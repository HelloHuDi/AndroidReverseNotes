package com.tencent.mm.plugin.exdevice.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.protocal.protobuf.asq;
import com.tencent.mm.protocal.protobuf.asr;
import com.tencent.mm.protocal.protobuf.bce;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;

public enum i implements f {
    ;
    
    private ProgressDialog ehJ;
    private boolean ltp;
    public a ltq;

    public interface a {
        void gM(boolean z);
    }

    static {
        AppMethodBeat.o(19305);
    }

    private i(String str) {
        AppMethodBeat.i(19299);
        this.ltp = false;
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("exdevice_pref", 0);
        StringBuilder stringBuilder = new StringBuilder();
        aw.ZK();
        if (sharedPreferences.getLong(stringBuilder.append(c.QF()).toString(), 0) != 0) {
            ab.i("MicroMsg.exdevice.GetBoundDeviceLogic", "this user has get bound device, last time is %d", Long.valueOf(sharedPreferences.getLong(stringBuilder.append(c.QF()).toString(), 0)));
            AppMethodBeat.o(19299);
            return;
        }
        ab.i("MicroMsg.exdevice.GetBoundDeviceLogic", "the user has not get bound device yet");
        AppMethodBeat.o(19299);
    }

    public final void a(Context context, final a aVar) {
        AppMethodBeat.i(19300);
        ab.i("MicroMsg.exdevice.GetBoundDeviceLogic", "startGetBoundHardDevices");
        if (this.ltp) {
            if (this.ltq == null) {
                this.ltq = aVar;
            }
            ab.i("MicroMsg.exdevice.GetBoundDeviceLogic", "getting bound device now, just leave");
            AppMethodBeat.o(19300);
            return;
        }
        final m oVar = new o();
        if (!(context == null || !(context instanceof Activity) || ((Activity) context).isFinishing())) {
            if (this.ehJ != null && this.ehJ.isShowing()) {
                this.ehJ.dismiss();
            }
            context.getString(R.string.tz);
            this.ehJ = h.b(context, context.getString(R.string.dy4), new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(19295);
                    aw.Rg().c(oVar);
                    i.this.ehJ.dismiss();
                    i.this.ltp = false;
                    if (aVar != null) {
                        aVar.gM(false);
                    }
                    i.this.ehJ = null;
                    AppMethodBeat.o(19295);
                }
            });
        }
        this.ltq = aVar;
        aw.Rg().a(oVar, 0);
        AppMethodBeat.o(19300);
    }

    public final boolean gN(boolean z) {
        AppMethodBeat.i(19301);
        if (this.ltp) {
            ab.i("MicroMsg.exdevice.GetBoundDeviceLogic", "Getting bound device now, just leave");
            AppMethodBeat.o(19301);
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("exdevice_pref", 0);
        StringBuilder stringBuilder = new StringBuilder();
        aw.ZK();
        long j = sharedPreferences.getLong(stringBuilder.append(c.QF()).toString(), 0);
        if (z || currentTimeMillis - j >= 86400000) {
            AppMethodBeat.o(19301);
            return true;
        }
        ab.i("MicroMsg.exdevice.GetBoundDeviceLogic", "GetBoundHardDevices not now pp");
        AppMethodBeat.o(19301);
        return false;
    }

    public static void hN(long j) {
        AppMethodBeat.i(19302);
        ab.i("MicroMsg.exdevice.GetBoundDeviceLogic", "update get bound hard device time : %d", Long.valueOf(j));
        Editor edit = ah.getContext().getSharedPreferences("exdevice_pref", 0).edit();
        StringBuilder stringBuilder = new StringBuilder();
        aw.ZK();
        edit.putLong(stringBuilder.append(c.QF()).toString(), j).commit();
        AppMethodBeat.o(19302);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(19303);
        ab.i("MicroMsg.exdevice.GetBoundDeviceLogic", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
        this.ltp = false;
        if (mVar != null && i2 == 0 && i == 0) {
            ab.i("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s", Integer.valueOf(mVar.getType()));
            if (mVar.getType() == 539) {
                if (i == 0 && i2 == 0) {
                    aga aga;
                    o oVar = (o) mVar;
                    if (oVar.ehh == null || oVar.ehh.fsH.fsP == null) {
                        aga = null;
                    } else {
                        aga = (aga) oVar.ehh.fsH.fsP;
                    }
                    if (aga == null || aga.wna == null) {
                        if (this.ltq != null) {
                            this.ltq.gM(false);
                        }
                        if (this.ehJ != null && this.ehJ.isShowing()) {
                            this.ehJ.dismiss();
                        }
                        AppMethodBeat.o(19303);
                        return;
                    }
                    aw.RS().aa(new Runnable() {
                        /* JADX WARNING: Removed duplicated region for block: B:7:0x0038  */
                        /* JADX WARNING: Removed duplicated region for block: B:11:0x0045  */
                        /* JADX WARNING: Removed duplicated region for block: B:24:0x00b1  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void run() {
                            AppMethodBeat.i(19296);
                            i.hN(bo.anU());
                            com.tencent.mm.plugin.exdevice.h.c boW = ad.boW();
                            LinkedList<b> linkedList = new LinkedList();
                            Cursor baR = boW.baR();
                            Iterator it;
                            if (baR == null || !baR.moveToFirst()) {
                                if (baR != null) {
                                    baR.close();
                                }
                                for (b bVar : linkedList) {
                                    int i;
                                    Iterator it2 = aga.wna.iterator();
                                    while (it2.hasNext()) {
                                        asq asq = ((bce) it2.next()).vLi;
                                        if (bVar.field_deviceType.equals(asq.vIk) && bVar.field_deviceID.equals(asq.jBE)) {
                                            i = 1;
                                            break;
                                        }
                                    }
                                    i = 0;
                                    if (i == 0) {
                                        ab.d("MicroMsg.exdevice.GetBoundDeviceLogic", "delete deviceId %s, deviceType %s ", bVar.field_deviceID, bVar.field_deviceType);
                                        i.d(bVar);
                                        ad.boW().dU(bVar.field_deviceID, bVar.field_deviceType);
                                        ad.bph();
                                        e.aw(bVar.field_deviceID, false);
                                    }
                                }
                                it = aga.wna.iterator();
                                while (it.hasNext()) {
                                    bce bce = (bce) it.next();
                                    asr asr = bce.vLj;
                                    asq asq2 = bce.vLi;
                                    if (!(asq2 == null || asr == null || bo.isNullOrNil(asq2.jBE))) {
                                        ab.i("MicroMsg.exdevice.GetBoundDeviceLogic", "ModHardDevice deviceId = %s, deviceType = %s, BindFlag = %s", asq2.jBE, asq2.vIk, Integer.valueOf(bce.wGJ));
                                        b Kv = ad.boW().Kv(asq2.jBE);
                                        if (2 == bce.wGJ) {
                                            ab.w("MicroMsg.exdevice.GetBoundDeviceLogic", "This Device is unbind, Just leave. deviceId = %s, mac = %s, brandName = %s", asq2.jBE, asr.vKF, asr.wwm);
                                            if (Kv != null) {
                                                i.d(Kv);
                                                ad.boW().dU(Kv.field_deviceID, Kv.field_deviceType);
                                                ad.bph();
                                                e.aw(Kv.field_deviceID, false);
                                            }
                                        } else {
                                            boolean b;
                                            b bVar2 = new b();
                                            bVar2.field_deviceID = asq2.jBE;
                                            bVar2.field_deviceType = asq2.vIk;
                                            bVar2.field_connProto = asr.wwn;
                                            bVar2.field_connStrategy = asr.wwo;
                                            bVar2.field_closeStrategy = asr.wwp;
                                            if (!(asr.dFp != 2 || Kv == null || Kv.dFl == null)) {
                                                asr.guS = Kv.dFl;
                                            }
                                            bVar2.iy(asr.guS);
                                            bVar2.jp(asr.wwv);
                                            bVar2.jo(asr.wwu);
                                            bVar2.jn(asr.wwt);
                                            bVar2.hV(asr.www);
                                            bVar2.jl(asr.IconUrl);
                                            bVar2.jm(asr.mZj);
                                            bVar2.hW(asr.dFp);
                                            bVar2.eH(asr.dFq);
                                            bVar2.jq(asr.dFr);
                                            bVar2.jr(asr.dFs);
                                            bVar2.js(asr.dFt);
                                            bVar2.jt(asr.dFu);
                                            bVar2.field_url = "";
                                            bVar2.field_mac = com.tencent.mm.plugin.exdevice.j.b.KK(com.tencent.mm.plugin.exdevice.j.b.KL(asr.vKF));
                                            bVar2.field_md5Str = g.x(new String(asq2.vIk + asq2.jBE).getBytes());
                                            bVar2.field_authKey = asr.vHO;
                                            bVar2.field_brandName = asr.wwm;
                                            if (bVar2.field_mac == 0) {
                                                bVar2.field_mac = System.currentTimeMillis();
                                            }
                                            if (Kv == null) {
                                                b = ad.boW().b((com.tencent.mm.sdk.e.c) bVar2);
                                                if (b) {
                                                    ad.bph();
                                                    e.aw(bVar2.field_deviceID, true);
                                                }
                                            } else {
                                                b = ad.boW().e(bVar2) != 0;
                                            }
                                            ab.i("MicroMsg.exdevice.GetBoundDeviceLogic", "insert HardDeviceInfo %s, brandName = %s, deviceID = %s, deviceType = %s, connProto = %s, connStrategy = %s, closeStrategy = %s, mac = %s", Boolean.valueOf(b), bVar2.field_brandName, bVar2.field_deviceID, asq2.vIk, bVar2.field_connProto, Integer.valueOf(bVar2.field_connStrategy), Integer.valueOf(bVar2.field_closeStrategy), Long.valueOf(bVar2.field_mac));
                                        }
                                    }
                                }
                                AppMethodBeat.o(19296);
                            }
                            do {
                                b bVar3 = new b();
                                bVar3.d(baR);
                                linkedList.add(bVar3);
                            } while (baR.moveToNext());
                            if (baR != null) {
                            }
                            for (b bVar4 : linkedList) {
                            }
                            it = aga.wna.iterator();
                            while (it.hasNext()) {
                            }
                            AppMethodBeat.o(19296);
                        }
                    });
                    if (this.ltq != null) {
                        this.ltq.gM(true);
                    }
                } else {
                    ab.e("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s, %s, %s", Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                    if (this.ltq != null) {
                        this.ltq.gM(false);
                    }
                    if (this.ehJ != null && this.ehJ.isShowing()) {
                        this.ehJ.dismiss();
                    }
                    AppMethodBeat.o(19303);
                    return;
                }
            }
            if (this.ehJ != null && this.ehJ.isShowing()) {
                this.ehJ.dismiss();
            }
            AppMethodBeat.o(19303);
            return;
        }
        ab.e("MicroMsg.exdevice.GetBoundDeviceLogic", "do scene failed : %d, %d", Integer.valueOf(i2), Integer.valueOf(i));
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        AppMethodBeat.o(19303);
    }
}
