package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.h;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class c extends b {
    private int rKL;
    private boolean rKM;
    private boolean rKN;
    a rKO;
    private int rKP = 0;
    private HashMap<String, Bitmap> rmh = new HashMap();
    boolean rmk;

    public interface a {
        void fu(int i, int i2);

        void removeItem(int i);
    }

    class b {
        ImageView cAw;
        View view;

        /* synthetic */ b(c cVar, View view, byte b) {
            this(view);
        }

        private b(View view) {
            AppMethodBeat.i(40301);
            this.view = view;
            this.cAw = (ImageView) view.findViewById(R.id.avg);
            AppMethodBeat.o(40301);
        }
    }

    class c extends h<String, Integer, Boolean> {
        private ImageView cDh;
        private Bitmap fru;
        private String path;

        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.i(40303);
            super.onPostExecute((Boolean) obj);
            if (!c.this.rmk && i.B(this.fru)) {
                c.this.rmh.put(this.path, this.fru);
                if (this.cDh.getTag() != null && (this.cDh.getTag() instanceof String) && this.cDh.getTag().equals(this.path)) {
                    this.cDh.setImageBitmap(this.fru);
                }
            }
            AppMethodBeat.o(40303);
        }

        public c(ImageView imageView, String str) {
            this.cDh = imageView;
            this.path = str;
        }

        public final com.tencent.mm.sdk.g.b.a cin() {
            AppMethodBeat.i(40302);
            com.tencent.mm.sdk.g.b.a cnp = af.cnp();
            AppMethodBeat.o(40302);
            return cnp;
        }

        public final /* synthetic */ Object dv() {
            AppMethodBeat.i(40304);
            if (c.this.rmk) {
                Boolean bool = Boolean.FALSE;
                AppMethodBeat.o(40304);
                return bool;
            }
            this.fru = com.tencent.mm.sdk.platformtools.d.d(this.path, af.cnN(), af.cnN(), true);
            ab.d("MicroMsg.MMAsyncTask", "exifPath : %s degree : %d", this.path, Integer.valueOf(Exif.fromFile(this.path).getOrientationInDegree()));
            this.fru = com.tencent.mm.sdk.platformtools.d.b(this.fru, (float) r0);
            Object obj = Boolean.TRUE;
            AppMethodBeat.o(40304);
            return obj;
        }
    }

    class d {
        public Object data;
        public int id;

        private d() {
        }

        /* synthetic */ d(c cVar, byte b) {
            this();
        }

        public final String toString() {
            AppMethodBeat.i(40305);
            String obj = this.data.toString();
            AppMethodBeat.o(40305);
            return obj;
        }

        public final int hashCode() {
            return this.id;
        }
    }

    public c(Context context, List<?> list, boolean z, a aVar) {
        super(context);
        AppMethodBeat.i(40306);
        super.dy(dz(list));
        this.rKL = 9;
        this.rKM = z;
        this.rKO = aVar;
        cuY();
        cuZ();
        AppMethodBeat.o(40306);
    }

    private List<d> dz(List<?> list) {
        AppMethodBeat.i(40307);
        ArrayList arrayList = new ArrayList(list.size());
        int i = 0;
        for (Object next : list) {
            d dVar = new d(this, (byte) 0);
            dVar.data = next;
            int i2 = i + 1;
            dVar.id = i;
            arrayList.add(dVar);
            i = i2;
        }
        AppMethodBeat.o(40307);
        return arrayList;
    }

    public final void cuZ() {
        AppMethodBeat.i(40309);
        ab.v("DynamicGridAdapter", "showAddImg %s, getCount %d, getHeaderCount %d, maxShowCount %d， showing %s", Boolean.valueOf(this.rKM), Integer.valueOf(getCount()), Integer.valueOf(this.rKK), Integer.valueOf(this.rKL), Boolean.valueOf(this.rKN));
        if (!this.rKM || cva() >= this.rKL) {
            this.rKN = false;
        } else if (!this.rKN) {
            this.rKN = true;
            add("");
            AppMethodBeat.o(40309);
            return;
        }
        AppMethodBeat.o(40309);
    }

    public final void clear() {
        AppMethodBeat.i(40310);
        super.clear();
        this.rKN = false;
        AppMethodBeat.o(40310);
    }

    public final void dy(List<?> list) {
        AppMethodBeat.i(40311);
        super.dy(dz(list));
        cuY();
        cuZ();
        AppMethodBeat.o(40311);
    }

    public final int cva() {
        AppMethodBeat.i(40312);
        int count = (getCount() - this.rKK) - (this.rKN ? 1 : 0);
        AppMethodBeat.o(40312);
        return count;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int screenWidth;
        AppMethodBeat.i(40313);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.aw4, viewGroup, false);
            bVar = new b(this, view, (byte) 0);
            view.setTag(R.id.bn, bVar);
            ImageView imageView = bVar.cAw;
            if (this.rKP == 0) {
                af.cnu();
                screenWidth = s.getScreenWidth();
                if (screenWidth != 0) {
                    this.rKP = ((screenWidth - (this.mContext.getResources().getDimensionPixelSize(R.dimen.a9l) * 4)) - (this.mContext.getResources().getDimensionPixelSize(R.dimen.l8) * 2)) / 3;
                }
            }
            LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
            layoutParams.width = this.rKP;
            layoutParams.height = this.rKP;
            imageView.setLayoutParams(layoutParams);
        } else {
            bVar = (b) view.getTag(R.id.bn);
        }
        String obj = getItem(i).toString();
        ImageView imageView2 = bVar.cAw;
        if (TextUtils.isEmpty(obj)) {
            imageView2.setBackgroundResource(R.color.a16);
            imageView2.setImageResource(R.raw.album_post_add_picture_btn);
            imageView2.setContentDescription(bVar.cAw.getContext().getString(R.string.eji));
            screenWidth = (c.this.rKP * 35) / 100;
            imageView2.setPadding(screenWidth, screenWidth, screenWidth, screenWidth);
            if (i > 0) {
                bVar.view.setTag(Integer.valueOf(-1));
            } else if (i < c.this.rKK) {
                bVar.view.setTag(Integer.valueOf(BaseClientBuilder.API_PRIORITY_OTHER));
            }
        } else {
            bVar.view.setTag(Integer.valueOf(i - c.this.rKK));
            imageView2.setBackgroundDrawable(null);
            imageView2.setTag(obj);
            imageView2.setContentDescription(bVar.cAw.getContext().getString(R.string.eld));
            imageView2.setPadding(0, 0, 0, 0);
            Bitmap bitmap = (Bitmap) c.this.rmh.get(obj);
            if (i.B(bitmap)) {
                imageView2.setImageBitmap(bitmap);
            } else {
                new c(imageView2, obj).u("");
            }
        }
        if (i < this.rKK) {
            bVar.cAw.setVisibility(4);
        } else {
            bVar.cAw.setVisibility(0);
            view.setVisibility(0);
        }
        AppMethodBeat.o(40313);
        return view;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(40314);
        if (TextUtils.isEmpty(getItem(i).toString())) {
            AppMethodBeat.o(40314);
            return 1;
        }
        AppMethodBeat.o(40314);
        return 0;
    }

    public final int getViewTypeCount() {
        return 2;
    }

    public final void fB(int i, int i2) {
        AppMethodBeat.i(40317);
        super.fB(i, i2);
        if (this.rKO != null) {
            this.rKO.fu(i - this.rKK, i2 - this.rKK);
        }
        AppMethodBeat.o(40317);
    }

    private void cuY() {
        AppMethodBeat.i(40308);
        for (int i = 0; i < this.rKK; i++) {
            d dVar = new d(this, (byte) 0);
            dVar.data = "";
            dVar.id = getCount();
            dVar.id = getCount();
            add(i, dVar);
        }
        AppMethodBeat.o(40308);
    }

    public final boolean Es(int i) {
        AppMethodBeat.i(40315);
        if (i < this.rKK) {
            AppMethodBeat.o(40315);
            return false;
        } else if (!this.rKN) {
            boolean Es = super.Es(i);
            AppMethodBeat.o(40315);
            return Es;
        } else if (i != getCount() - 1) {
            AppMethodBeat.o(40315);
            return true;
        } else {
            AppMethodBeat.o(40315);
            return false;
        }
    }

    public final boolean Et(int i) {
        AppMethodBeat.i(40316);
        if (i < this.rKK) {
            AppMethodBeat.o(40316);
            return false;
        } else if (!this.rKN) {
            boolean Et = super.Et(i);
            AppMethodBeat.o(40316);
            return Et;
        } else if (i != getCount() - 1) {
            AppMethodBeat.o(40316);
            return true;
        } else {
            AppMethodBeat.o(40316);
            return false;
        }
    }
}
