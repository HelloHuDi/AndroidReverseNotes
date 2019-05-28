package com.tencent.p177mm.p612ui.contact;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.applet.C36043b;
import com.tencent.p177mm.p612ui.applet.C36043b.C23577b;
import com.tencent.p177mm.p612ui.applet.C36043b.C5234a;
import com.tencent.p177mm.p612ui.base.MMSlideDelView;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C15521c;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23597d;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23599f;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23600g;
import com.tencent.p177mm.p612ui.base.MaskLayout;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.pluginsdk.p597ui.C14943d;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;
import java.util.List;

/* renamed from: com.tencent.mm.ui.contact.d */
public final class C36248d extends C46692p<C7616ad> {
    protected MMActivity crP;
    protected List<String> elZ = null;
    C36043b gvm = null;
    private C23577b gvn = null;
    protected C23600g jJO;
    protected C15521c jJP;
    protected C23597d jJR = MMSlideDelView.getItemStatusCallBack();
    protected C23599f oQS;
    C14943d vkK;
    protected String zjx = null;

    /* renamed from: com.tencent.mm.ui.contact.d$2 */
    class C54492 implements C23577b {
        C54492() {
        }

        /* renamed from: mW */
        public final String mo11090mW(int i) {
            AppMethodBeat.m2504i(33561);
            if (i < 0 || i >= C36248d.this.getCount()) {
                C4990ab.m7412e("MicroMsg.ChatroomContactAdapter", "pos is invalid");
                AppMethodBeat.m2505o(33561);
                return null;
            }
            C7616ad c7616ad = (C7616ad) C36248d.this.getItem(i);
            if (c7616ad == null) {
                AppMethodBeat.m2505o(33561);
                return null;
            }
            String str = c7616ad.field_username;
            AppMethodBeat.m2505o(33561);
            return str;
        }

        public final int apO() {
            AppMethodBeat.m2504i(33562);
            int count = C36248d.this.getCount();
            AppMethodBeat.m2505o(33562);
            return count;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.d$1 */
    class C158291 implements C5234a {
        C158291() {
        }

        /* renamed from: wd */
        public final Bitmap mo10738wd(String str) {
            AppMethodBeat.m2504i(33560);
            Bitmap a = C41730b.m73490a(str, false, -1);
            AppMethodBeat.m2505o(33560);
            return a;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.d$a */
    protected static class C36247a {
        public MaskLayout emP;
        public TextView emg;
        public TextView nBN;
        public ViewGroup zlo;
    }

    public C36248d(Context context, String str) {
        super(context, new C7616ad());
        AppMethodBeat.m2504i(33563);
        this.crP = (MMActivity) context;
        this.zjx = str;
        this.gvm = new C36043b(new C158291());
        AppMethodBeat.m2505o(33563);
    }

    public final void setPerformItemClickListener(C23600g c23600g) {
        this.jJO = c23600g;
    }

    /* renamed from: a */
    public final void mo57114a(C23599f c23599f) {
        this.oQS = c23599f;
    }

    public final void setGetViewPositionCallback(C15521c c15521c) {
        this.jJP = c15521c;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(33564);
        int count = getCursor().getCount();
        AppMethodBeat.m2505o(33564);
        return count;
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(33565);
        mo6869KC();
        AppMethodBeat.m2505o(33565);
    }

    /* renamed from: KC */
    public final synchronized void mo6869KC() {
        AppMethodBeat.m2504i(33566);
        C9638aw.m17190ZK();
        Cursor c = C18628c.m29078XM().mo15734c(this.zjx, "", this.elZ);
        bIf();
        setCursor(c);
        notifyDataSetChanged();
        AppMethodBeat.m2505o(33566);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C36247a c36247a;
        int i2;
        AppMethodBeat.m2504i(33567);
        if (this.gvn == null) {
            this.gvn = new C54492();
        }
        if (this.gvm != null) {
            this.gvm.mo56803a(i, this.gvn);
        }
        if (view == null) {
            view = View.inflate(this.crP, 2130969004, null);
            C36247a c36247a2 = new C36247a();
            c36247a2.nBN = (TextView) view.findViewById(2131821069);
            c36247a2.emP = (MaskLayout) view.findViewById(2131821072);
            c36247a2.emg = (TextView) view.findViewById(2131821079);
            c36247a2.zlo = (ViewGroup) view.findViewById(2131821071);
            LayoutParams layoutParams = c36247a2.zlo.getLayoutParams();
            layoutParams.height = (int) (((float) C1338a.m2857am(this.crP, C25738R.dimen.f9768f4)) * C1338a.m2863fZ(this.crP));
            c36247a2.zlo.setLayoutParams(layoutParams);
            view.setTag(c36247a2);
            c36247a = c36247a2;
        } else {
            c36247a = (C36247a) view.getTag();
        }
        C7616ad c7616ad = (C7616ad) getItem(i - 1);
        if (c7616ad == null) {
            i2 = -1;
        } else {
            i2 = c7616ad.field_showHead;
        }
        c7616ad = (C7616ad) getItem(i);
        if (i == 0) {
            String ag = m59668ag(c7616ad);
            if (C42252ah.isNullOrNil(ag)) {
                C4990ab.m7421w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", c7616ad.field_username, Integer.valueOf(i));
                c36247a.nBN.setVisibility(8);
            } else {
                c36247a.nBN.setVisibility(0);
                c36247a.nBN.setText(ag);
                c36247a.nBN.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            if (getItem(i + 1) == null) {
                c36247a.zlo.setBackgroundResource(0);
            }
        } else if (i <= 0 || c7616ad.field_showHead == i2) {
            c36247a.nBN.setVisibility(8);
            m59667a(c36247a, i, i2);
        } else {
            String ag2 = m59668ag(c7616ad);
            c36247a.zlo.setBackgroundResource(C25738R.drawable.f6623k5);
            if (C42252ah.isNullOrNil(ag2)) {
                C4990ab.m7421w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", c7616ad.field_username, Integer.valueOf(i));
                c36247a.nBN.setVisibility(8);
            } else {
                c36247a.nBN.setVisibility(0);
                c36247a.nBN.setText(ag2);
                if (c7616ad.field_showHead == 32) {
                    c36247a.nBN.setCompoundDrawablesWithIntrinsicBounds(C25738R.drawable.aiq, 0, 0, 0);
                    c36247a.nBN.setCompoundDrawablePadding(2);
                } else {
                    c36247a.nBN.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }
            }
            m59667a(c36247a, i, i2);
        }
        c36247a.emg.setTextColor(C1338a.m2870h(this.crP, !C1855t.m3923nI(c7616ad.field_username) ? C25738R.color.a7t : C25738R.color.a7u));
        ImageView imageView = (ImageView) c36247a.emP.getContentView();
        C40460b.m69434b(imageView, c7616ad.field_username);
        C40459a c40459a = (C40459a) imageView.getDrawable();
        if (this.vkK != null) {
            this.vkK.mo27290a(c40459a);
        }
        c36247a.emP.setMaskDrawable(null);
        try {
            if (C1855t.m3903mP(c7616ad.field_username)) {
                ((C32873b) C1720g.m3528K(C32873b.class)).mo44301a(this.crP, c36247a.emg, C1854s.m3866mJ(c7616ad.field_username));
            } else {
                c36247a.emg.setText(C44089j.m79294b(this.crP, C1854s.m3866mJ(c7616ad.field_username), (int) c36247a.emg.getTextSize()));
            }
        } catch (Exception e) {
            c36247a.emg.setText("");
        }
        AppMethodBeat.m2505o(33567);
        return view;
    }

    /* renamed from: a */
    private void m59667a(C36247a c36247a, int i, int i2) {
        AppMethodBeat.m2504i(33568);
        C7616ad c7616ad = (C7616ad) getItem(i + 1);
        if (c7616ad == null || !(c7616ad.field_showHead == i2 || C42252ah.isNullOrNil(m59668ag(c7616ad)))) {
            c36247a.zlo.setBackgroundResource(0);
        }
        AppMethodBeat.m2505o(33568);
    }

    /* renamed from: ag */
    private String m59668ag(C7616ad c7616ad) {
        AppMethodBeat.m2504i(33569);
        String str;
        if (c7616ad.field_showHead == 31) {
            str = "";
            AppMethodBeat.m2505o(33569);
            return str;
        } else if (c7616ad.field_showHead == 43) {
            str = this.crP.getString(C25738R.string.dso);
            AppMethodBeat.m2505o(33569);
            return str;
        } else {
            str = String.valueOf((char) c7616ad.field_showHead);
            AppMethodBeat.m2505o(33569);
            return str;
        }
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
        AppMethodBeat.m2504i(33570);
        C9638aw.m17190ZK();
        Object aoI = C18628c.m29078XM().aoI(C7616ad.m13550q(cursor));
        if (aoI == null) {
            aoI = new C7616ad();
            aoI.mo8995d(cursor);
            C9638aw.m17190ZK();
            C18628c.m29078XM().mo15699W(aoI);
        }
        AppMethodBeat.m2505o(33570);
        return aoI;
    }
}
