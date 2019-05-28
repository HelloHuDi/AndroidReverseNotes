package com.tencent.p177mm.plugin.appbrand.widget.input.autofill;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.appbrand.widget.input.autofill.C33622h.C27406a;
import com.tencent.p177mm.plugin.appbrand.widget.input.p341d.C33623a.C11016b;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.a */
final class C42732a extends ArrayAdapter<C11016b> implements C27405g {
    private C42736b jht;
    C33622h jhu;
    private boolean jhv = false;
    private final LayoutInflater mInflater;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.a$1 */
    class C198631 implements OnDismissListener {
        C198631() {
        }

        public final void onDismiss() {
            AppMethodBeat.m2504i(123872);
            if (!(C42732a.this.jhu == null || C42732a.this.jhv)) {
                C42732a.this.jhu.mo35093a("", C27406a.CANCEL);
            }
            AppMethodBeat.m2505o(123872);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.a$a */
    final class C42733a implements OnClickListener {
        View apJ;
        View goc;
        C11016b jhA;
        TextView jhx;
        TextView jhy;
        View jhz;

        C42733a(View view) {
            AppMethodBeat.m2504i(123873);
            this.apJ = view;
            this.jhx = (TextView) view.findViewById(2131820678);
            this.jhy = (TextView) view.findViewById(2131821019);
            this.jhz = view.findViewById(2131821217);
            this.goc = view.findViewById(2131821128);
            view.setBackgroundResource(C25738R.drawable.f6964x0);
            view.setOnClickListener(this);
            this.jhz.setOnClickListener(this);
            AppMethodBeat.m2505o(123873);
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(123874);
            if (this.jhA != null) {
                if (view.getId() == 2131821217) {
                    C42732a.this.remove(this.jhA);
                    if (C42732a.this.jhu != null) {
                        C42732a.this.jhu.mo35093a(this.jhA.f2885id, C27406a.DELETE);
                        AppMethodBeat.m2505o(123874);
                        return;
                    }
                } else if (view == this.apJ && C42732a.this.jhu != null) {
                    if (this.jhA != null) {
                        C42732a.this.jhu.mo35093a(this.jhA.f2885id, C27406a.SELECT);
                    }
                    C42732a.this.jhv = true;
                    if (C42732a.this.jht != null) {
                        C42732a.this.jht.jhB.getView().clearFocus();
                    }
                }
            }
            AppMethodBeat.m2505o(123874);
        }
    }

    C42732a(Context context, List<C11016b> list) {
        super(context, 2130968689, list);
        AppMethodBeat.m2504i(123875);
        this.mInflater = LayoutInflater.from(context);
        AppMethodBeat.m2505o(123875);
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.m2504i(123876);
        super.notifyDataSetChanged();
        AppMethodBeat.m2505o(123876);
    }

    /* renamed from: a */
    public final void mo45140a(C42736b c42736b) {
        AppMethodBeat.m2504i(123877);
        this.jht = c42736b;
        this.jht.setOnDismissListener(new C198631());
        AppMethodBeat.m2505o(123877);
    }

    public final void aRu() {
        AppMethodBeat.m2504i(123878);
        this.jht.setOnDismissListener(null);
        this.jht = null;
        AppMethodBeat.m2505o(123878);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C42733a c42733a;
        int i2;
        int i3 = 8;
        AppMethodBeat.m2504i(123879);
        if (view == null) {
            view = this.mInflater.inflate(2130968689, viewGroup, false);
        }
        C42733a c42733a2 = (C42733a) view.getTag();
        if (c42733a2 == null) {
            c42733a2 = new C42733a(view);
            view.setTag(c42733a2);
            c42733a = c42733a2;
        } else {
            c42733a = c42733a2;
        }
        C11016b c11016b = (C11016b) getItem(i);
        c42733a.jhA = c11016b;
        c42733a.jhx.setText(c11016b.title);
        c42733a.jhy.setText(c11016b.content);
        TextView textView = c42733a.jhy;
        if (C5046bo.isNullOrNil(c11016b.content)) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        textView.setVisibility(i2);
        View view2 = c42733a.goc;
        if (i != getCount() - 1) {
            i3 = 0;
        }
        view2.setVisibility(i3);
        AppMethodBeat.m2505o(123879);
        return view;
    }

    public final Filter getFilter() {
        AppMethodBeat.m2504i(123880);
        Filter filter = super.getFilter();
        AppMethodBeat.m2505o(123880);
        return filter;
    }
}
