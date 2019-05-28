package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public class LuckyMoneyAutoScrollItem extends ListView {
    public static SparseArray<Integer> ocb;
    private int YF;
    private Context mContext;
    private a obV;
    private long obW;
    private int obX;
    private CountDownTimer obY;
    private int obZ;
    private b oca;

    class a extends BaseAdapter {

        class a {
            ImageView ocf;

            a() {
            }
        }

        private a() {
        }

        /* synthetic */ a(LuckyMoneyAutoScrollItem luckyMoneyAutoScrollItem, byte b) {
            this();
        }

        public final int getCount() {
            return 2147483646;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(42562);
            Integer valueOf = Integer.valueOf(i % 10);
            AppMethodBeat.o(42562);
            return valueOf;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(42563);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(LuckyMoneyAutoScrollItem.this.mContext).inflate(R.layout.a_r, null);
                a aVar2 = new a();
                aVar2.ocf = (ImageView) view.findViewById(R.id.csq);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.ocf.setImageResource(((Integer) LuckyMoneyAutoScrollItem.ocb.get(i % 10)).intValue());
            AppMethodBeat.o(42563);
            return view;
        }
    }

    interface b {
        void aQe();
    }

    static /* synthetic */ int a(LuckyMoneyAutoScrollItem luckyMoneyAutoScrollItem) {
        int i = luckyMoneyAutoScrollItem.YF + 1;
        luckyMoneyAutoScrollItem.YF = i;
        return i;
    }

    static {
        AppMethodBeat.i(42567);
        SparseArray sparseArray = new SparseArray();
        ocb = sparseArray;
        sparseArray.put(0, Integer.valueOf(R.drawable.bcr));
        ocb.put(1, Integer.valueOf(R.drawable.bcs));
        ocb.put(2, Integer.valueOf(R.drawable.bct));
        ocb.put(3, Integer.valueOf(R.drawable.bcu));
        ocb.put(4, Integer.valueOf(R.drawable.bcv));
        ocb.put(5, Integer.valueOf(R.drawable.bcw));
        ocb.put(6, Integer.valueOf(R.drawable.bcx));
        ocb.put(7, Integer.valueOf(R.drawable.bcy));
        ocb.put(8, Integer.valueOf(R.drawable.bcz));
        ocb.put(9, Integer.valueOf(R.drawable.bd0));
        AppMethodBeat.o(42567);
    }

    public LuckyMoneyAutoScrollItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.i(42564);
        this.obV = null;
        this.obW = 900;
        this.obX = 0;
        this.YF = 0;
        this.oca = null;
        this.mContext = context;
        this.obV = new a(this, (byte) 0);
        setAdapter(this.obV);
        this.obZ = (int) ((this.mContext.getResources().getDisplayMetrics().density * 60.0f) + 0.5f);
        ab.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: scroll height is: %d", Integer.valueOf(this.obZ));
        AppMethodBeat.o(42564);
    }

    public LuckyMoneyAutoScrollItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setScrollTime(long j) {
        this.obW = j;
    }

    public static void setResouceMap(SparseArray<Integer> sparseArray) {
        AppMethodBeat.i(42565);
        ocb.clear();
        for (int i = 0; i < sparseArray.size(); i++) {
            int keyAt = sparseArray.keyAt(i);
            ocb.put(keyAt, sparseArray.get(keyAt));
        }
        AppMethodBeat.o(42565);
    }

    /* Access modifiers changed, original: 0000 */
    public void setOnScrollEndListener(b bVar) {
        this.oca = bVar;
    }

    public final void bMm() {
        AppMethodBeat.i(42566);
        if (this.obY != null) {
            this.obY.cancel();
        }
        final long j = ((long) (this.obX * 50)) + this.obW;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(42561);
                LuckyMoneyAutoScrollItem.this.obY = new CountDownTimer(j) {
                    public final void onTick(long j) {
                        AppMethodBeat.i(42559);
                        LuckyMoneyAutoScrollItem.this.smoothScrollToPosition(LuckyMoneyAutoScrollItem.a(LuckyMoneyAutoScrollItem.this));
                        AppMethodBeat.o(42559);
                    }

                    public final void onFinish() {
                        AppMethodBeat.i(42560);
                        if (LuckyMoneyAutoScrollItem.this.oca != null) {
                            LuckyMoneyAutoScrollItem.this.oca.aQe();
                        }
                        AppMethodBeat.o(42560);
                    }
                }.start();
                AppMethodBeat.o(42561);
            }
        });
        AppMethodBeat.o(42566);
    }

    public void setFinalNumber(int i) {
        this.obX = i;
    }
}
