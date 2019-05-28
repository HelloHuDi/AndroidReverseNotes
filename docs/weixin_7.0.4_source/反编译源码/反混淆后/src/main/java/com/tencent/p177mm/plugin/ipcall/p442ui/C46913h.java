package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.p057v4.app.FragmentActivity;
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
import com.tencent.p177mm.plugin.ipcall.p1275b.C34382c;
import com.tencent.p177mm.plugin.ipcall.p1275b.C46041a;
import com.tencent.p177mm.plugin.ipcall.p438a.C21088i;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C12256m;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C21083c;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C28332k;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.h */
public final class C46913h extends C46692p<C21083c> implements C8915a {
    private static HashMap<String, C21083c> nzw = null;
    private boolean jLC = false;
    private C21133d nAw;
    private HashMap<Long, C21083c> nAx = new HashMap();
    private HashSet<String> nAy = new HashSet();
    private boolean nAz = false;
    ArrayList<C28332k> nDZ;
    private OnClickListener nEa = new C344001();

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.h$a */
    class C28352a {
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

        private C28352a() {
        }

        /* synthetic */ C28352a(C46913h c46913h, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.h$1 */
    class C344001 implements OnClickListener {
        C344001() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22238);
            if (view.getTag() instanceof Integer) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (C34382c.m56382eo(C46913h.this.context)) {
                    C28332k xt = C46913h.this.mo76123xt(intValue);
                    C21083c c21083c = null;
                    if (xt.field_addressId > 0) {
                        if (C46913h.this.nAx.containsKey(Long.valueOf(xt.field_addressId))) {
                            c21083c = (C21083c) C46913h.this.nAx.get(Long.valueOf(xt.field_addressId));
                        } else {
                            c21083c = C21088i.bHw().mo36409iU(xt.field_addressId);
                        }
                        if (c21083c != null) {
                            C46913h.this.nAx.put(Long.valueOf(xt.field_addressId), c21083c);
                        }
                    }
                    Intent intent;
                    if (c21083c != null) {
                        intent = new Intent(C46913h.this.context, IPCallTalkUI.class);
                        intent.putExtra("IPCallTalkUI_phoneNumber", xt.field_phonenumber);
                        intent.putExtra("IPCallTalkUI_contactId", c21083c.field_contactId);
                        intent.putExtra("IPCallTalkUI_nickname", c21083c.field_systemAddressBookUsername);
                        intent.putExtra("IPCallTalkUI_toWechatUsername", c21083c.field_wechatUsername);
                        intent.putExtra("IPCallTalkUI_dialScene", 3);
                        C7060h.pYm.mo8381e(12059, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3));
                        ((FragmentActivity) C46913h.this.context).startActivityForResult(intent, 1001);
                        AppMethodBeat.m2505o(22238);
                        return;
                    }
                    intent = new Intent(C46913h.this.context, IPCallTalkUI.class);
                    intent.putExtra("IPCallTalkUI_phoneNumber", xt.field_phonenumber);
                    intent.putExtra("IPCallTalkUI_dialScene", 3);
                    C7060h.pYm.mo8381e(12059, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3));
                    ((FragmentActivity) C46913h.this.context).startActivityForResult(intent, 1001);
                } else {
                    AppMethodBeat.m2505o(22238);
                    return;
                }
            }
            AppMethodBeat.m2505o(22238);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.h$2 */
    class C392782 implements Runnable {
        C392782() {
        }

        public final void run() {
            AppMethodBeat.m2504i(22239);
            C46913h.this.notifyDataSetChanged();
            AppMethodBeat.m2505o(22239);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
        AppMethodBeat.m2504i(22250);
        C21083c c21083c = (C21083c) obj;
        if (c21083c == null) {
            c21083c = new C21083c();
        }
        c21083c.mo8995d(cursor);
        AppMethodBeat.m2505o(22250);
        return c21083c;
    }

    public C46913h(Context context) {
        super(context, null);
        AppMethodBeat.m2504i(22240);
        mo74996pN(true);
        this.nAw = new C21133d(context);
        C17884o.acd().mo67498a((C8915a) this);
        AppMethodBeat.m2505o(22240);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(22243);
        if (this.nDZ == null) {
            this.nDZ = C12256m.bIb();
        }
        if (this.nDZ != null) {
            int size = this.nDZ.size();
            AppMethodBeat.m2505o(22243);
            return size;
        }
        AppMethodBeat.m2505o(22243);
        return 0;
    }

    /* renamed from: xt */
    public final C28332k mo76123xt(int i) {
        AppMethodBeat.m2504i(22244);
        C28332k c28332k = (C28332k) this.nDZ.get(i);
        AppMethodBeat.m2505o(22244);
        return c28332k;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(22245);
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(2130969894, viewGroup, false);
            C28352a c28352a = new C28352a(this, (byte) 0);
            c28352a.nAM = view.findViewById(2131825131);
            c28352a.nAN = view.findViewById(2131825132);
            c28352a.eks = (ImageView) view.findViewById(2131821183);
            c28352a.gtO = (TextView) view.findViewById(2131823149);
            c28352a.nAE = (TextView) view.findViewById(2131825079);
            c28352a.nAF = (LinearLayout) view.findViewById(2131825135);
            c28352a.nAG = (TextView) view.findViewById(2131825136);
            c28352a.nAH = (TextView) view.findViewById(2131825137);
            c28352a.nAI = (TextView) view.findViewById(2131825130);
            c28352a.nAJ = (TextView) view.findViewById(2131825129);
            c28352a.nAK = (ImageView) view.findViewById(2131825138);
            c28352a.nAL = view.findViewById(2131825134);
            c28352a.nAL.setClickable(true);
            c28352a.nAO = (ImageView) view.findViewById(2131821128);
            view.setTag(c28352a);
        }
        C28352a c28352a2 = (C28352a) view.getTag();
        c28352a2.nAL.setClickable(true);
        c28352a2.nAL.setTag(Integer.valueOf(i));
        c28352a2.nAO.setVisibility(8);
        if (mo10892wK(i)) {
            c28352a2.gtO.setVisibility(8);
            c28352a2.nAE.setVisibility(8);
            c28352a2.nAF.setVisibility(8);
            c28352a2.eks.setVisibility(8);
            c28352a2.eks.setTag(null);
            c28352a2.nAJ.setVisibility(8);
            c28352a2.nAI.setVisibility(8);
            c28352a2.nAK.setVisibility(8);
        } else {
            C28332k xt = mo76123xt(i);
            if (xt != null) {
                C21083c c21083c;
                if (i == 0) {
                    c28352a2.nAJ.setVisibility(0);
                    c28352a2.nAI.setVisibility(8);
                    c28352a2.nAJ.setText(this.context.getString(C25738R.string.chg));
                } else {
                    c28352a2.nAJ.setVisibility(8);
                    c28352a2.nAI.setVisibility(8);
                }
                c28352a2.nAO.setVisibility(0);
                c28352a2.gtO.setVisibility(0);
                LayoutParams layoutParams = (LayoutParams) c28352a2.nAM.getLayoutParams();
                layoutParams.height = (int) c28352a2.nAE.getContext().getResources().getDimension(C25738R.dimen.f9679b8);
                c28352a2.nAM.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) c28352a2.eks.getLayoutParams();
                layoutParams2.height = (int) c28352a2.eks.getContext().getResources().getDimension(C25738R.dimen.aba);
                layoutParams2.width = (int) c28352a2.eks.getContext().getResources().getDimension(C25738R.dimen.aba);
                c28352a2.eks.setLayoutParams(layoutParams2);
                if (xt.field_addressId > 0) {
                    if (this.nAx.containsKey(Long.valueOf(xt.field_addressId))) {
                        c21083c = (C21083c) this.nAx.get(Long.valueOf(xt.field_addressId));
                    } else {
                        c21083c = C21088i.bHw().mo36409iU(xt.field_addressId);
                    }
                    if (c21083c != null) {
                        this.nAx.put(Long.valueOf(xt.field_addressId), c21083c);
                        c28352a2.gtO.setText(c21083c.field_systemAddressBookUsername);
                    }
                } else {
                    c28352a2.gtO.setText(C46041a.m85637Pw(xt.field_phonenumber));
                    c21083c = null;
                }
                c28352a2.nAE.setVisibility(8);
                c28352a2.nAF.setVisibility(0);
                c28352a2.nAH.setText(C34382c.m56384iY(xt.field_calltime));
                if (xt.field_duration > 0) {
                    c28352a2.nAG.setText(C34382c.m56388jc(xt.field_duration));
                } else {
                    c28352a2.nAG.setText(C34382c.m56389xy(xt.field_status));
                }
                ImageView imageView = c28352a2.eks;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    imageView.setTag(null);
                    imageView.setImageResource(C25738R.drawable.b7h);
                    if (c21083c != null) {
                        if (!C5046bo.isNullOrNil(c21083c.field_contactId) && !C5046bo.isNullOrNil(c21083c.field_wechatUsername)) {
                            this.nAw.mo36453a(c21083c.field_contactId, c21083c.field_wechatUsername, imageView);
                        } else if (!C5046bo.isNullOrNil(c21083c.field_contactId)) {
                            this.nAw.mo36454c(c21083c.field_contactId, imageView);
                        } else if (!C5046bo.isNullOrNil(c21083c.field_wechatUsername)) {
                            this.nAw.mo36455e(c21083c.field_wechatUsername, imageView);
                        }
                        if (!C5046bo.isNullOrNil(c21083c.field_wechatUsername)) {
                            this.nAy.add(c21083c.field_wechatUsername);
                        }
                    }
                }
            }
            c28352a2.nAL.setVisibility(0);
            c28352a2.nAK.setVisibility(0);
            c28352a2.nAL.setOnClickListener(this.nEa);
        }
        AppMethodBeat.m2505o(22245);
        return view;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(22246);
        int itemViewType = super.getItemViewType(i);
        AppMethodBeat.m2505o(22246);
        return itemViewType;
    }

    public final int getViewTypeCount() {
        AppMethodBeat.m2504i(22247);
        int viewTypeCount = super.getViewTypeCount();
        AppMethodBeat.m2505o(22247);
        return viewTypeCount;
    }

    /* renamed from: qj */
    public final void mo20342qj(String str) {
        AppMethodBeat.m2504i(22248);
        if (this.nAy.contains(str)) {
            C5004al.m7441d(new C392782());
        }
        AppMethodBeat.m2505o(22248);
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(138615);
        this.nDZ = C12256m.bIb();
        AppMethodBeat.m2505o(138615);
    }

    /* renamed from: KC */
    public final void mo6869KC() {
        AppMethodBeat.m2504i(139022);
        this.nDZ = C12256m.bIb();
        AppMethodBeat.m2505o(139022);
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.m2504i(22249);
        this.nDZ = C12256m.bIb();
        this.nAx.clear();
        super.notifyDataSetChanged();
        AppMethodBeat.m2505o(22249);
    }
}
