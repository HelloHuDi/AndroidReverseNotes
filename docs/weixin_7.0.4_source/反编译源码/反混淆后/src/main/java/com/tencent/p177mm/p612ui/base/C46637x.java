package com.tencent.p177mm.p612ui.base;

import android.os.Build.VERSION;
import android.support.p057v4.view.C25365p;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.tencent.mm.ui.base.x */
public abstract class C46637x extends C25365p {
    private final C40677w yAD;

    public abstract View getView(int i, View view, ViewGroup viewGroup);

    public C46637x() {
        this(new C40677w());
    }

    private C46637x(C40677w c40677w) {
        this.yAD = c40677w;
        SparseArray[] sparseArrayArr = new SparseArray[1];
        for (int i = 0; i <= 0; i++) {
            sparseArrayArr[0] = new SparseArray();
        }
        c40677w.yAB = 1;
        c40677w.yAC = sparseArrayArr[0];
        c40677w.yAA = sparseArrayArr;
    }

    public void notifyDataSetChanged() {
        Object obj;
        int length;
        C40677w c40677w = this.yAD;
        View[] viewArr = c40677w.yAy;
        int[] iArr = c40677w.yAz;
        if (c40677w.yAB > 1) {
            obj = 1;
        } else {
            obj = null;
        }
        SparseArray sparseArray = c40677w.yAC;
        for (length = viewArr.length - 1; length >= 0; length--) {
            Object obj2 = viewArr[length];
            if (obj2 != null) {
                Object obj3;
                int i = iArr[length];
                viewArr[length] = null;
                iArr[length] = -1;
                if (i >= 0) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (obj3 != null) {
                    if (obj != null) {
                        sparseArray = c40677w.yAA[i];
                    }
                    sparseArray.put(length, obj2);
                    if (VERSION.SDK_INT >= 14) {
                        obj2.setAccessibilityDelegate(null);
                    }
                }
            }
        }
        length = c40677w.yAy.length;
        int i2 = c40677w.yAB;
        SparseArray[] sparseArrayArr = c40677w.yAA;
        for (int i3 = 0; i3 < i2; i3++) {
            SparseArray sparseArray2 = sparseArrayArr[i3];
            int size = sparseArray2.size();
            int i4 = size - length;
            size--;
            int i5 = 0;
            while (i5 < i4) {
                int i6 = size - 1;
                sparseArray2.remove(sparseArray2.keyAt(size));
                i5++;
                size = i6;
            }
        }
        super.notifyDataSetChanged();
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = null;
        int itemViewType = getItemViewType(i);
        if (itemViewType != -1) {
            C40677w c40677w = this.yAD;
            if (c40677w.yAB == 1) {
                view = C40677w.m70263a(c40677w.yAC, i);
            } else if (itemViewType >= 0 && itemViewType < c40677w.yAA.length) {
                view = C40677w.m70263a(c40677w.yAA[itemViewType], i);
            }
        }
        view = getView(i, view, viewGroup);
        viewGroup.addView(view);
        return view;
    }

    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        viewGroup.removeView(view);
        int itemViewType = getItemViewType(i);
        if (itemViewType != -1) {
            C40677w c40677w = this.yAD;
            if (c40677w.yAB == 1) {
                c40677w.yAC.put(i, view);
            } else {
                c40677w.yAA[itemViewType].put(i, view);
            }
            if (VERSION.SDK_INT >= 14) {
                view.setAccessibilityDelegate(null);
            }
        }
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public int getItemViewType(int i) {
        return 0;
    }
}
