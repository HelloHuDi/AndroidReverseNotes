package com.tencent.mm.ui.base;

import android.os.Build.VERSION;
import android.support.v4.view.p;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

public abstract class x extends p {
    private final w yAD;

    public abstract View getView(int i, View view, ViewGroup viewGroup);

    public x() {
        this(new w());
    }

    private x(w wVar) {
        this.yAD = wVar;
        SparseArray[] sparseArrayArr = new SparseArray[1];
        for (int i = 0; i <= 0; i++) {
            sparseArrayArr[0] = new SparseArray();
        }
        wVar.yAB = 1;
        wVar.yAC = sparseArrayArr[0];
        wVar.yAA = sparseArrayArr;
    }

    public void notifyDataSetChanged() {
        Object obj;
        int length;
        w wVar = this.yAD;
        View[] viewArr = wVar.yAy;
        int[] iArr = wVar.yAz;
        if (wVar.yAB > 1) {
            obj = 1;
        } else {
            obj = null;
        }
        SparseArray sparseArray = wVar.yAC;
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
                        sparseArray = wVar.yAA[i];
                    }
                    sparseArray.put(length, obj2);
                    if (VERSION.SDK_INT >= 14) {
                        obj2.setAccessibilityDelegate(null);
                    }
                }
            }
        }
        length = wVar.yAy.length;
        int i2 = wVar.yAB;
        SparseArray[] sparseArrayArr = wVar.yAA;
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
            w wVar = this.yAD;
            if (wVar.yAB == 1) {
                view = w.a(wVar.yAC, i);
            } else if (itemViewType >= 0 && itemViewType < wVar.yAA.length) {
                view = w.a(wVar.yAA[itemViewType], i);
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
            w wVar = this.yAD;
            if (wVar.yAB == 1) {
                wVar.yAC.put(i, view);
            } else {
                wVar.yAA[itemViewType].put(i, view);
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
