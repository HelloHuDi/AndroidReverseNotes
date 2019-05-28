package com.tencent.mm.plugin.backup.backuppcui;

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
import com.tencent.mm.plugin.backup.b.f;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.pluginsdk.ui.e.j;
import java.util.HashSet;
import java.util.LinkedList;

public final class a extends BaseAdapter {
    static boolean jwF = false;
    HashSet<Integer> jur = new HashSet();
    BackupPcChooseUI jwE;

    class a {
        ImageView ejo;
        TextView gnB;
        CheckBox gnD;
        RelativeLayout juu;

        a() {
        }
    }

    public a(BackupPcChooseUI backupPcChooseUI) {
        AppMethodBeat.i(17568);
        this.jwE = backupPcChooseUI;
        jwF = false;
        AppMethodBeat.o(17568);
    }

    public final int getCount() {
        AppMethodBeat.i(17569);
        LinkedList aSV = b.aTD().aTH().aSV();
        if (aSV != null) {
            int size = aSV.size();
            AppMethodBeat.o(17569);
            return size;
        }
        AppMethodBeat.o(17569);
        return 0;
    }

    private static String getItem(int i) {
        AppMethodBeat.i(17570);
        LinkedList aSV = b.aTD().aTH().aSV();
        if (aSV.get(i) == null) {
            AppMethodBeat.o(17570);
            return null;
        }
        String str = ((f.b) aSV.get(i)).jrf;
        AppMethodBeat.o(17570);
        return str;
    }

    public final long getItemId(int i) {
        return -1;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(17571);
        if (view == null) {
            view = this.jwE.getLayoutInflater().inflate(R.layout.fa, viewGroup, false);
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
                AppMethodBeat.i(17567);
                if (a.this.jur.contains(Integer.valueOf(i))) {
                    a.this.jur.remove(Integer.valueOf(i));
                } else {
                    a.this.jur.add(Integer.valueOf(i));
                }
                a.this.notifyDataSetChanged();
                a.this.jwE.a(a.this.jur);
                AppMethodBeat.o(17567);
            }
        });
        String item = getItem(i);
        com.tencent.mm.pluginsdk.ui.a.b.b(aVar.ejo, item);
        if (t.kH(item)) {
            aVar.gnB.setText(j.b(this.jwE, s.getDisplayName(item, item), aVar.gnB.getTextSize()));
        } else {
            aVar.gnB.setText(j.b(this.jwE, s.mJ(item), aVar.gnB.getTextSize()));
        }
        if (this.jur.contains(Integer.valueOf(i))) {
            aVar.gnD.setChecked(true);
        } else {
            aVar.gnD.setChecked(false);
        }
        AppMethodBeat.o(17571);
        return view;
    }
}
