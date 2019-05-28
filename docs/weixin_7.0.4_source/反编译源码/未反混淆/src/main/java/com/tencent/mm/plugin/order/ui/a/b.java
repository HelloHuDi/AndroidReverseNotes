package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.List;

public final class b implements a {
    public final List<Preference> a(final Context context, final f fVar, final MallTransactionObject mallTransactionObject) {
        f fVar2;
        f fVar3;
        AppMethodBeat.i(43897);
        ArrayList arrayList = new ArrayList();
        Object obj = mallTransactionObject.coq == 2 ? 1 : null;
        if (!(bo.isNullOrNil(mallTransactionObject.pcn) || bo.isNullOrNil(mallTransactionObject.hgW))) {
            d dVar = new d(context);
            dVar.kWC = mallTransactionObject.hgW;
            dVar.mName = mallTransactionObject.pcn;
            dVar.mOnClickListener = new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(43895);
                    if (!bo.isNullOrNil(mallTransactionObject.pcm)) {
                        e.ae(context, mallTransactionObject.pcm);
                    }
                    AppMethodBeat.o(43895);
                }
            };
            arrayList.add(dVar);
            arrayList.add(new PreferenceSmallCategory(context));
        }
        ab.i("MicroMsg.FetchOrderPrefFactory", "getOrderPrefList() chargeFee is " + mallTransactionObject.pcC + " and fetchTotalFee is " + mallTransactionObject.pcM);
        h hVar;
        if (TextUtils.isEmpty(mallTransactionObject.pcC)) {
            CharSequence string;
            boolean z;
            i iVar = new i(context);
            iVar.peQ = e.e(mallTransactionObject.kCJ, mallTransactionObject.pcl);
            if (obj != null) {
                string = context.getString(R.string.fkh);
            } else {
                string = context.getString(R.string.fkz);
            }
            iVar.setTitle(string);
            if (!bo.isNullOrNil(mallTransactionObject.pcd)) {
                iVar.UA(mallTransactionObject.pcd);
            }
            arrayList.add(iVar);
            if (mallTransactionObject.kCJ == mallTransactionObject.pcr || mallTransactionObject.pcr <= 0.0d) {
                z = false;
            } else {
                hVar = new h(context);
                hVar.peN = false;
                hVar.peO = true;
                arrayList.add(hVar);
                fVar2 = new f(context);
                fVar2.setContent(e.e(mallTransactionObject.pcr, mallTransactionObject.pcl));
                fVar2.setTitle((int) R.string.fl7);
                arrayList.add(fVar2);
                z = true;
                if (!bo.isNullOrNil(mallTransactionObject.pcq)) {
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
            }
            h hVar2 = new h(context);
            hVar2.peN = z;
            hVar2.peO = true;
            arrayList.add(hVar2);
        } else {
            i iVar2 = new i(context);
            iVar2.peQ = e.e(mallTransactionObject.pcM, mallTransactionObject.pcl);
            iVar2.setTitle((CharSequence) context.getString(R.string.fki));
            if (!bo.isNullOrNil(mallTransactionObject.pcN)) {
                iVar2.UA(mallTransactionObject.pcN);
            }
            arrayList.add(iVar2);
            hVar = new h(context);
            hVar.peN = false;
            hVar.peO = true;
            arrayList.add(hVar);
            fVar2 = new f(context);
            fVar2.setTitle((int) R.string.fkz);
            fVar2.setContent(e.e(mallTransactionObject.kCJ, mallTransactionObject.pcl));
            arrayList.add(fVar2);
            fVar2 = new f(context);
            fVar2.setTitle((int) R.string.fkj);
            fVar2.setContent(mallTransactionObject.pcC);
            arrayList.add(fVar2);
        }
        if (!bo.isNullOrNil(mallTransactionObject.desc)) {
            if (obj != null) {
                fVar3 = new f(context);
                fVar3.setTitle((int) R.string.fl5);
                fVar3.setContent(mallTransactionObject.desc);
                arrayList.add(fVar3);
            } else {
                fVar3 = new f(context);
                fVar3.setTitle((int) R.string.fkr);
                if (bo.isNullOrNil(mallTransactionObject.pcb)) {
                    fVar3.setContent(mallTransactionObject.desc);
                } else {
                    String string2 = context.getString(R.string.fkk);
                    fVar3.a(mallTransactionObject.desc + " " + string2, mallTransactionObject.desc.length() + 1, string2.length() + (mallTransactionObject.desc.length() + 1), new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(43896);
                            fVar3.setContent(mallTransactionObject.desc + IOUtils.LINE_SEPARATOR_UNIX + mallTransactionObject.pcb);
                            fVar.notifyDataSetChanged();
                            AppMethodBeat.o(43896);
                        }
                    });
                }
                arrayList.add(fVar3);
            }
        }
        if (!bo.isNullOrNil(mallTransactionObject.pca)) {
            fVar3 = new f(context);
            fVar3.setTitle((int) R.string.fl6);
            fVar3.setContent(mallTransactionObject.pca);
            arrayList.add(fVar3);
        }
        if (!bo.isNullOrNil(mallTransactionObject.pcf)) {
            fVar3 = new f(context);
            fVar3.setTitle((int) R.string.fll);
            fVar3.setContent(mallTransactionObject.pcf);
            if (!bo.isNullOrNil(mallTransactionObject.pcg)) {
                fVar3.Uz(mallTransactionObject.pcg);
            }
            arrayList.add(fVar3);
        }
        fVar3 = new f(context);
        fVar3.setTitle((int) R.string.fl2);
        fVar3.setContent(e.kC(mallTransactionObject.fDG));
        arrayList.add(fVar3);
        if (mallTransactionObject.pcy > 0) {
            fVar3 = new f(context);
            fVar3.setTitle((int) R.string.fl0);
            fVar3.setContent(e.kC(mallTransactionObject.pcy));
            arrayList.add(fVar3);
        } else if (mallTransactionObject.pcx > 0) {
            fVar3 = new f(context);
            fVar3.setTitle((int) R.string.fl3);
            fVar3.setContent(e.kC(mallTransactionObject.pcx));
            arrayList.add(fVar3);
        } else {
            ab.e("MicroMsg.FetchOrderPrefFactory", "hy: is fetch but no arrive time or fetch time");
        }
        if (!bo.isNullOrNil(mallTransactionObject.pcj)) {
            fVar2 = new f(context);
            fVar2.setTitle((int) R.string.fl1);
            String str = mallTransactionObject.pcj;
            if (!bo.isNullOrNil(mallTransactionObject.pck)) {
                str = str + "(" + mallTransactionObject.pck + ")";
            }
            fVar2.setContent(str);
            arrayList.add(fVar2);
        }
        if (!bo.isNullOrNil(mallTransactionObject.pci)) {
            fVar3 = new f(context);
            fVar3.setTitle((int) R.string.fl4);
            fVar3.setContent(mallTransactionObject.pci);
            arrayList.add(fVar3);
        }
        h hVar3;
        if (bo.isNullOrNil(mallTransactionObject.pcv) && bo.isNullOrNil(mallTransactionObject.pcm) && bo.isNullOrNil(mallTransactionObject.pbP)) {
            hVar3 = new h(context);
            hVar3.peN = true;
            hVar3.jlN = false;
            arrayList.add(hVar3);
        } else {
            hVar3 = new h(context);
            hVar3.peN = true;
            arrayList.add(hVar3);
            arrayList.add(com.tencent.mm.plugin.order.model.a.a(context, mallTransactionObject));
        }
        AppMethodBeat.o(43897);
        return arrayList;
    }
}
