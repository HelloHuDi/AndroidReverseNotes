package com.tencent.mm.view.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.e;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.view.f.a;

public final class f extends d {
    public int Abr = 1;
    private ImageView Abs;
    private ImageView Abt;

    public f(Context context, a aVar) {
        super(context, aVar);
    }

    public final boolean ui(int i) {
        AppMethodBeat.i(62987);
        if (!super.ui(i) || QD(i)) {
            AppMethodBeat.o(62987);
            return false;
        }
        AppMethodBeat.o(62987);
        return true;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        AppMethodBeat.i(62988);
        if (i == (this.njC * this.Abg) - 5) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.atk, null);
            inflate.setLayoutParams(new LayoutParams(-1, -1));
            this.Abs = (ImageView) inflate.findViewById(R.id.ee3);
            this.Abt = (ImageView) inflate.findViewById(R.id.ee2);
            int QC = QC(i);
            this.Abs.setImageDrawable(e.dqK().qJ(QC));
            CharSequence text = e.dqK().getText(QC);
            if (bo.isNullOrNil(text)) {
                text = inflate.getResources().getString(R.string.bc5);
            }
            this.Abs.setContentDescription(text);
            this.Abt.setImageResource(R.drawable.l2);
            this.Abt.setContentDescription(this.mContext.getString(R.string.b56));
            bv((float) this.Abr);
            view2 = inflate;
        } else {
            view2 = super.getView(i, view, viewGroup);
        }
        AppMethodBeat.o(62988);
        return view2;
    }

    public final void bv(float f) {
        AppMethodBeat.i(62989);
        if (f >= 0.0f && f <= 1.0f) {
            if (this.Abs != null) {
                if (f <= 0.01f) {
                    this.Abs.setVisibility(4);
                } else {
                    this.Abs.setVisibility(0);
                    this.Abs.setImageAlpha((int) (255.0f * f));
                }
            }
            if (this.Abt != null) {
                if (f >= 0.99f) {
                    this.Abt.setVisibility(4);
                    AppMethodBeat.o(62989);
                    return;
                }
                this.Abt.setVisibility(0);
                this.Abt.setImageAlpha((int) ((1.0f - f) * 255.0f));
            }
        }
        AppMethodBeat.o(62989);
    }

    public final boolean QD(int i) {
        return this.Abr == 0 && i == (this.njC * this.Abg) - 5;
    }
}
