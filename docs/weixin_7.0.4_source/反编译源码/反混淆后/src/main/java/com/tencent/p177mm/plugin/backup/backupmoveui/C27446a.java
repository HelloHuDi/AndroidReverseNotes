package com.tencent.p177mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.plugin.backup.p342b.C45733f.C27443b;
import com.tencent.p177mm.plugin.backup.p345d.C41258b;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import java.util.HashSet;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.backup.backupmoveui.a */
public final class C27446a extends BaseAdapter {
    BackupMoveChooseUI juq;
    HashSet<Integer> jur;
    boolean jus = false;

    /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.a$a */
    class C27447a {
        ImageView ejo;
        TextView gnB;
        CheckBox gnD;
        RelativeLayout juu;

        C27447a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(17323);
        C27443b rp = C27446a.m43550rp(i);
        AppMethodBeat.m2505o(17323);
        return rp;
    }

    public C27446a(BackupMoveChooseUI backupMoveChooseUI) {
        AppMethodBeat.m2504i(17319);
        this.juq = backupMoveChooseUI;
        this.jur = new HashSet();
        this.jus = false;
        AppMethodBeat.m2505o(17319);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(17320);
        LinkedList aSV = C41258b.aSZ().aTd().aSV();
        if (aSV != null) {
            int size = aSV.size();
            AppMethodBeat.m2505o(17320);
            return size;
        }
        AppMethodBeat.m2505o(17320);
        return 0;
    }

    /* renamed from: rp */
    private static C27443b m43550rp(int i) {
        AppMethodBeat.m2504i(17321);
        C27443b c27443b = (C27443b) C41258b.aSZ().aTd().aSV().get(i);
        AppMethodBeat.m2505o(17321);
        return c27443b;
    }

    public final long getItemId(int i) {
        return -1;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        C27447a c27447a;
        AppMethodBeat.m2504i(17322);
        if (view == null) {
            view = this.juq.getLayoutInflater().inflate(2130968803, viewGroup, false);
            C27447a c27447a2 = new C27447a();
            c27447a2.ejo = (ImageView) view.findViewById(2131821183);
            c27447a2.gnB = (TextView) view.findViewById(2131821185);
            c27447a2.gnD = (CheckBox) view.findViewById(2131821593);
            c27447a2.juu = (RelativeLayout) view.findViewById(2131821592);
            view.setTag(c27447a2);
            c27447a = c27447a2;
        } else {
            c27447a = (C27447a) view.getTag();
        }
        c27447a.juu.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(17318);
                if (C27446a.this.jur.contains(Integer.valueOf(i))) {
                    C27446a.this.jur.remove(Integer.valueOf(i));
                } else {
                    C27446a.this.jur.add(Integer.valueOf(i));
                }
                C27446a.this.notifyDataSetChanged();
                C27446a.this.juq.mo6652a(C27446a.this.jur);
                AppMethodBeat.m2505o(17318);
            }
        });
        C27443b rp = C27446a.m43550rp(i);
        C40460b.m69434b(c27447a.ejo, rp.jrf);
        if (C1855t.m3896kH(rp.jrf)) {
            c27447a.gnB.setText(C44089j.m79293b(this.juq, C1854s.getDisplayName(rp.jrf, rp.jrf), c27447a.gnB.getTextSize()));
        } else {
            c27447a.gnB.setText(C44089j.m79293b(this.juq, C1854s.m3866mJ(rp.jrf), c27447a.gnB.getTextSize()));
        }
        if (this.jur.contains(Integer.valueOf(i))) {
            c27447a.gnD.setChecked(true);
        } else {
            c27447a.gnD.setChecked(false);
        }
        AppMethodBeat.m2505o(17322);
        return view;
    }
}
