package com.tencent.mm.aj;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.kb;
import com.tencent.mm.protocal.protobuf.kc;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private static String fuG = "";
    private static long fuH = 0;

    public static void qy(String str) {
        AppMethodBeat.i(11241);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(11241);
            return;
        }
        d qP = z.aeR().qP(str);
        qP.field_attrSyncVersion = null;
        qP.field_incrementUpdateTime = 0;
        z.aeR().e(qP);
        AppMethodBeat.o(11241);
    }

    public static void qz(String str) {
        AppMethodBeat.i(11242);
        fuG = str;
        fuH = System.currentTimeMillis();
        AppMethodBeat.o(11242);
    }

    public static boolean qA(String str) {
        AppMethodBeat.i(11243);
        if (!bo.isEqual(fuG, str) || System.currentTimeMillis() - fuH >= 1000) {
            AppMethodBeat.o(11243);
            return false;
        }
        AppMethodBeat.o(11243);
        return true;
    }

    static boolean b(d dVar) {
        AppMethodBeat.i(11244);
        if (dVar == null) {
            ab.i("MicroMsg.BizAttrRenovator", "BizInfo is null.");
            AppMethodBeat.o(11244);
            return false;
        } else if (adG()) {
            int i = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getInt("MMBizAttrSyncFreq", -1);
            if (i == -1) {
                ab.i("MicroMsg.BizAttrRenovator", "MMBizAttrSyncFreq is null.");
                i = 3600;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = dVar.field_incrementUpdateTime;
            String str = dVar.field_attrSyncVersion;
            ab.i("MicroMsg.BizAttrRenovator", "currentMS(%d), lastUpdateTime(%d), freq(%d), version(%s).", Long.valueOf(currentTimeMillis), Long.valueOf(j), Integer.valueOf(i), str);
            if (currentTimeMillis - j >= ((long) i) * 1000) {
                AppMethodBeat.o(11244);
                return true;
            }
            AppMethodBeat.o(11244);
            return false;
        } else {
            AppMethodBeat.o(11244);
            return false;
        }
    }

    public static boolean adG() {
        int i;
        AppMethodBeat.i(11245);
        Object obj = g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_BIZ_ATTR_SYNC_OPEN_FLAG_INT, null);
        if (obj == null || !(obj instanceof Integer)) {
            ab.i("MicroMsg.BizAttrRenovator", "openFlag is null.");
            i = 1;
        } else {
            i = ((Integer) obj).intValue();
        }
        ab.i("MicroMsg.BizAttrRenovator", "openFlag is %d.", Integer.valueOf(i));
        if (i == 1) {
            AppMethodBeat.o(11245);
            return true;
        }
        AppMethodBeat.o(11245);
        return false;
    }

    public final boolean qB(final String str) {
        AppMethodBeat.i(11246);
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes failed, username is null or nil.");
            AppMethodBeat.o(11246);
            return false;
        } else if (qA(str)) {
            ab.i("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes failed, username is just delete.");
            AppMethodBeat.o(11246);
            return false;
        } else {
            ab.d("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes");
            d qP = z.aeR().qP(str);
            if (b(qP)) {
                final WeakReference weakReference = new WeakReference(null);
                g.RO().eJo.a(new p(str, qP.field_attrSyncVersion, new com.tencent.mm.aj.p.a<p>() {
                    public final /* synthetic */ void a(int i, int i2, String str, m mVar) {
                        AppMethodBeat.i(11240);
                        p pVar = (p) mVar;
                        ab.i("MicroMsg.BizAttrRenovator", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
                        if (a.qA(str)) {
                            ab.i("MicroMsg.BizAttrRenovator", "onNetSceneEndCallback return, username is just delete.");
                            AppMethodBeat.o(11240);
                            return;
                        }
                        if (weakReference != null) {
                            weakReference.get();
                        }
                        if (i == 0 && i2 == 0) {
                            kb kbVar;
                            if (pVar.ehh == null || pVar.ehh.fsH.fsP == null) {
                                kbVar = null;
                            } else {
                                kbVar = (kb) pVar.ehh.fsH.fsP;
                            }
                            if (kbVar == null) {
                                ab.e("MicroMsg.BizAttrRenovator", "resp is null.");
                                AppMethodBeat.o(11240);
                                return;
                            }
                            String str2;
                            int i3;
                            String str3 = "MicroMsg.BizAttrRenovator";
                            String str4 = "[BizAttr] biz(%s) Attribute LastAttrVersion = %s, UpdateInfoList.size = %s";
                            Object[] objArr = new Object[3];
                            objArr[0] = str;
                            if (kbVar.vMS == null) {
                                str2 = null;
                            } else {
                                str2 = new String(kbVar.vMS.wR);
                            }
                            objArr[1] = str2;
                            if (kbVar.vMT == null) {
                                i3 = 0;
                            } else {
                                i3 = kbVar.vMT.size();
                            }
                            objArr[2] = Integer.valueOf(i3);
                            ab.i(str3, str4, objArr);
                            if (kbVar.vMT == null) {
                                ab.e("MicroMsg.BizAttrRenovator", "[BizAttr] resp.UpdateInfoList null");
                                AppMethodBeat.o(11240);
                                return;
                            }
                            boolean z;
                            str3 = str;
                            LinkedList linkedList = kbVar.vMT;
                            if (bo.isNullOrNil(str3)) {
                                ab.e("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, username is null.");
                                z = false;
                            } else {
                                d qP = z.aeR().qP(str3);
                                if (a.b(qP)) {
                                    ad aoO = ((j) g.K(j.class)).XM().aoO(str3);
                                    if (aoO == null || ((int) aoO.ewQ) == 0 || !aoO.dsf()) {
                                        ab.w("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, contact do not exist.(username : %s)", str3);
                                        z = false;
                                    } else {
                                        if (bo.isNullOrNil(aoO.field_username)) {
                                            aoO.setUsername(str3);
                                        }
                                        z = a.a(aoO, qP, linkedList);
                                    }
                                } else {
                                    ab.i("MicroMsg.BizAttrRenovator", "Do not need to update bizAttrs now.(username : %s)", str3);
                                    z = false;
                                }
                            }
                            if (z) {
                                if (kbVar.vMS != null) {
                                    str2 = str;
                                    String cd = bo.cd(kbVar.vMS.wR);
                                    if (bo.isNullOrNil(str2) || bo.isNullOrNil(cd)) {
                                        z = false;
                                    } else {
                                        z = z.aeR().hY("BizInfo", String.format("update %s set %s='%s', %s=%d where %s='%s'", new Object[]{"BizInfo", "attrSyncVersion", cd, "incrementUpdateTime", Long.valueOf(System.currentTimeMillis()), "username", str2}));
                                    }
                                    ab.i("MicroMsg.BizAttrRenovator", "Update attrSyncVersion of bizInfo succ = %b.", Boolean.valueOf(z));
                                }
                                AppMethodBeat.o(11240);
                                return;
                            }
                            ab.i("MicroMsg.BizAttrRenovator", "notifyDataSetChanged, after updateBizAttributes.");
                            AppMethodBeat.o(11240);
                            return;
                        }
                        ab.e("MicroMsg.BizAttrRenovator", "scene.getType() = %s", Integer.valueOf(pVar.getType()));
                        AppMethodBeat.o(11240);
                    }
                }), 0);
                AppMethodBeat.o(11246);
                return true;
            }
            ab.i("MicroMsg.BizAttrRenovator", "do not need to update biz attrs now.");
            AppMethodBeat.o(11246);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:89:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(ad adVar, d dVar, List<kc> list) {
        AppMethodBeat.i(11247);
        if (adVar == null || list == null || list.size() == 0) {
            ab.e("MicroMsg.BizAttrRenovator", "updateBizAttributes failed.");
            AppMethodBeat.o(11247);
            return false;
        }
        String str = adVar.field_username;
        if (adVar.dsf()) {
            if (dVar == null) {
                dVar = z.aeR().qP(str);
            }
            if (dVar == null) {
                ab.i("MicroMsg.BizAttrRenovator", "BizInfo is null.(username : %s)", str);
                AppMethodBeat.o(11247);
                return false;
            }
            JSONObject jSONObject;
            int i;
            h qo = o.act().qo(str);
            try {
                if (bo.isNullOrNil(dVar.field_extInfo)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(dVar.field_extInfo);
                }
            } catch (Exception e) {
                ab.e("MicroMsg.BizAttrRenovator", "create Json object from extInfo error. %s.", e);
                jSONObject = new JSONObject();
            }
            long j = -1;
            long j2 = (long) adVar.field_type;
            int i2 = 0;
            Object obj = null;
            for (kc kcVar : list) {
                if (kcVar == null) {
                    ab.w("MicroMsg.BizAttrRenovator", "keyValue is null.");
                } else {
                    Object obj2;
                    String str2 = kcVar.vMU;
                    ab.i("MicroMsg.BizAttrRenovator", "[BizAttr] UpdateInfoList key = %s, value = %s", str2, kcVar.pXM);
                    String str3 = kcVar.pXM;
                    if (!"UserName".equals(str2)) {
                        if ("NickName".equals(str2)) {
                            adVar.iB(str3);
                        } else if ("Alias".equals(str2)) {
                            adVar.iy(str3);
                        } else if ("PYInitial".equals(str2)) {
                            adVar.iC(str3);
                        } else if ("QuanPin".equals(str2)) {
                            adVar.iD(str3);
                        } else if ("VerifyFlag".equals(str2)) {
                            adVar.hw(bo.getInt(str3, adVar.field_verifyFlag));
                        } else if ("VerifyInfo".equals(str2)) {
                            adVar.iV(str3);
                        } else if ("Signature".equals(str2)) {
                            adVar.iQ(str3);
                        } else {
                            obj2 = null;
                            if (obj2 == null && !b(jSONObject, str2, kcVar.pXM)) {
                                str3 = kcVar.pXM;
                                if (!"BrandInfo".equals(str2)) {
                                    dVar.field_brandInfo = str3;
                                } else if ("BrandIconURL".equals(str2)) {
                                    dVar.field_brandIconURL = str3;
                                } else if ("BrandFlag".equals(str2)) {
                                    dVar.field_brandFlag = bo.getInt(str3, dVar.field_brandFlag);
                                } else {
                                    if (!"Appid".equals(str2)) {
                                        obj2 = null;
                                    } else if (str3.equals(dVar.field_appId)) {
                                        obj2 = null;
                                    } else {
                                        dVar.field_appId = str3;
                                    }
                                    if (obj2 == null) {
                                        str3 = kcVar.pXM;
                                        if ("BigHeadImgUrl".equals(str2)) {
                                            if (qo != null) {
                                                qo.frW = str3;
                                            }
                                        } else if (!"SmallHeadImgUrl".equals(str2)) {
                                            obj2 = null;
                                            if (obj2 == null) {
                                                i2++;
                                                obj = 1;
                                            } else if ("BitMask".equals(str2)) {
                                                j = bo.getLong(kcVar.pXM, j);
                                                i2++;
                                            } else {
                                                if ("BitVal".equals(str2)) {
                                                    j2 = bo.getLong(kcVar.pXM, j2);
                                                    i = i2 + 1;
                                                } else {
                                                    i = i2;
                                                }
                                                i2 = i;
                                            }
                                        } else if (qo != null) {
                                            qo.frV = str3;
                                        }
                                        obj2 = 1;
                                        if (obj2 == null) {
                                        }
                                    }
                                }
                                obj2 = 1;
                                if (obj2 == null) {
                                }
                            }
                            i2++;
                        }
                    }
                    obj2 = 1;
                    str3 = kcVar.pXM;
                    if (!"BrandInfo".equals(str2)) {
                    }
                    obj2 = 1;
                    if (obj2 == null) {
                    }
                    i2++;
                }
            }
            if (i2 == 0) {
                ab.i("MicroMsg.BizAttrRenovator", "None attribute has been updated.");
                AppMethodBeat.o(11247);
                return false;
            }
            dVar.field_extInfo = jSONObject.toString();
            if (!(qo == null || obj == null)) {
                o.act().b(qo);
                o.acd();
                d.E(str, false);
                o.acd();
                d.E(str, true);
                o.acv().pZ(str);
                com.tencent.mm.aj.m.a afb = z.afb();
                if (!bo.isNullOrNil(str)) {
                    ab.d("MicroMsg.BrandLogic", "remove cache by brandKey : %s", str);
                    WeakReference weakReference = (WeakReference) afb.fwK.remove(str);
                    if (weakReference != null) {
                        Bitmap bitmap = (Bitmap) weakReference.get();
                        if (bitmap != null) {
                            bitmap.isRecycled();
                        }
                    }
                }
            }
            adVar.setType(adVar.field_type | ((int) (j & j2)));
            i = ((j) g.K(j.class)).XM().b(str, adVar);
            z.aeR().e(dVar);
            if (i == 1) {
                ((j) g.K(j.class)).XM().b(4, (n) ((j) g.K(j.class)).XM(), str);
            }
            ab.i("MicroMsg.BizAttrRenovator", "Update bizInfo attributes successfully.");
            AppMethodBeat.o(11247);
            return true;
        }
        ab.w("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, contact is not a biz contact.(username : %s)", str);
        AppMethodBeat.o(11247);
        return false;
    }

    private static boolean b(JSONObject jSONObject, String str, String str2) {
        AppMethodBeat.i(11248);
        try {
            if ("IsShowHeadImgInMsg".equals(str)) {
                jSONObject.put(str, str2);
            } else if ("IsHideInputToolbarInMsg".equals(str)) {
                jSONObject.put(str, str2);
            } else if (!"IsAgreeProtocol".equals(str)) {
                if ("InteractiveMode".equals(str)) {
                    jSONObject.put(str, bo.getInt(str2, jSONObject.optInt(str)));
                } else if ("CanReceiveSpeexVoice".equals(str)) {
                    jSONObject.put(str, str2);
                } else if ("ConnectorMsgType".equals(str)) {
                    jSONObject.put(str, bo.getInt(str2, jSONObject.optInt(str)));
                } else if ("ReportLocationType".equals(str)) {
                    jSONObject.put(str, bo.getInt(str2, jSONObject.optInt(str)));
                } else if ("AudioPlayType".equals(str)) {
                    jSONObject.put(str, bo.getInt(str2, jSONObject.optInt(str)));
                } else if ("IsShowMember".equals(str)) {
                    jSONObject.put(str, str2);
                } else if ("ConferenceContactExpireTime".equals(str)) {
                    jSONObject.put(str, str2);
                } else if (!"VerifyMsg2Remark".equals(str)) {
                    if ("VerifyContactPromptTitle".equals(str)) {
                        jSONObject.put(str, str2);
                    } else if (!"IsSubscribeStat".equals(str)) {
                        if ("ScanQRCodeType".equals(str)) {
                            jSONObject.put(str, bo.getInt(str2, jSONObject.optInt(str)));
                        } else if ("ServiceType".equals(str)) {
                            jSONObject.put(str, bo.getInt(str2, jSONObject.optInt(str)));
                        } else if (!"NeedShowUserAddrObtaining".equals(str)) {
                            if ("SupportEmoticonLinkPrefix".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if ("FunctionFlag".equals(str)) {
                                jSONObject.put(str, bo.getInt(str2, jSONObject.optInt(str)));
                            } else if ("NotifyManage".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if ("ServicePhone".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if ("IsTrademarkProtection".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if (!"CanReceiveLongVideo".equals(str)) {
                                if ("TrademarkUrl".equals(str)) {
                                    jSONObject.put(str, str2);
                                } else if ("TrademarkName".equals(str)) {
                                    jSONObject.put(str, str2);
                                } else if ("MMBizMenu".equals(str)) {
                                    jSONObject.put(str, str2);
                                } else if ("VerifySource".equals(str)) {
                                    jSONObject.put(str, str2);
                                } else if (!"MMBizTabbar".equals(str)) {
                                    if ("PayShowInfo".equals(str)) {
                                        jSONObject.put(str, str2);
                                    } else if ("HardwareBizInfo".equals(str)) {
                                        jSONObject.put(str, str2);
                                    } else if ("EnterpriseBizInfo".equals(str)) {
                                        jSONObject.put(str, str2);
                                    } else if (!"MainPage".equals(str)) {
                                        if ("RegisterSource".equals(str)) {
                                            jSONObject.put(str, str2);
                                        } else if (!"IBeaconBizInfo".equals(str)) {
                                            if ("WxaAppInfo".equals(str)) {
                                                jSONObject.put(str, str2);
                                            } else if ("WxaAppVersionInfo".equals(str)) {
                                                jSONObject.put(str, str2);
                                            } else if ("WXAppType".equals(str)) {
                                                jSONObject.put(str, str2);
                                            } else if ("BindWxaInfo".equals(str)) {
                                                jSONObject.put(str, str2);
                                            } else if ("AcctTransferInfo".equals(str)) {
                                                jSONObject.put(str, str2);
                                            } else {
                                                AppMethodBeat.o(11248);
                                                return false;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (JSONException e) {
            ab.e("MicroMsg.BizAttrRenovator", "updateExtInfoAttrs failed, key(%s) value(%s), exception : %s.", str, str2, e);
        }
        AppMethodBeat.o(11248);
        return true;
    }
}
