package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.cd.h;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bm;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.readerapp.c.g;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.pluginsdk.ui.applet.f;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

@i
public class ReaderAppUI extends MMActivity {
    private static float density;
    private int cJB = 0;
    private View gwR;
    private com.tencent.mm.ui.widget.b.a jMO;
    private d jOb = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(76814);
            int groupId = menuItem.getGroupId();
            bl blVar;
            String str;
            switch (menuItem.getItemId()) {
                case 0:
                    if (ReaderAppUI.this.cJB == 20) {
                        List Q = g.cdZ().Q((String) ReaderAppUI.this.pFe.getItem(groupId), ReaderAppUI.this.cJB);
                        if (Q.size() > 0) {
                            blVar = (bl) Q.get(0);
                            com.tencent.mm.af.j.b bVar = new com.tencent.mm.af.j.b();
                            bVar.title = blVar.getTitle();
                            bVar.description = blVar.getDigest();
                            bVar.action = "view";
                            bVar.type = 5;
                            bVar.url = blVar.getUrl();
                            String a = com.tencent.mm.af.j.b.a(bVar, null, null);
                            Intent intent = new Intent();
                            intent.putExtra("Retr_Msg_content", a);
                            intent.putExtra("Retr_Msg_Type", 2);
                            intent.putExtra("Retr_Msg_thumb_path", q.v(blVar.aan(), blVar.type, "@T"));
                            intent.putExtra("Retr_Msg_Id", 7377812);
                            a = v.nW(blVar.fnf);
                            intent.putExtra("reportSessionId", a);
                            com.tencent.mm.model.v.b y = v.Zp().y(a, true);
                            y.j("prePublishId", "msg_" + blVar.fnf);
                            y.j("preUsername", "newsapp");
                            y.j("preChatName", "newsapp");
                            y.j("preMsgIndex", Integer.valueOf(0));
                            y.j("sendAppMsgScene", Integer.valueOf(1));
                            com.tencent.mm.plugin.readerapp.b.a.gkE.k(intent, ReaderAppUI.this);
                        }
                        AppMethodBeat.o(76814);
                        return;
                    }
                    break;
                case 1:
                    if (ReaderAppUI.this.cJB == 20) {
                        List Q2 = g.cdZ().Q((String) ReaderAppUI.this.pFe.getItem(groupId), ReaderAppUI.this.cJB);
                        if (!Q2.isEmpty()) {
                            ab.i("MicroMsg.ReaderAppUI", "fav functionId %s, index %d, size %d", str, Integer.valueOf(ReaderAppUI.this.pFg), Integer.valueOf(Q2.size()));
                            if (ReaderAppUI.this.pFg >= Q2.size()) {
                                ReaderAppUI.this.pFg = 0;
                            }
                            blVar = (bl) Q2.get(ReaderAppUI.this.pFg);
                            cl clVar = new cl();
                            String nW = v.nW(blVar.fnf);
                            com.tencent.mm.model.v.b y2 = v.Zp().y(nW, true);
                            y2.j("prePublishId", "msg_" + blVar.fnf);
                            y2.j("preUsername", "newsapp");
                            y2.j("preChatName", "newsapp");
                            y2.j("preMsgIndex", Integer.valueOf(0));
                            y2.j("sendAppMsgScene", Integer.valueOf(1));
                            clVar.cvA.cvF = nW;
                            com.tencent.mm.plugin.readerapp.c.b.a(clVar, blVar, ReaderAppUI.this.pFg);
                            clVar.cvA.cvH = 7;
                            clVar.cvA.activity = ReaderAppUI.this;
                            com.tencent.mm.sdk.b.a.xxA.m(clVar);
                            break;
                        }
                    }
                    break;
                case 2:
                    str = (String) ReaderAppUI.this.pFe.getItem(groupId);
                    if (!bo.isNullOrNil(str)) {
                        g.cU(str, ReaderAppUI.this.cJB);
                        bm cdZ = g.cdZ();
                        int a2 = ReaderAppUI.this.cJB;
                        ab.d("MicroMsg.ReaderAppInfoStorage", "deleteGroup:%s", "delete from " + bm.kH(a2) + " where reserved3 = " + h.escape(str));
                        if (cdZ.fni.hY(bm.kH(a2), "delete from " + bm.kH(a2) + " where reserved3 = " + h.escape(str))) {
                            cdZ.kK(a2);
                            cdZ.doNotify();
                        }
                    }
                    ReaderAppUI.this.refresh();
                    AppMethodBeat.o(76814);
                    return;
            }
            AppMethodBeat.o(76814);
        }
    };
    private String nNr = "";
    private ListView ooS;
    private MMPullDownView ooW;
    private a<String> pFe;
    private e pFf = null;
    private int pFg = 0;
    private b pFh;

    @Deprecated
    class c extends a<String> {
        private Context context;
        private int enb = this.kmW;
        private int jNi;
        private int kmW = 3;
        private int pFo;

        class a {
            TextView ngD;
            ReaderItemListView pFy;

            a() {
            }
        }

        public c(Context context, String str) {
            super(context, str);
            AppMethodBeat.i(76839);
            this.context = context;
            this.pFo = context.getResources().getDimensionPixelSize(R.dimen.f15do);
            this.jNi = context.getResources().getDimensionPixelSize(R.dimen.nc);
            AppMethodBeat.o(76839);
        }

        public final void KD() {
            AppMethodBeat.i(76840);
            KC();
            AppMethodBeat.o(76840);
        }

        public final boolean bdn() {
            return this.kmW >= this.enb;
        }

        public final int getShowCount() {
            return this.kmW;
        }

        public final int bdo() {
            AppMethodBeat.i(76841);
            if (bdn()) {
                AppMethodBeat.o(76841);
                return 0;
            }
            this.kmW += 3;
            if (this.kmW <= this.enb) {
                AppMethodBeat.o(76841);
                return 3;
            }
            this.kmW = this.enb;
            int i = this.enb % 3;
            AppMethodBeat.o(76841);
            return i;
        }

        public final void KC() {
            AppMethodBeat.i(76842);
            this.enb = g.cdZ().kI(ReaderAppUI.this.cJB);
            setCursor(g.cdZ().cp(this.kmW, ReaderAppUI.this.cJB));
            super.notifyDataSetChanged();
            AppMethodBeat.o(76842);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(76843);
            if (view == null) {
                aVar = new a();
                view = View.inflate(this.context, R.layout.amu, null);
                aVar.pFy = (ReaderItemListView) view.findViewById(R.id.dv3);
                aVar.ngD = (TextView) view.findViewById(R.id.duy);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            getItem(i);
            aVar.ngD.setText(com.tencent.mm.pluginsdk.f.h.c(this.context, 0, false));
            ReaderItemListView readerItemListView = aVar.pFy;
            String str = (String) getItem(i);
            OnCreateContextMenuListener a = ReaderAppUI.a(ReaderAppUI.this, false);
            d g = ReaderAppUI.this.jOb;
            readerItemListView.position = i;
            readerItemListView.pFC = a;
            readerItemListView.jOb = g;
            readerItemListView.pFA = g.cdZ().R(str, readerItemListView.type);
            readerItemListView.pFB.notifyDataSetChanged();
            if (ReaderAppUI.this.pFf != null) {
                aVar.ngD.setTextColor(ReaderAppUI.this.pFf.vgW);
                if (ReaderAppUI.this.pFf.vgX) {
                    aVar.ngD.setShadowLayer(2.0f, 1.2f, 1.2f, ReaderAppUI.this.pFf.vgY);
                } else {
                    aVar.ngD.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                }
                if (ReaderAppUI.this.pFf.vgZ) {
                    aVar.ngD.setBackgroundResource(R.drawable.hv);
                    aVar.ngD.setPadding(this.jNi, this.pFo, this.jNi, this.pFo);
                } else {
                    aVar.ngD.setBackgroundColor(0);
                }
            }
            AppMethodBeat.o(76843);
            return view;
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            AppMethodBeat.i(76844);
            String string = cursor.getString(0);
            AppMethodBeat.o(76844);
            return string;
        }
    }

    class a extends a<String> {
        private Context context;
        private int enb;
        private int jNf;
        private int jNg = 0;
        private int jNh = 0;
        private int jNi = 0;
        private int jNj;
        private int kmW;
        private ImageGetter pFn = new ImageGetter() {
            public final Drawable getDrawable(String str) {
                AppMethodBeat.i(76822);
                Drawable drawable = ReaderAppUI.this.getResources().getDrawable(bo.getInt(str, 0));
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                AppMethodBeat.o(76822);
                return drawable;
            }
        };
        private int pFo = 0;
        private int pFp = 0;

        final class a {
            TextView gsf;
            View jOR;
            View jOS;
            View jOT;
            View jOW;
            ImageView jOX;

            a() {
            }
        }

        final class b {
            View gCY;
            TextView gsf;
            View jPQ;
            ImageView jPe;
            View jPn;
            List<a> jPu;
            TextView ngD;
            TextView ooM;
            ImageView pFt;
            ViewGroup pFu;
            MMNeat7extView pFv;
            ImageView pFw;

            b() {
            }
        }

        private static void a(b bVar, a aVar) {
            AppMethodBeat.i(76824);
            if (bVar == null) {
                AppMethodBeat.o(76824);
                return;
            }
            bVar.pFu.addView(aVar.jOR);
            bVar.jPu.add(aVar);
            AppMethodBeat.o(76824);
        }

        public a(Context context, String str) {
            super(context, str);
            AppMethodBeat.i(76825);
            this.context = context;
            this.kmW = 3;
            this.enb = g.cdZ().kI(ReaderAppUI.this.cJB);
            this.jNi = context.getResources().getDimensionPixelSize(R.dimen.nc);
            this.jNg = context.getResources().getDimensionPixelSize(R.dimen.l5);
            this.pFo = context.getResources().getDimensionPixelSize(R.dimen.f15do);
            this.jNh = context.getResources().getDimensionPixelSize(R.dimen.lo);
            this.jNf = context.getResources().getDimensionPixelSize(R.dimen.wv);
            this.jNj = context.getResources().getDimensionPixelSize(R.dimen.wt);
            int gd = com.tencent.mm.bz.a.gd(context);
            int ge = com.tencent.mm.bz.a.ge(context);
            if (gd >= ge) {
                gd = ge;
            }
            this.pFp = (int) (((double) (gd - ((int) (ReaderAppUI.density * 32.0f)))) / 2.35d);
            AppMethodBeat.o(76825);
        }

        public final void KD() {
            AppMethodBeat.i(76826);
            KC();
            AppMethodBeat.o(76826);
        }

        public final boolean bdn() {
            return this.kmW >= this.enb;
        }

        public final int getShowCount() {
            return this.kmW;
        }

        public final int bdo() {
            AppMethodBeat.i(76827);
            if (bdn()) {
                AppMethodBeat.o(76827);
                return 0;
            }
            this.kmW += 3;
            if (this.kmW <= this.enb) {
                AppMethodBeat.o(76827);
                return 3;
            }
            this.kmW = this.enb;
            int i = this.enb % 3;
            AppMethodBeat.o(76827);
            return i;
        }

        public final void KC() {
            AppMethodBeat.i(76828);
            long currentTimeMillis = System.currentTimeMillis();
            this.enb = g.cdZ().kI(20);
            setCursor(g.cdZ().cp(this.kmW, 20));
            ab.i("MicroMsg.ReaderAppUI", "[resetCursor] cost:%sms showCount:%s totalCount:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(this.kmW), Integer.valueOf(this.enb));
            super.notifyDataSetChanged();
            AppMethodBeat.o(76828);
        }

        private String getItem(int i) {
            AppMethodBeat.i(76829);
            String str = (String) super.getItem(i);
            AppMethodBeat.o(76829);
            return str;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            a aVar;
            AppMethodBeat.i(76830);
            if (view == null) {
                b bVar2 = new b();
                view = View.inflate(this.context, R.layout.amt, null);
                bVar2.ngD = (TextView) view.findViewById(R.id.duy);
                bVar2.pFu = (ViewGroup) view.findViewById(R.id.duz);
                bVar2.gCY = view.findViewById(R.id.anp);
                bVar2.jPQ = view.findViewById(R.id.anm);
                bVar2.jPe = (ImageView) view.findViewById(R.id.a8e);
                bVar2.pFw = (ImageView) view.findViewById(R.id.ann);
                bVar2.gsf = (TextView) view.findViewById(R.id.dv1);
                bVar2.pFt = (ImageView) view.findViewById(R.id.dv0);
                bVar2.ooM = (TextView) view.findViewById(R.id.dv2);
                bVar2.jPn = view.findViewById(R.id.a8b);
                bVar2.pFv = (MMNeat7extView) view.findViewById(R.id.ano);
                bVar2.jPu = new ArrayList();
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            for (a aVar2 : bVar.jPu) {
                bVar.pFu.removeView(aVar2.jOR);
            }
            bVar.jPu.clear();
            List Q = g.cdZ().Q(getItem(i), 20);
            if (Q.size() > 0) {
                boolean z;
                int size = Q.size();
                bl blVar = (bl) Q.get(0);
                bVar.ngD.setText(com.tencent.mm.pluginsdk.f.h.c(this.context, blVar.time, false));
                if (ReaderAppUI.this.pFf != null) {
                    bVar.ngD.setTextColor(ReaderAppUI.this.pFf.vgW);
                    if (ReaderAppUI.this.pFf.vgX) {
                        bVar.ngD.setShadowLayer(2.0f, 1.2f, 1.2f, ReaderAppUI.this.pFf.vgY);
                    } else {
                        bVar.ngD.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                    }
                    if (ReaderAppUI.this.pFf.vgZ) {
                        bVar.ngD.setBackgroundResource(R.drawable.hv);
                        bVar.ngD.setPadding(this.jNi, this.pFo, this.jNi, this.pFo);
                    } else {
                        bVar.ngD.setBackgroundColor(0);
                    }
                }
                bVar.jPn.setOnClickListener(ReaderAppUI.this.a(blVar, ReaderAppUI.this.cJB, 0, blVar.getTitle()));
                if (size == 1) {
                    z = true;
                } else {
                    z = false;
                }
                bVar.gsf.setText(blVar.getTitle());
                bVar.ooM.setText(blVar.getDigest());
                Object obj = !bo.isNullOrNil(blVar.aan()) ? 1 : null;
                if (blVar.aai()) {
                    bVar.pFv.ah(Html.fromHtml(blVar.getTitle() + "<img src='2130841560'/>", this.pFn, null));
                } else {
                    bVar.pFv.ah(blVar.getTitle());
                }
                TextView textView = bVar.ooM;
                int i2 = (!z || bo.isNullOrNil(blVar.getDigest())) ? 8 : 0;
                textView.setVisibility(i2);
                bVar.pFw.setVisibility(8);
                if (z) {
                    bVar.jPe.setBackgroundResource(R.drawable.iz);
                    bVar.gCY.setVisibility(0);
                    bVar.pFv.setVisibility(8);
                    bVar.gsf.setVisibility(0);
                } else {
                    bVar.jPe.setBackgroundResource(R.drawable.j0);
                    bVar.gCY.setVisibility(obj != null ? 8 : 0);
                    bVar.gsf.setVisibility(8);
                    bVar.pFv.setVisibility(0);
                    bVar.pFv.setTextColor(ReaderAppUI.this.mController.ylL.getResources().getColor(R.color.t1));
                    bVar.pFv.setBackgroundResource(R.drawable.uv);
                    bVar.pFv.getPaint().setFakeBoldText(true);
                }
                ds(bVar.jPe);
                ds(bVar.jPQ);
                if (obj != null) {
                    bVar.jPQ.setVisibility(0);
                    String aan = blVar.aan();
                    ImageView imageView = bVar.pFt;
                    int i3 = blVar.type;
                    int i4 = this.pFp;
                    AnonymousClass2 anonymousClass2 = new com.tencent.mm.pluginsdk.ui.applet.e.a() {
                        public final void onFinish() {
                            AppMethodBeat.i(76823);
                            if (!z) {
                                bVar.pFv.setTextColor(ReaderAppUI.this.mController.ylL.getResources().getColor(R.color.a69));
                                bVar.pFv.setBackgroundResource(R.drawable.eh);
                            }
                            bVar.pFw.setVisibility(0);
                            AppMethodBeat.o(76823);
                        }
                    };
                    if (com.tencent.mm.at.q.ahs()) {
                        aan = com.tencent.mm.at.q.sy(aan);
                    }
                    int gd = com.tencent.mm.bz.a.gd(imageView.getContext()) - ((int) (ReaderAppUI.density * 32.0f));
                    com.tencent.mm.at.a.a ahp = o.ahp();
                    com.tencent.mm.at.a.a.c.a aVar3 = new com.tencent.mm.at.a.a.c.a();
                    aVar3.ePV = R.drawable.ed;
                    aVar3.ePH = true;
                    aVar3.ePX = "2130837909";
                    aVar3 = aVar3.ct(gd, i4);
                    aVar3.fGV = new f();
                    aVar3.ePJ = q.v(aan, i3, "@T");
                    ahp.a(aan, imageView, aVar3.ahG(), null, new com.tencent.mm.pluginsdk.ui.applet.e(R.drawable.axd, gd, i4, anonymousClass2));
                    bVar.gCY.setBackgroundResource(R.drawable.b18);
                    bVar.gCY.setPadding(this.jNg, this.jNh, this.jNg, this.jNg);
                    bVar.jPe.setVisibility(0);
                } else {
                    bVar.jPQ.setVisibility(8);
                    bVar.gsf.setVisibility(0);
                    bVar.ooM.setVisibility(bo.isNullOrNil(blVar.getDigest()) ? 8 : 0);
                    if (z) {
                        bVar.gCY.setBackgroundResource(R.drawable.iq);
                    } else {
                        bVar.gCY.setBackgroundResource(R.drawable.ip);
                    }
                    bVar.gCY.setPadding(this.jNg, this.jNg, this.jNg, this.jNg);
                    bVar.jPe.setVisibility(8);
                }
                if (size > 1) {
                    for (int i5 = 1; i5 < size - 1; i5++) {
                        a(bVar, Q, R.layout.an0, i5, blVar.getTitle());
                    }
                    a(bVar, Q, R.layout.amz, size - 1, blVar.getTitle());
                }
            }
            bVar.jPn.setTag(Integer.valueOf(i));
            bVar.jPn.setTag(R.id.c_, Integer.valueOf(0));
            ReaderAppUI.this.jMO.c(bVar.jPn, ReaderAppUI.a(ReaderAppUI.this, Q.size() == 1), ReaderAppUI.this.jOb);
            int i6 = 1;
            Iterator it = bVar.jPu.iterator();
            while (true) {
                int i7 = i6;
                if (it.hasNext()) {
                    aVar2 = (a) it.next();
                    aVar2.jOR.setTag(Integer.valueOf(i));
                    ReaderAppUI.this.jMO.c(aVar2.jOR, ReaderAppUI.a(ReaderAppUI.this, Q.size() == 1), ReaderAppUI.this.jOb);
                    View view2 = aVar2.jOR;
                    i6 = i7 + 1;
                    view2.setTag(R.id.c_, Integer.valueOf(i7));
                } else {
                    AppMethodBeat.o(76830);
                    return view;
                }
            }
        }

        private void a(b bVar, List<bl> list, int i, int i2, String str) {
            AppMethodBeat.i(76831);
            a aVar = new a();
            aVar.jOR = View.inflate(this.context, i, null);
            aVar.gsf = (TextView) aVar.jOR.findViewById(R.id.cx);
            aVar.jOX = (ImageView) aVar.jOR.findViewById(R.id.wj);
            aVar.jOW = aVar.jOR.findViewById(R.id.wi);
            aVar.jOS = aVar.jOR.findViewById(R.id.a7y);
            aVar.jOT = aVar.jOR.findViewById(R.id.a7z);
            a(bVar, aVar);
            bl blVar = (bl) list.get(i2);
            a(aVar, i2, list);
            aVar.gsf.setText(blVar.getTitle());
            if (blVar.aai()) {
                aVar.gsf.setText(Html.fromHtml(blVar.getTitle() + "<img src='2130841553'/>", this.pFn, null));
            } else {
                aVar.gsf.setText(blVar.getTitle());
            }
            if (bo.isNullOrNil(blVar.aan())) {
                aVar.jOW.setVisibility(8);
            } else {
                aVar.jOX.setVisibility(0);
                a(blVar.aan(), aVar.jOX, blVar.type, this.jNf, this.jNf, "@S");
            }
            aVar.jOR.setOnClickListener(ReaderAppUI.this.a(blVar, ReaderAppUI.this.cJB, i2, str));
            AppMethodBeat.o(76831);
        }

        private void ds(View view) {
            AppMethodBeat.i(76832);
            LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.pFp;
            view.setLayoutParams(layoutParams);
            AppMethodBeat.o(76832);
        }

        private static void O(View view, int i) {
            AppMethodBeat.i(76833);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams.rightMargin = i;
            view.setLayoutParams(layoutParams);
            AppMethodBeat.o(76833);
        }

        private void a(a aVar, int i, List<bl> list) {
            AppMethodBeat.i(76834);
            int size = list.size();
            if (i != 1) {
                aVar.jOS.setVisibility(0);
                bl blVar = (bl) list.get(i);
                if (bo.isNullOrNil(((bl) list.get(i - 1)).aan()) || bo.isNullOrNil(blVar.aan())) {
                    O(aVar.jOS, this.jNg);
                } else {
                    O(aVar.jOS, this.jNj);
                }
            } else if (bo.isNullOrNil(((bl) list.get(0)).aan())) {
                aVar.jOS.setVisibility(0);
                O(aVar.jOS, this.jNg);
            } else {
                aVar.jOS.setVisibility(8);
            }
            if (i == 1) {
                if (i == size - 1) {
                    aVar.jOT.setPadding(0, this.jNg, 0, this.jNg);
                    AppMethodBeat.o(76834);
                    return;
                }
                aVar.jOT.setPadding(0, this.jNg, 0, this.jNi);
                AppMethodBeat.o(76834);
            } else if (i == size - 1) {
                aVar.jOT.setPadding(0, this.jNi, 0, this.jNg);
                AppMethodBeat.o(76834);
            } else {
                aVar.jOT.setPadding(0, this.jNi, 0, this.jNi);
                AppMethodBeat.o(76834);
            }
        }

        private static void a(String str, ImageView imageView, int i, int i2, int i3, String str2) {
            String sy;
            AppMethodBeat.i(76835);
            if (com.tencent.mm.at.q.ahs()) {
                sy = com.tencent.mm.at.q.sy(str);
            } else {
                sy = str;
            }
            com.tencent.mm.at.a.a ahp = o.ahp();
            com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
            aVar.ePV = R.color.k8;
            aVar.ePH = true;
            aVar = aVar.ct(i2, i3);
            aVar.fGV = new f();
            aVar.ePJ = q.v(sy, i, str2);
            ahp.a(sy, imageView, aVar.ahG(), null, new com.tencent.mm.pluginsdk.ui.applet.e(0, 0, 0, null));
            AppMethodBeat.o(76835);
        }
    }

    static class b {
        HashMap<String, Set<String>> pFx = new HashMap();

        public b() {
            AppMethodBeat.i(76838);
            AppMethodBeat.o(76838);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ReaderAppUI() {
        AppMethodBeat.i(76845);
        AppMethodBeat.o(76845);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(76846);
        super.onCreate(bundle);
        this.cJB = getIntent().getIntExtra("type", 0);
        ab.i("MicroMsg.ReaderAppUI", "[onCreate] readerType:%s", Integer.valueOf(this.cJB));
        this.cJB = 20;
        density = com.tencent.mm.bz.a.getDensity(this);
        this.pFh = new b();
        long currentTimeMillis = System.currentTimeMillis();
        initView();
        ab.i("MicroMsg.ReaderAppUI", "[initView] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        this.nNr = bl.kG(this.cJB);
        if (20 == this.cJB && u.ac("newsapp", null) > 0) {
            com.tencent.mm.plugin.report.service.h.pYm.e(13440, Integer.valueOf(2));
        }
        AppMethodBeat.o(76846);
    }

    public void onDestroy() {
        AppMethodBeat.i(76847);
        if (this.pFe != null) {
            this.pFe.bIf();
            this.pFe.dww();
        }
        if (this.pFh != null) {
            b bVar = this.pFh;
            if (!bVar.pFx.isEmpty()) {
                for (Entry entry : bVar.pFx.entrySet()) {
                    String str = (String) entry.getKey();
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String str2 : (Set) entry.getValue()) {
                        if (stringBuilder.length() <= 0) {
                            stringBuilder.append(str2);
                        } else {
                            stringBuilder.append("||").append(str2);
                        }
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.e(15413, Integer.valueOf(9), str, stringBuilder.toString());
                }
                bVar.pFx.clear();
            }
        }
        super.onDestroy();
        AppMethodBeat.o(76847);
    }

    public final int getLayoutId() {
        return R.layout.amn;
    }

    public void onResume() {
        AppMethodBeat.i(76848);
        super.onResume();
        if (this.cJB == 20) {
            setMMTitle((int) R.string.cb1);
        } else {
            setMMTitle((int) R.string.cb4);
        }
        ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().jO(this.nNr);
        ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancelNotification(this.nNr);
        ((j) com.tencent.mm.kernel.g.K(j.class)).XR().apb(this.nNr);
        g.cdZ().c(this.pFe);
        this.pFe.a(null, null);
        refresh();
        AppMethodBeat.o(76848);
    }

    public void onPause() {
        AppMethodBeat.i(76849);
        super.onPause();
        ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().jO("");
        g.cdZ().d(this.pFe);
        ((j) com.tencent.mm.kernel.g.K(j.class)).XR().apb(this.nNr);
        AppMethodBeat.o(76849);
    }

    public final void refresh() {
        AppMethodBeat.i(76850);
        TextView textView = (TextView) findViewById(R.id.a74);
        textView.setText(this.cJB == 20 ? R.string.dhx : R.string.di3);
        if (this.pFe.getCount() == 0) {
            textView.setVisibility(0);
            AppMethodBeat.o(76850);
            return;
        }
        textView.setVisibility(8);
        AppMethodBeat.o(76850);
    }

    private void aP(Context context, String str) {
        AppMethodBeat.i(76851);
        try {
            this.pFf = new e(bo.convertStreamToString(context.getAssets().open(str)));
            AppMethodBeat.o(76851);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ReaderAppUI", e, "", new Object[0]);
            AppMethodBeat.o(76851);
        }
    }

    public final void initView() {
        AppMethodBeat.i(76852);
        aP(this, "chatting/purecolor_chat.xml");
        this.ooS = (ListView) findViewById(R.id.duj);
        this.ooW = (MMPullDownView) findViewById(R.id.dui);
        this.gwR = getLayoutInflater().inflate(R.layout.amr, null);
        this.ooS.addHeaderView(this.gwR);
        ((TextView) findViewById(R.id.a74)).setText(R.string.dhp);
        if (this.cJB == 20) {
            this.pFe = new a(this, "");
        } else if (this.cJB == 11) {
            this.pFe = new c(this, "");
        }
        this.ooS.setOnScrollListener(this.pFe);
        this.ooS.setAdapter(this.pFe);
        this.ooS.setTranscriptMode(0);
        registerForContextMenu(this.ooS);
        this.jMO = new com.tencent.mm.ui.widget.b.a(this);
        if (this.pFe.getCount() == 0) {
            Intent intent = new Intent(this, ReaderAppIntroUI.class);
            intent.putExtra("type", this.cJB);
            startActivity(intent);
            finish();
            AppMethodBeat.o(76852);
            return;
        }
        this.ooW.setOnTopLoadDataListener(new MMPullDownView.g() {
            public final boolean bhn() {
                AppMethodBeat.i(76815);
                if (ReaderAppUI.this.pFe.bdn()) {
                    ReaderAppUI.this.ooS.setSelectionFromTop(0, ReaderAppUI.this.ooW.getTopHeight());
                    AppMethodBeat.o(76815);
                } else {
                    int count = ReaderAppUI.this.pFe.getCount();
                    int bdo = ReaderAppUI.this.pFe.bdo();
                    ab.v("MicroMsg.ReaderAppUI", "onLoadData add count:".concat(String.valueOf(bdo)));
                    ReaderAppUI.this.pFe.a(null, null);
                    ab.d("MicroMsg.ReaderAppUI", "onTopLoadData nowCount:%d, preCount:%d", Integer.valueOf(ReaderAppUI.this.pFe.getCount()), Integer.valueOf(count));
                    if (ReaderAppUI.this.pFe.getCount() > count) {
                        ab.i("MicroMsg.ReaderAppUI", "pullDownView nowCount > preCount on set position %d, set pullDownView.getTopHeight() %d", Integer.valueOf(bdo + 1), Integer.valueOf(ReaderAppUI.this.ooW.getTopHeight()));
                        k.a(ReaderAppUI.this.ooS, bdo + 1, ReaderAppUI.this.ooW.getTopHeight(), false);
                    }
                    AppMethodBeat.o(76815);
                }
                return true;
            }
        });
        this.ooW.setTopViewVisible(true);
        this.ooW.setAtBottomCallBack(new com.tencent.mm.ui.base.MMPullDownView.c() {
            public final boolean bhm() {
                AppMethodBeat.i(76816);
                View childAt = ReaderAppUI.this.ooS.getChildAt(ReaderAppUI.this.ooS.getChildCount() - 1);
                if (childAt == null) {
                    AppMethodBeat.o(76816);
                    return false;
                } else if (childAt.getBottom() > ReaderAppUI.this.ooS.getHeight() || ReaderAppUI.this.ooS.getLastVisiblePosition() != ReaderAppUI.this.ooS.getAdapter().getCount() - 1) {
                    AppMethodBeat.o(76816);
                    return false;
                } else {
                    AppMethodBeat.o(76816);
                    return true;
                }
            }
        });
        this.ooW.setAtTopCallBack(new MMPullDownView.d() {
            public final boolean bhl() {
                AppMethodBeat.i(76817);
                View childAt = ReaderAppUI.this.ooS.getChildAt(ReaderAppUI.this.ooS.getFirstVisiblePosition());
                if (childAt == null || childAt.getTop() != 0) {
                    AppMethodBeat.o(76817);
                    return false;
                }
                AppMethodBeat.o(76817);
                return true;
            }
        });
        this.ooW.setIsBottomShowAll(true);
        this.pFe.a((com.tencent.mm.ui.p.a) new com.tencent.mm.ui.p.a() {
            public final void apt() {
                AppMethodBeat.i(76818);
                ReaderAppUI.this.ooW.setIsTopShowAll(ReaderAppUI.this.pFe.bdn());
                AppMethodBeat.o(76818);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(76819);
                ReaderAppUI.this.finish();
                AppMethodBeat.o(76819);
                return true;
            }
        });
        addIconOptionMenu(0, R.string.cd, R.raw.actionbar_setting_icon, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(76820);
                com.tencent.mm.plugin.readerapp.b.a.gkE.c(new Intent().putExtra("Contact_User", ReaderAppUI.this.nNr), ReaderAppUI.this);
                AppMethodBeat.o(76820);
                return true;
            }
        });
        this.ooS.setSelection((this.pFe.getShowCount() - 1) + this.ooS.getHeaderViewsCount());
        AppMethodBeat.o(76852);
    }

    public final OnClickListener a(bl blVar, int i, int i2, String str) {
        AppMethodBeat.i(76853);
        b bVar = this.pFh;
        String title = blVar.getTitle();
        if (!bo.isNullOrNil(str)) {
            Set set;
            if (bVar.pFx.containsKey(str)) {
                set = (Set) bVar.pFx.get(str);
            } else {
                set = new HashSet();
                bVar.pFx.put(str, set);
            }
            if (!bo.isNullOrNil(title)) {
                set.add(title);
            }
        }
        final int i3 = i;
        final String str2 = str;
        final bl blVar2 = blVar;
        final int i4 = i2;
        AnonymousClass9 anonymousClass9 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(76821);
                if (20 == i3) {
                    com.tencent.mm.plugin.report.service.h.pYm.e(15413, Integer.valueOf(8), str2, blVar2.getTitle());
                    Intent intent = new Intent();
                    intent.putExtra("mode", 1);
                    String url = blVar2.getUrl();
                    intent.putExtra("news_svr_id", blVar2.fnf);
                    intent.putExtra("news_svr_tweetid", blVar2.aaj());
                    intent.putExtra("rawUrl", ReaderAppUI.a(ReaderAppUI.this, url));
                    intent.putExtra("title", blVar2.getName());
                    intent.putExtra("webpageTitle", blVar2.getTitle());
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    Bundle bundle = new Bundle();
                    bundle.putInt("snsWebSource", 3);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("shortUrl", blVar2.aak());
                    intent.putExtra("type", blVar2.type);
                    intent.putExtra("tweetid", blVar2.aaj());
                    intent.putExtra("geta8key_username", "newsapp");
                    intent.putExtra("KPublisherId", "msg_" + Long.toString(blVar2.fnf));
                    intent.putExtra("pre_username", "newsapp");
                    intent.putExtra("prePublishId", "msg_" + Long.toString(blVar2.fnf));
                    intent.putExtra("preUsername", "newsapp");
                    intent.putExtra("preChatName", "newsapp");
                    intent.putExtra("preMsgIndex", i4);
                    intent.putExtra("geta8key_scene", 16);
                    intent.addFlags(536870912);
                    com.tencent.mm.plugin.readerapp.b.a.gkE.i(intent, ReaderAppUI.this);
                }
                AppMethodBeat.o(76821);
            }
        };
        AppMethodBeat.o(76853);
        return anonymousClass9;
    }

    private PackageInfo VA(String str) {
        PackageInfo packageInfo = null;
        AppMethodBeat.i(76854);
        if (str.length() == 0) {
            AppMethodBeat.o(76854);
        } else {
            try {
                packageInfo = this.mController.ylL.getPackageManager().getPackageInfo(str, 0);
                AppMethodBeat.o(76854);
            } catch (NameNotFoundException e) {
                ab.printErrStackTrace("MicroMsg.ReaderAppUI", e, "", new Object[0]);
                AppMethodBeat.o(76854);
            }
        }
        return packageInfo;
    }
}
