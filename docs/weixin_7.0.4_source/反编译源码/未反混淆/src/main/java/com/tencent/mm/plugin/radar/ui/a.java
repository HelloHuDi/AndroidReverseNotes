package com.tencent.mm.plugin.radar.ui;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableRow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH&J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\bH&J\u001a\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\bH&J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001b\u001a\u00020\u0011R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/GridDataAdapter;", "", "mGridView", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "mContext", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;Landroid/content/Context;)V", "count", "", "getCount", "()I", "mColumn", "getMContext", "()Landroid/content/Context;", "getMGridView", "()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "fillDataToTable", "", "getChanged", "", "position", "getItem", "getView", "Landroid/view/View;", "convertView", "makeRow", "Landroid/widget/TableRow;", "notifyDataChanged", "Companion", "plugin-radar_release"})
public abstract class a {
    private static final String TAG = TAG;
    public static final a pCa = new a();
    private final Context mContext;
    private int pBY = 3;
    final RadarSpecialGridView pBZ;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements OnClickListener {
        final /* synthetic */ int exi;
        final /* synthetic */ a pCb;

        b(a aVar, int i) {
            this.pCb = aVar;
            this.exi = i;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(102940);
            com.tencent.mm.plugin.radar.ui.RadarSpecialGridView.a onItemClickListener = this.pCb.pBZ.getOnItemClickListener();
            if (onItemClickListener != null) {
                int i = this.exi;
                j.o(view, "v");
                onItemClickListener.f(i, view);
                AppMethodBeat.o(102940);
                return;
            }
            AppMethodBeat.o(102940);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/GridDataAdapter$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public abstract View Y(View view, int i);

    public abstract int getCount();

    public a(RadarSpecialGridView radarSpecialGridView, Context context) {
        j.p(radarSpecialGridView, "mGridView");
        j.p(context, "mContext");
        this.pBZ = radarSpecialGridView;
        this.mContext = context;
    }

    public final void aPw() {
        if (this.pBY == 0) {
            ab.e(TAG, "column is 0, pls check!");
            return;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            TableRow tableRow;
            int i2;
            int i3 = i / this.pBY;
            int childCount = this.pBZ.getMTable().getChildCount();
            if (childCount > i3) {
                View childAt = this.pBZ.getMTable().getChildAt((childCount - 1) - i3);
                if (childAt == null) {
                    throw new v("null cannot be cast to non-null type android.widget.TableRow");
                }
                tableRow = (TableRow) childAt;
            } else {
                TableRow tableRow2 = new TableRow(this.mContext);
                tableRow2.setLayoutParams(new LayoutParams(-1, -2));
                this.pBZ.getMTable().addView(tableRow2, 0);
                tableRow = tableRow2;
            }
            int i4 = i % this.pBY;
            int childCount2 = tableRow.getChildCount();
            if (childCount2 <= i4) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            View view = null;
            i4 = (childCount2 - 1) - i4;
            if (i2 == 0) {
                view = tableRow.getChildAt(i4);
            }
            View Y = Y(view, i);
            if (i2 != 0) {
                tableRow.addView(Y, 0);
            } else if (Y != view) {
                tableRow.removeViewAt(i4);
                tableRow.addView(Y, i4);
            }
            Y.setOnClickListener(new b(this, i));
        }
        ab.v(TAG, "mTable rows count : " + this.pBZ.getMTable().getChildCount());
    }
}
