package com.tencent.p177mm.plugin.fav.p410ui.p412d;

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
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.fav.p410ui.C34171j;
import com.tencent.p177mm.plugin.fav.p410ui.C45939l;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.p993a.C34530b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.abh;
import com.tencent.p177mm.protocal.protobuf.abl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.fav.ui.d.a */
public abstract class C20714a {
    protected C45939l mhy = null;
    public final C3083a moE = new C3083a();

    /* renamed from: com.tencent.mm.plugin.fav.ui.d.a$a */
    public static class C3083a {
        public String ema;
        public boolean jLC;
        public long lastUpdateTime;
        public boolean mlh;
        public Map<Long, C27966g> mli;
        public boolean mlp;
        public C20717c moG;

        public final String toString() {
            AppMethodBeat.m2504i(74614);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("lastUpdateTime:").append(this.lastUpdateTime).append(10);
            stringBuilder.append("isSearching:").append(this.jLC).append(10);
            stringBuilder.append("search str:").append(this.ema).append(10);
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(74614);
            return stringBuilder2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.d.a$b */
    public static class C3084b {
        public TextView enf;
        public CheckBox gnD;
        public TextView gxi;
        public C27966g mgf;
        public View moH;
        public ImageView moI;
        public LinearLayout moJ;
        public TextView moK;
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.d.a$2 */
    class C207152 implements OnClickListener {
        C207152() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(74613);
            C4990ab.m7410d("MicroMsg.FavBaseListItem", "manual restart upload");
            if (view.getTag() instanceof C27966g) {
                C39037b.m66410l((C27966g) view.getTag());
            }
            AppMethodBeat.m2505o(74613);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.d.a$1 */
    class C207161 implements OnCheckedChangeListener {
        C207161() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.m2504i(74612);
            if (compoundButton.getTag() == null) {
                AppMethodBeat.m2505o(74612);
                return;
            }
            C27966g c27966g = (C27966g) compoundButton.getTag();
            if (z) {
                C20714a.this.moE.mli.put(Long.valueOf(c27966g.field_localId), ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c27966g.field_localId));
            } else {
                C20714a.this.moE.mli.remove(Long.valueOf(c27966g.field_localId));
            }
            if (C20714a.this.moE.moG != null) {
                C20714a.this.moE.moG.mo36019iI(c27966g.field_localId);
            }
            AppMethodBeat.m2505o(74612);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.d.a$c */
    public interface C20717c {
        /* renamed from: iI */
        void mo36019iI(long j);
    }

    /* renamed from: a */
    public abstract View mo7336a(View view, ViewGroup viewGroup, C27966g c27966g);

    /* renamed from: a */
    public abstract void mo7337a(View view, abh abh);

    public C20714a(C45939l c45939l) {
        this.mhy = c45939l;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final View mo36015a(View view, C3084b c3084b, C27966g c27966g) {
        if (view == null) {
            throw new NullPointerException("base item view is null");
        }
        c3084b.moH = view.findViewById(2131823915);
        if (c3084b.moH == null) {
            throw new IllegalArgumentException("base item view do not contain id named favTypeLayout");
        }
        c3084b.gxi = (TextView) view.findViewById(2131820611);
        if (c3084b.gxi == null) {
            throw new IllegalArgumentException("base item view do not contain id named fav_name");
        }
        c3084b.enf = (TextView) view.findViewById(2131820618);
        if (c3084b.enf == null) {
            throw new IllegalArgumentException("base item view do not contain id named fav_time");
        }
        c3084b.gnD = (CheckBox) view.findViewById(2131820600);
        if (c3084b.gnD == null) {
            throw new IllegalArgumentException("base item view do not contain id named checkbox");
        }
        c3084b.moI = (ImageView) view.findViewById(2131823916);
        if (c3084b.moI == null) {
            throw new IllegalArgumentException("base item view do not contain id named tagIV");
        }
        c3084b.gnD.setOnCheckedChangeListener(new C207161());
        c3084b.mgf = c27966g;
        view.setTag(c3084b);
        c3084b.moJ = (LinearLayout) view.findViewById(2131823913);
        c3084b.moK = (TextView) view.findViewById(2131823914);
        c3084b.moK.setOnClickListener(new C207152());
        return view;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo36016a(C3084b c3084b, C27966g c27966g) {
        c3084b.mgf = c27966g;
        if (c3084b.mgf.field_type == 18) {
            c3084b.moH.setVisibility(0);
        } else {
            c3084b.moH.setVisibility(8);
        }
        if (this.moE.mlp) {
            c3084b.enf.setText(C39037b.m66407iv(c3084b.mgf.field_datatotalsize));
        } else {
            c3084b.enf.setText(C34171j.m56019g(c3084b.enf.getContext(), c3084b.mgf.field_updateTime));
        }
        Context context = c3084b.gxi.getContext();
        C7616ad aoN = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoN(c3084b.mgf.field_fromUser);
        if (aoN == null || !aoN.field_username.equals(c3084b.mgf.field_fromUser)) {
            C4990ab.m7421w("MicroMsg.FavBaseListItem", "render name, user is %s, but name is null", c3084b.mgf.field_fromUser);
            c3084b.gxi.setText("");
            C26417a.flu.mo20966a(c3084b.mgf.field_fromUser, "", null);
        } else {
            CharSequence LC;
            if (C1855t.m3896kH(c3084b.mgf.field_fromUser)) {
                abl abl = c3084b.mgf.field_favProto.wit;
                if (C1853r.m3846Yz().equals(abl.cEV)) {
                    LC = C39037b.m66338LC(abl.toUser);
                } else {
                    LC = ((C34530b) C1720g.m3528K(C34530b.class)).mo55065mI(abl.cEV);
                }
            } else {
                LC = C39037b.m66338LC(aoN.field_username);
            }
            c3084b.gxi.setText(C44089j.m79293b(context, LC, c3084b.gxi.getTextSize()));
        }
        if (c3084b.mgf.bux()) {
            c3084b.moJ.setVisibility(0);
        } else {
            c3084b.moJ.setVisibility(8);
        }
        c3084b.gnD.setTag(c27966g);
        if (this.moE.mlh || this.moE.mlp) {
            boolean z;
            c3084b.gnD.setVisibility(0);
            CheckBox checkBox = c3084b.gnD;
            if (this.moE.mli.get(Long.valueOf(c27966g.field_localId)) != null) {
                z = true;
            } else {
                z = false;
            }
            checkBox.setChecked(z);
        } else {
            c3084b.gnD.setVisibility(8);
        }
        c3084b.moK.setTag(c27966g);
        if (c27966g.field_tagProto.wiJ == null || c27966g.field_tagProto.wiJ.isEmpty()) {
            c3084b.moI.setVisibility(8);
        } else {
            c3084b.moI.setVisibility(0);
        }
    }
}
