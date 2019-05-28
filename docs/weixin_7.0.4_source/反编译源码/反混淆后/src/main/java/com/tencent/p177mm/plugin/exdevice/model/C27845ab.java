package com.tencent.p177mm.plugin.exdevice.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1185bc.C17974c;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p230g.p231a.C26151he;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.exdevice.C45875a;
import com.tencent.p177mm.plugin.exdevice.p393ui.ExdeviceDeviceProfileUI;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.protocal.protobuf.C7285uy;
import com.tencent.p177mm.protocal.protobuf.asq;
import com.tencent.p177mm.protocal.protobuf.asr;
import com.tencent.p177mm.protocal.protobuf.bbv;
import com.tencent.p177mm.protocal.protobuf.bvd;
import com.tencent.p177mm.protocal.protobuf.ccl;
import com.tencent.p177mm.protocal.protobuf.cdm;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.RegionCodeDecoder;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.exdevice.model.ab */
public final class C27845ab extends C4884c<C26151he> implements C1202f {
    private ProgressDialog ehJ;
    C26151he ltT;

    public C27845ab() {
        AppMethodBeat.m2504i(19368);
        this.xxI = C26151he.class.getName().hashCode();
        AppMethodBeat.m2505o(19368);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private boolean m44268a(C26151he c26151he) {
        AppMethodBeat.m2504i(19369);
        if (c26151he instanceof C26151he) {
            this.ltT = c26151he;
            String str = this.ltT.cBW.result;
            C4990ab.m7417i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "action = %s, key = %s", Integer.valueOf(this.ltT.cBW.actionCode), str);
            if (!C5046bo.isNullOrNil(str)) {
                switch (this.ltT.cBW.actionCode) {
                    case 15:
                        if (this.ltT.cBW.context == null || !(this.ltT.cBW.context instanceof Activity)) {
                            AppMethodBeat.m2505o(19369);
                            break;
                        }
                        C9638aw.m17182Rg().mo14539a(540, (C1202f) this);
                        final C1207m c20537u = new C20537u(str);
                        C9638aw.m17182Rg().mo14541a(c20537u, 0);
                        Context context = this.ltT.cBW.context;
                        this.ltT.cBW.context.getString(C25738R.string.f9238tz);
                        this.ehJ = C30379h.m48457b(context, this.ltT.cBW.context.getString(C25738R.string.dy4), new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.m2504i(19367);
                                C9638aw.m17182Rg().mo14547c(c20537u);
                                if (C27845ab.this.ltT.callback != null) {
                                    C27845ab.this.ltT.cBX.ret = 1;
                                    C27845ab.this.ltT.callback.run();
                                }
                                AppMethodBeat.m2505o(19367);
                            }
                        });
                        break;
                    default:
                        AppMethodBeat.m2505o(19369);
                        break;
                }
            }
            AppMethodBeat.m2505o(19369);
        } else {
            C4990ab.m7414f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mismatched event");
            AppMethodBeat.m2505o(19369);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:157:0x0184 A:{SYNTHETIC, EDGE_INSN: B:157:0x0184->B:42:0x0184 ?: BREAK  , EDGE_INSN: B:157:0x0184->B:42:0x0184 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x019a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(19370);
        C4990ab.m7416i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        if (c1207m == null) {
            boU();
            AppMethodBeat.m2505o(19370);
        } else if (i == 0 && i2 == 0) {
            C4990ab.m7417i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", Integer.valueOf(c1207m.getType()));
            if (c1207m.getType() == 540) {
                bvd bvd;
                C9638aw.m17182Rg().mo14546b(540, (C1202f) this);
                C20537u c20537u = (C20537u) c1207m;
                if (c20537u.ehh == null || c20537u.ehh.fsH.fsP == null) {
                    bvd = null;
                } else {
                    bvd = (bvd) c20537u.ehh.fsH.fsP;
                }
                if (bvd == null) {
                    C4990ab.m7412e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp == null");
                    boU();
                    AppMethodBeat.m2505o(19370);
                    return;
                }
                String str2;
                ArrayList arrayList;
                int i3;
                int i4;
                asq asq = bvd.vLi;
                C4990ab.m7417i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "deviceId = %s, deviceType = %s", asq.jBE, asq.vIk);
                asr asr = bvd.vLj;
                C4990ab.m7417i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "AuthKey = %s, BrandName = %s, CloseStrategy = %s, ConnProto = %s, ConnStrategy = %s, Mac = %s", asr.vHO, asr.wwm, Integer.valueOf(asr.wwp), asr.wwn, Integer.valueOf(asr.wwo), asr.vKF);
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
                        C4990ab.m7417i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp.BindTicket = %s", bvd.vKK);
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
                                C25985d.m41467b(this.ltT.cBW.context, "exdevice", ".ui.ExdeviceBindDeviceGuideUI", intent);
                                stopScan();
                                AppMethodBeat.m2505o(19370);
                                return;
                            }
                            C4990ab.m7412e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Category connect proto can not be blue&wifi at the same time...");
                            AppMethodBeat.m2505o(19370);
                            return;
                        }
                        bbv bbv = bvd.vKL;
                        if (bbv == null) {
                            C4990ab.m7412e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mContact == null");
                            boU();
                            AppMethodBeat.m2505o(19370);
                            return;
                        }
                        stopScan();
                        if (bbv == null) {
                            C4990ab.m7414f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "unable to parse mod contact");
                        } else {
                            str2 = C1946aa.m4148a(bbv.wcB);
                            String nullAsNil = C5046bo.nullAsNil(bbv.wGl);
                            if (C5046bo.isNullOrNil(str2) && C5046bo.isNullOrNil(nullAsNil)) {
                                C4990ab.m7413e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact user is null user:%s enuser:%s", str2, nullAsNil);
                            } else {
                                C4990ab.m7417i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact : %s", str2);
                                C9638aw.m17190ZK();
                                C7616ad aoO = C18628c.m29078XM().aoO(str2);
                                if (aoO == null || !str2.equals(aoO.field_encryptUsername)) {
                                    C7616ad c7616ad = new C7616ad(str2);
                                    c7616ad.mo14728iy(bbv.guS);
                                    c7616ad.setType(bbv.wbu & bbv.wbv);
                                    if (!C5046bo.isNullOrNil(nullAsNil)) {
                                        c7616ad.mo14709iH(nullAsNil);
                                    } else if (aoO != null && ((int) aoO.ewQ) > 0) {
                                        c7616ad.mo14709iH(aoO.field_encryptUsername);
                                    }
                                    c7616ad.ewQ = aoO == null ? 0 : (long) ((int) aoO.ewQ);
                                    c7616ad.mo14703iB(C1946aa.m4148a(bbv.wyX));
                                    c7616ad.mo14704iC(C1946aa.m4148a(bbv.wce));
                                    c7616ad.mo14705iD(C1946aa.m4148a(bbv.wcf));
                                    c7616ad.mo14685hA(bbv.guN);
                                    c7616ad.mo14688hD(bbv.wbA);
                                    c7616ad.mo14702iA(C1946aa.m4148a(bbv.wGf));
                                    c7616ad.mo14689hE(bbv.wbE);
                                    c7616ad.mo14690hF(bbv.guR);
                                    c7616ad.mo14724iW(RegionCodeDecoder.m7796aC(bbv.guW, bbv.guO, bbv.guP));
                                    c7616ad.mo14718iQ(bbv.guQ);
                                    c7616ad.mo14698hw(bbv.wBT);
                                    c7616ad.mo14723iV(bbv.wBU);
                                    c7616ad.setSource(bbv.vFH);
                                    c7616ad.mo14697hv(bbv.wBX);
                                    c7616ad.mo14706iE(bbv.wBW);
                                    if (C1855t.m3929nO(bbv.wBV)) {
                                        c7616ad.mo14722iU(bbv.wBV);
                                    }
                                    c7616ad.mo14692hH((int) C5046bo.anT());
                                    c7616ad.mo14729iz(C1946aa.m4148a(bbv.wFK));
                                    c7616ad.mo14707iF(C1946aa.m4148a(bbv.wFM));
                                    c7616ad.mo14708iG(C1946aa.m4148a(bbv.wFL));
                                    c7616ad.mo14725iX(bbv.vEA);
                                    c7616ad.mo14726iY(bbv.wGv);
                                    if (!(aoO == null || C5046bo.nullAsNil(aoO.dum).equals(C5046bo.nullAsNil(bbv.wGv)))) {
                                        C17974c.aiB();
                                        C17974c.m28284sY(str2);
                                    }
                                    C9638aw.m17190ZK();
                                    C18628c.m29078XM().aoT(str2);
                                    if (C5046bo.isNullOrNil(c7616ad.field_username)) {
                                        C4990ab.m7412e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "dkinit dealModContactExtInfo failed invalid contact");
                                    } else {
                                        str3 = c7616ad.field_username;
                                        C17884o.act().mo33391b(C41730b.m73491a(str3, bbv));
                                        ccl ccl = bbv.wBZ;
                                        if (!(c7616ad.field_username.endsWith("@chatroom") || ccl == null)) {
                                            C4990ab.m7416i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsFlag modcontact " + ccl.guY + " " + bbv.wcB);
                                            C4990ab.m7416i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBg modcontact " + ccl.guZ);
                                            C4990ab.m7416i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + ccl.gva);
                                            C4990ab.m7416i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + ccl.xbQ);
                                            if (C21877n.qFy != null) {
                                                C21877n.qFy.mo47112a(c7616ad.field_username, ccl);
                                            }
                                        }
                                        str4 = C1853r.m3846Yz();
                                        if (!(str4 == null || str4.equals(str3))) {
                                            C16527d qP = C41747z.aeR().mo43729qP(str3);
                                            qP.field_username = str3;
                                            qP.field_brandList = bbv.guX;
                                            C7285uy c7285uy = bbv.wCa;
                                            if (c7285uy != null) {
                                                qP.field_brandFlag = c7285uy.gvb;
                                                qP.field_brandInfo = c7285uy.gvd;
                                                qP.field_brandIconURL = c7285uy.gve;
                                                qP.field_extInfo = c7285uy.gvc;
                                                qP.field_attrSyncVersion = null;
                                                qP.field_incrementUpdateTime = 0;
                                            }
                                            if (!C41747z.aeR().mo43726e(qP)) {
                                                C41747z.aeR().mo43724d(qP);
                                            }
                                            c7616ad.mo14693hI(qP.field_type);
                                        }
                                    }
                                    c7616ad.mo14700hy(bbv.wGu);
                                    if (!(bbv.wGq == null || bbv.wGq.vEU == null)) {
                                        c7616ad.mo14727iZ(bbv.wGq.vEU.vLl);
                                        c7616ad.mo14730ja(bbv.wGq.vEU.vLm);
                                        c7616ad.mo14731jb(bbv.wGq.vEU.vLn);
                                    }
                                    if (C1855t.m3923nI(str2)) {
                                        c7616ad.mo16685NK();
                                    }
                                    if (c7616ad.dsf()) {
                                        c7616ad.mo16688NN();
                                    }
                                    if (C5046bo.isNullOrNil(nullAsNil)) {
                                        C9638aw.m17190ZK();
                                        C18628c.m29078XM().mo15701Y(c7616ad);
                                    } else {
                                        C9638aw.m17190ZK();
                                        C18628c.m29078XM().mo15732c(nullAsNil, c7616ad);
                                    }
                                    if (!(aoO == null || (aoO.field_type & 2048) == (c7616ad.field_type & 2048))) {
                                        if ((c7616ad.field_type & 2048) != 0) {
                                            C9638aw.m17190ZK();
                                            C18628c.m29083XR().apf(c7616ad.field_username);
                                        } else {
                                            C9638aw.m17190ZK();
                                            C18628c.m29083XR().apg(c7616ad.field_username);
                                        }
                                    }
                                } else {
                                    C4990ab.m7420w("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "cat's replace user with stranger");
                                }
                            }
                        }
                        str3 = C1946aa.m4148a(bbv.wcB);
                        if (this.ltT == null || this.ltT.cBW == null || this.ltT.cBW.context == null) {
                            C4990ab.m7412e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "a8KeyRedirectEvent null");
                            AppMethodBeat.m2505o(19370);
                            return;
                        }
                        C9638aw.m17190ZK();
                        C7616ad aoO2 = C18628c.m29078XM().aoO(str3);
                        if (aoO2 != null) {
                            if (asr.dFp != 0) {
                                C4990ab.m7416i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to DeviceProfileUI.");
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
                                intent2.putExtra("device_has_bound", C45891ad.boW().mo45707dT(aoO2.field_username, asq.jBE) != null);
                                context.startActivity(intent2);
                                AppMethodBeat.m2505o(19370);
                                return;
                            }
                            C4990ab.m7416i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to ContactInfoUI.");
                            Intent intent3 = new Intent();
                            intent3.putExtra("Contact_User", str3);
                            intent3.putExtra("KIsHardDevice", true);
                            intent3.putExtra("KHardDeviceBindTicket", bvd.vKK);
                            intent3.putExtra("device_id", asq.jBE);
                            intent3.putExtra("device_type", asq.vIk);
                            C45875a.lqt.mo38912c(intent3, this.ltT.cBW.context);
                            AppMethodBeat.m2505o(19370);
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
                C4990ab.m7417i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp.BindTicket = %s", bvd.vKK);
                if (bvd.wWt != 1) {
                }
            }
            AppMethodBeat.m2505o(19370);
        } else {
            C4990ab.m7413e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", Integer.valueOf(c1207m.getType()));
            boU();
            AppMethodBeat.m2505o(19370);
        }
    }

    private void boU() {
        AppMethodBeat.m2504i(19371);
        if (!(this.ltT == null || this.ltT.callback == null)) {
            this.ltT.cBX.ret = 1;
            this.ltT.callback.run();
        }
        AppMethodBeat.m2505o(19371);
    }

    private void stopScan() {
        AppMethodBeat.m2504i(19372);
        if (!(this.ltT == null || this.ltT.callback == null)) {
            this.ltT.cBX.ret = 2;
            this.ltT.callback.run();
        }
        AppMethodBeat.m2505o(19372);
    }
}
