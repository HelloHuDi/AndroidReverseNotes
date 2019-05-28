package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.HelpCenter;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.c;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a implements com.tencent.mm.plugin.order.model.a.a {
    public c peq;

    public final List<Preference> a(final Context context, final f fVar, final MallTransactionObject mallTransactionObject) {
        Object obj;
        CharSequence string;
        f fVar2;
        ad aoO;
        String Oj;
        f fVar3;
        String string2;
        Object obj2;
        h hVar;
        AppMethodBeat.i(43893);
        ArrayList arrayList = new ArrayList();
        if (mallTransactionObject.coq == 2) {
            obj = 1;
        } else {
            obj = null;
        }
        if (!(bo.isNullOrNil(mallTransactionObject.pcn) || bo.isNullOrNil(mallTransactionObject.hgW))) {
            d dVar = new d(context);
            dVar.kWC = mallTransactionObject.hgW;
            dVar.mName = mallTransactionObject.pcn;
            dVar.mOnClickListener = new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(43884);
                    if (!bo.isNullOrNil(mallTransactionObject.pcm)) {
                        e.ae(context, mallTransactionObject.pcm);
                    }
                    AppMethodBeat.o(43884);
                }
            };
            arrayList.add(dVar);
            arrayList.add(new PreferenceSmallCategory(context));
        }
        i iVar = new i(context);
        iVar.peQ = e.e(mallTransactionObject.kCJ, mallTransactionObject.pcl);
        if (obj != null) {
            string = context.getString(R.string.fkh);
        } else if (mallTransactionObject.cQO == 11) {
            string = context.getString(R.string.flh);
        } else {
            string = context.getString(R.string.fkg);
        }
        iVar.setTitle(string);
        if (!bo.isNullOrNil(mallTransactionObject.pcd)) {
            iVar.UA(mallTransactionObject.pcd);
        }
        arrayList.add(iVar);
        boolean z = false;
        if (mallTransactionObject.kCJ != mallTransactionObject.pcr) {
            h hVar2 = new h(context);
            hVar2.peN = false;
            hVar2.peO = true;
            arrayList.add(hVar2);
            fVar2 = new f(context);
            fVar2.setContent(e.e(mallTransactionObject.pcr, mallTransactionObject.pcl));
            fVar2.setTitle((int) R.string.fl7);
            arrayList.add(fVar2);
            z = true;
        }
        if (!(mallTransactionObject.kCJ == mallTransactionObject.pcr || bo.isNullOrNil(mallTransactionObject.pcq))) {
            g gVar = new g(context);
            gVar.setTitle((int) R.string.fkt);
            gVar.iFE = fVar;
            String[] split = mallTransactionObject.pcq.split(IOUtils.LINE_SEPARATOR_UNIX);
            if (split.length == 1) {
                gVar.peG = split[0];
            } else {
                gVar.peG = context.getString(R.string.fkv, new Object[]{Integer.valueOf(split.length), e.e(mallTransactionObject.pcr - mallTransactionObject.kCJ, mallTransactionObject.pcl)});
                gVar.a(split, TruncateAt.MIDDLE);
            }
            arrayList.add(gVar);
        }
        h hVar3 = new h(context);
        hVar3.peN = z;
        hVar3.peO = true;
        arrayList.add(hVar3);
        if (obj == null && !bo.isNullOrNil(mallTransactionObject.pcA)) {
            g.RQ();
            aoO = ((j) g.K(j.class)).XM().aoO(mallTransactionObject.pcA);
            if (aoO != null && ((int) aoO.ewQ) > 0) {
                Oj = aoO.Oj();
                fVar3 = new f(context);
                fVar3.setTitle((int) R.string.flk);
                fVar3.setContent(Oj);
                arrayList.add(fVar3);
            }
        }
        if (!(mallTransactionObject.cQO != 31 || obj == null || bo.isNullOrNil(mallTransactionObject.pcH))) {
            g.RQ();
            aoO = ((j) g.K(j.class)).XM().aoO(mallTransactionObject.pcH);
            if (aoO != null && ((int) aoO.ewQ) > 0) {
                Oj = aoO.Oj();
                fVar3 = new f(context);
                fVar3.setTitle((int) R.string.fl5);
                fVar3.setContent(Oj);
                arrayList.add(fVar3);
            }
        }
        if (!bo.isNullOrNil(mallTransactionObject.desc)) {
            if (obj != null) {
                fVar2 = new f(context);
                if (mallTransactionObject.cQO == 32 || mallTransactionObject.cQO == 33 || mallTransactionObject.cQO == 31) {
                    fVar2.setTitle((int) R.string.fkl);
                } else {
                    fVar2.setTitle((int) R.string.fl5);
                }
                fVar2.setContent(mallTransactionObject.desc);
                arrayList.add(fVar2);
            } else {
                fVar2 = new f(context);
                if (mallTransactionObject.cQO == 31) {
                    fVar2.setTitle((int) R.string.fld);
                } else {
                    fVar2.setTitle((int) R.string.fkr);
                }
                if (bo.isNullOrNil(mallTransactionObject.pcb)) {
                    fVar2.setContent(mallTransactionObject.desc);
                } else {
                    string2 = context.getString(R.string.fkk);
                    fVar2.a(mallTransactionObject.desc + " " + string2, mallTransactionObject.desc.length() + 1, string2.length() + (mallTransactionObject.desc.length() + 1), new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(43885);
                            fVar2.setContent(mallTransactionObject.desc + IOUtils.LINE_SEPARATOR_UNIX + mallTransactionObject.pcb);
                            fVar.notifyDataSetChanged();
                            AppMethodBeat.o(43885);
                        }
                    });
                }
                arrayList.add(fVar2);
            }
        }
        if (!bo.isNullOrNil(mallTransactionObject.pcL)) {
            fVar2 = new f(context);
            fVar2.setTitle((int) R.string.flw);
            fVar2.setContent(mallTransactionObject.pcL);
            arrayList.add(fVar2);
        }
        if (!bo.isNullOrNil(mallTransactionObject.pcK)) {
            fVar2 = new f(context);
            fVar2.setTitle((int) R.string.flx);
            fVar2.setContent(mallTransactionObject.pcK);
            arrayList.add(fVar2);
        }
        if (!TextUtils.isEmpty(mallTransactionObject.pcC)) {
            fVar2 = new f(context);
            fVar2.setTitle((int) R.string.fkj);
            fVar2.setContent(mallTransactionObject.pcC);
            arrayList.add(fVar2);
        }
        if (!bo.isNullOrNil(mallTransactionObject.pca)) {
            fVar2 = new f(context);
            fVar2.setTitle((int) R.string.fl6);
            fVar2.setContent(mallTransactionObject.pca);
            arrayList.add(fVar2);
        }
        if (!bo.isNullOrNil(mallTransactionObject.pcf)) {
            fVar2 = new f(context);
            fVar2.setTitle((int) R.string.fll);
            if (mallTransactionObject.cQO != 31 || r.Yz().equals(mallTransactionObject.pcA) || mallTransactionObject.pcB <= 0 || bo.isNullOrNil(mallTransactionObject.pcA) || bo.isNullOrNil(mallTransactionObject.cAa)) {
                fVar2.setContent(mallTransactionObject.pcf);
                if (!bo.isNullOrNil(mallTransactionObject.pcg)) {
                    fVar2.Uz(mallTransactionObject.pcg);
                }
            } else {
                string2 = context.getString(R.string.dq4);
                fVar2.a(mallTransactionObject.pcf + " " + string2, mallTransactionObject.pcf.length() + 1, (string2.length() + mallTransactionObject.pcf.length()) + 1, new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(43887);
                        h.d(context, context.getString(R.string.do5), context.getString(R.string.t6), context.getString(R.string.dq3), context.getString(R.string.or), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(43886);
                                Intent intent = new Intent();
                                intent.putExtra(b.TRANSACTION_ID, mallTransactionObject.cAa);
                                intent.putExtra("receiver_name", mallTransactionObject.pcA);
                                intent.putExtra("resend_msg_from_flag", 1);
                                d.b(context, "remittance", ".ui.RemittanceResendMsgUI", intent);
                                AppMethodBeat.o(43886);
                            }
                        }, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        AppMethodBeat.o(43887);
                    }
                });
            }
            arrayList.add(fVar2);
        }
        fVar2 = new f(context);
        fVar2.setTitle((int) R.string.fko);
        fVar2.setContent(e.kC(mallTransactionObject.fDG));
        arrayList.add(fVar2);
        if (!bo.isNullOrNil(mallTransactionObject.pcj)) {
            f fVar4 = new f(context);
            fVar4.setTitle((int) R.string.fl9);
            Oj = mallTransactionObject.pcj;
            if (!bo.isNullOrNil(mallTransactionObject.pck)) {
                Oj = Oj + "(" + mallTransactionObject.pck + ")";
            }
            fVar4.setContent(Oj);
            arrayList.add(fVar4);
        }
        if (!bo.isNullOrNil(mallTransactionObject.cAa)) {
            fVar2 = new f(context);
            fVar2.setTitle((int) R.string.fls);
            fVar2.setContent(mallTransactionObject.cAa);
            arrayList.add(fVar2);
        }
        if (!bo.isNullOrNil(mallTransactionObject.pci)) {
            fVar2 = new f(context);
            fVar2.setTitle((int) R.string.fli);
            if (mallTransactionObject.cQO == 8) {
                fVar2.setContent(context.getString(R.string.flj));
                c cVar = new c(context);
                final Bitmap b = com.tencent.mm.bw.a.a.b(context, mallTransactionObject.pci, 5, 0);
                cVar.pey = e.atx(mallTransactionObject.pci);
                cVar.fru = b;
                cVar.mOnClickListener = new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(43888);
                        if (a.this.peq != null) {
                            a aVar = a.this;
                            Bitmap bitmap = b;
                            String str = mallTransactionObject.pci;
                            if (aVar.peq != null) {
                                aVar.peq.iw(str, str);
                                aVar.peq.oZz = bitmap;
                                aVar.peq.oZA = bitmap;
                                aVar.peq.dOv();
                            }
                            a.this.peq.G(view, true);
                        }
                        AppMethodBeat.o(43888);
                    }
                };
                arrayList.add(fVar2);
                arrayList.add(cVar);
            } else {
                fVar2.setContent(mallTransactionObject.pci);
                arrayList.add(fVar2);
            }
        }
        if (mallTransactionObject.pbM.size() == 0) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        if (obj2 != null || (bo.isNullOrNil(mallTransactionObject.pcv) && bo.isNullOrNil(mallTransactionObject.pcm) && bo.isNullOrNil(mallTransactionObject.pbP))) {
            hVar = new h(context);
            hVar.peN = true;
            hVar.jlN = false;
            arrayList.add(hVar);
        } else {
            hVar = new h(context);
            hVar.peN = true;
            arrayList.add(hVar);
            arrayList.add(com.tencent.mm.plugin.order.model.a.a(context, mallTransactionObject));
        }
        if (obj2 != null) {
            j jVar = new j(context);
            if (mallTransactionObject.pbN == 1) {
                if (!(bo.isNullOrNil(mallTransactionObject.pcv) && bo.isNullOrNil(mallTransactionObject.pcm) && bo.isNullOrNil(mallTransactionObject.pbP))) {
                    if (bo.isNullOrNil(mallTransactionObject.pcw)) {
                        jVar.peR = context.getString(R.string.flq);
                    } else {
                        jVar.peR = mallTransactionObject.pcw;
                    }
                    jVar.peS = new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(43890);
                            List linkedList = new LinkedList();
                            List linkedList2 = new LinkedList();
                            if (!bo.isNullOrNil(mallTransactionObject.pcm)) {
                                linkedList2.add(Integer.valueOf(0));
                                linkedList.add(context.getString(R.string.flo));
                            }
                            if (!bo.isNullOrNil(mallTransactionObject.pbP)) {
                                linkedList2.add(Integer.valueOf(1));
                                linkedList.add(context.getString(R.string.flp));
                            }
                            if (!bo.isNullOrNil(mallTransactionObject.pcv)) {
                                linkedList2.add(Integer.valueOf(2));
                                linkedList.add(context.getString(R.string.flr));
                            }
                            if (linkedList2.size() == 1) {
                                com.tencent.mm.plugin.order.model.a.a(((Integer) linkedList2.get(0)).intValue(), context, mallTransactionObject);
                                AppMethodBeat.o(43890);
                                return;
                            }
                            h.a(context, null, linkedList, linkedList2, null, true, new h.d() {
                                public final void bV(int i, int i2) {
                                    AppMethodBeat.i(43889);
                                    com.tencent.mm.plugin.order.model.a.a(i2, context, mallTransactionObject);
                                    AppMethodBeat.o(43889);
                                }
                            });
                            AppMethodBeat.o(43890);
                        }
                    };
                }
            } else if (!bo.isNullOrNil(mallTransactionObject.pcw)) {
                jVar.peR = mallTransactionObject.pcw;
                jVar.peS = new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(43891);
                        a.a(context, mallTransactionObject.pcv, mallTransactionObject);
                        AppMethodBeat.o(43891);
                    }
                };
            }
            jVar.pbM = mallTransactionObject.pbM;
            jVar.mOnClickListener = new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(43892);
                    if (view.getTag() == null) {
                        AppMethodBeat.o(43892);
                        return;
                    }
                    if (view.getTag() instanceof HelpCenter) {
                        a.a(context, ((HelpCenter) view.getTag()).url, mallTransactionObject);
                    }
                    AppMethodBeat.o(43892);
                }
            };
            hVar = new h(context);
            hVar.peN = true;
            arrayList.add(hVar);
            arrayList.add(jVar);
        }
        AppMethodBeat.o(43893);
        return arrayList;
    }
}
