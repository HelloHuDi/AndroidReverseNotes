package com.tencent.mm.plugin.fav.ui.a;

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
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public abstract class d extends BaseAdapter implements OnClickListener {
    private Context context;
    public String kPJ;
    public List<String> mlx = new LinkedList();
    public SparseArray<SpannableString> mly = new SparseArray();

    public abstract void KI(String str);

    public d(Context context) {
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
            view = View.inflate(this.context, R.layout.z2, null);
            view.setOnClickListener(this);
        }
        TextView textView = (TextView) view.findViewById(R.id.brv);
        CharSequence bc = bo.bc(getItem(i), "");
        int textSize = (int) textView.getTextSize();
        int hashCode = bc.hashCode();
        CharSequence charSequence = (SpannableString) this.mly.get(hashCode);
        if (charSequence == null) {
            charSequence = new SpannableString(j.b(this.context, bc, textSize));
            textSize = bc.indexOf(this.kPJ);
            if (-1 == textSize) {
                ab.w("MicroMsg.FavoriteTagSearchAdapter", "high light %s error", bc);
            } else {
                int length = this.kPJ.length() + textSize;
                charSequence.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.color.a61)), textSize, length, 33);
                charSequence.setSpan(new StyleSpan(1), textSize, length, 33);
                this.mly.put(hashCode, charSequence);
            }
        }
        textView.setText(charSequence);
        return view;
    }

    public void onClick(View view) {
        ab.d("MicroMsg.FavoriteTagSearchAdapter", "select search tag %s", ((TextView) view.findViewById(R.id.brv)).getText().toString());
        KI(r0);
    }
}
