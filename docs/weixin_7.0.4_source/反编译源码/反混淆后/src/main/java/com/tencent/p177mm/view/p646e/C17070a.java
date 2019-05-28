package com.tencent.p177mm.view.p646e;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Message;
import android.support.p057v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.emoji.debug.EmojiDebugUI;
import com.tencent.p177mm.emoji.p1381c.C26073a;
import com.tencent.p177mm.emoji.p227a.C32497a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p1177ao.C25779b;
import com.tencent.p177mm.p207by.C45274a;
import com.tencent.p177mm.p207by.C45274a.C18119c;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p230g.p231a.C45317cz;
import com.tencent.p177mm.p230g.p231a.C45348ny;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.base.MMRadioGroupView.C36060d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel.C44073a;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C23297j;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo.C30301b;
import com.tencent.p177mm.storage.emotion.EmojiInfo.C30302a;
import com.tencent.p177mm.view.ScrollRectRecyclerView;
import com.tencent.p177mm.view.SmileyPanelScrollView;
import com.tencent.p177mm.view.SmileyPanelScrollView.C46714b;
import com.tencent.p177mm.view.SmileyPanelViewPager;
import com.tencent.p177mm.view.SmileyPanelViewPager.C16036a;
import com.tencent.p177mm.view.p1097f.C16067a;
import com.tencent.p177mm.view.p1627c.C44418a;
import com.tencent.p177mm.view.p645a.C16042i;
import com.tencent.p177mm.view.p645a.C16049j;
import com.tencent.p177mm.view.p645a.C16049j.C16050a;
import com.tencent.p177mm.view.p645a.C36883f;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.view.e.a */
public final class C17070a implements OnPageChangeListener, OnClickListener, C36060d, C46714b, C16036a {
    private static boolean AdL = true;
    public C16067a Aaj;
    public ImageView AdA;
    public ImageButton AdB;
    public TextView AdC;
    public ImageView AdD;
    private C17077a AdE;
    private int AdF = -1;
    private boolean AdG = false;
    public boolean AdH = true;
    public String AdI;
    private boolean AdJ = false;
    private boolean AdK = false;
    public final C4931a AdM = new C170756();
    public final C4884c<C45317cz> AdN = new C160659();
    public final C4931a AdO = new C1707610();
    public C16050a AdP = new C170712();
    private final int Adp = 100;
    private final int Adq = 1102;
    private final int Adr = 1103;
    private final int Ads = 100;
    public SmileyPanelViewPager Adt;
    public C16042i Adu;
    public SmileyPanelScrollView Adv;
    public ScrollRectRecyclerView Adw;
    public C16049j Adx;
    public View Ady;
    public ImageView Adz;
    /* renamed from: Gn */
    private Context f3581Gn = C4996ah.getContext();
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelManager";
    public Context jiq;
    private C7306ak mHandler = new C75841();
    public View mView;
    public final C4931a xYF = new C170747();
    public final C4884c xYG = new C160648();

    /* renamed from: com.tencent.mm.view.e.a$3 */
    public class C57413 implements OnLongClickListener {
        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(63025);
            C17070a.this.jiq.startActivity(new Intent(C17070a.this.jiq, EmojiDebugUI.class));
            AppMethodBeat.m2505o(63025);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.view.e.a$1 */
    class C75841 extends C7306ak {
        C75841() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(63023);
            switch (message.what) {
                case 1102:
                    C17070a.this.dMY();
                    C17070a.this.AdH = true;
                    if (!(C17070a.this.AdI == null || C17070a.this.Adt == null)) {
                        int i = C17070a.this.Aaj.Aer;
                        if (i < 0 || i > C17070a.this.Aaj.atl(C17070a.this.AdI).dMX()) {
                            i = C17070a.this.Aaj.atl(C17070a.this.AdI).dMX() - 1;
                        }
                        C17070a.this.AdF = i + C17070a.this.Aaj.atl(C17070a.this.AdI).jis;
                        C17070a.this.Adt.setCurrentItem(C17070a.this.AdF);
                        C17070a.this.AdI = null;
                        AppMethodBeat.m2505o(63023);
                        return;
                    }
                case 1103:
                    C4990ab.m7410d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "update selection");
                    C17070a.m26389b(C17070a.this, message.arg1);
                    break;
            }
            AppMethodBeat.m2505o(63023);
        }
    }

    /* renamed from: com.tencent.mm.view.e.a$8 */
    class C160648 extends C4884c<C45348ny> {
        C160648() {
            AppMethodBeat.m2504i(63030);
            this.xxI = C45348ny.class.getName().hashCode();
            AppMethodBeat.m2505o(63030);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(63031);
            C4990ab.m7416i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "REFRESH_PANEL_EVENT");
            C17070a.this.dNg();
            AppMethodBeat.m2505o(63031);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.view.e.a$9 */
    class C160659 extends C4884c<C45317cz> {
        C160659() {
            AppMethodBeat.m2504i(63032);
            this.xxI = C45317cz.class.getName().hashCode();
            AppMethodBeat.m2505o(63032);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(63033);
            C45317cz c45317cz = (C45317cz) c4883b;
            C16067a d;
            if (c45317cz.cwc.type == 1) {
                if (C17070a.this.Aaj != null) {
                    C17070a.this.Aaj.Aer = 0;
                    d = C17070a.this.Aaj;
                    C17070a.this.Aaj;
                    d.mo28478eI(String.valueOf(EmojiGroupInfo.yas), 0);
                    d = C17070a.this.Aaj;
                    C17070a.this.Aaj;
                    d.setShowProductId(String.valueOf(EmojiGroupInfo.yas));
                    C17070a.this.Aaj.dNl();
                    C17070a.this.Aaj.dNw();
                    c45317cz.cwd.cwe = true;
                    C4990ab.m7410d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "update custom panel.");
                }
            } else if (c45317cz.cwc.type == 2 && C17070a.this.Aaj != null) {
                C17070a.this.Aaj.Aer = 0;
                d = C17070a.this.Aaj;
                C17070a.this.Aaj;
                d.mo28478eI("capture", 0);
                d = C17070a.this.Aaj;
                C17070a.this.Aaj;
                d.setShowProductId("capture");
                C17070a.this.Aaj.dNl();
                C17070a.this.Aaj.dNw();
                c45317cz.cwd.cwe = true;
                C4990ab.m7410d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "update capture panel.");
            }
            AppMethodBeat.m2505o(63033);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.view.e.a$2 */
    class C170712 implements C16050a {
        C170712() {
        }

        /* renamed from: f */
        public final void mo28419f(int i, View view) {
            boolean z = false;
            AppMethodBeat.m2504i(63024);
            EmojiGroupInfo QE = C17070a.this.Adx.mo28417QE(i);
            if (QE == null) {
                C4990ab.m7420w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "info is null. ignore click action.");
                AppMethodBeat.m2505o(63024);
                return;
            }
            String str = QE.field_productID;
            C17070a.this.Aaj;
            if (str.equalsIgnoreCase("TAG_STORE_MANEGER_TAB")) {
                C17070a.m26399k(C17070a.this);
                AppMethodBeat.m2505o(63024);
                return;
            }
            int dMX;
            C17070a.m26389b(C17070a.this, i);
            C44418a atl = C17070a.this.Aaj.atl(QE.field_productID);
            C17070a.this.AdF = atl.jis;
            if (atl.Adn > atl.dMX() - 1) {
                dMX = atl.dMX() - 1;
            } else {
                dMX = atl.Adn;
            }
            if (C17070a.this.Adt != null) {
                C17070a.this.Adt.setCurrentItem(C17070a.this.AdF + dMX, false);
            }
            if (C17070a.this.Aaj.dNx()) {
                String str2 = atl.kWz;
                C17070a.this.Aaj;
                if (str2.equals("TAG_DEFAULT_TAB")) {
                    z = true;
                }
            }
            C17070a.m26386a(C17070a.this, atl.dMX(), dMX, z);
            C17070a.this.Aaj.Aer = dMX;
            C17070a.this.Aaj.setShowProductId(QE.field_productID);
            str = QE.field_productID;
            C17070a.this.Aaj;
            if (str.equals("capture") && C16067a.m24369QL(C17070a.this.Aaj.gOW)) {
                C17070a.dNh();
                View findViewById = view.findViewById(2131827585);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
            }
            AppMethodBeat.m2505o(63024);
        }
    }

    /* renamed from: com.tencent.mm.view.e.a$4 */
    class C170724 implements Runnable {
        C170724() {
        }

        public final void run() {
            AppMethodBeat.m2504i(63026);
            C4990ab.m7418v("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onLayoutChange handle");
            C17070a.this.dMY();
            AppMethodBeat.m2505o(63026);
        }
    }

    /* renamed from: com.tencent.mm.view.e.a$5 */
    public class C170735 implements Runnable {
        final /* synthetic */ String kUJ;

        public C170735(String str) {
            this.kUJ = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(63027);
            if (C17070a.this.Adt == null || C17070a.this.Aaj == null || C17070a.this.Aaj.atl(this.kUJ) == null) {
                AppMethodBeat.m2505o(63027);
                return;
            }
            C17070a.this.AdF = C17070a.this.Aaj.atl(this.kUJ).jis;
            C17070a.this.Adt.setCurrentItem(C17070a.this.AdF);
            C17070a.this.Aaj.Aer = 0;
            AppMethodBeat.m2505o(63027);
        }
    }

    /* renamed from: com.tencent.mm.view.e.a$7 */
    class C170747 implements C4931a {
        C170747() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(63029);
            C4990ab.m7417i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "emoji storage notify %s", str);
            if (str == null) {
                AppMethodBeat.m2505o(63029);
            } else if (str.equalsIgnoreCase("delete_emoji_info_notify")) {
                C17070a.this.dNg();
                AppMethodBeat.m2505o(63029);
            } else if (C1720g.m3534RN().mo5161QY()) {
                if (((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(str) != null) {
                    C4990ab.m7411d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "update emoji %s, group %x.", str, Integer.valueOf(((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(str).field_catalog));
                    C17070a.this.dNg();
                }
                AppMethodBeat.m2505o(63029);
            } else {
                AppMethodBeat.m2505o(63029);
            }
        }
    }

    /* renamed from: com.tencent.mm.view.e.a$6 */
    class C170756 implements C4931a {
        C170756() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(63028);
            if (!TextUtils.isEmpty(str) && (str.equals("event_update_group") || str.equalsIgnoreCase("productID"))) {
                C4990ab.m7410d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "modify emoji group .");
                C17070a.this.dNg();
            }
            AppMethodBeat.m2505o(63028);
        }
    }

    /* renamed from: com.tencent.mm.view.e.a$10 */
    class C1707610 implements C4931a {
        C1707610() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(63034);
            Object obj = c4935m.obj;
            int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
            if (C17070a.this.Aaj.dNx() || intValue < 3) {
                if (!(C17070a.this.Adu == null || C17070a.this.Adt == null)) {
                    C17070a.this.Adu.mo28410aJ(C17070a.this.Adt.getCurrentItem(), false);
                }
                AppMethodBeat.m2505o(63034);
                return;
            }
            C17070a.this.Aaj.dNy();
            C17070a.this.AdJ = true;
            C17070a.this.dNg();
            AppMethodBeat.m2505o(63034);
        }
    }

    /* renamed from: com.tencent.mm.view.e.a$a */
    public interface C17077a {
        C23297j getSmileyPanelCallback();

        C44073a getTextOpListener();
    }

    /* renamed from: a */
    static /* synthetic */ void m26386a(C17070a c17070a, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(63061);
        c17070a.m26395g(i, i2, true, z);
        AppMethodBeat.m2505o(63061);
    }

    /* renamed from: b */
    static /* synthetic */ void m26389b(C17070a c17070a, int i) {
        AppMethodBeat.m2504i(63059);
        c17070a.setTabSelected(i);
        AppMethodBeat.m2505o(63059);
    }

    /* renamed from: k */
    static /* synthetic */ void m26399k(C17070a c17070a) {
        AppMethodBeat.m2504i(63060);
        c17070a.dNc();
        AppMethodBeat.m2505o(63060);
    }

    public C17070a(Context context, C16067a c16067a, C17077a c17077a) {
        AppMethodBeat.m2504i(63035);
        this.jiq = context;
        this.Aaj = c16067a;
        this.AdE = c17077a;
        C4990ab.m7416i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager add listener.");
        ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35652j(this.AdM);
        ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35649h(this.xYF);
        ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35655l(this.AdO);
        C4879a.xxA.mo10052c(this.xYG);
        C4879a.xxA.mo10052c(this.AdN);
        if (AdL) {
            AdL = false;
            for (EmojiInfo emojiInfo : C32497a.m53203OB().mo53137bZ(true)) {
                if (C30302a.STATUS_MIXING == emojiInfo.duZ()) {
                    emojiInfo.mo48510a(C30302a.STATUS_MIX_FAIL);
                    emojiInfo.mo48511a(C30301b.ERR_MIX_PROCESS_KILL);
                    ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().updateEmojiInfo(emojiInfo);
                    EmojiCaptureReporter.m66037h(emojiInfo.field_captureEnterTime, 5, emojiInfo.field_captureScene);
                } else if (emojiInfo.duZ() == C30302a.STATUS_UPLOADING) {
                    emojiInfo.mo48510a(C30302a.STATUS_UPLOAD_FAIL);
                    ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().updateEmojiInfo(emojiInfo);
                    EmojiCaptureReporter.m66036g(emojiInfo.field_captureEnterTime, 3, emojiInfo.field_captureScene);
                }
            }
        }
        AppMethodBeat.m2505o(63035);
    }

    public final synchronized void dMY() {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.m2504i(63036);
            if (this.mView == null || !this.Aaj.AeI) {
                C4990ab.m7410d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "not view can't deal");
                AppMethodBeat.m2505o(63036);
            } else {
                int i2;
                long currentTimeMillis = System.currentTimeMillis();
                this.Aaj.Aex = false;
                C4990ab.m7410d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initSmileyData");
                long currentTimeMillis2 = System.currentTimeMillis();
                C16067a c16067a = this.Aaj;
                if (c16067a.AeE != null) {
                    Iterator it = c16067a.AeE.iterator();
                    while (it.hasNext()) {
                        if (((C44418a) it.next()) != null) {
                            C4990ab.m7419v("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "removeAllGridViewListener listener: %s", ((C44418a) it.next()).kWz);
                        } else {
                            C4990ab.m7410d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "removeAllGridViewListener already release: ..");
                        }
                    }
                }
                if (c16067a.AeE != null) {
                    c16067a.AeE.clear();
                }
                ArrayList OD = ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35612OD();
                C45274a.dmE();
                C18119c c18119c = C45274a.xun;
                if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
                    i2 = C26373g.m41964Nu().getInt("EmotionRecommandCount", 3);
                } else {
                    i2 = c18119c.getInt("EmotionRecommandCount", 3);
                }
                C4990ab.m7417i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "recommend count :%d need recommend count:%d download count:%d", Integer.valueOf(i2), Integer.valueOf(i2 - ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().bjV()), Integer.valueOf(((C6835d) C1720g.m3530M(C6835d.class)).getProvider().bjV()));
                ArrayList arrayList = new ArrayList();
                if (!this.Aaj.Aet) {
                    arrayList.add(C16067a.dNo());
                    m26385a(C16067a.dNo(), true);
                }
                if (!this.Aaj.Aes) {
                    EmojiGroupInfo emojiGroupInfo;
                    arrayList.add(C16067a.dNp());
                    m26385a(C16067a.dNp(), true);
                    if (this.Aaj.Aeu && (C16067a.m24369QL(this.Aaj.gOW) || C32497a.m53203OB().mo53137bZ(false).size() > 0)) {
                        emojiGroupInfo = new EmojiGroupInfo();
                        emojiGroupInfo.field_productID = "capture";
                        arrayList.add(emojiGroupInfo);
                        m26385a(emojiGroupInfo, true);
                    }
                    int i3 = this.Aaj.gOW == ChatFooterPanel.vhi ? 1 : 0;
                    if (OD != null) {
                        Iterator it2 = OD.iterator();
                        while (it2.hasNext()) {
                            emojiGroupInfo = (EmojiGroupInfo) it2.next();
                            if (!(emojiGroupInfo == null || C5046bo.isNullOrNil(emojiGroupInfo.field_productID))) {
                                boolean e = C16067a.m24373e(emojiGroupInfo);
                                if (emojiGroupInfo.field_recommand == 1) {
                                    if (i < r8 && i < i2) {
                                        i++;
                                        if (e || i3 != 0) {
                                            m26385a(emojiGroupInfo, e);
                                            arrayList.add(emojiGroupInfo);
                                        }
                                    }
                                } else if (!(emojiGroupInfo.field_productID.equalsIgnoreCase(String.valueOf(EmojiGroupInfo.yas)) || emojiGroupInfo.field_productID.equalsIgnoreCase("TAG_DEFAULT_TAB") || (!e && i3 == 0))) {
                                    m26385a(emojiGroupInfo, e);
                                    arrayList.add(emojiGroupInfo);
                                }
                            }
                            i = i;
                        }
                    }
                }
                C16049j c16049j = this.Adx;
                c16049j.mData.clear();
                c16049j.mData.addAll(arrayList);
                c16049j.aop.notifyChanged();
                C4990ab.m7417i("MicroMsg.emoji.SmileyPanel.SmileyTabAdapter", "update %s, %s", Integer.valueOf(c16049j.mData.size()), Integer.valueOf(arrayList.size()));
                dNb();
                this.Aaj.dNt();
                C44418a atl = this.Aaj.atl(String.valueOf(EmojiGroupInfo.yas));
                if (atl != null) {
                    C26073a.m41631OZ().ezn = atl.aRz();
                }
                C4990ab.m7417i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "end initTabsGroup use time :%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                C4990ab.m7410d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "- deal View");
                if (this.Adt == null) {
                    C4990ab.m7420w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initPanelVP failed");
                } else {
                    if (this.Adu == null) {
                        dNa();
                        this.Aaj.dNr();
                        this.Adt.setAdapter(this.Adu);
                        this.Adt.setOffscreenPageLimit(1);
                    } else {
                        boolean gu = C40619x.m70075gu(this.f3581Gn);
                        if (gu != this.AdK) {
                            C4990ab.m7416i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "orientation changed ".concat(String.valueOf(gu)));
                            dNa();
                            this.Adt.setAdapter(this.Adu);
                        }
                        this.Adu.Abw = true;
                        this.Adu.refreshData();
                        this.Adu.notifyDataSetChanged();
                        this.Adu.Abw = false;
                    }
                    this.AdK = C40619x.m70075gu(this.f3581Gn);
                }
                aRF();
                this.Aaj.Aex = true;
                this.Aaj.Aez = true;
                if (!this.Aaj.zRn) {
                    C7060h.pYm.mo8378a(406, 6, 1, false);
                    C7060h.pYm.mo8378a(406, 8, System.currentTimeMillis() - currentTimeMillis, false);
                }
                AppMethodBeat.m2505o(63036);
            }
        }
    }

    public final void aRF() {
        AppMethodBeat.m2504i(63037);
        C44418a dNr = this.Aaj.dNr();
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
                C4990ab.m7410d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "init set currentItem not default qq. ");
                m26395g(dNr.dMX(), i, false, z);
            }
        }
        AppMethodBeat.m2505o(63037);
    }

    /* renamed from: g */
    private void m26395g(int i, int i2, boolean z, boolean z2) {
        AppMethodBeat.m2504i(63038);
        if (i <= 1) {
            this.Adv.setVisibility(4);
            AppMethodBeat.m2505o(63038);
            return;
        }
        this.Adv.setVisibility(0);
        this.Adv.mo75107f(i, i2, z, z2);
        AppMethodBeat.m2505o(63038);
    }

    public final void dMZ() {
        AppMethodBeat.m2504i(63039);
        if (this.Adu != null) {
            C4990ab.m7416i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "clearViewPagerCache");
            this.Adu.mCount = 0;
        }
        AppMethodBeat.m2505o(63039);
    }

    private void dNa() {
        AppMethodBeat.m2504i(63040);
        dMZ();
        this.Adu = new C16042i(this.Aaj, this.jiq);
        AppMethodBeat.m2505o(63040);
    }

    /* renamed from: a */
    private void m26385a(EmojiGroupInfo emojiGroupInfo, boolean z) {
        AppMethodBeat.m2504i(63041);
        this.Aaj.mo28458a(emojiGroupInfo, this, z);
        AppMethodBeat.m2505o(63041);
    }

    public final void dNb() {
        AppMethodBeat.m2504i(63042);
        if (this.Adz == null) {
            AppMethodBeat.m2505o(63042);
            return;
        }
        if (!C16067a.dNj() || this.Aaj.Aeq.equalsIgnoreCase("TAG_STORE_TAB")) {
            this.AdA.setVisibility(8);
        } else {
            this.AdA.setVisibility(0);
        }
        this.Adz.setContentDescription(this.f3581Gn.getString(C25738R.string.bd4));
        AppMethodBeat.m2505o(63042);
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(63043);
        if (view == this.Adz) {
            Intent intent = new Intent();
            intent.putExtra("preceding_scence", 13);
            intent.putExtra("download_entrance_scene", 17);
            intent.putExtra("check_clickflag", false);
            if (C16067a.dNi()) {
                C4990ab.m7410d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "called emoji store must refresh by net");
                intent.putExtra("emoji_stroe_must_refresh_by_net", true);
            }
            if (!C5046bo.isNullOrNil(this.Aaj.vmL)) {
                intent.putExtra("to_talker_name", this.Aaj.vmL);
            }
            C25985d.m41467b(this.f3581Gn, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
            C7060h.pYm.mo8381e(11594, Integer.valueOf(2));
            C7060h.pYm.mo8381e(12065, Integer.valueOf(8));
            AppMethodBeat.m2505o(63043);
        } else if (view == this.AdC) {
            if (!(this.AdE == null || this.AdE.getTextOpListener() == null)) {
                this.AdE.getTextOpListener().aYY();
            }
            AppMethodBeat.m2505o(63043);
        } else {
            if (view == this.AdB && this.AdE.getSmileyPanelCallback() != null) {
                this.AdE.getSmileyPanelCallback().bOg();
            }
            if (view == this.AdD) {
                dNc();
            }
            AppMethodBeat.m2505o(63043);
        }
    }

    private void dNc() {
        AppMethodBeat.m2504i(63044);
        C25985d.m41467b(this.f3581Gn, "emoji", ".ui.EmojiMineUI", new Intent());
        AppMethodBeat.m2505o(63044);
    }

    public final View findViewById(int i) {
        AppMethodBeat.m2504i(63045);
        View findViewById = this.mView.findViewById(i);
        AppMethodBeat.m2505o(63045);
        return findViewById;
    }

    /* renamed from: rk */
    public final void mo31142rk(boolean z) {
        AppMethodBeat.m2504i(63046);
        if (this.AdC == null) {
            AppMethodBeat.m2505o(63046);
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
        AppMethodBeat.m2505o(63046);
    }

    private void dNd() {
        AppMethodBeat.m2504i(63047);
        this.Aaj.Aey = false;
        if (this.AdC == null) {
            AppMethodBeat.m2505o(63047);
            return;
        }
        if (this.AdC.getVisibility() != 0) {
            TranslateAnimation translateAnimation = new TranslateAnimation((float) this.AdC.getWidth(), 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(250);
            this.AdC.startAnimation(translateAnimation);
            this.AdC.setVisibility(0);
        }
        AppMethodBeat.m2505o(63047);
    }

    /* renamed from: Qz */
    public final void mo31132Qz(int i) {
        AppMethodBeat.m2504i(63048);
        if (this.Adt != null) {
            int currentItem = this.Adt.getCurrentItem();
            int i2 = this.Aaj.mo28456QI(currentItem).jis + i;
            if (i2 != currentItem) {
                Math.abs(i2 - currentItem);
                this.Adt.setCurrentItem(i2);
            }
            this.AdF = i2;
        }
        AppMethodBeat.m2505o(63048);
    }

    public final C44073a dNe() {
        AppMethodBeat.m2504i(63049);
        if (this.AdE == null) {
            AppMethodBeat.m2505o(63049);
            return null;
        }
        C44073a textOpListener = this.AdE.getTextOpListener();
        AppMethodBeat.m2505o(63049);
        return textOpListener;
    }

    public final C23297j getSmileyPanelCallback() {
        AppMethodBeat.m2504i(63050);
        if (this.AdE == null) {
            AppMethodBeat.m2505o(63050);
            return null;
        }
        C23297j smileyPanelCallback = this.AdE.getSmileyPanelCallback();
        AppMethodBeat.m2505o(63050);
        return smileyPanelCallback;
    }

    public final void onPageScrollStateChanged(int i) {
        AppMethodBeat.m2504i(63051);
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
        AppMethodBeat.m2505o(63051);
    }

    public final void onPageScrolled(int i, float f, int i2) {
        AppMethodBeat.m2504i(63052);
        if (this.Adu != null) {
            C16042i c16042i = this.Adu;
            if (c16042i.Abz != null) {
                C36883f c36883f = c16042i.Abz;
                float f2 = ((float) i) + f;
                c36883f.Abr = Math.round(f2);
                c36883f.mo58775bv(f2);
            }
        }
        if (!(this.Adv == null || f == 0.0f)) {
            C44418a QI = this.Aaj.mo28456QI((f > 0.0f ? 1 : -1) + i);
            C44418a QI2 = this.Aaj.mo28456QI(i);
            if (QI == QI2) {
                SmileyPanelScrollView smileyPanelScrollView = this.Adv;
                int i3 = i - QI2.jis;
                smileyPanelScrollView.AaF = f;
                if (smileyPanelScrollView.AaE != i3) {
                    smileyPanelScrollView.AaE = i3;
                }
                smileyPanelScrollView.invalidate();
                this.AdG = true;
                AppMethodBeat.m2505o(63052);
                return;
            }
            this.AdG = false;
        }
        AppMethodBeat.m2505o(63052);
    }

    private void setTabSelected(int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(63053);
        if (!(this.Adw == null || this.Adx == null)) {
            C16049j c16049j = this.Adx;
            if (c16049j.llU != i) {
                c16049j.mo66316cg(c16049j.llU);
                c16049j.llU = i;
                c16049j.mo66316cg(c16049j.llU);
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
            scrollRectRecyclerView.mo66329a(i3, i2, null);
        }
        AppMethodBeat.m2505o(63053);
    }

    public final void onPageSelected(int i) {
        AppMethodBeat.m2504i(63054);
        C4990ab.m7411d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "cpan onPageSelected :%d", Integer.valueOf(i));
        if (this.Adu != null) {
            C16042i c16042i = this.Adu;
            c16042i.Abx = i;
            if (c16042i.Abz != null) {
                C36883f c36883f = c16042i.Abz;
                c36883f.Abr = i;
                if (i == 0) {
                    c36883f.mo58775bv(0.0f);
                } else {
                    c36883f.mo58775bv(1.0f);
                }
            }
            if (i != 0 && c16042i.Aby) {
                c16042i.mo28410aJ(c16042i.Abx, false);
                c16042i.Aby = false;
            }
        }
        if (this.Aaj == null) {
            AppMethodBeat.m2505o(63054);
        } else if (this.Aaj.AeI) {
            boolean z;
            boolean z2;
            C44418a QI = this.Aaj.mo28456QI(i);
            if (QI.kWz.equals("TAG_STORE_TAB")) {
                this.Adz.setSelected(true);
                C4990ab.m7411d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "show TAB: viewId: %d, tabProductId: %s", Integer.valueOf(this.Adz.getId()), "TAG_STORE_TAB");
                this.Aaj.setShowProductId("TAG_STORE_TAB");
                C7060h.pYm.mo8381e(11594, Integer.valueOf(5));
                C16112c.m24429PK().mo28553bZ(262147, 266244);
                C16112c.m24429PK().mo28553bZ(262149, 266244);
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
            m26395g(dMX, i3, z2, z);
            this.Aaj.Aer = i2;
            this.Aaj.setShowProductId(QI.kWz);
            QI.Adn = i2;
            this.Aaj.mo28478eI(QI.kWz, QI.Adn);
            int QJ = this.Aaj.mo28457QJ(i);
            C26073a.m41631OZ().ezl = QJ;
            C26073a.m41631OZ().ezm = i2;
            setTabSelected(QJ);
            dNf();
            if (C16067a.m24369QL(this.Aaj.gOW) && ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35614OT() && i2 == 0 && QI.kWz.equals("capture")) {
                C45287c.aNX();
                C7060h.pYm.mo8381e(15982, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            }
            if (this.Aaj.gOW == ChatFooterPanel.vhi && QI.kWz.equals(String.valueOf(EmojiGroupInfo.yas)) && !C25779b.afY().fAO) {
                C4990ab.m7416i("MicroMsg.FontResLogic", "check res early");
                C7060h.pYm.mo15419k(933, 11, 1);
                C25779b.aga();
            }
            AppMethodBeat.m2505o(63054);
        } else {
            AppMethodBeat.m2505o(63054);
        }
    }

    private void dNf() {
        AppMethodBeat.m2504i(63055);
        if (this.Aaj.atk("TAG_DEFAULT_TAB")) {
            if (!(this.AdE == null || this.AdE.getTextOpListener() == null)) {
                this.AdE.getTextOpListener().mo24351fC(true);
            }
            if (this.Aaj.dNq()) {
                dNd();
                AppMethodBeat.m2505o(63055);
                return;
            }
        }
        if (!(this.AdE == null || this.AdE.getTextOpListener() == null)) {
            this.AdE.getTextOpListener().mo24351fC(false);
        }
        mo31142rk(true);
        AppMethodBeat.m2505o(63055);
    }

    /* renamed from: QA */
    public final synchronized void mo28398QA(int i) {
        AppMethodBeat.m2504i(63056);
        C16067a c16067a;
        if (C40619x.m70075gu(this.Aaj.f3007Gn)) {
            if (!this.Aaj.AeC) {
                c16067a = this.Aaj;
                c16067a.AeC = true;
                c16067a.AeD = false;
            }
        } else if (!this.Aaj.AeD) {
            c16067a = this.Aaj;
            c16067a.AeD = true;
            c16067a.AeC = false;
        }
        C4990ab.m7416i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "catch Size & start deal");
        if (i > 0) {
            this.mView.post(new C170724());
        }
        AppMethodBeat.m2505o(63056);
    }

    /* renamed from: NJ */
    public final void mo31131NJ(int i) {
        AppMethodBeat.m2504i(63057);
        if (i > 0) {
            int i2;
            C4990ab.m7416i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "tab size changed ,so adjusting tab site.");
            C16067a c16067a = this.Aaj;
            String str = c16067a.Aeq;
            if (c16067a.AeE != null) {
                i2 = 0;
                while (i2 < c16067a.AeE.size()) {
                    C44418a c44418a = (C44418a) c16067a.AeE.get(i2);
                    if (c44418a != null && c44418a.kWz.equals(str)) {
                        break;
                    }
                    i2++;
                }
            }
            i2 = 0;
            setTabSelected(i2);
        }
        AppMethodBeat.m2505o(63057);
    }

    public final void dNg() {
        AppMethodBeat.m2504i(63058);
        this.AdH = false;
        this.mHandler.removeMessages(1102);
        this.mHandler.sendEmptyMessageDelayed(1102, 100);
        AppMethodBeat.m2505o(63058);
    }

    static /* synthetic */ void dNh() {
        AppMethodBeat.m2504i(63062);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_CAPTURE_TAB_RED_DOT_BOOLEAN, Boolean.TRUE);
        }
        AppMethodBeat.m2505o(63062);
    }
}
