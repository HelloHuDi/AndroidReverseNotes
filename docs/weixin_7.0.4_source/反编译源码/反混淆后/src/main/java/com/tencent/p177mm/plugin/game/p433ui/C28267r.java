package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.plugin.game.p428f.C28203e;
import com.tencent.p177mm.plugin.game.p428f.C28203e.C28207a.C12125a;
import com.tencent.p177mm.plugin.game.p428f.C39204b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.add;
import com.tencent.p177mm.protocal.protobuf.ade;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.ui.r */
public final class C28267r extends BaseAdapter {
    Context context;
    boolean ctn = false;
    ArrayList<C28266b> kwf;
    int mXJ = 0;
    int njD = 0;
    boolean nlW = false;
    int nlX = 0;
    int nlY = 0;
    int nlZ = 0;
    int nma = 0;
    private int nmb;
    boolean nmc = false;
    boolean nmd = false;
    private ArrayList<C28269d> nme;

    /* renamed from: com.tencent.mm.plugin.game.ui.r$a */
    static class C12206a {
        public View contentView;
        ImageView nmi;
        TextView nmj;
        TextView nmk;
        TextView nml;
        TextView nmm;
        View nmn;
        TextView nmo;
        TextView nmp;

        private C12206a() {
        }

        /* synthetic */ C12206a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.r$c */
    public static class C12207c {
        public int actionType;
        String appId;
        int cKG;
        String nmA;
        int nmu;
        int nmv;
        String nmz;
        int position;
        int type;

        public C12207c(String str) {
            this.actionType = 2;
            this.nmz = str;
        }

        public C12207c(String str, byte b) {
            this.actionType = 2;
            this.type = 3;
            this.nmz = str;
        }

        public C12207c(int i, int i2, String str, String str2) {
            AppMethodBeat.m2504i(112174);
            this.actionType = i;
            this.type = i2;
            this.appId = str;
            if (i == 2) {
                this.nmz = str2;
            }
            AppMethodBeat.m2505o(112174);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.r$b */
    public static class C28266b {
        public int actionType;
        public String appId;
        public long createTime;
        public String ctj;
        public String fnb;
        public String hHV;
        public String iconUrl;
        public String name;
        public String nmq;
        public ade nmr;
        public String nms;
        public LinkedList<String> nmt;
        public int nmu;
        public int nmv;
        public boolean nmw = false;
        public boolean nmx = false;
        public C12207c nmy;
        public int type;

        /* renamed from: aM */
        public static C28266b m44837aM(int i, String str) {
            AppMethodBeat.m2504i(112172);
            C28266b c28266b = new C28266b();
            c28266b.type = i;
            c28266b.name = str;
            c28266b.nmy = new C12207c();
            AppMethodBeat.m2505o(112172);
            return c28266b;
        }

        /* renamed from: a */
        public static C28266b m44836a(add add) {
            AppMethodBeat.m2504i(112173);
            C28266b c28266b = new C28266b();
            c28266b.type = 2;
            c28266b.name = add.Title;
            c28266b.hHV = add.Desc;
            c28266b.iconUrl = add.ThumbUrl;
            c28266b.nms = add.wkC;
            c28266b.nmu = add.wkX;
            c28266b.nmv = add.wkY;
            c28266b.appId = add.fKh;
            c28266b.fnb = add.ncH;
            c28266b.createTime = (long) add.vNm;
            c28266b.nmy = new C12207c(add.wkC, (byte) 0);
            AppMethodBeat.m2505o(112173);
            return c28266b;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.r$d */
    class C28269d {
        int end;
        int start;

        private C28269d() {
            this.start = -1;
            this.end = -1;
        }

        /* synthetic */ C28269d(C28267r c28267r, byte b) {
            this();
        }
    }

    public C28267r(Context context) {
        AppMethodBeat.m2504i(112175);
        this.context = context;
        this.kwf = null;
        this.nmb = context.getResources().getColor(C25738R.color.f12057qw);
        AppMethodBeat.m2505o(112175);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(112176);
        if (this.kwf == null) {
            AppMethodBeat.m2505o(112176);
            return 0;
        }
        int size = this.kwf.size();
        AppMethodBeat.m2505o(112176);
        return size;
    }

    public final Object getItem(int i) {
        AppMethodBeat.m2504i(112177);
        Object obj = this.kwf.get(i);
        AppMethodBeat.m2505o(112177);
        return obj;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(112178);
        int i2 = ((C28266b) getItem(i)).type;
        AppMethodBeat.m2505o(112178);
        return i2;
    }

    public final int getViewTypeCount() {
        return 7;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C12206a c12206a;
        AppMethodBeat.m2504i(112179);
        C28266b c28266b = (C28266b) getItem(i);
        if (view == null) {
            int i2;
            c12206a = new C12206a();
            Context context = this.context;
            switch (c28266b.type) {
                case 0:
                    i2 = 2130969780;
                    break;
                case 1:
                    i2 = 2130969774;
                    break;
                case 2:
                    i2 = 2130969781;
                    break;
                case 3:
                    i2 = 2130969779;
                    break;
                case 5:
                    i2 = 2130969776;
                    break;
                case 6:
                    i2 = 2130969777;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            view = View.inflate(context, i2, null);
            c12206a.contentView = view.findViewById(2131824619);
            c12206a.nmi = (ImageView) view.findViewById(2131824620);
            c12206a.nmj = (TextView) view.findViewById(2131824622);
            c12206a.nmk = (TextView) view.findViewById(2131824621);
            c12206a.nml = (TextView) view.findViewById(2131824623);
            c12206a.nmm = (TextView) view.findViewById(2131824629);
            c12206a.nmn = view.findViewById(2131824630);
            c12206a.nmo = (TextView) view.findViewById(2131824631);
            c12206a.nmp = (TextView) view.findViewById(2131824632);
            view.setTag(c12206a);
            if (!(c12206a.nmj == null || c12206a.nml == null)) {
                final TextView textView = c12206a.nmj;
                final TextView textView2 = c12206a.nml;
                textView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                    public final void onGlobalLayout() {
                        AppMethodBeat.m2504i(112171);
                        if (textView.getLineCount() > 1) {
                            textView.setMaxLines(2);
                            textView2.setMaxLines(1);
                            AppMethodBeat.m2505o(112171);
                            return;
                        }
                        textView2.setMaxLines(2);
                        AppMethodBeat.m2505o(112171);
                    }
                });
            }
        } else {
            c12206a = (C12206a) view.getTag();
        }
        C12125a c12125a;
        switch (c28266b.type) {
            case 0:
                c12206a.nml.setText(c28266b.name);
                break;
            case 1:
                if (!C5046bo.isNullOrNil(c28266b.iconUrl)) {
                    c12125a = new C12125a();
                    c12125a.ePF = false;
                    c12125a.ePH = false;
                    C28203e.bFH().mo46098a(c12206a.nmi, c28266b.iconUrl, c12125a.bFI());
                }
                m44839a(c12206a.nmj, c28266b.name);
                m44839a(c12206a.nmk, c28266b.nmq);
                m44839a(c12206a.nml, c28266b.hHV);
                break;
            case 2:
                if (C5046bo.isNullOrNil(c28266b.iconUrl)) {
                    c12206a.nmi.setVisibility(8);
                } else {
                    c12125a = new C12125a();
                    c12125a.ePF = false;
                    c12125a.ePH = false;
                    c12125a.nnP = true;
                    C28203e.bFH().mo46098a(c12206a.nmi, c28266b.iconUrl, c12125a.bFI());
                    c12206a.nmi.setVisibility(0);
                }
                m44839a(c12206a.nmj, c28266b.name);
                m44839a(c12206a.nml, c28266b.hHV);
                if (C5046bo.isNullOrNil(c28266b.fnb)) {
                    c12206a.nmo.setVisibility(8);
                } else {
                    c12206a.nmo.setText(C44089j.m79292b(this.context, c28266b.fnb));
                    c12206a.nmo.setVisibility(0);
                }
                if (c28266b.createTime <= 0) {
                    c12206a.nmp.setVisibility(8);
                    break;
                }
                c12206a.nmp.setText(C39204b.m66794h(this.context, c28266b.createTime * 1000));
                c12206a.nmp.setVisibility(0);
                break;
            case 3:
                if (!C5046bo.isNullOrNil(c28266b.iconUrl)) {
                    c12125a = new C12125a();
                    c12125a.ePF = false;
                    c12125a.ePH = false;
                    C28203e.bFH().mo46098a(c12206a.nmi, c28266b.iconUrl, c12125a.bFI());
                }
                m44839a(c12206a.nmj, c28266b.name);
                m44839a(c12206a.nmk, c28266b.nmq);
                m44839a(c12206a.nml, c28266b.hHV);
                TextView textView3 = c12206a.nmm;
                LinkedList linkedList = c28266b.nmt;
                StringBuilder stringBuilder = new StringBuilder();
                if (!C5046bo.m7548ek(linkedList)) {
                    int size = linkedList.size();
                    for (int i3 = 0; i3 < size - 1; i3++) {
                        stringBuilder.append(((String) linkedList.get(i3)) + IOUtils.LINE_SEPARATOR_UNIX);
                    }
                    stringBuilder.append((String) linkedList.get(size - 1));
                    textView3.setVisibility(0);
                    textView3.setText(stringBuilder.toString());
                    break;
                }
                textView3.setVisibility(8);
                break;
            case 5:
                c12206a.nmi.setImageResource(C1318a.search_more_button_icon);
                break;
            case 6:
                break;
        }
        c12206a.nmj.setText(c28266b.name);
        switch (c28266b.type) {
            case 0:
                if (!c28266b.nmw) {
                    c12206a.nmn.setVisibility(0);
                    break;
                }
                c12206a.nmn.setVisibility(8);
                break;
            case 1:
            case 2:
            case 3:
            case 5:
                if (c28266b.nmx) {
                    c12206a.contentView.setBackgroundResource(C25738R.drawable.f6625k7);
                } else {
                    c12206a.contentView.setBackgroundResource(C25738R.drawable.f6623k5);
                }
                int dimensionPixelSize = this.context.getResources().getDimensionPixelSize(C25738R.dimen.f9998my);
                c12206a.contentView.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
                break;
        }
        AppMethodBeat.m2505o(112179);
        return view;
    }

    public final void reset() {
        this.mXJ = 0;
        this.nmc = false;
    }

    /* renamed from: Oo */
    private String m44838Oo(String str) {
        AppMethodBeat.m2504i(112180);
        if (this.nme == null) {
            this.nme = new ArrayList();
        } else {
            this.nme.clear();
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        C28269d c28269d = new C28269d(this, (byte) 0);
        for (int indexOf = stringBuilder.indexOf("<em>"); indexOf >= 0; indexOf = stringBuilder.indexOf("<em>")) {
            c28269d.start = indexOf;
            stringBuilder.delete(indexOf, indexOf + 4);
            indexOf = stringBuilder.indexOf("</em>");
            if (indexOf < 0) {
                break;
            }
            c28269d.end = indexOf;
            stringBuilder.delete(indexOf, indexOf + 5);
            this.nme.add(c28269d);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(112180);
        return stringBuilder2;
    }

    /* renamed from: a */
    private void m44839a(TextView textView, String str) {
        AppMethodBeat.m2504i(112181);
        if (C5046bo.isNullOrNil(str)) {
            textView.setVisibility(8);
            AppMethodBeat.m2505o(112181);
            return;
        }
        SpannableString spannableString = new SpannableString(m44838Oo(str));
        Iterator it = this.nme.iterator();
        while (it.hasNext()) {
            C28269d c28269d = (C28269d) it.next();
            if (c28269d.start < c28269d.end) {
                spannableString.setSpan(new ForegroundColorSpan(this.nmb), c28269d.start, c28269d.end, 33);
            }
        }
        textView.setText(spannableString);
        textView.setVisibility(0);
        AppMethodBeat.m2505o(112181);
    }
}
