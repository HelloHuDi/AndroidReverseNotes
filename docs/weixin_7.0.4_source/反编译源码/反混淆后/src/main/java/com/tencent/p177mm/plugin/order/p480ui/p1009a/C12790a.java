package com.tencent.p177mm.plugin.order.p480ui.p1009a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p1529bw.p1530a.C37623a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30382d;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.base.preference.PreferenceSmallCategory;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.order.model.C46125a;
import com.tencent.p177mm.plugin.order.model.C46125a.C3567a;
import com.tencent.p177mm.plugin.order.model.MallOrderDetailObject.HelpCenter;
import com.tencent.p177mm.plugin.order.model.MallTransactionObject;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.C46724c;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.order.ui.a.a */
public final class C12790a implements C3567a {
    public C46724c peq;

    /* renamed from: a */
    public final List<Preference> mo8135a(final Context context, final C15541f c15541f, final MallTransactionObject mallTransactionObject) {
        Object obj;
        CharSequence string;
        C28661f c28661f;
        C7616ad aoO;
        String Oj;
        C28661f c28661f2;
        String string2;
        Object obj2;
        C12800h c12800h;
        AppMethodBeat.m2504i(43893);
        ArrayList arrayList = new ArrayList();
        if (mallTransactionObject.coq == 2) {
            obj = 1;
        } else {
            obj = null;
        }
        if (!(C5046bo.isNullOrNil(mallTransactionObject.pcn) || C5046bo.isNullOrNil(mallTransactionObject.hgW))) {
            C46128d c46128d = new C46128d(context);
            c46128d.kWC = mallTransactionObject.hgW;
            c46128d.mName = mallTransactionObject.pcn;
            c46128d.mOnClickListener = new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(43884);
                    if (!C5046bo.isNullOrNil(mallTransactionObject.pcm)) {
                        C36391e.m59991ae(context, mallTransactionObject.pcm);
                    }
                    AppMethodBeat.m2505o(43884);
                }
            };
            arrayList.add(c46128d);
            arrayList.add(new PreferenceSmallCategory(context));
        }
        C28663i c28663i = new C28663i(context);
        c28663i.peQ = C36391e.m60006e(mallTransactionObject.kCJ, mallTransactionObject.pcl);
        if (obj != null) {
            string = context.getString(C25738R.string.fkh);
        } else if (mallTransactionObject.cQO == 11) {
            string = context.getString(C25738R.string.flh);
        } else {
            string = context.getString(C25738R.string.fkg);
        }
        c28663i.setTitle(string);
        if (!C5046bo.isNullOrNil(mallTransactionObject.pcd)) {
            c28663i.mo46791UA(mallTransactionObject.pcd);
        }
        arrayList.add(c28663i);
        boolean z = false;
        if (mallTransactionObject.kCJ != mallTransactionObject.pcr) {
            C12800h c12800h2 = new C12800h(context);
            c12800h2.peN = false;
            c12800h2.peO = true;
            arrayList.add(c12800h2);
            c28661f = new C28661f(context);
            c28661f.setContent(C36391e.m60006e(mallTransactionObject.pcr, mallTransactionObject.pcl));
            c28661f.setTitle((int) C25738R.string.fl7);
            arrayList.add(c28661f);
            z = true;
        }
        if (!(mallTransactionObject.kCJ == mallTransactionObject.pcr || C5046bo.isNullOrNil(mallTransactionObject.pcq))) {
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
        C12800h c12800h3 = new C12800h(context);
        c12800h3.peN = z;
        c12800h3.peO = true;
        arrayList.add(c12800h3);
        if (obj == null && !C5046bo.isNullOrNil(mallTransactionObject.pcA)) {
            C1720g.m3537RQ();
            aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(mallTransactionObject.pcA);
            if (aoO != null && ((int) aoO.ewQ) > 0) {
                Oj = aoO.mo16707Oj();
                c28661f2 = new C28661f(context);
                c28661f2.setTitle((int) C25738R.string.flk);
                c28661f2.setContent(Oj);
                arrayList.add(c28661f2);
            }
        }
        if (!(mallTransactionObject.cQO != 31 || obj == null || C5046bo.isNullOrNil(mallTransactionObject.pcH))) {
            C1720g.m3537RQ();
            aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(mallTransactionObject.pcH);
            if (aoO != null && ((int) aoO.ewQ) > 0) {
                Oj = aoO.mo16707Oj();
                c28661f2 = new C28661f(context);
                c28661f2.setTitle((int) C25738R.string.fl5);
                c28661f2.setContent(Oj);
                arrayList.add(c28661f2);
            }
        }
        if (!C5046bo.isNullOrNil(mallTransactionObject.desc)) {
            if (obj != null) {
                c28661f = new C28661f(context);
                if (mallTransactionObject.cQO == 32 || mallTransactionObject.cQO == 33 || mallTransactionObject.cQO == 31) {
                    c28661f.setTitle((int) C25738R.string.fkl);
                } else {
                    c28661f.setTitle((int) C25738R.string.fl5);
                }
                c28661f.setContent(mallTransactionObject.desc);
                arrayList.add(c28661f);
            } else {
                c28661f = new C28661f(context);
                if (mallTransactionObject.cQO == 31) {
                    c28661f.setTitle((int) C25738R.string.fld);
                } else {
                    c28661f.setTitle((int) C25738R.string.fkr);
                }
                if (C5046bo.isNullOrNil(mallTransactionObject.pcb)) {
                    c28661f.setContent(mallTransactionObject.desc);
                } else {
                    string2 = context.getString(C25738R.string.fkk);
                    c28661f.mo46788a(mallTransactionObject.desc + " " + string2, mallTransactionObject.desc.length() + 1, string2.length() + (mallTransactionObject.desc.length() + 1), new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(43885);
                            c28661f.setContent(mallTransactionObject.desc + IOUtils.LINE_SEPARATOR_UNIX + mallTransactionObject.pcb);
                            c15541f.notifyDataSetChanged();
                            AppMethodBeat.m2505o(43885);
                        }
                    });
                }
                arrayList.add(c28661f);
            }
        }
        if (!C5046bo.isNullOrNil(mallTransactionObject.pcL)) {
            c28661f = new C28661f(context);
            c28661f.setTitle((int) C25738R.string.flw);
            c28661f.setContent(mallTransactionObject.pcL);
            arrayList.add(c28661f);
        }
        if (!C5046bo.isNullOrNil(mallTransactionObject.pcK)) {
            c28661f = new C28661f(context);
            c28661f.setTitle((int) C25738R.string.flx);
            c28661f.setContent(mallTransactionObject.pcK);
            arrayList.add(c28661f);
        }
        if (!TextUtils.isEmpty(mallTransactionObject.pcC)) {
            c28661f = new C28661f(context);
            c28661f.setTitle((int) C25738R.string.fkj);
            c28661f.setContent(mallTransactionObject.pcC);
            arrayList.add(c28661f);
        }
        if (!C5046bo.isNullOrNil(mallTransactionObject.pca)) {
            c28661f = new C28661f(context);
            c28661f.setTitle((int) C25738R.string.fl6);
            c28661f.setContent(mallTransactionObject.pca);
            arrayList.add(c28661f);
        }
        if (!C5046bo.isNullOrNil(mallTransactionObject.pcf)) {
            c28661f = new C28661f(context);
            c28661f.setTitle((int) C25738R.string.fll);
            if (mallTransactionObject.cQO != 31 || C1853r.m3846Yz().equals(mallTransactionObject.pcA) || mallTransactionObject.pcB <= 0 || C5046bo.isNullOrNil(mallTransactionObject.pcA) || C5046bo.isNullOrNil(mallTransactionObject.cAa)) {
                c28661f.setContent(mallTransactionObject.pcf);
                if (!C5046bo.isNullOrNil(mallTransactionObject.pcg)) {
                    c28661f.mo46787Uz(mallTransactionObject.pcg);
                }
            } else {
                string2 = context.getString(C25738R.string.dq4);
                c28661f.mo46788a(mallTransactionObject.pcf + " " + string2, mallTransactionObject.pcf.length() + 1, (string2.length() + mallTransactionObject.pcf.length()) + 1, new OnClickListener() {

                    /* renamed from: com.tencent.mm.plugin.order.ui.a.a$3$1 */
                    class C127881 implements DialogInterface.OnClickListener {
                        C127881() {
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(43886);
                            Intent intent = new Intent();
                            intent.putExtra(C8741b.TRANSACTION_ID, mallTransactionObject.cAa);
                            intent.putExtra("receiver_name", mallTransactionObject.pcA);
                            intent.putExtra("resend_msg_from_flag", 1);
                            C25985d.m41467b(context, "remittance", ".ui.RemittanceResendMsgUI", intent);
                            AppMethodBeat.m2505o(43886);
                        }
                    }

                    /* renamed from: com.tencent.mm.plugin.order.ui.a.a$3$2 */
                    class C127892 implements DialogInterface.OnClickListener {
                        C127892() {
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }

                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(43887);
                        C30379h.m48466d(context, context.getString(C25738R.string.do5), context.getString(C25738R.string.f9213t6), context.getString(C25738R.string.dq3), context.getString(C25738R.string.f9076or), new C127881(), new C127892());
                        AppMethodBeat.m2505o(43887);
                    }
                });
            }
            arrayList.add(c28661f);
        }
        c28661f = new C28661f(context);
        c28661f.setTitle((int) C25738R.string.fko);
        c28661f.setContent(C36391e.m60014kC(mallTransactionObject.fDG));
        arrayList.add(c28661f);
        if (!C5046bo.isNullOrNil(mallTransactionObject.pcj)) {
            C28661f c28661f3 = new C28661f(context);
            c28661f3.setTitle((int) C25738R.string.fl9);
            Oj = mallTransactionObject.pcj;
            if (!C5046bo.isNullOrNil(mallTransactionObject.pck)) {
                Oj = Oj + "(" + mallTransactionObject.pck + ")";
            }
            c28661f3.setContent(Oj);
            arrayList.add(c28661f3);
        }
        if (!C5046bo.isNullOrNil(mallTransactionObject.cAa)) {
            c28661f = new C28661f(context);
            c28661f.setTitle((int) C25738R.string.fls);
            c28661f.setContent(mallTransactionObject.cAa);
            arrayList.add(c28661f);
        }
        if (!C5046bo.isNullOrNil(mallTransactionObject.pci)) {
            c28661f = new C28661f(context);
            c28661f.setTitle((int) C25738R.string.fli);
            if (mallTransactionObject.cQO == 8) {
                c28661f.setContent(context.getString(C25738R.string.flj));
                C39482c c39482c = new C39482c(context);
                final Bitmap b = C37623a.m63542b(context, mallTransactionObject.pci, 5, 0);
                c39482c.pey = C36391e.atx(mallTransactionObject.pci);
                c39482c.fru = b;
                c39482c.mOnClickListener = new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(43888);
                        if (C12790a.this.peq != null) {
                            C12790a c12790a = C12790a.this;
                            Bitmap bitmap = b;
                            String str = mallTransactionObject.pci;
                            if (c12790a.peq != null) {
                                c12790a.peq.mo75141iw(str, str);
                                c12790a.peq.oZz = bitmap;
                                c12790a.peq.oZA = bitmap;
                                c12790a.peq.dOv();
                            }
                            C12790a.this.peq.mo75136G(view, true);
                        }
                        AppMethodBeat.m2505o(43888);
                    }
                };
                arrayList.add(c28661f);
                arrayList.add(c39482c);
            } else {
                c28661f.setContent(mallTransactionObject.pci);
                arrayList.add(c28661f);
            }
        }
        if (mallTransactionObject.pbM.size() == 0) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        if (obj2 != null || (C5046bo.isNullOrNil(mallTransactionObject.pcv) && C5046bo.isNullOrNil(mallTransactionObject.pcm) && C5046bo.isNullOrNil(mallTransactionObject.pbP))) {
            c12800h = new C12800h(context);
            c12800h.peN = true;
            c12800h.jlN = false;
            arrayList.add(c12800h);
        } else {
            c12800h = new C12800h(context);
            c12800h.peN = true;
            arrayList.add(c12800h);
            arrayList.add(C46125a.m86078a(context, mallTransactionObject));
        }
        if (obj2 != null) {
            C24802j c24802j = new C24802j(context);
            if (mallTransactionObject.pbN == 1) {
                if (!(C5046bo.isNullOrNil(mallTransactionObject.pcv) && C5046bo.isNullOrNil(mallTransactionObject.pcm) && C5046bo.isNullOrNil(mallTransactionObject.pbP))) {
                    if (C5046bo.isNullOrNil(mallTransactionObject.pcw)) {
                        c24802j.peR = context.getString(C25738R.string.flq);
                    } else {
                        c24802j.peR = mallTransactionObject.pcw;
                    }
                    c24802j.peS = new OnClickListener() {

                        /* renamed from: com.tencent.mm.plugin.order.ui.a.a$5$1 */
                        class C127961 implements C30382d {
                            C127961() {
                            }

                            /* renamed from: bV */
                            public final void mo4975bV(int i, int i2) {
                                AppMethodBeat.m2504i(43889);
                                C46125a.m86079a(i2, context, mallTransactionObject);
                                AppMethodBeat.m2505o(43889);
                            }
                        }

                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(43890);
                            List linkedList = new LinkedList();
                            List linkedList2 = new LinkedList();
                            if (!C5046bo.isNullOrNil(mallTransactionObject.pcm)) {
                                linkedList2.add(Integer.valueOf(0));
                                linkedList.add(context.getString(C25738R.string.flo));
                            }
                            if (!C5046bo.isNullOrNil(mallTransactionObject.pbP)) {
                                linkedList2.add(Integer.valueOf(1));
                                linkedList.add(context.getString(C25738R.string.flp));
                            }
                            if (!C5046bo.isNullOrNil(mallTransactionObject.pcv)) {
                                linkedList2.add(Integer.valueOf(2));
                                linkedList.add(context.getString(C25738R.string.flr));
                            }
                            if (linkedList2.size() == 1) {
                                C46125a.m86079a(((Integer) linkedList2.get(0)).intValue(), context, mallTransactionObject);
                                AppMethodBeat.m2505o(43890);
                                return;
                            }
                            C30379h.m48420a(context, null, linkedList, linkedList2, null, true, new C127961());
                            AppMethodBeat.m2505o(43890);
                        }
                    };
                }
            } else if (!C5046bo.isNullOrNil(mallTransactionObject.pcw)) {
                c24802j.peR = mallTransactionObject.pcw;
                c24802j.peS = new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(43891);
                        C12790a.m20793a(context, mallTransactionObject.pcv, mallTransactionObject);
                        AppMethodBeat.m2505o(43891);
                    }
                };
            }
            c24802j.pbM = mallTransactionObject.pbM;
            c24802j.mOnClickListener = new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(43892);
                    if (view.getTag() == null) {
                        AppMethodBeat.m2505o(43892);
                        return;
                    }
                    if (view.getTag() instanceof HelpCenter) {
                        C12790a.m20793a(context, ((HelpCenter) view.getTag()).url, mallTransactionObject);
                    }
                    AppMethodBeat.m2505o(43892);
                }
            };
            c12800h = new C12800h(context);
            c12800h.peN = true;
            arrayList.add(c12800h);
            arrayList.add(c24802j);
        }
        AppMethodBeat.m2505o(43893);
        return arrayList;
    }
}
