package com.tencent.mm.ui.tools;

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
import com.tencent.mm.R;
import com.tencent.mm.pointers.PIntArray;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.base.MMHorList;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;

public class FilterImageView extends LinearLayout {
    static c[] zBY = new c[]{new c(new b("原图", "原圖", "Normal"), "icon.png", 0, 0, "MatteOrigin.jpg", 0), new c(new b("LOMO", "LOMO", "LOMO"), "nuowei_mask%02d.jpg", 2, 1, "0004.jpg", 2), new c(new b("麦田", "麥田", "Wheat"), "0062_%02d.jpg", 2, 2, "0062.jpg", 20), new c(new b("玻璃镜", "玻璃鏡", "Glossy"), "habi_mask%02d.jpg", 1, 3, "0005.jpg", 4), new c(new b("拍立得", "拍立得", "Polaroid"), "0063_%02d.jpg", 2, 4, "0063.jpg", 21), new c(new b("湖水", "湖水", "Lake"), "0061_%02d.jpg", 1, 5, "0061.jpg", 19), new c(new b("黄昏", "黃昏", "Twilight"), "0030_mask%01d.jpg", 1, 6, "0030.jpg", 7), new c(new b("黑白", "黑白", "B&W"), "0065_%02d.jpg", 1, 7, "0065.jpg", 22), new c(new b("铜版画", "銅版畫", "Aquatint"), "0032_mask%01d.jpg", 1, 8, "0032.jpg", 9), new c(new b("圆珠笔", "圓珠筆", "Pen"), "0035_mask%01d.jpg", 1, 9, "0035.jpg", 18), new c(new b("海报", "海報", "Poster"), "0036_mask%01d.jpg", 0, 10, "0036.jpg", 17), new c(new b("素描", "素描", "Portrait"), "icon.jpg", 0, 11, "0040.jpg", 12)};
    private Activity czX;
    private int filterId = 0;
    int[] zBP;
    private View zBQ;
    private ImageView zBR;
    private CropImageView zBS;
    Bitmap zBT;
    private MMHorList zBU;
    private a zBV;
    private Runnable zBW;
    private Runnable zBX;

    class a extends BaseAdapter {
        int llU = 0;

        class a {
            TextView exj;
            ImageView zCa;
            Bitmap zCb;

            a() {
            }
        }

        a() {
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
            a aVar;
            CharSequence charSequence;
            AppMethodBeat.i(107628);
            c cVar = (c) getItem(i);
            if (view == null || !(view.getTag() instanceof a)) {
                view = View.inflate(FilterImageView.this.czX, R.layout.zi, null);
                a aVar2 = new a();
                aVar2.exj = (TextView) view.findViewById(R.id.bsw);
                aVar2.zCa = (ImageView) view.findViewById(R.id.bsv);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
                if (aVar.zCb != null) {
                    ab.i("MicroMsg.FilterView", "recycle bitmap:%s", aVar.zCb.toString());
                    aVar.zCb.recycle();
                }
            }
            TextView textView = aVar.exj;
            b bVar = cVar.zCf;
            String dor = aa.dor();
            if (dor.equals("zh_CN")) {
                charSequence = bVar.yVk;
            } else if (dor.equals("zh_TW") || dor.equals("zh_HK")) {
                charSequence = bVar.zCd;
            } else {
                charSequence = bVar.zCe;
            }
            textView.setText(charSequence);
            try {
                InputStream open = FilterImageView.this.czX.getAssets().open("filter/" + cVar.cIY);
                aVar.zCb = d.decodeStream(open);
                open.close();
                aVar.zCa.setImageBitmap(aVar.zCb);
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.FilterView", e, "", new Object[0]);
            }
            view.setLayoutParams(new LayoutParams(-2, -2));
            if (i == this.llU) {
                view.findViewById(R.id.bsv).setBackgroundResource(R.drawable.abo);
            } else {
                view.findViewById(R.id.bsv).setBackgroundResource(R.drawable.abp);
            }
            AppMethodBeat.o(107628);
            return view;
        }
    }

    static class c {
        String cIY;
        b zCf;
        String zCg;
        int zCh;
        int zCi;
        int zCj;

        c(b bVar, String str, int i, int i2, String str2, int i3) {
            this.zCf = bVar;
            this.zCg = str;
            this.zCh = i;
            this.zCi = i2;
            this.cIY = str2;
            this.zCj = i3;
        }
    }

    static class b {
        String yVk;
        String zCd;
        String zCe;

        b(String str, String str2, String str3) {
            this.yVk = str;
            this.zCd = str2;
            this.zCe = str3;
        }
    }

    static /* synthetic */ boolean a(FilterImageView filterImageView, String str, int i, int i2) {
        AppMethodBeat.i(107638);
        boolean ay = filterImageView.ay(str, i, i2);
        AppMethodBeat.o(107638);
        return ay;
    }

    public FilterImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(107629);
        this.czX = (Activity) context;
        View inflate = View.inflate(this.czX, R.layout.rk, this);
        this.zBS = (CropImageView) inflate.findViewById(R.id.b6y);
        this.zBR = (ImageView) inflate.findViewById(R.id.b71);
        this.zBQ = inflate.findViewById(R.id.b70);
        this.zBS.setOnTouchListener(null);
        this.zBU = (MMHorList) inflate.findViewById(R.id.b72);
        this.zBV = new a();
        this.zBU.setAdapter(this.zBV);
        this.zBU.invalidate();
        this.zBU.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(107627);
                a a = FilterImageView.this.zBV;
                a.llU = i;
                a.notifyDataSetChanged();
                try {
                    FilterImageView.this.filterId = FilterImageView.zBY[i].zCj;
                    FilterImageView.a(FilterImageView.this, FilterImageView.zBY[i].zCg, FilterImageView.zBY[i].zCh, FilterImageView.zBY[i].zCi);
                    AppMethodBeat.o(107627);
                } catch (Exception e) {
                    ab.e("MicroMsg.FilterView", e.toString());
                    ab.printErrStackTrace("MicroMsg.FilterView", e, "", new Object[0]);
                    AppMethodBeat.o(107627);
                } catch (OutOfMemoryError e2) {
                    ab.e("MicroMsg.FilterView", e2.toString());
                    ab.printErrStackTrace("MicroMsg.FilterView", e2, "", new Object[0]);
                    AppMethodBeat.o(107627);
                }
            }
        });
        AppMethodBeat.o(107629);
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
        AppMethodBeat.i(107630);
        if (this.zBS != null) {
            this.zBS.setLimitZoomIn(z);
        }
        AppMethodBeat.o(107630);
    }

    public final void dJL() {
        AppMethodBeat.i(107631);
        if (this.zBS != null) {
            this.zBS.setScaleType(ScaleType.MATRIX);
            this.zBS.dJJ();
        }
        AppMethodBeat.o(107631);
    }

    public void setMatrix(Matrix matrix) {
        AppMethodBeat.i(107632);
        if (this.zBS != null) {
            this.zBS.setImageMatrix(matrix);
        }
        AppMethodBeat.o(107632);
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
        AppMethodBeat.i(107633);
        if (this.zBR != null) {
            this.zBR.setVisibility(i);
        }
        AppMethodBeat.o(107633);
    }

    public void setCropMaskBackground(int i) {
        AppMethodBeat.i(107634);
        if (this.zBR != null) {
            this.zBR.setBackgroundResource(i);
        }
        AppMethodBeat.o(107634);
    }

    public final void eH(String str, int i) {
        AppMethodBeat.i(107635);
        ab.i("MicroMsg.FilterView", "filePath before fiterBmp:".concat(String.valueOf(str)));
        if (this.zBT == null || this.zBT.isRecycled()) {
            this.zBT = d.b(d.d(str, 480, 480, false), (float) i);
        }
        ab.d("MicroMsg.FilterView", "filterBmp w:" + this.zBT.getWidth() + " h:" + this.zBT.getHeight());
        this.zBP = new int[(this.zBT.getWidth() * this.zBT.getHeight())];
        this.zBT.getPixels(this.zBP, 0, this.zBT.getWidth(), 0, 0, this.zBT.getWidth(), this.zBT.getHeight());
        this.zBS.setImageBitmap(this.zBT);
        AppMethodBeat.o(107635);
    }

    public void setVisibility(int i) {
        AppMethodBeat.i(107636);
        if (i == 0) {
            this.zBV.notifyDataSetChanged();
            this.zBU.invalidate();
        }
        super.setVisibility(i);
        AppMethodBeat.o(107636);
    }

    public int getFilterId() {
        return this.filterId;
    }

    private boolean ay(String str, int i, int i2) {
        AppMethodBeat.i(107637);
        if (i2 == 0) {
            this.zBT.setPixels(this.zBP, 0, this.zBT.getWidth(), 0, 0, this.zBT.getWidth(), this.zBT.getHeight());
            this.zBS.invalidate();
            AppMethodBeat.o(107637);
            return true;
        }
        int width = this.zBT.getWidth() * this.zBT.getHeight();
        ab.d("MicroMsg.FilterView", "len:" + width + "  maskCount:" + i);
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i, width});
        int i3 = 0;
        while (i3 < i) {
            InputStream inputStream = null;
            try {
                inputStream = this.czX.getAssets().open("filter/".concat(String.valueOf(String.format(str, new Object[]{Integer.valueOf(i3)}))));
                byte[] bArr = new byte[width];
                inputStream.read(bArr);
                Bitmap bQ = d.bQ(bArr);
                inputStream.close();
                if (inputStream != null) {
                    inputStream.close();
                }
                if (bQ == null) {
                    AppMethodBeat.o(107637);
                    return false;
                }
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bQ, this.zBT.getWidth(), this.zBT.getHeight(), true);
                if (bQ != createScaledBitmap) {
                    ab.i("MicroMsg.FilterView", "recycle bitmap:%s", bQ.toString());
                    bQ.recycle();
                }
                if (createScaledBitmap == null) {
                    AppMethodBeat.o(107637);
                    return false;
                }
                createScaledBitmap.getPixels(iArr[i3], 0, createScaledBitmap.getWidth(), 0, 0, createScaledBitmap.getWidth(), createScaledBitmap.getHeight());
                ab.i("MicroMsg.FilterView", "recycle bitmap:%s", createScaledBitmap.toString());
                createScaledBitmap.recycle();
                i3++;
            } catch (Exception e) {
                AppMethodBeat.o(107637);
                throw e;
            } catch (Throwable th) {
                if (inputStream != null) {
                    inputStream.close();
                }
                AppMethodBeat.o(107637);
            }
        }
        PIntArray pIntArray = new PIntArray();
        ab.e("MicroMsg.FilterView", "src.len:" + this.zBP.length);
        for (int i4 = 0; i4 < iArr.length; i4++) {
            ab.e("MicroMsg.FilterView", "mask[" + i4 + "].len:" + iArr[i4].length);
        }
        ab.e("MicroMsg.FilterView", "before filter");
        ImgFilter.FilterInt(i2, this.zBP, iArr, i, this.zBT.getWidth(), this.zBT.getHeight(), pIntArray);
        ab.e("MicroMsg.FilterView", "after filter");
        this.zBT.setPixels(pIntArray.value, 0, this.zBT.getWidth(), 0, 0, this.zBT.getWidth(), this.zBT.getHeight());
        this.zBS.invalidate();
        AppMethodBeat.o(107637);
        return true;
    }

    static {
        AppMethodBeat.i(107639);
        AppMethodBeat.o(107639);
    }
}
