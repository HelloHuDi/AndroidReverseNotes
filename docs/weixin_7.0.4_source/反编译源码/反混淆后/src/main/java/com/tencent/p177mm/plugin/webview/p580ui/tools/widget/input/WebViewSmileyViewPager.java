package com.tencent.p177mm.plugin.webview.p580ui.tools.widget.input;

import android.content.Context;
import android.support.p057v4.view.C25365p;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.p612ui.base.CustomViewPager;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.ref.SoftReference;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyViewPager */
public class WebViewSmileyViewPager extends CustomViewPager {
    private int jiO = 0;
    private int jiP = 0;
    private C23156a uKI;
    private C14685c uKz;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyViewPager$a */
    public interface C23156a {
        void aRC();
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyViewPager$b */
    static class C23157b extends C25365p {
        SparseArray<SoftReference<View>> jiR = new SparseArray();
        private boolean jiS = false;
        C14685c uKz;

        C23157b() {
            AppMethodBeat.m2504i(10120);
            AppMethodBeat.m2505o(10120);
        }

        public final int getItemPosition(Object obj) {
            AppMethodBeat.m2504i(10121);
            if (this.jiS) {
                AppMethodBeat.m2505o(10121);
                return -2;
            }
            int itemPosition = super.getItemPosition(obj);
            AppMethodBeat.m2505o(10121);
            return itemPosition;
        }

        public final void notifyDataSetChanged() {
            AppMethodBeat.m2504i(10122);
            this.jiS = true;
            super.notifyDataSetChanged();
            this.jiS = false;
            AppMethodBeat.m2505o(10122);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(10123);
            int pageCount = this.uKz.ddb().getPageCount();
            AppMethodBeat.m2505o(10123);
            return pageCount;
        }

        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            AppMethodBeat.m2504i(10124);
            viewGroup.removeView((View) obj);
            AppMethodBeat.m2505o(10124);
        }

        public final Object instantiateItem(ViewGroup viewGroup, int i) {
            AppMethodBeat.m2504i(10125);
            View view = null;
            if (this.jiR.get(i) != null) {
                view = (View) ((SoftReference) this.jiR.get(i)).get();
            }
            if (view == null) {
                View qN = this.uKz.ddb().mo56469qN(i);
                if (qN != null) {
                    viewGroup.addView(qN, 0);
                    this.jiR.put(i, new SoftReference(qN));
                } else {
                    C4990ab.m7412e("MicroMsg.WebViewSmileyViewPagerAdapter", "contentView == null!");
                }
                AppMethodBeat.m2505o(10125);
                return qN;
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view, 0);
            AppMethodBeat.m2505o(10125);
            return view;
        }
    }

    public WebViewSmileyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(10126);
        if (C1443d.m3068iW(9)) {
            setOverScrollMode(2);
        }
        AppMethodBeat.m2505o(10126);
    }

    public void setPanelManager(C14685c c14685c) {
        this.uKz = c14685c;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(10127);
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
        AppMethodBeat.m2505o(10127);
    }

    public void setOnSizeChangedListener(C23156a c23156a) {
        this.uKI = c23156a;
    }
}
