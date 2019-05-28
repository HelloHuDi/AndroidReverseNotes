package com.tencent.mm.plugin.card.ui;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ca;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeCodeUI;
import com.tencent.mm.plugin.card.ui.view.i;
import com.tencent.mm.plugin.card.ui.view.j;
import com.tencent.mm.plugin.card.ui.view.k;
import com.tencent.mm.plugin.card.ui.view.q;
import com.tencent.mm.plugin.card.ui.view.u;
import com.tencent.mm.plugin.card.ui.view.w;
import com.tencent.mm.plugin.card.ui.view.y;
import com.tencent.mm.plugin.card.ui.view.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ax;
import com.tencent.mm.protocal.protobuf.od;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.protocal.protobuf.wy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public final class e implements com.tencent.mm.plugin.card.b.g.a, n, com.tencent.mm.ui.MMActivity.a {
    private final String TAG = "MicroMsg.CardDetailUIContoller";
    boolean cAY = false;
    OnClickListener gKK = new OnClickListener() {
        /* JADX WARNING: Removed duplicated region for block: B:69:0x01df  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x0188  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x02a2  */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x025b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(View view) {
            boolean z = true;
            int i = false;
            AppMethodBeat.i(88338);
            h hVar;
            Object[] objArr;
            tm tmVar;
            int i2;
            od odVar;
            if (view.getId() == R.id.a_d || view.getId() == R.id.a_e) {
                if (e.this.kaS.aZB()) {
                    if (e.this.kjE != null) {
                        e.this.kjE.bcr();
                        AppMethodBeat.o(88338);
                        return;
                    }
                } else if (e.this.kaS.aZC() && e.this.kjE != null) {
                    e.this.kjE.bcp();
                    AppMethodBeat.o(88338);
                    return;
                }
            } else if (view.getId() == R.id.bx_ || view.getId() == R.id.a_j) {
                com.tencent.mm.plugin.card.d.b.ae(e.this.kjd, e.this.kjF.kiN);
                AppMethodBeat.o(88338);
                return;
            } else if (view.getId() == R.id.aab || view.getId() == R.id.aa5) {
                if (view.getId() == R.id.aab) {
                    e.this.kjx = false;
                } else if (view.getId() == R.id.aa5) {
                    e.this.kjx = true;
                }
                if (e.this.kjk instanceof q) {
                    e.this.kjw.knw = ((q) e.this.kjk).e(com.tencent.mm.plugin.card.d.c.CARDCODEREFRESHACTION_DOREFRESH);
                }
                j jVar = e.this.kjw;
                boolean z2 = e.this.kjx;
                jVar.bdp();
                jVar.kjx = z2;
                if (!(jVar.gKG == null || jVar.gKG.isShowing())) {
                    jVar.gKG.showAtLocation(view.getRootView(), 17, 0, 0);
                    jVar.gKG.setFocusable(true);
                    jVar.gKG.setTouchable(true);
                    jVar.gKG.setBackgroundDrawable(new ColorDrawable(16777215));
                    jVar.gKG.setOutsideTouchable(true);
                    CharSequence charSequence;
                    if (jVar.kjx) {
                        jVar.kns.setOnClickListener(jVar.gKK);
                        Bitmap bitmap = jVar.kno;
                        if (jVar.kgb != null) {
                            jVar.kno = l.J(jVar.kgb);
                        } else {
                            jVar.kno = null;
                        }
                        jVar.kns.setImageBitmap(jVar.kno);
                        jVar.knv.add(0, bitmap);
                        jVar.bds();
                        jVar.gKI.setVisibility(8);
                        jVar.knr.setVisibility(0);
                        charSequence = jVar.kaS.aZW().code;
                        if (jVar.kaS.aZV().vUB == null || !jVar.kaS.aZV().vUB.wdu) {
                            if (!bo.isNullOrNil(jVar.kaS.aZW().vSo)) {
                                charSequence = jVar.kaS.aZW().vSo;
                            } else if (jVar.kaS.aZQ()) {
                                if (!bo.isNullOrNil(jVar.knw)) {
                                    charSequence = jVar.knw;
                                }
                            }
                            if (!TextUtils.isEmpty(charSequence) || charSequence.length() > 40) {
                                jVar.knt.setVisibility(8);
                            } else {
                                jVar.knt.setText(m.Hu(charSequence));
                                if (jVar.kaS.aZL()) {
                                    jVar.knt.setVisibility(0);
                                } else {
                                    jVar.knt.setVisibility(8);
                                }
                            }
                            if (bo.isNullOrNil(jVar.kaS.aZV().kCx)) {
                                jVar.knu.setText(jVar.kaS.aZV().kCx);
                                jVar.knu.setVisibility(0);
                            } else {
                                jVar.knu.setVisibility(8);
                            }
                        }
                        charSequence = "";
                        if (TextUtils.isEmpty(charSequence)) {
                        }
                        jVar.knt.setVisibility(8);
                        if (bo.isNullOrNil(jVar.kaS.aZV().kCx)) {
                        }
                    } else {
                        jVar.gKH.setOnClickListener(jVar.gKK);
                        jVar.gKH.setImageBitmap(jVar.gKF);
                        charSequence = jVar.kaS.aZW().code;
                        if (jVar.kaS.aZV().vUB == null || !jVar.kaS.aZV().vUB.wdu) {
                            if (!bo.isNullOrNil(jVar.kaS.aZW().vSo)) {
                                charSequence = jVar.kaS.aZW().vSo;
                            } else if (jVar.kaS.aZQ()) {
                                if (!bo.isNullOrNil(jVar.knw)) {
                                    charSequence = jVar.knw;
                                }
                            }
                            if (!TextUtils.isEmpty(charSequence) || charSequence.length() > 40) {
                                jVar.knp.setVisibility(8);
                            } else {
                                jVar.knp.setText(m.Hu(charSequence));
                                if (jVar.kaS.aZL()) {
                                    jVar.knp.setVisibility(0);
                                } else {
                                    jVar.knp.setVisibility(8);
                                }
                            }
                            if (TextUtils.isEmpty(jVar.kaS.aZV().kCx)) {
                                jVar.knq.setText(jVar.kaS.aZV().kCx);
                                jVar.knq.setVisibility(0);
                            } else {
                                jVar.knq.setVisibility(8);
                            }
                            jVar.gKI.setVisibility(0);
                            jVar.knr.setVisibility(8);
                        }
                        charSequence = "";
                        if (TextUtils.isEmpty(charSequence)) {
                        }
                        jVar.knp.setVisibility(8);
                        if (TextUtils.isEmpty(jVar.kaS.aZV().kCx)) {
                        }
                        jVar.gKI.setVisibility(0);
                        jVar.knr.setVisibility(8);
                    }
                    jVar.gKG.update();
                }
                AppMethodBeat.o(88338);
                return;
            } else if (view.getId() == R.id.aka || view.getId() == R.id.ahj || view.getId() == R.id.abe || view.getId() == R.id.aa7 || view.getId() == R.id.ahi) {
                if (view.getId() == R.id.aka) {
                    if (e.this.kaS.aZC()) {
                        int i3;
                        hVar = h.pYm;
                        objArr = new Object[9];
                        objArr[0] = "CardConsumedCodeUI";
                        objArr[1] = Integer.valueOf(e.this.kaS.aZV().iAd);
                        objArr[2] = e.this.kaS.baa();
                        objArr[3] = e.this.kaS.aZZ();
                        objArr[4] = Integer.valueOf(0);
                        objArr[5] = Integer.valueOf(e.this.kjF.kgn);
                        objArr[6] = e.this.kjF.kiN;
                        if (e.this.kaS.aZT()) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        objArr[7] = Integer.valueOf(i3);
                        objArr[8] = "";
                        hVar.e(11324, objArr);
                        if (e.this.kjE != null) {
                            e.this.kjE.fJ(true);
                            AppMethodBeat.o(88338);
                            return;
                        }
                    }
                    e.this.a(true, new com.tencent.mm.plugin.card.b.j.b(), false);
                    AppMethodBeat.o(88338);
                    return;
                } else if (view.getId() == R.id.aa7 && e.this.kaS.aZV().vUE) {
                    AppMethodBeat.o(88338);
                    return;
                } else if (!e.this.kaS.aZC()) {
                    e.this.a(false, new com.tencent.mm.plugin.card.b.j.b(), false);
                    AppMethodBeat.o(88338);
                    return;
                } else if (e.this.kjE != null) {
                    e.this.kjE.fJ(false);
                    AppMethodBeat.o(88338);
                    return;
                }
            } else if (view.getId() == R.id.acd) {
                if (!TextUtils.isEmpty(e.this.kaS.aZV().vUi)) {
                    com.tencent.mm.plugin.card.d.b.a(e.this.kjd, e.this.kaS.aZV().vUi, 3);
                    h.pYm.e(11941, Integer.valueOf(13), e.this.kaS.aZZ(), e.this.kaS.baa(), "", e.this.kaS.aZV().vUh);
                    AppMethodBeat.o(88338);
                    return;
                }
            } else if (view.getId() == R.id.a_h) {
                h.pYm.e(11582, "OpenShareUserSelectView", Integer.valueOf(0), Integer.valueOf(e.this.kaS.aZV().iAd), e.this.kaS.baa(), e.this.kaS.aZZ(), e.this.kjF.kiN);
                Intent intent = new Intent();
                intent.putExtra("KLabel_range_index", e.this.kgP);
                intent.putExtra("Klabel_name_list", e.this.kgQ);
                intent.putExtra("Kother_user_name_list", e.this.kgR);
                intent.putExtra("k_sns_label_ui_title", e.this.kjd.getString(R.string.aha));
                intent.putExtra("k_sns_label_ui_style", 0);
                intent.putExtra("KLabel_is_filter_private", true);
                com.tencent.mm.bp.d.b(e.this.kjd, "sns", ".ui.SnsLabelUI", intent, 2);
                e.this.kjd.ifE = e.this;
                AppMethodBeat.o(88338);
                return;
            } else if (view.getId() == R.id.aiv) {
                if (e.this.kaS.aZW().vSc != null) {
                    LinkedList linkedList = e.this.kaS.aZW().vSc;
                    int intValue = ((Integer) view.getTag()).intValue();
                    tmVar = (tm) linkedList.get(intValue);
                    if (com.tencent.mm.plugin.card.d.b.a(e.this.kaS.aZZ(), tmVar, e.this.kjF.kgn, e.this.kjF.kjL)) {
                        h.pYm.e(11941, Integer.valueOf(19), e.this.kaS.aZZ(), e.this.kaS.baa(), "", tmVar.title);
                        AppMethodBeat.o(88338);
                        return;
                    }
                    if (!(tmVar == null || TextUtils.isEmpty(tmVar.url))) {
                        com.tencent.mm.plugin.card.d.b.a(e.this.kjd, tmVar.url, 1);
                        h hVar2 = h.pYm;
                        Object[] objArr2 = new Object[5];
                        switch (intValue) {
                            case 0:
                                i2 = 10;
                                break;
                            case 1:
                                i2 = 11;
                                break;
                            case 2:
                                i2 = 12;
                                break;
                            case 3:
                                i2 = 16;
                                break;
                            default:
                                i2 = 10;
                                break;
                        }
                        objArr2[0] = Integer.valueOf(i2);
                        objArr2[1] = e.this.kaS.aZZ();
                        objArr2[2] = e.this.kaS.baa();
                        objArr2[3] = "";
                        objArr2[4] = tmVar.title;
                        hVar2.e(11941, objArr2);
                        if (l.a(tmVar, e.this.kaS.aZZ())) {
                            l.Hs(e.this.kaS.aZZ());
                            com.tencent.mm.plugin.card.d.b.b(e.this.kjd, e.this.kaS.aZV().kdg);
                        }
                    }
                    AppMethodBeat.o(88338);
                    return;
                }
            } else if (view.getId() == R.id.aiy) {
                if (e.this.kaS.aZW().vSc != null) {
                    tmVar = (tm) e.this.kaS.aZW().vSc.get(0);
                    if (com.tencent.mm.plugin.card.d.b.a(e.this.kaS.aZZ(), tmVar, e.this.kjF.kgn, e.this.kjF.kjL)) {
                        h.pYm.e(11941, Integer.valueOf(19), e.this.kaS.aZZ(), e.this.kaS.baa(), "", tmVar.title);
                        AppMethodBeat.o(88338);
                        return;
                    }
                    if (!(tmVar == null || TextUtils.isEmpty(tmVar.url))) {
                        com.tencent.mm.plugin.card.d.b.a(e.this.kjd, tmVar.url, 1);
                        h.pYm.e(11941, Integer.valueOf(10), e.this.kaS.aZZ(), e.this.kaS.baa(), "", tmVar.title);
                        if (l.a(tmVar, e.this.kaS.aZZ())) {
                            l.Hs(e.this.kaS.aZZ());
                            com.tencent.mm.plugin.card.d.b.b(e.this.kjd, e.this.kaS.aZV().kdg);
                        }
                    }
                    AppMethodBeat.o(88338);
                    return;
                }
            } else if (view.getId() == R.id.ahy || view.getId() == R.id.ahz) {
                if (e.this.kaS.aZW().vSj != null) {
                    if (e.this.kaS.aZO()) {
                        if (!e.this.kaS.aZC()) {
                            e.this.a(false, new com.tencent.mm.plugin.card.b.j.b(), false);
                            AppMethodBeat.o(88338);
                            return;
                        } else if (e.this.kjE != null) {
                            e.this.kjE.fJ(false);
                            AppMethodBeat.o(88338);
                            return;
                        }
                    } else if (e.this.kaS.aZP()) {
                        com.tencent.mm.plugin.card.b.j.b bVar = new com.tencent.mm.plugin.card.b.j.b();
                        com.tencent.mm.plugin.card.d.b.a(e.this.kjd, bVar.kbK, bVar.kbL, false, e.this.kaS);
                        AppMethodBeat.o(88338);
                        return;
                    } else {
                        tmVar = e.this.kaS.aZW().vSj;
                        if (com.tencent.mm.plugin.card.d.b.a(e.this.kaS.aZZ(), tmVar, e.this.kjF.kgn, e.this.kjF.kjL)) {
                            h.pYm.e(11941, Integer.valueOf(20), e.this.kaS.aZZ(), e.this.kaS.baa(), "", tmVar.title);
                            AppMethodBeat.o(88338);
                            return;
                        }
                        if (!(tmVar == null || TextUtils.isEmpty(tmVar.url))) {
                            com.tencent.mm.plugin.card.d.b.a(e.this.kjd, l.A(tmVar.url, tmVar.vUW), 1);
                            h.pYm.e(11941, Integer.valueOf(9), e.this.kaS.aZZ(), e.this.kaS.baa(), "", tmVar.title);
                            if (l.a(tmVar, e.this.kaS.aZZ())) {
                                l.Hs(e.this.kaS.aZZ());
                                com.tencent.mm.plugin.card.d.b.b(e.this.kjd, e.this.kaS.aZV().kdg);
                            }
                        }
                        AppMethodBeat.o(88338);
                        return;
                    }
                }
            } else if (view.getId() == R.id.ac5 || view.getId() == R.id.aby) {
                wy wyVar = e.this.kaS.aZV().vUo;
                hVar = h.pYm;
                objArr = new Object[9];
                objArr[0] = "CardLeftRightIntroduceView";
                objArr[1] = Integer.valueOf(e.this.kaS.aZV().iAd);
                objArr[2] = e.this.kaS.baa();
                objArr[3] = e.this.kaS.aZZ();
                objArr[4] = Integer.valueOf(0);
                objArr[5] = Integer.valueOf(e.this.kjF.kgn);
                objArr[6] = e.this.kjF.kiN;
                if (e.this.kaS.aZT()) {
                    i = 1;
                }
                objArr[7] = Integer.valueOf(i);
                objArr[8] = "";
                hVar.e(11324, objArr);
                if (wyVar == null || TextUtils.isEmpty(wyVar.url)) {
                    Intent intent2 = new Intent();
                    if (e.this.kaS instanceof CardInfo) {
                        intent2.putExtra("key_card_info_data", (CardInfo) e.this.kaS);
                    } else if (e.this.kaS instanceof ShareCardInfo) {
                        intent2.putExtra("key_card_info_data", (ShareCardInfo) e.this.kaS);
                    }
                    intent2.setClass(e.this.kjd, CardDetailPreference.class);
                    e.this.kjd.startActivity(intent2);
                    AppMethodBeat.o(88338);
                    return;
                }
                com.tencent.mm.plugin.card.d.b.a(e.this.kjd, wyVar.url, 1);
                AppMethodBeat.o(88338);
                return;
            } else if (view.getId() == R.id.ajh) {
                if (com.tencent.mm.plugin.card.sharecard.a.b.GC(e.this.kaS.baa()) <= 1) {
                    AppMethodBeat.o(88338);
                    return;
                }
                e eVar = e.this;
                if (e.this.kjg) {
                    z = false;
                }
                eVar.kjg = z;
                e.this.bbB();
                AppMethodBeat.o(88338);
                return;
            } else if (view.getId() == R.id.ac1) {
                if (!(e.this.kaS.aZV().vUk == null || TextUtils.isEmpty(e.this.kaS.aZV().vUk.url))) {
                    com.tencent.mm.plugin.card.d.b.a(e.this.kjd, e.this.kaS.aZV().vUk.url, 3);
                    h.pYm.e(11941, Integer.valueOf(3), e.this.kaS.aZZ(), e.this.kaS.baa(), "", e.this.kaS.aZV().vUk.text);
                    AppMethodBeat.o(88338);
                    return;
                }
            } else if (view.getId() == R.id.a_m) {
                if (!(e.this.kaS.aZV().vUr == null || bo.isNullOrNil(e.this.kaS.aZV().vUr.url))) {
                    com.tencent.mm.plugin.card.d.b.a(e.this.kjd, e.this.kaS.aZV().vUr.url, 1);
                    h.pYm.e(11941, Integer.valueOf(14), e.this.kaS.aZZ(), e.this.kaS.baa(), "", e.this.kaS.aZV().vUr.text);
                    AppMethodBeat.o(88338);
                    return;
                }
            } else if (view.getId() == R.id.aju || view.getId() == R.id.ajt) {
                if (e.this.kaS.aZV().vUa > 0) {
                    if (e.this.kaY == null || e.this.kaY.size() == 0) {
                        ab.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                        AppMethodBeat.o(88338);
                        return;
                    }
                    odVar = (od) e.this.kaY.get(0);
                    com.tencent.mm.plugin.card.d.b.a(e.this.kjd, odVar.cEB, odVar.cGm, odVar.fBg);
                    h hVar3 = h.pYm;
                    Object[] objArr3 = new Object[9];
                    objArr3[0] = "UsedStoresView";
                    objArr3[1] = Integer.valueOf(e.this.kaS.aZV().iAd);
                    objArr3[2] = e.this.kaS.baa();
                    objArr3[3] = e.this.kaS.aZZ();
                    objArr3[4] = Integer.valueOf(0);
                    objArr3[5] = Integer.valueOf(e.this.kjF.kgn);
                    objArr3[6] = e.this.kjF.kiN;
                    if (e.this.kaS.aZT()) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    objArr3[7] = Integer.valueOf(i2);
                    objArr3[8] = "";
                    hVar3.e(11324, objArr3);
                    h.pYm.e(11941, Integer.valueOf(5), e.this.kaS.aZZ(), e.this.kaS.baa(), "", odVar.name);
                    AppMethodBeat.o(88338);
                    return;
                }
            } else if (view.getId() == R.id.akk) {
                if (e.this.kaY == null || e.this.kaY.size() == 0) {
                    ab.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                    AppMethodBeat.o(88338);
                    return;
                }
                odVar = (od) e.this.kaY.get(0);
                String str = (String) view.getTag();
                if (TextUtils.isEmpty(str) || !str.equals(e.this.kjd.getString(R.string.acx))) {
                    if (!TextUtils.isEmpty(odVar.kdF)) {
                        com.tencent.mm.plugin.card.d.b.a(e.this.kjd, odVar.kdF, 1);
                        h.pYm.e(11941, Integer.valueOf(4), e.this.kaS.aZZ(), e.this.kaS.baa(), "", odVar.name);
                    }
                    AppMethodBeat.o(88338);
                    return;
                }
                e.a(e.this);
                AppMethodBeat.o(88338);
                return;
            } else if (view.getId() == R.id.ako) {
                e.a(e.this);
            }
            AppMethodBeat.o(88338);
        }
    };
    private View jcl;
    com.tencent.mm.plugin.card.base.b kaS;
    List<com.tencent.mm.plugin.card.model.b> kaW = new ArrayList();
    ArrayList<od> kaY;
    public int kgP = 0;
    String kgQ = "";
    String kgR = "";
    public ArrayList<String> kgS = new ArrayList();
    public ArrayList<String> kgT = new ArrayList();
    public String kjA = "";
    HashMap<Integer, String> kjB = new HashMap();
    HashMap<String, String> kjC = new HashMap();
    ArrayList<String> kjD = new ArrayList();
    d kjE;
    a kjF;
    private ak kjG = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(88337);
            if (message.obj != null && (message.obj instanceof c)) {
                c cVar = (c) message.obj;
                if (cVar.kjR == b.onGetCodeFail) {
                    if (e.this.kjk != null) {
                        com.tencent.mm.plugin.card.d.d.a(e.this.kjd, cVar.aIm, false);
                        e.this.kjk.bev();
                        AppMethodBeat.o(88337);
                        return;
                    }
                } else if (cVar.kjR == b.onShowTimeExpired) {
                    if (e.this.kjk != null) {
                        e.this.kjk.d(com.tencent.mm.plugin.card.d.c.CARDCODEREFRESHACTION_SHOWING_TIMEOUT);
                        AppMethodBeat.o(88337);
                        return;
                    }
                } else if (e.this.kjk != null) {
                    e.this.kjk.d(cVar.kjS);
                }
            }
            AppMethodBeat.o(88337);
        }
    };
    com.tencent.mm.sdk.b.c kjH = new com.tencent.mm.sdk.b.c<ca>() {
        {
            AppMethodBeat.i(88344);
            this.xxI = ca.class.getName().hashCode();
            AppMethodBeat.o(88344);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(88345);
            ca caVar = (ca) bVar;
            if (g.RK()) {
                ab.i("MicroMsg.CardDetailUIContoller", "deal with card notify event ConsumedCardByOfflinePayEvent");
                if (caVar instanceof ca) {
                    if (caVar.cvj.bFZ == 0) {
                        com.tencent.mm.plugin.card.d.d.c(e.this.kjd, e.this.kjd.getResources().getString(R.string.aik));
                    }
                    AppMethodBeat.o(88345);
                    return true;
                }
            }
            AppMethodBeat.o(88345);
            return false;
        }
    };
    CardDetailBaseUI kjd;
    com.tencent.mm.plugin.card.ui.a.g kje;
    i kjf;
    boolean kjg = false;
    i kjh;
    i kji;
    com.tencent.mm.plugin.card.widget.g kjj;
    com.tencent.mm.plugin.card.ui.view.g kjk;
    m kjl;
    i kjm;
    i kjn;
    i kjo;
    i kjp;
    i kjq;
    i kjr;
    i kjs;
    i kjt;
    com.tencent.mm.plugin.card.ui.view.d kju;
    i kjv;
    j kjw;
    boolean kjx = true;
    f kjy;
    public String kjz = "";
    LinearLayout lK;
    ListView mListView;

    public static class a {
        public int emC = 3;
        public String kaE = "";
        public boolean kcf = false;
        public int kgn = -1;
        public String kiN = "";
        public String kiO = "";
        public String kiP = "";
        public String kir = "";
        public String kis = "";
        public int kjL = 0;
    }

    public enum b {
        onGetCodeSuccess,
        onShowTimeExpired,
        onReceiveCodeUnavailable,
        onGetCodeFail;

        static {
            AppMethodBeat.o(88348);
        }
    }

    static class c {
        String aIm;
        int errCode;
        b kjR;
        com.tencent.mm.plugin.card.d.c kjS;

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    public interface d {
        void GQ(String str);

        void b(com.tencent.mm.plugin.card.base.b bVar);

        void bco();

        void bcp();

        void bcq();

        void bcr();

        void bcs();

        void bct();

        void bcu();

        void fJ(boolean z);
    }

    public e(CardDetailBaseUI cardDetailBaseUI, View view) {
        AppMethodBeat.i(88349);
        this.kjd = cardDetailBaseUI;
        this.jcl = view;
        AppMethodBeat.o(88349);
    }

    public final void a(com.tencent.mm.plugin.card.base.b bVar, a aVar, ArrayList<od> arrayList) {
        this.kaS = bVar;
        this.kjF = aVar;
        this.kaY = arrayList;
    }

    public final View findViewById(int i) {
        AppMethodBeat.i(88350);
        View findViewById = this.jcl.findViewById(i);
        AppMethodBeat.o(88350);
        return findViewById;
    }

    public final com.tencent.mm.plugin.card.base.b bcv() {
        return this.kaS;
    }

    public final void b(com.tencent.mm.plugin.card.base.b bVar) {
        AppMethodBeat.i(88351);
        if (bVar != null) {
            this.kaS = bVar;
            if (this.kjE != null) {
                this.kjE.b(bVar);
            }
            bbB();
        }
        AppMethodBeat.o(88351);
    }

    public final boolean bcw() {
        return this.kjg;
    }

    public final void bcx() {
        this.kjg = false;
    }

    public final MMActivity bcy() {
        return this.kjd;
    }

    public final OnClickListener bcz() {
        return this.gKK;
    }

    public final com.tencent.mm.plugin.card.ui.a.g bcA() {
        return this.kje;
    }

    public final d bcB() {
        return this.kjE;
    }

    public final a bcC() {
        return this.kjF;
    }

    public final f bcD() {
        return this.kjy;
    }

    public final j bcE() {
        return this.kjw;
    }

    public final String getString(int i) {
        AppMethodBeat.i(88352);
        String string = this.kjd.getString(i);
        AppMethodBeat.o(88352);
        return string;
    }

    public final void bbB() {
        AppMethodBeat.i(88354);
        if (this.kaS == null) {
            ab.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo == null");
            if (this.kjE != null) {
                this.kjE.bcs();
            }
            AppMethodBeat.o(88354);
        } else if (this.kaS.aZV() == null) {
            ab.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getCardTpInfo() == null");
            if (this.kjE != null) {
                this.kjE.bcs();
            }
            AppMethodBeat.o(88354);
        } else if (this.kaS.aZW() == null) {
            ab.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getDataInfo() == null");
            if (this.kjE != null) {
                this.kjE.bcs();
            }
            AppMethodBeat.o(88354);
        } else if (this.kaS.aZI()) {
            ab.i("MicroMsg.CardDetailUIContoller", "doUpdate()");
            ab.i("MicroMsg.CardDetailUIContoller", "doUpdate() showAcceptView:" + this.kaS.aZV().vUx);
            this.kjy.a(this.kaS, this.kaY, this.kjF.emC);
            bcF();
            this.kje.bee();
            ab.i("MicroMsg.CardDetailUIContoller", "");
            updateTitle();
            bcJ();
            if (this.kje.bdN()) {
                ab.i("MicroMsg.CardDetailUIContoller", "updateShareUsersInfoLayout()");
                this.kjf.update();
            } else {
                ab.i("MicroMsg.CardDetailUIContoller", "don't updateShareUsersInfoLayout()");
                this.kjf.bes();
            }
            if (this.kje.bdE()) {
                if (this.kjv == null) {
                    this.kjv = new com.tencent.mm.plugin.card.ui.view.b();
                    this.kjv.a(this);
                }
                ab.i("MicroMsg.CardDetailUIContoller", "update CardAcceptView()");
                this.kjv.update();
            } else {
                ab.i("MicroMsg.CardDetailUIContoller", "don't update CardAcceptView()");
                if (this.kjv != null) {
                    this.kjv.bes();
                }
            }
            this.kjd.fH(this.kje.bdI());
            if (this.kje.bdJ()) {
                bcP();
            }
            if (this.kje.bdK()) {
                bcQ();
            }
            if (this.kje.bdL()) {
                bcR();
            }
            bcN();
            x(this.kje.bdG(), this.kje.bdH());
            if (!this.kaS.aZD() && this.kje.bdP()) {
                ab.i("MicroMsg.CardDetailUIContoller", "update mFromUserView");
                this.kjh.update();
            } else if (this.kaS.aZD() && this.kje.bdP()) {
                ab.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout for username");
                this.kji.update();
            } else if (this.kje.bdQ()) {
                ab.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout");
                this.kji.update();
            } else {
                ab.i("MicroMsg.CardDetailUIContoller", "don't update mFromUserView and mAcceptHeaderLayout");
                this.kji.bes();
                this.kjh.bes();
            }
            if (this.kjj != null) {
                this.kjj.fM(this.kje.bcT());
            }
            bcH();
            if (this.kje.bdU()) {
                if (this.kjn == null) {
                    this.kjn = new y();
                    this.kjn.a(this);
                }
                ab.i("MicroMsg.CardDetailUIContoller", "update CardStatusView");
                this.kjn.update();
            } else {
                ab.i("MicroMsg.CardDetailUIContoller", "don't update CardStatusView");
                if (this.kjn != null) {
                    this.kjn.bes();
                }
            }
            if (this.kje.bed()) {
                if (this.kjm == null) {
                    this.kjm = new com.tencent.mm.plugin.card.ui.view.c();
                    this.kjm.a(this);
                }
                ab.i("MicroMsg.CardDetailUIContoller", "update mAdtitleView()");
                this.kjm.update();
            } else {
                ab.i("MicroMsg.CardDetailUIContoller", "don't update AdTitleView()");
                if (this.kjm != null) {
                    this.kjm.bes();
                }
            }
            if (this.kje.bdV()) {
                if (this.kjo == null) {
                    this.kjo = new k();
                    this.kjo.a(this);
                }
                ab.i("MicroMsg.CardDetailUIContoller", "update mCardDetailFieldView()");
                this.kjo.update();
            } else {
                ab.i("MicroMsg.CardDetailUIContoller", "don't update mCardDetailFieldView()");
                if (this.kjo != null) {
                    this.kjo.bes();
                }
            }
            if (this.kje.bdW()) {
                if (this.kjp == null) {
                    this.kjp = new w();
                    this.kjp.a(this);
                }
                ab.i("MicroMsg.CardDetailUIContoller", "update CardSecondaryFieldView");
                this.kjp.update();
            } else {
                ab.i("MicroMsg.CardDetailUIContoller", "don't update CardSecondaryFieldView");
                if (this.kjp != null) {
                    this.kjp.bes();
                }
            }
            if (this.kje.bdX()) {
                if (this.kjq == null) {
                    this.kjq = new com.tencent.mm.plugin.card.ui.view.l();
                    this.kjq.a(this);
                }
                ab.i("MicroMsg.CardDetailUIContoller", "update CardDetailTableView");
                this.kjq.update();
            } else {
                ab.i("MicroMsg.CardDetailUIContoller", "don't update CardDetailTableView");
                if (this.kjq != null) {
                    this.kjq.bes();
                }
            }
            if (this.kje.bdY()) {
                if (this.kjr == null) {
                    this.kjr = new z();
                    this.kjr.a(this);
                }
                ab.i("MicroMsg.CardDetailUIContoller", "update CardThirdFieldView");
                this.kjr.update();
            } else {
                ab.i("MicroMsg.CardDetailUIContoller", "don't update CardThirdFieldView");
                if (this.kjr != null) {
                    this.kjr.bes();
                }
            }
            if (this.kje.bea()) {
                if (this.kjs == null) {
                    this.kjs = new com.tencent.mm.plugin.card.ui.view.e();
                    this.kjs.a(this);
                }
                ab.i("MicroMsg.CardDetailUIContoller", "updateCardAnnoucementView");
                this.kjs.update();
            } else {
                ab.i("MicroMsg.CardDetailUIContoller", "don't updateCardAnnoucementView");
                if (this.kjs != null) {
                    this.kjs.bes();
                }
            }
            if (this.kje.bdZ()) {
                if (this.kjt == null) {
                    this.kjt = new u();
                    this.kjt.a(this);
                }
                ab.i("MicroMsg.CardDetailUIContoller", "updateCardOperateFieldView");
                this.kjt.update();
            } else {
                ab.i("MicroMsg.CardDetailUIContoller", "don't updateCardOperateFieldView");
                if (this.kjt != null) {
                    this.kjt.bes();
                }
            }
            bcI();
            if (this.kje.bdS()) {
                bcO();
                if (this.kje.bdT()) {
                    if (this.kjk == null) {
                        bcG();
                        this.kjk.a(this);
                        this.kjk.update();
                    } else if (this.kjk.f(this.kaS)) {
                        this.kjk.b(this.kaS);
                        this.kjk.update();
                    }
                } else if (this.kjk != null) {
                    this.kjk.bex();
                }
                if (this.kjj != null) {
                    this.kjj.fL(true);
                }
            } else {
                ab.e("MicroMsg.CardDetailUIContoller", "don't update CardCodeView");
                if (this.kjk != null) {
                    this.kjk.bex();
                }
                if (this.kjj != null) {
                    this.kjj.fL(false);
                }
            }
            if (this.kje.beb()) {
                ab.i("MicroMsg.CardDetailUIContoller", "update CardAdvertiseView");
                this.kju.update();
            } else {
                ab.i("MicroMsg.CardDetailUIContoller", "don't update CardAdvertiseView");
                this.kju.bes();
            }
            this.kjw.kaS = this.kaS;
            AppMethodBeat.o(88354);
        } else {
            ab.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, not support card type :%d", Integer.valueOf(this.kaS.aZV().iAd));
            if (TextUtils.isEmpty(this.kaS.aZV().vUc)) {
                com.tencent.mm.ui.base.h.a(this.kjd, getString(R.string.agb), null, false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(88336);
                        dialogInterface.dismiss();
                        if (e.this.kjE != null) {
                            e.this.kjE.bcs();
                        }
                        AppMethodBeat.o(88336);
                    }
                });
            } else {
                com.tencent.mm.plugin.card.d.b.a(this.kjd, this.kaS.aZV().vUc, 0);
                if (this.kjE != null) {
                    this.kjE.bcs();
                    AppMethodBeat.o(88354);
                    return;
                }
            }
            AppMethodBeat.o(88354);
        }
    }

    public final void c(com.tencent.mm.plugin.card.d.c cVar) {
        AppMethodBeat.i(88355);
        ab.i("MicroMsg.CardDetailUIContoller", "onGetCodeSuccess! do update code view!");
        Message obtain = Message.obtain();
        c cVar2 = new c();
        cVar2.kjR = b.onGetCodeSuccess;
        cVar2.kjS = cVar;
        obtain.obj = cVar2;
        this.kjG.sendMessage(obtain);
        AppMethodBeat.o(88355);
    }

    public final void ap(int i, String str) {
        String string;
        AppMethodBeat.i(88356);
        ab.e("MicroMsg.CardDetailUIContoller", "onGetCodeFail! errCode = %d, errMsg=%s", Integer.valueOf(i), str);
        Message obtain = Message.obtain();
        c cVar = new c();
        cVar.kjR = b.onGetCodeFail;
        cVar.errCode = i;
        if (i == -1) {
            string = getString(R.string.adw);
        } else if (i == 2) {
            string = getString(R.string.ad2);
        } else {
            string = getString(R.string.adv);
        }
        cVar.aIm = string;
        obtain.obj = cVar;
        this.kjG.sendMessage(obtain);
        AppMethodBeat.o(88356);
    }

    public final void baA() {
        AppMethodBeat.i(88357);
        ab.i("MicroMsg.CardDetailUIContoller", "on show TimeExpired! do update refresh code view!");
        Message obtain = Message.obtain();
        c cVar = new c();
        cVar.kjR = b.onShowTimeExpired;
        obtain.obj = cVar;
        this.kjG.sendMessage(obtain);
        AppMethodBeat.o(88357);
    }

    public final void b(com.tencent.mm.plugin.card.d.c cVar) {
        AppMethodBeat.i(88358);
        ab.i("MicroMsg.CardDetailUIContoller", "on onReceiveCodeUnavailable! do update refresh code view!");
        Message obtain = Message.obtain();
        c cVar2 = new c();
        cVar2.kjR = b.onReceiveCodeUnavailable;
        cVar2.kjS = cVar;
        obtain.obj = cVar2;
        this.kjG.sendMessage(obtain);
        AppMethodBeat.o(88358);
    }

    private void bcG() {
        AppMethodBeat.i(88359);
        if (this.kaS.aZV().vUB != null && this.kaS.aZV().vUB.wdu) {
            this.kjk = new com.tencent.mm.plugin.card.ui.view.m();
            am.bbm().a((com.tencent.mm.plugin.card.b.g.a) this);
            AppMethodBeat.o(88359);
        } else if (this.kaS.aZV().iAd == 10) {
            this.kjk = new q();
            AppMethodBeat.o(88359);
        } else {
            this.kjk = new j();
            AppMethodBeat.o(88359);
        }
    }

    private void bcH() {
        AppMethodBeat.i(88360);
        if (this.cAY) {
            ab.i("MicroMsg.CardDetailUIContoller", "updateUIBackground onPause return");
            AppMethodBeat.o(88360);
            return;
        }
        View findViewById;
        LayoutParams layoutParams;
        if (this.kaS.aZB() && this.kaS.aZD()) {
            this.jcl.findViewById(R.id.abq).setBackgroundColor(this.kjd.getResources().getColor(R.color.ir));
            this.kjd.O(-1, true);
        } else {
            int Hn = l.Hn(this.kaS.aZV().color);
            this.jcl.findViewById(R.id.abq).setBackgroundColor(Hn);
            this.kjd.O(Hn, false);
        }
        View findViewById2 = this.jcl.findViewById(R.id.abu);
        View findViewById3 = this.jcl.findViewById(R.id.abv);
        View findViewById4 = this.jcl.findViewById(R.id.abw);
        if (this.kaS.aZB() && this.kje.bdP()) {
            if (this.kaS.aZE()) {
                findViewById2.setBackgroundResource(R.drawable.azw);
                this.jcl.findViewById(R.id.bx9).setBackgroundResource(R.drawable.gm);
                findViewById4.setBackgroundResource(0);
            } else if (this.kaS.aZD()) {
                this.jcl.findViewById(R.id.bx9).setBackgroundResource(0);
                findViewById4.setBackgroundColor(this.kjd.getResources().getColor(R.color.ir));
            } else if (this.kaS.aZF()) {
                findViewById2.setBackgroundResource(R.drawable.azw);
                this.jcl.findViewById(R.id.bx9).setBackgroundResource(R.drawable.gm);
                findViewById4.setBackgroundResource(0);
            } else if (!this.kaS.aZG() && this.kaS.aZH()) {
                findViewById4.setBackgroundColor(this.kjd.getResources().getColor(R.color.ir));
            }
        } else if (this.kaS.aZC()) {
            if (this.kje.bdN() && this.kjg) {
                findViewById2.setBackgroundResource(R.drawable.azw);
                findViewById4.setBackgroundResource(0);
            } else if (!this.kje.bdN() || this.kjg) {
                findViewById2.setBackgroundResource(0);
                if (this.kje.bcT()) {
                    findViewById4.setBackgroundResource(R.drawable.azv);
                } else {
                    findViewById4.setBackgroundResource(R.drawable.azw);
                }
            } else {
                findViewById2.setBackgroundResource(R.drawable.azv);
                findViewById4.setBackgroundResource(0);
            }
        } else if (this.kaS.aZE()) {
            findViewById2.setBackgroundResource(0);
            if (this.kje.bcT()) {
                findViewById4.setBackgroundResource(R.drawable.azv);
            } else {
                findViewById4.setBackgroundResource(R.drawable.azw);
            }
        } else if (this.kaS.aZF()) {
            findViewById2.setBackgroundResource(R.drawable.ha);
            findViewById4.setBackgroundResource(0);
        } else {
            findViewById2.setBackgroundResource(0);
            findViewById4.setBackgroundColor(this.kjd.getResources().getColor(R.color.ir));
        }
        if (this.kaS.aZH()) {
            TextView textView = (TextView) this.jcl.findViewById(R.id.acb);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.LV(R.drawable.azu));
            bitmapDrawable.setTileModeX(TileMode.REPEAT);
            textView.setBackgroundDrawable(bitmapDrawable);
            textView.setVisibility(0);
        }
        Rect rect = new Rect(0, 0, 0, 0);
        findViewById2.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        findViewById2.invalidate();
        findViewById4.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        findViewById4.invalidate();
        if (this.kaS.aZC() && this.kje.bdN() && this.kjg) {
            findViewById = this.jcl.findViewById(R.id.ajn);
            findViewById.setPadding(rect.left, rect.top, rect.right, rect.bottom);
            findViewById.invalidate();
        }
        if (this.kaS.aZB() && this.kje.bdP()) {
            findViewById = this.jcl.findViewById(R.id.bx9);
            rect.left = this.kjd.getResources().getDimensionPixelOffset(R.dimen.l5);
            rect.right = this.kjd.getResources().getDimensionPixelOffset(R.dimen.l5);
            findViewById.setPadding(rect.left, rect.top, rect.right, rect.bottom);
            findViewById.invalidate();
            if (this.kaS.aZF()) {
                findViewById = this.jcl.findViewById(R.id.abs);
                layoutParams = (LayoutParams) findViewById.getLayoutParams();
                int dimensionPixelSize = this.kjd.getResources().getDimensionPixelSize(R.dimen.nc);
                layoutParams.rightMargin = dimensionPixelSize;
                layoutParams.leftMargin = dimensionPixelSize;
                findViewById.setLayoutParams(layoutParams);
            }
        }
        if (this.kje.bdP() || this.kje.bdN()) {
            if (this.kjj != null && ((this.kaS.aZB() && this.kaS.aZE()) || this.kaS.aZC())) {
                this.kjj.tq(0);
            }
        } else if (this.kjj != null && ((this.kaS.aZB() && this.kaS.aZE()) || this.kaS.aZC())) {
            if (this.kje.bcT()) {
                this.kjj.tq(R.drawable.azx);
            } else {
                this.kjj.tq(R.drawable.h9);
            }
        }
        if (this.kjj != null && this.kaS.aZB() && this.kaS.aZD()) {
            this.kjj.a(l.dI(l.Hn(this.kaS.aZV().color), this.kjd.getResources().getDimensionPixelOffset(R.dimen.w1)));
        }
        if (this.kaS.aZB() && this.kaS.aZD()) {
            layoutParams = (LayoutParams) findViewById2.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.leftMargin = 0;
            if (TextUtils.isEmpty(this.kaS.aZV().vUh)) {
                layoutParams.height = 0;
                layoutParams.weight = 1.0f;
            } else {
                layoutParams.weight = 0.0f;
                layoutParams.height = -2;
            }
            findViewById2.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) findViewById3.getLayoutParams();
            int dimensionPixelSize2 = this.kjd.getResources().getDimensionPixelSize(R.dimen.lo);
            layoutParams.rightMargin = dimensionPixelSize2;
            layoutParams.leftMargin = dimensionPixelSize2;
            if (this.kaS.aZD()) {
                layoutParams.topMargin = this.kjd.getResources().getDimensionPixelSize(R.dimen.ld);
                layoutParams.bottomMargin = this.kjd.getResources().getDimensionPixelSize(R.dimen.le);
                dimensionPixelSize2 = this.kjd.getResources().getDimensionPixelSize(R.dimen.l8);
                layoutParams.rightMargin = dimensionPixelSize2;
                layoutParams.leftMargin = dimensionPixelSize2;
            } else {
                dimensionPixelSize2 = this.kjd.getResources().getDimensionPixelSize(R.dimen.dy);
                layoutParams.bottomMargin = dimensionPixelSize2;
                layoutParams.topMargin = dimensionPixelSize2;
            }
            findViewById3.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) findViewById4.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.leftMargin = 0;
            if (this.kaS.aZD()) {
                layoutParams.bottomMargin = this.kjd.getResources().getDimensionPixelSize(R.dimen.l8);
            }
            if (TextUtils.isEmpty(this.kaS.aZV().vUh)) {
                layoutParams.height = 0;
                layoutParams.weight = 1.0f;
            } else {
                layoutParams.weight = 0.0f;
                layoutParams.height = -2;
            }
            findViewById4.setLayoutParams(layoutParams);
            if (!TextUtils.isEmpty(this.kaS.aZV().vUh)) {
                findViewById2 = findViewById(R.id.acc);
                layoutParams = (LayoutParams) findViewById2.getLayoutParams();
                layoutParams.height = 0;
                layoutParams.weight = 1.0f;
                findViewById2.setLayoutParams(layoutParams);
            }
        }
        this.jcl.invalidate();
        AppMethodBeat.o(88360);
    }

    public final void a(boolean z, com.tencent.mm.plugin.card.b.j.b bVar, boolean z2) {
        int i = 1;
        AppMethodBeat.i(88361);
        h hVar;
        Object[] objArr;
        if (z) {
            tm tmVar = this.kaS.aZW().vSj;
            h hVar2;
            Object[] objArr2;
            if (this.kaS.aZP()) {
                com.tencent.mm.plugin.card.d.b.a(this.kjd, bVar.kbK, bVar.kbL, z2, this.kaS);
                h.pYm.e(11941, Integer.valueOf(17), this.kaS.aZZ(), this.kaS.baa(), "", this.kaS.aZW().vSj.title);
                AppMethodBeat.o(88361);
                return;
            } else if (tmVar != null && !TextUtils.isEmpty(tmVar.vTL) && !TextUtils.isEmpty(tmVar.vTM)) {
                com.tencent.mm.plugin.card.d.b.a(this.kaS.aZZ(), tmVar, this.kjF.kgn, this.kjF.kjL);
                hVar2 = h.pYm;
                objArr2 = new Object[5];
                objArr2[0] = Integer.valueOf(6);
                objArr2[1] = this.kaS.aZZ();
                objArr2[2] = this.kaS.baa();
                objArr2[3] = "";
                objArr2[4] = tmVar.title != null ? tmVar.title : "";
                hVar2.e(11941, objArr2);
                AppMethodBeat.o(88361);
                return;
            } else if (tmVar == null || TextUtils.isEmpty(tmVar.url)) {
                hVar = h.pYm;
                objArr = new Object[9];
                objArr[0] = "CardConsumedCodeUI";
                objArr[1] = Integer.valueOf(this.kaS.aZV().iAd);
                objArr[2] = this.kaS.baa();
                objArr[3] = this.kaS.aZZ();
                objArr[4] = Integer.valueOf(0);
                objArr[5] = Integer.valueOf(this.kjF.kgn);
                objArr[6] = this.kjF.kiN;
                if (!this.kaS.aZT()) {
                    i = 0;
                }
                objArr[7] = Integer.valueOf(i);
                objArr[8] = "";
                hVar.e(11324, objArr);
                GR(bVar.kbH);
                AppMethodBeat.o(88361);
                return;
            } else {
                com.tencent.mm.plugin.card.d.b.a(this.kjd, l.A(tmVar.url, tmVar.vUW), 1);
                hVar2 = h.pYm;
                objArr2 = new Object[5];
                objArr2[0] = Integer.valueOf(6);
                objArr2[1] = this.kaS.aZZ();
                objArr2[2] = this.kaS.baa();
                objArr2[3] = "";
                objArr2[4] = tmVar.title != null ? tmVar.title : "";
                hVar2.e(11941, objArr2);
                AppMethodBeat.o(88361);
                return;
            }
        }
        hVar = h.pYm;
        objArr = new Object[9];
        objArr[0] = "CardConsumedCodeUI";
        objArr[1] = Integer.valueOf(this.kaS.aZV().iAd);
        objArr[2] = this.kaS.baa();
        objArr[3] = this.kaS.aZZ();
        objArr[4] = Integer.valueOf(0);
        objArr[5] = Integer.valueOf(this.kjF.kgn);
        objArr[6] = this.kjF.kiN;
        if (!this.kaS.aZT()) {
            i = 0;
        }
        objArr[7] = Integer.valueOf(i);
        objArr[8] = "";
        hVar.e(11324, objArr);
        GR(bVar.kbH);
        AppMethodBeat.o(88361);
    }

    private void x(boolean z, boolean z2) {
        AppMethodBeat.i(88362);
        if (this.kjj != null) {
            this.kjj.x(z, z2);
        }
        AppMethodBeat.o(88362);
    }

    private void updateTitle() {
        AppMethodBeat.i(88363);
        if (this.kje.bdM()) {
            this.kjd.setMMTitle(this.kjy.getTitle());
            AppMethodBeat.o(88363);
            return;
        }
        this.kjd.setMMTitle("");
        AppMethodBeat.o(88363);
    }

    private void bcI() {
        AppMethodBeat.i(88364);
        if (this.kje.bdR()) {
            this.kaW.clear();
            this.kaW.addAll(this.kjy.baw());
            this.kjl.setData(this.kaW);
            this.kjl.kob = this.kaS.aZH();
            this.kjl.notifyDataSetChanged();
            AppMethodBeat.o(88364);
            return;
        }
        ab.i("MicroMsg.CardDetailUIContoller", "card is membership or share card or general coupon, not accept, don't updateCellData()");
        AppMethodBeat.o(88364);
    }

    private void bcJ() {
        AppMethodBeat.i(88365);
        if (this.kaS == null) {
            ab.e("MicroMsg.CardDetailUIContoller", "updateWidget, mCardInfo is null");
            AppMethodBeat.o(88365);
            return;
        }
        if (bcK()) {
            bcM();
        }
        if (this.kjj == null) {
            bcL();
        }
        if (this.kjj != null) {
            if (this.kaS.aZF()) {
                ((com.tencent.mm.plugin.card.widget.f) this.kjj).kaY = this.kaY;
            }
            this.kjj.d(this.kaS);
        }
        AppMethodBeat.o(88365);
    }

    private boolean bcK() {
        AppMethodBeat.i(88366);
        if (this.kjj == null) {
            AppMethodBeat.o(88366);
            return false;
        } else if (this.kaS.aZD()) {
            if (this.kjj instanceof com.tencent.mm.plugin.card.widget.e) {
                AppMethodBeat.o(88366);
                return false;
            }
            AppMethodBeat.o(88366);
            return true;
        } else if (this.kaS.aZG()) {
            if (this.kjj instanceof com.tencent.mm.plugin.card.widget.c) {
                AppMethodBeat.o(88366);
                return false;
            }
            AppMethodBeat.o(88366);
            return true;
        } else if (this.kaS.aZE()) {
            if (this.kjj instanceof com.tencent.mm.plugin.card.widget.b) {
                AppMethodBeat.o(88366);
                return false;
            }
            AppMethodBeat.o(88366);
            return true;
        } else if (this.kaS.aZF()) {
            if (this.kjj instanceof com.tencent.mm.plugin.card.widget.f) {
                AppMethodBeat.o(88366);
                return false;
            }
            AppMethodBeat.o(88366);
            return true;
        } else if (!this.kaS.aZH()) {
            AppMethodBeat.o(88366);
            return false;
        } else if (this.kjj instanceof com.tencent.mm.plugin.card.widget.d) {
            AppMethodBeat.o(88366);
            return false;
        } else {
            AppMethodBeat.o(88366);
            return true;
        }
    }

    private void bcL() {
        AppMethodBeat.i(88367);
        if (this.kaS.aZD()) {
            this.kjj = new com.tencent.mm.plugin.card.widget.e(this.kjd);
        } else if (this.kaS.aZG()) {
            this.kjj = new com.tencent.mm.plugin.card.widget.c(this.kjd);
        } else if (this.kaS.aZE()) {
            this.kjj = new com.tencent.mm.plugin.card.widget.b(this.kjd);
        } else if (this.kaS.aZF()) {
            this.kjj = new com.tencent.mm.plugin.card.widget.f(this.kjd);
        } else if (this.kaS.aZH()) {
            this.kjj = new com.tencent.mm.plugin.card.widget.d(this.kjd);
        } else {
            this.kjj = new com.tencent.mm.plugin.card.widget.b(this.kjd);
        }
        this.kjj.i(this.kaS);
        View hS = this.kjj.hS();
        if (hS != null) {
            m.a(hS, this.lK);
        }
        this.lK.invalidate();
        this.kjj.setOnClickListener(this.gKK);
        x(false, false);
        AppMethodBeat.o(88367);
    }

    private void bcM() {
        AppMethodBeat.i(88368);
        View hS = this.kjj.hS();
        if (hS != null) {
            this.lK.removeView(hS);
        }
        this.lK.removeAllViews();
        this.lK.invalidate();
        this.kjj.release();
        this.kjj = null;
        AppMethodBeat.o(88368);
    }

    private void bcN() {
        AppMethodBeat.i(88369);
        if (this.kjj != null && (this.kjj instanceof com.tencent.mm.plugin.card.widget.b)) {
            ((com.tencent.mm.plugin.card.widget.b) this.kjj).bcN();
        }
        AppMethodBeat.o(88369);
    }

    private void bcO() {
        AppMethodBeat.i(88370);
        this.kaS.a(this.kaS.aZW());
        l.h(this.kaS);
        AppMethodBeat.o(88370);
    }

    private void bcP() {
        int i = 0;
        AppMethodBeat.i(88371);
        this.kjB.clear();
        this.kjD.clear();
        if (this.kaS.aZK()) {
            this.kjD.add(getString(R.string.aij));
            this.kjB.put(Integer.valueOf(0), "menu_func_share_friend");
            this.kjD.add(getString(R.string.aii));
            this.kjB.put(Integer.valueOf(1), "menu_func_share_timeline");
            i = 2;
        }
        if (!TextUtils.isEmpty(this.kaS.aZW().vSf)) {
            this.kjD.add(getString(R.string.ag3));
            this.kjB.put(Integer.valueOf(i), "menu_func_report");
            i++;
        }
        tc(i);
        if (this.kjD.size() > 0) {
            this.kjd.fH(true);
        }
        AppMethodBeat.o(88371);
    }

    private void bcQ() {
        int i = 0;
        AppMethodBeat.i(88372);
        this.kjB.clear();
        this.kjD.clear();
        if (this.kaS.aZB() && this.kaS.aZJ()) {
            if (!bo.isNullOrNil(this.kaS.aZV().vUI)) {
                this.kjD.add(this.kaS.aZV().vUI);
            } else if (this.kaS.aZH()) {
                this.kjD.add(getString(R.string.ag2));
            } else {
                this.kjD.add(getString(R.string.ag1));
            }
            this.kjB.put(Integer.valueOf(0), "menu_func_gift");
            i = 1;
        }
        if (!TextUtils.isEmpty(this.kaS.aZW().vSf)) {
            this.kjD.add(getString(R.string.ag3));
            this.kjB.put(Integer.valueOf(i), "menu_func_report");
            i++;
        }
        if (this.kaS.aZB()) {
            this.kjD.add(getString(R.string.p4));
            this.kjB.put(Integer.valueOf(i), "menu_func_delete");
            i++;
        } else if (this.kaS.aZC()) {
            String Yz = r.Yz();
            String bab = this.kaS.bab();
            if (Yz == null || !Yz.equals(bab)) {
                ab.i("MicroMsg.CardDetailUIContoller", "the card is not belong mine");
            } else {
                this.kjD.add(getString(R.string.p4));
                this.kjB.put(Integer.valueOf(i), "menu_func_delete_share_card");
                i++;
            }
        }
        tc(i);
        if (this.kjD.size() > 0) {
            this.kjd.fH(true);
        }
        AppMethodBeat.o(88372);
    }

    private void bcR() {
        int i = 0;
        AppMethodBeat.i(88373);
        this.kjB.clear();
        this.kjD.clear();
        if (!TextUtils.isEmpty(this.kaS.aZW().vSf)) {
            this.kjD.add(getString(R.string.ag3));
            this.kjB.put(Integer.valueOf(0), "menu_func_report");
            i = 1;
        }
        tc(i);
        if (this.kjD.size() > 0) {
            this.kjd.fH(true);
        }
        AppMethodBeat.o(88373);
    }

    private void tc(int i) {
        AppMethodBeat.i(88374);
        LinkedList linkedList = this.kaS.aZW().vSh;
        if (linkedList == null) {
            AppMethodBeat.o(88374);
            return;
        }
        this.kjC.clear();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < linkedList.size()) {
                ax axVar = (ax) linkedList.get(i3);
                if (!(bo.isNullOrNil(axVar.text) || bo.isNullOrNil(axVar.url))) {
                    this.kjD.add(axVar.text);
                    this.kjB.put(Integer.valueOf(i), axVar.text);
                    this.kjC.put(axVar.text, axVar.url);
                    i++;
                }
                i2 = i3 + 1;
            } else {
                AppMethodBeat.o(88374);
                return;
            }
        }
    }

    public final void c(final int i, int i2, Intent intent) {
        AppMethodBeat.i(88375);
        switch (i) {
            case 0:
            case 1:
            case 4:
                if (i2 == -1 && intent != null) {
                    this.kjz = intent.getStringExtra("Select_Conv_User");
                    final String str = this.kjz;
                    if (this.kaS == null || this.kaS.aZV() == null) {
                        ab.e("MicroMsg.CardDetailUIContoller", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
                        AppMethodBeat.o(88375);
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    if (i == 0) {
                        if (TextUtils.isEmpty(this.kaS.aZX().wYl) || this.kaS.aZH()) {
                            stringBuilder.append(getString(R.string.ens));
                        } else {
                            stringBuilder.append(this.kaS.aZX().wYl);
                        }
                    } else if (i == 1) {
                        stringBuilder.append(getString(R.string.ahl) + this.kjy.getTitle());
                    } else if (i == 4) {
                        stringBuilder.append(getString(R.string.agj) + this.kjy.getTitle());
                    }
                    com.tencent.mm.pluginsdk.ui.applet.t.a.vlq.a(this.kjd.mController, stringBuilder.toString(), this.kaS.aZV().kbV, this.kaS.aZV().title + IOUtils.LINE_SEPARATOR_UNIX + this.kaS.aZV().kdg, true, this.kjd.getResources().getString(R.string.tf), new com.tencent.mm.pluginsdk.ui.applet.q.a() {
                        public final void a(boolean z, String str, int i) {
                            AppMethodBeat.i(88343);
                            if (z) {
                                e.this.kjA = str;
                                e eVar;
                                if (i == 0) {
                                    if (e.this.kjE != null) {
                                        e.this.kjE.GQ(str);
                                    }
                                    h.pYm.e(11582, "OperGift", Integer.valueOf(1), Integer.valueOf(e.this.kaS.aZV().iAd), e.this.kaS.baa(), e.this.kaS.aZZ(), e.this.kjz);
                                    com.tencent.mm.ui.base.h.bQ(e.this.kjd, e.this.kjd.getResources().getString(R.string.aeq));
                                    AppMethodBeat.o(88343);
                                    return;
                                } else if (i == 1) {
                                    eVar = e.this;
                                    eVar.kaS.aZX().wYl = eVar.getString(R.string.ahl) + eVar.kjy.getTitle();
                                    l.a(eVar.kaS, eVar.kjz, eVar.kjF.kiP, 2);
                                    l.dw(eVar.kjA, eVar.kjz);
                                    com.tencent.mm.ui.base.h.bQ(e.this.kjd, e.this.kjd.getResources().getString(R.string.aeq));
                                    AppMethodBeat.o(88343);
                                    return;
                                } else if (i == 4) {
                                    eVar = e.this;
                                    if (TextUtils.isEmpty(eVar.kaS.bab())) {
                                        eVar.kaS.Gi(r.Yz());
                                    }
                                    eVar.kaS.aZX().wYl = eVar.getString(R.string.agj) + eVar.kjy.getTitle();
                                    l.a(eVar.kaS, eVar.kjz, eVar.kjF.kiP, 23);
                                    l.dw(eVar.kjA, eVar.kjz);
                                    h.pYm.e(11582, "OpeRecommendCard", Integer.valueOf(e.this.kjF.emC), Integer.valueOf(e.this.kaS.aZV().iAd), e.this.kaS.baa(), e.this.kaS.aZZ(), e.this.kjz);
                                    com.tencent.mm.ui.base.h.bQ(e.this.kjd, e.this.kjd.getResources().getString(R.string.aeq));
                                }
                            }
                            AppMethodBeat.o(88343);
                        }
                    });
                    AppMethodBeat.o(88375);
                    return;
                }
                break;
            case 2:
                if (i2 != -1) {
                    AppMethodBeat.o(88375);
                    return;
                }
                this.kgP = intent.getIntExtra("Ktag_range_index", 0);
                ab.i("MicroMsg.CardDetailUIContoller", "mPrivateSelelct : %d", Integer.valueOf(this.kgP));
                if (this.kgP >= 2) {
                    this.kgQ = intent.getStringExtra("Klabel_name_list");
                    this.kgR = intent.getStringExtra("Kother_user_name_list");
                    ab.d("MicroMsg.CardDetailUIContoller", "mPrivateSelect : %d, names : %s", Integer.valueOf(this.kgP), this.kgQ);
                    if (TextUtils.isEmpty(this.kgQ) && TextUtils.isEmpty(this.kgR)) {
                        ab.e("MicroMsg.CardDetailUIContoller", "mLabelNameList by getIntent is empty");
                        AppMethodBeat.o(88375);
                        return;
                    }
                    List asList = Arrays.asList(this.kgQ.split(","));
                    this.kgT = l.bl(asList);
                    this.kgS = l.bk(asList);
                    if (this.kgR != null && this.kgR.length() > 0) {
                        this.kgS.addAll(Arrays.asList(this.kgR.split(",")));
                    }
                    if (this.kgT != null) {
                        ab.i("MicroMsg.CardDetailUIContoller", "mPrivateIdsList size is " + this.kgT.size());
                    }
                    if (this.kgS != null) {
                        ab.i("MicroMsg.CardDetailUIContoller", "mPrivateNamesList size is " + this.kgS.size());
                        Iterator it = this.kgS.iterator();
                        while (it.hasNext()) {
                            ab.d("MicroMsg.CardDetailUIContoller", "username : %s", (String) it.next());
                        }
                    }
                    if (this.kgP == 2) {
                        this.kju.Hd(this.kjd.getString(R.string.ah_, new Object[]{bbF()}));
                        AppMethodBeat.o(88375);
                        return;
                    } else if (this.kgP == 3) {
                        this.kju.Hd(this.kjd.getString(R.string.ah9, new Object[]{bbF()}));
                        AppMethodBeat.o(88375);
                        return;
                    } else {
                        this.kju.Hd(this.kjd.getString(R.string.ah8));
                        AppMethodBeat.o(88375);
                        return;
                    }
                }
                this.kju.Hd(this.kjd.getString(R.string.ah8));
                AppMethodBeat.o(88375);
                return;
            case 3:
                if (this.kjE != null) {
                    this.kjE.bcu();
                    break;
                }
                break;
        }
        AppMethodBeat.o(88375);
    }

    private String bbF() {
        AppMethodBeat.i(88376);
        String str;
        if (!TextUtils.isEmpty(this.kgQ) && !TextUtils.isEmpty(this.kgR)) {
            str = this.kgQ + "," + l.Hq(this.kgR);
            AppMethodBeat.o(88376);
            return str;
        } else if (!TextUtils.isEmpty(this.kgQ)) {
            str = this.kgQ;
            AppMethodBeat.o(88376);
            return str;
        } else if (TextUtils.isEmpty(this.kgR)) {
            str = "";
            AppMethodBeat.o(88376);
            return str;
        } else {
            str = l.Hq(this.kgR);
            AppMethodBeat.o(88376);
            return str;
        }
    }

    private void GR(String str) {
        AppMethodBeat.i(88377);
        Intent intent = new Intent();
        if (this.kaS instanceof CardInfo) {
            intent.putExtra("key_card_info_data", (CardInfo) this.kaS);
        } else if (this.kaS instanceof ShareCardInfo) {
            intent.putExtra("key_card_info_data", (ShareCardInfo) this.kaS);
        }
        intent.setClass(this.kjd, CardConsumeCodeUI.class);
        intent.putExtra("key_from_scene", this.kjF.emC);
        intent.putExtra("key_previous_scene", this.kjF.kgn);
        intent.putExtra("key_mark_user", str);
        intent.putExtra("key_from_appbrand_type", this.kjF.kjL);
        this.kjd.startActivityForResult(intent, 3);
        this.kjd.ifE = this;
        AppMethodBeat.o(88377);
    }

    public final int bcS() {
        AppMethodBeat.i(88378);
        if (this.kjy == null) {
            AppMethodBeat.o(88378);
            return 0;
        } else if (this.kjy.bay()) {
            AppMethodBeat.o(88378);
            return 1;
        } else {
            AppMethodBeat.o(88378);
            return 0;
        }
    }

    public final boolean bcT() {
        AppMethodBeat.i(88379);
        if (this.kje == null) {
            AppMethodBeat.o(88379);
            return false;
        }
        boolean bcT = this.kje.bcT();
        AppMethodBeat.o(88379);
        return bcT;
    }

    private void bcF() {
        int i;
        AppMethodBeat.i(88353);
        if (this.kje == null) {
            i = 0;
        } else if (this.kaS.aZC()) {
            if (this.kje instanceof com.tencent.mm.plugin.card.ui.a.h) {
                i = 0;
            } else {
                i = 1;
            }
        } else if (this.kaS.aZD()) {
            if (this.kje instanceof com.tencent.mm.plugin.card.ui.a.e) {
                i = 0;
            } else {
                i = 1;
            }
        } else if (this.kaS.aZG()) {
            if (this.kje instanceof com.tencent.mm.plugin.card.ui.a.b) {
                i = 0;
            } else {
                i = 1;
            }
        } else if (this.kaS.aZE()) {
            if (this.kje instanceof com.tencent.mm.plugin.card.ui.a.c) {
                i = 0;
            } else {
                i = 1;
            }
        } else if (this.kaS.aZF()) {
            if (this.kje instanceof com.tencent.mm.plugin.card.ui.a.f) {
                i = 0;
            } else {
                i = 1;
            }
        } else if (this.kaS.aZH()) {
            if (this.kje instanceof com.tencent.mm.plugin.card.ui.a.d) {
                i = 0;
            } else {
                i = 1;
            }
        } else if (this.kje instanceof com.tencent.mm.plugin.card.ui.a.a) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            this.kje.release();
            this.kje = null;
            ab.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, need recreate show logic, card_type:%d", Integer.valueOf(this.kaS.aZV().iAd));
        }
        if (this.kje == null) {
            ab.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, mCardShowLogic == null, card_type:%d", Integer.valueOf(this.kaS.aZV().iAd));
            ab.i("MicroMsg.CardDetailUIContoller", "createShowLogic, card_type:%d", Integer.valueOf(this.kaS.aZV().iAd));
            if (!this.kaS.aZC()) {
                switch (this.kaS.aZV().iAd) {
                    case 0:
                        this.kje = new com.tencent.mm.plugin.card.ui.a.c(this.kjd);
                        break;
                    case 10:
                        this.kje = new com.tencent.mm.plugin.card.ui.a.e(this.kjd);
                        break;
                    case 11:
                        this.kje = new com.tencent.mm.plugin.card.ui.a.b(this.kjd);
                        break;
                    case 20:
                        this.kje = new com.tencent.mm.plugin.card.ui.a.f(this.kjd);
                        break;
                    case 30:
                        this.kje = new com.tencent.mm.plugin.card.ui.a.d(this.kjd);
                        break;
                    default:
                        this.kje = new com.tencent.mm.plugin.card.ui.a.a(this.kjd);
                        break;
                }
            }
            this.kje = new com.tencent.mm.plugin.card.ui.a.h(this.kjd);
        }
        ab.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, card_tye:%d", Integer.valueOf(this.kaS.aZV().iAd));
        this.kje.a(this.kaS, this.kjF);
        AppMethodBeat.o(88353);
    }

    static /* synthetic */ void a(e eVar) {
        int i;
        AppMethodBeat.i(88380);
        Intent intent = new Intent();
        if (eVar.kaS instanceof CardInfo) {
            intent.putExtra("key_card_info_data", (CardInfo) eVar.kaS);
        } else if (eVar.kaS instanceof ShareCardInfo) {
            intent.putExtra("key_card_info_data", (ShareCardInfo) eVar.kaS);
        }
        intent.putExtra("key_from_appbrand_type", eVar.kjF.kjL);
        intent.setClass(eVar.kjd, CardShopUI.class);
        eVar.kjd.startActivity(intent);
        h hVar = h.pYm;
        Object[] objArr = new Object[9];
        objArr[0] = "UsedStoresView";
        objArr[1] = Integer.valueOf(eVar.kaS.aZV().iAd);
        objArr[2] = eVar.kaS.baa();
        objArr[3] = eVar.kaS.aZZ();
        objArr[4] = Integer.valueOf(0);
        objArr[5] = Integer.valueOf(eVar.kjF.kgn);
        objArr[6] = eVar.kjF.kiN;
        if (eVar.kaS.aZT()) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[7] = Integer.valueOf(i);
        objArr[8] = "";
        hVar.e(11324, objArr);
        AppMethodBeat.o(88380);
    }
}
