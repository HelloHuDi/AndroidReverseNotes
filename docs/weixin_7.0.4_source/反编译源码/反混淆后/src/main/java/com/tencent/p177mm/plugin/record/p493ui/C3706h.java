package com.tencent.p177mm.plugin.record.p493ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.record.p493ui.p1619a.C43438b;
import com.tencent.p177mm.plugin.record.p493ui.p1619a.C44758a;
import com.tencent.p177mm.plugin.record.p493ui.p1619a.C44759c;
import com.tencent.p177mm.plugin.record.p493ui.p494b.C21622e;
import com.tencent.p177mm.plugin.record.p493ui.p494b.C28843d;
import com.tencent.p177mm.plugin.record.p493ui.p494b.C41299a;
import com.tencent.p177mm.plugin.record.p493ui.p494b.C41300c;
import com.tencent.p177mm.plugin.record.p493ui.p494b.C46167b;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.aat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.record.ui.h */
public abstract class C3706h extends BaseAdapter {
    protected Context context;
    ListView mListView;
    private Runnable mhD = new C37082();
    protected C7306ak mty = null;
    protected List<aar> pJZ = new LinkedList();
    SparseArray<C3713b> pKp = new SparseArray();
    boolean pKq = false;
    private boolean pKr = false;
    protected C28837a pKs;
    protected C3709a pKt;
    private int padding = C1338a.fromDPToPix(this.context, 35);

    /* renamed from: com.tencent.mm.plugin.record.ui.h$2 */
    class C37082 implements Runnable {
        C37082() {
        }

        public final void run() {
            AppMethodBeat.m2504i(24229);
            C4990ab.m7410d("MicroMsg.RecordMsgBaseAdapter", "refresh adapter");
            C3706h.this.notifyDataSetChanged();
            AppMethodBeat.m2505o(24229);
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.ui.h$a */
    public interface C3709a {

        /* renamed from: com.tencent.mm.plugin.record.ui.h$a$b */
        public static class C3710b {
            public aar cAv;
            public boolean cAy;
            public boolean cAz;
            public int maxWidth;
            public long pKv;
        }

        /* renamed from: com.tencent.mm.plugin.record.ui.h$a$c */
        public static class C3711c {
            public aar cAv;
            public long pKv;
        }

        /* renamed from: com.tencent.mm.plugin.record.ui.h$a$a */
        public static class C3712a {
            public aar cAv;
            public ImageView cAw;
            public int cAx;
            public int height;
            public long pKv;
            public int width;
        }

        /* renamed from: a */
        Bitmap mo8340a(C3710b c3710b);

        /* renamed from: a */
        Bitmap mo8341a(C3711c c3711c);

        /* renamed from: a */
        void mo8342a(C3712a c3712a);

        void ceH();
    }

    /* renamed from: com.tencent.mm.plugin.record.ui.h$b */
    public interface C3713b {
        /* renamed from: a */
        void mo8344a(View view, int i, C43438b c43438b);

        void destroy();

        /* renamed from: eK */
        View mo8346eK(Context context);

        void pause();
    }

    /* renamed from: a */
    public abstract void mo8328a(C28837a c28837a);

    /* renamed from: d */
    public abstract void mo8331d(C43438b c43438b);

    public /* synthetic */ Object getItem(int i) {
        return m6005BI(i);
    }

    public C3706h(Context context, C3709a c3709a) {
        this.context = context;
        this.mty = new C7306ak(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(24228);
                if (message.what == 1) {
                    C4990ab.m7410d("MicroMsg.RecordMsgBaseAdapter", "do play music");
                    C3706h.this.notifyDataSetChanged();
                }
                AppMethodBeat.m2505o(24228);
            }
        };
        this.pKt = c3709a;
    }

    public final void ceO() {
        this.pKp.put(0, new C28843d(this.context));
        this.pKp.put(1, new C41299a(this.pKt, this.mListView));
        this.pKp.put(2, new C21622e());
        this.pKp.put(3, new C46167b(this.pKt, this.mty));
        this.pKp.put(4, new C41300c(this.pKt));
    }

    public final void destroy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.pKp.size()) {
                break;
            }
            C3713b c3713b = (C3713b) this.pKp.valueAt(i2);
            if (c3713b != null) {
                c3713b.destroy();
            }
            i = i2 + 1;
        }
        if (this.pKt != null) {
            this.pKt.ceH();
            this.pKt = null;
        }
    }

    public int getItemViewType(int i) {
        return C3706h.m6007m(m6005BI(i));
    }

    public int getViewTypeCount() {
        return 5;
    }

    public int getCount() {
        return this.pJZ == null ? 0 : this.pJZ.size();
    }

    /* renamed from: BI */
    private aar m6005BI(int i) {
        if (this.pJZ != null && i >= 0 && i < this.pJZ.size()) {
            return (aar) this.pJZ.get(i);
        }
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C43438b c44758a;
        String str;
        aar BI = m6005BI(i);
        C3713b c3713b = (C3713b) this.pKp.get(C3706h.m6007m(BI));
        if (view == null) {
            view = c3713b.mo8346eK(this.context);
        }
        switch (BI.dataType) {
            case 2:
                c44758a = new C44758a();
                break;
            case 15:
                c44758a = new C44759c();
                break;
            default:
                c44758a = new C43438b();
                break;
        }
        c44758a.cAv = BI;
        mo8331d(c44758a);
        c3713b.mo8344a(view, i, c44758a);
        ImageView imageView = (ImageView) view.findViewById(2131820658);
        TextView textView = (TextView) view.findViewById(2131826905);
        CharSequence b = C44089j.m79293b(textView.getContext(), BI.wgV, textView.getTextSize());
        if (C5046bo.isNullOrNil(BI.whu)) {
            textView.setText(b);
        } else {
            String str2 = BI.whu;
            if (str2 != null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(b);
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append(str2);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(C4996ah.getContext().getResources().getColor(C25738R.color.f12217wf)), length, spannableStringBuilder.length(), 33);
                Object b2 = spannableStringBuilder;
            }
            textView.setText(b2);
        }
        textView = (TextView) view.findViewById(2131826906);
        C4990ab.m7411d("MicroMsg.RecordMsgBaseAdapter", "datasrctime %s", BI.wgX);
        if (BI.wgX != null) {
            if (this.pKq) {
                str = BI.wgX;
                textView.setText(str.substring(str.indexOf("-") + 1));
            } else {
                String[] split = BI.wgX.split(" ");
                if (split.length < 2) {
                    textView.setText(BI.wgX);
                } else {
                    textView.setText(BI.wgX.substring(split[0].length() + 1));
                }
            }
        }
        if (i == 0) {
            if (BI.wgT != null) {
                aat aat = BI.wgT.whw;
                imageView.setVisibility(0);
                if (aat.whV) {
                    C3706h.m6006VK(aat.whU);
                    if (C25754e.m40904rr(aat.whU)) {
                        C32291o.ahp().mo43765a(C25754e.m40907ru(aat.whU), imageView);
                    } else {
                        C40460b.m69434b(imageView, aat.whU);
                    }
                } else if (!aat.whQ || (C1853r.m3846Yz().equals(aat.cEV) && aat.cEV.equals(aat.toUser))) {
                    imageView.setVisibility(8);
                    view.setPadding(this.padding, view.getPaddingTop(), this.padding, view.getPaddingBottom());
                    this.pKr = true;
                } else {
                    C3706h.m6006VK(aat.cEV);
                    C40460b.m69434b(imageView, aat.cEV);
                }
            } else {
                imageView.setVisibility(8);
                view.setPadding(this.padding, view.getPaddingTop(), this.padding, view.getPaddingBottom());
                this.pKr = true;
            }
        } else if (i <= 0 || this.pKr) {
            imageView.setVisibility(8);
            view.setPadding(this.padding, view.getPaddingTop(), this.padding, view.getPaddingBottom());
        } else {
            String str3 = "";
            aat aat2 = BI.wgT.whw;
            if (m6005BI(i - 1).wgT.whw.whV) {
                str3 = m6005BI(i - 1).wgT.whw.whU;
            } else if (m6005BI(i - 1).wgT.whw.whQ) {
                str3 = m6005BI(i - 1).wgT.whw.cEV;
            }
            imageView.setVisibility(0);
            if (BI.wgT.whw.whV) {
                String str4 = BI.wgT.whw.whU;
                if (str3.equals(str4)) {
                    imageView.setVisibility(4);
                } else {
                    C3706h.m6006VK(str4);
                    if (C25754e.m40904rr(aat2.whU)) {
                        C32291o.ahp().mo43765a(C25754e.m40907ru(aat2.whU), imageView);
                    } else {
                        C40460b.m69434b(imageView, str4);
                    }
                }
            } else if (BI.wgT.whw.whQ) {
                str = BI.wgT.whw.cEV;
                if (str3.equals(str)) {
                    imageView.setVisibility(4);
                } else {
                    C3706h.m6006VK(str);
                    C40460b.m69434b(imageView, str);
                }
            } else {
                imageView.setVisibility(4);
            }
        }
        if (i == getCount() - 1) {
            view.findViewById(2131820659).setVisibility(8);
        } else {
            view.findViewById(2131820659).setVisibility(0);
        }
        return view;
    }

    /* renamed from: VK */
    private static void m6006VK(String str) {
        if (!C1855t.m3912mY(str)) {
            C17880h c17880h = new C17880h();
            c17880h.username = str;
            C17884o.act().mo33391b(c17880h);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void ceP() {
        this.mty.post(this.mhD);
    }

    /* renamed from: m */
    private static int m6007m(aar aar) {
        switch (aar.dataType) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            default:
                return 3;
        }
    }
}
