package com.tencent.p177mm.plugin.luckymoney.p449ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollItem */
public class LuckyMoneyAutoScrollItem extends ListView {
    public static SparseArray<Integer> ocb;
    /* renamed from: YF */
    private int f17207YF;
    private Context mContext;
    private C34460a obV;
    private long obW;
    private int obX;
    private CountDownTimer obY;
    private int obZ;
    private C34462b oca;

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollItem$a */
    class C34460a extends BaseAdapter {

        /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollItem$a$a */
        class C34461a {
            ImageView ocf;

            C34461a() {
            }
        }

        private C34460a() {
        }

        /* synthetic */ C34460a(LuckyMoneyAutoScrollItem luckyMoneyAutoScrollItem, byte b) {
            this();
        }

        public final int getCount() {
            return 2147483646;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(42562);
            Integer valueOf = Integer.valueOf(i % 10);
            AppMethodBeat.m2505o(42562);
            return valueOf;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C34461a c34461a;
            AppMethodBeat.m2504i(42563);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(LuckyMoneyAutoScrollItem.this.mContext).inflate(2130969966, null);
                C34461a c34461a2 = new C34461a();
                c34461a2.ocf = (ImageView) view.findViewById(2131825380);
                view.setTag(c34461a2);
                c34461a = c34461a2;
            } else {
                c34461a = (C34461a) view.getTag();
            }
            c34461a.ocf.setImageResource(((Integer) LuckyMoneyAutoScrollItem.ocb.get(i % 10)).intValue());
            AppMethodBeat.m2505o(42563);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollItem$b */
    interface C34462b {
        void aQe();
    }

    /* renamed from: a */
    static /* synthetic */ int m77012a(LuckyMoneyAutoScrollItem luckyMoneyAutoScrollItem) {
        int i = luckyMoneyAutoScrollItem.f17207YF + 1;
        luckyMoneyAutoScrollItem.f17207YF = i;
        return i;
    }

    static {
        AppMethodBeat.m2504i(42567);
        SparseArray sparseArray = new SparseArray();
        ocb = sparseArray;
        sparseArray.put(0, Integer.valueOf(C25738R.drawable.bcr));
        ocb.put(1, Integer.valueOf(C25738R.drawable.bcs));
        ocb.put(2, Integer.valueOf(C25738R.drawable.bct));
        ocb.put(3, Integer.valueOf(C25738R.drawable.bcu));
        ocb.put(4, Integer.valueOf(C25738R.drawable.bcv));
        ocb.put(5, Integer.valueOf(C25738R.drawable.bcw));
        ocb.put(6, Integer.valueOf(C25738R.drawable.bcx));
        ocb.put(7, Integer.valueOf(C25738R.drawable.bcy));
        ocb.put(8, Integer.valueOf(C25738R.drawable.bcz));
        ocb.put(9, Integer.valueOf(C25738R.drawable.bd0));
        AppMethodBeat.m2505o(42567);
    }

    public LuckyMoneyAutoScrollItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(42564);
        this.obV = null;
        this.obW = 900;
        this.obX = 0;
        this.f17207YF = 0;
        this.oca = null;
        this.mContext = context;
        this.obV = new C34460a(this, (byte) 0);
        setAdapter(this.obV);
        this.obZ = (int) ((this.mContext.getResources().getDisplayMetrics().density * 60.0f) + 0.5f);
        C4990ab.m7417i("MicroMsg.LuckyMoneyAutoScrollView", "hy: scroll height is: %d", Integer.valueOf(this.obZ));
        AppMethodBeat.m2505o(42564);
    }

    public LuckyMoneyAutoScrollItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setScrollTime(long j) {
        this.obW = j;
    }

    public static void setResouceMap(SparseArray<Integer> sparseArray) {
        AppMethodBeat.m2504i(42565);
        ocb.clear();
        for (int i = 0; i < sparseArray.size(); i++) {
            int keyAt = sparseArray.keyAt(i);
            ocb.put(keyAt, sparseArray.get(keyAt));
        }
        AppMethodBeat.m2505o(42565);
    }

    /* Access modifiers changed, original: 0000 */
    public void setOnScrollEndListener(C34462b c34462b) {
        this.oca = c34462b;
    }

    public final void bMm() {
        AppMethodBeat.m2504i(42566);
        if (this.obY != null) {
            this.obY.cancel();
        }
        final long j = ((long) (this.obX * 50)) + this.obW;
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(42561);
                LuckyMoneyAutoScrollItem.this.obY = new CountDownTimer(j) {
                    public final void onTick(long j) {
                        AppMethodBeat.m2504i(42559);
                        LuckyMoneyAutoScrollItem.this.smoothScrollToPosition(LuckyMoneyAutoScrollItem.m77012a(LuckyMoneyAutoScrollItem.this));
                        AppMethodBeat.m2505o(42559);
                    }

                    public final void onFinish() {
                        AppMethodBeat.m2504i(42560);
                        if (LuckyMoneyAutoScrollItem.this.oca != null) {
                            LuckyMoneyAutoScrollItem.this.oca.aQe();
                        }
                        AppMethodBeat.m2505o(42560);
                    }
                }.start();
                AppMethodBeat.m2505o(42561);
            }
        });
        AppMethodBeat.m2505o(42566);
    }

    public void setFinalNumber(int i) {
        this.obX = i;
    }
}
