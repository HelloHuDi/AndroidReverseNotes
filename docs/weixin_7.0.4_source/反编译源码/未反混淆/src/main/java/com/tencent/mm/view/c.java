package com.tencent.mm.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.emoji.debug.EmojiDebugUI;
import com.tencent.mm.g.a.sq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.f;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.view.e.a.AnonymousClass5;
import com.tencent.mm.view.e.a.a;
import java.util.Iterator;

public final class c extends SmileyPanel implements a {
    private com.tencent.mm.view.e.a Aai;
    private com.tencent.mm.view.f.a Aaj;
    private final String TAG;
    private boolean jgc;

    public c(Context context, boolean z) {
        this(context, z, (byte) 0);
    }

    private c(Context context, boolean z, byte b) {
        int i;
        if (z) {
            i = R.style.hd;
        } else {
            i = R.style.hc;
        }
        super(new com.tencent.mm.emoji.b.a(context, i), null);
        AppMethodBeat.i(62923);
        this.TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanel";
        this.jgc = false;
        this.Aaj = new com.tencent.mm.view.f.a();
        this.Aai = new com.tencent.mm.view.e.a(getContext(), this.Aaj, this);
        AppMethodBeat.o(62923);
    }

    public final void onResume() {
        AppMethodBeat.i(62924);
        ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onResume");
        com.tencent.mm.view.f.a aVar = this.Aaj;
        aVar.zRn = true;
        aVar.dNv();
        aVar.dNm();
        com.tencent.mm.view.e.a aVar2 = this.Aai;
        if (!(aVar2.Adu == null || aVar2.Adt == null)) {
            aVar2.Adu.aJ(aVar2.Adt.getCurrentItem(), true);
        }
        aVar2.dNb();
        AppMethodBeat.o(62924);
    }

    public final void setShowProductId(String str) {
        AppMethodBeat.i(62925);
        this.Aaj.setShowProductId(str);
        AppMethodBeat.o(62925);
    }

    public final void onPause() {
        AppMethodBeat.i(62926);
        ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onPause");
        this.Aaj.onPause();
        AppMethodBeat.o(62926);
    }

    public final void destroy() {
        AppMethodBeat.i(62927);
        ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onDestroy");
        this.vhf = null;
        if (this.Aai != null) {
            ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "ui clear");
            com.tencent.mm.view.e.a aVar = this.Aai;
            aVar.dMZ();
            aVar.jiq = null;
            if (aVar.Adt != null) {
                aVar.Adt.setAdapter(null);
            }
            ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager destroy remove listener.");
            ((d) g.M(d.class)).getProvider().i(aVar.AdM);
            ((d) g.M(d.class)).getProvider().g(aVar.xYF);
            ((d) g.M(d.class)).getProvider().k(aVar.AdO);
            com.tencent.mm.sdk.b.a.xxA.d(aVar.xYG);
            com.tencent.mm.sdk.b.a.xxA.d(aVar.AdN);
            this.Aai = null;
        }
        if (this.Aaj != null) {
            ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "stg clear");
            if (this.Aaj.zRn) {
                this.Aaj.onPause();
            }
            com.tencent.mm.view.f.a aVar2 = this.Aaj;
            Iterator it = aVar2.AeE.iterator();
            while (it.hasNext()) {
                com.tencent.mm.view.c.a aVar3 = (com.tencent.mm.view.c.a) it.next();
                if (aVar3 != null) {
                    aVar3.Aaj = null;
                    aVar3.Adi = null;
                }
            }
            aVar2.dNu();
        }
        ((d) g.M(d.class)).getProvider().onDestroy();
        AppMethodBeat.o(62927);
    }

    public final void setCallback(f fVar) {
        AppMethodBeat.i(62928);
        super.setCallback(fVar);
        AppMethodBeat.o(62928);
    }

    public final void setSendButtonEnable(boolean z) {
        AppMethodBeat.i(62929);
        com.tencent.mm.view.e.a aVar = this.Aai;
        if (aVar.AdC != null) {
            aVar.AdC.setEnabled(z);
        }
        AppMethodBeat.o(62929);
    }

    public final void AC() {
        this.vhf = null;
    }

    public final void refresh() {
        AppMethodBeat.i(62930);
        ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "refresh");
        try {
            if (this.Aaj == null || this.Aai == null) {
                AppMethodBeat.o(62930);
                return;
            }
            this.Aai.dNg();
            AppMethodBeat.o(62930);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.emoji.SmileyPanel.SmileyPanel", e, "", new Object[0]);
            AppMethodBeat.o(62930);
        }
    }

    public final void AD() {
        AppMethodBeat.i(62931);
        ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideCustomBtn, %s", bo.dpG());
        this.Aaj.Aes = true;
        AppMethodBeat.o(62931);
    }

    public final void AE() {
        AppMethodBeat.i(62932);
        ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "[hideDefaultBtn]");
        this.Aaj.Aet = true;
        AppMethodBeat.o(62932);
    }

    public final void j(boolean z, boolean z2) {
        AppMethodBeat.i(62933);
        ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideSmiley: %B, hideEmojiSmiley: %B", Boolean.valueOf(z), Boolean.valueOf(z2));
        this.Aaj.Aev = z;
        this.Aaj.Aew = z2;
        AppMethodBeat.o(62933);
    }

    public final void bf(boolean z) {
        AppMethodBeat.i(62934);
        ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideSendButton:B", Boolean.valueOf(z));
        this.Aai.rk(z);
        this.Aaj.Aey = true;
        AppMethodBeat.o(62934);
    }

    public final ChatFooterPanel.a getTextOpListener() {
        return this.vhf;
    }

    public final j getSmileyPanelCallback() {
        return (j) this.vhg;
    }

    public final void setPortHeightPx(int i) {
        AppMethodBeat.i(62935);
        ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "setPortHeightPx: %d", Integer.valueOf(i));
        com.tencent.mm.view.f.a aVar = this.Aaj;
        if (aVar.Aei != i) {
            aVar.AeD = false;
            aVar.AeC = false;
        }
        aVar.Aei = i;
        this.Aaj.dNl();
        aVar = this.Aaj;
        aVar.QH(i - aVar.AdY);
        this.Aaj.jiM = 0;
        AppMethodBeat.o(62935);
    }

    public final int getBottomHeightPx() {
        return this.Aaj.Aei;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(62936);
        super.onSizeChanged(i, i2, i3, i4);
        AppMethodBeat.o(62936);
    }

    public final void setVisibility(int i) {
        int i2 = 0;
        AppMethodBeat.i(62937);
        super.setVisibility(i);
        if (i == 0) {
            this.jgc = false;
            if (this.Aai != null) {
                com.tencent.mm.view.e.a aVar = this.Aai;
                ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initView begin");
                com.tencent.mm.emoji.c.a OZ = com.tencent.mm.emoji.c.a.OZ();
                OZ.ezk = System.currentTimeMillis();
                OZ.clickCount = 0;
                if (aVar.mView != null && getChildCount() > 0) {
                    ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "already load view --- pass");
                    if (!(aVar.Adu == null || aVar.Adt == null)) {
                        aVar.Adu.aJ(aVar.Adt.getCurrentItem(), true);
                        com.tencent.mm.view.c.a atl = aVar.Aaj.atl("capture");
                        if (atl != null && atl.jis == aVar.Adt.getCurrentItem() && com.tencent.mm.view.f.a.QL(aVar.Aaj.gOW) && ((d) g.M(d.class)).getEmojiMgr().OT()) {
                            h.pYm.e(15982, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                            com.tencent.mm.cj.c.aNX();
                        }
                    }
                    aVar.aRF();
                    AppMethodBeat.o(62937);
                    return;
                } else if (aVar.Aaj == null) {
                    ab.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "mPanelStg is null");
                    AppMethodBeat.o(62937);
                    return;
                } else {
                    int i3;
                    ImageView imageView;
                    aVar.Aaj.AeI = false;
                    if (aVar.mView == null) {
                        aVar.mView = LayoutInflater.from(getContext()).inflate(R.layout.atp, null);
                    } else if (aVar.mView.getParent() != null) {
                        ((ViewGroup) aVar.mView.getParent()).removeView(aVar.mView);
                    }
                    aVar.Adt = (SmileyPanelViewPager) aVar.findViewById(R.id.yz);
                    aVar.Adt.setPanelStg(aVar.Aaj);
                    aVar.Adt.setSmileyPanelViewPagerLayoutListener(aVar);
                    aVar.Adt.setOnPageChangeListener(aVar);
                    aVar.Adt.setOffscreenPageLimit(3);
                    aVar.Aaj.jiM = aVar.Adt.getWidth();
                    aVar.Adv = (SmileyPanelScrollView) aVar.findViewById(R.id.yy);
                    aVar.Adv.setOnPageSelectListener(aVar);
                    aVar.Adv.setSmileyPanelStg(aVar.Aaj);
                    aVar.Adw = (ScrollRectRecyclerView) aVar.findViewById(R.id.eee);
                    aVar.Adx = new com.tencent.mm.view.a.j(aVar.jiq, aVar.Aaj);
                    aVar.Adx.AbO = aVar.AdP;
                    aVar.Adw.setLayoutManager(new LinearLayoutManager(0));
                    aVar.Adw.setAdapter(aVar.Adx);
                    aVar.Adw.setItemAnimator(null);
                    aVar.AdC = (TextView) aVar.findViewById(R.id.dfq);
                    aVar.Adz = (ImageView) aVar.findViewById(R.id.eeh);
                    aVar.Adz.setOnClickListener(aVar);
                    aVar.Ady = aVar.findViewById(R.id.eed);
                    aVar.AdA = (ImageView) aVar.findViewById(R.id.eei);
                    aVar.AdC.setOnClickListener(aVar);
                    aVar.AdC.setVisibility(aVar.Aaj.dNq() ? 0 : 8);
                    addView(aVar.mView, new LayoutParams(-1, -1));
                    aVar.Aaj.AeI = true;
                    View view = aVar.Ady;
                    if (aVar.Aaj.Aes || aVar.Aaj.Aet) {
                        i3 = 8;
                    } else {
                        i3 = 0;
                    }
                    view.setVisibility(i3);
                    aVar.AdB = (ImageButton) aVar.findViewById(R.id.eeg);
                    aVar.AdB.setOnClickListener(aVar);
                    ImageButton imageButton = aVar.AdB;
                    if (aVar.Aaj.Aet) {
                        com.tencent.mm.view.f.a aVar2 = aVar.Aaj;
                        if (aVar2.gOW == ChatFooterPanel.vhk || aVar2.gOW == ChatFooterPanel.vhl || aVar2.gOW == ChatFooterPanel.vhn || aVar2.gOW == ChatFooterPanel.vhp || aVar2.gOW == ChatFooterPanel.vho || aVar2.gOW == ChatFooterPanel.vhq || aVar2.gOW == ChatFooterPanel.vhs || aVar2.gOW == ChatFooterPanel.vhr) {
                            i3 = true;
                        } else {
                            i3 = 0;
                        }
                        if (i3 != 0) {
                            i3 = 0;
                            imageButton.setVisibility(i3);
                            aVar.AdD = (ImageView) aVar.findViewById(R.id.eef);
                            imageView = aVar.AdD;
                            if (aVar.Aaj.gOW != ChatFooterPanel.vhi || aVar.Aaj.Aet) {
                                i2 = 8;
                            }
                            imageView.setVisibility(i2);
                            aVar.AdD.setOnClickListener(aVar);
                            if (bp.dpL() || com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED) {
                                aVar.AdD.setOnLongClickListener(new OnLongClickListener() {
                                    public final boolean onLongClick(View view) {
                                        AppMethodBeat.i(63025);
                                        a.this.jiq.startActivity(new Intent(a.this.jiq, EmojiDebugUI.class));
                                        AppMethodBeat.o(63025);
                                        return true;
                                    }
                                });
                            }
                            AppMethodBeat.o(62937);
                            return;
                        }
                    }
                    i3 = 8;
                    imageButton.setVisibility(i3);
                    aVar.AdD = (ImageView) aVar.findViewById(R.id.eef);
                    imageView = aVar.AdD;
                    i2 = 8;
                    imageView.setVisibility(i2);
                    aVar.AdD.setOnClickListener(aVar);
                    aVar.AdD.setOnLongClickListener(/* anonymous class already generated */);
                    AppMethodBeat.o(62937);
                    return;
                }
            }
            ab.w("MicroMsg.emoji.SmileyPanel.SmileyPanel", "Smiley Panel Manager is null.");
            AppMethodBeat.o(62937);
        } else if (this.Aaj != null) {
            this.Aaj.dNu();
            AppMethodBeat.o(62937);
        } else {
            ab.w("MicroMsg.emoji.SmileyPanel.SmileyPanel", "Smiley PanelStg Manager is null.");
            AppMethodBeat.o(62937);
        }
    }

    public final void setTalkerName(String str) {
        this.Aaj.vmL = str;
    }

    public final void setDefaultEmojiByDetail(String str) {
        AppMethodBeat.i(62938);
        com.tencent.mm.view.f.a aVar = this.Aaj;
        aVar.setShowProductId(str);
        aVar.dNl();
        if (aVar.AeH == null) {
            aVar.AeH = new com.tencent.mm.sdk.b.c<sq>() {
                {
                    AppMethodBeat.i(63073);
                    this.xxI = sq.class.getName().hashCode();
                    AppMethodBeat.o(63073);
                }

                public final /* synthetic */ boolean a(b bVar) {
                    AppMethodBeat.i(63074);
                    sq sqVar = (sq) bVar;
                    ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "kv stat update click cell item");
                    h.pYm.X(11076, "1," + sqVar.cOO.cwg);
                    a.this.dNu();
                    AppMethodBeat.o(63074);
                    return true;
                }
            };
        }
        ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "add succeed send listener");
        com.tencent.mm.sdk.b.a.xxA.c(aVar.AeH);
        AppMethodBeat.o(62938);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.i(62939);
        if (this.jgc) {
            setVisibility(8);
            i = MeasureSpec.makeMeasureSpec(0, ErrorDialogData.SUPPRESSED);
            i2 = MeasureSpec.makeMeasureSpec(0, ErrorDialogData.SUPPRESSED);
        }
        super.onMeasure(i, i2);
        AppMethodBeat.o(62939);
    }

    public final void setHide(boolean z) {
        this.jgc = z;
    }

    public final void AG() {
        this.Aaj.AeA = true;
    }

    public final void AF() {
        AppMethodBeat.i(62940);
        if (this.Aai != null) {
            com.tencent.mm.view.e.a aVar = this.Aai;
            String str = "TAG_DEFAULT_TAB";
            if (!(aVar.Adt == null || aVar.Aaj == null)) {
                if (aVar.AdH) {
                    aVar.AdI = null;
                    aVar.Adt.post(new AnonymousClass5(str));
                } else {
                    aVar.AdI = str;
                }
            }
        }
        if (this.Aaj != null) {
            com.tencent.mm.by.a.dmE();
            com.tencent.mm.by.a.b bVar = com.tencent.mm.by.a.xum;
            com.tencent.mm.by.a.b.alW("TAG_DEFAULT_TAB");
        }
        AppMethodBeat.o(62940);
    }

    public final void setEntranceScene(int i) {
        AppMethodBeat.i(62941);
        com.tencent.mm.emoji.c.a.OZ().scene = i;
        if (this.Aaj != null) {
            this.Aaj.gOW = i;
        }
        AppMethodBeat.o(62941);
    }
}
