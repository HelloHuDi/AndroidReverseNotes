package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.widget.QFadeImageView;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C43558b.C39758c;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.protocal.protobuf.baw;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.storage.C44222az;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.aq */
public final class C22067aq {
    public static int ruA = -1;
    public static int[] run = new int[]{0, 0, 1, 3, 6, 9};
    public static int[] ruo = new int[]{2131827766};
    public static int[] rup = new int[]{2131827766, 2131827893, 2131827894};
    public static int[] ruq = new int[]{2131827766, 2131827893, 2131827894, 2131827895, 2131827896, 2131827897};
    public static int[] rur = new int[]{2131827766, 2131827893, 2131827894, 2131827895, 2131827896, 2131827897, 2131827898, 2131827899, 2131827900};
    static double rus = -1.0d;
    static double rut = -1.0d;
    static double ruu = -1.0d;
    static double ruv = -1.0d;
    static double ruw = -1.0d;
    public static int ruz = -1;
    private Context context;
    private LinkedList<LinearLayout> rux = new LinkedList();
    private boolean ruy;

    public C22067aq(Context context) {
        boolean z = false;
        AppMethodBeat.m2504i(39115);
        if (1 == C26373g.m41964Nu().getInt("SnsGroupImageDownloadSwitch", 0)) {
            z = true;
        }
        this.ruy = z;
        this.context = context;
        if ((C5058f.IS_FLAVOR_RED || C5058f.DEBUG) && -1 == ruz) {
            C4990ab.m7416i("MicroMsg.SnsMultiLineImageLineMgr", "inner version, open sns batch image download.");
            ruz = 1;
        }
        AppMethodBeat.m2505o(39115);
    }

    /* renamed from: a */
    public final void mo37628a(PhotosContent photosContent, TimeLineObject timeLineObject, String str, int i, int i2, int i3, boolean z, C44222az c44222az, boolean z2) {
        AppMethodBeat.m2504i(39116);
        int[] iArr = rur;
        if (i2 == 2 || i2 == 10) {
            iArr = ruo;
        } else if (i2 == 3) {
            iArr = rup;
        } else if (i2 == 4) {
            iArr = ruq;
        } else if (i2 == 5) {
            iArr = rur;
        }
        LinkedList linkedList = timeLineObject.xfI.wbK;
        if (rus < 0.0d) {
            rus = (double) C4977b.m7371b(this.context, 160.0f);
            rut = (double) C4977b.m7371b(this.context, 200.0f);
            ruu = (double) C4977b.m7371b(this.context, 44.0f);
            ruv = (double) C4977b.m7371b(this.context, 66.0f);
            ruw = (double) C4977b.m7371b(this.context, 300.0f);
        }
        int size = linkedList.size();
        if (size == 0) {
            for (size = 0; size < iArr.length; size++) {
                C13373af.cnC().mo37462dz(photosContent.mo8755DT(size));
                photosContent.mo8755DT(size).setPosition(i3);
            }
            photosContent.setVisibility(8);
            AppMethodBeat.m2505o(39116);
            return;
        }
        photosContent.setVisibility(0);
        if (size == 1) {
            for (size = 1; size < iArr.length; size++) {
                TagImageView DT = photosContent.mo8755DT(size);
                DT.setVisibility(8);
                C13373af.cnC().mo37462dz(DT);
                photosContent.mo8755DT(size).setPosition(i3);
            }
            photosContent.mo8755DT(0).setVisibility(0);
            C22067aq.m33691a((bau) linkedList.get(0), photosContent.mo8755DT(0), str, i, i3, z, c44222az, i2, z2);
            AppMethodBeat.m2505o(39116);
            return;
        }
        AppMethodBeat.m2505o(39116);
    }

    /* renamed from: a */
    public final void mo37629a(PhotosContent photosContent, TimeLineObject timeLineObject, String str, int i, int i2, int i3, boolean z, boolean z2, C44222az c44222az, List<baw> list, String str2) {
        AppMethodBeat.m2504i(39117);
        int[] iArr = rur;
        if (i2 == 2 || i2 == 10 || i2 == 13) {
            iArr = ruo;
        } else if (i2 == 3) {
            iArr = rup;
        } else if (i2 == 4) {
            iArr = ruq;
        } else if (i2 == 5) {
            iArr = rur;
        }
        LinkedList linkedList = timeLineObject.xfI.wbK;
        if (rus < 0.0d) {
            rus = (double) C4977b.m7371b(this.context, 160.0f);
            rut = (double) C4977b.m7371b(this.context, 200.0f);
            ruu = (double) C4977b.m7371b(this.context, 44.0f);
            ruv = (double) C4977b.m7371b(this.context, 66.0f);
            ruw = (double) C4977b.m7371b(this.context, 300.0f);
        }
        int size = linkedList.size();
        int i4;
        if (size == 0) {
            for (i4 = 0; i4 < iArr.length; i4++) {
                C13373af.cnC().mo37462dz(photosContent.mo8755DT(i4));
                photosContent.mo8755DT(i4).setPosition(i3);
            }
            photosContent.setVisibility(8);
            AppMethodBeat.m2505o(39117);
            return;
        }
        photosContent.setImageViewWidth(C13373af.cnN());
        photosContent.setVisibility(0);
        if (size == 1) {
            for (i4 = 1; i4 < iArr.length; i4++) {
                TagImageView DT = photosContent.mo8755DT(i4);
                DT.setVisibility(8);
                C13373af.cnC().mo37462dz(DT);
                photosContent.mo8755DT(i4).setPosition(i3);
            }
            photosContent.mo8755DT(0).setVisibility(0);
            if (list == null || list.size() <= 0) {
                C22067aq.m33691a((bau) linkedList.get(0), photosContent.mo8755DT(0), str, i, i3, z2, c44222az, i2, false);
                AppMethodBeat.m2505o(39117);
                return;
            }
            C22067aq.m33692a((bau) linkedList.get(0), photosContent.mo8755DT(0), str, i, i3, z2, c44222az, i2, false, (baw) list.get(0));
            AppMethodBeat.m2505o(39117);
            return;
        }
        C39758c c39758c;
        if (ctE()) {
            c39758c = null;
        } else {
            c39758c = new C39758c(str2, size);
        }
        SparseArray sparseArray;
        SparseArray sparseArray2;
        int i5;
        bau bau;
        if (size == 4) {
            ArrayList arrayList = new ArrayList();
            sparseArray = new SparseArray();
            sparseArray2 = new SparseArray();
            int length = iArr.length - 1;
            int i6 = 3;
            while (length >= 0) {
                TagImageView DT2 = photosContent.mo8755DT(length);
                DT2.setPosition(i3);
                if (length == 0 || length == 1 || length == 3 || length == 4) {
                    DT2.setVisibility(0);
                    arrayList.add(DT2);
                    C29190ao c29190ao = new C29190ao();
                    c29190ao.czD = str;
                    i5 = i6 - 1;
                    c29190ao.index = i6;
                    c29190ao.rsl = arrayList;
                    c29190ao.rps = z2;
                    c29190ao.position = i3;
                    DT2.setTag(c29190ao);
                    if (z || !ctE()) {
                        bau = (bau) linkedList.get(c29190ao.index);
                        C13373af.cnA().mo69137a(bau.f17915Id, c39758c);
                        C13373af.cnA().mo69135XI(bau.f17915Id);
                        C22067aq.m33690a(bau, DT2, i, c44222az);
                    }
                    sparseArray.put(c29190ao.index, linkedList.get(c29190ao.index));
                    sparseArray2.put(c29190ao.index, DT2);
                    i6 = i5;
                } else {
                    DT2.setVisibility(8);
                    C13373af.cnC().mo37462dz(DT2);
                }
                length--;
            }
            if (!z && ctE() && sparseArray.size() > 0) {
                C22067aq.m33693a(str2, sparseArray, sparseArray2, i, c44222az, size);
            }
            AppMethodBeat.m2505o(39117);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        sparseArray = new SparseArray();
        sparseArray2 = new SparseArray();
        for (i5 = iArr.length - 1; i5 >= 0; i5--) {
            TagImageView DT3 = photosContent.mo8755DT(i5);
            DT3.setPosition(i3);
            if (i5 < linkedList.size()) {
                DT3.setVisibility(0);
                arrayList2.add(DT3);
                C29190ao c29190ao2 = new C29190ao();
                c29190ao2.czD = str;
                c29190ao2.index = i5;
                c29190ao2.rsl = arrayList2;
                c29190ao2.rps = z2;
                c29190ao2.position = i3;
                DT3.setTag(c29190ao2);
                if (z || !ctE()) {
                    bau = (bau) linkedList.get(c29190ao2.index);
                    C13373af.cnA().mo69137a(bau.f17915Id, c39758c);
                    C13373af.cnA().mo69135XI(bau.f17915Id);
                    C22067aq.m33690a(bau, DT3, i, c44222az);
                }
                sparseArray.put(c29190ao2.index, linkedList.get(c29190ao2.index));
                sparseArray2.put(c29190ao2.index, DT3);
            } else {
                DT3.setVisibility(8);
                C13373af.cnC().mo37462dz(DT3);
            }
        }
        if (!z && ctE() && sparseArray.size() > 0) {
            C22067aq.m33693a(str2, sparseArray, sparseArray2, i, c44222az, size);
        }
        AppMethodBeat.m2505o(39117);
    }

    private boolean ctE() {
        AppMethodBeat.m2504i(39118);
        C4990ab.m7417i("MicroMsg.SnsMultiLineImageLineMgr", "enableGroupDownload_cmd: %d.", Integer.valueOf(ruz));
        switch (ruz) {
            case 1:
                C4990ab.m7416i("MicroMsg.SnsMultiLineImageLineMgr", "enforce group download.");
                if (!CdnLogic.getSnsImagePrivateProtocolAvalible()) {
                    CdnLogic.setSnsImagePrivateProtocolAvalible(true);
                }
                AppMethodBeat.m2505o(39118);
                return true;
            case 2:
                C4990ab.m7416i("MicroMsg.SnsMultiLineImageLineMgr", "enforce single download.");
                AppMethodBeat.m2505o(39118);
                return false;
            default:
                if (-1 != ruA) {
                    boolean z;
                    if (1 == ruA) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.ruy = z;
                }
                C4990ab.m7411d("MicroMsg.SnsMultiLineImageLineMgr", "EnablePrivateProtocol: %s, SnsGroupImageDownloadSwitch: %s.", Boolean.valueOf(CdnLogic.getSnsImagePrivateProtocolAvalible()), Boolean.valueOf(this.ruy));
                if (CdnLogic.getSnsImagePrivateProtocolAvalible() && this.ruy) {
                    C4990ab.m7410d("MicroMsg.SnsMultiLineImageLineMgr", "groupDownloadEnable!!!");
                    AppMethodBeat.m2505o(39118);
                    return true;
                }
                C4990ab.m7410d("MicroMsg.SnsMultiLineImageLineMgr", "groupDownloadDisable!!!");
                AppMethodBeat.m2505o(39118);
                return false;
        }
    }

    /* renamed from: a */
    private static void m33690a(bau bau, QFadeImageView qFadeImageView, int i, C44222az c44222az) {
        AppMethodBeat.m2504i(39119);
        C13373af.cnC().mo37455b(bau, qFadeImageView, i, c44222az);
        AppMethodBeat.m2505o(39119);
    }

    /* renamed from: a */
    private static void m33693a(String str, SparseArray<bau> sparseArray, SparseArray<View> sparseArray2, int i, C44222az c44222az, int i2) {
        AppMethodBeat.m2504i(139042);
        C13373af.cnC().mo37443a(str, (SparseArray) sparseArray, (SparseArray) sparseArray2, i, c44222az, i2);
        AppMethodBeat.m2505o(139042);
    }

    /* renamed from: a */
    private static void m33692a(bau bau, QFadeImageView qFadeImageView, String str, int i, int i2, boolean z, C44222az c44222az, int i3, boolean z2, baw baw) {
        AppMethodBeat.m2504i(39121);
        if (qFadeImageView == null) {
            C4990ab.m7412e("MicroMsg.SnsMultiLineImageLineMgr", "");
            AppMethodBeat.m2505o(39121);
            return;
        }
        double d;
        C29190ao c29190ao = new C29190ao();
        c29190ao.czD = str;
        c29190ao.index = 0;
        ArrayList arrayList = new ArrayList();
        arrayList.add(qFadeImageView);
        c29190ao.rsl = arrayList;
        c29190ao.rps = z;
        c29190ao.position = i2;
        qFadeImageView.setTag(c29190ao);
        double d2 = 0.0d;
        double d3 = 0.0d;
        if (i3 == 10 && z2) {
            C13373af.cnC().mo37458c(bau, qFadeImageView, i, c44222az);
        } else {
            C13373af.cnC().mo37442a(bau, (View) qFadeImageView, i, c44222az);
        }
        if (bau.wEK != null) {
            d2 = (double) bau.wEK.wFx;
            d3 = (double) bau.wEK.wFy;
        }
        if (d2 <= 0.0d || d3 <= 0.0d) {
            d = rus;
            d3 = rus;
        } else {
            d = Math.min(rut / d2, rut / d3);
            d2 *= d;
            d3 *= d;
            if (d2 < ruu) {
                d = (1.0d * ruu) / d2;
                d2 *= d;
                d3 *= d;
            }
            if (d3 < ruu) {
                d = (1.0d * ruu) / d3;
                d2 *= d;
                d3 *= d;
            }
            if (d2 > rut) {
                d2 = rut;
            }
            if (d3 > rut) {
                d3 = rut;
            }
            d = d2;
        }
        if (d < 1.0d) {
            d = 1.0d;
        }
        if (d3 < 1.0d) {
            d3 = 1.0d;
        }
        if (baw == null || baw.wFx <= 0.0f || baw.wFy <= 0.0f) {
            d2 = d3;
        } else {
            d = (double) baw.wFx;
            d2 = (double) baw.wFy;
        }
        if (qFadeImageView.getLayoutParams() instanceof LayoutParams) {
            LayoutParams layoutParams = (LayoutParams) qFadeImageView.getLayoutParams();
            if (((double) layoutParams.width) == d && ((double) layoutParams.height) == d2) {
                AppMethodBeat.m2505o(39121);
                return;
            }
            qFadeImageView.setLayoutParams(new LayoutParams((int) d, (int) d2));
        }
        AppMethodBeat.m2505o(39121);
    }

    /* renamed from: a */
    private static void m33691a(bau bau, QFadeImageView qFadeImageView, String str, int i, int i2, boolean z, C44222az c44222az, int i3, boolean z2) {
        AppMethodBeat.m2504i(39122);
        C22067aq.m33692a(bau, qFadeImageView, str, i, i2, z, c44222az, i3, z2, new baw());
        AppMethodBeat.m2505o(39122);
    }
}
