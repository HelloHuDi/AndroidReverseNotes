package com.tencent.mm.plugin.backup.backupmoveui;

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
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.pluginsdk.ui.e.j;
import java.util.HashSet;
import java.util.LinkedList;

public final class a extends BaseAdapter {
    BackupMoveChooseUI juq;
    HashSet<Integer> jur;
    boolean jus = false;

    class a {
        ImageView ejo;
        TextView gnB;
        CheckBox gnD;
        RelativeLayout juu;

        a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(17323);
        b rp = rp(i);
        AppMethodBeat.o(17323);
        return rp;
    }

    public a(BackupMoveChooseUI backupMoveChooseUI) {
        AppMethodBeat.i(17319);
        this.juq = backupMoveChooseUI;
        this.jur = new HashSet();
        this.jus = false;
        AppMethodBeat.o(17319);
    }

    public final int getCount() {
        AppMethodBeat.i(17320);
        LinkedList aSV = com.tencent.mm.plugin.backup.d.b.aSZ().aTd().aSV();
        if (aSV != null) {
            int size = aSV.size();
            AppMethodBeat.o(17320);
            return size;
        }
        AppMethodBeat.o(17320);
        return 0;
    }

    private static b rp(int i) {
        AppMethodBeat.i(17321);
        b bVar = (b) com.tencent.mm.plugin.backup.d.b.aSZ().aTd().aSV().get(i);
        AppMethodBeat.o(17321);
        return bVar;
    }

    public final long getItemId(int i) {
        return -1;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(17322);
        if (view == null) {
            view = this.juq.getLayoutInflater().inflate(R.layout.ff, viewGroup, false);
            a aVar2 = new a();
            aVar2.ejo = (ImageView) view.findViewById(R.id.qk);
            aVar2.gnB = (TextView) view.findViewById(R.id.qm);
            aVar2.gnD = (CheckBox) view.findViewById(R.id.a1b);
            aVar2.juu = (RelativeLayout) view.findViewById(R.id.a1a);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.juu.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(17318);
                if (a.this.jur.contains(Integer.valueOf(i))) {
                    a.this.jur.remove(Integer.valueOf(i));
                } else {
                    a.this.jur.add(Integer.valueOf(i));
                }
                a.this.notifyDataSetChanged();
                a.this.juq.a(a.this.jur);
                AppMethodBeat.o(17318);
            }
        });
        b rp = rp(i);
        com.tencent.mm.pluginsdk.ui.a.b.b(aVar.ejo, rp.jrf);
        if (t.kH(rp.jrf)) {
            aVar.gnB.setText(j.b(this.juq, s.getDisplayName(rp.jrf, rp.jrf), aVar.gnB.getTextSize()));
        } else {
            aVar.gnB.setText(j.b(this.juq, s.mJ(rp.jrf), aVar.gnB.getTextSize()));
        }
        if (this.jur.contains(Integer.valueOf(i))) {
            aVar.gnD.setChecked(true);
        } else {
            aVar.gnD.setChecked(false);
        }
        AppMethodBeat.o(17322);
        return view;
    }
}
