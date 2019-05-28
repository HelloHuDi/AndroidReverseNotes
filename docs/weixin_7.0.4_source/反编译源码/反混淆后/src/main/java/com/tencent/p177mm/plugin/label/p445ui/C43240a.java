package com.tencent.p177mm.plugin.label.p445ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p184aj.C8935m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p213cd.C6394d;
import com.tencent.p177mm.p612ui.AddressView;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.contact.C36250f;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a;
import com.tencent.p177mm.pluginsdk.p597ui.C46503b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.storage.C7616ad;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.label.ui.a */
public final class C43240a extends C46692p<C36250f> {
    public static final ColorStateList nIp = C1338a.m2870h(C4996ah.getContext(), (int) C25738R.color.a7t);
    public static final ColorStateList nIq = C1338a.m2870h(C4996ah.getContext(), (int) C25738R.color.f12092s0);
    List<String> nIr;

    /* renamed from: com.tencent.mm.plugin.label.ui.a$a */
    protected static class C21167a {
        public AddressView nIu;

        public C21167a(View view) {
            AppMethodBeat.m2504i(22627);
            this.nIu = (AddressView) view.findViewById(2131821089);
            AppMethodBeat.m2505o(22627);
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(22636);
        C36250f xB = mo68754xB(i);
        AppMethodBeat.m2505o(22636);
        return xB;
    }

    static {
        AppMethodBeat.m2504i(22638);
        AppMethodBeat.m2505o(22638);
    }

    public C43240a(Context context) {
        super(context, new C36250f());
        AppMethodBeat.m2504i(22628);
        AppMethodBeat.m2505o(22628);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(22629);
        int count = super.getCount();
        AppMethodBeat.m2505o(22629);
        return count;
    }

    /* renamed from: xB */
    public final C36250f mo68754xB(int i) {
        AppMethodBeat.m2504i(22630);
        C36250f c36250f;
        if (mo10892wK(i)) {
            c36250f = (C36250f) bFt();
            AppMethodBeat.m2505o(22630);
            return c36250f;
        }
        if (this.yld != null) {
            c36250f = (C36250f) this.yld.get(Integer.valueOf(i));
            if (c36250f != null) {
                AppMethodBeat.m2505o(22630);
                return c36250f;
            }
        }
        if (i < 0 || !getCursor().moveToPosition(i)) {
            AppMethodBeat.m2505o(22630);
            return null;
        }
        c36250f = C43240a.m76901a(null, getCursor());
        if (this.yld == null) {
            mo74996pN(true);
        }
        if (this.yld != null) {
            this.yld.put(Integer.valueOf(i), c36250f);
        }
        AppMethodBeat.m2505o(22630);
        return c36250f;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C21167a c21167a;
        C46503b c46503b;
        AppMethodBeat.m2504i(22631);
        C7616ad c7616ad = mo68754xB(i).ehM;
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.context, 2130969228, null);
            C21167a c21167a2 = new C21167a(view);
            view.setTag(c21167a2);
            c21167a = c21167a2;
        } else {
            c21167a = (C21167a) view.getTag();
        }
        AddressView addressView = c21167a.nIu;
        String str = c7616ad.field_username;
        float Iz = C40459a.vgN;
        Drawable drawable = addressView.getDrawable();
        if (drawable == null || !(drawable instanceof C46503b)) {
            c46503b = new C46503b(str, Iz);
        } else {
            c46503b = (C46503b) drawable;
        }
        c46503b.setTag(str);
        addressView.setImageDrawable(c46503b);
        addressView.doInvalidate();
        if (c7616ad.field_verifyFlag != 0) {
            String kz = C26417a.flw.mo37873kz(c7616ad.field_verifyFlag);
            if (kz != null) {
                c21167a.nIu.setMaskBitmap(C8935m.m16106rk(kz));
            } else {
                c21167a.nIu.setMaskBitmap(null);
            }
        } else {
            c21167a.nIu.setMaskBitmap(null);
        }
        if (c7616ad.field_deleteFlag == 1) {
            c21167a.nIu.setNickNameTextColor(nIq);
        } else {
            c21167a.nIu.setNickNameTextColor(nIp);
        }
        c21167a.nIu.updateTextColors();
        CharSequence charSequence = c7616ad.xHQ;
        if (charSequence == null) {
            try {
                Context context = this.context;
                charSequence = C1854s.m3866mJ(c7616ad.field_username);
                str = "";
                if (str.length() > 0 && !str.equals(charSequence)) {
                    StringBuilder stringBuilder = new StringBuilder(32);
                    stringBuilder.append(charSequence);
                    stringBuilder.append("(");
                    stringBuilder.append(str);
                    stringBuilder.append(")");
                    charSequence = stringBuilder.toString();
                }
                charSequence = C44089j.m79293b(context, charSequence, c21167a.nIu.getNickNameSize());
            } catch (Exception e) {
                charSequence = null;
            }
            if (charSequence == null) {
                charSequence = "";
            }
            c21167a.nIu.setName(charSequence);
            c7616ad.xHQ = charSequence;
        } else {
            c21167a.nIu.setName(charSequence);
        }
        c21167a.nIu.updatePositionFlag();
        AppMethodBeat.m2505o(22631);
        return view;
    }

    /* renamed from: KC */
    public final synchronized void mo6869KC() {
        Cursor dvo;
        AppMethodBeat.m2504i(22632);
        Object obj = Looper.myLooper() == Looper.getMainLooper() ? 1 : null;
        if (this.nIr == null || this.nIr.size() <= 0) {
            dvo = C6394d.dvo();
        } else {
            C9638aw.m17190ZK();
            dvo = C18628c.m29078XM().mo15760ew(this.nIr);
        }
        if (obj != null) {
            mo68753l(dvo);
            AppMethodBeat.m2505o(22632);
        } else {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(22626);
                    C43240a.this.mo68753l(dvo);
                    AppMethodBeat.m2505o(22626);
                }
            });
            AppMethodBeat.m2505o(22632);
        }
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(22633);
        mo6869KC();
        AppMethodBeat.m2505o(22633);
    }

    /* renamed from: a */
    private static C36250f m76901a(C36250f c36250f, Cursor cursor) {
        AppMethodBeat.m2504i(22634);
        if (c36250f == null) {
            c36250f = new C36250f();
        }
        C9638aw.m17190ZK();
        C7616ad aoI = C18628c.m29078XM().aoI(C7616ad.m13550q(cursor));
        if (aoI == null) {
            c36250f.ehM.mo8995d(cursor);
            C9638aw.m17190ZK();
            C18628c.m29078XM().mo15699W(c36250f.ehM);
        } else {
            c36250f.ehM = aoI;
        }
        AppMethodBeat.m2505o(22634);
        return c36250f;
    }

    /* renamed from: l */
    public final void mo68753l(Cursor cursor) {
        AppMethodBeat.m2504i(22635);
        bIf();
        setCursor(cursor);
        notifyDataSetChanged();
        AppMethodBeat.m2505o(22635);
    }
}
