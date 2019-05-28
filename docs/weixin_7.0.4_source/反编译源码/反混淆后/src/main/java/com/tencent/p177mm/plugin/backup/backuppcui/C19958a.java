package com.tencent.p177mm.plugin.backup.backuppcui;

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
import com.tencent.p177mm.plugin.backup.backuppcmodel.C42759b;
import com.tencent.p177mm.plugin.backup.p342b.C45733f.C27443b;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import java.util.HashSet;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.backup.backuppcui.a */
public final class C19958a extends BaseAdapter {
    static boolean jwF = false;
    HashSet<Integer> jur = new HashSet();
    BackupPcChooseUI jwE;

    /* renamed from: com.tencent.mm.plugin.backup.backuppcui.a$a */
    class C19959a {
        ImageView ejo;
        TextView gnB;
        CheckBox gnD;
        RelativeLayout juu;

        C19959a() {
        }
    }

    public C19958a(BackupPcChooseUI backupPcChooseUI) {
        AppMethodBeat.m2504i(17568);
        this.jwE = backupPcChooseUI;
        jwF = false;
        AppMethodBeat.m2505o(17568);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(17569);
        LinkedList aSV = C42759b.aTD().aTH().aSV();
        if (aSV != null) {
            int size = aSV.size();
            AppMethodBeat.m2505o(17569);
            return size;
        }
        AppMethodBeat.m2505o(17569);
        return 0;
    }

    private static String getItem(int i) {
        AppMethodBeat.m2504i(17570);
        LinkedList aSV = C42759b.aTD().aTH().aSV();
        if (aSV.get(i) == null) {
            AppMethodBeat.m2505o(17570);
            return null;
        }
        String str = ((C27443b) aSV.get(i)).jrf;
        AppMethodBeat.m2505o(17570);
        return str;
    }

    public final long getItemId(int i) {
        return -1;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        C19959a c19959a;
        AppMethodBeat.m2504i(17571);
        if (view == null) {
            view = this.jwE.getLayoutInflater().inflate(2130968798, viewGroup, false);
            C19959a c19959a2 = new C19959a();
            c19959a2.ejo = (ImageView) view.findViewById(2131821183);
            c19959a2.gnB = (TextView) view.findViewById(2131821185);
            c19959a2.gnD = (CheckBox) view.findViewById(2131821593);
            c19959a2.juu = (RelativeLayout) view.findViewById(2131821592);
            view.setTag(c19959a2);
            c19959a = c19959a2;
        } else {
            c19959a = (C19959a) view.getTag();
        }
        c19959a.juu.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(17567);
                if (C19958a.this.jur.contains(Integer.valueOf(i))) {
                    C19958a.this.jur.remove(Integer.valueOf(i));
                } else {
                    C19958a.this.jur.add(Integer.valueOf(i));
                }
                C19958a.this.notifyDataSetChanged();
                C19958a.this.jwE.mo68237a(C19958a.this.jur);
                AppMethodBeat.m2505o(17567);
            }
        });
        String item = C19958a.getItem(i);
        C40460b.m69434b(c19959a.ejo, item);
        if (C1855t.m3896kH(item)) {
            c19959a.gnB.setText(C44089j.m79293b(this.jwE, C1854s.getDisplayName(item, item), c19959a.gnB.getTextSize()));
        } else {
            c19959a.gnB.setText(C44089j.m79293b(this.jwE, C1854s.m3866mJ(item), c19959a.gnB.getTextSize()));
        }
        if (this.jur.contains(Integer.valueOf(i))) {
            c19959a.gnD.setChecked(true);
        } else {
            c19959a.gnD.setChecked(false);
        }
        AppMethodBeat.m2505o(17571);
        return view;
    }
}
