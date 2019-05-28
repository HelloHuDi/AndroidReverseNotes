package com.tencent.p177mm.plugin.webview.p580ui.tools.widget.input;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p211cb.C26003e;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.input.WebViewSmileyPanel.C4658a;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyGrid */
public class WebViewSmileyGrid extends GridView {
    OnItemClickListener arw = new C299651();
    int jiA = 0;
    int jiB = 0;
    int jiw;
    int jix = 0;
    int jiy;
    int jiz = 0;
    C29964a uKA;
    private C14685c uKz;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyGrid$b */
    static final class C14684b {
        ImageView iqT;

        public C14684b(View view) {
            AppMethodBeat.m2504i(10107);
            this.iqT = (ImageView) view.findViewById(2131821503);
            AppMethodBeat.m2505o(10107);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyGrid$a */
    class C29964a extends BaseAdapter {
        private C29964a() {
        }

        /* synthetic */ C29964a(WebViewSmileyGrid webViewSmileyGrid, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.m2504i(10105);
            int d = WebViewSmileyGrid.this.jix;
            AppMethodBeat.m2505o(10105);
            return d;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C14684b c14684b;
            AppMethodBeat.m2504i(10106);
            if (view == null || view.getTag() == null) {
                view = C5616v.m8409hu(WebViewSmileyGrid.this.getContext()).inflate(2130971218, null);
                view.setLayoutParams(new LayoutParams(-1, ((WebViewSmileyGrid.this.uKz.jiL - C1338a.m2856al(WebViewSmileyGrid.this.getContext(), C25738R.dimen.f9958le)) - C1338a.m2856al(WebViewSmileyGrid.this.getContext(), C25738R.dimen.a15)) / WebViewSmileyGrid.this.jiB));
                c14684b = new C14684b(view);
                view.setTag(c14684b);
            } else {
                c14684b = (C14684b) view.getTag();
            }
            if (i == getCount() - 1) {
                c14684b.iqT.setImageResource(C25738R.drawable.f6647l2);
                c14684b.iqT.setContentDescription(WebViewSmileyGrid.this.getContext().getString(C25738R.string.b56));
            } else {
                int d = ((WebViewSmileyGrid.this.jix - 1) * WebViewSmileyGrid.this.jiy) + i;
                if (d > WebViewSmileyGrid.this.jiw - 1) {
                    c14684b.iqT.setImageDrawable(null);
                } else {
                    WebViewSmileyGrid.this.uKz;
                    c14684b.iqT.setImageDrawable(C26003e.dqK().mo43876qJ(d));
                }
            }
            AppMethodBeat.m2505o(10106);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyGrid$1 */
    class C299651 implements OnItemClickListener {
        C299651() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(10104);
            if (i == WebViewSmileyGrid.this.uKA.getCount() - 1) {
                if (WebViewSmileyGrid.this.uKz.uKG != null) {
                    WebViewSmileyGrid.this.uKz.uKG.aRg();
                }
                AppMethodBeat.m2505o(10104);
            } else if ((WebViewSmileyGrid.this.jiy * (WebViewSmileyGrid.this.jix - 1)) + i >= WebViewSmileyGrid.this.jiw) {
                AppMethodBeat.m2505o(10104);
            } else {
                int c = (WebViewSmileyGrid.this.jiy * (WebViewSmileyGrid.this.jix - 1)) + i;
                if (WebViewSmileyGrid.this.uKz.uKG != null) {
                    C4658a c4658a = WebViewSmileyGrid.this.uKz.uKG;
                    WebViewSmileyGrid.this.uKz;
                    c4658a.append(C26003e.dqK().mo43878qL(c));
                }
                AppMethodBeat.m2505o(10104);
            }
        }
    }

    public WebViewSmileyGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(10108);
        AppMethodBeat.m2505o(10108);
    }

    /* Access modifiers changed, original: 0000 */
    public int getRowSpacing() {
        return this.jiz;
    }

    public void setPanelManager(C14685c c14685c) {
        this.uKz = c14685c;
    }
}
