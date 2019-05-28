package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.p;
import java.util.List;

public final class d extends p<ad> {
    protected MMActivity crP;
    protected List<String> elZ = null;
    b gvm = null;
    private b.b gvn = null;
    protected g jJO;
    protected c jJP;
    protected com.tencent.mm.ui.base.MMSlideDelView.d jJR = MMSlideDelView.getItemStatusCallBack();
    protected f oQS;
    com.tencent.mm.pluginsdk.ui.d vkK;
    protected String zjx = null;

    protected static class a {
        public MaskLayout emP;
        public TextView emg;
        public TextView nBN;
        public ViewGroup zlo;
    }

    public d(Context context, String str) {
        super(context, new ad());
        AppMethodBeat.i(33563);
        this.crP = (MMActivity) context;
        this.zjx = str;
        this.gvm = new b(new com.tencent.mm.ui.applet.b.a() {
            public final Bitmap wd(String str) {
                AppMethodBeat.i(33560);
                Bitmap a = com.tencent.mm.ah.b.a(str, false, -1);
                AppMethodBeat.o(33560);
                return a;
            }
        });
        AppMethodBeat.o(33563);
    }

    public final void setPerformItemClickListener(g gVar) {
        this.jJO = gVar;
    }

    public final void a(f fVar) {
        this.oQS = fVar;
    }

    public final void setGetViewPositionCallback(c cVar) {
        this.jJP = cVar;
    }

    public final int getCount() {
        AppMethodBeat.i(33564);
        int count = getCursor().getCount();
        AppMethodBeat.o(33564);
        return count;
    }

    public final void KD() {
        AppMethodBeat.i(33565);
        KC();
        AppMethodBeat.o(33565);
    }

    public final synchronized void KC() {
        AppMethodBeat.i(33566);
        aw.ZK();
        Cursor c = com.tencent.mm.model.c.XM().c(this.zjx, "", this.elZ);
        bIf();
        setCursor(c);
        notifyDataSetChanged();
        AppMethodBeat.o(33566);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int i2;
        AppMethodBeat.i(33567);
        if (this.gvn == null) {
            this.gvn = new b.b() {
                public final String mW(int i) {
                    AppMethodBeat.i(33561);
                    if (i < 0 || i >= d.this.getCount()) {
                        ab.e("MicroMsg.ChatroomContactAdapter", "pos is invalid");
                        AppMethodBeat.o(33561);
                        return null;
                    }
                    ad adVar = (ad) d.this.getItem(i);
                    if (adVar == null) {
                        AppMethodBeat.o(33561);
                        return null;
                    }
                    String str = adVar.field_username;
                    AppMethodBeat.o(33561);
                    return str;
                }

                public final int apO() {
                    AppMethodBeat.i(33562);
                    int count = d.this.getCount();
                    AppMethodBeat.o(33562);
                    return count;
                }
            };
        }
        if (this.gvm != null) {
            this.gvm.a(i, this.gvn);
        }
        if (view == null) {
            view = View.inflate(this.crP, R.layout.kv, null);
            a aVar2 = new a();
            aVar2.nBN = (TextView) view.findViewById(R.id.nh);
            aVar2.emP = (MaskLayout) view.findViewById(R.id.nk);
            aVar2.emg = (TextView) view.findViewById(R.id.nr);
            aVar2.zlo = (ViewGroup) view.findViewById(R.id.nj);
            LayoutParams layoutParams = aVar2.zlo.getLayoutParams();
            layoutParams.height = (int) (((float) com.tencent.mm.bz.a.am(this.crP, R.dimen.f4)) * com.tencent.mm.bz.a.fZ(this.crP));
            aVar2.zlo.setLayoutParams(layoutParams);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        ad adVar = (ad) getItem(i - 1);
        if (adVar == null) {
            i2 = -1;
        } else {
            i2 = adVar.field_showHead;
        }
        adVar = (ad) getItem(i);
        if (i == 0) {
            String ag = ag(adVar);
            if (ah.isNullOrNil(ag)) {
                ab.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", adVar.field_username, Integer.valueOf(i));
                aVar.nBN.setVisibility(8);
            } else {
                aVar.nBN.setVisibility(0);
                aVar.nBN.setText(ag);
                aVar.nBN.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            if (getItem(i + 1) == null) {
                aVar.zlo.setBackgroundResource(0);
            }
        } else if (i <= 0 || adVar.field_showHead == i2) {
            aVar.nBN.setVisibility(8);
            a(aVar, i, i2);
        } else {
            String ag2 = ag(adVar);
            aVar.zlo.setBackgroundResource(R.drawable.k5);
            if (ah.isNullOrNil(ag2)) {
                ab.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", adVar.field_username, Integer.valueOf(i));
                aVar.nBN.setVisibility(8);
            } else {
                aVar.nBN.setVisibility(0);
                aVar.nBN.setText(ag2);
                if (adVar.field_showHead == 32) {
                    aVar.nBN.setCompoundDrawablesWithIntrinsicBounds(R.drawable.aiq, 0, 0, 0);
                    aVar.nBN.setCompoundDrawablePadding(2);
                } else {
                    aVar.nBN.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }
            }
            a(aVar, i, i2);
        }
        aVar.emg.setTextColor(com.tencent.mm.bz.a.h(this.crP, !t.nI(adVar.field_username) ? R.color.a7t : R.color.a7u));
        ImageView imageView = (ImageView) aVar.emP.getContentView();
        com.tencent.mm.pluginsdk.ui.a.b.b(imageView, adVar.field_username);
        com.tencent.mm.pluginsdk.ui.a aVar3 = (com.tencent.mm.pluginsdk.ui.a) imageView.getDrawable();
        if (this.vkK != null) {
            this.vkK.a(aVar3);
        }
        aVar.emP.setMaskDrawable(null);
        try {
            if (t.mP(adVar.field_username)) {
                ((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.openim.a.b.class)).a(this.crP, aVar.emg, s.mJ(adVar.field_username));
            } else {
                aVar.emg.setText(j.b(this.crP, s.mJ(adVar.field_username), (int) aVar.emg.getTextSize()));
            }
        } catch (Exception e) {
            aVar.emg.setText("");
        }
        AppMethodBeat.o(33567);
        return view;
    }

    private void a(a aVar, int i, int i2) {
        AppMethodBeat.i(33568);
        ad adVar = (ad) getItem(i + 1);
        if (adVar == null || !(adVar.field_showHead == i2 || ah.isNullOrNil(ag(adVar)))) {
            aVar.zlo.setBackgroundResource(0);
        }
        AppMethodBeat.o(33568);
    }

    private String ag(ad adVar) {
        AppMethodBeat.i(33569);
        String str;
        if (adVar.field_showHead == 31) {
            str = "";
            AppMethodBeat.o(33569);
            return str;
        } else if (adVar.field_showHead == 43) {
            str = this.crP.getString(R.string.dso);
            AppMethodBeat.o(33569);
            return str;
        } else {
            str = String.valueOf((char) adVar.field_showHead);
            AppMethodBeat.o(33569);
            return str;
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        AppMethodBeat.i(33570);
        aw.ZK();
        Object aoI = com.tencent.mm.model.c.XM().aoI(ad.q(cursor));
        if (aoI == null) {
            aoI = new ad();
            aoI.d(cursor);
            aw.ZK();
            com.tencent.mm.model.c.XM().W(aoI);
        }
        AppMethodBeat.o(33570);
        return aoI;
    }
}
