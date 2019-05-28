package com.tencent.mm.view.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.e;
import com.tencent.mm.emoji.a.f;
import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.t;
import java.util.List;

public final class h extends a {
    private List<t> Abu;

    class a {
        ImageView iqT;

        public a(View view) {
            AppMethodBeat.i(62990);
            this.iqT = (ImageView) view.findViewById(R.id.yw);
            AppMethodBeat.o(62990);
        }
    }

    public h(Context context, com.tencent.mm.view.f.a aVar) {
        super(context, aVar);
    }

    public final void update() {
        AppMethodBeat.i(62991);
        this.Abu = this.Aal.AeG;
        notifyDataSetChanged();
        AppMethodBeat.o(62991);
    }

    public final int getCount() {
        AppMethodBeat.i(62992);
        if (this.Abu == null) {
            AppMethodBeat.o(62992);
            return 0;
        }
        int i = this.Abg * this.njC;
        if (i > this.Abu.size()) {
            i = this.Abu.size();
            AppMethodBeat.o(62992);
            return i;
        }
        AppMethodBeat.o(62992);
        return i;
    }

    public final Object getItem(int i) {
        AppMethodBeat.i(62993);
        f fVar = new f();
        fVar.position = QC(i);
        AppMethodBeat.o(62993);
        return fVar;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    private int QC(int i) {
        AppMethodBeat.i(62994);
        if (this.Abu == null || i < 0 || i >= this.Abu.size()) {
            AppMethodBeat.o(62994);
            return i;
        }
        i = ((t) this.Abu.get(i)).position;
        AppMethodBeat.o(62994);
        return i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(62995);
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.atm, null);
            view.setLayoutParams(new LayoutParams(-1, -1));
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        int QC = QC(i);
        Drawable qJ = e.dqK().qJ(QC);
        aVar.iqT.setImageDrawable(qJ);
        CharSequence text = e.dqK().getText(QC);
        if (bo.isNullOrNil(text)) {
            text = view.getResources().getString(R.string.bc5);
        }
        aVar.iqT.setContentDescription(text);
        if (qJ == null) {
            b.i("RecentSmileyAdapter", "drawable is null. realPosition:%d description:%s", Integer.valueOf(QC), text);
        }
        AppMethodBeat.o(62995);
        return view;
    }
}
