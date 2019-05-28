package com.tencent.p177mm.p184aj;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41732d;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C45146p.C25773a;
import com.tencent.p177mm.p184aj.C8935m.C8938a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.protocal.protobuf.C40537kb;
import com.tencent.p177mm.protocal.protobuf.C44132kc;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.aj.a */
public final class C32237a {
    private static String fuG = "";
    private static long fuH = 0;

    /* renamed from: qy */
    public static void m52584qy(String str) {
        AppMethodBeat.m2504i(11241);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(11241);
            return;
        }
        C16527d qP = C41747z.aeR().mo43729qP(str);
        qP.field_attrSyncVersion = null;
        qP.field_incrementUpdateTime = 0;
        C41747z.aeR().mo43726e(qP);
        AppMethodBeat.m2505o(11241);
    }

    /* renamed from: qz */
    public static void m52585qz(String str) {
        AppMethodBeat.m2504i(11242);
        fuG = str;
        fuH = System.currentTimeMillis();
        AppMethodBeat.m2505o(11242);
    }

    /* renamed from: qA */
    public static boolean m52583qA(String str) {
        AppMethodBeat.m2504i(11243);
        if (!C5046bo.isEqual(fuG, str) || System.currentTimeMillis() - fuH >= 1000) {
            AppMethodBeat.m2505o(11243);
            return false;
        }
        AppMethodBeat.m2505o(11243);
        return true;
    }

    /* renamed from: b */
    static boolean m52581b(C16527d c16527d) {
        AppMethodBeat.m2504i(11244);
        if (c16527d == null) {
            C4990ab.m7416i("MicroMsg.BizAttrRenovator", "BizInfo is null.");
            AppMethodBeat.m2505o(11244);
            return false;
        } else if (C32237a.adG()) {
            int i = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getInt("MMBizAttrSyncFreq", -1);
            if (i == -1) {
                C4990ab.m7416i("MicroMsg.BizAttrRenovator", "MMBizAttrSyncFreq is null.");
                i = 3600;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = c16527d.field_incrementUpdateTime;
            String str = c16527d.field_attrSyncVersion;
            C4990ab.m7417i("MicroMsg.BizAttrRenovator", "currentMS(%d), lastUpdateTime(%d), freq(%d), version(%s).", Long.valueOf(currentTimeMillis), Long.valueOf(j), Integer.valueOf(i), str);
            if (currentTimeMillis - j >= ((long) i) * 1000) {
                AppMethodBeat.m2505o(11244);
                return true;
            }
            AppMethodBeat.m2505o(11244);
            return false;
        } else {
            AppMethodBeat.m2505o(11244);
            return false;
        }
    }

    public static boolean adG() {
        int i;
        AppMethodBeat.m2504i(11245);
        Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_BIZ_ATTR_SYNC_OPEN_FLAG_INT, null);
        if (obj == null || !(obj instanceof Integer)) {
            C4990ab.m7416i("MicroMsg.BizAttrRenovator", "openFlag is null.");
            i = 1;
        } else {
            i = ((Integer) obj).intValue();
        }
        C4990ab.m7417i("MicroMsg.BizAttrRenovator", "openFlag is %d.", Integer.valueOf(i));
        if (i == 1) {
            AppMethodBeat.m2505o(11245);
            return true;
        }
        AppMethodBeat.m2505o(11245);
        return false;
    }

    /* renamed from: qB */
    public final boolean mo52930qB(final String str) {
        AppMethodBeat.m2504i(11246);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes failed, username is null or nil.");
            AppMethodBeat.m2505o(11246);
            return false;
        } else if (C32237a.m52583qA(str)) {
            C4990ab.m7416i("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes failed, username is just delete.");
            AppMethodBeat.m2505o(11246);
            return false;
        } else {
            C4990ab.m7410d("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes");
            C16527d qP = C41747z.aeR().mo43729qP(str);
            if (C32237a.m52581b(qP)) {
                final WeakReference weakReference = new WeakReference(null);
                C1720g.m3535RO().eJo.mo14541a(new C45146p(str, qP.field_attrSyncVersion, new C25773a<C45146p>() {
                    /* renamed from: a */
                    public final /* synthetic */ void mo43736a(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(11240);
                        C45146p c45146p = (C45146p) c1207m;
                        C4990ab.m7416i("MicroMsg.BizAttrRenovator", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
                        if (C32237a.m52583qA(str)) {
                            C4990ab.m7416i("MicroMsg.BizAttrRenovator", "onNetSceneEndCallback return, username is just delete.");
                            AppMethodBeat.m2505o(11240);
                            return;
                        }
                        if (weakReference != null) {
                            weakReference.get();
                        }
                        if (i == 0 && i2 == 0) {
                            C40537kb c40537kb;
                            if (c45146p.ehh == null || c45146p.ehh.fsH.fsP == null) {
                                c40537kb = null;
                            } else {
                                c40537kb = (C40537kb) c45146p.ehh.fsH.fsP;
                            }
                            if (c40537kb == null) {
                                C4990ab.m7412e("MicroMsg.BizAttrRenovator", "resp is null.");
                                AppMethodBeat.m2505o(11240);
                                return;
                            }
                            String str2;
                            int i3;
                            String str3 = "MicroMsg.BizAttrRenovator";
                            String str4 = "[BizAttr] biz(%s) Attribute LastAttrVersion = %s, UpdateInfoList.size = %s";
                            Object[] objArr = new Object[3];
                            objArr[0] = str;
                            if (c40537kb.vMS == null) {
                                str2 = null;
                            } else {
                                str2 = new String(c40537kb.vMS.f1226wR);
                            }
                            objArr[1] = str2;
                            if (c40537kb.vMT == null) {
                                i3 = 0;
                            } else {
                                i3 = c40537kb.vMT.size();
                            }
                            objArr[2] = Integer.valueOf(i3);
                            C4990ab.m7417i(str3, str4, objArr);
                            if (c40537kb.vMT == null) {
                                C4990ab.m7412e("MicroMsg.BizAttrRenovator", "[BizAttr] resp.UpdateInfoList null");
                                AppMethodBeat.m2505o(11240);
                                return;
                            }
                            boolean z;
                            str3 = str;
                            LinkedList linkedList = c40537kb.vMT;
                            if (C5046bo.isNullOrNil(str3)) {
                                C4990ab.m7412e("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, username is null.");
                                z = false;
                            } else {
                                C16527d qP = C41747z.aeR().mo43729qP(str3);
                                if (C32237a.m52581b(qP)) {
                                    C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str3);
                                    if (aoO == null || ((int) aoO.ewQ) == 0 || !aoO.dsf()) {
                                        C4990ab.m7421w("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, contact do not exist.(username : %s)", str3);
                                        z = false;
                                    } else {
                                        if (C5046bo.isNullOrNil(aoO.field_username)) {
                                            aoO.setUsername(str3);
                                        }
                                        z = C32237a.m52580a(aoO, qP, linkedList);
                                    }
                                } else {
                                    C4990ab.m7417i("MicroMsg.BizAttrRenovator", "Do not need to update bizAttrs now.(username : %s)", str3);
                                    z = false;
                                }
                            }
                            if (z) {
                                if (c40537kb.vMS != null) {
                                    str2 = str;
                                    String cd = C5046bo.m7543cd(c40537kb.vMS.f1226wR);
                                    if (C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(cd)) {
                                        z = false;
                                    } else {
                                        z = C41747z.aeR().mo16768hY("BizInfo", String.format("update %s set %s='%s', %s=%d where %s='%s'", new Object[]{"BizInfo", "attrSyncVersion", cd, "incrementUpdateTime", Long.valueOf(System.currentTimeMillis()), "username", str2}));
                                    }
                                    C4990ab.m7417i("MicroMsg.BizAttrRenovator", "Update attrSyncVersion of bizInfo succ = %b.", Boolean.valueOf(z));
                                }
                                AppMethodBeat.m2505o(11240);
                                return;
                            }
                            C4990ab.m7416i("MicroMsg.BizAttrRenovator", "notifyDataSetChanged, after updateBizAttributes.");
                            AppMethodBeat.m2505o(11240);
                            return;
                        }
                        C4990ab.m7413e("MicroMsg.BizAttrRenovator", "scene.getType() = %s", Integer.valueOf(c45146p.getType()));
                        AppMethodBeat.m2505o(11240);
                    }
                }), 0);
                AppMethodBeat.m2505o(11246);
                return true;
            }
            C4990ab.m7416i("MicroMsg.BizAttrRenovator", "do not need to update biz attrs now.");
            AppMethodBeat.m2505o(11246);
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
    /* renamed from: a */
    public static boolean m52580a(C7616ad c7616ad, C16527d c16527d, List<C44132kc> list) {
        AppMethodBeat.m2504i(11247);
        if (c7616ad == null || list == null || list.size() == 0) {
            C4990ab.m7412e("MicroMsg.BizAttrRenovator", "updateBizAttributes failed.");
            AppMethodBeat.m2505o(11247);
            return false;
        }
        String str = c7616ad.field_username;
        if (c7616ad.dsf()) {
            if (c16527d == null) {
                c16527d = C41747z.aeR().mo43729qP(str);
            }
            if (c16527d == null) {
                C4990ab.m7417i("MicroMsg.BizAttrRenovator", "BizInfo is null.(username : %s)", str);
                AppMethodBeat.m2505o(11247);
                return false;
            }
            JSONObject jSONObject;
            int i;
            C17880h qo = C17884o.act().mo33392qo(str);
            try {
                if (C5046bo.isNullOrNil(c16527d.field_extInfo)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(c16527d.field_extInfo);
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.BizAttrRenovator", "create Json object from extInfo error. %s.", e);
                jSONObject = new JSONObject();
            }
            long j = -1;
            long j2 = (long) c7616ad.field_type;
            int i2 = 0;
            Object obj = null;
            for (C44132kc c44132kc : list) {
                if (c44132kc == null) {
                    C4990ab.m7420w("MicroMsg.BizAttrRenovator", "keyValue is null.");
                } else {
                    Object obj2;
                    String str2 = c44132kc.vMU;
                    C4990ab.m7417i("MicroMsg.BizAttrRenovator", "[BizAttr] UpdateInfoList key = %s, value = %s", str2, c44132kc.pXM);
                    String str3 = c44132kc.pXM;
                    if (!"UserName".equals(str2)) {
                        if ("NickName".equals(str2)) {
                            c7616ad.mo14703iB(str3);
                        } else if ("Alias".equals(str2)) {
                            c7616ad.mo14728iy(str3);
                        } else if ("PYInitial".equals(str2)) {
                            c7616ad.mo14704iC(str3);
                        } else if ("QuanPin".equals(str2)) {
                            c7616ad.mo14705iD(str3);
                        } else if ("VerifyFlag".equals(str2)) {
                            c7616ad.mo14698hw(C5046bo.getInt(str3, c7616ad.field_verifyFlag));
                        } else if ("VerifyInfo".equals(str2)) {
                            c7616ad.mo14723iV(str3);
                        } else if ("Signature".equals(str2)) {
                            c7616ad.mo14718iQ(str3);
                        } else {
                            obj2 = null;
                            if (obj2 == null && !C32237a.m52582b(jSONObject, str2, c44132kc.pXM)) {
                                str3 = c44132kc.pXM;
                                if (!"BrandInfo".equals(str2)) {
                                    c16527d.field_brandInfo = str3;
                                } else if ("BrandIconURL".equals(str2)) {
                                    c16527d.field_brandIconURL = str3;
                                } else if ("BrandFlag".equals(str2)) {
                                    c16527d.field_brandFlag = C5046bo.getInt(str3, c16527d.field_brandFlag);
                                } else {
                                    if (!"Appid".equals(str2)) {
                                        obj2 = null;
                                    } else if (str3.equals(c16527d.field_appId)) {
                                        obj2 = null;
                                    } else {
                                        c16527d.field_appId = str3;
                                    }
                                    if (obj2 == null) {
                                        str3 = c44132kc.pXM;
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
                                                j = C5046bo.getLong(c44132kc.pXM, j);
                                                i2++;
                                            } else {
                                                if ("BitVal".equals(str2)) {
                                                    j2 = C5046bo.getLong(c44132kc.pXM, j2);
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
                    str3 = c44132kc.pXM;
                    if (!"BrandInfo".equals(str2)) {
                    }
                    obj2 = 1;
                    if (obj2 == null) {
                    }
                    i2++;
                }
            }
            if (i2 == 0) {
                C4990ab.m7416i("MicroMsg.BizAttrRenovator", "None attribute has been updated.");
                AppMethodBeat.m2505o(11247);
                return false;
            }
            c16527d.field_extInfo = jSONObject.toString();
            if (!(qo == null || obj == null)) {
                C17884o.act().mo33391b(qo);
                C17884o.acd();
                C41732d.m73516E(str, false);
                C17884o.acd();
                C41732d.m73516E(str, true);
                C17884o.acv().mo67495pZ(str);
                C8938a afb = C41747z.afb();
                if (!C5046bo.isNullOrNil(str)) {
                    C4990ab.m7411d("MicroMsg.BrandLogic", "remove cache by brandKey : %s", str);
                    WeakReference weakReference = (WeakReference) afb.fwK.remove(str);
                    if (weakReference != null) {
                        Bitmap bitmap = (Bitmap) weakReference.get();
                        if (bitmap != null) {
                            bitmap.isRecycled();
                        }
                    }
                }
            }
            c7616ad.setType(c7616ad.field_type | ((int) (j & j2)));
            i = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15724b(str, c7616ad);
            C41747z.aeR().mo43726e(c16527d);
            if (i == 1) {
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo10120b(4, (C7298n) ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM(), str);
            }
            C4990ab.m7416i("MicroMsg.BizAttrRenovator", "Update bizInfo attributes successfully.");
            AppMethodBeat.m2505o(11247);
            return true;
        }
        C4990ab.m7421w("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, contact is not a biz contact.(username : %s)", str);
        AppMethodBeat.m2505o(11247);
        return false;
    }

    /* renamed from: b */
    private static boolean m52582b(JSONObject jSONObject, String str, String str2) {
        AppMethodBeat.m2504i(11248);
        try {
            if ("IsShowHeadImgInMsg".equals(str)) {
                jSONObject.put(str, str2);
            } else if ("IsHideInputToolbarInMsg".equals(str)) {
                jSONObject.put(str, str2);
            } else if (!"IsAgreeProtocol".equals(str)) {
                if ("InteractiveMode".equals(str)) {
                    jSONObject.put(str, C5046bo.getInt(str2, jSONObject.optInt(str)));
                } else if ("CanReceiveSpeexVoice".equals(str)) {
                    jSONObject.put(str, str2);
                } else if ("ConnectorMsgType".equals(str)) {
                    jSONObject.put(str, C5046bo.getInt(str2, jSONObject.optInt(str)));
                } else if ("ReportLocationType".equals(str)) {
                    jSONObject.put(str, C5046bo.getInt(str2, jSONObject.optInt(str)));
                } else if ("AudioPlayType".equals(str)) {
                    jSONObject.put(str, C5046bo.getInt(str2, jSONObject.optInt(str)));
                } else if ("IsShowMember".equals(str)) {
                    jSONObject.put(str, str2);
                } else if ("ConferenceContactExpireTime".equals(str)) {
                    jSONObject.put(str, str2);
                } else if (!"VerifyMsg2Remark".equals(str)) {
                    if ("VerifyContactPromptTitle".equals(str)) {
                        jSONObject.put(str, str2);
                    } else if (!"IsSubscribeStat".equals(str)) {
                        if ("ScanQRCodeType".equals(str)) {
                            jSONObject.put(str, C5046bo.getInt(str2, jSONObject.optInt(str)));
                        } else if ("ServiceType".equals(str)) {
                            jSONObject.put(str, C5046bo.getInt(str2, jSONObject.optInt(str)));
                        } else if (!"NeedShowUserAddrObtaining".equals(str)) {
                            if ("SupportEmoticonLinkPrefix".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if ("FunctionFlag".equals(str)) {
                                jSONObject.put(str, C5046bo.getInt(str2, jSONObject.optInt(str)));
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
                                                AppMethodBeat.m2505o(11248);
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
            C4990ab.m7413e("MicroMsg.BizAttrRenovator", "updateExtInfoAttrs failed, key(%s) value(%s), exception : %s.", str, str2, e);
        }
        AppMethodBeat.m2505o(11248);
        return true;
    }
}
