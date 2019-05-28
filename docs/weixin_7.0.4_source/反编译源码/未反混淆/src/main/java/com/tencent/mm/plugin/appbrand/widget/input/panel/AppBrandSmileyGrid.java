package com.tencent.mm.plugin.appbrand.widget.input.panel;

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
import com.tencent.mm.R;
import com.tencent.mm.ui.v;

public class AppBrandSmileyGrid extends GridView {
    OnItemClickListener arw = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.i(134307);
            if (i == AppBrandSmileyGrid.this.jiv.getCount() - 1) {
                if (AppBrandSmileyGrid.this.jir.jiK != null) {
                    AppBrandSmileyGrid.this.jir.jiK.aRg();
                }
                AppMethodBeat.o(134307);
            } else if ((AppBrandSmileyGrid.this.jiy * (AppBrandSmileyGrid.this.jix - 1)) + i >= AppBrandSmileyGrid.this.jiw) {
                AppMethodBeat.o(134307);
            } else {
                int c = (AppBrandSmileyGrid.this.jiy * (AppBrandSmileyGrid.this.jix - 1)) + i;
                if (AppBrandSmileyGrid.this.jir.jiK != null) {
                    AppBrandSmileyGrid.this.jir.jiK.append(AppBrandSmileyGrid.this.jir.aRr().qL(c));
                }
                AppMethodBeat.o(134307);
            }
        }
    };
    int jiA = 0;
    int jiB = 0;
    private c jir;
    a jiv;
    int jiw;
    int jix = 0;
    int jiy;
    int jiz = 0;

    static final class b {
        ImageView iqT;

        public b(View view) {
            AppMethodBeat.i(134310);
            this.iqT = (ImageView) view.findViewById(R.id.yw);
            AppMethodBeat.o(134310);
        }
    }

    class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(AppBrandSmileyGrid appBrandSmileyGrid, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(134308);
            int d = AppBrandSmileyGrid.this.jix;
            AppMethodBeat.o(134308);
            return d;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            AppMethodBeat.i(134309);
            if (view == null || view.getTag() == null) {
                view = v.hu(new ContextThemeWrapper(AppBrandSmileyGrid.this.getContext(), R.style.hc)).inflate(R.layout.ek, null);
                view.setLayoutParams(new LayoutParams(-1, ((AppBrandSmileyGrid.this.jir.jiL - com.tencent.mm.bz.a.al(AppBrandSmileyGrid.this.getContext(), R.dimen.le)) - com.tencent.mm.bz.a.al(AppBrandSmileyGrid.this.getContext(), R.dimen.a15)) / AppBrandSmileyGrid.this.jiB));
                bVar = new b(view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            if (i == getCount() - 1) {
                bVar.iqT.setImageResource(R.drawable.l2);
                bVar.iqT.setContentDescription(AppBrandSmileyGrid.this.getContext().getString(R.string.b56));
            } else {
                int d = ((AppBrandSmileyGrid.this.jix - 1) * AppBrandSmileyGrid.this.jiy) + i;
                if (d > AppBrandSmileyGrid.this.jiw - 1) {
                    bVar.iqT.setImageDrawable(null);
                } else {
                    bVar.iqT.setImageDrawable(AppBrandSmileyGrid.this.jir.aRr().qJ(d));
                }
            }
            AppMethodBeat.o(134309);
            return view;
        }
    }

    public AppBrandSmileyGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(134311);
        AppMethodBeat.o(134311);
    }

    /* Access modifiers changed, original: 0000 */
    public int getRowSpacing() {
        return this.jiz;
    }

    public void setPanelManager(c cVar) {
        this.jir = cVar;
    }
}
