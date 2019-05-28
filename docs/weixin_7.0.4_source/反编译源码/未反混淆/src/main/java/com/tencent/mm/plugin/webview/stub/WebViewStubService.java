package com.tencent.mm.plugin.webview.stub;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.z;
import com.tencent.mm.compatible.e.y;
import com.tencent.mm.g.a.bu;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.g.a.di;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.g.a.fk;
import com.tencent.mm.g.a.fn;
import com.tencent.mm.g.a.fq;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gu;
import com.tencent.mm.g.a.hh;
import com.tencent.mm.g.a.hv;
import com.tencent.mm.g.a.la;
import com.tencent.mm.g.a.ng;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.g.a.og;
import com.tencent.mm.g.a.ol;
import com.tencent.mm.g.a.sc;
import com.tencent.mm.g.a.vr;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.k;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.plugin.webview.fts.b.e;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.af;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.plugin.webview.model.ap;
import com.tencent.mm.plugin.webview.model.ar;
import com.tencent.mm.plugin.webview.model.o;
import com.tencent.mm.plugin.webview.model.u;
import com.tencent.mm.plugin.webview.model.x;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.plugin.webview.modeltools.l;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.AnonymousClass90;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.adl;
import com.tencent.mm.protocal.protobuf.ado;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.anf;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.beq;
import com.tencent.mm.protocal.protobuf.bes;
import com.tencent.mm.protocal.protobuf.bsj;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.view.d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.AssertionFailedError;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewStubService extends Service implements f {
    private List<WebViewStubCallbackWrapper> cAV = new ArrayList();
    private c eFv = new c<nr>() {
        {
            AppMethodBeat.i(7191);
            this.xxI = nr.class.getName().hashCode();
            AppMethodBeat.o(7191);
        }

        private boolean a(nr nrVar) {
            AppMethodBeat.i(7192);
            if (!(nrVar instanceof nr)) {
                AppMethodBeat.o(7192);
            } else if (WebViewStubService.this.uiP == null || WebViewStubService.this.uiP.containsKey(nrVar.cJX.filePath)) {
                if (WebViewStubService.this.uiP != null) {
                    WebViewStubService.this.uiP.remove(nrVar.cJX.filePath);
                }
                ab.d("MicroMsg.WebViewStubService", "result: " + nrVar.cJX.result);
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.cAV) {
                        webViewStubCallbackWrapper.uuT.e(nrVar.cJX.filePath, nrVar.cJX.result, nrVar.cJX.cvn, nrVar.cJX.cvo);
                    }
                } catch (RemoteException e) {
                    ab.printErrStackTrace("MicroMsg.WebViewStubService", e, "", new Object[0]);
                }
                AppMethodBeat.o(7192);
            } else {
                AppMethodBeat.o(7192);
            }
            return false;
        }
    };
    private ak handler;
    private n mwl;
    private Map<String, Integer> uiP;
    private int uqA = -1;
    private final SparseArray<Bundle> uqu = new SparseArray();
    private com.tencent.mm.plugin.webview.stub.d.a uqv = new com.tencent.mm.plugin.webview.stub.d.a() {
        public final void r(int i, Bundle bundle) {
            AppMethodBeat.i(7113);
            com.tencent.mm.plugin.webview.c.a cYA = g.cYA();
            HashMap hashMap = new HashMap();
            for (String str : bundle.keySet()) {
                hashMap.put(str, bundle.get(str));
            }
            switch (i) {
                case 1:
                    cYA.ar(hashMap);
                    AppMethodBeat.o(7113);
                    return;
                default:
                    ab.w("MicroMsg.emoji.EmojiStoreWebViewLogic", "unknow action:%d", Integer.valueOf(i));
                    AppMethodBeat.o(7113);
                    return;
            }
        }

        public final void j(int i, Bundle bundle) {
            AppMethodBeat.i(7114);
            f cYC = g.cYC();
            switch (i) {
                case 1:
                    int i2;
                    cYC.ufg.remove(Integer.valueOf(bundle.getInt("webview_id")));
                    e eVar = cYC.ufm;
                    if (eVar.egk) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                    }
                    if (i2 == 0 || bo.isNullOrNil(eVar.query)) {
                        ab.v("MicroMsg.FTS.FTSWebViewLogic", "can not report %s", eVar.query);
                    } else {
                        ab.v("MicroMsg.FTS.FTSWebViewLogic", "report isReported:%b query:%s hasResult:%b isClick:%b searchType:%d", Boolean.valueOf(eVar.egk), eVar.query, Boolean.valueOf(eVar.ctn), Boolean.valueOf(eVar.sAY), Integer.valueOf(eVar.mFl));
                        an.a(eVar.scene, eVar.query, eVar.sAY, eVar.ctn, eVar.mFl);
                        eVar.egk = true;
                    }
                    ab.i("MicroMsg.FTS.FTSWebViewLogic", "activity destroy %d", Integer.valueOf(r4));
                    AppMethodBeat.o(7114);
                    return;
                case 3:
                    if (cYC.mEx != null) {
                        ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(cYC.mEx);
                    }
                    i iVar = new i();
                    iVar.query = bundle.getString(SearchIntents.EXTRA_QUERY);
                    iVar.mEt = bundle.getInt("count");
                    iVar.mEw = cYC.plf;
                    iVar.mEu.add("notifymessage");
                    cYC.mEx = ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).search(8, iVar);
                    cYC.mEx.mDs = Integer.valueOf(bundle.getInt("webview_id"));
                    s sVar = new s();
                    sVar.scene = bundle.getInt("scene");
                    sVar.ctj = bundle.getString(SearchIntents.EXTRA_QUERY);
                    sVar.tZw = 1;
                    sVar.cIv = bundle.getInt("webview_id");
                    if (cYC.ufj != null) {
                        com.tencent.mm.kernel.g.Rg().c(cYC.ufj);
                    }
                    cYC.ufj = new com.tencent.mm.plugin.webview.fts.e(sVar);
                    com.tencent.mm.kernel.g.Rg().a(1161, cYC);
                    com.tencent.mm.kernel.g.Rg().a(cYC.ufj, 0);
                    AppMethodBeat.o(7114);
                    return;
                case 5:
                    ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).deleteSOSHistory(bundle.getString("history"));
                    AppMethodBeat.o(7114);
                    return;
                case 6:
                    ab.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryWebViewVisitTime %s", bundle.getString("reportString"));
                    bsj bsj = new bsj();
                    bsj.wUu = r0;
                    com.tencent.mm.kernel.g.Rg().a(new w(bsj), 0);
                    break;
            }
            AppMethodBeat.o(7114);
        }

        public final Bundle p(int i, Bundle bundle) {
            AppMethodBeat.i(7115);
            g.cYC();
            Bundle p = com.tencent.mm.plugin.webview.fts.b.p(i, bundle);
            AppMethodBeat.o(7115);
            return p;
        }

        public final String mJ(String str) {
            AppMethodBeat.i(7116);
            String Oi = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(str).Oi();
            AppMethodBeat.o(7116);
            return Oi;
        }

        public final boolean mY(String str) {
            AppMethodBeat.i(7117);
            boolean mY = t.mY(str);
            AppMethodBeat.o(7117);
            return mY;
        }

        public final boolean nI(String str) {
            AppMethodBeat.i(7118);
            boolean nI = t.nI(str);
            AppMethodBeat.o(7118);
            return nI;
        }

        public final boolean mZ(String str) {
            AppMethodBeat.i(7119);
            boolean RK = com.tencent.mm.kernel.g.RK();
            ab.i("MicroMsg.WebViewStubService", "isBizContact, accHasReady = ".concat(String.valueOf(RK)));
            if (RK) {
                RK = t.mZ(str);
                AppMethodBeat.o(7119);
                return RK;
            }
            AppMethodBeat.o(7119);
            return false;
        }

        public final boolean Mn() {
            AppMethodBeat.i(7120);
            boolean Mn = com.tencent.mm.compatible.util.f.Mn();
            AppMethodBeat.o(7120);
            return Mn;
        }

        public final boolean cZd() {
            AppMethodBeat.i(7121);
            boolean RK = com.tencent.mm.kernel.g.RK();
            AppMethodBeat.o(7121);
            return RK;
        }

        @Deprecated
        public final void a(final int i, final Bundle bundle, final int i2) {
            AppMethodBeat.i(7122);
            ab.i("MicroMsg.WebViewStubService", "edw, invoke, actionCode = %d, binderID = %d", Integer.valueOf(i), Integer.valueOf(i2));
            WebViewStubService.this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(7105);
                    int i;
                    int i2;
                    Intent intent;
                    String str;
                    Bundle bundle;
                    switch (i) {
                        case 1:
                            WebViewStubService.a(WebViewStubService.this, 2, bundle, i2);
                            AppMethodBeat.o(7105);
                            return;
                        case 2:
                            com.tencent.mm.ui.base.t.hO(WebViewStubService.this);
                            AppMethodBeat.o(7105);
                            return;
                        case 3:
                            Bundle bundle2 = new Bundle();
                            bundle2.putInt("stat_scene", 4);
                            com.tencent.mm.plugin.webview.ui.tools.jsapi.g JR = h.JR(i2);
                            if (JR != null) {
                                bundle2.putString("stat_url", JR.getCurrentUrl());
                            }
                            AnonymousClass1.a(AnonymousClass1.this, bundle, bundle2);
                            AppMethodBeat.o(7105);
                            return;
                        case 4:
                            WebViewStubService.a(WebViewStubService.this, 3, bundle, i2);
                            AppMethodBeat.o(7105);
                            return;
                        case 5:
                            i = bundle.getInt("scene_end_type", 0);
                            i2 = bundle.getInt("scene_end_listener_hash_code", -1);
                            if (i2 != -1) {
                                WebViewStubService.this.uqz.add(Integer.valueOf(i2));
                            }
                            ab.i("MicroMsg.WebViewStubService", "add Scene end, type:[%d] hashCode:[%d], set_size:[%d], before_inc_count[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(WebViewStubService.this.uqz.size()), Integer.valueOf(WebViewStubService.this.uqw));
                            if (i > 0) {
                                WebViewStubService.this.uqw = WebViewStubService.this.uqw + 1;
                                ab.i("MicroMsg.WebViewStubService", "real add Scene end, hashCode:[%d]", Integer.valueOf(i2));
                                com.tencent.mm.kernel.g.Rg().a((int) d.MIC_PTU_MEISHI, WebViewStubService.this);
                                com.tencent.mm.kernel.g.Rg().a(673, WebViewStubService.this);
                                com.tencent.mm.kernel.g.Rg().a(666, WebViewStubService.this);
                                com.tencent.mm.kernel.g.Rg().a(1254, WebViewStubService.this);
                                com.tencent.mm.kernel.g.Rg().a(1373, WebViewStubService.this);
                                AppMethodBeat.o(7105);
                                return;
                            }
                            break;
                        case 6:
                            i = bundle.getInt("scene_end_type", 0);
                            i2 = bundle.getInt("scene_end_listener_hash_code", -1);
                            if (i2 != -1) {
                                WebViewStubService.this.uqz.remove(Integer.valueOf(i2));
                            }
                            ab.i("MicroMsg.WebViewStubService", "remove Scene end, type:[%d] hashCode:[%d], set_size:[%d], before_dec_count:[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(WebViewStubService.this.uqz.size()), Integer.valueOf(WebViewStubService.this.uqw));
                            if (i > 0) {
                                WebViewStubService.this.uqw = WebViewStubService.this.uqw - 1;
                                if (WebViewStubService.this.uqw < 0) {
                                    ab.e("MicroMsg.WebViewStubService", "remove Scene end, type:[%d] hashCode:[%d], set size:[%d], unexpected_count[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(WebViewStubService.this.uqz.size()), Integer.valueOf(WebViewStubService.this.uqw));
                                    WebViewStubService.this.uqw = 0;
                                }
                                if (WebViewStubService.this.uqw <= 0 && WebViewStubService.this.uqz.size() <= 0) {
                                    ab.i("MicroMsg.WebViewStubService", "real remove Scene end, hashCode:[%d]", Integer.valueOf(i2));
                                    if (com.tencent.mm.kernel.g.RK()) {
                                        com.tencent.mm.kernel.g.Rg().b((int) d.MIC_PTU_MEISHI, WebViewStubService.this);
                                        com.tencent.mm.kernel.g.Rg().b(673, WebViewStubService.this);
                                        com.tencent.mm.kernel.g.Rg().b(666, WebViewStubService.this);
                                        com.tencent.mm.kernel.g.Rg().b(1254, WebViewStubService.this);
                                        com.tencent.mm.kernel.g.Rg().b(1373, WebViewStubService.this);
                                        AppMethodBeat.o(7105);
                                        return;
                                    }
                                }
                            }
                            break;
                        case 7:
                            intent = new Intent();
                            intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, 0);
                            intent.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, R.anim.ce);
                            intent.addFlags(268435456);
                            com.tencent.mm.plugin.webview.a.a.gkE.r(intent, WebViewStubService.this);
                            AppMethodBeat.o(7105);
                            return;
                        case 8:
                            intent = new Intent();
                            intent.putExtras(bundle);
                            intent.addFlags(268435456);
                            com.tencent.mm.plugin.webview.a.a.gkE.s(intent, WebViewStubService.this);
                            AppMethodBeat.o(7105);
                            return;
                        case 20:
                            bundle.setClassLoader(getClass().getClassLoader());
                            h.JR(i2).uGh = bundle.getBundle("jsapiargs");
                            str = (String) bundle.getCharSequence("bizofstartfrom");
                            bundle = bundle.getBundle("startwebviewparams");
                            if (!(str == null || bundle == null)) {
                                la laVar = new la();
                                laVar.cGS.cGT = str;
                                laVar.cGS.params = bundle;
                                com.tencent.mm.sdk.b.a.xxA.m(laVar);
                            }
                            WebViewStubService.this.uqA = bundle.getInt("screen_orientation", -1);
                            AppMethodBeat.o(7105);
                            return;
                        case 21:
                            h.JR(i2).dcv().putAll(bundle);
                            AppMethodBeat.o(7105);
                            return;
                        case 29:
                            str = bundle.getString("srcUsername");
                            z.aeR();
                            com.tencent.mm.aj.e.qU(str);
                            z.aeR();
                            com.tencent.mm.aj.e.qV(str);
                            z.afc();
                            if (!bo.isNullOrNil(str) && com.tencent.mm.aj.f.rd(str)) {
                                z.afc().a(str, null, 0, null);
                            }
                            AppMethodBeat.o(7105);
                            return;
                        case 30:
                            str = bundle.getString("srcUsername");
                            z.aeR();
                            com.tencent.mm.aj.e.qW(str);
                            z.afc();
                            if (!bo.isNullOrNil(str) && com.tencent.mm.aj.f.rd(str)) {
                                z.afc().a(str, null);
                            }
                            AppMethodBeat.o(7105);
                            return;
                        case 41:
                            if (com.tencent.mm.kernel.g.RK()) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.g JR2 = h.JR(i2);
                                bundle = bundle;
                                if (JR2.uGZ != null) {
                                    if (bundle == null || bundle.size() <= 0) {
                                        JR2.a(JR2.umI, JR2.uGZ, "showKeyboard:fail", null, true, true);
                                    } else {
                                        HashMap hashMap = new HashMap();
                                        hashMap.put("text", bo.nullAsNil(bundle.getString("show_kb_input_callback_text")));
                                        JR2.a(JR2.umI, JR2.uGZ, "showKeyboard:ok", hashMap, true, true);
                                    }
                                    JR2.uGZ = null;
                                    AppMethodBeat.o(7105);
                                    return;
                                }
                            }
                            break;
                        default:
                            ab.e("MicroMsg.WebViewStubService", "not support action code:[%d]", Integer.valueOf(i));
                            break;
                    }
                    AppMethodBeat.o(7105);
                }
            });
            AppMethodBeat.o(7122);
        }

        public final b Z(Bundle bundle) {
            boolean a;
            AppMethodBeat.i(7123);
            a aVar = new a();
            long j = bundle.getLong("msg_id", Long.MIN_VALUE);
            String string = bundle.getString("sns_local_id");
            int i = bundle.getInt("news_svr_id", 0);
            String string2 = bundle.getString("news_svr_tweetid");
            cl clVar = new cl();
            if (Long.MIN_VALUE != j) {
                clVar.cvA.cvE = bundle.getInt("message_index", 0);
                a = ((ad) com.tencent.mm.kernel.g.K(ad.class)).a(clVar, j);
            } else if (!bo.isNullOrNil(string)) {
                sc scVar = new sc();
                scVar.cNZ.cOc = string;
                scVar.cNZ.cOd = clVar;
                scVar.cNZ.url = bundle.getString("rawUrl");
                scVar.cNZ.cOb = true;
                com.tencent.mm.sdk.b.a.xxA.m(scVar);
                a = scVar.cOa.cvi;
            } else if (i != 0) {
                ng ngVar = new ng();
                ngVar.cJw.opType = 3;
                ngVar.cJw.cJy = clVar;
                ngVar.cJw.cJz = i;
                ngVar.cJw.cJA = string2;
                com.tencent.mm.sdk.b.a.xxA.m(ngVar);
                a = ngVar.cJx.cvi;
            } else {
                aVar.uhJ = true;
                AppMethodBeat.o(7123);
                return aVar;
            }
            if (a) {
                string = bo.nullAsNil(bundle.getString("prePublishId"));
                String nW = v.nW(string);
                com.tencent.mm.model.v.b y = v.Zp().y(nW, true);
                y.j("sendAppMsgScene", Integer.valueOf(2));
                y.j("preChatName", bundle.getString("preChatName"));
                y.j("preMsgIndex", Integer.valueOf(bundle.getInt("preMsgIndex")));
                y.j("prePublishId", string);
                y.j("preUsername", bundle.getString("preUsername"));
                y.j("getA8KeyScene", bundle.getString("getA8KeyScene"));
                y.j("referUrl", bundle.getString("referUrl"));
                Bundle bundle2 = bundle.getBundle("jsapiargs");
                if (bundle2 != null) {
                    y.j("adExtStr", bundle2.getString("key_snsad_statextstr"));
                }
                clVar.cvA.cvF = nW;
                com.tencent.mm.sdk.b.a.xxA.m(clVar);
            } else {
                if (clVar.cvA.cvG == 0) {
                    clVar.cvA.cvG = R.string.bop;
                }
                com.tencent.mm.sdk.b.a.xxA.m(clVar);
            }
            aVar.ret = clVar.cvB.ret;
            AppMethodBeat.o(7123);
            return aVar;
        }

        public final boolean isSDCardAvailable() {
            AppMethodBeat.i(7125);
            boolean isSDCardAvailable = com.tencent.mm.kernel.g.RP().isSDCardAvailable();
            AppMethodBeat.o(7125);
            return isSDCardAvailable;
        }

        public final int gw(int i, int i2) {
            AppMethodBeat.i(7126);
            int a = bo.a((Integer) com.tencent.mm.kernel.g.RP().Ry().get(i, null), i2);
            AppMethodBeat.o(7126);
            return a;
        }

        public final void gx(final int i, final int i2) {
            AppMethodBeat.i(7127);
            WebViewStubService.this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(7107);
                    com.tencent.mm.kernel.g.RP().Ry().set(i, Integer.valueOf(i2));
                    AppMethodBeat.o(7107);
                }
            });
            AppMethodBeat.o(7127);
        }

        public final String bF(int i, String str) {
            AppMethodBeat.i(7128);
            String bc = bo.bc((String) com.tencent.mm.kernel.g.RP().Ry().get(i, null), str);
            AppMethodBeat.o(7128);
            return bc;
        }

        public final boolean s(int i, Bundle bundle) {
            AppMethodBeat.i(7129);
            ab.i("MicroMsg.WebViewStubService", "doScene, type = %d", Integer.valueOf(i));
            String string;
            m hVar;
            int i2;
            boolean a;
            switch (i) {
                case d.MIC_PTU_MEISHI /*233*/:
                    if (cZd()) {
                        string = bundle.getString("geta8key_data_req_url");
                        if (!bo.isNullOrNil(bundle.getString("k_share_url"))) {
                            ar.hb(string, bundle.getString("k_share_url"));
                        }
                        if (bo.isNullOrNil(string)) {
                            hVar = new com.tencent.mm.modelsimple.h(bundle.getString("geta8key_data_appid"), bundle.getString("geta8key_data_scope"), bundle.getString("geta8key_data_state"), bundle.getInt("geta8key_session_id", 0));
                        } else {
                            hVar = new com.tencent.mm.modelsimple.h(string, bundle.getString("geta8key_data_username"), bundle.getInt("geta8key_data_scene"), bundle.getInt("geta8key_data_reason"), bundle.getInt("geta8key_data_flag"), bundle.getString("geta8key_data_net_type"), bundle.getInt("geta8key_session_id", 0), bundle.getString("geta8key_data_appid"), bundle.getString("key_function_id"), bundle.getInt("key_wallet_region", 0), bundle.getByteArray("k_a8key_cookie"));
                        }
                        hVar.tag = Integer.valueOf(bundle.getInt("webview_binder_id"));
                        i2 = bundle.getInt("geta8key_data_subscene", -1);
                        if (i2 > 0) {
                            hVar.lV(i2);
                        }
                        string = bundle.getString("geta8key_outer_url");
                        if (!bo.isNullOrNil(string)) {
                            hVar.tq(string);
                        }
                        a = com.tencent.mm.kernel.g.Rg().a(hVar, 0);
                        AppMethodBeat.o(7129);
                        return a;
                    }
                    ab.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    AppMethodBeat.o(7129);
                    return false;
                case 666:
                    if (cZd()) {
                        a = WebViewStubService.Y(bundle);
                        AppMethodBeat.o(7129);
                        return a;
                    }
                    ab.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    AppMethodBeat.o(7129);
                    return false;
                case 673:
                    if (cZd()) {
                        m oVar = new o(bundle.getString("reading_mode_data_url"), bundle.getString("reading_mode_data_useragent"), bundle.getInt("reading_mode_data_width"), bundle.getInt("reading_mode_data_height"));
                        oVar.tag = Integer.valueOf(bundle.getInt("webview_binder_id"));
                        a = com.tencent.mm.kernel.g.Rg().a(oVar, 0);
                        AppMethodBeat.o(7129);
                        return a;
                    }
                    ab.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    AppMethodBeat.o(7129);
                    return false;
                case 1254:
                    if (cZd()) {
                        m wVar = new com.tencent.mm.plugin.webview.model.w(bundle.getString("oauth_url"), bundle.getString("biz_username"), bundle.getInt("scene"));
                        wVar.tag = Integer.valueOf(bundle.getInt("webview_binder_id"));
                        a = com.tencent.mm.kernel.g.Rg().a(wVar, 0);
                        AppMethodBeat.o(7129);
                        return a;
                    }
                    ab.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    AppMethodBeat.o(7129);
                    return false;
                case 1295:
                    if (!cZd()) {
                        ab.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                        AppMethodBeat.o(7129);
                        return false;
                    } else if (bundle == null) {
                        AppMethodBeat.o(7129);
                        return false;
                    } else {
                        ab.d("MicroMsg.WebViewReportUtil", "doReportCgi : %s", bundle.getString("ad_report_data_str"));
                        ((com.tencent.mm.plugin.sns.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.sns.b.a.class)).i(13791, string, (int) bo.anT());
                        AppMethodBeat.o(7129);
                        return true;
                    }
                case 1373:
                    if (cZd()) {
                        String string2 = bundle.getString("oauth_url");
                        int i3 = bundle.getInt("opt");
                        LinkedList linkedList = new LinkedList(bundle.getStringArrayList(Constants.KEY_SCOPES));
                        StringBuilder stringBuilder = new StringBuilder();
                        int i4 = 0;
                        while (true) {
                            i2 = i4;
                            if (i2 < linkedList.size()) {
                                stringBuilder.append((String) linkedList.get(i2)).append(",");
                                i4 = i2 + 1;
                            } else {
                                ab.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm selectedScopes: %s", stringBuilder.toString());
                                hVar = new x(string2, i3, linkedList);
                                hVar.tag = Integer.valueOf(bundle.getInt("webview_binder_id"));
                                a = com.tencent.mm.kernel.g.Rg().a(hVar, 0);
                                AppMethodBeat.o(7129);
                                return a;
                            }
                        }
                    }
                    ab.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    AppMethodBeat.o(7129);
                    return false;
                case 2836:
                    if (cZd()) {
                        a = WebViewStubService.a(WebViewStubService.this, bundle);
                        AppMethodBeat.o(7129);
                        return a;
                    }
                    ab.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    AppMethodBeat.o(7129);
                    return false;
                default:
                    ab.e("MicroMsg.WebViewStubService", "doScene fail, invalid type = %d", Integer.valueOf(i));
                    AppMethodBeat.o(7129);
                    return false;
            }
        }

        public final boolean aeD() {
            AppMethodBeat.i(7130);
            boolean aeD = com.tencent.mm.aj.f.aeD();
            AppMethodBeat.o(7130);
            return aeD;
        }

        public final void k(int i, List<String> list) {
            AppMethodBeat.i(7132);
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
            com.tencent.mm.plugin.report.service.h.g(i, list);
            AppMethodBeat.o(7132);
        }

        public final String afg(String str) {
            AppMethodBeat.i(7134);
            String x = ((q) com.tencent.mm.kernel.g.K(q.class)).x(WebViewStubService.this, str);
            AppMethodBeat.o(7134);
            return x;
        }

        public final void dB(String str, int i) {
            AppMethodBeat.i(7135);
            new Bundle().putInt("webview_binder_id", i);
            WebViewStubService.a(WebViewStubService.this, 5, null, i);
            AppMethodBeat.o(7135);
        }

        public final boolean Ze() {
            AppMethodBeat.i(7137);
            boolean Ze = r.Ze();
            AppMethodBeat.o(7137);
            return Ze;
        }

        public final void i(String str, boolean z, int i) {
            AppMethodBeat.i(7138);
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g JR = h.JR(i);
            if (!bo.isNullOrNil(str)) {
                ab.i("MicroMsg.MsgHandler", "addInvokedJsApiFromMenu, functionName = %s, clear isBusy state", str);
                JR.eBB = false;
                JR.uGg.add(str);
                if (z) {
                    JR.uGf.add(str);
                }
            }
            AppMethodBeat.o(7138);
        }

        public final Bundle Ja(int i) {
            AppMethodBeat.i(7139);
            Bundle dcv = h.JR(i).dcv();
            AppMethodBeat.o(7139);
            return dcv;
        }

        public final boolean Jb(int i) {
            AppMethodBeat.i(7140);
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g JR = h.JR(i);
            boolean z = JR.eBB;
            boolean z2 = com.tencent.mm.protocal.d.vxr;
            if (z) {
                ab.w("MicroMsg.WebViewStubService", "isBusy(%d), doingFunction = %s", Integer.valueOf(i), JR.uGn);
            } else if (z2 && JR.uGo) {
                ab.i("MicroMsg.WebViewStubService", "isBusy(%d), awaiting proxyUI", Integer.valueOf(i));
                AppMethodBeat.o(7140);
                return true;
            }
            AppMethodBeat.o(7140);
            return z;
        }

        public final void L(String str, String str2, int i) {
            AppMethodBeat.i(7141);
            h.JR(i).dcv().putString(str, str2);
            AppMethodBeat.o(7141);
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0057  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(String str, String str2, String str3, Bundle bundle, Bundle bundle2, int i) {
            boolean z;
            AppMethodBeat.i(7142);
            boolean afe = WebViewStubService.afe(str2);
            ab.i("MicroMsg.WebViewStubService", "handleMsg, function = " + str2 + ", doInActivity = " + afe);
            JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper();
            jsapiPermissionWrapper.fromBundle(bundle);
            if ("wcPrivacyPolicyResult".equals(str2)) {
                Bundle bundle3 = (Bundle) WebViewStubService.this.uqu.get(i);
                if (bundle3 != null && bundle3.getBoolean("KInitialParam_Force_wcPrivacyPolicyResult_DoInService", false)) {
                    z = false;
                    if (z) {
                        com.tencent.mm.plugin.webview.ui.tools.jsapi.i iVar = new com.tencent.mm.plugin.webview.ui.tools.jsapi.i();
                        iVar.type = str;
                        iVar.uIJ = str2;
                        iVar.uIG = str3;
                        iVar.puc = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aq(bundle2.getBundle("compatParams"));
                        try {
                            iVar.uIH = new JSONObject(bundle2.getString("rawParams"));
                        } catch (JSONException e) {
                            ab.e("MicroMsg.WebViewStubService", "get rawParams, e = %s", e);
                        }
                        e eVar = null;
                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.cAV) {
                            e eVar2;
                            if (webViewStubCallbackWrapper == null || webViewStubCallbackWrapper.id != i) {
                                eVar2 = eVar;
                            } else {
                                eVar2 = webViewStubCallbackWrapper.uuT;
                            }
                            eVar = eVar2;
                        }
                        h.JR(i).dcu();
                        h.JR(i).a(WebViewStubService.this, eVar, eVar);
                        z = h.JR(i).a(iVar, jsapiPermissionWrapper);
                        ab.i("MicroMsg.WebViewStubService", "handleRet = ".concat(String.valueOf(z)));
                        AppMethodBeat.o(7142);
                        return z;
                    }
                    if (WebViewStubService.a(WebViewStubService.this, str, str2, str3, jsapiPermissionWrapper, bundle2, i)) {
                        h.JR(i).oc(true);
                    }
                    AppMethodBeat.o(7142);
                    return true;
                }
            }
            z = afe;
            if (z) {
            }
        }

        public final void a(String str, Bundle bundle, int i) {
            AppMethodBeat.i(7143);
            Bundle bundle2 = new Bundle();
            JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper();
            jsapiPermissionWrapper.fromBundle(bundle);
            bundle2.putParcelable("proxyui_perm_key", jsapiPermissionWrapper);
            bundle2.putString("proxyui_username_key", str);
            bundle2.putInt("webview_binder_id", i);
            WebViewStubService.a(WebViewStubService.this, 4, bundle2, i);
            AppMethodBeat.o(7143);
        }

        public final void afh(String str) {
            AppMethodBeat.i(7144);
            com.tencent.mm.pluginsdk.model.app.f bT = com.tencent.mm.pluginsdk.model.app.g.bT(str, false);
            if (bT != null && bo.isNullOrNil(bT.field_openId)) {
                ab.i("MicroMsg.WebViewStubService", "initView trigger getappsetting, appId = ".concat(String.valueOf(str)));
                hh hhVar = new hh();
                hhVar.cCd.appId = str;
                com.tencent.mm.sdk.b.a.xxA.m(hhVar);
            }
            AppMethodBeat.o(7144);
        }

        public final String afi(String str) {
            AppMethodBeat.i(7145);
            com.tencent.mm.pluginsdk.model.app.f bT = com.tencent.mm.pluginsdk.model.app.g.bT(str, false);
            if (bT == null) {
                AppMethodBeat.o(7145);
                return null;
            }
            String str2 = bT.field_packageName;
            AppMethodBeat.o(7145);
            return str2;
        }

        public final boolean dq(String str) {
            AppMethodBeat.i(7146);
            boolean dq = ((q) com.tencent.mm.kernel.g.K(q.class)).dq(str);
            AppMethodBeat.o(7146);
            return dq;
        }

        public final void ao(int i, int i2, int i3) {
            AppMethodBeat.i(7147);
            Bundle bundle = new Bundle();
            bundle.putInt("proxyui_expired_errtype", i);
            bundle.putInt("proxyui_expired_errcode", i2);
            WebViewStubService.a(WebViewStubService.this, 6, bundle, i3);
            AppMethodBeat.o(7147);
        }

        public final boolean afj(String str) {
            AppMethodBeat.i(7148);
            boolean afj = com.tencent.mm.bp.d.afj(str);
            AppMethodBeat.o(7148);
            return afj;
        }

        public final void Jc(int i) {
            AppMethodBeat.i(7149);
            ab.i("MicroMsg.WebViewStubService", "removeCallback, id = %d", Integer.valueOf(i));
            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.cAV) {
                if (webViewStubCallbackWrapper.id == i) {
                    WebViewStubService.this.cAV.remove(webViewStubCallbackWrapper);
                    AppMethodBeat.o(7149);
                    return;
                }
            }
            WebViewStubService.this.uqu.remove(i);
            AppMethodBeat.o(7149);
        }

        public final void a(e eVar, int i) {
            AppMethodBeat.i(7150);
            ab.i("MicroMsg.WebViewStubService", "addCallback, cb.hash = %d, id = %d", Integer.valueOf(eVar.hashCode()), Integer.valueOf(i));
            WebViewStubService.this.cAV.add(new WebViewStubCallbackWrapper(eVar, i));
            h.JR(i);
            AppMethodBeat.o(7150);
        }

        public final String[] cZe() {
            AppMethodBeat.i(7151);
            String O = com.tencent.mm.m.g.Nv().O("WebViewConfig", "removeJavascriptInterface");
            if (bo.isNullOrNil(O)) {
                AppMethodBeat.o(7151);
                return null;
            }
            String[] split = O.split(";");
            AppMethodBeat.o(7151);
            return split;
        }

        public final boolean aa(Bundle bundle) {
            AppMethodBeat.i(7152);
            cg cgVar = new cg();
            cgVar.cvt.cvv = bundle.getLong("fav_local_id", -1);
            com.tencent.mm.sdk.b.a.xxA.m(cgVar);
            ab.i("MicroMsg.WebViewStubService", "do del fav web url, local id %d, result %B", Long.valueOf(cgVar.cvt.cvv), Boolean.valueOf(cgVar.cvu.cvi));
            boolean z = cgVar.cvu.cvi;
            AppMethodBeat.o(7152);
            return z;
        }

        public final String cZf() {
            AppMethodBeat.i(7153);
            String str = (String) com.tencent.mm.kernel.g.RP().Ry().get(-1535680990, null);
            AppMethodBeat.o(7153);
            return str;
        }

        public final String aek(String str) {
            AppMethodBeat.i(7154);
            String aek = ar.aek(str);
            AppMethodBeat.o(7154);
            return aek;
        }

        public final String cZg() {
            AppMethodBeat.i(7155);
            String g = aa.g(WebViewStubService.this.getSharedPreferences(ah.doA(), 0));
            AppMethodBeat.o(7155);
            return g;
        }

        public final String afk(final String str) {
            AppMethodBeat.i(7156);
            boolean RK = com.tencent.mm.kernel.g.RK();
            ab.i("MicroMsg.WebViewStubService", "getDynamicConfigValue, accHasReady = ".concat(String.valueOf(RK)));
            String value;
            if (RK) {
                value = com.tencent.mm.m.g.Nu().getValue(str);
                AppMethodBeat.o(7156);
                return value;
            }
            value = (String) new bj<String>() {
                public final /* synthetic */ Object run() {
                    AppMethodBeat.i(7108);
                    if (com.tencent.mm.kernel.g.RK()) {
                        String value = com.tencent.mm.m.g.Nu().getValue(str);
                        AppMethodBeat.o(7108);
                        return value;
                    }
                    AppMethodBeat.o(7108);
                    return null;
                }
            }.b(WebViewStubService.this.handler);
            AppMethodBeat.o(7156);
            return value;
        }

        public final void afl(final String str) {
            AppMethodBeat.i(7157);
            boolean RK = com.tencent.mm.kernel.g.RK();
            ab.i("MicroMsg.WebViewStubService", "triggerGetContact, accHasReady = ".concat(String.valueOf(RK)));
            AnonymousClass5 anonymousClass5 = new bj<Void>() {
                public final /* synthetic */ Object run() {
                    AppMethodBeat.i(7109);
                    if (com.tencent.mm.kernel.g.RK()) {
                        com.tencent.mm.storage.ad aoO = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(str);
                        if (aoO == null || ((int) aoO.ewQ) <= 0) {
                            aoO = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoK(str);
                            if (aoO == null || ((int) aoO.ewQ) <= 0) {
                                com.tencent.mm.model.ao.a.flu.a(str, "", null);
                                AppMethodBeat.o(7109);
                            } else {
                                ab.v("MicroMsg.WebViewStubService", "triggerGetContact, alias already exist, no need to getcontact");
                                AppMethodBeat.o(7109);
                            }
                        } else {
                            ab.v("MicroMsg.WebViewStubService", "triggerGetContact, already exist, no need to getcontact");
                            AppMethodBeat.o(7109);
                        }
                    } else {
                        AppMethodBeat.o(7109);
                    }
                    return null;
                }
            };
            if (RK) {
                anonymousClass5.b(null);
                AppMethodBeat.o(7157);
                return;
            }
            anonymousClass5.b(WebViewStubService.this.handler);
            AppMethodBeat.o(7157);
        }

        public final String dC(String str, int i) {
            AppMethodBeat.i(7158);
            String aeC;
            switch (i) {
                case 1:
                    aeC = ap.aeC(str);
                    AppMethodBeat.o(7158);
                    return aeC;
                case 2:
                    aeC = ap.aeD(str);
                    AppMethodBeat.o(7158);
                    return aeC;
                default:
                    AppMethodBeat.o(7158);
                    return null;
            }
        }

        public final int afm(String str) {
            AppMethodBeat.i(7159);
            cl clVar = new cl();
            ((ad) com.tencent.mm.kernel.g.K(ad.class)).a(clVar, 1, str);
            com.tencent.mm.sdk.b.a.xxA.m(clVar);
            int i = clVar.cvB.ret;
            AppMethodBeat.o(7159);
            return i;
        }

        public final void favEditTag() {
            AppMethodBeat.i(7160);
            gh ghVar = new gh();
            ghVar.cAH.type = 35;
            com.tencent.mm.sdk.b.a.xxA.m(ghVar);
            AppMethodBeat.o(7160);
        }

        public final boolean x(long j, String str) {
            AppMethodBeat.i(7161);
            if (j == Long.MIN_VALUE && str == null) {
                AppMethodBeat.o(7161);
                return false;
            }
            dq dqVar = new dq();
            if (j != Long.MIN_VALUE) {
                dqVar.cxc.cvx = j;
            }
            if (str != null) {
                dqVar.cxc.cwT = str;
            }
            com.tencent.mm.sdk.b.a.xxA.m(dqVar);
            if (dqVar.cxd.cwB) {
                AppMethodBeat.o(7161);
                return true;
            }
            if (com.tencent.mm.kernel.g.RK() && j != Long.MIN_VALUE) {
                bi jf = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().jf(j);
                if (jf.getType() == 49) {
                    boolean kH = t.kH(jf.field_talker);
                    String str2 = jf.field_content;
                    int i = jf.field_isSend;
                    if (kH && str2 != null && i == 0) {
                        str2 = bf.oz(str2);
                    }
                    com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(str2);
                    boolean o;
                    if (me.type == 3) {
                        o = com.tencent.mm.pluginsdk.model.app.g.o(ah.getContext(), 16);
                        AppMethodBeat.o(7161);
                        return o;
                    } else if (me.type == 4) {
                        o = com.tencent.mm.pluginsdk.model.app.g.o(ah.getContext(), 8);
                        AppMethodBeat.o(7161);
                        return o;
                    }
                }
            }
            AppMethodBeat.o(7161);
            return false;
        }

        public final void afn(String str) {
            AppMethodBeat.i(7162);
            if (com.tencent.mm.sdk.platformtools.r.amo(str)) {
                EmojiInfo Jd;
                EmojiInfo Jd2 = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jd(com.tencent.mm.a.g.cz(str));
                if (Jd2 == null || !Jd2.duP()) {
                    com.tencent.mm.pluginsdk.a.d emojiMgr = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
                    ah.getContext();
                    Jd = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jd(emojiMgr.Jf(str));
                } else {
                    Jd = Jd2;
                }
                int cs = Jd == null ? 0 : com.tencent.mm.a.e.cs(Jd.dve());
                if (Jd != null) {
                    str = Jd.dve();
                }
                Options options = new Options();
                options.inJustDecodeBounds = true;
                int i;
                if ((com.tencent.mm.sdk.platformtools.d.decodeFile(str, options) == null || options.outHeight <= com.tencent.mm.m.b.Na()) && options.outWidth <= com.tencent.mm.m.b.Na()) {
                    i = 0;
                } else {
                    i = true;
                }
                if (cs > com.tencent.mm.m.b.Nb() || i != 0) {
                    com.tencent.mm.ui.base.h.a(ah.getContext(), WebViewStubService.this.getString(R.string.b9x), "", WebViewStubService.this.getString(R.string.cd_), null);
                    AppMethodBeat.o(7162);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Retr_File_Name", Jd == null ? "" : Jd.Aq());
                intent.putExtra("Retr_Msg_Type", 5);
                intent.putExtra("Retr_MsgImgScene", 1);
                intent.addFlags(268435456);
                com.tencent.mm.plugin.webview.a.a.gkE.k(intent, WebViewStubService.this);
                AppMethodBeat.o(7162);
                return;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("Retr_File_Name", str);
            intent2.putExtra("Retr_Compress_Type", 0);
            intent2.putExtra("Retr_Msg_Type", 0);
            intent2.addFlags(268435456);
            com.tencent.mm.plugin.webview.a.a.gkE.k(intent2, WebViewStubService.this);
            AppMethodBeat.o(7162);
        }

        public final String getLanguage() {
            AppMethodBeat.i(7163);
            String gw = aa.gw(ah.getContext());
            AppMethodBeat.o(7163);
            return gw;
        }

        public final String cZh() {
            AppMethodBeat.i(7164);
            hv hvVar = new hv();
            com.tencent.mm.sdk.b.a.xxA.m(hvVar);
            String str = hvVar.cCO.url;
            AppMethodBeat.o(7164);
            return str;
        }

        public final Map cZi() {
            AppMethodBeat.i(7165);
            com.tencent.mm.m.d Nf = com.tencent.mm.m.g.Nv().Nf();
            if (Nf == null) {
                AppMethodBeat.o(7165);
                return null;
            }
            Map map = Nf.evZ;
            AppMethodBeat.o(7165);
            return map;
        }

        public final String hf(String str, String str2) {
            return "";
        }

        public final int cZj() {
            AppMethodBeat.i(7166);
            com.tencent.mm.kernel.g.RN();
            int QF = com.tencent.mm.kernel.a.QF();
            AppMethodBeat.o(7166);
            return QF;
        }

        public final int cZk() {
            AppMethodBeat.i(7167);
            int h = bo.h((Integer) com.tencent.mm.kernel.g.RP().Ry().get(12304, null));
            AppMethodBeat.o(7167);
            return h;
        }

        public final void cZl() {
            AppMethodBeat.i(7168);
            Intent intent = new Intent();
            String str = (String) com.tencent.mm.kernel.g.RP().Ry().get(2, null);
            intent.setFlags(268435456);
            intent.putExtra("sns_userName", str);
            intent.addFlags(67108864);
            intent.putExtra("sns_adapter_type", 1);
            com.tencent.mm.kernel.g.RP().Ry().set(68389, Integer.valueOf(bo.a((Integer) com.tencent.mm.kernel.g.RP().Ry().get(68389, null), 0) + 1));
            intent.setClassName(ah.getContext(), "com.tencent.mm.plugin.sns.ui.SnsTimeLineUserPagerUI");
            WebViewStubService.this.startActivity(intent);
            AppMethodBeat.o(7168);
        }

        public final void cZm() {
            AppMethodBeat.i(7169);
            if (((r.YK() & 32768) == 0) && com.tencent.mm.bp.d.afj("sns")) {
                Intent intent = new Intent();
                intent.setFlags(268435456);
                intent.addFlags(67108864);
                intent.setClassName(ah.getContext(), "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI");
                intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                WebViewStubService.this.startActivity(intent);
            }
            AppMethodBeat.o(7169);
        }

        public final void IP(int i) {
            Iterator it;
            String str;
            AppMethodBeat.i(7170);
            if (WebViewStubService.this.cAV.size() == 0) {
                fq fqVar = new fq();
                fqVar.czB.czE = 2;
                com.tencent.mm.sdk.b.a.xxA.m(fqVar);
                fk fkVar = new fk();
                fkVar.czf.op = 2;
                com.tencent.mm.sdk.b.a.xxA.m(fkVar);
                fn fnVar = new fn();
                fnVar.czm.op = 2;
                com.tencent.mm.sdk.b.a.xxA.m(fnVar);
            }
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g JR = h.JR(i);
            ab.d("MicroMsg.MsgHandler", "onWebViewUIDestroy");
            JR.uGm = true;
            if (JR.dcC()) {
                WebViewJSSDKFileItem aex = g.cYF().aex(JR.uGP);
                if (aex != null) {
                    al.d(new AnonymousClass90(aex));
                }
            }
            Entry entry;
            String str2;
            if ((JR.cZr() == 8 || JR.cZr() == -1) && JR.bFf() != 27) {
                if (JR.cZr() == 8) {
                    if (JR.uGj == null || JR.uGj.isEmpty()) {
                        ab.i("MicroMsg.MsgHandler", "Not hard biz, or no ble device connection, just return");
                    } else {
                        it = JR.uGj.entrySet().iterator();
                        if (it != null) {
                            while (it.hasNext()) {
                                entry = (Entry) it.next();
                                str2 = (String) entry.getKey();
                                str = (String) entry.getValue();
                                ab.i("MicroMsg.MsgHandler", "Remove ble devices, srcUserName(%s), deviceId(%s)", str2, str);
                                dj djVar = new dj();
                                djVar.cwE.cwG = str2;
                                djVar.cwE.ceI = str;
                                com.tencent.mm.sdk.b.a.xxA.m(djVar);
                                if (!djVar.cwF.cwB) {
                                    try {
                                        dh dhVar = new dh();
                                        dhVar.cwx.cwA = false;
                                        dhVar.cwx.cwz = str2;
                                        dhVar.cwx.ceI = str;
                                        com.tencent.mm.sdk.b.a.xxA.m(dhVar);
                                        ab.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                                    } catch (Exception e) {
                                        ab.e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
                                        ab.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
                                    }
                                }
                            }
                        }
                        JR.uGj.clear();
                    }
                }
            } else if ((JR.uGk == null || JR.uGk.isEmpty()) && (JR.uGj == null || JR.uGj.isEmpty())) {
                ab.i("MicroMsg.MsgHandler", "No exdevice connection, just return");
            } else {
                if (!(JR.uGk == null || JR.uGk.isEmpty())) {
                    for (Entry entry2 : JR.uGk.entrySet()) {
                        ab.i("MicroMsg.MsgHandler", "Remove wifi devices, srcUserName(%s), deviceId(%s)", (String) entry2.getKey(), (String) entry2.getValue());
                        try {
                            di diVar = new di();
                            diVar.cwC.cwA = false;
                            diVar.cwC.cwz = str2;
                            diVar.cwC.ceI = str;
                            com.tencent.mm.sdk.b.a.xxA.m(diVar);
                            ab.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                        } catch (Exception e2) {
                            ab.e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
                            ab.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
                        }
                    }
                    JR.uGk.clear();
                }
                if (!(JR.uGj == null || JR.uGj.isEmpty())) {
                    it = JR.uGj.entrySet().iterator();
                    ab.i("MicroMsg.MsgHandler", "Is in hard biz(%b)", Boolean.valueOf(com.tencent.mm.plugin.webview.ui.tools.jsapi.g.Ke(JR.dcB())));
                    if (it != null) {
                        while (it.hasNext()) {
                            entry2 = (Entry) it.next();
                            str2 = (String) entry2.getKey();
                            str = (String) entry2.getValue();
                            ab.i("MicroMsg.MsgHandler", "Remove ble devices, srcUserName(%s), deviceId(%s)", str2, str);
                            if (r4) {
                                dj djVar2 = new dj();
                                djVar2.cwE.cwG = str2;
                                djVar2.cwE.ceI = str;
                                com.tencent.mm.sdk.b.a.xxA.m(djVar2);
                                if (djVar2.cwF.cwB) {
                                }
                            }
                            try {
                                dh dhVar2 = new dh();
                                dhVar2.cwx.cwA = false;
                                dhVar2.cwx.cwz = str2;
                                dhVar2.cwx.ceI = str;
                                com.tencent.mm.sdk.b.a.xxA.m(dhVar2);
                                ab.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                            } catch (Exception e22) {
                                ab.e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
                                ab.printErrStackTrace("MicroMsg.MsgHandler", e22, "", new Object[0]);
                            }
                        }
                    }
                    JR.uGj.clear();
                }
            }
            if (JR.uGl != null) {
                com.tencent.mm.model.ao.a.flu.or(JR.uGl);
            }
            com.tencent.mm.plugin.webview.model.f cXv = com.tencent.mm.plugin.webview.model.f.a.ulU;
            if (bo.ek(cXv.ulR)) {
                ab.d("MicroMsg.WebView.JsLogHelper", "not kv stat cached, no need to doReport, skip");
            } else if (com.tencent.mm.kernel.g.RK()) {
                List list;
                cXv.ulO = com.tencent.mm.m.g.Nu().getInt("MMUxAdLog2GSendSize", 20480);
                cXv.ulP = com.tencent.mm.m.g.Nu().getInt("MMUxAdLog3GSendSize", 30720);
                cXv.ulQ = com.tencent.mm.m.g.Nu().getInt("MMUxAdLogWifiSendSize", VideoMemoryManager.VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB);
                ab.d("MicroMsg.WebView.JsLogHelper", "readDynamicSendSize, 2g(%d), 3g(%d), wifi(%d)", Integer.valueOf(cXv.ulO), Integer.valueOf(cXv.ulP), Integer.valueOf(cXv.ulQ));
                List<axc> list2 = cXv.ulR;
                if (bo.ek(list2)) {
                    ab.d("MicroMsg.WebView.JsLogHelper", "no need to split, existings is empty");
                    list = null;
                } else {
                    axc axc;
                    int i2;
                    ab.d("MicroMsg.WebView.JsLogHelper", "begin split >>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    ab.d("MicroMsg.WebView.JsLogHelper", "before split, given list:");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.setLength(0);
                    stringBuilder.append("{ ");
                    for (axc axc2 : list2) {
                        stringBuilder.append(axc2.wBd).append(", ");
                    }
                    stringBuilder.append(" }");
                    ab.d("MicroMsg.WebView.JsLogHelper", stringBuilder.toString());
                    if (bo.az(cXv.ulT) >= 100 || cXv.ulS <= 0) {
                        cXv.ulT = SystemClock.elapsedRealtime();
                        int i3;
                        if (at.isWifi(ah.getContext())) {
                            i3 = cXv.ulQ;
                            cXv.ulS = i3;
                            i2 = i3;
                        } else if (at.is3G(ah.getContext()) || at.is4G(ah.getContext())) {
                            i3 = cXv.ulP;
                            cXv.ulS = i3;
                            i2 = i3;
                        } else {
                            at.is2G(ah.getContext());
                            i3 = cXv.ulO;
                            cXv.ulS = i3;
                            i2 = i3;
                        }
                    } else {
                        i2 = cXv.ulS;
                    }
                    LinkedList linkedList = new LinkedList();
                    linkedList.addAll(list2);
                    LinkedList<List> linkedList2 = new LinkedList();
                    LinkedList linkedList3 = null;
                    int i4 = 0;
                    while (linkedList.size() > 0) {
                        if (i4 <= 0) {
                            linkedList3 = new LinkedList();
                            axc2 = (axc) linkedList.remove();
                            i4 += axc2.wBe.wR.length;
                            linkedList3.add(axc2);
                            linkedList2.add(linkedList3);
                        } else if (((axc) linkedList.peek()).wBe.wR.length + i4 >= i2) {
                            i4 = 0;
                        } else {
                            axc2 = (axc) linkedList.remove();
                            i4 += axc2.wBe.wR.length;
                            linkedList3.add(axc2);
                        }
                    }
                    ab.d("MicroMsg.WebView.JsLogHelper", "split result: ");
                    for (List<axc> list3 : linkedList2) {
                        stringBuilder.setLength(0);
                        stringBuilder.append("{ ");
                        for (axc axc22 : list3) {
                            stringBuilder.append(axc22.wBd).append(", ");
                        }
                        stringBuilder.append(" }");
                        ab.d("MicroMsg.WebView.JsLogHelper", stringBuilder.toString());
                        ab.d("MicroMsg.WebView.JsLogHelper", "---------------------------");
                    }
                    ab.d("MicroMsg.WebView.JsLogHelper", "end split <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    Object list4 = linkedList2;
                }
                if (bo.ek(list4)) {
                    ab.d("MicroMsg.WebView.JsLogHelper", "split result empty, skip");
                } else {
                    for (List list42 : list42) {
                        if (!bo.ek(list42)) {
                            ab.d("MicroMsg.WebView.JsLogHelper", "trigger do scene");
                            com.tencent.mm.kernel.g.Rg().a(new u(list42), 0);
                        }
                    }
                    cXv.ulR.clear();
                }
            } else {
                ab.i("MicroMsg.WebView.JsLogHelper", "doReport(), acc not ready, skip");
            }
            if (JR.uGh != null) {
                JR.uGh.setClassLoader(JR.getClass().getClassLoader());
            }
            if (JR.uGh != null) {
                Parcelable parcelable = JR.uGh.getParcelable("KSnsAdTag");
                if (parcelable != null && (parcelable instanceof SnsAdClick)) {
                    SnsAdClick snsAdClick = (SnsAdClick) parcelable;
                    ol olVar = new ol();
                    olVar.cKM.cKN = 1;
                    olVar.cKM.cKz = snsAdClick;
                    com.tencent.mm.sdk.b.a.xxA.m(olVar);
                }
            }
            str = "";
            if (JR.uGh != null) {
                JR.uGh.setClassLoader(JR.getClass().getClassLoader());
                str = JR.uGh.getString("KoriginUrl");
            }
            vr vrVar = new vr();
            vrVar.cSE.clP = str;
            com.tencent.mm.sdk.b.a.xxA.m(vrVar);
            if (JR.uGh != null) {
                com.tencent.mm.modelsns.b n = com.tencent.mm.modelsns.b.n(JR.uGh);
                if (n != null) {
                    n.update();
                    n.ajK();
                }
            }
            for (String str3 : JR.uGO.keySet()) {
                if (!bo.isNullOrNil(str3)) {
                    g.cYE();
                    aj.yC(str3);
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.g.b bVar = (com.tencent.mm.plugin.webview.ui.tools.jsapi.g.b) JR.uGO.get(str3);
                    if (bVar != null) {
                        if (bVar.uIC != null) {
                            g.cYE().a(bVar.uIC);
                        }
                        if (bVar.uGd != null) {
                            JR.a(bVar.uGd, "uploadVideo:cancel", null, false);
                        }
                    }
                }
            }
            JR.uGO.clear();
            for (com.tencent.mm.pluginsdk.ui.tools.t.a aVar : com.tencent.mm.pluginsdk.ui.tools.t.dlE()) {
                ab.i("MicroMsg.MsgHandler", "onWebViewUIDestroy, stop plugin = " + aVar.getName());
                aVar.dbp();
            }
            com.tencent.mm.pluginsdk.ui.tools.t.clear();
            com.tencent.mm.sdk.b.a.xxA.d(JR.qwg);
            com.tencent.mm.sdk.b.a.xxA.d(JR.qwh);
            com.tencent.mm.sdk.b.a.xxA.d(JR.uGN);
            com.tencent.mm.sdk.b.a.xxA.d(JR.uHa);
            if (JR.uGQ != null) {
                com.tencent.mm.sdk.b.a.xxA.d(JR.uGQ);
            }
            if (JR.hwv != null) {
                com.tencent.mm.sdk.b.a.xxA.d(JR.hwv);
            }
            if (JR.uGY != null) {
                JR.uGY.dead();
            }
            if (com.tencent.mm.kernel.g.RK()) {
                com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_IBEACON_SHAKE_IS_RANGING_INTERFACE_BOOLEAN, Boolean.FALSE);
            }
            Editor edit = ah.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).edit();
            edit.putBoolean("isNewScanning", false);
            edit.commit();
            JR.uGe = null;
            JR.uGM = null;
            JR.b(JR.uGd, new int[0]);
            JR.uGp = null;
            JR.uGV.clear();
            com.tencent.mm.plugin.webview.modelcache.r cYq = com.tencent.mm.plugin.webview.modelcache.r.a.uor;
            List list5 = JR.uGR;
            if (!(y.Me() == 0 || !com.tencent.mm.kernel.g.RK() || bo.ek(list5))) {
                cYq.aNS().aa(new com.tencent.mm.plugin.webview.modelcache.r.AnonymousClass5(list5));
            }
            com.tencent.mm.plugin.webview.modelcache.r.a.uor.IP(JR.cIv);
            com.tencent.mm.kernel.g.Rg().b((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_HEIBAI, JR.uGr);
            AppMethodBeat.o(7170);
        }

        public final void dD(String str, int i) {
            AppMethodBeat.i(7171);
            Bundle bundle = new Bundle();
            bundle.putString("proxyui_phone", str);
            WebViewStubService.a(WebViewStubService.this, 8, bundle, i);
            AppMethodBeat.o(7171);
        }

        public final boolean cZn() {
            AppMethodBeat.i(7172);
            boolean YM = r.YM();
            AppMethodBeat.o(7172);
            return YM;
        }

        public final void a(String str, int[] iArr, int i, int i2) {
            AppMethodBeat.i(7173);
            if (WebViewStubService.this.uiP == null) {
                WebViewStubService.this.uiP = new HashMap();
                com.tencent.mm.sdk.b.a.xxA.c(WebViewStubService.this.eFv);
            }
            com.tencent.mm.model.v.b y = v.Zp().y("basescanui@datacenter", true);
            y.j("key_basescanui_screen_x", Integer.valueOf(i));
            y.j("key_basescanui_screen_y", Integer.valueOf(i2));
            np npVar = new np();
            npVar.cJU.filePath = str;
            if (iArr != null && iArr.length > 0) {
                npVar.cJU.cJV = new HashSet();
                for (int valueOf : iArr) {
                    npVar.cJU.cJV.add(Integer.valueOf(valueOf));
                }
            }
            com.tencent.mm.sdk.b.a.xxA.m(npVar);
            WebViewStubService.this.uiP.put(str, Integer.valueOf(1));
            AppMethodBeat.o(7173);
        }

        public final void afo(String str) {
            AppMethodBeat.i(7174);
            if (WebViewStubService.this.uiP == null || !WebViewStubService.this.uiP.containsKey(str)) {
                ab.e("MicroMsg.WebViewStubService", "%s is not recognizing", str);
                AppMethodBeat.o(7174);
                return;
            }
            com.tencent.mm.g.a.an anVar = new com.tencent.mm.g.a.an();
            anVar.ctC.filePath = str;
            com.tencent.mm.sdk.b.a.xxA.m(anVar);
            WebViewStubService.this.uiP.remove(str);
            AppMethodBeat.o(7174);
        }

        public final void a(String str, String str2, String str3, int i, int i2, Bundle bundle) {
            AppMethodBeat.i(7175);
            if (str == null) {
                AppMethodBeat.o(7175);
                return;
            }
            Intent intent = new Intent();
            intent.setClass(ah.getContext(), WebviewScanImageActivity.class);
            intent.setFlags(872415232);
            intent.putExtra("key_string_for_scan", str);
            intent.putExtra("key_string_for_url", str2);
            intent.putExtra("key_string_for_image_url", str3);
            intent.putExtra("key_codetype_for_scan", i);
            intent.putExtra("key_codeversion_for_scan", i2);
            if (bundle != null) {
                String string = bundle.getString("preUsername");
                String string2 = bundle.getString("preChatName");
                String string3 = bundle.getString("rawUrl");
                String nW = v.nW("WebviewQrCode");
                com.tencent.mm.model.v.b y = v.Zp().y(nW, true);
                y.j("preUsername", string);
                y.j("preChatName", string2);
                y.j("url", str2);
                y.j("rawUrl", string3);
                intent.putExtra("img_gallery_session_id", nW);
            }
            ah.getContext().startActivity(intent);
            AppMethodBeat.o(7175);
        }

        public final String afp(String str) {
            AppMethodBeat.i(7176);
            String str2 = "";
            com.tencent.mm.pluginsdk.e.aiq(str);
            AppMethodBeat.o(7176);
            return str2;
        }

        public final boolean cZo() {
            AppMethodBeat.i(7177);
            if (AnonymousClass1.vn("EnableWebviewScanQRCode") == 1) {
                AppMethodBeat.o(7177);
                return true;
            }
            AppMethodBeat.o(7177);
            return false;
        }

        private static int vn(String str) {
            int i = 1;
            AppMethodBeat.i(7178);
            try {
                i = bo.getInt(com.tencent.mm.m.g.Nu().getValue(str), 1);
            } catch (Exception e) {
                ab.e("MicroMsg.WebViewStubService", "getIntValFromDynamicConfig parseInt failed, val: ".concat(String.valueOf(str)));
            }
            AppMethodBeat.o(7178);
            return i;
        }

        public final void Jd(int i) {
            AppMethodBeat.i(7179);
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g JR = h.JR(i);
            WebViewStubService webViewStubService = WebViewStubService.this;
            JR.uGm = false;
            for (com.tencent.mm.pluginsdk.ui.tools.t.a aVar : com.tencent.mm.pluginsdk.ui.tools.t.dlE()) {
                ab.i("MicroMsg.MsgHandler", "onWebViewUIResume, resume plugin = " + aVar.getName());
                aVar.ft(webViewStubService);
            }
            JR.uGs = false;
            if (JR.uGh != null) {
                Parcelable parcelable = JR.uGh.getParcelable("KSnsAdTag");
                if (parcelable != null && (parcelable instanceof SnsAdClick)) {
                    SnsAdClick snsAdClick = (SnsAdClick) parcelable;
                    if (snsAdClick.fQd > 0) {
                        snsAdClick.fQe += bo.az(snsAdClick.fQd);
                        snsAdClick.fQd = 0;
                    }
                }
            }
            AppMethodBeat.o(7179);
        }

        public final void Je(int i) {
            AppMethodBeat.i(7180);
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g JR = h.JR(i);
            JR.uGm = true;
            for (com.tencent.mm.pluginsdk.ui.tools.t.a aVar : com.tencent.mm.pluginsdk.ui.tools.t.dlE()) {
                ab.i("MicroMsg.MsgHandler", "onWebViewUIPause, pause plugin = " + aVar.getName());
                aVar.dbq();
            }
            if (JR.uGh != null) {
                Parcelable parcelable = JR.uGh.getParcelable("KSnsAdTag");
                if (parcelable != null && (parcelable instanceof SnsAdClick)) {
                    ((SnsAdClick) parcelable).fQd = bo.yz();
                }
            }
            AppMethodBeat.o(7180);
        }

        public final Bundle g(int i, Bundle bundle) {
            AppMethodBeat.i(7181);
            Bundle bundle2 = new Bundle();
            String nullAsNil;
            String string;
            Bundle bundle3;
            FileDownloadTaskInfo hm;
            String str;
            int i2;
            Bundle bundle4;
            boolean RK;
            com.tencent.mm.storage.c cVar;
            int i3;
            Object obj;
            switch (i) {
                case 14:
                    if (bundle == null) {
                        AppMethodBeat.o(7181);
                        return null;
                    }
                    nullAsNil = bo.nullAsNil(bundle.getString("task_url"));
                    ab.i("MicroMsg.WebViewStubService", "add download task, taskurl = %s, taskname = %s", nullAsNil, bundle.getString("task_name"));
                    if (bo.isNullOrNil(nullAsNil)) {
                        ab.e("MicroMsg.WebViewStubService", "download url is null or nil");
                        AppMethodBeat.o(7181);
                        return null;
                    }
                    com.tencent.mm.plugin.downloader.model.e.a aVar = new com.tencent.mm.plugin.downloader.model.e.a();
                    aVar.It(nullAsNil);
                    aVar.Iv(string);
                    aVar.ga(true);
                    aVar.tN(1);
                    ab.i("MicroMsg.WebViewStubService", "add download task, downloadId = %d", Long.valueOf(com.tencent.mm.plugin.downloader.model.d.bij().a(aVar.kNl)));
                    bundle3 = new Bundle();
                    bundle3.putLong("download_id", r2);
                    AppMethodBeat.o(7181);
                    return bundle3;
                case 15:
                    hm = com.tencent.mm.plugin.downloader.model.d.bij().hm(bundle.getLong("download_id", 0));
                    str = "MicroMsg.WebViewStubService";
                    String str2 = "query download task info, info == null ? %b task state = %d";
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(hm == null);
                    if (hm == null) {
                        i2 = 0;
                    } else {
                        i2 = hm.status;
                    }
                    objArr[1] = Integer.valueOf(i2);
                    ab.i(str, str2, objArr);
                    i2 = 0;
                    if (hm != null) {
                        i2 = hm.status;
                    }
                    ab.i("MicroMsg.WebViewStubService", "query download task, task id = %d, ret = %d", Long.valueOf(r2), Integer.valueOf(i2));
                    bundle4 = new Bundle();
                    bundle4.putInt("download_state", i2);
                    AppMethodBeat.o(7181);
                    return bundle4;
                case 16:
                    ab.i("MicroMsg.WebViewStubService", "query download task, task id = %d, ret = %d", Long.valueOf(bundle.getLong("download_id", 0)), Integer.valueOf(com.tencent.mm.plugin.downloader.model.d.bij().hl(bundle.getLong("download_id", 0))));
                    bundle4 = new Bundle();
                    bundle4.putBoolean("cancel_result", com.tencent.mm.plugin.downloader.model.d.bij().hl(bundle.getLong("download_id", 0)) > 0);
                    AppMethodBeat.o(7181);
                    return bundle4;
                case 17:
                    hm = com.tencent.mm.plugin.downloader.model.d.bij().hm(bundle.getLong("download_id"));
                    bundle3 = new Bundle();
                    if (hm == null) {
                        ab.e("MicroMsg.WebViewStubService", "install download task fail, get download task info failed");
                        bundle3.putBoolean("install_result", false);
                        AppMethodBeat.o(7181);
                        return bundle3;
                    } else if (hm.status != 3) {
                        ab.e("MicroMsg.WebViewStubService", "install download task fail, invalid status = " + hm.status);
                        bundle3.putBoolean("install_result", false);
                        AppMethodBeat.o(7181);
                        return bundle3;
                    } else if (com.tencent.mm.a.e.ct(hm.path)) {
                        com.tencent.mm.pluginsdk.model.app.q.a(WebViewStubService.this, Uri.fromFile(new File(hm.path)), null);
                        bundle3.putBoolean("install_result", true);
                        AppMethodBeat.o(7181);
                        return bundle3;
                    } else {
                        ab.e("MicroMsg.WebViewStubService", "file not exists : %s", hm.path);
                        bundle3.putBoolean("install_result", false);
                        AppMethodBeat.o(7181);
                        return bundle3;
                    }
                case 19:
                    bundle3 = new Bundle();
                    bundle3.putBoolean("webview_video_proxy_init", ao.cXP().hasInit);
                    AppMethodBeat.o(7181);
                    return bundle3;
                case 23:
                    RK = com.tencent.mm.kernel.g.RK();
                    AnonymousClass7 anonymousClass7 = new bj<String>() {
                        public final /* synthetic */ Object run() {
                            AppMethodBeat.i(7112);
                            if (com.tencent.mm.kernel.g.RK()) {
                                Object Yz = r.Yz();
                                AppMethodBeat.o(7112);
                                return Yz;
                            }
                            String str = "";
                            AppMethodBeat.o(7112);
                            return str;
                        }
                    };
                    if (RK) {
                        nullAsNil = (String) anonymousClass7.b(null);
                    } else {
                        nullAsNil = (String) anonymousClass7.b(WebViewStubService.this.handler);
                    }
                    bundle4 = new Bundle();
                    bundle4.putString("config_info_username", nullAsNil);
                    AppMethodBeat.o(7181);
                    return bundle4;
                case 24:
                    bundle4 = new Bundle();
                    cVar = null;
                    try {
                        cVar = com.tencent.mm.model.c.c.abi().ll(com.tencent.mm.plugin.webview.modeltools.c.uoy);
                    } catch (AssertionFailedError e) {
                        ab.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: getHostList, acc stg is null");
                    } catch (com.tencent.mm.model.b e2) {
                        ab.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: getHostList, uin invalid");
                    }
                    if (cVar == null || !cVar.isValid()) {
                        ab.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: dbItem(%s) invalid", cVar);
                        AppMethodBeat.o(7181);
                        return bundle4;
                    }
                    Map dru = cVar.dru();
                    long j = bo.getLong((String) dru.get("interval"), 0);
                    long anT = bo.anT();
                    ab.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: nextQuerySeconds(%d), now(%d), interval(%d)", Long.valueOf(bo.c((Long) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WEBVIEW_CLEAR_HOST_COOKIES_INTERVAL_LONG, null))), Long.valueOf(anT), Long.valueOf(j));
                    if (bo.c((Long) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WEBVIEW_CLEAR_HOST_COOKIES_INTERVAL_LONG, null)) >= anT) {
                        ab.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: not exceed interval, skip");
                        AppMethodBeat.o(7181);
                        return bundle4;
                    }
                    com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WEBVIEW_CLEAR_HOST_COOKIES_INTERVAL_LONG, Long.valueOf(j + anT));
                    i3 = bo.getInt((String) dru.get("urlCount"), 0);
                    ArrayList arrayList = new ArrayList(i3);
                    for (i2 = 0; i2 < i3; i2++) {
                        arrayList.add(dru.get(String.format("url%d", new Object[]{Integer.valueOf(i2)})));
                    }
                    bundle4.putStringArrayList("cookies_cleanup_url_list", arrayList);
                    AppMethodBeat.o(7181);
                    return bundle4;
                case 26:
                    com.tencent.mm.plugin.webview.modelcache.c.cYl();
                    bundle3 = new Bundle(1);
                    bundle3.putBoolean("webview_resource_cache_inWhiteList", false);
                    AppMethodBeat.o(7181);
                    return bundle3;
                case 31:
                    if (com.tencent.mm.kernel.g.RK()) {
                        cVar = com.tencent.mm.model.c.c.abi().ll("100036");
                        if (cVar.isValid()) {
                            Map dru2 = cVar.dru();
                            bundle4 = new Bundle();
                            i2 = bo.getInt((String) dru2.get("controlFlag"), 0);
                            bundle4.putInt("webview_ad_intercept_control_flag", i2);
                            if (i2 == 0) {
                                ab.i("MicroMsg.WebViewStubService", "control flag = 0, ignore get black list and white list");
                                AppMethodBeat.o(7181);
                                return bundle4;
                            }
                            int i4;
                            int i5 = bo.getInt((String) dru2.get("blackListCount"), 0);
                            ArrayList arrayList2 = new ArrayList();
                            for (i4 = 0; i4 < i5; i4++) {
                                nullAsNil = (String) dru2.get("blackList" + (i4 + 1));
                                if (!(bo.isNullOrNil(nullAsNil) || arrayList2.contains(nullAsNil))) {
                                    ab.i("MicroMsg.WebViewStubService", "add black list domin = %s", nullAsNil);
                                    arrayList2.add(nullAsNil);
                                }
                            }
                            i5 = bo.getInt((String) dru2.get("whiteListCount"), 0);
                            ArrayList arrayList3 = new ArrayList();
                            for (i4 = 0; i4 < i5; i4++) {
                                nullAsNil = (String) dru2.get("whiteList" + (i4 + 1));
                                if (!(bo.isNullOrNil(nullAsNil) || arrayList3.contains(nullAsNil))) {
                                    ab.i("MicroMsg.WebViewStubService", "add white list domin = %s", nullAsNil);
                                    arrayList3.add(nullAsNil);
                                }
                            }
                            bundle4.putStringArrayList("webview_ad_intercept_blacklist_domins", arrayList2);
                            bundle4.putStringArrayList("webview_ad_intercept_whitelist_domins", arrayList3);
                            AppMethodBeat.o(7181);
                            return bundle4;
                        }
                        ab.d("MicroMsg.WebViewStubService", "test is valid");
                        AppMethodBeat.o(7181);
                        return null;
                    }
                    AppMethodBeat.o(7181);
                    return null;
                case 50:
                    if (bundle == null) {
                        AppMethodBeat.o(7181);
                        return null;
                    }
                    string = bundle.getString("data");
                    if (string == null) {
                        AppMethodBeat.o(7181);
                        return null;
                    }
                    bundle3 = new Bundle();
                    bundle3.putInt("key_biz_type", com.tencent.mm.aj.f.qX(string).field_type);
                    AppMethodBeat.o(7181);
                    return bundle3;
                case 51:
                    try {
                        if (Looper.myLooper() == null) {
                            Looper.prepare();
                        }
                        com.tencent.mm.sdk.g.d.xDG.execute(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(7111);
                                com.tencent.mm.modelgeo.d.agz().a(new com.tencent.mm.modelgeo.b.a() {
                                    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                                        AppMethodBeat.i(7110);
                                        ab.i("MicroMsg.WebViewStubService", "onGetLocation %b %f|%f", Boolean.valueOf(z), Float.valueOf(f), Float.valueOf(f2));
                                        com.tencent.mm.modelgeo.d.agz().c(this);
                                        AppMethodBeat.o(7110);
                                        return false;
                                    }
                                }, true);
                                AppMethodBeat.o(7111);
                            }
                        });
                    } catch (Exception e3) {
                        ab.printErrStackTrace("MicroMsg.WebViewStubService", e3, "", new Object[0]);
                    }
                    AppMethodBeat.o(7181);
                    return null;
                case 71:
                    if (bundle == null) {
                        AppMethodBeat.o(7181);
                        return null;
                    }
                    nullAsNil = bundle.getString("enterprise_action");
                    bundle4 = new Bundle();
                    if (nullAsNil.equals("enterprise_has_connector")) {
                        String str3 = "enterprise_has_connector";
                        z.aeR();
                        if (com.tencent.mm.aj.e.aev().size() > 0) {
                            RK = true;
                        } else {
                            RK = false;
                        }
                        bundle4.putBoolean(str3, RK);
                    } else if (nullAsNil.equals("enterprise_connectors")) {
                        z.aeR();
                        List aev = com.tencent.mm.aj.e.aev();
                        if (aev != null) {
                            bundle4.putStringArrayList("enterprise_connectors", new ArrayList(aev));
                        }
                    }
                    AppMethodBeat.o(7181);
                    return bundle4;
                case 75:
                    ao cXP = ao.cXP();
                    if (cXP.hasInit) {
                        cXP.umI = null;
                        ao.umH = null;
                        cXP.hasInit = false;
                    }
                    AppMethodBeat.o(7181);
                    return null;
                case 76:
                    if (bundle == null) {
                        bundle3 = Bundle.EMPTY;
                        AppMethodBeat.o(7181);
                        return bundle3;
                    }
                    bundle3 = new Bundle();
                    bundle3.putString("appId", h.JR(bundle.getInt("webview_binder_id")).bK(bo.nullAsNil(bundle.getString("rawUrl"))));
                    AppMethodBeat.o(7181);
                    return bundle3;
                case com.tencent.mm.plugin.appbrand.jsapi.d.h.a.CTRL_INDEX /*78*/:
                    bundle2.putBoolean("isOpenForFaceBook", r.YX());
                    break;
                case 80:
                    if (bundle != null) {
                        nullAsNil = bundle.getString("KAppId");
                        string = bundle.getString("shortcut_user_name");
                        i3 = bundle.getInt("webviewui_binder_id");
                        if (!bo.isNullOrNil(nullAsNil) && !bo.isNullOrNil(string)) {
                            WebViewStubService.a(WebViewStubService.this, 10, bundle, i3);
                            break;
                        }
                        AppMethodBeat.o(7181);
                        return null;
                    }
                    AppMethodBeat.o(7181);
                    return null;
                    break;
                case 83:
                    WebViewStubService.this.uqA = bundle.getInt("screen_orientation", -1);
                    break;
                case PlayerException.EXCEPTION_IN_PREPARE /*91*/:
                    if (bundle != null) {
                        i2 = bundle.getInt("game_sourceScene");
                        gt gtVar = new gt();
                        gtVar.cBv.actionCode = 5;
                        gtVar.cBv.scene = i2;
                        com.tencent.mm.sdk.b.a.xxA.m(gtVar);
                        break;
                    }
                    AppMethodBeat.o(7181);
                    return null;
                case 92:
                    if (bundle != null) {
                        nullAsNil = bundle.getString("game_hv_menu_appid");
                        if (!bo.isNullOrNil(nullAsNil)) {
                            gu guVar = new gu();
                            guVar.cBw.Cn = 3;
                            guVar.cBw.cBy = nullAsNil;
                            com.tencent.mm.sdk.b.a.xxA.m(guVar);
                            bundle2.putString("game_hv_menu_pbcache", guVar.cBx.result);
                            break;
                        }
                        AppMethodBeat.o(7181);
                        return null;
                    }
                    AppMethodBeat.o(7181);
                    return null;
                case PlayerException.EXCEPTION_IN_PAUSE /*93*/:
                    bundle3 = new Bundle();
                    bundle3.putBoolean("is_oauth_native", false);
                    if (!com.tencent.mm.kernel.g.RN().QY()) {
                        ab.i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative account not ready");
                        AppMethodBeat.o(7181);
                        return bundle3;
                    } else if (com.tencent.mm.kernel.g.RQ().eKi.eKC) {
                        com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100272");
                        if (ll.isValid()) {
                            Map dru3 = ll.dru();
                            if (dru3 == null) {
                                ab.i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative args == null");
                                AppMethodBeat.o(7181);
                                return bundle3;
                            } else if (dru3.containsKey("isUseNative") && "1".equals(dru3.get("isUseNative"))) {
                                bundle3.putBoolean("is_oauth_native", true);
                                AppMethodBeat.o(7181);
                                return bundle3;
                            } else {
                                ab.i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative not contain the isUseNative key or the value is not 1");
                                AppMethodBeat.o(7181);
                                return bundle3;
                            }
                        }
                        ab.i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative item.isValid is false");
                        AppMethodBeat.o(7181);
                        return bundle3;
                    } else {
                        ab.i("MicroMsg.OauthAuthorizeLogic", "kernel has not startup done");
                        AppMethodBeat.o(7181);
                        return bundle3;
                    }
                case 94:
                    bundle3 = com.tencent.mm.plugin.webview.model.af.a.cXG();
                    AppMethodBeat.o(7181);
                    return bundle3;
                case 96:
                    if (bundle == null) {
                        AppMethodBeat.o(7181);
                        return null;
                    }
                    Set<String> keySet = bundle.keySet();
                    if (keySet == null) {
                        AppMethodBeat.o(7181);
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        for (String nullAsNil2 : keySet) {
                            jSONObject.put(nullAsNil2, bundle.get(nullAsNil2));
                        }
                        gu guVar2 = new gu();
                        guVar2.cBw.Cn = 4;
                        guVar2.cBw.cBy = jSONObject.toString();
                        com.tencent.mm.sdk.b.a.xxA.m(guVar2);
                        break;
                    } catch (JSONException e4) {
                        AppMethodBeat.o(7181);
                        return null;
                    }
                case 100:
                    bundle3 = com.tencent.mm.plugin.webview.model.a.b.cXt();
                    AppMethodBeat.o(7181);
                    return bundle3;
                case 102:
                    if (bundle != null) {
                        bundle2.putBoolean("is_enterprise_username", com.tencent.mm.aj.f.ra(bundle.getString("enterprise_biz_username")));
                        break;
                    }
                    AppMethodBeat.o(7181);
                    return null;
                case 103:
                    bundle3 = com.tencent.mm.plugin.webview.ui.tools.bag.n.a.af(bundle);
                    AppMethodBeat.o(7181);
                    return bundle3;
                case 104:
                    bundle3 = new Bundle();
                    com.tencent.mm.plugin.webview.modeltools.f.V(bundle);
                    bundle3.putBoolean("open_result", false);
                    AppMethodBeat.o(7181);
                    return bundle3;
                case 105:
                    if (bundle == null) {
                        bundle3 = new Bundle();
                        AppMethodBeat.o(7181);
                        return bundle3;
                    }
                    int i6 = bundle.getInt("WebViewShare_BinderID");
                    i3 = bundle.getInt("WebViewShare_type");
                    bundle2 = new Bundle();
                    str = bundle.getString("WebViewShare_wv_url", "");
                    com.tencent.mm.plugin.webview.modeltools.l.a aVar2 = null;
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.g JR;
                    String aef;
                    l lVar;
                    if (i3 == 1) {
                        JR = h.JR(i6);
                        aef = com.tencent.mm.pluginsdk.ui.tools.u.aef(str);
                        lVar = JR.uGv;
                        if (!lVar.upC.containsKey(aef) || lVar.upC.get(aef) == null) {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                        if (obj == null) {
                            aVar2 = null;
                        } else {
                            aVar2 = (com.tencent.mm.plugin.webview.modeltools.l.a) JR.uGv.upC.get(aef);
                        }
                        bundle2.putBoolean("WebViewShare_reslut", aVar2 != null);
                    } else if (i3 == 2) {
                        boolean z;
                        JR = h.JR(i6);
                        aef = com.tencent.mm.pluginsdk.ui.tools.u.aef(str);
                        lVar = JR.uGv;
                        if (!lVar.upD.containsKey(aef) || lVar.upD.get(aef) == null) {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                        if (obj == null) {
                            aVar2 = null;
                        } else {
                            aVar2 = (com.tencent.mm.plugin.webview.modeltools.l.a) JR.uGv.upD.get(aef);
                        }
                        aef = "WebViewShare_reslut";
                        if (aVar2 != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        bundle2.putBoolean(aef, z);
                    }
                    if (aVar2 != null) {
                        bundle2.putString("link", aVar2.link);
                        bundle2.putString("title", aVar2.title);
                        bundle2.putString("desc", aVar2.desc);
                        bundle2.putString("img_url", aVar2.rid);
                    }
                    AppMethodBeat.o(7181);
                    return bundle2;
                case 106:
                    cVar = com.tencent.mm.model.c.c.abi().ll("100484");
                    if (!cVar.isValid()) {
                        AppMethodBeat.o(7181);
                        return null;
                    } else if ("1".equals(cVar.dru().get("closeDelayInject"))) {
                        bundle3 = new Bundle();
                        AppMethodBeat.o(7181);
                        return bundle3;
                    } else {
                        AppMethodBeat.o(7181);
                        return null;
                    }
                case 108:
                    com.tencent.mm.sdk.b.a.xxA.m(new bu());
                    AppMethodBeat.o(7181);
                    return null;
                case 109:
                    if (bundle == null) {
                        bundle3 = new Bundle();
                        AppMethodBeat.o(7181);
                        return bundle3;
                    }
                    com.tencent.mm.plugin.webview.e.c.a aVar3;
                    i2 = bundle.getInt("WebViewShare_BinderID");
                    string = bundle.getString("WebViewShare_wv_url", "");
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.g JR2 = h.JR(i2);
                    string = com.tencent.mm.pluginsdk.ui.tools.u.aef(string);
                    com.tencent.mm.plugin.webview.e.c cVar2 = JR2.uGw;
                    if (!cVar2.uKV.containsKey(string) || cVar2.uKV.get(string) == null) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj == null) {
                        aVar3 = null;
                    } else {
                        aVar3 = JR2.uGw.agE(string);
                    }
                    bundle4 = new Bundle();
                    if (aVar3 != null) {
                        bundle4.putInt("key_hao_kan_permission", aVar3.permission);
                        bundle4.putInt("key_hao_kan_recommand", aVar3.uKW);
                        bundle4.putString("key_hao_kan_title", aVar3.title);
                    }
                    AppMethodBeat.o(7181);
                    return bundle4;
                case GmsClientSupervisor.DEFAULT_BIND_FLAGS /*129*/:
                    i3 = bundle.getInt("webview_instance_id");
                    e eVar = null;
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.cAV) {
                        e eVar2;
                        if (webViewStubCallbackWrapper == null || webViewStubCallbackWrapper.id != i3) {
                            eVar2 = eVar;
                        } else {
                            eVar2 = webViewStubCallbackWrapper.uuT;
                        }
                        eVar = eVar2;
                    }
                    h.JR(i3).a(WebViewStubService.this, eVar);
                    HashMap hashMap = new HashMap();
                    hashMap.put("scene", Integer.valueOf(bundle.getInt("scene")));
                    hashMap.put("webview_instance_id", Integer.valueOf(i3));
                    g.cYC().aw(hashMap);
                    break;
                case 131:
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("logString", bundle.getString("logString"));
                    com.tencent.mm.plugin.webview.fts.b cYC = g.cYC();
                    obj = com.tencent.mm.plugin.websearch.api.aa.t(hashMap2, "logString");
                    HashMap hashMap3 = new HashMap();
                    if (!obj.contains("h5version=")) {
                        hashMap3.put("h5version", Integer.valueOf(com.tencent.mm.plugin.websearch.api.aa.HV(0)));
                    }
                    if (hashMap3.keySet().size() > 0) {
                        if (obj.length() > 0) {
                            obj = obj + "&" + com.tencent.mm.plugin.websearch.api.aa.an(hashMap3);
                        } else {
                            obj = com.tencent.mm.plugin.websearch.api.aa.an(hashMap3);
                        }
                    }
                    hashMap2.put("logString", obj);
                    cYC.ay(hashMap2);
                    break;
                case 204:
                    if (bundle != null) {
                        try {
                            bundle.setClassLoader(getClass().getClassLoader());
                            if (bundle.getStringArrayList("reportAdH5Load") != null) {
                                ArrayList stringArrayList = bundle.getStringArrayList("reportAdH5Load");
                                og ogVar = new og();
                                ogVar.cKA.cKz = (SnsAdClick) bundle.getParcelable("snsAdClick");
                                ogVar.cKA.url = com.tencent.mm.compatible.util.q.encode((String) stringArrayList.get(0), "UTF-8");
                                ogVar.cKA.cKB = bo.ank((String) stringArrayList.get(1));
                                ogVar.cKA.timestamp = bo.anl((String) stringArrayList.get(2));
                                ogVar.cKA.errorCode = bundle.getInt("errCode", 0);
                                com.tencent.mm.sdk.b.a.xxA.m(ogVar);
                                break;
                            }
                        } catch (Exception e32) {
                            ab.e("MicroMsg.WebViewStubService", "report sns ad exception, %s", e32.getMessage());
                            break;
                        }
                    }
                    AppMethodBeat.o(7181);
                    return null;
                    break;
                case 250:
                    if (bundle != null) {
                        if (bundle != null) {
                            try {
                                com.tencent.mm.sdk.g.d.post(new com.tencent.mm.modelstat.a.c.AnonymousClass1(bundle), "web_call_rpt");
                                break;
                            } catch (Exception e322) {
                                ab.printErrStackTrace("MicroMsg.WebViewStubService", e322, "webview call back mm error", new Object[0]);
                                break;
                            }
                        }
                    }
                    AppMethodBeat.o(7181);
                    return null;
                    break;
                case 251:
                    if (bundle != null) {
                        com.tencent.mm.modelstat.f.akh().u(WebViewUI.class.getName(), bundle.getLong("key_activity_browse_time", 0));
                        break;
                    }
                    AppMethodBeat.o(7181);
                    return null;
                case WearableStatusCodes.DUPLICATE_CAPABILITY /*4006*/:
                    bundle3 = new Bundle();
                    string = ah.doC().getString("nfc_open_url", null);
                    ab.i("MicroMsg.WebViewStubService", "nfc url=" + bo.nullAsNil(string));
                    if (!(bo.isNullOrNil(string) || bo.isNullOrNil(string.trim()))) {
                        bundle3.putString("debugConfig", string);
                    }
                    bundle3.putString("config", String.valueOf(com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_NFC_CPU_CARD_CONFIG_STRING, null)));
                    AppMethodBeat.o(7181);
                    return bundle3;
                case 10001:
                    StringBuilder stringBuilder = new StringBuilder("kwid_");
                    com.tencent.mm.kernel.g.RN();
                    com.tencent.mm.modelappbrand.b.fpE = stringBuilder.append(com.tencent.mm.kernel.a.QF()).append("_").append(bo.anU()).toString();
                    ab.v("MicroMsg.AppBrandReporter", "refreshWeAppSearchKeywordId : %s", com.tencent.mm.modelappbrand.b.fpE);
                    break;
                case 100000:
                    cVar = com.tencent.mm.model.c.c.abi().ll("100248");
                    if (cVar.isValid()) {
                        if (bo.getInt((String) cVar.dru().get("isForceSync"), 0) == 1) {
                            ab.d("MicroMsg.ConfigListDecoder", "host list = %s", com.tencent.mm.m.g.Nv().O("WebViewConfig", "forceSyncA8KeyHostPath"));
                            bundle2.putString("force_geta8key_host_path", nullAsNil2);
                            break;
                        }
                    }
                    ab.d("MicroMsg.WebViewStubService", "force geta8key abtest is not invaild");
                    AppMethodBeat.o(7181);
                    return null;
                    break;
                default:
                    ab.e("MicroMsg.WebViewStubService", "unknown action = %d", Integer.valueOf(i));
                    break;
            }
            AppMethodBeat.o(7181);
            return bundle2;
        }

        public final boolean cZp() {
            AppMethodBeat.i(7182);
            com.tencent.mm.kernel.g.RN();
            if (!com.tencent.mm.kernel.a.QX() || com.tencent.mm.kernel.a.QT()) {
                AppMethodBeat.o(7182);
                return true;
            }
            AppMethodBeat.o(7182);
            return false;
        }

        public final void aB(Intent intent) {
            AppMethodBeat.i(7183);
            Intent intent2 = new Intent(WebViewStubService.this, WebViewStubProxyUI.class);
            intent2.putExtra("proxyui_action_code_key", 9);
            intent2.putExtra("proxyui_next_intent_key", intent);
            intent2.setFlags(268435456);
            WebViewStubService.this.startActivity(intent2);
            AppMethodBeat.o(7183);
        }

        public final void J(int i, String str, String str2) {
            AppMethodBeat.i(7184);
            WebViewJSSDKFileItem I = WebViewJSSDKFileItem.I(i, str, str2);
            I.het = false;
            g.cYF().b(I);
            g.cYE().b(null, I.czD, null);
            AppMethodBeat.o(7184);
        }

        public final List<String> cZq() {
            com.tencent.mm.plugin.webview.modeltools.m cYG;
            AppMethodBeat.i(7185);
            if (com.tencent.mm.kernel.g.RK()) {
                g.cYz();
                cYG = g.cYG();
            } else {
                cYG = null;
            }
            if (cYG == null) {
                ArrayList arrayList = new ArrayList();
                AppMethodBeat.o(7185);
                return arrayList;
            }
            List<String> arrayList2 = new ArrayList(cYG.cYN());
            AppMethodBeat.o(7185);
            return arrayList2;
        }

        public final void a(Bundle bundle, int i) {
            AppMethodBeat.i(7186);
            WebViewStubService.this.uqu.put(i, bundle);
            AppMethodBeat.o(7186);
        }

        public final int cZr() {
            AppMethodBeat.i(7187);
            int cZr = com.tencent.mm.pluginsdk.wallet.i.cZr();
            AppMethodBeat.o(7187);
            return cZr;
        }

        public final boolean cZs() {
            AppMethodBeat.i(7188);
            if (AnonymousClass1.vn("WebViewDownLoadFileSwitch") == 1) {
                AppMethodBeat.o(7188);
                return true;
            }
            AppMethodBeat.o(7188);
            return false;
        }

        public final String[] cZt() {
            AppMethodBeat.i(7189);
            String O = com.tencent.mm.m.g.Nv().O("AsyncCheckUrl", "UrlHost");
            if (bo.isNullOrNil(O)) {
                AppMethodBeat.o(7189);
                return null;
            }
            String[] split = O.split(";");
            AppMethodBeat.o(7189);
            return split;
        }

        public final String aff(String str) {
            AppMethodBeat.i(7124);
            String pX = com.tencent.mm.ah.b.pX(str);
            AppMethodBeat.o(7124);
            return pX;
        }

        public final List<String> aeC() {
            AppMethodBeat.i(7131);
            List<String> aeC = com.tencent.mm.aj.f.aeC();
            LinkedList linkedList = new LinkedList();
            for (String str : aeC) {
                if (!com.tencent.mm.aj.f.ra(str)) {
                    linkedList.add(str);
                }
            }
            AppMethodBeat.o(7131);
            return linkedList;
        }

        public final boolean a(String str, boolean z, Bundle bundle) {
            AppMethodBeat.i(7133);
            boolean a = com.tencent.mm.pluginsdk.r.a.vax.a(WebViewStubService.this, str, z, bundle);
            AppMethodBeat.o(7133);
            return a;
        }

        public final void bG(String str, boolean z) {
            AppMethodBeat.i(7136);
            com.tencent.mm.pluginsdk.r.a.vax.a(WebViewStubService.this, str, z);
            AppMethodBeat.o(7136);
        }
    };
    private int uqw = 0;
    private k uqx;
    private com.tencent.mm.plugin.webview.model.d.a uqy;
    private Set<Integer> uqz = new HashSet();

    static class a extends com.tencent.mm.plugin.webview.stub.b.a {
        public boolean csN;
        public int ret;
        public int type;
        public boolean uhJ;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final boolean cYV() {
            return this.uhJ;
        }

        public final boolean getResult() {
            return this.csN;
        }

        public final int getRet() {
            return this.ret;
        }

        public final int getType() {
            return this.type;
        }
    }

    public static class b extends com.tencent.mm.plugin.webview.stub.c.a {
        public String aIm;
        public int errCode;
        public int errType;
        public Bundle mqu;
        public int type;

        public final int getType() {
            return this.type;
        }

        public final int cYW() {
            return this.errType;
        }

        public final int cYX() {
            return this.errCode;
        }

        public final String adx() {
            return this.aIm;
        }

        public final Bundle getData() {
            return this.mqu;
        }
    }

    public WebViewStubService() {
        AppMethodBeat.i(7207);
        AppMethodBeat.o(7207);
    }

    public void onCreate() {
        AppMethodBeat.i(7208);
        super.onCreate();
        ab.i("MicroMsg.WebViewStubService", "WebViewStubService onCreate");
        this.handler = new ak();
        this.uqx = new k() {
            public final void onTaskStarted(long j, String str) {
                AppMethodBeat.i(7194);
                ab.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskResumed, downloadId = ".concat(String.valueOf(j)));
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.cAV) {
                        Bundle bundle = new Bundle();
                        bundle.putLong("download_manager_downloadid", j);
                        com.tencent.mm.plugin.downloader.f.a hv = com.tencent.mm.plugin.downloader.model.c.hv(j);
                        bundle.putCharSequence("download_manager_appid", hv != null ? hv.field_appId : "");
                        webViewStubCallbackWrapper.uuT.c(1012, bundle);
                    }
                    AppMethodBeat.o(7194);
                } catch (Exception e) {
                    ab.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, ex = " + e.getMessage());
                    AppMethodBeat.o(7194);
                }
            }

            public final void b(long j, String str, boolean z) {
                AppMethodBeat.i(7195);
                ab.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFinished, downloadId = ".concat(String.valueOf(j)));
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.cAV) {
                        Bundle bundle = new Bundle();
                        bundle.putLong("download_manager_downloadid", j);
                        com.tencent.mm.plugin.downloader.f.a hv = com.tencent.mm.plugin.downloader.model.c.hv(j);
                        bundle.putCharSequence("download_manager_appid", hv != null ? hv.field_appId : "");
                        webViewStubCallbackWrapper.uuT.c(1002, bundle);
                    }
                    AppMethodBeat.o(7195);
                } catch (Exception e) {
                    ab.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFinished, ex = " + e.getMessage());
                    AppMethodBeat.o(7195);
                }
            }

            public final void b(long j, int i, boolean z) {
                AppMethodBeat.i(7196);
                ab.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFailed, downloadId = ".concat(String.valueOf(j)));
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.cAV) {
                        Bundle bundle = new Bundle();
                        bundle.putLong("download_manager_downloadid", j);
                        com.tencent.mm.plugin.downloader.f.a hv = com.tencent.mm.plugin.downloader.model.c.hv(j);
                        bundle.putCharSequence("download_manager_appid", hv != null ? hv.field_appId : "");
                        bundle.putInt("download_manager_errcode", i);
                        webViewStubCallbackWrapper.uuT.c(1003, bundle);
                    }
                    AppMethodBeat.o(7196);
                } catch (Exception e) {
                    ab.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFailed, ex = " + e.getMessage());
                    AppMethodBeat.o(7196);
                }
            }

            public final void onTaskRemoved(long j) {
                AppMethodBeat.i(7197);
                ab.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, downloadId = ".concat(String.valueOf(j)));
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.cAV) {
                        Bundle bundle = new Bundle();
                        bundle.putLong("download_manager_downloadid", j);
                        com.tencent.mm.plugin.downloader.f.a hv = com.tencent.mm.plugin.downloader.model.c.hv(j);
                        bundle.putCharSequence("download_manager_appid", hv != null ? hv.field_appId : "");
                        webViewStubCallbackWrapper.uuT.c(1008, bundle);
                    }
                    AppMethodBeat.o(7197);
                } catch (Exception e) {
                    ab.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, ex = " + e.getMessage());
                    AppMethodBeat.o(7197);
                }
            }

            public final void onTaskPaused(long j) {
                AppMethodBeat.i(7198);
                ab.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskPaused, downloadId = ".concat(String.valueOf(j)));
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.cAV) {
                        Bundle bundle = new Bundle();
                        bundle.putLong("download_manager_downloadid", j);
                        com.tencent.mm.plugin.downloader.f.a hv = com.tencent.mm.plugin.downloader.model.c.hv(j);
                        bundle.putCharSequence("download_manager_appid", hv != null ? hv.field_appId : "");
                        webViewStubCallbackWrapper.uuT.c(1010, bundle);
                    }
                    AppMethodBeat.o(7198);
                } catch (Exception e) {
                    ab.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, ex = " + e.getMessage());
                    AppMethodBeat.o(7198);
                }
            }

            public final void gm(long j) {
                AppMethodBeat.i(7199);
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.cAV) {
                        com.tencent.mm.plugin.downloader.f.a hv = com.tencent.mm.plugin.downloader.model.c.hv(j);
                        if (hv == null || hv.field_totalSize == 0) {
                            ab.w("MicroMsg.WebViewUI.IFileDownloadCallback", "loadDownloadProgress failed, downloadId = ".concat(String.valueOf(j)));
                            AppMethodBeat.o(7199);
                            return;
                        }
                        int i = (int) ((((double) hv.field_downloadedSize) / ((double) hv.field_totalSize)) * 100.0d);
                        if (i == 0) {
                            i = 1;
                        }
                        Bundle bundle = new Bundle();
                        bundle.putLong("download_manager_downloadid", j);
                        bundle.putInt("download_manager_progress", i);
                        bundle.putString("download_manager_appid", hv.field_appId);
                        webViewStubCallbackWrapper.uuT.c(1007, bundle);
                    }
                    AppMethodBeat.o(7199);
                } catch (Exception e) {
                    ab.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskProgressChanged, ex = " + e.getMessage());
                    AppMethodBeat.o(7199);
                }
            }

            public final void i(long j, String str) {
                AppMethodBeat.i(7200);
                ab.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskResumed, downloadId = ".concat(String.valueOf(j)));
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.cAV) {
                        Bundle bundle = new Bundle();
                        bundle.putLong("download_manager_downloadid", j);
                        com.tencent.mm.plugin.downloader.f.a hv = com.tencent.mm.plugin.downloader.model.c.hv(j);
                        bundle.putCharSequence("download_manager_appid", hv != null ? hv.field_appId : "");
                        webViewStubCallbackWrapper.uuT.c(1011, bundle);
                    }
                    AppMethodBeat.o(7200);
                } catch (Exception e) {
                    ab.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, ex = " + e.getMessage());
                    AppMethodBeat.o(7200);
                }
            }

            public final void gn(long j) {
            }
        };
        com.tencent.mm.plugin.downloader.model.d.bij();
        com.tencent.mm.plugin.downloader.model.b.a(this.uqx);
        this.uqy = new com.tencent.mm.plugin.webview.model.d.a() {
            public final void a(boolean z, int i, int i2, String str, String str2) {
                Bundle bundle;
                AppMethodBeat.i(7201);
                ab.i("MicroMsg.WebViewStubService", "onWebView cdn callback progress, upload : %b, mediaType : %d, percent : %d, localid : %s, mediaId : %s", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), str, str2);
                if (z) {
                    try {
                        bundle = new Bundle();
                        bundle.putString("webview_jssdk_file_item_local_id", str);
                        bundle.putInt("webview_jssdk_file_item_progreess", i2);
                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.cAV) {
                            webViewStubCallbackWrapper.uuT.c(2011, bundle);
                        }
                    } catch (Exception e) {
                        ab.e("MicroMsg.WebViewStubService", "notify upload image failed :%s", e.getMessage());
                    }
                }
                switch (i) {
                    case 1:
                        if (z) {
                            try {
                                bundle = new Bundle();
                                bundle.putString("webview_jssdk_file_item_local_id", str);
                                bundle.putInt("webview_jssdk_file_item_progreess", i2);
                                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : WebViewStubService.this.cAV) {
                                    webViewStubCallbackWrapper2.uuT.c(2003, bundle);
                                }
                                AppMethodBeat.o(7201);
                                return;
                            } catch (Exception e2) {
                                ab.e("MicroMsg.WebViewStubService", "notify upload image failed :%s", e2.getMessage());
                                AppMethodBeat.o(7201);
                                return;
                            }
                        }
                        try {
                            bundle = new Bundle();
                            bundle.putString("webview_jssdk_file_item_server_id", str2);
                            bundle.putInt("webview_jssdk_file_item_progreess", i2);
                            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper22 : WebViewStubService.this.cAV) {
                                webViewStubCallbackWrapper22.uuT.c(2004, bundle);
                            }
                            AppMethodBeat.o(7201);
                            return;
                        } catch (Exception e22) {
                            ab.e("MicroMsg.WebViewStubService", "notify download image failed :%s", e22.getMessage());
                            AppMethodBeat.o(7201);
                            return;
                        }
                    case 2:
                        if (z) {
                            try {
                                bundle = new Bundle();
                                bundle.putString("webview_jssdk_file_item_local_id", str);
                                bundle.putInt("webview_jssdk_file_item_progreess", i2);
                                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper222 : WebViewStubService.this.cAV) {
                                    webViewStubCallbackWrapper222.uuT.c(TXLiveConstants.PLAY_EVT_PLAY_PROGRESS, bundle);
                                }
                                AppMethodBeat.o(7201);
                                return;
                            } catch (Exception e222) {
                                ab.e("MicroMsg.WebViewStubService", "notify upload voice failed :%s", e222.getMessage());
                                AppMethodBeat.o(7201);
                                return;
                            }
                        }
                        try {
                            bundle = new Bundle();
                            bundle.putString("webview_jssdk_file_item_server_id", str2);
                            bundle.putInt("webview_jssdk_file_item_progreess", i2);
                            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2222 : WebViewStubService.this.cAV) {
                                webViewStubCallbackWrapper2222.uuT.c(TXLiveConstants.PLAY_EVT_PLAY_END, bundle);
                            }
                            AppMethodBeat.o(7201);
                            return;
                        } catch (Exception e2222) {
                            ab.e("MicroMsg.WebViewStubService", "notify download voice failed :%s", e2222.getMessage());
                            AppMethodBeat.o(7201);
                            return;
                        }
                    case 4:
                        if (z) {
                            try {
                                bundle = new Bundle();
                                bundle.putString("webview_jssdk_file_item_local_id", str);
                                bundle.putInt("webview_jssdk_file_item_progreess", i2);
                                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper22222 : WebViewStubService.this.cAV) {
                                    webViewStubCallbackWrapper22222.uuT.c(2010, bundle);
                                }
                                AppMethodBeat.o(7201);
                                return;
                            } catch (Exception e22222) {
                                ab.e("MicroMsg.WebViewStubService", "notify upload video failed :%s", e22222.getMessage());
                                AppMethodBeat.o(7201);
                                return;
                            }
                        }
                        break;
                    default:
                        ab.e("MicroMsg.WebViewStubService", "unsupport media type : %d", Integer.valueOf(i));
                        break;
                }
                AppMethodBeat.o(7201);
            }
        };
        this.mwl = new com.tencent.mm.network.n.a() {
            private final byte[] ecf = new byte[0];

            {
                AppMethodBeat.i(7202);
                AppMethodBeat.o(7202);
            }

            public final void gl(int i) {
                AppMethodBeat.i(7203);
                synchronized (this.ecf) {
                    try {
                        String cXS = com.tencent.mm.pluginsdk.ui.tools.u.cXS();
                        Bundle bundle = new Bundle();
                        bundle.putString("webview_network_type", cXS);
                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.cAV) {
                            webViewStubCallbackWrapper.uuT.c(90, bundle);
                        }
                    } catch (Exception e) {
                        ab.e("MicroMsg.WebViewStubService", "notify network change failed :%s", e.getMessage());
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(7203);
                        }
                    }
                }
                AppMethodBeat.o(7203);
            }
        };
        com.tencent.mm.kernel.g.RO().a(this.mwl);
        if (com.tencent.mm.kernel.g.RK()) {
            g.cYE().a(this.uqy);
        }
        AppMethodBeat.o(7208);
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(7209);
        ab.i("MicroMsg.WebViewStubService", "WebViewStubService onBind");
        com.tencent.mm.plugin.webview.stub.d.a aVar = this.uqv;
        AppMethodBeat.o(7209);
        return aVar;
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.i(7210);
        ab.i("MicroMsg.WebViewStubService", "WebViewStubService onUnbind");
        h.detach();
        ar.clear();
        com.tencent.mm.plugin.webview.modelcache.r.a.uor.release(false);
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.o(7210);
        return onUnbind;
    }

    public void onDestroy() {
        AppMethodBeat.i(7211);
        ab.i("MicroMsg.WebViewStubService", "WebViewStubService onDestroy");
        super.onDestroy();
        com.tencent.mm.plugin.downloader.model.d.bij();
        com.tencent.mm.plugin.downloader.model.b.b(this.uqx);
        if (com.tencent.mm.kernel.g.RK()) {
            g.cYE().b(this.uqy);
        }
        com.tencent.mm.kernel.g.RO().b(this.mwl);
        this.mwl = null;
        this.uqx = null;
        this.cAV.clear();
        AppMethodBeat.o(7211);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(7212);
        int type = mVar.getType();
        ab.i("MicroMsg.WebViewStubService", "onSceneEnd :[%d], errCode = %d, errType = %d, errMsg = %s", Integer.valueOf(type), Integer.valueOf(i2), Integer.valueOf(i), str);
        Bundle bundle;
        Bundle bundle2;
        String str2;
        int i3;
        String str3;
        b bVar;
        if (type == 106) {
            com.tencent.mm.kernel.g.Rg().b(106, (f) this);
            if (i == 0 && i2 == 0) {
                buv bOj = ((com.tencent.mm.plugin.messenger.a.f) mVar).bOj();
                String a = com.tencent.mm.platformtools.aa.a(bOj.wcB);
                com.tencent.mm.ah.o.acd().n(a, com.tencent.mm.platformtools.aa.a(bOj.vEF));
                Intent intent = new Intent();
                ((com.tencent.mm.api.j) com.tencent.mm.kernel.g.K(com.tencent.mm.api.j.class)).a(intent, bOj, 30);
                if (bo.nullAsNil(a).length() > 0) {
                    com.tencent.mm.storage.ad aoO = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(a);
                    if (!(aoO == null || com.tencent.mm.n.a.jh(aoO.field_type))) {
                        intent.putExtra("Contact_IsLBSFriend", true);
                    }
                    if ((bOj.wBT & 8) > 0) {
                        com.tencent.mm.plugin.report.service.h.pYm.X(10298, a + ",30");
                    }
                    intent.addFlags(268435456);
                    com.tencent.mm.plugin.webview.a.a.gkE.c(intent, this);
                    bundle = new Bundle();
                    bundle.putString("search_contact_result_user", a);
                    try {
                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.cAV) {
                            b bVar2 = new b();
                            bVar2.type = type;
                            bVar2.errType = i;
                            bVar2.errCode = i2;
                            bVar2.aIm = str;
                            bVar2.mqu = bundle;
                            bVar2.mqu.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper.id);
                            webViewStubCallbackWrapper.uuT.a(bVar2);
                        }
                        AppMethodBeat.o(7212);
                        return;
                    } catch (Exception e) {
                        ab.e("MicroMsg.WebViewStubService", "onSceneEnd searchcontact fail, ex = " + e.getMessage());
                    }
                }
                AppMethodBeat.o(7212);
                return;
            }
            ab.e("MicroMsg.WebViewStubService", "onSceneEnd, sendcard errType = " + i + ", errCode = " + i2);
            AppMethodBeat.o(7212);
        } else if (type == d.MIC_PTU_MEISHI && (mVar instanceof com.tencent.mm.modelsimple.h)) {
            com.tencent.mm.modelsimple.h hVar = (com.tencent.mm.modelsimple.h) mVar;
            bundle2 = new Bundle();
            byte[] aiW = hVar.aiW();
            if (aiW == null || aiW.length <= 0) {
                ab.e("MicroMsg.WebViewStubService", "getA8Key controlBytes is null");
            }
            str2 = "geta8key_result_jsapi_perm_control_bytes";
            if (aiW == null) {
                aiW = null;
            }
            bundle2.putByteArray(str2, aiW);
            adl adl = ((adp) hVar.ehh.fsH.fsP).wlB;
            bundle2.putInt("geta8key_result_general_ctrl_b1", adl == null ? 0 : adl.wli);
            bundle2.putInt("geta8key_result_reason", ((ado) hVar.ehh.fsG.fsP).vIw);
            bundle2.putString("geta8key_result_req_url", hVar.aiU());
            bundle2.putString("geta8key_result_full_url", hVar.aiT());
            bundle2.putString("geta8key_result_title", hVar.getTitle());
            bundle2.putInt("geta8key_result_action_code", hVar.aiV());
            bundle2.putString("geta8key_result_content", hVar.getContent());
            bundle2.putString("geta8key_result_head_img", ((adp) hVar.ehh.fsH.fsP).wlK);
            bundle2.putString("geta8key_result_wording", ((adp) hVar.ehh.fsH.fsP).nzz);
            bundle2.putLong("geta8key_result_deep_link_bit_set", hVar.aiZ());
            bundle2.putString("geta8key_data_username", ((adp) hVar.ehh.fsH.fsP).jBB);
            bundle2.putByteArray("geta8key_result_cookie", hVar.ajc());
            bundle2.putString("geta8key_result_menu_wording", ((adp) hVar.ehh.fsH.fsP).wlL);
            ab.d("MicroMsg.WebViewStubService", "getA8KeyCookie:%s", bo.cd(hVar.ajc()));
            List<atp> aja = hVar.aja();
            if (!bo.ek(aja)) {
                atp atp;
                Object obj;
                for (atp atp2 : aja) {
                    if (atp2 != null && !bo.isNullOrNil(atp2.vMU)) {
                        if (bo.isNullOrNil(atp2.pXM)) {
                            ab.e("MicroMsg.WebViewStubService", "http header has null value");
                            obj = 1;
                            break;
                        }
                    }
                    ab.e("MicroMsg.WebViewStubService", "http header has null value");
                    obj = 1;
                    break;
                }
                obj = null;
                if (obj == null) {
                    String[] strArr = new String[aja.size()];
                    String[] strArr2 = new String[aja.size()];
                    int i4 = 0;
                    while (true) {
                        i3 = i4;
                        if (i3 >= aja.size()) {
                            break;
                        }
                        atp2 = (atp) aja.get(i3);
                        ab.i("MicroMsg.WebViewStubService", "http header index = %d, key = %s, value = %s", Integer.valueOf(i3), atp2.vMU, atp2.pXM);
                        strArr[i3] = r9;
                        strArr2[i3] = str3;
                        i4 = i3 + 1;
                    }
                    bundle2.putStringArray("geta8key_result_http_header_key_list", strArr);
                    bundle2.putStringArray("geta8key_result_http_header_value_list", strArr2);
                }
            }
            bundle2.putSerializable("geta8key_result_scope_list", hVar.aiY());
            ab.i("MicroMsg.WebViewStubService", "geta8key onscened: share url:[%s], full url:[%s], req url:[%s], has scopeList:[%s]", hVar.aiX(), hVar.aiT(), hVar.aiU(), Boolean.TRUE);
            if (bo.isNullOrNil(hVar.aiX())) {
                ab.e("MicroMsg.WebViewStubService", "null shareUrl, full url:[%s], req url:[%s]", hVar.aiT(), hVar.aiU());
            } else {
                ar.hb(hVar.aiT(), hVar.aiX());
            }
            try {
                if (hVar.tag != null) {
                    i3 = ((Integer) hVar.tag).intValue();
                } else {
                    i3 = 0;
                }
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : this.cAV) {
                    if (i3 == 0 || i3 == webViewStubCallbackWrapper2.id) {
                        bVar = new b();
                        bVar.type = type;
                        bVar.errType = i;
                        bVar.errCode = i2;
                        bVar.aIm = str;
                        bVar.mqu = bundle2;
                        bVar.mqu.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper2.id);
                        webViewStubCallbackWrapper2.uuT.a(bVar);
                    } else {
                        ab.d("MicroMsg.WebViewStubService", "geta8key hashcode not equal, this one = %d, that = %d", Integer.valueOf(i3), Integer.valueOf(webViewStubCallbackWrapper2.id));
                    }
                }
                AppMethodBeat.o(7212);
            } catch (Exception e2) {
                ab.e("MicroMsg.WebViewStubService", "onSceneEnd geta8key fail, ex = " + Log.getStackTraceString(e2));
                AppMethodBeat.o(7212);
            }
        } else if (type == 673) {
            o oVar = (o) mVar;
            bundle2 = new Bundle();
            str2 = "reading_mode_result_url";
            if (oVar.ehh == null) {
                str3 = null;
            } else {
                str3 = ((anf) oVar.ehh.fsH.fsP).URL;
            }
            bundle2.putString(str2, str3);
            try {
                if (oVar.tag != null) {
                    i3 = ((Integer) oVar.tag).intValue();
                } else {
                    i3 = 0;
                }
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper22 : this.cAV) {
                    if (i3 == 0 || i3 == webViewStubCallbackWrapper22.id) {
                        bVar = new b();
                        bVar.type = type;
                        bVar.errType = i;
                        bVar.errCode = i2;
                        bVar.aIm = str;
                        bVar.mqu = bundle2;
                        bVar.mqu.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper22.id);
                        webViewStubCallbackWrapper22.uuT.a(bVar);
                    } else {
                        ab.d("MicroMsg.WebViewStubService", " get readingmodeinfo, hashcode not equal, this one = %d, that = %d", Integer.valueOf(i3), Integer.valueOf(webViewStubCallbackWrapper22.id));
                    }
                }
                AppMethodBeat.o(7212);
            } catch (Exception e22) {
                ab.e("MicroMsg.WebViewStubService", "onSceneEnd geta8key fail, ex = " + Log.getStackTraceString(e22));
                AppMethodBeat.o(7212);
            }
        } else if (type == 666) {
            com.tencent.mm.ao.c cVar = (com.tencent.mm.ao.c) mVar;
            bundle2 = new Bundle();
            bundle2.putString("emoji_stroe_product_id", cVar.agd().ProductID);
            if (i == 0 && i2 == 0) {
                str3 = bundle2.getString("emoji_stroe_product_id");
                ab.i("MicroMsg.WebViewStubService", "[cpan] onsceneend url:%s", str3);
                if (!bo.isNullOrNil(str3)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("extra_id", str3);
                    intent2.putExtra("preceding_scence", 12);
                    intent2.putExtra("download_entrance_scene", 12);
                    com.tencent.mm.bp.d.b((Context) this, "emoji", ".ui.EmojiStoreDetailUI", intent2);
                }
            }
            try {
                if (cVar.tag != null) {
                    i3 = ((Integer) cVar.tag).intValue();
                } else {
                    i3 = 0;
                }
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper222 : this.cAV) {
                    if (i3 == 0 || i3 == webViewStubCallbackWrapper222.id) {
                        bVar = new b();
                        bVar.type = type;
                        bVar.errType = i;
                        bVar.errCode = i2;
                        bVar.aIm = str;
                        bVar.mqu = bundle2;
                        bVar.mqu.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper222.id);
                        webViewStubCallbackWrapper222.uuT.a(bVar);
                    } else {
                        ab.d("MicroMsg.WebViewStubService", "jumpEmojiDetail, hashcode not equal, this one = %d, that = %d", Integer.valueOf(i3), Integer.valueOf(webViewStubCallbackWrapper222.id));
                    }
                }
                AppMethodBeat.o(7212);
            } catch (Exception e222) {
                ab.e("MicroMsg.WebViewStubService", "onSceneEnd MMFunc_JumpEmotionDetail fail, ex = " + e222.getMessage());
                AppMethodBeat.o(7212);
            }
        } else if (type == 1254) {
            try {
                int intValue;
                com.tencent.mm.plugin.webview.model.w wVar = (com.tencent.mm.plugin.webview.model.w) mVar;
                if (wVar.tag != null) {
                    intValue = ((Integer) wVar.tag).intValue();
                } else {
                    intValue = 0;
                }
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper3 : this.cAV) {
                    if (intValue == 0 || intValue == webViewStubCallbackWrapper3.id) {
                        Bundle bundle3;
                        b bVar3 = new b();
                        bVar3.type = type;
                        bVar3.errType = i;
                        bVar3.errCode = i2;
                        bVar3.aIm = str;
                        Bundle bundle4 = new Bundle();
                        if (i != 0 || i2 != 0) {
                            bundle3 = bundle4;
                        } else if (mVar instanceof com.tencent.mm.plugin.webview.model.w) {
                            bes bes = (bes) ((com.tencent.mm.plugin.webview.model.w) mVar).ehh.fsH.fsP;
                            bundle4.putString("oauth_url", ((com.tencent.mm.plugin.webview.model.w) mVar).umb);
                            bundle4.putSerializable("scope_list", af.aA(bes.wIK));
                            bundle4.putString("appname", bes.fhH);
                            bundle4.putString("appicon_url", bes.wIL);
                            bundle4.putString("redirect_url", bes.vGi);
                            bundle4.putBoolean("is_recent_has_auth", bes.wIM);
                            bundle4.putBoolean("is_silence_auth", bes.wIN);
                            bundle4.putBoolean("is_call_server_when_confirm", bes.wIO);
                            bundle3 = bundle4;
                        } else {
                            bundle3 = bundle4;
                        }
                        bVar3.mqu = bundle3;
                        bVar3.mqu.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper3.id);
                        webViewStubCallbackWrapper3.uuT.a(bVar3);
                    } else {
                        ab.d("MicroMsg.WebViewStubService", "authorize, hashcode not equal, this one = %d, that = %d", Integer.valueOf(intValue), Integer.valueOf(webViewStubCallbackWrapper3.id));
                    }
                }
                AppMethodBeat.o(7212);
            } catch (Exception e2222) {
                ab.e("MicroMsg.WebViewStubService", "onSceneEnd MMFunc_AuthorizeReq fail, ex = " + Log.getStackTraceString(e2222));
                AppMethodBeat.o(7212);
            }
        } else {
            if (type == 1373) {
                try {
                    int intValue2;
                    x xVar = (x) mVar;
                    if (xVar.tag != null) {
                        intValue2 = ((Integer) xVar.tag).intValue();
                    } else {
                        intValue2 = 0;
                    }
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2222 : this.cAV) {
                        if (intValue2 == 0 || intValue2 == webViewStubCallbackWrapper2222.id) {
                            b bVar4 = new b();
                            bVar4.type = type;
                            bVar4.errType = i;
                            bVar4.errCode = i2;
                            bVar4.aIm = str;
                            bundle2 = new Bundle();
                            if (i != 0 || i2 != 0) {
                                bundle = bundle2;
                            } else if (mVar instanceof x) {
                                bundle2.putString("redirect_url", ((beq) ((x) mVar).ehh.fsH.fsP).vGi);
                                bundle = bundle2;
                            } else {
                                bundle = bundle2;
                            }
                            bVar4.mqu = bundle;
                            bVar4.mqu.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper2222.id);
                            webViewStubCallbackWrapper2222.uuT.a(bVar4);
                        } else {
                            ab.d("MicroMsg.WebViewStubService", "authorizeconfirm, hashcode not equal, this one = %d, that = %d", Integer.valueOf(intValue2), Integer.valueOf(webViewStubCallbackWrapper2222.id));
                        }
                    }
                    AppMethodBeat.o(7212);
                    return;
                } catch (Exception e22222) {
                    ab.e("MicroMsg.WebViewStubService", "onSceneEnd MMFunc_AuthorizeConfirmReq fail, ex = " + Log.getStackTraceString(e22222));
                }
            }
            AppMethodBeat.o(7212);
        }
    }

    static /* synthetic */ void a(WebViewStubService webViewStubService, int i, Bundle bundle, int i2) {
        AppMethodBeat.i(7213);
        WebViewStubCallbackWrapper webViewStubCallbackWrapper = null;
        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : webViewStubService.cAV) {
            WebViewStubCallbackWrapper webViewStubCallbackWrapper22;
            if (webViewStubCallbackWrapper22 == null || webViewStubCallbackWrapper22.id != i2) {
                webViewStubCallbackWrapper22 = webViewStubCallbackWrapper;
            }
            webViewStubCallbackWrapper = webViewStubCallbackWrapper22;
        }
        if (webViewStubCallbackWrapper == null || webViewStubCallbackWrapper.uuT == null) {
            AppMethodBeat.o(7213);
            return;
        }
        final Intent intent = new Intent(webViewStubService, WebViewStubProxyUI.class);
        intent.putExtras(bundle);
        intent.putExtra("proxyui_action_code_key", i);
        intent.putExtra("webview_stub_callbacker_key", webViewStubCallbackWrapper);
        intent.putExtra("webview_binder_id", i2);
        intent.putExtra("screen_orientation", webViewStubService.uqA);
        intent.addFlags(268435456);
        com.tencent.mm.plugin.webview.ui.tools.g.a(intent.getExtras(), "webview", ".stub.WebViewStubProxyUI", webViewStubCallbackWrapper.uuT, new Runnable() {
            public final void run() {
                AppMethodBeat.i(7205);
                WebViewStubService.this.startActivity(intent);
                AppMethodBeat.o(7205);
            }
        });
        AppMethodBeat.o(7213);
    }

    static /* synthetic */ boolean Y(Bundle bundle) {
        AppMethodBeat.i(7214);
        m cVar = new com.tencent.mm.ao.c(bundle.getString("emoji_store_jump_url"));
        cVar.tag = Integer.valueOf(bundle.getInt("webview_binder_id"));
        boolean a = com.tencent.mm.kernel.g.Rg().a(cVar, 0);
        AppMethodBeat.o(7214);
        return a;
    }

    static /* synthetic */ boolean afe(String str) {
        AppMethodBeat.i(7216);
        if (str == null) {
            ab.e("MicroMsg.WebViewStubService", "doInActivity fail, function null");
        } else {
            com.tencent.mm.protocal.c.g akD = com.tencent.mm.protocal.c.akD(str);
            if (akD == null) {
                ab.e("MicroMsg.WebViewStubService", "doInActivity fail, func null, %s", str);
            } else if (akD.dmc()) {
                AppMethodBeat.o(7216);
                return true;
            }
        }
        AppMethodBeat.o(7216);
        return false;
    }

    static /* synthetic */ boolean a(WebViewStubService webViewStubService, String str, String str2, String str3, JsapiPermissionWrapper jsapiPermissionWrapper, Bundle bundle, int i) {
        AppMethodBeat.i(7217);
        WebViewStubCallbackWrapper webViewStubCallbackWrapper = null;
        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : webViewStubService.cAV) {
            WebViewStubCallbackWrapper webViewStubCallbackWrapper22;
            if (webViewStubCallbackWrapper22 == null || webViewStubCallbackWrapper22.id != i) {
                webViewStubCallbackWrapper22 = webViewStubCallbackWrapper;
            }
            webViewStubCallbackWrapper = webViewStubCallbackWrapper22;
        }
        if (webViewStubCallbackWrapper == null || webViewStubCallbackWrapper.uuT == null) {
            AppMethodBeat.o(7217);
            return false;
        }
        h.JR(i).dcu();
        final Intent intent = new Intent(webViewStubService, WebViewStubProxyUI.class);
        intent.putExtras(bundle);
        intent.putExtra("proxyui_action_code_key", 1);
        intent.putExtra("proxyui_type_key", str);
        intent.putExtra("proxyui_function_key", str2);
        intent.putExtra("proxyui_callback_key", str3);
        intent.putExtra("webview_stub_callbacker_key", webViewStubCallbackWrapper);
        intent.putExtra("proxyui_perm_key", jsapiPermissionWrapper);
        intent.putExtra("webview_binder_id", i);
        intent.putExtra("screen_orientation", webViewStubService.uqA);
        intent.addFlags(268435456);
        boolean a = com.tencent.mm.plugin.webview.ui.tools.g.a(intent.getExtras(), "webview", ".stub.WebViewStubProxyUI", webViewStubCallbackWrapper.uuT, new Runnable() {
            public final void run() {
                AppMethodBeat.i(7204);
                WebViewStubService.this.startActivity(intent);
                AppMethodBeat.o(7204);
            }
        });
        AppMethodBeat.o(7217);
        return a;
    }
}
