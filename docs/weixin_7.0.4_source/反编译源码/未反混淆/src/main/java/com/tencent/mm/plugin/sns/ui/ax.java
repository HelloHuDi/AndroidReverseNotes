package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.util.HashMap;

public final class ax implements OnItemClickListener {
    private Context mContext;
    private LayoutInflater mInflater;
    k rBk;
    c rBl;
    d rBm;
    private l rBn;
    private a rBo;
    private HashMap<Integer, CharSequence> rBp = new HashMap();
    private HashMap<Integer, Integer> rBq = new HashMap();

    class a extends BaseAdapter {

        class a {
            TextView gsf;
            TextView rBs;

            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }
        }

        private a() {
        }

        /* synthetic */ a(ax axVar, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(39615);
            int size = ax.this.rBn.size();
            AppMethodBeat.o(39615);
            return size;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(39616);
            if (view == null) {
                view = ax.this.mInflater.inflate(R.layout.awv, viewGroup, false);
                aVar = new a(this, (byte) 0);
                aVar.gsf = (TextView) view.findViewById(R.id.cx);
                aVar.rBs = (TextView) view.findViewById(R.id.en9);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            MenuItem item = ax.this.rBn.getItem(i);
            aVar.gsf.setText(item.getTitle());
            if (ax.this.rBp.get(Integer.valueOf(item.getItemId())) != null) {
                aVar.rBs.setText((CharSequence) ax.this.rBp.get(Integer.valueOf(item.getItemId())));
                aVar.rBs.setVisibility(0);
            } else {
                aVar.rBs.setVisibility(4);
            }
            if (ax.this.rBq.get(Integer.valueOf(item.getItemId())) != null) {
                aVar.rBs.setTextColor(((Integer) ax.this.rBq.get(Integer.valueOf(item.getItemId()))).intValue());
            }
            AppMethodBeat.o(39616);
            return view;
        }
    }

    public ax(Context context) {
        AppMethodBeat.i(39617);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.rBk = new k(context);
        this.rBn = new l(context);
        AppMethodBeat.o(39617);
    }

    public final void c(int i, CharSequence charSequence) {
        AppMethodBeat.i(39618);
        this.rBp.put(Integer.valueOf(i), charSequence);
        AppMethodBeat.o(39618);
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(39619);
        m mVar = (m) this.rBn.yvT.get(i);
        if (mVar.performClick()) {
            ab.i("MicroMsg.SnsTimelineListMenu", "onItemClick menu item has listener");
            dismiss();
            AppMethodBeat.o(39619);
            return;
        }
        if (this.rBm != null) {
            this.rBm.onMMMenuItemSelected(mVar, i);
        }
        dismiss();
        AppMethodBeat.o(39619);
    }

    private void dismiss() {
        AppMethodBeat.i(39620);
        if (this.rBk.isShowing()) {
            this.rBk.dismiss();
        }
        AppMethodBeat.o(39620);
    }

    public final Dialog cuu() {
        AppMethodBeat.i(39621);
        if (this.rBl != null) {
            this.rBn.clear();
            this.rBn = new l(this.mContext);
            this.rBl.a(this.rBn);
        }
        if (this.rBn.dzR()) {
            ab.w("MicroMsg.SnsTimelineListMenu", "show, menu empty");
            AppMethodBeat.o(39621);
            return null;
        }
        if (this.rBo == null) {
            this.rBo = new a(this, (byte) 0);
        }
        this.rBk.khG = this.rBo;
        this.rBk.vtI = this;
        this.rBk.setTitle(this.rBn.abz);
        this.rBk.show();
        Dialog dialog = this.rBk;
        AppMethodBeat.o(39621);
        return dialog;
    }
}
