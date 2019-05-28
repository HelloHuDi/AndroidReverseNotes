package com.tencent.p177mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5616v;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyGrid */
public class AppBrandSmileyGrid extends GridView {
    OnItemClickListener arw = new C110291();
    int jiA = 0;
    int jiB = 0;
    private C27414c jir;
    C38604a jiv;
    int jiw;
    int jix = 0;
    int jiy;
    int jiz = 0;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyGrid$1 */
    class C110291 implements OnItemClickListener {
        C110291() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(134307);
            if (i == AppBrandSmileyGrid.this.jiv.getCount() - 1) {
                if (AppBrandSmileyGrid.this.jir.jiK != null) {
                    AppBrandSmileyGrid.this.jir.jiK.aRg();
                }
                AppMethodBeat.m2505o(134307);
            } else if ((AppBrandSmileyGrid.this.jiy * (AppBrandSmileyGrid.this.jix - 1)) + i >= AppBrandSmileyGrid.this.jiw) {
                AppMethodBeat.m2505o(134307);
            } else {
                int c = (AppBrandSmileyGrid.this.jiy * (AppBrandSmileyGrid.this.jix - 1)) + i;
                if (AppBrandSmileyGrid.this.jir.jiK != null) {
                    AppBrandSmileyGrid.this.jir.jiK.append(AppBrandSmileyGrid.this.jir.aRr().mo43878qL(c));
                }
                AppMethodBeat.m2505o(134307);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyGrid$b */
    static final class C11030b {
        ImageView iqT;

        public C11030b(View view) {
            AppMethodBeat.m2504i(134310);
            this.iqT = (ImageView) view.findViewById(2131821503);
            AppMethodBeat.m2505o(134310);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyGrid$a */
    class C38604a extends BaseAdapter {
        private C38604a() {
        }

        /* synthetic */ C38604a(AppBrandSmileyGrid appBrandSmileyGrid, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.m2504i(134308);
            int d = AppBrandSmileyGrid.this.jix;
            AppMethodBeat.m2505o(134308);
            return d;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C11030b c11030b;
            AppMethodBeat.m2504i(134309);
            if (view == null || view.getTag() == null) {
                view = C5616v.m8409hu(new ContextThemeWrapper(AppBrandSmileyGrid.this.getContext(), C25738R.style.f10877hc)).inflate(2130968771, null);
                view.setLayoutParams(new LayoutParams(-1, ((AppBrandSmileyGrid.this.jir.jiL - C1338a.m2856al(AppBrandSmileyGrid.this.getContext(), C25738R.dimen.f9958le)) - C1338a.m2856al(AppBrandSmileyGrid.this.getContext(), C25738R.dimen.a15)) / AppBrandSmileyGrid.this.jiB));
                c11030b = new C11030b(view);
                view.setTag(c11030b);
            } else {
                c11030b = (C11030b) view.getTag();
            }
            if (i == getCount() - 1) {
                c11030b.iqT.setImageResource(C25738R.drawable.f6647l2);
                c11030b.iqT.setContentDescription(AppBrandSmileyGrid.this.getContext().getString(C25738R.string.b56));
            } else {
                int d = ((AppBrandSmileyGrid.this.jix - 1) * AppBrandSmileyGrid.this.jiy) + i;
                if (d > AppBrandSmileyGrid.this.jiw - 1) {
                    c11030b.iqT.setImageDrawable(null);
                } else {
                    c11030b.iqT.setImageDrawable(AppBrandSmileyGrid.this.jir.aRr().mo43876qJ(d));
                }
            }
            AppMethodBeat.m2505o(134309);
            return view;
        }
    }

    public AppBrandSmileyGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(134311);
        AppMethodBeat.m2505o(134311);
    }

    /* Access modifiers changed, original: 0000 */
    public int getRowSpacing() {
        return this.jiz;
    }

    public void setPanelManager(C27414c c27414c) {
        this.jir = c27414c;
    }
}
