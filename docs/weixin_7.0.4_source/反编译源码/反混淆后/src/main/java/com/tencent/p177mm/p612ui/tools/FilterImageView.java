package com.tencent.p177mm.p612ui.tools;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.MMHorList;
import com.tencent.p177mm.pointers.PIntArray;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;

/* renamed from: com.tencent.mm.ui.tools.FilterImageView */
public class FilterImageView extends LinearLayout {
    static C40882c[] zBY = new C40882c[]{new C40882c(new C40883b("原图", "原圖", "Normal"), "icon.png", 0, 0, "MatteOrigin.jpg", 0), new C40882c(new C40883b("LOMO", "LOMO", "LOMO"), "nuowei_mask%02d.jpg", 2, 1, "0004.jpg", 2), new C40882c(new C40883b("麦田", "麥田", "Wheat"), "0062_%02d.jpg", 2, 2, "0062.jpg", 20), new C40882c(new C40883b("玻璃镜", "玻璃鏡", "Glossy"), "habi_mask%02d.jpg", 1, 3, "0005.jpg", 4), new C40882c(new C40883b("拍立得", "拍立得", "Polaroid"), "0063_%02d.jpg", 2, 4, "0063.jpg", 21), new C40882c(new C40883b("湖水", "湖水", "Lake"), "0061_%02d.jpg", 1, 5, "0061.jpg", 19), new C40882c(new C40883b("黄昏", "黃昏", "Twilight"), "0030_mask%01d.jpg", 1, 6, "0030.jpg", 7), new C40882c(new C40883b("黑白", "黑白", "B&W"), "0065_%02d.jpg", 1, 7, "0065.jpg", 22), new C40882c(new C40883b("铜版画", "銅版畫", "Aquatint"), "0032_mask%01d.jpg", 1, 8, "0032.jpg", 9), new C40882c(new C40883b("圆珠笔", "圓珠筆", "Pen"), "0035_mask%01d.jpg", 1, 9, "0035.jpg", 18), new C40882c(new C40883b("海报", "海報", "Poster"), "0036_mask%01d.jpg", 0, 10, "0036.jpg", 17), new C40882c(new C40883b("素描", "素描", "Portrait"), "icon.jpg", 0, 11, "0040.jpg", 12)};
    private Activity czX;
    private int filterId = 0;
    int[] zBP;
    private View zBQ;
    private ImageView zBR;
    private CropImageView zBS;
    Bitmap zBT;
    private MMHorList zBU;
    private C40881a zBV;
    private Runnable zBW;
    private Runnable zBX;

    /* renamed from: com.tencent.mm.ui.tools.FilterImageView$1 */
    class C240261 implements OnItemClickListener {
        C240261() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(107627);
            C40881a a = FilterImageView.this.zBV;
            a.llU = i;
            a.notifyDataSetChanged();
            try {
                FilterImageView.this.filterId = FilterImageView.zBY[i].zCj;
                FilterImageView.m70845a(FilterImageView.this, FilterImageView.zBY[i].zCg, FilterImageView.zBY[i].zCh, FilterImageView.zBY[i].zCi);
                AppMethodBeat.m2505o(107627);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.FilterView", e.toString());
                C4990ab.printErrStackTrace("MicroMsg.FilterView", e, "", new Object[0]);
                AppMethodBeat.m2505o(107627);
            } catch (OutOfMemoryError e2) {
                C4990ab.m7412e("MicroMsg.FilterView", e2.toString());
                C4990ab.printErrStackTrace("MicroMsg.FilterView", e2, "", new Object[0]);
                AppMethodBeat.m2505o(107627);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.FilterImageView$a */
    class C40881a extends BaseAdapter {
        int llU = 0;

        /* renamed from: com.tencent.mm.ui.tools.FilterImageView$a$a */
        class C36330a {
            TextView exj;
            ImageView zCa;
            Bitmap zCb;

            C36330a() {
            }
        }

        C40881a() {
        }

        public final int getCount() {
            return FilterImageView.zBY.length;
        }

        public final Object getItem(int i) {
            return FilterImageView.zBY[i];
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C36330a c36330a;
            CharSequence charSequence;
            AppMethodBeat.m2504i(107628);
            C40882c c40882c = (C40882c) getItem(i);
            if (view == null || !(view.getTag() instanceof C36330a)) {
                view = View.inflate(FilterImageView.this.czX, 2130969549, null);
                C36330a c36330a2 = new C36330a();
                c36330a2.exj = (TextView) view.findViewById(2131824018);
                c36330a2.zCa = (ImageView) view.findViewById(2131824017);
                view.setTag(c36330a2);
                c36330a = c36330a2;
            } else {
                c36330a = (C36330a) view.getTag();
                if (c36330a.zCb != null) {
                    C4990ab.m7417i("MicroMsg.FilterView", "recycle bitmap:%s", c36330a.zCb.toString());
                    c36330a.zCb.recycle();
                }
            }
            TextView textView = c36330a.exj;
            C40883b c40883b = c40882c.zCf;
            String dor = C4988aa.dor();
            if (dor.equals("zh_CN")) {
                charSequence = c40883b.yVk;
            } else if (dor.equals("zh_TW") || dor.equals("zh_HK")) {
                charSequence = c40883b.zCd;
            } else {
                charSequence = c40883b.zCe;
            }
            textView.setText(charSequence);
            try {
                InputStream open = FilterImageView.this.czX.getAssets().open("filter/" + c40882c.cIY);
                c36330a.zCb = C5056d.decodeStream(open);
                open.close();
                c36330a.zCa.setImageBitmap(c36330a.zCb);
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.FilterView", e, "", new Object[0]);
            }
            view.setLayoutParams(new LayoutParams(-2, -2));
            if (i == this.llU) {
                view.findViewById(2131824017).setBackgroundResource(C25738R.drawable.abo);
            } else {
                view.findViewById(2131824017).setBackgroundResource(C25738R.drawable.abp);
            }
            AppMethodBeat.m2505o(107628);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.FilterImageView$c */
    static class C40882c {
        String cIY;
        C40883b zCf;
        String zCg;
        int zCh;
        int zCi;
        int zCj;

        C40882c(C40883b c40883b, String str, int i, int i2, String str2, int i3) {
            this.zCf = c40883b;
            this.zCg = str;
            this.zCh = i;
            this.zCi = i2;
            this.cIY = str2;
            this.zCj = i3;
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.FilterImageView$b */
    static class C40883b {
        String yVk;
        String zCd;
        String zCe;

        C40883b(String str, String str2, String str3) {
            this.yVk = str;
            this.zCd = str2;
            this.zCe = str3;
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m70845a(FilterImageView filterImageView, String str, int i, int i2) {
        AppMethodBeat.m2504i(107638);
        boolean ay = filterImageView.m70846ay(str, i, i2);
        AppMethodBeat.m2505o(107638);
        return ay;
    }

    public FilterImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(107629);
        this.czX = (Activity) context;
        View inflate = View.inflate(this.czX, 2130969254, this);
        this.zBS = (CropImageView) inflate.findViewById(2131823169);
        this.zBR = (ImageView) inflate.findViewById(2131823172);
        this.zBQ = inflate.findViewById(2131823171);
        this.zBS.setOnTouchListener(null);
        this.zBU = (MMHorList) inflate.findViewById(2131823173);
        this.zBV = new C40881a();
        this.zBU.setAdapter(this.zBV);
        this.zBU.invalidate();
        this.zBU.setOnItemClickListener(new C240261());
        AppMethodBeat.m2505o(107629);
    }

    public void setOnConfirmImp(Runnable runnable) {
        this.zBW = runnable;
    }

    public void setOnExitImp(Runnable runnable) {
        this.zBX = runnable;
    }

    public Bitmap getFilterBmp() {
        return this.zBT;
    }

    public void setLimitZoomIn(boolean z) {
        AppMethodBeat.m2504i(107630);
        if (this.zBS != null) {
            this.zBS.setLimitZoomIn(z);
        }
        AppMethodBeat.m2505o(107630);
    }

    public final void dJL() {
        AppMethodBeat.m2504i(107631);
        if (this.zBS != null) {
            this.zBS.setScaleType(ScaleType.MATRIX);
            this.zBS.dJJ();
        }
        AppMethodBeat.m2505o(107631);
    }

    public void setMatrix(Matrix matrix) {
        AppMethodBeat.m2504i(107632);
        if (this.zBS != null) {
            this.zBS.setImageMatrix(matrix);
        }
        AppMethodBeat.m2505o(107632);
    }

    public void setImage(Bitmap bitmap) {
        this.zBT = bitmap;
    }

    public CropImageView getCropImageIV() {
        return this.zBS;
    }

    public View getCropAreaView() {
        return this.zBQ;
    }

    public void setCropMaskVisible(int i) {
        AppMethodBeat.m2504i(107633);
        if (this.zBR != null) {
            this.zBR.setVisibility(i);
        }
        AppMethodBeat.m2505o(107633);
    }

    public void setCropMaskBackground(int i) {
        AppMethodBeat.m2504i(107634);
        if (this.zBR != null) {
            this.zBR.setBackgroundResource(i);
        }
        AppMethodBeat.m2505o(107634);
    }

    /* renamed from: eH */
    public final void mo64466eH(String str, int i) {
        AppMethodBeat.m2504i(107635);
        C4990ab.m7416i("MicroMsg.FilterView", "filePath before fiterBmp:".concat(String.valueOf(str)));
        if (this.zBT == null || this.zBT.isRecycled()) {
            this.zBT = C5056d.m7648b(C5056d.m7659d(str, 480, 480, false), (float) i);
        }
        C4990ab.m7410d("MicroMsg.FilterView", "filterBmp w:" + this.zBT.getWidth() + " h:" + this.zBT.getHeight());
        this.zBP = new int[(this.zBT.getWidth() * this.zBT.getHeight())];
        this.zBT.getPixels(this.zBP, 0, this.zBT.getWidth(), 0, 0, this.zBT.getWidth(), this.zBT.getHeight());
        this.zBS.setImageBitmap(this.zBT);
        AppMethodBeat.m2505o(107635);
    }

    public void setVisibility(int i) {
        AppMethodBeat.m2504i(107636);
        if (i == 0) {
            this.zBV.notifyDataSetChanged();
            this.zBU.invalidate();
        }
        super.setVisibility(i);
        AppMethodBeat.m2505o(107636);
    }

    public int getFilterId() {
        return this.filterId;
    }

    /* renamed from: ay */
    private boolean m70846ay(String str, int i, int i2) {
        AppMethodBeat.m2504i(107637);
        if (i2 == 0) {
            this.zBT.setPixels(this.zBP, 0, this.zBT.getWidth(), 0, 0, this.zBT.getWidth(), this.zBT.getHeight());
            this.zBS.invalidate();
            AppMethodBeat.m2505o(107637);
            return true;
        }
        int width = this.zBT.getWidth() * this.zBT.getHeight();
        C4990ab.m7410d("MicroMsg.FilterView", "len:" + width + "  maskCount:" + i);
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i, width});
        int i3 = 0;
        while (i3 < i) {
            InputStream inputStream = null;
            try {
                inputStream = this.czX.getAssets().open("filter/".concat(String.valueOf(String.format(str, new Object[]{Integer.valueOf(i3)}))));
                byte[] bArr = new byte[width];
                inputStream.read(bArr);
                Bitmap bQ = C5056d.m7652bQ(bArr);
                inputStream.close();
                if (inputStream != null) {
                    inputStream.close();
                }
                if (bQ == null) {
                    AppMethodBeat.m2505o(107637);
                    return false;
                }
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bQ, this.zBT.getWidth(), this.zBT.getHeight(), true);
                if (bQ != createScaledBitmap) {
                    C4990ab.m7417i("MicroMsg.FilterView", "recycle bitmap:%s", bQ.toString());
                    bQ.recycle();
                }
                if (createScaledBitmap == null) {
                    AppMethodBeat.m2505o(107637);
                    return false;
                }
                createScaledBitmap.getPixels(iArr[i3], 0, createScaledBitmap.getWidth(), 0, 0, createScaledBitmap.getWidth(), createScaledBitmap.getHeight());
                C4990ab.m7417i("MicroMsg.FilterView", "recycle bitmap:%s", createScaledBitmap.toString());
                createScaledBitmap.recycle();
                i3++;
            } catch (Exception e) {
                AppMethodBeat.m2505o(107637);
                throw e;
            } catch (Throwable th) {
                if (inputStream != null) {
                    inputStream.close();
                }
                AppMethodBeat.m2505o(107637);
            }
        }
        PIntArray pIntArray = new PIntArray();
        C4990ab.m7412e("MicroMsg.FilterView", "src.len:" + this.zBP.length);
        for (int i4 = 0; i4 < iArr.length; i4++) {
            C4990ab.m7412e("MicroMsg.FilterView", "mask[" + i4 + "].len:" + iArr[i4].length);
        }
        C4990ab.m7412e("MicroMsg.FilterView", "before filter");
        ImgFilter.FilterInt(i2, this.zBP, iArr, i, this.zBT.getWidth(), this.zBT.getHeight(), pIntArray);
        C4990ab.m7412e("MicroMsg.FilterView", "after filter");
        this.zBT.setPixels(pIntArray.value, 0, this.zBT.getWidth(), 0, 0, this.zBT.getWidth(), this.zBT.getHeight());
        this.zBS.invalidate();
        AppMethodBeat.m2505o(107637);
        return true;
    }

    static {
        AppMethodBeat.m2504i(107639);
        AppMethodBeat.m2505o(107639);
    }
}
