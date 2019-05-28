package com.tencent.mm.plugin.ext;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.qq.wx.voice.embed.recognizer.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.g.a.fb;
import com.tencent.mm.g.a.fj;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi;
import com.tencent.mm.plugin.ext.provider.ExtControlProviderEntry;
import com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg;
import com.tencent.mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.x;
import com.tencent.mm.pluginsdk.model.i;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.z;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import junit.framework.Assert;

public class b implements at {
    private static HashMap<Integer, d> eaA;
    private static boolean lPw = false;
    private final long lPg = 1600;
    private z lPh;
    private bp lPi;
    private ca lPj;
    private a lPk;
    private b lPl;
    private HashMap<String, Integer> lPm = new HashMap();
    private com.tencent.mm.plugin.messenger.foundation.a.a.h.a lPn = new com.tencent.mm.plugin.messenger.foundation.a.a.h.a() {
        /* JADX WARNING: Missing block: B:49:0x012c, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(20263);
     */
        /* JADX WARNING: Missing block: B:64:?, code skipped:
            return;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(h hVar, c cVar) {
            AppMethodBeat.i(20263);
            if (hVar == null || cVar == null || cVar.oqK == null) {
                ab.e("MicroMsg.SubCoreExt", "onMsgChange, wrong args");
                AppMethodBeat.o(20263);
                return;
            }
            synchronized (b.this) {
                try {
                    Cursor dui = b.brA().dui();
                    if (dui == null) {
                        ab.i("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange getValidOpenMsgListener cu == null");
                    } else {
                        ab.d("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange listener count = %s", Integer.valueOf(dui.getCount()));
                        if (dui.getCount() <= 0) {
                            dui.close();
                            ab.i("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange cu.getCount() <= 0");
                            AppMethodBeat.o(20263);
                            return;
                        }
                        dui.close();
                        for (int i = 0; i < cVar.oqK.size(); i++) {
                            bi biVar = (bi) cVar.oqK.get(i);
                            if (!(biVar == null || biVar.field_isSend != 0 || biVar.field_status == 4 || biVar.getType() == 9999 || biVar.getType() == Downloads.MIN_WAIT_FOR_NETWORK || t.nJ(biVar.field_talker) || t.nN(biVar.field_talker))) {
                                Integer num = (Integer) b.this.lPm.get(biVar.field_talker);
                                if (num == null) {
                                    b.this.lPm.put(biVar.field_talker, Integer.valueOf(1));
                                    ab.d("MicroMsg.SubCoreExt", "onMsgChange %s, %d", biVar.field_talker, Integer.valueOf(1));
                                } else {
                                    b.this.lPm.put(biVar.field_talker, Integer.valueOf(num.intValue() + 1));
                                    ab.d("MicroMsg.SubCoreExt", "onMsgChange %s, %d", biVar.field_talker, Integer.valueOf(num.intValue() + 1));
                                }
                            }
                        }
                        if (b.this.lPm.size() > 0) {
                            b.this.brF();
                        } else {
                            ab.i("MicroMsg.SubCoreExt", "notifyMsgUsers.size < 1");
                        }
                    }
                } finally {
                    AppMethodBeat.o(20263);
                }
            }
        }
    };
    com.tencent.mm.pluginsdk.model.i.a lPo = new com.tencent.mm.pluginsdk.model.i.a() {
        public final void a(l lVar) {
            AppMethodBeat.i(20264);
            if (lVar == null) {
                AppMethodBeat.o(20264);
                return;
            }
            Iterator it = lVar.dhk().wtB.iterator();
            int i = 0;
            while (it.hasNext()) {
                cmf cmf = (cmf) it.next();
                ab.v("MicroMsg.SubCoreExt", "AppId[%s], UserName[%s], Xml[%s]", lVar.hzi, cmf.jBB, cmf.xkk);
                if (!(bo.isNullOrNil(cmf.jBB) || bo.isNullOrNil(cmf.xkk))) {
                    aw.ZK();
                    ad aoM = com.tencent.mm.model.c.XM().aoM(cmf.jBB);
                    if (aoM == null || ((int) aoM.ewQ) <= 0) {
                        ab.e("MicroMsg.SubCoreExt", "contact is null");
                    } else if (aoM.dsf()) {
                        ab.w("MicroMsg.SubCoreExt", "isBizContact");
                    } else {
                        com.tencent.mm.pluginsdk.model.i.b aiA = i.aiA(cmf.xkk);
                        if (!(aiA == null || bo.isNullOrNil(aiA.vbf))) {
                            ab.v("MicroMsg.SubCoreExt", "AppId[%s], openId[%s]", lVar.hzi, aiA.vbf);
                            b.brB().a(new bz(lVar.hzi, cmf.jBB, aiA.vbf));
                            i = 1;
                        }
                    }
                }
            }
            if (i != 0) {
                b.this.brF();
            }
            AppMethodBeat.o(20264);
        }
    };
    private ak lPp = new ak(Looper.getMainLooper()) {
        @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140514", reviewer = 20, vComment = {EType.INTENTCHECK})
        public final void handleMessage(Message message) {
            AppMethodBeat.i(20266);
            if (ah.getContext() == null || !aw.RK()) {
                ab.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong status");
                AppMethodBeat.o(20266);
                return;
            }
            Cursor dui = b.brA().dui();
            if (dui == null) {
                ab.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler getValidOpenMsgListener cu == null");
                AppMethodBeat.o(20266);
                return;
            }
            ab.d("MicroMsg.SubCoreExt", "notifyMsgChangeHandler listener count = %s", Integer.valueOf(dui.getCount()));
            if (dui.getCount() <= 0) {
                dui.close();
                ab.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler cu.getCount() <= 0");
                AppMethodBeat.o(20266);
                return;
            }
            try {
                if (dui.moveToFirst()) {
                    HashMap hashMap = new HashMap();
                    synchronized (b.this) {
                        hashMap.putAll(b.this.lPm);
                        b.this.lPm.clear();
                    }
                    do {
                        LinkedList linkedList = new LinkedList();
                        ArrayList arrayList = new ArrayList();
                        if (hashMap.entrySet() == null) {
                            ab.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler waitForNotify.entrySet() == null");
                            AppMethodBeat.o(20266);
                            return;
                        }
                        com.tencent.mm.storage.bo boVar = new com.tencent.mm.storage.bo();
                        boVar.d(dui);
                        if (bo.isNullOrNil(boVar.field_appId) || bo.isNullOrNil(boVar.field_packageName)) {
                            ab.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong msgListener, appid = %s, package = %s", boVar.field_appId, boVar.field_packageName);
                        } else {
                            for (Entry entry : hashMap.entrySet()) {
                                String nullAsNil = bo.nullAsNil((String) entry.getKey());
                                Integer num = (Integer) entry.getValue();
                                aw.ZK();
                                com.tencent.mm.storage.ak aoZ = com.tencent.mm.model.c.XR().aoZ(nullAsNil);
                                if (aoZ != null && !bo.isNullOrNil(aoZ.field_username) && aoZ.field_unReadCount <= 0) {
                                    ab.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler no unread in conversation");
                                } else if (!(t.nJ(nullAsNil) || t.kH(nullAsNil) || t.mZ(nullAsNil))) {
                                    bz bzVar;
                                    ca brB = b.brB();
                                    String str = boVar.field_appId;
                                    if (str == null || str.length() <= 0 || nullAsNil == null || nullAsNil.length() <= 0) {
                                        bzVar = null;
                                    } else {
                                        Cursor a = brB.bSd.a("UserOpenIdInApp", null, "appId=? and username=? ", new String[]{bo.vA(str), bo.vA(nullAsNil)}, null, null, null, 2);
                                        if (a.moveToFirst()) {
                                            bzVar = new bz();
                                            bzVar.d(a);
                                            a.close();
                                        } else {
                                            ab.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with appId-%s, username-%s:", str, nullAsNil);
                                            a.close();
                                            bzVar = null;
                                        }
                                    }
                                    if (bzVar == null || bo.isNullOrNil(bzVar.field_openId) || bo.isNullOrNil(bzVar.field_username)) {
                                        ab.d("MicroMsg.SubCoreExt", "notifyMsgChangeHandler openId is null, go get it.");
                                        Integer num2 = (Integer) b.this.lPm.get(nullAsNil);
                                        if (num2 == null) {
                                            b.this.lPm.put(nullAsNil, num);
                                        } else {
                                            b.this.lPm.put(nullAsNil, Integer.valueOf(num2.intValue() + num.intValue()));
                                        }
                                        linkedList.add(nullAsNil);
                                    } else {
                                        ab.v("MicroMsg.SubCoreExt", "username[%s], appId[%s], openId[%s]", bzVar.field_username, bzVar.field_appId, bzVar.field_openId);
                                        arrayList.add(String.format("%s,%s,%s", new Object[]{bzVar.field_openId, num, Long.valueOf(System.currentTimeMillis() - 1600)}));
                                    }
                                }
                            }
                            if (linkedList.size() > 0) {
                                ab.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler doGetGetUserInfoInApp");
                                b bVar = b.this;
                                String str2 = boVar.field_appId;
                                if (!bo.isNullOrNil(str2) && linkedList.size() > 0) {
                                    i dgZ = i.dgZ();
                                    Context context = ah.getContext();
                                    com.tencent.mm.pluginsdk.model.i.a aVar = bVar.lPo;
                                    ab.d("MicroMsg.GetUserInfoInAppLogic", "getGetUserInfoInApp");
                                    if (!i.vbc) {
                                        dgZ.dha();
                                    }
                                    if (aw.RK() && context != null) {
                                        if (linkedList.size() == 0) {
                                            ab.d("MicroMsg.GetUserInfoInAppLogic", "userNameList empty");
                                        } else {
                                            dgZ.vbe = aVar;
                                            x lVar = new l(str2, linkedList);
                                            am.bYM();
                                            com.tencent.mm.pluginsdk.model.app.d.a(14, lVar);
                                        }
                                    }
                                }
                            }
                            if (arrayList.size() <= 0) {
                                dui.close();
                                ab.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler userDataList.size() <= 0");
                                AppMethodBeat.o(20266);
                                return;
                            }
                            Object obj;
                            if (boVar.field_status == 1) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj == null) {
                                ab.w("MicroMsg.SubCoreExt", "invalid msgListener, appid = %s, package = %s", boVar.field_appId, boVar.field_packageName);
                            } else if (!(bo.isNullOrNil(boVar.field_appId) || bo.isNullOrNil(boVar.field_packageName))) {
                                ab.i("MicroMsg.SubCoreExt", "notify app, appId = %s, package = %s", boVar.field_appId, boVar.field_packageName);
                                final Intent intent = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_NOTIFY_MSG");
                                intent.addCategory("com.tencent.mm.category." + boVar.field_packageName);
                                com.tencent.mm.compatible.a.a.a(12, new com.tencent.mm.compatible.a.a.a() {
                                    public final void run() {
                                        AppMethodBeat.i(20265);
                                        intent.setFlags(32);
                                        AppMethodBeat.o(20265);
                                    }
                                });
                                intent.putExtra("EXTRA_EXT_OPEN_NOTIFY_TYPE", "NEW_MESSAGE");
                                intent.putStringArrayListExtra("EXTRA_EXT_OPEN_USER_DATA", arrayList);
                                ah.getContext().sendBroadcast(intent);
                            }
                        }
                    } while (dui.moveToNext());
                }
                dui.close();
                AppMethodBeat.o(20266);
            } catch (Exception e) {
                ab.e("MicroMsg.SubCoreExt", "Exception in handleMessage, %s", e.getMessage());
                if (dui != null) {
                    dui.close();
                }
                AppMethodBeat.o(20266);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(20266);
                    throw th;
                }
            }
        }
    };
    private LinkedList<String> lPq = new LinkedList();
    private final long lPr = 60;
    private ak lPs = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(20267);
            try {
                if (b.this.lPq.size() <= 0) {
                    AppMethodBeat.o(20267);
                    return;
                }
                Iterator it = b.this.lPq.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (!"*".equals(str)) {
                        f bT = g.bT(str, false);
                        if (bT == null) {
                            ab.w("MicroMsg.SubCoreExt", "appInfo is null");
                        } else if (bo.isNullOrNil(bT.field_appId)) {
                            ab.w("MicroMsg.SubCoreExt", "appId is null");
                        } else {
                            ab.d("MicroMsg.SubCoreExt", "onAppInfoStgChange, notify[%s], appFlag[%s], id[%s]", str, Integer.valueOf(bT.field_appInfoFlag), bT.field_appId);
                            com.tencent.mm.storage.bo apN = b.brA().apN(bT.field_appId);
                            if (apN == null) {
                                ab.w("MicroMsg.SubCoreExt", "openMsgListener is null, appId = %s", bT.field_appId);
                            } else {
                                if (g.k(bT)) {
                                    if (apN.field_status != 1) {
                                        apN.field_status = 1;
                                    }
                                } else if (apN.field_status != 0) {
                                    apN.field_status = 0;
                                }
                                bp brA = b.brA();
                                if (bo.isNullOrNil(bT.field_appId) || apN == null || bo.isNullOrNil(apN.field_appId)) {
                                    ab.w("MicroMsg.OpenMsgListenerStorage", "wrong argument");
                                } else {
                                    int update;
                                    ContentValues Hl = apN.Hl();
                                    if (Hl.size() > 0) {
                                        update = brA.bSd.update("OpenMsgListener", Hl, "appId=?", new String[]{bo.vA(r3)});
                                    } else {
                                        update = 0;
                                    }
                                    ab.d("MicroMsg.OpenMsgListenerStorage", "update: id=%s, ret=%s ", apN.field_appId, Integer.valueOf(update));
                                }
                            }
                        }
                    }
                }
                b.this.lPq.clear();
                AppMethodBeat.o(20267);
            } catch (Exception e) {
                ab.e("MicroMsg.SubCoreExt", "exception in onAppInfoStgChange, %s", e.getMessage());
                AppMethodBeat.o(20267);
            }
        }
    };
    private com.tencent.mm.sdk.e.k.a lPt = new com.tencent.mm.sdk.e.k.a() {
        public final void a(String str, m mVar) {
            AppMethodBeat.i(20268);
            if (!b.this.lPq.contains(str)) {
                b.this.lPq.add(str);
            }
            b.this.lPs.removeMessages(0);
            b.this.lPs.sendEmptyMessageDelayed(0, 60);
            AppMethodBeat.o(20268);
        }
    };
    private boolean lPu = true;
    private boolean lPv = false;
    com.tencent.mm.sdk.e.n.b luz = new com.tencent.mm.sdk.e.n.b() {
        public final void a(int i, n nVar, Object obj) {
            AppMethodBeat.i(20269);
            if (obj == null || !(obj instanceof String)) {
                ab.d("MicroMsg.SubCoreExt", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), nVar, obj);
                AppMethodBeat.o(20269);
            } else if (aw.RK()) {
                aw.ZK();
                if (nVar == com.tencent.mm.model.c.XM()) {
                    b.d(b.this);
                }
                AppMethodBeat.o(20269);
            } else {
                ab.i("MicroMsg.SubCoreExt", "onNotifyChange acc not ready");
                AppMethodBeat.o(20269);
            }
        }
    };

    public static class a extends com.tencent.mm.sdk.b.c<fj> {
        public a() {
            AppMethodBeat.i(20270);
            this.xxI = fj.class.getName().hashCode();
            AppMethodBeat.o(20270);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(20271);
            fj fjVar = (fj) bVar;
            if (!(fjVar instanceof fj)) {
                ab.f("MicroMsg.SubCoreExt", "mismatched event");
                AppMethodBeat.o(20271);
                return false;
            } else if (fjVar.czd == null) {
                ab.e("MicroMsg.SubCoreExt", "revent.data is null");
                AppMethodBeat.o(20271);
                return false;
            } else {
                if (fjVar.czd.cyy == 9 || fjVar.czd.cyy == 13) {
                    ExtControlProviderMsg extControlProviderMsg = new ExtControlProviderMsg(fjVar.czd.crW, fjVar.czd.cyy, fjVar.czd.context);
                    fjVar.cze.cyz = extControlProviderMsg.query(fjVar.czd.uri, null, null, fjVar.czd.selectionArgs, null);
                } else if (fjVar.czd.cyy == 3) {
                    ExtControlProviderEntry extControlProviderEntry = new ExtControlProviderEntry(fjVar.czd.crW, fjVar.czd.cyy, fjVar.czd.context);
                    fjVar.cze.cyz = extControlProviderEntry.query(fjVar.czd.uri, null, null, fjVar.czd.selectionArgs, null);
                } else if (fjVar.czd.cyy == 29) {
                    ExtControlProviderVoiceControl extControlProviderVoiceControl = new ExtControlProviderVoiceControl(fjVar.czd.crW, fjVar.czd.cyy, fjVar.czd.context);
                    fjVar.cze.cyz = extControlProviderVoiceControl.query(fjVar.czd.uri, null, null, fjVar.czd.selectionArgs, null);
                    SharedPreferences doB = ah.doB();
                    if (!b.lPw) {
                        doB.edit().putBoolean("hasCallVoiceControlApi", true).commit();
                        b.lPw = true;
                    }
                } else {
                    ExtControlProviderOpenApi extControlProviderOpenApi = new ExtControlProviderOpenApi(fjVar.czd.crW, fjVar.czd.cyy, fjVar.czd.context);
                    fjVar.cze.cyz = extControlProviderOpenApi.query(fjVar.czd.uri, null, null, fjVar.czd.selectionArgs, null);
                }
                AppMethodBeat.o(20271);
                return true;
            }
        }
    }

    public static class b extends com.tencent.mm.sdk.b.c<fp> {
        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(20273);
            fp fpVar = (fp) bVar;
            if (fpVar.czu == null) {
                ab.e("MicroMsg.SubCoreExt", "StepCount revent.data is null");
            } else {
                ab.i("MicroMsg.SubCoreExt", " action = " + fpVar.czu.action);
                if (fpVar.czu.action == 1) {
                    b.brE();
                    ab.d("MicroMsg.SubCoreExt", " sendBroadcast");
                    AppMethodBeat.o(20273);
                    return true;
                }
            }
            AppMethodBeat.o(20273);
            return false;
        }

        public b() {
            super(0);
            AppMethodBeat.i(20272);
            this.xxI = fp.class.getName().hashCode();
            AppMethodBeat.o(20272);
        }
    }

    public b() {
        AppMethodBeat.i(20274);
        AppMethodBeat.o(20274);
    }

    static /* synthetic */ void d(b bVar) {
        AppMethodBeat.i(20289);
        bVar.gT(false);
        AppMethodBeat.o(20289);
    }

    static {
        AppMethodBeat.i(20290);
        int Lw = com.tencent.mm.compatible.e.m.Lw();
        try {
            if (!Build.CPU_ABI.contains("armeabi")) {
                ab.e("hakon SilkCodec", "x86 machines not supported.");
            } else if ((Lw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                k.a("wechatvoicesilk_v7a", b.class.getClassLoader());
            } else if ((Lw & 512) != 0) {
                k.a("wechatvoicesilk", b.class.getClassLoader());
                Assert.assertTrue("Can't remove libwechatvoicesilk.so yet.", false);
            } else {
                ab.e("hakon SilkCodec", "load library failed! silk don't support armv5!!!!");
            }
        } catch (Exception e) {
            ab.e("hakon SilkCodec", "load library failed!");
        }
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("OPENMSGLISTENER_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return bp.fnj;
            }
        });
        eaA.put(Integer.valueOf("USEROPENIDINAPP_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return ca.fnj;
            }
        });
        AppMethodBeat.o(20290);
    }

    public static b bry() {
        AppMethodBeat.i(20275);
        aw.ZE();
        b bVar = (b) bw.oJ("plugin.ext");
        if (bVar == null) {
            bVar = new b();
            aw.ZE().a("plugin.ext", bVar);
        }
        AppMethodBeat.o(20275);
        return bVar;
    }

    public static z brz() {
        AppMethodBeat.i(20276);
        com.tencent.mm.kernel.g.RN().QU();
        if (bry().lPh == null) {
            b bry = bry();
            aw.ZK();
            bry.lPh = new z(com.tencent.mm.model.c.Ru());
        }
        z zVar = bry().lPh;
        AppMethodBeat.o(20276);
        return zVar;
    }

    public static bp brA() {
        AppMethodBeat.i(20277);
        com.tencent.mm.kernel.g.RN().QU();
        if (bry().lPi == null) {
            b bry = bry();
            aw.ZK();
            bry.lPi = new bp(com.tencent.mm.model.c.Ru());
        }
        bp bpVar = bry().lPi;
        AppMethodBeat.o(20277);
        return bpVar;
    }

    public static ca brB() {
        AppMethodBeat.i(20278);
        com.tencent.mm.kernel.g.RN().QU();
        if (bry().lPj == null) {
            b bry = bry();
            aw.ZK();
            bry.lPj = new ca(com.tencent.mm.model.c.Ru());
        }
        ca caVar = bry().lPj;
        AppMethodBeat.o(20278);
        return caVar;
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public final void bA(boolean z) {
        AppMethodBeat.i(20279);
        brC();
        AppMethodBeat.o(20279);
    }

    private static void brC() {
        AppMethodBeat.i(20280);
        File file = new File(com.tencent.mm.kernel.g.RP().eJM);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(com.tencent.mm.kernel.g.RP().eJM + "image/ext/pcm");
        if (!file.exists()) {
            file.mkdirs();
        }
        ab.i("MicroMsg.SubCoreExt", "summerpcm accPath[%s] [%s]", com.tencent.mm.kernel.g.RP().eJM, bo.dpG());
        AppMethodBeat.o(20280);
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(20281);
        fb fbVar = new fb();
        fbVar.cyt.op = 1;
        if (!com.tencent.mm.sdk.b.a.xxA.m(fbVar)) {
            ab.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountPostReset");
        }
        i.dgZ().dha();
        aw.ZK();
        com.tencent.mm.model.c.XO().a(this.lPn, null);
        if (this.lPk == null) {
            this.lPk = new a();
        }
        com.tencent.mm.sdk.b.a.xxA.c(this.lPk);
        if (this.lPl == null) {
            this.lPl = new b();
        }
        com.tencent.mm.sdk.b.a.xxA.c(this.lPl);
        com.tencent.mm.pluginsdk.model.app.i bYJ = am.bYJ();
        if (bYJ != null) {
            bYJ.c(this.lPt);
        }
        SharedPreferences doB = ah.doB();
        this.lPv = doB.getBoolean("hasTryToInitVoiceControlData", false);
        lPw = doB.getBoolean("hasCallVoiceControlApi", false);
        ab.i("MicroMsg.SubCoreExt", "onAccountPostReset,hasTryToInit:%s,hasCallApi:%s", Boolean.valueOf(this.lPv), Boolean.valueOf(lPw));
        aw.ZK();
        com.tencent.mm.model.c.XM().a(this.luz);
        gT(true);
        com.tencent.mm.plugin.ext.c.c.brT();
        brC();
        AppMethodBeat.o(20281);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(20282);
        if (this.lPk != null) {
            com.tencent.mm.sdk.b.a.xxA.d(this.lPk);
        }
        if (this.lPl != null) {
            com.tencent.mm.sdk.b.a.xxA.d(this.lPl);
        }
        com.tencent.mm.pluginsdk.model.app.i bYJ = am.bYJ();
        if (bYJ != null) {
            bYJ.d(this.lPt);
        }
        aw.ZK();
        com.tencent.mm.model.c.XO().a(this.lPn);
        fb fbVar = new fb();
        fbVar.cyt.op = 2;
        if (!com.tencent.mm.sdk.b.a.xxA.m(fbVar)) {
            ab.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountRelease");
        }
        i dgZ = i.dgZ();
        if (aw.RK()) {
            i.vbc = false;
            am.bYM().b(14, dgZ);
        }
        aw.ZK();
        com.tencent.mm.model.c.XM().b(this.luz);
        com.tencent.mm.plugin.ext.c.c.brU();
        AppMethodBeat.o(20282);
    }

    public static String brD() {
        AppMethodBeat.i(20283);
        String str = com.tencent.mm.kernel.g.RP().eJM + "image/ext/pcm";
        AppMethodBeat.o(20283);
        return str;
    }

    public static void brE() {
        AppMethodBeat.i(20284);
        String str = (String) brz().get(com.tencent.mm.storage.ac.a.USERINFO_EXT_SPORT_PKGNAME_STRING, null);
        ab.i("MicroMsg.SubCoreExt", "sendSportBroadcast pkgNames = ".concat(String.valueOf(str)));
        if (str != null) {
            for (String str2 : str.split(";")) {
                final Intent intent = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_SET_SPORT_STEP");
                intent.setPackage(str2);
                com.tencent.mm.compatible.a.a.a(12, new com.tencent.mm.compatible.a.a.a() {
                    public final void run() {
                        AppMethodBeat.i(20262);
                        intent.setFlags(32);
                        AppMethodBeat.o(20262);
                    }
                });
                intent.putExtra("EXTRA_EXT_OPEN_NOTIFY_TYPE", "SPORT_MESSAGE");
                ah.getContext().sendBroadcast(intent);
            }
        }
        AppMethodBeat.o(20284);
    }

    public final void iy(int i) {
    }

    public static ad ig(long j) {
        AppMethodBeat.i(20285);
        if (!aw.RK() || j <= 0) {
            AppMethodBeat.o(20285);
            return null;
        }
        aw.ZK();
        ad mQ = com.tencent.mm.model.c.XM().mQ(j);
        AppMethodBeat.o(20285);
        return mQ;
    }

    public static void ih(long j) {
        AppMethodBeat.i(20286);
        if (j <= 0) {
            AppMethodBeat.o(20286);
            return;
        }
        try {
            aw.ZK();
            if (com.tencent.mm.model.c.XO().ji(j)) {
                aw.ZK();
                h XO = com.tencent.mm.model.c.XO();
                aw.ZK();
                XO.aa(com.tencent.mm.model.c.XO().jf(j));
                AppMethodBeat.o(20286);
                return;
            }
            ab.e("MicroMsg.SubCoreExt", "msgId is out of range, ".concat(String.valueOf(j)));
            AppMethodBeat.o(20286);
        } catch (Exception e) {
            ab.e("MicroMsg.SubCoreExt", e.getMessage());
            ab.printErrStackTrace("MicroMsg.SubCoreExt", e, "", new Object[0]);
            AppMethodBeat.o(20286);
        }
    }

    public final void brF() {
        AppMethodBeat.i(20287);
        this.lPp.removeMessages(0);
        this.lPp.sendEmptyMessageDelayed(0, 1600);
        AppMethodBeat.o(20287);
    }

    private void gT(boolean z) {
        AppMethodBeat.i(20288);
        if (!this.lPu) {
            AppMethodBeat.o(20288);
        } else if (z && this.lPv) {
            ab.i("MicroMsg.SubCoreExt", "fromStartApp and already try to init");
            AppMethodBeat.o(20288);
        } else if (z || lPw) {
            ab.i("MicroMsg.SubCoreExt", "initLocalVoiceControl,fromStartApp:%s,hasTryToInit:%s,hasCallApi:%s", Boolean.valueOf(z), Boolean.valueOf(this.lPv), Boolean.valueOf(lPw));
            this.lPu = false;
            aw.RS().m(new Runnable() {
                /* JADX WARNING: Missing block: B:48:0x01c6, code skipped:
            if (r0 >= 0) goto L_0x01c8;
     */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    AppMethodBeat.i(20261);
                    try {
                        String value = com.tencent.mm.m.g.Nu().getValue("VoiceRecognizeSprSoMD5");
                        String value2 = com.tencent.mm.m.g.Nu().getValue("VoiceRecognizeSprDataMD5");
                        if (value == null || value2 == null) {
                            ab.i("MicroMsg.SubCoreExt", "error mMd5So:%s,  mMd5Data:%s", value, value2);
                            b.this.lPu = true;
                            AppMethodBeat.o(20261);
                            return;
                        }
                        int i;
                        String str = "/system/lib/";
                        if (VERSION.SDK_INT >= 24) {
                            str = "/vendor/lib/";
                        }
                        ab.i("MicroMsg.SubCoreExt", "mMd5So:%s,  mMd5Data:%s,  mSoPath:%s", value, value2, str);
                        long currentTimeMillis = System.currentTimeMillis();
                        com.qq.wx.voice.embed.recognizer.b bVar = com.qq.wx.voice.embed.recognizer.b.a.bCt;
                        Context context = ah.getContext();
                        e eVar = bVar.bCs;
                        if (eVar.d) {
                            i = 0;
                        } else {
                            i = eVar.bCz.checkFiles(context, str, value, value2);
                            if (i >= 0) {
                                eVar.d = true;
                                i = 0;
                            }
                        }
                        SharedPreferences doB = ah.doB();
                        ab.i("MicroMsg.SubCoreExt", "checkFiles ret:%s,use time:%s", Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        if (i == 0) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            LinkedList linkedList = new LinkedList();
                            linkedList.add("tmessage");
                            linkedList.add("officialaccounts");
                            linkedList.add("helper_entry");
                            aw.ZK();
                            bq RA = com.tencent.mm.model.c.XU().RA("@t.qq.com");
                            if (RA != null) {
                                linkedList.add(RA.name);
                            }
                            ArrayList arrayList = new ArrayList();
                            aw.ZK();
                            Cursor a = com.tencent.mm.model.c.XM().a("@all.contact.android", null, linkedList, null, true, true);
                            if (a == null) {
                                ab.w("MicroMsg.SubCoreExt", "initLocalVoiceControl cu is null");
                                b.this.lPu = true;
                                AppMethodBeat.o(20261);
                                return;
                            }
                            if (a.moveToFirst()) {
                                while (!a.isAfterLast()) {
                                    com.tencent.mm.storage.f fVar = new com.tencent.mm.storage.f();
                                    fVar.d(a);
                                    arrayList.add(new com.qq.wx.voice.embed.recognizer.d(fVar.field_username, fVar.field_nickname, fVar.field_conRemark));
                                    a.moveToNext();
                                }
                            }
                            a.close();
                            ab.i("MicroMsg.SubCoreExt", "init cusor,count:%s,use time:%s", Integer.valueOf(a.getCount()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                            long currentTimeMillis3 = System.currentTimeMillis();
                            e eVar2 = com.qq.wx.voice.embed.recognizer.b.a.bCt.bCs;
                            if (eVar2.d) {
                                if (eVar2.e) {
                                    i = eVar2.bCz.update(arrayList);
                                } else {
                                    i = eVar2.bCz.init(arrayList);
                                    if (i >= 0) {
                                        eVar2.e = true;
                                    }
                                }
                                i = 0;
                            } else {
                                i = -304;
                            }
                            if (i == 0) {
                                doB.edit().putBoolean("hasInitVoiceControlData", true).putBoolean("hasTryToInitVoiceControlData", true).commit();
                                b.this.lPv = true;
                            } else {
                                doB.edit().putBoolean("hasInitVoiceControlData", false).commit();
                            }
                            ab.i("MicroMsg.SubCoreExt", "init ret:%s,use time:%s", Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                            b.this.lPu = true;
                        } else {
                            doB.edit().putBoolean("hasInitVoiceControlData", false).putBoolean("hasTryToInitVoiceControlData", true).commit();
                            b.this.lPv = true;
                        }
                        b.this.lPu = true;
                        AppMethodBeat.o(20261);
                    } catch (Exception e) {
                        ab.i("MicroMsg.SubCoreExt", "initLocalVoiceControl Exception:%s", e.getMessage());
                        AppMethodBeat.o(20261);
                    }
                }
            }, 10000);
            AppMethodBeat.o(20288);
        } else {
            AppMethodBeat.o(20288);
        }
    }
}
