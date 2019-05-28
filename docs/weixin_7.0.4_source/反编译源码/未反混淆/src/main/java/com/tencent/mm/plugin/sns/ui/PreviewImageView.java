package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PreviewImageView extends LinearLayout implements v {
    private final Context context;
    private List<String> list = new ArrayList();
    private TableLayout rmd;
    private final Map<Integer, View> rme = new HashMap();
    private final Map<Integer, TableRow> rmf = new HashMap();
    private final int rmg = 4;
    private HashMap<String, Bitmap> rmh = new HashMap();
    private com.tencent.mm.plugin.sns.ui.v.a rmi;
    private boolean rmj = true;
    private boolean rmk = false;

    class a extends h<String, Integer, Boolean> {
        private ImageView cDh;
        private Bitmap fru;
        private String path;

        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.i(38513);
            super.onPostExecute((Boolean) obj);
            if (!PreviewImageView.this.rmk && i.B(this.fru)) {
                PreviewImageView.this.rmh.put(this.path, this.fru);
                if (this.cDh.getTag() != null && (this.cDh.getTag() instanceof String) && this.cDh.getTag().equals(this.path)) {
                    this.cDh.setImageBitmap(this.fru);
                }
            }
            AppMethodBeat.o(38513);
        }

        public a(ImageView imageView, String str) {
            this.cDh = imageView;
            this.path = str;
        }

        public final com.tencent.mm.sdk.g.b.a cin() {
            AppMethodBeat.i(38512);
            com.tencent.mm.sdk.g.b.a cnp = af.cnp();
            AppMethodBeat.o(38512);
            return cnp;
        }

        public final /* synthetic */ Object dv() {
            AppMethodBeat.i(38514);
            if (PreviewImageView.this.rmk) {
                Boolean bool = Boolean.FALSE;
                AppMethodBeat.o(38514);
                return bool;
            }
            this.fru = d.d(this.path, af.cnN(), af.cnN(), true);
            ab.d("MicroMsg.MMAsyncTask", "exifPath : %s degree : %d", this.path, Integer.valueOf(Exif.fromFile(this.path).getOrientationInDegree()));
            this.fru = d.b(this.fru, (float) r0);
            Object obj = Boolean.TRUE;
            AppMethodBeat.o(38514);
            return obj;
        }
    }

    public PreviewImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(38515);
        this.context = context;
        init();
        AppMethodBeat.o(38515);
    }

    public PreviewImageView(Context context) {
        super(context);
        AppMethodBeat.i(38516);
        this.context = context;
        init();
        AppMethodBeat.o(38516);
    }

    public void setIsShowAddImage(boolean z) {
        this.rmj = z;
    }

    public View getView() {
        return this;
    }

    public void setImageClick(com.tencent.mm.plugin.sns.ui.v.a aVar) {
        this.rmi = aVar;
    }

    private void init() {
        AppMethodBeat.i(38517);
        this.rmd = (TableLayout) LayoutInflater.from(this.context).inflate(R.layout.aw3, this, true).findViewById(R.id.m5);
        AppMethodBeat.o(38517);
    }

    public int getCount() {
        AppMethodBeat.i(38518);
        int size = this.rme.size();
        AppMethodBeat.o(38518);
        return size;
    }

    public final void clean() {
        AppMethodBeat.i(38519);
        this.rmk = true;
        for (Bitmap bitmap : this.rmh.values()) {
            if (i.B(bitmap)) {
                bitmap.recycle();
            }
        }
        AppMethodBeat.o(38519);
    }

    public final void setList$22875ea3(List<String> list) {
        AppMethodBeat.i(38520);
        long currentTimeMillis = System.currentTimeMillis();
        if (list == null) {
            AppMethodBeat.o(38520);
            return;
        }
        this.list = list;
        int i = 0;
        this.rmd.removeAllViews();
        int size = list.size() + 1;
        int i2 = 0;
        while (i < size) {
            TableRow tableRow;
            TableRow tableRow2 = (TableRow) this.rmf.get(Integer.valueOf(i2));
            if (tableRow2 == null) {
                tableRow2 = new TableRow(this.context);
                this.rmf.put(Integer.valueOf(i2), tableRow2);
                tableRow = tableRow2;
            } else {
                tableRow = tableRow2;
            }
            tableRow.removeAllViews();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= 4 || i >= size) {
                    i3 = i;
                } else if (i >= 9) {
                    i3 = i + 1;
                    break;
                } else {
                    Object obj;
                    View view = (View) this.rme.get(Integer.valueOf(i));
                    if (view == null) {
                        view = View.inflate(this.context, R.layout.aw4, null);
                        this.rme.put(Integer.valueOf(i), view);
                    }
                    View view2 = view;
                    if (i == size - 1) {
                        obj = "";
                    } else {
                        String obj2 = (String) list.get(i);
                    }
                    ImageView imageView = (ImageView) view2.findViewById(R.id.avg);
                    if (i != size - 1) {
                        imageView.setBackgroundDrawable(null);
                        imageView.setTag(obj2);
                        imageView.setContentDescription(getContext().getString(R.string.eld));
                        Bitmap bitmap = (Bitmap) this.rmh.get(obj2);
                        if (i.B(bitmap)) {
                            imageView.setImageBitmap(bitmap);
                        } else {
                            ab.d("MicroMsg.PreviewImageView", "bm is null");
                            new a(imageView, obj2).u("");
                        }
                    } else if (this.rmj) {
                        imageView.setBackgroundResource(R.drawable.a0r);
                        imageView.setContentDescription(getContext().getString(R.string.eji));
                        imageView.setImageDrawable(null);
                    } else {
                        i3 = i4 + 1;
                        i++;
                    }
                    if (this.rmi != null) {
                        if (i == size - 1) {
                            view2.setTag(Integer.valueOf(-1));
                            view2.setOnClickListener(this.rmi.rjy);
                            view2.setClickable(true);
                        } else {
                            view2.setTag(Integer.valueOf(i));
                            view2.setOnClickListener(this.rmi.rjy);
                            view2.setClickable(true);
                        }
                    }
                    view2.setLayoutParams(new LayoutParams(-2, -2));
                    tableRow.addView(view2);
                    i3 = i4 + 1;
                    i++;
                }
            }
            if (tableRow.getChildCount() > 0) {
                this.rmd.addView(tableRow);
            }
            ab.d("MicroMsg.PreviewImageView", "initlist time : " + (System.currentTimeMillis() - currentTimeMillis));
            i2++;
            i = i3;
        }
        AppMethodBeat.o(38520);
    }
}
