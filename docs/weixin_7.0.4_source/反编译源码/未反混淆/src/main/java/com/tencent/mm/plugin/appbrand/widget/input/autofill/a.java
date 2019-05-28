package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.b;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

final class a extends ArrayAdapter<b> implements g {
    private b jht;
    h jhu;
    private boolean jhv = false;
    private final LayoutInflater mInflater;

    final class a implements OnClickListener {
        View apJ;
        View goc;
        b jhA;
        TextView jhx;
        TextView jhy;
        View jhz;

        a(View view) {
            AppMethodBeat.i(123873);
            this.apJ = view;
            this.jhx = (TextView) view.findViewById(R.id.cx);
            this.jhy = (TextView) view.findViewById(R.id.m5);
            this.jhz = view.findViewById(R.id.rh);
            this.goc = view.findViewById(R.id.p3);
            view.setBackgroundResource(R.drawable.x0);
            view.setOnClickListener(this);
            this.jhz.setOnClickListener(this);
            AppMethodBeat.o(123873);
        }

        public final void onClick(View view) {
            AppMethodBeat.i(123874);
            if (this.jhA != null) {
                if (view.getId() == R.id.rh) {
                    a.this.remove(this.jhA);
                    if (a.this.jhu != null) {
                        a.this.jhu.a(this.jhA.id, com.tencent.mm.plugin.appbrand.widget.input.autofill.h.a.DELETE);
                        AppMethodBeat.o(123874);
                        return;
                    }
                } else if (view == this.apJ && a.this.jhu != null) {
                    if (this.jhA != null) {
                        a.this.jhu.a(this.jhA.id, com.tencent.mm.plugin.appbrand.widget.input.autofill.h.a.SELECT);
                    }
                    a.this.jhv = true;
                    if (a.this.jht != null) {
                        a.this.jht.jhB.getView().clearFocus();
                    }
                }
            }
            AppMethodBeat.o(123874);
        }
    }

    a(Context context, List<b> list) {
        super(context, R.layout.cc, list);
        AppMethodBeat.i(123875);
        this.mInflater = LayoutInflater.from(context);
        AppMethodBeat.o(123875);
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(123876);
        super.notifyDataSetChanged();
        AppMethodBeat.o(123876);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(123877);
        this.jht = bVar;
        this.jht.setOnDismissListener(new OnDismissListener() {
            public final void onDismiss() {
                AppMethodBeat.i(123872);
                if (!(a.this.jhu == null || a.this.jhv)) {
                    a.this.jhu.a("", com.tencent.mm.plugin.appbrand.widget.input.autofill.h.a.CANCEL);
                }
                AppMethodBeat.o(123872);
            }
        });
        AppMethodBeat.o(123877);
    }

    public final void aRu() {
        AppMethodBeat.i(123878);
        this.jht.setOnDismissListener(null);
        this.jht = null;
        AppMethodBeat.o(123878);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int i2;
        int i3 = 8;
        AppMethodBeat.i(123879);
        if (view == null) {
            view = this.mInflater.inflate(R.layout.cc, viewGroup, false);
        }
        a aVar2 = (a) view.getTag();
        if (aVar2 == null) {
            aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = aVar2;
        }
        b bVar = (b) getItem(i);
        aVar.jhA = bVar;
        aVar.jhx.setText(bVar.title);
        aVar.jhy.setText(bVar.content);
        TextView textView = aVar.jhy;
        if (bo.isNullOrNil(bVar.content)) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        textView.setVisibility(i2);
        View view2 = aVar.goc;
        if (i != getCount() - 1) {
            i3 = 0;
        }
        view2.setVisibility(i3);
        AppMethodBeat.o(123879);
        return view;
    }

    public final Filter getFilter() {
        AppMethodBeat.i(123880);
        Filter filter = super.getFilter();
        AppMethodBeat.o(123880);
        return filter;
    }
}
