package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

final class b extends BaseAdapter {
    private Context context;
    private c lyr;
    private List<z> yGD;
    boolean yGE = false;

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(30377);
        z Oc = Oc(i);
        AppMethodBeat.o(30377);
        return Oc;
    }

    public b(Context context) {
        AppMethodBeat.i(30370);
        this.context = context;
        this.yGD = new ArrayList();
        a aVar = new a();
        aVar.ePT = R.drawable.ajl;
        this.lyr = aVar.ahG();
        bw(null);
        AppMethodBeat.o(30370);
    }

    public final void bw(List<z> list) {
        AppMethodBeat.i(30371);
        this.yGD.clear();
        if (!(list == null || list.size() == 0)) {
            this.yGD.addAll(list);
        }
        if (this.yGE) {
            this.yGD.add(dBv());
        }
        this.yGD.add(dBu());
        ab.d("MicroMsg.AppInfoListAdapter", "updateData mDeviceInfoList.size() = %d.", Integer.valueOf(this.yGD.size()));
        AppMethodBeat.o(30371);
    }

    private z dBu() {
        AppMethodBeat.i(30372);
        z zVar = new z();
        zVar.resId = R.drawable.bgy;
        zVar.eoz = this.context.getString(R.string.ebr);
        AppMethodBeat.o(30372);
        return zVar;
    }

    private z dBv() {
        AppMethodBeat.i(30373);
        z zVar = new z();
        zVar.resId = R.drawable.bgz;
        zVar.eoz = this.context.getString(R.string.aok);
        AppMethodBeat.o(30373);
        return zVar;
    }

    public final int getCount() {
        AppMethodBeat.i(30374);
        int size = this.yGD.size();
        AppMethodBeat.o(30374);
        return size;
    }

    private z Oc(int i) {
        AppMethodBeat.i(30375);
        z zVar = (z) this.yGD.get(i);
        AppMethodBeat.o(30375);
        return zVar;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        aq aqVar;
        AppMethodBeat.i(30376);
        z Oc = Oc(i);
        if (view == null) {
            aq aqVar2 = new aq();
            view = View.inflate(viewGroup.getContext(), R.layout.ar9, null);
            aqVar2.lBq = view.findViewById(R.id.nc);
            aqVar2.gxi = (TextView) view.findViewById(R.id.bi_);
            aqVar2.iqT = (ImageView) view.findViewById(R.id.bi9);
            aqVar2.yKX = (TextView) view.findViewById(R.id.e8v);
            aqVar2.yMM = (SendDataToDeviceProgressBar) view.findViewById(R.id.e8u);
            aqVar2.yMM.setVisibility(4);
            view.setTag(aqVar2);
            aqVar = aqVar2;
        } else {
            aqVar = (aq) view.getTag();
        }
        aqVar.gxi.setText(Oc.eoz);
        ab.v("MicroMsg.AppInfoListAdapter", "position(%s), name(%s).", Integer.valueOf(i), Oc.eoz);
        if (Oc.resId != 0) {
            aqVar.iqT.setImageResource(Oc.resId);
        } else {
            Bitmap b = g.b(Oc.appId, 1, com.tencent.mm.bz.a.getDensity(this.context));
            if (b == null || b.isRecycled()) {
                o.ahp().a(Oc.iconUrl, aqVar.iqT, this.lyr);
            } else {
                aqVar.iqT.setImageBitmap(b);
            }
        }
        aqVar.lBq.setTag(Integer.valueOf(i));
        AppMethodBeat.o(30376);
        return view;
    }
}
