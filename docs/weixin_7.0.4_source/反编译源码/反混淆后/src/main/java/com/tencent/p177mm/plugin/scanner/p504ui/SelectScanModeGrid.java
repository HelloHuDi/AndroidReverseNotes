package com.tencent.p177mm.plugin.scanner.p504ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid */
public class SelectScanModeGrid extends GridView {

    /* renamed from: com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid$a */
    public static class C13147a extends BaseAdapter {
        private Context context;
        private List<C13149b> itemList;
        int qgq = -1;

        /* renamed from: com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid$a$a */
        static class C13148a {
            public TextView piD;
            public TextView qgr;
            public ImageView qgs;

            C13148a() {
            }
        }

        public C13147a(Context context, List<C13149b> list) {
            AppMethodBeat.m2504i(81327);
            this.context = context;
            this.itemList = list;
            C4990ab.m7410d("MicroMsg.scanner.SelectScanModeGroupAdapter", "<init> list size = " + this.itemList.size());
            AppMethodBeat.m2505o(81327);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(81328);
            int size = this.itemList.size();
            AppMethodBeat.m2505o(81328);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(81329);
            if (i < 0 || i >= this.itemList.size()) {
                C4990ab.m7412e("MicroMsg.scanner.SelectScanModeGroupAdapter", "getItem fail, invalid position = ".concat(String.valueOf(i)));
                AppMethodBeat.m2505o(81329);
                return null;
            }
            Object obj = this.itemList.get(i);
            AppMethodBeat.m2505o(81329);
            return obj;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C13148a c13148a;
            AppMethodBeat.m2504i(81330);
            if (view == null) {
                view = View.inflate(this.context, 2130970603, null);
                c13148a = new C13148a();
                c13148a.qgr = (TextView) view.findViewById(2131827330);
                c13148a.piD = (TextView) view.findViewById(2131827331);
                c13148a.qgs = (ImageView) view.findViewById(2131827332);
                view.setTag(c13148a);
            } else {
                c13148a = (C13148a) view.getTag();
            }
            if (i == viewGroup.getChildCount()) {
                C13149b c13149b = (C13149b) getItem(i);
                if (c13149b == null) {
                    C4990ab.m7412e("MicroMsg.scanner.SelectScanModeGroupAdapter", "getView fail, item is null");
                    AppMethodBeat.m2505o(81330);
                    return view;
                }
                c13148a.piD.setText(c13149b.title);
                if (i == this.qgq) {
                    c13148a.qgr.setBackgroundResource(c13149b.qgu);
                } else {
                    c13148a.qgr.setBackgroundResource(c13149b.qgt);
                }
                c13149b.qgw = c13148a.qgr;
                if (c13149b.qgx) {
                    c13148a.qgs.setVisibility(0);
                } else {
                    c13148a.qgs.setVisibility(4);
                }
            }
            AppMethodBeat.m2505o(81330);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid$b */
    public static class C13149b {
        public int qgt;
        public int qgu;
        public int qgv;
        public TextView qgw;
        public boolean qgx;
        public String title;

        public C13149b(String str, int i, int i2, int i3, boolean z) {
            this.title = str;
            this.qgt = i;
            this.qgu = i2;
            this.qgv = i3;
            this.qgx = z;
        }
    }

    public SelectScanModeGrid(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SelectScanModeGrid(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
