package com.tencent.p177mm.plugin.sns.p520ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.Exif;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C39759h;
import com.tencent.p177mm.plugin.sns.p520ui.C43611v.C22145a;
import com.tencent.p177mm.sdk.p604g.p606b.C4946a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.ui.PreviewImageView */
public class PreviewImageView extends LinearLayout implements C43611v {
    private final Context context;
    private List<String> list = new ArrayList();
    private TableLayout rmd;
    private final Map<Integer, View> rme = new HashMap();
    private final Map<Integer, TableRow> rmf = new HashMap();
    private final int rmg = 4;
    private HashMap<String, Bitmap> rmh = new HashMap();
    private C22145a rmi;
    private boolean rmj = true;
    private boolean rmk = false;

    /* renamed from: com.tencent.mm.plugin.sns.ui.PreviewImageView$a */
    class C29114a extends C39759h<String, Integer, Boolean> {
        private ImageView cDh;
        private Bitmap fru;
        private String path;

        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.m2504i(38513);
            super.onPostExecute((Boolean) obj);
            if (!PreviewImageView.this.rmk && C29036i.m46072B(this.fru)) {
                PreviewImageView.this.rmh.put(this.path, this.fru);
                if (this.cDh.getTag() != null && (this.cDh.getTag() instanceof String) && this.cDh.getTag().equals(this.path)) {
                    this.cDh.setImageBitmap(this.fru);
                }
            }
            AppMethodBeat.m2505o(38513);
        }

        public C29114a(ImageView imageView, String str) {
            this.cDh = imageView;
            this.path = str;
        }

        public final C4946a cin() {
            AppMethodBeat.m2504i(38512);
            C4946a cnp = C13373af.cnp();
            AppMethodBeat.m2505o(38512);
            return cnp;
        }

        /* renamed from: dv */
        public final /* synthetic */ Object mo25905dv() {
            AppMethodBeat.m2504i(38514);
            if (PreviewImageView.this.rmk) {
                Boolean bool = Boolean.FALSE;
                AppMethodBeat.m2505o(38514);
                return bool;
            }
            this.fru = C5056d.m7659d(this.path, C13373af.cnN(), C13373af.cnN(), true);
            C4990ab.m7411d("MicroMsg.MMAsyncTask", "exifPath : %s degree : %d", this.path, Integer.valueOf(Exif.fromFile(this.path).getOrientationInDegree()));
            this.fru = C5056d.m7648b(this.fru, (float) r0);
            Object obj = Boolean.TRUE;
            AppMethodBeat.m2505o(38514);
            return obj;
        }
    }

    public PreviewImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(38515);
        this.context = context;
        init();
        AppMethodBeat.m2505o(38515);
    }

    public PreviewImageView(Context context) {
        super(context);
        AppMethodBeat.m2504i(38516);
        this.context = context;
        init();
        AppMethodBeat.m2505o(38516);
    }

    public void setIsShowAddImage(boolean z) {
        this.rmj = z;
    }

    public View getView() {
        return this;
    }

    public void setImageClick(C22145a c22145a) {
        this.rmi = c22145a;
    }

    private void init() {
        AppMethodBeat.m2504i(38517);
        this.rmd = (TableLayout) LayoutInflater.from(this.context).inflate(2130970792, this, true).findViewById(2131821019);
        AppMethodBeat.m2505o(38517);
    }

    public int getCount() {
        AppMethodBeat.m2504i(38518);
        int size = this.rme.size();
        AppMethodBeat.m2505o(38518);
        return size;
    }

    public final void clean() {
        AppMethodBeat.m2504i(38519);
        this.rmk = true;
        for (Bitmap bitmap : this.rmh.values()) {
            if (C29036i.m46072B(bitmap)) {
                bitmap.recycle();
            }
        }
        AppMethodBeat.m2505o(38519);
    }

    public final void setList$22875ea3(List<String> list) {
        AppMethodBeat.m2504i(38520);
        long currentTimeMillis = System.currentTimeMillis();
        if (list == null) {
            AppMethodBeat.m2505o(38520);
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
                        view = View.inflate(this.context, 2130970793, null);
                        this.rme.put(Integer.valueOf(i), view);
                    }
                    View view2 = view;
                    if (i == size - 1) {
                        obj = "";
                    } else {
                        String obj2 = (String) list.get(i);
                    }
                    ImageView imageView = (ImageView) view2.findViewById(2131822744);
                    if (i != size - 1) {
                        imageView.setBackgroundDrawable(null);
                        imageView.setTag(obj2);
                        imageView.setContentDescription(getContext().getString(C25738R.string.eld));
                        Bitmap bitmap = (Bitmap) this.rmh.get(obj2);
                        if (C29036i.m46072B(bitmap)) {
                            imageView.setImageBitmap(bitmap);
                        } else {
                            C4990ab.m7410d("MicroMsg.PreviewImageView", "bm is null");
                            new C29114a(imageView, obj2).mo62862u("");
                        }
                    } else if (this.rmj) {
                        imageView.setBackgroundResource(C25738R.drawable.a0r);
                        imageView.setContentDescription(getContext().getString(C25738R.string.eji));
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
            C4990ab.m7410d("MicroMsg.PreviewImageView", "initlist time : " + (System.currentTimeMillis() - currentTimeMillis));
            i2++;
            i = i3;
        }
        AppMethodBeat.m2505o(38520);
    }
}
