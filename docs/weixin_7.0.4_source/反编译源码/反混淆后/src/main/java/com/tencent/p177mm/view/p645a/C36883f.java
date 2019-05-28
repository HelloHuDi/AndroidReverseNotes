package com.tencent.p177mm.view.p645a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p211cb.C26003e;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.view.p1097f.C16067a;

/* renamed from: com.tencent.mm.view.a.f */
public final class C36883f extends C36373d {
    public int Abr = 1;
    private ImageView Abs;
    private ImageView Abt;

    public C36883f(Context context, C16067a c16067a) {
        super(context, c16067a);
    }

    /* renamed from: ui */
    public final boolean mo28409ui(int i) {
        AppMethodBeat.m2504i(62987);
        if (!super.mo28409ui(i) || mo58774QD(i)) {
            AppMethodBeat.m2505o(62987);
            return false;
        }
        AppMethodBeat.m2505o(62987);
        return true;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        AppMethodBeat.m2504i(62988);
        if (i == (this.njC * this.Abg) - 5) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130970700, null);
            inflate.setLayoutParams(new LayoutParams(-1, -1));
            this.Abs = (ImageView) inflate.findViewById(2131827576);
            this.Abt = (ImageView) inflate.findViewById(2131827575);
            int QC = mo57296QC(i);
            this.Abs.setImageDrawable(C26003e.dqK().mo43876qJ(QC));
            CharSequence text = C26003e.dqK().getText(QC);
            if (C5046bo.isNullOrNil(text)) {
                text = inflate.getResources().getString(C25738R.string.bc5);
            }
            this.Abs.setContentDescription(text);
            this.Abt.setImageResource(C25738R.drawable.f6647l2);
            this.Abt.setContentDescription(this.mContext.getString(C25738R.string.b56));
            mo58775bv((float) this.Abr);
            view2 = inflate;
        } else {
            view2 = super.getView(i, view, viewGroup);
        }
        AppMethodBeat.m2505o(62988);
        return view2;
    }

    /* renamed from: bv */
    public final void mo58775bv(float f) {
        AppMethodBeat.m2504i(62989);
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
                    AppMethodBeat.m2505o(62989);
                    return;
                }
                this.Abt.setVisibility(0);
                this.Abt.setImageAlpha((int) ((1.0f - f) * 255.0f));
            }
        }
        AppMethodBeat.m2505o(62989);
    }

    /* renamed from: QD */
    public final boolean mo58774QD(int i) {
        return this.Abr == 0 && i == (this.njC * this.Abg) - 5;
    }
}
