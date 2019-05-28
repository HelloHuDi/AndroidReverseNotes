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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class d extends a {

    class a {
        ImageView iqT;

        public a(View view) {
            AppMethodBeat.i(62976);
            this.iqT = (ImageView) view.findViewById(R.id.yw);
            AppMethodBeat.o(62976);
        }
    }

    public d(Context context, com.tencent.mm.view.f.a aVar) {
        super(context, aVar);
    }

    public int getCount() {
        return this.Abd;
    }

    public Object getItem(int i) {
        AppMethodBeat.i(62977);
        f fVar = new f();
        if (i == getCount() - 1) {
            fVar.position = -1;
        } else {
            fVar.position = QC(i);
        }
        AppMethodBeat.o(62977);
        return fVar;
    }

    public boolean ui(int i) {
        AppMethodBeat.i(62978);
        if (i != getCount() - 1) {
            AppMethodBeat.o(62978);
            return true;
        }
        AppMethodBeat.o(62978);
        return false;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public final int QC(int i) {
        return ((this.Abd - 1) * this.Abe) + i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(62979);
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.atm, null);
            view.setLayoutParams(new LayoutParams(-1, -1));
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == getCount() - 1) {
            aVar.iqT.setImageResource(R.drawable.l2);
            aVar.iqT.setContentDescription(this.mContext.getString(R.string.b56));
        } else {
            int QC = QC(i);
            if (QC > this.emW - 1) {
                aVar.iqT.setImageDrawable(null);
                aVar.iqT.setContentDescription("");
                ab.i("MicroMsg.emoji.DefaultSmileyAdapter", "real position is bigger real count.");
            } else {
                Drawable qJ = e.dqK().qJ(QC);
                aVar.iqT.setImageDrawable(qJ);
                CharSequence text = e.dqK().getText(QC);
                if (bo.isNullOrNil(text)) {
                    text = view.getResources().getString(R.string.bc5);
                }
                aVar.iqT.setContentDescription(text);
                if (qJ == null) {
                    ab.i("MicroMsg.emoji.DefaultSmileyAdapter", "drawable is null. realPosition:%d description:%s", Integer.valueOf(QC), text);
                }
            }
        }
        AppMethodBeat.o(62979);
        return view;
    }
}
