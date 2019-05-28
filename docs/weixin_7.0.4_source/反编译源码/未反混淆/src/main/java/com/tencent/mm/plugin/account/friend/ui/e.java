package com.tencent.mm.plugin.account.friend.ui;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class e extends d {
    private final int Zb;
    private final MMActivity crP;
    private String gtz;
    private final a gxE;
    private final c gxF;
    private com.tencent.mm.plugin.account.friend.ui.d.a gxG;
    boolean gxH = false;
    private a gxI = new a() {
        public final void d(int i, String str, int i2) {
            AppMethodBeat.i(108589);
            ab.d("MicroMsg.QQFriendAdapter", "[cpan] postion:%d qq:%s status:%d", Integer.valueOf(i), str, Integer.valueOf(i2));
            ao aoVar = (ao) e.this.getItem(i);
            if (aoVar == null) {
                ab.e("MicroMsg.QQFriendAdapter", "[cpan] qq friend is null. qq:%s", str);
                AppMethodBeat.o(108589);
            } else if (bo.isNullOrNil(aoVar.getUsername())) {
                ab.e("MicroMsg.QQFriendAdapter", "[cpan] qq friend username is null. qq:%s", str);
                AppMethodBeat.o(108589);
            } else {
                ab.d("MicroMsg.QQFriendAdapter", "qq friend:%s", aoVar.toString());
                if (aoVar.gwD == 0) {
                    int[] iArr = new int[]{p.cB(aoVar.gwC)};
                    g gVar = new g(e.this.crP, new com.tencent.mm.plugin.account.friend.ui.g.a() {
                        public final void e(boolean z, String str) {
                            AppMethodBeat.i(108587);
                            ao ge = ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).ge((long) p.cB(str));
                            if (ge != null) {
                                ge.frT = 2;
                                ab.d("MicroMsg.QQFriendAdapter", "qq friend onSendInviteEmail:%s", ge.toString());
                                ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(ge.gwC, ge);
                                e.this.KC();
                                AppMethodBeat.o(108587);
                                return;
                            }
                            ab.w("MicroMsg.QQFriendAdapter", "cpan qq friedn is null. qq:%s", ge);
                            AppMethodBeat.o(108587);
                        }
                    }, (byte) 0);
                    gVar.m(iArr);
                    gVar.gyj = aoVar.gwC;
                    aoVar.frT = 1;
                    ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(aoVar.gwC, aoVar);
                    e.this.KC();
                    AppMethodBeat.o(108589);
                    return;
                }
                if (aoVar.gwD == 1) {
                    com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(e.this.crP, new com.tencent.mm.pluginsdk.ui.applet.a.a() {
                        public final void a(boolean z, boolean z2, String str, String str2) {
                            AppMethodBeat.i(108588);
                            ab.i("MicroMsg.QQFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", Boolean.valueOf(z), Boolean.valueOf(z2), str, str2);
                            long longValue = new p(p.cB(str2)).longValue();
                            ao ge = ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).ge(longValue);
                            if (ge != null && z) {
                                ge.username = str;
                            }
                            if (ge != null) {
                                ge.frT = 2;
                                ab.d("MicroMsg.QQFriendAdapter", "f :%s", ge.toString());
                                ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(longValue, ge);
                                e.this.KC();
                            } else {
                                ab.w("MicroMsg.QQFriendAdapter", "cpan qq friend is null. qq:%s", str2);
                            }
                            if (z && ge != null) {
                                d.wl(str);
                            }
                            AppMethodBeat.o(108588);
                        }
                    });
                    aVar.gyj = aoVar.gwC;
                    aVar.vjO = false;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(Integer.valueOf(12));
                    aVar.b(aoVar.getUsername(), linkedList, true);
                    aoVar.frT = 1;
                    ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(aoVar.gwC, aoVar);
                    e.this.KC();
                }
                AppMethodBeat.o(108589);
            }
        }
    };

    interface a {
        void d(int i, String str, int i2);
    }

    class b {
        ImageView eks;
        TextView gnh;
        int gtF;
        TextView gtG;
        View gtH;
        ProgressBar gtI;
        String gxL;
        int status;

        public b(View view) {
            AppMethodBeat.i(108594);
            this.eks = (ImageView) view.findViewById(R.id.bo3);
            this.gtG = (TextView) view.findViewById(R.id.bo4);
            this.gtH = view.findViewById(R.id.dqs);
            this.gnh = (TextView) view.findViewById(R.id.dqt);
            this.gtI = (ProgressBar) view.findViewById(R.id.dqu);
            this.gtH.setOnClickListener(new OnClickListener(e.this) {
                public final void onClick(View view) {
                    AppMethodBeat.i(108593);
                    if (e.this.gxI != null) {
                        e.this.gxI.d(b.this.gtF, b.this.gxL, b.this.status);
                    }
                    AppMethodBeat.o(108593);
                }
            });
            AppMethodBeat.o(108594);
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        AppMethodBeat.i(108601);
        ao aoVar = (ao) obj;
        if (aoVar == null) {
            aoVar = new ao();
        }
        aoVar.d(cursor);
        AppMethodBeat.o(108601);
        return aoVar;
    }

    public e(MMActivity mMActivity, int i) {
        super(mMActivity, new ao());
        AppMethodBeat.i(108595);
        this.crP = mMActivity;
        this.Zb = i;
        this.gxH = mMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
        this.gxE = new a(mMActivity, new com.tencent.mm.plugin.account.friend.ui.a.a() {
            public final void wk(String str) {
                AppMethodBeat.i(108590);
                ap apVar = (ap) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
                ao wj = apVar.wj(str);
                if (wj == null) {
                    ab.w("MicroMsg.QQFriendAdapter", "[cpan] dealSucc failed. qqlist is null. username is :%s", String.valueOf(str));
                    AppMethodBeat.o(108590);
                    return;
                }
                wj.gwD = 2;
                apVar.a(wj.gwC, wj);
                e.this.notifyDataSetChanged();
                ad aoO = ((j) g.K(j.class)).XM().aoO(str);
                if (aoO == null) {
                    wj = ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).wj(str);
                    if (wj != null) {
                        wj.aqu();
                        ab.d("MicroMsg.QQFriendAdapter", "user " + str + " qq " + wj.gwC);
                        ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(wj.gwC, wj);
                    }
                } else if (!((aoO.field_conRemark != null && !aoO.field_conRemark.equals("")) || wj == null || wj.aqr() == null || wj.aqr().equals(""))) {
                    t.b(aoO, wj.aqr());
                }
                bv.aaq().c(26, new Object[0]);
                AppMethodBeat.o(108590);
            }

            public final void W(String str, boolean z) {
                AppMethodBeat.i(108591);
                if (z) {
                    ao wj = ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).wj(str);
                    if (wj != null) {
                        wj.aqu();
                        ab.d("MicroMsg.QQFriendAdapter", "user " + str + " qq " + wj.gwC);
                        ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(wj.gwC, wj);
                    } else {
                        ab.w("MicroMsg.QQFriendAdapter", "[cpan] dealFail failed. qqlist is null. username is :%s", String.valueOf(str));
                    }
                }
                e.this.notifyDataSetChanged();
                AppMethodBeat.o(108591);
            }
        });
        this.gxF = new c(mMActivity, new com.tencent.mm.plugin.account.friend.ui.c.a() {
            public final void dm(boolean z) {
                AppMethodBeat.i(108592);
                if (z) {
                    e.this.notifyDataSetChanged();
                }
                AppMethodBeat.o(108592);
            }
        });
        AppMethodBeat.o(108595);
    }

    public final void a(com.tencent.mm.plugin.account.friend.ui.d.a aVar) {
        this.gxG = aVar;
    }

    public final void KD() {
        AppMethodBeat.i(108597);
        KC();
        AppMethodBeat.o(108597);
    }

    public final void KC() {
        AppMethodBeat.i(108598);
        bIf();
        if (bo.isNullOrNil(this.gtz)) {
            setCursor(((ap) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).E(this.Zb, this.gxH));
        } else {
            setCursor(((ap) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).c(this.Zb, this.gtz, this.gxH));
        }
        if (!(this.gxG == null || this.gtz == null)) {
            this.gxG.mT(getCursor().getCount());
        }
        notifyDataSetChanged();
        AppMethodBeat.o(108598);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        Bitmap fr;
        AppMethodBeat.i(108599);
        ao aoVar = (ao) getItem(i);
        if (view == null) {
            view = View.inflate(this.crP, R.layout.am0, null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.gtF = i;
        bVar.gxL = aoVar.gwC;
        bVar.status = aoVar.gwD;
        bVar.gtG.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.crP, aoVar.getDisplayName(), bVar.gtG.getTextSize()));
        if (p.cB(aoVar.gwC) != 0) {
            fr = com.tencent.mm.ah.b.fr(aoVar.gwC);
        } else {
            fr = null;
        }
        if (fr == null) {
            bVar.eks.setImageDrawable(com.tencent.mm.bz.a.g(this.crP, R.raw.default_avatar));
        } else {
            bVar.eks.setImageBitmap(fr);
        }
        if (!this.gxH) {
            switch (aoVar.gwD) {
                case 0:
                    if (aoVar.frT != 2) {
                        bVar.gtH.setClickable(true);
                        bVar.gtH.setBackgroundResource(R.drawable.fp);
                        bVar.gnh.setText(R.string.c12);
                        bVar.gnh.setTextColor(this.crP.getResources().getColor(R.color.a69));
                        break;
                    }
                    bVar.gtH.setClickable(false);
                    bVar.gtH.setBackgroundDrawable(null);
                    bVar.gnh.setText(R.string.c13);
                    bVar.gnh.setTextColor(this.crP.getResources().getColor(R.color.t4));
                    break;
                case 1:
                case 2:
                    if (!((j) g.K(j.class)).XM().aoJ(aoVar.getUsername()) && !r.Yz().equals(aoVar.getUsername())) {
                        if (aoVar.frT != 2) {
                            bVar.gtH.setClickable(true);
                            bVar.gtH.setBackgroundResource(R.drawable.fp);
                            bVar.gnh.setText(R.string.c10);
                            bVar.gnh.setTextColor(this.crP.getResources().getColor(R.color.a69));
                            break;
                        }
                        bVar.gtH.setClickable(false);
                        bVar.gtH.setBackgroundDrawable(null);
                        bVar.gnh.setText(R.string.c16);
                        bVar.gnh.setTextColor(this.crP.getResources().getColor(R.color.t4));
                        break;
                    }
                    bVar.gtH.setClickable(false);
                    bVar.gtH.setBackgroundDrawable(null);
                    bVar.gnh.setText(R.string.c11);
                    bVar.gnh.setTextColor(this.crP.getResources().getColor(R.color.t4));
                    break;
                    break;
            }
            switch (aoVar.frT) {
                case 0:
                case 2:
                    bVar.gnh.setVisibility(0);
                    bVar.gtI.setVisibility(4);
                    break;
                case 1:
                    bVar.gnh.setVisibility(4);
                    bVar.gtI.setVisibility(0);
                    break;
            }
        }
        bVar.gtH.setVisibility(8);
        AppMethodBeat.o(108599);
        return view;
    }

    public final void qj(String str) {
        AppMethodBeat.i(108600);
        notifyDataSetChanged();
        AppMethodBeat.o(108600);
    }

    public final void vM(String str) {
        AppMethodBeat.i(108596);
        this.gtz = bo.vA(str.trim());
        bIf();
        KC();
        AppMethodBeat.o(108596);
    }
}
