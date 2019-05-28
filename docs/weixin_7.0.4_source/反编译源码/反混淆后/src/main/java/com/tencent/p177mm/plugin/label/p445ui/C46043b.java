package com.tencent.p177mm.plugin.label.p445ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.widget.MMTextView;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.label.ui.b */
public final class C46043b extends BaseAdapter {
    String gtk;
    private Context mContext;
    ArrayList<String> nIA = new ArrayList();
    SparseArray<SpannableString> nIB = new SparseArray();

    public C46043b(Context context) {
        AppMethodBeat.m2504i(22653);
        this.mContext = context;
        AppMethodBeat.m2505o(22653);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(22654);
        if (this.nIA == null) {
            AppMethodBeat.m2505o(22654);
            return 0;
        }
        int size = this.nIA.size();
        AppMethodBeat.m2505o(22654);
        return size;
    }

    public final String getItem(int i) {
        AppMethodBeat.m2504i(22655);
        if (this.nIA == null || i >= getCount()) {
            AppMethodBeat.m2505o(22655);
            return null;
        }
        String str = (String) this.nIA.get(i);
        AppMethodBeat.m2505o(22655);
        return str;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C39282c c39282c;
        AppMethodBeat.m2504i(22656);
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(2130969225, viewGroup, false);
            c39282c = new C39282c(view);
            view.setTag(c39282c);
        } else {
            c39282c = (C39282c) view.getTag();
        }
        MMTextView mMTextView = c39282c.nJb;
        CharSequence bc = C5046bo.m7532bc(getItem(i), "");
        int textSize = (int) c39282c.nJb.getTextSize();
        int hashCode = bc.hashCode();
        CharSequence charSequence = (SpannableString) this.nIB.get(hashCode);
        if (charSequence == null) {
            charSequence = new SpannableString(C44089j.m79294b(this.mContext, bc, textSize));
            textSize = bc.indexOf(this.gtk);
            if (textSize == -1) {
                C4990ab.m7421w("MicroMsg.Label.ContactLabelSearchAdapter", "hight light %s error.", bc);
            } else {
                int length = this.gtk.length() + textSize;
                charSequence.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(C25738R.color.a61)), textSize, length, 33);
                charSequence.setSpan(new StyleSpan(1), textSize, length, 33);
                this.nIB.put(hashCode, charSequence);
            }
        }
        mMTextView.setText(charSequence);
        AppMethodBeat.m2505o(22656);
        return view;
    }
}
