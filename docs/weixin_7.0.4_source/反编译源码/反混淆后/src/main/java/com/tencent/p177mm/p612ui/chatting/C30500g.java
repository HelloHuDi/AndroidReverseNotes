package com.tencent.p177mm.p612ui.chatting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p184aj.C37455j;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5231al;
import com.tencent.p177mm.p612ui.base.MMListPopupWindow;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.ui.chatting.g */
public final class C30500g implements OnKeyListener, OnItemClickListener, OnDismissListener {
    private int height;
    private Context mContext = null;
    private int mCount;
    private LayoutInflater mInflater;
    OnItemClickListener yHJ = null;
    private ViewGroup yHK = null;
    private C30501b yHL = null;
    private MMListPopupWindow yHM;
    private int yHN = C25738R.style.f11269uz;
    private int yHO;
    C37455j yHP = null;
    private boolean yHQ = true;

    /* renamed from: com.tencent.mm.ui.chatting.g$b */
    class C30501b extends BaseAdapter {
        private C30501b() {
        }

        /* synthetic */ C30501b(C30500g c30500g, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(30500);
            C37455j Oi = m48602Oi(i);
            AppMethodBeat.m2505o(30500);
            return Oi;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(30497);
            int a = C30500g.this.mCount;
            AppMethodBeat.m2505o(30497);
            return a;
        }

        /* renamed from: Oi */
        private C37455j m48602Oi(int i) {
            AppMethodBeat.m2504i(30498);
            C37455j c37455j = (C37455j) C30500g.this.yHP.fwr.get(i);
            AppMethodBeat.m2505o(30498);
            return c37455j;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView;
            AppMethodBeat.m2504i(30499);
            if (view == null) {
                textView = (TextView) C30500g.this.mInflater.inflate(2130970371, viewGroup, false);
            } else {
                textView = (TextView) view;
            }
            C37455j Oi = m48602Oi(i);
            textView.setTag(Oi);
            textView.setText(C44089j.m79292b(C30500g.this.mContext, Oi.name));
            AppMethodBeat.m2505o(30499);
            return textView;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.g$a */
    public static class C30502a {
        private static DisplayMetrics yHR = null;

        /* renamed from: com.tencent.mm.ui.chatting.g$a$a */
        public static class C15644a {
            public int jiU;
            public int jiV;

            public final String toString() {
                AppMethodBeat.m2504i(30495);
                String str = " marginLeft:" + this.jiU + " marginRight:" + this.jiV;
                AppMethodBeat.m2505o(30495);
                return str;
            }
        }

        /* renamed from: a */
        public static C15644a m48603a(Context context, TextPaint textPaint, List<C37455j> list, int i) {
            float f;
            AppMethodBeat.m2504i(30496);
            C15644a c15644a = new C15644a();
            if (yHR == null) {
                yHR = context.getResources().getDisplayMetrics();
            }
            DisplayMetrics displayMetrics = yHR;
            Point hy = C5231al.m7995hy(context);
            int i2 = hy.x;
            if (!(i2 == displayMetrics.widthPixels && hy.y == displayMetrics.heightPixels)) {
                C4990ab.m7413e("MicroMsg.ChatFooterCustomSubmenu", "get screen param error!! width:%s, systermWidth:%s, height:%s, systermHeight:%s", Integer.valueOf(i2), Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(hy.y), Integer.valueOf(displayMetrics.heightPixels));
            }
            float f2 = 0.0f;
            Iterator it = list.iterator();
            while (true) {
                f = f2;
                if (!it.hasNext()) {
                    break;
                }
                f2 = textPaint.measureText(((C37455j) it.next()).name);
                if (f >= f2) {
                    f2 = f;
                }
            }
            int fromDPToPix = (C1338a.fromDPToPix(context, 30) * 2) + ((int) f);
            int fromDPToPix2 = C1338a.fromDPToPix(context, 95);
            if (fromDPToPix >= fromDPToPix2) {
                fromDPToPix2 = fromDPToPix;
            }
            if (i - (fromDPToPix2 / 2) < 0) {
                c15644a.jiU = 0;
                c15644a.jiV = i2 - (fromDPToPix2 + 0);
            } else if (i2 - ((fromDPToPix2 / 2) + i) < 0) {
                c15644a.jiU = i2 - (fromDPToPix2 + 0);
                c15644a.jiV = 0;
            } else {
                c15644a.jiU = i - (fromDPToPix2 / 2);
                c15644a.jiV = i2 - ((fromDPToPix2 / 2) + i);
            }
            AppMethodBeat.m2505o(30496);
            return c15644a;
        }
    }

    public C30500g(Context context, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(30501);
        this.mContext = context;
        this.yHK = viewGroup;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        dBX();
        this.yHL = new C30501b(this, (byte) 0);
        AppMethodBeat.m2505o(30501);
    }

    @SuppressLint({"WrongCall"})
    /* renamed from: a */
    public final boolean mo48914a(C37455j c37455j, int i, int i2) {
        AppMethodBeat.m2504i(30502);
        if (isShowing() || c37455j == null || c37455j.fwr == null || c37455j.fwr.size() <= 0) {
            AppMethodBeat.m2505o(30502);
            return false;
        }
        this.yHQ = false;
        this.yHP = c37455j;
        this.mCount = c37455j.fwr.size();
        this.yHL.notifyDataSetChanged();
        this.height = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getHeight();
        C15644a a = C30502a.m48603a(this.mContext, ((TextView) ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(2130970371, null)).getPaint(), c37455j.fwr, i);
        this.yHO = (i2 - (this.yHL.getCount() * this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10010nb))) - this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9863i9);
        C4990ab.m7410d("MicroMsg.ChatFooterCustomSubmenu", "showPointY=" + i2 + "verticalOffset=" + this.yHO);
        this.yHM = new MMListPopupWindow(this.mContext, null, 0);
        this.yHM.setOnDismissListener(this);
        this.yHM.amz = this.yHJ;
        this.yHM.setAdapter(this.yHL);
        this.yHM.setModal(true);
        this.yHM.setBackgroundDrawable(this.mContext.getResources().getDrawable(C25738R.drawable.bij));
        this.yHM.setAnimationStyle(this.yHN);
        this.yHM.amm = a.jiV;
        this.yHM.setVerticalOffset(this.yHO);
        this.yHM.amx = this.yHK;
        this.yHM.setContentWidth(m48597b(this.yHL));
        this.yHM.mo39308iZ();
        this.yHM.show();
        this.yHM.yvM.setOnKeyListener(this);
        this.yHM.yvM.setDivider(new ColorDrawable(this.mContext.getResources().getColor(C25738R.color.a04)));
        this.yHM.yvM.setSelector(this.mContext.getResources().getDrawable(C25738R.drawable.f6964x0));
        this.yHM.yvM.setDividerHeight(1);
        this.yHM.yvM.setVerticalScrollBarEnabled(false);
        this.yHM.yvM.setHorizontalScrollBarEnabled(false);
        AppMethodBeat.m2505o(30502);
        return true;
    }

    public final boolean isShowing() {
        AppMethodBeat.m2504i(30503);
        if (this.yHM == null || !this.yHM.gKG.isShowing()) {
            AppMethodBeat.m2505o(30503);
            return false;
        }
        AppMethodBeat.m2505o(30503);
        return true;
    }

    public final boolean dBX() {
        AppMethodBeat.m2504i(30504);
        if (isShowing()) {
            this.yHM.dismiss();
            AppMethodBeat.m2505o(30504);
            return true;
        }
        AppMethodBeat.m2505o(30504);
        return false;
    }

    /* renamed from: b */
    private int m48597b(ListAdapter listAdapter) {
        AppMethodBeat.m2504i(30505);
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
            if (this.yHK == null) {
                this.yHK = new FrameLayout(this.mContext);
            }
            view = listAdapter.getView(i, view, this.yHK);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
            i++;
            i2 = itemViewType;
        }
        AppMethodBeat.m2505o(30505);
        return i3;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        return false;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public final void onDismiss() {
    }
}
