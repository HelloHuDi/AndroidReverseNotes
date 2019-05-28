package com.tencent.p177mm.p612ui.widget.p1095b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5227ai;
import com.tencent.p177mm.p612ui.C5229aj;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44274m;
import com.tencent.p177mm.p612ui.base.C46633o;
import com.tencent.p177mm.p612ui.base.MMListPopupWindow;
import com.tencent.p177mm.p612ui.widget.p1095b.C24092b.C24093a;

/* renamed from: com.tencent.mm.ui.widget.b.a */
public class C24088a implements OnKeyListener, OnItemClickListener, OnDismissListener {
    private static int zRR;
    private static int zRS;
    private static boolean zRT = false;
    private DisplayMetrics cbh;
    private Context mContext = null;
    private LayoutInflater mInflater;
    private View nWa;
    public C5279d rBm;
    private C44273l rBn;
    private MMListPopupWindow yHM;
    public OnDismissListener zHM;
    private C24090a zRU = null;
    private C46633o zRV;
    private int zRW;
    private boolean zRX = false;
    public View zRY;
    public OnCreateContextMenuListener zRZ;
    public boolean zSa = false;
    public boolean zSb = true;
    public boolean zSc = false;
    private View zbD = null;

    /* renamed from: com.tencent.mm.ui.widget.b.a$3 */
    class C159993 implements OnItemClickListener {
        C159993() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(112757);
            if (C24088a.this.rBm != null) {
                C24088a.this.rBm.onMMMenuItemSelected(C24088a.this.rBn.getItem(i), i);
            }
            if (C24088a.this.yHM != null && C24088a.this.yHM.gKG.isShowing()) {
                C24088a.this.yHM.dismiss();
            }
            AppMethodBeat.m2505o(112757);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.b.a$a */
    class C24090a extends BaseAdapter {
        private C24090a() {
        }

        /* synthetic */ C24090a(C24088a c24088a, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.m2504i(112760);
            int size = C24088a.this.rBn.size();
            AppMethodBeat.m2505o(112760);
            return size;
        }

        private String getItem(int i) {
            AppMethodBeat.m2504i(112761);
            String str = (String) ((MenuItem) C24088a.this.rBn.yvT.get(i)).getTitle();
            AppMethodBeat.m2505o(112761);
            return str;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(112762);
            TextView textView = null;
            if (view == null) {
                textView = (TextView) C24088a.this.mInflater.inflate(2130970371, viewGroup, false);
            } else if (view instanceof TextView) {
                textView = (TextView) view;
            }
            String item = getItem(i);
            if (textView != null) {
                textView.setTag(item);
                textView.setText(item);
            }
            AppMethodBeat.m2505o(112762);
            return textView;
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.b.a$5 */
    class C240915 implements OnTouchListener {
        C240915() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(112759);
            switch (motionEvent.getAction() & 255) {
                case 0:
                    C24088a.zRR = (int) motionEvent.getRawX();
                    C24088a.zRS = (int) motionEvent.getRawY();
                    C24088a.this.nWa = C24088a.this.zbD;
                    C24088a.zRT = true;
                    C5227ai.m7973i("MicroMsg.MMPopupMenu", "popmenu view set , x_down=" + C24088a.zRR + "y_down=" + C24088a.zRS, new Object[0]);
                    break;
            }
            AppMethodBeat.m2505o(112759);
            return false;
        }
    }

    public C24088a(Context context, View view) {
        AppMethodBeat.m2504i(112764);
        this.mContext = context;
        this.zbD = view;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        initView();
        dLi();
        AppMethodBeat.m2505o(112764);
    }

    public C24088a(Context context) {
        AppMethodBeat.m2504i(112765);
        this.mContext = context;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        initView();
        AppMethodBeat.m2505o(112765);
    }

    /* renamed from: c */
    public final void mo39887c(View view, final OnCreateContextMenuListener onCreateContextMenuListener, C5279d c5279d) {
        AppMethodBeat.m2504i(112766);
        this.zbD = view;
        dLi();
        this.rBm = c5279d;
        if (view instanceof AbsListView) {
            C5227ai.m7974v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView", new Object[0]);
            ((AbsListView) view).setOnItemLongClickListener(new OnItemLongClickListener() {
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.m2504i(112755);
                    C24088a.this.rBn.clear();
                    C5227ai.m7974v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView long click", new Object[0]);
                    AdapterContextMenuInfo adapterContextMenuInfo = new AdapterContextMenuInfo(view, i, j);
                    onCreateContextMenuListener.onCreateContextMenu(C24088a.this.rBn, view, adapterContextMenuInfo);
                    for (MenuItem menuItem : C24088a.this.rBn.yvT) {
                        ((C44274m) menuItem).yvW = adapterContextMenuInfo;
                    }
                    C24088a.this.mo22431dn(0, 0);
                    AppMethodBeat.m2505o(112755);
                    return true;
                }
            });
            AppMethodBeat.m2505o(112766);
            return;
        }
        C5227ai.m7974v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view", new Object[0]);
        view.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                AppMethodBeat.m2504i(112756);
                C5227ai.m7974v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view long click", new Object[0]);
                C24088a.this.rBn.clear();
                C24088a.this.zbD = view;
                onCreateContextMenuListener.onCreateContextMenu(C24088a.this.rBn, view, null);
                if (view.getTag(2131820679) instanceof int[]) {
                    int[] iArr = (int[]) view.getTag(2131820679);
                    if (iArr == null) {
                        C24088a.this.mo22431dn(0, 0);
                    } else {
                        C24088a.this.mo22431dn(iArr[0], iArr[1]);
                    }
                } else {
                    C24088a.this.mo22431dn(0, 0);
                }
                AppMethodBeat.m2505o(112756);
                return true;
            }
        });
        AppMethodBeat.m2505o(112766);
    }

    /* renamed from: a */
    public final void mo39885a(View view, int i, long j, OnCreateContextMenuListener onCreateContextMenuListener, C5279d c5279d, int i2, int i3) {
        AppMethodBeat.m2504i(112767);
        this.rBm = c5279d;
        this.zbD = view;
        dLi();
        this.rBn.clear();
        AdapterContextMenuInfo adapterContextMenuInfo = new AdapterContextMenuInfo(view, i, j);
        onCreateContextMenuListener.onCreateContextMenu(this.rBn, view, adapterContextMenuInfo);
        for (MenuItem menuItem : this.rBn.yvT) {
            ((C44274m) menuItem).yvW = adapterContextMenuInfo;
        }
        if (i2 == 0 && i3 == 0) {
            mo22431dn(0, 0);
            AppMethodBeat.m2505o(112767);
            return;
        }
        mo22431dn(i2, i3);
        AppMethodBeat.m2505o(112767);
    }

    /* renamed from: a */
    public final void mo39886a(View view, OnCreateContextMenuListener onCreateContextMenuListener, C5279d c5279d, int i, int i2) {
        AppMethodBeat.m2504i(112768);
        this.rBm = c5279d;
        this.zbD = view;
        if (!(view instanceof TextView) && (i == 0 || i2 == 0)) {
            dLi();
        }
        this.rBn.clear();
        onCreateContextMenuListener.onCreateContextMenu(this.rBn, view, null);
        if (i == 0 && i2 == 0) {
            mo22431dn(0, 0);
            AppMethodBeat.m2505o(112768);
            return;
        }
        mo22431dn(i, i2);
        AppMethodBeat.m2505o(112768);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: hC */
    private boolean m37052hC(int i, int i2) {
        AppMethodBeat.m2504i(112769);
        if (isShowing() || dLh()) {
            AppMethodBeat.m2505o(112769);
            return false;
        }
        boolean z;
        if (this.mContext instanceof Activity) {
            View findViewById = ((ViewGroup) ((Activity) this.mContext).getWindow().getDecorView()).findViewById(16908290);
            if (findViewById != null) {
                Rect rect = new Rect();
                findViewById.getGlobalVisibleRect(rect);
                if (rect.left > 0) {
                    z = true;
                    if (z) {
                        boolean z2;
                        if (this.zRZ != null) {
                            this.zRZ.onCreateContextMenu(this.rBn, this.zbD, null);
                        }
                        int count = this.zRU.getCount() * this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10010nb);
                        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10372zh);
                        int b = m37045b(this.zRU);
                        int am = C5229aj.m7981am(this.mContext, C25738R.dimen.a5z);
                        if (b >= am) {
                            am = b;
                        }
                        if (this.rBn.size() >= 3) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (!this.zRX) {
                            if (this.zRY != null) {
                                this.zRY.setSelected(true);
                            } else {
                                this.zbD.setSelected(true);
                            }
                        }
                        if (this.zSa) {
                            m37053hD(i, i2);
                        } else {
                            C24093a a = C24092b.m37058a(this.mContext, am, i, i2, count, dimensionPixelSize, z2);
                            this.zRW = i2 - this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10372zh);
                            C5227ai.m7971d("MicroMsg.MMPopupMenu", "showPointY=" + i2 + "verticalOffset=" + this.zRW, new Object[0]);
                            this.yHM = new MMListPopupWindow(this.mContext, null, 0);
                            this.yHM.setOnDismissListener(this);
                            this.yHM.amz = new C159993();
                            this.yHM.setAdapter(this.zRU);
                            this.yHM.setModal(this.zSb);
                            this.yHM.amt = this.zSc;
                            this.yHM.setBackgroundDrawable(this.mContext.getResources().getDrawable(C25738R.drawable.bij));
                            this.yHM.setAnimationStyle(a.zSf);
                            this.yHM.amm = a.jiV;
                            this.yHM.setVerticalOffset(a.rDO);
                            this.yHM.amx = this.zbD;
                            this.yHM.setContentWidth(am);
                            this.yHM.mo39308iZ();
                            if (!(this.mContext instanceof Activity) || ((Activity) this.mContext).isFinishing()) {
                                AppMethodBeat.m2505o(112769);
                                return false;
                            }
                            this.yHM.show();
                            this.yHM.yvM.setOnKeyListener(this);
                            this.yHM.yvM.setDivider(new ColorDrawable(this.mContext.getResources().getColor(C25738R.color.a04)));
                            this.yHM.yvM.setSelector(this.mContext.getResources().getDrawable(C25738R.drawable.f6964x0));
                            this.yHM.yvM.setDividerHeight(0);
                            this.yHM.yvM.setVerticalScrollBarEnabled(false);
                            this.yHM.yvM.setHorizontalScrollBarEnabled(false);
                        }
                        AppMethodBeat.m2505o(112769);
                        return true;
                    }
                    C5227ai.m7975w("MicroMsg.MMPopupMenu", "is swiping, PASS tryShow", new Object[0]);
                    AppMethodBeat.m2505o(112769);
                    return false;
                }
            }
        }
        z = false;
        if (z) {
        }
    }

    /* renamed from: hD */
    private void m37053hD(int i, int i2) {
        AppMethodBeat.m2504i(112770);
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(C25738R.dimen.f9979m4);
        int dimensionPixelOffset2 = this.mContext.getResources().getDimensionPixelOffset(C25738R.dimen.f9948l5);
        this.zRV = new C46633o(this.mContext);
        this.zRV.setWidth(-2);
        this.zRV.setHeight(-2);
        this.zRV.setBackgroundDrawable(this.mContext.getResources().getDrawable(C25738R.drawable.bij));
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundColor(this.mContext.getResources().getColor(C25738R.color.a69));
        for (int i3 = 0; i3 < this.rBn.size(); i3++) {
            TextView textView = (TextView) this.mInflater.inflate(2130969839, null, false);
            textView.setBackground(this.mContext.getResources().getDrawable(C25738R.drawable.f6964x0));
            if (i3 == 0) {
                textView.setPadding(dimensionPixelOffset2, 0, dimensionPixelOffset, 0);
            } else if (i3 == this.rBn.size() - 1) {
                textView.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset2, 0);
            }
            textView.setText(((MenuItem) this.rBn.yvT.get(i3)).getTitle());
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(112758);
                    if (C24088a.this.rBm != null) {
                        C24088a.this.rBm.onMMMenuItemSelected(C24088a.this.rBn.getItem(i3), i3);
                    }
                    C24088a.this.zRV.dismiss();
                    AppMethodBeat.m2505o(112758);
                }
            });
            linearLayout.addView(textView);
        }
        linearLayout.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = linearLayout.getMeasuredHeight();
        this.zRV.setContentView(linearLayout);
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing()) {
            this.zRV.showAtLocation(this.zbD, 0, i, i2 - measuredHeight);
        }
        AppMethodBeat.m2505o(112770);
    }

    private boolean isShowing() {
        AppMethodBeat.m2504i(112771);
        if (this.yHM == null || !this.yHM.gKG.isShowing()) {
            AppMethodBeat.m2505o(112771);
            return false;
        }
        AppMethodBeat.m2505o(112771);
        return true;
    }

    private boolean dLh() {
        AppMethodBeat.m2504i(112772);
        if (this.zRV == null || !this.zRV.isShowing()) {
            AppMethodBeat.m2505o(112772);
            return false;
        }
        AppMethodBeat.m2505o(112772);
        return true;
    }

    public final boolean dBX() {
        AppMethodBeat.m2504i(112773);
        if (isShowing()) {
            if (this.yHM != null) {
                this.yHM.dismiss();
            }
            AppMethodBeat.m2505o(112773);
            return true;
        } else if (dLh()) {
            if (this.zRV != null) {
                this.zRV.dismiss();
            }
            AppMethodBeat.m2505o(112773);
            return true;
        } else {
            AppMethodBeat.m2505o(112773);
            return false;
        }
    }

    /* renamed from: dn */
    public boolean mo22431dn(int i, int i2) {
        int i3;
        boolean hC;
        AppMethodBeat.m2504i(112774);
        if (!(((this.zbD == null || this.zbD.equals(this.nWa)) && zRT) || (i == 0 && i2 == 0))) {
            zRR = i;
            zRS = i2;
        }
        this.nWa = null;
        int i4 = zRR;
        int i5 = zRS;
        zRT = false;
        if (this.cbh == null) {
            this.cbh = this.mContext.getResources().getDisplayMetrics();
        }
        if (this.zbD != null) {
            int[] iArr = new int[2];
            this.zbD.getLocationOnScreen(iArr);
            if (i4 == 0) {
                i4 = iArr[0] + (this.zbD.getWidth() / 2);
            }
            i3 = iArr[1];
            int height = iArr[1] + this.zbD.getHeight();
            if (i3 < 0) {
                i3 = 0;
            }
            if (height > this.cbh.heightPixels) {
                height = this.cbh.heightPixels;
            }
            if (i5 == 0) {
                i3 = (i3 + height) / 2;
                C5227ai.m7973i("MicroMsg.MMPopupMenu", "show popMenu , xDown:%s, yDown:%s, showPointX:%s, showPointY:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3));
                if (isShowing() || !dLh()) {
                    hC = m37052hC(i4, i3);
                    AppMethodBeat.m2505o(112774);
                    return hC;
                }
                hC = m37052hC(i4, i3) & dBX();
                AppMethodBeat.m2505o(112774);
                return hC;
            }
        }
        i3 = i5;
        C5227ai.m7973i("MicroMsg.MMPopupMenu", "show popMenu , xDown:%s, yDown:%s, showPointX:%s, showPointY:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3));
        if (isShowing()) {
        }
        hC = m37052hC(i4, i3);
        AppMethodBeat.m2505o(112774);
        return hC;
    }

    private void initView() {
        AppMethodBeat.m2504i(112775);
        dBX();
        this.rBn = new C44273l(this.mContext);
        this.zRU = new C24090a(this, (byte) 0);
        this.cbh = this.mContext.getResources().getDisplayMetrics();
        AppMethodBeat.m2505o(112775);
    }

    private void dLi() {
        AppMethodBeat.m2504i(112776);
        this.zbD.setOnTouchListener(new C240915());
        AppMethodBeat.m2505o(112776);
    }

    /* renamed from: b */
    private int m37045b(ListAdapter listAdapter) {
        AppMethodBeat.m2504i(112777);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i = 0;
        int i2 = 0;
        View view = null;
        int i3 = 0;
        while (i < count) {
            int itemViewType = listAdapter.getItemViewType(i);
            if (itemViewType != i2) {
                view = null;
            } else {
                itemViewType = i2;
            }
            view = listAdapter.getView(i, view, new FrameLayout(this.mContext));
            if (view != null) {
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 = Math.max(i3, view.getMeasuredWidth());
            }
            i++;
            i2 = itemViewType;
        }
        AppMethodBeat.m2505o(112777);
        return i3;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        return false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public void onDismiss() {
        AppMethodBeat.m2504i(112778);
        if (!this.zRX) {
            if (this.zRY != null) {
                this.zRY.setSelected(false);
            } else {
                this.zbD.setSelected(false);
            }
        }
        if (this.zHM != null) {
            this.zHM.onDismiss();
        }
        AppMethodBeat.m2505o(112778);
    }
}
