package com.tencent.mm.plugin.clean.ui.newui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.clean.c.b;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashSet;

public final class a extends BaseAdapter {
    HashSet<Integer> jur = new HashSet();
    CleanChattingUI kyF;

    class a {
        ImageView ejo;
        TextView gnB;
        TextView gnC;
        CheckBox gnD;
        RelativeLayout juu;

        a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(18846);
        b ty = ty(i);
        AppMethodBeat.o(18846);
        return ty;
    }

    public a(CleanChattingUI cleanChattingUI) {
        AppMethodBeat.i(18841);
        this.kyF = cleanChattingUI;
        AppMethodBeat.o(18841);
    }

    public final int getCount() {
        AppMethodBeat.i(18842);
        ArrayList bfS = d.bfS();
        if (bfS != null) {
            int size = bfS.size();
            AppMethodBeat.o(18842);
            return size;
        }
        AppMethodBeat.o(18842);
        return 0;
    }

    private static b ty(int i) {
        AppMethodBeat.i(18843);
        b bVar = (b) d.bfS().get(i);
        AppMethodBeat.o(18843);
        return bVar;
    }

    public final long getItemId(int i) {
        return -1;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(18844);
        if (view == null) {
            view = this.kyF.getLayoutInflater().inflate(R.layout.ok, viewGroup, false);
            a aVar2 = new a();
            aVar2.ejo = (ImageView) view.findViewById(R.id.qk);
            aVar2.gnB = (TextView) view.findViewById(R.id.qm);
            aVar2.gnC = (TextView) view.findViewById(R.id.ld);
            aVar2.gnD = (CheckBox) view.findViewById(R.id.a1b);
            aVar2.juu = (RelativeLayout) view.findViewById(R.id.a1a);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.juu.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(18840);
                if (a.this.jur.contains(Integer.valueOf(i))) {
                    a.this.jur.remove(Integer.valueOf(i));
                } else {
                    a.this.jur.add(Integer.valueOf(i));
                }
                a.this.notifyDataSetChanged();
                a.this.kyF.a(a.this.jur);
                AppMethodBeat.o(18840);
            }
        });
        b ty = ty(i);
        com.tencent.mm.pluginsdk.ui.a.b.b(aVar.ejo, ty.username);
        aVar.gnB.setText(bo.ga(ty.jrb));
        if (t.kH(ty.username)) {
            aVar.gnC.setText(j.b(this.kyF, s.getDisplayName(ty.username, ty.username), aVar.gnC.getTextSize()));
        } else {
            aVar.gnC.setText(j.b(this.kyF, s.mJ(ty.username), aVar.gnC.getTextSize()));
        }
        if (this.jur.contains(Integer.valueOf(i))) {
            aVar.gnD.setChecked(true);
        } else {
            aVar.gnD.setChecked(false);
        }
        AppMethodBeat.o(18844);
        return view;
    }

    public final void bgh() {
        AppMethodBeat.i(18845);
        this.jur.clear();
        this.kyF.a(this.jur);
        AppMethodBeat.o(18845);
    }
}
