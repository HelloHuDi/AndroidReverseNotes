package com.tencent.p177mm.plugin.sns.p520ui;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.C30394k;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44274m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.sns.ui.ax */
public final class C29199ax implements OnItemClickListener {
    private Context mContext;
    private LayoutInflater mInflater;
    C30394k rBk;
    C36073c rBl;
    C5279d rBm;
    private C44273l rBn;
    private C29200a rBo;
    private HashMap<Integer, CharSequence> rBp = new HashMap();
    private HashMap<Integer, Integer> rBq = new HashMap();

    /* renamed from: com.tencent.mm.plugin.sns.ui.ax$a */
    class C29200a extends BaseAdapter {

        /* renamed from: com.tencent.mm.plugin.sns.ui.ax$a$a */
        class C13634a {
            TextView gsf;
            TextView rBs;

            private C13634a() {
            }

            /* synthetic */ C13634a(C29200a c29200a, byte b) {
                this();
            }
        }

        private C29200a() {
        }

        /* synthetic */ C29200a(C29199ax c29199ax, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.m2504i(39615);
            int size = C29199ax.this.rBn.size();
            AppMethodBeat.m2505o(39615);
            return size;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C13634a c13634a;
            AppMethodBeat.m2504i(39616);
            if (view == null) {
                view = C29199ax.this.mInflater.inflate(2130970821, viewGroup, false);
                c13634a = new C13634a(this, (byte) 0);
                c13634a.gsf = (TextView) view.findViewById(2131820678);
                c13634a.rBs = (TextView) view.findViewById(2131827915);
                view.setTag(c13634a);
            } else {
                c13634a = (C13634a) view.getTag();
            }
            MenuItem item = C29199ax.this.rBn.getItem(i);
            c13634a.gsf.setText(item.getTitle());
            if (C29199ax.this.rBp.get(Integer.valueOf(item.getItemId())) != null) {
                c13634a.rBs.setText((CharSequence) C29199ax.this.rBp.get(Integer.valueOf(item.getItemId())));
                c13634a.rBs.setVisibility(0);
            } else {
                c13634a.rBs.setVisibility(4);
            }
            if (C29199ax.this.rBq.get(Integer.valueOf(item.getItemId())) != null) {
                c13634a.rBs.setTextColor(((Integer) C29199ax.this.rBq.get(Integer.valueOf(item.getItemId()))).intValue());
            }
            AppMethodBeat.m2505o(39616);
            return view;
        }
    }

    public C29199ax(Context context) {
        AppMethodBeat.m2504i(39617);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.rBk = new C30394k(context);
        this.rBn = new C44273l(context);
        AppMethodBeat.m2505o(39617);
    }

    /* renamed from: c */
    public final void mo47368c(int i, CharSequence charSequence) {
        AppMethodBeat.m2504i(39618);
        this.rBp.put(Integer.valueOf(i), charSequence);
        AppMethodBeat.m2505o(39618);
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(39619);
        C44274m c44274m = (C44274m) this.rBn.yvT.get(i);
        if (c44274m.performClick()) {
            C4990ab.m7416i("MicroMsg.SnsTimelineListMenu", "onItemClick menu item has listener");
            dismiss();
            AppMethodBeat.m2505o(39619);
            return;
        }
        if (this.rBm != null) {
            this.rBm.onMMMenuItemSelected(c44274m, i);
        }
        dismiss();
        AppMethodBeat.m2505o(39619);
    }

    private void dismiss() {
        AppMethodBeat.m2504i(39620);
        if (this.rBk.isShowing()) {
            this.rBk.dismiss();
        }
        AppMethodBeat.m2505o(39620);
    }

    public final Dialog cuu() {
        AppMethodBeat.m2504i(39621);
        if (this.rBl != null) {
            this.rBn.clear();
            this.rBn = new C44273l(this.mContext);
            this.rBl.mo5746a(this.rBn);
        }
        if (this.rBn.dzR()) {
            C4990ab.m7420w("MicroMsg.SnsTimelineListMenu", "show, menu empty");
            AppMethodBeat.m2505o(39621);
            return null;
        }
        if (this.rBo == null) {
            this.rBo = new C29200a(this, (byte) 0);
        }
        this.rBk.khG = this.rBo;
        this.rBk.vtI = this;
        this.rBk.setTitle(this.rBn.abz);
        this.rBk.show();
        Dialog dialog = this.rBk;
        AppMethodBeat.m2505o(39621);
        return dialog;
    }
}
