package com.tencent.p177mm.p612ui.contact;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p184aj.C25764e;
import com.tencent.p177mm.p184aj.C25764e.C25765a;
import com.tencent.p177mm.p184aj.C25764e.C25765a.C8934b;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.ui.contact.i */
public final class C5451i extends LinearLayout implements C25765a {
    private Context context;
    private LinearLayout mpt = null;
    private List<String> zms;
    private Map<String, View> zmt;
    private C5453a zmu;

    /* renamed from: com.tencent.mm.ui.contact.i$a */
    public interface C5453a {
        /* renamed from: Pl */
        void mo11094Pl(int i);
    }

    /* renamed from: e */
    static /* synthetic */ void m8260e(C5451i c5451i) {
        AppMethodBeat.m2504i(33708);
        c5451i.init();
        AppMethodBeat.m2505o(33708);
    }

    public C5451i(Context context, C5453a c5453a) {
        super(context);
        AppMethodBeat.m2504i(33704);
        this.context = context;
        this.zmu = c5453a;
        init();
        AppMethodBeat.m2505o(33704);
    }

    public final int getEnterpriseFriendCount() {
        AppMethodBeat.m2504i(33705);
        if (this.zms == null) {
            AppMethodBeat.m2505o(33705);
            return 0;
        }
        int size = this.zms.size();
        AppMethodBeat.m2505o(33705);
        return size;
    }

    private void init() {
        int i = 0;
        AppMethodBeat.m2504i(33706);
        C25764e aeR = C41747z.aeR();
        ArrayList arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        C25764e.m40943a(stringBuilder);
        C25764e.m40948c(stringBuilder);
        stringBuilder.append(" and bizinfo.type = 2 ");
        stringBuilder.append(" order by ");
        stringBuilder.append(C25764e.aet());
        C4990ab.m7417i("MicroMsg.BizInfoStorage", "getEnterpriseFatherBizLst sql %s", stringBuilder.toString());
        Cursor rawQuery = aeR.rawQuery(r3, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    arrayList.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        this.zms = arrayList;
        if (this.zms == null || this.zms.size() <= 0) {
            C4990ab.m7412e("MicroMsg.EnterpriseBizView", "bizList is null");
            AppMethodBeat.m2505o(33706);
            return;
        }
        C4990ab.m7417i("MicroMsg.EnterpriseBizView", "biz list size = %s", Integer.valueOf(this.zms.size()));
        this.zmt = new HashMap();
        if (this.mpt == null) {
            View.inflate(getContext(), 2130969392, this);
            this.mpt = (LinearLayout) findViewById(2131821064);
        }
        while (i < this.zms.size()) {
            String str = (String) this.zms.get(i);
            C5455j c5455j = new C5455j(getContext(), str);
            this.mpt.addView(c5455j);
            this.zmt.put(str, c5455j);
            if (i == this.zms.size() - 1) {
                c5455j.findViewById(2131823612).setBackgroundResource(C25738R.drawable.a_q);
            }
            i++;
        }
        AppMethodBeat.m2505o(33706);
    }

    /* renamed from: a */
    public final void mo11091a(final C8934b c8934b) {
        AppMethodBeat.m2504i(33707);
        if (c8934b.fwl == null) {
            AppMethodBeat.m2505o(33707);
        } else if (c8934b.fwl.adP()) {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(33703);
                    C9638aw.m17190ZK();
                    C7616ad aoO = C18628c.m29078XM().aoO(c8934b.fuO);
                    if (C5451i.this.zms == null || C5451i.this.zms.size() <= 0 || !C5451i.this.zms.contains(c8934b.fuO)) {
                        if (aoO == null || ((int) aoO.ewQ) <= 0 || !C7486a.m12942jh(aoO.field_type)) {
                            AppMethodBeat.m2505o(33703);
                            return;
                        }
                        if (C5451i.this.zms != null) {
                            C5451i.this.zms.clear();
                        }
                        if (C5451i.this.zmt != null) {
                            C5451i.this.zmt.clear();
                        }
                        if (C5451i.this.mpt != null) {
                            C5451i.this.mpt.removeAllViews();
                        }
                        C5451i.m8260e(C5451i.this);
                        if (C5451i.this.zmu != null) {
                            C5451i.this.zmu.mo11094Pl(C5451i.this.zms.size());
                        }
                    } else if (aoO == null || ((int) aoO.ewQ) <= 0 || !C7486a.m12942jh(aoO.field_type)) {
                        C4990ab.m7417i("MicroMsg.EnterpriseBizView", "remove enterprise biz view item, %s", c8934b.fuO);
                        C5451i.this.zms.remove(c8934b.fuO);
                        if (C5451i.this.zms.size() > 0) {
                            View view = (View) C5451i.this.zmt.get(c8934b.fuO);
                            if (!(view == null || C5451i.this.mpt == null)) {
                                C5451i.this.mpt.removeView(view);
                                C5451i.this.zmt.remove(view);
                            }
                            AppMethodBeat.m2505o(33703);
                            return;
                        } else if (C5451i.this.zmu != null) {
                            if (C5451i.this.zmt != null) {
                                C5451i.this.zmt.clear();
                            }
                            if (C5451i.this.mpt != null) {
                                C5451i.this.mpt.removeAllViews();
                            }
                            C5451i.this.zmu.mo11094Pl(C5451i.this.zms.size());
                            AppMethodBeat.m2505o(33703);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(33703);
                }
            });
            AppMethodBeat.m2505o(33707);
        } else {
            C4990ab.m7416i("MicroMsg.EnterpriseBizView", "onEvent, not enterprise father");
            AppMethodBeat.m2505o(33707);
        }
    }
}
