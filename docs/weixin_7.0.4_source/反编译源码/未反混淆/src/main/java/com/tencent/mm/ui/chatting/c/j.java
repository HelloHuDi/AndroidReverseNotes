package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.f;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.i.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar;
import com.tencent.mm.ui.chatting.ah;
import com.tencent.mm.ui.chatting.an;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.b.aj;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.c.b.z;
import com.tencent.mm.ui.chatting.k;
import com.tencent.mm.ui.chatting.m;
import com.tencent.mm.ui.chatting.n;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.tools.o.b;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.vfs.e;
import com.tencent.wework.api.WWAPIFactory;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@a(dFp = i.class)
public class j extends a implements ah, i {
    public static az yOM = new az(5, "MicroMsg.ChattingMoreBtnBarHelper");
    private ad cFn;
    private o elS;
    private boolean hasInit = false;
    private Animation qzp;
    private boolean yFW;
    private String yLB = "";
    private boolean yNq = false;
    private ChattingFooterMoreBtnBar yON;
    private boolean yOO = true;

    static {
        AppMethodBeat.i(31343);
        AppMethodBeat.o(31343);
    }

    public final void bd(bi biVar) {
        AppMethodBeat.i(31336);
        if (biVar == null) {
            ab.w("MicroMsg.ChattingMoreBtnBarHelper", "perform search mode click msg item fail, msg is null");
            AppMethodBeat.o(31336);
            return;
        }
        h hVar = (h) this.cgL.aF(h.class);
        if (hVar.nf(biVar.field_msgId)) {
            this.yON.On(hVar.cdf());
            this.yON.setVisibility(0);
            this.elS.dJS();
        }
        AppMethodBeat.o(31336);
    }

    public final void a(ah.a aVar) {
    }

    public final boolean dDN() {
        return this.yNq;
    }

    public final void dDO() {
        AppMethodBeat.i(31339);
        if (this.elS != null) {
            this.elS.dJS();
            this.elS.zHa = null;
        }
        AppMethodBeat.o(31339);
    }

    public final void dCI() {
        AppMethodBeat.i(31340);
        dDL();
        AppMethodBeat.o(31340);
    }

    public final void b(ah.a aVar) {
        AppMethodBeat.i(31341);
        dDL();
        AppMethodBeat.o(31341);
    }

    public final boolean dCJ() {
        return this.yOO;
    }

    public final void bc(bi biVar) {
        AppMethodBeat.i(31335);
        if (this.hasInit) {
            ab.e("MicroMsg.ChattingMoreBtnBarHelper", "[init] hasInit!");
        } else {
            this.hasInit = true;
            if (this.yON == null) {
                ((ViewStub) this.cgL.findViewById(R.id.aly)).inflate();
                this.yON = (ChattingFooterMoreBtnBar) this.cgL.findViewById(R.id.av2);
            }
            if (((z) this.cgL.aF(z.class)).dEW()) {
                ab.w("MicroMsg.ChattingMoreBtnBarHelper", "is in show search chat result");
                if (this.elS != null) {
                    this.elS.zHa = null;
                }
            } else {
                this.elS = new o((byte) 0);
                this.elS.zHa = new b() {
                    String mLR = null;

                    public final void vO(String str) {
                        AppMethodBeat.i(31332);
                        ab.v("MicroMsg.ChattingMoreBtnBarHelper", "on edit change");
                        z zVar = (z) j.this.cgL.aF(z.class);
                        if (!bo.isNullOrNil(str)) {
                            ab.v("MicroMsg.ChattingMoreBtnBarHelper", "enter search mode");
                            j.this.yON.setVisibility(8);
                            zVar.dEO();
                            if (zVar.dER() != null) {
                                zVar.dER().vM(str);
                            }
                        } else if (zVar.dEW()) {
                            if (zVar.dER() != null) {
                                zVar.dER().vM("");
                            }
                            zVar.OD(-1);
                        } else if (!j.this.yNq) {
                            zVar.dEP();
                            j.this.yON.setVisibility(8);
                        } else if (this.mLR != null) {
                            zVar.dEP();
                            j.this.yON.setVisibility(0);
                            j.this.yON.On(((h) j.this.cgL.aF(h.class)).cdf());
                        }
                        this.mLR = str;
                        AppMethodBeat.o(31332);
                    }

                    public final void apo() {
                        AppMethodBeat.i(31333);
                        ab.v("MicroMsg.ChattingMoreBtnBarHelper", "onQuitSearch");
                        h hVar = (h) j.this.cgL.aF(h.class);
                        if (hVar.isInEditMode()) {
                            ((z) j.this.cgL.aF(z.class)).dEP();
                            j.this.yON.setVisibility(0);
                            j.this.yON.On(hVar.cdf());
                        }
                        AppMethodBeat.o(31333);
                    }

                    public final void app() {
                        AppMethodBeat.i(31334);
                        ab.v("MicroMsg.ChattingMoreBtnBarHelper", "onEnterSearch");
                        com.tencent.mm.plugin.report.service.h.pYm.a(219, 21, 1, true);
                        if (((h) j.this.cgL.aF(h.class)).isInEditMode()) {
                            ((z) j.this.cgL.aF(z.class)).dEO();
                            j.this.yON.setVisibility(8);
                        }
                        AppMethodBeat.o(31334);
                    }

                    public final boolean vN(String str) {
                        return false;
                    }

                    public final void apq() {
                    }

                    public final void apr() {
                    }
                };
            }
            this.yON.c(3, new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(31308);
                    final h hVar = (h) j.this.cgL.aF(h.class);
                    if (hVar.cdf() == 0) {
                        ab.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
                        AppMethodBeat.o(31308);
                        return;
                    }
                    final Context context = j.this.cgL.yTx.getContext();
                    com.tencent.mm.ui.base.h.a(context, context.getString(R.string.at7), "", context.getString(R.string.b59), context.getString(R.string.or), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(31307);
                            ab.i("MicroMsg.ChattingMoreBtnBarHelper", "delete message");
                            com.tencent.mm.ui.chatting.i.a(context, hVar.dCQ(), j.this);
                            j.this.dDL();
                            AppMethodBeat.o(31307);
                        }
                    }, null, (int) R.color.ei);
                    AppMethodBeat.o(31308);
                }
            });
            this.yON.c(2, new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(31309);
                    if (((h) j.this.cgL.aF(h.class)).cdf() == 0) {
                        ab.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
                        AppMethodBeat.o(31309);
                        return;
                    }
                    m.a(j.this.cgL, j.c(j.this), j.this.yFW, j.this, j.this.cFn);
                    AppMethodBeat.o(31309);
                }
            });
            this.yON.c(1, new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(31310);
                    if (((h) j.this.cgL.aF(h.class)).cdf() == 0) {
                        ab.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
                        AppMethodBeat.o(31310);
                        return;
                    }
                    List c = j.c(j.this);
                    if (com.tencent.mm.ui.chatting.j.eS(c)) {
                        com.tencent.mm.ui.base.h.a(j.this.cgL.yTx.getContext(), j.this.cgL.yTx.getContext().getString(R.string.b2y), "", j.this.cgL.yTx.getContext().getString(R.string.aj), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        AppMethodBeat.o(31310);
                    } else if (com.tencent.mm.ui.chatting.j.eT(c)) {
                        com.tencent.mm.ui.base.h.a(j.this.cgL.yTx.getContext(), j.this.cgL.yTx.getContext().getString(R.string.b2z), "", j.this.cgL.yTx.getContext().getString(R.string.aj), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        AppMethodBeat.o(31310);
                    } else if (com.tencent.mm.ui.chatting.j.eR(c)) {
                        com.tencent.mm.ui.base.h.a(j.this.cgL.yTx.getContext(), j.this.cgL.yTx.getContext().getString(R.string.b30), "", new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }, null);
                        AppMethodBeat.o(31310);
                    } else {
                        if (n.a(j.this.cgL, c, j.this.cFn)) {
                            j.this.dDL();
                        }
                        AppMethodBeat.o(31310);
                    }
                }
            });
            this.yON.c(0, new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(31313);
                    if (((h) j.this.cgL.aF(h.class)).cdf() == 0) {
                        ab.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
                        AppMethodBeat.o(31313);
                    } else if ((!t.mZ(j.this.cFn.field_username) || f.kq(j.this.cFn.field_username)) && !t.nJ(j.this.cFn.field_username)) {
                        d dVar = new d(j.this.cgL.yTx.getContext(), 1, false);
                        dVar.rBl = new c() {
                            public final void a(l lVar) {
                                AppMethodBeat.i(31311);
                                lVar.hi(0, R.string.d1y);
                                lVar.hi(1, R.string.d1z);
                                if (WWAPIFactory.jv(j.this.cgL.yTx.getContext()).dTK()) {
                                    Activity context = j.this.cgL.yTx.getContext();
                                    Object[] objArr = new Object[1];
                                    WWAPIFactory.jv(j.this.cgL.yTx.getContext());
                                    objArr[0] = "企业微信";
                                    lVar.e(2, context.getString(R.string.d20, objArr));
                                }
                                AppMethodBeat.o(31311);
                            }
                        };
                        dVar.rBm = new com.tencent.mm.ui.base.n.d() {
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                AppMethodBeat.i(31312);
                                switch (menuItem.getItemId()) {
                                    case 0:
                                        j.this.yOO = true;
                                        k.a(j.this.cgL.yTx.getContext(), j.c(j.this), j.this.yFW, j.this.cFn.field_username, j.this);
                                        AppMethodBeat.o(31312);
                                        return;
                                    case 1:
                                        j.this.yOO = false;
                                        k.a(j.this.cgL.yTx.getContext(), j.c(j.this), j.this.yFW, j.this.cFn.field_username, j.this);
                                        AppMethodBeat.o(31312);
                                        return;
                                    case 2:
                                        Context context = j.this.cgL.yTx.getContext();
                                        ad e = j.this.cFn;
                                        List c = j.c(j.this);
                                        boolean d = j.this.yFW;
                                        if (c.size() != 0) {
                                            if (com.tencent.mm.ui.chatting.j.eR(c)) {
                                                ab.w("MicroMsg.SendToWeWorkHelper", "isContainUndownloadFile");
                                                com.tencent.mm.ui.base.h.a(context, context.getString(R.string.b31), "", new DialogInterface.OnClickListener() {
                                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                                    }
                                                }, null);
                                            } else if (com.tencent.mm.ui.chatting.j.a(true, c, null)) {
                                                an.a(context, e, c, d);
                                            } else {
                                                ab.w("MicroMsg.SendToWeWorkHelper", "handleInvalidSendToFriendMsg");
                                                com.tencent.mm.ui.base.h.d(context, context.getString(R.string.ce3), "", context.getString(R.string.dr1), context.getString(R.string.or), new com.tencent.mm.ui.chatting.an.AnonymousClass2(context, e, c, d), null);
                                            }
                                        }
                                        j.this.dDL();
                                        break;
                                }
                                AppMethodBeat.o(31312);
                            }
                        };
                        dVar.cpD();
                        AppMethodBeat.o(31313);
                    } else {
                        j.this.yOO = true;
                        k.a(j.this.cgL.yTx.getContext(), j.c(j.this), j.this.yFW, j.this.cFn.field_username, j.this);
                        AppMethodBeat.o(31313);
                    }
                }
            });
            this.yON.c(4, new OnClickListener() {
                static /* synthetic */ void eZ(List list) {
                    AppMethodBeat.i(31331);
                    AnonymousClass6.eY(list);
                    AppMethodBeat.o(31331);
                }

                private void c(cl clVar) {
                    int i;
                    AppMethodBeat.i(31323);
                    clVar.cvA.fragment = j.this.cgL.yTx;
                    clVar.cvA.cvH = 41;
                    clVar.cvA.cvJ = new com.tencent.mm.ui.widget.snackbar.a.c() {
                        public final void onShow() {
                            AppMethodBeat.i(31314);
                            j.this.dDL();
                            j.this.yON.setVisibility(4);
                            AppMethodBeat.o(31314);
                        }

                        public final void onHide() {
                            AppMethodBeat.i(31315);
                            j.this.dDL();
                            AppMethodBeat.o(31315);
                        }

                        public final void cLd() {
                            AppMethodBeat.i(31316);
                            ((com.tencent.mm.ui.chatting.c.b.o) j.this.cgL.aF(com.tencent.mm.ui.chatting.c.b.o.class)).dEf();
                            AppMethodBeat.o(31316);
                        }
                    };
                    com.tencent.mm.sdk.b.a.xxA.m(clVar);
                    if (clVar.cvB.ret == 0) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    List<bi> c = j.c(j.this);
                    long anT = bo.anT();
                    for (bi biVar : c) {
                        if (biVar.bAA()) {
                            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(bo.anj(biVar.field_content));
                            if (!(me == null || me.type != 5 || bo.isNullOrNil(me.url))) {
                                int i2;
                                if (biVar.drC()) {
                                    i2 = 1;
                                } else {
                                    i2 = 2;
                                }
                                ab.d("MicroMsg.ChattingMoreBtnBarHelper", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), me.url, Long.valueOf(anT), Integer.valueOf(i2), Integer.valueOf(2), Integer.valueOf(1));
                                String str = "";
                                try {
                                    str = URLEncoder.encode(me.url, "UTF-8");
                                } catch (UnsupportedEncodingException e) {
                                    ab.printErrStackTrace("MicroMsg.ChattingMoreBtnBarHelper", e, "", new Object[0]);
                                }
                                com.tencent.mm.plugin.report.service.h.pYm.e(13378, str, Long.valueOf(anT), Integer.valueOf(i2), Integer.valueOf(2), Integer.valueOf(i));
                            }
                        }
                    }
                    if (clVar.cvB.ret == 0) {
                        if (14 != clVar.cvA.type) {
                            ab.d("MicroMsg.ChattingMoreBtnBarHelper", "not record type, do not report");
                            AppMethodBeat.o(31323);
                            return;
                        } else if (clVar.cvA.cvD == null) {
                            ab.e("MicroMsg.ChattingMoreBtnBarHelper", "want to report record fav, but type count is null");
                            AppMethodBeat.o(31323);
                            return;
                        } else {
                            com.tencent.mm.plugin.report.service.h.pYm.e(11142, Integer.valueOf(clVar.cvA.cvD.wiK), Integer.valueOf(clVar.cvA.cvD.wiL), Integer.valueOf(clVar.cvA.cvD.wiM), Integer.valueOf(clVar.cvA.cvD.wiN), Integer.valueOf(clVar.cvA.cvD.wiO), Integer.valueOf(clVar.cvA.cvD.wiP), Integer.valueOf(clVar.cvA.cvD.wiQ), Integer.valueOf(clVar.cvA.cvD.fileCount), Integer.valueOf(clVar.cvA.cvD.wiR), Integer.valueOf(clVar.cvA.cvD.wiS), Integer.valueOf(clVar.cvA.cvD.wiT), Integer.valueOf(clVar.cvA.cvD.wiU), Integer.valueOf(clVar.cvA.cvD.wiV), Integer.valueOf(clVar.cvA.cvD.wiW), Integer.valueOf(clVar.cvA.cvD.wiX));
                        }
                    }
                    AppMethodBeat.o(31323);
                }

                private static String eX(List<bi> list) {
                    AppMethodBeat.i(31324);
                    StringBuffer stringBuffer = new StringBuffer();
                    for (bi biVar : list) {
                        stringBuffer.append(biVar.field_msgId);
                    }
                    String stringBuffer2 = stringBuffer.toString();
                    AppMethodBeat.o(31324);
                    return stringBuffer2;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(31325);
                    List<bi> c = j.c(j.this);
                    final HashSet hashSet = new HashSet();
                    String eX = AnonymousClass6.eX(c);
                    if (eX.equals(j.this.yLB)) {
                        com.tencent.mm.ui.base.t.makeText(j.this.cgL.yTx.getContext(), j.this.cgL.yTx.getContext().getString(R.string.bna), 0).show();
                        AppMethodBeat.o(31325);
                        return;
                    }
                    j.this.yLB = eX;
                    for (final bi biVar : c) {
                        int i;
                        if (biVar.bAA()) {
                            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(biVar.field_content);
                            if (!(me == null || me.type != 6 || bo.isNullOrNil(me.fgu))) {
                                final com.tencent.mm.pluginsdk.model.app.b d = com.tencent.mm.pluginsdk.model.app.l.d(biVar, me.csD);
                                if (!(d == null || (e.ct(d.field_fileFullPath) && e.asZ(d.field_fileFullPath) == d.field_totalLen))) {
                                    ab.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav startDownload msgID:%d", Long.valueOf(biVar.field_msgId));
                                    hashSet.add(Long.valueOf(biVar.field_msgId));
                                    g gVar = new g();
                                    gVar.egl = new g.a() {
                                        public final int a(String str, int i, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
                                            AppMethodBeat.i(31320);
                                            if (i == 0 && cVar != null) {
                                                d.field_offset = (long) cVar.field_finishedLength;
                                                am.aUq().a(d, new String[0]);
                                            }
                                            if (i == 0 && dVar != null && dVar.field_retCode == 0) {
                                                ab.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav success msgID:%d", Long.valueOf(biVar.field_msgId));
                                                d.field_status = 199;
                                                d.field_offset = d.field_totalLen;
                                                am.aUq().a(d, new String[0]);
                                                biVar.setStatus(3);
                                                aw.ZK();
                                                com.tencent.mm.model.c.XO().a(biVar.field_msgId, biVar);
                                                hashSet.remove(Long.valueOf(biVar.field_msgId));
                                                AnonymousClass6.a(AnonymousClass6.this, hashSet);
                                            }
                                            if (!(i == 0 && (dVar == null || dVar.field_retCode == 0))) {
                                                String str2 = "MicroMsg.ChattingMoreBtnBarHelper";
                                                String str3 = "oreh downloadTpFileAndFav success msgID:%d, error(%d,%d)";
                                                Object[] objArr = new Object[3];
                                                objArr[0] = Long.valueOf(biVar.field_msgId);
                                                objArr[1] = Integer.valueOf(i);
                                                objArr[2] = Integer.valueOf(dVar == null ? 0 : dVar.field_retCode);
                                                ab.i(str2, str3, objArr);
                                                hashSet.remove(Long.valueOf(biVar.field_msgId));
                                                AnonymousClass6.a(AnonymousClass6.this, hashSet);
                                            }
                                            AppMethodBeat.o(31320);
                                            return 0;
                                        }

                                        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                                        }

                                        public final byte[] l(String str, byte[] bArr) {
                                            return new byte[0];
                                        }
                                    };
                                    gVar.field_mediaId = com.tencent.mm.al.c.a("checkExist", bo.anU(), biVar.field_talker, biVar.field_msgId);
                                    gVar.field_aesKey = me.eyr;
                                    gVar.field_fileType = 19;
                                    gVar.field_authKey = me.fgA;
                                    gVar.egm = me.fgu;
                                    if (d == null || bo.isNullOrNil(d.field_fileFullPath)) {
                                        aw.ZK();
                                        gVar.field_fullpath = com.tencent.mm.pluginsdk.model.app.l.X(com.tencent.mm.model.c.Ye(), me.title, me.fgp);
                                    } else {
                                        gVar.field_fullpath = d.field_fileFullPath;
                                    }
                                    if (!com.tencent.mm.al.f.afx().b(gVar, -1)) {
                                        ab.e("MicroMsg.ChattingMoreBtnBarHelper", "openim attach download failed before rescend");
                                        hashSet.remove(Long.valueOf(biVar.field_msgId));
                                    }
                                }
                            }
                        }
                        if (biVar.drE()) {
                            int i2;
                            com.tencent.mm.at.e fI = com.tencent.mm.at.o.ahl().fI(biVar.field_msgSvrId);
                            if (biVar.field_isSend == 1) {
                                if (fI.agQ()) {
                                    i = 1;
                                } else {
                                    i = 0;
                                }
                                i2 = i;
                            } else if (fI.agQ()) {
                                if (e.ct(com.tencent.mm.at.o.ahl().q(com.tencent.mm.at.f.a(fI).fDz, "", ""))) {
                                    i2 = 1;
                                } else {
                                    i2 = 0;
                                }
                            } else {
                                i2 = 0;
                            }
                            if (fI.offset < fI.frO || fI.frO == 0) {
                                ab.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav start  msgID:%d", Long.valueOf(biVar.field_msgId));
                                hashSet.add(Long.valueOf(biVar.field_msgId));
                                if (!com.tencent.mm.at.o.ahm().a(fI.fDy, biVar.field_msgId, i2, biVar, R.drawable.b0p, new com.tencent.mm.at.d.a() {
                                    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, com.tencent.mm.ai.m mVar) {
                                    }

                                    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, com.tencent.mm.ai.m mVar) {
                                        AppMethodBeat.i(31318);
                                        boolean z = i3 == 0 && i4 == 0;
                                        ab.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav taskEnd image succed: %s, msgID:%d, errType: %s, errCode:%s", Boolean.valueOf(z), Long.valueOf(biVar.field_msgId), Integer.valueOf(i3), Integer.valueOf(i4));
                                        hashSet.remove(Long.valueOf(biVar.field_msgId));
                                        AnonymousClass6.a(AnonymousClass6.this, hashSet);
                                        AppMethodBeat.o(31318);
                                    }

                                    public final void a(long j, long j2, int i, int i2, Object obj) {
                                        AppMethodBeat.i(31319);
                                        ab.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav download image taskcancel: msgID:%d", Long.valueOf(biVar.field_msgId));
                                        hashSet.remove(Long.valueOf(biVar.field_msgId));
                                        AnonymousClass6.a(AnonymousClass6.this, hashSet);
                                        AppMethodBeat.o(31319);
                                    }
                                })) {
                                    hashSet.remove(Long.valueOf(biVar.field_msgId));
                                }
                            }
                        }
                        if (biVar.bws() || biVar.bwt()) {
                            s ut = u.ut(biVar.field_imgPath);
                            if (!(ut == null || ut.status == 199)) {
                                hashSet.add(Long.valueOf(biVar.field_msgId));
                                com.tencent.mm.modelvideo.o.all().a(new com.tencent.mm.modelvideo.t.a() {
                                    public final void a(com.tencent.mm.modelvideo.t.a.a aVar) {
                                        AppMethodBeat.i(31317);
                                        if (biVar.field_imgPath.equals(aVar.fileName)) {
                                            s ut = u.ut(aVar.fileName);
                                            if (ut == null || !ut.alz()) {
                                                ab.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav fialed msgID:%d, fileName:%s", Long.valueOf(biVar.field_msgId), aVar.fileName);
                                            } else {
                                                ab.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav suc msgID:%d, fileName:%s", Long.valueOf(biVar.field_msgId), aVar.fileName);
                                            }
                                            com.tencent.mm.modelvideo.o.all().a(this);
                                            hashSet.remove(Long.valueOf(biVar.field_msgId));
                                            AnonymousClass6.a(AnonymousClass6.this, hashSet);
                                        }
                                        AppMethodBeat.o(31317);
                                    }
                                }, Looper.getMainLooper());
                                ab.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav start  msgID:%d, fileName:%s", Long.valueOf(biVar.field_msgId), biVar.field_imgPath);
                                if (ut.aly()) {
                                    ab.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete online video");
                                    i = u.uA(biVar.field_imgPath);
                                } else {
                                    ab.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete offline video");
                                    i = u.up(biVar.field_imgPath);
                                }
                                if (i != 0) {
                                    hashSet.remove(Long.valueOf(biVar.field_msgId));
                                }
                            }
                        }
                    }
                    g(hashSet);
                    AppMethodBeat.o(31325);
                }

                private void g(HashSet<Long> hashSet) {
                    AppMethodBeat.i(31326);
                    if (hashSet.isEmpty()) {
                        new ak(Looper.getMainLooper()).post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(31321);
                                AnonymousClass6.this.dDP();
                                AppMethodBeat.o(31321);
                            }
                        });
                    }
                    AppMethodBeat.o(31326);
                }

                public final void dDP() {
                    AppMethodBeat.i(31327);
                    j.this.yLB = "";
                    final List<bi> c = j.c(j.this);
                    if (com.tencent.mm.ui.chatting.j.eS(c)) {
                        com.tencent.mm.ui.base.h.a(j.this.cgL.yTx.getContext(), j.this.cgL.yTx.getContext().getString(R.string.bow), "", j.this.cgL.yTx.getContext().getString(R.string.aj), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        AppMethodBeat.o(31327);
                        return;
                    }
                    bi biVar;
                    String nW;
                    final cl clVar = new cl();
                    ab.d("MicroMsg.ChattingMoreBtnBarHelper", "want fav msgs from %s", j.this.cFn.field_username);
                    if (c.size() == 1) {
                        biVar = (bi) c.get(0);
                        if (biVar != null && (biVar.bAA() || biVar.drC())) {
                            nW = v.nW(biVar.field_msgSvrId);
                            v.b y = v.Zp().y(nW, true);
                            y.j("prePublishId", "msg_" + biVar.field_msgSvrId);
                            y.j("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(biVar, j.this.yFW, ((com.tencent.mm.ui.chatting.c.b.d) j.this.cgL.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDm()));
                            y.j("preChatName", j.this.cFn.field_username);
                            y.j("preMsgIndex", Integer.valueOf(0));
                            y.j("sendAppMsgScene", Integer.valueOf(1));
                            ((com.tencent.mm.plugin.sns.b.i) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.sns.b.i.class)).a("adExtStr", y, biVar);
                            clVar.cvA.cvF = nW;
                        }
                    }
                    if (com.tencent.mm.pluginsdk.model.g.a(j.this.cgL.yTx.getContext(), clVar, j.this.cFn.field_username, c, true)) {
                        for (bi biVar2 : c) {
                            if (biVar2.bAA()) {
                                com.tencent.mm.modelstat.b.fRa.b(biVar2, com.tencent.mm.af.k.k(biVar2));
                            } else {
                                com.tencent.mm.modelstat.b.fRa.D(biVar2);
                            }
                        }
                        c(clVar);
                        AnonymousClass6.eY(j.c(j.this));
                        AppMethodBeat.o(31327);
                    } else if (j.c(j.this).size() > 1) {
                        String string;
                        String string2;
                        Activity context = j.this.cgL.yTx.getContext();
                        if (clVar.cvA.cvG >= 0) {
                            string = j.this.cgL.yTx.getContext().getString(R.string.bov);
                        } else {
                            string = j.this.cgL.yTx.getContext().getString(R.string.bou);
                        }
                        nW = "";
                        if (clVar.cvA.cvG >= 0) {
                            string2 = j.this.cgL.yTx.getContext().getString(R.string.atd);
                        } else {
                            string2 = j.this.cgL.yTx.getContext().getString(R.string.dcq);
                        }
                        com.tencent.mm.ui.base.h.d(context, string, nW, string2, j.this.cgL.yTx.getContext().getString(R.string.atb), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(31322);
                                for (bi biVar : c) {
                                    if (!biVar.dty() && !biVar.dtx()) {
                                        if (clVar.cvA.type == 14 && clVar.cvA.cvC.wiv.size() == 0) {
                                            j.this.dDL();
                                            AppMethodBeat.o(31322);
                                            return;
                                        }
                                        AnonymousClass6.a(AnonymousClass6.this, clVar);
                                        AnonymousClass6.eZ(j.c(j.this));
                                        AppMethodBeat.o(31322);
                                        return;
                                    }
                                }
                                AppMethodBeat.o(31322);
                            }
                        }, null);
                        AppMethodBeat.o(31327);
                    } else {
                        com.tencent.mm.ui.base.h.g(j.this.cgL.yTx.getContext(), clVar.cvA.cvG, 0);
                        AppMethodBeat.o(31327);
                    }
                }

                private static void eY(List<bi> list) {
                    AppMethodBeat.i(31328);
                    for (bi a : list) {
                        com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.c.Fav, com.tencent.mm.ui.chatting.a.d.Samll, a, 0);
                    }
                    AppMethodBeat.o(31328);
                }
            });
            this.qzp = AnimationUtils.loadAnimation(this.cgL.yTx.getContext(), R.anim.cg);
            ((h) this.cgL.aF(h.class)).c(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(31306);
                    h hVar = (h) j.this.cgL.aF(h.class);
                    if (hVar.nf(((Long) view.getTag()).longValue())) {
                        int cdf = hVar.cdf();
                        ((z) j.this.cgL.aF(z.class)).dEP();
                        j.this.elS.dJS();
                        j.this.yON.setVisibility(0);
                        j.this.yON.On(cdf);
                    }
                    AppMethodBeat.o(31306);
                }
            });
        }
        this.cFn = this.cgL.sRl;
        boolean z = this.cgL.dFw() || ((com.tencent.mm.ui.chatting.c.b.d) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDn();
        this.yFW = z;
        this.yON.dCp();
        this.cgL.yTx.getController().addSearchMenu(true, this.elS);
        this.yON.startAnimation(this.qzp);
        this.yON.setVisibility(0);
        this.yNq = true;
        ((z) this.cgL.aF(z.class)).dEP();
        h hVar = (h) this.cgL.aF(h.class);
        hVar.dCS();
        hVar.dCR();
        hVar.nf(biVar.field_msgId);
        this.yON.On(hVar.cdf());
        ((com.tencent.mm.ui.chatting.c.b.l) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.l.class)).dDV();
        this.cgL.aqX();
        dDM();
        ((com.tencent.mm.ui.chatting.c.b.o) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.o.class)).dEg();
        com.tencent.mm.plugin.report.service.h.pYm.e(10811, Integer.valueOf(1));
        if (this.cFn.dsf()) {
            com.tencent.mm.ui.chatting.d.a aVar = this.cgL;
            ab.i("MicroMsg.ChattingContext", "[showOptionMenu] menuID:%d", Integer.valueOf(R.id.c1));
            aVar.yTy.removeOptionMenu(R.id.c1);
        }
        ((com.tencent.mm.ui.chatting.c.b.s) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.s.class)).dEz();
        AppMethodBeat.o(31335);
    }

    public final void dDL() {
        AppMethodBeat.i(31337);
        this.cgL.yTx.getController().addSearchMenu(false, this.elS);
        this.yON.setVisibility(8);
        ((h) this.cgL.aF(h.class)).bvQ();
        ((com.tencent.mm.ui.chatting.c.b.d) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDA();
        ((z) this.cgL.aF(z.class)).dEP();
        this.yNq = false;
        dDM();
        ((com.tencent.mm.ui.chatting.c.b.l) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.l.class)).cuB();
        ((com.tencent.mm.ui.chatting.c.b.o) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.o.class)).dEg();
        this.cgL.aqX();
        k.dCa();
        AppMethodBeat.o(31337);
    }

    private void dDM() {
        AppMethodBeat.i(31338);
        if (this.yNq) {
            this.cgL.showOptionMenu(false);
        } else {
            ((r) this.cgL.aF(r.class)).dEp();
        }
        ((aj) this.cgL.aF(aj.class)).dFn();
        AppMethodBeat.o(31338);
    }

    static /* synthetic */ List c(j jVar) {
        AppMethodBeat.i(31342);
        LinkedList linkedList = new LinkedList();
        for (Long longValue : ((h) jVar.cgL.aF(h.class)).dCQ()) {
            ab.v("MicroMsg.ChattingMoreBtnBarHelper", "select msg id %d", Long.valueOf(longValue.longValue()));
            aw.ZK();
            linkedList.add(com.tencent.mm.model.c.XO().jf(r4));
        }
        Collections.sort(linkedList, new Comparator<bi>() {
            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return (int) (((bi) obj).field_createTime - ((bi) obj2).field_createTime);
            }
        });
        AppMethodBeat.o(31342);
        return linkedList;
    }
}
