package com.tencent.mm.plugin.record.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.record.ui.b.c;
import com.tencent.mm.plugin.record.ui.b.d;
import com.tencent.mm.plugin.record.ui.b.e;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public abstract class h extends BaseAdapter {
    protected Context context;
    ListView mListView;
    private Runnable mhD = new Runnable() {
        public final void run() {
            AppMethodBeat.i(24229);
            ab.d("MicroMsg.RecordMsgBaseAdapter", "refresh adapter");
            h.this.notifyDataSetChanged();
            AppMethodBeat.o(24229);
        }
    };
    protected ak mty = null;
    protected List<aar> pJZ = new LinkedList();
    SparseArray<b> pKp = new SparseArray();
    boolean pKq = false;
    private boolean pKr = false;
    protected a pKs;
    protected a pKt;
    private int padding = com.tencent.mm.bz.a.fromDPToPix(this.context, 35);

    public interface a {

        public static class b {
            public aar cAv;
            public boolean cAy;
            public boolean cAz;
            public int maxWidth;
            public long pKv;
        }

        public static class c {
            public aar cAv;
            public long pKv;
        }

        public static class a {
            public aar cAv;
            public ImageView cAw;
            public int cAx;
            public int height;
            public long pKv;
            public int width;
        }

        Bitmap a(b bVar);

        Bitmap a(c cVar);

        void a(a aVar);

        void ceH();
    }

    public interface b {
        void a(View view, int i, com.tencent.mm.plugin.record.ui.a.b bVar);

        void destroy();

        View eK(Context context);

        void pause();
    }

    public abstract void a(a aVar);

    public abstract void d(com.tencent.mm.plugin.record.ui.a.b bVar);

    public /* synthetic */ Object getItem(int i) {
        return BI(i);
    }

    public h(Context context, a aVar) {
        this.context = context;
        this.mty = new ak(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(24228);
                if (message.what == 1) {
                    ab.d("MicroMsg.RecordMsgBaseAdapter", "do play music");
                    h.this.notifyDataSetChanged();
                }
                AppMethodBeat.o(24228);
            }
        };
        this.pKt = aVar;
    }

    public final void ceO() {
        this.pKp.put(0, new d(this.context));
        this.pKp.put(1, new com.tencent.mm.plugin.record.ui.b.a(this.pKt, this.mListView));
        this.pKp.put(2, new e());
        this.pKp.put(3, new com.tencent.mm.plugin.record.ui.b.b(this.pKt, this.mty));
        this.pKp.put(4, new c(this.pKt));
    }

    public final void destroy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.pKp.size()) {
                break;
            }
            b bVar = (b) this.pKp.valueAt(i2);
            if (bVar != null) {
                bVar.destroy();
            }
            i = i2 + 1;
        }
        if (this.pKt != null) {
            this.pKt.ceH();
            this.pKt = null;
        }
    }

    public int getItemViewType(int i) {
        return m(BI(i));
    }

    public int getViewTypeCount() {
        return 5;
    }

    public int getCount() {
        return this.pJZ == null ? 0 : this.pJZ.size();
    }

    private aar BI(int i) {
        if (this.pJZ != null && i >= 0 && i < this.pJZ.size()) {
            return (aar) this.pJZ.get(i);
        }
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        com.tencent.mm.plugin.record.ui.a.b aVar;
        String str;
        aar BI = BI(i);
        b bVar = (b) this.pKp.get(m(BI));
        if (view == null) {
            view = bVar.eK(this.context);
        }
        switch (BI.dataType) {
            case 2:
                aVar = new com.tencent.mm.plugin.record.ui.a.a();
                break;
            case 15:
                aVar = new com.tencent.mm.plugin.record.ui.a.c();
                break;
            default:
                aVar = new com.tencent.mm.plugin.record.ui.a.b();
                break;
        }
        aVar.cAv = BI;
        d(aVar);
        bVar.a(view, i, aVar);
        ImageView imageView = (ImageView) view.findViewById(R.id.cd);
        TextView textView = (TextView) view.findViewById(R.id.dwy);
        CharSequence b = j.b(textView.getContext(), BI.wgV, textView.getTextSize());
        if (bo.isNullOrNil(BI.whu)) {
            textView.setText(b);
        } else {
            String str2 = BI.whu;
            if (str2 != null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(b);
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append(str2);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ah.getContext().getResources().getColor(R.color.wf)), length, spannableStringBuilder.length(), 33);
                Object b2 = spannableStringBuilder;
            }
            textView.setText(b2);
        }
        textView = (TextView) view.findViewById(R.id.dwz);
        ab.d("MicroMsg.RecordMsgBaseAdapter", "datasrctime %s", BI.wgX);
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
                    VK(aat.whU);
                    if (com.tencent.mm.aj.a.e.rr(aat.whU)) {
                        o.ahp().a(com.tencent.mm.aj.a.e.ru(aat.whU), imageView);
                    } else {
                        com.tencent.mm.pluginsdk.ui.a.b.b(imageView, aat.whU);
                    }
                } else if (!aat.whQ || (r.Yz().equals(aat.cEV) && aat.cEV.equals(aat.toUser))) {
                    imageView.setVisibility(8);
                    view.setPadding(this.padding, view.getPaddingTop(), this.padding, view.getPaddingBottom());
                    this.pKr = true;
                } else {
                    VK(aat.cEV);
                    com.tencent.mm.pluginsdk.ui.a.b.b(imageView, aat.cEV);
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
            if (BI(i - 1).wgT.whw.whV) {
                str3 = BI(i - 1).wgT.whw.whU;
            } else if (BI(i - 1).wgT.whw.whQ) {
                str3 = BI(i - 1).wgT.whw.cEV;
            }
            imageView.setVisibility(0);
            if (BI.wgT.whw.whV) {
                String str4 = BI.wgT.whw.whU;
                if (str3.equals(str4)) {
                    imageView.setVisibility(4);
                } else {
                    VK(str4);
                    if (com.tencent.mm.aj.a.e.rr(aat2.whU)) {
                        o.ahp().a(com.tencent.mm.aj.a.e.ru(aat2.whU), imageView);
                    } else {
                        com.tencent.mm.pluginsdk.ui.a.b.b(imageView, str4);
                    }
                }
            } else if (BI.wgT.whw.whQ) {
                str = BI.wgT.whw.cEV;
                if (str3.equals(str)) {
                    imageView.setVisibility(4);
                } else {
                    VK(str);
                    com.tencent.mm.pluginsdk.ui.a.b.b(imageView, str);
                }
            } else {
                imageView.setVisibility(4);
            }
        }
        if (i == getCount() - 1) {
            view.findViewById(R.id.ce).setVisibility(8);
        } else {
            view.findViewById(R.id.ce).setVisibility(0);
        }
        return view;
    }

    private static void VK(String str) {
        if (!t.mY(str)) {
            com.tencent.mm.ah.h hVar = new com.tencent.mm.ah.h();
            hVar.username = str;
            com.tencent.mm.ah.o.act().b(hVar);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void ceP() {
        this.mty.post(this.mhD);
    }

    private static int m(aar aar) {
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
