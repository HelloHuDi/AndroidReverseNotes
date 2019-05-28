package com.google.android.flexbox;

import android.view.View;
import java.util.List;

interface a {
    void a(int i, View view);

    void a(View view, int i, int i2, b bVar);

    void a(b bVar);

    int ca(View view);

    View eU(int i);

    View eV(int i);

    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<b> getFlexLinesInternal();

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

    int m(View view, int i, int i2);

    void setFlexLines(List<b> list);

    boolean ua();

    int v(int i, int i2, int i3);

    int w(int i, int i2, int i3);
}
