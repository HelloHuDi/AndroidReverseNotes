package com.tencent.p177mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.p057v4.view.C25365p;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.CustomViewPager;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.ref.SoftReference;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyViewPager */
public class AppBrandSmileyViewPager extends CustomViewPager {
    private int jiO = 0;
    private int jiP = 0;
    private C11031b jiQ;
    private C27414c jir;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyViewPager$b */
    public interface C11031b {
        void aRC();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyViewPager$a */
    static class C36741a extends C25365p {
        SparseArray<SoftReference<View>> jiR = new SparseArray();
        private boolean jiS = false;
        C27414c jir;

        C36741a() {
            AppMethodBeat.m2504i(134333);
            AppMethodBeat.m2505o(134333);
        }

        public final int getItemPosition(Object obj) {
            AppMethodBeat.m2504i(134334);
            if (this.jiS) {
                AppMethodBeat.m2505o(134334);
                return -2;
            }
            int itemPosition = super.getItemPosition(obj);
            AppMethodBeat.m2505o(134334);
            return itemPosition;
        }

        public final void notifyDataSetChanged() {
            AppMethodBeat.m2504i(134335);
            this.jiS = true;
            super.notifyDataSetChanged();
            this.jiS = false;
            AppMethodBeat.m2505o(134335);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(134336);
            int pageCount = this.jir.aRH().getPageCount();
            AppMethodBeat.m2505o(134336);
            return pageCount;
        }

        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            AppMethodBeat.m2504i(134337);
            viewGroup.removeView((View) obj);
            AppMethodBeat.m2505o(134337);
        }

        public final Object instantiateItem(ViewGroup viewGroup, int i) {
            AppMethodBeat.m2504i(134338);
            View view = null;
            if (this.jiR.get(i) != null) {
                view = (View) ((SoftReference) this.jiR.get(i)).get();
            }
            if (view == null) {
                View qN = this.jir.aRH().mo35148qN(i);
                if (qN != null) {
                    viewGroup.addView(qN, 0);
                    this.jiR.put(i, new SoftReference(qN));
                } else {
                    C4990ab.m7412e("MicroMsg.AppBrandSmileyViewPagerAdapter", "contentView == null!");
                }
                AppMethodBeat.m2505o(134338);
                return qN;
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view, 0);
            AppMethodBeat.m2505o(134338);
            return view;
        }
    }

    public AppBrandSmileyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(134339);
        if (VERSION.SDK_INT >= 9) {
            setOverScrollMode(2);
        }
        AppMethodBeat.m2505o(134339);
    }

    public void setPanelManager(C27414c c27414c) {
        this.jir = c27414c;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(134340);
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
        AppMethodBeat.m2505o(134340);
    }

    public void setOnSizeChangedListener(C11031b c11031b) {
        this.jiQ = c11031b;
    }
}
