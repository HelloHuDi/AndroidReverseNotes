package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.chatroom.ui.DelChatroomMemberUI;
import com.tencent.mm.g.a.as;
import com.tencent.mm.g.a.ez;
import com.tencent.mm.g.a.tg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.n;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.f;
import com.tencent.mm.ui.chatting.c.b.r;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@a(dFp = f.class)
public class e extends a implements com.tencent.mm.ai.f, b, f {
    protected boolean yOr = false;
    protected Map<String, String> yOs = new HashMap();
    private c yOt = new c<as>() {
        {
            AppMethodBeat.i(31242);
            this.xxI = as.class.getName().hashCode();
            AppMethodBeat.o(31242);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(31243);
            as asVar = (as) bVar;
            if ((asVar instanceof as) && e.this.cgL.getTalkerUserName() != null && !bo.isNullOrNil(asVar.ctO.username) && asVar.ctO.username.equals(e.this.cgL.getTalkerUserName())) {
                e.a(e.this);
            }
            AppMethodBeat.o(31243);
            return false;
        }
    };
    private final k.a yOu = new k.a() {
        public final void a(String str, m mVar) {
            AppMethodBeat.i(31250);
            ab.v("MicroMsg.ChattingUI.ChatroomComponent", "roommember watcher notify ".concat(String.valueOf(str)));
            if (((d) e.this.cgL.aF(d.class)).dDn()) {
                e.this.yoR = com.tencent.mm.aj.a.e.c(((d) e.this.cgL.aF(d.class)).dDk());
            } else {
                e.this.yoR = n.ms(e.this.cgL.getTalkerUserName());
            }
            if (e.this.yOr) {
                n.f(e.this.cgL.getTalkerUserName(), e.this.yOs);
            } else {
                e.this.yOs.clear();
            }
            if (!bo.isNullOrNil(str)) {
                e.this.cgL.aWv();
            }
            AppMethodBeat.o(31250);
        }
    };
    private c yOv = new c<tg>() {
        {
            AppMethodBeat.i(31251);
            this.xxI = tg.class.getName().hashCode();
            AppMethodBeat.o(31251);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(31252);
            tg tgVar = (tg) bVar;
            if ((!(tgVar instanceof tg) || e.this.cgL.getTalkerUserName().equals(tgVar.cPx.userName)) && t.kH(e.this.cgL.getTalkerUserName())) {
                h.b(e.this.cgL.yTx.getContext(), e.this.cgL.yTx.getMMResources().getString(R.string.exm), null, true);
            }
            AppMethodBeat.o(31252);
            return false;
        }
    };
    com.tencent.mm.roomsdk.a.c.d yOw;
    private boolean yOx = false;
    private boolean yoR = false;

    public e() {
        AppMethodBeat.i(31258);
        AppMethodBeat.o(31258);
    }

    static /* synthetic */ void a(e eVar) {
        AppMethodBeat.i(31275);
        eVar.dDG();
        AppMethodBeat.o(31275);
    }

    public final CharSequence arj(String str) {
        AppMethodBeat.i(31259);
        d dVar = (d) this.cgL.aF(d.class);
        ad aoO = ((j) g.K(j.class)).XM().aoO(str);
        String mK = s.mK(str);
        CharSequence mJ;
        if (dVar.dDm() || bo.isNullOrNil(mK)) {
            if (this.yOs.containsKey(str)) {
                mK = (String) this.yOs.get(str);
                if (!bo.isNullOrNil(mK)) {
                    AppMethodBeat.o(31259);
                    return mK;
                }
            }
            if (dVar.dDm()) {
                mJ = dVar.dDk().mJ(str);
                AppMethodBeat.o(31259);
                return mJ;
            }
            mJ = com.tencent.mm.openim.room.a.a.a(aoO, s.mJ(str));
            AppMethodBeat.o(31259);
            return mJ;
        }
        mJ = com.tencent.mm.openim.room.a.a.a(aoO, mK);
        AppMethodBeat.o(31259);
        return mJ;
    }

    public final boolean dDE() {
        return this.yOr;
    }

    public final boolean dDF() {
        AppMethodBeat.i(31260);
        if (this.yoR || ((d) this.cgL.aF(d.class)).dDs()) {
            AppMethodBeat.o(31260);
            return true;
        }
        AppMethodBeat.o(31260);
        return false;
    }

    public final void aJ(LinkedList<String> linkedList) {
        AppMethodBeat.i(31261);
        aw.ZK();
        u oa = com.tencent.mm.model.c.XV().oa(this.cgL.getTalkerUserName());
        if (oa == null) {
            h.a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(R.string.dsc), null, this.cgL.yTx.getMMResources().getString(R.string.ds8), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AppMethodBeat.o(31261);
            return;
        }
        String str;
        this.cgL.getTalkerUserName();
        final List linkedList2 = new LinkedList();
        List afg = oa.afg();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            if (afg != null && afg.contains(str)) {
                linkedList2.add(str);
            }
        }
        if (linkedList2.size() == 0) {
            if (linkedList.size() == 1) {
                h.a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(R.string.ds7), null, this.cgL.yTx.getMMResources().getString(R.string.ds8), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(31261);
                return;
            }
            h.a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(R.string.ds2), null, this.cgL.yTx.getMMResources().getString(R.string.ds8), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AppMethodBeat.o(31261);
        } else if (linkedList.size() == 1) {
            Resources mMResources = this.cgL.yTx.getMMResources();
            Object[] objArr = new Object[1];
            str = (String) linkedList.get(0);
            if (((d) this.cgL.aF(d.class)).dDn() || this.cgL.dFw()) {
                aw.ZK();
                ad aoO = com.tencent.mm.model.c.XM().aoO(str);
                if (!(aoO == null || ((int) aoO.ewQ) == 0)) {
                    if (bo.isNullOrNil(aoO.field_conRemark)) {
                        aw.ZK();
                        oa = com.tencent.mm.model.c.XV().oa(this.cgL.getTalkerUserName());
                        if (oa == null) {
                            str = null;
                        } else {
                            str = oa.mJ(aoO.field_username);
                        }
                    } else {
                        str = aoO.field_conRemark;
                    }
                    if (bo.isNullOrNil(str)) {
                        str = aoO.field_conRemark;
                    }
                    if (bo.isNullOrNil(str)) {
                        str = aoO.Oi();
                    }
                }
            } else {
                str = null;
            }
            objArr[0] = str;
            h.a(this.cgL.yTx.getContext(), mMResources.getString(R.string.ds1, objArr), null, this.cgL.yTx.getMMResources().getString(R.string.ds9), this.cgL.yTx.getMMResources().getString(R.string.or), true, new OnClickListener() {
                final /* synthetic */ int fwD = 1;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(31256);
                    final com.tencent.mm.roomsdk.a.c.a a = com.tencent.mm.roomsdk.a.b.alY(e.this.cgL.getTalkerUserName()).a(e.this.cgL.getTalkerUserName(), linkedList2, this.fwD);
                    a.b(new com.tencent.mm.roomsdk.a.b.b() {
                        public final /* synthetic */ void a(int i, int i2, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                            AppMethodBeat.i(31253);
                            h.bQ(e.this.cgL.yTx.getContext(), e.this.cgL.yTx.getMMResources().getString(R.string.ds_));
                            AppMethodBeat.o(31253);
                        }
                    });
                    a.c(new com.tencent.mm.roomsdk.a.b.b() {
                        public final /* synthetic */ void a(int i, int i2, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                            AppMethodBeat.i(31254);
                            if (!(i == 0 && i2 == 0)) {
                                if (i2 == -2024) {
                                    com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
                                    if (jY != null) {
                                        jY.a(e.this.cgL.yTx.getContext(), null, null);
                                        AppMethodBeat.o(31254);
                                        return;
                                    }
                                    h.a(e.this.cgL.yTx.getContext(), e.this.cgL.yTx.getMMResources().getString(R.string.ds7), null, e.this.cgL.yTx.getMMResources().getString(R.string.ds8), false, new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                        }
                                    });
                                    AppMethodBeat.o(31254);
                                    return;
                                }
                                h.a(e.this.cgL.yTx.getContext(), e.this.cgL.yTx.getMMResources().getString(R.string.dsf), null, e.this.cgL.yTx.getMMResources().getString(R.string.s6), false, new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                            }
                            AppMethodBeat.o(31254);
                        }
                    });
                    Activity context = e.this.cgL.yTx.getContext();
                    e.this.cgL.yTx.getMMResources().getString(R.string.tz);
                    a.a(context, e.this.cgL.yTx.getMMResources().getString(R.string.drx), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(31255);
                            a.cancel();
                            AppMethodBeat.o(31255);
                        }
                    });
                    AppMethodBeat.o(31256);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AppMethodBeat.o(31261);
        } else {
            Intent intent = new Intent(this.cgL.yTx.getContext(), DelChatroomMemberUI.class);
            intent.putExtra("members", bo.c(linkedList2, ","));
            intent.putExtra("RoomInfo_Id", this.cgL.getTalkerUserName());
            intent.putExtra("scene", 1);
            this.cgL.startActivity(intent);
            AppMethodBeat.o(31261);
        }
    }

    public final void a(List<String> list, String str, bi biVar) {
        AppMethodBeat.i(31262);
        final com.tencent.mm.roomsdk.a.c.a a = com.tencent.mm.roomsdk.a.b.alY(this.cgL.getTalkerUserName()).a(this.cgL.dFw() ? this.cgL.getTalkerUserName() : "", list, str, biVar);
        a.b(new com.tencent.mm.roomsdk.a.b.d() {
            public final /* synthetic */ void a(int i, int i2, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                AppMethodBeat.i(31244);
                com.tencent.mm.roomsdk.a.b.d dVar = (com.tencent.mm.roomsdk.a.b.d) aVar;
                if (bo.cv(e.this.cgL.yTx.getContext()) && !e.b(e.this.cgL.yTx.getContext(), i, i2, str)) {
                    bi biVar = dVar.xuW;
                    if (biVar == null) {
                        AppMethodBeat.o(31244);
                        return;
                    }
                    biVar.dtQ();
                    aw.ZK();
                    com.tencent.mm.model.c.XO().b(biVar.field_msgSvrId, biVar);
                    Toast.makeText(e.this.cgL.yTx.getContext(), e.this.cgL.yTx.getMMResources().getString(R.string.cep), 0).show();
                    if (a.dmW()) {
                        com.tencent.mm.plugin.report.service.h.pYm.a(219, 24, (long) dVar.ehB, true);
                    }
                }
                AppMethodBeat.o(31244);
            }
        }).c(new com.tencent.mm.roomsdk.a.b.b() {
            public final /* synthetic */ void a(int i, int i2, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                AppMethodBeat.i(31257);
                if (bo.cv(e.this.cgL.yTx.getContext()) && !e.b(e.this.cgL.yTx.getContext(), i, i2, str)) {
                    ab.d("MicroMsg.ActionCallbackFunc", "scene type:%s errCode:%s, errType:%s, errMsg:%s", Integer.valueOf(610), Integer.valueOf(i2), Integer.valueOf(i), bo.nullAsNil(str));
                    h.b(e.this.cgL.yTx.getContext(), e.this.cgL.yTx.getMMResources().getString(R.string.cen), e.this.cgL.yTx.getMMResources().getString(R.string.tz), true);
                }
                AppMethodBeat.o(31257);
            }
        });
        Activity context = this.cgL.yTx.getContext();
        this.cgL.yTx.getMMResources().getString(R.string.tz);
        a.a(context, this.cgL.yTx.getMMResources().getString(R.string.dsq), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(31245);
                a.cancel();
                AppMethodBeat.o(31245);
            }
        });
        AppMethodBeat.o(31262);
    }

    private void dBr() {
        AppMethodBeat.i(31263);
        d dVar = (d) this.cgL.aF(d.class);
        if (t.kH(this.cgL.getTalkerUserName())) {
            this.yOr = n.mq(this.cgL.getTalkerUserName());
            if (this.yOr) {
                n.f(this.cgL.getTalkerUserName(), this.yOs);
            } else {
                this.yOs.clear();
            }
            ab.d("MicroMsg.ChattingUI.ChatroomComponent", "chatroom display  " + (this.yOr ? "show " : "not show"));
            AppMethodBeat.o(31263);
        } else if (dVar.dDn()) {
            this.yOr = true;
            AppMethodBeat.o(31263);
        } else {
            this.yOr = false;
            this.yOs.clear();
            AppMethodBeat.o(31263);
        }
    }

    private void dDi() {
        AppMethodBeat.i(31264);
        aw.Rg().b(610, (com.tencent.mm.ai.f) this);
        aw.ZK();
        com.tencent.mm.model.c.XM().b(this);
        aw.Rg().b(551, (com.tencent.mm.ai.f) this);
        if (this.yOw != null) {
            this.yOw.dead();
        }
        if (aw.RK()) {
            aw.ZK();
            com.tencent.mm.model.c.XV().d(this.yOu);
            com.tencent.mm.sdk.b.a.xxA.d(this.yOt);
            com.tencent.mm.sdk.b.a.xxA.d(this.yOv);
        }
        AppMethodBeat.o(31264);
    }

    private void dDG() {
        AppMethodBeat.i(31265);
        if (this.cgL.sRl == null) {
            ab.e("MicroMsg.ChattingUI.ChatroomComponent", "getChatroomMemberDetail() talker == null");
            AppMethodBeat.o(31265);
            return;
        }
        if (t.mN(this.cgL.getTalkerUserName())) {
            ab.d("MicroMsg.ChattingUI.ChatroomComponent", "cpan[changeTalker]");
            new ak().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(31249);
                    if (e.this.cgL == null) {
                        ab.e("MicroMsg.ChattingUI.ChatroomComponent", "[getChatroomMemberDetail] mChattingContext is null!");
                        AppMethodBeat.o(31249);
                        return;
                    }
                    aw.ZK();
                    u oa = com.tencent.mm.model.c.XV().oa(e.this.cgL.getTalkerUserName());
                    if (oa != null && oa.drU()) {
                        ab.d("MicroMsg.ChattingUI.ChatroomComponent", "cpan[doScene NetSceneGetChatroomMemberDetail]");
                        com.tencent.mm.roomsdk.a.c.a D = com.tencent.mm.roomsdk.a.b.alY(e.this.cgL.getTalkerUserName()).D(e.this.cgL.getTalkerUserName(), oa.drT());
                        D.b(new com.tencent.mm.roomsdk.a.b.b() {
                            public final /* synthetic */ void a(int i, int i2, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                                AppMethodBeat.i(31248);
                                if (bo.cv(e.this.cgL.yTx.getContext())) {
                                    ab.i("MicroMsg.ActionCallbackFunc", "cpan[refresh top btn]");
                                    e.this.yoR = n.ms(e.this.cgL.getTalkerUserName());
                                    ((r) e.this.cgL.aF(r.class)).dEp();
                                }
                                AppMethodBeat.o(31248);
                            }
                        });
                        D.dmX();
                    }
                    AppMethodBeat.o(31249);
                }
            }, 1000);
        }
        AppMethodBeat.o(31265);
    }

    public final void dxx() {
        AppMethodBeat.i(31266);
        if (this.cgL.dFw()) {
            this.yoR = n.ms(this.cgL.getTalkerUserName());
        }
        AppMethodBeat.o(31266);
    }

    public final void dxy() {
        AppMethodBeat.i(31267);
        this.yOx = true;
        dBr();
        AppMethodBeat.o(31267);
    }

    public final void dxA() {
        AppMethodBeat.i(31269);
        if (!this.yOx) {
            dBr();
        }
        this.yOx = false;
        AppMethodBeat.o(31269);
    }

    public final void dxB() {
    }

    public final void dDh() {
        AppMethodBeat.i(31270);
        super.dDh();
        dDi();
        AppMethodBeat.o(31270);
    }

    public final void dxC() {
        AppMethodBeat.i(31271);
        dDi();
        AppMethodBeat.o(31271);
    }

    public void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(31272);
        ab.i("MicroMsg.ChattingUI.ChatroomComponent", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " sceneType:" + mVar.getType());
        this.cgL.dismissDialog();
        if (!this.cgL.caA) {
            ab.i("MicroMsg.ChattingUI.ChatroomComponent", "onSceneEnd fragment not foreground, return");
            AppMethodBeat.o(31272);
        } else if (!bo.cv(this.cgL.yTx.getContext())) {
            AppMethodBeat.o(31272);
        } else if (b(this.cgL.yTx.getContext(), i, i2, str)) {
            AppMethodBeat.o(31272);
        } else {
            if (i == 0 && i2 == 0) {
                switch (mVar.getType()) {
                    case 551:
                        ab.i("MicroMsg.ChattingUI.ChatroomComponent", "cpan[refresh top btn]");
                        this.yoR = n.ms(this.cgL.getTalkerUserName());
                        ((r) this.cgL.aF(r.class)).dEp();
                        break;
                }
            }
            AppMethodBeat.o(31272);
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.n nVar, Object obj) {
        AppMethodBeat.i(31273);
        if (this.cgL == null) {
            ab.e("MicroMsg.ChattingUI.ChatroomComponent", "[onNotifyChange] mChattingContext is null!");
            AppMethodBeat.o(31273);
        } else if (((d) this.cgL.aF(d.class)).dDn()) {
            this.yoR = com.tencent.mm.aj.a.e.c(((d) this.cgL.aF(d.class)).dDk());
            AppMethodBeat.o(31273);
        } else {
            this.yoR = n.ms(this.cgL.getTalkerUserName());
            AppMethodBeat.o(31273);
        }
    }

    protected static boolean b(Activity activity, int i, int i2, String str) {
        AppMethodBeat.i(31274);
        if (com.tencent.mm.ui.u.a.a(activity, i, i2, str, 7)) {
            AppMethodBeat.o(31274);
            return true;
        } else if (com.tencent.mm.ui.u.a(activity, i, i2, new Intent().setClass(activity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str)) {
            AppMethodBeat.o(31274);
            return true;
        } else {
            AppMethodBeat.o(31274);
            return false;
        }
    }

    public final void dxz() {
        AppMethodBeat.i(31268);
        if (!t.nI(this.cgL.getTalkerUserName()) && t.kH(this.cgL.getTalkerUserName())) {
            aw.ZK();
            com.tencent.mm.storage.ak aoZ = com.tencent.mm.model.c.XR().aoZ(this.cgL.getTalkerUserName());
            if (aoZ == null || (aoZ.field_showTips & 2) > 0) {
                ab.d("MicroMsg.ChattingUI.ChatroomComponent", "jacks ont need auto display name because : already tips");
            } else {
                aw.ZK();
                u oa = com.tencent.mm.model.c.XV().oa(this.cgL.getTalkerUserName());
                if (oa == null || oa.afg().size() < 20) {
                    ab.d("MicroMsg.ChattingUI.ChatroomComponent", "jacks ont need auto display name because : member nums too few");
                } else if (!(oa == null || oa.drX())) {
                    n.a(this.cgL.getTalkerUserName(), oa, true);
                    aoZ.field_showTips = 2;
                    aoZ.duQ = true;
                    aw.ZK();
                    com.tencent.mm.model.c.XR().a(aoZ, this.cgL.getTalkerUserName());
                    ab.i("MicroMsg.ChattingUI.ChatroomComponent", "Jacks Show auto Display name tips");
                    com.tencent.mm.model.m.a(this.cgL.getTalkerUserName(), null, this.cgL.yTx.getMMResources().getString(R.string.aom), false, "", 0);
                }
            }
        }
        aw.Rg().a(610, (com.tencent.mm.ai.f) this);
        aw.Rg().a(551, (com.tencent.mm.ai.f) this);
        aw.ZK();
        com.tencent.mm.model.c.XM().a(this);
        aw.ZK();
        com.tencent.mm.model.c.XV().c(this.yOu);
        if (this.yOw != null) {
            this.yOw.dead();
        }
        this.yOw = com.tencent.mm.roomsdk.a.b.alY(this.cgL.getTalkerUserName()).Ju().e(new com.tencent.mm.roomsdk.a.b.b() {
            public final /* synthetic */ void a(int i, int i2, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                AppMethodBeat.i(31247);
                e.this.cgL.dismissDialog();
                h.bQ(e.this.cgL.yTx.getContext(), e.this.cgL.yTx.getMMResources().getString(R.string.ds5));
                AppMethodBeat.o(31247);
            }
        }).f(new com.tencent.mm.roomsdk.a.b.b() {
            public final /* synthetic */ void a(int i, int i2, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                AppMethodBeat.i(31246);
                e.this.cgL.dismissDialog();
                h.a(e.this.cgL.yTx.getContext(), e.this.cgL.yTx.getMMResources().getString(R.string.dsf), null, e.this.cgL.yTx.getMMResources().getString(R.string.s6), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(31246);
            }
        }).dmY();
        com.tencent.mm.sdk.b.a.xxA.c(this.yOt);
        com.tencent.mm.sdk.b.a.xxA.c(this.yOv);
        if (t.mN(this.cgL.getTalkerUserName()) && n.mt(this.cgL.getTalkerUserName())) {
            ab.d("MicroMsg.ChattingUI.ChatroomComponent", "chattingui find chatroom contact need update %s", this.cgL.getTalkerUserName());
            ao.a.flu.ai(this.cgL.getTalkerUserName(), "");
        }
        if (!(com.tencent.mm.bh.d.fUv == null || this.cgL.getTalkerUserName().equals(com.tencent.mm.bh.d.fUv.akN()))) {
            ab.i("MicroMsg.ChattingUI.ChatroomComponent", "chatting oncreate end track %s", com.tencent.mm.bh.d.fUv.akN());
            ez ezVar = new ez();
            ezVar.cys.username = this.cgL.getTalkerUserName();
            com.tencent.mm.sdk.b.a.xxA.m(ezVar);
        }
        dDG();
        AppMethodBeat.o(31268);
    }
}
