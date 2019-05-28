package com.tencent.p177mm.plugin.fav.p410ui.p1260a;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fav.ui.a.d */
public abstract class C34151d extends BaseAdapter implements OnClickListener {
    private Context context;
    public String kPJ;
    public List<String> mlx = new LinkedList();
    public SparseArray<SpannableString> mly = new SparseArray();

    /* renamed from: KI */
    public abstract void mo54737KI(String str);

    public C34151d(Context context) {
        this.context = context;
    }

    public int getCount() {
        return this.mlx.size();
    }

    private String getItem(int i) {
        return (String) this.mlx.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = View.inflate(this.context, 2130969531, null);
            view.setOnClickListener(this);
        }
        TextView textView = (TextView) view.findViewById(2131823980);
        CharSequence bc = C5046bo.m7532bc(getItem(i), "");
        int textSize = (int) textView.getTextSize();
        int hashCode = bc.hashCode();
        CharSequence charSequence = (SpannableString) this.mly.get(hashCode);
        if (charSequence == null) {
            charSequence = new SpannableString(C44089j.m79294b(this.context, bc, textSize));
            textSize = bc.indexOf(this.kPJ);
            if (-1 == textSize) {
                C4990ab.m7421w("MicroMsg.FavoriteTagSearchAdapter", "high light %s error", bc);
            } else {
                int length = this.kPJ.length() + textSize;
                charSequence.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(C25738R.color.a61)), textSize, length, 33);
                charSequence.setSpan(new StyleSpan(1), textSize, length, 33);
                this.mly.put(hashCode, charSequence);
            }
        }
        textView.setText(charSequence);
        return view;
    }

    public void onClick(View view) {
        C4990ab.m7411d("MicroMsg.FavoriteTagSearchAdapter", "select search tag %s", ((TextView) view.findViewById(2131823980)).getText().toString());
        mo54737KI(r0);
    }
}
