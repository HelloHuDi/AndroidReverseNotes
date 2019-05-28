package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.p;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.CustomViewPager;
import java.lang.ref.SoftReference;

public class AppBrandSmileyViewPager extends CustomViewPager {
    private int jiO = 0;
    private int jiP = 0;
    private b jiQ;
    private c jir;

    public interface b {
        void aRC();
    }

    static class a extends p {
        SparseArray<SoftReference<View>> jiR = new SparseArray();
        private boolean jiS = false;
        c jir;

        a() {
            AppMethodBeat.i(134333);
            AppMethodBeat.o(134333);
        }

        public final int getItemPosition(Object obj) {
            AppMethodBeat.i(134334);
            if (this.jiS) {
                AppMethodBeat.o(134334);
                return -2;
            }
            int itemPosition = super.getItemPosition(obj);
            AppMethodBeat.o(134334);
            return itemPosition;
        }

        public final void notifyDataSetChanged() {
            AppMethodBeat.i(134335);
            this.jiS = true;
            super.notifyDataSetChanged();
            this.jiS = false;
            AppMethodBeat.o(134335);
        }

        public final int getCount() {
            AppMethodBeat.i(134336);
            int pageCount = this.jir.aRH().getPageCount();
            AppMethodBeat.o(134336);
            return pageCount;
        }

        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            AppMethodBeat.i(134337);
            viewGroup.removeView((View) obj);
            AppMethodBeat.o(134337);
        }

        public final Object instantiateItem(ViewGroup viewGroup, int i) {
            AppMethodBeat.i(134338);
            View view = null;
            if (this.jiR.get(i) != null) {
                view = (View) ((SoftReference) this.jiR.get(i)).get();
            }
            if (view == null) {
                View qN = this.jir.aRH().qN(i);
                if (qN != null) {
                    viewGroup.addView(qN, 0);
                    this.jiR.put(i, new SoftReference(qN));
                } else {
                    ab.e("MicroMsg.AppBrandSmileyViewPagerAdapter", "contentView == null!");
                }
                AppMethodBeat.o(134338);
                return qN;
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view, 0);
            AppMethodBeat.o(134338);
            return view;
        }
    }

    public AppBrandSmileyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(134339);
        if (VERSION.SDK_INT >= 9) {
            setOverScrollMode(2);
        }
        AppMethodBeat.o(134339);
    }

    public void setPanelManager(c cVar) {
        this.jir = cVar;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(134340);
        super.onSizeChanged(i, i2, i3, i4);
        if (this.jir != null && (((i > 0 && i3 != i) || (i2 > 0 && i4 != i2)) && ((i2 > 0 && i2 != this.jiO) || (i > 0 && i != this.jiP)))) {
            this.jir.jiL = i2;
            this.jir.jiM = i;
            if (this.jiQ != null) {
                this.jiQ.aRC();
            }
        }
        if (i2 > 0) {
            this.jiO = i2;
        }
        if (i > 0) {
            this.jiP = i;
        }
        AppMethodBeat.o(134340);
    }

    public void setOnSizeChangedListener(b bVar) {
        this.jiQ = bVar;
    }
}
