package com.google.android.flexbox;

import android.view.View;
import java.util.List;

/* renamed from: com.google.android.flexbox.a */
interface C45055a {
    /* renamed from: a */
    void mo19324a(int i, View view);

    /* renamed from: a */
    void mo19325a(View view, int i, int i2, C41633b c41633b);

    /* renamed from: a */
    void mo19326a(C41633b c41633b);

    /* renamed from: ca */
    int mo19328ca(View view);

    /* renamed from: eU */
    View mo19330eU(int i);

    /* renamed from: eV */
    View mo19331eV(int i);

    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<C41633b> getFlexLinesInternal();

    int getFlexWrap();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    int getSumOfCrossSize();

    /* renamed from: m */
    int mo19349m(View view, int i, int i2);

    void setFlexLines(List<C41633b> list);

    /* renamed from: ua */
    boolean mo19366ua();

    /* renamed from: v */
    int mo19367v(int i, int i2, int i3);

    /* renamed from: w */
    int mo19368w(int i, int i2, int i3);
}
