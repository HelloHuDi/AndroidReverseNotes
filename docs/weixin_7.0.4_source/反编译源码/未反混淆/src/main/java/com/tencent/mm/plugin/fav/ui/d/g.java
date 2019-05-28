package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.j;
import java.util.HashSet;
import java.util.Set;

public final class g extends a {
    private final int moM;
    private Set<ImageView> moO;
    private OnClickListener moP = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(74628);
            if (f.Mn()) {
                if (view.getTag() instanceof com.tencent.mm.plugin.fav.a.g) {
                    com.tencent.mm.plugin.fav.a.g gVar = (com.tencent.mm.plugin.fav.a.g) view.getTag();
                    abl abl = gVar.field_favProto.wit;
                    aar c = b.c(gVar);
                    if (c == null) {
                        ab.w("MicroMsg.FavBaseListItem", "data item is null");
                        AppMethodBeat.o(74628);
                        return;
                    } else if (b.e(c)) {
                        ab.i("MicroMsg.FavBaseListItem", "same song, do release");
                        com.tencent.mm.aw.a.aic();
                        g.a(g.this, null);
                        AppMethodBeat.o(74628);
                        return;
                    } else {
                        String w;
                        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(b.c(c));
                        if (bVar.exists()) {
                            w = j.w(bVar.dMD());
                        } else if (c.cvq == null) {
                            w = "";
                        } else {
                            String w2;
                            bVar = new com.tencent.mm.vfs.b(b.bue() + com.tencent.mm.a.g.x(c.cvq.getBytes()));
                            if (bVar.exists()) {
                                w2 = j.w(bVar.dMD());
                            } else {
                                w2 = "";
                            }
                            w = w2;
                        }
                        com.tencent.mm.aw.a.b(com.tencent.mm.aw.f.a(6, null, c.title, c.desc, c.wgg, c.wgk, c.wgi, c.mnd, b.bul(), w, "", abl.appId));
                        g.a(g.this, (ImageView) view);
                    }
                }
                AppMethodBeat.o(74628);
                return;
            }
            t.hO(g.this.mhy.context);
            AppMethodBeat.o(74628);
        }
    };

    public static class a extends a.b {
        TextView gnB;
        TextView gnC;
        ImageView iqT;
        TextView moL;
        ImageView moR;
    }

    public g(l lVar) {
        super(lVar);
        AppMethodBeat.i(74629);
        this.moM = com.tencent.mm.bz.a.al(lVar.context, R.dimen.hw);
        this.moO = new HashSet();
        AppMethodBeat.o(74629);
    }

    public final View a(View view, ViewGroup viewGroup, com.tencent.mm.plugin.fav.a.g gVar) {
        a.b bVar;
        AppMethodBeat.i(74630);
        Context context = viewGroup.getContext();
        if (view == null) {
            a.b aVar = new a();
            view = a(View.inflate(context, R.layout.yd, null), aVar, gVar);
            aVar.iqT = (ImageView) view.findViewById(R.id.yk);
            aVar.gnB = (TextView) view.findViewById(R.id.bb);
            aVar.gnC = (TextView) view.findViewById(R.id.av);
            aVar.moR = (ImageView) view.findViewById(R.id.yl);
            aVar.moL = (TextView) view.findViewById(R.id.b8);
            aVar.moL.setVisibility(8);
            aVar.moR.setOnClickListener(this.moP);
            aVar.moR.setVisibility(0);
            this.moO.add(aVar.moR);
            bVar = aVar;
        } else {
            bVar = (a) view.getTag();
        }
        a(bVar, gVar);
        aar c = b.c(gVar);
        bVar.gnB.setText(c.title);
        bVar.gnC.setText(c.desc);
        bVar.gnC.setVisibility(0);
        this.mhy.a(bVar.iqT, c, gVar, (int) R.raw.app_attach_file_icon_music, this.moM, this.moM);
        bVar.moR.setTag(gVar);
        if (b.e(c)) {
            bVar.moR.setImageResource(R.drawable.vq);
        } else {
            bVar.moR.setImageResource(R.drawable.vs);
        }
        AppMethodBeat.o(74630);
        return view;
    }

    public final void a(View view, abh abh) {
        AppMethodBeat.i(74631);
        a aVar = (a) view.getTag();
        ((y) com.tencent.mm.kernel.g.K(y.class)).a(view.getContext(), aVar.mgf, abh);
        AppMethodBeat.o(74631);
    }
}
