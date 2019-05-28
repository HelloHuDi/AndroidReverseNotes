package com.tencent.mm.ui.voicesearch;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.aj.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.but;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.v;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class b extends p<ad> implements f {
    private Context context;
    private ProgressDialog ehJ = null;
    private List<String> elZ = null;
    private LinkedList<but> fjr = new LinkedList();
    public com.tencent.mm.ui.applet.b gvm = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a() {
        public final Bitmap wd(String str) {
            AppMethodBeat.i(35327);
            Bitmap a = com.tencent.mm.ah.b.a(str, false, -1);
            AppMethodBeat.o(35327);
            return a;
        }
    });
    private com.tencent.mm.ui.applet.b.b gvn = null;
    public String sfv;
    private int showType = 1;
    public String[] yDL;
    private boolean zLv = false;
    private ad zLw = null;
    private boolean zLx = true;
    public boolean zLy = false;
    private boolean zLz = false;
    public String zjx;

    protected static class a {
        public MaskLayout emP;
        public TextView emg;
        public CheckBox gnD;
        public TextView nBN;
        public ProgressBar zLD;
        public TextView zpr;
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(35361);
        ad PP = PP(i);
        AppMethodBeat.o(35361);
        return PP;
    }

    static /* synthetic */ void c(b bVar, Cursor cursor) {
        AppMethodBeat.i(35366);
        bVar.setCursor(cursor);
        AppMethodBeat.o(35366);
    }

    static /* synthetic */ void d(b bVar, Cursor cursor) {
        AppMethodBeat.i(35367);
        bVar.setCursor(cursor);
        AppMethodBeat.o(35367);
    }

    static /* synthetic */ int e(b bVar) {
        AppMethodBeat.i(35363);
        int realCount = bVar.getRealCount();
        AppMethodBeat.o(35363);
        return realCount;
    }

    static /* synthetic */ void e(b bVar, Cursor cursor) {
        AppMethodBeat.i(35368);
        bVar.setCursor(cursor);
        AppMethodBeat.o(35368);
    }

    public b(Context context, int i) {
        super(context, new ad());
        AppMethodBeat.i(35339);
        this.context = context;
        this.showType = i;
        this.zLw = new ad();
        this.zLw.setUsername("_find_more_public_contact_");
        this.zLw.NK();
        this.zjx = "@micromsg.with.all.biz.qq.com";
        AppMethodBeat.o(35339);
    }

    public final void fl(final List<String> list) {
        AppMethodBeat.i(35340);
        ay(new Runnable() {
            public final void run() {
                AppMethodBeat.i(35331);
                if (b.this.elZ == null) {
                    b.this.elZ = new ArrayList();
                }
                b.this.elZ.clear();
                b.this.elZ.addAll(list);
                b.this.elZ.add("officialaccounts");
                b.this.elZ.add("helper_entry");
                AppMethodBeat.o(35331);
            }
        });
        AppMethodBeat.o(35340);
    }

    public final void qU(boolean z) {
        AppMethodBeat.i(35341);
        this.zLy = z;
        if (z) {
            this.zLw.NK();
        }
        AppMethodBeat.o(35341);
    }

    public final void detach() {
        AppMethodBeat.i(35342);
        if (this.gvm != null) {
            this.gvm.detach();
            this.gvm = null;
        }
        AppMethodBeat.o(35342);
    }

    public final int getViewTypeCount() {
        return 3;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(35343);
        if (this.showType == 2) {
            AppMethodBeat.o(35343);
            return 2;
        } else if (PQ(i)) {
            AppMethodBeat.o(35343);
            return 1;
        } else {
            AppMethodBeat.o(35343);
            return 0;
        }
    }

    public final int bFs() {
        int i = 0;
        AppMethodBeat.i(35344);
        if (this.zLv) {
            if (!this.zLw.isHidden()) {
                i = this.fjr.size();
            }
            i++;
            AppMethodBeat.o(35344);
            return i;
        }
        AppMethodBeat.o(35344);
        return 0;
    }

    public final but PO(int i) {
        AppMethodBeat.i(35345);
        try {
            ab.d("MicroMsg.SearchResultAdapter", "position " + i + " size " + this.fjr.size() + "  " + (i - getRealCount()));
            but but = (but) this.fjr.get((i - getRealCount()) - 1);
            AppMethodBeat.o(35345);
            return but;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SearchResultAdapter", e, "", new Object[0]);
            AppMethodBeat.o(35345);
            return null;
        }
    }

    public final ad PP(int i) {
        AppMethodBeat.i(35346);
        ad adVar;
        if (wK(i)) {
            adVar = (ad) bFt();
            AppMethodBeat.o(35346);
            return adVar;
        }
        adVar = (ad) super.getItem(i);
        AppMethodBeat.o(35346);
        return adVar;
    }

    public final void qV(final boolean z) {
        AppMethodBeat.i(35347);
        ay(new Runnable() {
            public final void run() {
                AppMethodBeat.i(35332);
                b.this.zLv = z;
                AppMethodBeat.o(35332);
            }
        });
        AppMethodBeat.o(35347);
    }

    public final void asx(final String str) {
        AppMethodBeat.i(35348);
        ay(new Runnable() {
            public final void run() {
                AppMethodBeat.i(35333);
                if (b.this.zLw.isHidden()) {
                    b.this.zLw.NL();
                    if (b.this.zLx) {
                        aw.Rg().a(new com.tencent.mm.plugin.messenger.a.f(str, 3), 0);
                        b.this.zLz = true;
                        AppMethodBeat.o(35333);
                        return;
                    }
                }
                b.this.zLw.NK();
                AppMethodBeat.o(35333);
            }
        });
        AppMethodBeat.o(35348);
    }

    public final boolean PQ(int i) {
        AppMethodBeat.i(35349);
        if (this.zLv) {
            int realCount = getRealCount();
            if (i == realCount && i < realCount + bFs()) {
                AppMethodBeat.o(35349);
                return true;
            }
        }
        AppMethodBeat.o(35349);
        return false;
    }

    public final boolean isEnabled(int i) {
        AppMethodBeat.i(35350);
        if (!PQ(i) || (!(this.fjr == null || this.fjr.size() == 0) || this.zLx)) {
            AppMethodBeat.o(35350);
            return true;
        }
        AppMethodBeat.o(35350);
        return false;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(35351);
        boolean wK = wK(i);
        boolean PQ = PQ(i);
        a aVar;
        a aVar2;
        String kz;
        if (this.zLv && wK) {
            if (view != null) {
                aVar = (a) view.getTag();
                if (PQ && aVar.zLD == null) {
                    view = null;
                }
            }
            if (view != null) {
                aVar2 = (a) view.getTag();
            } else if (PQ) {
                view = View.inflate(this.context, R.layout.q0, null);
                aVar2 = new a();
                aVar2.emg = (TextView) view.findViewById(R.id.nr);
                aVar2.zLD = (ProgressBar) view.findViewById(R.id.b1g);
                view.setTag(aVar2);
            } else {
                view = View.inflate(this.context, R.layout.qq, null);
                aVar2 = new a();
                aVar2.nBN = (TextView) view.findViewById(R.id.nh);
                aVar2.emP = (MaskLayout) view.findViewById(R.id.nk);
                aVar2.emg = (TextView) view.findViewById(R.id.nr);
                aVar2.gnD = (CheckBox) view.findViewById(R.id.no);
                aVar2.zpr = (TextView) view.findViewById(R.id.ns);
                view.setTag(aVar2);
            }
            if (PQ) {
                if (this.zLz) {
                    aVar2.zLD.setVisibility(0);
                } else {
                    aVar2.zLD.setVisibility(8);
                }
                ab.d("MicroMsg.SearchResultAdapter", "refresh  " + this.zLx);
                if ((this.fjr == null || this.fjr.size() == 0) && !this.zLx) {
                    aVar2.emg.setText(this.context.getString(R.string.e_));
                    aVar2.emg.setTextColor(this.context.getResources().getColor(R.color.t4));
                } else {
                    aVar2.emg.setText(this.context.getString(R.string.ea));
                    aVar2.emg.setTextColor(com.tencent.mm.bz.a.h(this.context, (int) R.color.a7t));
                }
            } else {
                if (this.gvn == null) {
                    this.gvn = new com.tencent.mm.ui.applet.b.b() {
                        public final String mW(int i) {
                            AppMethodBeat.i(35334);
                            if (i < 0) {
                                ab.e("MicroMsg.SearchResultAdapter", "pos is invalid");
                                AppMethodBeat.o(35334);
                                return null;
                            }
                            b bVar = b.this;
                            but PO = bVar.PO((b.e(bVar) + i) + 1);
                            if (PO == null) {
                                AppMethodBeat.o(35334);
                                return null;
                            }
                            String str = PO.wcB.wVI;
                            AppMethodBeat.o(35334);
                            return str;
                        }

                        public final int apO() {
                            AppMethodBeat.i(35335);
                            if (b.this.fjr == null) {
                                AppMethodBeat.o(35335);
                                return 0;
                            }
                            int size = b.this.fjr.size();
                            AppMethodBeat.o(35335);
                            return size;
                        }
                    };
                }
                if (this.gvm != null) {
                    this.gvm.a((i - getRealCount()) - 1, this.gvn);
                }
                but PO = PO(i);
                aVar2.nBN.setVisibility(8);
                if (PO == null) {
                    AppMethodBeat.o(35351);
                    return view;
                }
                aVar2.zpr.setVisibility(8);
                com.tencent.mm.pluginsdk.ui.a.b.b((ImageView) aVar2.emP.getContentView(), PO.wcB.wVI);
                if (PO.wBT == 0) {
                    aVar2.emP.setMaskDrawable(null);
                } else if (com.tencent.mm.model.ao.a.flw != null) {
                    kz = com.tencent.mm.model.ao.a.flw.kz(PO.wBT);
                    if (kz != null) {
                        aVar2.emP.a(m.rk(kz), com.tencent.mm.ui.base.MaskLayout.a.SUBSCRIPT_DRAWABLE_DIRECTION_BOTTOM_RIGHT);
                    } else {
                        aVar2.emP.setMaskDrawable(null);
                    }
                } else {
                    aVar2.emP.setMaskDrawable(null);
                }
                try {
                    aVar2.emg.setText(j.b(this.context, bo.nullAsNil(PO.wyX.wVI), aVar2.emg.getTextSize()));
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.SearchResultAdapter", e, "", new Object[0]);
                    aVar2.emg.setText("");
                }
            }
            AppMethodBeat.o(35351);
            return view;
        } else if (this.showType == 2) {
            if (view == null) {
                view = View.inflate(this.context, R.layout.b1w, null);
                aVar2 = new a();
                aVar2.emg = (TextView) view.findViewById(R.id.nr);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            ad PP = PP(i);
            aVar.emg.setTextColor(com.tencent.mm.bz.a.h(this.context, (int) R.color.a7t));
            try {
                aVar.emg.setText(j.b(this.context, this.context.getString(R.string.f36, new Object[]{s.a(PP, PP.field_username)}), aVar.emg.getTextSize()));
            } catch (Exception e2) {
                aVar.emg.setText("");
            }
            aVar.emg.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            AppMethodBeat.o(35351);
            return view;
        } else {
            View view2;
            if (view != null) {
                aVar = (a) view.getTag();
                view2 = aVar == null ? null : view;
            } else {
                aVar = null;
                view2 = view;
            }
            if (view2 == null) {
                view2 = v.hu(this.context).inflate(R.layout.qq, null);
                aVar2 = new a();
                aVar2.nBN = (TextView) view2.findViewById(R.id.nh);
                aVar2.emP = (MaskLayout) view2.findViewById(R.id.nk);
                aVar2.emg = (TextView) view2.findViewById(R.id.nr);
                aVar2.gnD = (CheckBox) view2.findViewById(R.id.no);
                aVar2.zpr = (TextView) view2.findViewById(R.id.ns);
                view2.setTag(aVar2);
            } else {
                aVar2 = aVar;
            }
            ad PP2 = PP(i);
            if (aVar2.nBN != null) {
                aVar2.nBN.setVisibility(8);
            }
            aVar2.emg.setTextColor(com.tencent.mm.bz.a.h(this.context, !t.nI(PP2.field_username) ? R.color.a7t : R.color.a7u));
            com.tencent.mm.pluginsdk.ui.a.b.b((ImageView) aVar2.emP.getContentView(), PP2.field_username);
            aVar2.zpr.setVisibility(8);
            if (PP2.field_verifyFlag == 0) {
                aVar2.emP.setMaskDrawable(null);
            } else if (com.tencent.mm.model.ao.a.flw != null) {
                kz = com.tencent.mm.model.ao.a.flw.kz(PP2.field_verifyFlag);
                if (kz != null) {
                    aVar2.emP.a(m.rk(kz), com.tencent.mm.ui.base.MaskLayout.a.SUBSCRIPT_DRAWABLE_DIRECTION_BOTTOM_RIGHT);
                } else {
                    aVar2.emP.setMaskDrawable(null);
                }
            } else {
                aVar2.emP.setMaskDrawable(null);
            }
            try {
                SpannableString b = j.b(this.context, s.mJ(PP2.field_username), (int) aVar2.emg.getTextSize());
                if (t.mP(PP2.field_username)) {
                    aVar2.emg.setText(((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).a(this.context, b));
                } else {
                    aVar2.emg.setText(b);
                }
            } catch (Exception e3) {
                aVar2.emg.setText("");
            }
            AppMethodBeat.o(35351);
            return view2;
        }
    }

    public final void KC() {
        AppMethodBeat.i(35352);
        ll(false);
        AppMethodBeat.o(35352);
    }

    public final void ll(final boolean z) {
        AppMethodBeat.i(35353);
        ay(new Runnable() {
            public final void run() {
                int i = 0;
                AppMethodBeat.i(35336);
                b bVar;
                if (b.this.yDL != null && b.this.yDL.length != 0) {
                    ArrayList arrayList = new ArrayList();
                    String[] g = b.this.yDL;
                    int length = g.length;
                    while (i < length) {
                        String str = g[i];
                        if (b.this.asz(str)) {
                            arrayList.add(str);
                        }
                        i++;
                    }
                    if (arrayList.size() > 0) {
                        b bVar2 = b.this;
                        aw.ZK();
                        b.a(bVar2, c.XM().a((String[]) arrayList.toArray(new String[arrayList.size()]), b.this.zjx, b.this.elZ));
                        AppMethodBeat.o(35336);
                        return;
                    }
                    bVar = b.this;
                    aw.ZK();
                    b.b(bVar, c.XM().dsF());
                    AppMethodBeat.o(35336);
                } else if (b.this.sfv == null) {
                    bVar = b.this;
                    aw.ZK();
                    b.e(bVar, c.XM().dsF());
                    AppMethodBeat.o(35336);
                } else if (b.this.zjx.equals("@all.chatroom.contact")) {
                    Cursor a;
                    if (z) {
                        a = aw.ZK().fke.a(b.this.sfv, "@micromsg.with.all.biz.qq.com.openim", b.this.elZ, false);
                    } else {
                        a = aw.ZK().fke.a(b.this.sfv, "@micromsg.with.all.biz.qq.com", b.this.elZ, false);
                    }
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    while (a.moveToNext()) {
                        String string = a.getString(a.getColumnIndex("username"));
                        if (t.mN(string)) {
                            arrayList3.add(string);
                        } else {
                            arrayList2.add(string);
                        }
                    }
                    if (!a.isClosed()) {
                        a.close();
                    }
                    if (arrayList2.size() == 0 && arrayList3.size() == 0) {
                        aw.ZK();
                        a = c.XM().dsF();
                    } else {
                        a = aw.ZK().fke.a(b.this.sfv, arrayList2, null, arrayList3, b.this.elZ);
                    }
                    b.d(b.this, a);
                    AppMethodBeat.o(35336);
                } else {
                    b.c(b.this, aw.ZK().fke.a(b.this.sfv, b.this.zjx, b.this.elZ, true));
                    AppMethodBeat.o(35336);
                }
            }
        });
        AppMethodBeat.o(35353);
    }

    public final void KD() {
        AppMethodBeat.i(35354);
        bIf();
        ll(false);
        AppMethodBeat.o(35354);
    }

    public final void onResume() {
        AppMethodBeat.i(35355);
        aw.Rg().a(106, (f) this);
        AppMethodBeat.o(35355);
    }

    public final void onPause() {
        AppMethodBeat.i(35356);
        aw.Rg().b(106, (f) this);
        AppMethodBeat.o(35356);
    }

    public static String asy(String str) {
        AppMethodBeat.i(35357);
        String trim = str.trim();
        if (trim.startsWith("@")) {
            trim = trim.substring(1) + "%@micromsg.with.all.biz.qq.com";
        }
        ab.d("MicroMsg.SearchResultAdapter", "translateQueryText [" + trim + "]");
        AppMethodBeat.o(35357);
        return trim;
    }

    public final void onSceneEnd(int i, int i2, String str, final com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(35358);
        ab.d("MicroMsg.SearchResultAdapter", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (mVar.getType() != 106) {
            ab.e("MicroMsg.SearchResultAdapter", "error type");
            AppMethodBeat.o(35358);
            return;
        }
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        this.zLz = false;
        if (com.tencent.mm.ui.u.a.a(this.context, i, i2, str, 7)) {
            this.zLx = false;
            AppMethodBeat.o(35358);
        } else if (i == 4 && i2 == -4) {
            ay(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(35338);
                    b.this.zLx = false;
                    AppMethodBeat.o(35338);
                }
            });
            AppMethodBeat.o(35358);
        } else if (i == 0 && i2 == 0) {
            ay(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(35329);
                    buv bOj = ((com.tencent.mm.plugin.messenger.a.f) mVar).bOj();
                    ab.d("MicroMsg.SearchResultAdapter", "count " + bOj.wod);
                    if (bOj.wod > 0) {
                        for (but but : bOj.woe) {
                            if (t.kv(but.wBT)) {
                                if (b.this.fjr == null) {
                                    b.this.fjr = new LinkedList();
                                }
                                b.this.fjr.add(but);
                            }
                        }
                    } else {
                        String a = aa.a(bOj.wcB);
                        ab.d("MicroMsg.SearchResultAdapter", "user ".concat(String.valueOf(a)));
                        if (bo.nullAsNil(a).length() > 0) {
                            but but2 = new but();
                            but2.wcB = bOj.wcB;
                            but2.wBT = bOj.wBT;
                            but2.guQ = bOj.guQ;
                            but2.wyX = bOj.wyX;
                            but2.guS = bOj.guS;
                            but2.guW = bOj.guW;
                            but2.guP = bOj.guP;
                            but2.guO = bOj.guO;
                            but2.guN = bOj.guN;
                            but2.wBU = bOj.wBU;
                            but2.wBX = bOj.wBX;
                            but2.wBV = bOj.wBV;
                            but2.wBW = bOj.wBW;
                            but2.wBZ = bOj.wBZ;
                            o.acd().n(a, aa.a(bOj.vEF));
                            if (b.this.fjr == null) {
                                b.this.fjr = new LinkedList();
                            }
                            b.this.fjr.clear();
                            if (t.kv(but2.wBT)) {
                                b.this.fjr.add(but2);
                            }
                            ab.d("MicroMsg.SearchResultAdapter", "count " + b.this.fjr.size());
                        }
                    }
                    b.this.zLx = false;
                    AppMethodBeat.o(35329);
                }
            });
            AppMethodBeat.o(35358);
        } else {
            ay(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(35328);
                    b.this.zLx = false;
                    AppMethodBeat.o(35328);
                }
            });
            AppMethodBeat.o(35358);
        }
    }

    public final void ay(final Runnable runnable) {
        AppMethodBeat.i(35359);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            notifyDataSetChanged();
            AppMethodBeat.o(35359);
            return;
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(35330);
                runnable.run();
                b.this.notifyDataSetChanged();
                AppMethodBeat.o(35330);
            }
        });
        AppMethodBeat.o(35359);
    }

    public final boolean asz(String str) {
        AppMethodBeat.i(35360);
        if (!(this.elZ == null || str == null)) {
            for (String equals : this.elZ) {
                if (equals.equals(str)) {
                    AppMethodBeat.o(35360);
                    return false;
                }
            }
        }
        AppMethodBeat.o(35360);
        return true;
    }
}
