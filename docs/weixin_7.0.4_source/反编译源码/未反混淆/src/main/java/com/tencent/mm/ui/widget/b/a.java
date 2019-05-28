package com.tencent.mm.ui.widget.b;

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
import com.tencent.mm.R;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.o;

public class a implements OnKeyListener, OnItemClickListener, OnDismissListener {
    private static int zRR;
    private static int zRS;
    private static boolean zRT = false;
    private DisplayMetrics cbh;
    private Context mContext = null;
    private LayoutInflater mInflater;
    private View nWa;
    public d rBm;
    private l rBn;
    private MMListPopupWindow yHM;
    public OnDismissListener zHM;
    private a zRU = null;
    private o zRV;
    private int zRW;
    private boolean zRX = false;
    public View zRY;
    public OnCreateContextMenuListener zRZ;
    public boolean zSa = false;
    public boolean zSb = true;
    public boolean zSc = false;
    private View zbD = null;

    class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(112760);
            int size = a.this.rBn.size();
            AppMethodBeat.o(112760);
            return size;
        }

        private String getItem(int i) {
            AppMethodBeat.i(112761);
            String str = (String) ((MenuItem) a.this.rBn.yvT.get(i)).getTitle();
            AppMethodBeat.o(112761);
            return str;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(112762);
            TextView textView = null;
            if (view == null) {
                textView = (TextView) a.this.mInflater.inflate(R.layout.ako, viewGroup, false);
            } else if (view instanceof TextView) {
                textView = (TextView) view;
            }
            String item = getItem(i);
            if (textView != null) {
                textView.setTag(item);
                textView.setText(item);
            }
            AppMethodBeat.o(112762);
            return textView;
        }
    }

    public a(Context context, View view) {
        AppMethodBeat.i(112764);
        this.mContext = context;
        this.zbD = view;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        initView();
        dLi();
        AppMethodBeat.o(112764);
    }

    public a(Context context) {
        AppMethodBeat.i(112765);
        this.mContext = context;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        initView();
        AppMethodBeat.o(112765);
    }

    public final void c(View view, final OnCreateContextMenuListener onCreateContextMenuListener, d dVar) {
        AppMethodBeat.i(112766);
        this.zbD = view;
        dLi();
        this.rBm = dVar;
        if (view instanceof AbsListView) {
            ai.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView", new Object[0]);
            ((AbsListView) view).setOnItemLongClickListener(new OnItemLongClickListener() {
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(112755);
                    a.this.rBn.clear();
                    ai.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView long click", new Object[0]);
                    AdapterContextMenuInfo adapterContextMenuInfo = new AdapterContextMenuInfo(view, i, j);
                    onCreateContextMenuListener.onCreateContextMenu(a.this.rBn, view, adapterContextMenuInfo);
                    for (MenuItem menuItem : a.this.rBn.yvT) {
                        ((m) menuItem).yvW = adapterContextMenuInfo;
                    }
                    a.this.dn(0, 0);
                    AppMethodBeat.o(112755);
                    return true;
                }
            });
            AppMethodBeat.o(112766);
            return;
        }
        ai.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view", new Object[0]);
        view.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                AppMethodBeat.i(112756);
                ai.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view long click", new Object[0]);
                a.this.rBn.clear();
                a.this.zbD = view;
                onCreateContextMenuListener.onCreateContextMenu(a.this.rBn, view, null);
                if (view.getTag(R.id.cy) instanceof int[]) {
                    int[] iArr = (int[]) view.getTag(R.id.cy);
                    if (iArr == null) {
                        a.this.dn(0, 0);
                    } else {
                        a.this.dn(iArr[0], iArr[1]);
                    }
                } else {
                    a.this.dn(0, 0);
                }
                AppMethodBeat.o(112756);
                return true;
            }
        });
        AppMethodBeat.o(112766);
    }

    public final void a(View view, int i, long j, OnCreateContextMenuListener onCreateContextMenuListener, d dVar, int i2, int i3) {
        AppMethodBeat.i(112767);
        this.rBm = dVar;
        this.zbD = view;
        dLi();
        this.rBn.clear();
        AdapterContextMenuInfo adapterContextMenuInfo = new AdapterContextMenuInfo(view, i, j);
        onCreateContextMenuListener.onCreateContextMenu(this.rBn, view, adapterContextMenuInfo);
        for (MenuItem menuItem : this.rBn.yvT) {
            ((m) menuItem).yvW = adapterContextMenuInfo;
        }
        if (i2 == 0 && i3 == 0) {
            dn(0, 0);
            AppMethodBeat.o(112767);
            return;
        }
        dn(i2, i3);
        AppMethodBeat.o(112767);
    }

    public final void a(View view, OnCreateContextMenuListener onCreateContextMenuListener, d dVar, int i, int i2) {
        AppMethodBeat.i(112768);
        this.rBm = dVar;
        this.zbD = view;
        if (!(view instanceof TextView) && (i == 0 || i2 == 0)) {
            dLi();
        }
        this.rBn.clear();
        onCreateContextMenuListener.onCreateContextMenu(this.rBn, view, null);
        if (i == 0 && i2 == 0) {
            dn(0, 0);
            AppMethodBeat.o(112768);
            return;
        }
        dn(i, i2);
        AppMethodBeat.o(112768);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean hC(int i, int i2) {
        AppMethodBeat.i(112769);
        if (isShowing() || dLh()) {
            AppMethodBeat.o(112769);
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
                        int count = this.zRU.getCount() * this.mContext.getResources().getDimensionPixelSize(R.dimen.nb);
                        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.zh);
                        int b = b(this.zRU);
                        int am = aj.am(this.mContext, R.dimen.a5z);
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
                            hD(i, i2);
                        } else {
                            com.tencent.mm.ui.widget.b.b.a a = b.a(this.mContext, am, i, i2, count, dimensionPixelSize, z2);
                            this.zRW = i2 - this.mContext.getResources().getDimensionPixelSize(R.dimen.zh);
                            ai.d("MicroMsg.MMPopupMenu", "showPointY=" + i2 + "verticalOffset=" + this.zRW, new Object[0]);
                            this.yHM = new MMListPopupWindow(this.mContext, null, 0);
                            this.yHM.setOnDismissListener(this);
                            this.yHM.amz = new OnItemClickListener() {
                                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                                    AppMethodBeat.i(112757);
                                    if (a.this.rBm != null) {
                                        a.this.rBm.onMMMenuItemSelected(a.this.rBn.getItem(i), i);
                                    }
                                    if (a.this.yHM != null && a.this.yHM.gKG.isShowing()) {
                                        a.this.yHM.dismiss();
                                    }
                                    AppMethodBeat.o(112757);
                                }
                            };
                            this.yHM.setAdapter(this.zRU);
                            this.yHM.setModal(this.zSb);
                            this.yHM.amt = this.zSc;
                            this.yHM.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bij));
                            this.yHM.setAnimationStyle(a.zSf);
                            this.yHM.amm = a.jiV;
                            this.yHM.setVerticalOffset(a.rDO);
                            this.yHM.amx = this.zbD;
                            this.yHM.setContentWidth(am);
                            this.yHM.iZ();
                            if (!(this.mContext instanceof Activity) || ((Activity) this.mContext).isFinishing()) {
                                AppMethodBeat.o(112769);
                                return false;
                            }
                            this.yHM.show();
                            this.yHM.yvM.setOnKeyListener(this);
                            this.yHM.yvM.setDivider(new ColorDrawable(this.mContext.getResources().getColor(R.color.a04)));
                            this.yHM.yvM.setSelector(this.mContext.getResources().getDrawable(R.drawable.x0));
                            this.yHM.yvM.setDividerHeight(0);
                            this.yHM.yvM.setVerticalScrollBarEnabled(false);
                            this.yHM.yvM.setHorizontalScrollBarEnabled(false);
                        }
                        AppMethodBeat.o(112769);
                        return true;
                    }
                    ai.w("MicroMsg.MMPopupMenu", "is swiping, PASS tryShow", new Object[0]);
                    AppMethodBeat.o(112769);
                    return false;
                }
            }
        }
        z = false;
        if (z) {
        }
    }

    private void hD(int i, int i2) {
        AppMethodBeat.i(112770);
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.m4);
        int dimensionPixelOffset2 = this.mContext.getResources().getDimensionPixelOffset(R.dimen.l5);
        this.zRV = new o(this.mContext);
        this.zRV.setWidth(-2);
        this.zRV.setHeight(-2);
        this.zRV.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bij));
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundColor(this.mContext.getResources().getColor(R.color.a69));
        for (int i3 = 0; i3 < this.rBn.size(); i3++) {
            TextView textView = (TextView) this.mInflater.inflate(R.layout.a7b, null, false);
            textView.setBackground(this.mContext.getResources().getDrawable(R.drawable.x0));
            if (i3 == 0) {
                textView.setPadding(dimensionPixelOffset2, 0, dimensionPixelOffset, 0);
            } else if (i3 == this.rBn.size() - 1) {
                textView.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset2, 0);
            }
            textView.setText(((MenuItem) this.rBn.yvT.get(i3)).getTitle());
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(112758);
                    if (a.this.rBm != null) {
                        a.this.rBm.onMMMenuItemSelected(a.this.rBn.getItem(i3), i3);
                    }
                    a.this.zRV.dismiss();
                    AppMethodBeat.o(112758);
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
        AppMethodBeat.o(112770);
    }

    private boolean isShowing() {
        AppMethodBeat.i(112771);
        if (this.yHM == null || !this.yHM.gKG.isShowing()) {
            AppMethodBeat.o(112771);
            return false;
        }
        AppMethodBeat.o(112771);
        return true;
    }

    private boolean dLh() {
        AppMethodBeat.i(112772);
        if (this.zRV == null || !this.zRV.isShowing()) {
            AppMethodBeat.o(112772);
            return false;
        }
        AppMethodBeat.o(112772);
        return true;
    }

    public final boolean dBX() {
        AppMethodBeat.i(112773);
        if (isShowing()) {
            if (this.yHM != null) {
                this.yHM.dismiss();
            }
            AppMethodBeat.o(112773);
            return true;
        } else if (dLh()) {
            if (this.zRV != null) {
                this.zRV.dismiss();
            }
            AppMethodBeat.o(112773);
            return true;
        } else {
            AppMethodBeat.o(112773);
            return false;
        }
    }

    public boolean dn(int i, int i2) {
        int i3;
        boolean hC;
        AppMethodBeat.i(112774);
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
                ai.i("MicroMsg.MMPopupMenu", "show popMenu , xDown:%s, yDown:%s, showPointX:%s, showPointY:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3));
                if (isShowing() || !dLh()) {
                    hC = hC(i4, i3);
                    AppMethodBeat.o(112774);
                    return hC;
                }
                hC = hC(i4, i3) & dBX();
                AppMethodBeat.o(112774);
                return hC;
            }
        }
        i3 = i5;
        ai.i("MicroMsg.MMPopupMenu", "show popMenu , xDown:%s, yDown:%s, showPointX:%s, showPointY:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3));
        if (isShowing()) {
        }
        hC = hC(i4, i3);
        AppMethodBeat.o(112774);
        return hC;
    }

    private void initView() {
        AppMethodBeat.i(112775);
        dBX();
        this.rBn = new l(this.mContext);
        this.zRU = new a(this, (byte) 0);
        this.cbh = this.mContext.getResources().getDisplayMetrics();
        AppMethodBeat.o(112775);
    }

    private void dLi() {
        AppMethodBeat.i(112776);
        this.zbD.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(112759);
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        a.zRR = (int) motionEvent.getRawX();
                        a.zRS = (int) motionEvent.getRawY();
                        a.this.nWa = a.this.zbD;
                        a.zRT = true;
                        ai.i("MicroMsg.MMPopupMenu", "popmenu view set , x_down=" + a.zRR + "y_down=" + a.zRS, new Object[0]);
                        break;
                }
                AppMethodBeat.o(112759);
                return false;
            }
        });
        AppMethodBeat.o(112776);
    }

    private int b(ListAdapter listAdapter) {
        AppMethodBeat.i(112777);
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
        AppMethodBeat.o(112777);
        return i3;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        return false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public void onDismiss() {
        AppMethodBeat.i(112778);
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
        AppMethodBeat.o(112778);
    }
}
