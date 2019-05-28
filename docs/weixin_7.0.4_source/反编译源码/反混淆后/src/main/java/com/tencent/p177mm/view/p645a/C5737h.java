package com.tencent.p177mm.view.p645a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.emoji.p227a.C1511f;
import com.tencent.p177mm.ipcinvoker.p855h.C26340b;
import com.tencent.p177mm.p211cb.C26003e;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.C15438t;
import com.tencent.p177mm.view.p1097f.C16067a;
import java.util.List;

/* renamed from: com.tencent.mm.view.a.h */
public final class C5737h extends C16041a {
    private List<C15438t> Abu;

    /* renamed from: com.tencent.mm.view.a.h$a */
    class C5738a {
        ImageView iqT;

        public C5738a(View view) {
            AppMethodBeat.m2504i(62990);
            this.iqT = (ImageView) view.findViewById(2131821503);
            AppMethodBeat.m2505o(62990);
        }
    }

    public C5737h(Context context, C16067a c16067a) {
        super(context, c16067a);
    }

    public final void update() {
        AppMethodBeat.m2504i(62991);
        this.Abu = this.Aal.AeG;
        notifyDataSetChanged();
        AppMethodBeat.m2505o(62991);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(62992);
        if (this.Abu == null) {
            AppMethodBeat.m2505o(62992);
            return 0;
        }
        int i = this.Abg * this.njC;
        if (i > this.Abu.size()) {
            i = this.Abu.size();
            AppMethodBeat.m2505o(62992);
            return i;
        }
        AppMethodBeat.m2505o(62992);
        return i;
    }

    public final Object getItem(int i) {
        AppMethodBeat.m2504i(62993);
        C1511f c1511f = new C1511f();
        c1511f.position = m8650QC(i);
        AppMethodBeat.m2505o(62993);
        return c1511f;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    /* renamed from: QC */
    private int m8650QC(int i) {
        AppMethodBeat.m2504i(62994);
        if (this.Abu == null || i < 0 || i >= this.Abu.size()) {
            AppMethodBeat.m2505o(62994);
            return i;
        }
        i = ((C15438t) this.Abu.get(i)).position;
        AppMethodBeat.m2505o(62994);
        return i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C5738a c5738a;
        AppMethodBeat.m2504i(62995);
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(2130970702, null);
            view.setLayoutParams(new LayoutParams(-1, -1));
            c5738a = new C5738a(view);
            view.setTag(c5738a);
        } else {
            c5738a = (C5738a) view.getTag();
        }
        int QC = m8650QC(i);
        Drawable qJ = C26003e.dqK().mo43876qJ(QC);
        c5738a.iqT.setImageDrawable(qJ);
        CharSequence text = C26003e.dqK().getText(QC);
        if (C5046bo.isNullOrNil(text)) {
            text = view.getResources().getString(C25738R.string.bc5);
        }
        c5738a.iqT.setContentDescription(text);
        if (qJ == null) {
            C26340b.m41917i("RecentSmileyAdapter", "drawable is null. realPosition:%d description:%s", Integer.valueOf(QC), text);
        }
        AppMethodBeat.m2505o(62995);
        return view;
    }
}
