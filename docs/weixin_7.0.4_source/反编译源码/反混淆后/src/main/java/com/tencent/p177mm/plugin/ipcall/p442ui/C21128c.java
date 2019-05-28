package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41732d.C8915a;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.platformtools.C9790g;
import com.tencent.p177mm.plugin.fts.p419a.C34204f;
import com.tencent.p177mm.plugin.ipcall.p438a.C21088i;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C21082b;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C21083c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5025av;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.c */
public final class C21128c extends C46692p<C21083c> implements C8915a {
    static HashMap<String, C21083c> nzw = null;
    HashMap<String, Integer> emK = new HashMap();
    C5025av gGg = new C5025av();
    private String gtX;
    boolean jLC = false;
    private Context mContext;
    private OnClickListener nAA = new C211291();
    private C21133d nAw;
    private HashMap<Long, C21083c> nAx = new HashMap();
    private HashSet<String> nAy = new HashSet();
    private boolean nAz = false;

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.c$b */
    class C12325b {
        ImageView eks;
        TextView gtO;
        TextView nAE;
        LinearLayout nAF;
        TextView nAG;
        TextView nAH;
        TextView nAI;
        TextView nAJ;
        ImageView nAK;
        View nAL;
        View nAM;
        View nAN;
        ImageView nAO;

        private C12325b() {
        }

        /* synthetic */ C12325b(C21128c c21128c, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.c$1 */
    class C211291 implements OnClickListener {
        C211291() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21995);
            if (view.getTag() instanceof Integer) {
                C21083c xn = C21128c.this.mo36449xn(((Integer) view.getTag()).intValue());
                Intent intent = new Intent(C21128c.this.context, IPCallUserProfileUI.class);
                intent.putExtra("IPCallProfileUI_contactid", xn.field_contactId);
                intent.putExtra("IPCallProfileUI_systemUsername", xn.field_systemAddressBookUsername);
                intent.putExtra("IPCallProfileUI_wechatUsername", xn.field_wechatUsername);
                C21128c.this.context.startActivity(intent);
            }
            AppMethodBeat.m2505o(21995);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.c$2 */
    class C211302 implements Runnable {
        C211302() {
        }

        public final void run() {
            AppMethodBeat.m2504i(21996);
            C21128c.this.notifyDataSetChanged();
            AppMethodBeat.m2505o(21996);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.c$a */
    class C21131a {
        String nAC;
        String nAD;

        public C21131a(String str, String str2) {
            this.nAD = str2;
            this.nAC = str;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(22013);
        C21083c xn = mo36449xn(i);
        AppMethodBeat.m2505o(22013);
        return xn;
    }

    public C21128c(Context context) {
        super(context, null);
        AppMethodBeat.m2504i(21997);
        mo74996pN(true);
        this.mContext = context;
        this.nAw = new C21133d(context);
        C17884o.acd().mo67498a((C8915a) this);
        AppMethodBeat.m2505o(21997);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(21998);
        int count = super.getCount();
        AppMethodBeat.m2505o(21998);
        return count;
    }

    public final int bIe() {
        AppMethodBeat.m2504i(21999);
        int count = super.getCount();
        AppMethodBeat.m2505o(21999);
        return count;
    }

    /* renamed from: xn */
    public final C21083c mo36449xn(int i) {
        AppMethodBeat.m2504i(22000);
        C21083c c21083c = (C21083c) super.getItem(i);
        AppMethodBeat.m2505o(22000);
        return c21083c;
    }

    /* renamed from: vM */
    public final void mo36448vM(String str) {
        AppMethodBeat.m2504i(22001);
        this.gtX = str;
        if (C5046bo.isNullOrNil(this.gtX)) {
            this.nAz = false;
        } else {
            this.nAz = true;
        }
        this.yld.clear();
        mo6869KC();
        notifyDataSetChanged();
        AppMethodBeat.m2505o(22001);
    }

    /* renamed from: KC */
    public final void mo6869KC() {
        Cursor OS;
        AppMethodBeat.m2504i(22002);
        if (this.nAz) {
            this.jLC = true;
            OS = C21088i.bHw().mo36406OS(this.gtX);
            this.jLC = false;
        } else {
            OS = C21088i.bHw().bHZ();
        }
        if (OS != null) {
            OS.moveToFirst();
        }
        setCursor(OS);
        bIg();
        AppMethodBeat.m2505o(22002);
    }

    public final void bIf() {
        AppMethodBeat.m2504i(22003);
        super.bIf();
        AppMethodBeat.m2505o(22003);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(22005);
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(2130969894, viewGroup, false);
            C12325b c12325b = new C12325b(this, (byte) 0);
            c12325b.nAM = view.findViewById(2131825131);
            c12325b.nAN = view.findViewById(2131825132);
            c12325b.eks = (ImageView) view.findViewById(2131821183);
            c12325b.gtO = (TextView) view.findViewById(2131823149);
            c12325b.nAE = (TextView) view.findViewById(2131825079);
            c12325b.nAF = (LinearLayout) view.findViewById(2131825135);
            c12325b.nAG = (TextView) view.findViewById(2131825136);
            c12325b.nAH = (TextView) view.findViewById(2131825137);
            c12325b.nAI = (TextView) view.findViewById(2131825130);
            c12325b.nAJ = (TextView) view.findViewById(2131825129);
            c12325b.nAK = (ImageView) view.findViewById(2131825138);
            c12325b.nAL = view.findViewById(2131825134);
            c12325b.nAL.setClickable(true);
            c12325b.nAO = (ImageView) view.findViewById(2131821128);
            view.setTag(c12325b);
        }
        C12325b c12325b2 = (C12325b) view.getTag();
        c12325b2.nAL.setClickable(true);
        c12325b2.nAL.setTag(Integer.valueOf(i));
        c12325b2.nAO.setVisibility(8);
        if (mo10892wK(i)) {
            c12325b2.gtO.setVisibility(8);
            c12325b2.nAE.setVisibility(8);
            c12325b2.nAF.setVisibility(8);
            c12325b2.eks.setVisibility(8);
            c12325b2.eks.setTag(null);
            c12325b2.nAJ.setVisibility(8);
            c12325b2.nAI.setVisibility(8);
            c12325b2.nAK.setVisibility(8);
        } else {
            C21083c xn = mo36449xn(i);
            if (xn != null) {
                String str;
                if (C5046bo.isNullOrNil(xn.field_systemAddressBookUsername)) {
                    c12325b2.gtO.setVisibility(8);
                    c12325b2.nAE.setVisibility(8);
                } else {
                    c12325b2.gtO.setVisibility(0);
                    LayoutParams layoutParams;
                    RelativeLayout.LayoutParams layoutParams2;
                    if (this.nAz) {
                        c12325b2.nAE.setVisibility(0);
                        layoutParams = (LayoutParams) c12325b2.nAM.getLayoutParams();
                        layoutParams.height = (int) c12325b2.nAE.getContext().getResources().getDimension(C25738R.dimen.abc);
                        c12325b2.nAM.setLayoutParams(layoutParams);
                        layoutParams2 = (RelativeLayout.LayoutParams) c12325b2.eks.getLayoutParams();
                        layoutParams2.height = (int) c12325b2.eks.getContext().getResources().getDimension(C25738R.dimen.f9678b7);
                        layoutParams2.width = (int) c12325b2.eks.getContext().getResources().getDimension(C25738R.dimen.f9678b7);
                        c12325b2.eks.setLayoutParams(layoutParams2);
                    } else {
                        c12325b2.nAE.setVisibility(8);
                        layoutParams = (LayoutParams) c12325b2.nAM.getLayoutParams();
                        layoutParams.height = (int) c12325b2.nAE.getContext().getResources().getDimension(C25738R.dimen.f9679b8);
                        c12325b2.nAM.setLayoutParams(layoutParams);
                        layoutParams2 = (RelativeLayout.LayoutParams) c12325b2.eks.getLayoutParams();
                        layoutParams2.height = (int) c12325b2.eks.getContext().getResources().getDimension(C25738R.dimen.aba);
                        layoutParams2.width = (int) c12325b2.eks.getContext().getResources().getDimension(C25738R.dimen.aba);
                        c12325b2.eks.setLayoutParams(layoutParams2);
                    }
                    if (this.nAz && xn.nzx == null && nzw != null && nzw.containsKey(xn.field_contactId)) {
                        xn.nzx = ((C21083c) nzw.get(xn.field_contactId)).nzx;
                    } else if (this.nAz && xn.nzx == null && (nzw == null || nzw.containsKey(xn.field_contactId))) {
                        xn.nzx = C21082b.m32388OP(xn.field_contactId);
                    }
                    if (!C5046bo.isNullOrNil(this.gtX) && (C5046bo.m7498A(this.gtX.charAt(0)) || this.gtX.startsWith("+"))) {
                        c12325b2.nAE.setText(C34204f.m56084a(C21128c.m32458a(xn, this.gtX), C5025av.amM(this.gtX)));
                        c12325b2.gtO.setText(C34204f.m56084a(xn.field_systemAddressBookUsername, this.gtX));
                    } else if (!C5046bo.isNullOrNil(this.gtX) && !C5046bo.m7498A(this.gtX.charAt(0))) {
                        CharSequence charSequence = xn.field_systemAddressBookUsername;
                        String str2 = xn.field_systemAddressBookUsername;
                        String str3 = this.gtX;
                        if (C5046bo.isNullOrNil(str3) || C5046bo.isNullOrNil(str2)) {
                            str = "";
                        } else {
                            if (!C5046bo.amT(str3) && C5046bo.amU(str3)) {
                                int i2;
                                int i3;
                                ArrayList arrayList = new ArrayList();
                                for (i2 = 0; i2 < str2.length(); i2++) {
                                    String substring = str2.substring(i2, i2 + 1);
                                    arrayList.add(new C21131a(C9790g.m17432vo(substring), substring));
                                }
                                for (i2 = 2; i2 <= str2.length(); i2++) {
                                    for (i3 = 0; i3 <= str2.length() - i2; i3++) {
                                        String substring2 = str2.substring(i3, i3 + i2);
                                        arrayList.add(new C21131a(C9790g.m17432vo(substring2), substring2));
                                    }
                                }
                                i2 = 0;
                                while (true) {
                                    i3 = i2;
                                    if (i3 >= arrayList.size()) {
                                        break;
                                    }
                                    C21131a c21131a = (C21131a) arrayList.get(i3);
                                    if (c21131a.nAC.contains(str3)) {
                                        str = c21131a.nAD;
                                        break;
                                    }
                                    i2 = i3 + 1;
                                }
                            }
                            str = str3;
                        }
                        c12325b2.gtO.setText(C34204f.m56084a(charSequence, str));
                        c12325b2.nAE.setText(C21128c.m32458a(xn, this.gtX));
                    } else if (C5046bo.isNullOrNil(this.gtX)) {
                        c12325b2.gtO.setText(xn.field_systemAddressBookUsername);
                    }
                }
                ImageView imageView = c12325b2.eks;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    imageView.setTag(null);
                    imageView.setImageResource(C25738R.drawable.b7h);
                    if (xn != null) {
                        if (!C5046bo.isNullOrNil(xn.field_contactId) && !C5046bo.isNullOrNil(xn.field_wechatUsername)) {
                            this.nAw.mo36453a(xn.field_contactId, xn.field_wechatUsername, imageView);
                        } else if (!C5046bo.isNullOrNil(xn.field_contactId)) {
                            this.nAw.mo36454c(xn.field_contactId, imageView);
                        } else if (!C5046bo.isNullOrNil(xn.field_wechatUsername)) {
                            this.nAw.mo36455e(xn.field_wechatUsername, imageView);
                        }
                        if (!C5046bo.isNullOrNil(xn.field_wechatUsername)) {
                            this.nAy.add(xn.field_wechatUsername);
                        }
                    }
                }
                c12325b2.nAF.setVisibility(8);
                str = C21128c.m32456Pc(xn.field_sortKey);
                if (i == 0) {
                    c12325b2.nAI.setVisibility(0);
                    c12325b2.nAI.setText(str);
                    c12325b2.nAJ.setVisibility(8);
                } else if (C21128c.m32456Pc(mo36449xn(i - 1).field_sortKey).equals(str)) {
                    c12325b2.nAI.setVisibility(8);
                    c12325b2.nAI.setText("");
                    c12325b2.nAJ.setVisibility(8);
                } else {
                    c12325b2.nAI.setVisibility(0);
                    c12325b2.nAI.setText(str);
                    c12325b2.nAJ.setVisibility(8);
                }
            }
            c12325b2.nAL.setVisibility(8);
            c12325b2.nAK.setVisibility(8);
            c12325b2.nAK.setOnClickListener(this.nAA);
        }
        Object obj = 1;
        if (!(mo36449xn(i + 1) == null || mo36449xn(i) == null || C21128c.m32456Pc(mo36449xn(i + 1).field_sortKey).equals(C21128c.m32456Pc(mo36449xn(i).field_sortKey)))) {
            obj = null;
        }
        if (i + 1 == getCount() || obj == null) {
            c12325b2.nAN.setVisibility(8);
        } else {
            c12325b2.nAN.setVisibility(0);
        }
        AppMethodBeat.m2505o(22005);
        return view;
    }

    /* renamed from: a */
    private static String m32458a(C21083c c21083c, String str) {
        AppMethodBeat.m2504i(22006);
        if (!(c21083c == null || c21083c.nzx == null)) {
            Iterator it = c21083c.nzx.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (str2.contains(str)) {
                    AppMethodBeat.m2505o(22006);
                    return str2;
                }
            }
        }
        AppMethodBeat.m2505o(22006);
        return null;
    }

    /* renamed from: Pc */
    private static String m32456Pc(String str) {
        AppMethodBeat.m2504i(22007);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(22007);
            return str2;
        } else if (str.startsWith(C21082b.emJ)) {
            str2 = "#";
            AppMethodBeat.m2505o(22007);
            return str2;
        } else {
            str2 = str.toUpperCase().substring(0, 1);
            AppMethodBeat.m2505o(22007);
            return str2;
        }
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(22008);
        int itemViewType = super.getItemViewType(i);
        AppMethodBeat.m2505o(22008);
        return itemViewType;
    }

    public final int getViewTypeCount() {
        AppMethodBeat.m2504i(22009);
        int viewTypeCount = super.getViewTypeCount();
        AppMethodBeat.m2505o(22009);
        return viewTypeCount;
    }

    /* renamed from: qj */
    public final void mo20342qj(String str) {
        AppMethodBeat.m2504i(22010);
        if (this.nAy.contains(str)) {
            C5004al.m7441d(new C211302());
        }
        AppMethodBeat.m2505o(22010);
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.m2504i(22011);
        this.nAx.clear();
        super.notifyDataSetChanged();
        AppMethodBeat.m2505o(22011);
    }

    private void bIg() {
        AppMethodBeat.m2504i(22012);
        if (getCursor() != null) {
            Cursor cursor = getCursor();
            Object obj = null;
            try {
                if (cursor.moveToFirst()) {
                    int i = 0;
                    while (!cursor.isAfterLast()) {
                        C21083c c21083c = new C21083c();
                        c21083c.mo8995d(cursor);
                        String Pc = C21128c.m32456Pc(c21083c.field_sortKey);
                        if (i == 0) {
                            this.emK.put(Pc, Integer.valueOf(i));
                        } else if (!(obj == null || Pc.equals(obj))) {
                            this.emK.put(Pc, Integer.valueOf(i));
                        }
                        i++;
                        cursor.moveToNext();
                        String obj2 = Pc;
                    }
                }
                AppMethodBeat.m2505o(22012);
                return;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.IPCallAddressAdapter", "initSectionPosMap error: %s", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(22012);
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(22004);
        super.bIf();
        mo6869KC();
        AppMethodBeat.m2505o(22004);
    }
}
