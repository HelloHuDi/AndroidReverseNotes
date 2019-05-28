package com.tencent.p177mm.plugin.sns.p520ui.previewimageview;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.Exif;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C39759h;
import com.tencent.p177mm.plugin.sns.storage.C13478s;
import com.tencent.p177mm.sdk.p604g.p606b.C4946a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.c */
public final class C13702c extends C36818b {
    private int rKL;
    private boolean rKM;
    private boolean rKN;
    C4087a rKO;
    private int rKP = 0;
    private HashMap<String, Bitmap> rmh = new HashMap();
    boolean rmk;

    /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.c$a */
    public interface C4087a {
        /* renamed from: fu */
        void mo8949fu(int i, int i2);

        void removeItem(int i);
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.c$b */
    class C13703b {
        ImageView cAw;
        View view;

        /* synthetic */ C13703b(C13702c c13702c, View view, byte b) {
            this(view);
        }

        private C13703b(View view) {
            AppMethodBeat.m2504i(40301);
            this.view = view;
            this.cAw = (ImageView) view.findViewById(2131822744);
            AppMethodBeat.m2505o(40301);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.c$c */
    class C13704c extends C39759h<String, Integer, Boolean> {
        private ImageView cDh;
        private Bitmap fru;
        private String path;

        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.m2504i(40303);
            super.onPostExecute((Boolean) obj);
            if (!C13702c.this.rmk && C29036i.m46072B(this.fru)) {
                C13702c.this.rmh.put(this.path, this.fru);
                if (this.cDh.getTag() != null && (this.cDh.getTag() instanceof String) && this.cDh.getTag().equals(this.path)) {
                    this.cDh.setImageBitmap(this.fru);
                }
            }
            AppMethodBeat.m2505o(40303);
        }

        public C13704c(ImageView imageView, String str) {
            this.cDh = imageView;
            this.path = str;
        }

        public final C4946a cin() {
            AppMethodBeat.m2504i(40302);
            C4946a cnp = C13373af.cnp();
            AppMethodBeat.m2505o(40302);
            return cnp;
        }

        /* renamed from: dv */
        public final /* synthetic */ Object mo25905dv() {
            AppMethodBeat.m2504i(40304);
            if (C13702c.this.rmk) {
                Boolean bool = Boolean.FALSE;
                AppMethodBeat.m2505o(40304);
                return bool;
            }
            this.fru = C5056d.m7659d(this.path, C13373af.cnN(), C13373af.cnN(), true);
            C4990ab.m7411d("MicroMsg.MMAsyncTask", "exifPath : %s degree : %d", this.path, Integer.valueOf(Exif.fromFile(this.path).getOrientationInDegree()));
            this.fru = C5056d.m7648b(this.fru, (float) r0);
            Object obj = Boolean.TRUE;
            AppMethodBeat.m2505o(40304);
            return obj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.c$d */
    class C13705d {
        public Object data;
        /* renamed from: id */
        public int f2939id;

        private C13705d() {
        }

        /* synthetic */ C13705d(C13702c c13702c, byte b) {
            this();
        }

        public final String toString() {
            AppMethodBeat.m2504i(40305);
            String obj = this.data.toString();
            AppMethodBeat.m2505o(40305);
            return obj;
        }

        public final int hashCode() {
            return this.f2939id;
        }
    }

    public C13702c(Context context, List<?> list, boolean z, C4087a c4087a) {
        super(context);
        AppMethodBeat.m2504i(40306);
        super.mo25899dy(m21899dz(list));
        this.rKL = 9;
        this.rKM = z;
        this.rKO = c4087a;
        cuY();
        cuZ();
        AppMethodBeat.m2505o(40306);
    }

    /* renamed from: dz */
    private List<C13705d> m21899dz(List<?> list) {
        AppMethodBeat.m2504i(40307);
        ArrayList arrayList = new ArrayList(list.size());
        int i = 0;
        for (Object next : list) {
            C13705d c13705d = new C13705d(this, (byte) 0);
            c13705d.data = next;
            int i2 = i + 1;
            c13705d.f2939id = i;
            arrayList.add(c13705d);
            i = i2;
        }
        AppMethodBeat.m2505o(40307);
        return arrayList;
    }

    public final void cuZ() {
        AppMethodBeat.m2504i(40309);
        C4990ab.m7419v("DynamicGridAdapter", "showAddImg %s, getCount %d, getHeaderCount %d, maxShowCount %d， showing %s", Boolean.valueOf(this.rKM), Integer.valueOf(getCount()), Integer.valueOf(this.rKK), Integer.valueOf(this.rKL), Boolean.valueOf(this.rKN));
        if (!this.rKM || cva() >= this.rKL) {
            this.rKN = false;
        } else if (!this.rKN) {
            this.rKN = true;
            add("");
            AppMethodBeat.m2505o(40309);
            return;
        }
        AppMethodBeat.m2505o(40309);
    }

    public final void clear() {
        AppMethodBeat.m2504i(40310);
        super.clear();
        this.rKN = false;
        AppMethodBeat.m2505o(40310);
    }

    /* renamed from: dy */
    public final void mo25899dy(List<?> list) {
        AppMethodBeat.m2504i(40311);
        super.mo25899dy(m21899dz(list));
        cuY();
        cuZ();
        AppMethodBeat.m2505o(40311);
    }

    public final int cva() {
        AppMethodBeat.m2504i(40312);
        int count = (getCount() - this.rKK) - (this.rKN ? 1 : 0);
        AppMethodBeat.m2505o(40312);
        return count;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C13703b c13703b;
        int screenWidth;
        AppMethodBeat.m2504i(40313);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(2130970793, viewGroup, false);
            c13703b = new C13703b(this, view, (byte) 0);
            view.setTag(2131820631, c13703b);
            ImageView imageView = c13703b.cAw;
            if (this.rKP == 0) {
                C13373af.cnu();
                screenWidth = C13478s.getScreenWidth();
                if (screenWidth != 0) {
                    this.rKP = ((screenWidth - (this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.a9l) * 4)) - (this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9951l8) * 2)) / 3;
                }
            }
            LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
            layoutParams.width = this.rKP;
            layoutParams.height = this.rKP;
            imageView.setLayoutParams(layoutParams);
        } else {
            c13703b = (C13703b) view.getTag(2131820631);
        }
        String obj = getItem(i).toString();
        ImageView imageView2 = c13703b.cAw;
        if (TextUtils.isEmpty(obj)) {
            imageView2.setBackgroundResource(C25738R.color.a16);
            imageView2.setImageResource(C1318a.album_post_add_picture_btn);
            imageView2.setContentDescription(c13703b.cAw.getContext().getString(C25738R.string.eji));
            screenWidth = (C13702c.this.rKP * 35) / 100;
            imageView2.setPadding(screenWidth, screenWidth, screenWidth, screenWidth);
            if (i > 0) {
                c13703b.view.setTag(Integer.valueOf(-1));
            } else if (i < C13702c.this.rKK) {
                c13703b.view.setTag(Integer.valueOf(BaseClientBuilder.API_PRIORITY_OTHER));
            }
        } else {
            c13703b.view.setTag(Integer.valueOf(i - C13702c.this.rKK));
            imageView2.setBackgroundDrawable(null);
            imageView2.setTag(obj);
            imageView2.setContentDescription(c13703b.cAw.getContext().getString(C25738R.string.eld));
            imageView2.setPadding(0, 0, 0, 0);
            Bitmap bitmap = (Bitmap) C13702c.this.rmh.get(obj);
            if (C29036i.m46072B(bitmap)) {
                imageView2.setImageBitmap(bitmap);
            } else {
                new C13704c(imageView2, obj).mo62862u("");
            }
        }
        if (i < this.rKK) {
            c13703b.cAw.setVisibility(4);
        } else {
            c13703b.cAw.setVisibility(0);
            view.setVisibility(0);
        }
        AppMethodBeat.m2505o(40313);
        return view;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(40314);
        if (TextUtils.isEmpty(getItem(i).toString())) {
            AppMethodBeat.m2505o(40314);
            return 1;
        }
        AppMethodBeat.m2505o(40314);
        return 0;
    }

    public final int getViewTypeCount() {
        return 2;
    }

    /* renamed from: fB */
    public final void mo25900fB(int i, int i2) {
        AppMethodBeat.m2504i(40317);
        super.mo25900fB(i, i2);
        if (this.rKO != null) {
            this.rKO.mo8949fu(i - this.rKK, i2 - this.rKK);
        }
        AppMethodBeat.m2505o(40317);
    }

    private void cuY() {
        AppMethodBeat.m2504i(40308);
        for (int i = 0; i < this.rKK; i++) {
            C13705d c13705d = new C13705d(this, (byte) 0);
            c13705d.data = "";
            c13705d.f2939id = getCount();
            c13705d.f2939id = getCount();
            add(i, c13705d);
        }
        AppMethodBeat.m2505o(40308);
    }

    /* renamed from: Es */
    public final boolean mo25894Es(int i) {
        AppMethodBeat.m2504i(40315);
        if (i < this.rKK) {
            AppMethodBeat.m2505o(40315);
            return false;
        } else if (!this.rKN) {
            boolean Es = super.mo25894Es(i);
            AppMethodBeat.m2505o(40315);
            return Es;
        } else if (i != getCount() - 1) {
            AppMethodBeat.m2505o(40315);
            return true;
        } else {
            AppMethodBeat.m2505o(40315);
            return false;
        }
    }

    /* renamed from: Et */
    public final boolean mo25895Et(int i) {
        AppMethodBeat.m2504i(40316);
        if (i < this.rKK) {
            AppMethodBeat.m2505o(40316);
            return false;
        } else if (!this.rKN) {
            boolean Et = super.mo25895Et(i);
            AppMethodBeat.m2505o(40316);
            return Et;
        } else if (i != getCount() - 1) {
            AppMethodBeat.m2505o(40316);
            return true;
        } else {
            AppMethodBeat.m2505o(40316);
            return false;
        }
    }
}
