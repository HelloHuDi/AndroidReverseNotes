package com.tencent.mm.ui.chatting;

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
import com.tencent.mm.R;
import com.tencent.mm.aj.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.MMListPopupWindow;
import java.util.Iterator;
import java.util.List;

public final class g implements OnKeyListener, OnItemClickListener, OnDismissListener {
    private int height;
    private Context mContext = null;
    private int mCount;
    private LayoutInflater mInflater;
    OnItemClickListener yHJ = null;
    private ViewGroup yHK = null;
    private b yHL = null;
    private MMListPopupWindow yHM;
    private int yHN = R.style.uz;
    private int yHO;
    j yHP = null;
    private boolean yHQ = true;

    class b extends BaseAdapter {
        private b() {
        }

        /* synthetic */ b(g gVar, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(30500);
            j Oi = Oi(i);
            AppMethodBeat.o(30500);
            return Oi;
        }

        public final int getCount() {
            AppMethodBeat.i(30497);
            int a = g.this.mCount;
            AppMethodBeat.o(30497);
            return a;
        }

        private j Oi(int i) {
            AppMethodBeat.i(30498);
            j jVar = (j) g.this.yHP.fwr.get(i);
            AppMethodBeat.o(30498);
            return jVar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView;
            AppMethodBeat.i(30499);
            if (view == null) {
                textView = (TextView) g.this.mInflater.inflate(R.layout.ako, viewGroup, false);
            } else {
                textView = (TextView) view;
            }
            j Oi = Oi(i);
            textView.setTag(Oi);
            textView.setText(com.tencent.mm.pluginsdk.ui.e.j.b(g.this.mContext, Oi.name));
            AppMethodBeat.o(30499);
            return textView;
        }
    }

    public static class a {
        private static DisplayMetrics yHR = null;

        public static class a {
            public int jiU;
            public int jiV;

            public final String toString() {
                AppMethodBeat.i(30495);
                String str = " marginLeft:" + this.jiU + " marginRight:" + this.jiV;
                AppMethodBeat.o(30495);
                return str;
            }
        }

        public static a a(Context context, TextPaint textPaint, List<j> list, int i) {
            float f;
            AppMethodBeat.i(30496);
            a aVar = new a();
            if (yHR == null) {
                yHR = context.getResources().getDisplayMetrics();
            }
            DisplayMetrics displayMetrics = yHR;
            Point hy = al.hy(context);
            int i2 = hy.x;
            if (!(i2 == displayMetrics.widthPixels && hy.y == displayMetrics.heightPixels)) {
                ab.e("MicroMsg.ChatFooterCustomSubmenu", "get screen param error!! width:%s, systermWidth:%s, height:%s, systermHeight:%s", Integer.valueOf(i2), Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(hy.y), Integer.valueOf(displayMetrics.heightPixels));
            }
            float f2 = 0.0f;
            Iterator it = list.iterator();
            while (true) {
                f = f2;
                if (!it.hasNext()) {
                    break;
                }
                f2 = textPaint.measureText(((j) it.next()).name);
                if (f >= f2) {
                    f2 = f;
                }
            }
            int fromDPToPix = (com.tencent.mm.bz.a.fromDPToPix(context, 30) * 2) + ((int) f);
            int fromDPToPix2 = com.tencent.mm.bz.a.fromDPToPix(context, 95);
            if (fromDPToPix >= fromDPToPix2) {
                fromDPToPix2 = fromDPToPix;
            }
            if (i - (fromDPToPix2 / 2) < 0) {
                aVar.jiU = 0;
                aVar.jiV = i2 - (fromDPToPix2 + 0);
            } else if (i2 - ((fromDPToPix2 / 2) + i) < 0) {
                aVar.jiU = i2 - (fromDPToPix2 + 0);
                aVar.jiV = 0;
            } else {
                aVar.jiU = i - (fromDPToPix2 / 2);
                aVar.jiV = i2 - ((fromDPToPix2 / 2) + i);
            }
            AppMethodBeat.o(30496);
            return aVar;
        }
    }

    public g(Context context, ViewGroup viewGroup) {
        AppMethodBeat.i(30501);
        this.mContext = context;
        this.yHK = viewGroup;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        dBX();
        this.yHL = new b(this, (byte) 0);
        AppMethodBeat.o(30501);
    }

    @SuppressLint({"WrongCall"})
    public final boolean a(j jVar, int i, int i2) {
        AppMethodBeat.i(30502);
        if (isShowing() || jVar == null || jVar.fwr == null || jVar.fwr.size() <= 0) {
            AppMethodBeat.o(30502);
            return false;
        }
        this.yHQ = false;
        this.yHP = jVar;
        this.mCount = jVar.fwr.size();
        this.yHL.notifyDataSetChanged();
        this.height = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getHeight();
        a a = a.a(this.mContext, ((TextView) ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.ako, null)).getPaint(), jVar.fwr, i);
        this.yHO = (i2 - (this.yHL.getCount() * this.mContext.getResources().getDimensionPixelSize(R.dimen.nb))) - this.mContext.getResources().getDimensionPixelSize(R.dimen.i9);
        ab.d("MicroMsg.ChatFooterCustomSubmenu", "showPointY=" + i2 + "verticalOffset=" + this.yHO);
        this.yHM = new MMListPopupWindow(this.mContext, null, 0);
        this.yHM.setOnDismissListener(this);
        this.yHM.amz = this.yHJ;
        this.yHM.setAdapter(this.yHL);
        this.yHM.setModal(true);
        this.yHM.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bij));
        this.yHM.setAnimationStyle(this.yHN);
        this.yHM.amm = a.jiV;
        this.yHM.setVerticalOffset(this.yHO);
        this.yHM.amx = this.yHK;
        this.yHM.setContentWidth(b(this.yHL));
        this.yHM.iZ();
        this.yHM.show();
        this.yHM.yvM.setOnKeyListener(this);
        this.yHM.yvM.setDivider(new ColorDrawable(this.mContext.getResources().getColor(R.color.a04)));
        this.yHM.yvM.setSelector(this.mContext.getResources().getDrawable(R.drawable.x0));
        this.yHM.yvM.setDividerHeight(1);
        this.yHM.yvM.setVerticalScrollBarEnabled(false);
        this.yHM.yvM.setHorizontalScrollBarEnabled(false);
        AppMethodBeat.o(30502);
        return true;
    }

    public final boolean isShowing() {
        AppMethodBeat.i(30503);
        if (this.yHM == null || !this.yHM.gKG.isShowing()) {
            AppMethodBeat.o(30503);
            return false;
        }
        AppMethodBeat.o(30503);
        return true;
    }

    public final boolean dBX() {
        AppMethodBeat.i(30504);
        if (isShowing()) {
            this.yHM.dismiss();
            AppMethodBeat.o(30504);
            return true;
        }
        AppMethodBeat.o(30504);
        return false;
    }

    private int b(ListAdapter listAdapter) {
        AppMethodBeat.i(30505);
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
        AppMethodBeat.o(30505);
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
