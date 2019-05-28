package com.tencent.p177mm.p612ui;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1441a;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1099x.C16107a.C16108a;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p1527d.C37477b;
import com.tencent.p177mm.p190at.p191a.p193c.C9014g;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p199ax.C1301c;
import com.tencent.p177mm.p199ax.C32321b;
import com.tencent.p177mm.p199ax.C6328d.C6329a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p230g.p231a.C18296ik;
import com.tencent.p177mm.p230g.p231a.C45367sp;
import com.tencent.p177mm.p230g.p231a.C6533on;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.IconPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.contact.AddressUI;
import com.tencent.p177mm.p612ui.tools.C44385r;
import com.tencent.p177mm.p612ui.widget.listview.PullDownListView;
import com.tencent.p177mm.p612ui.widget.listview.PullDownListView.C30804a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.account.p765a.p1216b.C32921a;
import com.tencent.p177mm.plugin.appbrand.p326n.C33459c;
import com.tencent.p177mm.plugin.appbrand.p326n.C33459c.C33460a;
import com.tencent.p177mm.plugin.boots.p348a.C20015c;
import com.tencent.p177mm.plugin.boots.p348a.C27502b;
import com.tencent.p177mm.plugin.card.p1243c.C33762b;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.p1140r.C16841a;
import com.tencent.p177mm.plugin.p754x.p755a.C46480a;
import com.tencent.p177mm.plugin.p754x.p755a.p756a.C7233a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.setting.p505ui.setting.SelfQRCodeUI;
import com.tencent.p177mm.plugin.story.api.AbsStoryGallery;
import com.tencent.p177mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.p177mm.plugin.story.api.C35168e;
import com.tencent.p177mm.plugin.story.api.C35171g;
import com.tencent.p177mm.plugin.story.api.C46269m.C29273a;
import com.tencent.p177mm.plugin.story.api.C46270n;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.welab.p1072a.p1073a.C14714c;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.p597ui.preference.AccountInfoPreference;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C36001bm;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.UUID;

/* renamed from: com.tencent.mm.ui.MoreTabUI */
public class MoreTabUI extends AbstractTabChildPreference implements C35171g, C4937b {
    private View contentView;
    private C15541f ehK;
    private boolean lZa = false;
    private RelativeLayout oZf = null;
    private AbsStoryGallery plq = null;
    private AbsStoryMuteView plr = null;
    private View plw;
    private boolean pnR = false;
    private byte[] qkE = null;
    private C16108a qpv = new C303441();
    private Bitmap svw = null;
    private int yoA = C1338a.fromDPToPix(getContext(), 120);
    public C30804a yoB = new C2354310();
    private C23551a yoC = new C23551a();
    private ImageView yog;
    PullDownListView yoh;
    private View yoi = null;
    private C30343b yoj = new C30343b(this, (byte) 0);
    private boolean yok = false;
    private AccountInfoPreference yol = null;
    private boolean yom = false;
    private RelativeLayout yon = null;
    private FrameLayout yoo = null;
    private int yop = 0;
    private int yoq = 0;
    private int yor = 0;
    private int yos = 0;
    private boolean yot = false;
    private boolean you = false;
    private boolean yov = false;
    public boolean yow = true;
    private boolean yox = true;
    public boolean yoy = true;
    private int yoz = C1338a.fromDPToPix(getContext(), 48);

    /* renamed from: com.tencent.mm.ui.MoreTabUI$10 */
    class C2354310 implements C30804a {

        /* renamed from: com.tencent.mm.ui.MoreTabUI$10$1 */
        class C235441 implements Runnable {
            C235441() {
            }

            public final void run() {
                AppMethodBeat.m2504i(29703);
                MoreTabUI.m48354p(MoreTabUI.this);
                MoreTabUI.m48333a(MoreTabUI.this, 0);
                MoreTabUI.m48338b(MoreTabUI.this, MoreTabUI.this.pnR);
                if (MoreTabUI.this.yoi != null) {
                    MoreTabUI.this.yoi.setTranslationY(0.0f);
                }
                AppMethodBeat.m2505o(29703);
            }
        }

        C2354310() {
        }

        /* renamed from: jM */
        public final void mo36936jM(boolean z) {
            AppMethodBeat.m2504i(29704);
            String str = "MicroMsg.MoreTabUI";
            String str2 = "story_cat onPostOpen, storyGallery is null?:%s";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(MoreTabUI.this.plq == null);
            C4990ab.m7417i(str, str2, objArr);
            if (MoreTabUI.this.plq != null) {
                C22212h c22212h = C22212h.scu;
                C22212h.cAs().cYQ = 1;
                c22212h = C22212h.scu;
                C22212h.cAs().cZT = 1;
                MoreTabUI.this.plq.mo55932K(z, true);
                MoreTabUI.m48333a(MoreTabUI.this, 8);
                MoreTabUI.m48348j(MoreTabUI.this);
                MoreTabUI.m48349k(MoreTabUI.this);
            }
            MoreTabUI.this.yok = true;
            MoreTabUI.m48350l(MoreTabUI.this);
            if (!(MoreTabUI.this.pnR || MoreTabUI.this.yot)) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_STORY_PULL_DOWN_COUNT_INT, Integer.valueOf(C1720g.m3536RP().mo5239Ry().getInt(C5127a.USERINFO_STORY_PULL_DOWN_COUNT_INT, 0) + 1));
                MoreTabUI.m48353o(MoreTabUI.this);
            }
            AppMethodBeat.m2505o(29704);
        }

        public final void caI() {
            AppMethodBeat.m2504i(29705);
            String str = "MicroMsg.MoreTabUI";
            String str2 = "story_cat onPostClose, storyGallery is null?:%s";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(MoreTabUI.this.plq == null);
            C4990ab.m7417i(str, str2, objArr);
            if (MoreTabUI.this.plq != null) {
                MoreTabUI.this.plq.mo55945lr(true);
                MoreTabUI.this.plq.post(new C235441());
            }
            MoreTabUI.this.yok = false;
            MoreTabUI.m48359r(MoreTabUI.this);
            MoreTabUI.this.yoj.caH();
            if (MoreTabUI.this.you && !MoreTabUI.this.pnR) {
                long currentTimeMillis = System.currentTimeMillis();
                C22212h c22212h = C22212h.scu;
                C22212h.m33899lq(currentTimeMillis);
                c22212h = C22212h.scu;
                C22212h.cAJ().cZm = currentTimeMillis;
            }
            AppMethodBeat.m2505o(29705);
        }

        public final void caJ() {
            AppMethodBeat.m2504i(29706);
            if (MoreTabUI.this.plq != null) {
                MoreTabUI.this.plq.cwK();
            }
            if (MoreTabUI.this.you && !MoreTabUI.this.pnR) {
                C22212h c22212h = C22212h.scu;
                C22212h.cAJ().cZY = System.currentTimeMillis();
                c22212h = C22212h.scu;
                C22212h.cAK();
            }
            AppMethodBeat.m2505o(29706);
        }

        public final void caK() {
            AppMethodBeat.m2504i(29707);
            if (MoreTabUI.this.plq != null) {
                MoreTabUI.this.plq.cwL();
            }
            AppMethodBeat.m2505o(29707);
        }

        public final void caL() {
            AppMethodBeat.m2504i(29708);
            C4990ab.m7416i("MicroMsg.MoreTabUI", "story_cat onMuteIn");
            MoreTabUI.this.plr.cwM();
            AppMethodBeat.m2505o(29708);
        }

        public final void caM() {
            AppMethodBeat.m2504i(29709);
            MoreTabUI.this.plr.cwN();
            AppMethodBeat.m2505o(29709);
        }

        /* renamed from: AU */
        public final void mo36928AU(int i) {
            AppMethodBeat.m2504i(29710);
            if (MoreTabUI.this.plq != null) {
                MoreTabUI.this.plq.mo55929EF(i);
            }
            AppMethodBeat.m2505o(29710);
        }

        /* renamed from: AV */
        public final void mo36929AV(int i) {
            AppMethodBeat.m2504i(29711);
            if (MoreTabUI.this.plq != null) {
                MoreTabUI.this.plq.mo55930EG(i);
            }
            AppMethodBeat.m2505o(29711);
        }

        /* renamed from: AW */
        public final void mo36930AW(int i) {
            AppMethodBeat.m2504i(29712);
            if (MoreTabUI.this.plq != null) {
                MoreTabUI.this.plq.mo55928AW(i);
            }
            AppMethodBeat.m2505o(29712);
        }
    }

    /* renamed from: com.tencent.mm.ui.MoreTabUI$2 */
    class C235452 implements Runnable {
        C235452() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29690);
            MoreTabUI.this.yoh.dLf();
            AppMethodBeat.m2505o(29690);
        }
    }

    /* renamed from: com.tencent.mm.ui.MoreTabUI$4 */
    class C235464 implements OnScrollListener {
        C235464() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.ui.MoreTabUI$a */
    class C23551a implements C1202f {
        C23551a() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        }
    }

    /* renamed from: com.tencent.mm.ui.MoreTabUI$3 */
    class C303413 implements OnClickListener {
        C303413() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(29691);
            C4990ab.m7416i("MicroMsg.MoreTabUI", "onClick: mActionBarRoot");
            if (MoreTabUI.this.lZa) {
                C23639t.makeText(MoreTabUI.this.getContext(), MoreTabUI.this.getResources().getString(C25738R.string.et4), 0).show();
                AppMethodBeat.m2505o(29691);
                return;
            }
            if (MoreTabUI.this.yoh != null && MoreTabUI.this.yoh.isVisible) {
                MoreTabUI.this.yoh.dLg();
            }
            AppMethodBeat.m2505o(29691);
        }
    }

    /* renamed from: com.tencent.mm.ui.MoreTabUI$b */
    class C30343b {
        private int status;

        private C30343b() {
            this.status = 2;
        }

        /* synthetic */ C30343b(MoreTabUI moreTabUI, byte b) {
            this();
        }

        public final void caH() {
            AppMethodBeat.m2504i(29714);
            if (MoreTabUI.this.getActivity() == null) {
                AppMethodBeat.m2505o(29714);
                return;
            }
            switch (this.status) {
                case 0:
                    MoreTabUI.this.yoh.setBackgroundResource(C25738R.drawable.f6878u4);
                    MoreTabUI.this.yoh.setSupportOverscroll(MoreTabUI.this.pnR);
                    MoreTabUI.this.yot = false;
                    MoreTabUI.this.yor = C1338a.m2857am(MoreTabUI.this.getContext(), C25738R.dimen.a7h);
                    if (MoreTabUI.this.plq != null) {
                        ((LayoutParams) MoreTabUI.this.plq.getLayoutParams()).topMargin = MoreTabUI.this.yos;
                        MoreTabUI.this.yoh.mo49263x(MoreTabUI.this.plq, MoreTabUI.this.yor, MoreTabUI.this.yos);
                    }
                    MoreTabUI.this.yoh.setMuteView(MoreTabUI.this.plr);
                    MoreTabUI.m48340c(MoreTabUI.this, MoreTabUI.this.pnR);
                    MoreTabUI.m48333a(MoreTabUI.this, 0);
                    MoreTabUI.m48338b(MoreTabUI.this, MoreTabUI.this.pnR);
                    if (MoreTabUI.this.yol != null) {
                        MoreTabUI.this.yol.mo27300ad(MoreTabUI.this.pnR, MoreTabUI.this.yot);
                        AppMethodBeat.m2505o(29714);
                        return;
                    }
                    break;
                case 1:
                    MoreTabUI.this.yoh.setSupportOverscroll(true);
                    MoreTabUI.m48353o(MoreTabUI.this);
                    if (MoreTabUI.this.yot) {
                        MoreTabUI.this.yoh.setBackgroundResource(C25738R.drawable.f6879u6);
                    } else {
                        MoreTabUI.this.yoh.setBackgroundResource(C25738R.drawable.f6878u4);
                    }
                    if (MoreTabUI.this.plq != null) {
                        ((LayoutParams) MoreTabUI.this.plq.getLayoutParams()).topMargin = MoreTabUI.this.yoq;
                        MoreTabUI.this.yoh.mo49263x(MoreTabUI.this.plq, MoreTabUI.this.yor, MoreTabUI.this.yoq);
                    }
                    MoreTabUI.this.yoh.setMuteView(null);
                    MoreTabUI.m48340c(MoreTabUI.this, MoreTabUI.this.pnR);
                    MoreTabUI.m48333a(MoreTabUI.this, 0);
                    MoreTabUI.m48338b(MoreTabUI.this, MoreTabUI.this.pnR);
                    if (MoreTabUI.this.yol != null) {
                        MoreTabUI.this.yol.mo27300ad(MoreTabUI.this.pnR, MoreTabUI.this.yot);
                        AppMethodBeat.m2505o(29714);
                        return;
                    }
                    break;
                case 2:
                    MoreTabUI.this.yoh.setBackgroundResource(C25738R.drawable.f6879u6);
                    MoreTabUI.this.yoh.setSupportOverscroll(MoreTabUI.this.pnR);
                    MoreTabUI.m48340c(MoreTabUI.this, MoreTabUI.this.pnR);
                    MoreTabUI.m48348j(MoreTabUI.this);
                    if (MoreTabUI.this.yol != null) {
                        MoreTabUI.this.yol.mo27300ad(MoreTabUI.this.pnR, MoreTabUI.this.yot);
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(29714);
        }

        public final void dyU() {
            AppMethodBeat.m2504i(29715);
            if (!C46270n.isShowStoryCheck() || MoreTabUI.this.lZa) {
                MoreTabUI.this.pnR = false;
                this.status = 2;
            } else if (((C35168e) C1720g.m3530M(C35168e.class)).isStoryExist(C1853r.m3846Yz())) {
                MoreTabUI.this.pnR = true;
                this.status = 0;
            } else {
                MoreTabUI.this.pnR = false;
                this.status = 1;
            }
            C4990ab.m7417i("MicroMsg.MoreTabUI", "checkStoryStatus status=%s", Integer.valueOf(this.status));
            caH();
            AppMethodBeat.m2505o(29715);
        }

        /* renamed from: Nr */
        public final void mo48653Nr(int i) {
            AppMethodBeat.m2504i(29716);
            C4990ab.m7417i("MicroMsg.MoreTabUI", "forceToStatus %s", Integer.valueOf(i));
            if (i == 0) {
                MoreTabUI.this.pnR = true;
            } else {
                MoreTabUI.this.pnR = false;
            }
            this.status = i;
            caH();
            AppMethodBeat.m2505o(29716);
        }
    }

    /* renamed from: com.tencent.mm.ui.MoreTabUI$1 */
    class C303441 implements C16108a {
        C303441() {
        }

        /* renamed from: p */
        public final void mo25292p(int i, String str) {
            AppMethodBeat.m2504i(29688);
            if (i == 262145 || i == 266260 || i == 262157 || i == 266267 || i == 262158) {
                MoreTabUI.m48332a(MoreTabUI.this);
                MoreTabUI.m48337b(MoreTabUI.this);
            } else if (i == 262147) {
                MoreTabUI.m48339c(MoreTabUI.this);
            } else if (i == 262156) {
                MoreTabUI.m48341d(MoreTabUI.this);
            } else if (i == 262152) {
                MoreTabUI.m48343e(MoreTabUI.this);
            } else if (i == 352279) {
                MoreTabUI.m48334a(MoreTabUI.this, str);
            }
            MoreTabUI.this.ehK.notifyDataSetChanged();
            AppMethodBeat.m2505o(29688);
        }

        /* renamed from: b */
        public final void mo25291b(C5127a c5127a) {
            AppMethodBeat.m2504i(29689);
            if (c5127a == C5127a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC) {
                MoreTabUI.m48343e(MoreTabUI.this);
            } else if (c5127a == C5127a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC) {
                MoreTabUI.m48343e(MoreTabUI.this);
            } else if (c5127a == C5127a.NEW_BANDAGE_DATASOURCE_WALLET_MORE_TAB_STRING_SYNC || c5127a == C5127a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC) {
                MoreTabUI.m48341d(MoreTabUI.this);
            } else if (c5127a == C5127a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC) {
                MoreTabUI.m48332a(MoreTabUI.this);
            }
            MoreTabUI.this.ehK.notifyDataSetChanged();
            AppMethodBeat.m2505o(29689);
        }
    }

    /* renamed from: com.tencent.mm.ui.MoreTabUI$7 */
    class C303457 implements OnClickListener {
        C303457() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(29698);
            if (MoreTabUI.this.lZa) {
                C23639t.makeText(MoreTabUI.this.getContext(), MoreTabUI.this.getResources().getString(C25738R.string.et4), 0).show();
                AppMethodBeat.m2505o(29698);
                return;
            }
            if (MoreTabUI.this.yoh != null) {
                MoreTabUI.this.yoh.dLg();
            }
            AppMethodBeat.m2505o(29698);
        }
    }

    /* renamed from: com.tencent.mm.ui.MoreTabUI$8 */
    class C303468 implements OnClickListener {
        C303468() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(29699);
            C7060h.pYm.mo8381e(11264, Integer.valueOf(1));
            MoreTabUI.this.startActivity(new Intent(MoreTabUI.this.getContext(), SelfQRCodeUI.class));
            AppMethodBeat.m2505o(29699);
        }
    }

    public MoreTabUI() {
        AppMethodBeat.m2504i(29717);
        AppMethodBeat.m2505o(29717);
    }

    /* renamed from: a */
    static /* synthetic */ void m48332a(MoreTabUI moreTabUI) {
        AppMethodBeat.m2504i(29754);
        moreTabUI.dyN();
        AppMethodBeat.m2505o(29754);
    }

    /* renamed from: b */
    static /* synthetic */ void m48337b(MoreTabUI moreTabUI) {
        AppMethodBeat.m2504i(29755);
        moreTabUI.dyL();
        AppMethodBeat.m2505o(29755);
    }

    /* renamed from: c */
    static /* synthetic */ void m48339c(MoreTabUI moreTabUI) {
        AppMethodBeat.m2504i(29756);
        moreTabUI.dyO();
        AppMethodBeat.m2505o(29756);
    }

    /* renamed from: d */
    static /* synthetic */ void m48341d(MoreTabUI moreTabUI) {
        AppMethodBeat.m2504i(29757);
        moreTabUI.dyQ();
        AppMethodBeat.m2505o(29757);
    }

    /* renamed from: e */
    static /* synthetic */ void m48343e(MoreTabUI moreTabUI) {
        AppMethodBeat.m2504i(29758);
        moreTabUI.dyM();
        AppMethodBeat.m2505o(29758);
    }

    /* renamed from: l */
    static /* synthetic */ void m48350l(MoreTabUI moreTabUI) {
        AppMethodBeat.m2504i(29763);
        moreTabUI.dyS();
        AppMethodBeat.m2505o(29763);
    }

    /* renamed from: o */
    static /* synthetic */ void m48353o(MoreTabUI moreTabUI) {
        AppMethodBeat.m2504i(29764);
        moreTabUI.dyK();
        AppMethodBeat.m2505o(29764);
    }

    /* renamed from: p */
    static /* synthetic */ void m48354p(MoreTabUI moreTabUI) {
        AppMethodBeat.m2504i(29765);
        moreTabUI.caE();
        AppMethodBeat.m2505o(29765);
    }

    /* renamed from: r */
    static /* synthetic */ void m48359r(MoreTabUI moreTabUI) {
        AppMethodBeat.m2504i(29767);
        moreTabUI.dyT();
        AppMethodBeat.m2505o(29767);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(29718);
        super.onCreate(bundle);
        if (!C9638aw.m17179RK() || C9638aw.m17178QT()) {
            C4990ab.m7413e("MicroMsg.MoreTabUI", "Create MoreTabUI when accready:%b ishold:%b", Boolean.valueOf(C9638aw.m17179RK()), Boolean.valueOf(C9638aw.m17178QT()));
            AppMethodBeat.m2505o(29718);
            return;
        }
        dyK();
        m48356pT(false);
        AppMethodBeat.m2505o(29718);
    }

    public void onResume() {
        AppMethodBeat.m2504i(29719);
        super.onResume();
        C4990ab.m7416i("MicroMsg.MoreTabUI", "onResume: ");
        dyK();
        if (this.you) {
            long currentTimeMillis = System.currentTimeMillis();
            C22212h c22212h = C22212h.scu;
            C22212h.m33899lq(currentTimeMillis);
            c22212h = C22212h.scu;
            C22212h.cAJ().cZm = currentTimeMillis;
        }
        AppMethodBeat.m2505o(29719);
    }

    public void onPause() {
        AppMethodBeat.m2504i(29720);
        super.onPause();
        C4990ab.m7416i("MicroMsg.MoreTabUI", "onPause: ");
        if (this.you) {
            C22212h c22212h = C22212h.scu;
            C22212h.cAK();
        }
        AppMethodBeat.m2505o(29720);
    }

    private void dyK() {
        AppMethodBeat.m2504i(29721);
        if (!this.yot) {
            int i = C1720g.m3536RP().mo5239Ry().getInt(C5127a.USERINFO_STORY_PULL_DOWN_COUNT_INT, 0);
            boolean z = C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_STORY_CAPTURE_FIRST_BOOLEAN_SYNC, false);
            C4990ab.m7417i("MicroMsg.MoreTabUI", "checkSmallHead: %s", Integer.valueOf(i));
            if (!this.pnR && (z || i > 0)) {
                this.yot = true;
                if (this.yol != null) {
                    this.yol.mo27300ad(this.pnR, this.yot);
                }
                if (this.yot) {
                    i = C1338a.m2857am(getContext(), C25738R.dimen.a7i);
                } else {
                    i = C1338a.m2857am(getContext(), C25738R.dimen.a7h);
                }
                this.yor = i;
            }
        }
        AppMethodBeat.m2505o(29721);
    }

    /* renamed from: JC */
    public final int mo48647JC() {
        return C25738R.xml.f8518b3;
    }

    public boolean supportNavigationSwipeBack() {
        return false;
    }

    public boolean noActionBar() {
        return true;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(29722);
        super.onDestroy();
        AppMethodBeat.m2505o(29722);
    }

    public void onActivityCreated(Bundle bundle) {
        AppMethodBeat.m2504i(29723);
        C4990ab.m7416i("MicroMsg.MoreTabUI", "onActivityCreated");
        super.onActivityCreated(bundle);
        this.ehK = this.yCw;
        this.ehK.mo27715ce("more_setting", true);
        this.ehK.mo27715ce("settings_emoji_store", true);
        this.ehK.mo27715ce("settings_mm_wallet", true);
        this.ehK.mo27715ce("settings_mm_cardpackage", true);
        this.ehK.mo27715ce("settings_mm_favorite", true);
        this.ehK.mo27715ce("settings_my_album", true);
        this.ehK.mo27715ce("settings_my_address", true);
        this.ehK.mo27715ce("more_tab_setting_personal_info", true);
        this.ehK.mo27715ce("more_uishow", true);
        this.ehK.mo27715ce("settings_privacy_agreements", true);
        this.yoi = getView().getRootView().findViewById(2131820634);
        this.oZf = (RelativeLayout) findViewById(2131826058);
        this.yog = (ImageView) findViewById(2131826061);
        this.yon = (RelativeLayout) findViewById(2131826059);
        this.yoo = (FrameLayout) findViewById(2131826060);
        this.yoh = (PullDownListView) this.nDp;
        this.yoh.setTabView(this.yoi);
        this.yoh.setBackgroundResource(C25738R.drawable.f6878u4);
        this.yoh.setOnScrollListener(new C235464());
        AppMethodBeat.m2505o(29723);
    }

    /* renamed from: a */
    public final boolean mo48649a(C15541f c15541f, Preference preference, View view) {
        AppMethodBeat.m2504i(29724);
        if (C1720g.m3531RK()) {
            boolean pS;
            try {
                if (C5047bp.dnM() || C5047bp.dpJ() || C5047bp.dpL() || C5058f.IS_FLAVOR_RED) {
                    if (C5046bo.nullAsNil(preference.mKey).equals("settings_emoji_store")) {
                        pS = m48355pS(true);
                        AppMethodBeat.m2505o(29724);
                        return pS;
                    } else if (C5046bo.nullAsNil(preference.mKey).equals("more_setting")) {
                        pS = m48355pS(false);
                        AppMethodBeat.m2505o(29724);
                        return pS;
                    }
                }
            } catch (ActivityNotFoundException e) {
            }
            pS = super.mo48649a(c15541f, preference, view);
            AppMethodBeat.m2505o(29724);
            return pS;
        }
        C4990ab.m7420w("MicroMsg.MoreTabUI", "account has not already!");
        AppMethodBeat.m2505o(29724);
        return true;
    }

    /* renamed from: a */
    public final boolean mo48648a(C15541f c15541f, Preference preference) {
        String str;
        AppMethodBeat.m2504i(29725);
        String str2 = "MicroMsg.MoreTabUI";
        StringBuilder stringBuilder = new StringBuilder();
        if (preference == null) {
            str = BuildConfig.COMMAND;
        } else {
            str = preference.mKey;
        }
        C4990ab.m7416i(str2, stringBuilder.append(str).append(" item has been clicked!").toString());
        Intent intent;
        boolean bY;
        int i;
        if (!C1720g.m3531RK()) {
            C4990ab.m7420w("MicroMsg.MoreTabUI", "account has not already!");
            AppMethodBeat.m2505o(29725);
            return true;
        } else if (preference.mKey.equals("settings_my_address")) {
            intent = new Intent(getContext(), AddressUI.class);
            intent.putExtra("Contact_GroupFilter_Type", "@biz.contact");
            startActivity(intent);
            AppMethodBeat.m2505o(29725);
            return true;
        } else if (preference.mKey.equals("settings_my_add_contact")) {
            C25985d.m41467b(getContext(), "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
            AppMethodBeat.m2505o(29725);
            return true;
        } else if (preference.mKey.equals("settings_mm_wallet")) {
            boolean bX = C16112c.m24429PK().mo28551bX(262156, 266248);
            bY = C16112c.m24429PK().mo28552bY(262156, 266248);
            C7060h.pYm.mo8374X(10958, "9");
            C7060h c7060h = C7060h.pYm;
            Object[] objArr = new Object[1];
            i = (bX || bY) ? 1 : 0;
            objArr[0] = Integer.valueOf(i);
            c7060h.mo8381e(13341, objArr);
            C7060h.pYm.mo8381e(14419, UUID.randomUUID().toString(), Integer.valueOf(0));
            C6533on c6533on = new C6533on();
            c6533on.cKQ.context = getContext();
            Intent intent2 = new Intent();
            intent2.putExtra("key_wallet_has_red", bY);
            intent2.putExtra("key_uuid", str);
            c6533on.cKQ.intent = intent2;
            C4879a.xxA.mo10055m(c6533on);
            C16112c.m24429PK().mo28553bZ(262156, 266248);
            C16112c.m24429PK().mo28554c(C5127a.NEW_BANDAGE_DATASOURCE_WALLET_MORE_TAB_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_LQT_WALLET_RED_DOT_WORDING_STRING, (Object) "");
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_LQT_WALLET_RED_DOT_INT, Integer.valueOf(-1));
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_MY_ENTRY_REDDOT_BOOLEAN_SYNC, Boolean.FALSE);
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_ENTRY_WORDING_STRING_SYNC, (Object) "");
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_MY_ENTRY_TAB_REDDOT_BOOLEAN_SYNC, Boolean.FALSE);
            C16112c.m24429PK().mo28554c(C5127a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, C5127a.USERINFO_NEW_BANDAGE_WATCHER_PAY_ENTRANCE_STRING_SYNC);
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_New_MY_ENTRY_WORDING_STRING_SYNC, (Object) "");
            c7060h = C7060h.pYm;
            objArr = new Object[5];
            objArr[0] = Integer.valueOf(6);
            objArr[1] = Integer.valueOf(bY ? 1 : 0);
            objArr[2] = "";
            objArr[3] = "";
            objArr[4] = Integer.valueOf(0);
            c7060h.mo8381e(14872, objArr);
            AppMethodBeat.m2505o(29725);
            return true;
        } else if (preference.mKey.equals("settings_mm_cardpackage")) {
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, (Object) "");
            new Intent().putExtra("key_from_scene", 22);
            C4990ab.m7416i("MicroMsg.MoreTabUI", "enter to cardhome");
            C18296ik c18296ik = new C18296ik();
            c18296ik.cDz.context = getContext();
            c18296ik.cDz.cDB = 1;
            C4879a.xxA.mo10055m(c18296ik);
            AppMethodBeat.m2505o(29725);
            return true;
        } else if (preference.mKey.equals("settings_my_album")) {
            C9638aw.m17190ZK();
            if (C18628c.isSDCardAvailable()) {
                C9638aw.m17190ZK();
                str = (String) C18628c.m29072Ry().get(2, null);
                Intent intent3 = new Intent(getContext(), AlbumUI.class);
                intent3.putExtra("sns_userName", str);
                intent3.putExtra("username", str);
                intent3.putExtra("story_dot", this.yov);
                intent3.setFlags(536870912);
                intent3.addFlags(67108864);
                C9638aw.m17190ZK();
                i = C42252ah.m74625i((Integer) C18628c.m29072Ry().get(68389, null));
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(68389, Integer.valueOf(i + 1));
                startActivity(intent3);
                AppMethodBeat.m2505o(29725);
                return true;
            }
            C23639t.m36492hO(getContext());
            AppMethodBeat.m2505o(29725);
            return true;
        } else if (preference.mKey.equals("settings_mm_favorite")) {
            C7060h.pYm.mo8374X(10958, "8");
            C7060h.pYm.mo8381e(14103, Integer.valueOf(0));
            C39037b.m66371b(getContext(), ".ui.FavoriteIndexUI", new Intent());
            C45287c.aNX();
            AppMethodBeat.m2505o(29725);
            return true;
        } else if (preference.mKey.equals("settings_emoji_store")) {
            C7060h.pYm.mo8374X(10958, "7");
            C16112c.m24429PK().mo28553bZ(262147, 266244);
            C16112c.m24429PK().mo28553bZ(262149, 266244);
            intent = new Intent();
            intent.putExtra("preceding_scence", 2);
            C25985d.m41467b(getContext(), "emoji", ".ui.v2.EmojiStoreV2UI", intent);
            C7060h.pYm.mo8381e(12065, Integer.valueOf(1));
            ((C20015c) C1720g.m3528K(C20015c.class)).mo6742dC(C27502b.jJo, 881);
            AppMethodBeat.m2505o(29725);
            return true;
        } else if (preference.mKey.equals("more_setting")) {
            bY = C16112c.m24429PK().mo28551bX(262145, 266242);
            C16112c.m24429PK().mo28553bZ(262145, 266242);
            C16112c.m24429PK().mo28553bZ(262157, 266261);
            C16112c.m24429PK().mo28553bZ(262158, 266264);
            C16112c.m24429PK().mo28547b(C5127a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, 266242);
            C25985d.m41467b(getContext(), "setting", ".ui.setting.SettingsUI", new Intent());
            C9638aw.m17190ZK();
            int intValue = ((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_SETTING_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(0))).intValue();
            C9638aw.m17190ZK();
            i = ((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_SETTING_RED_DOT_DID_SHOW_ID_INT, Integer.valueOf(0))).intValue();
            if (!bY && intValue > i) {
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_SETTING_RED_DOT_DID_SHOW_ID_INT, Integer.valueOf(intValue));
                IconPreference iconPreference = (IconPreference) c15541f.aqO("more_setting");
                if (iconPreference != null) {
                    iconPreference.mo48765NN(8);
                }
                C16112c.m24429PK().mo28553bZ(266260, 266241);
            }
            AppMethodBeat.m2505o(29725);
            return true;
        } else if (preference.mKey.equals("more_uishow")) {
            C1720g.m3528K(C7233a.class);
            getContext();
            intent = new Intent();
            AppMethodBeat.m2505o(29725);
            return true;
        } else if (preference.mKey.equals("settings_privacy_agreements")) {
            C32921a.m53856b(getActivity(), getString(C25738R.string.g7o, C4988aa.dor(), C1720g.m3536RP().mo5239Ry().get(274436, null), "setting", Integer.valueOf(0), Integer.valueOf(0)), 0, true);
            AppMethodBeat.m2505o(29725);
            return true;
        } else {
            AppMethodBeat.m2505o(29725);
            return false;
        }
    }

    private void dyL() {
        AppMethodBeat.m2504i(29726);
        if (C25985d.afj("sns")) {
            this.ehK.mo27715ce("settings_my_album", false);
            IconPreference iconPreference = (IconPreference) this.ehK.aqO("settings_my_album");
            if (iconPreference != null) {
                if (C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_STORY_NEED_DISPLAY_ALBUM_GUIDE_BOOLEAN_SYNC, true) && this.yov) {
                    iconPreference.mo48765NN(0);
                    AppMethodBeat.m2505o(29726);
                    return;
                }
                this.yov = false;
                iconPreference.mo48765NN(8);
            }
            AppMethodBeat.m2505o(29726);
            return;
        }
        this.ehK.mo27715ce("settings_my_album", true);
        AppMethodBeat.m2505o(29726);
    }

    private void dyM() {
        AppMethodBeat.m2504i(29727);
        C33762b c33762b = (C33762b) C1720g.m3528K(C33762b.class);
        if (c33762b == null || !((c33762b.bbn() || c33762b.bbo()) && C25985d.afj("card"))) {
            this.ehK.mo27715ce("settings_mm_cardpackage", true);
            AppMethodBeat.m2505o(29727);
            return;
        }
        String bbp;
        String str = "";
        if (c33762b != null) {
            bbp = c33762b.bbp();
        } else {
            bbp = str;
        }
        boolean bY = C16112c.m24429PK().mo28552bY(262152, 266256);
        boolean bX = C16112c.m24429PK().mo28551bX(262152, 266256);
        boolean a = C16112c.m24429PK().mo28546a(C5127a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_REDDOT_WORDING_STRING_SYNC);
        boolean a2 = C16112c.m24429PK().mo28546a(C5127a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_ICON_STRING_SYNC);
        this.ehK.mo27715ce("settings_mm_cardpackage", false);
        final IconPreference iconPreference = (IconPreference) this.ehK.aqO("settings_mm_cardpackage");
        if (iconPreference == null) {
            AppMethodBeat.m2505o(29727);
            return;
        }
        iconPreference.setTitle((int) C25738R.string.e8b);
        if (bX) {
            iconPreference.mo48763NL(0);
            iconPreference.mo48774ey(getString(C25738R.string.f9181s0), C25738R.drawable.f6940w3);
            iconPreference.mo48765NN(8);
            iconPreference.setSummary(null);
            iconPreference.mo48770ap(null);
            iconPreference.mo48767NP(8);
            iconPreference.mo48775ez("", -1);
            iconPreference.mo48764NM(8);
            AppMethodBeat.m2505o(29727);
            return;
        }
        C9638aw.m17190ZK();
        str = (String) C18628c.m29072Ry().get(C5127a.USERINFO_CARD_REDOT_ICON_URL_STRING_SYNC, (Object) "");
        if (!a2 || TextUtils.isEmpty(str)) {
            iconPreference.mo48770ap(null);
            iconPreference.mo48767NP(8);
        } else {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(C25738R.dimen.f10242vj);
            C17927a c17927a = new C17927a();
            c17927a.ePK = C6457e.eSn;
            C32291o.ahq();
            c17927a.ePY = null;
            c17927a.ePH = true;
            c17927a.eQf = true;
            c17927a.ePF = true;
            c17927a.ePO = dimensionPixelOffset;
            c17927a.ePN = dimensionPixelOffset;
            C32291o.ahp().mo43767a(str, iconPreference.dAz(), c17927a.ahG(), new C9014g() {

                /* renamed from: com.tencent.mm.ui.MoreTabUI$5$3 */
                class C154753 implements Runnable {
                    C154753() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(29694);
                        iconPreference.mo48770ap(null);
                        iconPreference.mo48767NP(8);
                        AppMethodBeat.m2505o(29694);
                    }
                }

                /* renamed from: com.tencent.mm.ui.MoreTabUI$5$1 */
                class C235481 implements Runnable {
                    C235481() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(29692);
                        iconPreference.mo48767NP(0);
                        iconPreference.mo48766NO(C25738R.drawable.bcm);
                        AppMethodBeat.m2505o(29692);
                    }
                }

                /* renamed from: sH */
                public final void mo7596sH(String str) {
                    AppMethodBeat.m2504i(29695);
                    C5004al.m7441d(new C235481());
                    AppMethodBeat.m2505o(29695);
                }

                /* renamed from: a */
                public final Bitmap mo7594a(String str, View view, C37477b c37477b) {
                    return null;
                }

                /* renamed from: b */
                public final void mo7595b(String str, View view, C37477b c37477b) {
                    AppMethodBeat.m2504i(29696);
                    if (c37477b.bitmap != null) {
                        final Bitmap bitmap = c37477b.bitmap;
                        C5004al.m7441d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(29693);
                                iconPreference.mo48770ap(bitmap);
                                iconPreference.mo48767NP(0);
                                AppMethodBeat.m2505o(29693);
                            }
                        });
                        AppMethodBeat.m2505o(29696);
                        return;
                    }
                    C5004al.m7441d(new C154753());
                    AppMethodBeat.m2505o(29696);
                }
            });
        }
        if (bY) {
            iconPreference.mo48765NN(0);
        } else {
            iconPreference.mo48765NN(8);
        }
        if (a) {
            iconPreference.mo48774ey("", -1);
            iconPreference.mo48763NL(8);
            if (a2) {
                iconPreference.setSummary(null);
                if (C42252ah.isNullOrNil(bbp)) {
                    iconPreference.mo48775ez("", -1);
                    iconPreference.mo48764NM(8);
                } else {
                    iconPreference.mo48771av(bbp, -1, getResources().getColor(C25738R.color.f12092s0));
                    iconPreference.mo48764NM(0);
                }
            } else {
                iconPreference.mo48775ez("", -1);
                iconPreference.mo48764NM(8);
                if (C42252ah.isNullOrNil(bbp)) {
                    iconPreference.setSummary(null);
                } else {
                    iconPreference.setSummary((CharSequence) bbp);
                }
            }
        } else {
            iconPreference.mo48764NM(8);
            iconPreference.mo48763NL(8);
            iconPreference.setSummary(null);
        }
        C7060h.pYm.mo8381e(16322, Integer.valueOf(1));
        AppMethodBeat.m2505o(29727);
    }

    private void dyN() {
        AppMethodBeat.m2504i(29728);
        this.ehK.mo27715ce("more_setting", false);
        final IconPreference iconPreference = (IconPreference) this.ehK.aqO("more_setting");
        if (iconPreference != null) {
            iconPreference.mo48768NQ(8);
            boolean bX = C16112c.m24429PK().mo28551bX(262145, 266242);
            if (bX) {
                iconPreference.mo48763NL(0);
                iconPreference.mo48774ey(getString(C25738R.string.f9181s0), C25738R.drawable.f6940w3);
            } else {
                iconPreference.mo48763NL(8);
                iconPreference.mo48774ey("", -1);
            }
            C9638aw.m17190ZK();
            if (((Integer) C18628c.m29072Ry().get(9, Integer.valueOf(0))).intValue() != 0) {
                if (C1853r.m3826YH()) {
                    iconPreference.setSummary((CharSequence) "");
                } else {
                    iconPreference.setSummary((int) C25738R.string.dw0);
                }
            }
            iconPreference.mo48765NN(8);
            if (bX) {
                AppMethodBeat.m2505o(29728);
                return;
            }
            C9638aw.m17190ZK();
            int intValue = ((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_SETTING_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(0))).intValue();
            C9638aw.m17190ZK();
            int intValue2 = ((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_SETTING_RED_DOT_DID_SHOW_ID_INT, Integer.valueOf(0))).intValue();
            if ((((C14714c) C1720g.m3528K(C14714c.class)).ddn() || ((C14714c) C1720g.m3528K(C14714c.class)).ddo() || intValue > intValue2) && !bX) {
                iconPreference.mo48765NN(0);
                iconPreference.mo48763NL(8);
                iconPreference.mo48774ey("", -1);
                AppMethodBeat.m2505o(29728);
                return;
            }
            iconPreference.mo48765NN(8);
            if (C16112c.m24429PK().mo28552bY(262157, 266261)) {
                iconPreference.mo48765NN(0);
                iconPreference.mo48763NL(8);
                iconPreference.mo48774ey("", -1);
                AppMethodBeat.m2505o(29728);
                return;
            }
            iconPreference.mo48765NN(8);
            if (C16112c.m24429PK().mo28552bY(262158, 266264)) {
                iconPreference.mo48765NN(0);
                iconPreference.mo48763NL(8);
                iconPreference.mo48774ey("", -1);
                AppMethodBeat.m2505o(29728);
                return;
            } else if (C16112c.m24429PK().mo28545a(C5127a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, 266242)) {
                iconPreference.mo48765NN(0);
                AppMethodBeat.m2505o(29728);
                return;
            } else {
                boolean booleanValue;
                iconPreference.mo48765NN(8);
                C9638aw.m17190ZK();
                if ((C18628c.m29072Ry().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
                    bX = true;
                } else {
                    bX = false;
                }
                if (C5046bo.getInt(C26373g.m41964Nu().getValue("VoiceprintEntry"), 0) == 1) {
                    C9638aw.m17190ZK();
                    booleanValue = ((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_VOICEPRINT_MORE_TAB_DOT_SHOW_BOOLEAN, Boolean.TRUE)).booleanValue();
                } else {
                    booleanValue = false;
                }
                if (booleanValue && r2) {
                    C4990ab.m7416i("MicroMsg.MoreTabUI", "show voiceprint dot");
                    iconPreference.mo48765NN(0);
                    AppMethodBeat.m2505o(29728);
                    return;
                }
                iconPreference.mo48765NN(8);
                C36001bm Ms = C16841a.bVu().mo48500Ms(C32321b.fKD);
                if (Ms == null || Ms.field_isExit) {
                    C16841a.bVv();
                    if (C1301c.m2776lQ(C32321b.fKD)) {
                        iconPreference.mo48765NN(0);
                        iconPreference.mo48763NL(8);
                        iconPreference.mo48774ey("", -1);
                        AppMethodBeat.m2505o(29728);
                        return;
                    }
                }
                C16841a.bVt().fKT = new C6329a() {
                    /* renamed from: e */
                    public final void mo14568e(C36001bm c36001bm) {
                        AppMethodBeat.m2504i(29697);
                        if (c36001bm.field_tipId == C32321b.fKD) {
                            C16841a.bVv();
                            if (C1301c.m2776lQ(C32321b.fKD)) {
                                iconPreference.mo48765NN(0);
                                iconPreference.mo48763NL(8);
                                iconPreference.mo48774ey("", -1);
                                AppMethodBeat.m2505o(29697);
                                return;
                            }
                        }
                        AppMethodBeat.m2505o(29697);
                    }
                };
                AppMethodBeat.m2505o(29728);
                return;
            }
        }
        AppMethodBeat.m2505o(29728);
    }

    private void dyO() {
        AppMethodBeat.m2504i(29729);
        if (C25985d.afj("emoji")) {
            C25985d.dlL();
            this.ehK.mo27715ce("settings_emoji_store", false);
            boolean bX = C16112c.m24429PK().mo28551bX(262147, 266244);
            boolean bX2 = C16112c.m24429PK().mo28551bX(262149, 266244);
            final IconPreference iconPreference = (IconPreference) this.ehK.aqO("settings_emoji_store");
            if (iconPreference == null) {
                AppMethodBeat.m2505o(29729);
                return;
            }
            if (bX) {
                iconPreference.mo48763NL(0);
                iconPreference.mo48774ey(getString(C25738R.string.f9181s0), C25738R.drawable.f6940w3);
            } else if (bX2) {
                iconPreference.mo48763NL(0);
                iconPreference.mo48774ey(getString(C25738R.string.f9144qv), C25738R.drawable.f6940w3);
            } else {
                iconPreference.mo48763NL(8);
                iconPreference.mo48774ey("", -1);
            }
            if (bX2 || bX) {
                C9638aw.m17190ZK();
                C32291o.ahp().mo43770a((String) C18628c.m29072Ry().get(229633, null), iconPreference.dAz(), new C9014g() {

                    /* renamed from: com.tencent.mm.ui.MoreTabUI$9$2 */
                    class C303492 implements Runnable {
                        C303492() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(29701);
                            iconPreference.mo48767NP(8);
                            AppMethodBeat.m2505o(29701);
                        }
                    }

                    /* renamed from: sH */
                    public final void mo7596sH(String str) {
                    }

                    /* renamed from: a */
                    public final Bitmap mo7594a(String str, View view, C37477b c37477b) {
                        return null;
                    }

                    /* renamed from: b */
                    public final void mo7595b(String str, View view, C37477b c37477b) {
                        AppMethodBeat.m2504i(29702);
                        if (c37477b.status != 0 || c37477b.bitmap == null) {
                            C5004al.m7441d(new C303492());
                            AppMethodBeat.m2505o(29702);
                            return;
                        }
                        final Bitmap bitmap = c37477b.bitmap;
                        C5004al.m7441d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(29700);
                                iconPreference.mo48770ap(bitmap);
                                iconPreference.mo48767NP(0);
                                AppMethodBeat.m2505o(29700);
                            }
                        });
                        AppMethodBeat.m2505o(29702);
                    }
                });
                AppMethodBeat.m2505o(29729);
                return;
            }
            iconPreference.mo48767NP(8);
            AppMethodBeat.m2505o(29729);
            return;
        }
        this.ehK.mo27715ce("settings_emoji_store", false);
        AppMethodBeat.m2505o(29729);
    }

    private void dyP() {
        AppMethodBeat.m2504i(29730);
        boolean YI = C1853r.m3827YI();
        C4990ab.m7410d("MicroMsg.MoreTabUI", "wallet status: is open".concat(String.valueOf(YI)));
        C15541f c15541f = this.ehK;
        String str = "settings_mm_wallet";
        if (YI) {
            YI = false;
        } else {
            YI = true;
        }
        c15541f.mo27715ce(str, YI);
        this.yCw.notifyDataSetChanged();
        AppMethodBeat.m2505o(29730);
    }

    private void dyQ() {
        AppMethodBeat.m2504i(29731);
        C9638aw.m17190ZK();
        int i = C42252ah.m74625i((Integer) C18628c.m29072Ry().get(204820, null));
        C9638aw.m17190ZK();
        int i2 = i + C42252ah.m74625i((Integer) C18628c.m29072Ry().get(204817, null));
        boolean bX = C16112c.m24429PK().mo28551bX(262156, 266248);
        int bY = C16112c.m24429PK().mo28552bY(262156, 266248);
        boolean b = C16112c.m24429PK().mo28550b(C5127a.NEW_BANDAGE_DATASOURCE_WALLET_MORE_TAB_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
        C9638aw.m17190ZK();
        String str = (String) C18628c.m29072Ry().get(C5127a.USERINFO_WALLET_MORE_TAB_REDDOT_WORDING_STRING_SYNC, (Object) "");
        IconPreference iconPreference = (IconPreference) this.ehK.aqO("settings_mm_wallet");
        if (iconPreference == null) {
            AppMethodBeat.m2505o(29731);
            return;
        }
        long longValue;
        long lb;
        int i3;
        C4990ab.m7410d("MicroMsg.MoreTabUI", "isShowNew : ".concat(String.valueOf(bX)));
        C4990ab.m7410d("MicroMsg.MoreTabUI", "isShowDot : ".concat(String.valueOf(bY)));
        C9638aw.m17190ZK();
        String str2 = (String) C18628c.m29072Ry().get(C5127a.USERINFO_LQT_WALLET_RED_DOT_WORDING_STRING, (Object) "");
        C9638aw.m17190ZK();
        int intValue = ((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_LQT_WALLET_RED_DOT_INT, Integer.valueOf(-1))).intValue();
        if (bX || bY != 0) {
            C9638aw.m17190ZK();
            longValue = ((Long) C18628c.m29072Ry().get(C5127a.USERINFO_WALLET_ENTRY_REDDOT_PUSH_DATE_LONG_SYNC, Long.valueOf(-1))).longValue();
            lb = C42252ah.m74628lb(C26373g.m41964Nu().getValue("PayWalletRedDotExpire"));
            long j = 86400000 * lb;
            C4990ab.m7417i("MicroMsg.MoreTabUI", "pushTick: %s, expireTime: %s, expireTick: %s, currentTick: %s, passDay: %s", Long.valueOf(longValue), Long.valueOf(lb), Long.valueOf(j), Long.valueOf(System.currentTimeMillis()), Double.valueOf((((double) System.currentTimeMillis()) - ((double) longValue)) / 8.64E7d));
            if (longValue > 0 && lb > 0 && r20 >= ((double) lb)) {
                bX = false;
                C16112c.m24429PK().mo28556x(262156, false);
                bY = 0;
            }
        }
        C1720g.m3537RQ();
        boolean booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_MY_ENTRY_REDDOT_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        C1720g.m3537RQ();
        longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_MY_ENTRY_REDDOT_EXPIRETIME_LONG_SYNC, Long.valueOf(0))).longValue();
        if (!booleanValue || longValue <= 0 || System.currentTimeMillis() <= longValue) {
            boolean i32 = booleanValue;
        } else {
            C4990ab.m7416i("MicroMsg.MoreTabUI", "walletMyEntryRedDot expire, ignore redDot");
            i32 = 0;
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_MY_ENTRY_REDDOT_BOOLEAN_SYNC, Boolean.FALSE);
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_MY_ENTRY_REDDOT_EXPIRETIME_LONG_SYNC, Long.valueOf(0));
        }
        int i4 = bY | i32;
        C1720g.m3537RQ();
        C4990ab.m7417i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s, walletEntryWording: %s", Boolean.valueOf(bX), Boolean.valueOf(i4), (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_ENTRY_WORDING_STRING_SYNC, (Object) ""));
        booleanValue = C16112c.m24429PK().mo28550b(C5127a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, C5127a.USERINFO_NEW_BANDAGE_WATCHER_PAY_ENTRANCE_STRING_SYNC);
        C1720g.m3537RQ();
        lb = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_New_MY_ENTRY_REDDOT_EXPIRETIME_LONG_SYNC, Long.valueOf(0))).longValue();
        if (!booleanValue || lb <= 0 || System.currentTimeMillis() <= lb) {
            boolean z = booleanValue;
        } else {
            C4990ab.m7416i("MicroMsg.MoreTabUI", "walletMyEntryRedDot expire, ignore redDot");
            bY = 0;
            C16112c.m24429PK().mo28554c(C5127a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, C5127a.USERINFO_NEW_BANDAGE_WATCHER_PAY_ENTRANCE_STRING_SYNC);
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_New_MY_ENTRY_REDDOT_EXPIRETIME_LONG_SYNC, Long.valueOf(0));
        }
        int i5 = i4 | bY;
        C1720g.m3537RQ();
        String str3 = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_New_MY_ENTRY_WORDING_STRING_SYNC, (Object) "");
        C4990ab.m7417i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s, walletEntryWording: %s", Boolean.valueOf(bX), Boolean.valueOf(i5), str3);
        C4990ab.m7410d("MicroMsg.MoreTabUI", "bankcardDot : ".concat(String.valueOf(b)));
        if (b) {
            if (C5046bo.isNullOrNil(str)) {
                iconPreference.mo48775ez("", -1);
                iconPreference.mo48764NM(8);
                iconPreference.mo48765NN(0);
            } else {
                iconPreference.mo48764NM(0);
                iconPreference.mo48771av(str, -1, -7566196);
                iconPreference.mo48778qh(true);
                iconPreference.mo48765NN(8);
            }
        } else if (bX) {
            iconPreference.mo48763NL(0);
            iconPreference.mo48774ey(getString(C25738R.string.f9181s0), C25738R.drawable.f6940w3);
            iconPreference.mo48765NN(8);
        } else if (i2 > 99) {
            iconPreference.mo48763NL(0);
            iconPreference.mo48774ey(getString(C25738R.string.eu9), C44385r.m80243ik(getContext()));
            iconPreference.mo48765NN(8);
        } else if (i2 > 0) {
            iconPreference.mo48763NL(0);
            iconPreference.mo48774ey(String.valueOf(i2), C44385r.m80243ik(getContext()));
            iconPreference.mo48765NN(8);
        } else if (i5 != 0) {
            iconPreference.mo48774ey("", -1);
            iconPreference.mo48763NL(8);
            iconPreference.mo48765NN(0);
        } else if (intValue == 1) {
            iconPreference.mo48774ey("", -1);
            iconPreference.mo48763NL(8);
            iconPreference.mo48764NM(0);
            iconPreference.mo48778qh(true);
            if (!C42252ah.isNullOrNil(str2)) {
                iconPreference.mo48771av(str2, -1, Color.parseColor("#888888"));
            }
            iconPreference.mo48768NQ(8);
        } else {
            iconPreference.mo48774ey("", -1);
            iconPreference.mo48763NL(8);
            iconPreference.mo48765NN(8);
            iconPreference.mo48764NM(8);
            iconPreference.mo48775ez("", -1);
        }
        if (C5046bo.isNullOrNil(str3)) {
            str3 = r5;
        }
        if (C42252ah.isNullOrNil(str3) || i5 == 0) {
            iconPreference.setSummary((CharSequence) "");
        } else {
            iconPreference.setSummary((CharSequence) str3);
        }
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(6);
        objArr[1] = Integer.valueOf(i5 != 0 ? 1 : 0);
        objArr[2] = "";
        objArr[3] = "";
        objArr[4] = Integer.valueOf(1);
        c7060h.mo8381e(14872, objArr);
        AppMethodBeat.m2505o(29731);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(29732);
        int bh = C42252ah.m74609bh(obj);
        C4990ab.m7411d("MicroMsg.MoreTabUI", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(bh), c7298n);
        C9638aw.m17190ZK();
        if (c7298n != C18628c.m29072Ry() || bh <= 0) {
            C4990ab.m7413e("MicroMsg.MoreTabUI", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(bh), c7298n);
            AppMethodBeat.m2505o(29732);
        } else if (204817 == bh || 204820 == bh) {
            dyQ();
            AppMethodBeat.m2505o(29732);
        } else if (40 == bh) {
            dyP();
            AppMethodBeat.m2505o(29732);
        } else {
            if ("208899".equals(Integer.valueOf(i))) {
                dyO();
            }
            AppMethodBeat.m2505o(29732);
        }
    }

    /* renamed from: pS */
    private boolean m48355pS(boolean z) {
        AppMethodBeat.m2504i(29733);
        C33459c.izk.mo53945a(C33460a.izo);
        C33459c.izk.mo53945a(C33460a.izA);
        Intent intent = new Intent();
        intent.putExtra("preceding_scence", 2);
        intent.putExtra("isNativeView", z);
        C25985d.m41467b(getContext(), "appbrand", ".functions.emojistore.LFEmojiStoreContainerActivity", intent);
        AppMethodBeat.m2505o(29733);
        return true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(29734);
        super.onConfigurationChanged(configuration);
        C4990ab.m7410d("MicroMsg.MoreTabUI", "onConfigurationChanged");
        if (configuration.orientation == 1) {
            this.lZa = false;
            if (this.yoh != null) {
                this.yoj.dyU();
                AppMethodBeat.m2505o(29734);
                return;
            }
        } else if (configuration.orientation == 2) {
            this.lZa = true;
            if (this.yoh != null) {
                if (!this.yoh.isVisible) {
                    this.yoh.dLf();
                }
                this.yoj.mo48653Nr(2);
            }
        }
        AppMethodBeat.m2505o(29734);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dvY() {
        boolean z;
        AppMethodBeat.m2504i(29735);
        if (getResources().getConfiguration().orientation == 2) {
            z = true;
        } else {
            z = false;
        }
        this.lZa = z;
        this.ehK = this.yCw;
        this.contentView = getContentView();
        C1441a.m3065bG(getContext());
        C1720g.m3537RQ();
        this.plr = ((C35168e) C1720g.m3530M(C35168e.class)).getStoryUIFactory().mo69258eV(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(C1338a.m2857am(getContext(), C25738R.dimen.a7g), C1338a.m2857am(getContext(), C25738R.dimen.a7g));
        layoutParams.gravity = 83;
        ((ViewGroup) getContext().findViewById(2131823829).getParent()).addView(this.plr, 0, layoutParams);
        this.yoh.zRr = this.yoB;
        this.yoh.setPadding(this.yoh.getPaddingLeft(), this.yoh.getPaddingTop(), this.yoh.getPaddingRight(), this.yoi.getHeight());
        if (this.oZf != null) {
            C4990ab.m7410d("MicroMsg.MoreTabUI", "dancy test add view !");
            this.plq = ((C35168e) C1720g.m3530M(C35168e.class)).getStoryUIFactory().mo69256a(getContext(), C29273a.SelfTabGallery, null);
            if (this.plq != null) {
                int am;
                this.yos = -(C5230ak.m7993hy(getContext()).y / 10);
                if (this.yot) {
                    am = C1338a.m2857am(getContext(), C25738R.dimen.a7i);
                } else {
                    am = C1338a.m2857am(getContext(), C25738R.dimen.a7h);
                }
                this.yor = am;
                this.yoq = -C1338a.fromDPToPix(getContext(), ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE);
                this.yop = 0;
                LayoutParams layoutParams2 = new LayoutParams(-1, C5230ak.m7993hy(getContext()).y);
                layoutParams2.topMargin = this.yos;
                layoutParams2.bottomMargin = -C5230ak.m7988fr(getContext());
                this.oZf.addView(this.plq, 0, layoutParams2);
                this.yoh.mo49263x(this.plq, this.yor, this.yos);
                this.yoh.setNavigationBarHeight(C5230ak.m7988fr(getActivity()));
                this.plq.setDataSeed(C1853r.m3846Yz());
                this.plq.mo55934a(this.yoh);
                this.plq.setStoryBrowseUIListener(this);
            }
            ((C35168e) C1720g.m3530M(C35168e.class)).getStoryUIFactory().mo69257d(this.yoo, this.yog);
            this.yoj.dyU();
        }
        AppMethodBeat.m2505o(29735);
    }

    /* renamed from: Nq */
    private void m48331Nq(int i) {
        AppMethodBeat.m2504i(29736);
        View findViewById = findViewById(2131820940);
        if (findViewById != null) {
            findViewById.setVisibility(i);
            C4990ab.m7417i("MicroMsg.MoreTabUI", "setActionbarContainer type:%s", Integer.valueOf(i));
            AppMethodBeat.m2505o(29736);
            return;
        }
        C4990ab.m7416i("MicroMsg.MoreTabUI", "setActionbarContainer is null!!");
        AppMethodBeat.m2505o(29736);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dvZ() {
        AppMethodBeat.m2504i(29737);
        long currentTimeMillis = System.currentTimeMillis();
        this.ehK = this.yCw;
        C9638aw.m17190ZK();
        C18628c.m29072Ry().mo10118a(this);
        C16112c.m24429PK().mo28543a(this.qpv);
        this.ehK.mo27715ce("more_tab_setting_personal_info", false);
        this.yol = (AccountInfoPreference) this.yCw.aqO("more_tab_setting_personal_info");
        String YA = C1853r.m3819YA();
        if (C42252ah.isNullOrNil(YA)) {
            YA = C1853r.m3846Yz();
            if (C7616ad.aoA(YA)) {
                this.yol.vpX = null;
            } else {
                this.yol.vpX = YA;
            }
        } else {
            this.yol.vpX = YA;
        }
        this.yol.userName = C1853r.m3846Yz();
        CharSequence YB = C1853r.m3820YB();
        if (C42252ah.isNullOrNil(YB)) {
            YB = C1853r.m3846Yz();
        }
        this.yol.vpW = C44089j.m79292b(getContext(), YB);
        this.yol.mo27300ad(this.pnR, this.yot);
        this.yol.vqe = new C303457();
        ((AccountInfoPreference) this.ehK.aqO("more_tab_setting_personal_info")).vqd = new C303468();
        IconPreference iconPreference = (IconPreference) this.ehK.aqO("settings_my_address");
        if (iconPreference != null) {
            int dtd = C41789d.akP().dtd();
            if (dtd > 0) {
                iconPreference.mo48763NL(0);
                iconPreference.mo48774ey(String.valueOf(dtd), C25738R.drawable.f6940w3);
            } else {
                iconPreference.mo48763NL(8);
                iconPreference.mo48774ey("", -1);
            }
        }
        dyL();
        dyO();
        dyN();
        if (C25985d.afj("favorite")) {
            this.ehK.mo27715ce("settings_mm_favorite", false);
        } else {
            this.ehK.mo27715ce("settings_mm_favorite", true);
        }
        dyQ();
        dyP();
        dyM();
        if (C1720g.m3532RL().mo5213J(C46480a.class)) {
            this.ehK.mo27715ce("more_uishow", false);
        } else {
            this.ehK.mo27715ce("more_uishow", true);
        }
        Preference aqO = this.ehK.aqO("settings_privacy_agreements");
        if (C17950b.m28216sO((String) C1720g.m3536RP().mo5239Ry().get(274436, null))) {
            YA = getString(C25738R.string.dei);
            CharSequence newSpannable = Factory.getInstance().newSpannable(YA);
            newSpannable.setSpan(new ForegroundColorSpan(getResources().getColor(C25738R.color.f12123t7)), newSpannable.length() - YA.length(), newSpannable.length(), 33);
            aqO.setTitle(newSpannable);
            this.ehK.mo27715ce("settings_privacy_agreements", false);
        } else {
            this.ehK.mo27715ce("settings_privacy_agreements", true);
        }
        thisActivity().supportInvalidateOptionsMenu();
        this.ehK.notifyDataSetChanged();
        final View findViewById = findViewById(2131828206);
        if (!(findViewById == null || findViewById.getVisibility() == 8)) {
            new C7306ak(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(29713);
                    findViewById.setVisibility(8);
                    findViewById.startAnimation(AnimationUtils.loadAnimation(MoreTabUI.this.getContext(), C25738R.anim.f8333b6));
                    AppMethodBeat.m2505o(29713);
                }
            });
        }
        if (this.yoh != null && this.yoh.isVisible) {
            m48331Nq(0);
            C4990ab.m7416i("MicroMsg.MoreTabUI", "onTabResume force set actionbar visible!!");
        }
        if (this.plq != null) {
            this.plq.onResume();
            this.plq.mo55933Pb();
        }
        boolean z = ((C35168e) C1720g.m3530M(C35168e.class)).isShowStoryCheck() && C16112c.m24429PK().mo28551bX(352279, 266241);
        this.yom = z;
        dyT();
        C4990ab.m7417i("MicroMsg.MoreTabUI", "[onTabResume] cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(29737);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dwa() {
        AppMethodBeat.m2504i(29738);
        if (this.plq != null) {
            this.plq.onStart();
        }
        AppMethodBeat.m2505o(29738);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dwb() {
        AppMethodBeat.m2504i(29739);
        C4990ab.m7410d("MicroMsg.MoreTabUI", "onTabPause");
        C16112c.m24429PK().mo28549b(this.qpv);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().mo10121b(this);
        if (this.plq != null) {
            this.plq.onPause();
        }
        if (this.yoh != null) {
            if (!this.yoh.isVisible && !this.pnR) {
                this.yoh.postDelayed(new C235452(), 200);
            } else if (this.yoh.isVisible && this.yoh.getTranslationY() != 0.0f) {
                this.yoh.setTranslationY(0.0f);
            }
        }
        dyS();
        AppMethodBeat.m2505o(29739);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dwc() {
        AppMethodBeat.m2504i(29740);
        if (this.plq != null) {
            this.plq.onStop();
        }
        AppMethodBeat.m2505o(29740);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dwd() {
        AppMethodBeat.m2504i(29741);
        if (this.plq != null) {
            this.plq.onDestroy();
        }
        ((C35168e) C1720g.m3530M(C35168e.class)).getStoryUIFactory().mo69260ee(this.yog);
        AppMethodBeat.m2505o(29741);
    }

    public final void dwf() {
    }

    public final void dwg() {
    }

    public final void dwi() {
    }

    public final void dxc() {
        AppMethodBeat.m2504i(29742);
        C4990ab.m7410d("MicroMsg.MoreTabUI", "onTabSwitchIn");
        this.you = true;
        if (getContext() != null) {
            this.lZa = getResources().getConfiguration().orientation == 2;
        }
        if (this.yoh != null) {
            PullDownListView pullDownListView = this.yoh;
            C5227ai.m7973i("MicroMsg.PullDownListView", "onResume", new Object[0]);
            pullDownListView.zRn = true;
            if (this.yoh.isVisible && this.yoh.getTranslationY() != 0.0f) {
                this.yoh.setTranslationY(0.0f);
            } else if (!this.yoh.isVisible) {
                this.yoh.dLf();
            }
        }
        if (this.plq != null) {
            this.plq.mo55933Pb();
        }
        m48356pT(true);
        long currentTimeMillis = System.currentTimeMillis();
        C22212h c22212h = C22212h.scu;
        C22212h.m33899lq(currentTimeMillis);
        c22212h = C22212h.scu;
        C22212h.cAJ().cZm = currentTimeMillis;
        C22212h c22212h2 = C22212h.scu;
        C22212h.cAJ().cZW = System.currentTimeMillis();
        AppMethodBeat.m2505o(29742);
    }

    public final void dxd() {
        AppMethodBeat.m2504i(29743);
        this.you = false;
        if (this.yoh != null) {
            PullDownListView pullDownListView = this.yoh;
            C5227ai.m7973i("MicroMsg.PullDownListView", "onPause", new Object[0]);
            pullDownListView.zRn = false;
            if (!this.yoh.isVisible) {
                this.yoh.dLf();
            }
        }
        if (this.plr != null) {
            this.plr.setVisibility(8);
        }
        C4879a.xxA.mo10055m(new C45367sp());
        m48356pT(false);
        C22212h c22212h = C22212h.scu;
        C22212h.cAK();
        AppMethodBeat.m2505o(29743);
    }

    public final void caA() {
        AppMethodBeat.m2504i(29744);
        C4990ab.m7416i("MicroMsg.MoreTabUI", "story_cat storyUINoStory");
        if (!(this.yoh == null || this.yoh.isVisible)) {
            this.yoh.dLf();
        }
        if (!C46270n.isShowStoryCheck() || this.lZa) {
            this.yoj.mo48653Nr(2);
            AppMethodBeat.m2505o(29744);
            return;
        }
        this.yoj.mo48653Nr(1);
        AppMethodBeat.m2505o(29744);
    }

    public final void caB() {
        AppMethodBeat.m2504i(29745);
        C4990ab.m7416i("MicroMsg.MoreTabUI", "story_cat storyUIHasStory");
        if (this.yoh != null && this.yoh.isVisible) {
            if (this.lZa) {
                this.yoj.mo48653Nr(2);
            } else {
                this.yoj.mo48653Nr(0);
            }
        }
        IconPreference iconPreference = (IconPreference) this.ehK.aqO("settings_my_album");
        if (iconPreference != null) {
            if (C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_STORY_NEED_DISPLAY_ALBUM_GUIDE_BOOLEAN_SYNC, true)) {
                this.yov = true;
                iconPreference.mo48765NN(0);
                AppMethodBeat.m2505o(29745);
                return;
            }
            this.yov = false;
            iconPreference.mo48765NN(8);
        }
        AppMethodBeat.m2505o(29745);
    }

    public final void caC() {
        AppMethodBeat.m2504i(29746);
        C4990ab.m7416i("MicroMsg.MoreTabUI", "story_cat storyUIBackPressed");
        if (!(this.yoh == null || this.yoh.isVisible)) {
            this.yoh.dLf();
        }
        m48331Nq(0);
        m48357pU(this.pnR);
        AppMethodBeat.m2505o(29746);
    }

    /* renamed from: pT */
    private void m48356pT(boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(29747);
        if (getActivity() != null) {
            if (this.plw == null) {
                View findViewById = findViewById(2131820940);
                if (findViewById != null) {
                    this.plw = findViewById.findViewById(2131820941);
                }
                String str = "MicroMsg.MoreTabUI";
                String str2 = "checkActionBarClick: findActionBar %s";
                Object[] objArr = new Object[1];
                if (this.plw == null) {
                    z2 = false;
                }
                objArr[0] = Boolean.valueOf(z2);
                C4990ab.m7417i(str, str2, objArr);
            }
            if (this.plw != null) {
                if (z) {
                    this.plw.setOnClickListener(new C303413());
                    AppMethodBeat.m2505o(29747);
                    return;
                }
                this.plw.setOnClickListener(null);
            }
        }
        AppMethodBeat.m2505o(29747);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean wY;
        AppMethodBeat.m2504i(29748);
        if (i == 4 && keyEvent.getAction() == 0 && this.plq != null) {
            wY = this.plq.mo55964wY();
        } else {
            wY = false;
        }
        C4990ab.m7411d("MicroMsg.MoreTabUI", "onBackPressed: %b", Boolean.valueOf(wY));
        if (wY || super.onKeyDown(i, keyEvent)) {
            AppMethodBeat.m2505o(29748);
            return true;
        }
        AppMethodBeat.m2505o(29748);
        return false;
    }

    /* renamed from: pU */
    private void m48357pU(boolean z) {
        AppMethodBeat.m2504i(29749);
        if ((getContext() instanceof LauncherUI) && this.yoh != null && this.yoh.isVisible) {
            ((LauncherUI) getContext()).getHomeUI().mo69896pK(z);
        }
        AppMethodBeat.m2505o(29749);
    }

    /* Access modifiers changed, original: final */
    public final void caE() {
        AppMethodBeat.m2504i(29750);
        if (C1443d.m3068iW(19)) {
            getWindow().clearFlags(201327616);
            AppMethodBeat.m2505o(29750);
            return;
        }
        getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        AppMethodBeat.m2505o(29750);
    }

    private void dyR() {
        AppMethodBeat.m2504i(29751);
        C4990ab.m7409c("MicroMsg.MoreTabUI", "activeBubbleTip", new Object[0]);
        this.yon.setVisibility(0);
        ((C35168e) C1720g.m3530M(C35168e.class)).getStoryUIFactory().mo69261ef(this.yog);
        AppMethodBeat.m2505o(29751);
    }

    private void dyS() {
        AppMethodBeat.m2504i(29752);
        C4990ab.m7409c("MicroMsg.MoreTabUI", "forceStopBubbleTip", new Object[0]);
        this.yon.setVisibility(4);
        ((C35168e) C1720g.m3530M(C35168e.class)).getStoryUIFactory().mo69262eg(this.yog);
        AppMethodBeat.m2505o(29752);
    }

    private void dyT() {
        AppMethodBeat.m2504i(29753);
        if (this.yom && this.yoh.isVisible) {
            dyR();
            AppMethodBeat.m2505o(29753);
            return;
        }
        dyS();
        AppMethodBeat.m2505o(29753);
    }

    /* renamed from: j */
    static /* synthetic */ void m48348j(MoreTabUI moreTabUI) {
        AppMethodBeat.m2504i(29761);
        if (moreTabUI.getContext() instanceof LauncherUI) {
            HomeUI homeUI = ((LauncherUI) moreTabUI.getContext()).getHomeUI();
            if (homeUI.yje != null) {
                homeUI.yje.setVisible(false);
                homeUI.yje.setEnabled(false);
            }
        }
        AppMethodBeat.m2505o(29761);
    }

    /* renamed from: k */
    static /* synthetic */ void m48349k(MoreTabUI moreTabUI) {
        AppMethodBeat.m2504i(29762);
        if (C1443d.m3068iW(19)) {
            moreTabUI.getWindow().setFlags(201327616, 201327616);
            AppMethodBeat.m2505o(29762);
            return;
        }
        moreTabUI.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        AppMethodBeat.m2505o(29762);
    }

    /* renamed from: c */
    static /* synthetic */ void m48340c(MoreTabUI moreTabUI, boolean z) {
        AppMethodBeat.m2504i(29768);
        C4990ab.m7417i("MicroMsg.MoreTabUI", "updateStatusBarCell %s stack: %s", Boolean.valueOf(z), C42252ah.anW().toString());
        if (VERSION.SDK_INT >= 23) {
            View decorView = moreTabUI.getActivity().getWindow().getDecorView();
            if (decorView != null) {
                int systemUiVisibility = decorView.getSystemUiVisibility();
                if (z) {
                    systemUiVisibility &= -8193;
                } else {
                    systemUiVisibility |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                }
                decorView.setSystemUiVisibility(systemUiVisibility);
            }
        }
        AppMethodBeat.m2505o(29768);
    }
}
