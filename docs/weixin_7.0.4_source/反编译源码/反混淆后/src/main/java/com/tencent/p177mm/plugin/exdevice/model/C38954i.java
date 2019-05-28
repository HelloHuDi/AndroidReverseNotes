package com.tencent.p177mm.plugin.exdevice.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.plugin.exdevice.p956h.C11648b;
import com.tencent.p177mm.plugin.exdevice.p956h.C27837c;
import com.tencent.p177mm.protocal.protobuf.aga;
import com.tencent.p177mm.protocal.protobuf.asq;
import com.tencent.p177mm.protocal.protobuf.asr;
import com.tencent.p177mm.protocal.protobuf.bce;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.exdevice.model.i */
public enum C38954i implements C1202f {
    ;
    
    private ProgressDialog ehJ;
    private boolean ltp;
    public C34037a ltq;

    /* renamed from: com.tencent.mm.plugin.exdevice.model.i$a */
    public interface C34037a {
        /* renamed from: gM */
        void mo35799gM(boolean z);
    }

    static {
        AppMethodBeat.m2505o(19305);
    }

    private C38954i(String str) {
        AppMethodBeat.m2504i(19299);
        this.ltp = false;
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("exdevice_pref", 0);
        StringBuilder stringBuilder = new StringBuilder();
        C9638aw.m17190ZK();
        if (sharedPreferences.getLong(stringBuilder.append(C18628c.m29064QF()).toString(), 0) != 0) {
            C4990ab.m7417i("MicroMsg.exdevice.GetBoundDeviceLogic", "this user has get bound device, last time is %d", Long.valueOf(sharedPreferences.getLong(stringBuilder.append(C18628c.m29064QF()).toString(), 0)));
            AppMethodBeat.m2505o(19299);
            return;
        }
        C4990ab.m7416i("MicroMsg.exdevice.GetBoundDeviceLogic", "the user has not get bound device yet");
        AppMethodBeat.m2505o(19299);
    }

    /* renamed from: a */
    public final void mo61833a(Context context, final C34037a c34037a) {
        AppMethodBeat.m2504i(19300);
        C4990ab.m7416i("MicroMsg.exdevice.GetBoundDeviceLogic", "startGetBoundHardDevices");
        if (this.ltp) {
            if (this.ltq == null) {
                this.ltq = c34037a;
            }
            C4990ab.m7416i("MicroMsg.exdevice.GetBoundDeviceLogic", "getting bound device now, just leave");
            AppMethodBeat.m2505o(19300);
            return;
        }
        final C1207m c27854o = new C27854o();
        if (!(context == null || !(context instanceof Activity) || ((Activity) context).isFinishing())) {
            if (this.ehJ != null && this.ehJ.isShowing()) {
                this.ehJ.dismiss();
            }
            context.getString(C25738R.string.f9238tz);
            this.ehJ = C30379h.m48457b(context, context.getString(C25738R.string.dy4), new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(19295);
                    C9638aw.m17182Rg().mo14547c(c27854o);
                    C38954i.this.ehJ.dismiss();
                    C38954i.this.ltp = false;
                    if (c34037a != null) {
                        c34037a.mo35799gM(false);
                    }
                    C38954i.this.ehJ = null;
                    AppMethodBeat.m2505o(19295);
                }
            });
        }
        this.ltq = c34037a;
        C9638aw.m17182Rg().mo14541a(c27854o, 0);
        AppMethodBeat.m2505o(19300);
    }

    /* renamed from: gN */
    public final boolean mo61834gN(boolean z) {
        AppMethodBeat.m2504i(19301);
        if (this.ltp) {
            C4990ab.m7416i("MicroMsg.exdevice.GetBoundDeviceLogic", "Getting bound device now, just leave");
            AppMethodBeat.m2505o(19301);
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("exdevice_pref", 0);
        StringBuilder stringBuilder = new StringBuilder();
        C9638aw.m17190ZK();
        long j = sharedPreferences.getLong(stringBuilder.append(C18628c.m29064QF()).toString(), 0);
        if (z || currentTimeMillis - j >= 86400000) {
            AppMethodBeat.m2505o(19301);
            return true;
        }
        C4990ab.m7416i("MicroMsg.exdevice.GetBoundDeviceLogic", "GetBoundHardDevices not now pp");
        AppMethodBeat.m2505o(19301);
        return false;
    }

    /* renamed from: hN */
    public static void m66126hN(long j) {
        AppMethodBeat.m2504i(19302);
        C4990ab.m7417i("MicroMsg.exdevice.GetBoundDeviceLogic", "update get bound hard device time : %d", Long.valueOf(j));
        Editor edit = C4996ah.getContext().getSharedPreferences("exdevice_pref", 0).edit();
        StringBuilder stringBuilder = new StringBuilder();
        C9638aw.m17190ZK();
        edit.putLong(stringBuilder.append(C18628c.m29064QF()).toString(), j).commit();
        AppMethodBeat.m2505o(19302);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(19303);
        C4990ab.m7416i("MicroMsg.exdevice.GetBoundDeviceLogic", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
        this.ltp = false;
        if (c1207m != null && i2 == 0 && i == 0) {
            C4990ab.m7417i("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s", Integer.valueOf(c1207m.getType()));
            if (c1207m.getType() == 539) {
                if (i == 0 && i2 == 0) {
                    aga aga;
                    C27854o c27854o = (C27854o) c1207m;
                    if (c27854o.ehh == null || c27854o.ehh.fsH.fsP == null) {
                        aga = null;
                    } else {
                        aga = (aga) c27854o.ehh.fsH.fsP;
                    }
                    if (aga == null || aga.wna == null) {
                        if (this.ltq != null) {
                            this.ltq.mo35799gM(false);
                        }
                        if (this.ehJ != null && this.ehJ.isShowing()) {
                            this.ehJ.dismiss();
                        }
                        AppMethodBeat.m2505o(19303);
                        return;
                    }
                    C9638aw.m17180RS().mo10302aa(new Runnable() {
                        /* JADX WARNING: Removed duplicated region for block: B:7:0x0038  */
                        /* JADX WARNING: Removed duplicated region for block: B:11:0x0045  */
                        /* JADX WARNING: Removed duplicated region for block: B:24:0x00b1  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void run() {
                            AppMethodBeat.m2504i(19296);
                            C38954i.m66126hN(C5046bo.anU());
                            C27837c boW = C45891ad.boW();
                            LinkedList<C11648b> linkedList = new LinkedList();
                            Cursor baR = boW.baR();
                            Iterator it;
                            if (baR == null || !baR.moveToFirst()) {
                                if (baR != null) {
                                    baR.close();
                                }
                                for (C11648b c11648b : linkedList) {
                                    int i;
                                    Iterator it2 = aga.wna.iterator();
                                    while (it2.hasNext()) {
                                        asq asq = ((bce) it2.next()).vLi;
                                        if (c11648b.field_deviceType.equals(asq.vIk) && c11648b.field_deviceID.equals(asq.jBE)) {
                                            i = 1;
                                            break;
                                        }
                                    }
                                    i = 0;
                                    if (i == 0) {
                                        C4990ab.m7411d("MicroMsg.exdevice.GetBoundDeviceLogic", "delete deviceId %s, deviceType %s ", c11648b.field_deviceID, c11648b.field_deviceType);
                                        C38954i.m66125d(c11648b);
                                        C45891ad.boW().mo45708dU(c11648b.field_deviceID, c11648b.field_deviceType);
                                        C45891ad.bph();
                                        C20495e.m31662aw(c11648b.field_deviceID, false);
                                    }
                                }
                                it = aga.wna.iterator();
                                while (it.hasNext()) {
                                    bce bce = (bce) it.next();
                                    asr asr = bce.vLj;
                                    asq asq2 = bce.vLi;
                                    if (!(asq2 == null || asr == null || C5046bo.isNullOrNil(asq2.jBE))) {
                                        C4990ab.m7417i("MicroMsg.exdevice.GetBoundDeviceLogic", "ModHardDevice deviceId = %s, deviceType = %s, BindFlag = %s", asq2.jBE, asq2.vIk, Integer.valueOf(bce.wGJ));
                                        C11648b Kv = C45891ad.boW().mo45701Kv(asq2.jBE);
                                        if (2 == bce.wGJ) {
                                            C4990ab.m7421w("MicroMsg.exdevice.GetBoundDeviceLogic", "This Device is unbind, Just leave. deviceId = %s, mac = %s, brandName = %s", asq2.jBE, asr.vKF, asr.wwm);
                                            if (Kv != null) {
                                                C38954i.m66125d(Kv);
                                                C45891ad.boW().mo45708dU(Kv.field_deviceID, Kv.field_deviceType);
                                                C45891ad.bph();
                                                C20495e.m31662aw(Kv.field_deviceID, false);
                                            }
                                        } else {
                                            boolean b;
                                            C11648b c11648b2 = new C11648b();
                                            c11648b2.field_deviceID = asq2.jBE;
                                            c11648b2.field_deviceType = asq2.vIk;
                                            c11648b2.field_connProto = asr.wwn;
                                            c11648b2.field_connStrategy = asr.wwo;
                                            c11648b2.field_closeStrategy = asr.wwp;
                                            if (!(asr.dFp != 2 || Kv == null || Kv.dFl == null)) {
                                                asr.guS = Kv.dFl;
                                            }
                                            c11648b2.mo60557iy(asr.guS);
                                            c11648b2.mo60562jp(asr.wwv);
                                            c11648b2.mo60561jo(asr.wwu);
                                            c11648b2.mo60560jn(asr.wwt);
                                            c11648b2.mo60555hV(asr.www);
                                            c11648b2.mo60558jl(asr.IconUrl);
                                            c11648b2.mo60559jm(asr.mZj);
                                            c11648b2.mo60556hW(asr.dFp);
                                            c11648b2.mo60554eH(asr.dFq);
                                            c11648b2.mo60563jq(asr.dFr);
                                            c11648b2.mo60564jr(asr.dFs);
                                            c11648b2.mo60565js(asr.dFt);
                                            c11648b2.mo60566jt(asr.dFu);
                                            c11648b2.field_url = "";
                                            c11648b2.field_mac = C42992b.m76346KK(C42992b.m76347KL(asr.vKF));
                                            c11648b2.field_md5Str = C1178g.m2591x(new String(asq2.vIk + asq2.jBE).getBytes());
                                            c11648b2.field_authKey = asr.vHO;
                                            c11648b2.field_brandName = asr.wwm;
                                            if (c11648b2.field_mac == 0) {
                                                c11648b2.field_mac = System.currentTimeMillis();
                                            }
                                            if (Kv == null) {
                                                b = C45891ad.boW().mo10101b((C4925c) c11648b2);
                                                if (b) {
                                                    C45891ad.bph();
                                                    C20495e.m31662aw(c11648b2.field_deviceID, true);
                                                }
                                            } else {
                                                b = C45891ad.boW().mo45709e(c11648b2) != 0;
                                            }
                                            C4990ab.m7417i("MicroMsg.exdevice.GetBoundDeviceLogic", "insert HardDeviceInfo %s, brandName = %s, deviceID = %s, deviceType = %s, connProto = %s, connStrategy = %s, closeStrategy = %s, mac = %s", Boolean.valueOf(b), c11648b2.field_brandName, c11648b2.field_deviceID, asq2.vIk, c11648b2.field_connProto, Integer.valueOf(c11648b2.field_connStrategy), Integer.valueOf(c11648b2.field_closeStrategy), Long.valueOf(c11648b2.field_mac));
                                        }
                                    }
                                }
                                AppMethodBeat.m2505o(19296);
                            }
                            do {
                                C11648b c11648b3 = new C11648b();
                                c11648b3.mo8995d(baR);
                                linkedList.add(c11648b3);
                            } while (baR.moveToNext());
                            if (baR != null) {
                            }
                            for (C11648b c11648b4 : linkedList) {
                            }
                            it = aga.wna.iterator();
                            while (it.hasNext()) {
                            }
                            AppMethodBeat.m2505o(19296);
                        }
                    });
                    if (this.ltq != null) {
                        this.ltq.mo35799gM(true);
                    }
                } else {
                    C4990ab.m7413e("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s, %s, %s", Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                    if (this.ltq != null) {
                        this.ltq.mo35799gM(false);
                    }
                    if (this.ehJ != null && this.ehJ.isShowing()) {
                        this.ehJ.dismiss();
                    }
                    AppMethodBeat.m2505o(19303);
                    return;
                }
            }
            if (this.ehJ != null && this.ehJ.isShowing()) {
                this.ehJ.dismiss();
            }
            AppMethodBeat.m2505o(19303);
            return;
        }
        C4990ab.m7413e("MicroMsg.exdevice.GetBoundDeviceLogic", "do scene failed : %d, %d", Integer.valueOf(i2), Integer.valueOf(i));
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        AppMethodBeat.m2505o(19303);
    }
}
