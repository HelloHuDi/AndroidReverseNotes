package com.tencent.p177mm.plugin.readerapp.p490ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.model.C32779bl;
import com.tencent.p177mm.model.C32780bm;
import com.tencent.p177mm.model.C32798u;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C41764q;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p612ui.C46692p.C30723a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.MMPullDownView;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5258c;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5260d;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5262g;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.notification.p1652b.C46115a;
import com.tencent.p177mm.plugin.readerapp.p1015c.C21568b;
import com.tencent.p177mm.plugin.readerapp.p1015c.C39565g;
import com.tencent.p177mm.plugin.readerapp.p1654b.C46155a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.C30080q;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.pluginsdk.p597ui.C14945e;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35836e;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35836e.C35837a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35838f;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C35897k;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

@C18524i
/* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderAppUI */
public class ReaderAppUI extends MMActivity {
    private static float density;
    private int cJB = 0;
    private View gwR;
    private C24088a jMO;
    private C5279d jOb = new C288012();
    private String nNr = "";
    private ListView ooS;
    private MMPullDownView ooW;
    private C43419a<String> pFe;
    private C14945e pFf = null;
    private int pFg = 0;
    private C28800b pFh;

    /* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderAppUI$5 */
    class C36855 implements C5260d {
        C36855() {
        }

        public final boolean bhl() {
            AppMethodBeat.m2504i(76817);
            View childAt = ReaderAppUI.this.ooS.getChildAt(ReaderAppUI.this.ooS.getFirstVisiblePosition());
            if (childAt == null || childAt.getTop() != 0) {
                AppMethodBeat.m2505o(76817);
                return false;
            }
            AppMethodBeat.m2505o(76817);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderAppUI$6 */
    class C36866 implements C30723a {
        C36866() {
        }

        public final void apt() {
            AppMethodBeat.m2504i(76818);
            ReaderAppUI.this.ooW.setIsTopShowAll(ReaderAppUI.this.pFe.bdn());
            AppMethodBeat.m2505o(76818);
        }
    }

    @Deprecated
    /* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderAppUI$c */
    class C12946c extends C43419a<String> {
        private Context context;
        private int enb = this.kmW;
        private int jNi;
        private int kmW = 3;
        private int pFo;

        /* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderAppUI$c$a */
        class C12947a {
            TextView ngD;
            ReaderItemListView pFy;

            C12947a() {
            }
        }

        public C12946c(Context context, String str) {
            super(context, str);
            AppMethodBeat.m2504i(76839);
            this.context = context;
            this.pFo = context.getResources().getDimensionPixelSize(C25738R.dimen.f9723do);
            this.jNi = context.getResources().getDimensionPixelSize(C25738R.dimen.f10011nc);
            AppMethodBeat.m2505o(76839);
        }

        /* renamed from: KD */
        public final void mo6870KD() {
            AppMethodBeat.m2504i(76840);
            mo6869KC();
            AppMethodBeat.m2505o(76840);
        }

        public final boolean bdn() {
            return this.kmW >= this.enb;
        }

        public final int getShowCount() {
            return this.kmW;
        }

        public final int bdo() {
            AppMethodBeat.m2504i(76841);
            if (bdn()) {
                AppMethodBeat.m2505o(76841);
                return 0;
            }
            this.kmW += 3;
            if (this.kmW <= this.enb) {
                AppMethodBeat.m2505o(76841);
                return 3;
            }
            this.kmW = this.enb;
            int i = this.enb % 3;
            AppMethodBeat.m2505o(76841);
            return i;
        }

        /* renamed from: KC */
        public final void mo6869KC() {
            AppMethodBeat.m2504i(76842);
            this.enb = C39565g.cdZ().mo53338kI(ReaderAppUI.this.cJB);
            setCursor(C39565g.cdZ().mo53336cp(this.kmW, ReaderAppUI.this.cJB));
            super.notifyDataSetChanged();
            AppMethodBeat.m2505o(76842);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C12947a c12947a;
            AppMethodBeat.m2504i(76843);
            if (view == null) {
                c12947a = new C12947a();
                view = View.inflate(this.context, 2130970451, null);
                c12947a.pFy = (ReaderItemListView) view.findViewById(2131826836);
                c12947a.ngD = (TextView) view.findViewById(2131826831);
                view.setTag(c12947a);
            } else {
                c12947a = (C12947a) view.getTag();
            }
            getItem(i);
            c12947a.ngD.setText(C14835h.m23089c(this.context, 0, false));
            ReaderItemListView readerItemListView = c12947a.pFy;
            String str = (String) getItem(i);
            OnCreateContextMenuListener a = ReaderAppUI.m45809a(ReaderAppUI.this, false);
            C5279d g = ReaderAppUI.this.jOb;
            readerItemListView.position = i;
            readerItemListView.pFC = a;
            readerItemListView.jOb = g;
            readerItemListView.pFA = C39565g.cdZ().mo53335R(str, readerItemListView.type);
            readerItemListView.pFB.notifyDataSetChanged();
            if (ReaderAppUI.this.pFf != null) {
                c12947a.ngD.setTextColor(ReaderAppUI.this.pFf.vgW);
                if (ReaderAppUI.this.pFf.vgX) {
                    c12947a.ngD.setShadowLayer(2.0f, 1.2f, 1.2f, ReaderAppUI.this.pFf.vgY);
                } else {
                    c12947a.ngD.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                }
                if (ReaderAppUI.this.pFf.vgZ) {
                    c12947a.ngD.setBackgroundResource(C25738R.drawable.f6550hv);
                    c12947a.ngD.setPadding(this.jNi, this.pFo, this.jNi, this.pFo);
                } else {
                    c12947a.ngD.setBackgroundColor(0);
                }
            }
            AppMethodBeat.m2505o(76843);
            return view;
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
            AppMethodBeat.m2504i(76844);
            String string = cursor.getString(0);
            AppMethodBeat.m2505o(76844);
            return string;
        }
    }

    /* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderAppUI$8 */
    class C215698 implements OnMenuItemClickListener {
        C215698() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(76820);
            C46155a.gkE.mo38912c(new Intent().putExtra("Contact_User", ReaderAppUI.this.nNr), ReaderAppUI.this);
            AppMethodBeat.m2505o(76820);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderAppUI$a */
    class C21570a extends C43419a<String> {
        private Context context;
        private int enb;
        private int jNf;
        private int jNg = 0;
        private int jNh = 0;
        private int jNi = 0;
        private int jNj;
        private int kmW;
        private ImageGetter pFn = new C215711();
        private int pFo = 0;
        private int pFp = 0;

        /* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderAppUI$a$a */
        final class C3687a {
            TextView gsf;
            View jOR;
            View jOS;
            View jOT;
            View jOW;
            ImageView jOX;

            C3687a() {
            }
        }

        /* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderAppUI$a$b */
        final class C3688b {
            View gCY;
            TextView gsf;
            View jPQ;
            ImageView jPe;
            View jPn;
            List<C3687a> jPu;
            TextView ngD;
            TextView ooM;
            ImageView pFt;
            ViewGroup pFu;
            MMNeat7extView pFv;
            ImageView pFw;

            C3688b() {
            }
        }

        /* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderAppUI$a$1 */
        class C215711 implements ImageGetter {
            C215711() {
            }

            public final Drawable getDrawable(String str) {
                AppMethodBeat.m2504i(76822);
                Drawable drawable = ReaderAppUI.this.getResources().getDrawable(C5046bo.getInt(str, 0));
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                AppMethodBeat.m2505o(76822);
                return drawable;
            }
        }

        /* renamed from: a */
        private static void m33024a(C3688b c3688b, C3687a c3687a) {
            AppMethodBeat.m2504i(76824);
            if (c3688b == null) {
                AppMethodBeat.m2505o(76824);
                return;
            }
            c3688b.pFu.addView(c3687a.jOR);
            c3688b.jPu.add(c3687a);
            AppMethodBeat.m2505o(76824);
        }

        public C21570a(Context context, String str) {
            super(context, str);
            AppMethodBeat.m2504i(76825);
            this.context = context;
            this.kmW = 3;
            this.enb = C39565g.cdZ().mo53338kI(ReaderAppUI.this.cJB);
            this.jNi = context.getResources().getDimensionPixelSize(C25738R.dimen.f10011nc);
            this.jNg = context.getResources().getDimensionPixelSize(C25738R.dimen.f9948l5);
            this.pFo = context.getResources().getDimensionPixelSize(C25738R.dimen.f9723do);
            this.jNh = context.getResources().getDimensionPixelSize(C25738R.dimen.f9966lo);
            this.jNf = context.getResources().getDimensionPixelSize(C25738R.dimen.f10287wv);
            this.jNj = context.getResources().getDimensionPixelSize(C25738R.dimen.f10285wt);
            int gd = C1338a.m2868gd(context);
            int ge = C1338a.m2869ge(context);
            if (gd >= ge) {
                gd = ge;
            }
            this.pFp = (int) (((double) (gd - ((int) (ReaderAppUI.density * 32.0f)))) / 2.35d);
            AppMethodBeat.m2505o(76825);
        }

        /* renamed from: KD */
        public final void mo6870KD() {
            AppMethodBeat.m2504i(76826);
            mo6869KC();
            AppMethodBeat.m2505o(76826);
        }

        public final boolean bdn() {
            return this.kmW >= this.enb;
        }

        public final int getShowCount() {
            return this.kmW;
        }

        public final int bdo() {
            AppMethodBeat.m2504i(76827);
            if (bdn()) {
                AppMethodBeat.m2505o(76827);
                return 0;
            }
            this.kmW += 3;
            if (this.kmW <= this.enb) {
                AppMethodBeat.m2505o(76827);
                return 3;
            }
            this.kmW = this.enb;
            int i = this.enb % 3;
            AppMethodBeat.m2505o(76827);
            return i;
        }

        /* renamed from: KC */
        public final void mo6869KC() {
            AppMethodBeat.m2504i(76828);
            long currentTimeMillis = System.currentTimeMillis();
            this.enb = C39565g.cdZ().mo53338kI(20);
            setCursor(C39565g.cdZ().mo53336cp(this.kmW, 20));
            C4990ab.m7417i("MicroMsg.ReaderAppUI", "[resetCursor] cost:%sms showCount:%s totalCount:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(this.kmW), Integer.valueOf(this.enb));
            super.notifyDataSetChanged();
            AppMethodBeat.m2505o(76828);
        }

        private String getItem(int i) {
            AppMethodBeat.m2504i(76829);
            String str = (String) super.getItem(i);
            AppMethodBeat.m2505o(76829);
            return str;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C3688b c3688b;
            C3687a c3687a;
            AppMethodBeat.m2504i(76830);
            if (view == null) {
                C3688b c3688b2 = new C3688b();
                view = View.inflate(this.context, 2130970450, null);
                c3688b2.ngD = (TextView) view.findViewById(2131826831);
                c3688b2.pFu = (ViewGroup) view.findViewById(2131826832);
                c3688b2.gCY = view.findViewById(2131822458);
                c3688b2.jPQ = view.findViewById(2131822455);
                c3688b2.jPe = (ImageView) view.findViewById(2131821855);
                c3688b2.pFw = (ImageView) view.findViewById(2131822456);
                c3688b2.gsf = (TextView) view.findViewById(2131826834);
                c3688b2.pFt = (ImageView) view.findViewById(2131826833);
                c3688b2.ooM = (TextView) view.findViewById(2131826835);
                c3688b2.jPn = view.findViewById(2131821852);
                c3688b2.pFv = (MMNeat7extView) view.findViewById(2131822457);
                c3688b2.jPu = new ArrayList();
                view.setTag(c3688b2);
                c3688b = c3688b2;
            } else {
                c3688b = (C3688b) view.getTag();
            }
            for (C3687a c3687a2 : c3688b.jPu) {
                c3688b.pFu.removeView(c3687a2.jOR);
            }
            c3688b.jPu.clear();
            List Q = C39565g.cdZ().mo53334Q(getItem(i), 20);
            if (Q.size() > 0) {
                boolean z;
                int size = Q.size();
                C32779bl c32779bl = (C32779bl) Q.get(0);
                c3688b.ngD.setText(C14835h.m23089c(this.context, c32779bl.time, false));
                if (ReaderAppUI.this.pFf != null) {
                    c3688b.ngD.setTextColor(ReaderAppUI.this.pFf.vgW);
                    if (ReaderAppUI.this.pFf.vgX) {
                        c3688b.ngD.setShadowLayer(2.0f, 1.2f, 1.2f, ReaderAppUI.this.pFf.vgY);
                    } else {
                        c3688b.ngD.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                    }
                    if (ReaderAppUI.this.pFf.vgZ) {
                        c3688b.ngD.setBackgroundResource(C25738R.drawable.f6550hv);
                        c3688b.ngD.setPadding(this.jNi, this.pFo, this.jNi, this.pFo);
                    } else {
                        c3688b.ngD.setBackgroundColor(0);
                    }
                }
                c3688b.jPn.setOnClickListener(ReaderAppUI.this.mo46947a(c32779bl, ReaderAppUI.this.cJB, 0, c32779bl.getTitle()));
                if (size == 1) {
                    z = true;
                } else {
                    z = false;
                }
                c3688b.gsf.setText(c32779bl.getTitle());
                c3688b.ooM.setText(c32779bl.getDigest());
                Object obj = !C5046bo.isNullOrNil(c32779bl.aan()) ? 1 : null;
                if (c32779bl.aai()) {
                    c3688b.pFv.mo15921ah(Html.fromHtml(c32779bl.getTitle() + "<img src='2130841560'/>", this.pFn, null));
                } else {
                    c3688b.pFv.mo15921ah(c32779bl.getTitle());
                }
                TextView textView = c3688b.ooM;
                int i2 = (!z || C5046bo.isNullOrNil(c32779bl.getDigest())) ? 8 : 0;
                textView.setVisibility(i2);
                c3688b.pFw.setVisibility(8);
                if (z) {
                    c3688b.jPe.setBackgroundResource(C25738R.drawable.f6586iz);
                    c3688b.gCY.setVisibility(0);
                    c3688b.pFv.setVisibility(8);
                    c3688b.gsf.setVisibility(0);
                } else {
                    c3688b.jPe.setBackgroundResource(C25738R.drawable.f6587j0);
                    c3688b.gCY.setVisibility(obj != null ? 8 : 0);
                    c3688b.gsf.setVisibility(8);
                    c3688b.pFv.setVisibility(0);
                    c3688b.pFv.setTextColor(ReaderAppUI.this.mController.ylL.getResources().getColor(C25738R.color.f12119t1));
                    c3688b.pFv.setBackgroundResource(C25738R.drawable.f6900uv);
                    c3688b.pFv.getPaint().setFakeBoldText(true);
                }
                m33027ds(c3688b.jPe);
                m33027ds(c3688b.jPQ);
                if (obj != null) {
                    c3688b.jPQ.setVisibility(0);
                    String aan = c32779bl.aan();
                    ImageView imageView = c3688b.pFt;
                    int i3 = c32779bl.type;
                    int i4 = this.pFp;
                    C215722 c215722 = new C35837a() {
                        public final void onFinish() {
                            AppMethodBeat.m2504i(76823);
                            if (!z) {
                                c3688b.pFv.setTextColor(ReaderAppUI.this.mController.ylL.getResources().getColor(C25738R.color.a69));
                                c3688b.pFv.setBackgroundResource(C25738R.drawable.f6447eh);
                            }
                            c3688b.pFw.setVisibility(0);
                            AppMethodBeat.m2505o(76823);
                        }
                    };
                    if (C41764q.ahs()) {
                        aan = C41764q.m73703sy(aan);
                    }
                    int gd = C1338a.m2868gd(imageView.getContext()) - ((int) (ReaderAppUI.density * 32.0f));
                    C25815a ahp = C32291o.ahp();
                    C17927a c17927a = new C17927a();
                    c17927a.ePV = C25738R.drawable.f6444ed;
                    c17927a.ePH = true;
                    c17927a.ePX = "2130837909";
                    c17927a = c17927a.mo33448ct(gd, i4);
                    c17927a.fGV = new C35838f();
                    c17927a.ePJ = C30080q.m47642v(aan, i3, "@T");
                    ahp.mo43769a(aan, imageView, c17927a.ahG(), null, new C35836e(C25738R.drawable.axd, gd, i4, c215722));
                    c3688b.gCY.setBackgroundResource(C25738R.drawable.b18);
                    c3688b.gCY.setPadding(this.jNg, this.jNh, this.jNg, this.jNg);
                    c3688b.jPe.setVisibility(0);
                } else {
                    c3688b.jPQ.setVisibility(8);
                    c3688b.gsf.setVisibility(0);
                    c3688b.ooM.setVisibility(C5046bo.isNullOrNil(c32779bl.getDigest()) ? 8 : 0);
                    if (z) {
                        c3688b.gCY.setBackgroundResource(C25738R.drawable.f6578iq);
                    } else {
                        c3688b.gCY.setBackgroundResource(C25738R.drawable.f6577ip);
                    }
                    c3688b.gCY.setPadding(this.jNg, this.jNg, this.jNg, this.jNg);
                    c3688b.jPe.setVisibility(8);
                }
                if (size > 1) {
                    for (int i5 = 1; i5 < size - 1; i5++) {
                        m33025a(c3688b, Q, 2130970457, i5, c32779bl.getTitle());
                    }
                    m33025a(c3688b, Q, 2130970456, size - 1, c32779bl.getTitle());
                }
            }
            c3688b.jPn.setTag(Integer.valueOf(i));
            c3688b.jPn.setTag(2131820654, Integer.valueOf(0));
            ReaderAppUI.this.jMO.mo39887c(c3688b.jPn, ReaderAppUI.m45809a(ReaderAppUI.this, Q.size() == 1), ReaderAppUI.this.jOb);
            int i6 = 1;
            Iterator it = c3688b.jPu.iterator();
            while (true) {
                int i7 = i6;
                if (it.hasNext()) {
                    c3687a2 = (C3687a) it.next();
                    c3687a2.jOR.setTag(Integer.valueOf(i));
                    ReaderAppUI.this.jMO.mo39887c(c3687a2.jOR, ReaderAppUI.m45809a(ReaderAppUI.this, Q.size() == 1), ReaderAppUI.this.jOb);
                    View view2 = c3687a2.jOR;
                    i6 = i7 + 1;
                    view2.setTag(2131820654, Integer.valueOf(i7));
                } else {
                    AppMethodBeat.m2505o(76830);
                    return view;
                }
            }
        }

        /* renamed from: a */
        private void m33025a(C3688b c3688b, List<C32779bl> list, int i, int i2, String str) {
            AppMethodBeat.m2504i(76831);
            C3687a c3687a = new C3687a();
            c3687a.jOR = View.inflate(this.context, i, null);
            c3687a.gsf = (TextView) c3687a.jOR.findViewById(2131820678);
            c3687a.jOX = (ImageView) c3687a.jOR.findViewById(2131821404);
            c3687a.jOW = c3687a.jOR.findViewById(2131821403);
            c3687a.jOS = c3687a.jOR.findViewById(2131821838);
            c3687a.jOT = c3687a.jOR.findViewById(2131821839);
            C21570a.m33024a(c3688b, c3687a);
            C32779bl c32779bl = (C32779bl) list.get(i2);
            m33023a(c3687a, i2, list);
            c3687a.gsf.setText(c32779bl.getTitle());
            if (c32779bl.aai()) {
                c3687a.gsf.setText(Html.fromHtml(c32779bl.getTitle() + "<img src='2130841553'/>", this.pFn, null));
            } else {
                c3687a.gsf.setText(c32779bl.getTitle());
            }
            if (C5046bo.isNullOrNil(c32779bl.aan())) {
                c3687a.jOW.setVisibility(8);
            } else {
                c3687a.jOX.setVisibility(0);
                C21570a.m33026a(c32779bl.aan(), c3687a.jOX, c32779bl.type, this.jNf, this.jNf, "@S");
            }
            c3687a.jOR.setOnClickListener(ReaderAppUI.this.mo46947a(c32779bl, ReaderAppUI.this.cJB, i2, str));
            AppMethodBeat.m2505o(76831);
        }

        /* renamed from: ds */
        private void m33027ds(View view) {
            AppMethodBeat.m2504i(76832);
            LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.pFp;
            view.setLayoutParams(layoutParams);
            AppMethodBeat.m2505o(76832);
        }

        /* renamed from: O */
        private static void m33022O(View view, int i) {
            AppMethodBeat.m2504i(76833);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams.rightMargin = i;
            view.setLayoutParams(layoutParams);
            AppMethodBeat.m2505o(76833);
        }

        /* renamed from: a */
        private void m33023a(C3687a c3687a, int i, List<C32779bl> list) {
            AppMethodBeat.m2504i(76834);
            int size = list.size();
            if (i != 1) {
                c3687a.jOS.setVisibility(0);
                C32779bl c32779bl = (C32779bl) list.get(i);
                if (C5046bo.isNullOrNil(((C32779bl) list.get(i - 1)).aan()) || C5046bo.isNullOrNil(c32779bl.aan())) {
                    C21570a.m33022O(c3687a.jOS, this.jNg);
                } else {
                    C21570a.m33022O(c3687a.jOS, this.jNj);
                }
            } else if (C5046bo.isNullOrNil(((C32779bl) list.get(0)).aan())) {
                c3687a.jOS.setVisibility(0);
                C21570a.m33022O(c3687a.jOS, this.jNg);
            } else {
                c3687a.jOS.setVisibility(8);
            }
            if (i == 1) {
                if (i == size - 1) {
                    c3687a.jOT.setPadding(0, this.jNg, 0, this.jNg);
                    AppMethodBeat.m2505o(76834);
                    return;
                }
                c3687a.jOT.setPadding(0, this.jNg, 0, this.jNi);
                AppMethodBeat.m2505o(76834);
            } else if (i == size - 1) {
                c3687a.jOT.setPadding(0, this.jNi, 0, this.jNg);
                AppMethodBeat.m2505o(76834);
            } else {
                c3687a.jOT.setPadding(0, this.jNi, 0, this.jNi);
                AppMethodBeat.m2505o(76834);
            }
        }

        /* renamed from: a */
        private static void m33026a(String str, ImageView imageView, int i, int i2, int i3, String str2) {
            String sy;
            AppMethodBeat.m2504i(76835);
            if (C41764q.ahs()) {
                sy = C41764q.m73703sy(str);
            } else {
                sy = str;
            }
            C25815a ahp = C32291o.ahp();
            C17927a c17927a = new C17927a();
            c17927a.ePV = C25738R.color.f11875k8;
            c17927a.ePH = true;
            c17927a = c17927a.mo33448ct(i2, i3);
            c17927a.fGV = new C35838f();
            c17927a.ePJ = C30080q.m47642v(sy, i, str2);
            ahp.mo43769a(sy, imageView, c17927a.ahG(), null, new C35836e(0, 0, 0, null));
            AppMethodBeat.m2505o(76835);
        }
    }

    /* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderAppUI$7 */
    class C287997 implements OnMenuItemClickListener {
        C287997() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(76819);
            ReaderAppUI.this.finish();
            AppMethodBeat.m2505o(76819);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderAppUI$b */
    static class C28800b {
        HashMap<String, Set<String>> pFx = new HashMap();

        public C28800b() {
            AppMethodBeat.m2504i(76838);
            AppMethodBeat.m2505o(76838);
        }
    }

    /* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderAppUI$2 */
    class C288012 implements C5279d {
        C288012() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(76814);
            int groupId = menuItem.getGroupId();
            C32779bl c32779bl;
            String str;
            switch (menuItem.getItemId()) {
                case 0:
                    if (ReaderAppUI.this.cJB == 20) {
                        List Q = C39565g.cdZ().mo53334Q((String) ReaderAppUI.this.pFe.getItem(groupId), ReaderAppUI.this.cJB);
                        if (Q.size() > 0) {
                            c32779bl = (C32779bl) Q.get(0);
                            C8910b c8910b = new C8910b();
                            c8910b.title = c32779bl.getTitle();
                            c8910b.description = c32779bl.getDigest();
                            c8910b.action = "view";
                            c8910b.type = 5;
                            c8910b.url = c32779bl.getUrl();
                            String a = C8910b.m16061a(c8910b, null, null);
                            Intent intent = new Intent();
                            intent.putExtra("Retr_Msg_content", a);
                            intent.putExtra("Retr_Msg_Type", 2);
                            intent.putExtra("Retr_Msg_thumb_path", C30080q.m47642v(c32779bl.aan(), c32779bl.type, "@T"));
                            intent.putExtra("Retr_Msg_Id", 7377812);
                            a = C37922v.m64078nW(c32779bl.fnf);
                            intent.putExtra("reportSessionId", a);
                            C32800b y = C37922v.m64076Zp().mo60676y(a, true);
                            y.mo53356j("prePublishId", "msg_" + c32779bl.fnf);
                            y.mo53356j("preUsername", "newsapp");
                            y.mo53356j("preChatName", "newsapp");
                            y.mo53356j("preMsgIndex", Integer.valueOf(0));
                            y.mo53356j("sendAppMsgScene", Integer.valueOf(1));
                            C46155a.gkE.mo38926k(intent, ReaderAppUI.this);
                        }
                        AppMethodBeat.m2505o(76814);
                        return;
                    }
                    break;
                case 1:
                    if (ReaderAppUI.this.cJB == 20) {
                        List Q2 = C39565g.cdZ().mo53334Q((String) ReaderAppUI.this.pFe.getItem(groupId), ReaderAppUI.this.cJB);
                        if (!Q2.isEmpty()) {
                            C4990ab.m7417i("MicroMsg.ReaderAppUI", "fav functionId %s, index %d, size %d", str, Integer.valueOf(ReaderAppUI.this.pFg), Integer.valueOf(Q2.size()));
                            if (ReaderAppUI.this.pFg >= Q2.size()) {
                                ReaderAppUI.this.pFg = 0;
                            }
                            c32779bl = (C32779bl) Q2.get(ReaderAppUI.this.pFg);
                            C45316cl c45316cl = new C45316cl();
                            String nW = C37922v.m64078nW(c32779bl.fnf);
                            C32800b y2 = C37922v.m64076Zp().mo60676y(nW, true);
                            y2.mo53356j("prePublishId", "msg_" + c32779bl.fnf);
                            y2.mo53356j("preUsername", "newsapp");
                            y2.mo53356j("preChatName", "newsapp");
                            y2.mo53356j("preMsgIndex", Integer.valueOf(0));
                            y2.mo53356j("sendAppMsgScene", Integer.valueOf(1));
                            c45316cl.cvA.cvF = nW;
                            C21568b.m33021a(c45316cl, c32779bl, ReaderAppUI.this.pFg);
                            c45316cl.cvA.cvH = 7;
                            c45316cl.cvA.activity = ReaderAppUI.this;
                            C4879a.xxA.mo10055m(c45316cl);
                            break;
                        }
                    }
                    break;
                case 2:
                    str = (String) ReaderAppUI.this.pFe.getItem(groupId);
                    if (!C5046bo.isNullOrNil(str)) {
                        C39565g.m67625cU(str, ReaderAppUI.this.cJB);
                        C32780bm cdZ = C39565g.cdZ();
                        int a2 = ReaderAppUI.this.cJB;
                        C4990ab.m7411d("MicroMsg.ReaderAppInfoStorage", "deleteGroup:%s", "delete from " + C32780bm.m53549kH(a2) + " where reserved3 = " + C7480h.escape(str));
                        if (cdZ.fni.mo10108hY(C32780bm.m53549kH(a2), "delete from " + C32780bm.m53549kH(a2) + " where reserved3 = " + C7480h.escape(str))) {
                            cdZ.mo53340kK(a2);
                            cdZ.doNotify();
                        }
                    }
                    ReaderAppUI.this.refresh();
                    AppMethodBeat.m2505o(76814);
                    return;
            }
            AppMethodBeat.m2505o(76814);
        }
    }

    /* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderAppUI$4 */
    class C288024 implements C5258c {
        C288024() {
        }

        public final boolean bhm() {
            AppMethodBeat.m2504i(76816);
            View childAt = ReaderAppUI.this.ooS.getChildAt(ReaderAppUI.this.ooS.getChildCount() - 1);
            if (childAt == null) {
                AppMethodBeat.m2505o(76816);
                return false;
            } else if (childAt.getBottom() > ReaderAppUI.this.ooS.getHeight() || ReaderAppUI.this.ooS.getLastVisiblePosition() != ReaderAppUI.this.ooS.getAdapter().getCount() - 1) {
                AppMethodBeat.m2505o(76816);
                return false;
            } else {
                AppMethodBeat.m2505o(76816);
                return true;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderAppUI$3 */
    class C288043 implements C5262g {
        C288043() {
        }

        public final boolean bhn() {
            AppMethodBeat.m2504i(76815);
            if (ReaderAppUI.this.pFe.bdn()) {
                ReaderAppUI.this.ooS.setSelectionFromTop(0, ReaderAppUI.this.ooW.getTopHeight());
                AppMethodBeat.m2505o(76815);
            } else {
                int count = ReaderAppUI.this.pFe.getCount();
                int bdo = ReaderAppUI.this.pFe.bdo();
                C4990ab.m7418v("MicroMsg.ReaderAppUI", "onLoadData add count:".concat(String.valueOf(bdo)));
                ReaderAppUI.this.pFe.mo5248a(null, null);
                C4990ab.m7411d("MicroMsg.ReaderAppUI", "onTopLoadData nowCount:%d, preCount:%d", Integer.valueOf(ReaderAppUI.this.pFe.getCount()), Integer.valueOf(count));
                if (ReaderAppUI.this.pFe.getCount() > count) {
                    C4990ab.m7417i("MicroMsg.ReaderAppUI", "pullDownView nowCount > preCount on set position %d, set pullDownView.getTopHeight() %d", Integer.valueOf(bdo + 1), Integer.valueOf(ReaderAppUI.this.ooW.getTopHeight()));
                    C35897k.m58842a(ReaderAppUI.this.ooS, bdo + 1, ReaderAppUI.this.ooW.getTopHeight(), false);
                }
                AppMethodBeat.m2505o(76815);
            }
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ReaderAppUI() {
        AppMethodBeat.m2504i(76845);
        AppMethodBeat.m2505o(76845);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(76846);
        super.onCreate(bundle);
        this.cJB = getIntent().getIntExtra("type", 0);
        C4990ab.m7417i("MicroMsg.ReaderAppUI", "[onCreate] readerType:%s", Integer.valueOf(this.cJB));
        this.cJB = 20;
        density = C1338a.getDensity(this);
        this.pFh = new C28800b();
        long currentTimeMillis = System.currentTimeMillis();
        initView();
        C4990ab.m7417i("MicroMsg.ReaderAppUI", "[initView] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        this.nNr = C32779bl.m53547kG(this.cJB);
        if (20 == this.cJB && C32798u.m53582ac("newsapp", null) > 0) {
            C7060h.pYm.mo8381e(13440, Integer.valueOf(2));
        }
        AppMethodBeat.m2505o(76846);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(76847);
        if (this.pFe != null) {
            this.pFe.bIf();
            this.pFe.dww();
        }
        if (this.pFh != null) {
            C28800b c28800b = this.pFh;
            if (!c28800b.pFx.isEmpty()) {
                for (Entry entry : c28800b.pFx.entrySet()) {
                    String str = (String) entry.getKey();
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String str2 : (Set) entry.getValue()) {
                        if (stringBuilder.length() <= 0) {
                            stringBuilder.append(str2);
                        } else {
                            stringBuilder.append("||").append(str2);
                        }
                    }
                    C7060h.pYm.mo8381e(15413, Integer.valueOf(9), str, stringBuilder.toString());
                }
                c28800b.pFx.clear();
            }
        }
        super.onDestroy();
        AppMethodBeat.m2505o(76847);
    }

    public final int getLayoutId() {
        return 2130970444;
    }

    public void onResume() {
        AppMethodBeat.m2504i(76848);
        super.onResume();
        if (this.cJB == 20) {
            setMMTitle((int) C25738R.string.cb1);
        } else {
            setMMTitle((int) C25738R.string.cb4);
        }
        ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().mo41582jO(this.nNr);
        ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().cancelNotification(this.nNr);
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apb(this.nNr);
        C39565g.cdZ().mo10116c(this.pFe);
        this.pFe.mo5248a(null, null);
        refresh();
        AppMethodBeat.m2505o(76848);
    }

    public void onPause() {
        AppMethodBeat.m2504i(76849);
        super.onPause();
        ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().mo41582jO("");
        C39565g.cdZ().mo10117d(this.pFe);
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apb(this.nNr);
        AppMethodBeat.m2505o(76849);
    }

    public final void refresh() {
        AppMethodBeat.m2504i(76850);
        TextView textView = (TextView) findViewById(2131821807);
        textView.setText(this.cJB == 20 ? C25738R.string.dhx : C25738R.string.di3);
        if (this.pFe.getCount() == 0) {
            textView.setVisibility(0);
            AppMethodBeat.m2505o(76850);
            return;
        }
        textView.setVisibility(8);
        AppMethodBeat.m2505o(76850);
    }

    /* renamed from: aP */
    private void m45811aP(Context context, String str) {
        AppMethodBeat.m2504i(76851);
        try {
            this.pFf = new C14945e(C5046bo.convertStreamToString(context.getAssets().open(str)));
            AppMethodBeat.m2505o(76851);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ReaderAppUI", e, "", new Object[0]);
            AppMethodBeat.m2505o(76851);
        }
    }

    public final void initView() {
        AppMethodBeat.m2504i(76852);
        m45811aP(this, "chatting/purecolor_chat.xml");
        this.ooS = (ListView) findViewById(2131826816);
        this.ooW = (MMPullDownView) findViewById(2131826815);
        this.gwR = getLayoutInflater().inflate(2130970448, null);
        this.ooS.addHeaderView(this.gwR);
        ((TextView) findViewById(2131821807)).setText(C25738R.string.dhp);
        if (this.cJB == 20) {
            this.pFe = new C21570a(this, "");
        } else if (this.cJB == 11) {
            this.pFe = new C12946c(this, "");
        }
        this.ooS.setOnScrollListener(this.pFe);
        this.ooS.setAdapter(this.pFe);
        this.ooS.setTranscriptMode(0);
        registerForContextMenu(this.ooS);
        this.jMO = new C24088a(this);
        if (this.pFe.getCount() == 0) {
            Intent intent = new Intent(this, ReaderAppIntroUI.class);
            intent.putExtra("type", this.cJB);
            startActivity(intent);
            finish();
            AppMethodBeat.m2505o(76852);
            return;
        }
        this.ooW.setOnTopLoadDataListener(new C288043());
        this.ooW.setTopViewVisible(true);
        this.ooW.setAtBottomCallBack(new C288024());
        this.ooW.setAtTopCallBack(new C36855());
        this.ooW.setIsBottomShowAll(true);
        this.pFe.mo74992a((C30723a) new C36866());
        setBackBtn(new C287997());
        addIconOptionMenu(0, C25738R.string.f8697cd, C1318a.actionbar_setting_icon, new C215698());
        this.ooS.setSelection((this.pFe.getShowCount() - 1) + this.ooS.getHeaderViewsCount());
        AppMethodBeat.m2505o(76852);
    }

    /* renamed from: a */
    public final OnClickListener mo46947a(C32779bl c32779bl, int i, int i2, String str) {
        AppMethodBeat.m2504i(76853);
        C28800b c28800b = this.pFh;
        String title = c32779bl.getTitle();
        if (!C5046bo.isNullOrNil(str)) {
            Set set;
            if (c28800b.pFx.containsKey(str)) {
                set = (Set) c28800b.pFx.get(str);
            } else {
                set = new HashSet();
                c28800b.pFx.put(str, set);
            }
            if (!C5046bo.isNullOrNil(title)) {
                set.add(title);
            }
        }
        final int i3 = i;
        final String str2 = str;
        final C32779bl c32779bl2 = c32779bl;
        final int i4 = i2;
        C288059 c288059 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(76821);
                if (20 == i3) {
                    C7060h.pYm.mo8381e(15413, Integer.valueOf(8), str2, c32779bl2.getTitle());
                    Intent intent = new Intent();
                    intent.putExtra("mode", 1);
                    String url = c32779bl2.getUrl();
                    intent.putExtra("news_svr_id", c32779bl2.fnf);
                    intent.putExtra("news_svr_tweetid", c32779bl2.aaj());
                    intent.putExtra("rawUrl", ReaderAppUI.m45810a(ReaderAppUI.this, url));
                    intent.putExtra("title", c32779bl2.getName());
                    intent.putExtra("webpageTitle", c32779bl2.getTitle());
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    Bundle bundle = new Bundle();
                    bundle.putInt("snsWebSource", 3);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("shortUrl", c32779bl2.aak());
                    intent.putExtra("type", c32779bl2.type);
                    intent.putExtra("tweetid", c32779bl2.aaj());
                    intent.putExtra("geta8key_username", "newsapp");
                    intent.putExtra("KPublisherId", "msg_" + Long.toString(c32779bl2.fnf));
                    intent.putExtra("pre_username", "newsapp");
                    intent.putExtra("prePublishId", "msg_" + Long.toString(c32779bl2.fnf));
                    intent.putExtra("preUsername", "newsapp");
                    intent.putExtra("preChatName", "newsapp");
                    intent.putExtra("preMsgIndex", i4);
                    intent.putExtra("geta8key_scene", 16);
                    intent.addFlags(536870912);
                    C46155a.gkE.mo38924i(intent, ReaderAppUI.this);
                }
                AppMethodBeat.m2505o(76821);
            }
        };
        AppMethodBeat.m2505o(76853);
        return c288059;
    }

    /* renamed from: VA */
    private PackageInfo m45806VA(String str) {
        PackageInfo packageInfo = null;
        AppMethodBeat.m2504i(76854);
        if (str.length() == 0) {
            AppMethodBeat.m2505o(76854);
        } else {
            try {
                packageInfo = this.mController.ylL.getPackageManager().getPackageInfo(str, 0);
                AppMethodBeat.m2505o(76854);
            } catch (NameNotFoundException e) {
                C4990ab.printErrStackTrace("MicroMsg.ReaderAppUI", e, "", new Object[0]);
                AppMethodBeat.m2505o(76854);
            }
        }
        return packageInfo;
    }
}
