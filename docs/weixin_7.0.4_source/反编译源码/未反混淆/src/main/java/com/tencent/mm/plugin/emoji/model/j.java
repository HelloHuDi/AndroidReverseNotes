package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.at.a.a.b;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.emoji.e.h;
import com.tencent.mm.plugin.emoji.e.i;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager.ConnectivityReceiver;
import com.tencent.mm.plugin.emoji.sync.a;
import com.tencent.mm.plugin.emoji.sync.c;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleRecommendView;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.RecommendView;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.emotion.l;
import com.tencent.mm.storage.emotion.m;
import com.tencent.mm.storage.emotion.n;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.storage.emotion.u;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.ArrayList;
import java.util.HashMap;

public class j implements at {
    private static HashMap<Integer, d> eaA;
    private d kVL;
    private aq kVM;
    private h kVN;
    private k kVO;
    private g kVP;
    private e kVQ;
    private a<c> kVR;
    private volatile i kVS;
    private volatile com.tencent.mm.plugin.emoji.e.c kVT;
    private volatile k kVU;
    private com.tencent.mm.at.a.a kVV;
    private c kVW;

    private static j bkg() {
        AppMethodBeat.i(53063);
        j jVar = (j) q.Y(j.class);
        AppMethodBeat.o(53063);
        return jVar;
    }

    public static com.tencent.mm.at.a.a bjW() {
        AppMethodBeat.i(53064);
        g.RN().QU();
        if (bkg().kVV == null) {
            b.a aVar = new b.a(ah.getContext());
            aVar.fGV = new com.tencent.mm.plugin.emoji.d.a();
            aVar.fGT = new com.tencent.mm.view.d.a();
            b ahx = aVar.ahx();
            bkg().kVV = new com.tencent.mm.at.a.a(ahx);
        }
        com.tencent.mm.at.a.a aVar2 = bkg().kVV;
        AppMethodBeat.o(53064);
        return aVar2;
    }

    public static d bkh() {
        AppMethodBeat.i(53065);
        g.RN().QU();
        if (bkg().kVL == null) {
            bkg().kVL = new d();
        }
        d dVar = bkg().kVL;
        AppMethodBeat.o(53065);
        return dVar;
    }

    public static aq getEmojiDescMgr() {
        AppMethodBeat.i(53066);
        g.RN().QU();
        if (bkg().kVM == null) {
            bkg().kVM = new aq();
        }
        aq aqVar = bkg().kVM;
        AppMethodBeat.o(53066);
        return aqVar;
    }

    public static h bki() {
        AppMethodBeat.i(53067);
        g.RN().QU();
        if (bkg().kVN == null) {
            bkg().kVN = new h();
        }
        h hVar = bkg().kVN;
        AppMethodBeat.o(53067);
        return hVar;
    }

    public static a<c> bkj() {
        AppMethodBeat.i(53068);
        g.RN().QU();
        if (bkg().kVR == null) {
            bkg().kVR = new a();
        }
        a aVar = bkg().kVR;
        AppMethodBeat.o(53068);
        return aVar;
    }

    private static synchronized i bkk() {
        i iVar;
        synchronized (j.class) {
            AppMethodBeat.i(53069);
            g.RN().QU();
            if (bkg().kVS == null) {
                bkg().kVS = new i();
            }
            iVar = bkg().kVS;
            AppMethodBeat.o(53069);
        }
        return iVar;
    }

    private static com.tencent.mm.plugin.emoji.e.c bkl() {
        AppMethodBeat.i(53070);
        g.RN().QU();
        if (bkg().kVT == null) {
            bkg().kVT = new com.tencent.mm.plugin.emoji.e.c();
        }
        com.tencent.mm.plugin.emoji.e.c cVar = bkg().kVT;
        AppMethodBeat.o(53070);
        return cVar;
    }

    public static com.tencent.mm.storage.at getEmojiStorageMgr() {
        AppMethodBeat.i(53071);
        com.tencent.mm.storage.at dsZ = com.tencent.mm.storage.at.dsZ();
        AppMethodBeat.o(53071);
        return dsZ;
    }

    public static k bkm() {
        AppMethodBeat.i(53072);
        g.RN().QU();
        if (bkg().kVU == null) {
            bkg().kVU = new k();
        }
        k kVar = bkg().kVU;
        AppMethodBeat.o(53072);
        return kVar;
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(53073);
        ab.i("MicroMsg.emoji.SubCoreEmoji", "onAccountRelease: ");
        i bkk = bkk();
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("emotionstore", bkk.kTV, true);
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("NewRecommendEmotion", bkk.kTW, true);
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("EmojiBackup", bkk.kTX, true);
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("EmotionBackup", bkk.kTX, true);
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("SelfieEmojiBackup", bkk.kTX, true);
        com.tencent.mm.plugin.emoji.e.c bkl = bkl();
        com.tencent.mm.sdk.b.a.xxA.d(bkl.kTp);
        com.tencent.mm.sdk.b.a.xxA.d(bkl.kTt);
        com.tencent.mm.sdk.b.a.xxA.d(bkl.kTu);
        com.tencent.mm.sdk.b.a.xxA.d(bkl.kTv);
        com.tencent.mm.sdk.b.a.xxA.d(bkl.kTw);
        com.tencent.mm.sdk.b.a.xxA.d(bkl.kTx);
        com.tencent.mm.sdk.b.a.xxA.d(bkl.kTy);
        com.tencent.mm.sdk.b.a.xxA.d(bkl.kTz);
        com.tencent.mm.sdk.b.a.xxA.d(bkl.kTA);
        com.tencent.mm.sdk.b.a.xxA.d(bkl.kTq);
        com.tencent.mm.sdk.b.a.xxA.d(bkl.kTr);
        com.tencent.mm.sdk.b.a.xxA.d(bkl.kTB);
        com.tencent.mm.sdk.b.a.xxA.d(bkl.kTC);
        com.tencent.mm.sdk.b.a.xxA.d(bkl.kTs);
        com.tencent.mm.storage.at dsZ = com.tencent.mm.storage.at.dsZ();
        dsZ.xYn.d(dsZ.xYF);
        dsZ.xYo.d(dsZ.xYD);
        dsZ.xYp.d(dsZ.xYE);
        com.tencent.mm.sdk.b.a.xxA.d(dsZ.xYG);
        com.tencent.mm.emoji.a.a aVar = dsZ.xYz;
        if (aVar.eyA != null) {
            aVar.eyA.clear();
        }
        if (aVar.eyB != null) {
            aVar.eyB.clear();
        }
        getEmojiDescMgr().clear();
        ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).removeEmojiMgr();
        f bkh = bkh();
        g.RO().eJo.b((int) ErrorCode.NEEDDOWNLOAD_FALSE_5, bkh);
        bkh.kVh.clear();
        bkh.kVf.clear();
        bkh.kVk.clear();
        k bkm = bkm();
        bkm.kUF = null;
        if (bkm.kUG != null) {
            bkm.kUG.clear();
        }
        BKGLoaderManager bKGLoaderManager = bkj().kXj;
        ab.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg detach");
        bKGLoaderManager.bkF();
        com.tencent.mm.sdk.b.a.xxA.d(bKGLoaderManager.kXG);
        com.tencent.mm.sdk.b.a.xxA.d(bKGLoaderManager.kXH);
        if (bKGLoaderManager.kXC != null) {
            ah.getContext().unregisterReceiver(bKGLoaderManager.kXC);
            bKGLoaderManager.kXC = null;
        }
        com.tencent.mm.plugin.emoji.e.f.bjK().isRunning = false;
        if (this.kVO != null) {
            k kVar = this.kVO;
            com.tencent.mm.sdk.b.a.xxA.d(kVar.kWb);
            com.tencent.mm.sdk.b.a.xxA.d(kVar.kWc);
        }
        if (this.kVP != null) {
            g gVar = this.kVP;
            gVar.kVv.clear();
            bkh().kVj = null;
            gVar.kVw.dead();
        }
        if (this.kVV != null) {
            this.kVV.detach();
        }
        g.RO().eJo.b(697, bko());
        com.tencent.mm.ao.b.afY().fAP.dead();
        EmojiSyncManager.a aVar2 = EmojiSyncManager.ezA;
        EmojiSyncManager.a.Pg().destroy();
        aVar2 = EmojiSyncManager.ezA;
        EmojiSyncManager.a.Ph().destroy();
        AppMethodBeat.o(53073);
    }

    static {
        AppMethodBeat.i(53077);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("EMOJIINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.storage.emotion.d.fnj;
            }
        });
        eaA.put(Integer.valueOf("EMOJIGROUPINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.storage.emotion.a.fnj;
            }
        });
        eaA.put(Integer.valueOf("EMOJIINFODESC_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.storage.emotion.c.fnj;
            }
        });
        eaA.put(Integer.valueOf("EMOTIONDETAIL_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.storage.emotion.j.fnj;
            }
        });
        eaA.put(Integer.valueOf("GETEMOTIONLISTCACHE_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.storage.emotion.p.fnj;
            }
        });
        eaA.put(Integer.valueOf("EmotionRewardINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return l.fnj;
            }
        });
        eaA.put(Integer.valueOf("EmotionDesignerInfoStorage_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.storage.emotion.h.fnj;
            }
        });
        eaA.put(Integer.valueOf("EmotionRewardTipStorage_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return n.fnj;
            }
        });
        eaA.put(Integer.valueOf("SmileyInfoStorage_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.storage.emotion.q.fnj;
            }
        });
        eaA.put(Integer.valueOf("SmileyPanelConfigInfoStorage_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return s.fnj;
            }
        });
        eaA.put(Integer.valueOf("EmojiDescMapStorage".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.storage.emotion.f.fnj;
            }
        });
        eaA.put(Integer.valueOf("DELETE".hashCode()), new d() {
            public final String[] Af() {
                return new String[]{"DROP TABLE IF EXISTS EmotionDetail ", "DROP TABLE IF EXISTS EmojiSummaryInfo", "DROP TABLE IF EXISTS RewardMagicInfo"};
            }
        });
        AppMethodBeat.o(53077);
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        long currentTimeMillis;
        boolean z2;
        AppMethodBeat.i(53074);
        ab.i("MicroMsg.emoji.SubCoreEmoji", "[onAccountPostReset]");
        e.vom = new e.b() {
            public final ChatFooterPanel dF(Context context) {
                AppMethodBeat.i(53060);
                com.tencent.mm.view.c cVar = new com.tencent.mm.view.c(context, false);
                AppMethodBeat.o(53060);
                return cVar;
            }
        };
        e.von = new e.a() {
            public final /* synthetic */ RecommendView t(Context context, boolean z) {
                AppMethodBeat.i(53061);
                EmojiStoreV2SingleRecommendView emojiStoreV2SingleRecommendView = new EmojiStoreV2SingleRecommendView(context, z);
                AppMethodBeat.o(53061);
                return emojiStoreV2SingleRecommendView;
            }
        };
        com.tencent.mm.storage.at dsZ = com.tencent.mm.storage.at.dsZ();
        if (g.RP().eJN == null || !g.RP().eJN.isOpen()) {
            ab.w("MicroMsg.emoji.EmojiStorageMgr", "initStorage: db close %s", g.RP().eJN);
        }
        dsZ.xYn = new com.tencent.mm.storage.emotion.d(g.RP().eJN);
        dsZ.xYo = new com.tencent.mm.storage.emotion.a(g.RP().eJN);
        dsZ.xYp = new com.tencent.mm.storage.emotion.c(g.RP().eJN);
        dsZ.xYr = new com.tencent.mm.storage.emotion.j(g.RP().eJN);
        dsZ.xYs = new l(g.RP().eJN);
        dsZ.xYt = new com.tencent.mm.storage.emotion.h(g.RP().eJN);
        dsZ.xYq = new com.tencent.mm.storage.emotion.p(g.RP().eJN);
        dsZ.xYu = new n(g.RP().eJN);
        dsZ.xYv = new com.tencent.mm.storage.emotion.q(g.RP().eJN);
        dsZ.xYw = new s(g.RP().eJN);
        dsZ.xYx = new com.tencent.mm.storage.emotion.f(g.RP().eJN);
        dsZ.xYy = new u();
        dsZ.xYz = com.tencent.mm.emoji.a.a.OB();
        ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).setEmojiMgr();
        i bkk = bkk();
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("emotionstore", bkk.kTV, true);
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("NewRecommendEmotion", bkk.kTW, true);
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("EmojiBackup", bkk.kTX, true);
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("EmotionBackup", bkk.kTX, true);
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("SelfieEmojiBackup", bkk.kTX, true);
        com.tencent.mm.plugin.emoji.e.c bkl = bkl();
        com.tencent.mm.sdk.b.a.xxA.c(bkl.kTp);
        com.tencent.mm.sdk.b.a.xxA.c(bkl.kTt);
        com.tencent.mm.sdk.b.a.xxA.c(bkl.kTu);
        com.tencent.mm.sdk.b.a.xxA.c(bkl.kTv);
        com.tencent.mm.sdk.b.a.xxA.c(bkl.kTw);
        com.tencent.mm.sdk.b.a.xxA.c(bkl.kTx);
        com.tencent.mm.sdk.b.a.xxA.c(bkl.kTy);
        com.tencent.mm.sdk.b.a.xxA.c(bkl.kTz);
        com.tencent.mm.sdk.b.a.xxA.c(bkl.kTA);
        com.tencent.mm.sdk.b.a.xxA.c(bkl.kTq);
        com.tencent.mm.sdk.b.a.xxA.c(bkl.kTr);
        com.tencent.mm.sdk.b.a.xxA.c(bkl.kTB);
        com.tencent.mm.sdk.b.a.xxA.c(bkl.kTC);
        com.tencent.mm.sdk.b.a.xxA.c(bkl.kTs);
        dsZ = com.tencent.mm.storage.at.dsZ();
        dsZ.xYn.c(dsZ.xYF);
        dsZ.xYo.c(dsZ.xYD);
        dsZ.xYp.c(dsZ.xYE);
        com.tencent.mm.sdk.b.a.xxA.c(dsZ.xYG);
        getEmojiDescMgr();
        k bkm = bkm();
        String value = com.tencent.mm.m.g.Nu().getValue("EmotionRewardTipsLimit");
        if (!bo.isNullOrNil(value)) {
            ab.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateConfig dynamic config %s", value);
            String[] split = value.split(",");
            if (split != null && split.length == 3) {
                long j;
                if (bo.getInt(split[0], 0) == 0) {
                    j = 863913600000L;
                } else {
                    j = ((long) bo.getInt(split[0], 0)) * 86400000;
                }
                bkm.kUD = j;
                bkm.kUE = bo.getInt(split[1], 20) - 1;
                bkm.emW = bo.getInt(split[2], 80) - 1;
            }
        }
        boolean z3 = com.tencent.mm.emoji.a.e.OK() && ((Boolean) g.RP().Ry().get(ac.a.USERINFO_EMOJI_REWARD_TIP_ENABLE_BOOLEAN, Boolean.TRUE)).booleanValue();
        bkm.kUC = z3;
        ab.i("MicroMsg.emoji.EmojiRewardTipMgr", "init RewardTipMgr RewardTipEnable:%b isEnableRewardTip:%b isTipsEnable:%b", Boolean.valueOf(bkm.kUC), Boolean.valueOf(r1), Boolean.valueOf(r3));
        g.RS().aa(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:14:0x004e  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                AppMethodBeat.i(52976);
                if (k.this.kUC) {
                    k kVar = k.this;
                    if (j.getEmojiStorageMgr().xYu != null) {
                        kVar.kUF = j.getEmojiStorageMgr().xYu.dvk();
                    }
                    kVar = k.this;
                    Cursor cursor = null;
                    try {
                        cursor = j.getEmojiStorageMgr().xYu.baR();
                        if (cursor != null && cursor.moveToFirst()) {
                            do {
                                m mVar = new m();
                                mVar.d(cursor);
                                kVar.kUG.put(mVar.field_prodcutID, mVar);
                            } while (cursor.moveToNext());
                            if (cursor != null) {
                            }
                        } else if (cursor != null) {
                            cursor.close();
                            AppMethodBeat.o(52976);
                            return;
                        }
                    } catch (Exception e) {
                        ab.w("MicroMsg.emoji.EmojiRewardTipMgr", bo.l(e));
                        if (cursor != null) {
                            cursor.close();
                            AppMethodBeat.o(52976);
                            return;
                        }
                    } catch (Throwable th) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        AppMethodBeat.o(52976);
                    }
                }
                AppMethodBeat.o(52976);
            }
        });
        BKGLoaderManager bKGLoaderManager = bkj().kXj;
        ab.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg attach");
        com.tencent.mm.sdk.b.a.xxA.c(bKGLoaderManager.kXG);
        com.tencent.mm.sdk.b.a.xxA.c(bKGLoaderManager.kXH);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        bKGLoaderManager.kXC = new ConnectivityReceiver();
        ah.getContext().registerReceiver(bKGLoaderManager.kXC, intentFilter);
        ab.i("MicroMsg.emoji.SubCoreEmoji", "[oneliang]initCore");
        com.tencent.mm.storage.at dsZ2 = com.tencent.mm.storage.at.dsZ();
        Context context = ah.getContext();
        if (context != null) {
            ab.i("MicroMsg.emoji.EmojiStorageMgr", "[oneliang]initCore,need init emoji:%s", String.valueOf(((Boolean) g.RP().Ry().get(274480, Boolean.TRUE)).booleanValue()));
            if (((Boolean) g.RP().Ry().get(274480, Boolean.TRUE)).booleanValue()) {
                dsZ2.xYn.hi(context);
                dsZ2.xYo.hi(context);
            }
            g.RP().Ry().set(274480, Boolean.FALSE);
        }
        if (((Integer) g.RP().Ry().get(ac.a.USERINFO_EMOJI_CUREENT_VERSION_INT, Integer.valueOf(0))).intValue() != com.tencent.mm.protocal.d.vxo) {
            currentTimeMillis = System.currentTimeMillis();
            dsZ2.xYo.duN();
            g.RP().Ry().set(ac.a.USERINFO_EMOJI_CUREENT_VERSION_INT, Integer.valueOf(com.tencent.mm.protocal.d.vxo));
            ab.i("MicroMsg.emoji.EmojiStorageMgr", "recoverCustomEmojiGroup use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        if (((Boolean) g.RP().Ry().get(ac.a.USERINFO_EMOJI_UPDATE_EMOJI_GROUP_COUNT_BOOLEAN, Boolean.TRUE)).booleanValue()) {
            currentTimeMillis = System.currentTimeMillis();
            g.RP().Ry().set(ac.a.USERINFO_EMOJI_UPDATE_EMOJI_GROUP_COUNT_BOOLEAN, Boolean.valueOf(!dsZ2.xYo.duO()));
            ab.i("MicroMsg.emoji.EmojiStorageMgr", "updateEmojiGroupCount use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        this.kVO = new k();
        this.kVP = new g();
        com.tencent.mm.ao.a.cM(z);
        g.RO().eJo.a(697, bko());
        boolean dqN = com.tencent.mm.cb.f.dqL().dqN();
        com.tencent.mm.cb.e dqK = com.tencent.mm.cb.e.dqK();
        ab.i("MicroMsg.MergerSmileyManager", "checkNewSmiley ");
        ArrayList bjP = ((PluginEmoji) g.M(PluginEmoji.class)).getEmojiMgr().bjP();
        if (bjP == null || bjP.isEmpty()) {
            dqK.aRs();
            z2 = true;
        } else {
            dqK.aRs();
            z2 = false;
        }
        if (dqN && ((Integer) g.RP().Ry().get(ac.a.USERINFO_EMOJI_NEW_EMOJI_INT, Integer.valueOf(0))).intValue() > 0) {
            com.tencent.mm.pluginsdk.g.a.a.b.c.veg.f(37, 1, -1, false);
            g.RP().Ry().set(ac.a.USERINFO_EMOJI_NEW_EMOJI_INT, Integer.valueOf(0));
            g.RO().eJo.a(new com.tencent.mm.pluginsdk.g.a.a.m(37), 0);
            com.tencent.mm.plugin.report.service.h.pYm.a(165, 10, 1, false);
        }
        if (z2 && ((Integer) g.RP().Ry().get(ac.a.USERINFO_EMOJI_NEW_PANEL_INT, Integer.valueOf(0))).intValue() > 0) {
            com.tencent.mm.pluginsdk.g.a.a.b.c.veg.f(37, 2, -1, false);
            g.RP().Ry().set(ac.a.USERINFO_EMOJI_NEW_PANEL_INT, Integer.valueOf(0));
            g.RO().eJo.a(new com.tencent.mm.pluginsdk.g.a.a.m(37), 0);
            com.tencent.mm.plugin.report.service.h.pYm.a(165, 11, 1, false);
        }
        com.tencent.mm.ao.b afY = com.tencent.mm.ao.b.afY();
        ab.i("MicroMsg.FontResLogic", "init");
        afY.fAP.dnU();
        if (afY.agb()) {
            com.tencent.mm.plugin.report.service.h.pYm.k(933, 4, 1);
        } else {
            com.tencent.mm.plugin.report.service.h.pYm.k(933, 5, 1);
            com.tencent.mm.pluginsdk.g.a.a.b.c.veg;
            String gM = com.tencent.mm.pluginsdk.g.a.a.b.gM(57, 1);
            if (com.tencent.mm.vfs.e.ct(gM)) {
                com.tencent.mm.plugin.report.service.h.pYm.k(933, 6, 1);
                ab.i("MicroMsg.FontResLogic", "cache file exist %s", gM);
                afY.e(gM, 57, 1, 1);
            }
        }
        EmojiSyncManager.a aVar = EmojiSyncManager.ezA;
        EmojiSyncManager.a.Pg().init();
        aVar = EmojiSyncManager.ezA;
        EmojiSyncManager.a.Ph().init();
        com.tencent.mm.emoji.a.b bVar = com.tencent.mm.emoji.a.b.eyD;
        com.tencent.mm.emoji.a.b.OG();
        com.tencent.mm.sdk.g.d.xDG.execute(new Runnable() {
            public final void run() {
                AppMethodBeat.i(53062);
                ((com.tencent.mm.plugin.emojicapture.api.b) g.M(com.tencent.mm.plugin.emojicapture.api.b.class)).getRes();
                AppMethodBeat.o(53062);
            }
        });
        AppMethodBeat.o(53074);
    }

    public final void bA(boolean z) {
    }

    public static e bkn() {
        AppMethodBeat.i(53075);
        g.RN().QU();
        if (bkg().kVQ == null) {
            bkg().kVQ = new e();
        }
        e eVar = bkg().kVQ;
        AppMethodBeat.o(53075);
        return eVar;
    }

    public static c bko() {
        AppMethodBeat.i(53076);
        g.RN().QU();
        if (bkg().kVW == null) {
            bkg().kVW = new c();
        }
        c cVar = bkg().kVW;
        AppMethodBeat.o(53076);
        return cVar;
    }
}
