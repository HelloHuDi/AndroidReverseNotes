package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.g.a.ii;
import com.tencent.mm.g.a.lz;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.pluginsdk.model.app.aj;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.cvi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.am;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.s.i;
import com.tencent.mm.ui.chatting.s.j;
import com.tencent.mm.ui.chatting.s.l;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.wav.WavFileHeader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class d {

    public static class e extends c implements n {
        private boolean rEF = false;
        private com.tencent.mm.ui.chatting.d.a yJI;
        protected i zcO;
        protected l zcP;
        protected j zcQ;

        public final boolean dHk() {
            return true;
        }

        public final boolean aH(int i, boolean z) {
            if (z && (i == 49 || i == 335544369 || i == 402653233 || i == 369098801)) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(32852);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.n1);
                view.setTag(new c().y(view, false));
            }
            AppMethodBeat.o(32852);
            return view;
        }

        /* JADX WARNING: Missing block: B:216:0x0a21, code skipped:
            r8 = 1;
     */
        /* JADX WARNING: Missing block: B:217:0x0a25, code skipped:
            if (r8 != null) goto L_0x16db;
     */
        /* JADX WARNING: Missing block: B:219:0x0a2b, code skipped:
            if (com.tencent.mm.ui.chatting.viewitems.c.dHm() == false) goto L_0x0bb9;
     */
        /* JADX WARNING: Missing block: B:220:0x0a2d, code skipped:
            a((com.tencent.mm.ui.chatting.viewitems.d.c) r20, (com.tencent.mm.ui.chatting.c.b.h) r27.aF(com.tencent.mm.ui.chatting.c.b.h.class), r28);
     */
        /* JADX WARNING: Missing block: B:221:0x0a42, code skipped:
            if (r20.pyf == null) goto L_0x16db;
     */
        /* JADX WARNING: Missing block: B:222:0x0a44, code skipped:
            r20.pyf.setVisibility(8);
            r7 = r8;
            r12 = r6;
     */
        /* JADX WARNING: Missing block: B:242:0x0bbd, code skipped:
            if (r20.pyf == null) goto L_0x16db;
     */
        /* JADX WARNING: Missing block: B:243:0x0bbf, code skipped:
            r20.pyf.setVisibility(0);
     */
        /* JADX WARNING: Missing block: B:244:0x0bcc, code skipped:
            if (r28.getStatus() < 2) goto L_0x16db;
     */
        /* JADX WARNING: Missing block: B:245:0x0bce, code skipped:
            r20.pyf.setVisibility(8);
            r7 = r8;
            r12 = r6;
     */
        /* JADX WARNING: Missing block: B:493:0x16d6, code skipped:
            r7 = null;
            r12 = r6;
     */
        /* JADX WARNING: Missing block: B:494:0x16db, code skipped:
            r7 = r8;
            r12 = r6;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            com.tencent.mm.af.n mj;
            com.tencent.mm.af.j.b bVar;
            Object obj;
            AppMethodBeat.i(32853);
            com.tencent.mm.ui.chatting.viewitems.c.a aVar3 = (c) aVar;
            this.yJI = aVar2;
            ((com.tencent.mm.ui.chatting.c.b.j) aVar2.aF(com.tencent.mm.ui.chatting.c.b.j.class)).bg(biVar);
            aVar3.reset();
            String str2 = biVar.field_content;
            ((com.tencent.mm.ui.chatting.c.b.j) aVar2.aF(com.tencent.mm.ui.chatting.c.b.j.class)).be(biVar);
            if (str2 != null) {
                com.tencent.mm.af.j.b X = com.tencent.mm.af.j.b.X(str2, biVar.field_reserved);
                mj = com.tencent.mm.af.n.mj(str2);
                bVar = X;
            } else {
                mj = null;
                bVar = null;
            }
            ay ayVar = new ay(biVar, aVar2.dFx(), i, null, 0);
            Object obj2 = null;
            if (bVar != null) {
                final com.tencent.mm.ui.chatting.d.a aVar4;
                boolean z;
                Object obj3;
                ay ayVar2;
                Bitmap b;
                com.tencent.mm.pluginsdk.model.app.f dX = g.dX(bVar.appId, bVar.axy);
                aVar3.gnB.setText(bVar.title);
                aVar3.gnC.setText(bVar.description);
                aVar3.zbN.setMaxLines(1);
                aVar3.gnB.setTextColor(aVar2.yTx.getContext().getResources().getColor(R.color.w4));
                aVar3.gnC.setTextColor(aVar2.yTx.getContext().getResources().getColor(R.color.s0));
                aVar3.zcd.setBackgroundResource(R.drawable.b0t);
                aVar3.zcd.setPadding(0, aVar2.yTx.getContext().getResources().getDimensionPixelSize(R.dimen.lo), 0, 0);
                aVar3.zbI.setVisibility(0);
                aVar3.zcb.setVisibility(0);
                aVar3.gnC.setVisibility(0);
                aVar3.zcf.setVisibility(8);
                aVar3.zcg.setVisibility(8);
                aVar3.zbS.setVisibility(8);
                aVar3.zbR.setVisibility(8);
                aVar3.zbO.setVisibility(8);
                aVar3.zbL.setVisibility(8);
                aVar3.zbK.setVisibility(8);
                aVar3.zcq.setVisibility(8);
                aVar3.zcj.setVisibility(8);
                aVar3.zcd.setVisibility(0);
                aVar3.zcv.setVisibility(8);
                aVar3.zcC.setVisibility(8);
                com.tencent.mm.ui.chatting.viewitems.c.a.an(aVar3.zcc, aVar3.zcJ);
                String str3 = (dX == null || dX.field_appName == null || dX.field_appName.trim().length() <= 0) ? bVar.appName : dX.field_appName;
                boolean z2 = true;
                com.tencent.mm.bz.a.fromDPToPix(aVar2.yTx.getContext(), 12);
                if (bVar.type == 20 || "wxaf060266bfa9a35c".equals(bVar.appId)) {
                    z2 = com.tencent.mm.pluginsdk.p.a.dgQ().cjQ();
                }
                if (z2 && bVar.appId != null && bVar.appId.length() > 0 && g.dg(str3)) {
                    aVar3.moL.setText(g.b(aVar2.yTx.getContext(), dX, str3));
                    aVar3.zbM.setVisibility(0);
                    aVar3.moL.setVisibility(0);
                    aVar3.moL.setCompoundDrawables(null, null, null, null);
                    aVar3.zbJ.setVisibility(0);
                    if (dX == null || !dX.xy()) {
                        c.a(aVar2, (View) aVar3.moL, bVar.appId);
                    } else {
                        c.a(aVar2, (View) aVar3.moL, biVar, bVar, dX.field_packageName, biVar.field_msgSvrId);
                    }
                    aVar3.zbJ.setImageResource(R.drawable.ir);
                    c.a(aVar2, aVar3.zbJ, bVar.appId);
                } else if (bVar.type == 24) {
                    aVar3.moL.setText(ah.getContext().getString(R.string.bnl));
                    aVar3.zbM.setVisibility(0);
                    aVar3.moL.setVisibility(0);
                    aVar3.zbJ.setVisibility(8);
                } else if (bVar.type == 19 || mj.fju == 19) {
                    aVar3.moL.setText(ah.getContext().getString(R.string.alu));
                    aVar3.zbM.setVisibility(0);
                    aVar3.moL.setVisibility(0);
                    aVar3.zbJ.setVisibility(8);
                } else if (!d.a(bVar, (c) aVar3)) {
                    aVar3.zbM.setVisibility(8);
                    aVar3.moL.setVisibility(8);
                    aVar3.zbJ.setVisibility(8);
                }
                boolean z3 = false;
                aVar3.zbI.setVisibility(0);
                if (this.kuU) {
                    Bitmap bitmap = null;
                    if (!(bVar.type == 33 || bVar.type == 36 || bVar.type == 44 || b.arC(biVar.field_imgPath))) {
                        bitmap = o.ahl().a(biVar.field_imgPath, com.tencent.mm.bz.a.getDensity(aVar2.yTx.getContext()), false);
                    }
                    if (bitmap == null || bitmap.isRecycled()) {
                        z3 = true;
                    } else {
                        aVar3.zbI.setImageBitmap(bitmap);
                    }
                    if (bVar.type == 3) {
                        final c cVar = aVar3;
                        aVar4 = aVar2;
                        aVar3.zcd.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                            private boolean zcR = false;

                            public final boolean onPreDraw() {
                                AppMethodBeat.i(32839);
                                if (this.zcR) {
                                    cVar.zcd.getViewTreeObserver().removeOnPreDrawListener(this);
                                    AppMethodBeat.o(32839);
                                } else {
                                    cVar.zcd.getViewTreeObserver().removeOnPreDrawListener(this);
                                    this.zcR = true;
                                    int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(aVar4.yTx.getContext(), 24);
                                    Bitmap bitmap = bitmap;
                                    if (bitmap == null || bitmap.isRecycled()) {
                                        bitmap = com.tencent.mm.sdk.platformtools.d.au(aVar4.yTx.getContext().getResources().getColor(R.color.k0), fromDPToPix, fromDPToPix);
                                    }
                                    int height = bitmap.getHeight();
                                    if (fromDPToPix <= height) {
                                        height = fromDPToPix;
                                    }
                                    Bitmap e = com.tencent.mm.sdk.platformtools.d.e(com.tencent.mm.sdk.platformtools.d.al(Bitmap.createScaledBitmap(bitmap, height, height, true)), 20);
                                    height = cVar.zcd.getHeight();
                                    int width = cVar.zcd.getWidth();
                                    if (height == 0) {
                                        height = com.tencent.mm.bz.a.al(aVar4.yTx.getContext(), R.dimen.x5);
                                    }
                                    if (width == 0) {
                                        width = com.tencent.mm.bz.a.al(aVar4.yTx.getContext(), R.dimen.x6);
                                    }
                                    cVar.zcd.setBackgroundDrawable(new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.a(e, (int) R.drawable.b0t, width, height)));
                                    AppMethodBeat.o(32839);
                                }
                                return true;
                            }
                        });
                    }
                    z = z3;
                } else {
                    aVar3.zbI.setImageBitmap(BitmapFactory.decodeResource(aVar2.yTx.getMMResources(), R.drawable.ak9));
                    z = false;
                }
                aVar3.zbT.setOnClickListener(null);
                Bitmap b2;
                WxaAttributes zb;
                CharSequence charSequence;
                Object charSequence2;
                final com.tencent.mm.ui.chatting.viewitems.c.a aVar5;
                switch (bVar.type) {
                    case 0:
                        if (bVar.title == null || bVar.title.length() <= 0) {
                            aVar3.gnB.setVisibility(8);
                        } else {
                            aVar3.gnB.setVisibility(0);
                        }
                        aVar3.gnC.setVisibility(0);
                        aVar3.zbN.setVisibility(8);
                        aVar3.zbO.setVisibility(8);
                        aVar3.zbT.setVisibility(4);
                        aVar3.gnC.setMaxLines(2);
                        if (z) {
                            b2 = g.b(bVar.appId, 1, com.tencent.mm.bz.a.getDensity(aVar2.getContext()));
                            if (b2 != null && !b2.isRecycled()) {
                                aVar3.zbI.setImageBitmap(b2);
                                obj3 = null;
                                ayVar2 = ayVar;
                                break;
                            }
                            aVar3.zbI.setImageResource(R.raw.app_attach_file_icon_webpage);
                            obj3 = null;
                            ayVar2 = ayVar;
                            break;
                        }
                        break;
                    case 3:
                        if (bVar.title == null || bVar.title.length() <= 0) {
                            aVar3.gnB.setVisibility(8);
                        } else {
                            aVar3.gnB.setVisibility(0);
                            aVar3.gnB.setTextColor(aVar2.yTx.getContext().getResources().getColor(R.color.a69));
                        }
                        aVar3.gnC.setVisibility(0);
                        aVar3.gnC.setTextColor(aVar2.yTx.getContext().getResources().getColor(R.color.a69));
                        aVar3.zbN.setVisibility(8);
                        aVar3.zbO.setVisibility(4);
                        aVar3.gnC.setMaxLines(2);
                        aVar3.zbT.setVisibility(0);
                        if ((biVar.field_msgId).equals(aVar.zbz)) {
                            aVar3.zbT.setImageResource(R.drawable.vq);
                        } else {
                            aVar3.zbT.setImageResource(R.drawable.vs);
                        }
                        f fVar = new f();
                        fVar.cvx = biVar.field_msgId;
                        fVar.cHz = biVar.field_content;
                        fVar.imgPath = biVar.field_imgPath;
                        aVar3.zbT.setTag(fVar);
                        aVar3.zbT.setOnClickListener(((h) aVar2.aF(h.class)).dDa());
                        if (z) {
                            b2 = g.b(bVar.appId, 1, com.tencent.mm.bz.a.getDensity(aVar2.yTx.getContext()));
                            if (b2 == null || b2.isRecycled()) {
                                aVar3.zbI.setImageResource(R.raw.app_attach_file_icon_music);
                            } else {
                                aVar3.zbI.setImageBitmap(b2);
                            }
                        }
                        if (!c.dHm()) {
                            if (aVar3.pyf != null) {
                                aVar3.pyf.setVisibility(0);
                                if (biVar.field_status >= 2) {
                                    aVar3.pyf.setVisibility(8);
                                    obj3 = null;
                                    ayVar2 = ayVar;
                                    break;
                                }
                            }
                        } else if (aVar3.pyf != null) {
                            aVar3.pyf.setVisibility(8);
                            obj3 = null;
                            ayVar2 = ayVar;
                            break;
                        }
                        break;
                    case 4:
                        if (bVar.title == null || bVar.title.length() <= 0) {
                            aVar3.gnB.setVisibility(8);
                        } else {
                            aVar3.gnB.setVisibility(0);
                        }
                        aVar3.gnC.setVisibility(0);
                        aVar3.zbN.setVisibility(8);
                        aVar3.gnC.setMaxLines(2);
                        aVar3.zbO.setVisibility(4);
                        aVar3.zbT.setVisibility(0);
                        aVar3.zbT.setImageResource(R.drawable.a4k);
                        if (z) {
                            b2 = g.b(bVar.appId, 1, com.tencent.mm.bz.a.getDensity(aVar2.yTx.getContext()));
                            if (b2 == null || b2.isRecycled()) {
                                aVar3.zbI.setImageResource(R.raw.app_attach_file_icon_video);
                            } else {
                                aVar3.zbI.setImageBitmap(b2);
                            }
                            aVar3.zbT.setVisibility(8);
                            obj3 = null;
                            ayVar2 = ayVar;
                            break;
                        }
                        break;
                    case 5:
                        com.tencent.mm.af.e eVar = (com.tencent.mm.af.e) bVar.X(com.tencent.mm.af.e.class);
                        if (eVar == null || eVar.fgb != 1 || eVar.ffZ != 5 || !((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.b.class)).aVP()) {
                            aVar3.gnB.setVisibility(8);
                            if (bVar.title == null || bVar.title.length() <= 0) {
                                aVar3.zbN.setVisibility(8);
                            } else {
                                aVar3.zbN.setMaxLines(2);
                                aVar3.zbN.setVisibility(0);
                                aVar3.zbN.setText(bVar.title);
                            }
                            aVar3.gnC.setMaxLines(3);
                            aVar3.zbO.setVisibility(4);
                            if (d.h(bVar)) {
                                aVar3.zbT.setImageResource(R.drawable.a4k);
                                aVar3.zbT.setVisibility(0);
                            } else {
                                aVar3.zbT.setVisibility(8);
                            }
                            if (z) {
                                b2 = g.b(bVar.appId, 1, com.tencent.mm.bz.a.getDensity(aVar2.yTx.getContext()));
                                if (b2 == null) {
                                    com.tencent.mm.at.a.a.c.a aVar6 = new com.tencent.mm.at.a.a.c.a();
                                    aVar6.ePT = R.raw.app_attach_file_icon_webpage;
                                    aVar6.ePG = true;
                                    aVar6.ePK = com.tencent.mm.plugin.i.c.bGF();
                                    aVar6.ct(com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 50), com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 50)).ePF = true;
                                    o.ahp().a(bo.isNullOrNil(bVar.thumburl) ? bVar.fgv : bVar.thumburl, aVar3.zbI, aVar6.ahG());
                                } else if (b2.isRecycled()) {
                                    aVar3.zbI.setImageResource(R.raw.app_attach_file_icon_webpage);
                                } else {
                                    aVar3.zbI.setImageBitmap(b2);
                                }
                            }
                            if (c.dHm()) {
                                a((c) aVar3, (h) aVar2.aF(h.class), biVar);
                                if (aVar3.pyf != null) {
                                    aVar3.pyf.setVisibility(8);
                                }
                            } else if (aVar3.pyf != null) {
                                aVar3.pyf.setVisibility(0);
                                if (biVar.field_status >= 2) {
                                    aVar3.pyf.setVisibility(8);
                                }
                            }
                            if (bVar != null) {
                                int ad = u.ad(b(aVar2, biVar), aVar2.getTalkerUserName());
                                int i2 = -1;
                                eVar = (com.tencent.mm.af.e) bVar.X(com.tencent.mm.af.e.class);
                                if (eVar != null) {
                                    i2 = eVar.ffZ;
                                }
                                ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.b.class)).a(bVar.url, i2, 1, Long.valueOf(biVar.field_msgSvrId), str, Integer.valueOf(ad));
                                if (!(this.rEF || i2 == -1 || !((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.b.class)).rW(23))) {
                                    this.rEF = true;
                                    ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.b.class)).rX(1);
                                }
                                obj3 = null;
                                ayVar2 = ayVar;
                                break;
                            }
                        }
                        c.a(aVar2, (c) aVar3, bVar, biVar, z);
                        obj3 = null;
                        ayVar2 = ayVar;
                        break;
                        break;
                    case 6:
                        if (bVar.title == null || bVar.title.length() <= 0) {
                            aVar3.gnB.setVisibility(8);
                        } else {
                            aVar3.gnB.setVisibility(0);
                            aVar3.gnB.setMaxLines(2);
                        }
                        aVar3.gnC.setVisibility(0);
                        aVar3.zbN.setVisibility(8);
                        aVar3.zbO.setVisibility(4);
                        aVar3.gnC.setMaxLines(2);
                        aVar3.gnC.setText(bo.ga((long) bVar.fgo));
                        aVar3.zbT.setVisibility(8);
                        c.a(aVar3, str2, bVar.fgo);
                        c.a((c) aVar3, Boolean.FALSE, biVar, bVar.csD, bVar.title);
                        if (z) {
                            if (!bo.any(bVar.fgp)) {
                                aVar3.zbI.setImageResource(com.tencent.mm.pluginsdk.model.o.aiD(bVar.fgp));
                                obj3 = null;
                                ayVar2 = ayVar;
                                break;
                            }
                            aVar3.zbI.setImageResource(R.drawable.aay);
                            obj3 = null;
                            ayVar2 = ayVar;
                            break;
                        }
                        break;
                    case 7:
                        aVar3.gnB.setVisibility(8);
                        if (bVar.title == null || bVar.title.length() <= 0) {
                            aVar3.zbN.setVisibility(8);
                        } else {
                            aVar3.zbN.setMaxLines(2);
                            aVar3.zbN.setVisibility(0);
                            aVar3.zbN.setText(bVar.title);
                        }
                        aVar3.gnC.setMaxLines(3);
                        aVar3.zbO.setVisibility(4);
                        aVar3.zbT.setVisibility(8);
                        if (z) {
                            b2 = g.b(bVar.appId, 1, com.tencent.mm.bz.a.getDensity(aVar2.getContext()));
                            if (b2 == null || b2.isRecycled()) {
                                aVar3.zbI.setImageResource(R.raw.app_attach_file_icon_webpage);
                            } else {
                                aVar3.zbI.setImageBitmap(b2);
                            }
                        }
                        if (!c.dHm()) {
                            if (aVar3.pyf != null) {
                                aVar3.pyf.setVisibility(0);
                                if (biVar.getStatus() >= 2) {
                                    aVar3.pyf.setVisibility(8);
                                    obj3 = null;
                                    ayVar2 = ayVar;
                                    break;
                                }
                            }
                        } else if (aVar3.pyf != null) {
                            aVar3.pyf.setVisibility(8);
                            obj3 = null;
                            ayVar2 = ayVar;
                            break;
                        }
                        break;
                    case 10:
                        aVar3.zbN.setVisibility(0);
                        if (bVar.fgP == 1) {
                            aVar3.zbN.setText(R.string.dyb);
                        } else if (bVar.fgP == 2) {
                            aVar3.zbN.setText(R.string.dyd);
                        } else if (bVar.fgP == 3) {
                            aVar3.zbN.setText(R.string.dyc);
                        } else {
                            aVar3.zbN.setText(R.string.dye);
                        }
                        if (bVar.title != null && bVar.title.length() > 0) {
                            aVar3.gnB.setVisibility(0);
                            aVar3.gnB.setText(bVar.title);
                        }
                        aVar3.gnC.setMaxLines(4);
                        aVar3.zbO.setVisibility(4);
                        aVar3.zbT.setVisibility(8);
                        if (z) {
                            b2 = o.ahl().b(biVar.HF(), com.tencent.mm.bz.a.getDensity(aVar2.getContext()), false);
                            if (b2 != null && !b2.isRecycled()) {
                                aVar3.zbI.setImageBitmap(b2);
                                obj3 = null;
                                ayVar2 = ayVar;
                                break;
                            }
                            aVar3.zbI.setImageResource(R.raw.app_attach_file_icon_webpage);
                            obj3 = null;
                            ayVar2 = ayVar;
                            break;
                        }
                        break;
                    case 13:
                        aVar3.gnB.setVisibility(0);
                        aVar3.gnB.setText(bVar.title);
                        aVar3.zbN.setVisibility(0);
                        aVar3.zbN.setText(R.string.amu);
                        aVar3.gnC.setMaxLines(4);
                        aVar3.zbO.setVisibility(4);
                        aVar3.zbT.setVisibility(8);
                        if (z) {
                            b2 = o.ahl().b(biVar.HF(), com.tencent.mm.bz.a.getDensity(aVar2.getContext()), false);
                            if (b2 != null && !b2.isRecycled()) {
                                aVar3.zbI.setImageBitmap(b2);
                                obj3 = null;
                                ayVar2 = ayVar;
                                break;
                            }
                            aVar3.zbI.setImageResource(R.raw.app_attach_file_icon_webpage);
                            obj3 = null;
                            ayVar2 = ayVar;
                            break;
                        }
                        break;
                    case 15:
                        if (bVar.title == null || bVar.title.length() <= 0) {
                            aVar3.gnB.setVisibility(8);
                        } else {
                            aVar3.gnB.setVisibility(0);
                        }
                        aVar3.gnC.setVisibility(0);
                        aVar3.zbN.setVisibility(8);
                        aVar3.zbT.setVisibility(8);
                        aVar3.zbO.setVisibility(4);
                        aVar3.gnC.setMaxLines(2);
                        if (z) {
                            b = o.ahl().b(biVar.HF(), com.tencent.mm.bz.a.getDensity(aVar2.getContext()), false);
                            if (b == null || b.isRecycled()) {
                                aVar3.zbI.setImageResource(R.raw.app_attach_file_icon_webpage);
                            } else {
                                aVar3.zbI.setImageBitmap(b);
                            }
                        }
                        ayVar = new ay(biVar, false, i, "", false, aVar2.dDw(), bVar.cMg, bVar.cMh, bVar.title, bVar.fgX, bVar.url, false, false);
                        aVar3.zcc.setTag(ayVar);
                        aVar3.zcc.setOnClickListener(i(aVar2));
                        obj2 = 1;
                        obj3 = null;
                        ayVar2 = ayVar;
                        break;
                    case 16:
                        aVar3.gnB.setVisibility(0);
                        aVar3.gnB.setText(bVar.description);
                        aVar3.gnC.setText(bVar.fhC);
                        if (bVar.title == null || bVar.title.length() <= 0) {
                            aVar3.zbN.setVisibility(8);
                        } else {
                            aVar3.zbN.setVisibility(0);
                            aVar3.zbN.setText(bVar.title);
                        }
                        aVar3.gnC.setMaxLines(4);
                        aVar3.zbO.setVisibility(4);
                        aVar3.zbT.setVisibility(8);
                        if (z) {
                            b2 = o.ahl().b(biVar.HF(), com.tencent.mm.bz.a.getDensity(aVar2.getContext()), false);
                            if (b2 == null) {
                                aVar3.zbI.setImageResource(R.raw.app_attach_file_icon_webpage);
                                obj3 = null;
                                ayVar2 = ayVar;
                                break;
                            }
                            aVar3.zbI.setImageBitmap(b2);
                            obj3 = null;
                            ayVar2 = ayVar;
                            break;
                        }
                        break;
                    case 19:
                        c.a(aVar2, aVar3, bVar, z);
                        if (!c.dHm()) {
                            if (aVar3.pyf != null) {
                                aVar3.pyf.setVisibility(0);
                                if (biVar.getStatus() >= 2) {
                                    aVar3.pyf.setVisibility(8);
                                    obj3 = null;
                                    ayVar2 = ayVar;
                                    break;
                                }
                            }
                        }
                        a((c) aVar3, (h) aVar2.aF(h.class), biVar);
                        if (aVar3.pyf != null) {
                            aVar3.pyf.setVisibility(8);
                            obj3 = null;
                            ayVar2 = ayVar;
                            break;
                        }
                    case 20:
                        if (bVar.title != null && bVar.title.length() > 0) {
                            aVar3.gnB.setVisibility(0);
                            aVar3.gnB.setText(bVar.title);
                            aVar3.zbN.setVisibility(8);
                        }
                        aVar3.gnC.setMaxLines(4);
                        aVar3.zbO.setVisibility(4);
                        aVar3.zbT.setVisibility(8);
                        if (z) {
                            b2 = o.ahl().b(biVar.HF(), com.tencent.mm.bz.a.getDensity(aVar2.getContext()), false);
                            if (b2 != null && !b2.isRecycled()) {
                                aVar3.zbI.setImageBitmap(b2);
                                obj3 = null;
                                ayVar2 = ayVar;
                                break;
                            }
                            aVar3.zbI.setImageResource(R.raw.app_attach_file_icon_webpage);
                            obj3 = null;
                            ayVar2 = ayVar;
                            break;
                        }
                        break;
                    case 24:
                        aVar3.gnB.setVisibility(8);
                        aVar3.zbN.setVisibility(0);
                        if (bVar.title == null || bVar.title.length() <= 0) {
                            aVar3.zbN.setText(com.tencent.mm.pluginsdk.ui.e.j.b(aVar3.zbN.getContext(), ah.getContext().getString(R.string.bsc), (int) aVar3.zbN.getTextSize()));
                        } else {
                            aVar3.zbN.setText(com.tencent.mm.pluginsdk.ui.e.j.b(aVar3.zbN.getContext(), bVar.title, (int) aVar3.zbN.getTextSize()));
                        }
                        aVar3.gnC.setMaxLines(3);
                        aVar3.zbO.setVisibility(4);
                        aVar3.zbT.setVisibility(8);
                        if (z) {
                            aVar3.zbI.setVisibility(8);
                        }
                        c.b(aVar2, aVar3, bVar, biVar, z);
                        if (!c.dHm()) {
                            if (aVar3.pyf != null) {
                                aVar3.pyf.setVisibility(0);
                                if (biVar.getStatus() >= 2) {
                                    aVar3.pyf.setVisibility(8);
                                    obj3 = null;
                                    ayVar2 = ayVar;
                                    break;
                                }
                            }
                        }
                        a((c) aVar3, (h) aVar2.aF(h.class), biVar);
                        if (aVar3.pyf != null) {
                            aVar3.pyf.setVisibility(8);
                            obj3 = null;
                            ayVar2 = ayVar;
                            break;
                        }
                        break;
                    case 25:
                        if (bVar.title == null || bVar.title.length() <= 0) {
                            aVar3.gnB.setVisibility(8);
                        } else {
                            aVar3.gnB.setVisibility(0);
                        }
                        aVar3.gnC.setVisibility(0);
                        aVar3.zbN.setVisibility(8);
                        aVar3.zbT.setVisibility(8);
                        aVar3.zbO.setVisibility(4);
                        aVar3.gnC.setMaxLines(2);
                        if (z) {
                            b = o.ahl().b(biVar.HF(), com.tencent.mm.bz.a.getDensity(aVar2.getContext()), false);
                            if (b == null || b.isRecycled()) {
                                aVar3.zbI.setImageResource(R.raw.app_attach_file_icon_webpage);
                            } else {
                                aVar3.zbI.setImageBitmap(b);
                            }
                        }
                        ayVar = new ay(biVar, i, "", aVar2.dDw(), bVar.cMg, bVar.cMh, bVar.title, bVar.fiD, bVar.designerName, bVar.designerRediretctUrl, bVar.url);
                        aVar3.zcc.setTag(ayVar);
                        FrameLayout frameLayout = aVar3.zcc;
                        if (this.zcO == null) {
                            this.zcO = new i(aVar2);
                        }
                        frameLayout.setOnClickListener(this.zcO);
                        obj2 = 1;
                        obj3 = null;
                        ayVar2 = ayVar;
                        break;
                    case 26:
                    case 27:
                        if (bVar.title == null || bVar.title.length() <= 0) {
                            aVar3.gnB.setVisibility(8);
                        } else {
                            aVar3.gnB.setVisibility(0);
                        }
                        aVar3.gnC.setVisibility(0);
                        aVar3.zbN.setVisibility(8);
                        aVar3.zbT.setVisibility(8);
                        aVar3.zbO.setVisibility(4);
                        aVar3.gnC.setMaxLines(2);
                        if (z) {
                            if (bo.isNullOrNil(biVar.HF())) {
                                o.ahp().a(bVar.thumburl, aVar3.zbI);
                            } else {
                                b = o.ahl().b(biVar.HF(), com.tencent.mm.bz.a.getDensity(aVar2.getContext()), false);
                                if (b == null || b.isRecycled()) {
                                    aVar3.zbI.setImageResource(R.raw.app_attach_file_icon_webpage);
                                } else {
                                    aVar3.zbI.setImageBitmap(b);
                                }
                            }
                        }
                        ayVar2 = new ay();
                        ayVar2.cKd = biVar;
                        ayVar2.yFW = false;
                        ayVar2.position = i;
                        ayVar2.zis = false;
                        ayVar2.title = aVar2.dDw();
                        ayVar2.cMg = bVar.cMg;
                        ayVar2.cMh = bVar.cMh;
                        ayVar2.zit = bVar.title;
                        FrameLayout frameLayout2;
                        if (bVar.type == 26) {
                            ayVar2.tid = bVar.tid;
                            ayVar2.fiE = bVar.fiE;
                            ayVar2.desc = bVar.desc;
                            ayVar2.iconUrl = bVar.iconUrl;
                            ayVar2.secondUrl = bVar.secondUrl;
                            ayVar2.pageType = bVar.pageType;
                            frameLayout2 = aVar3.zcc;
                            if (this.zcP == null) {
                                this.zcP = new l(aVar2);
                            }
                            frameLayout2.setOnClickListener(this.zcP);
                            obj = 1;
                        } else if (bVar.type == 27) {
                            ayVar2.tid = bVar.tid;
                            ayVar2.fiE = bVar.fiE;
                            ayVar2.desc = bVar.desc;
                            ayVar2.iconUrl = bVar.iconUrl;
                            ayVar2.secondUrl = bVar.secondUrl;
                            ayVar2.pageType = bVar.pageType;
                            frameLayout2 = aVar3.zcc;
                            if (this.zcQ == null) {
                                this.zcQ = new j(aVar2);
                            }
                            frameLayout2.setOnClickListener(this.zcQ);
                            obj = 1;
                        } else {
                            ab.i("MicroMsg.ChattingItemAppMsgTo", "unknow view type");
                            obj = null;
                        }
                        aVar3.zcc.setTag(ayVar2);
                        obj3 = null;
                        obj2 = obj;
                        break;
                    case 33:
                        zb = ((com.tencent.mm.plugin.appbrand.service.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.d.class)).zb(bVar.fiP);
                        switch (bVar.fiR) {
                            case 0:
                                aVar3.zbM.setVisibility(0);
                                aVar3.zbJ.setVisibility(0);
                                aVar3.zbJ.setBackground(null);
                                aVar3.zbJ.setImageResource(R.raw.app_brand_we_app_logo_share);
                                d.a(aVar3.moL, bVar);
                                break;
                            case 1:
                                if (zb != null) {
                                    charSequence2 = zb.field_nickname;
                                } else {
                                    charSequence2 = bVar.title;
                                }
                                str3 = zb != null ? zb.field_smallHeadURL : null;
                                aVar3.zcd.setVisibility(8);
                                aVar3.zcq.setVisibility(8);
                                aVar3.zcj.setVisibility(0);
                                aVar3.zcl.setText(charSequence2);
                                aVar3.zcv.setVisibility(8);
                                if (!bo.isNullOrNil(str3)) {
                                    com.tencent.mm.modelappbrand.a.b.abR().a(aVar3.zck, str3, com.tencent.mm.modelappbrand.a.a.abQ(), com.tencent.mm.modelappbrand.a.f.fqH);
                                    charSequence2 = null;
                                    break;
                                }
                                com.tencent.mm.modelappbrand.a.b.abR().a(aVar3.zck, "file://".concat(String.valueOf(o.ahl().so(biVar.HF()))), com.tencent.mm.modelappbrand.a.a.abQ(), com.tencent.mm.modelappbrand.a.f.fqH);
                                charSequence2 = null;
                                break;
                            case 2:
                            case 3:
                                if (zb != null) {
                                    charSequence2 = zb.field_nickname;
                                } else {
                                    charSequence2 = bVar.cMh;
                                }
                                if (zb != null) {
                                    str3 = zb.field_smallHeadURL;
                                } else {
                                    str3 = bVar.fjb;
                                }
                                aVar3.zcd.setVisibility(8);
                                aVar3.zcq.setVisibility(0);
                                aVar3.zcj.setVisibility(8);
                                aVar3.zcm.setVisibility(8);
                                aVar3.zcv.setVisibility(8);
                                aVar3.zct.setText(bVar.title);
                                aVar3.zcm.setText(bVar.description);
                                aVar3.zco.setText(charSequence2);
                                d.a(aVar3.zcp, bVar);
                                o.ahp().a(str3, aVar3.zcn, d.zel);
                                str3 = o.ahl().so(biVar.field_imgPath);
                                aVar3.zcr.setImageBitmap(null);
                                aVar5 = aVar3;
                                com.tencent.mm.modelappbrand.a.b.abR().a(new com.tencent.mm.modelappbrand.a.b.i() {
                                    public final void abU() {
                                    }

                                    public final void x(Bitmap bitmap) {
                                        AppMethodBeat.i(32840);
                                        if (bitmap == null || bitmap.isRecycled()) {
                                            aVar5.zcr.setVisibility(4);
                                            aVar5.zcs.setVisibility(0);
                                            AppMethodBeat.o(32840);
                                            return;
                                        }
                                        aVar5.zcr.setImageBitmap(bitmap);
                                        aVar5.zcr.setVisibility(0);
                                        aVar5.zcs.setVisibility(4);
                                        AppMethodBeat.o(32840);
                                    }

                                    public final void mr() {
                                    }

                                    public final String wP() {
                                        AppMethodBeat.i(32841);
                                        String str = "CHAT#" + com.tencent.mm.plugin.appbrand.r.n.bE(this);
                                        AppMethodBeat.o(32841);
                                        return str;
                                    }
                                }, "file://".concat(String.valueOf(str3)), null, ((com.tencent.mm.modelappbrand.i) com.tencent.mm.kernel.g.K(com.tencent.mm.modelappbrand.i.class)).cq(240, az.CTRL_INDEX));
                                charSequence2 = null;
                                break;
                        }
                        break;
                    case 34:
                        if (bVar.title == null || bVar.title.length() <= 0) {
                            aVar3.gnB.setVisibility(8);
                        } else {
                            aVar3.gnB.setVisibility(0);
                            if (bo.isNullOrNil(bVar.fhL)) {
                                aVar3.gnB.setTextColor(aVar2.getContext().getResources().getColor(R.color.h4));
                            } else if (bo.isNullOrNil(bVar.fhL)) {
                                aVar3.gnB.setTextColor(aVar2.getContext().getResources().getColor(R.color.h4));
                            } else {
                                aVar3.gnB.setTextColor(bo.bS(bVar.fhL, aVar2.getContext().getResources().getColor(R.color.h4)));
                            }
                        }
                        aVar3.gnC.setMaxLines(2);
                        aVar3.gnC.setVisibility(0);
                        if (bo.isNullOrNil(bVar.fhM)) {
                            aVar3.gnC.setTextColor(aVar2.getContext().getResources().getColor(R.color.rb));
                        } else {
                            aVar3.gnC.setTextColor(bo.bS(bVar.fhM, aVar2.getContext().getResources().getColor(R.color.rb)));
                        }
                        aVar3.zbN.setVisibility(8);
                        aVar3.zbO.setVisibility(4);
                        aVar3.zbT.setVisibility(8);
                        aVar3.zbM.setVisibility(0);
                        aVar3.moL.setVisibility(0);
                        if (bo.isNullOrNil(bVar.fhH)) {
                            aVar3.moL.setText(R.string.als);
                        } else {
                            aVar3.moL.setText(bVar.fhH);
                        }
                        if (!this.kuU) {
                            aVar3.zbI.setImageBitmap(BitmapFactory.decodeResource(aVar2.yTx.getMMResources(), R.drawable.ak9));
                            obj3 = null;
                            ayVar2 = ayVar;
                            break;
                        }
                        b2 = o.ahl().e(biVar.HF(), com.tencent.mm.bz.a.getDensity(aVar2.getContext()));
                        if (!(b2 == null || b2.isRecycled())) {
                            aVar3.zbI.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(b2, false, (float) (b2.getWidth() / 2)));
                        }
                        if (!bo.isNullOrNil(bVar.fhK)) {
                            aVar5 = aVar3;
                            aVar4 = aVar2;
                            o.ahp().a(bVar.fhK, new ImageView(aVar2.getContext()), new com.tencent.mm.at.a.a.c.a().ahD().ahG(), new com.tencent.mm.at.a.c.g() {
                                public final void sH(String str) {
                                }

                                public final Bitmap a(String str, View view, com.tencent.mm.at.a.d.b bVar) {
                                    return null;
                                }

                                public final void b(String str, View view, com.tencent.mm.at.a.d.b bVar) {
                                    AppMethodBeat.i(32848);
                                    if (bVar.bitmap != null) {
                                        final Bitmap bitmap = bVar.bitmap;
                                        aVar5.zcd.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                                            public final boolean onPreDraw() {
                                                AppMethodBeat.i(32847);
                                                aVar5.zcd.getViewTreeObserver().removeOnPreDrawListener(this);
                                                int height = aVar5.zcd.getHeight();
                                                int width = aVar5.zcd.getWidth();
                                                if (height == 0) {
                                                    height = com.tencent.mm.bz.a.al(aVar4.yTx.getContext(), R.dimen.x5);
                                                }
                                                if (width == 0) {
                                                    width = com.tencent.mm.bz.a.al(aVar4.yTx.getContext(), R.dimen.x6);
                                                }
                                                aVar5.zcd.setBackgroundDrawable(new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.a(bitmap, (int) R.drawable.b0t, width, height)));
                                                AppMethodBeat.o(32847);
                                                return true;
                                            }
                                        });
                                    }
                                    AppMethodBeat.o(32848);
                                }
                            });
                            obj3 = null;
                            ayVar2 = ayVar;
                            break;
                        }
                        aVar5 = aVar3;
                        aVar4 = aVar2;
                        aVar3.zcd.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                            private boolean zcR = false;

                            public final boolean onPreDraw() {
                                AppMethodBeat.i(32849);
                                if (this.zcR) {
                                    aVar5.zcd.getViewTreeObserver().removeOnPreDrawListener(this);
                                    AppMethodBeat.o(32849);
                                } else {
                                    aVar5.zcd.getViewTreeObserver().removeOnPreDrawListener(this);
                                    this.zcR = true;
                                    int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(aVar4.yTx.getContext(), 24);
                                    Bitmap bitmap = b2;
                                    if (bitmap == null || bitmap.isRecycled()) {
                                        bitmap = com.tencent.mm.sdk.platformtools.d.au(aVar4.yTx.getContext().getResources().getColor(R.color.k0), fromDPToPix, fromDPToPix);
                                    }
                                    int height = bitmap.getHeight();
                                    if (fromDPToPix <= height) {
                                        height = fromDPToPix;
                                    }
                                    Bitmap e = com.tencent.mm.sdk.platformtools.d.e(com.tencent.mm.sdk.platformtools.d.al(Bitmap.createScaledBitmap(bitmap, height, height, true)), 20);
                                    height = aVar5.zcd.getHeight();
                                    int width = aVar5.zcd.getWidth();
                                    if (height == 0) {
                                        height = com.tencent.mm.bz.a.al(aVar4.yTx.getContext(), R.dimen.x5);
                                    }
                                    if (width == 0) {
                                        width = com.tencent.mm.bz.a.al(aVar4.yTx.getContext(), R.dimen.x6);
                                    }
                                    aVar5.zcd.setBackgroundDrawable(new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.a(e, (int) R.drawable.b0t, width, height)));
                                    AppMethodBeat.o(32849);
                                }
                                return true;
                            }
                        });
                        obj3 = null;
                        ayVar2 = ayVar;
                        break;
                        break;
                    case 36:
                        zb = ((com.tencent.mm.plugin.appbrand.service.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.d.class)).zb(bVar.fiP);
                        if (zb != null) {
                            charSequence2 = zb.field_nickname;
                        } else {
                            charSequence2 = bVar.cMh;
                        }
                        if (zb != null) {
                            str3 = zb.field_smallHeadURL;
                        } else {
                            str3 = bVar.fjb;
                        }
                        aVar3.zcd.setVisibility(8);
                        aVar3.zcq.setVisibility(0);
                        aVar3.zcj.setVisibility(8);
                        aVar3.zcm.setVisibility(8);
                        aVar3.zcv.setVisibility(8);
                        aVar3.zct.setText(bVar.title);
                        aVar3.zcm.setText(bVar.description);
                        aVar3.zco.setText(charSequence2);
                        d.a(aVar3.zcp, bVar);
                        o.ahp().a(str3, aVar3.zcn, d.zel);
                        String c = o.ahl().c(biVar.field_imgPath, false, true);
                        aVar3.zcr.setImageBitmap(null);
                        com.tencent.mm.modelappbrand.a.b.abR().a(aVar3.zcr, "file://".concat(String.valueOf(c)), null, null, ((com.tencent.mm.modelappbrand.i) com.tencent.mm.kernel.g.K(com.tencent.mm.modelappbrand.i.class)).cq(240, az.CTRL_INDEX));
                        if (!c.dHm()) {
                            if (aVar3.pyf != null) {
                                aVar3.pyf.setVisibility(0);
                                if (biVar.field_status >= 2) {
                                    aVar3.pyf.setVisibility(8);
                                    obj3 = null;
                                    ayVar2 = ayVar;
                                    break;
                                }
                            }
                        }
                        a((c) aVar3, (h) aVar2.aF(h.class), biVar);
                        if (aVar3.pyf != null) {
                            aVar3.pyf.setVisibility(8);
                            obj3 = null;
                            ayVar2 = ayVar;
                            break;
                        }
                    case 40:
                        if (mj.fju == 19) {
                            c.a(aVar2, aVar3, bVar, z);
                            obj3 = null;
                            ayVar2 = ayVar;
                            break;
                        }
                    case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                        if (!bVar.cw(false)) {
                            obj3 = 1;
                            ayVar2 = ayVar;
                            break;
                        }
                        str3 = bVar.p(aVar2.getContext(), false);
                        if (!bo.isNullOrNil(str3)) {
                            aVar3.zcB.setText(str3);
                            aVar3.zcd.setVisibility(8);
                            aVar3.zcq.setVisibility(8);
                            aVar3.zcj.setVisibility(8);
                            aVar3.zcv.setVisibility(0);
                            aVar3.zcw.setText(bVar.title);
                            aVar3.zcx.setText(bVar.description);
                            if (com.tencent.mm.af.j.a.BUSINESS_MY_LIFE_AROUND.ordinal() == bVar.fiW) {
                                aVar3.zcA.setImageResource(R.raw.my_life_around_default_icon);
                            } else if (com.tencent.mm.af.j.a.BUSINESS_OTHER.ordinal() == bVar.fiW) {
                                aVar5 = aVar3;
                                o.aho().a(bVar.fjb, new com.tencent.mm.at.p.a() {
                                    public final void i(String str, final Bitmap bitmap) {
                                        AppMethodBeat.i(32843);
                                        al.d(new Runnable() {
                                            public final void run() {
                                                AppMethodBeat.i(32842);
                                                aVar5.zcA.setImageBitmap(bitmap);
                                                AppMethodBeat.o(32842);
                                            }
                                        });
                                        AppMethodBeat.o(32843);
                                    }
                                });
                            }
                            str3 = o.ahl().so(biVar.HF());
                            aVar3.zcz.setImageBitmap(null);
                            aVar5 = aVar3;
                            com.tencent.mm.modelappbrand.a.b.abR().a(new com.tencent.mm.modelappbrand.a.b.i() {
                                public final void abU() {
                                    AppMethodBeat.i(32844);
                                    aVar5.zcz.setVisibility(4);
                                    aVar5.zcy.setVisibility(0);
                                    AppMethodBeat.o(32844);
                                }

                                public final void x(Bitmap bitmap) {
                                    AppMethodBeat.i(32845);
                                    if (!(bitmap == null || bitmap.isRecycled())) {
                                        aVar5.zcz.setImageBitmap(bitmap);
                                        aVar5.zcz.setVisibility(0);
                                        aVar5.zcy.setVisibility(4);
                                    }
                                    AppMethodBeat.o(32845);
                                }

                                public final void mr() {
                                }

                                public final String wP() {
                                    AppMethodBeat.i(32846);
                                    String str = "CHAT#" + com.tencent.mm.plugin.appbrand.r.n.bE(this);
                                    AppMethodBeat.o(32846);
                                    return str;
                                }
                            }, "file://".concat(String.valueOf(str3)), null, ((com.tencent.mm.modelappbrand.i) com.tencent.mm.kernel.g.K(com.tencent.mm.modelappbrand.i.class)).a(240, 120, com.tencent.mm.modelappbrand.i.a.DECODE_TYPE_ORIGIN));
                            obj3 = null;
                            ayVar2 = ayVar;
                            break;
                        }
                        obj3 = 1;
                        ayVar2 = ayVar;
                        break;
                    default:
                        obj3 = 1;
                        ayVar2 = ayVar;
                        break;
                }
                if (obj3 != null) {
                    if (bVar.title == null || bVar.title.length() <= 0) {
                        aVar3.zbN.setVisibility(8);
                    } else {
                        aVar3.zbN.setVisibility(0);
                        aVar3.zbN.setMaxLines(2);
                        aVar3.zbN.setText(bVar.title);
                    }
                    aVar3.gnB.setVisibility(8);
                    if (z) {
                        if (bVar.type == 33 || bVar.type == 36 || bVar.type == 44) {
                            String so = o.ahl().so(biVar.HF());
                            aVar3.zbI.setImageResource(R.raw.app_attach_file_icon_webpage);
                            com.tencent.mm.modelappbrand.a.b.abR().a(aVar3.zbI, "file://".concat(String.valueOf(so)), null, null, ((com.tencent.mm.modelappbrand.i) com.tencent.mm.kernel.g.K(com.tencent.mm.modelappbrand.i.class)).cq(50, 50));
                            obj = ayVar2;
                        } else {
                            b = o.ahl().b(biVar.HF(), com.tencent.mm.bz.a.getDensity(aVar2.getContext()), false);
                            if (b == null || b.isRecycled()) {
                                b = o.ahl().e(biVar.HF(), com.tencent.mm.bz.a.getDensity(aVar2.getContext()));
                            }
                            if (b == null || b.isRecycled()) {
                                aVar3.zbI.setImageResource(R.drawable.aay);
                            } else {
                                aVar3.zbI.setImageBitmap(b);
                                ayVar = ayVar2;
                            }
                        }
                    }
                }
                ayVar = ayVar2;
            }
            if (obj2 == null) {
                aVar3.zcc.setTag(obj);
                aVar3.zcc.setOnClickListener(d(aVar2));
            }
            if (this.kuU) {
                aVar3.zcc.setOnLongClickListener(c(aVar2));
                aVar3.zcc.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
            }
            a(i, aVar3, biVar, aVar2.dFu(), aVar2.dFx(), aVar2, (n) this);
            AppMethodBeat.o(32853);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(32855);
            int i = ((ay) view.getTag()).position;
            if (biVar.field_content == null) {
                AppMethodBeat.o(32855);
                return true;
            }
            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(bf.b(this.yJI.dFx(), biVar.field_content, biVar.field_isSend));
            if (me == null) {
                AppMethodBeat.o(32855);
                return true;
            }
            boolean aex;
            com.tencent.mm.pluginsdk.model.app.f bT = g.bT(me.appId, false);
            if (g.i(bT) && !com.tencent.mm.ui.chatting.j.aA(biVar)) {
                contextMenu.add(i, 111, 0, this.yJI.yTx.getMMResources().getString(R.string.dr1));
            }
            if ((biVar.field_status == 2 || biVar.dJz == 1) && c.a(biVar, this.yJI) && c.arB(biVar.field_talker) && !ad.mg(this.yJI.getTalkerUserName())) {
                contextMenu.add(i, 123, 0, view.getContext().getString(R.string.ami));
            }
            switch (me.type) {
                case 1:
                    aex = com.tencent.mm.aj.f.aex();
                    break;
                case 2:
                    aex = com.tencent.mm.aj.f.aey();
                    break;
                case 3:
                    aex = com.tencent.mm.aj.f.aeH();
                    break;
                case 4:
                    aex = com.tencent.mm.aj.f.aez();
                    break;
                case 5:
                    aex = com.tencent.mm.aj.f.aeD();
                    break;
                case 6:
                    aex = com.tencent.mm.aj.f.aeF();
                    if (!bo.any(me.fgp)) {
                        contextMenu.add(i, 150, 0, this.yJI.yTx.getMMResources().getString(R.string.amd));
                        break;
                    }
                    break;
                case 8:
                    aex = com.tencent.mm.aj.f.aeB();
                    break;
                case 16:
                    if (me.fhD != 5 && me.fhD != 6 && me.fhD != 2) {
                        aex = false;
                        break;
                    }
                    if (me.fhD != 2) {
                        contextMenu.clear();
                    }
                    contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
                    AppMethodBeat.o(32855);
                    return false;
                    break;
                case 34:
                    contextMenu.clear();
                    contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
                    AppMethodBeat.o(32855);
                    return false;
                default:
                    aex = false;
                    break;
            }
            if (aex && !this.yJI.dFy()) {
                contextMenu.add(i, 114, 0, view.getContext().getString(R.string.am3));
            }
            if (com.tencent.mm.bp.d.afj("favorite") && (bT == null || !bT.xy())) {
                switch (me.type) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 10:
                    case 13:
                    case 19:
                    case 20:
                    case 24:
                        contextMenu.add(i, 116, 0, view.getContext().getString(R.string.dcq));
                        break;
                }
            }
            dq dqVar = new dq();
            dqVar.cxc.cvx = biVar.field_msgId;
            com.tencent.mm.sdk.b.a.xxA.m(dqVar);
            if (dqVar.cxd.cwB || b.a(this.yJI.yTx.getContext(), me)) {
                contextMenu.add(i, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 0, view.getContext().getString(R.string.amc));
            }
            if (!this.yJI.dFy()) {
                contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
            }
            AppMethodBeat.o(32855);
            return true;
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32856);
            String str;
            com.tencent.mm.af.j.b me;
            switch (menuItem.getItemId()) {
                case 100:
                    AppMethodBeat.o(32856);
                    break;
                case 103:
                    str = biVar.field_content;
                    if (str == null) {
                        AppMethodBeat.o(32856);
                        break;
                    }
                    me = com.tencent.mm.af.j.b.me(str);
                    if (me != null) {
                        switch (me.type) {
                            case 16:
                                ii iiVar = new ii();
                                iiVar.cDs.cDt = me.cDt;
                                iiVar.cDs.cuQ = biVar.field_msgId;
                                iiVar.cDs.cDu = biVar.field_talker;
                                com.tencent.mm.sdk.b.a.xxA.m(iiVar);
                        }
                    }
                case 111:
                    b.a(aVar, biVar, b(aVar, biVar));
                    AppMethodBeat.o(32856);
                    break;
                case 114:
                    str = biVar.field_content;
                    if (str != null) {
                        me = com.tencent.mm.af.j.b.me(str);
                        if (me != null) {
                            switch (me.type) {
                                case 1:
                                    am.m(bf.b(aVar.dFx(), biVar.field_content, biVar.field_isSend), aVar.yTx.getContext());
                                    break;
                                case 2:
                                    am.a(biVar, aVar.yTx.getContext(), b(aVar, biVar), aVar.dFx());
                                    break;
                                case 3:
                                    am.a(biVar, bf.b(aVar.dFx(), biVar.field_content, biVar.field_isSend), aVar.yTx.getContext());
                                    break;
                                case 4:
                                    am.c(biVar, aVar.yTx.getContext());
                                    break;
                                case 5:
                                    am.c(biVar, bf.b(aVar.dFx(), biVar.field_content, biVar.field_isSend), aVar.yTx.getContext());
                                    break;
                                case 6:
                                    am.b(biVar, bf.b(aVar.dFx(), biVar.field_content, biVar.field_isSend), aVar.yTx.getContext());
                                    break;
                                case 8:
                                    am.d(biVar, aVar.yTx.getContext());
                                    break;
                            }
                        }
                        AppMethodBeat.o(32856);
                        break;
                    }
                    AppMethodBeat.o(32856);
                    break;
                default:
                    AppMethodBeat.o(32856);
                    break;
            }
            return false;
        }

        /* JADX WARNING: Missing block: B:14:0x004f, code skipped:
            if (r3.url == null) goto L_0x0cac;
     */
        /* JADX WARNING: Missing block: B:16:0x005a, code skipped:
            if (r3.url.equals("") != false) goto L_0x0cac;
     */
        /* JADX WARNING: Missing block: B:18:0x0062, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(r3.canvasPageXml) != false) goto L_0x0a59;
     */
        /* JADX WARNING: Missing block: B:19:0x0064, code skipped:
            r2 = new android.content.Intent();
            r2.putExtra("sns_landig_pages_from_source", 5);
            r2.putExtra("msg_id", r18.field_msgId);
            r2.putExtra("sns_landing_pages_xml", r3.canvasPageXml);
            r2.putExtra("sns_landing_pages_share_thumb_url", r18.field_imgPath);
            r2.addFlags(268435456);
            com.tencent.mm.bp.d.b(r17.yTx.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", r2);
            com.tencent.matrix.trace.core.AppMethodBeat.o(32857);
     */
        /* JADX WARNING: Missing block: B:39:0x01c3, code skipped:
            if (a(r17, r3, r18) == false) goto L_0x01ce;
     */
        /* JADX WARNING: Missing block: B:40:0x01c5, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(32857);
     */
        /* JADX WARNING: Missing block: B:41:0x01ce, code skipped:
            r4 = com.tencent.mm.pluginsdk.model.app.p.B(r3.url, com.facebook.share.internal.ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            r5 = com.tencent.mm.pluginsdk.model.app.p.B(r3.fgn, com.facebook.share.internal.ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            r2 = com.tencent.mm.ui.chatting.viewitems.c.getPackageInfo(r17.yTx.getContext(), r3.appId);
     */
        /* JADX WARNING: Missing block: B:42:0x01ee, code skipped:
            if (r2 != null) goto L_0x0210;
     */
        /* JADX WARNING: Missing block: B:43:0x01f0, code skipped:
            r6 = null;
     */
        /* JADX WARNING: Missing block: B:44:0x01f1, code skipped:
            if (r2 != null) goto L_0x0213;
     */
        /* JADX WARNING: Missing block: B:45:0x01f3, code skipped:
            r7 = 0;
     */
        /* JADX WARNING: Missing block: B:46:0x01f4, code skipped:
            a(r17, r4, r5, r6, r7, r3.appId, true, r18.field_msgId, r18.field_msgSvrId, r18);
            com.tencent.matrix.trace.core.AppMethodBeat.o(32857);
     */
        /* JADX WARNING: Missing block: B:47:0x0210, code skipped:
            r6 = r2.versionName;
     */
        /* JADX WARNING: Missing block: B:48:0x0213, code skipped:
            r7 = r2.versionCode;
     */
        /* JADX WARNING: Missing block: B:208:0x0a59, code skipped:
            r2 = (com.tencent.mm.plugin.websearch.api.ab) r3.X(com.tencent.mm.plugin.websearch.api.ab.class);
     */
        /* JADX WARNING: Missing block: B:209:0x0a61, code skipped:
            if (r2 == null) goto L_0x0aea;
     */
        /* JADX WARNING: Missing block: B:211:0x0a69, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(r2.uaa) != false) goto L_0x0aea;
     */
        /* JADX WARNING: Missing block: B:212:0x0a6b, code skipped:
            r3 = new com.tencent.mm.protocal.protobuf.cvi();
            r3.uaa = r2.uaa;
            r3.uab = r2.uab;
            r3.uac = r2.uac;
            r3.uad = r2.uad;
            r3.uae = r2.uae;
            r3.uai = r2.uai;
            r3.lvz = r2.lvz;
            r3.lvA = r2.lvA;
            r3.qVw = r2.qVw;
            r3.uaf = r2.uaf;
            r3.uag = r2.uag;
            r3.uah = r2.uah;
            r3.source = r2.source;
            r3.phw = r2.phw;
            r3.uaj = r2.uaj;
            r3.ual = r2.ual;
            r3.uam = r2.uam;
            r3.uan = r2.uan;
            r3.uak = r2.uak;
            com.tencent.mm.plugin.websearch.api.aa.a(r17.yTx.getContext(), com.tencent.mm.plugin.topstory.a.g.a(r3, 32, r17.yTx.getContext().getString(com.tencent.mm.R.string.c2a)));
            com.tencent.mm.plugin.topstory.a.h.a(r3, r18);
            com.tencent.matrix.trace.core.AppMethodBeat.o(32857);
     */
        /* JADX WARNING: Missing block: B:213:0x0aea, code skipped:
            r4 = r3.url;
     */
        /* JADX WARNING: Missing block: B:214:0x0af0, code skipped:
            if (r17.dFx() == false) goto L_0x0c8f;
     */
        /* JADX WARNING: Missing block: B:215:0x0af2, code skipped:
            r2 = "groupmessage";
     */
        /* JADX WARNING: Missing block: B:216:0x0af5, code skipped:
            r2 = com.tencent.mm.pluginsdk.model.app.p.B(r4, r2);
            r4 = r3.url;
            r5 = com.tencent.mm.ui.chatting.viewitems.c.getPackageInfo(r17.yTx.getContext(), r3.appId);
            r6 = new android.content.Intent();
            r6.putExtra("rawUrl", r2);
            r6.putExtra("webpageTitle", r3.title);
     */
        /* JADX WARNING: Missing block: B:217:0x0b1e, code skipped:
            if (r3.appId == null) goto L_0x0b54;
     */
        /* JADX WARNING: Missing block: B:219:0x0b29, code skipped:
            if ("wx751a1acca5688ba3".equals(r3.appId) != false) goto L_0x0b41;
     */
        /* JADX WARNING: Missing block: B:221:0x0b34, code skipped:
            if ("wxfbc915ff7c30e335".equals(r3.appId) != false) goto L_0x0b41;
     */
        /* JADX WARNING: Missing block: B:223:0x0b3f, code skipped:
            if ("wx482a4001c37e2b74".equals(r3.appId) == false) goto L_0x0b54;
     */
        /* JADX WARNING: Missing block: B:224:0x0b41, code skipped:
            r2 = new android.os.Bundle();
            r2.putString("jsapi_args_appid", r3.appId);
            r6.putExtra("jsapiargs", r2);
     */
        /* JADX WARNING: Missing block: B:226:0x0b58, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(r4) != false) goto L_0x0c94;
     */
        /* JADX WARNING: Missing block: B:227:0x0b5a, code skipped:
            r6.putExtra("shortUrl", r4);
     */
        /* JADX WARNING: Missing block: B:228:0x0b60, code skipped:
            r4 = "version_name";
     */
        /* JADX WARNING: Missing block: B:229:0x0b63, code skipped:
            if (r5 != null) goto L_0x0c9e;
     */
        /* JADX WARNING: Missing block: B:230:0x0b65, code skipped:
            r2 = null;
     */
        /* JADX WARNING: Missing block: B:231:0x0b66, code skipped:
            r6.putExtra(r4, r2);
            r4 = "version_code";
     */
        /* JADX WARNING: Missing block: B:232:0x0b6c, code skipped:
            if (r5 != null) goto L_0x0ca2;
     */
        /* JADX WARNING: Missing block: B:233:0x0b6e, code skipped:
            r2 = 0;
     */
        /* JADX WARNING: Missing block: B:234:0x0b6f, code skipped:
            r6.putExtra(r4, r2);
     */
        /* JADX WARNING: Missing block: B:235:0x0b78, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(r3.cMg) != false) goto L_0x0b8a;
     */
        /* JADX WARNING: Missing block: B:236:0x0b7a, code skipped:
            r6.putExtra("srcUsername", r3.cMg);
            r6.putExtra("srcDisplayname", r3.cMh);
     */
        /* JADX WARNING: Missing block: B:237:0x0b8a, code skipped:
            r6.putExtra("msg_id", r18.field_msgId);
            r6.putExtra("KPublisherId", "msg_" + java.lang.Long.toString(r18.field_msgSvrId));
            r6.putExtra("KAppId", r3.appId);
            r6.putExtra("geta8key_username", r17.getTalkerUserName());
            r6.putExtra("pre_username", b(r17, r18));
            r6.putExtra("from_scence", 2);
            r6.putExtra("expid_str", r18.dJE);
            r2 = com.tencent.mm.model.u.ad(b(r17, r18), r17.getTalkerUserName());
            r6.putExtra("prePublishId", "msg_" + java.lang.Long.toString(r18.field_msgSvrId));
            r6.putExtra("preUsername", b(r17, r18));
            r6.putExtra("preChatName", r17.getTalkerUserName());
            r6.putExtra("preChatTYPE", r2);
            r6.putExtra("preMsgIndex", 0);
     */
        /* JADX WARNING: Missing block: B:238:0x0c36, code skipped:
            switch(r2) {
                case 1: goto L_0x0ca8;
                case 2: goto L_0x0ca6;
                case 3: goto L_0x0c39;
                case 4: goto L_0x0c39;
                case 5: goto L_0x0c39;
                case 6: goto L_0x0caa;
                case 7: goto L_0x0caa;
                default: goto L_0x0c39;
            };
     */
        /* JADX WARNING: Missing block: B:239:0x0c39, code skipped:
            r2 = 0;
     */
        /* JADX WARNING: Missing block: B:240:0x0c3a, code skipped:
            r6.putExtra("share_report_pre_msg_url", r3.url);
            r6.putExtra("share_report_pre_msg_title", r3.title);
            r6.putExtra("share_report_pre_msg_desc", r3.description);
            r6.putExtra("share_report_pre_msg_icon_url", r3.thumburl);
            r6.putExtra("share_report_pre_msg_appid", r3.appId);
            r6.putExtra("share_report_from_scene", r2);
     */
        /* JADX WARNING: Missing block: B:241:0x0c69, code skipped:
            if (r2 != 5) goto L_0x0c75;
     */
        /* JADX WARNING: Missing block: B:242:0x0c6b, code skipped:
            r6.putExtra("share_report_biz_username", r17.getTalkerUserName());
     */
        /* JADX WARNING: Missing block: B:243:0x0c75, code skipped:
            com.tencent.mm.bp.d.b(r17.yTx.getContext(), "webview", ".ui.tools.WebViewUI", r6);
            com.tencent.matrix.trace.core.AppMethodBeat.o(32857);
     */
        /* JADX WARNING: Missing block: B:244:0x0c8f, code skipped:
            r2 = "singlemessage";
     */
        /* JADX WARNING: Missing block: B:245:0x0c94, code skipped:
            r6.putExtra("shortUrl", r3.url);
     */
        /* JADX WARNING: Missing block: B:246:0x0c9e, code skipped:
            r2 = r5.versionName;
     */
        /* JADX WARNING: Missing block: B:247:0x0ca2, code skipped:
            r2 = r5.versionCode;
     */
        /* JADX WARNING: Missing block: B:248:0x0ca6, code skipped:
            r2 = 2;
     */
        /* JADX WARNING: Missing block: B:249:0x0ca8, code skipped:
            r2 = 3;
     */
        /* JADX WARNING: Missing block: B:250:0x0caa, code skipped:
            r2 = 5;
     */
        /* JADX WARNING: Missing block: B:251:0x0cac, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(32857);
     */
        /* JADX WARNING: Missing block: B:254:?, code skipped:
            return true;
     */
        /* JADX WARNING: Missing block: B:258:?, code skipped:
            return true;
     */
        /* JADX WARNING: Missing block: B:259:?, code skipped:
            return true;
     */
        /* JADX WARNING: Missing block: B:281:?, code skipped:
            return true;
     */
        /* JADX WARNING: Missing block: B:282:?, code skipped:
            return true;
     */
        /* JADX WARNING: Missing block: B:283:?, code skipped:
            return false;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32857);
            view.getTag();
            String str = biVar.field_content;
            if (str == null) {
                AppMethodBeat.o(32857);
                return false;
            }
            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(str);
            if (me == null) {
                AppMethodBeat.o(32857);
                return false;
            }
            com.tencent.mm.pluginsdk.model.app.f bT = g.bT(me.appId, true);
            if (!(bT == null || bo.isNullOrNil(bT.field_appId))) {
                c.a(aVar, me, r.Yz(), bT, biVar.field_msgSvrId, aVar.getTalkerUserName());
            }
            String B;
            Bundle bundle;
            int ad;
            Intent intent;
            Object obj;
            String talkerUserName;
            Bundle bundle2;
            switch (me.type) {
                case 3:
                    com.tencent.mm.plugin.report.service.h.pYm.e(13043, Integer.valueOf(2), me.description, me.appId);
                    break;
                case 4:
                    break;
                case 5:
                    if (bo.isNullOrNil(me.canvasPageXml)) {
                        com.tencent.mm.plugin.websearch.api.ab abVar = (com.tencent.mm.plugin.websearch.api.ab) me.X(com.tencent.mm.plugin.websearch.api.ab.class);
                        if (abVar == null || bo.isNullOrNil(abVar.uaa)) {
                            if (!(me.url == null || me.url.equals(""))) {
                                B = p.B(me.url, aVar.dFx() ? "groupmessage" : "singlemessage");
                                str = me.fgn;
                                PackageInfo packageInfo = c.getPackageInfo(aVar.yTx.getContext(), me.appId);
                                Intent intent2 = new Intent();
                                intent2.putExtra("rawUrl", B);
                                intent2.putExtra("webpageTitle", me.title);
                                bundle = new Bundle();
                                bundle.putString("key_snsad_statextstr", me.cMn);
                                if (me.appId != null && ("wx751a1acca5688ba3".equals(me.appId) || "wxfbc915ff7c30e335".equals(me.appId) || "wx482a4001c37e2b74".equals(me.appId))) {
                                    bundle.putString("jsapi_args_appid", me.appId);
                                }
                                intent2.putExtra("jsapiargs", bundle);
                                if (bo.isNullOrNil(str)) {
                                    intent2.putExtra("shortUrl", me.url);
                                } else {
                                    intent2.putExtra("shortUrl", str);
                                }
                                intent2.putExtra("version_name", packageInfo == null ? null : packageInfo.versionName);
                                intent2.putExtra("version_code", packageInfo == null ? 0 : packageInfo.versionCode);
                                if (!bo.isNullOrNil(me.cMg)) {
                                    intent2.putExtra("srcUsername", me.cMg);
                                    intent2.putExtra("srcDisplayname", me.cMh);
                                }
                                intent2.putExtra("msg_id", biVar.field_msgId);
                                intent2.putExtra("KPublisherId", "msg_" + Long.toString(biVar.field_msgSvrId));
                                intent2.putExtra("KAppId", me.appId);
                                intent2.putExtra("geta8key_username", aVar.getTalkerUserName());
                                intent2.putExtra("pre_username", b(aVar, biVar));
                                intent2.putExtra("from_scence", 2);
                                ad = u.ad(b(aVar, biVar), aVar.getTalkerUserName());
                                intent2.putExtra("prePublishId", "msg_" + Long.toString(biVar.field_msgSvrId));
                                intent2.putExtra("preUsername", b(aVar, biVar));
                                intent2.putExtra("preChatName", aVar.getTalkerUserName());
                                intent2.putExtra("preChatTYPE", ad);
                                intent2.putExtra("preMsgIndex", 0);
                                switch (ad) {
                                    case 1:
                                        ad = 3;
                                        break;
                                    case 2:
                                        ad = 2;
                                        break;
                                    case 6:
                                    case 7:
                                        ad = 5;
                                        break;
                                    default:
                                        ad = 0;
                                        break;
                                }
                                intent2.putExtra("share_report_pre_msg_url", me.url);
                                intent2.putExtra("share_report_pre_msg_title", me.title);
                                intent2.putExtra("share_report_pre_msg_desc", me.description);
                                intent2.putExtra("share_report_pre_msg_icon_url", me.thumburl);
                                intent2.putExtra("share_report_pre_msg_appid", me.appId);
                                intent2.putExtra("share_report_from_scene", ad);
                                if (ad == 5) {
                                    intent2.putExtra("share_report_biz_username", aVar.getTalkerUserName());
                                }
                                com.tencent.mm.af.e eVar = (com.tencent.mm.af.e) me.X(com.tencent.mm.af.e.class);
                                int i = eVar != null ? eVar.ffZ : -1;
                                intent2.putExtra(m.ygo, i);
                                int intExtra = aVar.yTx.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", Downloads.MIN_WAIT_FOR_NETWORK);
                                if (eVar != null && i == 5 && eVar.fgb == 1 && ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.b.class)).aVP()) {
                                    Bundle bundle3 = new Bundle();
                                    bundle3.putInt("biz_video_scene", 1);
                                    bundle3.putInt("biz_video_subscene", intExtra);
                                    bundle3.putInt("geta8key_scene", 1);
                                    com.tencent.mm.plugin.brandservice.ui.timeline.video.a.c.a(aVar.yTx.getContext(), biVar.field_msgId, biVar.field_msgSvrId, 0, view.findViewById(R.id.anb), bundle3);
                                    AppMethodBeat.o(32857);
                                    return true;
                                } else if (((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.b.class)).rW(3) && ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.b.class)).a(aVar.yTx.getContext(), B, i, 1, intExtra, intent2)) {
                                    ab.i("MicroMsg.ChattingItemAppMsgTo", "jump to TmplWebview");
                                    AppMethodBeat.o(32857);
                                    return true;
                                } else {
                                    com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                                }
                            }
                            AppMethodBeat.o(32857);
                            return true;
                        }
                        cvi cvi = new cvi();
                        cvi.uaa = abVar.uaa;
                        cvi.uab = abVar.uab;
                        cvi.uac = abVar.uac;
                        cvi.uad = abVar.uad;
                        cvi.uae = abVar.uae;
                        cvi.uai = abVar.uai;
                        cvi.lvz = abVar.lvz;
                        cvi.lvA = abVar.lvA;
                        cvi.qVw = abVar.qVw;
                        cvi.uaf = abVar.uaf;
                        cvi.uag = abVar.uag;
                        cvi.uah = abVar.uah;
                        cvi.source = abVar.source;
                        cvi.phw = abVar.phw;
                        cvi.uaj = abVar.uaj;
                        cvi.ual = abVar.ual;
                        cvi.uam = abVar.uam;
                        cvi.uan = abVar.uan;
                        cvi.uak = abVar.uak;
                        aa.a(aVar.yTx.getContext(), com.tencent.mm.plugin.topstory.a.g.a(cvi, 32, aVar.yTx.getContext().getString(R.string.c2a)));
                        com.tencent.mm.plugin.topstory.a.h.a(cvi, biVar);
                        AppMethodBeat.o(32857);
                        return true;
                    }
                    intent = new Intent();
                    intent.putExtra("sns_landig_pages_from_source", 5);
                    intent.putExtra("msg_id", biVar.field_msgId);
                    intent.putExtra("sns_landing_pages_xml", me.canvasPageXml);
                    intent.putExtra("sns_landing_pages_share_thumb_url", biVar.field_imgPath);
                    intent.addFlags(268435456);
                    com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
                    AppMethodBeat.o(32857);
                    return true;
                case 6:
                    aw.ZK();
                    if (com.tencent.mm.model.c.isSDCardAvailable()) {
                        if (bo.any(me.fgp)) {
                            long j = biVar.field_msgId;
                            com.tencent.mm.pluginsdk.model.app.b aiE = com.tencent.mm.pluginsdk.model.app.am.aUq().aiE(me.csD);
                            if (aiE == null || !aiE.bCR()) {
                                obj = null;
                            } else {
                                aw.ZK();
                                if (com.tencent.mm.model.c.XO().jf(j).dtH()) {
                                    ab.i("MicroMsg.ChattingItemAppMsgTo", "openImg:: msg is clean, attachId %s, msgId: %d, msgSvrId: %d, imgPath: %s", str, Long.valueOf(j), Long.valueOf(com.tencent.mm.model.c.XO().jf(j).field_msgSvrId), com.tencent.mm.model.c.XO().jf(j).field_imgPath);
                                    intent = new Intent();
                                    intent.setClassName(this.yJI.yTx.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
                                    intent.putExtra("clean_view_type", 1);
                                    this.yJI.startActivity(intent);
                                    obj = 1;
                                } else {
                                    intent = new Intent(this.yJI.yTx.getContext(), ShowImageUI.class);
                                    intent.putExtra("key_image_path", aiE.field_fileFullPath);
                                    intent.putExtra("key_message_id", j);
                                    intent.putExtra("key_favorite", true);
                                    this.yJI.startActivity(intent);
                                    obj = 1;
                                }
                            }
                            if (obj != null) {
                                AppMethodBeat.o(32857);
                                return true;
                            }
                        }
                        intent = new Intent();
                        intent.setClassName(aVar.yTx.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                        intent.putExtra("app_msg_id", biVar.field_msgId);
                        aVar.startActivity(intent);
                        AppMethodBeat.o(32857);
                        return true;
                    }
                    t.hO(aVar.yTx.getContext());
                    AppMethodBeat.o(32857);
                    return true;
                case 7:
                    if (bT != null && bT.xy() && c.a(aVar, bT)) {
                        AppMethodBeat.o(32857);
                        return true;
                    }
                    final com.tencent.mm.pluginsdk.model.app.f fVar = bT;
                    final com.tencent.mm.ui.chatting.d.a aVar2 = aVar;
                    final com.tencent.mm.af.j.b bVar = me;
                    final bi biVar2 = biVar;
                    ((com.tencent.mm.ui.chatting.c.b.b) aVar.aF(com.tencent.mm.ui.chatting.c.b.b.class)).a(biVar, new aj() {
                        public final void dR(boolean z) {
                            AppMethodBeat.i(32850);
                            if (fVar != null) {
                                if (z) {
                                    c.a(aVar2, bVar, r.Yz(), fVar, biVar2.field_msgSvrId, 3, aVar2.getTalkerUserName());
                                    AppMethodBeat.o(32850);
                                    return;
                                }
                                c.a(aVar2, bVar, r.Yz(), fVar, biVar2.field_msgSvrId, 7, aVar2.getTalkerUserName());
                            }
                            AppMethodBeat.o(32850);
                        }
                    });
                    AppMethodBeat.o(32857);
                    return true;
                case 10:
                    if (bo.isNullOrNil(me.fgQ)) {
                        AppMethodBeat.o(32857);
                        return false;
                    }
                    intent = new Intent();
                    intent.setFlags(65536);
                    intent.putExtra("key_Product_xml", me.fgQ);
                    intent.putExtra("key_ProductUI_getProductInfoScene", 1);
                    if (biVar.field_imgPath == null) {
                        intent.putExtra("key_ProductUI_chatting_msgId", biVar.field_msgId);
                    }
                    com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "scanner", ".ui.ProductUI", intent);
                    AppMethodBeat.o(32857);
                    return true;
                case 13:
                    if (bo.isNullOrNil(me.fgW)) {
                        AppMethodBeat.o(32857);
                        return false;
                    }
                    intent = new Intent();
                    intent.setFlags(65536);
                    intent.putExtra("key_product_info", me.fgW);
                    intent.putExtra("key_product_scene", 1);
                    com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "product", ".ui.MallProductUI", intent);
                    AppMethodBeat.o(32857);
                    return true;
                case 16:
                    if (bo.isNullOrNil(me.cDt)) {
                        AppMethodBeat.o(32857);
                        return false;
                    }
                    intent = new Intent();
                    intent.setFlags(65536);
                    intent.putExtra("key_card_app_msg", me.cDt);
                    intent.putExtra("key_from_scene", me.fhD);
                    com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "card", ".ui.CardDetailUI", intent);
                    AppMethodBeat.o(32857);
                    return true;
                case 19:
                    intent = new Intent();
                    intent.putExtra("message_id", biVar.field_msgId);
                    intent.putExtra("record_xml", me.fgU);
                    int ad2 = u.ad(b(aVar, biVar), aVar.getTalkerUserName());
                    intent.putExtra("prePublishId", "msg_" + Long.toString(biVar.field_msgSvrId));
                    intent.putExtra("preUsername", b(aVar, biVar));
                    intent.putExtra("preChatName", aVar.getTalkerUserName());
                    intent.putExtra("preChatTYPE", ad2);
                    a.a(intent, aVar, biVar, this);
                    com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "record", ".ui.RecordMsgDetailUI", intent);
                    AppMethodBeat.o(32857);
                    return true;
                case 20:
                    if (bo.isNullOrNil(me.fgT)) {
                        AppMethodBeat.o(32857);
                        return false;
                    }
                    intent = new Intent();
                    intent.setFlags(65536);
                    intent.putExtra("key_TV_xml", me.fgT);
                    intent.putExtra("key_TV_getProductInfoScene", 1);
                    if (biVar.field_imgPath == null) {
                        intent.putExtra("key_TVInfoUI_chatting_msgId", biVar.field_msgId);
                    }
                    com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "shake", ".ui.TVInfoUI", intent);
                    AppMethodBeat.o(32857);
                    return true;
                case 24:
                    lz lzVar = new lz();
                    lzVar.cHO.context = aVar.yTx.getContext();
                    lzVar.cHO.cvx = biVar.field_msgId;
                    lzVar.cHO.cHc = aVar.dFx();
                    lzVar.cHO.cHP = me.fgU;
                    lzVar.cHO.scene = 6;
                    com.tencent.mm.sdk.b.a.xxA.m(lzVar);
                    AppMethodBeat.o(32857);
                    return true;
                case 33:
                case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                    ab.i("MicroMsg.ChattingItemAppMsgTo", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", me.fiP, me.fiO, me.fiQ, me.url, Integer.valueOf(me.fiZ), me.fiS);
                    if (44 != me.type || (me.cw(false) && !bo.isNullOrNil(me.p(aVar.yTx.getContext(), false)))) {
                        talkerUserName = aVar.getTalkerUserName();
                        String b = b(aVar, biVar);
                        bundle = new Bundle();
                        if (aVar.yTx instanceof AppBrandServiceChattingFmUI) {
                            B = "stat_scene";
                            ad = 10;
                            bundle2 = bundle;
                        } else if (aVar.dFx()) {
                            B = "stat_scene";
                            ad = 2;
                            bundle2 = bundle;
                        } else {
                            B = "stat_scene";
                            if (com.tencent.mm.model.t.mZ(talkerUserName)) {
                                ad = 7;
                                bundle2 = bundle;
                            } else {
                                ad = 1;
                                bundle2 = bundle;
                            }
                        }
                        bundle2.putInt(B, ad);
                        bundle.putString("stat_msg_id", "msg_" + Long.toString(biVar.field_msgSvrId));
                        bundle.putString("stat_chat_talker_username", talkerUserName);
                        bundle.putString("stat_send_msg_user", b);
                        switch (me.fiR) {
                            case 0:
                            case 2:
                                if (!(aVar.yTx instanceof AppBrandServiceChattingFmUI)) {
                                    if (!com.tencent.mm.model.t.mZ(talkerUserName)) {
                                        com.tencent.mm.modelappbrand.a.a(talkerUserName, b, aVar.dFx(), me, bundle);
                                        obj = null;
                                        break;
                                    }
                                    com.tencent.mm.modelappbrand.a.a(talkerUserName, FilterEnum4Shaka.MIC_WEISHI_CHAZHI, me, bundle);
                                    obj = null;
                                    break;
                                }
                                com.tencent.mm.modelappbrand.a.a(talkerUserName, FilterEnum4Shaka.MIC_WEISHI_MENGHUANG, me, bundle);
                                obj = null;
                                break;
                            case 1:
                                intent = new Intent();
                                intent.putExtra("key_username", me.fiP);
                                if (aVar.dFx()) {
                                    intent.putExtra("key_from_scene", 1);
                                    intent.putExtra("key_scene_note", aVar.getTalkerUserName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + b);
                                } else {
                                    intent.putExtra("key_from_scene", 2);
                                    intent.putExtra("key_scene_note", talkerUserName);
                                }
                                intent.putExtra("_stat_obj", bundle);
                                com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a aVar3 = new com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a();
                                aVar3.appId = me.fiQ;
                                aVar3.from = 6;
                                aVar3.gVt = me.fiZ;
                                aVar3.gVu = me.fiT;
                                intent.putExtra("key_scene_exposed_params", aVar3.ayP());
                                com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "appbrand", ".ui.AppBrandProfileUI", intent);
                                obj = null;
                                break;
                            case 3:
                                com.tencent.mm.modelappbrand.a.b(talkerUserName, b, aVar.dFx(), me, bundle);
                                obj = null;
                                break;
                            default:
                                obj = 1;
                                break;
                        }
                        if (obj == null) {
                            AppMethodBeat.o(32857);
                            return true;
                        }
                    }
                    break;
                case 34:
                    intent = new Intent();
                    intent.putExtra("key_biz_uin", me.fhF);
                    intent.putExtra("key_order_id", me.fhG);
                    if (!(biVar.field_talker == null || biVar.field_talker.equals("") || !com.tencent.mm.model.t.kH(biVar.field_talker))) {
                        intent.putExtra("key_chatroom_name", biVar.field_talker);
                    }
                    com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "card", ".ui.CardGiftAcceptUI", intent);
                    AppMethodBeat.o(32857);
                    return true;
                case 36:
                    if (bo.isNullOrNil(me.fiQ) && bo.isNullOrNil(me.fiP)) {
                        str = p.B(me.url, aVar.dFx() ? "groupmessage" : "singlemessage");
                        Intent intent3 = new Intent();
                        intent3.putExtra("rawUrl", str);
                        intent3.putExtra("webpageTitle", me.title);
                        intent3.putExtra("shortUrl", me.url);
                        com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent3);
                        AppMethodBeat.o(32857);
                        return true;
                    }
                    String talkerUserName2 = aVar.getTalkerUserName();
                    talkerUserName = b(aVar, biVar);
                    bundle = new Bundle();
                    if (aVar.dFx()) {
                        B = "stat_scene";
                        ad = 2;
                        bundle2 = bundle;
                    } else {
                        B = "stat_scene";
                        if (com.tencent.mm.model.t.mZ(talkerUserName2)) {
                            ad = 7;
                            bundle2 = bundle;
                        } else {
                            ad = 1;
                            bundle2 = bundle;
                        }
                    }
                    bundle2.putInt(B, ad);
                    bundle.putString("stat_msg_id", "msg_" + Long.toString(biVar.field_msgSvrId));
                    bundle.putString("stat_chat_talker_username", talkerUserName2);
                    bundle.putString("stat_send_msg_user", talkerUserName);
                    ((com.tencent.mm.plugin.appbrand.service.e) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.e.class)).a(aVar.yTx.getContext(), aVar.getTalkerUserName(), b(aVar, biVar), aVar.dFx(), me);
                    AppMethodBeat.o(32857);
                    return true;
            }
        }

        private static void a(c cVar, h hVar, bi biVar) {
            AppMethodBeat.i(32854);
            if (biVar.field_status == 2 && c.a(hVar, biVar.field_msgId)) {
                if (cVar.zci != null) {
                    cVar.zci.setVisibility(0);
                    AppMethodBeat.o(32854);
                    return;
                }
            } else if (cVar.zci != null) {
                cVar.zci.setVisibility(8);
            }
            AppMethodBeat.o(32854);
        }

        public final void a(final com.tencent.mm.ui.chatting.d.a aVar, final bi biVar) {
            AppMethodBeat.i(32858);
            com.tencent.mm.ui.base.h.d(aVar.yTx.getContext(), aVar.yTx.getMMResources().getString(R.string.anu), "", aVar.yTx.getMMResources().getString(R.string.t_), aVar.yTx.getMMResources().getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(32851);
                    if (biVar.bAA()) {
                        com.tencent.mm.pluginsdk.model.app.l.al(biVar);
                        aVar.qp(true);
                        AppMethodBeat.o(32851);
                        return;
                    }
                    AppMethodBeat.o(32851);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AppMethodBeat.o(32858);
        }
    }

    public static class f {
        public String cHz;
        public long cvx;
        public String imgPath;
        public int zcZ = -1;
    }

    static final class a {
        static void a(Intent intent, com.tencent.mm.ui.chatting.d.a aVar, bi biVar, c cVar) {
            String str;
            int i;
            Bundle bundle;
            AppMethodBeat.i(32803);
            String talkerUserName = aVar.getTalkerUserName();
            String b = cVar.b(aVar, biVar);
            Bundle bundle2 = new Bundle();
            if (aVar.dFx()) {
                str = "stat_scene";
                i = 2;
                bundle = bundle2;
            } else {
                str = "stat_scene";
                if (com.tencent.mm.model.t.mZ(talkerUserName)) {
                    i = 7;
                    bundle = bundle2;
                } else {
                    i = 1;
                    bundle = bundle2;
                }
            }
            bundle.putInt(str, i);
            bundle2.putString("stat_msg_id", "msg_" + Long.toString(biVar.field_msgSvrId));
            bundle2.putString("stat_chat_talker_username", talkerUserName);
            bundle2.putString("stat_send_msg_user", b);
            intent.putExtra("_stat_obj", bundle2);
            AppMethodBeat.o(32803);
        }
    }

    static class b {
        static boolean a(Context context, com.tencent.mm.af.j.b bVar) {
            AppMethodBeat.i(32805);
            boolean o;
            if (bVar == null || context == null) {
                AppMethodBeat.o(32805);
                return false;
            } else if (bVar.type == 3) {
                o = g.o(context, 16);
                AppMethodBeat.o(32805);
                return o;
            } else if (bVar.type == 4) {
                o = g.o(context, 8);
                AppMethodBeat.o(32805);
                return o;
            } else if (bVar.type == 5) {
                o = g.o(context, 32);
                AppMethodBeat.o(32805);
                return o;
            } else if (bVar.type == 6) {
                Long aik = com.tencent.mm.pluginsdk.c.a.aik(bVar.fgp);
                if (aik == null) {
                    AppMethodBeat.o(32805);
                    return false;
                }
                o = g.o(context, aik.longValue());
                AppMethodBeat.o(32805);
                return o;
            } else {
                AppMethodBeat.o(32805);
                return false;
            }
        }

        static void a(final com.tencent.mm.ui.chatting.d.a aVar, final bi biVar, String str) {
            AppMethodBeat.i(32806);
            String b = bf.b(aVar.dFx(), biVar.field_content, biVar.field_isSend);
            final Intent intent = new Intent(aVar.yTx.getContext(), MsgRetransmitUI.class);
            intent.putExtra("Retr_Msg_content", b);
            intent.putExtra("Retr_MsgFromScene", 2);
            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(b);
            if (me != null && 19 == me.type) {
                intent.putExtra("Retr_Msg_Type", 10);
            } else if (me != null && 24 == me.type) {
                intent.putExtra("Retr_Msg_Type", 10);
            } else if (me == null || 16 != me.type) {
                intent.putExtra("Retr_Msg_Type", 2);
                b = biVar.field_talker;
                String nW = v.nW(biVar.field_msgSvrId);
                intent.putExtra("reportSessionId", nW);
                com.tencent.mm.model.v.b y = v.Zp().y(nW, true);
                y.j("prePublishId", "msg_" + biVar.field_msgSvrId);
                y.j("preUsername", str);
                y.j("preChatName", b);
                if (!(me == null || me.X(com.tencent.mm.af.a.class) == null)) {
                    y.j("appservicetype", Integer.valueOf(((com.tencent.mm.af.a) me.X(com.tencent.mm.af.a.class)).ffa));
                    intent.putExtra("Retr_MsgAppBrandServiceType", ((com.tencent.mm.af.a) me.X(com.tencent.mm.af.a.class)).ffa);
                }
                if (me != null && 33 == me.type) {
                    if (aVar.dFx()) {
                        y.j("fromScene", Integer.valueOf(2));
                        intent.putExtra("Retr_MsgAppBrandFromScene", 2);
                    } else {
                        y.j("fromScene", Integer.valueOf(1));
                        intent.putExtra("Retr_MsgAppBrandFromScene", 1);
                    }
                    intent.putExtra("Retr_MsgFromUserName", str);
                    intent.putExtra("Retr_MsgTalker", biVar.field_talker);
                }
                y.j("sendAppMsgScene", Integer.valueOf(1));
                ((com.tencent.mm.plugin.sns.b.i) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.sns.b.i.class)).a("adExtStr", y, biVar);
            } else {
                intent.putExtra("Retr_Msg_Type", 14);
            }
            intent.putExtra("Retr_Msg_Id", biVar.field_msgId);
            if (me == null || me.type != 6) {
                aVar.startActivity(intent);
                AppMethodBeat.o(32806);
                return;
            }
            int i;
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
            Object[] objArr = new Object[6];
            objArr[0] = me.fgD;
            if (me.fgs == 1) {
                i = 7;
            } else {
                i = 5;
            }
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(me.fgo);
            objArr[3] = Integer.valueOf(2);
            objArr[4] = Long.valueOf((System.currentTimeMillis() - biVar.field_createTime) / 1000);
            objArr[5] = me.fgp;
            hVar.e(14665, objArr);
            boolean z = me.fgs != 0 || me.fgo > 26214400;
            intent.putExtra("Retr_Big_File", z);
            final com.tencent.mm.pluginsdk.model.app.b aiM = com.tencent.mm.pluginsdk.model.app.l.aiM(me.csD);
            if (aiM != null) {
                File file = new File(aiM.field_fileFullPath);
                if (file.exists() && file.length() == aiM.field_totalLen) {
                    aVar.startActivity(intent);
                    AppMethodBeat.o(32806);
                    return;
                } else if (aiM.field_offset > 0 && aiM.field_totalLen > aiM.field_offset) {
                    a(aVar, intent, biVar, aiM.field_fileFullPath);
                    AppMethodBeat.o(32806);
                    return;
                }
            }
            ab.i("MicroMsg.AppMessageUtil", "summerbig retrans content.attachlen[%d], cdnAttachUrl[%s], aesKey[%s]", Integer.valueOf(me.fgo), me.fgD, bo.anv(me.eyr));
            if (z) {
                intent.putExtra("Retr_Big_File", z);
                com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
                gVar.egl = new com.tencent.mm.i.g.a() {
                    public final int a(String str, int i, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
                        AppMethodBeat.i(32804);
                        String str2 = "MicroMsg.AppMessageUtil";
                        String str3 = "summerbig cdnCallback mediaId:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]";
                        Object[] objArr = new Object[7];
                        objArr[0] = str;
                        objArr[1] = Integer.valueOf(i);
                        objArr[2] = cVar;
                        objArr[3] = dVar;
                        objArr[4] = Boolean.valueOf(cVar != null);
                        objArr[5] = Boolean.valueOf(dVar != null);
                        objArr[6] = Boolean.valueOf(z);
                        ab.i(str2, str3, objArr);
                        if (dVar != null) {
                            if (dVar.field_exist_whencheck) {
                                aVar.startActivity(intent);
                            } else if (biVar.dtH() || (aiM != null && b.e(biVar, aiM.field_fileFullPath))) {
                                ab.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
                                com.tencent.mm.ui.base.h.a(aVar.yTx.getContext(), aVar.yTx.getContext().getString(R.string.bt0), aVar.yTx.getContext().getString(R.string.tz), new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                            } else {
                                com.tencent.mm.ui.base.h.b(aVar.yTx.getContext(), aVar.yTx.getMMResources().getString(R.string.b30), "", true);
                            }
                        }
                        AppMethodBeat.o(32804);
                        return 0;
                    }

                    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                    }

                    public final byte[] l(String str, byte[] bArr) {
                        return new byte[0];
                    }
                };
                gVar.field_mediaId = com.tencent.mm.al.c.a("checkExist", bo.anU(), str, biVar.field_msgId);
                gVar.field_fileId = me.fgD;
                gVar.field_aesKey = me.eyr;
                gVar.field_filemd5 = me.filemd5;
                gVar.field_fileType = com.tencent.mm.i.a.efE;
                gVar.field_talker = str;
                gVar.field_priority = com.tencent.mm.i.a.efC;
                gVar.field_svr_signature = "";
                gVar.field_onlycheckexist = true;
                ab.i("MicroMsg.AppMessageUtil", "summerbig retrans to startupDownloadMedia ret[%b], field_fileId[%s], field_mediaId[%s], field_aesKey[%s]", Boolean.valueOf(com.tencent.mm.al.f.afx().e(gVar)), gVar.field_fileId, gVar.field_mediaId, bo.anv(gVar.field_aesKey));
                if (!com.tencent.mm.al.f.afx().e(gVar)) {
                    a(aVar, intent, biVar, null);
                }
                AppMethodBeat.o(32806);
                return;
            }
            a(aVar, intent, biVar, null);
            AppMethodBeat.o(32806);
        }

        private static void a(com.tencent.mm.ui.chatting.d.a aVar, Intent intent, bi biVar, String str) {
            AppMethodBeat.i(32807);
            if (biVar.dtH() || e(biVar, str)) {
                ab.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
                com.tencent.mm.ui.base.h.a(aVar.yTx.getContext(), aVar.yTx.getContext().getString(R.string.bt0), aVar.yTx.getContext().getString(R.string.tz), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(32807);
                return;
            }
            aVar.startActivity(intent);
            AppMethodBeat.o(32807);
        }

        public static boolean e(bi biVar, String str) {
            AppMethodBeat.i(32808);
            if (System.currentTimeMillis() - biVar.field_createTime <= 259200000 || (!bo.isNullOrNil(str) && com.tencent.mm.vfs.e.ct(str))) {
                AppMethodBeat.o(32808);
                return false;
            }
            AppMethodBeat.o(32808);
            return true;
        }

        public static boolean arC(String str) {
            boolean z = false;
            AppMethodBeat.i(32809);
            String c = o.ahl().c(str, false, true);
            if (com.tencent.mm.vfs.e.ct(c)) {
                Options options = new Options();
                options.inJustDecodeBounds = true;
                Bitmap decodeFile = com.tencent.mm.sdk.platformtools.d.decodeFile(c, options);
                if (options.outWidth * options.outHeight > 1048576) {
                    ab.i("MicroMsg.AppMessageUtil", "Bitmap to big:%d/%d", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
                    z = true;
                }
                if (decodeFile != null) {
                    decodeFile.recycle();
                }
                AppMethodBeat.o(32809);
            } else {
                AppMethodBeat.o(32809);
            }
            return z;
        }
    }

    static final class c extends com.tencent.mm.ui.chatting.viewitems.c.a {
        public static int[] mqq = new int[]{R.id.asx, R.id.asy, R.id.asz, R.id.at0, R.id.at1};
        protected TextView gnB;
        protected TextView gnC;
        protected TextView moL;
        private ArrayList<MMImageView> rlN = new ArrayList();
        protected MMImageView zbI;
        protected ImageView zbJ;
        protected ImageView zbK;
        protected TextView zbL;
        protected LinearLayout zbM;
        protected TextView zbN;
        protected ImageView zbO;
        protected MMPinProgressBtn zbP;
        protected ImageView zbQ;
        protected ImageView zbR;
        protected ImageView zbS;
        protected ImageView zbT;
        protected TextView zbU;
        protected ChattingItemFooter zbV;
        protected ImageView zbW;
        protected LinearLayout zbX;
        protected ViewGroup zbY;
        protected TextView zbZ;
        ImageView zcA;
        TextView zcB;
        LinearLayout zcC;
        MMNeat7extView zcD;
        ImageView zcE;
        ImageView zcF;
        ImageView zcG;
        TextView zcH;
        TextView zcI;
        public int zcJ = 0;
        private int zcK = BaseClientBuilder.API_PRIORITY_OTHER;
        protected LinearLayout zca;
        protected RelativeLayout zcb;
        protected FrameLayout zcc;
        protected LinearLayout zcd;
        protected LinearLayout zce;
        protected ViewStub zcf;
        protected ImageView zcg;
        protected ImageView zch;
        ImageView zci;
        protected LinearLayout zcj;
        protected ImageView zck;
        protected TextView zcl;
        protected TextView zcm;
        protected ImageView zcn;
        protected TextView zco;
        protected TextView zcp;
        protected LinearLayout zcq;
        protected ImageView zcr;
        protected ImageView zcs;
        protected TextView zct;
        protected LinearLayout zcu;
        LinearLayout zcv;
        TextView zcw;
        TextView zcx;
        ImageView zcy;
        ImageView zcz;

        c() {
            AppMethodBeat.i(32813);
            AppMethodBeat.o(32813);
        }

        public final c y(View view, boolean z) {
            AppMethodBeat.i(32814);
            super.eP(view);
            this.zcu = (LinearLayout) view.findViewById(R.id.apg);
            this.zbI = (MMImageView) view.findViewById(R.id.apt);
            this.gnB = (TextView) view.findViewById(R.id.apq);
            this.zbN = (TextView) view.findViewById(R.id.apo);
            this.gnC = (TextView) view.findViewById(R.id.apr);
            this.moL = (TextView) view.findViewById(R.id.aq0);
            this.zbJ = (ImageView) view.findViewById(R.id.apz);
            this.zbL = (TextView) view.findViewById(R.id.aq2);
            this.zbK = (ImageView) view.findViewById(R.id.aq1);
            this.zbM = (LinearLayout) view.findViewById(R.id.apy);
            this.zbO = (ImageView) view.findViewById(R.id.aqd);
            this.zbP = (MMPinProgressBtn) view.findViewById(R.id.apu);
            this.zbQ = (ImageView) this.mRR.findViewById(R.id.apv);
            this.zbR = (ImageView) this.mRR.findViewById(R.id.aqc);
            this.zbS = (ImageView) this.mRR.findViewById(R.id.aqb);
            this.zbT = (ImageView) view.findViewById(R.id.apw);
            this.zbU = (TextView) view.findViewById(R.id.anl);
            this.zbW = (ImageView) view.findViewById(R.id.aqe);
            this.moo = (CheckBox) view.findViewById(R.id.a_);
            this.iVh = view.findViewById(R.id.af);
            this.qkY = (TextView) view.findViewById(R.id.od);
            this.zbV = (ChattingItemFooter) view.findViewById(R.id.aqa);
            this.zbX = (LinearLayout) view.findViewById(R.id.ap8);
            this.zbY = (ViewGroup) view.findViewById(R.id.ap5);
            this.zbZ = (TextView) view.findViewById(R.id.ap7);
            this.zca = (LinearLayout) view.findViewById(R.id.a9f);
            this.zcc = (FrameLayout) view.findViewById(R.id.ap9);
            this.zcd = (LinearLayout) view.findViewById(R.id.apn);
            this.zch = (ImageView) view.findViewById(R.id.aq_);
            this.zcb = (RelativeLayout) view.findViewById(R.id.aps);
            this.zcf = (ViewStub) view.findViewById(R.id.apx);
            this.zcg = (ImageView) view.findViewById(R.id.app);
            if (!z) {
                this.zci = (ImageView) this.mRR.findViewById(R.id.at7);
                this.pyf = (ProgressBar) this.mRR.findViewById(R.id.at6);
            }
            this.zcq = (LinearLayout) view.findViewById(R.id.ap_);
            this.zcn = (ImageView) view.findViewById(R.id.apa);
            this.zco = (TextView) view.findViewById(R.id.apb);
            this.zct = (TextView) view.findViewById(R.id.apc);
            this.zcm = (TextView) view.findViewById(R.id.apd);
            this.zcs = (ImageView) view.findViewById(R.id.ape);
            this.zcr = (ImageView) view.findViewById(R.id.apf);
            this.zcj = (LinearLayout) view.findViewById(R.id.api);
            this.zck = (ImageView) view.findViewById(R.id.apj);
            this.zcl = (TextView) view.findViewById(R.id.apk);
            this.zcp = (TextView) view.findViewById(R.id.aph);
            this.zcv = (LinearLayout) view.findViewById(R.id.aq3);
            this.zcw = (TextView) view.findViewById(R.id.aq4);
            this.zcx = (TextView) view.findViewById(R.id.aq5);
            this.zcy = (ImageView) view.findViewById(R.id.aq6);
            this.zcz = (ImageView) view.findViewById(R.id.aq7);
            this.zcA = (ImageView) view.findViewById(R.id.aq8);
            this.zcB = (TextView) view.findViewById(R.id.aq9);
            this.zcC = (LinearLayout) view.findViewById(R.id.an9);
            this.zcG = (ImageView) view.findViewById(R.id.anc);
            this.zcD = (MMNeat7extView) view.findViewById(R.id.an_);
            this.zcE = (ImageView) view.findViewById(R.id.anb);
            this.zcF = (ImageView) view.findViewById(R.id.ane);
            this.zcH = (TextView) view.findViewById(R.id.anf);
            this.zcI = (TextView) view.findViewById(R.id.and);
            if (this.zbN != null && VERSION.SDK_INT >= 16) {
                this.zcK = this.zbN.getMaxLines();
            }
            this.zcJ = c.hU(ah.getContext());
            AppMethodBeat.o(32814);
            return this;
        }

        public final void reset() {
            AppMethodBeat.i(32815);
            if (this.zbN != null) {
                this.zbN.setMaxLines(this.zcK);
            }
            AppMethodBeat.o(32815);
        }

        public static void a(c cVar, String str, int i) {
            AppMethodBeat.i(32816);
            int aiL = com.tencent.mm.pluginsdk.model.app.l.aiL(str);
            if (aiL == -1 || aiL >= 100 || i <= 0) {
                cVar.zbP.setVisibility(8);
                cVar.zbQ.setVisibility(8);
                AppMethodBeat.o(32816);
                return;
            }
            cVar.zbP.setVisibility(0);
            cVar.zbQ.setVisibility(0);
            cVar.zbP.setProgress(aiL);
            AppMethodBeat.o(32816);
        }

        static void a(com.tencent.mm.ui.chatting.d.a aVar, c cVar, com.tencent.mm.af.j.b bVar, boolean z) {
            String str;
            String str2;
            AppMethodBeat.i(32818);
            cVar.gnB.setVisibility(8);
            if (bVar.title == null || bVar.title.trim().length() <= 0) {
                cVar.zbN.setVisibility(8);
                str = null;
            } else {
                str = bVar.title;
                cVar.zbN.setVisibility(0);
                cVar.zbN.setMaxLines(2);
            }
            cVar.gnC.setMaxLines(4);
            cVar.zbT.setVisibility(8);
            cVar.zbO.setVisibility(4);
            if (z) {
                cVar.zbI.setVisibility(8);
            }
            nt ntVar = new nt();
            ntVar.cJY.type = 0;
            ntVar.cJY.cKa = bVar.fgU;
            com.tencent.mm.sdk.b.a.xxA.m(ntVar);
            com.tencent.mm.protocal.b.a.c cVar2 = ntVar.cJZ.cKi;
            if (cVar2 != null) {
                cVar.zbN.setText(com.tencent.mm.pluginsdk.ui.e.j.b(cVar.zbN.getContext(), bo.bc(cVar2.title, bVar.title), cVar.zbN.getTextSize()));
                String str3 = cVar2.desc;
                if (str3 == null) {
                    ab.e("MicroMsg.AppMsgViewHolder", "recordMsg desc is null !! recordInfo = [%s]", bVar.fgU);
                } else {
                    str3 = str3.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
                }
                if (str3 != null && str3.length() > 100) {
                    str3 = str3.substring(0, 100);
                }
                cVar.gnC.setText(com.tencent.mm.pluginsdk.ui.e.j.b(cVar.gnC.getContext(), bo.bc(str3, bVar.description), cVar.gnC.getTextSize()));
                Iterator it = cVar2.fjr.iterator();
                int i = 0;
                Object obj = null;
                String str4 = null;
                str2 = str;
                while (it.hasNext()) {
                    aar aar = (aar) it.next();
                    if (bo.isNullOrNil(aar.wgo) || !aar.wgo.equals(".htm") || bo.isNullOrNil(aar.whb) || !aar.whb.equals("WeNoteHtmlFile")) {
                        int i2;
                        if (aar.wgT.whw.whU != null) {
                            i2 = 1;
                            str2 = aVar.yTx.getContext().getString(R.string.dja);
                        } else {
                            if (aar.wgT.whw.cEV != null) {
                                if (str4 == null) {
                                    str4 = aar.wgV;
                                    i2 = i;
                                } else if (str4 != aar.wgV) {
                                    obj = aar.wgV;
                                    i2 = i;
                                }
                            }
                            i2 = i;
                        }
                        switch (aar.dataType) {
                            case 1:
                                i = i2;
                                continue;
                            case 2:
                                if (z) {
                                    cVar.zbI.setVisibility(0);
                                    cVar.zbI.setImageResource(R.drawable.avp);
                                }
                                i = i2;
                                continue;
                            case 3:
                                if (z) {
                                    cVar.zbI.setVisibility(0);
                                    cVar.zbI.setImageResource(R.raw.app_attach_file_icon_voice);
                                }
                                i = i2;
                                continue;
                            case 4:
                                if (z) {
                                    cVar.zbI.setVisibility(0);
                                    cVar.zbI.setImageResource(R.raw.app_attach_file_icon_video);
                                }
                                cVar.zbT.setVisibility(0);
                                cVar.zbT.setImageResource(R.drawable.a4k);
                                i = i2;
                                continue;
                            case 5:
                                if (z) {
                                    cVar.zbI.setVisibility(0);
                                    cVar.zbI.setImageResource(R.raw.app_attach_file_icon_webpage);
                                }
                                i = i2;
                                continue;
                            case 6:
                                cVar.zbI.setVisibility(0);
                                cVar.zbI.setImageResource(R.raw.app_attach_file_icon_location);
                                i = i2;
                                continue;
                            case 7:
                                if (z) {
                                    cVar.zbI.setVisibility(0);
                                    cVar.zbI.setImageResource(R.raw.app_attach_file_icon_music);
                                }
                                cVar.zbT.setVisibility(0);
                                cVar.zbT.setImageResource(R.drawable.vs);
                                i = i2;
                                continue;
                            case 8:
                                if (z) {
                                    cVar.zbI.setVisibility(0);
                                    cVar.zbI.setImageResource(com.tencent.mm.pluginsdk.d.ail(aar.wgo));
                                }
                                i = i2;
                                continue;
                            case 10:
                            case 11:
                            case 14:
                                if (z) {
                                    cVar.zbI.setVisibility(0);
                                    cVar.zbI.setImageResource(R.raw.app_attach_file_icon_unknow);
                                }
                                i = i2;
                                continue;
                            case 16:
                                if (z) {
                                    cVar.zbI.setVisibility(0);
                                    cVar.zbI.setImageResource(R.drawable.ad2);
                                    break;
                                }
                                break;
                        }
                        i = i2;
                    }
                }
                if (str4 != null && obj == null && i == 0) {
                    str2 = aVar.yTx.getContext().getString(R.string.bqj, new Object[]{str4});
                } else if (!(str4 == null || obj == null || str4.equals(obj) || i != 0)) {
                    str2 = aVar.yTx.getContext().getString(R.string.bqi, new Object[]{str4, obj});
                }
            } else {
                str2 = str;
            }
            if (!bo.isNullOrNil(str2)) {
                cVar.zbN.setText(str2);
                cVar.zbN.setVisibility(0);
            }
            cVar.zbI.setVisibility(8);
            cVar.zcb.setVisibility(8);
            AppMethodBeat.o(32818);
        }

        static void a(com.tencent.mm.ui.chatting.d.a aVar, c cVar, com.tencent.mm.af.j.b bVar, bi biVar, boolean z) {
            int i;
            CharSequence charSequence;
            AppMethodBeat.i(GLType.GL_UNSIGNED_SHORT_4_4_4_4);
            cVar.zcd.setVisibility(8);
            cVar.zcC.setVisibility(0);
            if (bVar.title == null || bVar.title.length() <= 0) {
                cVar.zcD.setVisibility(8);
            } else {
                cVar.zcD.setMaxLines(2);
                cVar.zcD.setVisibility(0);
                cVar.zcD.ah(bVar.getTitle());
            }
            com.tencent.mm.af.e eVar = (com.tencent.mm.af.e) bVar.X(com.tencent.mm.af.e.class);
            if (eVar != null) {
                i = eVar.duration;
            } else {
                i = 0;
            }
            String kr = com.tencent.mm.af.l.kr(i);
            if (bo.isNullOrNil(kr)) {
                cVar.zcI.setVisibility(8);
            } else {
                cVar.zcI.setVisibility(0);
                cVar.zcI.setText(kr);
            }
            cVar.zcG.setVisibility(0);
            if (eVar != null && com.tencent.mm.af.r.ks(eVar.fgc)) {
                cVar.zcI.setVisibility(8);
                cVar.zcG.setVisibility(8);
            }
            com.tencent.mm.pluginsdk.ui.a.b.r(cVar.zcF, bVar.cMg);
            ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(bVar.cMg);
            if (aoO == null || ((int) aoO.ewQ) <= 0) {
                charSequence = bVar.cMh;
                cVar.zcF.setTag(bVar.cMg);
                final WeakReference weakReference = new WeakReference(cVar.zcF);
                com.tencent.mm.model.ao.a.flu.a(bVar.cMg, "", new com.tencent.mm.model.ao.b.a() {
                    public final void o(String str, boolean z) {
                        AppMethodBeat.i(32812);
                        ImageView imageView = (ImageView) weakReference.get();
                        if (imageView == null) {
                            AppMethodBeat.o(32812);
                            return;
                        }
                        ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(str);
                        if (aoO != null && ((int) aoO.ewQ) > 0 && (imageView.getTag() instanceof String) && bo.isEqual((String) imageView.getTag(), str)) {
                            com.tencent.mm.ah.h qo = com.tencent.mm.ah.o.act().qo(str);
                            if (qo == null || bo.isNullOrNil(qo.acl())) {
                                com.tencent.mm.pluginsdk.ui.a.b.r(imageView, str);
                            } else {
                                com.tencent.mm.plugin.brandservice.b.a.a(imageView, aoO, qo.acl(), true);
                                AppMethodBeat.o(32812);
                                return;
                            }
                        }
                        AppMethodBeat.o(32812);
                    }
                });
            } else {
                if (!com.tencent.mm.n.a.jh(aoO.field_type) && com.tencent.mm.ah.b.a(bVar.cMg, false, -1) == null) {
                    com.tencent.mm.ah.h qo = com.tencent.mm.ah.o.act().qo(bVar.cMg);
                    if (!(qo == null || bo.isNullOrNil(qo.acl()))) {
                        com.tencent.mm.plugin.brandservice.b.a.a(cVar.zcF, aoO, qo.acl(), true);
                    }
                }
                String charSequence2 = s.mJ(bVar.cMg);
                if (bo.isEqual(charSequence2, bVar.cMg) && !bo.isNullOrNil(bVar.cMh)) {
                    charSequence2 = bVar.cMh;
                }
            }
            cVar.zcH.setText(com.tencent.mm.pluginsdk.ui.e.j.b(aVar.yTx.getContext(), charSequence2, cVar.zcH.getTextSize()));
            cVar.zbO.setVisibility(4);
            int al = com.tencent.mm.bz.a.al(aVar.yTx.getContext(), R.dimen.x7) - com.tencent.mm.bz.a.fromDPToPix(aVar.yTx.getContext(), 24);
            i = (al * 9) / 16;
            if (z || !bo.isNullOrNil(bVar.thumburl)) {
                String str = bVar.thumburl;
                com.tencent.mm.at.a.a.c.a aVar2 = new com.tencent.mm.at.a.a.c.a();
                aVar2.ePT = R.color.k8;
                aVar2.ePG = true;
                aVar2.ePJ = q.v(str, biVar.getType(), "@T");
                com.tencent.mm.at.a.a.c.a ct = aVar2.ct(al, i);
                ct.fGV = new com.tencent.mm.pluginsdk.ui.applet.f();
                ct.ePF = true;
                o.ahp().a(str, cVar.zcE, aVar2.ahG());
                AppMethodBeat.o(GLType.GL_UNSIGNED_SHORT_4_4_4_4);
                return;
            }
            Bitmap bitmap = null;
            if (!b.arC(biVar.field_imgPath)) {
                bitmap = o.ahl().a(biVar.field_imgPath, com.tencent.mm.bz.a.getDensity(aVar.yTx.getContext()), false);
            }
            if (bitmap == null || bitmap.isRecycled()) {
                cVar.zcE.setImageResource(R.color.k8);
                AppMethodBeat.o(GLType.GL_UNSIGNED_SHORT_4_4_4_4);
                return;
            }
            cVar.zcE.setImageBitmap(bitmap);
            AppMethodBeat.o(GLType.GL_UNSIGNED_SHORT_4_4_4_4);
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        static void b(com.tencent.mm.ui.chatting.d.a aVar, c cVar, com.tencent.mm.af.j.b bVar, bi biVar, boolean z) {
            AppMethodBeat.i(GLType.GL_UNSIGNED_SHORT_5_5_5_1);
            nt ntVar = new nt();
            ntVar.cJY.type = 0;
            ntVar.cJY.cKa = bVar.fgU;
            com.tencent.mm.sdk.b.a.xxA.m(ntVar);
            com.tencent.mm.protocal.b.a.c cVar2 = ntVar.cJZ.cKi;
            cVar.zcb.setVisibility(8);
            String[] strArr = new String[4];
            String[] strArr2 = new String[4];
            int[] iArr = new int[4];
            String[] strArr3 = new String[4];
            String[] strArr4 = new String[4];
            int[] iArr2 = new int[4];
            String[] strArr5 = new String[4];
            if (cVar2 != null) {
                String str;
                Object obj;
                String trim;
                CharSequence replaceAll;
                Object replaceAll2;
                String str2 = null;
                String bc = bo.bc(cVar2.desc, bVar.description);
                Object obj2 = null;
                Iterator it = cVar2.fjr.iterator();
                int i = 0;
                while (it.hasNext()) {
                    aar aar = (aar) it.next();
                    if (bo.isNullOrNil(aar.wgo) || !aar.wgo.equals(".htm") || bo.isNullOrNil(aar.whb) || !aar.whb.equals("WeNoteHtmlFile")) {
                        switch (aar.dataType) {
                            case 1:
                                if (obj2 == null) {
                                    String str3 = aar.desc;
                                    if (!bo.isNullOrNil(str3)) {
                                        if (bo.isNullOrNil(str3.replaceAll(IOUtils.LINE_SEPARATOR_UNIX, "").trim())) {
                                            str = str2;
                                        } else {
                                            str = aar.desc.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
                                        }
                                        obj2 = 1;
                                        str2 = str;
                                        continue;
                                    }
                                }
                            case 2:
                                if (z) {
                                    cVar.zcb.setVisibility(0);
                                    cVar.zbI.setVisibility(0);
                                    cVar.zbI.setImageResource(R.drawable.avp);
                                }
                                if (i < 4) {
                                    strArr[i] = aar.fgE;
                                    strArr2[i] = aar.wfV;
                                    iArr[i] = (int) aar.wgF;
                                    strArr3[i] = aar.wfZ;
                                    strArr4[i] = aar.wgb;
                                    iArr2[i] = (int) aar.wgu;
                                    strArr5[i] = aar.mnd;
                                }
                                i++;
                                continue;
                            case 3:
                            case 6:
                                break;
                            case 8:
                                if (bo.isNullOrNil(bc)) {
                                    bc = ah.getContext().getString(R.string.qr) + aar.title;
                                }
                                bc = bc;
                                break;
                        }
                        bc = bc;
                    }
                }
                if (str2 != null) {
                    String[] split = str2.split(IOUtils.LINE_SEPARATOR_UNIX, 2);
                    ArrayList arrayList = new ArrayList();
                    if (split.length > 0) {
                        for (String str4 : split) {
                            if (str4.length() > 0) {
                                arrayList.add(str4);
                            }
                        }
                    }
                    if (arrayList.size() == 1) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (arrayList.size() == 1 && cVar2.fjr.size() == 2) {
                        str = ah.getContext().getString(R.string.bsc);
                    } else if (i > 0) {
                        str = (String) arrayList.get(0);
                        if (arrayList.size() > 1) {
                            str2 = (String) arrayList.get(1);
                        } else {
                            str2 = null;
                        }
                    } else {
                        str = (String) arrayList.get(0);
                        String[] split2 = bc.split(Pattern.quote(str), 2);
                        str2 = split2[0].trim();
                        if (split2.length > 1) {
                            str2 = new StringBuilder(split2[0].trim()).append(IOUtils.LINE_SEPARATOR_UNIX).append(split2[1].trim()).toString().trim();
                        }
                    }
                    trim = str.trim();
                } else {
                    trim = ah.getContext().getString(R.string.bsc);
                    obj = null;
                    str2 = bc;
                }
                if (trim != null) {
                    replaceAll2 = trim.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
                } else {
                    replaceAll2 = trim;
                }
                cVar.zbN.setText(com.tencent.mm.pluginsdk.ui.e.j.b(cVar.zbN.getContext(), replaceAll2, (int) cVar.zbN.getTextSize()));
                if (str2 == null || str2.length() <= 100) {
                    replaceAll2 = str2;
                } else {
                    replaceAll2 = str2.substring(0, 100).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
                }
                cVar.gnC.setText(com.tencent.mm.pluginsdk.ui.e.j.b(cVar.gnC.getContext(), replaceAll2, (int) cVar.gnC.getTextSize()));
                if (i > 0) {
                    int i2;
                    cVar.zcb.setVisibility(8);
                    if (obj != null || obj2 == null || bo.isNullOrNil(replaceAll2)) {
                        cVar.gnC.setVisibility(8);
                        cVar.zbN.setMaxLines(2);
                    } else {
                        cVar.gnC.setMaxLines(1);
                        cVar.gnC.setVisibility(0);
                        cVar.zbN.setMaxLines(1);
                    }
                    cVar.zcg.setVisibility(8);
                    cVar.zcf.setLayoutResource(R.layout.mv);
                    try {
                        if (cVar.zce == null) {
                            cVar.zce = (LinearLayout) cVar.zcf.inflate();
                        } else {
                            cVar.zce.setVisibility(0);
                        }
                    } catch (Exception e) {
                        cVar.zcf.setVisibility(0);
                    }
                    if (i > 4) {
                        i2 = 4;
                    } else {
                        i2 = i;
                    }
                    a(aVar, cVar, i2, strArr5, strArr2, strArr, iArr, strArr4, strArr3, iArr2, biVar.field_talker);
                    ImageView imageView = (ImageView) cVar.zce.findViewById(R.id.at2);
                    TextView textView = (TextView) cVar.zce.findViewById(R.id.at3);
                    if (textView != null) {
                        textView.setTextSize(0, (float) ah.getContext().getResources().getDimensionPixelSize(R.dimen.nc));
                    }
                    if (i > 4) {
                        if (imageView != null) {
                            imageView.setVisibility(0);
                        }
                        if (textView != null) {
                            textView.setText("(" + i + ")");
                            textView.setVisibility(0);
                        }
                    }
                    AppMethodBeat.o(GLType.GL_UNSIGNED_SHORT_5_5_5_1);
                    return;
                }
                cVar.zcf.setVisibility(8);
                cVar.zcg.setVisibility(0);
            }
            AppMethodBeat.o(GLType.GL_UNSIGNED_SHORT_5_5_5_1);
        }

        private static void a(com.tencent.mm.ui.chatting.d.a aVar, c cVar, int i, String[] strArr, String[] strArr2, String[] strArr3, int[] iArr, String[] strArr4, String[] strArr5, int[] iArr2, String str) {
            MMImageView mMImageView;
            AppMethodBeat.i(32821);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 > 4) {
                    break;
                }
                mMImageView = (MMImageView) cVar.zce.findViewById(mqq[i3]);
                if (mMImageView != null) {
                    mMImageView.setImageDrawable(null);
                    mMImageView.setVisibility(8);
                }
                i2 = i3 + 1;
            }
            ImageView imageView = (ImageView) cVar.zce.findViewById(R.id.at2);
            TextView textView = (TextView) cVar.zce.findViewById(R.id.at3);
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            if (textView != null) {
                textView.setVisibility(8);
            }
            for (int i4 = 0; i4 < i; i4++) {
                if (i == 1) {
                    imageView = (MMImageView) cVar.zce.findViewById(mqq[i4]);
                    imageView.setImageResource(R.raw.chatting_note_default_img_one);
                } else {
                    mMImageView = (MMImageView) cVar.zce.findViewById(mqq[i4 + 1]);
                    mMImageView.setImageResource(R.raw.chatting_note_default_img);
                }
                imageView.setVisibility(0);
                com.tencent.mm.pluginsdk.model.app.am.dhM().a((com.tencent.mm.pluginsdk.model.app.j.a) aVar.aF(h.class), strArr[i4], bo.anU(), strArr2[i4], strArr3[i4], iArr[i4], str);
                String q = o.ahl().q("Note_" + strArr[i4], "", "");
                com.tencent.mm.at.a.a.c.a aVar2 = new com.tencent.mm.at.a.a.c.a();
                aVar2.fHe = 1;
                aVar2.eQa = true;
                aVar2.ePV = R.raw.chatting_note_default_img;
                aVar2.ePN = (int) aVar.yTx.getMMResources().getDimension(R.dimen.ee);
                aVar2.ePO = (int) aVar.yTx.getMMResources().getDimension(R.dimen.ee);
                com.tencent.mm.at.a.a.c ahG = aVar2.ahG();
                if (com.tencent.mm.vfs.e.ct(q)) {
                    o.ahp().a(q, imageView, ahG);
                } else {
                    com.tencent.mm.pluginsdk.model.app.am.dhM().a((com.tencent.mm.pluginsdk.model.app.j.a) aVar.aF(h.class), strArr[i4], bo.anU(), strArr4[i4], strArr5[i4], iArr2[i4], str);
                    o.ahl().q("Note_" + strArr[i4], "", "");
                    com.tencent.mm.bz.a.fromDPToPix(aVar.yTx.getContext(), 45);
                    if (com.tencent.mm.vfs.e.ct(q)) {
                        o.ahp().a(q, imageView, ahG);
                    } else {
                        ab.i("MicroMsg.AppMsgViewHolder", "thumb file not exist!");
                    }
                }
            }
            AppMethodBeat.o(32821);
        }

        public static void a(c cVar, Boolean bool, bi biVar, String str, String str2) {
            AppMethodBeat.i(32817);
            final long j = biVar.field_msgId;
            com.tencent.mm.pluginsdk.model.app.b lZ = com.tencent.mm.pluginsdk.model.app.am.aUq().lZ(j);
            if (lZ == null) {
                ab.w("MicroMsg.AppMsgViewHolder", "attach info is null, msgId: %s, attachName: %s", Long.valueOf(j), str2);
                AppMethodBeat.o(32817);
                return;
            }
            if (bool.booleanValue()) {
                if (lZ.field_status == 101) {
                    cVar.zbS.setVisibility(0);
                    cVar.zbP.setVisibility(0);
                    cVar.zbQ.setVisibility(0);
                } else if (lZ.field_status == 102) {
                    cVar.zbS.setVisibility(8);
                    cVar.zbP.setVisibility(8);
                    cVar.zbQ.setVisibility(8);
                } else {
                    cVar.zbS.setVisibility(8);
                    cVar.zbP.setVisibility(8);
                    cVar.zbQ.setVisibility(8);
                }
            } else if (lZ.field_status == 101) {
                cVar.zbS.setVisibility(0);
                cVar.zbR.setVisibility(8);
            } else if (lZ.field_status == 105) {
                cVar.zbS.setVisibility(8);
                cVar.zbR.setVisibility(0);
            } else {
                cVar.zbS.setVisibility(8);
                cVar.zbR.setVisibility(8);
            }
            if (biVar.field_status == 5) {
                cVar.zbS.setVisibility(8);
                cVar.zbR.setVisibility(8);
            }
            final Boolean bool2 = bool;
            final String str3 = str;
            final String str4 = str2;
            final bi biVar2 = biVar;
            cVar.zbS.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(32810);
                    long j;
                    String str;
                    com.tencent.mm.pluginsdk.model.app.b lZ;
                    if (bool2.booleanValue()) {
                        j = j;
                        str = str4;
                        lZ = com.tencent.mm.pluginsdk.model.app.am.aUq().lZ(j);
                        if (lZ == null) {
                            ab.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + " getinfo failed: " + str);
                            AppMethodBeat.o(32810);
                            return;
                        } else if (lZ.field_status != 101) {
                            ab.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + " get status failed: " + str + " status:" + lZ.field_status);
                            AppMethodBeat.o(32810);
                            return;
                        } else {
                            lZ.field_status = 102;
                            lZ.field_lastModifyTime = bo.anT();
                            com.tencent.mm.pluginsdk.model.app.am.aUq().a(lZ, new String[0]);
                            AppMethodBeat.o(32810);
                            return;
                        }
                    }
                    j = j;
                    str = str4;
                    lZ = com.tencent.mm.pluginsdk.model.app.am.aUq().lZ(j);
                    if (lZ == null) {
                        ab.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + " getinfo failed: " + str);
                    } else if (lZ.field_status != 101) {
                        ab.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + " get status failed: " + str + " status:" + lZ.field_status);
                    } else {
                        if (!bo.isNullOrNil(lZ.field_clientAppDataId) || bo.isNullOrNil(lZ.field_mediaSvrId)) {
                            lZ.field_status = 105;
                        } else {
                            lZ.field_status = 102;
                        }
                        lZ.field_lastModifyTime = bo.anT();
                        com.tencent.mm.pluginsdk.model.app.am.aUq().a(lZ, new String[0]);
                    }
                    biVar2.setStatus(5);
                    aw.ZK();
                    com.tencent.mm.model.c.XO().jf(j);
                    AppMethodBeat.o(32810);
                }
            });
            bool2 = bool;
            str3 = str2;
            final bi biVar3 = biVar;
            cVar.zbR.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(32811);
                    if (!bool2.booleanValue()) {
                        long j = j;
                        String str = str3;
                        com.tencent.mm.pluginsdk.model.app.b lZ = com.tencent.mm.pluginsdk.model.app.am.aUq().lZ(j);
                        if (lZ == null) {
                            ab.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + " getinfo failed: " + str);
                        } else if (lZ.field_status == 105 || lZ.field_status == 101) {
                            lZ.field_status = 101;
                            lZ.field_lastModifyTime = bo.anT();
                            com.tencent.mm.pluginsdk.model.app.am.aUq().a(lZ, new String[0]);
                            com.tencent.mm.pluginsdk.model.app.am.dhP().run();
                        } else {
                            ab.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + " get status failed: " + str + " status:" + lZ.field_status);
                        }
                        biVar3.setStatus(1);
                        aw.ZK();
                        com.tencent.mm.model.c.XO().jf(j);
                    }
                    AppMethodBeat.o(32811);
                }
            });
            AppMethodBeat.o(32817);
        }
    }

    public static class d extends c {
        private boolean mgQ;
        private com.tencent.mm.ui.chatting.d.a yJI;
        protected i zcO;
        protected l zcP;
        protected j zcQ;

        public final boolean dHk() {
            return false;
        }

        public final boolean aH(int i, boolean z) {
            if (z || (i != 49 && i != 335544369 && i != 402653233 && i != 369098801)) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(32834);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.m1);
                view.setTag(new c().y(view, true));
            }
            AppMethodBeat.o(32834);
            return view;
        }

        /* JADX WARNING: Removed duplicated region for block: B:110:0x0474  */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x0076  */
        /* JADX WARNING: Removed duplicated region for block: B:104:0x042d  */
        /* JADX WARNING: Removed duplicated region for block: B:107:0x0449  */
        /* JADX WARNING: Missing block: B:450:0x15cf, code skipped:
            r7 = null;
            r12 = r6;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            String substring;
            com.tencent.mm.af.j.b bVar;
            ay ayVar;
            Object obj;
            AppMethodBeat.i(32835);
            c cVar = (c) aVar;
            this.yJI = aVar2;
            cVar.reset();
            String str2 = biVar.field_content;
            com.tencent.mm.ui.chatting.c.b.j jVar = (com.tencent.mm.ui.chatting.c.b.j) aVar2.aF(com.tencent.mm.ui.chatting.c.b.j.class);
            jVar.be(biVar);
            jVar.bf(biVar);
            jVar.bg(biVar);
            if (this.mgQ) {
                int indexOf = biVar.field_content.indexOf(58);
                if (indexOf != -1) {
                    com.tencent.mm.af.n mj;
                    Object obj2;
                    substring = biVar.field_content.substring(indexOf + 1);
                    if (substring == null) {
                        com.tencent.mm.af.j.b X = com.tencent.mm.af.j.b.X(substring, biVar.field_reserved);
                        mj = com.tencent.mm.af.n.mj(substring);
                        bVar = X;
                    } else {
                        ab.e("MicroMsg.ChattingItemAppMsgFrom", "amessage, msgid:%s, user:%s", Long.valueOf(biVar.field_msgId), str);
                        mj = null;
                        bVar = null;
                    }
                    ayVar = new ay(biVar, aVar2.dFx(), i, null, 0);
                    obj = null;
                    if (bVar != null) {
                        List list;
                        Object obj3;
                        Object obj4;
                        final c cVar2;
                        final com.tencent.mm.ui.chatting.d.a aVar3;
                        boolean z;
                        ay ayVar2;
                        Bitmap b;
                        String str3;
                        cVar.gnB.setText(bVar.getTitle());
                        cVar.gnC.setText(bVar.getDescription());
                        cVar.zbN.setMaxLines(1);
                        cVar.gnB.setTextColor(aVar2.yTx.getContext().getResources().getColor(R.color.w4));
                        cVar.gnC.setTextColor(aVar2.yTx.getContext().getResources().getColor(R.color.s0));
                        cVar.zcd.setBackgroundResource(R.drawable.b0k);
                        cVar.zcd.setPadding(0, aVar2.yTx.getContext().getResources().getDimensionPixelSize(R.dimen.lo), 0, 0);
                        cVar.zbI.setVisibility(0);
                        cVar.zcb.setVisibility(0);
                        cVar.gnC.setVisibility(0);
                        cVar.zbP.setVisibility(8);
                        cVar.zbS.setVisibility(8);
                        cVar.zbR.setVisibility(8);
                        cVar.zcf.setVisibility(8);
                        cVar.zcg.setVisibility(8);
                        cVar.zbK.setVisibility(8);
                        cVar.zbL.setVisibility(8);
                        cVar.zcq.setVisibility(8);
                        cVar.zcj.setVisibility(8);
                        cVar.zcd.setVisibility(0);
                        cVar.zcv.setVisibility(8);
                        cVar.zcC.setVisibility(8);
                        com.tencent.mm.ui.chatting.viewitems.c.a.an(cVar.zcc, cVar.zcJ);
                        com.tencent.mm.af.g gVar = (com.tencent.mm.af.g) bVar.X(com.tencent.mm.af.g.class);
                        ChattingItemFooter chattingItemFooter = cVar.zbV;
                        if (gVar == null) {
                            list = null;
                        } else {
                            list = gVar.fgf;
                        }
                        if (chattingItemFooter.l(list, biVar.field_talker)) {
                            cVar.zcc.setBackgroundResource(R.drawable.i4);
                        } else {
                            cVar.zcc.setBackgroundResource(R.drawable.i0);
                        }
                        com.tencent.mm.pluginsdk.model.app.f dX = g.dX(bVar.appId, bVar.axy);
                        if (dX != null) {
                            c.b(aVar2, bVar, biVar);
                        }
                        if (dX == null || dX.field_appName == null || dX.field_appName.trim().length() <= 0) {
                            str2 = bVar.appName;
                        } else {
                            str2 = dX.field_appName;
                        }
                        boolean z2 = true;
                        com.tencent.mm.bz.a.fromDPToPix(aVar2.yTx.getContext(), 12);
                        if (bVar.type == 20 || "wxaf060266bfa9a35c".equals(bVar.appId)) {
                            z2 = com.tencent.mm.pluginsdk.p.a.dgQ().cjQ();
                        }
                        if (z2 && bVar.appId != null && bVar.appId.length() > 0 && g.dg(str2)) {
                            cVar.moL.setText(g.b(aVar2.yTx.getContext(), dX, str2));
                            cVar.moL.setVisibility(0);
                            cVar.moL.setCompoundDrawables(null, null, null, null);
                            cVar.zbM.setVisibility(0);
                            cVar.zbJ.setVisibility(0);
                            if (dX == null || !dX.xy()) {
                                c.a(aVar2, (View) cVar.moL, bVar.appId);
                            } else {
                                c.a(aVar2, (View) cVar.moL, biVar, bVar, dX.field_packageName, biVar.field_msgSvrId);
                            }
                            cVar.zbJ.setImageResource(R.drawable.ir);
                            c.a(aVar2, cVar.zbJ, bVar.appId);
                        } else if (bVar.type == 24) {
                            cVar.moL.setText(ah.getContext().getString(R.string.bnl));
                            cVar.zbM.setVisibility(0);
                            cVar.moL.setVisibility(0);
                            cVar.zbJ.setVisibility(8);
                        } else if (bVar.type == 19 || mj.fju == 19) {
                            cVar.moL.setText(ah.getContext().getString(R.string.alu));
                            cVar.zbM.setVisibility(0);
                            cVar.moL.setVisibility(0);
                            cVar.zbJ.setVisibility(8);
                        } else if (!d.a(bVar, cVar)) {
                            cVar.zbM.setVisibility(8);
                            cVar.moL.setVisibility(8);
                            cVar.zbJ.setVisibility(8);
                        }
                        if (bVar.fgl == null || bVar.fgl.fjm == 0) {
                            obj3 = null;
                        } else {
                            obj3 = 1;
                        }
                        if (obj3 != null) {
                            cVar.zbM.setVisibility(8);
                        }
                        boolean z3 = false;
                        cVar.zbI.setVisibility(0);
                        if (bVar.fgl == null || bVar.fgl.fjj != 1) {
                            obj4 = null;
                        } else {
                            obj4 = 1;
                        }
                        if (obj4 == null && this.kuU) {
                            Bitmap bitmap = null;
                            if (!(bVar.type == 33 || bVar.type == 36 || bVar.type == 44 || b.arC(biVar.field_imgPath))) {
                                bitmap = o.ahl().a(biVar.field_imgPath, com.tencent.mm.bz.a.getDensity(aVar2.yTx.getContext()), false);
                            }
                            if (bitmap == null || bitmap.isRecycled()) {
                                z3 = true;
                            } else {
                                cVar.zbI.setImageBitmap(bitmap);
                            }
                            if (bVar.type == 3) {
                                cVar2 = cVar;
                                aVar3 = aVar2;
                                cVar.zcd.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                                    private boolean zcR = false;

                                    public final boolean onPreDraw() {
                                        AppMethodBeat.i(32822);
                                        if (this.zcR) {
                                            cVar2.zcd.getViewTreeObserver().removeOnPreDrawListener(this);
                                            AppMethodBeat.o(32822);
                                        } else {
                                            cVar2.zcd.getViewTreeObserver().removeOnPreDrawListener(this);
                                            this.zcR = true;
                                            int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(aVar3.yTx.getContext(), 24);
                                            Bitmap bitmap = bitmap;
                                            if (bitmap == null || bitmap.isRecycled()) {
                                                bitmap = com.tencent.mm.sdk.platformtools.d.au(aVar3.yTx.getContext().getResources().getColor(R.color.k0), fromDPToPix, fromDPToPix);
                                            }
                                            int height = bitmap.getHeight();
                                            if (fromDPToPix <= height) {
                                                height = fromDPToPix;
                                            }
                                            Bitmap e = com.tencent.mm.sdk.platformtools.d.e(com.tencent.mm.sdk.platformtools.d.al(Bitmap.createScaledBitmap(bitmap, height, height, true)), 20);
                                            height = cVar2.zcd.getHeight();
                                            int width = cVar2.zcd.getWidth();
                                            if (height == 0) {
                                                height = com.tencent.mm.bz.a.al(aVar3.yTx.getContext(), R.dimen.x5);
                                            }
                                            if (width == 0) {
                                                width = com.tencent.mm.bz.a.al(aVar3.yTx.getContext(), R.dimen.x6);
                                            }
                                            cVar2.zcd.setBackgroundDrawable(new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.a(e, (int) R.drawable.b0k, width, height)));
                                            AppMethodBeat.o(32822);
                                        }
                                        return true;
                                    }
                                });
                            }
                            z = z3;
                        } else {
                            cVar.zbI.setImageBitmap(BitmapFactory.decodeResource(aVar2.yTx.getMMResources(), R.drawable.ak9));
                            z = false;
                        }
                        if (bVar.dJv == null || bVar.dJv.length() == 0) {
                            cVar.zbU.setVisibility(8);
                        } else {
                            cVar.zbU.setVisibility(0);
                            b(aVar2, (View) cVar.zbU, (Object) ay.arL(bVar.dJv));
                        }
                        cVar.zbT.setOnClickListener(null);
                        cVar.zbX.setVisibility(0);
                        cVar.zbO.setVisibility(8);
                        cVar.zca.setVisibility(0);
                        cVar.zbY.setVisibility(8);
                        Bitmap b2;
                        WxaAttributes zb;
                        CharSequence charSequence;
                        switch (bVar.type) {
                            case 0:
                                if (bVar.title == null || bVar.title.length() <= 0) {
                                    cVar.gnB.setVisibility(8);
                                } else {
                                    cVar.gnB.setVisibility(0);
                                }
                                cVar.gnC.setVisibility(0);
                                cVar.zbN.setVisibility(8);
                                cVar.zbT.setVisibility(8);
                                cVar.zbO.setVisibility(4);
                                cVar.gnC.setMaxLines(2);
                                if (z) {
                                    b2 = g.b(bVar.appId, 1, com.tencent.mm.bz.a.getDensity(aVar2.yTx.getContext()));
                                    if (b2 != null && !b2.isRecycled()) {
                                        cVar.zbI.setImageBitmap(b2);
                                        obj3 = null;
                                        ayVar2 = ayVar;
                                        break;
                                    }
                                    cVar.zbI.setImageResource(R.raw.app_attach_file_icon_webpage);
                                    obj3 = null;
                                    ayVar2 = ayVar;
                                    break;
                                }
                                break;
                            case 3:
                                if (bVar.title == null || bVar.title.length() <= 0) {
                                    cVar.gnB.setVisibility(8);
                                } else {
                                    cVar.gnB.setVisibility(0);
                                    cVar.gnB.setTextColor(aVar2.yTx.getContext().getResources().getColor(R.color.a69));
                                }
                                cVar.gnC.setVisibility(0);
                                cVar.gnC.setTextColor(aVar2.yTx.getContext().getResources().getColor(R.color.a69));
                                cVar.zbN.setVisibility(8);
                                cVar.zbO.setVisibility(4);
                                cVar.zbT.setVisibility(0);
                                if ((biVar.field_msgId).equals(aVar.zbz)) {
                                    cVar.zbT.setImageResource(R.drawable.vq);
                                } else {
                                    cVar.zbT.setImageResource(R.drawable.vs);
                                }
                                cVar.gnC.setMaxLines(2);
                                if (z) {
                                    b2 = g.b(bVar.appId, 1, com.tencent.mm.bz.a.getDensity(aVar2.yTx.getContext()));
                                    if (b2 == null || b2.isRecycled()) {
                                        cVar.zbI.setImageResource(R.raw.app_attach_file_icon_music);
                                    } else {
                                        cVar.zbI.setImageBitmap(b2);
                                    }
                                }
                                f fVar = new f();
                                fVar.cvx = biVar.field_msgId;
                                fVar.cHz = biVar.field_content;
                                fVar.imgPath = biVar.field_imgPath;
                                cVar.zbT.setTag(fVar);
                                cVar.zbT.setOnClickListener(((h) aVar2.aF(h.class)).dDa());
                                obj3 = null;
                                ayVar2 = ayVar;
                                break;
                            case 4:
                                if (bVar.title == null || bVar.title.length() <= 0) {
                                    cVar.gnB.setVisibility(8);
                                } else {
                                    cVar.gnB.setVisibility(0);
                                }
                                cVar.gnC.setVisibility(0);
                                cVar.zbN.setVisibility(8);
                                cVar.zbT.setVisibility(0);
                                cVar.zbT.setImageResource(R.drawable.a4k);
                                cVar.zbO.setVisibility(4);
                                cVar.gnC.setMaxLines(2);
                                if (z) {
                                    b2 = g.b(bVar.appId, 1, com.tencent.mm.bz.a.getDensity(aVar2.yTx.getContext()));
                                    if (b2 == null || b2.isRecycled()) {
                                        cVar.zbI.setImageResource(R.raw.app_attach_file_icon_video);
                                    } else {
                                        cVar.zbI.setImageBitmap(b2);
                                    }
                                    cVar.zbT.setVisibility(8);
                                    obj3 = null;
                                    ayVar2 = ayVar;
                                    break;
                                }
                                break;
                            case 5:
                                com.tencent.mm.af.e eVar = (com.tencent.mm.af.e) bVar.X(com.tencent.mm.af.e.class);
                                if (eVar == null || eVar.fgb != 1 || eVar.ffZ != 5 || !((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.b.class)).aVP()) {
                                    cVar.gnB.setVisibility(8);
                                    if (bVar.title == null || bVar.title.length() <= 0) {
                                        cVar.zbN.setVisibility(8);
                                    } else {
                                        cVar.zbN.setMaxLines(2);
                                        cVar.zbN.setVisibility(0);
                                        cVar.zbN.setText(bVar.getTitle());
                                    }
                                    cVar.gnC.setMaxLines(3);
                                    if (d.h(bVar)) {
                                        cVar.zbT.setVisibility(0);
                                        cVar.zbT.setImageResource(R.drawable.a4k);
                                    } else {
                                        cVar.zbT.setVisibility(8);
                                    }
                                    cVar.zbO.setVisibility(4);
                                    if (z) {
                                        b2 = g.b(bVar.appId, 1, com.tencent.mm.bz.a.getDensity(aVar2.yTx.getContext()));
                                        if (b2 != null && !b2.isRecycled()) {
                                            cVar.zbI.setImageBitmap(b2);
                                            obj3 = null;
                                            ayVar2 = ayVar;
                                            break;
                                        }
                                        com.tencent.mm.at.a.a.c.a aVar4 = new com.tencent.mm.at.a.a.c.a();
                                        aVar4.ePT = R.raw.app_attach_file_icon_webpage;
                                        aVar4.ePG = true;
                                        aVar4.ePK = com.tencent.mm.plugin.i.c.bGF();
                                        aVar4.ct(com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 50), com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 50)).ePF = true;
                                        o.ahp().a(bo.isNullOrNil(bVar.thumburl) ? bVar.fgv : bVar.thumburl, cVar.zbI, aVar4.ahG());
                                        obj3 = null;
                                        ayVar2 = ayVar;
                                        break;
                                    }
                                }
                                c.a(aVar2, cVar, bVar, biVar, z);
                                obj3 = null;
                                ayVar2 = ayVar;
                                break;
                                break;
                            case 6:
                                if (bVar.title == null || bVar.title.length() <= 0) {
                                    cVar.gnB.setVisibility(8);
                                } else {
                                    cVar.gnB.setVisibility(0);
                                    cVar.gnB.setMaxLines(2);
                                }
                                cVar.gnC.setVisibility(0);
                                cVar.zbN.setVisibility(8);
                                cVar.zbT.setVisibility(8);
                                cVar.zbO.setVisibility(4);
                                cVar.gnC.setMaxLines(2);
                                cVar.gnC.setText(bo.ga((long) bVar.fgo));
                                c.a(cVar, substring, bVar.fgo);
                                c.a(cVar, Boolean.TRUE, biVar, bVar.csD, bVar.title);
                                if (z) {
                                    if (!bo.any(bVar.fgp)) {
                                        cVar.zbI.setImageResource(com.tencent.mm.pluginsdk.model.o.aiD(bVar.fgp));
                                        obj3 = null;
                                        ayVar2 = ayVar;
                                        break;
                                    }
                                    cVar.zbI.setImageResource(R.drawable.aay);
                                    obj3 = null;
                                    ayVar2 = ayVar;
                                    break;
                                }
                                break;
                            case 7:
                                cVar.gnB.setVisibility(8);
                                if (bVar.title == null || bVar.title.trim().length() <= 0) {
                                    cVar.zbN.setVisibility(8);
                                } else {
                                    cVar.zbN.setMaxLines(2);
                                    cVar.zbN.setVisibility(0);
                                    cVar.zbN.setText(bVar.getTitle());
                                }
                                cVar.gnC.setMaxLines(3);
                                cVar.zbT.setVisibility(8);
                                cVar.zbO.setVisibility(4);
                                if (z) {
                                    b2 = g.b(bVar.appId, 1, com.tencent.mm.bz.a.getDensity(aVar2.yTx.getContext()));
                                    if (b2 != null && !b2.isRecycled()) {
                                        cVar.zbI.setImageBitmap(b2);
                                        obj3 = null;
                                        ayVar2 = ayVar;
                                        break;
                                    }
                                    cVar.zbI.setImageResource(R.raw.app_attach_file_icon_webpage);
                                    obj3 = null;
                                    ayVar2 = ayVar;
                                    break;
                                }
                                break;
                            case 10:
                                cVar.zbN.setVisibility(0);
                                if (bVar.fgP == 1) {
                                    cVar.zbN.setText(R.string.dyb);
                                } else if (bVar.fgP == 2) {
                                    cVar.zbN.setText(R.string.dyd);
                                } else if (bVar.fgP == 3) {
                                    cVar.zbN.setText(R.string.dyc);
                                } else {
                                    cVar.zbN.setText(R.string.dye);
                                }
                                if (bVar.title != null && bVar.title.length() > 0) {
                                    cVar.gnB.setVisibility(0);
                                    cVar.gnB.setText(bVar.getTitle());
                                }
                                cVar.gnC.setMaxLines(4);
                                cVar.zbO.setVisibility(4);
                                cVar.zbT.setVisibility(8);
                                if (z) {
                                    b2 = o.ahl().b(biVar.field_imgPath, com.tencent.mm.bz.a.getDensity(aVar2.yTx.getContext()), false);
                                    if (b2 != null && !b2.isRecycled()) {
                                        cVar.zbI.setImageBitmap(b2);
                                        obj3 = null;
                                        ayVar2 = ayVar;
                                        break;
                                    }
                                    cVar.zbI.setImageResource(R.raw.app_attach_file_icon_webpage);
                                    obj3 = null;
                                    ayVar2 = ayVar;
                                    break;
                                }
                                break;
                            case 13:
                                cVar.gnB.setVisibility(0);
                                cVar.gnB.setText(bVar.getTitle());
                                cVar.zbN.setVisibility(0);
                                cVar.zbN.setText(R.string.amu);
                                cVar.gnC.setMaxLines(4);
                                cVar.zbO.setVisibility(4);
                                cVar.zbT.setVisibility(8);
                                if (z) {
                                    b2 = o.ahl().b(biVar.field_imgPath, com.tencent.mm.bz.a.getDensity(aVar2.yTx.getContext()), false);
                                    if (b2 != null && !b2.isRecycled()) {
                                        cVar.zbI.setImageBitmap(b2);
                                        obj3 = null;
                                        ayVar2 = ayVar;
                                        break;
                                    }
                                    cVar.zbI.setImageResource(R.raw.app_attach_file_icon_webpage);
                                    obj3 = null;
                                    ayVar2 = ayVar;
                                    break;
                                }
                                break;
                            case 15:
                                if (bVar.title == null || bVar.title.length() <= 0) {
                                    cVar.gnB.setVisibility(8);
                                } else {
                                    cVar.gnB.setVisibility(0);
                                }
                                cVar.gnC.setVisibility(0);
                                cVar.zbN.setVisibility(8);
                                cVar.zbT.setVisibility(8);
                                cVar.zbO.setVisibility(4);
                                cVar.gnC.setMaxLines(2);
                                if (z) {
                                    b = o.ahl().b(biVar.field_imgPath, com.tencent.mm.bz.a.getDensity(aVar2.yTx.getContext()), false);
                                    if (b == null || b.isRecycled()) {
                                        cVar.zbI.setImageResource(R.raw.app_attach_file_icon_webpage);
                                    } else {
                                        cVar.zbI.setImageBitmap(b);
                                    }
                                }
                                ayVar = new ay(biVar, false, i, "", false, bVar.title, bVar.cMg, bVar.cMh, bVar.title, bVar.fgX, bVar.url, false, false);
                                cVar.zcc.setTag(ayVar);
                                cVar.zcc.setOnClickListener(i(aVar2));
                                obj = 1;
                                obj3 = null;
                                ayVar2 = ayVar;
                                break;
                            case 16:
                                cVar.gnB.setVisibility(0);
                                cVar.gnB.setText(bVar.description);
                                cVar.gnC.setText(bVar.fhC);
                                if (bVar.title == null || bVar.title.length() <= 0) {
                                    cVar.zbN.setVisibility(8);
                                } else {
                                    cVar.zbN.setVisibility(0);
                                    cVar.zbN.setText(bVar.title);
                                }
                                cVar.gnC.setMaxLines(4);
                                cVar.zbO.setVisibility(4);
                                cVar.zbT.setVisibility(8);
                                if (z) {
                                    b2 = o.ahl().b(biVar.field_imgPath, com.tencent.mm.bz.a.getDensity(aVar2.yTx.getContext()), false);
                                    if (b2 == null) {
                                        cVar.zbI.setImageResource(R.raw.app_attach_file_icon_webpage);
                                        obj3 = null;
                                        ayVar2 = ayVar;
                                        break;
                                    }
                                    cVar.zbI.setImageBitmap(b2);
                                    obj3 = null;
                                    ayVar2 = ayVar;
                                    break;
                                }
                                break;
                            case 19:
                                c.a(aVar2, cVar, bVar, z);
                                obj3 = null;
                                ayVar2 = ayVar;
                                break;
                            case 20:
                                if (bVar.title != null && bVar.title.length() > 0) {
                                    cVar.gnB.setVisibility(0);
                                    cVar.gnB.setText(bVar.getTitle());
                                    cVar.zbN.setVisibility(8);
                                }
                                cVar.gnC.setMaxLines(4);
                                cVar.zbO.setVisibility(4);
                                cVar.zbT.setVisibility(8);
                                if (z) {
                                    b2 = o.ahl().b(biVar.field_imgPath, com.tencent.mm.bz.a.getDensity(aVar2.yTx.getContext()), false);
                                    if (b2 != null && !b2.isRecycled()) {
                                        cVar.zbI.setImageBitmap(b2);
                                        obj3 = null;
                                        ayVar2 = ayVar;
                                        break;
                                    }
                                    cVar.zbI.setImageResource(R.raw.app_attach_file_icon_webpage);
                                    obj3 = null;
                                    ayVar2 = ayVar;
                                    break;
                                }
                                break;
                            case 24:
                                cVar.gnB.setVisibility(8);
                                cVar.zbN.setVisibility(0);
                                if (bVar.title == null || bVar.title.trim().length() <= 0) {
                                    cVar.zbN.setText(com.tencent.mm.pluginsdk.ui.e.j.b(cVar.zbN.getContext(), ah.getContext().getString(R.string.bsc), cVar.zbN.getTextSize()));
                                } else {
                                    cVar.zbN.setText(com.tencent.mm.pluginsdk.ui.e.j.b(cVar.zbN.getContext(), bVar.title, cVar.zbN.getTextSize()));
                                }
                                cVar.gnC.setMaxLines(3);
                                cVar.zbT.setVisibility(8);
                                cVar.zbO.setVisibility(4);
                                if (z) {
                                    cVar.zbI.setVisibility(8);
                                    cVar.zcb.setVisibility(8);
                                }
                                c.b(aVar2, cVar, bVar, biVar, z);
                                obj3 = null;
                                ayVar2 = ayVar;
                                break;
                            case 25:
                                if (bVar.title == null || bVar.title.length() <= 0) {
                                    cVar.gnB.setVisibility(8);
                                } else {
                                    cVar.gnB.setVisibility(0);
                                }
                                cVar.gnC.setVisibility(0);
                                cVar.zbN.setVisibility(8);
                                cVar.zbT.setVisibility(8);
                                cVar.zbO.setVisibility(4);
                                cVar.gnC.setMaxLines(2);
                                if (z) {
                                    b = o.ahl().b(biVar.field_imgPath, com.tencent.mm.bz.a.getDensity(aVar2.yTx.getContext()), false);
                                    if (b == null || b.isRecycled()) {
                                        cVar.zbI.setImageResource(R.raw.app_attach_file_icon_webpage);
                                    } else {
                                        cVar.zbI.setImageBitmap(b);
                                    }
                                }
                                ayVar = new ay(biVar, i, "", aVar2.dDw(), bVar.cMg, bVar.cMh, bVar.title, bVar.fiD, bVar.designerName, bVar.designerRediretctUrl, bVar.url);
                                cVar.zcc.setTag(ayVar);
                                FrameLayout frameLayout = cVar.zcc;
                                if (this.zcO == null) {
                                    this.zcO = new i(aVar2);
                                }
                                frameLayout.setOnClickListener(this.zcO);
                                obj = 1;
                                obj3 = null;
                                ayVar2 = ayVar;
                                break;
                            case 26:
                            case 27:
                                if (bVar.title == null || bVar.title.length() <= 0) {
                                    cVar.gnB.setVisibility(8);
                                } else {
                                    cVar.gnB.setVisibility(0);
                                }
                                cVar.gnC.setVisibility(0);
                                cVar.zbN.setVisibility(8);
                                cVar.zbT.setVisibility(8);
                                cVar.zbO.setVisibility(4);
                                cVar.gnC.setMaxLines(2);
                                if (z) {
                                    b = o.ahl().b(biVar.field_imgPath, com.tencent.mm.bz.a.getDensity(aVar2.yTx.getContext()), false);
                                    if (b == null || b.isRecycled()) {
                                        cVar.zbI.setImageResource(R.raw.app_attach_file_icon_webpage);
                                    } else {
                                        cVar.zbI.setImageBitmap(b);
                                    }
                                }
                                ayVar2 = new ay();
                                ayVar2.cKd = biVar;
                                ayVar2.yFW = false;
                                ayVar2.position = i;
                                ayVar2.zis = false;
                                ayVar2.title = aVar2.dDw();
                                ayVar2.cMg = bVar.cMg;
                                ayVar2.cMh = bVar.cMh;
                                ayVar2.zit = bVar.title;
                                FrameLayout frameLayout2;
                                if (bVar.type == 26) {
                                    ayVar2.tid = bVar.tid;
                                    ayVar2.fiE = bVar.fiE;
                                    ayVar2.desc = bVar.desc;
                                    ayVar2.iconUrl = bVar.iconUrl;
                                    ayVar2.secondUrl = bVar.secondUrl;
                                    ayVar2.pageType = bVar.pageType;
                                    frameLayout2 = cVar.zcc;
                                    if (this.zcP == null) {
                                        this.zcP = new l(aVar2);
                                    }
                                    frameLayout2.setOnClickListener(this.zcP);
                                    obj2 = 1;
                                } else if (bVar.type == 27) {
                                    ayVar2.tid = bVar.tid;
                                    ayVar2.fiE = bVar.fiE;
                                    ayVar2.desc = bVar.desc;
                                    ayVar2.iconUrl = bVar.iconUrl;
                                    ayVar2.secondUrl = bVar.secondUrl;
                                    ayVar2.pageType = bVar.pageType;
                                    frameLayout2 = cVar.zcc;
                                    if (this.zcQ == null) {
                                        this.zcQ = new j(aVar2);
                                    }
                                    frameLayout2.setOnClickListener(this.zcQ);
                                    obj2 = 1;
                                } else {
                                    obj2 = null;
                                }
                                cVar.zcc.setTag(ayVar2);
                                obj3 = null;
                                obj = obj2;
                                break;
                            case 33:
                                zb = ((com.tencent.mm.plugin.appbrand.service.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.d.class)).zb(bVar.fiP);
                                switch (bVar.fiR) {
                                    case 0:
                                        cVar.zbM.setVisibility(0);
                                        cVar.zbJ.setVisibility(0);
                                        cVar.zbJ.setBackground(null);
                                        cVar.zbJ.setImageResource(R.raw.app_brand_we_app_logo_share);
                                        d.a(cVar.moL, bVar);
                                    case 1:
                                        if (zb != null) {
                                            charSequence = zb.field_nickname;
                                        } else {
                                            obj4 = bVar.title;
                                        }
                                        str2 = zb != null ? zb.field_smallHeadURL : null;
                                        cVar.zcd.setVisibility(8);
                                        cVar.zcq.setVisibility(8);
                                        cVar.zcj.setVisibility(0);
                                        cVar.zcl.setText(charSequence);
                                        cVar.zcv.setVisibility(8);
                                        if (!bo.isNullOrNil(str2)) {
                                            com.tencent.mm.modelappbrand.a.b.abR().a(cVar.zck, str2, com.tencent.mm.modelappbrand.a.a.abQ(), com.tencent.mm.modelappbrand.a.f.fqH);
                                            obj3 = null;
                                            ayVar2 = ayVar;
                                            break;
                                        }
                                        com.tencent.mm.modelappbrand.a.b.abR().a(cVar.zck, "file://".concat(String.valueOf(o.ahl().c(biVar.field_imgPath, false, true))), com.tencent.mm.modelappbrand.a.a.abQ(), com.tencent.mm.modelappbrand.a.f.fqH);
                                        obj3 = null;
                                        ayVar2 = ayVar;
                                        break;
                                    case 2:
                                    case 3:
                                        if (zb != null) {
                                            charSequence = zb.field_nickname;
                                        } else {
                                            obj4 = bVar.cMh;
                                        }
                                        if (zb != null) {
                                            str2 = zb.field_smallHeadURL;
                                        } else {
                                            str2 = bVar.fjb;
                                        }
                                        cVar.zcd.setVisibility(8);
                                        cVar.zcq.setVisibility(0);
                                        cVar.zcj.setVisibility(8);
                                        cVar.zcm.setVisibility(8);
                                        cVar.zcv.setVisibility(8);
                                        cVar.zct.setText(bVar.title);
                                        cVar.zcm.setText(bVar.description);
                                        cVar.zco.setText(charSequence);
                                        d.a(cVar.zcp, bVar);
                                        o.ahp().a(str2, cVar.zcn, d.zel);
                                        str2 = o.ahl().c(biVar.field_imgPath, false, true);
                                        cVar.zcr.setImageBitmap(null);
                                        cVar.zcr.setVisibility(4);
                                        cVar.zcs.setVisibility(0);
                                        cVar2 = cVar;
                                        com.tencent.mm.modelappbrand.a.b.abR().a(new com.tencent.mm.modelappbrand.a.b.i() {
                                            public final void abU() {
                                            }

                                            public final void x(Bitmap bitmap) {
                                                AppMethodBeat.i(32823);
                                                if (bitmap == null || bitmap.isRecycled()) {
                                                    cVar2.zcr.setVisibility(4);
                                                    cVar2.zcs.setVisibility(0);
                                                    AppMethodBeat.o(32823);
                                                    return;
                                                }
                                                cVar2.zcr.setImageBitmap(bitmap);
                                                cVar2.zcr.setVisibility(0);
                                                cVar2.zcs.setVisibility(4);
                                                AppMethodBeat.o(32823);
                                            }

                                            public final void mr() {
                                            }

                                            public final String wP() {
                                                AppMethodBeat.i(32824);
                                                String str = "CHAT#" + com.tencent.mm.plugin.appbrand.r.n.bE(this);
                                                AppMethodBeat.o(32824);
                                                return str;
                                            }
                                        }, "file://".concat(String.valueOf(str2)), null, ((com.tencent.mm.modelappbrand.i) com.tencent.mm.kernel.g.K(com.tencent.mm.modelappbrand.i.class)).cq(240, az.CTRL_INDEX));
                                        obj3 = null;
                                        ayVar2 = ayVar;
                                        break;
                                    default:
                                        obj3 = 1;
                                        ayVar2 = ayVar;
                                        break;
                                }
                            case 34:
                                if (bVar.title == null || bVar.title.length() <= 0) {
                                    cVar.gnB.setVisibility(8);
                                } else {
                                    cVar.gnB.setVisibility(0);
                                    if (bo.isNullOrNil(bVar.fhL)) {
                                        cVar.gnB.setTextColor(aVar2.yTx.getContext().getResources().getColor(R.color.h4));
                                    } else {
                                        cVar.gnB.setTextColor(bo.bS(bVar.fhL, aVar2.yTx.getContext().getResources().getColor(R.color.h4)));
                                    }
                                }
                                cVar.gnC.setMaxLines(2);
                                cVar.gnC.setVisibility(0);
                                if (bo.isNullOrNil(bVar.fhM)) {
                                    cVar.gnC.setTextColor(aVar2.yTx.getContext().getResources().getColor(R.color.rb));
                                } else {
                                    cVar.gnC.setTextColor(bo.bS(bVar.fhM, aVar2.yTx.getContext().getResources().getColor(R.color.rb)));
                                }
                                cVar.zbN.setVisibility(8);
                                cVar.zbO.setVisibility(4);
                                cVar.zbT.setVisibility(8);
                                cVar.zbM.setVisibility(0);
                                cVar.moL.setVisibility(0);
                                if (bo.isNullOrNil(bVar.fhH)) {
                                    cVar.moL.setText(R.string.als);
                                } else {
                                    cVar.moL.setText(bVar.fhH);
                                }
                                if (!this.kuU) {
                                    cVar.zbI.setImageBitmap(BitmapFactory.decodeResource(aVar2.yTx.getMMResources(), R.drawable.ak9));
                                    obj3 = null;
                                    ayVar2 = ayVar;
                                    break;
                                }
                                b2 = o.ahl().a(biVar.field_imgPath, com.tencent.mm.bz.a.getDensity(aVar2.yTx.getContext()), false);
                                if (!(b2 == null || b2.isRecycled())) {
                                    cVar.zbI.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(b2, false, (float) (b2.getWidth() / 2)));
                                }
                                if (!bo.isNullOrNil(bVar.fhK)) {
                                    com.tencent.mm.at.a.a ahp = o.ahp();
                                    str3 = bVar.fhK;
                                    ImageView imageView = new ImageView(aVar2.yTx.getContext());
                                    com.tencent.mm.at.a.a.c.a aVar5 = new com.tencent.mm.at.a.a.c.a();
                                    aVar5.ePH = true;
                                    cVar2 = cVar;
                                    aVar3 = aVar2;
                                    ahp.a(str3, imageView, aVar5.ahG(), new com.tencent.mm.at.a.c.g() {
                                        public final void sH(String str) {
                                        }

                                        public final Bitmap a(String str, View view, com.tencent.mm.at.a.d.b bVar) {
                                            return null;
                                        }

                                        public final void b(String str, View view, com.tencent.mm.at.a.d.b bVar) {
                                            AppMethodBeat.i(32831);
                                            if (bVar.bitmap != null) {
                                                final Bitmap bitmap = bVar.bitmap;
                                                cVar2.zcd.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                                                    public final boolean onPreDraw() {
                                                        AppMethodBeat.i(32830);
                                                        cVar2.zcd.getViewTreeObserver().removeOnPreDrawListener(this);
                                                        int height = cVar2.zcd.getHeight();
                                                        int width = cVar2.zcd.getWidth();
                                                        if (height == 0) {
                                                            height = com.tencent.mm.bz.a.al(aVar3.yTx.getContext(), R.dimen.x5);
                                                        }
                                                        if (width == 0) {
                                                            width = com.tencent.mm.bz.a.al(aVar3.yTx.getContext(), R.dimen.x6);
                                                        }
                                                        cVar2.zcd.setBackgroundDrawable(new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.a(bitmap, (int) R.drawable.b0k, width, height)));
                                                        AppMethodBeat.o(32830);
                                                        return true;
                                                    }
                                                });
                                            }
                                            AppMethodBeat.o(32831);
                                        }
                                    });
                                    obj3 = null;
                                    ayVar2 = ayVar;
                                    break;
                                }
                                cVar2 = cVar;
                                aVar3 = aVar2;
                                cVar.zcd.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                                    private boolean zcR = false;

                                    public final boolean onPreDraw() {
                                        AppMethodBeat.i(32832);
                                        if (this.zcR) {
                                            cVar2.zcd.getViewTreeObserver().removeOnPreDrawListener(this);
                                            AppMethodBeat.o(32832);
                                        } else {
                                            cVar2.zcd.getViewTreeObserver().removeOnPreDrawListener(this);
                                            this.zcR = true;
                                            int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(aVar3.yTx.getContext(), 24);
                                            Bitmap bitmap = b2;
                                            if (bitmap == null || bitmap.isRecycled()) {
                                                bitmap = com.tencent.mm.sdk.platformtools.d.au(aVar3.yTx.getContext().getResources().getColor(R.color.k0), fromDPToPix, fromDPToPix);
                                            }
                                            int height = bitmap.getHeight();
                                            if (fromDPToPix <= height) {
                                                height = fromDPToPix;
                                            }
                                            Bitmap e = com.tencent.mm.sdk.platformtools.d.e(com.tencent.mm.sdk.platformtools.d.al(Bitmap.createScaledBitmap(bitmap, height, height, true)), 20);
                                            height = cVar2.zcd.getHeight();
                                            int width = cVar2.zcd.getWidth();
                                            if (height == 0) {
                                                height = com.tencent.mm.bz.a.al(aVar3.yTx.getContext(), R.dimen.x5);
                                            }
                                            if (width == 0) {
                                                width = com.tencent.mm.bz.a.al(aVar3.yTx.getContext(), R.dimen.x6);
                                            }
                                            cVar2.zcd.setBackgroundDrawable(new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.a(e, (int) R.drawable.b0k, width, height)));
                                            AppMethodBeat.o(32832);
                                        }
                                        return true;
                                    }
                                });
                                obj3 = null;
                                ayVar2 = ayVar;
                                break;
                                break;
                            case 36:
                                zb = ((com.tencent.mm.plugin.appbrand.service.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.d.class)).zb(bVar.fiP);
                                if (zb != null) {
                                    charSequence = zb.field_nickname;
                                } else {
                                    obj4 = bVar.cMh;
                                }
                                if (zb != null) {
                                    str2 = zb.field_smallHeadURL;
                                } else {
                                    str2 = bVar.fjb;
                                }
                                cVar.zcd.setVisibility(8);
                                cVar.zcq.setVisibility(0);
                                cVar.zcj.setVisibility(8);
                                cVar.zcm.setVisibility(8);
                                cVar.zcv.setVisibility(8);
                                cVar.zct.setText(bVar.title);
                                cVar.zcm.setText(bVar.description);
                                cVar.zco.setText(charSequence);
                                d.a(cVar.zcp, bVar);
                                o.ahp().a(str2, cVar.zcn, d.zel);
                                String c = o.ahl().c(biVar.field_imgPath, false, true);
                                cVar.zcr.setImageBitmap(null);
                                com.tencent.mm.modelappbrand.a.b.abR().a(cVar.zcr, "file://".concat(String.valueOf(c)), null, null, ((com.tencent.mm.modelappbrand.i) com.tencent.mm.kernel.g.K(com.tencent.mm.modelappbrand.i.class)).cq(240, az.CTRL_INDEX));
                                obj3 = null;
                                ayVar2 = ayVar;
                                break;
                            case 40:
                                if (mj.fju == 19) {
                                    c.a(aVar2, cVar, bVar, z);
                                    obj3 = null;
                                    ayVar2 = ayVar;
                                    break;
                                }
                            case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                                if (!bVar.cw(false)) {
                                    obj3 = 1;
                                    ayVar2 = ayVar;
                                    break;
                                }
                                str2 = bVar.p(aVar2.yTx.getContext(), false);
                                if (!bo.isNullOrNil(str2)) {
                                    cVar.zcB.setText(str2);
                                    cVar.zcd.setVisibility(8);
                                    cVar.zcq.setVisibility(8);
                                    cVar.zcj.setVisibility(8);
                                    cVar.zcv.setVisibility(0);
                                    cVar.zcw.setText(bVar.title);
                                    cVar.zcx.setText(bVar.description);
                                    if (com.tencent.mm.af.j.a.BUSINESS_MY_LIFE_AROUND.ordinal() == bVar.fiW) {
                                        cVar.zcA.setImageResource(R.raw.my_life_around_default_icon);
                                    } else if (com.tencent.mm.af.j.a.BUSINESS_OTHER.ordinal() == bVar.fiW) {
                                        cVar2 = cVar;
                                        o.aho().a(bVar.fjb, new com.tencent.mm.at.p.a() {
                                            public final void i(String str, final Bitmap bitmap) {
                                                AppMethodBeat.i(32826);
                                                al.d(new Runnable() {
                                                    public final void run() {
                                                        AppMethodBeat.i(32825);
                                                        cVar2.zcA.setImageBitmap(bitmap);
                                                        AppMethodBeat.o(32825);
                                                    }
                                                });
                                                AppMethodBeat.o(32826);
                                            }
                                        });
                                    }
                                    str2 = o.ahl().c(biVar.field_imgPath, false, true);
                                    cVar.zcz.setImageBitmap(null);
                                    cVar2 = cVar;
                                    com.tencent.mm.modelappbrand.a.b.abR().a(new com.tencent.mm.modelappbrand.a.b.i() {
                                        public final void abU() {
                                            AppMethodBeat.i(32827);
                                            cVar2.zcz.setVisibility(4);
                                            cVar2.zcy.setVisibility(0);
                                            AppMethodBeat.o(32827);
                                        }

                                        public final void x(Bitmap bitmap) {
                                            AppMethodBeat.i(32828);
                                            if (!(bitmap == null || bitmap.isRecycled())) {
                                                cVar2.zcz.setImageBitmap(bitmap);
                                                cVar2.zcz.setVisibility(0);
                                                cVar2.zcy.setVisibility(4);
                                            }
                                            AppMethodBeat.o(32828);
                                        }

                                        public final void mr() {
                                        }

                                        public final String wP() {
                                            AppMethodBeat.i(32829);
                                            String str = "CHAT#" + com.tencent.mm.plugin.appbrand.r.n.bE(this);
                                            AppMethodBeat.o(32829);
                                            return str;
                                        }
                                    }, "file://".concat(String.valueOf(str2)), null, ((com.tencent.mm.modelappbrand.i) com.tencent.mm.kernel.g.K(com.tencent.mm.modelappbrand.i.class)).a(240, 120, com.tencent.mm.modelappbrand.i.a.DECODE_TYPE_ORIGIN));
                                    obj3 = null;
                                    ayVar2 = ayVar;
                                    break;
                                }
                                obj3 = 1;
                                ayVar2 = ayVar;
                                break;
                            default:
                                obj3 = 1;
                                ayVar2 = ayVar;
                                break;
                        }
                        if (obj3 != null) {
                            if (bVar.title == null || bVar.title.length() <= 0) {
                                cVar.zbN.setVisibility(8);
                            } else {
                                cVar.zbN.setVisibility(0);
                                cVar.zbN.setMaxLines(2);
                                cVar.zbN.setText(bVar.title);
                            }
                            cVar.gnB.setVisibility(8);
                            if (z) {
                                if (bVar.type == 33 || bVar.type == 36 || bVar.type == 44) {
                                    str3 = o.ahl().c(biVar.field_imgPath, false, true);
                                    cVar.zbI.setImageResource(R.raw.app_attach_file_icon_webpage);
                                    com.tencent.mm.modelappbrand.a.b.abR().a(cVar.zbI, "file://".concat(String.valueOf(str3)), null, null, ((com.tencent.mm.modelappbrand.i) com.tencent.mm.kernel.g.K(com.tencent.mm.modelappbrand.i.class)).cq(50, 50));
                                } else {
                                    b = o.ahl().b(biVar.field_imgPath, com.tencent.mm.bz.a.getDensity(aVar2.yTx.getContext()), false);
                                    if (b == null || b.isRecycled()) {
                                        b = o.ahl().a(biVar.field_imgPath, com.tencent.mm.bz.a.getDensity(aVar2.yTx.getContext()), false);
                                    }
                                    if (b == null || b.isRecycled()) {
                                        cVar.zbI.setImageResource(R.drawable.aay);
                                    } else {
                                        cVar.zbI.setImageBitmap(b);
                                    }
                                }
                            }
                        }
                        if (aVar2.dFx()) {
                            cVar.zbW.setVisibility(8);
                            ayVar = ayVar2;
                        } else if (g.h(dX)) {
                            cVar.zbW.setVisibility(0);
                            c.c(aVar2, cVar.zbW, ay.a(bVar, biVar));
                            obj2 = ayVar2;
                        } else {
                            cVar.zbW.setVisibility(8);
                            ayVar = ayVar2;
                        }
                    }
                    if (obj == null) {
                        cVar.zcc.setTag(obj2);
                        cVar.zcc.setOnClickListener(d(aVar2));
                    }
                    if (this.kuU) {
                        cVar.zcc.setOnLongClickListener(c(aVar2));
                        cVar.zcc.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
                    }
                    AppMethodBeat.o(32835);
                }
            }
            substring = str2;
            if (substring == null) {
            }
            ayVar = new ay(biVar, aVar2.dFx(), i, null, 0);
            obj = null;
            if (bVar != null) {
            }
            if (obj == null) {
            }
            if (this.kuU) {
            }
            AppMethodBeat.o(32835);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(32836);
            int i = ((ay) view.getTag()).position;
            int aiL = com.tencent.mm.pluginsdk.model.app.l.aiL(bf.b(this.yJI.dFx(), biVar.field_content, biVar.field_isSend));
            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(bf.b(this.yJI.dFx(), biVar.field_content, biVar.field_isSend));
            com.tencent.mm.pluginsdk.model.app.f bT = g.bT(me.appId, false);
            if (g.i(bT) && !com.tencent.mm.ui.chatting.j.aA(biVar)) {
                if (me.type == 6) {
                    com.tencent.mm.pluginsdk.model.app.b aiM = com.tencent.mm.pluginsdk.model.app.l.aiM(me.csD);
                    if ((aiM == null || !b.e(biVar, aiM.field_fileFullPath)) && !biVar.dtH()) {
                        contextMenu.add(i, 111, 0, this.yJI.yTx.getMMResources().getString(R.string.dr1));
                    }
                } else {
                    contextMenu.add(i, 111, 0, this.yJI.yTx.getMMResources().getString(R.string.dr1));
                }
            }
            if (me.fgo <= 0 || (me.fgo > 0 && aiL >= 100)) {
                boolean aex;
                switch (me.type) {
                    case 1:
                        aex = com.tencent.mm.aj.f.aex();
                        break;
                    case 2:
                        aex = com.tencent.mm.aj.f.aey();
                        break;
                    case 3:
                        aex = com.tencent.mm.aj.f.aeH();
                        break;
                    case 4:
                        aex = com.tencent.mm.aj.f.aez();
                        break;
                    case 5:
                        aex = com.tencent.mm.aj.f.aeD();
                        break;
                    case 6:
                        aex = com.tencent.mm.aj.f.aeF();
                        if (!bo.any(me.fgp)) {
                            contextMenu.add(i, 150, 0, this.yJI.yTx.getMMResources().getString(R.string.amd));
                            break;
                        }
                        break;
                    case 8:
                        aex = com.tencent.mm.aj.f.aeB();
                        break;
                    case 16:
                        if (me.fhD != 5 && me.fhD != 6 && me.fhD != 2) {
                            aex = false;
                            break;
                        }
                        if (me.fhD != 2 || bh.o(biVar)) {
                            contextMenu.clear();
                        }
                        contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
                        AppMethodBeat.o(32836);
                        return false;
                        break;
                    case 34:
                        contextMenu.clear();
                        contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
                        AppMethodBeat.o(32836);
                        return false;
                    default:
                        aex = false;
                        break;
                }
                if (aex && !this.yJI.dFy()) {
                    contextMenu.add(i, 114, 0, view.getContext().getString(R.string.am3));
                }
            }
            if (com.tencent.mm.bp.d.afj("favorite") && (bT == null || !bT.xy())) {
                switch (me.type) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 10:
                    case 13:
                    case 19:
                    case 20:
                    case 24:
                        contextMenu.add(i, 116, 0, view.getContext().getString(R.string.dcq));
                        break;
                }
            }
            dq dqVar = new dq();
            dqVar.cxc.cvx = biVar.field_msgId;
            com.tencent.mm.sdk.b.a.xxA.m(dqVar);
            if (dqVar.cxd.cwB || b.a(this.yJI.yTx.getContext(), me)) {
                contextMenu.add(i, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 0, view.getContext().getString(R.string.amc));
            }
            if (bh.o(biVar)) {
                contextMenu.clear();
            }
            if (!this.yJI.dFy()) {
                contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
            }
            AppMethodBeat.o(32836);
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32837);
            switch (menuItem.getItemId()) {
                case 100:
                    AppMethodBeat.o(32837);
                    break;
                case 111:
                    b.a(aVar, biVar, b(aVar, biVar));
                    AppMethodBeat.o(32837);
                    break;
                case 114:
                    String str = biVar.field_content;
                    if (str != null) {
                        com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(str);
                        if (me != null) {
                            switch (me.type) {
                                case 1:
                                    am.m(bf.b(aVar.dFx(), biVar.field_content, biVar.field_isSend), aVar.yTx.getContext());
                                    break;
                                case 2:
                                    am.a(biVar, aVar.yTx.getContext(), b(aVar, biVar), aVar.dFx());
                                    break;
                                case 3:
                                    am.a(biVar, bf.b(aVar.dFx(), biVar.field_content, biVar.field_isSend), aVar.yTx.getContext());
                                    break;
                                case 4:
                                    am.c(biVar, aVar.yTx.getContext());
                                    break;
                                case 5:
                                    am.c(biVar, bf.b(aVar.dFx(), biVar.field_content, biVar.field_isSend), aVar.yTx.getContext());
                                    break;
                                case 6:
                                    am.b(biVar, bf.b(aVar.dFx(), biVar.field_content, biVar.field_isSend), aVar.yTx.getContext());
                                    break;
                                case 8:
                                    am.d(biVar, aVar.yTx.getContext());
                                    break;
                            }
                        }
                        AppMethodBeat.o(32837);
                        break;
                    }
                    AppMethodBeat.o(32837);
                    break;
                default:
                    AppMethodBeat.o(32837);
                    break;
            }
            return false;
        }

        /* JADX WARNING: Missing block: B:15:0x006b, code skipped:
            if (r2 == null) goto L_0x09fe;
     */
        /* JADX WARNING: Missing block: B:17:0x006f, code skipped:
            if (r3.url == null) goto L_0x09fe;
     */
        /* JADX WARNING: Missing block: B:19:0x007a, code skipped:
            if (r3.url.equals("") != false) goto L_0x09fe;
     */
        /* JADX WARNING: Missing block: B:21:0x0082, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(r3.canvasPageXml) != false) goto L_0x06eb;
     */
        /* JADX WARNING: Missing block: B:22:0x0084, code skipped:
            r2 = new android.content.Intent();
            r2.putExtra("sns_landig_pages_from_source", 5);
            r2.putExtra("msg_id", r18.field_msgId);
            r2.putExtra("sns_landing_pages_xml", r3.canvasPageXml);
            r2.putExtra("sns_landing_pages_share_thumb_url", r18.field_imgPath);
            r2.addFlags(268435456);
            com.tencent.mm.bp.d.b(r17.yTx.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", r2);
            com.tencent.matrix.trace.core.AppMethodBeat.o(32838);
     */
        /* JADX WARNING: Missing block: B:25:0x00f3, code skipped:
            if (com.tencent.mm.r.a.bJ(r17.yTx.getContext()) != false) goto L_0x0103;
     */
        /* JADX WARNING: Missing block: B:27:0x0101, code skipped:
            if (com.tencent.mm.r.a.bH(r17.yTx.getContext()) == false) goto L_0x0115;
     */
        /* JADX WARNING: Missing block: B:28:0x0103, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingItemAppMsgFrom", "Voip is running, can't do this");
            com.tencent.matrix.trace.core.AppMethodBeat.o(32838);
     */
        /* JADX WARNING: Missing block: B:30:0x011d, code skipped:
            if (a(r17, r3, r18) == false) goto L_0x0128;
     */
        /* JADX WARNING: Missing block: B:31:0x011f, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(32838);
     */
        /* JADX WARNING: Missing block: B:32:0x0128, code skipped:
            r4 = com.tencent.mm.pluginsdk.model.app.p.B(r3.url, com.facebook.share.internal.ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            r5 = com.tencent.mm.pluginsdk.model.app.p.B(r3.fgn, com.facebook.share.internal.ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            r2 = com.tencent.mm.ui.chatting.viewitems.c.getPackageInfo(r17.yTx.getContext(), r3.appId);
     */
        /* JADX WARNING: Missing block: B:33:0x0148, code skipped:
            if (r2 != null) goto L_0x016a;
     */
        /* JADX WARNING: Missing block: B:34:0x014a, code skipped:
            r6 = null;
     */
        /* JADX WARNING: Missing block: B:35:0x014b, code skipped:
            if (r2 != null) goto L_0x016d;
     */
        /* JADX WARNING: Missing block: B:36:0x014d, code skipped:
            r7 = 0;
     */
        /* JADX WARNING: Missing block: B:37:0x014e, code skipped:
            a(r17, r4, r5, r6, r7, r3.appId, true, r18.field_msgId, r18.field_msgSvrId, r18);
            com.tencent.matrix.trace.core.AppMethodBeat.o(32838);
     */
        /* JADX WARNING: Missing block: B:38:0x016a, code skipped:
            r6 = r2.versionName;
     */
        /* JADX WARNING: Missing block: B:39:0x016d, code skipped:
            r7 = r2.versionCode;
     */
        /* JADX WARNING: Missing block: B:144:0x06eb, code skipped:
            r2 = (com.tencent.mm.plugin.websearch.api.ab) r3.X(com.tencent.mm.plugin.websearch.api.ab.class);
     */
        /* JADX WARNING: Missing block: B:145:0x06f3, code skipped:
            if (r2 == null) goto L_0x077c;
     */
        /* JADX WARNING: Missing block: B:147:0x06fb, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(r2.uaa) != false) goto L_0x077c;
     */
        /* JADX WARNING: Missing block: B:148:0x06fd, code skipped:
            r3 = new com.tencent.mm.protocal.protobuf.cvi();
            r3.uaa = r2.uaa;
            r3.uab = r2.uab;
            r3.uac = r2.uac;
            r3.uad = r2.uad;
            r3.uae = r2.uae;
            r3.uai = r2.uai;
            r3.lvz = r2.lvz;
            r3.lvA = r2.lvA;
            r3.qVw = r2.qVw;
            r3.uaf = r2.uaf;
            r3.uag = r2.uag;
            r3.uah = r2.uah;
            r3.source = r2.source;
            r3.phw = r2.phw;
            r3.uaj = r2.uaj;
            r3.ual = r2.ual;
            r3.uam = r2.uam;
            r3.uan = r2.uan;
            r3.uak = r2.uak;
            r2 = com.tencent.mm.plugin.topstory.a.g.a(r3, 32, r17.yTx.getContext().getString(com.tencent.mm.R.string.c2a));
            com.tencent.mm.plugin.topstory.a.h.a(r3, r18);
            com.tencent.mm.plugin.websearch.api.aa.a(r17.yTx.getContext(), r2);
            com.tencent.matrix.trace.core.AppMethodBeat.o(32838);
     */
        /* JADX WARNING: Missing block: B:149:0x077c, code skipped:
            r4 = r3.url;
     */
        /* JADX WARNING: Missing block: B:150:0x0782, code skipped:
            if (r17.dFx() == false) goto L_0x0989;
     */
        /* JADX WARNING: Missing block: B:151:0x0784, code skipped:
            r2 = "groupmessage";
     */
        /* JADX WARNING: Missing block: B:152:0x0787, code skipped:
            r4 = com.tencent.mm.pluginsdk.model.app.p.B(r4, r2);
            r2 = r3.url;
            r5 = com.tencent.mm.ui.chatting.viewitems.c.getPackageInfo(r17.yTx.getContext(), r3.appId);
            r8 = new android.content.Intent();
            r8.putExtra("rawUrl", r4);
            r8.putExtra("webpageTitle", r3.title);
     */
        /* JADX WARNING: Missing block: B:153:0x07b0, code skipped:
            if (r3.appId == null) goto L_0x07e6;
     */
        /* JADX WARNING: Missing block: B:155:0x07bb, code skipped:
            if ("wx751a1acca5688ba3".equals(r3.appId) != false) goto L_0x07d3;
     */
        /* JADX WARNING: Missing block: B:157:0x07c6, code skipped:
            if ("wxfbc915ff7c30e335".equals(r3.appId) != false) goto L_0x07d3;
     */
        /* JADX WARNING: Missing block: B:159:0x07d1, code skipped:
            if ("wx482a4001c37e2b74".equals(r3.appId) == false) goto L_0x07e6;
     */
        /* JADX WARNING: Missing block: B:160:0x07d3, code skipped:
            r6 = new android.os.Bundle();
            r6.putString("jsapi_args_appid", r3.appId);
            r8.putExtra("jsapiargs", r6);
     */
        /* JADX WARNING: Missing block: B:162:0x07ea, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(r2) != false) goto L_0x098e;
     */
        /* JADX WARNING: Missing block: B:163:0x07ec, code skipped:
            r8.putExtra("shortUrl", r2);
     */
        /* JADX WARNING: Missing block: B:164:0x07f2, code skipped:
            r6 = "version_name";
     */
        /* JADX WARNING: Missing block: B:165:0x07f5, code skipped:
            if (r5 != null) goto L_0x0998;
     */
        /* JADX WARNING: Missing block: B:166:0x07f7, code skipped:
            r2 = null;
     */
        /* JADX WARNING: Missing block: B:167:0x07f8, code skipped:
            r8.putExtra(r6, r2);
            r6 = "version_code";
     */
        /* JADX WARNING: Missing block: B:168:0x07fe, code skipped:
            if (r5 != null) goto L_0x099c;
     */
        /* JADX WARNING: Missing block: B:169:0x0800, code skipped:
            r2 = 0;
     */
        /* JADX WARNING: Missing block: B:170:0x0801, code skipped:
            r8.putExtra(r6, r2);
     */
        /* JADX WARNING: Missing block: B:171:0x080a, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(r3.cMg) != false) goto L_0x081c;
     */
        /* JADX WARNING: Missing block: B:172:0x080c, code skipped:
            r8.putExtra("srcUsername", r3.cMg);
            r8.putExtra("srcDisplayname", r3.cMh);
     */
        /* JADX WARNING: Missing block: B:173:0x081c, code skipped:
            r8.putExtra("msg_id", r18.field_msgId);
            r8.putExtra("KPublisherId", "msg_" + java.lang.Long.toString(r18.field_msgSvrId));
            r8.putExtra("KAppId", r3.appId);
            r8.putExtra("geta8key_username", r17.getTalkerUserName());
            r8.putExtra("pre_username", b(r17, r18));
            r8.putExtra("from_scence", 2);
            r8.putExtra("expid_str", r18.dJE);
            r2 = com.tencent.mm.model.u.ad(b(r17, r18), r17.getTalkerUserName());
            r8.putExtra("prePublishId", "msg_" + java.lang.Long.toString(r18.field_msgSvrId));
            r8.putExtra("preUsername", b(r17, r18));
            r8.putExtra("preChatName", r17.getTalkerUserName());
            r8.putExtra("preChatTYPE", r2);
            r8.putExtra("preMsgIndex", 0);
     */
        /* JADX WARNING: Missing block: B:174:0x08c8, code skipped:
            switch(r2) {
                case 1: goto L_0x09a3;
                case 2: goto L_0x09a0;
                case 3: goto L_0x08cb;
                case 4: goto L_0x08cb;
                case 5: goto L_0x08cb;
                case 6: goto L_0x09a6;
                case 7: goto L_0x09a6;
                default: goto L_0x08cb;
            };
     */
        /* JADX WARNING: Missing block: B:175:0x08cb, code skipped:
            r2 = 0;
     */
        /* JADX WARNING: Missing block: B:176:0x08cc, code skipped:
            r8.putExtra("share_report_pre_msg_url", r3.url);
            r8.putExtra("share_report_pre_msg_title", r3.title);
            r8.putExtra("share_report_pre_msg_desc", r3.description);
            r8.putExtra("share_report_pre_msg_icon_url", r3.thumburl);
            r8.putExtra("share_report_pre_msg_appid", r3.appId);
            r8.putExtra("share_report_from_scene", r2);
     */
        /* JADX WARNING: Missing block: B:177:0x08fb, code skipped:
            if (r2 != 5) goto L_0x0907;
     */
        /* JADX WARNING: Missing block: B:178:0x08fd, code skipped:
            r8.putExtra("share_report_biz_username", r17.getTalkerUserName());
     */
        /* JADX WARNING: Missing block: B:179:0x0907, code skipped:
            r2 = (com.tencent.mm.af.e) r3.X(com.tencent.mm.af.e.class);
     */
        /* JADX WARNING: Missing block: B:180:0x090f, code skipped:
            if (r2 == null) goto L_0x09a9;
     */
        /* JADX WARNING: Missing block: B:181:0x0911, code skipped:
            r5 = r2.ffZ;
     */
        /* JADX WARNING: Missing block: B:182:0x0913, code skipped:
            r8.putExtra(com.tencent.mm.ui.e.m.ygo, r5);
            r8.addFlags(536870912);
            r7 = r17.yTx.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", com.tencent.tmassistantsdk.downloadservice.Downloads.MIN_WAIT_FOR_NETWORK);
     */
        /* JADX WARNING: Missing block: B:183:0x0932, code skipped:
            if (r2 == null) goto L_0x09ac;
     */
        /* JADX WARNING: Missing block: B:185:0x0935, code skipped:
            if (r5 != 5) goto L_0x09ac;
     */
        /* JADX WARNING: Missing block: B:187:0x093a, code skipped:
            if (r2.fgb != 1) goto L_0x09ac;
     */
        /* JADX WARNING: Missing block: B:189:0x0948, code skipped:
            if (((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.b.class)).aVP() == false) goto L_0x09ac;
     */
        /* JADX WARNING: Missing block: B:190:0x094a, code skipped:
            r10 = new android.os.Bundle();
            r10.putInt("biz_video_scene", 1);
            r10.putInt("biz_video_subscene", r7);
            r10.putInt("geta8key_scene", 1);
            com.tencent.mm.plugin.brandservice.ui.timeline.video.a.c.a(r17.yTx.getContext(), r18.field_msgId, r18.field_msgSvrId, 0, r16.findViewById(com.tencent.mm.R.id.anb), r10);
            com.tencent.matrix.trace.core.AppMethodBeat.o(32838);
     */
        /* JADX WARNING: Missing block: B:191:0x0989, code skipped:
            r2 = "singlemessage";
     */
        /* JADX WARNING: Missing block: B:192:0x098e, code skipped:
            r8.putExtra("shortUrl", r3.url);
     */
        /* JADX WARNING: Missing block: B:193:0x0998, code skipped:
            r2 = r5.versionName;
     */
        /* JADX WARNING: Missing block: B:194:0x099c, code skipped:
            r2 = r5.versionCode;
     */
        /* JADX WARNING: Missing block: B:195:0x09a0, code skipped:
            r2 = 2;
     */
        /* JADX WARNING: Missing block: B:196:0x09a3, code skipped:
            r2 = 3;
     */
        /* JADX WARNING: Missing block: B:197:0x09a6, code skipped:
            r2 = 5;
     */
        /* JADX WARNING: Missing block: B:198:0x09a9, code skipped:
            r5 = -1;
     */
        /* JADX WARNING: Missing block: B:200:0x09b9, code skipped:
            if (((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.b.class)).rW(3) == false) goto L_0x09e4;
     */
        /* JADX WARNING: Missing block: B:202:0x09d0, code skipped:
            if (((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.b.class)).a(r17.yTx.getContext(), r4, r5, 1, r7, r8) == false) goto L_0x09e4;
     */
        /* JADX WARNING: Missing block: B:203:0x09d2, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingItemAppMsgFrom", "jump to TmplWebview");
            com.tencent.matrix.trace.core.AppMethodBeat.o(32838);
     */
        /* JADX WARNING: Missing block: B:204:0x09e4, code skipped:
            com.tencent.mm.bp.d.b(r17.yTx.getContext(), "webview", ".ui.tools.WebViewUI", r8);
            com.tencent.matrix.trace.core.AppMethodBeat.o(32838);
     */
        /* JADX WARNING: Missing block: B:205:0x09fe, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(32838);
     */
        /* JADX WARNING: Missing block: B:208:?, code skipped:
            return true;
     */
        /* JADX WARNING: Missing block: B:209:?, code skipped:
            return true;
     */
        /* JADX WARNING: Missing block: B:210:?, code skipped:
            return true;
     */
        /* JADX WARNING: Missing block: B:211:?, code skipped:
            return true;
     */
        /* JADX WARNING: Missing block: B:231:?, code skipped:
            return true;
     */
        /* JADX WARNING: Missing block: B:232:?, code skipped:
            return true;
     */
        /* JADX WARNING: Missing block: B:233:?, code skipped:
            return true;
     */
        /* JADX WARNING: Missing block: B:234:?, code skipped:
            return true;
     */
        /* JADX WARNING: Missing block: B:235:?, code skipped:
            return false;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32838);
            com.tencent.mm.modelstat.a.a(biVar, com.tencent.mm.modelstat.a.a.Click);
            String str = biVar.field_content;
            Boolean bool = Boolean.FALSE;
            if (str != null) {
                com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(bf.b(aVar.dFx(), biVar.field_content, biVar.field_isSend));
                com.tencent.mm.af.n mj = com.tencent.mm.af.n.mj(str);
                if (me != null) {
                    if (mj.fju != 0) {
                        bool = Boolean.TRUE;
                        me.type = mj.fju;
                    }
                    Boolean bool2 = bool;
                    com.tencent.mm.pluginsdk.model.app.f bT = g.bT(me.appId, false);
                    str = c.d(aVar, biVar);
                    if (bT != null) {
                        c.a(aVar, me, str, bT, biVar.field_msgSvrId, aVar.getTalkerUserName());
                    }
                    Intent intent;
                    Object obj;
                    String talkerUserName;
                    Bundle bundle;
                    int i;
                    Bundle bundle2;
                    switch (me.type) {
                        case 3:
                            com.tencent.mm.plugin.report.service.h.pYm.e(13043, Integer.valueOf(2), me.description, me.appId);
                            break;
                        case 4:
                            break;
                        case 6:
                            if (this.kuU) {
                                intent = new Intent();
                                intent.setClassName(aVar.yTx.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                                intent.putExtra("app_msg_id", biVar.field_msgId);
                                aVar.startActivity(intent);
                                AppMethodBeat.o(32838);
                                return true;
                            }
                            t.hO(aVar.yTx.getContext());
                            AppMethodBeat.o(32838);
                            return true;
                        case 7:
                            if (bT != null && bT.xy() && c.a(aVar, bT)) {
                                AppMethodBeat.o(32838);
                                return true;
                            }
                            if (me.csD == null || me.csD.length() == 0) {
                                final com.tencent.mm.pluginsdk.model.app.f fVar = bT;
                                final com.tencent.mm.ui.chatting.d.a aVar2 = aVar;
                                final com.tencent.mm.af.j.b bVar = me;
                                final String str2 = str;
                                final bi biVar2 = biVar;
                                ((com.tencent.mm.ui.chatting.c.b.b) aVar.aF(com.tencent.mm.ui.chatting.c.b.b.class)).a(biVar, new aj() {
                                    public final void dR(boolean z) {
                                        AppMethodBeat.i(32833);
                                        if (fVar != null) {
                                            if (z) {
                                                c.a(aVar2, bVar, str2, fVar, biVar2.field_msgSvrId, 3, aVar2.getTalkerUserName());
                                                AppMethodBeat.o(32833);
                                                return;
                                            }
                                            c.a(aVar2, bVar, str2, fVar, biVar2.field_msgSvrId, 7, aVar2.getTalkerUserName());
                                        }
                                        AppMethodBeat.o(32833);
                                    }
                                });
                            } else if (this.kuU) {
                                intent = new Intent();
                                intent.setClassName(aVar.yTx.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                                intent.putExtra("app_msg_id", biVar.field_msgId);
                                aVar.yTx.startActivityForResult(intent, 210);
                            } else {
                                t.hO(aVar.yTx.getContext());
                                AppMethodBeat.o(32838);
                                return true;
                            }
                            AppMethodBeat.o(32838);
                            return true;
                        case 10:
                            if (bo.isNullOrNil(me.fgQ)) {
                                AppMethodBeat.o(32838);
                                return false;
                            }
                            intent = new Intent();
                            intent.setFlags(65536);
                            intent.putExtra("key_Product_xml", me.fgQ);
                            intent.putExtra("key_ProductUI_getProductInfoScene", 1);
                            if (biVar.field_imgPath == null) {
                                intent.putExtra("key_ProductUI_chatting_msgId", biVar.field_msgId);
                            }
                            com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "scanner", ".ui.ProductUI", intent);
                            AppMethodBeat.o(32838);
                            return true;
                        case 13:
                            if (bo.isNullOrNil(me.fgW)) {
                                AppMethodBeat.o(32838);
                                return false;
                            }
                            intent = new Intent();
                            intent.setFlags(65536);
                            intent.putExtra("key_product_info", me.fgW);
                            intent.putExtra("key_product_scene", 1);
                            com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "product", ".ui.MallProductUI", intent);
                            AppMethodBeat.o(32838);
                            return true;
                        case 16:
                            if (bo.isNullOrNil(me.cDt)) {
                                AppMethodBeat.o(32838);
                                return false;
                            }
                            intent = new Intent();
                            intent.setFlags(65536);
                            intent.putExtra("key_card_app_msg", me.cDt);
                            intent.putExtra("key_from_scene", me.fhD);
                            com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "card", ".ui.CardDetailUI", intent);
                            AppMethodBeat.o(32838);
                            return true;
                        case 19:
                            intent = new Intent();
                            intent.putExtra("message_id", biVar.field_msgId);
                            intent.putExtra("record_xml", me.fgU);
                            intent.putExtra("big_appmsg", bool2);
                            int ad = u.ad(b(aVar, biVar), aVar.getTalkerUserName());
                            intent.putExtra("prePublishId", "msg_" + Long.toString(biVar.field_msgSvrId));
                            intent.putExtra("preUsername", b(aVar, biVar));
                            intent.putExtra("preChatName", aVar.getTalkerUserName());
                            intent.putExtra("preChatTYPE", ad);
                            a.a(intent, aVar, biVar, this);
                            com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "record", ".ui.RecordMsgDetailUI", intent);
                            AppMethodBeat.o(32838);
                            return true;
                        case 20:
                            if (bo.isNullOrNil(me.fgT)) {
                                AppMethodBeat.o(32838);
                                return false;
                            }
                            intent = new Intent();
                            intent.setFlags(65536);
                            intent.putExtra("key_TV_xml", me.fgT);
                            intent.putExtra("key_TV_getProductInfoScene", 1);
                            if (biVar.field_imgPath == null) {
                                intent.putExtra("key_TVInfoUI_chatting_msgId", biVar.field_msgId);
                            }
                            com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "shake", ".ui.TVInfoUI", intent);
                            AppMethodBeat.o(32838);
                            return true;
                        case 24:
                            lz lzVar = new lz();
                            lzVar.cHO.context = aVar.yTx.getContext();
                            lzVar.cHO.cvx = biVar.field_msgId;
                            lzVar.cHO.cHc = aVar.dFx();
                            lzVar.cHO.cHP = me.fgU;
                            lzVar.cHO.scene = 6;
                            com.tencent.mm.sdk.b.a.xxA.m(lzVar);
                            AppMethodBeat.o(32838);
                            return true;
                        case 33:
                        case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                            ab.i("MicroMsg.ChattingItemAppMsgFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", me.fiP, me.fiO, me.fiQ, me.url, Integer.valueOf(me.fiZ), me.fiS);
                            if (44 == me.type && (!me.cw(false) || bo.isNullOrNil(me.p(aVar.yTx.getContext(), false)))) {
                                obj = 1;
                                break;
                            }
                            talkerUserName = aVar.getTalkerUserName();
                            String b = b(aVar, biVar);
                            bundle = new Bundle();
                            if (aVar.yTx instanceof AppBrandServiceChattingFmUI) {
                                str = "stat_scene";
                                i = 10;
                                bundle2 = bundle;
                            } else if (aVar.dFx()) {
                                str = "stat_scene";
                                i = 2;
                                bundle2 = bundle;
                            } else {
                                str = "stat_scene";
                                if (com.tencent.mm.model.t.mZ(talkerUserName)) {
                                    i = 7;
                                    bundle2 = bundle;
                                } else {
                                    i = 1;
                                    bundle2 = bundle;
                                }
                            }
                            bundle2.putInt(str, i);
                            bundle.putString("stat_msg_id", "msg_" + Long.toString(biVar.field_msgSvrId));
                            bundle.putString("stat_chat_talker_username", talkerUserName);
                            bundle.putString("stat_send_msg_user", b);
                            switch (me.fiR) {
                                case 0:
                                case 2:
                                    if (!(aVar.yTx instanceof AppBrandServiceChattingFmUI)) {
                                        if (!com.tencent.mm.model.t.mZ(talkerUserName)) {
                                            com.tencent.mm.modelappbrand.a.a(talkerUserName, b, aVar.dFx(), me, bundle);
                                            obj = null;
                                            break;
                                        }
                                        com.tencent.mm.modelappbrand.a.a(talkerUserName, FilterEnum4Shaka.MIC_WEISHI_CHAZHI, me, bundle);
                                        obj = null;
                                        break;
                                    }
                                    com.tencent.mm.modelappbrand.a.a(talkerUserName, FilterEnum4Shaka.MIC_WEISHI_MENGHUANG, me, bundle);
                                    obj = null;
                                    break;
                                case 1:
                                    intent = new Intent();
                                    intent.putExtra("key_username", me.fiP);
                                    if (aVar.dFx()) {
                                        intent.putExtra("key_from_scene", 1);
                                        intent.putExtra("key_scene_note", talkerUserName + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + b);
                                    } else {
                                        intent.putExtra("key_from_scene", 2);
                                        intent.putExtra("key_scene_note", talkerUserName);
                                    }
                                    com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a aVar3 = new com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a();
                                    aVar3.appId = me.fiQ;
                                    aVar3.from = 6;
                                    aVar3.gVt = me.fiZ;
                                    aVar3.gVu = me.fiT;
                                    intent.putExtra("key_scene_exposed_params", aVar3.ayP());
                                    intent.putExtra("_stat_obj", bundle);
                                    com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "appbrand", ".ui.AppBrandProfileUI", intent);
                                    obj = null;
                                    break;
                                case 3:
                                    com.tencent.mm.modelappbrand.a.b(talkerUserName, b, aVar.dFx(), me, bundle);
                                    obj = null;
                                    break;
                                default:
                                    obj = 1;
                                    break;
                            }
                            if (obj == null) {
                                AppMethodBeat.o(32838);
                                return true;
                            }
                            break;
                        case 34:
                            intent = new Intent();
                            intent.putExtra("key_from_user_name", b(aVar, biVar));
                            intent.putExtra("key_biz_uin", me.fhF);
                            intent.putExtra("key_order_id", me.fhG);
                            if (!(biVar.field_talker == null || biVar.field_talker.equals("") || !com.tencent.mm.model.t.kH(biVar.field_talker))) {
                                intent.putExtra("key_chatroom_name", biVar.field_talker);
                            }
                            com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "card", ".ui.CardGiftAcceptUI", intent);
                            AppMethodBeat.o(32838);
                            return true;
                        case 36:
                            if (bo.isNullOrNil(me.fiQ) && bo.isNullOrNil(me.fiP)) {
                                String B = p.B(me.url, aVar.dFx() ? "groupmessage" : "singlemessage");
                                Intent intent2 = new Intent();
                                intent2.putExtra("rawUrl", B);
                                intent2.putExtra("webpageTitle", me.title);
                                intent2.putExtra("shortUrl", me.url);
                                com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                                AppMethodBeat.o(32838);
                                return true;
                            }
                            String talkerUserName2 = aVar.getTalkerUserName();
                            talkerUserName = b(aVar, biVar);
                            bundle = new Bundle();
                            if (aVar.dFx()) {
                                str = "stat_scene";
                                i = 2;
                                bundle2 = bundle;
                            } else {
                                str = "stat_scene";
                                if (com.tencent.mm.model.t.mZ(talkerUserName2)) {
                                    i = 7;
                                    bundle2 = bundle;
                                } else {
                                    i = 1;
                                    bundle2 = bundle;
                                }
                            }
                            bundle2.putInt(str, i);
                            bundle.putString("stat_msg_id", "msg_" + Long.toString(biVar.field_msgSvrId));
                            bundle.putString("stat_chat_talker_username", talkerUserName2);
                            bundle.putString("stat_send_msg_user", talkerUserName);
                            ((com.tencent.mm.plugin.appbrand.service.e) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.e.class)).a(aVar.yTx.getContext(), aVar.getTalkerUserName(), b(aVar, biVar), aVar.dFx(), me);
                            AppMethodBeat.o(32838);
                            return true;
                        default:
                            obj = 1;
                            break;
                    }
                }
                AppMethodBeat.o(32838);
                return false;
            }
            AppMethodBeat.o(32838);
            return false;
        }
    }

    protected static void a(TextView textView, com.tencent.mm.af.j.b bVar) {
        AppMethodBeat.i(32859);
        switch (bVar.fiZ) {
            case 1:
                textView.setText(R.string.o1);
                break;
            case 2:
                textView.setText(R.string.o0);
                break;
            default:
                textView.setText(R.string.i9);
                break;
        }
        textView.setVisibility(0);
        AppMethodBeat.o(32859);
    }

    static boolean h(com.tencent.mm.af.j.b bVar) {
        AppMethodBeat.i(32860);
        com.tencent.mm.plugin.websearch.api.ab abVar = (com.tencent.mm.plugin.websearch.api.ab) bVar.X(com.tencent.mm.plugin.websearch.api.ab.class);
        if (abVar == null || bo.isNullOrNil(abVar.uaa)) {
            AppMethodBeat.o(32860);
            return false;
        }
        AppMethodBeat.o(32860);
        return true;
    }
}
