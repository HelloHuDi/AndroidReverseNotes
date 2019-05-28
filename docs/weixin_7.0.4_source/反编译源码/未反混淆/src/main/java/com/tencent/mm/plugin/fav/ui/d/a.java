package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import java.util.Map;

public abstract class a {
    protected l mhy = null;
    public final a moE = new a();

    public static class a {
        public String ema;
        public boolean jLC;
        public long lastUpdateTime;
        public boolean mlh;
        public Map<Long, g> mli;
        public boolean mlp;
        public c moG;

        public final String toString() {
            AppMethodBeat.i(74614);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("lastUpdateTime:").append(this.lastUpdateTime).append(10);
            stringBuilder.append("isSearching:").append(this.jLC).append(10);
            stringBuilder.append("search str:").append(this.ema).append(10);
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.o(74614);
            return stringBuilder2;
        }
    }

    public static class b {
        public TextView enf;
        public CheckBox gnD;
        public TextView gxi;
        public g mgf;
        public View moH;
        public ImageView moI;
        public LinearLayout moJ;
        public TextView moK;
    }

    public interface c {
        void iI(long j);
    }

    public abstract View a(View view, ViewGroup viewGroup, g gVar);

    public abstract void a(View view, abh abh);

    public a(l lVar) {
        this.mhy = lVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final View a(View view, b bVar, g gVar) {
        if (view == null) {
            throw new NullPointerException("base item view is null");
        }
        bVar.moH = view.findViewById(R.id.bq4);
        if (bVar.moH == null) {
            throw new IllegalArgumentException("base item view do not contain id named favTypeLayout");
        }
        bVar.gxi = (TextView) view.findViewById(R.id.b4);
        if (bVar.gxi == null) {
            throw new IllegalArgumentException("base item view do not contain id named fav_name");
        }
        bVar.enf = (TextView) view.findViewById(R.id.ba);
        if (bVar.enf == null) {
            throw new IllegalArgumentException("base item view do not contain id named fav_time");
        }
        bVar.gnD = (CheckBox) view.findViewById(R.id.at);
        if (bVar.gnD == null) {
            throw new IllegalArgumentException("base item view do not contain id named checkbox");
        }
        bVar.moI = (ImageView) view.findViewById(R.id.bq5);
        if (bVar.moI == null) {
            throw new IllegalArgumentException("base item view do not contain id named tagIV");
        }
        bVar.gnD.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(74612);
                if (compoundButton.getTag() == null) {
                    AppMethodBeat.o(74612);
                    return;
                }
                g gVar = (g) compoundButton.getTag();
                if (z) {
                    a.this.moE.mli.put(Long.valueOf(gVar.field_localId), ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(gVar.field_localId));
                } else {
                    a.this.moE.mli.remove(Long.valueOf(gVar.field_localId));
                }
                if (a.this.moE.moG != null) {
                    a.this.moE.moG.iI(gVar.field_localId);
                }
                AppMethodBeat.o(74612);
            }
        });
        bVar.mgf = gVar;
        view.setTag(bVar);
        bVar.moJ = (LinearLayout) view.findViewById(R.id.bq2);
        bVar.moK = (TextView) view.findViewById(R.id.bq3);
        bVar.moK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(74613);
                ab.d("MicroMsg.FavBaseListItem", "manual restart upload");
                if (view.getTag() instanceof g) {
                    com.tencent.mm.plugin.fav.a.b.l((g) view.getTag());
                }
                AppMethodBeat.o(74613);
            }
        });
        return view;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(b bVar, g gVar) {
        bVar.mgf = gVar;
        if (bVar.mgf.field_type == 18) {
            bVar.moH.setVisibility(0);
        } else {
            bVar.moH.setVisibility(8);
        }
        if (this.moE.mlp) {
            bVar.enf.setText(com.tencent.mm.plugin.fav.a.b.iv(bVar.mgf.field_datatotalsize));
        } else {
            bVar.enf.setText(j.g(bVar.enf.getContext(), bVar.mgf.field_updateTime));
        }
        Context context = bVar.gxi.getContext();
        ad aoN = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoN(bVar.mgf.field_fromUser);
        if (aoN == null || !aoN.field_username.equals(bVar.mgf.field_fromUser)) {
            ab.w("MicroMsg.FavBaseListItem", "render name, user is %s, but name is null", bVar.mgf.field_fromUser);
            bVar.gxi.setText("");
            com.tencent.mm.model.ao.a.flu.a(bVar.mgf.field_fromUser, "", null);
        } else {
            CharSequence LC;
            if (t.kH(bVar.mgf.field_fromUser)) {
                abl abl = bVar.mgf.field_favProto.wit;
                if (r.Yz().equals(abl.cEV)) {
                    LC = com.tencent.mm.plugin.fav.a.b.LC(abl.toUser);
                } else {
                    LC = ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.a.b.class)).mI(abl.cEV);
                }
            } else {
                LC = com.tencent.mm.plugin.fav.a.b.LC(aoN.field_username);
            }
            bVar.gxi.setText(com.tencent.mm.pluginsdk.ui.e.j.b(context, LC, bVar.gxi.getTextSize()));
        }
        if (bVar.mgf.bux()) {
            bVar.moJ.setVisibility(0);
        } else {
            bVar.moJ.setVisibility(8);
        }
        bVar.gnD.setTag(gVar);
        if (this.moE.mlh || this.moE.mlp) {
            boolean z;
            bVar.gnD.setVisibility(0);
            CheckBox checkBox = bVar.gnD;
            if (this.moE.mli.get(Long.valueOf(gVar.field_localId)) != null) {
                z = true;
            } else {
                z = false;
            }
            checkBox.setChecked(z);
        } else {
            bVar.gnD.setVisibility(8);
        }
        bVar.moK.setTag(gVar);
        if (gVar.field_tagProto.wiJ == null || gVar.field_tagProto.wiJ.isEmpty()) {
            bVar.moI.setVisibility(8);
        } else {
            bVar.moI.setVisibility(0);
        }
    }
}
