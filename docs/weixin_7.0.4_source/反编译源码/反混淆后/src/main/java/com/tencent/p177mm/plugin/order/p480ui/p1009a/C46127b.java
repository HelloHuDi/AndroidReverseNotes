package com.tencent.p177mm.plugin.order.p480ui.p1009a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.base.preference.PreferenceSmallCategory;
import com.tencent.p177mm.plugin.order.model.C46125a;
import com.tencent.p177mm.plugin.order.model.C46125a.C3567a;
import com.tencent.p177mm.plugin.order.model.MallTransactionObject;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.order.ui.a.b */
public final class C46127b implements C3567a {
    /* renamed from: a */
    public final List<Preference> mo8135a(final Context context, final C15541f c15541f, final MallTransactionObject mallTransactionObject) {
        C28661f c28661f;
        C28661f c28661f2;
        AppMethodBeat.m2504i(43897);
        ArrayList arrayList = new ArrayList();
        Object obj = mallTransactionObject.coq == 2 ? 1 : null;
        if (!(C5046bo.isNullOrNil(mallTransactionObject.pcn) || C5046bo.isNullOrNil(mallTransactionObject.hgW))) {
            C46128d c46128d = new C46128d(context);
            c46128d.kWC = mallTransactionObject.hgW;
            c46128d.mName = mallTransactionObject.pcn;
            c46128d.mOnClickListener = new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(43895);
                    if (!C5046bo.isNullOrNil(mallTransactionObject.pcm)) {
                        C36391e.m59991ae(context, mallTransactionObject.pcm);
                    }
                    AppMethodBeat.m2505o(43895);
                }
            };
            arrayList.add(c46128d);
            arrayList.add(new PreferenceSmallCategory(context));
        }
        C4990ab.m7416i("MicroMsg.FetchOrderPrefFactory", "getOrderPrefList() chargeFee is " + mallTransactionObject.pcC + " and fetchTotalFee is " + mallTransactionObject.pcM);
        C12800h c12800h;
        if (TextUtils.isEmpty(mallTransactionObject.pcC)) {
            CharSequence string;
            boolean z;
            C28663i c28663i = new C28663i(context);
            c28663i.peQ = C36391e.m60006e(mallTransactionObject.kCJ, mallTransactionObject.pcl);
            if (obj != null) {
                string = context.getString(C25738R.string.fkh);
            } else {
                string = context.getString(C25738R.string.fkz);
            }
            c28663i.setTitle(string);
            if (!C5046bo.isNullOrNil(mallTransactionObject.pcd)) {
                c28663i.mo46791UA(mallTransactionObject.pcd);
            }
            arrayList.add(c28663i);
            if (mallTransactionObject.kCJ == mallTransactionObject.pcr || mallTransactionObject.pcr <= 0.0d) {
                z = false;
            } else {
                c12800h = new C12800h(context);
                c12800h.peN = false;
                c12800h.peO = true;
                arrayList.add(c12800h);
                c28661f = new C28661f(context);
                c28661f.setContent(C36391e.m60006e(mallTransactionObject.pcr, mallTransactionObject.pcl));
                c28661f.setTitle((int) C25738R.string.fl7);
                arrayList.add(c28661f);
                z = true;
                if (!C5046bo.isNullOrNil(mallTransactionObject.pcq)) {
                    C28662g c28662g = new C28662g(context);
                    c28662g.setTitle((int) C25738R.string.fkt);
                    c28662g.iFE = c15541f;
                    String[] split = mallTransactionObject.pcq.split(IOUtils.LINE_SEPARATOR_UNIX);
                    if (split.length == 1) {
                        c28662g.peG = split[0];
                    } else {
                        c28662g.peG = context.getString(C25738R.string.fkv, new Object[]{Integer.valueOf(split.length), C36391e.m60006e(mallTransactionObject.pcr - mallTransactionObject.kCJ, mallTransactionObject.pcl)});
                        c28662g.mo46790a(split, TruncateAt.MIDDLE);
                    }
                    arrayList.add(c28662g);
                }
            }
            C12800h c12800h2 = new C12800h(context);
            c12800h2.peN = z;
            c12800h2.peO = true;
            arrayList.add(c12800h2);
        } else {
            C28663i c28663i2 = new C28663i(context);
            c28663i2.peQ = C36391e.m60006e(mallTransactionObject.pcM, mallTransactionObject.pcl);
            c28663i2.setTitle((CharSequence) context.getString(C25738R.string.fki));
            if (!C5046bo.isNullOrNil(mallTransactionObject.pcN)) {
                c28663i2.mo46791UA(mallTransactionObject.pcN);
            }
            arrayList.add(c28663i2);
            c12800h = new C12800h(context);
            c12800h.peN = false;
            c12800h.peO = true;
            arrayList.add(c12800h);
            c28661f = new C28661f(context);
            c28661f.setTitle((int) C25738R.string.fkz);
            c28661f.setContent(C36391e.m60006e(mallTransactionObject.kCJ, mallTransactionObject.pcl));
            arrayList.add(c28661f);
            c28661f = new C28661f(context);
            c28661f.setTitle((int) C25738R.string.fkj);
            c28661f.setContent(mallTransactionObject.pcC);
            arrayList.add(c28661f);
        }
        if (!C5046bo.isNullOrNil(mallTransactionObject.desc)) {
            if (obj != null) {
                c28661f2 = new C28661f(context);
                c28661f2.setTitle((int) C25738R.string.fl5);
                c28661f2.setContent(mallTransactionObject.desc);
                arrayList.add(c28661f2);
            } else {
                c28661f2 = new C28661f(context);
                c28661f2.setTitle((int) C25738R.string.fkr);
                if (C5046bo.isNullOrNil(mallTransactionObject.pcb)) {
                    c28661f2.setContent(mallTransactionObject.desc);
                } else {
                    String string2 = context.getString(C25738R.string.fkk);
                    c28661f2.mo46788a(mallTransactionObject.desc + " " + string2, mallTransactionObject.desc.length() + 1, string2.length() + (mallTransactionObject.desc.length() + 1), new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(43896);
                            c28661f2.setContent(mallTransactionObject.desc + IOUtils.LINE_SEPARATOR_UNIX + mallTransactionObject.pcb);
                            c15541f.notifyDataSetChanged();
                            AppMethodBeat.m2505o(43896);
                        }
                    });
                }
                arrayList.add(c28661f2);
            }
        }
        if (!C5046bo.isNullOrNil(mallTransactionObject.pca)) {
            c28661f2 = new C28661f(context);
            c28661f2.setTitle((int) C25738R.string.fl6);
            c28661f2.setContent(mallTransactionObject.pca);
            arrayList.add(c28661f2);
        }
        if (!C5046bo.isNullOrNil(mallTransactionObject.pcf)) {
            c28661f2 = new C28661f(context);
            c28661f2.setTitle((int) C25738R.string.fll);
            c28661f2.setContent(mallTransactionObject.pcf);
            if (!C5046bo.isNullOrNil(mallTransactionObject.pcg)) {
                c28661f2.mo46787Uz(mallTransactionObject.pcg);
            }
            arrayList.add(c28661f2);
        }
        c28661f2 = new C28661f(context);
        c28661f2.setTitle((int) C25738R.string.fl2);
        c28661f2.setContent(C36391e.m60014kC(mallTransactionObject.fDG));
        arrayList.add(c28661f2);
        if (mallTransactionObject.pcy > 0) {
            c28661f2 = new C28661f(context);
            c28661f2.setTitle((int) C25738R.string.fl0);
            c28661f2.setContent(C36391e.m60014kC(mallTransactionObject.pcy));
            arrayList.add(c28661f2);
        } else if (mallTransactionObject.pcx > 0) {
            c28661f2 = new C28661f(context);
            c28661f2.setTitle((int) C25738R.string.fl3);
            c28661f2.setContent(C36391e.m60014kC(mallTransactionObject.pcx));
            arrayList.add(c28661f2);
        } else {
            C4990ab.m7412e("MicroMsg.FetchOrderPrefFactory", "hy: is fetch but no arrive time or fetch time");
        }
        if (!C5046bo.isNullOrNil(mallTransactionObject.pcj)) {
            c28661f = new C28661f(context);
            c28661f.setTitle((int) C25738R.string.fl1);
            String str = mallTransactionObject.pcj;
            if (!C5046bo.isNullOrNil(mallTransactionObject.pck)) {
                str = str + "(" + mallTransactionObject.pck + ")";
            }
            c28661f.setContent(str);
            arrayList.add(c28661f);
        }
        if (!C5046bo.isNullOrNil(mallTransactionObject.pci)) {
            c28661f2 = new C28661f(context);
            c28661f2.setTitle((int) C25738R.string.fl4);
            c28661f2.setContent(mallTransactionObject.pci);
            arrayList.add(c28661f2);
        }
        C12800h c12800h3;
        if (C5046bo.isNullOrNil(mallTransactionObject.pcv) && C5046bo.isNullOrNil(mallTransactionObject.pcm) && C5046bo.isNullOrNil(mallTransactionObject.pbP)) {
            c12800h3 = new C12800h(context);
            c12800h3.peN = true;
            c12800h3.jlN = false;
            arrayList.add(c12800h3);
        } else {
            c12800h3 = new C12800h(context);
            c12800h3.peN = true;
            arrayList.add(c12800h3);
            arrayList.add(C46125a.m86078a(context, mallTransactionObject));
        }
        AppMethodBeat.m2505o(43897);
        return arrayList;
    }
}
