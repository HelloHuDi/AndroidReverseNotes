package com.tencent.mm.plugin.game.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.add;
import com.tencent.mm.protocal.protobuf.ade;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class r extends BaseAdapter {
    Context context;
    boolean ctn = false;
    ArrayList<b> kwf;
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
    private ArrayList<d> nme;

    static class a {
        public View contentView;
        ImageView nmi;
        TextView nmj;
        TextView nmk;
        TextView nml;
        TextView nmm;
        View nmn;
        TextView nmo;
        TextView nmp;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public static class c {
        public int actionType;
        String appId;
        int cKG;
        String nmA;
        int nmu;
        int nmv;
        String nmz;
        int position;
        int type;

        public c(String str) {
            this.actionType = 2;
            this.nmz = str;
        }

        public c(String str, byte b) {
            this.actionType = 2;
            this.type = 3;
            this.nmz = str;
        }

        public c(int i, int i2, String str, String str2) {
            AppMethodBeat.i(112174);
            this.actionType = i;
            this.type = i2;
            this.appId = str;
            if (i == 2) {
                this.nmz = str2;
            }
            AppMethodBeat.o(112174);
        }
    }

    public static class b {
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
        public c nmy;
        public int type;

        public static b aM(int i, String str) {
            AppMethodBeat.i(112172);
            b bVar = new b();
            bVar.type = i;
            bVar.name = str;
            bVar.nmy = new c();
            AppMethodBeat.o(112172);
            return bVar;
        }

        public static b a(add add) {
            AppMethodBeat.i(112173);
            b bVar = new b();
            bVar.type = 2;
            bVar.name = add.Title;
            bVar.hHV = add.Desc;
            bVar.iconUrl = add.ThumbUrl;
            bVar.nms = add.wkC;
            bVar.nmu = add.wkX;
            bVar.nmv = add.wkY;
            bVar.appId = add.fKh;
            bVar.fnb = add.ncH;
            bVar.createTime = (long) add.vNm;
            bVar.nmy = new c(add.wkC, (byte) 0);
            AppMethodBeat.o(112173);
            return bVar;
        }
    }

    class d {
        int end;
        int start;

        private d() {
            this.start = -1;
            this.end = -1;
        }

        /* synthetic */ d(r rVar, byte b) {
            this();
        }
    }

    public r(Context context) {
        AppMethodBeat.i(112175);
        this.context = context;
        this.kwf = null;
        this.nmb = context.getResources().getColor(R.color.qw);
        AppMethodBeat.o(112175);
    }

    public final int getCount() {
        AppMethodBeat.i(112176);
        if (this.kwf == null) {
            AppMethodBeat.o(112176);
            return 0;
        }
        int size = this.kwf.size();
        AppMethodBeat.o(112176);
        return size;
    }

    public final Object getItem(int i) {
        AppMethodBeat.i(112177);
        Object obj = this.kwf.get(i);
        AppMethodBeat.o(112177);
        return obj;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(112178);
        int i2 = ((b) getItem(i)).type;
        AppMethodBeat.o(112178);
        return i2;
    }

    public final int getViewTypeCount() {
        return 7;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(112179);
        b bVar = (b) getItem(i);
        if (view == null) {
            int i2;
            aVar = new a();
            Context context = this.context;
            switch (bVar.type) {
                case 0:
                    i2 = R.layout.a5q;
                    break;
                case 1:
                    i2 = R.layout.a5k;
                    break;
                case 2:
                    i2 = R.layout.a5r;
                    break;
                case 3:
                    i2 = R.layout.a5p;
                    break;
                case 5:
                    i2 = R.layout.a5m;
                    break;
                case 6:
                    i2 = R.layout.a5n;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            view = View.inflate(context, i2, null);
            aVar.contentView = view.findViewById(R.id.c95);
            aVar.nmi = (ImageView) view.findViewById(R.id.c96);
            aVar.nmj = (TextView) view.findViewById(R.id.c98);
            aVar.nmk = (TextView) view.findViewById(R.id.c97);
            aVar.nml = (TextView) view.findViewById(R.id.c99);
            aVar.nmm = (TextView) view.findViewById(R.id.c9e);
            aVar.nmn = view.findViewById(R.id.c9f);
            aVar.nmo = (TextView) view.findViewById(R.id.c9g);
            aVar.nmp = (TextView) view.findViewById(R.id.c9h);
            view.setTag(aVar);
            if (!(aVar.nmj == null || aVar.nml == null)) {
                final TextView textView = aVar.nmj;
                final TextView textView2 = aVar.nml;
                textView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                    public final void onGlobalLayout() {
                        AppMethodBeat.i(112171);
                        if (textView.getLineCount() > 1) {
                            textView.setMaxLines(2);
                            textView2.setMaxLines(1);
                            AppMethodBeat.o(112171);
                            return;
                        }
                        textView2.setMaxLines(2);
                        AppMethodBeat.o(112171);
                    }
                });
            }
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.plugin.game.f.e.a.a aVar2;
        switch (bVar.type) {
            case 0:
                aVar.nml.setText(bVar.name);
                break;
            case 1:
                if (!bo.isNullOrNil(bVar.iconUrl)) {
                    aVar2 = new com.tencent.mm.plugin.game.f.e.a.a();
                    aVar2.ePF = false;
                    aVar2.ePH = false;
                    e.bFH().a(aVar.nmi, bVar.iconUrl, aVar2.bFI());
                }
                a(aVar.nmj, bVar.name);
                a(aVar.nmk, bVar.nmq);
                a(aVar.nml, bVar.hHV);
                break;
            case 2:
                if (bo.isNullOrNil(bVar.iconUrl)) {
                    aVar.nmi.setVisibility(8);
                } else {
                    aVar2 = new com.tencent.mm.plugin.game.f.e.a.a();
                    aVar2.ePF = false;
                    aVar2.ePH = false;
                    aVar2.nnP = true;
                    e.bFH().a(aVar.nmi, bVar.iconUrl, aVar2.bFI());
                    aVar.nmi.setVisibility(0);
                }
                a(aVar.nmj, bVar.name);
                a(aVar.nml, bVar.hHV);
                if (bo.isNullOrNil(bVar.fnb)) {
                    aVar.nmo.setVisibility(8);
                } else {
                    aVar.nmo.setText(j.b(this.context, bVar.fnb));
                    aVar.nmo.setVisibility(0);
                }
                if (bVar.createTime <= 0) {
                    aVar.nmp.setVisibility(8);
                    break;
                }
                aVar.nmp.setText(com.tencent.mm.plugin.game.f.b.h(this.context, bVar.createTime * 1000));
                aVar.nmp.setVisibility(0);
                break;
            case 3:
                if (!bo.isNullOrNil(bVar.iconUrl)) {
                    aVar2 = new com.tencent.mm.plugin.game.f.e.a.a();
                    aVar2.ePF = false;
                    aVar2.ePH = false;
                    e.bFH().a(aVar.nmi, bVar.iconUrl, aVar2.bFI());
                }
                a(aVar.nmj, bVar.name);
                a(aVar.nmk, bVar.nmq);
                a(aVar.nml, bVar.hHV);
                TextView textView3 = aVar.nmm;
                LinkedList linkedList = bVar.nmt;
                StringBuilder stringBuilder = new StringBuilder();
                if (!bo.ek(linkedList)) {
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
                aVar.nmi.setImageResource(R.raw.search_more_button_icon);
                break;
            case 6:
                break;
        }
        aVar.nmj.setText(bVar.name);
        switch (bVar.type) {
            case 0:
                if (!bVar.nmw) {
                    aVar.nmn.setVisibility(0);
                    break;
                }
                aVar.nmn.setVisibility(8);
                break;
            case 1:
            case 2:
            case 3:
            case 5:
                if (bVar.nmx) {
                    aVar.contentView.setBackgroundResource(R.drawable.k7);
                } else {
                    aVar.contentView.setBackgroundResource(R.drawable.k5);
                }
                int dimensionPixelSize = this.context.getResources().getDimensionPixelSize(R.dimen.my);
                aVar.contentView.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
                break;
        }
        AppMethodBeat.o(112179);
        return view;
    }

    public final void reset() {
        this.mXJ = 0;
        this.nmc = false;
    }

    private String Oo(String str) {
        AppMethodBeat.i(112180);
        if (this.nme == null) {
            this.nme = new ArrayList();
        } else {
            this.nme.clear();
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        d dVar = new d(this, (byte) 0);
        for (int indexOf = stringBuilder.indexOf("<em>"); indexOf >= 0; indexOf = stringBuilder.indexOf("<em>")) {
            dVar.start = indexOf;
            stringBuilder.delete(indexOf, indexOf + 4);
            indexOf = stringBuilder.indexOf("</em>");
            if (indexOf < 0) {
                break;
            }
            dVar.end = indexOf;
            stringBuilder.delete(indexOf, indexOf + 5);
            this.nme.add(dVar);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(112180);
        return stringBuilder2;
    }

    private void a(TextView textView, String str) {
        AppMethodBeat.i(112181);
        if (bo.isNullOrNil(str)) {
            textView.setVisibility(8);
            AppMethodBeat.o(112181);
            return;
        }
        SpannableString spannableString = new SpannableString(Oo(str));
        Iterator it = this.nme.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.start < dVar.end) {
                spannableString.setSpan(new ForegroundColorSpan(this.nmb), dVar.start, dVar.end, 33);
            }
        }
        textView.setText(spannableString);
        textView.setVisibility(0);
        AppMethodBeat.o(112181);
    }
}
