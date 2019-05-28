package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.b.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.QFadeImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class aq {
    public static int ruA = -1;
    public static int[] run = new int[]{0, 0, 1, 3, 6, 9};
    public static int[] ruo = new int[]{R.id.ej8};
    public static int[] rup = new int[]{R.id.ej8, R.id.emn, R.id.emo};
    public static int[] ruq = new int[]{R.id.ej8, R.id.emn, R.id.emo, R.id.emp, R.id.emq, R.id.emr};
    public static int[] rur = new int[]{R.id.ej8, R.id.emn, R.id.emo, R.id.emp, R.id.emq, R.id.emr, R.id.ems, R.id.emt, R.id.emu};
    static double rus = -1.0d;
    static double rut = -1.0d;
    static double ruu = -1.0d;
    static double ruv = -1.0d;
    static double ruw = -1.0d;
    public static int ruz = -1;
    private Context context;
    private LinkedList<LinearLayout> rux = new LinkedList();
    private boolean ruy;

    public aq(Context context) {
        boolean z = false;
        AppMethodBeat.i(39115);
        if (1 == g.Nu().getInt("SnsGroupImageDownloadSwitch", 0)) {
            z = true;
        }
        this.ruy = z;
        this.context = context;
        if ((f.IS_FLAVOR_RED || f.DEBUG) && -1 == ruz) {
            ab.i("MicroMsg.SnsMultiLineImageLineMgr", "inner version, open sns batch image download.");
            ruz = 1;
        }
        AppMethodBeat.o(39115);
    }

    public final void a(PhotosContent photosContent, TimeLineObject timeLineObject, String str, int i, int i2, int i3, boolean z, az azVar, boolean z2) {
        AppMethodBeat.i(39116);
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
            rus = (double) b.b(this.context, 160.0f);
            rut = (double) b.b(this.context, 200.0f);
            ruu = (double) b.b(this.context, 44.0f);
            ruv = (double) b.b(this.context, 66.0f);
            ruw = (double) b.b(this.context, 300.0f);
        }
        int size = linkedList.size();
        if (size == 0) {
            for (size = 0; size < iArr.length; size++) {
                af.cnC().dz(photosContent.DT(size));
                photosContent.DT(size).setPosition(i3);
            }
            photosContent.setVisibility(8);
            AppMethodBeat.o(39116);
            return;
        }
        photosContent.setVisibility(0);
        if (size == 1) {
            for (size = 1; size < iArr.length; size++) {
                TagImageView DT = photosContent.DT(size);
                DT.setVisibility(8);
                af.cnC().dz(DT);
                photosContent.DT(size).setPosition(i3);
            }
            photosContent.DT(0).setVisibility(0);
            a((bau) linkedList.get(0), photosContent.DT(0), str, i, i3, z, azVar, i2, z2);
            AppMethodBeat.o(39116);
            return;
        }
        AppMethodBeat.o(39116);
    }

    public final void a(PhotosContent photosContent, TimeLineObject timeLineObject, String str, int i, int i2, int i3, boolean z, boolean z2, az azVar, List<baw> list, String str2) {
        AppMethodBeat.i(39117);
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
            rus = (double) b.b(this.context, 160.0f);
            rut = (double) b.b(this.context, 200.0f);
            ruu = (double) b.b(this.context, 44.0f);
            ruv = (double) b.b(this.context, 66.0f);
            ruw = (double) b.b(this.context, 300.0f);
        }
        int size = linkedList.size();
        int i4;
        if (size == 0) {
            for (i4 = 0; i4 < iArr.length; i4++) {
                af.cnC().dz(photosContent.DT(i4));
                photosContent.DT(i4).setPosition(i3);
            }
            photosContent.setVisibility(8);
            AppMethodBeat.o(39117);
            return;
        }
        photosContent.setImageViewWidth(af.cnN());
        photosContent.setVisibility(0);
        if (size == 1) {
            for (i4 = 1; i4 < iArr.length; i4++) {
                TagImageView DT = photosContent.DT(i4);
                DT.setVisibility(8);
                af.cnC().dz(DT);
                photosContent.DT(i4).setPosition(i3);
            }
            photosContent.DT(0).setVisibility(0);
            if (list == null || list.size() <= 0) {
                a((bau) linkedList.get(0), photosContent.DT(0), str, i, i3, z2, azVar, i2, false);
                AppMethodBeat.o(39117);
                return;
            }
            a((bau) linkedList.get(0), photosContent.DT(0), str, i, i3, z2, azVar, i2, false, (baw) list.get(0));
            AppMethodBeat.o(39117);
            return;
        }
        c cVar;
        if (ctE()) {
            cVar = null;
        } else {
            cVar = new c(str2, size);
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
                TagImageView DT2 = photosContent.DT(length);
                DT2.setPosition(i3);
                if (length == 0 || length == 1 || length == 3 || length == 4) {
                    DT2.setVisibility(0);
                    arrayList.add(DT2);
                    ao aoVar = new ao();
                    aoVar.czD = str;
                    i5 = i6 - 1;
                    aoVar.index = i6;
                    aoVar.rsl = arrayList;
                    aoVar.rps = z2;
                    aoVar.position = i3;
                    DT2.setTag(aoVar);
                    if (z || !ctE()) {
                        bau = (bau) linkedList.get(aoVar.index);
                        af.cnA().a(bau.Id, cVar);
                        af.cnA().XI(bau.Id);
                        a(bau, DT2, i, azVar);
                    }
                    sparseArray.put(aoVar.index, linkedList.get(aoVar.index));
                    sparseArray2.put(aoVar.index, DT2);
                    i6 = i5;
                } else {
                    DT2.setVisibility(8);
                    af.cnC().dz(DT2);
                }
                length--;
            }
            if (!z && ctE() && sparseArray.size() > 0) {
                a(str2, sparseArray, sparseArray2, i, azVar, size);
            }
            AppMethodBeat.o(39117);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        sparseArray = new SparseArray();
        sparseArray2 = new SparseArray();
        for (i5 = iArr.length - 1; i5 >= 0; i5--) {
            TagImageView DT3 = photosContent.DT(i5);
            DT3.setPosition(i3);
            if (i5 < linkedList.size()) {
                DT3.setVisibility(0);
                arrayList2.add(DT3);
                ao aoVar2 = new ao();
                aoVar2.czD = str;
                aoVar2.index = i5;
                aoVar2.rsl = arrayList2;
                aoVar2.rps = z2;
                aoVar2.position = i3;
                DT3.setTag(aoVar2);
                if (z || !ctE()) {
                    bau = (bau) linkedList.get(aoVar2.index);
                    af.cnA().a(bau.Id, cVar);
                    af.cnA().XI(bau.Id);
                    a(bau, DT3, i, azVar);
                }
                sparseArray.put(aoVar2.index, linkedList.get(aoVar2.index));
                sparseArray2.put(aoVar2.index, DT3);
            } else {
                DT3.setVisibility(8);
                af.cnC().dz(DT3);
            }
        }
        if (!z && ctE() && sparseArray.size() > 0) {
            a(str2, sparseArray, sparseArray2, i, azVar, size);
        }
        AppMethodBeat.o(39117);
    }

    private boolean ctE() {
        AppMethodBeat.i(39118);
        ab.i("MicroMsg.SnsMultiLineImageLineMgr", "enableGroupDownload_cmd: %d.", Integer.valueOf(ruz));
        switch (ruz) {
            case 1:
                ab.i("MicroMsg.SnsMultiLineImageLineMgr", "enforce group download.");
                if (!CdnLogic.getSnsImagePrivateProtocolAvalible()) {
                    CdnLogic.setSnsImagePrivateProtocolAvalible(true);
                }
                AppMethodBeat.o(39118);
                return true;
            case 2:
                ab.i("MicroMsg.SnsMultiLineImageLineMgr", "enforce single download.");
                AppMethodBeat.o(39118);
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
                ab.d("MicroMsg.SnsMultiLineImageLineMgr", "EnablePrivateProtocol: %s, SnsGroupImageDownloadSwitch: %s.", Boolean.valueOf(CdnLogic.getSnsImagePrivateProtocolAvalible()), Boolean.valueOf(this.ruy));
                if (CdnLogic.getSnsImagePrivateProtocolAvalible() && this.ruy) {
                    ab.d("MicroMsg.SnsMultiLineImageLineMgr", "groupDownloadEnable!!!");
                    AppMethodBeat.o(39118);
                    return true;
                }
                ab.d("MicroMsg.SnsMultiLineImageLineMgr", "groupDownloadDisable!!!");
                AppMethodBeat.o(39118);
                return false;
        }
    }

    private static void a(bau bau, QFadeImageView qFadeImageView, int i, az azVar) {
        AppMethodBeat.i(39119);
        af.cnC().b(bau, qFadeImageView, i, azVar);
        AppMethodBeat.o(39119);
    }

    private static void a(String str, SparseArray<bau> sparseArray, SparseArray<View> sparseArray2, int i, az azVar, int i2) {
        AppMethodBeat.i(139042);
        af.cnC().a(str, (SparseArray) sparseArray, (SparseArray) sparseArray2, i, azVar, i2);
        AppMethodBeat.o(139042);
    }

    private static void a(bau bau, QFadeImageView qFadeImageView, String str, int i, int i2, boolean z, az azVar, int i3, boolean z2, baw baw) {
        AppMethodBeat.i(39121);
        if (qFadeImageView == null) {
            ab.e("MicroMsg.SnsMultiLineImageLineMgr", "");
            AppMethodBeat.o(39121);
            return;
        }
        double d;
        ao aoVar = new ao();
        aoVar.czD = str;
        aoVar.index = 0;
        ArrayList arrayList = new ArrayList();
        arrayList.add(qFadeImageView);
        aoVar.rsl = arrayList;
        aoVar.rps = z;
        aoVar.position = i2;
        qFadeImageView.setTag(aoVar);
        double d2 = 0.0d;
        double d3 = 0.0d;
        if (i3 == 10 && z2) {
            af.cnC().c(bau, qFadeImageView, i, azVar);
        } else {
            af.cnC().a(bau, (View) qFadeImageView, i, azVar);
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
                AppMethodBeat.o(39121);
                return;
            }
            qFadeImageView.setLayoutParams(new LayoutParams((int) d, (int) d2));
        }
        AppMethodBeat.o(39121);
    }

    private static void a(bau bau, QFadeImageView qFadeImageView, String str, int i, int i2, boolean z, az azVar, int i3, boolean z2) {
        AppMethodBeat.i(39122);
        a(bau, qFadeImageView, str, i, i2, z, azVar, i3, z2, new baw());
        AppMethodBeat.o(39122);
    }
}
