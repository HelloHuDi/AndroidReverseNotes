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
import com.tencent.p177mm.p211cb.C26003e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.view.p1097f.C16067a;

/* renamed from: com.tencent.mm.view.a.d */
public class C36373d extends C16041a {

    /* renamed from: com.tencent.mm.view.a.d$a */
    class C30840a {
        ImageView iqT;

        public C30840a(View view) {
            AppMethodBeat.m2504i(62976);
            this.iqT = (ImageView) view.findViewById(2131821503);
            AppMethodBeat.m2505o(62976);
        }
    }

    public C36373d(Context context, C16067a c16067a) {
        super(context, c16067a);
    }

    public int getCount() {
        return this.Abd;
    }

    public Object getItem(int i) {
        AppMethodBeat.m2504i(62977);
        C1511f c1511f = new C1511f();
        if (i == getCount() - 1) {
            c1511f.position = -1;
        } else {
            c1511f.position = mo57296QC(i);
        }
        AppMethodBeat.m2505o(62977);
        return c1511f;
    }

    /* renamed from: ui */
    public boolean mo28409ui(int i) {
        AppMethodBeat.m2504i(62978);
        if (i != getCount() - 1) {
            AppMethodBeat.m2505o(62978);
            return true;
        }
        AppMethodBeat.m2505o(62978);
        return false;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    /* renamed from: QC */
    public final int mo57296QC(int i) {
        return ((this.Abd - 1) * this.Abe) + i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C30840a c30840a;
        AppMethodBeat.m2504i(62979);
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(2130970702, null);
            view.setLayoutParams(new LayoutParams(-1, -1));
            c30840a = new C30840a(view);
            view.setTag(c30840a);
        } else {
            c30840a = (C30840a) view.getTag();
        }
        if (i == getCount() - 1) {
            c30840a.iqT.setImageResource(C25738R.drawable.f6647l2);
            c30840a.iqT.setContentDescription(this.mContext.getString(C25738R.string.b56));
        } else {
            int QC = mo57296QC(i);
            if (QC > this.emW - 1) {
                c30840a.iqT.setImageDrawable(null);
                c30840a.iqT.setContentDescription("");
                C4990ab.m7416i("MicroMsg.emoji.DefaultSmileyAdapter", "real position is bigger real count.");
            } else {
                Drawable qJ = C26003e.dqK().mo43876qJ(QC);
                c30840a.iqT.setImageDrawable(qJ);
                CharSequence text = C26003e.dqK().getText(QC);
                if (C5046bo.isNullOrNil(text)) {
                    text = view.getResources().getString(C25738R.string.bc5);
                }
                c30840a.iqT.setContentDescription(text);
                if (qJ == null) {
                    C4990ab.m7417i("MicroMsg.emoji.DefaultSmileyAdapter", "drawable is null. realPosition:%d description:%s", Integer.valueOf(QC), text);
                }
            }
        }
        AppMethodBeat.m2505o(62979);
        return view;
    }
}
