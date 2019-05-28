package com.tencent.p177mm.plugin.ext;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import com.p123qq.p803wx.voice.embed.recognizer.C17715b;
import com.p123qq.p803wx.voice.embed.recognizer.C17715b.C17716a;
import com.p123qq.p803wx.voice.embed.recognizer.C17717d;
import com.p123qq.p803wx.voice.embed.recognizer.C41655e;
import com.p802jg.EType;
import com.p802jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p1597a.C41933a;
import com.tencent.p177mm.compatible.p1597a.C41933a.C41932a;
import com.tencent.p177mm.compatible.p221e.C45290m;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C45439bw;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C37711fb;
import com.tencent.p177mm.p230g.p231a.C9339fj;
import com.tencent.p177mm.p230g.p231a.C9345fp;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi;
import com.tencent.p177mm.plugin.ext.p730c.C45907c;
import com.tencent.p177mm.plugin.ext.provider.ExtControlProviderEntry;
import com.tencent.p177mm.plugin.ext.provider.ExtControlProviderMsg;
import com.tencent.p177mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3457a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3460c;
import com.tencent.p177mm.pluginsdk.model.C30074i;
import com.tencent.p177mm.pluginsdk.model.C30074i.C14890a;
import com.tencent.p177mm.pluginsdk.model.C30074i.C30073b;
import com.tencent.p177mm.pluginsdk.model.C44063l;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C14883d;
import com.tencent.p177mm.pluginsdk.model.app.C35796i;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C40442x;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.protocal.protobuf.cmf;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C23511bo;
import com.tencent.p177mm.storage.C23512bz;
import com.tencent.p177mm.storage.C30298bp;
import com.tencent.p177mm.storage.C30299ca;
import com.tencent.p177mm.storage.C40629f;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C5140bq;
import com.tencent.p177mm.storage.C7580z;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.ext.b */
public class C6875b implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    private static boolean lPw = false;
    private final long lPg = 1600;
    private C7580z lPh;
    private C30298bp lPi;
    private C30299ca lPj;
    private C6885a lPk;
    private C6888b lPl;
    private HashMap<String, Integer> lPm = new HashMap();
    private C3457a lPn = new C68845();
    C14890a lPo = new C68876();
    private C7306ak lPp = new C7306ak(Looper.getMainLooper()) {
        @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140514", reviewer = 20, vComment = {EType.INTENTCHECK})
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(20266);
            if (C4996ah.getContext() == null || !C9638aw.m17179RK()) {
                C4990ab.m7420w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong status");
                AppMethodBeat.m2505o(20266);
                return;
            }
            Cursor dui = C6875b.brA().dui();
            if (dui == null) {
                C4990ab.m7416i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler getValidOpenMsgListener cu == null");
                AppMethodBeat.m2505o(20266);
                return;
            }
            C4990ab.m7411d("MicroMsg.SubCoreExt", "notifyMsgChangeHandler listener count = %s", Integer.valueOf(dui.getCount()));
            if (dui.getCount() <= 0) {
                dui.close();
                C4990ab.m7416i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler cu.getCount() <= 0");
                AppMethodBeat.m2505o(20266);
                return;
            }
            try {
                if (dui.moveToFirst()) {
                    HashMap hashMap = new HashMap();
                    synchronized (C6875b.this) {
                        hashMap.putAll(C6875b.this.lPm);
                        C6875b.this.lPm.clear();
                    }
                    do {
                        LinkedList linkedList = new LinkedList();
                        ArrayList arrayList = new ArrayList();
                        if (hashMap.entrySet() == null) {
                            C4990ab.m7420w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler waitForNotify.entrySet() == null");
                            AppMethodBeat.m2505o(20266);
                            return;
                        }
                        C23511bo c23511bo = new C23511bo();
                        c23511bo.mo8995d(dui);
                        if (C5046bo.isNullOrNil(c23511bo.field_appId) || C5046bo.isNullOrNil(c23511bo.field_packageName)) {
                            C4990ab.m7421w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong msgListener, appid = %s, package = %s", c23511bo.field_appId, c23511bo.field_packageName);
                        } else {
                            for (Entry entry : hashMap.entrySet()) {
                                String nullAsNil = C5046bo.nullAsNil((String) entry.getKey());
                                Integer num = (Integer) entry.getValue();
                                C9638aw.m17190ZK();
                                C7617ak aoZ = C18628c.m29083XR().aoZ(nullAsNil);
                                if (aoZ != null && !C5046bo.isNullOrNil(aoZ.field_username) && aoZ.field_unReadCount <= 0) {
                                    C4990ab.m7416i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler no unread in conversation");
                                } else if (!(C1855t.m3924nJ(nullAsNil) || C1855t.m3896kH(nullAsNil) || C1855t.m3913mZ(nullAsNil))) {
                                    C23512bz c23512bz;
                                    C30299ca brB = C6875b.brB();
                                    String str = c23511bo.field_appId;
                                    if (str == null || str.length() <= 0 || nullAsNil == null || nullAsNil.length() <= 0) {
                                        c23512bz = null;
                                    } else {
                                        Cursor a = brB.bSd.mo10105a("UserOpenIdInApp", null, "appId=? and username=? ", new String[]{C5046bo.m7586vA(str), C5046bo.m7586vA(nullAsNil)}, null, null, null, 2);
                                        if (a.moveToFirst()) {
                                            c23512bz = new C23512bz();
                                            c23512bz.mo8995d(a);
                                            a.close();
                                        } else {
                                            C4990ab.m7421w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with appId-%s, username-%s:", str, nullAsNil);
                                            a.close();
                                            c23512bz = null;
                                        }
                                    }
                                    if (c23512bz == null || C5046bo.isNullOrNil(c23512bz.field_openId) || C5046bo.isNullOrNil(c23512bz.field_username)) {
                                        C4990ab.m7410d("MicroMsg.SubCoreExt", "notifyMsgChangeHandler openId is null, go get it.");
                                        Integer num2 = (Integer) C6875b.this.lPm.get(nullAsNil);
                                        if (num2 == null) {
                                            C6875b.this.lPm.put(nullAsNil, num);
                                        } else {
                                            C6875b.this.lPm.put(nullAsNil, Integer.valueOf(num2.intValue() + num.intValue()));
                                        }
                                        linkedList.add(nullAsNil);
                                    } else {
                                        C4990ab.m7419v("MicroMsg.SubCoreExt", "username[%s], appId[%s], openId[%s]", c23512bz.field_username, c23512bz.field_appId, c23512bz.field_openId);
                                        arrayList.add(String.format("%s,%s,%s", new Object[]{c23512bz.field_openId, num, Long.valueOf(System.currentTimeMillis() - 1600)}));
                                    }
                                }
                            }
                            if (linkedList.size() > 0) {
                                C4990ab.m7416i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler doGetGetUserInfoInApp");
                                C6875b c6875b = C6875b.this;
                                String str2 = c23511bo.field_appId;
                                if (!C5046bo.isNullOrNil(str2) && linkedList.size() > 0) {
                                    C30074i dgZ = C30074i.dgZ();
                                    Context context = C4996ah.getContext();
                                    C14890a c14890a = c6875b.lPo;
                                    C4990ab.m7410d("MicroMsg.GetUserInfoInAppLogic", "getGetUserInfoInApp");
                                    if (!C30074i.vbc) {
                                        dgZ.dha();
                                    }
                                    if (C9638aw.m17179RK() && context != null) {
                                        if (linkedList.size() == 0) {
                                            C4990ab.m7410d("MicroMsg.GetUserInfoInAppLogic", "userNameList empty");
                                        } else {
                                            dgZ.vbe = c14890a;
                                            C40442x c44063l = new C44063l(str2, linkedList);
                                            C14877am.bYM();
                                            C14883d.m23149a(14, c44063l);
                                        }
                                    }
                                }
                            }
                            if (arrayList.size() <= 0) {
                                dui.close();
                                C4990ab.m7416i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler userDataList.size() <= 0");
                                AppMethodBeat.m2505o(20266);
                                return;
                            }
                            Object obj;
                            if (c23511bo.field_status == 1) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj == null) {
                                C4990ab.m7421w("MicroMsg.SubCoreExt", "invalid msgListener, appid = %s, package = %s", c23511bo.field_appId, c23511bo.field_packageName);
                            } else if (!(C5046bo.isNullOrNil(c23511bo.field_appId) || C5046bo.isNullOrNil(c23511bo.field_packageName))) {
                                C4990ab.m7417i("MicroMsg.SubCoreExt", "notify app, appId = %s, package = %s", c23511bo.field_appId, c23511bo.field_packageName);
                                final Intent intent = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_NOTIFY_MSG");
                                intent.addCategory("com.tencent.mm.category." + c23511bo.field_packageName);
                                C41933a.m74069a(12, new C41932a() {
                                    public final void run() {
                                        AppMethodBeat.m2504i(20265);
                                        intent.setFlags(32);
                                        AppMethodBeat.m2505o(20265);
                                    }
                                });
                                intent.putExtra("EXTRA_EXT_OPEN_NOTIFY_TYPE", "NEW_MESSAGE");
                                intent.putStringArrayListExtra("EXTRA_EXT_OPEN_USER_DATA", arrayList);
                                C4996ah.getContext().sendBroadcast(intent);
                            }
                        }
                    } while (dui.moveToNext());
                }
                dui.close();
                AppMethodBeat.m2505o(20266);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.SubCoreExt", "Exception in handleMessage, %s", e.getMessage());
                if (dui != null) {
                    dui.close();
                }
                AppMethodBeat.m2505o(20266);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(20266);
                    throw th;
                }
            }
        }
    };
    private LinkedList<String> lPq = new LinkedList();
    private final long lPr = 60;
    private C7306ak lPs = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(20267);
            try {
                if (C6875b.this.lPq.size() <= 0) {
                    AppMethodBeat.m2505o(20267);
                    return;
                }
                Iterator it = C6875b.this.lPq.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (!"*".equals(str)) {
                        C40439f bT = C46494g.m87739bT(str, false);
                        if (bT == null) {
                            C4990ab.m7420w("MicroMsg.SubCoreExt", "appInfo is null");
                        } else if (C5046bo.isNullOrNil(bT.field_appId)) {
                            C4990ab.m7420w("MicroMsg.SubCoreExt", "appId is null");
                        } else {
                            C4990ab.m7411d("MicroMsg.SubCoreExt", "onAppInfoStgChange, notify[%s], appFlag[%s], id[%s]", str, Integer.valueOf(bT.field_appInfoFlag), bT.field_appId);
                            C23511bo apN = C6875b.brA().apN(bT.field_appId);
                            if (apN == null) {
                                C4990ab.m7421w("MicroMsg.SubCoreExt", "openMsgListener is null, appId = %s", bT.field_appId);
                            } else {
                                if (C46494g.m87752k(bT)) {
                                    if (apN.field_status != 1) {
                                        apN.field_status = 1;
                                    }
                                } else if (apN.field_status != 0) {
                                    apN.field_status = 0;
                                }
                                C30298bp brA = C6875b.brA();
                                if (C5046bo.isNullOrNil(bT.field_appId) || apN == null || C5046bo.isNullOrNil(apN.field_appId)) {
                                    C4990ab.m7420w("MicroMsg.OpenMsgListenerStorage", "wrong argument");
                                } else {
                                    int update;
                                    ContentValues Hl = apN.mo10098Hl();
                                    if (Hl.size() > 0) {
                                        update = brA.bSd.update("OpenMsgListener", Hl, "appId=?", new String[]{C5046bo.m7586vA(r3)});
                                    } else {
                                        update = 0;
                                    }
                                    C4990ab.m7411d("MicroMsg.OpenMsgListenerStorage", "update: id=%s, ret=%s ", apN.field_appId, Integer.valueOf(update));
                                }
                            }
                        }
                    }
                }
                C6875b.this.lPq.clear();
                AppMethodBeat.m2505o(20267);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.SubCoreExt", "exception in onAppInfoStgChange, %s", e.getMessage());
                AppMethodBeat.m2505o(20267);
            }
        }
    };
    private C4931a lPt = new C68819();
    private boolean lPu = true;
    private boolean lPv = false;
    C4937b luz = new C688210();

    /* renamed from: com.tencent.mm.plugin.ext.b$2 */
    class C68782 implements Runnable {
        C68782() {
        }

        /* JADX WARNING: Missing block: B:48:0x01c6, code skipped:
            if (r0 >= 0) goto L_0x01c8;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            AppMethodBeat.m2504i(20261);
            try {
                String value = C26373g.m41964Nu().getValue("VoiceRecognizeSprSoMD5");
                String value2 = C26373g.m41964Nu().getValue("VoiceRecognizeSprDataMD5");
                if (value == null || value2 == null) {
                    C4990ab.m7417i("MicroMsg.SubCoreExt", "error mMd5So:%s,  mMd5Data:%s", value, value2);
                    C6875b.this.lPu = true;
                    AppMethodBeat.m2505o(20261);
                    return;
                }
                int i;
                String str = "/system/lib/";
                if (VERSION.SDK_INT >= 24) {
                    str = "/vendor/lib/";
                }
                C4990ab.m7417i("MicroMsg.SubCoreExt", "mMd5So:%s,  mMd5Data:%s,  mSoPath:%s", value, value2, str);
                long currentTimeMillis = System.currentTimeMillis();
                C17715b c17715b = C17716a.bCt;
                Context context = C4996ah.getContext();
                C41655e c41655e = c17715b.bCs;
                if (c41655e.f16879d) {
                    i = 0;
                } else {
                    i = c41655e.bCz.checkFiles(context, str, value, value2);
                    if (i >= 0) {
                        c41655e.f16879d = true;
                        i = 0;
                    }
                }
                SharedPreferences doB = C4996ah.doB();
                C4990ab.m7417i("MicroMsg.SubCoreExt", "checkFiles ret:%s,use time:%s", Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                if (i == 0) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    LinkedList linkedList = new LinkedList();
                    linkedList.add("tmessage");
                    linkedList.add("officialaccounts");
                    linkedList.add("helper_entry");
                    C9638aw.m17190ZK();
                    C5140bq RA = C18628c.m29086XU().mo15356RA("@t.qq.com");
                    if (RA != null) {
                        linkedList.add(RA.name);
                    }
                    ArrayList arrayList = new ArrayList();
                    C9638aw.m17190ZK();
                    Cursor a = C18628c.m29078XM().mo15703a("@all.contact.android", null, linkedList, null, true, true);
                    if (a == null) {
                        C4990ab.m7420w("MicroMsg.SubCoreExt", "initLocalVoiceControl cu is null");
                        C6875b.this.lPu = true;
                        AppMethodBeat.m2505o(20261);
                        return;
                    }
                    if (a.moveToFirst()) {
                        while (!a.isAfterLast()) {
                            C40629f c40629f = new C40629f();
                            c40629f.mo64095d(a);
                            arrayList.add(new C17717d(c40629f.field_username, c40629f.field_nickname, c40629f.field_conRemark));
                            a.moveToNext();
                        }
                    }
                    a.close();
                    C4990ab.m7417i("MicroMsg.SubCoreExt", "init cusor,count:%s,use time:%s", Integer.valueOf(a.getCount()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                    long currentTimeMillis3 = System.currentTimeMillis();
                    C41655e c41655e2 = C17716a.bCt.bCs;
                    if (c41655e2.f16879d) {
                        if (c41655e2.f16880e) {
                            i = c41655e2.bCz.update(arrayList);
                        } else {
                            i = c41655e2.bCz.init(arrayList);
                            if (i >= 0) {
                                c41655e2.f16880e = true;
                            }
                        }
                        i = 0;
                    } else {
                        i = -304;
                    }
                    if (i == 0) {
                        doB.edit().putBoolean("hasInitVoiceControlData", true).putBoolean("hasTryToInitVoiceControlData", true).commit();
                        C6875b.this.lPv = true;
                    } else {
                        doB.edit().putBoolean("hasInitVoiceControlData", false).commit();
                    }
                    C4990ab.m7417i("MicroMsg.SubCoreExt", "init ret:%s,use time:%s", Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                    C6875b.this.lPu = true;
                } else {
                    doB.edit().putBoolean("hasInitVoiceControlData", false).putBoolean("hasTryToInitVoiceControlData", true).commit();
                    C6875b.this.lPv = true;
                }
                C6875b.this.lPu = true;
                AppMethodBeat.m2505o(20261);
            } catch (Exception e) {
                C4990ab.m7417i("MicroMsg.SubCoreExt", "initLocalVoiceControl Exception:%s", e.getMessage());
                AppMethodBeat.m2505o(20261);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.ext.b$1 */
    static class C68791 implements C1366d {
        C68791() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C30298bp.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ext.b$9 */
    class C68819 implements C4931a {
        C68819() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(20268);
            if (!C6875b.this.lPq.contains(str)) {
                C6875b.this.lPq.add(str);
            }
            C6875b.this.lPs.removeMessages(0);
            C6875b.this.lPs.sendEmptyMessageDelayed(0, 60);
            AppMethodBeat.m2505o(20268);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ext.b$10 */
    class C688210 implements C4937b {
        C688210() {
        }

        /* renamed from: a */
        public final void mo10136a(int i, C7298n c7298n, Object obj) {
            AppMethodBeat.m2504i(20269);
            if (obj == null || !(obj instanceof String)) {
                C4990ab.m7411d("MicroMsg.SubCoreExt", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), c7298n, obj);
                AppMethodBeat.m2505o(20269);
            } else if (C9638aw.m17179RK()) {
                C9638aw.m17190ZK();
                if (c7298n == C18628c.m29078XM()) {
                    C6875b.m11364d(C6875b.this);
                }
                AppMethodBeat.m2505o(20269);
            } else {
                C4990ab.m7416i("MicroMsg.SubCoreExt", "onNotifyChange acc not ready");
                AppMethodBeat.m2505o(20269);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.ext.b$3 */
    static class C68833 implements C1366d {
        C68833() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C30299ca.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ext.b$5 */
    class C68845 implements C3457a {
        C68845() {
        }

        /* JADX WARNING: Missing block: B:49:0x012c, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(20263);
     */
        /* JADX WARNING: Missing block: B:64:?, code skipped:
            return;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final void mo7913a(C6977h c6977h, C3460c c3460c) {
            AppMethodBeat.m2504i(20263);
            if (c6977h == null || c3460c == null || c3460c.oqK == null) {
                C4990ab.m7412e("MicroMsg.SubCoreExt", "onMsgChange, wrong args");
                AppMethodBeat.m2505o(20263);
                return;
            }
            synchronized (C6875b.this) {
                try {
                    Cursor dui = C6875b.brA().dui();
                    if (dui == null) {
                        C4990ab.m7416i("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange getValidOpenMsgListener cu == null");
                    } else {
                        C4990ab.m7411d("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange listener count = %s", Integer.valueOf(dui.getCount()));
                        if (dui.getCount() <= 0) {
                            dui.close();
                            C4990ab.m7416i("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange cu.getCount() <= 0");
                            AppMethodBeat.m2505o(20263);
                            return;
                        }
                        dui.close();
                        for (int i = 0; i < c3460c.oqK.size(); i++) {
                            C7620bi c7620bi = (C7620bi) c3460c.oqK.get(i);
                            if (!(c7620bi == null || c7620bi.field_isSend != 0 || c7620bi.field_status == 4 || c7620bi.getType() == 9999 || c7620bi.getType() == Downloads.MIN_WAIT_FOR_NETWORK || C1855t.m3924nJ(c7620bi.field_talker) || C1855t.m3928nN(c7620bi.field_talker))) {
                                Integer num = (Integer) C6875b.this.lPm.get(c7620bi.field_talker);
                                if (num == null) {
                                    C6875b.this.lPm.put(c7620bi.field_talker, Integer.valueOf(1));
                                    C4990ab.m7411d("MicroMsg.SubCoreExt", "onMsgChange %s, %d", c7620bi.field_talker, Integer.valueOf(1));
                                } else {
                                    C6875b.this.lPm.put(c7620bi.field_talker, Integer.valueOf(num.intValue() + 1));
                                    C4990ab.m7411d("MicroMsg.SubCoreExt", "onMsgChange %s, %d", c7620bi.field_talker, Integer.valueOf(num.intValue() + 1));
                                }
                            }
                        }
                        if (C6875b.this.lPm.size() > 0) {
                            C6875b.this.brF();
                        } else {
                            C4990ab.m7416i("MicroMsg.SubCoreExt", "notifyMsgUsers.size < 1");
                        }
                    }
                } finally {
                    AppMethodBeat.m2505o(20263);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.ext.b$a */
    public static class C6885a extends C4884c<C9339fj> {
        public C6885a() {
            AppMethodBeat.m2504i(20270);
            this.xxI = C9339fj.class.getName().hashCode();
            AppMethodBeat.m2505o(20270);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(20271);
            C9339fj c9339fj = (C9339fj) c4883b;
            if (!(c9339fj instanceof C9339fj)) {
                C4990ab.m7414f("MicroMsg.SubCoreExt", "mismatched event");
                AppMethodBeat.m2505o(20271);
                return false;
            } else if (c9339fj.czd == null) {
                C4990ab.m7412e("MicroMsg.SubCoreExt", "revent.data is null");
                AppMethodBeat.m2505o(20271);
                return false;
            } else {
                if (c9339fj.czd.cyy == 9 || c9339fj.czd.cyy == 13) {
                    ExtControlProviderMsg extControlProviderMsg = new ExtControlProviderMsg(c9339fj.czd.crW, c9339fj.czd.cyy, c9339fj.czd.context);
                    c9339fj.cze.cyz = extControlProviderMsg.query(c9339fj.czd.uri, null, null, c9339fj.czd.selectionArgs, null);
                } else if (c9339fj.czd.cyy == 3) {
                    ExtControlProviderEntry extControlProviderEntry = new ExtControlProviderEntry(c9339fj.czd.crW, c9339fj.czd.cyy, c9339fj.czd.context);
                    c9339fj.cze.cyz = extControlProviderEntry.query(c9339fj.czd.uri, null, null, c9339fj.czd.selectionArgs, null);
                } else if (c9339fj.czd.cyy == 29) {
                    ExtControlProviderVoiceControl extControlProviderVoiceControl = new ExtControlProviderVoiceControl(c9339fj.czd.crW, c9339fj.czd.cyy, c9339fj.czd.context);
                    c9339fj.cze.cyz = extControlProviderVoiceControl.query(c9339fj.czd.uri, null, null, c9339fj.czd.selectionArgs, null);
                    SharedPreferences doB = C4996ah.doB();
                    if (!C6875b.lPw) {
                        doB.edit().putBoolean("hasCallVoiceControlApi", true).commit();
                        C6875b.lPw = true;
                    }
                } else {
                    ExtControlProviderOpenApi extControlProviderOpenApi = new ExtControlProviderOpenApi(c9339fj.czd.crW, c9339fj.czd.cyy, c9339fj.czd.context);
                    c9339fj.cze.cyz = extControlProviderOpenApi.query(c9339fj.czd.uri, null, null, c9339fj.czd.selectionArgs, null);
                }
                AppMethodBeat.m2505o(20271);
                return true;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.ext.b$6 */
    class C68876 implements C14890a {
        C68876() {
        }

        /* renamed from: a */
        public final void mo15144a(C44063l c44063l) {
            AppMethodBeat.m2504i(20264);
            if (c44063l == null) {
                AppMethodBeat.m2505o(20264);
                return;
            }
            Iterator it = c44063l.dhk().wtB.iterator();
            int i = 0;
            while (it.hasNext()) {
                cmf cmf = (cmf) it.next();
                C4990ab.m7419v("MicroMsg.SubCoreExt", "AppId[%s], UserName[%s], Xml[%s]", c44063l.hzi, cmf.jBB, cmf.xkk);
                if (!(C5046bo.isNullOrNil(cmf.jBB) || C5046bo.isNullOrNil(cmf.xkk))) {
                    C9638aw.m17190ZK();
                    C7616ad aoM = C18628c.m29078XM().aoM(cmf.jBB);
                    if (aoM == null || ((int) aoM.ewQ) <= 0) {
                        C4990ab.m7412e("MicroMsg.SubCoreExt", "contact is null");
                    } else if (aoM.dsf()) {
                        C4990ab.m7420w("MicroMsg.SubCoreExt", "isBizContact");
                    } else {
                        C30073b aiA = C30074i.aiA(cmf.xkk);
                        if (!(aiA == null || C5046bo.isNullOrNil(aiA.vbf))) {
                            C4990ab.m7419v("MicroMsg.SubCoreExt", "AppId[%s], openId[%s]", c44063l.hzi, aiA.vbf);
                            C6875b.brB().mo48505a(new C23512bz(c44063l.hzi, cmf.jBB, aiA.vbf));
                            i = 1;
                        }
                    }
                }
            }
            if (i != 0) {
                C6875b.this.brF();
            }
            AppMethodBeat.m2505o(20264);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ext.b$b */
    public static class C6888b extends C4884c<C9345fp> {
        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(20273);
            C9345fp c9345fp = (C9345fp) c4883b;
            if (c9345fp.czu == null) {
                C4990ab.m7412e("MicroMsg.SubCoreExt", "StepCount revent.data is null");
            } else {
                C4990ab.m7416i("MicroMsg.SubCoreExt", " action = " + c9345fp.czu.action);
                if (c9345fp.czu.action == 1) {
                    C6875b.brE();
                    C4990ab.m7410d("MicroMsg.SubCoreExt", " sendBroadcast");
                    AppMethodBeat.m2505o(20273);
                    return true;
                }
            }
            AppMethodBeat.m2505o(20273);
            return false;
        }

        public C6888b() {
            super(0);
            AppMethodBeat.m2504i(20272);
            this.xxI = C9345fp.class.getName().hashCode();
            AppMethodBeat.m2505o(20272);
        }
    }

    public C6875b() {
        AppMethodBeat.m2504i(20274);
        AppMethodBeat.m2505o(20274);
    }

    /* renamed from: d */
    static /* synthetic */ void m11364d(C6875b c6875b) {
        AppMethodBeat.m2504i(20289);
        c6875b.m11367gT(false);
        AppMethodBeat.m2505o(20289);
    }

    static {
        AppMethodBeat.m2504i(20290);
        int Lw = C45290m.m83509Lw();
        try {
            if (!Build.CPU_ABI.contains("armeabi")) {
                C4990ab.m7412e("hakon SilkCodec", "x86 machines not supported.");
            } else if ((Lw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                C1449k.m3079a("wechatvoicesilk_v7a", C6875b.class.getClassLoader());
            } else if ((Lw & 512) != 0) {
                C1449k.m3079a("wechatvoicesilk", C6875b.class.getClassLoader());
                Assert.assertTrue("Can't remove libwechatvoicesilk.so yet.", false);
            } else {
                C4990ab.m7412e("hakon SilkCodec", "load library failed! silk don't support armv5!!!!");
            }
        } catch (Exception e) {
            C4990ab.m7412e("hakon SilkCodec", "load library failed!");
        }
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("OPENMSGLISTENER_TABLE".hashCode()), new C68791());
        eaA.put(Integer.valueOf("USEROPENIDINAPP_TABLE".hashCode()), new C68833());
        AppMethodBeat.m2505o(20290);
    }

    public static C6875b bry() {
        AppMethodBeat.m2504i(20275);
        C9638aw.m17184ZE();
        C6875b c6875b = (C6875b) C45439bw.m83697oJ("plugin.ext");
        if (c6875b == null) {
            c6875b = new C6875b();
            C9638aw.m17184ZE().mo73244a("plugin.ext", c6875b);
        }
        AppMethodBeat.m2505o(20275);
        return c6875b;
    }

    public static C7580z brz() {
        AppMethodBeat.m2504i(20276);
        C1720g.m3534RN().mo5159QU();
        if (C6875b.bry().lPh == null) {
            C6875b bry = C6875b.bry();
            C9638aw.m17190ZK();
            bry.lPh = new C7580z(C18628c.m29069Ru());
        }
        C7580z c7580z = C6875b.bry().lPh;
        AppMethodBeat.m2505o(20276);
        return c7580z;
    }

    public static C30298bp brA() {
        AppMethodBeat.m2504i(20277);
        C1720g.m3534RN().mo5159QU();
        if (C6875b.bry().lPi == null) {
            C6875b bry = C6875b.bry();
            C9638aw.m17190ZK();
            bry.lPi = new C30298bp(C18628c.m29069Ru());
        }
        C30298bp c30298bp = C6875b.bry().lPi;
        AppMethodBeat.m2505o(20277);
        return c30298bp;
    }

    public static C30299ca brB() {
        AppMethodBeat.m2504i(20278);
        C1720g.m3534RN().mo5159QU();
        if (C6875b.bry().lPj == null) {
            C6875b bry = C6875b.bry();
            C9638aw.m17190ZK();
            bry.lPj = new C30299ca(C18628c.m29069Ru());
        }
        C30299ca c30299ca = C6875b.bry().lPj;
        AppMethodBeat.m2505o(20278);
        return c30299ca;
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
        AppMethodBeat.m2504i(20279);
        C6875b.brC();
        AppMethodBeat.m2505o(20279);
    }

    private static void brC() {
        AppMethodBeat.m2504i(20280);
        File file = new File(C1720g.m3536RP().eJM);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(C1720g.m3536RP().eJM + "image/ext/pcm");
        if (!file.exists()) {
            file.mkdirs();
        }
        C4990ab.m7417i("MicroMsg.SubCoreExt", "summerpcm accPath[%s] [%s]", C1720g.m3536RP().eJM, C5046bo.dpG());
        AppMethodBeat.m2505o(20280);
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(20281);
        C37711fb c37711fb = new C37711fb();
        c37711fb.cyt.f2859op = 1;
        if (!C4879a.xxA.mo10055m(c37711fb)) {
            C4990ab.m7412e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountPostReset");
        }
        C30074i.dgZ().dha();
        C9638aw.m17190ZK();
        C18628c.m29080XO().mo15287a(this.lPn, null);
        if (this.lPk == null) {
            this.lPk = new C6885a();
        }
        C4879a.xxA.mo10052c(this.lPk);
        if (this.lPl == null) {
            this.lPl = new C6888b();
        }
        C4879a.xxA.mo10052c(this.lPl);
        C35796i bYJ = C14877am.bYJ();
        if (bYJ != null) {
            bYJ.mo10116c(this.lPt);
        }
        SharedPreferences doB = C4996ah.doB();
        this.lPv = doB.getBoolean("hasTryToInitVoiceControlData", false);
        lPw = doB.getBoolean("hasCallVoiceControlApi", false);
        C4990ab.m7417i("MicroMsg.SubCoreExt", "onAccountPostReset,hasTryToInit:%s,hasCallApi:%s", Boolean.valueOf(this.lPv), Boolean.valueOf(lPw));
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo10118a(this.luz);
        m11367gT(true);
        C45907c.brT();
        C6875b.brC();
        AppMethodBeat.m2505o(20281);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(20282);
        if (this.lPk != null) {
            C4879a.xxA.mo10053d(this.lPk);
        }
        if (this.lPl != null) {
            C4879a.xxA.mo10053d(this.lPl);
        }
        C35796i bYJ = C14877am.bYJ();
        if (bYJ != null) {
            bYJ.mo10117d(this.lPt);
        }
        C9638aw.m17190ZK();
        C18628c.m29080XO().mo15286a(this.lPn);
        C37711fb c37711fb = new C37711fb();
        c37711fb.cyt.f2859op = 2;
        if (!C4879a.xxA.mo10055m(c37711fb)) {
            C4990ab.m7412e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountRelease");
        }
        C30074i dgZ = C30074i.dgZ();
        if (C9638aw.m17179RK()) {
            C30074i.vbc = false;
            C14877am.bYM().mo27203b(14, dgZ);
        }
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo10121b(this.luz);
        C45907c.brU();
        AppMethodBeat.m2505o(20282);
    }

    public static String brD() {
        AppMethodBeat.m2504i(20283);
        String str = C1720g.m3536RP().eJM + "image/ext/pcm";
        AppMethodBeat.m2505o(20283);
        return str;
    }

    public static void brE() {
        AppMethodBeat.m2504i(20284);
        String str = (String) C6875b.brz().get(C5127a.USERINFO_EXT_SPORT_PKGNAME_STRING, null);
        C4990ab.m7416i("MicroMsg.SubCoreExt", "sendSportBroadcast pkgNames = ".concat(String.valueOf(str)));
        if (str != null) {
            for (String str2 : str.split(";")) {
                final Intent intent = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_SET_SPORT_STEP");
                intent.setPackage(str2);
                C41933a.m74069a(12, new C41932a() {
                    public final void run() {
                        AppMethodBeat.m2504i(20262);
                        intent.setFlags(32);
                        AppMethodBeat.m2505o(20262);
                    }
                });
                intent.putExtra("EXTRA_EXT_OPEN_NOTIFY_TYPE", "SPORT_MESSAGE");
                C4996ah.getContext().sendBroadcast(intent);
            }
        }
        AppMethodBeat.m2505o(20284);
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: ig */
    public static C7616ad m11368ig(long j) {
        AppMethodBeat.m2504i(20285);
        if (!C9638aw.m17179RK() || j <= 0) {
            AppMethodBeat.m2505o(20285);
            return null;
        }
        C9638aw.m17190ZK();
        C7616ad mQ = C18628c.m29078XM().mo15763mQ(j);
        AppMethodBeat.m2505o(20285);
        return mQ;
    }

    /* renamed from: ih */
    public static void m11369ih(long j) {
        AppMethodBeat.m2504i(20286);
        if (j <= 0) {
            AppMethodBeat.m2505o(20286);
            return;
        }
        try {
            C9638aw.m17190ZK();
            if (C18628c.m29080XO().mo15343ji(j)) {
                C9638aw.m17190ZK();
                C6977h XO = C18628c.m29080XO();
                C9638aw.m17190ZK();
                XO.mo15293aa(C18628c.m29080XO().mo15340jf(j));
                AppMethodBeat.m2505o(20286);
                return;
            }
            C4990ab.m7412e("MicroMsg.SubCoreExt", "msgId is out of range, ".concat(String.valueOf(j)));
            AppMethodBeat.m2505o(20286);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.SubCoreExt", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.SubCoreExt", e, "", new Object[0]);
            AppMethodBeat.m2505o(20286);
        }
    }

    public final void brF() {
        AppMethodBeat.m2504i(20287);
        this.lPp.removeMessages(0);
        this.lPp.sendEmptyMessageDelayed(0, 1600);
        AppMethodBeat.m2505o(20287);
    }

    /* renamed from: gT */
    private void m11367gT(boolean z) {
        AppMethodBeat.m2504i(20288);
        if (!this.lPu) {
            AppMethodBeat.m2505o(20288);
        } else if (z && this.lPv) {
            C4990ab.m7416i("MicroMsg.SubCoreExt", "fromStartApp and already try to init");
            AppMethodBeat.m2505o(20288);
        } else if (z || lPw) {
            C4990ab.m7417i("MicroMsg.SubCoreExt", "initLocalVoiceControl,fromStartApp:%s,hasTryToInit:%s,hasCallApi:%s", Boolean.valueOf(z), Boolean.valueOf(this.lPv), Boolean.valueOf(lPw));
            this.lPu = false;
            C9638aw.m17180RS().mo10310m(new C68782(), 10000);
            AppMethodBeat.m2505o(20288);
        } else {
            AppMethodBeat.m2505o(20288);
        }
    }
}
