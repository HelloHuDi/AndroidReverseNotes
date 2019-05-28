package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
public class PreviewContactView extends LinearLayout {
    private final Context context;
    private List<String> list = new ArrayList();
    private TableLayout rmd;
    private final Map<Integer, View> rme = new HashMap();
    @SuppressLint({"UseSparseArrays"})
    private final Map<Integer, TableRow> rmf = new HashMap();
    private int rmg = 5;

    static abstract class a {
    }

    public PreviewContactView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(38509);
        this.context = context;
        this.rmd = (TableLayout) LayoutInflater.from(this.context).inflate(R.layout.aw3, this, true).findViewById(R.id.m5);
        AppMethodBeat.o(38509);
    }

    public void setLineNum(int i) {
        AppMethodBeat.i(38510);
        this.rmg = i;
        setList(this.list);
        AppMethodBeat.o(38510);
    }

    public void setImageClick(a aVar) {
    }

    public void setList(List<String> list) {
        AppMethodBeat.i(38511);
        if (list == null) {
            AppMethodBeat.o(38511);
            return;
        }
        this.list = list;
        this.rmd.removeAllViews();
        if (list.size() == 0) {
            AppMethodBeat.o(38511);
            return;
        }
        int size = list.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            TableRow tableRow;
            int i3;
            TableRow tableRow2 = (TableRow) this.rmf.get(Integer.valueOf(i));
            if (tableRow2 == null) {
                tableRow2 = new TableRow(this.context);
                this.rmf.put(Integer.valueOf(i), tableRow2);
                tableRow = tableRow2;
            } else {
                tableRow = tableRow2;
            }
            tableRow.removeAllViews();
            int i4 = 0;
            while (true) {
                i3 = i2;
                if (i4 >= this.rmg || i3 >= size) {
                    this.rmd.addView(tableRow);
                    i++;
                    i2 = i3;
                } else {
                    View view = (View) this.rme.get(Integer.valueOf(i3));
                    if (view == null) {
                        view = View.inflate(this.context, R.layout.aw2, null);
                        this.rme.put(Integer.valueOf(i3), view);
                    }
                    View view2 = view;
                    String str = (String) list.get(i3);
                    ImageView imageView = (ImageView) view2.findViewById(R.id.avg);
                    imageView.setBackgroundDrawable(null);
                    b.b(imageView, str);
                    view2.setTag(Integer.valueOf(0));
                    view2.setClickable(false);
                    tableRow.addView(view2);
                    i2 = i3 + 1;
                    i4++;
                }
            }
            this.rmd.addView(tableRow);
            i++;
            i2 = i3;
        }
        AppMethodBeat.o(38511);
    }
}
