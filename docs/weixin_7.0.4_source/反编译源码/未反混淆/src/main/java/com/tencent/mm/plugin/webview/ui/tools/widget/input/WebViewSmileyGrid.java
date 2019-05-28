package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.util.AttributeSet;
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
import com.tencent.mm.cb.e;
import com.tencent.mm.ui.v;

public class WebViewSmileyGrid extends GridView {
    OnItemClickListener arw = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.i(10104);
            if (i == WebViewSmileyGrid.this.uKA.getCount() - 1) {
                if (WebViewSmileyGrid.this.uKz.uKG != null) {
                    WebViewSmileyGrid.this.uKz.uKG.aRg();
                }
                AppMethodBeat.o(10104);
            } else if ((WebViewSmileyGrid.this.jiy * (WebViewSmileyGrid.this.jix - 1)) + i >= WebViewSmileyGrid.this.jiw) {
                AppMethodBeat.o(10104);
            } else {
                int c = (WebViewSmileyGrid.this.jiy * (WebViewSmileyGrid.this.jix - 1)) + i;
                if (WebViewSmileyGrid.this.uKz.uKG != null) {
                    com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel.a aVar = WebViewSmileyGrid.this.uKz.uKG;
                    WebViewSmileyGrid.this.uKz;
                    aVar.append(e.dqK().qL(c));
                }
                AppMethodBeat.o(10104);
            }
        }
    };
    int jiA = 0;
    int jiB = 0;
    int jiw;
    int jix = 0;
    int jiy;
    int jiz = 0;
    a uKA;
    private c uKz;

    static final class b {
        ImageView iqT;

        public b(View view) {
            AppMethodBeat.i(10107);
            this.iqT = (ImageView) view.findViewById(R.id.yw);
            AppMethodBeat.o(10107);
        }
    }

    class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(WebViewSmileyGrid webViewSmileyGrid, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(10105);
            int d = WebViewSmileyGrid.this.jix;
            AppMethodBeat.o(10105);
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
            AppMethodBeat.i(10106);
            if (view == null || view.getTag() == null) {
                view = v.hu(WebViewSmileyGrid.this.getContext()).inflate(R.layout.b7h, null);
                view.setLayoutParams(new LayoutParams(-1, ((WebViewSmileyGrid.this.uKz.jiL - com.tencent.mm.bz.a.al(WebViewSmileyGrid.this.getContext(), R.dimen.le)) - com.tencent.mm.bz.a.al(WebViewSmileyGrid.this.getContext(), R.dimen.a15)) / WebViewSmileyGrid.this.jiB));
                bVar = new b(view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            if (i == getCount() - 1) {
                bVar.iqT.setImageResource(R.drawable.l2);
                bVar.iqT.setContentDescription(WebViewSmileyGrid.this.getContext().getString(R.string.b56));
            } else {
                int d = ((WebViewSmileyGrid.this.jix - 1) * WebViewSmileyGrid.this.jiy) + i;
                if (d > WebViewSmileyGrid.this.jiw - 1) {
                    bVar.iqT.setImageDrawable(null);
                } else {
                    WebViewSmileyGrid.this.uKz;
                    bVar.iqT.setImageDrawable(e.dqK().qJ(d));
                }
            }
            AppMethodBeat.o(10106);
            return view;
        }
    }

    public WebViewSmileyGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(10108);
        AppMethodBeat.o(10108);
    }

    /* Access modifiers changed, original: 0000 */
    public int getRowSpacing() {
        return this.jiz;
    }

    public void setPanelManager(c cVar) {
        this.uKz = cVar;
    }
}
