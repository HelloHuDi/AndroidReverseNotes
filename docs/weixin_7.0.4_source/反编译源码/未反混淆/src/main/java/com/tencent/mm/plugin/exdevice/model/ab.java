package com.tencent.mm.plugin.exdevice.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.z;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.he;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.exdevice.a;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.protobuf.asq;
import com.tencent.mm.protocal.protobuf.asr;
import com.tencent.mm.protocal.protobuf.bbv;
import com.tencent.mm.protocal.protobuf.bvd;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.protocal.protobuf.uy;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ab extends c<he> implements f {
    private ProgressDialog ehJ;
    he ltT;

    public ab() {
        AppMethodBeat.i(19368);
        this.xxI = he.class.getName().hashCode();
        AppMethodBeat.o(19368);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(he heVar) {
        AppMethodBeat.i(19369);
        if (heVar instanceof he) {
            this.ltT = heVar;
            String str = this.ltT.cBW.result;
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "action = %s, key = %s", Integer.valueOf(this.ltT.cBW.actionCode), str);
            if (!bo.isNullOrNil(str)) {
                switch (this.ltT.cBW.actionCode) {
                    case 15:
                        if (this.ltT.cBW.context == null || !(this.ltT.cBW.context instanceof Activity)) {
                            AppMethodBeat.o(19369);
                            break;
                        }
                        aw.Rg().a(540, (f) this);
                        final m uVar = new u(str);
                        aw.Rg().a(uVar, 0);
                        Context context = this.ltT.cBW.context;
                        this.ltT.cBW.context.getString(R.string.tz);
                        this.ehJ = h.b(context, this.ltT.cBW.context.getString(R.string.dy4), new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(19367);
                                aw.Rg().c(uVar);
                                if (ab.this.ltT.callback != null) {
                                    ab.this.ltT.cBX.ret = 1;
                                    ab.this.ltT.callback.run();
                                }
                                AppMethodBeat.o(19367);
                            }
                        });
                        break;
                    default:
                        AppMethodBeat.o(19369);
                        break;
                }
            }
            AppMethodBeat.o(19369);
        } else {
            com.tencent.mm.sdk.platformtools.ab.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mismatched event");
            AppMethodBeat.o(19369);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:157:0x0184 A:{SYNTHETIC, EDGE_INSN: B:157:0x0184->B:42:0x0184 ?: BREAK  , EDGE_INSN: B:157:0x0184->B:42:0x0184 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x019a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(19370);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        if (mVar == null) {
            boU();
            AppMethodBeat.o(19370);
        } else if (i == 0 && i2 == 0) {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", Integer.valueOf(mVar.getType()));
            if (mVar.getType() == 540) {
                bvd bvd;
                aw.Rg().b(540, (f) this);
                u uVar = (u) mVar;
                if (uVar.ehh == null || uVar.ehh.fsH.fsP == null) {
                    bvd = null;
                } else {
                    bvd = (bvd) uVar.ehh.fsH.fsP;
                }
                if (bvd == null) {
                    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp == null");
                    boU();
                    AppMethodBeat.o(19370);
                    return;
                }
                String str2;
                ArrayList arrayList;
                int i3;
                int i4;
                asq asq = bvd.vLi;
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "deviceId = %s, deviceType = %s", asq.jBE, asq.vIk);
                asr asr = bvd.vLj;
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "AuthKey = %s, BrandName = %s, CloseStrategy = %s, ConnProto = %s, ConnStrategy = %s, Mac = %s", asr.vHO, asr.wwm, Integer.valueOf(asr.wwp), asr.wwn, Integer.valueOf(asr.wwo), asr.vKF);
                String str3 = "";
                String str4 = "";
                LinkedList linkedList = new LinkedList();
                if (bvd.wWu != null) {
                    if (bvd.wWu.vFh != null) {
                        str3 = bvd.wWu.vFh;
                    }
                    if (bvd.wWu.title != null) {
                        str4 = bvd.wWu.title;
                    }
                    if (bvd.wWu.vFi != null) {
                        linkedList = bvd.wWu.vFi;
                        str2 = str3;
                        arrayList = new ArrayList();
                        if (linkedList != null && linkedList.size() > 0) {
                            i3 = 0;
                            while (true) {
                                i4 = i3;
                                if (i4 < linkedList.size()) {
                                    break;
                                }
                                cdm cdm = (cdm) linkedList.get(i4);
                                if (cdm.type.contains("text")) {
                                    arrayList.add(cdm.content);
                                }
                                i3 = i4 + 1;
                            }
                        }
                        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp.BindTicket = %s", bvd.vKK);
                        if (bvd.wWt != 1) {
                            Intent intent = new Intent();
                            intent.putExtra("device_scan_mode", "SCAN_CATALOG");
                            Object obj = (asr.wwn.contains(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) || asr.wwn.contains("1")) ? 1 : null;
                            boolean contains = asr.wwn.contains("4");
                            if (obj == null || !contains) {
                                if (obj != null) {
                                    intent.putExtra("device_scan_conn_proto", "blue");
                                } else if (contains) {
                                    intent.putExtra("device_scan_conn_proto", "wifi");
                                }
                                intent.putExtra("device_id", asq.jBE);
                                intent.putExtra("device_type", asq.vIk);
                                intent.putExtra("device_title", asr.wwt);
                                intent.putExtra("device_desc", asr.wwu);
                                intent.putExtra("device_icon_url", asr.IconUrl);
                                intent.putExtra("device_category_id", asr.wwv);
                                intent.putExtra("device_brand_name", asr.wwm);
                                intent.putExtra("bind_ticket", bvd.vKK);
                                intent.putExtra("device_ble_simple_proto", asr.dFq);
                                intent.putExtra("device_airkiss_key", str2);
                                intent.putExtra("device_airkiss_title", str4);
                                intent.putStringArrayListExtra("device_airkiss_steps", arrayList);
                                d.b(this.ltT.cBW.context, "exdevice", ".ui.ExdeviceBindDeviceGuideUI", intent);
                                stopScan();
                                AppMethodBeat.o(19370);
                                return;
                            }
                            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Category connect proto can not be blue&wifi at the same time...");
                            AppMethodBeat.o(19370);
                            return;
                        }
                        bbv bbv = bvd.vKL;
                        if (bbv == null) {
                            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mContact == null");
                            boU();
                            AppMethodBeat.o(19370);
                            return;
                        }
                        stopScan();
                        if (bbv == null) {
                            com.tencent.mm.sdk.platformtools.ab.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "unable to parse mod contact");
                        } else {
                            str2 = aa.a(bbv.wcB);
                            String nullAsNil = bo.nullAsNil(bbv.wGl);
                            if (bo.isNullOrNil(str2) && bo.isNullOrNil(nullAsNil)) {
                                com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact user is null user:%s enuser:%s", str2, nullAsNil);
                            } else {
                                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact : %s", str2);
                                aw.ZK();
                                ad aoO = com.tencent.mm.model.c.XM().aoO(str2);
                                if (aoO == null || !str2.equals(aoO.field_encryptUsername)) {
                                    ad adVar = new ad(str2);
                                    adVar.iy(bbv.guS);
                                    adVar.setType(bbv.wbu & bbv.wbv);
                                    if (!bo.isNullOrNil(nullAsNil)) {
                                        adVar.iH(nullAsNil);
                                    } else if (aoO != null && ((int) aoO.ewQ) > 0) {
                                        adVar.iH(aoO.field_encryptUsername);
                                    }
                                    adVar.ewQ = aoO == null ? 0 : (long) ((int) aoO.ewQ);
                                    adVar.iB(aa.a(bbv.wyX));
                                    adVar.iC(aa.a(bbv.wce));
                                    adVar.iD(aa.a(bbv.wcf));
                                    adVar.hA(bbv.guN);
                                    adVar.hD(bbv.wbA);
                                    adVar.iA(aa.a(bbv.wGf));
                                    adVar.hE(bbv.wbE);
                                    adVar.hF(bbv.guR);
                                    adVar.iW(RegionCodeDecoder.aC(bbv.guW, bbv.guO, bbv.guP));
                                    adVar.iQ(bbv.guQ);
                                    adVar.hw(bbv.wBT);
                                    adVar.iV(bbv.wBU);
                                    adVar.setSource(bbv.vFH);
                                    adVar.hv(bbv.wBX);
                                    adVar.iE(bbv.wBW);
                                    if (t.nO(bbv.wBV)) {
                                        adVar.iU(bbv.wBV);
                                    }
                                    adVar.hH((int) bo.anT());
                                    adVar.iz(aa.a(bbv.wFK));
                                    adVar.iF(aa.a(bbv.wFM));
                                    adVar.iG(aa.a(bbv.wFL));
                                    adVar.iX(bbv.vEA);
                                    adVar.iY(bbv.wGv);
                                    if (!(aoO == null || bo.nullAsNil(aoO.dum).equals(bo.nullAsNil(bbv.wGv)))) {
                                        com.tencent.mm.bc.c.aiB();
                                        com.tencent.mm.bc.c.sY(str2);
                                    }
                                    aw.ZK();
                                    com.tencent.mm.model.c.XM().aoT(str2);
                                    if (bo.isNullOrNil(adVar.field_username)) {
                                        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "dkinit dealModContactExtInfo failed invalid contact");
                                    } else {
                                        str3 = adVar.field_username;
                                        o.act().b(b.a(str3, bbv));
                                        ccl ccl = bbv.wBZ;
                                        if (!(adVar.field_username.endsWith("@chatroom") || ccl == null)) {
                                            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsFlag modcontact " + ccl.guY + " " + bbv.wcB);
                                            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBg modcontact " + ccl.guZ);
                                            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + ccl.gva);
                                            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + ccl.xbQ);
                                            if (n.qFy != null) {
                                                n.qFy.a(adVar.field_username, ccl);
                                            }
                                        }
                                        str4 = r.Yz();
                                        if (!(str4 == null || str4.equals(str3))) {
                                            com.tencent.mm.aj.d qP = z.aeR().qP(str3);
                                            qP.field_username = str3;
                                            qP.field_brandList = bbv.guX;
                                            uy uyVar = bbv.wCa;
                                            if (uyVar != null) {
                                                qP.field_brandFlag = uyVar.gvb;
                                                qP.field_brandInfo = uyVar.gvd;
                                                qP.field_brandIconURL = uyVar.gve;
                                                qP.field_extInfo = uyVar.gvc;
                                                qP.field_attrSyncVersion = null;
                                                qP.field_incrementUpdateTime = 0;
                                            }
                                            if (!z.aeR().e(qP)) {
                                                z.aeR().d(qP);
                                            }
                                            adVar.hI(qP.field_type);
                                        }
                                    }
                                    adVar.hy(bbv.wGu);
                                    if (!(bbv.wGq == null || bbv.wGq.vEU == null)) {
                                        adVar.iZ(bbv.wGq.vEU.vLl);
                                        adVar.ja(bbv.wGq.vEU.vLm);
                                        adVar.jb(bbv.wGq.vEU.vLn);
                                    }
                                    if (t.nI(str2)) {
                                        adVar.NK();
                                    }
                                    if (adVar.dsf()) {
                                        adVar.NN();
                                    }
                                    if (bo.isNullOrNil(nullAsNil)) {
                                        aw.ZK();
                                        com.tencent.mm.model.c.XM().Y(adVar);
                                    } else {
                                        aw.ZK();
                                        com.tencent.mm.model.c.XM().c(nullAsNil, adVar);
                                    }
                                    if (!(aoO == null || (aoO.field_type & 2048) == (adVar.field_type & 2048))) {
                                        if ((adVar.field_type & 2048) != 0) {
                                            aw.ZK();
                                            com.tencent.mm.model.c.XR().apf(adVar.field_username);
                                        } else {
                                            aw.ZK();
                                            com.tencent.mm.model.c.XR().apg(adVar.field_username);
                                        }
                                    }
                                } else {
                                    com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "cat's replace user with stranger");
                                }
                            }
                        }
                        str3 = aa.a(bbv.wcB);
                        if (this.ltT == null || this.ltT.cBW == null || this.ltT.cBW.context == null) {
                            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "a8KeyRedirectEvent null");
                            AppMethodBeat.o(19370);
                            return;
                        }
                        aw.ZK();
                        ad aoO2 = com.tencent.mm.model.c.XM().aoO(str3);
                        if (aoO2 != null) {
                            if (asr.dFp != 0) {
                                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to DeviceProfileUI.");
                                Context context = this.ltT.cBW.context;
                                Intent intent2 = new Intent(context, ExdeviceDeviceProfileUI.class);
                                if (!(context instanceof Activity)) {
                                    intent2.addFlags(268435456);
                                }
                                intent2.putExtra("device_id", asq.jBE);
                                intent2.putExtra("device_type", asq.vIk);
                                intent2.putExtra("device_mac", asr.vKF);
                                intent2.putExtra("device_brand_name", asr.wwm);
                                intent2.putExtra("device_alias", asr.guS);
                                intent2.putExtra("device_desc", asr.wwu);
                                intent2.putExtra("device_title", asr.wwt);
                                intent2.putExtra("device_icon_url", asr.IconUrl);
                                intent2.putExtra("device_jump_url", asr.mZj);
                                intent2.putExtra("bind_ticket", bvd.vKK);
                                intent2.putExtra("device_has_bound", ad.boW().dT(aoO2.field_username, asq.jBE) != null);
                                context.startActivity(intent2);
                                AppMethodBeat.o(19370);
                                return;
                            }
                            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to ContactInfoUI.");
                            Intent intent3 = new Intent();
                            intent3.putExtra("Contact_User", str3);
                            intent3.putExtra("KIsHardDevice", true);
                            intent3.putExtra("KHardDeviceBindTicket", bvd.vKK);
                            intent3.putExtra("device_id", asq.jBE);
                            intent3.putExtra("device_type", asq.vIk);
                            a.lqt.c(intent3, this.ltT.cBW.context);
                            AppMethodBeat.o(19370);
                            return;
                        }
                    }
                }
                str2 = str3;
                arrayList = new ArrayList();
                i3 = 0;
                while (true) {
                    i4 = i3;
                    if (i4 < linkedList.size()) {
                    }
                    i3 = i4 + 1;
                }
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp.BindTicket = %s", bvd.vKK);
                if (bvd.wWt != 1) {
                }
            }
            AppMethodBeat.o(19370);
        } else {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", Integer.valueOf(mVar.getType()));
            boU();
            AppMethodBeat.o(19370);
        }
    }

    private void boU() {
        AppMethodBeat.i(19371);
        if (!(this.ltT == null || this.ltT.callback == null)) {
            this.ltT.cBX.ret = 1;
            this.ltT.callback.run();
        }
        AppMethodBeat.o(19371);
    }

    private void stopScan() {
        AppMethodBeat.i(19372);
        if (!(this.ltT == null || this.ltT.callback == null)) {
            this.ltT.cBX.ret = 2;
            this.ltT.callback.run();
        }
        AppMethodBeat.o(19372);
    }
}
