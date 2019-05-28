package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.os.Looper;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class e extends BaseAdapter {
    byte[] buffer = null;
    private Context context = null;
    boolean eTf = false;
    boolean gxV = false;
    String kPJ = "";
    String key = "";
    int llU = 0;
    boolean nPV = false;
    List<f> nQk = new ArrayList();

    static class a {
        TextView iKA;
        TextView nQl;
        ImageView nQm;
        View nQn;
        View nQo;
        TextView titleView;
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(113666);
        f xG = xG(i);
        AppMethodBeat.o(113666);
        return xG;
    }

    public e(Context context) {
        AppMethodBeat.i(113656);
        this.context = context;
        AppMethodBeat.o(113656);
    }

    public final void clean() {
        AppMethodBeat.i(113657);
        this.buffer = null;
        this.eTf = false;
        this.key = "";
        this.nQk.clear();
        AppMethodBeat.o(113657);
    }

    public final void bKy() {
        this.buffer = null;
        this.eTf = false;
        this.key = "";
    }

    public final void Qb(String str) {
        AppMethodBeat.i(113658);
        this.key = str;
        ab.i("MicroMsg.PoiAdapter", "initdata key %s", str);
        AppMethodBeat.o(113658);
    }

    public final void b(f fVar) {
        AppMethodBeat.i(113659);
        if (this.nQk.size() >= 0) {
            this.nQk.add(0, fVar);
            notifyDataSetChanged();
        }
        AppMethodBeat.o(113659);
    }

    public final void a(List<f> list, byte[] bArr, boolean z, String str) {
        AppMethodBeat.i(113660);
        if (this.key == null || !this.key.equals(str)) {
            ab.i("MicroMsg.PoiAdapter", "old key come pass it %s %s", this.key, str);
            AppMethodBeat.o(113660);
            return;
        }
        int size = this.nQk.size();
        int i = size;
        for (f fVar : list) {
            fVar.nQC = i;
            i++;
            this.nQk.add(fVar);
        }
        this.buffer = bArr;
        this.eTf = z;
        notifyDataSetChanged();
        AppMethodBeat.o(113660);
    }

    public final int getCount() {
        AppMethodBeat.i(113661);
        int size = this.nQk.size();
        AppMethodBeat.o(113661);
        return size;
    }

    public final f xG(int i) {
        AppMethodBeat.i(113662);
        f fVar = (f) this.nQk.get(i);
        AppMethodBeat.o(113662);
        return fVar;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(113663);
        if (view == null) {
            view = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.akl, null);
            aVar = new a();
            aVar.titleView = (TextView) view.findViewById(R.id.cx);
            aVar.nQl = (TextView) view.findViewById(R.id.a_6);
            aVar.nQm = (ImageView) view.findViewById(R.id.dnj);
            aVar.nQo = view.findViewById(R.id.dnl);
            aVar.nQn = view.findViewById(R.id.dnk);
            aVar.iKA = (TextView) view.findViewById(R.id.dnm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (((f) this.nQk.get(i)).type == 1 || ((f) this.nQk.get(i)).type == 2) {
            aVar.nQo.setVisibility(0);
            aVar.nQn.setVisibility(8);
            aVar.iKA.setText(bo.bc(((f) this.nQk.get(i)).nQp, ""));
        } else {
            aVar.nQo.setVisibility(8);
            aVar.nQn.setVisibility(0);
        }
        if (i != 0 || this.gxV) {
            CharSequence Qc;
            f fVar = (f) this.nQk.get(i);
            String bc = bo.bc(fVar.mName, "");
            CharSequence bc2 = bo.bc(fVar.nQp, "");
            if (!this.gxV || bo.isNullOrNil(this.kPJ)) {
                Object Qc2 = bc;
            } else {
                Qc2 = Qc(bc);
                bc2 = Qc(bc2);
            }
            aVar.titleView.setText(Qc2);
            aVar.nQl.setText(bc2);
            aVar.nQl.setVisibility(0);
        } else if (this.nPV) {
            aVar.titleView.setText(bo.bc(((f) this.nQk.get(0)).mName, ""));
            aVar.nQl.setVisibility(0);
            aVar.nQl.setText(bo.bc(((f) this.nQk.get(0)).nQp, ""));
        } else {
            aVar.nQl.setVisibility(8);
            if (!bo.isNullOrNil(((f) this.nQk.get(0)).nQp)) {
                aVar.titleView.setText(bo.bc(((f) this.nQk.get(i)).nQp, ""));
            } else if (bo.isNullOrNil(((f) this.nQk.get(0)).nQy)) {
                aVar.titleView.setText(bo.bc(((f) this.nQk.get(i)).mName, ""));
            } else {
                aVar.titleView.setText(bo.bc(((f) this.nQk.get(i)).nQy, ""));
            }
        }
        if (i == this.llU) {
            aVar.nQm.setVisibility(0);
        } else {
            aVar.nQm.setVisibility(4);
        }
        AppMethodBeat.o(113663);
        return view;
    }

    private Spannable Qc(String str) {
        AppMethodBeat.i(113664);
        Spannable a = f.a((CharSequence) str, this.kPJ);
        AppMethodBeat.o(113664);
        return a;
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(113665);
        super.notifyDataSetChanged();
        Thread.currentThread().getId();
        Looper.getMainLooper().getThread().getId();
        ab.i("MicroMsg.PoiAdapter", "map notifyDataChange " + bo.dpG().toString() + " threadId : " + Thread.currentThread().getId());
        AppMethodBeat.o(113665);
    }
}
