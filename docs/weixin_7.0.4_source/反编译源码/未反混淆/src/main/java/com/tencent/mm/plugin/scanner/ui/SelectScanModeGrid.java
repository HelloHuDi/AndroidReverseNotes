package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public class SelectScanModeGrid extends GridView {

    public static class a extends BaseAdapter {
        private Context context;
        private List<b> itemList;
        int qgq = -1;

        static class a {
            public TextView piD;
            public TextView qgr;
            public ImageView qgs;

            a() {
            }
        }

        public a(Context context, List<b> list) {
            AppMethodBeat.i(81327);
            this.context = context;
            this.itemList = list;
            ab.d("MicroMsg.scanner.SelectScanModeGroupAdapter", "<init> list size = " + this.itemList.size());
            AppMethodBeat.o(81327);
        }

        public final int getCount() {
            AppMethodBeat.i(81328);
            int size = this.itemList.size();
            AppMethodBeat.o(81328);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(81329);
            if (i < 0 || i >= this.itemList.size()) {
                ab.e("MicroMsg.scanner.SelectScanModeGroupAdapter", "getItem fail, invalid position = ".concat(String.valueOf(i)));
                AppMethodBeat.o(81329);
                return null;
            }
            Object obj = this.itemList.get(i);
            AppMethodBeat.o(81329);
            return obj;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(81330);
            if (view == null) {
                view = View.inflate(this.context, R.layout.aqy, null);
                aVar = new a();
                aVar.qgr = (TextView) view.findViewById(R.id.e8f);
                aVar.piD = (TextView) view.findViewById(R.id.e8g);
                aVar.qgs = (ImageView) view.findViewById(R.id.e8h);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            if (i == viewGroup.getChildCount()) {
                b bVar = (b) getItem(i);
                if (bVar == null) {
                    ab.e("MicroMsg.scanner.SelectScanModeGroupAdapter", "getView fail, item is null");
                    AppMethodBeat.o(81330);
                    return view;
                }
                aVar.piD.setText(bVar.title);
                if (i == this.qgq) {
                    aVar.qgr.setBackgroundResource(bVar.qgu);
                } else {
                    aVar.qgr.setBackgroundResource(bVar.qgt);
                }
                bVar.qgw = aVar.qgr;
                if (bVar.qgx) {
                    aVar.qgs.setVisibility(0);
                } else {
                    aVar.qgs.setVisibility(4);
                }
            }
            AppMethodBeat.o(81330);
            return view;
        }
    }

    public static class b {
        public int qgt;
        public int qgu;
        public int qgv;
        public TextView qgw;
        public boolean qgx;
        public String title;

        public b(String str, int i, int i2, int i3, boolean z) {
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
