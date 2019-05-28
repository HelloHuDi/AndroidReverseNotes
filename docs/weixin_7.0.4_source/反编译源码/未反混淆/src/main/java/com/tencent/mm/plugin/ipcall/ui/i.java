package com.tencent.mm.plugin.ipcall.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.p;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMDotView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class i extends AlertDialog implements OnPageChangeListener {
    private CharSequence IT;
    private TextView TF;
    private View jcl;
    private MMDotView jiG;
    private Context mContext;
    private b nFL;
    private IPCallShareViewPager nFM;
    private OnClickListener nFN;
    private LinkedList<Integer> nFO;

    public static class a extends BaseAdapter {
        private Context mContext;
        OnClickListener nFP;
        List<Integer> ngC = null;

        public class a {
            int id;
            RelativeLayout nFR;
            TextView nFS;
            ImageView nFT;
        }

        public a(Context context) {
            AppMethodBeat.i(22345);
            Assert.assertTrue(context != null);
            this.mContext = context;
            AppMethodBeat.o(22345);
        }

        public final int getCount() {
            AppMethodBeat.i(22346);
            if (this.ngC == null) {
                AppMethodBeat.o(22346);
                return 0;
            }
            int size = this.ngC.size();
            AppMethodBeat.o(22346);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(22347);
            if (this.ngC != null) {
                Object obj = this.ngC.get(i);
                AppMethodBeat.o(22347);
                return obj;
            }
            AppMethodBeat.o(22347);
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(22348);
            if (view == null) {
                view = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.a98, viewGroup, false);
                aVar = new a();
                aVar.nFR = (RelativeLayout) view.findViewById(R.id.bz0);
                aVar.nFS = (TextView) view.findViewById(R.id.cnq);
                aVar.nFT = (ImageView) view.findViewById(R.id.cnp);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            Object item = getItem(i);
            if (item == null) {
                AppMethodBeat.o(22348);
            } else {
                aVar.id = ((Integer) item).intValue();
                IPCallShareCouponCardUI.a(this.mContext, aVar.id, aVar.nFS, aVar.nFT);
                aVar.nFR.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(22344);
                        if (a.this.nFP != null) {
                            a.this.nFP.onClick(view);
                        }
                        AppMethodBeat.o(22344);
                    }
                });
                AppMethodBeat.o(22348);
            }
            return view;
        }
    }

    public class b extends p {
        int mCount = 0;
        OnClickListener nFP;
        LinkedList<Integer> nFU;
        ArrayList<View> nFV = new ArrayList();

        public b() {
            AppMethodBeat.i(22349);
            AppMethodBeat.o(22349);
        }

        public final int getCount() {
            return this.mCount;
        }

        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            AppMethodBeat.i(22350);
            ab.v("MicroMsg.IPCallShareDialog", "destroy item: %d", Integer.valueOf(i));
            viewGroup.removeView((View) obj);
            AppMethodBeat.o(22350);
        }

        public final Object instantiateItem(ViewGroup viewGroup, int i) {
            View view;
            AppMethodBeat.i(22351);
            if (this.nFV.get(i) != null) {
                view = (View) this.nFV.get(i);
            } else {
                view = null;
            }
            if (view != null) {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                if (viewGroup != null) {
                    viewGroup.addView(view, 0);
                }
            }
            AppMethodBeat.o(22351);
            return view;
        }

        public final int getItemPosition(Object obj) {
            AppMethodBeat.i(22352);
            int itemPosition = super.getItemPosition(obj);
            AppMethodBeat.o(22352);
            return itemPosition;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(22353);
        super.onCreate(bundle);
        getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        getWindow().setGravity(80);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        setContentView(this.jcl);
        AppMethodBeat.o(22353);
    }

    public final void onPageScrollStateChanged(int i) {
    }

    public final void onPageScrolled(int i, float f, int i2) {
    }

    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.IT = charSequence;
        } else {
            this.IT = null;
        }
    }

    public final void show() {
        int i = 0;
        AppMethodBeat.i(22355);
        if (this.nFO == null || this.nFO.size() == 0) {
            AppMethodBeat.o(22355);
            return;
        }
        this.nFM.setOnPageChangeListener(this);
        b bVar = new b();
        bVar.nFP = this.nFN;
        bVar.nFU = this.nFO;
        if (bVar.nFU.size() > 0) {
            bVar.mCount = ((bVar.nFU.size() - 1) / 9) + 1;
        } else {
            bVar.mCount = 0;
        }
        while (true) {
            int i2 = i;
            if (i2 < bVar.mCount) {
                View inflate = ((LayoutInflater) i.this.mContext.getSystemService("layout_inflater")).inflate(R.layout.a97, null);
                GridView gridView = (GridView) inflate.findViewById(R.id.cno);
                ArrayList arrayList = new ArrayList();
                int i3 = i2 * 9;
                while (i3 < bVar.nFU.size() && i3 < (i2 * 9) + 9) {
                    arrayList.add(bVar.nFU.get(i3));
                    i3++;
                }
                a aVar = new a(i.this.getContext());
                aVar.nFP = bVar.nFP;
                aVar.ngC = arrayList;
                gridView.setAdapter(aVar);
                bVar.nFV.add(inflate);
                i = i2 + 1;
            } else {
                this.nFL = bVar;
                this.nFM.setAdapter(this.nFL);
                this.TF.setText(this.IT);
                super.show();
                AppMethodBeat.o(22355);
                return;
            }
        }
    }

    public final void dismiss() {
        AppMethodBeat.i(22356);
        try {
            super.dismiss();
            AppMethodBeat.o(22356);
        } catch (Exception e) {
            ab.e("MicroMsg.IPCallShareDialog", "dismiss exception, e = " + e.getMessage());
            AppMethodBeat.o(22356);
        }
    }

    public final void onPageSelected(int i) {
        AppMethodBeat.i(22354);
        if (this.nFL.getCount() <= 1) {
            this.jiG.setVisibility(4);
            AppMethodBeat.o(22354);
            return;
        }
        this.jiG.setVisibility(0);
        this.jiG.setDotCount(this.nFL.getCount());
        this.jiG.setSelectedDot(i);
        AppMethodBeat.o(22354);
    }
}
