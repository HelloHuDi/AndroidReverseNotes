package com.tencent.mm.plugin.label.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMTextView;
import java.util.ArrayList;

public final class b extends BaseAdapter {
    String gtk;
    private Context mContext;
    ArrayList<String> nIA = new ArrayList();
    SparseArray<SpannableString> nIB = new SparseArray();

    public b(Context context) {
        AppMethodBeat.i(22653);
        this.mContext = context;
        AppMethodBeat.o(22653);
    }

    public final int getCount() {
        AppMethodBeat.i(22654);
        if (this.nIA == null) {
            AppMethodBeat.o(22654);
            return 0;
        }
        int size = this.nIA.size();
        AppMethodBeat.o(22654);
        return size;
    }

    public final String getItem(int i) {
        AppMethodBeat.i(22655);
        if (this.nIA == null || i >= getCount()) {
            AppMethodBeat.o(22655);
            return null;
        }
        String str = (String) this.nIA.get(i);
        AppMethodBeat.o(22655);
        return str;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        AppMethodBeat.i(22656);
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.qs, viewGroup, false);
            cVar = new c(view);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        MMTextView mMTextView = cVar.nJb;
        CharSequence bc = bo.bc(getItem(i), "");
        int textSize = (int) cVar.nJb.getTextSize();
        int hashCode = bc.hashCode();
        CharSequence charSequence = (SpannableString) this.nIB.get(hashCode);
        if (charSequence == null) {
            charSequence = new SpannableString(j.b(this.mContext, bc, textSize));
            textSize = bc.indexOf(this.gtk);
            if (textSize == -1) {
                ab.w("MicroMsg.Label.ContactLabelSearchAdapter", "hight light %s error.", bc);
            } else {
                int length = this.gtk.length() + textSize;
                charSequence.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(R.color.a61)), textSize, length, 33);
                charSequence.setSpan(new StyleSpan(1), textSize, length, 33);
                this.nIB.put(hashCode, charSequence);
            }
        }
        mMTextView.setText(charSequence);
        AppMethodBeat.o(22656);
        return view;
    }
}
