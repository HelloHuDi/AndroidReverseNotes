package com.tencent.p177mm.p612ui.voicesearch;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C8935m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C30777u.C30784a;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.applet.C36043b;
import com.tencent.p177mm.p612ui.applet.C36043b.C23577b;
import com.tencent.p177mm.p612ui.applet.C36043b.C5234a;
import com.tencent.p177mm.p612ui.base.MaskLayout;
import com.tencent.p177mm.p612ui.base.MaskLayout.C23622a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.p993a.C12518f;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.but;
import com.tencent.p177mm.protocal.protobuf.buv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"DefaultLocale"})
/* renamed from: com.tencent.mm.ui.voicesearch.b */
public final class C46939b extends C46692p<C7616ad> implements C1202f {
    private Context context;
    private ProgressDialog ehJ = null;
    private List<String> elZ = null;
    private LinkedList<but> fjr = new LinkedList();
    public C36043b gvm = new C36043b(new C466981());
    private C23577b gvn = null;
    public String sfv;
    private int showType = 1;
    public String[] yDL;
    private boolean zLv = false;
    private C7616ad zLw = null;
    private boolean zLx = true;
    public boolean zLy = false;
    private boolean zLz = false;
    public String zjx;

    /* renamed from: com.tencent.mm.ui.voicesearch.b$10 */
    public class C561810 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(35337);
            C46939b.this.zLx = true;
            C46939b.this.fjr.clear();
            AppMethodBeat.m2505o(35337);
        }
    }

    /* renamed from: com.tencent.mm.ui.voicesearch.b$a */
    protected static class C30789a {
        public MaskLayout emP;
        public TextView emg;
        public CheckBox gnD;
        public TextView nBN;
        public ProgressBar zLD;
        public TextView zpr;
    }

    /* renamed from: com.tencent.mm.ui.voicesearch.b$11 */
    class C3635111 implements Runnable {
        C3635111() {
        }

        public final void run() {
            AppMethodBeat.m2504i(35338);
            C46939b.this.zLx = false;
            AppMethodBeat.m2505o(35338);
        }
    }

    /* renamed from: com.tencent.mm.ui.voicesearch.b$2 */
    class C408992 implements Runnable {
        C408992() {
        }

        public final void run() {
            AppMethodBeat.m2504i(35328);
            C46939b.this.zLx = false;
            AppMethodBeat.m2505o(35328);
        }
    }

    /* renamed from: com.tencent.mm.ui.voicesearch.b$1 */
    class C466981 implements C5234a {
        C466981() {
        }

        /* renamed from: wd */
        public final Bitmap mo10738wd(String str) {
            AppMethodBeat.m2504i(35327);
            Bitmap a = C41730b.m73490a(str, false, -1);
            AppMethodBeat.m2505o(35327);
            return a;
        }
    }

    /* renamed from: com.tencent.mm.ui.voicesearch.b$8 */
    class C466998 implements C23577b {
        C466998() {
        }

        /* renamed from: mW */
        public final String mo11090mW(int i) {
            AppMethodBeat.m2504i(35334);
            if (i < 0) {
                C4990ab.m7412e("MicroMsg.SearchResultAdapter", "pos is invalid");
                AppMethodBeat.m2505o(35334);
                return null;
            }
            C46939b c46939b = C46939b.this;
            but PO = c46939b.mo76187PO((C46939b.m89699e(c46939b) + i) + 1);
            if (PO == null) {
                AppMethodBeat.m2505o(35334);
                return null;
            }
            String str = PO.wcB.wVI;
            AppMethodBeat.m2505o(35334);
            return str;
        }

        public final int apO() {
            AppMethodBeat.m2504i(35335);
            if (C46939b.this.fjr == null) {
                AppMethodBeat.m2505o(35335);
                return 0;
            }
            int size = C46939b.this.fjr.size();
            AppMethodBeat.m2505o(35335);
            return size;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(35361);
        C7616ad PP = mo76188PP(i);
        AppMethodBeat.m2505o(35361);
        return PP;
    }

    /* renamed from: c */
    static /* synthetic */ void m89695c(C46939b c46939b, Cursor cursor) {
        AppMethodBeat.m2504i(35366);
        c46939b.setCursor(cursor);
        AppMethodBeat.m2505o(35366);
    }

    /* renamed from: d */
    static /* synthetic */ void m89697d(C46939b c46939b, Cursor cursor) {
        AppMethodBeat.m2504i(35367);
        c46939b.setCursor(cursor);
        AppMethodBeat.m2505o(35367);
    }

    /* renamed from: e */
    static /* synthetic */ int m89699e(C46939b c46939b) {
        AppMethodBeat.m2504i(35363);
        int realCount = c46939b.getRealCount();
        AppMethodBeat.m2505o(35363);
        return realCount;
    }

    /* renamed from: e */
    static /* synthetic */ void m89700e(C46939b c46939b, Cursor cursor) {
        AppMethodBeat.m2504i(35368);
        c46939b.setCursor(cursor);
        AppMethodBeat.m2505o(35368);
    }

    public C46939b(Context context, int i) {
        super(context, new C7616ad());
        AppMethodBeat.m2504i(35339);
        this.context = context;
        this.showType = i;
        this.zLw = new C7616ad();
        this.zLw.setUsername("_find_more_public_contact_");
        this.zLw.mo16685NK();
        this.zjx = "@micromsg.with.all.biz.qq.com";
        AppMethodBeat.m2505o(35339);
    }

    /* renamed from: fl */
    public final void mo76194fl(final List<String> list) {
        AppMethodBeat.m2504i(35340);
        mo76192ay(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(35331);
                if (C46939b.this.elZ == null) {
                    C46939b.this.elZ = new ArrayList();
                }
                C46939b.this.elZ.clear();
                C46939b.this.elZ.addAll(list);
                C46939b.this.elZ.add("officialaccounts");
                C46939b.this.elZ.add("helper_entry");
                AppMethodBeat.m2505o(35331);
            }
        });
        AppMethodBeat.m2505o(35340);
    }

    /* renamed from: qU */
    public final void mo76202qU(boolean z) {
        AppMethodBeat.m2504i(35341);
        this.zLy = z;
        if (z) {
            this.zLw.mo16685NK();
        }
        AppMethodBeat.m2505o(35341);
    }

    public final void detach() {
        AppMethodBeat.m2504i(35342);
        if (this.gvm != null) {
            this.gvm.detach();
            this.gvm = null;
        }
        AppMethodBeat.m2505o(35342);
    }

    public final int getViewTypeCount() {
        return 3;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(35343);
        if (this.showType == 2) {
            AppMethodBeat.m2505o(35343);
            return 2;
        } else if (mo76189PQ(i)) {
            AppMethodBeat.m2505o(35343);
            return 1;
        } else {
            AppMethodBeat.m2505o(35343);
            return 0;
        }
    }

    public final int bFs() {
        int i = 0;
        AppMethodBeat.m2504i(35344);
        if (this.zLv) {
            if (!this.zLw.isHidden()) {
                i = this.fjr.size();
            }
            i++;
            AppMethodBeat.m2505o(35344);
            return i;
        }
        AppMethodBeat.m2505o(35344);
        return 0;
    }

    /* renamed from: PO */
    public final but mo76187PO(int i) {
        AppMethodBeat.m2504i(35345);
        try {
            C4990ab.m7410d("MicroMsg.SearchResultAdapter", "position " + i + " size " + this.fjr.size() + "  " + (i - getRealCount()));
            but but = (but) this.fjr.get((i - getRealCount()) - 1);
            AppMethodBeat.m2505o(35345);
            return but;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SearchResultAdapter", e, "", new Object[0]);
            AppMethodBeat.m2505o(35345);
            return null;
        }
    }

    /* renamed from: PP */
    public final C7616ad mo76188PP(int i) {
        AppMethodBeat.m2504i(35346);
        C7616ad c7616ad;
        if (mo10892wK(i)) {
            c7616ad = (C7616ad) bFt();
            AppMethodBeat.m2505o(35346);
            return c7616ad;
        }
        c7616ad = (C7616ad) super.getItem(i);
        AppMethodBeat.m2505o(35346);
        return c7616ad;
    }

    /* renamed from: qV */
    public final void mo76203qV(final boolean z) {
        AppMethodBeat.m2504i(35347);
        mo76192ay(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(35332);
                C46939b.this.zLv = z;
                AppMethodBeat.m2505o(35332);
            }
        });
        AppMethodBeat.m2505o(35347);
    }

    public final void asx(final String str) {
        AppMethodBeat.m2504i(35348);
        mo76192ay(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(35333);
                if (C46939b.this.zLw.isHidden()) {
                    C46939b.this.zLw.mo16686NL();
                    if (C46939b.this.zLx) {
                        C9638aw.m17182Rg().mo14541a(new C12518f(str, 3), 0);
                        C46939b.this.zLz = true;
                        AppMethodBeat.m2505o(35333);
                        return;
                    }
                }
                C46939b.this.zLw.mo16685NK();
                AppMethodBeat.m2505o(35333);
            }
        });
        AppMethodBeat.m2505o(35348);
    }

    /* renamed from: PQ */
    public final boolean mo76189PQ(int i) {
        AppMethodBeat.m2504i(35349);
        if (this.zLv) {
            int realCount = getRealCount();
            if (i == realCount && i < realCount + bFs()) {
                AppMethodBeat.m2505o(35349);
                return true;
            }
        }
        AppMethodBeat.m2505o(35349);
        return false;
    }

    public final boolean isEnabled(int i) {
        AppMethodBeat.m2504i(35350);
        if (!mo76189PQ(i) || (!(this.fjr == null || this.fjr.size() == 0) || this.zLx)) {
            AppMethodBeat.m2505o(35350);
            return true;
        }
        AppMethodBeat.m2505o(35350);
        return false;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(35351);
        boolean wK = mo10892wK(i);
        boolean PQ = mo76189PQ(i);
        C30789a c30789a;
        C30789a c30789a2;
        String kz;
        if (this.zLv && wK) {
            if (view != null) {
                c30789a = (C30789a) view.getTag();
                if (PQ && c30789a.zLD == null) {
                    view = null;
                }
            }
            if (view != null) {
                c30789a2 = (C30789a) view.getTag();
            } else if (PQ) {
                view = View.inflate(this.context, 2130969196, null);
                c30789a2 = new C30789a();
                c30789a2.emg = (TextView) view.findViewById(2131821079);
                c30789a2.zLD = (ProgressBar) view.findViewById(2131822966);
                view.setTag(c30789a2);
            } else {
                view = View.inflate(this.context, 2130969223, null);
                c30789a2 = new C30789a();
                c30789a2.nBN = (TextView) view.findViewById(2131821069);
                c30789a2.emP = (MaskLayout) view.findViewById(2131821072);
                c30789a2.emg = (TextView) view.findViewById(2131821079);
                c30789a2.gnD = (CheckBox) view.findViewById(2131821076);
                c30789a2.zpr = (TextView) view.findViewById(2131821080);
                view.setTag(c30789a2);
            }
            if (PQ) {
                if (this.zLz) {
                    c30789a2.zLD.setVisibility(0);
                } else {
                    c30789a2.zLD.setVisibility(8);
                }
                C4990ab.m7410d("MicroMsg.SearchResultAdapter", "refresh  " + this.zLx);
                if ((this.fjr == null || this.fjr.size() == 0) && !this.zLx) {
                    c30789a2.emg.setText(this.context.getString(C25738R.string.f8762e_));
                    c30789a2.emg.setTextColor(this.context.getResources().getColor(C25738R.color.f12121t4));
                } else {
                    c30789a2.emg.setText(this.context.getString(C25738R.string.f8763ea));
                    c30789a2.emg.setTextColor(C1338a.m2870h(this.context, (int) C25738R.color.a7t));
                }
            } else {
                if (this.gvn == null) {
                    this.gvn = new C466998();
                }
                if (this.gvm != null) {
                    this.gvm.mo56803a((i - getRealCount()) - 1, this.gvn);
                }
                but PO = mo76187PO(i);
                c30789a2.nBN.setVisibility(8);
                if (PO == null) {
                    AppMethodBeat.m2505o(35351);
                    return view;
                }
                c30789a2.zpr.setVisibility(8);
                C40460b.m69434b((ImageView) c30789a2.emP.getContentView(), PO.wcB.wVI);
                if (PO.wBT == 0) {
                    c30789a2.emP.setMaskDrawable(null);
                } else if (C26417a.flw != null) {
                    kz = C26417a.flw.mo37873kz(PO.wBT);
                    if (kz != null) {
                        c30789a2.emP.mo48741a(C8935m.m16106rk(kz), C23622a.SUBSCRIPT_DRAWABLE_DIRECTION_BOTTOM_RIGHT);
                    } else {
                        c30789a2.emP.setMaskDrawable(null);
                    }
                } else {
                    c30789a2.emP.setMaskDrawable(null);
                }
                try {
                    c30789a2.emg.setText(C44089j.m79293b(this.context, C5046bo.nullAsNil(PO.wyX.wVI), c30789a2.emg.getTextSize()));
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.SearchResultAdapter", e, "", new Object[0]);
                    c30789a2.emg.setText("");
                }
            }
            AppMethodBeat.m2505o(35351);
            return view;
        } else if (this.showType == 2) {
            if (view == null) {
                view = View.inflate(this.context, 2130971009, null);
                c30789a2 = new C30789a();
                c30789a2.emg = (TextView) view.findViewById(2131821079);
                view.setTag(c30789a2);
                c30789a = c30789a2;
            } else {
                c30789a = (C30789a) view.getTag();
            }
            C7616ad PP = mo76188PP(i);
            c30789a.emg.setTextColor(C1338a.m2870h(this.context, (int) C25738R.color.a7t));
            try {
                c30789a.emg.setText(C44089j.m79293b(this.context, this.context.getString(C25738R.string.f36, new Object[]{C1854s.m3860a(PP, PP.field_username)}), c30789a.emg.getTextSize()));
            } catch (Exception e2) {
                c30789a.emg.setText("");
            }
            c30789a.emg.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            AppMethodBeat.m2505o(35351);
            return view;
        } else {
            View view2;
            if (view != null) {
                c30789a = (C30789a) view.getTag();
                view2 = c30789a == null ? null : view;
            } else {
                c30789a = null;
                view2 = view;
            }
            if (view2 == null) {
                view2 = C5616v.m8409hu(this.context).inflate(2130969223, null);
                c30789a2 = new C30789a();
                c30789a2.nBN = (TextView) view2.findViewById(2131821069);
                c30789a2.emP = (MaskLayout) view2.findViewById(2131821072);
                c30789a2.emg = (TextView) view2.findViewById(2131821079);
                c30789a2.gnD = (CheckBox) view2.findViewById(2131821076);
                c30789a2.zpr = (TextView) view2.findViewById(2131821080);
                view2.setTag(c30789a2);
            } else {
                c30789a2 = c30789a;
            }
            C7616ad PP2 = mo76188PP(i);
            if (c30789a2.nBN != null) {
                c30789a2.nBN.setVisibility(8);
            }
            c30789a2.emg.setTextColor(C1338a.m2870h(this.context, !C1855t.m3923nI(PP2.field_username) ? C25738R.color.a7t : C25738R.color.a7u));
            C40460b.m69434b((ImageView) c30789a2.emP.getContentView(), PP2.field_username);
            c30789a2.zpr.setVisibility(8);
            if (PP2.field_verifyFlag == 0) {
                c30789a2.emP.setMaskDrawable(null);
            } else if (C26417a.flw != null) {
                kz = C26417a.flw.mo37873kz(PP2.field_verifyFlag);
                if (kz != null) {
                    c30789a2.emP.mo48741a(C8935m.m16106rk(kz), C23622a.SUBSCRIPT_DRAWABLE_DIRECTION_BOTTOM_RIGHT);
                } else {
                    c30789a2.emP.setMaskDrawable(null);
                }
            } else {
                c30789a2.emP.setMaskDrawable(null);
            }
            try {
                SpannableString b = C44089j.m79294b(this.context, C1854s.m3866mJ(PP2.field_username), (int) c30789a2.emg.getTextSize());
                if (C1855t.m3903mP(PP2.field_username)) {
                    c30789a2.emg.setText(((C32873b) C1720g.m3528K(C32873b.class)).mo44298a(this.context, b));
                } else {
                    c30789a2.emg.setText(b);
                }
            } catch (Exception e3) {
                c30789a2.emg.setText("");
            }
            AppMethodBeat.m2505o(35351);
            return view2;
        }
    }

    /* renamed from: KC */
    public final void mo6869KC() {
        AppMethodBeat.m2504i(35352);
        mo76199ll(false);
        AppMethodBeat.m2505o(35352);
    }

    /* renamed from: ll */
    public final void mo76199ll(final boolean z) {
        AppMethodBeat.m2504i(35353);
        mo76192ay(new Runnable() {
            public final void run() {
                int i = 0;
                AppMethodBeat.m2504i(35336);
                C46939b c46939b;
                if (C46939b.this.yDL != null && C46939b.this.yDL.length != 0) {
                    ArrayList arrayList = new ArrayList();
                    String[] g = C46939b.this.yDL;
                    int length = g.length;
                    while (i < length) {
                        String str = g[i];
                        if (C46939b.this.asz(str)) {
                            arrayList.add(str);
                        }
                        i++;
                    }
                    if (arrayList.size() > 0) {
                        C46939b c46939b2 = C46939b.this;
                        C9638aw.m17190ZK();
                        C46939b.m89690a(c46939b2, C18628c.m29078XM().mo15706a((String[]) arrayList.toArray(new String[arrayList.size()]), C46939b.this.zjx, C46939b.this.elZ));
                        AppMethodBeat.m2505o(35336);
                        return;
                    }
                    c46939b = C46939b.this;
                    C9638aw.m17190ZK();
                    C46939b.m89693b(c46939b, C18628c.m29078XM().dsF());
                    AppMethodBeat.m2505o(35336);
                } else if (C46939b.this.sfv == null) {
                    c46939b = C46939b.this;
                    C9638aw.m17190ZK();
                    C46939b.m89700e(c46939b, C18628c.m29078XM().dsF());
                    AppMethodBeat.m2505o(35336);
                } else if (C46939b.this.zjx.equals("@all.chatroom.contact")) {
                    Cursor a;
                    if (z) {
                        a = C9638aw.m17190ZK().fke.mo20974a(C46939b.this.sfv, "@micromsg.with.all.biz.qq.com.openim", C46939b.this.elZ, false);
                    } else {
                        a = C9638aw.m17190ZK().fke.mo20974a(C46939b.this.sfv, "@micromsg.with.all.biz.qq.com", C46939b.this.elZ, false);
                    }
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    while (a.moveToNext()) {
                        String string = a.getString(a.getColumnIndex("username"));
                        if (C1855t.m3901mN(string)) {
                            arrayList3.add(string);
                        } else {
                            arrayList2.add(string);
                        }
                    }
                    if (!a.isClosed()) {
                        a.close();
                    }
                    if (arrayList2.size() == 0 && arrayList3.size() == 0) {
                        C9638aw.m17190ZK();
                        a = C18628c.m29078XM().dsF();
                    } else {
                        a = C9638aw.m17190ZK().fke.mo20976a(C46939b.this.sfv, arrayList2, null, arrayList3, C46939b.this.elZ);
                    }
                    C46939b.m89697d(C46939b.this, a);
                    AppMethodBeat.m2505o(35336);
                } else {
                    C46939b.m89695c(C46939b.this, C9638aw.m17190ZK().fke.mo20974a(C46939b.this.sfv, C46939b.this.zjx, C46939b.this.elZ, true));
                    AppMethodBeat.m2505o(35336);
                }
            }
        });
        AppMethodBeat.m2505o(35353);
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(35354);
        bIf();
        mo76199ll(false);
        AppMethodBeat.m2505o(35354);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(35355);
        C9638aw.m17182Rg().mo14539a(106, (C1202f) this);
        AppMethodBeat.m2505o(35355);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(35356);
        C9638aw.m17182Rg().mo14546b(106, (C1202f) this);
        AppMethodBeat.m2505o(35356);
    }

    public static String asy(String str) {
        AppMethodBeat.m2504i(35357);
        String trim = str.trim();
        if (trim.startsWith("@")) {
            trim = trim.substring(1) + "%@micromsg.with.all.biz.qq.com";
        }
        C4990ab.m7410d("MicroMsg.SearchResultAdapter", "translateQueryText [" + trim + "]");
        AppMethodBeat.m2505o(35357);
        return trim;
    }

    public final void onSceneEnd(int i, int i2, String str, final C1207m c1207m) {
        AppMethodBeat.m2504i(35358);
        C4990ab.m7410d("MicroMsg.SearchResultAdapter", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (c1207m.getType() != 106) {
            C4990ab.m7412e("MicroMsg.SearchResultAdapter", "error type");
            AppMethodBeat.m2505o(35358);
            return;
        }
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        this.zLz = false;
        if (C30784a.m49123a(this.context, i, i2, str, 7)) {
            this.zLx = false;
            AppMethodBeat.m2505o(35358);
        } else if (i == 4 && i2 == -4) {
            mo76192ay(new C3635111());
            AppMethodBeat.m2505o(35358);
        } else if (i == 0 && i2 == 0) {
            mo76192ay(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(35329);
                    buv bOj = ((C12518f) c1207m).bOj();
                    C4990ab.m7410d("MicroMsg.SearchResultAdapter", "count " + bOj.wod);
                    if (bOj.wod > 0) {
                        for (but but : bOj.woe) {
                            if (C1855t.m3897kv(but.wBT)) {
                                if (C46939b.this.fjr == null) {
                                    C46939b.this.fjr = new LinkedList();
                                }
                                C46939b.this.fjr.add(but);
                            }
                        }
                    } else {
                        String a = C1946aa.m4148a(bOj.wcB);
                        C4990ab.m7410d("MicroMsg.SearchResultAdapter", "user ".concat(String.valueOf(a)));
                        if (C5046bo.nullAsNil(a).length() > 0) {
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
                            C17884o.acd().mo67506n(a, C1946aa.m4150a(bOj.vEF));
                            if (C46939b.this.fjr == null) {
                                C46939b.this.fjr = new LinkedList();
                            }
                            C46939b.this.fjr.clear();
                            if (C1855t.m3897kv(but2.wBT)) {
                                C46939b.this.fjr.add(but2);
                            }
                            C4990ab.m7410d("MicroMsg.SearchResultAdapter", "count " + C46939b.this.fjr.size());
                        }
                    }
                    C46939b.this.zLx = false;
                    AppMethodBeat.m2505o(35329);
                }
            });
            AppMethodBeat.m2505o(35358);
        } else {
            mo76192ay(new C408992());
            AppMethodBeat.m2505o(35358);
        }
    }

    /* renamed from: ay */
    public final void mo76192ay(final Runnable runnable) {
        AppMethodBeat.m2504i(35359);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            notifyDataSetChanged();
            AppMethodBeat.m2505o(35359);
            return;
        }
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(35330);
                runnable.run();
                C46939b.this.notifyDataSetChanged();
                AppMethodBeat.m2505o(35330);
            }
        });
        AppMethodBeat.m2505o(35359);
    }

    public final boolean asz(String str) {
        AppMethodBeat.m2504i(35360);
        if (!(this.elZ == null || str == null)) {
            for (String equals : this.elZ) {
                if (equals.equals(str)) {
                    AppMethodBeat.m2505o(35360);
                    return false;
                }
            }
        }
        AppMethodBeat.m2505o(35360);
        return true;
    }
}
