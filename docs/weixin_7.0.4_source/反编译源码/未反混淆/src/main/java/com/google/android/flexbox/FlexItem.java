package com.google.android.flexbox;

import android.os.Parcelable;

interface FlexItem extends Parcelable {
    int getHeight();

    int getMaxHeight();

    int getMaxWidth();

    int getMinHeight();

    int getMinWidth();

    int getOrder();

    int getWidth();

    float ub();

    float uc();

    int ud();

    boolean ue();

    float uf();

    int ug();

    int uh();

    int ui();

    int uj();
}
