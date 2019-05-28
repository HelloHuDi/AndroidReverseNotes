package com.tencent.p177mm.p612ui.tools;

import android.widget.TextView.OnEditorActionListener;
import com.tencent.p177mm.p612ui.tools.ActionBarSearchView.C5553a;
import com.tencent.p177mm.p612ui.tools.ActionBarSearchView.C5554b;
import com.tencent.p177mm.p612ui.tools.SearchViewNotRealTimeHelper.C5576a;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.ui.tools.d */
public interface C5582d {
    void dJr();

    boolean dJs();

    boolean dJt();

    String getSearchContent();

    /* renamed from: qN */
    void mo11322qN(boolean z);

    /* renamed from: qO */
    void mo11323qO(boolean z);

    void setAutoMatchKeywords(boolean z);

    void setBackClickCallback(C5553a c5553a);

    void setCallBack(C5554b c5554b);

    void setEditTextEnabled(boolean z);

    void setHint(CharSequence charSequence);

    void setKeywords(ArrayList<String> arrayList);

    void setNotRealCallBack(C5576a c5576a);

    void setOnEditorActionListener(OnEditorActionListener onEditorActionListener);

    void setSearchContent(String str);

    void setSearchTipIcon(int i);

    void setSelectedTag(String str);

    void setStatusBtnEnabled(boolean z);
}
