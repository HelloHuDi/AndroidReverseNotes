package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.p057v4.view.C25365p;
import android.support.p057v4.view.ViewPager.OnPageChangeListener;
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
import com.tencent.p177mm.p612ui.base.MMDotView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.i */
public final class C43232i extends AlertDialog implements OnPageChangeListener {
    /* renamed from: IT */
    private CharSequence f17202IT;
    /* renamed from: TF */
    private TextView f17203TF;
    private View jcl;
    private MMDotView jiG;
    private Context mContext;
    private C3328b nFL;
    private IPCallShareViewPager nFM;
    private OnClickListener nFN;
    private LinkedList<Integer> nFO;

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.i$a */
    public static class C3325a extends BaseAdapter {
        private Context mContext;
        OnClickListener nFP;
        List<Integer> ngC = null;

        /* renamed from: com.tencent.mm.plugin.ipcall.ui.i$a$1 */
        class C33261 implements OnClickListener {
            C33261() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(22344);
                if (C3325a.this.nFP != null) {
                    C3325a.this.nFP.onClick(view);
                }
                AppMethodBeat.m2505o(22344);
            }
        }

        /* renamed from: com.tencent.mm.plugin.ipcall.ui.i$a$a */
        public class C3327a {
            /* renamed from: id */
            int f1268id;
            RelativeLayout nFR;
            TextView nFS;
            ImageView nFT;
        }

        public C3325a(Context context) {
            AppMethodBeat.m2504i(22345);
            Assert.assertTrue(context != null);
            this.mContext = context;
            AppMethodBeat.m2505o(22345);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(22346);
            if (this.ngC == null) {
                AppMethodBeat.m2505o(22346);
                return 0;
            }
            int size = this.ngC.size();
            AppMethodBeat.m2505o(22346);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(22347);
            if (this.ngC != null) {
                Object obj = this.ngC.get(i);
                AppMethodBeat.m2505o(22347);
                return obj;
            }
            AppMethodBeat.m2505o(22347);
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C3327a c3327a;
            AppMethodBeat.m2504i(22348);
            if (view == null) {
                view = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(2130969909, viewGroup, false);
                c3327a = new C3327a();
                c3327a.nFR = (RelativeLayout) view.findViewById(2131824244);
                c3327a.nFS = (TextView) view.findViewById(2131825196);
                c3327a.nFT = (ImageView) view.findViewById(2131825195);
                view.setTag(c3327a);
            } else {
                c3327a = (C3327a) view.getTag();
            }
            Object item = getItem(i);
            if (item == null) {
                AppMethodBeat.m2505o(22348);
            } else {
                c3327a.f1268id = ((Integer) item).intValue();
                IPCallShareCouponCardUI.m85653a(this.mContext, c3327a.f1268id, c3327a.nFS, c3327a.nFT);
                c3327a.nFR.setOnClickListener(new C33261());
                AppMethodBeat.m2505o(22348);
            }
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.i$b */
    public class C3328b extends C25365p {
        int mCount = 0;
        OnClickListener nFP;
        LinkedList<Integer> nFU;
        ArrayList<View> nFV = new ArrayList();

        public C3328b() {
            AppMethodBeat.m2504i(22349);
            AppMethodBeat.m2505o(22349);
        }

        public final int getCount() {
            return this.mCount;
        }

        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            AppMethodBeat.m2504i(22350);
            C4990ab.m7419v("MicroMsg.IPCallShareDialog", "destroy item: %d", Integer.valueOf(i));
            viewGroup.removeView((View) obj);
            AppMethodBeat.m2505o(22350);
        }

        public final Object instantiateItem(ViewGroup viewGroup, int i) {
            View view;
            AppMethodBeat.m2504i(22351);
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
            AppMethodBeat.m2505o(22351);
            return view;
        }

        public final int getItemPosition(Object obj) {
            AppMethodBeat.m2504i(22352);
            int itemPosition = super.getItemPosition(obj);
            AppMethodBeat.m2505o(22352);
            return itemPosition;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(22353);
        super.onCreate(bundle);
        getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        getWindow().setGravity(80);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        setContentView(this.jcl);
        AppMethodBeat.m2505o(22353);
    }

    public final void onPageScrollStateChanged(int i) {
    }

    public final void onPageScrolled(int i, float f, int i2) {
    }

    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f17202IT = charSequence;
        } else {
            this.f17202IT = null;
        }
    }

    public final void show() {
        int i = 0;
        AppMethodBeat.m2504i(22355);
        if (this.nFO == null || this.nFO.size() == 0) {
            AppMethodBeat.m2505o(22355);
            return;
        }
        this.nFM.setOnPageChangeListener(this);
        C3328b c3328b = new C3328b();
        c3328b.nFP = this.nFN;
        c3328b.nFU = this.nFO;
        if (c3328b.nFU.size() > 0) {
            c3328b.mCount = ((c3328b.nFU.size() - 1) / 9) + 1;
        } else {
            c3328b.mCount = 0;
        }
        while (true) {
            int i2 = i;
            if (i2 < c3328b.mCount) {
                View inflate = ((LayoutInflater) C43232i.this.mContext.getSystemService("layout_inflater")).inflate(2130969908, null);
                GridView gridView = (GridView) inflate.findViewById(2131825194);
                ArrayList arrayList = new ArrayList();
                int i3 = i2 * 9;
                while (i3 < c3328b.nFU.size() && i3 < (i2 * 9) + 9) {
                    arrayList.add(c3328b.nFU.get(i3));
                    i3++;
                }
                C3325a c3325a = new C3325a(C43232i.this.getContext());
                c3325a.nFP = c3328b.nFP;
                c3325a.ngC = arrayList;
                gridView.setAdapter(c3325a);
                c3328b.nFV.add(inflate);
                i = i2 + 1;
            } else {
                this.nFL = c3328b;
                this.nFM.setAdapter(this.nFL);
                this.f17203TF.setText(this.f17202IT);
                super.show();
                AppMethodBeat.m2505o(22355);
                return;
            }
        }
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(22356);
        try {
            super.dismiss();
            AppMethodBeat.m2505o(22356);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.IPCallShareDialog", "dismiss exception, e = " + e.getMessage());
            AppMethodBeat.m2505o(22356);
        }
    }

    public final void onPageSelected(int i) {
        AppMethodBeat.m2504i(22354);
        if (this.nFL.getCount() <= 1) {
            this.jiG.setVisibility(4);
            AppMethodBeat.m2505o(22354);
            return;
        }
        this.jiG.setVisibility(0);
        this.jiG.setDotCount(this.nFL.getCount());
        this.jiG.setSelectedDot(i);
        AppMethodBeat.m2505o(22354);
    }
}
