package com.tencent.p177mm.p612ui.chatting.viewitems;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p184aj.C37455j;
import com.tencent.p177mm.p184aj.C41744q;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.List;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.ChattingItemFooter */
public class ChattingItemFooter extends LinearLayout implements OnClickListener {
    private static final int[] zfI = new int[]{C25738R.drawable.f6556i1, C25738R.drawable.f6556i1, C25738R.drawable.f6558i3, C25738R.drawable.f6557i2};
    private static final int[] zfJ = new int[]{C25738R.drawable.f6998y4, C25738R.drawable.f6999y5, C25738R.drawable.f7001y7, C25738R.drawable.f7000y6};
    private String igi;
    private Context mContext;
    private LayoutInflater mInflater;

    public ChattingItemFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(33207);
        this.mContext = context;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        AppMethodBeat.m2505o(33207);
    }

    /* renamed from: l */
    public final boolean mo70214l(List<C37455j> list, String str) {
        AppMethodBeat.m2504i(33208);
        if (list == null || list.size() <= 0) {
            C4990ab.m7410d("ChattingItemFooter", "no menulist!");
            setVisibility(8);
            AppMethodBeat.m2505o(33208);
            return false;
        }
        C37455j c37455j;
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
                c37455j = (C37455j) list.get(0);
                a = m80120a(0, childCount, layoutParams);
                a.setText(c37455j.name);
                a.setTag(c37455j);
                a.setBackgroundResource(iArr[3]);
                break;
            case 2:
                break;
            case 3:
                c37455j = (C37455j) list.get(1);
                a2 = m80120a(1, childCount, layoutParams);
                a2.setText(c37455j.name);
                a2.setTag(c37455j);
                a2.setBackgroundResource(iArr[1]);
                break;
        }
        c37455j = (C37455j) list.get(0);
        a2 = m80120a(0, childCount, layoutParams);
        a2.setText(c37455j.name);
        a2.setTag(c37455j);
        a2.setBackgroundResource(iArr[0]);
        c37455j = (C37455j) list.get(size - 1);
        a = m80120a(size - 1, childCount, layoutParams);
        a.setText(c37455j.name);
        a.setTag(c37455j);
        a.setBackgroundResource(iArr[2]);
        if (childCount > size && childCount - 1 > 0) {
            removeViews(size, childCount - 1);
        }
        setLongClickable(true);
        setVisibility(0);
        AppMethodBeat.m2505o(33208);
        return true;
    }

    /* renamed from: a */
    private TextView m80120a(int i, int i2, LayoutParams layoutParams) {
        AppMethodBeat.m2504i(33209);
        TextView textView;
        if (i < i2) {
            textView = (TextView) getChildAt(i);
            AppMethodBeat.m2505o(33209);
            return textView;
        }
        textView = (TextView) this.mInflater.inflate(2130969045, null);
        textView.setLongClickable(false);
        textView.setOnClickListener(this);
        textView.setLayoutParams(layoutParams);
        addView(textView);
        AppMethodBeat.m2505o(33209);
        return textView;
    }

    /* renamed from: d */
    private void m80121d(C37455j c37455j) {
        AppMethodBeat.m2504i(33210);
        C9638aw.m17182Rg().mo14541a(new C41744q(this.igi, c37455j.getInfo()), 0);
        AppMethodBeat.m2505o(33210);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(33211);
        Object tag = view.getTag();
        if (tag instanceof C37455j) {
            C37455j c37455j = (C37455j) tag;
            switch (c37455j.type) {
                case 1:
                    C4990ab.m7410d("ChattingItemFooter", "get latest message");
                    c37455j.state = C37455j.fwo;
                    m80121d(c37455j);
                    AppMethodBeat.m2505o(33211);
                    return;
                case 2:
                    C4990ab.m7410d("ChattingItemFooter", "start webview url");
                    c37455j.state = C37455j.fwo;
                    m80121d(c37455j);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", c37455j.value);
                    intent.putExtra("showShare", false);
                    intent.putExtra("geta8key_username", this.igi);
                    C25985d.m41467b(this.mContext, "webview", ".ui.tools.WebViewUI", intent);
                    break;
            }
            AppMethodBeat.m2505o(33211);
            return;
        }
        AppMethodBeat.m2505o(33211);
    }
}
