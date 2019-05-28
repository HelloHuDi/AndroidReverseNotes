package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.support.v4.view.p;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.CustomViewPager;
import java.lang.ref.SoftReference;

public class WebViewSmileyViewPager extends CustomViewPager {
    private int jiO = 0;
    private int jiP = 0;
    private a uKI;
    private c uKz;

    public interface a {
        void aRC();
    }

    static class b extends p {
        SparseArray<SoftReference<View>> jiR = new SparseArray();
        private boolean jiS = false;
        c uKz;

        b() {
            AppMethodBeat.i(10120);
            AppMethodBeat.o(10120);
        }

        public final int getItemPosition(Object obj) {
            AppMethodBeat.i(10121);
            if (this.jiS) {
                AppMethodBeat.o(10121);
                return -2;
            }
            int itemPosition = super.getItemPosition(obj);
            AppMethodBeat.o(10121);
            return itemPosition;
        }

        public final void notifyDataSetChanged() {
            AppMethodBeat.i(10122);
            this.jiS = true;
            super.notifyDataSetChanged();
            this.jiS = false;
            AppMethodBeat.o(10122);
        }

        public final int getCount() {
            AppMethodBeat.i(10123);
            int pageCount = this.uKz.ddb().getPageCount();
            AppMethodBeat.o(10123);
            return pageCount;
        }

        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            AppMethodBeat.i(10124);
            viewGroup.removeView((View) obj);
            AppMethodBeat.o(10124);
        }

        public final Object instantiateItem(ViewGroup viewGroup, int i) {
            AppMethodBeat.i(10125);
            View view = null;
            if (this.jiR.get(i) != null) {
                view = (View) ((SoftReference) this.jiR.get(i)).get();
            }
            if (view == null) {
                View qN = this.uKz.ddb().qN(i);
                if (qN != null) {
                    viewGroup.addView(qN, 0);
                    this.jiR.put(i, new SoftReference(qN));
                } else {
                    ab.e("MicroMsg.WebViewSmileyViewPagerAdapter", "contentView == null!");
                }
                AppMethodBeat.o(10125);
                return qN;
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view, 0);
            AppMethodBeat.o(10125);
            return view;
        }
    }

    public WebViewSmileyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(10126);
        if (d.iW(9)) {
            setOverScrollMode(2);
        }
        AppMethodBeat.o(10126);
    }

    public void setPanelManager(c cVar) {
        this.uKz = cVar;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(10127);
        super.onSizeChanged(i, i2, i3, i4);
        if (this.uKz != null && (((i > 0 && i3 != i) || (i2 > 0 && i4 != i2)) && ((i2 > 0 && i2 != this.jiO) || (i > 0 && i != this.jiP)))) {
            this.uKz.jiL = i2;
            this.uKz.jiM = i;
            if (this.uKI != null) {
                this.uKI.aRC();
            }
        }
        if (i2 > 0) {
            this.jiO = i2;
        }
        if (i > 0) {
            this.jiP = i;
        }
        AppMethodBeat.o(10127);
    }

    public void setOnSizeChangedListener(a aVar) {
        this.uKI = aVar;
    }
}
