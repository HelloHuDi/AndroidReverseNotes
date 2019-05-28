package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.q;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public class ChattingItemFooter extends LinearLayout implements OnClickListener {
    private static final int[] zfI = new int[]{R.drawable.i1, R.drawable.i1, R.drawable.i3, R.drawable.i2};
    private static final int[] zfJ = new int[]{R.drawable.y4, R.drawable.y5, R.drawable.y7, R.drawable.y6};
    private String igi;
    private Context mContext;
    private LayoutInflater mInflater;

    public ChattingItemFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(33207);
        this.mContext = context;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        AppMethodBeat.o(33207);
    }

    public final boolean l(List<j> list, String str) {
        AppMethodBeat.i(33208);
        if (list == null || list.size() <= 0) {
            ab.d("ChattingItemFooter", "no menulist!");
            setVisibility(8);
            AppMethodBeat.o(33208);
            return false;
        }
        j jVar;
        TextView a;
        TextView a2;
        this.igi = str;
        int childCount = getChildCount();
        int[] iArr = zfI;
        LayoutParams layoutParams = new LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        int size = list.size();
        switch (size) {
            case 1:
                jVar = (j) list.get(0);
                a = a(0, childCount, layoutParams);
                a.setText(jVar.name);
                a.setTag(jVar);
                a.setBackgroundResource(iArr[3]);
                break;
            case 2:
                break;
            case 3:
                jVar = (j) list.get(1);
                a2 = a(1, childCount, layoutParams);
                a2.setText(jVar.name);
                a2.setTag(jVar);
                a2.setBackgroundResource(iArr[1]);
                break;
        }
        jVar = (j) list.get(0);
        a2 = a(0, childCount, layoutParams);
        a2.setText(jVar.name);
        a2.setTag(jVar);
        a2.setBackgroundResource(iArr[0]);
        jVar = (j) list.get(size - 1);
        a = a(size - 1, childCount, layoutParams);
        a.setText(jVar.name);
        a.setTag(jVar);
        a.setBackgroundResource(iArr[2]);
        if (childCount > size && childCount - 1 > 0) {
            removeViews(size, childCount - 1);
        }
        setLongClickable(true);
        setVisibility(0);
        AppMethodBeat.o(33208);
        return true;
    }

    private TextView a(int i, int i2, LayoutParams layoutParams) {
        AppMethodBeat.i(33209);
        TextView textView;
        if (i < i2) {
            textView = (TextView) getChildAt(i);
            AppMethodBeat.o(33209);
            return textView;
        }
        textView = (TextView) this.mInflater.inflate(R.layout.lz, null);
        textView.setLongClickable(false);
        textView.setOnClickListener(this);
        textView.setLayoutParams(layoutParams);
        addView(textView);
        AppMethodBeat.o(33209);
        return textView;
    }

    private void d(j jVar) {
        AppMethodBeat.i(33210);
        aw.Rg().a(new q(this.igi, jVar.getInfo()), 0);
        AppMethodBeat.o(33210);
    }

    public void onClick(View view) {
        AppMethodBeat.i(33211);
        Object tag = view.getTag();
        if (tag instanceof j) {
            j jVar = (j) tag;
            switch (jVar.type) {
                case 1:
                    ab.d("ChattingItemFooter", "get latest message");
                    jVar.state = j.fwo;
                    d(jVar);
                    AppMethodBeat.o(33211);
                    return;
                case 2:
                    ab.d("ChattingItemFooter", "start webview url");
                    jVar.state = j.fwo;
                    d(jVar);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", jVar.value);
                    intent.putExtra("showShare", false);
                    intent.putExtra("geta8key_username", this.igi);
                    d.b(this.mContext, "webview", ".ui.tools.WebViewUI", intent);
                    break;
            }
            AppMethodBeat.o(33211);
            return;
        }
        AppMethodBeat.o(33211);
    }
}
