package com.tencent.mm.ui.chatting.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bg.g;
import com.tencent.mm.bh.c;
import com.tencent.mm.bh.d;
import com.tencent.mm.g.a.ez;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MultiTalkRoomPopupNav;
import com.tencent.mm.ui.base.TalkRoomPopupNav;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.b.af;
import com.tencent.mm.ui.chatting.c.b.f;
import java.util.LinkedList;

@a(dFp = af.class)
public class an extends a implements com.tencent.mm.bg.a, c, com.tencent.mm.plugin.multitalk.model.a.a, af {
    private final k.a yOu = new k.a() {
        public final void a(String str, m mVar) {
            AppMethodBeat.i(31748);
            ab.v("MicroMsg.ChattingUI.TrackRoomComponent", "roommember watcher notify ".concat(String.valueOf(str)));
            if (!bo.isNullOrNil(str)) {
                an.a(an.this);
            }
            AppMethodBeat.o(31748);
        }
    };
    public TalkRoomPopupNav ySA;
    public MultiTalkRoomPopupNav ySB;
    private TalkRoomPopupNav.a ySC = new TalkRoomPopupNav.a() {
        public final void dAt() {
            AppMethodBeat.i(31753);
            if (com.tencent.mm.r.a.bJ(an.this.cgL.yTx.getContext()) || com.tencent.mm.r.a.bH(an.this.cgL.yTx.getContext())) {
                ab.d("MicroMsg.ChattingUI.TrackRoomComponent", "voip is running");
                AppMethodBeat.o(31753);
                return;
            }
            LinkedList tP = d.fUu.tP(an.this.cgL.sRl.field_username);
            ab.i("MicroMsg.ChattingUI.TrackRoomComponent", "Click banner : %d", Integer.valueOf(tP.size()));
            if (d.fUu.tQ(an.this.cgL.sRl.field_username)) {
                an.b(an.this);
                AppMethodBeat.o(31753);
                return;
            }
            an.this.qt(true);
            AppMethodBeat.o(31753);
        }

        public final void dAu() {
            AppMethodBeat.i(31754);
            sz szVar = new sz();
            szVar.cPf.cPi = true;
            com.tencent.mm.sdk.b.a.xxA.m(szVar);
            an.a(an.this, an.this.cgL.getTalkerUserName());
            AppMethodBeat.o(31754);
        }
    };

    static /* synthetic */ void a(an anVar, String str) {
        AppMethodBeat.i(31782);
        anVar.ars(str);
        AppMethodBeat.o(31782);
    }

    public an() {
        AppMethodBeat.i(31760);
        AppMethodBeat.o(31760);
    }

    public final boolean dFa() {
        AppMethodBeat.i(31761);
        if (this.ySA == null) {
            AppMethodBeat.o(31761);
            return false;
        } else if (this.ySA.getVisibility() == 0) {
            AppMethodBeat.o(31761);
            return true;
        } else {
            AppMethodBeat.o(31761);
            return false;
        }
    }

    public final boolean dFb() {
        AppMethodBeat.i(31762);
        if (this.ySB == null) {
            AppMethodBeat.o(31762);
            return false;
        } else if (this.ySB.getVisibility() == 0) {
            AppMethodBeat.o(31762);
            return true;
        } else {
            AppMethodBeat.o(31762);
            return false;
        }
    }

    public final int dFc() {
        AppMethodBeat.i(31763);
        if (this.ySA == null) {
            AppMethodBeat.o(31763);
            return 0;
        }
        int height = this.ySA.getHeight();
        AppMethodBeat.o(31763);
        return height;
    }

    public final void k(String str, String str2, String str3) {
        AppMethodBeat.i(31765);
        if (this.cgL != null && str.equals(this.cgL.getTalkerUserName())) {
            qs(false);
        }
        AppMethodBeat.o(31765);
    }

    public final void tR(String str) {
        AppMethodBeat.i(31766);
        if (this.cgL != null && str.equals(this.cgL.getTalkerUserName())) {
            qs(false);
        }
        AppMethodBeat.o(31766);
    }

    public final void Sf(String str) {
        AppMethodBeat.i(31767);
        if (this.cgL != null && str.equals(this.cgL.getTalkerUserName())) {
            qs(false);
        }
        AppMethodBeat.o(31767);
    }

    private void a(TalkRoomPopupNav.a aVar) {
        AppMethodBeat.i(31768);
        if (this.ySA == null) {
            i.a(this.cgL.yTx, R.id.aln);
            this.ySA = (TalkRoomPopupNav) this.cgL.findViewById(R.id.evp);
            if (this.ySA == null) {
                AppMethodBeat.o(31768);
                return;
            }
        }
        if (this.ySA != null) {
            this.ySA.setOnClickListener(aVar);
        }
        AppMethodBeat.o(31768);
    }

    private void dFd() {
        AppMethodBeat.i(31769);
        if (this.ySB == null) {
            i.a(this.cgL.yTx, R.id.alo);
            this.ySB = (MultiTalkRoomPopupNav) this.cgL.findViewById(R.id.df9);
        }
        AppMethodBeat.o(31769);
    }

    private void qs(boolean z) {
        AppMethodBeat.i(31770);
        if (this.cgL == null) {
            ab.w("MicroMsg.ChattingUI.TrackRoomComponent", "[checkTalkroomBanner] isResume:%s mChattingContext == null! maybe chattingui has Exited! this event come from post msg", Boolean.valueOf(z));
            AppMethodBeat.o(31770);
            return;
        }
        boolean z2 = ((f) this.cgL.aF(f.class)).dDF() || ((com.tencent.mm.ui.chatting.c.b.d) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDs();
        if (!t.kH(this.cgL.getTalkerUserName()) || z2) {
            dFe();
            String str;
            if (d.fUu != null && d.fUu.tQ(this.cgL.sRl.field_username)) {
                a(this.ySC);
                if (this.ySA == null) {
                    AppMethodBeat.o(31770);
                    return;
                }
                LinkedList tP = d.fUu.tP(this.cgL.sRl.field_username);
                str = "";
                if (tP == null || !tP.contains(this.cgL.dFu())) {
                    this.ySA.setIconAnim(-1);
                    this.ySA.stop();
                    this.ySA.setBgViewResource(R.drawable.a3j);
                    if (tP != null && tP.size() == 1) {
                        str = this.cgL.yTx.getMMResources().getString(R.string.exn, new Object[]{s.mJ((String) tP.get(0))});
                    } else if (tP != null) {
                        str = this.cgL.yTx.getMMResources().getString(R.string.exp, new Object[]{Integer.valueOf(tP.size())});
                    }
                    this.ySA.setIconRes(R.raw.tipsbar_icon_location);
                } else {
                    this.ySA.setBgViewResource(R.drawable.a3i);
                    str = this.cgL.yTx.getMMResources().getString(R.string.exo);
                    this.ySA.setIconRes(R.raw.tipsbar_icon_location_lightgreen);
                    this.ySA.setIconAnim(R.raw.tipsbar_icon_location_shining);
                    this.ySA.start();
                }
                this.ySA.setVisibility(0);
                this.ySA.setNavContent(str);
                ((com.tencent.mm.ui.chatting.c.b.s) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.s.class)).OB(1);
                AppMethodBeat.o(31770);
                return;
            } else if (g.fUs != null && g.fUs.tN(this.cgL.getTalkerUserName())) {
                a(this.ySC);
                sz szVar = new sz();
                szVar.cPf.cPh = true;
                com.tencent.mm.sdk.b.a.xxA.m(szVar);
                if (this.cgL.getTalkerUserName().equals(szVar.cPg.cPj)) {
                    this.ySA.setBgViewResource(R.drawable.a3i);
                } else {
                    this.ySA.setBgViewResource(R.drawable.a3j);
                }
                str = this.cgL.yTx.getMMResources().getString(R.string.euu, new Object[]{Integer.valueOf(g.fUs.tM(this.cgL.getTalkerUserName()).size())});
                this.ySA.setIconRes(R.drawable.app);
                this.ySA.setIconAnim(-1);
                this.ySA.stop();
                this.ySA.setVisibility(0);
                this.ySA.setNavContent(str);
                ((com.tencent.mm.ui.chatting.c.b.s) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.s.class)).OB(1);
                AppMethodBeat.o(31770);
                return;
            } else if (t.kH(this.cgL.getTalkerUserName())) {
                com.tencent.mm.bg.f RW = ((com.tencent.mm.plugin.multitalk.model.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.multitalk.model.a.class)).RW(this.cgL.getTalkerUserName());
                if (!(RW == null || RW.field_wxGroupId == null || !RW.field_wxGroupId.equals(this.cgL.getTalkerUserName()))) {
                    dFd();
                    if (this.ySB != null) {
                        ab.i("MicroMsg.ChattingUI.TrackRoomComponent", "show multiTalkBanner! ");
                        this.ySB.setGroupUserName(this.cgL.getTalkerUserName());
                        this.ySB.setCurrentSenderUserName(this.cgL.dFu());
                        this.ySB.setInChatRoom(z2);
                        this.ySB.pV(z);
                        this.ySB.setMultiTalkInfo(RW);
                        ((com.tencent.mm.ui.chatting.c.b.s) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.s.class)).OB(1);
                    }
                }
                AppMethodBeat.o(31770);
                return;
            } else {
                dFe();
                AppMethodBeat.o(31770);
                return;
            }
        }
        if (this.ySA != null) {
            this.ySA.setVisibility(8);
            ((com.tencent.mm.ui.chatting.c.b.s) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.s.class)).OB(-1);
        }
        if (this.ySB != null) {
            this.ySB.setInChatRoom(false);
            this.ySB.setVisibility(8);
        }
        AppMethodBeat.o(31770);
    }

    private void dFe() {
        AppMethodBeat.i(31771);
        if (this.ySA != null) {
            this.ySA.setVisibility(8);
            this.ySA.setIconAnim(-1);
            this.ySA.stop();
            ((com.tencent.mm.ui.chatting.c.b.s) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.s.class)).OB(-1);
        }
        if (this.ySB != null) {
            if (!((com.tencent.mm.plugin.multitalk.model.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.multitalk.model.a.class)).RV(this.cgL.getTalkerUserName())) {
                this.ySB.dyV();
            }
            this.ySB.setVisibility(8);
            ((com.tencent.mm.ui.chatting.c.b.s) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.s.class)).OB(-1);
        }
        AppMethodBeat.o(31771);
    }

    public final void qt(final boolean z) {
        AppMethodBeat.i(31772);
        int i = (((f) this.cgL.aF(f.class)).dDF() || ((com.tencent.mm.ui.chatting.c.b.d) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDs()) ? true : 0;
        if (t.kH(this.cgL.getTalkerUserName()) && i == 0) {
            h.b(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(R.string.eul), null, true);
            AppMethodBeat.o(31772);
            return;
        }
        sz szVar = new sz();
        szVar.cPf.cPh = true;
        com.tencent.mm.sdk.b.a.xxA.m(szVar);
        if (z) {
            if (bo.isNullOrNil(szVar.cPg.cPj) || this.cgL.getTalkerUserName().equals(szVar.cPg.cPj)) {
                ars(this.cgL.getTalkerUserName());
                AppMethodBeat.o(31772);
            } else if (this.ySA == null || this.ySA.getVisibility() != 0) {
                h.a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(R.string.eub), null, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(31759);
                        sz szVar = new sz();
                        szVar.cPf.cPi = true;
                        com.tencent.mm.sdk.b.a.xxA.m(szVar);
                        an.a(an.this, an.this.cgL.getTalkerUserName());
                        AppMethodBeat.o(31759);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(31749);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(31749);
                    }
                });
                AppMethodBeat.o(31772);
            } else {
                this.ySA.setDialogContent(this.cgL.yTx.getMMResources().getString(R.string.eub));
                TalkRoomPopupNav talkRoomPopupNav = this.ySA;
                if (talkRoomPopupNav.yAJ == null) {
                    talkRoomPopupNav.yAJ = new ScaleAnimation(1.0f, 1.0f, (((float) talkRoomPopupNav.yAL) * 1.0f) / ((float) talkRoomPopupNav.yAM), 1.0f);
                    talkRoomPopupNav.yAJ.setDuration(300);
                    talkRoomPopupNav.yAJ.setAnimationListener(new AnimationListener() {
                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            AppMethodBeat.i(30009);
                            TalkRoomPopupNav.this.yAG.startAnimation(AnimationUtils.loadAnimation(TalkRoomPopupNav.this.getContext(), R.anim.b5));
                            TalkRoomPopupNav.this.yAG.setVisibility(0);
                            AppMethodBeat.o(30009);
                        }
                    });
                }
                if (talkRoomPopupNav.yAK == null) {
                    talkRoomPopupNav.yAK = AnimationUtils.loadAnimation(talkRoomPopupNav.getContext(), R.anim.b6);
                    talkRoomPopupNav.yAK.setFillAfter(true);
                    talkRoomPopupNav.yAK.setAnimationListener(new AnimationListener() {
                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            AppMethodBeat.i(30010);
                            TalkRoomPopupNav.this.yoK.setVisibility(8);
                            TalkRoomPopupNav.this.yoK.setClickable(false);
                            AppMethodBeat.o(30010);
                        }
                    });
                }
                LayoutParams layoutParams = talkRoomPopupNav.miL.getLayoutParams();
                layoutParams.height = talkRoomPopupNav.yAM;
                talkRoomPopupNav.miL.setLayoutParams(layoutParams);
                talkRoomPopupNav.miL.startAnimation(talkRoomPopupNav.yAJ);
                talkRoomPopupNav.yoK.startAnimation(talkRoomPopupNav.yAK);
                talkRoomPopupNav.yAF.startAnimation(AnimationUtils.loadAnimation(talkRoomPopupNav.getContext(), R.anim.b5));
                talkRoomPopupNav.yAF.setVisibility(0);
                AppMethodBeat.o(31772);
            }
        } else if (d.fUu != null && d.fUu.tQ(this.cgL.sRl.field_username)) {
            String string;
            LinkedList tP = d.fUu.tP(this.cgL.sRl.field_username);
            if (tP == null || !tP.contains(this.cgL.dFu())) {
                string = this.cgL.yTx.getMMResources().getString(R.string.euh);
                i = R.string.ck7;
            } else {
                string = this.cgL.yTx.getMMResources().getString(R.string.eug);
                i = R.string.bdb;
            }
            com.tencent.mm.plugin.report.service.h.pYm.e(10997, Integer.valueOf(19), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this.cgL.yTx.getContext());
            aVar.asE(string);
            aVar.Qc(R.string.or).a(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(31755);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(31755);
                }
            });
            aVar.Qd(i).b(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(31756);
                    an.this.arr(z ? "fromBanner" : "fromPluginTalk");
                    AppMethodBeat.o(31756);
                }
            });
            aVar.aMb().show();
            AppMethodBeat.o(31772);
        } else if (bo.isNullOrNil(szVar.cPg.cPj) || this.cgL.getTalkerUserName().equals(szVar.cPg.cPj)) {
            ars(this.cgL.getTalkerUserName());
            AppMethodBeat.o(31772);
        } else {
            h.a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(R.string.eub), null, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(31757);
                    sz szVar = new sz();
                    szVar.cPf.cPi = true;
                    com.tencent.mm.sdk.b.a.xxA.m(szVar);
                    an.a(an.this, an.this.cgL.getTalkerUserName());
                    AppMethodBeat.o(31757);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(31758);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(31758);
                }
            });
            AppMethodBeat.o(31772);
        }
    }

    private void dFf() {
        AppMethodBeat.i(31773);
        cg("fromBanner", false);
        AppMethodBeat.o(31773);
    }

    public final void arr(String str) {
        AppMethodBeat.i(31775);
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 6);
        intent.putExtra("map_sender_name", this.cgL.dFu());
        intent.putExtra("map_talker_name", this.cgL.getTalkerUserName());
        intent.putExtra("fromWhereShare", str);
        com.tencent.mm.bp.d.b(this.cgL.yTx.getContext(), b.LOCATION, ".ui.RedirectUI", intent);
        AppMethodBeat.o(31775);
    }

    private void ars(String str) {
        AppMethodBeat.i(31776);
        Intent intent = new Intent();
        intent.putExtra("enter_room_username", str);
        intent.setFlags(268435456);
        com.tencent.mm.bp.d.b(this.cgL.yTx.getContext(), "talkroom", ".ui.TalkRoomUI", intent);
        AppMethodBeat.o(31776);
    }

    public final void dDh() {
        AppMethodBeat.i(31777);
        super.dDh();
        if (this.ySA != null) {
            this.ySA.stop();
        }
        AppMethodBeat.o(31777);
    }

    public final void dxA() {
        AppMethodBeat.i(31778);
        ab.i("MicroMsg.ChattingUI.TrackRoomComponent", "[onChattingResume]");
        if (g.fUs != null) {
            g.fUs.a(this);
        }
        if (d.fUu != null) {
            d.fUu.a(this);
        }
        ((com.tencent.mm.plugin.multitalk.model.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.multitalk.model.a.class)).a(this);
        qs(true);
        AppMethodBeat.o(31778);
    }

    public final void dxB() {
        AppMethodBeat.i(31779);
        ab.i("MicroMsg.ChattingUI.TrackRoomComponent", "[onChattingPause]");
        if (g.fUs != null) {
            g.fUs.b(this);
        }
        if (d.fUu != null) {
            d.fUu.b(this);
        }
        ((com.tencent.mm.plugin.multitalk.model.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.multitalk.model.a.class)).b(this);
        AppMethodBeat.o(31779);
    }

    public final void dxC() {
    }

    public final void ax(final Runnable runnable) {
        AppMethodBeat.i(31764);
        if (d.fUu == null || !d.fUu.aV(this.cgL.sRl.field_username, this.cgL.dFu())) {
            runnable.run();
            AppMethodBeat.o(31764);
            return;
        }
        h.a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(R.string.exk), this.cgL.yTx.getMMResources().getString(R.string.tz), true, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(31752);
                runnable.run();
                ez ezVar = new ez();
                ezVar.cys.username = an.this.cgL.getTalkerUserName();
                com.tencent.mm.sdk.b.a.xxA.m(ezVar);
                AppMethodBeat.o(31752);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(31764);
    }

    public final void cg(final String str, boolean z) {
        AppMethodBeat.i(31774);
        if ((d.fUu != null && d.fUu.tQ(this.cgL.sRl.field_username)) || z) {
            LinkedList tP = d.fUu.tP(this.cgL.sRl.field_username);
            if (tP == null || !tP.contains(this.cgL.dFu())) {
                com.tencent.mm.plugin.report.service.h.pYm.e(10997, Integer.valueOf(13), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                h.a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(R.string.bde), null, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(31750);
                        an.this.arr(str);
                        AppMethodBeat.o(31750);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(31751);
                        com.tencent.mm.plugin.report.service.h.pYm.e(10997, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                        dialogInterface.dismiss();
                        AppMethodBeat.o(31751);
                    }
                });
                AppMethodBeat.o(31774);
                return;
            }
        }
        arr(str);
        AppMethodBeat.o(31774);
    }

    static /* synthetic */ void b(an anVar) {
        AppMethodBeat.i(31781);
        boolean z = ((f) anVar.cgL.aF(f.class)).dDF() || ((com.tencent.mm.ui.chatting.c.b.d) anVar.cgL.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDs();
        if (!t.kH(anVar.cgL.getTalkerUserName()) || z) {
            sz szVar = new sz();
            szVar.cPf.cPh = true;
            com.tencent.mm.sdk.b.a.xxA.m(szVar);
            if (bo.isNullOrNil(szVar.cPg.cPj) || anVar.cgL.getTalkerUserName().equals(szVar.cPg.cPj)) {
                anVar.cgL.getTalkerUserName();
                anVar.dFf();
                AppMethodBeat.o(31781);
                return;
            }
            szVar = new sz();
            szVar.cPf.cPi = true;
            com.tencent.mm.sdk.b.a.xxA.m(szVar);
            anVar.cgL.getTalkerUserName();
            anVar.dFf();
            AppMethodBeat.o(31781);
            return;
        }
        h.b(anVar.cgL.yTx.getContext(), anVar.cgL.yTx.getMMResources().getString(R.string.exm), null, true);
        AppMethodBeat.o(31781);
    }
}
