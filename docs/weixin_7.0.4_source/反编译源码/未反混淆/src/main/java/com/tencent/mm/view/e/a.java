package com.tencent.mm.view.e;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Message;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.MMRadioGroupView.d;
import com.tencent.mm.view.ScrollRectRecyclerView;
import com.tencent.mm.view.SmileyPanelScrollView;
import com.tencent.mm.view.SmileyPanelScrollView.b;
import com.tencent.mm.view.SmileyPanelViewPager;
import com.tencent.mm.view.a.f;
import com.tencent.mm.view.a.i;
import com.tencent.mm.view.a.j;
import java.util.ArrayList;
import java.util.Iterator;

public final class a implements OnPageChangeListener, OnClickListener, d, b, com.tencent.mm.view.SmileyPanelViewPager.a {
    private static boolean AdL = true;
    public com.tencent.mm.view.f.a Aaj;
    public ImageView AdA;
    public ImageButton AdB;
    public TextView AdC;
    public ImageView AdD;
    private a AdE;
    private int AdF = -1;
    private boolean AdG = false;
    public boolean AdH = true;
    public String AdI;
    private boolean AdJ = false;
    private boolean AdK = false;
    public final com.tencent.mm.sdk.e.k.a AdM = new com.tencent.mm.sdk.e.k.a() {
        public final void a(String str, m mVar) {
            AppMethodBeat.i(63028);
            if (!TextUtils.isEmpty(str) && (str.equals("event_update_group") || str.equalsIgnoreCase("productID"))) {
                ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "modify emoji group .");
                a.this.dNg();
            }
            AppMethodBeat.o(63028);
        }
    };
    public final c<cz> AdN = new c<cz>() {
        {
            AppMethodBeat.i(63032);
            this.xxI = cz.class.getName().hashCode();
            AppMethodBeat.o(63032);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(63033);
            cz czVar = (cz) bVar;
            com.tencent.mm.view.f.a d;
            if (czVar.cwc.type == 1) {
                if (a.this.Aaj != null) {
                    a.this.Aaj.Aer = 0;
                    d = a.this.Aaj;
                    a.this.Aaj;
                    d.eI(String.valueOf(EmojiGroupInfo.yas), 0);
                    d = a.this.Aaj;
                    a.this.Aaj;
                    d.setShowProductId(String.valueOf(EmojiGroupInfo.yas));
                    a.this.Aaj.dNl();
                    a.this.Aaj.dNw();
                    czVar.cwd.cwe = true;
                    ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "update custom panel.");
                }
            } else if (czVar.cwc.type == 2 && a.this.Aaj != null) {
                a.this.Aaj.Aer = 0;
                d = a.this.Aaj;
                a.this.Aaj;
                d.eI("capture", 0);
                d = a.this.Aaj;
                a.this.Aaj;
                d.setShowProductId("capture");
                a.this.Aaj.dNl();
                a.this.Aaj.dNw();
                czVar.cwd.cwe = true;
                ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "update capture panel.");
            }
            AppMethodBeat.o(63033);
            return false;
        }
    };
    public final com.tencent.mm.sdk.e.k.a AdO = new com.tencent.mm.sdk.e.k.a() {
        public final void a(String str, m mVar) {
            AppMethodBeat.i(63034);
            Object obj = mVar.obj;
            int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
            if (a.this.Aaj.dNx() || intValue < 3) {
                if (!(a.this.Adu == null || a.this.Adt == null)) {
                    a.this.Adu.aJ(a.this.Adt.getCurrentItem(), false);
                }
                AppMethodBeat.o(63034);
                return;
            }
            a.this.Aaj.dNy();
            a.this.AdJ = true;
            a.this.dNg();
            AppMethodBeat.o(63034);
        }
    };
    public com.tencent.mm.view.a.j.a AdP = new com.tencent.mm.view.a.j.a() {
        public final void f(int i, View view) {
            boolean z = false;
            AppMethodBeat.i(63024);
            EmojiGroupInfo QE = a.this.Adx.QE(i);
            if (QE == null) {
                ab.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "info is null. ignore click action.");
                AppMethodBeat.o(63024);
                return;
            }
            String str = QE.field_productID;
            a.this.Aaj;
            if (str.equalsIgnoreCase("TAG_STORE_MANEGER_TAB")) {
                a.k(a.this);
                AppMethodBeat.o(63024);
                return;
            }
            int dMX;
            a.b(a.this, i);
            com.tencent.mm.view.c.a atl = a.this.Aaj.atl(QE.field_productID);
            a.this.AdF = atl.jis;
            if (atl.Adn > atl.dMX() - 1) {
                dMX = atl.dMX() - 1;
            } else {
                dMX = atl.Adn;
            }
            if (a.this.Adt != null) {
                a.this.Adt.setCurrentItem(a.this.AdF + dMX, false);
            }
            if (a.this.Aaj.dNx()) {
                String str2 = atl.kWz;
                a.this.Aaj;
                if (str2.equals("TAG_DEFAULT_TAB")) {
                    z = true;
                }
            }
            a.a(a.this, atl.dMX(), dMX, z);
            a.this.Aaj.Aer = dMX;
            a.this.Aaj.setShowProductId(QE.field_productID);
            str = QE.field_productID;
            a.this.Aaj;
            if (str.equals("capture") && com.tencent.mm.view.f.a.QL(a.this.Aaj.gOW)) {
                a.dNh();
                View findViewById = view.findViewById(R.id.eeb);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
            }
            AppMethodBeat.o(63024);
        }
    };
    private final int Adp = 100;
    private final int Adq = 1102;
    private final int Adr = 1103;
    private final int Ads = 100;
    public SmileyPanelViewPager Adt;
    public i Adu;
    public SmileyPanelScrollView Adv;
    public ScrollRectRecyclerView Adw;
    public j Adx;
    public View Ady;
    public ImageView Adz;
    private Context Gn = ah.getContext();
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelManager";
    public Context jiq;
    private ak mHandler = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(63023);
            switch (message.what) {
                case 1102:
                    a.this.dMY();
                    a.this.AdH = true;
                    if (!(a.this.AdI == null || a.this.Adt == null)) {
                        int i = a.this.Aaj.Aer;
                        if (i < 0 || i > a.this.Aaj.atl(a.this.AdI).dMX()) {
                            i = a.this.Aaj.atl(a.this.AdI).dMX() - 1;
                        }
                        a.this.AdF = i + a.this.Aaj.atl(a.this.AdI).jis;
                        a.this.Adt.setCurrentItem(a.this.AdF);
                        a.this.AdI = null;
                        AppMethodBeat.o(63023);
                        return;
                    }
                case 1103:
                    ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "update selection");
                    a.b(a.this, message.arg1);
                    break;
            }
            AppMethodBeat.o(63023);
        }
    };
    public View mView;
    public final com.tencent.mm.sdk.e.k.a xYF = new com.tencent.mm.sdk.e.k.a() {
        public final void a(String str, m mVar) {
            AppMethodBeat.i(63029);
            ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "emoji storage notify %s", str);
            if (str == null) {
                AppMethodBeat.o(63029);
            } else if (str.equalsIgnoreCase("delete_emoji_info_notify")) {
                a.this.dNg();
                AppMethodBeat.o(63029);
            } else if (g.RN().QY()) {
                if (((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jd(str) != null) {
                    ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "update emoji %s, group %x.", str, Integer.valueOf(((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jd(str).field_catalog));
                    a.this.dNg();
                }
                AppMethodBeat.o(63029);
            } else {
                AppMethodBeat.o(63029);
            }
        }
    };
    public final c xYG = new c<ny>() {
        {
            AppMethodBeat.i(63030);
            this.xxI = ny.class.getName().hashCode();
            AppMethodBeat.o(63030);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(63031);
            ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "REFRESH_PANEL_EVENT");
            a.this.dNg();
            AppMethodBeat.o(63031);
            return false;
        }
    };

    /* renamed from: com.tencent.mm.view.e.a$5 */
    public class AnonymousClass5 implements Runnable {
        final /* synthetic */ String kUJ;

        public AnonymousClass5(String str) {
            this.kUJ = str;
        }

        public final void run() {
            AppMethodBeat.i(63027);
            if (a.this.Adt == null || a.this.Aaj == null || a.this.Aaj.atl(this.kUJ) == null) {
                AppMethodBeat.o(63027);
                return;
            }
            a.this.AdF = a.this.Aaj.atl(this.kUJ).jis;
            a.this.Adt.setCurrentItem(a.this.AdF);
            a.this.Aaj.Aer = 0;
            AppMethodBeat.o(63027);
        }
    }

    public interface a {
        com.tencent.mm.pluginsdk.ui.chat.j getSmileyPanelCallback();

        com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a getTextOpListener();
    }

    static /* synthetic */ void a(a aVar, int i, int i2, boolean z) {
        AppMethodBeat.i(63061);
        aVar.g(i, i2, true, z);
        AppMethodBeat.o(63061);
    }

    static /* synthetic */ void b(a aVar, int i) {
        AppMethodBeat.i(63059);
        aVar.setTabSelected(i);
        AppMethodBeat.o(63059);
    }

    static /* synthetic */ void k(a aVar) {
        AppMethodBeat.i(63060);
        aVar.dNc();
        AppMethodBeat.o(63060);
    }

    public a(Context context, com.tencent.mm.view.f.a aVar, a aVar2) {
        AppMethodBeat.i(63035);
        this.jiq = context;
        this.Aaj = aVar;
        this.AdE = aVar2;
        ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager add listener.");
        ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().j(this.AdM);
        ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().h(this.xYF);
        ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().l(this.AdO);
        com.tencent.mm.sdk.b.a.xxA.c(this.xYG);
        com.tencent.mm.sdk.b.a.xxA.c(this.AdN);
        if (AdL) {
            AdL = false;
            for (EmojiInfo emojiInfo : com.tencent.mm.emoji.a.a.OB().bZ(true)) {
                if (com.tencent.mm.storage.emotion.EmojiInfo.a.STATUS_MIXING == emojiInfo.duZ()) {
                    emojiInfo.a(com.tencent.mm.storage.emotion.EmojiInfo.a.STATUS_MIX_FAIL);
                    emojiInfo.a(EmojiInfo.b.ERR_MIX_PROCESS_KILL);
                    ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(emojiInfo);
                    EmojiCaptureReporter.h(emojiInfo.field_captureEnterTime, 5, emojiInfo.field_captureScene);
                } else if (emojiInfo.duZ() == com.tencent.mm.storage.emotion.EmojiInfo.a.STATUS_UPLOADING) {
                    emojiInfo.a(com.tencent.mm.storage.emotion.EmojiInfo.a.STATUS_UPLOAD_FAIL);
                    ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(emojiInfo);
                    EmojiCaptureReporter.g(emojiInfo.field_captureEnterTime, 3, emojiInfo.field_captureScene);
                }
            }
        }
        AppMethodBeat.o(63035);
    }

    public final synchronized void dMY() {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.i(63036);
            if (this.mView == null || !this.Aaj.AeI) {
                ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "not view can't deal");
                AppMethodBeat.o(63036);
            } else {
                int i2;
                long currentTimeMillis = System.currentTimeMillis();
                this.Aaj.Aex = false;
                ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initSmileyData");
                long currentTimeMillis2 = System.currentTimeMillis();
                com.tencent.mm.view.f.a aVar = this.Aaj;
                if (aVar.AeE != null) {
                    Iterator it = aVar.AeE.iterator();
                    while (it.hasNext()) {
                        if (((com.tencent.mm.view.c.a) it.next()) != null) {
                            ab.v("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "removeAllGridViewListener listener: %s", ((com.tencent.mm.view.c.a) it.next()).kWz);
                        } else {
                            ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "removeAllGridViewListener already release: ..");
                        }
                    }
                }
                if (aVar.AeE != null) {
                    aVar.AeE.clear();
                }
                ArrayList OD = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().OD();
                com.tencent.mm.by.a.dmE();
                com.tencent.mm.by.a.c cVar = com.tencent.mm.by.a.xun;
                if (((h) g.RM().Rn()).SG()) {
                    i2 = com.tencent.mm.m.g.Nu().getInt("EmotionRecommandCount", 3);
                } else {
                    i2 = cVar.getInt("EmotionRecommandCount", 3);
                }
                ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "recommend count :%d need recommend count:%d download count:%d", Integer.valueOf(i2), Integer.valueOf(i2 - ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().bjV()), Integer.valueOf(((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().bjV()));
                ArrayList arrayList = new ArrayList();
                if (!this.Aaj.Aet) {
                    arrayList.add(com.tencent.mm.view.f.a.dNo());
                    a(com.tencent.mm.view.f.a.dNo(), true);
                }
                if (!this.Aaj.Aes) {
                    EmojiGroupInfo emojiGroupInfo;
                    arrayList.add(com.tencent.mm.view.f.a.dNp());
                    a(com.tencent.mm.view.f.a.dNp(), true);
                    if (this.Aaj.Aeu && (com.tencent.mm.view.f.a.QL(this.Aaj.gOW) || com.tencent.mm.emoji.a.a.OB().bZ(false).size() > 0)) {
                        emojiGroupInfo = new EmojiGroupInfo();
                        emojiGroupInfo.field_productID = "capture";
                        arrayList.add(emojiGroupInfo);
                        a(emojiGroupInfo, true);
                    }
                    int i3 = this.Aaj.gOW == ChatFooterPanel.vhi ? 1 : 0;
                    if (OD != null) {
                        Iterator it2 = OD.iterator();
                        while (it2.hasNext()) {
                            emojiGroupInfo = (EmojiGroupInfo) it2.next();
                            if (!(emojiGroupInfo == null || bo.isNullOrNil(emojiGroupInfo.field_productID))) {
                                boolean e = com.tencent.mm.view.f.a.e(emojiGroupInfo);
                                if (emojiGroupInfo.field_recommand == 1) {
                                    if (i < r8 && i < i2) {
                                        i++;
                                        if (e || i3 != 0) {
                                            a(emojiGroupInfo, e);
                                            arrayList.add(emojiGroupInfo);
                                        }
                                    }
                                } else if (!(emojiGroupInfo.field_productID.equalsIgnoreCase(String.valueOf(EmojiGroupInfo.yas)) || emojiGroupInfo.field_productID.equalsIgnoreCase("TAG_DEFAULT_TAB") || (!e && i3 == 0))) {
                                    a(emojiGroupInfo, e);
                                    arrayList.add(emojiGroupInfo);
                                }
                            }
                            i = i;
                        }
                    }
                }
                j jVar = this.Adx;
                jVar.mData.clear();
                jVar.mData.addAll(arrayList);
                jVar.aop.notifyChanged();
                ab.i("MicroMsg.emoji.SmileyPanel.SmileyTabAdapter", "update %s, %s", Integer.valueOf(jVar.mData.size()), Integer.valueOf(arrayList.size()));
                dNb();
                this.Aaj.dNt();
                com.tencent.mm.view.c.a atl = this.Aaj.atl(String.valueOf(EmojiGroupInfo.yas));
                if (atl != null) {
                    com.tencent.mm.emoji.c.a.OZ().ezn = atl.aRz();
                }
                ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "end initTabsGroup use time :%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "- deal View");
                if (this.Adt == null) {
                    ab.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initPanelVP failed");
                } else {
                    if (this.Adu == null) {
                        dNa();
                        this.Aaj.dNr();
                        this.Adt.setAdapter(this.Adu);
                        this.Adt.setOffscreenPageLimit(1);
                    } else {
                        boolean gu = x.gu(this.Gn);
                        if (gu != this.AdK) {
                            ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "orientation changed ".concat(String.valueOf(gu)));
                            dNa();
                            this.Adt.setAdapter(this.Adu);
                        }
                        this.Adu.Abw = true;
                        this.Adu.refreshData();
                        this.Adu.notifyDataSetChanged();
                        this.Adu.Abw = false;
                    }
                    this.AdK = x.gu(this.Gn);
                }
                aRF();
                this.Aaj.Aex = true;
                this.Aaj.Aez = true;
                if (!this.Aaj.zRn) {
                    com.tencent.mm.plugin.report.service.h.pYm.a(406, 6, 1, false);
                    com.tencent.mm.plugin.report.service.h.pYm.a(406, 8, System.currentTimeMillis() - currentTimeMillis, false);
                }
                AppMethodBeat.o(63036);
            }
        }
    }

    public final void aRF() {
        AppMethodBeat.i(63037);
        com.tencent.mm.view.c.a dNr = this.Aaj.dNr();
        if (dNr == null) {
            this.Aaj.setShowProductId("TAG_DEFAULT_TAB");
            dNr = this.Aaj.dNr();
        }
        dNf();
        if (!(dNr == null || this.Adt == null)) {
            boolean z;
            int i = this.Aaj.Aer;
            if (i < 0 || i > dNr.dMX() - 1) {
                i = dNr.dMX() - 1;
            }
            if (this.AdJ) {
                i++;
                this.AdJ = false;
            }
            if (this.Aaj.Aes) {
                i = 0;
            }
            this.AdF = dNr.jis + i;
            this.Adt.setCurrentItem(this.AdF, false);
            if (this.Aaj.dNx() && dNr.kWz.equals("TAG_DEFAULT_TAB")) {
                z = true;
            } else {
                z = false;
            }
            if (!dNr.kWz.equals("TAG_STORE_TAB")) {
                ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "init set currentItem not default qq. ");
                g(dNr.dMX(), i, false, z);
            }
        }
        AppMethodBeat.o(63037);
    }

    private void g(int i, int i2, boolean z, boolean z2) {
        AppMethodBeat.i(63038);
        if (i <= 1) {
            this.Adv.setVisibility(4);
            AppMethodBeat.o(63038);
            return;
        }
        this.Adv.setVisibility(0);
        this.Adv.f(i, i2, z, z2);
        AppMethodBeat.o(63038);
    }

    public final void dMZ() {
        AppMethodBeat.i(63039);
        if (this.Adu != null) {
            ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "clearViewPagerCache");
            this.Adu.mCount = 0;
        }
        AppMethodBeat.o(63039);
    }

    private void dNa() {
        AppMethodBeat.i(63040);
        dMZ();
        this.Adu = new i(this.Aaj, this.jiq);
        AppMethodBeat.o(63040);
    }

    private void a(EmojiGroupInfo emojiGroupInfo, boolean z) {
        AppMethodBeat.i(63041);
        this.Aaj.a(emojiGroupInfo, this, z);
        AppMethodBeat.o(63041);
    }

    public final void dNb() {
        AppMethodBeat.i(63042);
        if (this.Adz == null) {
            AppMethodBeat.o(63042);
            return;
        }
        if (!com.tencent.mm.view.f.a.dNj() || this.Aaj.Aeq.equalsIgnoreCase("TAG_STORE_TAB")) {
            this.AdA.setVisibility(8);
        } else {
            this.AdA.setVisibility(0);
        }
        this.Adz.setContentDescription(this.Gn.getString(R.string.bd4));
        AppMethodBeat.o(63042);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(63043);
        if (view == this.Adz) {
            Intent intent = new Intent();
            intent.putExtra("preceding_scence", 13);
            intent.putExtra("download_entrance_scene", 17);
            intent.putExtra("check_clickflag", false);
            if (com.tencent.mm.view.f.a.dNi()) {
                ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "called emoji store must refresh by net");
                intent.putExtra("emoji_stroe_must_refresh_by_net", true);
            }
            if (!bo.isNullOrNil(this.Aaj.vmL)) {
                intent.putExtra("to_talker_name", this.Aaj.vmL);
            }
            com.tencent.mm.bp.d.b(this.Gn, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
            com.tencent.mm.plugin.report.service.h.pYm.e(11594, Integer.valueOf(2));
            com.tencent.mm.plugin.report.service.h.pYm.e(12065, Integer.valueOf(8));
            AppMethodBeat.o(63043);
        } else if (view == this.AdC) {
            if (!(this.AdE == null || this.AdE.getTextOpListener() == null)) {
                this.AdE.getTextOpListener().aYY();
            }
            AppMethodBeat.o(63043);
        } else {
            if (view == this.AdB && this.AdE.getSmileyPanelCallback() != null) {
                this.AdE.getSmileyPanelCallback().bOg();
            }
            if (view == this.AdD) {
                dNc();
            }
            AppMethodBeat.o(63043);
        }
    }

    private void dNc() {
        AppMethodBeat.i(63044);
        com.tencent.mm.bp.d.b(this.Gn, "emoji", ".ui.EmojiMineUI", new Intent());
        AppMethodBeat.o(63044);
    }

    public final View findViewById(int i) {
        AppMethodBeat.i(63045);
        View findViewById = this.mView.findViewById(i);
        AppMethodBeat.o(63045);
        return findViewById;
    }

    public final void rk(boolean z) {
        AppMethodBeat.i(63046);
        if (this.AdC == null) {
            AppMethodBeat.o(63046);
            return;
        }
        if (this.AdC.getVisibility() == 0) {
            if (z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (float) this.AdC.getWidth(), 0.0f, 0.0f);
                translateAnimation.setDuration(250);
                this.AdC.startAnimation(translateAnimation);
            }
            this.AdC.setVisibility(8);
        }
        AppMethodBeat.o(63046);
    }

    private void dNd() {
        AppMethodBeat.i(63047);
        this.Aaj.Aey = false;
        if (this.AdC == null) {
            AppMethodBeat.o(63047);
            return;
        }
        if (this.AdC.getVisibility() != 0) {
            TranslateAnimation translateAnimation = new TranslateAnimation((float) this.AdC.getWidth(), 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(250);
            this.AdC.startAnimation(translateAnimation);
            this.AdC.setVisibility(0);
        }
        AppMethodBeat.o(63047);
    }

    public final void Qz(int i) {
        AppMethodBeat.i(63048);
        if (this.Adt != null) {
            int currentItem = this.Adt.getCurrentItem();
            int i2 = this.Aaj.QI(currentItem).jis + i;
            if (i2 != currentItem) {
                Math.abs(i2 - currentItem);
                this.Adt.setCurrentItem(i2);
            }
            this.AdF = i2;
        }
        AppMethodBeat.o(63048);
    }

    public final com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a dNe() {
        AppMethodBeat.i(63049);
        if (this.AdE == null) {
            AppMethodBeat.o(63049);
            return null;
        }
        com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a textOpListener = this.AdE.getTextOpListener();
        AppMethodBeat.o(63049);
        return textOpListener;
    }

    public final com.tencent.mm.pluginsdk.ui.chat.j getSmileyPanelCallback() {
        AppMethodBeat.i(63050);
        if (this.AdE == null) {
            AppMethodBeat.o(63050);
            return null;
        }
        com.tencent.mm.pluginsdk.ui.chat.j smileyPanelCallback = this.AdE.getSmileyPanelCallback();
        AppMethodBeat.o(63050);
        return smileyPanelCallback;
    }

    public final void onPageScrollStateChanged(int i) {
        AppMethodBeat.i(63051);
        if (this.Adv != null) {
            SmileyPanelScrollView smileyPanelScrollView = this.Adv;
            smileyPanelScrollView.AaI = i;
            if (i == 0) {
                smileyPanelScrollView.AaE = smileyPanelScrollView.Aar;
                smileyPanelScrollView.AaD = smileyPanelScrollView.Aar;
                smileyPanelScrollView.AaF = 0.0f;
                smileyPanelScrollView.invalidate();
                if (smileyPanelScrollView.AaG) {
                    smileyPanelScrollView.AaG = false;
                }
            } else if (i == 1) {
                smileyPanelScrollView.AaE = smileyPanelScrollView.Aar;
                smileyPanelScrollView.AaD = smileyPanelScrollView.Aar;
                smileyPanelScrollView.AaF = 0.0f;
            }
        }
        if (i == 0 || i == 1) {
            this.AdF = this.Adt.getCurrentItem();
        }
        AppMethodBeat.o(63051);
    }

    public final void onPageScrolled(int i, float f, int i2) {
        AppMethodBeat.i(63052);
        if (this.Adu != null) {
            i iVar = this.Adu;
            if (iVar.Abz != null) {
                f fVar = iVar.Abz;
                float f2 = ((float) i) + f;
                fVar.Abr = Math.round(f2);
                fVar.bv(f2);
            }
        }
        if (!(this.Adv == null || f == 0.0f)) {
            com.tencent.mm.view.c.a QI = this.Aaj.QI((f > 0.0f ? 1 : -1) + i);
            com.tencent.mm.view.c.a QI2 = this.Aaj.QI(i);
            if (QI == QI2) {
                SmileyPanelScrollView smileyPanelScrollView = this.Adv;
                int i3 = i - QI2.jis;
                smileyPanelScrollView.AaF = f;
                if (smileyPanelScrollView.AaE != i3) {
                    smileyPanelScrollView.AaE = i3;
                }
                smileyPanelScrollView.invalidate();
                this.AdG = true;
                AppMethodBeat.o(63052);
                return;
            }
            this.AdG = false;
        }
        AppMethodBeat.o(63052);
    }

    private void setTabSelected(int i) {
        int i2 = 0;
        AppMethodBeat.i(63053);
        if (!(this.Adw == null || this.Adx == null)) {
            j jVar = this.Adx;
            if (jVar.llU != i) {
                jVar.cg(jVar.llU);
                jVar.llU = i;
                jVar.cg(jVar.llU);
            }
            int i3 = this.Aaj.lfN;
            Rect rect = new Rect();
            rect.left = i3 * i;
            rect.right = i3 * (i + 1);
            ScrollRectRecyclerView scrollRectRecyclerView = this.Adw;
            if (rect.left < scrollRectRecyclerView.scrollX) {
                i3 = rect.left - scrollRectRecyclerView.scrollX;
            } else {
                i3 = 0;
            }
            if (rect.right > scrollRectRecyclerView.scrollX + scrollRectRecyclerView.getMeasuredWidth()) {
                i3 = rect.right - (scrollRectRecyclerView.scrollX + scrollRectRecyclerView.getMeasuredWidth());
            }
            if (rect.top < scrollRectRecyclerView.scrollY) {
                i2 = rect.top - scrollRectRecyclerView.scrollY;
            }
            if (rect.bottom > scrollRectRecyclerView.scrollY + scrollRectRecyclerView.getMeasuredHeight()) {
                i2 = rect.bottom - (scrollRectRecyclerView.scrollY + scrollRectRecyclerView.getMeasuredHeight());
            }
            scrollRectRecyclerView.a(i3, i2, null);
        }
        AppMethodBeat.o(63053);
    }

    public final void onPageSelected(int i) {
        AppMethodBeat.i(63054);
        ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "cpan onPageSelected :%d", Integer.valueOf(i));
        if (this.Adu != null) {
            i iVar = this.Adu;
            iVar.Abx = i;
            if (iVar.Abz != null) {
                f fVar = iVar.Abz;
                fVar.Abr = i;
                if (i == 0) {
                    fVar.bv(0.0f);
                } else {
                    fVar.bv(1.0f);
                }
            }
            if (i != 0 && iVar.Aby) {
                iVar.aJ(iVar.Abx, false);
                iVar.Aby = false;
            }
        }
        if (this.Aaj == null) {
            AppMethodBeat.o(63054);
        } else if (this.Aaj.AeI) {
            boolean z;
            boolean z2;
            com.tencent.mm.view.c.a QI = this.Aaj.QI(i);
            if (QI.kWz.equals("TAG_STORE_TAB")) {
                this.Adz.setSelected(true);
                ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "show TAB: viewId: %d, tabProductId: %s", Integer.valueOf(this.Adz.getId()), "TAG_STORE_TAB");
                this.Aaj.setShowProductId("TAG_STORE_TAB");
                com.tencent.mm.plugin.report.service.h.pYm.e(11594, Integer.valueOf(5));
                com.tencent.mm.x.c.PK().bZ(262147, 266244);
                com.tencent.mm.x.c.PK().bZ(262149, 266244);
                dNb();
            } else {
                this.Adz.setSelected(false);
            }
            int i2 = i - QI.jis;
            if (this.Aaj.dNx() && QI.kWz.equals("TAG_DEFAULT_TAB")) {
                z = true;
            } else {
                z = false;
            }
            int dMX = QI.dMX();
            int i3 = i - QI.jis;
            if (this.AdG) {
                z2 = false;
            } else {
                z2 = true;
            }
            g(dMX, i3, z2, z);
            this.Aaj.Aer = i2;
            this.Aaj.setShowProductId(QI.kWz);
            QI.Adn = i2;
            this.Aaj.eI(QI.kWz, QI.Adn);
            int QJ = this.Aaj.QJ(i);
            com.tencent.mm.emoji.c.a.OZ().ezl = QJ;
            com.tencent.mm.emoji.c.a.OZ().ezm = i2;
            setTabSelected(QJ);
            dNf();
            if (com.tencent.mm.view.f.a.QL(this.Aaj.gOW) && ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().OT() && i2 == 0 && QI.kWz.equals("capture")) {
                com.tencent.mm.cj.c.aNX();
                com.tencent.mm.plugin.report.service.h.pYm.e(15982, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            }
            if (this.Aaj.gOW == ChatFooterPanel.vhi && QI.kWz.equals(String.valueOf(EmojiGroupInfo.yas)) && !com.tencent.mm.ao.b.afY().fAO) {
                ab.i("MicroMsg.FontResLogic", "check res early");
                com.tencent.mm.plugin.report.service.h.pYm.k(933, 11, 1);
                com.tencent.mm.ao.b.aga();
            }
            AppMethodBeat.o(63054);
        } else {
            AppMethodBeat.o(63054);
        }
    }

    private void dNf() {
        AppMethodBeat.i(63055);
        if (this.Aaj.atk("TAG_DEFAULT_TAB")) {
            if (!(this.AdE == null || this.AdE.getTextOpListener() == null)) {
                this.AdE.getTextOpListener().fC(true);
            }
            if (this.Aaj.dNq()) {
                dNd();
                AppMethodBeat.o(63055);
                return;
            }
        }
        if (!(this.AdE == null || this.AdE.getTextOpListener() == null)) {
            this.AdE.getTextOpListener().fC(false);
        }
        rk(true);
        AppMethodBeat.o(63055);
    }

    public final synchronized void QA(int i) {
        AppMethodBeat.i(63056);
        com.tencent.mm.view.f.a aVar;
        if (x.gu(this.Aaj.Gn)) {
            if (!this.Aaj.AeC) {
                aVar = this.Aaj;
                aVar.AeC = true;
                aVar.AeD = false;
            }
        } else if (!this.Aaj.AeD) {
            aVar = this.Aaj;
            aVar.AeD = true;
            aVar.AeC = false;
        }
        ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "catch Size & start deal");
        if (i > 0) {
            this.mView.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(63026);
                    ab.v("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onLayoutChange handle");
                    a.this.dMY();
                    AppMethodBeat.o(63026);
                }
            });
        }
        AppMethodBeat.o(63056);
    }

    public final void NJ(int i) {
        AppMethodBeat.i(63057);
        if (i > 0) {
            int i2;
            ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "tab size changed ,so adjusting tab site.");
            com.tencent.mm.view.f.a aVar = this.Aaj;
            String str = aVar.Aeq;
            if (aVar.AeE != null) {
                i2 = 0;
                while (i2 < aVar.AeE.size()) {
                    com.tencent.mm.view.c.a aVar2 = (com.tencent.mm.view.c.a) aVar.AeE.get(i2);
                    if (aVar2 != null && aVar2.kWz.equals(str)) {
                        break;
                    }
                    i2++;
                }
            }
            i2 = 0;
            setTabSelected(i2);
        }
        AppMethodBeat.o(63057);
    }

    public final void dNg() {
        AppMethodBeat.i(63058);
        this.AdH = false;
        this.mHandler.removeMessages(1102);
        this.mHandler.sendEmptyMessageDelayed(1102, 100);
        AppMethodBeat.o(63058);
    }

    static /* synthetic */ void dNh() {
        AppMethodBeat.i(63062);
        if (((h) g.RM().Rn()).SG()) {
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_CAPTURE_TAB_RED_DOT_BOOLEAN, Boolean.TRUE);
        }
        AppMethodBeat.o(63062);
    }
}
