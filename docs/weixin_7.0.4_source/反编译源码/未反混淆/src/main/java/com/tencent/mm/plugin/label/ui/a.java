package com.tencent.mm.plugin.label.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.m;
import com.tencent.mm.cd.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.b;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.AddressView;
import com.tencent.mm.ui.contact.f;
import com.tencent.mm.ui.p;
import java.util.List;

public final class a extends p<f> {
    public static final ColorStateList nIp = com.tencent.mm.bz.a.h(ah.getContext(), (int) R.color.a7t);
    public static final ColorStateList nIq = com.tencent.mm.bz.a.h(ah.getContext(), (int) R.color.s0);
    List<String> nIr;

    protected static class a {
        public AddressView nIu;

        public a(View view) {
            AppMethodBeat.i(22627);
            this.nIu = (AddressView) view.findViewById(R.id.o1);
            AppMethodBeat.o(22627);
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(22636);
        f xB = xB(i);
        AppMethodBeat.o(22636);
        return xB;
    }

    static {
        AppMethodBeat.i(22638);
        AppMethodBeat.o(22638);
    }

    public a(Context context) {
        super(context, new f());
        AppMethodBeat.i(22628);
        AppMethodBeat.o(22628);
    }

    public final int getCount() {
        AppMethodBeat.i(22629);
        int count = super.getCount();
        AppMethodBeat.o(22629);
        return count;
    }

    public final f xB(int i) {
        AppMethodBeat.i(22630);
        f fVar;
        if (wK(i)) {
            fVar = (f) bFt();
            AppMethodBeat.o(22630);
            return fVar;
        }
        if (this.yld != null) {
            fVar = (f) this.yld.get(Integer.valueOf(i));
            if (fVar != null) {
                AppMethodBeat.o(22630);
                return fVar;
            }
        }
        if (i < 0 || !getCursor().moveToPosition(i)) {
            AppMethodBeat.o(22630);
            return null;
        }
        fVar = a(null, getCursor());
        if (this.yld == null) {
            pN(true);
        }
        if (this.yld != null) {
            this.yld.put(Integer.valueOf(i), fVar);
        }
        AppMethodBeat.o(22630);
        return fVar;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        b bVar;
        AppMethodBeat.i(22631);
        ad adVar = xB(i).ehM;
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.context, R.layout.qv, null);
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        AddressView addressView = aVar.nIu;
        String str = adVar.field_username;
        float Iz = com.tencent.mm.pluginsdk.ui.a.vgN;
        Drawable drawable = addressView.getDrawable();
        if (drawable == null || !(drawable instanceof b)) {
            bVar = new b(str, Iz);
        } else {
            bVar = (b) drawable;
        }
        bVar.setTag(str);
        addressView.setImageDrawable(bVar);
        addressView.doInvalidate();
        if (adVar.field_verifyFlag != 0) {
            String kz = com.tencent.mm.model.ao.a.flw.kz(adVar.field_verifyFlag);
            if (kz != null) {
                aVar.nIu.setMaskBitmap(m.rk(kz));
            } else {
                aVar.nIu.setMaskBitmap(null);
            }
        } else {
            aVar.nIu.setMaskBitmap(null);
        }
        if (adVar.field_deleteFlag == 1) {
            aVar.nIu.setNickNameTextColor(nIq);
        } else {
            aVar.nIu.setNickNameTextColor(nIp);
        }
        aVar.nIu.updateTextColors();
        CharSequence charSequence = adVar.xHQ;
        if (charSequence == null) {
            try {
                Context context = this.context;
                charSequence = s.mJ(adVar.field_username);
                str = "";
                if (str.length() > 0 && !str.equals(charSequence)) {
                    StringBuilder stringBuilder = new StringBuilder(32);
                    stringBuilder.append(charSequence);
                    stringBuilder.append("(");
                    stringBuilder.append(str);
                    stringBuilder.append(")");
                    charSequence = stringBuilder.toString();
                }
                charSequence = j.b(context, charSequence, aVar.nIu.getNickNameSize());
            } catch (Exception e) {
                charSequence = null;
            }
            if (charSequence == null) {
                charSequence = "";
            }
            aVar.nIu.setName(charSequence);
            adVar.xHQ = charSequence;
        } else {
            aVar.nIu.setName(charSequence);
        }
        aVar.nIu.updatePositionFlag();
        AppMethodBeat.o(22631);
        return view;
    }

    public final synchronized void KC() {
        Cursor dvo;
        AppMethodBeat.i(22632);
        Object obj = Looper.myLooper() == Looper.getMainLooper() ? 1 : null;
        if (this.nIr == null || this.nIr.size() <= 0) {
            dvo = d.dvo();
        } else {
            aw.ZK();
            dvo = c.XM().ew(this.nIr);
        }
        if (obj != null) {
            l(dvo);
            AppMethodBeat.o(22632);
        } else {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(22626);
                    a.this.l(dvo);
                    AppMethodBeat.o(22626);
                }
            });
            AppMethodBeat.o(22632);
        }
    }

    public final void KD() {
        AppMethodBeat.i(22633);
        KC();
        AppMethodBeat.o(22633);
    }

    private static f a(f fVar, Cursor cursor) {
        AppMethodBeat.i(22634);
        if (fVar == null) {
            fVar = new f();
        }
        aw.ZK();
        ad aoI = c.XM().aoI(ad.q(cursor));
        if (aoI == null) {
            fVar.ehM.d(cursor);
            aw.ZK();
            c.XM().W(fVar.ehM);
        } else {
            fVar.ehM = aoI;
        }
        AppMethodBeat.o(22634);
        return fVar;
    }

    public final void l(Cursor cursor) {
        AppMethodBeat.i(22635);
        bIf();
        setCursor(cursor);
        notifyDataSetChanged();
        AppMethodBeat.o(22635);
    }
}
