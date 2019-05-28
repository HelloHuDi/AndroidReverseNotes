package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ba.n;
import com.tencent.mm.ba.r;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.fq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.az;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f extends BaseAdapter {
    private final Activity czX;
    private final ak handler = new ak();
    final List<bau> list = new ArrayList();
    private String nJy = "";
    final Map<Integer, Integer> rgf = new HashMap();
    final Map<Integer, Integer> rgg = new HashMap();
    int rgh = 0;
    int rgi = 0;
    private final b rgj;
    private final g rgk;
    final a rgl;
    fq rgm;

    class c {
        TextView gsf;
        TextView rgt;
        ImageView rgu;
        ImageView rgv;
        ImageView rgw;
        LinearLayout rgx;
        View rgy;

        c() {
        }
    }

    public interface a {
        void a(fq fqVar);

        void b(fq fqVar);

        void crx();
    }

    static abstract class b {
        OnClickListener rgo = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(38083);
                b.this.rgr = (a) view.getTag();
                b.this.DM(b.this.rgr.position);
                AppMethodBeat.o(38083);
            }
        };
        OnClickListener rgp = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(38084);
                b.this.rgr = (a) view.getTag();
                b.this.DM(b.this.rgr.position);
                AppMethodBeat.o(38084);
            }
        };
        OnClickListener rgq = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(38085);
                b.this.rgr = (a) view.getTag();
                b.this.DM(b.this.rgr.position);
                AppMethodBeat.o(38085);
            }
        };
        public a rgr = new a();

        public static class a {
            public String cFc;
            public int position;
        }

        public abstract void DM(int i);
    }

    public f(Activity activity, String str, b bVar, a aVar) {
        AppMethodBeat.i(38086);
        this.czX = activity;
        this.nJy = str;
        this.rgj = bVar;
        this.rgl = aVar;
        this.rgk = new g(new com.tencent.mm.plugin.sns.ui.g.a() {
            public final void a(List<bau> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, int i, int i2, fq fqVar) {
                AppMethodBeat.i(38081);
                ab.d("MicroMsg.ArtistAdapter", "onFinishFixPos");
                f fVar = f.this;
                if (list == null || list.size() <= 0) {
                    AppMethodBeat.o(38081);
                    return;
                }
                int intValue;
                try {
                    fVar.rgm = (fq) new fq().parseFrom(fqVar.toByteArray());
                    fVar.rgl.a(fVar.rgm);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.ArtistAdapter", e, "", new Object[0]);
                }
                ab.d("MicroMsg.ArtistAdapter", "copy list info");
                int size = list.size();
                fVar.list.clear();
                fVar.rgf.clear();
                fVar.rgg.clear();
                for (int i3 = 0; i3 < size; i3++) {
                    bau bau = (bau) list.get(i3);
                    fVar.list.add(e.a(bau.Id, bau.jCt, bau.Url, bau.wEH, bau.wEG, bau.wEI, bau.Desc));
                }
                for (Integer intValue2 : map.keySet()) {
                    intValue = intValue2.intValue();
                    fVar.rgf.put(Integer.valueOf(intValue), Integer.valueOf(((Integer) map.get(Integer.valueOf(intValue))).intValue()));
                }
                for (Integer intValue22 : map2.keySet()) {
                    intValue = intValue22.intValue();
                    fVar.rgg.put(Integer.valueOf(intValue), Integer.valueOf(((Integer) map2.get(Integer.valueOf(intValue))).intValue()));
                }
                list.clear();
                map.clear();
                map2.clear();
                fVar.rgi = i;
                fVar.rgh = i2;
                ab.d("MicroMsg.ArtistAdapter", "reallyCount " + i + " icount " + i2);
                fVar.notifyDataSetChanged();
                AppMethodBeat.o(38081);
            }

            public final void crw() {
                AppMethodBeat.i(38082);
                f fVar = f.this;
                if (fVar.rgl != null) {
                    fVar.rgl.crx();
                }
                AppMethodBeat.o(38082);
            }
        });
        KC();
        AppMethodBeat.o(38086);
    }

    public final void KC() {
        AppMethodBeat.i(38087);
        if (this.rgk != null) {
            r.aix();
            String aiu = n.aiu();
            ab.d("MicroMsg.ArtistAdapter", "packgePath: ".concat(String.valueOf(aiu)));
            this.rgk.gs(this.nJy, aiu);
        }
        AppMethodBeat.o(38087);
    }

    public final int getCount() {
        return this.rgh;
    }

    public final Object getItem(int i) {
        AppMethodBeat.i(38088);
        Object obj = this.list.get(i);
        AppMethodBeat.o(38088);
        return obj;
    }

    public final long getItemId(int i) {
        return 0;
    }

    private void a(int i, ImageView imageView) {
        AppMethodBeat.i(38090);
        bau bau = (bau) getItem(i);
        imageView.setVisibility(0);
        a aVar = new a();
        aVar.cFc = "";
        aVar.position = i;
        imageView.setTag(aVar);
        af.cnC().b(bau, imageView, this.czX.hashCode(), az.xYU);
        AppMethodBeat.o(38090);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        int intValue;
        AppMethodBeat.i(38089);
        if (view == null) {
            cVar = new c();
            view = View.inflate(this.czX, R.layout.aut, null);
            cVar.gsf = (TextView) view.findViewById(R.id.eh0);
            cVar.rgt = (TextView) view.findViewById(R.id.eh1);
            cVar.rgu = (ImageView) view.findViewById(R.id.eh2);
            cVar.rgv = (ImageView) view.findViewById(R.id.eh3);
            cVar.rgw = (ImageView) view.findViewById(R.id.eh4);
            cVar.rgx = (LinearLayout) view.findViewById(R.id.egz);
            cVar.rgy = view.findViewById(R.id.egy);
            cVar.rgu.setOnClickListener(this.rgj.rgo);
            cVar.rgv.setOnClickListener(this.rgj.rgp);
            cVar.rgw.setOnClickListener(this.rgj.rgq);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        if (this.rgf.get(Integer.valueOf(i)) != null) {
            intValue = ((Integer) this.rgf.get(Integer.valueOf(i))).intValue();
        } else {
            intValue = -1;
        }
        cVar.rgu.setVisibility(8);
        cVar.rgv.setVisibility(8);
        cVar.rgw.setVisibility(8);
        cVar.rgy.setVisibility(8);
        if (f.this.nJy.equals("en")) {
            cVar.gsf.setVisibility(8);
            cVar.rgt.setVisibility(4);
        } else {
            cVar.gsf.setVisibility(4);
            cVar.rgt.setVisibility(8);
        }
        if (intValue >= this.rgi || intValue == -1) {
            view.setLayoutParams(new LayoutParams(-1, 1));
            view.setVisibility(8);
        } else {
            int intValue2;
            String str = "";
            if (intValue - 1 >= 0) {
                Object obj = ((bau) getItem(intValue - 1)).Desc;
            } else {
                String obj2 = str;
            }
            view.setLayoutParams(new LayoutParams(-1, -2));
            view.setVisibility(0);
            if (this.rgg.get(Integer.valueOf(i)) != null) {
                intValue2 = ((Integer) this.rgg.get(Integer.valueOf(i))).intValue();
            } else {
                intValue2 = 1;
            }
            bau bau = (bau) getItem(intValue);
            if (bau.Desc.equals("") || !bau.Desc.equals(obj2)) {
                if (this.nJy.equals("en")) {
                    cVar.rgt.setVisibility(0);
                    cVar.rgt.setText(bau.Desc);
                    cVar.rgy.setVisibility(0);
                } else {
                    cVar.gsf.setVisibility(0);
                    cVar.gsf.setText(bau.Desc);
                    cVar.rgy.setVisibility(0);
                }
            }
            if (intValue2 > 0) {
                a(intValue, cVar.rgu);
            }
            if (intValue2 >= 2) {
                a(intValue + 1, cVar.rgv);
            }
            if (intValue2 >= 3) {
                a(intValue + 2, cVar.rgw);
            }
            if (this.rgl != null) {
                this.rgl.b(this.rgm);
            }
        }
        AppMethodBeat.o(38089);
        return view;
    }
}
