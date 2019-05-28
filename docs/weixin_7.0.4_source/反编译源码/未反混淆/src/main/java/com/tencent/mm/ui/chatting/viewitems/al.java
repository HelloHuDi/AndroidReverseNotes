package com.tencent.mm.ui.chatting.viewitems;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pluginsdk.ui.e.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.c.b.z;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.HashMap;

public final class al {

    static class d implements com.tencent.mm.ui.widget.textview.a.e {
        private com.tencent.mm.ui.widget.textview.a yMs;

        d(com.tencent.mm.ui.widget.textview.a aVar) {
            this.yMs = aVar;
        }

        public final void dHp() {
            AppMethodBeat.i(33319);
            ab.d("OnTouchOutside", "touchOutside");
            this.yMs.dLM();
            this.yMs.zWD = true;
            this.yMs.dLP();
            this.yMs.zWC = true;
            this.yMs.dLQ();
            com.tencent.mm.ui.widget.textview.a aVar = this.yMs;
            if (aVar.zWn != null) {
                aVar.zWn.dismiss();
            }
            AppMethodBeat.o(33319);
        }
    }

    static final class f extends com.tencent.mm.ui.chatting.viewitems.c.a {
        View gbS;
        com.tencent.mm.ui.widget.b.a yMt;
        com.tencent.mm.ui.widget.textview.a.f zbi;
        ImageView zci;
        MMNeat7extView zgQ;
        ImageView zgR;
        TextView zgS;
        ViewStub zgT;
        ChattingItemTranslate zgU;
        com.tencent.mm.ui.widget.textview.a zgV;
        com.tencent.mm.pluginsdk.ui.e.f zgW;
        com.tencent.mm.ui.widget.textview.a.e zgX;

        f() {
        }

        public final com.tencent.mm.ui.chatting.viewitems.c.a z(View view, boolean z) {
            AppMethodBeat.i(33321);
            super.eP(view);
            this.enf = (TextView) view.findViewById(R.id.ag);
            this.qkY = (TextView) view.findViewById(R.id.od);
            this.zgQ = (MMNeat7extView) view.findViewById(R.id.oe);
            this.zgQ.setMaxWidth((int) (((float) com.tencent.mm.bz.a.am(this.zgQ.getContext(), R.dimen.x7)) / com.tencent.mm.ca.a.dmK()));
            this.moo = (CheckBox) view.findViewById(R.id.a_);
            this.iVh = view.findViewById(R.id.af);
            this.gbS = view.findViewById(R.id.aa);
            this.zgT = (ViewStub) view.findViewById(R.id.ap4);
            if (z) {
                this.zgR = (ImageView) view.findViewById(R.id.ap2);
                this.zgS = (TextView) view.findViewById(R.id.ap3);
            } else {
                this.zci = (ImageView) view.findViewById(R.id.at7);
                this.zby = (ImageView) view.findViewById(R.id.asb);
                this.pyf = (ProgressBar) view.findViewById(R.id.at6);
            }
            this.zgW = new com.tencent.mm.pluginsdk.ui.e.f(this.zgQ, new m(this.zgQ.getContext()));
            this.zgQ.setIsOpen(dHq());
            this.zgQ.setTextCrashListener(new c());
            AppMethodBeat.o(33321);
            return this;
        }

        private static boolean dHq() {
            AppMethodBeat.i(33322);
            try {
                ab.i("NeatTextView", "[isOpenNeatTextView] value:%s isNeatTextViewOpen:%s local:%s", g.Nu().getValue("CellTextViewEnable"), Integer.valueOf(bo.getInt(g.Nu().getValue("CellTextViewEnable"), 1)), Boolean.valueOf(com.tencent.mm.kernel.g.RP().Ry().getBoolean(com.tencent.mm.storage.ac.a.USERINFO_CELLTEXTVIEW_CONFIG_BOOLEAN_SYNC, true)));
                if (1 == bo.getInt(g.Nu().getValue("CellTextViewEnable"), 1) && r4) {
                    AppMethodBeat.o(33322);
                    return true;
                }
                AppMethodBeat.o(33322);
                return false;
            } catch (Exception e) {
                AppMethodBeat.o(33322);
                return false;
            }
        }
    }

    static class e extends com.tencent.mm.ui.chatting.s.e {
        public e(com.tencent.mm.ui.chatting.d.a aVar) {
            super(aVar);
        }

        public final void a(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33320);
            ay ayVar = (ay) view.getTag();
            if (biVar.dtr()) {
                if (this.yJI != null) {
                    h.pYm.X(10221, "1");
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    com.tencent.mm.bp.d.b(this.yJI.yTx.getContext(), "shake", ".ui.ShakeReportUI", intent);
                }
                AppMethodBeat.o(33320);
                return;
            }
            if (biVar.isText() && (view instanceof MMTextView)) {
                MMTextView mMTextView = (MMTextView) view;
                com.tencent.mm.ui.chatting.k.a.a.dHa();
                com.tencent.mm.ui.chatting.k.a.a.a(mMTextView.getText(), ayVar.cKd);
            }
            AppMethodBeat.o(33320);
        }
    }

    public static class b extends c implements n, com.tencent.neattextview.textview.view.NeatTextView.b {
        private static final int zgH = R.id.cr;
        private static final int zgI = R.id.ae;
        private static final int zgJ = R.id.ad;
        private com.tencent.mm.ui.chatting.d.a yJI;
        private CharSequence yMu;
        private e zgK;

        private e dHo() {
            AppMethodBeat.i(33309);
            if (this.zgK == null) {
                this.zgK = new e(this.yJI);
            }
            e eVar = this.zgK;
            AppMethodBeat.o(33309);
            return eVar;
        }

        public final boolean dHk() {
            return true;
        }

        public boolean aH(int i, boolean z) {
            if (z && (i == 1 || i == 11 || i == 21 || i == 31 || i == 36 || i == 301989937)) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33310);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.n0);
                view.setTag(new f().z(view, false));
            }
            AppMethodBeat.o(33310);
            return view;
        }

        public void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            Object obj;
            com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b bl;
            AppMethodBeat.i(33311);
            this.yJI = aVar2;
            aVar = (f) aVar;
            aVar.zgQ.setTag(zgI, Long.valueOf(biVar.field_msgId));
            aVar.zgQ.setTag(zgJ, Boolean.TRUE);
            aVar.zgQ.setMaxLines(BaseClientBuilder.API_PRIORITY_OTHER);
            if (c.dHm()) {
                if (aVar.pyf != null) {
                    aVar.pyf.setVisibility(8);
                }
                if (biVar.field_status == 1 || biVar.field_status == 5) {
                    if (aVar.zci != null) {
                        aVar.zci.setVisibility(8);
                    }
                    aVar.zgQ.setBackgroundResource(R.drawable.j5);
                    biVar.xZd = true;
                } else {
                    aVar.zgQ.setBackgroundResource(R.drawable.j4);
                    if (aVar.zci != null) {
                        if (c.a((com.tencent.mm.ui.chatting.c.b.h) aVar2.aF(com.tencent.mm.ui.chatting.c.b.h.class), biVar.field_msgId)) {
                            if (biVar.xZd) {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
                                alphaAnimation.setDuration(300);
                                aVar.zgQ.startAnimation(alphaAnimation);
                                biVar.xZd = false;
                            }
                            aVar.zci.setVisibility(0);
                        } else {
                            aVar.zci.setVisibility(8);
                        }
                    }
                }
            } else if (aVar.pyf != null) {
                aVar.pyf.setVisibility(biVar.field_status >= 2 ? 8 : 0);
            }
            String str2 = biVar.field_content;
            if (bo.isNullOrNil(str2)) {
                ab.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", Long.valueOf(biVar.field_msgId), Long.valueOf(biVar.field_msgSvrId));
            }
            if (biVar.dqJ == null || !biVar.dtV()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                CharSequence a = j.a(aVar.zgQ.getContext(), str2, (int) aVar.zgQ.getTextSize(), 1, null, bK(biVar));
                z zVar = (z) aVar2.aF(z.class);
                if (zVar.ng(biVar.field_msgId)) {
                    aVar.zgQ.a(com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(a, zVar.dEM(), com.tencent.mm.plugin.fts.a.a.d.a.Background, com.tencent.mm.plugin.fts.ui.b.b.mHt)).mDR, BufferType.SPANNABLE);
                } else {
                    aVar.zgQ.a(a, BufferType.SPANNABLE);
                }
                for (com.tencent.mm.pluginsdk.ui.e.n type : (com.tencent.mm.pluginsdk.ui.e.n[]) a.getSpans(0, a.length(), com.tencent.mm.pluginsdk.ui.e.n.class)) {
                    if (type.getType() == 44) {
                        h.pYm.e(12809, Integer.valueOf(6), "");
                        break;
                    }
                }
            } else {
                Object obj2;
                if (biVar.dqJ.contains("notify@all")) {
                    obj2 = "";
                } else {
                    String obj22 = aVar.zgQ.getContext().getString(R.string.dtl, new Object[]{"@"}) + IOUtils.LINE_SEPARATOR_UNIX;
                }
                aVar.zgQ.a(j.a(aVar.zgQ.getContext(), obj22 + str2, (int) aVar.zgQ.getTextSize(), 1, Integer.valueOf(31), bK(biVar)), BufferType.SPANNABLE);
            }
            com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.a aVar3 = new com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.a(biVar, aVar2.dFx(), i);
            aVar3.zix = false;
            final Context context = aVar.zgQ.getContext();
            aVar.zgQ.setTag(zgH, Boolean.TRUE);
            if (aVar.yMt == null) {
                aVar.yMt = new com.tencent.mm.ui.widget.b.a(context, aVar.zgQ);
                aVar.yMt.zSa = true;
                aVar.yMt.zRZ = new OnCreateContextMenuListener() {
                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.i(33304);
                        contextMenu.clear();
                        contextMenu.add(0, 0, 0, context.getResources().getString(R.string.oy));
                        contextMenu.add(0, 1, 0, context.getResources().getString(R.string.czl));
                        contextMenu.add(0, 2, 0, context.getResources().getString(R.string.czk));
                        contextMenu.add(0, 3, 0, context.getResources().getString(R.string.bnl));
                        AppMethodBeat.o(33304);
                    }
                };
                aVar.yMt.rBm = new com.tencent.mm.ui.base.n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(33305);
                        switch (menuItem.getItemId()) {
                            case 0:
                                ((ClipboardManager) ah.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(b.this.yMu, b.this.yMu));
                                if (aVar.zgV != null) {
                                    aVar.zgV.dLM();
                                    aVar.zgV.zWC = true;
                                    aVar.zgV.zWD = true;
                                    aVar.zgV.dLL();
                                }
                                Toast.makeText(context, R.string.oz, 0).show();
                                AppMethodBeat.o(33305);
                                return;
                            case 1:
                                if (aVar.zgV != null) {
                                    aVar.zgV.zWC = true;
                                    aVar.zgV.dLL();
                                    aVar.zgV.hH(0, aVar.zgQ.dPr().length());
                                    aVar.zgV.dLO();
                                    aVar.zgV.dLR();
                                    AppMethodBeat.o(33305);
                                    return;
                                }
                                break;
                            case 2:
                                Intent intent = new Intent(context, MsgRetransmitUI.class);
                                intent.putExtra("Retr_Msg_content", b.this.yMu);
                                intent.putExtra("Retr_Msg_Type", 4);
                                context.startActivity(intent);
                                AppMethodBeat.o(33305);
                                return;
                            case 3:
                                cl clVar = new cl();
                                com.tencent.mm.pluginsdk.model.e.b(clVar, b.this.yMu.toString(), 1);
                                clVar.cvA.fragment = b.this.yJI.yTx;
                                clVar.cvA.cvH = 43;
                                if (clVar.cvA.cvC != null) {
                                    abl abl = clVar.cvA.cvC.wit;
                                    if (abl != null) {
                                        ay ayVar = (ay) aVar.zgQ.getTag();
                                        if (ayVar != null) {
                                            abl.alD(r.Yz());
                                            abl.alE(ayVar.cKd.field_talker);
                                            com.tencent.mm.sdk.b.a.xxA.m(clVar);
                                        }
                                    }
                                }
                                if (aVar.zgV != null) {
                                    aVar.zgV.dLM();
                                    aVar.zgV.zWC = true;
                                    aVar.zgV.zWD = true;
                                    aVar.zgV.dLL();
                                    break;
                                }
                                break;
                        }
                        AppMethodBeat.o(33305);
                    }
                };
            }
            if (aVar.zgV == null) {
                com.tencent.mm.ui.chatting.viewitems.c.c c = c(aVar2);
                com.tencent.mm.ui.widget.textview.a.a aVar4 = new com.tencent.mm.ui.widget.textview.a.a(aVar.zgQ, aVar.yMt, a(c(aVar2)), dHo(), aVar.zgW);
                aVar4.zWt = R.color.z1;
                aVar4.zWN = 18;
                aVar4.zWu = R.color.l7;
                aVar.zgV = aVar4.dLT();
                aVar.zgX = new d(aVar.zgV);
                aVar.zgV.zWl = new v() {
                    public final void af(CharSequence charSequence) {
                        AppMethodBeat.i(33306);
                        b.this.yMu = charSequence;
                        AppMethodBeat.o(33306);
                    }
                };
                aVar.zbi = new com.tencent.mm.ui.widget.textview.a.f() {
                    public final void dismiss() {
                        AppMethodBeat.i(33307);
                        aVar.zgV.dLM();
                        aVar.zgV.zWC = true;
                        aVar.zgV.zWD = true;
                        aVar.zgV.dLL();
                        AppMethodBeat.o(33307);
                    }
                };
                c.zbi = aVar.zbi;
            } else {
                aVar.zgV.init();
            }
            aVar.zgV.zWJ = aVar.zgX;
            aVar.zgQ.setTag(aVar3);
            aVar.zgQ.setOnDoubleClickListener(this);
            aVar.zgQ.setTextListener(new com.tencent.mm.ui.widget.MMNeat7extView.a() {
                public final void ag(CharSequence charSequence) {
                    AppMethodBeat.i(33308);
                    if (((Boolean) aVar.zgQ.getTag(b.zgJ)).booleanValue()) {
                        com.tencent.mm.ui.chatting.k.a.a.dHa();
                        com.tencent.mm.ui.chatting.k.a.a.dHb().a(charSequence, ((Long) aVar.zgQ.getTag(b.zgI)).longValue());
                    }
                    AppMethodBeat.o(33308);
                }
            });
            com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b bVar = com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b.NoTransform;
            if (com.tencent.mm.app.plugin.c.Cj()) {
                if (biVar.dtF() && biVar.dtM()) {
                    str2 = biVar.field_transContent;
                } else {
                    str2 = null;
                }
                bl = ((com.tencent.mm.ui.chatting.c.b.ah) aVar2.aF(com.tencent.mm.ui.chatting.c.b.ah.class)).bl(biVar);
            } else {
                str2 = null;
                bl = bVar;
            }
            if (!bo.isNullOrNil(str2) || bl != com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b.NoTransform) {
                String string;
                if (aVar.zgU == null) {
                    aVar.zgU = (ChattingItemTranslate) aVar.zgT.inflate();
                    aVar.zgU.init();
                }
                aVar.zgU.a(j.a(aVar.zgQ.getContext(), str2, (int) aVar.zgQ.getTextSize(), 1, null, bK(biVar)), bl);
                ChattingItemTranslate chattingItemTranslate = aVar.zgU;
                if (bo.isNullOrNil(biVar.field_transBrandWording)) {
                    string = aVar2.yTx.getMMResources().getString(R.string.evt);
                } else {
                    string = biVar.field_transBrandWording;
                }
                chattingItemTranslate.setBrandWording(string);
                if (!bo.isNullOrNil(str2)) {
                    com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.a aVar5 = new com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.a(biVar, aVar2.dFx(), i);
                    aVar5.klY = 2;
                    aVar.zgU.setTag(aVar5);
                    aVar.zgU.setOnClickListener(dHo());
                    aVar.zgU.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h) aVar2.aF(com.tencent.mm.ui.chatting.c.b.h.class)).dCZ());
                    aVar.zgU.setOnDoubleClickListener(this);
                    aVar.zgU.setOnLongClickListener(c(aVar2));
                    aVar.zgU.setVisibility(0);
                }
            } else if (aVar.zgU != null) {
                aVar.zgU.setVisibility(8);
            }
            a(i, aVar, biVar, aVar2.dFu(), aVar2.dFx(), aVar2, (n) this);
            AppMethodBeat.o(33311);
        }

        private void aU(bi biVar) {
            AppMethodBeat.i(33312);
            if (!this.yJI.getTalkerUserName().equals("medianote")) {
                aw.ZK();
                com.tencent.mm.model.c.XL().c(new com.tencent.mm.az.e(biVar.field_talker, biVar.field_msgSvrId));
            }
            ak.aU(biVar);
            this.yJI.qp(true);
            AppMethodBeat.o(33312);
        }

        private String bK(bi biVar) {
            AppMethodBeat.i(33313);
            if (biVar != null) {
                String nW = com.tencent.mm.model.v.nW(biVar.field_msgSvrId);
                com.tencent.mm.model.v.b y = com.tencent.mm.model.v.Zp().y(nW, true);
                y.j("prePublishId", "msg_" + biVar.field_msgSvrId);
                y.j("preUsername", b(this.yJI, biVar));
                y.j("preChatName", c.c(this.yJI, biVar));
                AppMethodBeat.o(33313);
                return nW;
            }
            AppMethodBeat.o(33313);
            return null;
        }

        /* JADX WARNING: Missing block: B:2:0x0011, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(33315);
     */
        /* JADX WARNING: Missing block: B:17:0x00b3, code skipped:
            r0 = (android.content.ClipboardManager) com.tencent.mm.sdk.platformtools.ah.getContext().getSystemService("clipboard");
            r3 = r11.field_content;
            r4 = "MicroMsg.ChattingItemTextTo";
            r5 = new java.lang.StringBuilder("groupId = ").append(r9.getGroupId()).append(", content length: ");
     */
        /* JADX WARNING: Missing block: B:18:0x00dc, code skipped:
            if (r3 != null) goto L_0x0137;
     */
        /* JADX WARNING: Missing block: B:19:0x00de, code skipped:
            com.tencent.mm.sdk.platformtools.ab.d(r4, r5.append(r1).toString());
            r1 = ((com.tencent.mm.ui.chatting.c.b.ah) r10.aF(com.tencent.mm.ui.chatting.c.b.ah.class)).bm(r11);
     */
        /* JADX WARNING: Missing block: B:21:?, code skipped:
            r0.setText(r1);
     */
        /* JADX WARNING: Missing block: B:24:0x0137, code skipped:
            r1 = r3.length();
     */
        /* JADX WARNING: Missing block: B:26:0x013d, code skipped:
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ChattingItemTextTo", "clip.setText error ");
     */
        /* JADX WARNING: Missing block: B:34:?, code skipped:
            return false;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            String str;
            int i = 0;
            AppMethodBeat.i(33315);
            switch (menuItem.getItemId()) {
                case 102:
                    break;
                case 103:
                    aU(biVar);
                    break;
                case 108:
                    Intent intent = new Intent(aVar.yTx.getContext(), MsgRetransmitUI.class);
                    String bm = ((com.tencent.mm.ui.chatting.c.b.ah) aVar.aF(com.tencent.mm.ui.chatting.c.b.ah.class)).bm(biVar);
                    if (biVar.dtr()) {
                        intent.putExtra("Retr_Msg_content", bm);
                        intent.putExtra("Retr_Msg_Type", 6);
                    } else {
                        intent.putExtra("Retr_Msg_content", bm);
                        intent.putExtra("Retr_Msg_Type", 4);
                    }
                    aVar.startActivity(intent);
                    break;
                case 124:
                    ((com.tencent.mm.ui.chatting.c.b.ah) aVar.aF(com.tencent.mm.ui.chatting.c.b.ah.class)).b(menuItem, biVar);
                    break;
                case 141:
                    android.text.ClipboardManager clipboardManager = (android.text.ClipboardManager) ah.getContext().getSystemService("clipboard");
                    str = biVar.field_transContent;
                    if (!bo.isNullOrNil(str)) {
                        clipboardManager.setText(str);
                    }
                    com.tencent.mm.ui.base.h.bQ(aVar.yTx.getContext(), aVar.yTx.getContext().getString(R.string.oz));
                    AppMethodBeat.o(33315);
                    return true;
                case ErrorCode.NEEDDOWNLOAD_3 /*142*/:
                    Intent intent2 = new Intent(aVar.yTx.getContext(), MsgRetransmitUI.class);
                    str = biVar.field_transContent;
                    if (biVar.dtr()) {
                        intent2.putExtra("Retr_Msg_content", str);
                        intent2.putExtra("Retr_Msg_Type", 6);
                    } else {
                        intent2.putExtra("Retr_Msg_content", str);
                        intent2.putExtra("Retr_Msg_Type", 4);
                    }
                    aVar.startActivity(intent2);
                    AppMethodBeat.o(33315);
                    return true;
                case ErrorCode.NEEDDOWNLOAD_4 /*143*/:
                    cl clVar = new cl();
                    com.tencent.mm.pluginsdk.model.e.b(clVar, biVar.field_transContent, 1);
                    clVar.cvA.fragment = aVar.yTx;
                    clVar.cvA.cvH = 43;
                    if (clVar.cvA.cvC == null) {
                        ab.e("MicroMsg.ChattingItemTextTo", "alvinluo transform text fav failed");
                        break;
                    }
                    abl abl = clVar.cvA.cvC.wit;
                    if (abl != null) {
                        abl.alD(biVar.field_talker);
                        abl.alE(r.Yz());
                        com.tencent.mm.sdk.b.a.xxA.m(clVar);
                        break;
                    }
                    break;
            }
            com.tencent.mm.ui.base.h.bQ(aVar.yTx.getContext(), aVar.yTx.getContext().getString(R.string.oz));
            com.tencent.mm.plugin.secinforeport.a.a aVar2 = com.tencent.mm.plugin.secinforeport.a.a.qjm;
            com.tencent.mm.plugin.secinforeport.a.a.h(1, biVar.field_msgSvrId, bo.ana(str));
            AppMethodBeat.o(33315);
            return true;
        }

        public final void a(com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33316);
            biVar.dtJ();
            aw.ZK();
            com.tencent.mm.model.c.XO().a(biVar.field_msgId, biVar);
            if (biVar.isText() && biVar.field_isSend == 1) {
                aU(biVar);
            }
            AppMethodBeat.o(33316);
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }

        public final boolean fi(View view) {
            AppMethodBeat.i(33317);
            CharSequence dPr = ((MMNeat7extView) view).dPr();
            Intent intent = new Intent(view.getContext(), TextPreviewUI.class);
            intent.addFlags(67108864);
            intent.putExtra("key_chat_text", dPr);
            if (view.getTag() instanceof ay) {
                ay ayVar = (ay) view.getTag();
                if (ayVar != null) {
                    intent.putExtra("Chat_Msg_Id", ayVar.cKd.field_msgId);
                }
            }
            view.getContext().startActivity(intent);
            com.tencent.mm.ui.base.b.hL(view.getContext());
            AppMethodBeat.o(33317);
            return true;
        }

        public boolean a(ContextMenu contextMenu, View view, bi biVar) {
            boolean z;
            AppMethodBeat.i(33314);
            if (biVar.dqJ == null || !biVar.dqJ.contains("announcement@all")) {
                z = false;
            } else {
                z = true;
            }
            if (biVar.isText() || biVar.dtr()) {
                com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.a aVar = (com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.a) view.getTag();
                int i = aVar.position;
                if (aVar.klY == 1) {
                    if (biVar.isText()) {
                        contextMenu.add(i, 102, 0, view.getContext().getString(R.string.am4));
                    }
                    contextMenu.add(i, 108, 0, view.getContext().getString(R.string.dr1));
                    if (biVar.field_status == 5) {
                        contextMenu.add(i, 103, 0, view.getContext().getString(R.string.anv));
                    }
                    if (com.tencent.mm.bp.d.afj("favorite")) {
                        contextMenu.add(i, 116, 0, view.getContext().getString(R.string.dcq));
                    }
                    if (com.tencent.mm.pluginsdk.model.app.g.ad(this.yJI.yTx.getContext(), biVar.getType())) {
                        contextMenu.add(i, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 0, view.getContext().getString(R.string.amc));
                    }
                    if (!z && !biVar.drC() && biVar.isText() && ((biVar.field_status == 2 || biVar.dJz == 1) && c.a(biVar, this.yJI) && c.arB(biVar.field_talker) && !ad.mg(this.yJI.getTalkerUserName()))) {
                        contextMenu.add(i, 123, 0, view.getContext().getString(R.string.ami));
                    }
                    if (com.tencent.mm.app.plugin.c.Cj()) {
                        if (biVar.dtF() && biVar.dtM()) {
                            contextMenu.add(i, 124, 0, view.getContext().getString(R.string.amn));
                        } else {
                            contextMenu.add(i, 124, 0, view.getContext().getString(R.string.amp));
                        }
                    }
                    if (biVar.isText() && com.tencent.mm.aj.f.aex()) {
                        this.yJI.dFy();
                    }
                    if (!this.yJI.dFy()) {
                        contextMenu.add(i, 100, 0, view.getContext().getString(R.string.am7));
                    }
                } else if (aVar.klY == 2) {
                    contextMenu.add(i, 141, 0, view.getContext().getString(R.string.am4));
                    contextMenu.add(i, ErrorCode.NEEDDOWNLOAD_3, 0, view.getContext().getString(R.string.dr1));
                    if (com.tencent.mm.bp.d.afj("favorite")) {
                        contextMenu.add(i, ErrorCode.NEEDDOWNLOAD_4, 0, view.getContext().getString(R.string.dcq));
                    }
                    if (com.tencent.mm.app.plugin.c.Ck() && biVar.dtP()) {
                        contextMenu.add(i, 125, 0, view.getContext().getString(R.string.amh));
                    }
                    AppMethodBeat.o(33314);
                    return false;
                }
                AppMethodBeat.o(33314);
                return true;
            }
            AppMethodBeat.o(33314);
            return true;
        }
    }

    static final class c implements com.tencent.mm.ui.widget.MMNeat7extView.b {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        public final void a(Exception exception, String str, String str2) {
            AppMethodBeat.i(33318);
            if (!com.tencent.mm.protocal.d.vxp) {
                HashMap hashMap = new HashMap(2);
                hashMap.put("Content", str);
                hashMap.put("Exception", exception.toString());
                hashMap.put("Stack", exception.getStackTrace());
                h.pYm.g("NeatTextView", str2, hashMap);
            }
            AppMethodBeat.o(33318);
        }
    }

    public static class a extends c implements com.tencent.neattextview.textview.view.NeatTextView.b {
        private static final int zgH = R.id.cr;
        private static final int zgI = R.id.ae;
        private static final int zgJ = R.id.ad;
        private com.tencent.mm.ui.chatting.d.a yJI;
        private CharSequence yMu;
        private e zgK;

        private e dHo() {
            AppMethodBeat.i(33295);
            if (this.zgK == null) {
                this.zgK = new e(this.yJI);
            }
            e eVar = this.zgK;
            AppMethodBeat.o(33295);
            return eVar;
        }

        public final boolean dHk() {
            return false;
        }

        public boolean aH(int i, boolean z) {
            if (z || (i != 1 && i != 11 && i != 21 && i != 31 && i != 36 && i != 301989937)) {
                return false;
            }
            return true;
        }

        public View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33296);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.m0);
                view.setTag(new f().z(view, true));
            }
            AppMethodBeat.o(33296);
            return view;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean b(com.tencent.mm.ui.chatting.d.a aVar) {
            AppMethodBeat.i(33297);
            boolean dFx = aVar.dFx();
            AppMethodBeat.o(33297);
            return dFx;
        }

        /* JADX WARNING: Removed duplicated region for block: B:73:0x0301  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00a7  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0140  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x0374  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x0166  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x021e  */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x025c  */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x0398  */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x0292  */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x02a8  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b bl;
            String str2;
            String trim;
            String str3;
            Object obj;
            com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.a aVar3;
            final Context context;
            int t;
            ChattingItemTranslate chattingItemTranslate;
            AppMethodBeat.i(33298);
            this.yJI = aVar2;
            final f fVar = (f) aVar;
            String str4 = biVar.field_content;
            String talkerUserName = aVar2.getTalkerUserName();
            fVar.zgQ.setTag(zgI, Long.valueOf(biVar.field_msgId));
            fVar.zgQ.setTag(zgJ, Boolean.TRUE);
            com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b bVar = com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b.NoTransform;
            if (com.tencent.mm.app.plugin.c.Cj()) {
                String str5;
                if (biVar.dtF() && biVar.dtM()) {
                    str5 = biVar.field_transContent;
                } else {
                    str5 = null;
                }
                bl = ((com.tencent.mm.ui.chatting.c.b.ah) aVar2.aF(com.tencent.mm.ui.chatting.c.b.ah.class)).bl(biVar);
                str2 = str5;
            } else {
                bl = bVar;
                str2 = null;
            }
            if (aVar2.dFx() && !((com.tencent.mm.ui.chatting.c.b.d) aVar2.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDm()) {
                int ox = bf.ox(str4);
                if (ox != -1) {
                    trim = str4.substring(0, ox).trim();
                    if (trim == null || trim.length() <= 0) {
                        trim = talkerUserName;
                    }
                    CharSequence trim2 = str4.substring(ox + 1).trim();
                    if (bo.isNullOrNil(str2)) {
                        str3 = str2;
                        talkerUserName = trim;
                    } else {
                        str3 = str2.substring(ox + 1).trim();
                        talkerUserName = trim;
                    }
                    a((com.tencent.mm.ui.chatting.viewitems.c.a) fVar, aVar2, biVar, talkerUserName);
                    a((com.tencent.mm.ui.chatting.viewitems.c.a) fVar, aVar2, talkerUserName, biVar);
                    if (biVar.dqJ == null && biVar.dtV()) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        trim2 = j.a(fVar.zgQ.getContext(), trim2, (int) fVar.zgQ.getTextSize(), 1, null, bK(biVar));
                        z zVar = (z) aVar2.aF(z.class);
                        if (zVar.ng(biVar.field_msgId)) {
                            fVar.zgQ.a(com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(trim2, zVar.dEM(), com.tencent.mm.plugin.fts.a.a.d.a.Background, com.tencent.mm.plugin.fts.ui.b.b.mHs)).mDR, BufferType.SPANNABLE);
                        } else {
                            fVar.zgQ.a(trim2, BufferType.SPANNABLE);
                        }
                        for (com.tencent.mm.pluginsdk.ui.e.n type : (com.tencent.mm.pluginsdk.ui.e.n[]) trim2.getSpans(0, trim2.length(), com.tencent.mm.pluginsdk.ui.e.n.class)) {
                            if (type.getType() == 44) {
                                h.pYm.e(12809, Integer.valueOf(7), "");
                                break;
                            }
                        }
                    } else if (obj != null) {
                        Object obj2;
                        if (biVar.dqJ.contains("notify@all")) {
                            obj2 = "";
                        } else {
                            str2 = fVar.zgQ.getContext().getString(R.string.dtl, new Object[]{"@"}) + IOUtils.LINE_SEPARATOR_UNIX;
                        }
                        fVar.zgQ.a(j.a(fVar.zgQ.getContext(), obj2 + trim2, (int) fVar.zgQ.getTextSize(), 1, Integer.valueOf(31), bK(biVar)), BufferType.SPANNABLE);
                    }
                    aVar3 = new com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.a(biVar, aVar2.dFx(), i);
                    fVar.zgS.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(33285);
                            Intent intent = new Intent(view.getContext(), TextPreviewUI.class);
                            intent.addFlags(67108864);
                            ay ayVar = (ay) fVar.zgQ.getTag();
                            if (ayVar != null) {
                                CharSequence dPr = fVar.zgQ.dPr();
                                intent.putExtra("Chat_Msg_Id", ayVar.cKd.field_msgId);
                                intent.putExtra("key_chat_text", dPr);
                                view.getContext().startActivity(intent);
                                com.tencent.mm.ui.base.b.hL(view.getContext());
                            }
                            AppMethodBeat.o(33285);
                        }
                    });
                    context = fVar.zgQ.getContext();
                    fVar.zgQ.setTag(zgH, Boolean.TRUE);
                    if (fVar.yMt == null) {
                        fVar.yMt = new com.tencent.mm.ui.widget.b.a(context, fVar.zgQ);
                        fVar.yMt.zSa = true;
                        fVar.yMt.zRZ = new OnCreateContextMenuListener() {
                            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                                int t;
                                AppMethodBeat.i(33286);
                                contextMenu.clear();
                                contextMenu.add(0, 0, 0, context.getResources().getString(R.string.oy));
                                CharSequence dPr = fVar.zgQ.dPr();
                                ay ayVar = (ay) fVar.zgQ.getTag();
                                if (ayVar != null) {
                                    t = bh.t(ayVar.cKd);
                                } else {
                                    t = 0;
                                }
                                if (t <= 0 || t >= dPr.length()) {
                                    contextMenu.add(0, 1, 0, context.getResources().getString(R.string.czl));
                                }
                                contextMenu.add(0, 2, 0, context.getResources().getString(R.string.czk));
                                contextMenu.add(0, 3, 0, context.getResources().getString(R.string.bnl));
                                AppMethodBeat.o(33286);
                            }
                        };
                        fVar.yMt.rBm = new com.tencent.mm.ui.base.n.d() {
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                AppMethodBeat.i(33289);
                                ay ayVar;
                                switch (menuItem.getItemId()) {
                                    case 0:
                                        ((ClipboardManager) ah.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(a.this.yMu, a.this.yMu));
                                        if (fVar.zgV != null) {
                                            fVar.zgV.dLM();
                                            fVar.zgV.zWC = true;
                                            fVar.zgV.zWD = true;
                                            fVar.zgV.dLL();
                                        }
                                        Toast.makeText(context, R.string.oz, 0).show();
                                        AppMethodBeat.o(33289);
                                        return;
                                    case 1:
                                        if (fVar.zgV != null) {
                                            fVar.zgV.zWC = true;
                                            fVar.zgV.dLL();
                                            fVar.zgV.hH(0, fVar.zgQ.dPr().length());
                                            fVar.zgV.dLO();
                                            fVar.zgV.dLR();
                                            AppMethodBeat.o(33289);
                                            return;
                                        }
                                        break;
                                    case 2:
                                        ayVar = (ay) fVar.zgQ.getTag();
                                        if (ayVar != null) {
                                            final String s = bh.s(ayVar.cKd);
                                            if (bo.isNullOrNil(s)) {
                                                Intent intent = new Intent(context, MsgRetransmitUI.class);
                                                intent.putExtra("Retr_Msg_content", a.this.yMu);
                                                intent.putExtra("Retr_Msg_Type", 4);
                                                context.startActivity(intent);
                                                AppMethodBeat.o(33289);
                                                return;
                                            }
                                            com.tencent.mm.ui.base.h.a(context, (int) R.string.g8v, (int) R.string.g8w, (int) R.string.uf, (int) R.string.g6g, true, new DialogInterface.OnClickListener() {
                                                public final void onClick(DialogInterface dialogInterface, int i) {
                                                    AppMethodBeat.i(33287);
                                                    Intent intent = new Intent();
                                                    intent.putExtra("rawUrl", s);
                                                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                                                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                                                    com.tencent.mm.bp.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
                                                    AppMethodBeat.o(33287);
                                                }
                                            }, new DialogInterface.OnClickListener() {
                                                public final void onClick(DialogInterface dialogInterface, int i) {
                                                    AppMethodBeat.i(33288);
                                                    Intent intent = new Intent(context, MsgRetransmitUI.class);
                                                    intent.putExtra("Retr_Msg_content", a.this.yMu);
                                                    intent.putExtra("Retr_Msg_Type", 4);
                                                    context.startActivity(intent);
                                                    AppMethodBeat.o(33288);
                                                }
                                            });
                                            AppMethodBeat.o(33289);
                                            return;
                                        }
                                        break;
                                    case 3:
                                        cl clVar = new cl();
                                        com.tencent.mm.pluginsdk.model.e.b(clVar, a.this.yMu.toString(), 1);
                                        clVar.cvA.fragment = a.this.yJI.yTx;
                                        clVar.cvA.cvH = 43;
                                        if (clVar.cvA.cvC != null) {
                                            abl abl = clVar.cvA.cvC.wit;
                                            if (abl != null) {
                                                ayVar = (ay) fVar.zgQ.getTag();
                                                if (ayVar != null) {
                                                    abl.alD(ayVar.cKd.field_talker);
                                                    abl.alE(r.Yz());
                                                    com.tencent.mm.sdk.b.a.xxA.m(clVar);
                                                }
                                            }
                                        }
                                        if (fVar.zgV != null) {
                                            fVar.zgV.dLM();
                                            fVar.zgV.zWC = true;
                                            fVar.zgV.zWD = true;
                                            fVar.zgV.dLL();
                                            break;
                                        }
                                        break;
                                }
                                AppMethodBeat.o(33289);
                            }
                        };
                    }
                    if (bh.o(biVar)) {
                        int i2;
                        t = bh.t(biVar);
                        if (t <= 0 || t >= com.tencent.mm.ui.widget.textview.b.fs(fVar.zgQ).length()) {
                            i2 = 0;
                        } else {
                            i2 = t;
                        }
                        com.tencent.mm.ui.chatting.viewitems.c.c c = c(aVar2);
                        com.tencent.mm.ui.widget.textview.a.f a = a(c);
                        if (fVar.zgV != null) {
                            fVar.zgV.destroy();
                        }
                        com.tencent.mm.ui.widget.textview.a.a aVar4 = new com.tencent.mm.ui.widget.textview.a.a(fVar.zgQ, fVar.yMt, a, dHo(), fVar.zgW);
                        aVar4.zWt = R.color.z1;
                        aVar4.zWN = 18;
                        aVar4.zWu = R.color.l7;
                        fVar.zgV = aVar4.dLT();
                        fVar.zgX = new d(fVar.zgV);
                        fVar.zgV.zWl = new v() {
                            public final void af(CharSequence charSequence) {
                                AppMethodBeat.i(33290);
                                a.this.yMu = charSequence;
                                AppMethodBeat.o(33290);
                            }
                        };
                        fVar.zbi = new com.tencent.mm.ui.widget.textview.a.f() {
                            public final void dismiss() {
                                AppMethodBeat.i(33291);
                                fVar.zgV.dLM();
                                fVar.zgV.zWC = true;
                                fVar.zgV.zWD = true;
                                fVar.zgV.dLL();
                                AppMethodBeat.o(33291);
                            }
                        };
                        c.zbi = fVar.zbi;
                        fVar.zgV.zWy = i2;
                        fVar.zgV.zWJ = fVar.zgX;
                    } else {
                        fVar.zgQ.setTag(zgH, Boolean.FALSE);
                        fVar.zgQ.setOnTouchListener(fVar.zgW);
                        fVar.zgQ.setOnLongClickListener(c(aVar2));
                        fVar.zgQ.setOnClickListener(dHo());
                    }
                    fVar.zgQ.setOnDoubleClickListener(this);
                    fVar.zgQ.setTag(aVar3);
                    fVar.zgQ.setTag(zgI, Long.valueOf(biVar.field_msgId));
                    fVar.zgQ.setTextListener(new com.tencent.mm.ui.widget.MMNeat7extView.a() {
                        public final void ag(CharSequence charSequence) {
                            AppMethodBeat.i(33292);
                            if (((Boolean) fVar.zgQ.getTag(a.zgJ)).booleanValue()) {
                                com.tencent.mm.ui.chatting.k.a.a.dHa();
                                com.tencent.mm.ui.chatting.k.a.a.dHb().a(charSequence, ((Long) fVar.zgQ.getTag(a.zgI)).longValue());
                            }
                            AppMethodBeat.o(33292);
                        }
                    });
                    fVar.zgS.setVisibility(8);
                    fVar.zgR.setVisibility(8);
                    fVar.zgQ.setMaxLines(BaseClientBuilder.API_PRIORITY_OTHER);
                    t = g.Nu().getInt("InvalidateTextFoldLineNum", 5);
                    if (bh.q(biVar)) {
                        com.tencent.neattextview.textview.layout.a QV = fVar.zgQ.QV(fVar.zgQ.getContext().getResources().getDimensionPixelSize(R.dimen.x7));
                        if (QV != null && QV.dPe() > t) {
                            fVar.zgQ.setMaxLines(t);
                            fVar.zgS.setVisibility(0);
                            fVar.zgR.setVisibility(0);
                        }
                    }
                    if (bo.isNullOrNil(str3) || bl != com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b.NoTransform) {
                        if (fVar.zgU == null) {
                            fVar.zgU = (ChattingItemTranslate) fVar.zgT.inflate();
                            fVar.zgU.init();
                        }
                        fVar.zgU.a(j.a(fVar.zgQ.getContext(), str3, (int) fVar.zgQ.getTextSize(), 1, null, bK(biVar)), bl);
                        chattingItemTranslate = fVar.zgU;
                        if (bo.isNullOrNil(biVar.field_transBrandWording)) {
                            trim = biVar.field_transBrandWording;
                        } else {
                            trim = aVar2.yTx.getMMResources().getString(R.string.evt);
                        }
                        chattingItemTranslate.setBrandWording(trim);
                        if (!bo.isNullOrNil(str3)) {
                            com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.a aVar5 = new com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.a(biVar, aVar2.dFx(), i);
                            aVar5.zix = false;
                            aVar5.klY = 2;
                            fVar.zgU.setTag(aVar5);
                            fVar.zgU.setOnClickListener(dHo());
                            fVar.zgU.setOnDoubleClickListener(this);
                            fVar.zgU.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h) aVar2.aF(com.tencent.mm.ui.chatting.c.b.h.class)).dCZ());
                            fVar.zgU.setOnLongClickListener(c(aVar2));
                            fVar.zgU.setVisibility(0);
                        }
                        AppMethodBeat.o(33298);
                    }
                    if (fVar.zgU != null) {
                        fVar.zgU.setVisibility(8);
                    }
                    AppMethodBeat.o(33298);
                    return;
                }
            }
            str3 = str2;
            Object trim22 = str4;
            a((com.tencent.mm.ui.chatting.viewitems.c.a) fVar, aVar2, biVar, talkerUserName);
            a((com.tencent.mm.ui.chatting.viewitems.c.a) fVar, aVar2, talkerUserName, biVar);
            if (biVar.dqJ == null) {
            }
            obj = null;
            if (obj != null) {
            }
            aVar3 = new com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.a(biVar, aVar2.dFx(), i);
            fVar.zgS.setOnClickListener(/* anonymous class already generated */);
            context = fVar.zgQ.getContext();
            fVar.zgQ.setTag(zgH, Boolean.TRUE);
            if (fVar.yMt == null) {
            }
            if (bh.o(biVar)) {
            }
            fVar.zgQ.setOnDoubleClickListener(this);
            fVar.zgQ.setTag(aVar3);
            fVar.zgQ.setTag(zgI, Long.valueOf(biVar.field_msgId));
            fVar.zgQ.setTextListener(/* anonymous class already generated */);
            fVar.zgS.setVisibility(8);
            fVar.zgR.setVisibility(8);
            fVar.zgQ.setMaxLines(BaseClientBuilder.API_PRIORITY_OTHER);
            t = g.Nu().getInt("InvalidateTextFoldLineNum", 5);
            if (bh.q(biVar)) {
            }
            if (bo.isNullOrNil(str3)) {
            }
            if (fVar.zgU == null) {
            }
            fVar.zgU.a(j.a(fVar.zgQ.getContext(), str3, (int) fVar.zgQ.getTextSize(), 1, null, bK(biVar)), bl);
            chattingItemTranslate = fVar.zgU;
            if (bo.isNullOrNil(biVar.field_transBrandWording)) {
            }
            chattingItemTranslate.setBrandWording(trim);
            if (bo.isNullOrNil(str3)) {
            }
            AppMethodBeat.o(33298);
        }

        private String bK(bi biVar) {
            AppMethodBeat.i(33299);
            if (biVar != null) {
                String nW = com.tencent.mm.model.v.nW(biVar.field_msgSvrId);
                com.tencent.mm.model.v.b y = com.tencent.mm.model.v.Zp().y(nW, true);
                y.j("prePublishId", "msg_" + biVar.field_msgSvrId);
                y.j("preUsername", b(this.yJI, biVar));
                y.j("preChatName", c.c(this.yJI, biVar));
                AppMethodBeat.o(33299);
                return nW;
            }
            AppMethodBeat.o(33299);
            return null;
        }

        /* Access modifiers changed, original: protected */
        public boolean dHj() {
            return false;
        }

        public boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(33300);
            if (biVar.isText() || biVar.dtr()) {
                com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.a aVar = (com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.a) view.getTag();
                int i = aVar.position;
                if (aVar.klY == 1) {
                    if (biVar.isText()) {
                        contextMenu.add(i, 102, 0, view.getContext().getString(R.string.am4));
                    }
                    contextMenu.add(i, 108, 0, view.getContext().getString(R.string.dr1));
                    if (com.tencent.mm.bp.d.afj("favorite")) {
                        contextMenu.add(i, 116, 0, view.getContext().getString(R.string.dcq));
                    }
                    if (com.tencent.mm.pluginsdk.model.app.g.ad(this.yJI.yTx.getContext(), biVar.getType())) {
                        contextMenu.add(i, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 0, view.getContext().getString(R.string.amc));
                    }
                    if (biVar.isText() && com.tencent.mm.aj.f.aex()) {
                        this.yJI.dFy();
                    }
                    if (!this.yJI.dFy()) {
                        contextMenu.add(i, 100, 0, view.getContext().getString(R.string.am7));
                    }
                    if (com.tencent.mm.app.plugin.c.Cj()) {
                        if (biVar.dtF() && biVar.dtM()) {
                            contextMenu.add(i, 124, 0, view.getContext().getString(R.string.amn));
                        } else {
                            contextMenu.add(i, 124, 0, view.getContext().getString(R.string.amp));
                        }
                    }
                    if (bh.o(biVar)) {
                        contextMenu.clear();
                        if (!this.yJI.dFy()) {
                            contextMenu.add(i, 100, 0, view.getContext().getString(R.string.am7));
                        }
                    }
                } else if (aVar.klY == 2) {
                    contextMenu.add(i, 141, 0, view.getContext().getString(R.string.am4));
                    contextMenu.add(i, ErrorCode.NEEDDOWNLOAD_3, 0, view.getContext().getString(R.string.dr1));
                    if (com.tencent.mm.bp.d.afj("favorite")) {
                        contextMenu.add(i, ErrorCode.NEEDDOWNLOAD_4, 0, view.getContext().getString(R.string.dcq));
                    }
                    if (com.tencent.mm.app.plugin.c.Ck() && biVar.dtP()) {
                        contextMenu.add(i, 125, 0, view.getContext().getString(R.string.amh));
                    }
                    AppMethodBeat.o(33300);
                    return false;
                }
                AppMethodBeat.o(33300);
                return true;
            }
            AppMethodBeat.o(33300);
            return true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x00bb  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00a6  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x019a  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0108  */
        /* JADX WARNING: Missing block: B:2:0x0011, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(33301);
     */
        /* JADX WARNING: Missing block: B:38:0x0121, code skipped:
            r0 = (android.content.ClipboardManager) com.tencent.mm.sdk.platformtools.ah.getContext().getSystemService("clipboard");
            r1 = r13.field_content;
            r2 = "MicroMsg.ChattingItemTextFrom";
            r3 = new java.lang.StringBuilder("groupId = ").append(r11.getGroupId()).append(", content length: ");
     */
        /* JADX WARNING: Missing block: B:39:0x014a, code skipped:
            if (r1 != null) goto L_0x01a5;
     */
        /* JADX WARNING: Missing block: B:40:0x014c, code skipped:
            r1 = 0;
     */
        /* JADX WARNING: Missing block: B:41:0x014d, code skipped:
            com.tencent.mm.sdk.platformtools.ab.d(r2, r3.append(r1).toString());
            r1 = ((com.tencent.mm.ui.chatting.c.b.ah) r12.aF(com.tencent.mm.ui.chatting.c.b.ah.class)).bm(r13);
     */
        /* JADX WARNING: Missing block: B:43:?, code skipped:
            r0.setText(r1);
     */
        /* JADX WARNING: Missing block: B:46:0x01a5, code skipped:
            r1 = r1.length();
     */
        /* JADX WARNING: Missing block: B:48:0x01ab, code skipped:
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ChattingItemTextFrom", "clip.setText error ");
     */
        /* JADX WARNING: Missing block: B:60:?, code skipped:
            return false;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(MenuItem menuItem, final com.tencent.mm.ui.chatting.d.a aVar, final bi biVar) {
            String str;
            AppMethodBeat.i(33301);
            String bm;
            int ox;
            switch (menuItem.getItemId()) {
                case 102:
                    break;
                case 108:
                    final String s = bh.s(biVar);
                    if (!bo.isNullOrNil(s)) {
                        com.tencent.mm.ui.base.h.a(aVar.yTx.getContext(), (int) R.string.g8v, (int) R.string.g8w, (int) R.string.uf, (int) R.string.g6g, true, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(33293);
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", s);
                                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                                com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                AppMethodBeat.o(33293);
                            }
                        }, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(33294);
                                Intent intent = new Intent(aVar.yTx.getContext(), MsgRetransmitUI.class);
                                String bm = ((com.tencent.mm.ui.chatting.c.b.ah) aVar.aF(com.tencent.mm.ui.chatting.c.b.ah.class)).bm(biVar);
                                if (biVar.dtr()) {
                                    intent.putExtra("Retr_Msg_content", bm);
                                    intent.putExtra("Retr_Msg_Type", 6);
                                } else {
                                    intent.putExtra("Retr_Msg_content", bm);
                                    intent.putExtra("Retr_Msg_Type", 4);
                                }
                                aVar.yTx.getContext().startActivity(intent);
                                AppMethodBeat.o(33294);
                            }
                        });
                        break;
                    }
                    Intent intent = new Intent(aVar.yTx.getContext(), MsgRetransmitUI.class);
                    bm = ((com.tencent.mm.ui.chatting.c.b.ah) aVar.aF(com.tencent.mm.ui.chatting.c.b.ah.class)).bm(biVar);
                    if (biVar.dtr()) {
                        intent.putExtra("Retr_Msg_content", bm);
                        intent.putExtra("Retr_Msg_Type", 6);
                    } else {
                        intent.putExtra("Retr_Msg_content", bm);
                        intent.putExtra("Retr_Msg_Type", 4);
                    }
                    aVar.startActivity(intent);
                    break;
                case 124:
                case 125:
                    ((com.tencent.mm.ui.chatting.c.b.ah) aVar.aF(com.tencent.mm.ui.chatting.c.b.ah.class)).b(menuItem, biVar);
                    break;
                case 141:
                    str = biVar.field_transContent;
                    if (aVar.dFx() && !((com.tencent.mm.ui.chatting.c.b.d) aVar.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDm()) {
                        ox = bf.ox(str);
                        if (ox != -1) {
                            str = str.substring(ox + 1).trim();
                        }
                    }
                    android.text.ClipboardManager clipboardManager = (android.text.ClipboardManager) ah.getContext().getSystemService("clipboard");
                    if (!bo.isNullOrNil(str)) {
                        clipboardManager.setText(str);
                    }
                    com.tencent.mm.ui.base.h.bQ(aVar.yTx.getContext(), aVar.yTx.getContext().getString(R.string.oz));
                    AppMethodBeat.o(33301);
                    return true;
                case ErrorCode.NEEDDOWNLOAD_3 /*142*/:
                    Intent intent2 = new Intent(aVar.yTx.getContext(), MsgRetransmitUI.class);
                    str = biVar.field_transContent;
                    if (aVar.dFx() && !((com.tencent.mm.ui.chatting.c.b.d) aVar.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDm()) {
                        ox = bf.ox(str);
                        if (ox != -1) {
                            bm = str.substring(ox + 1).trim();
                            if (biVar.dtr()) {
                                intent2.putExtra("Retr_Msg_content", bm);
                                intent2.putExtra("Retr_Msg_Type", 4);
                            } else {
                                intent2.putExtra("Retr_Msg_content", bm);
                                intent2.putExtra("Retr_Msg_Type", 6);
                            }
                            aVar.startActivity(intent2);
                            AppMethodBeat.o(33301);
                            return true;
                        }
                    }
                    bm = str;
                    if (biVar.dtr()) {
                    }
                    aVar.startActivity(intent2);
                    AppMethodBeat.o(33301);
                    return true;
                case ErrorCode.NEEDDOWNLOAD_4 /*143*/:
                    cl clVar = new cl();
                    str = biVar.field_transContent;
                    if (aVar.dFx() && !((com.tencent.mm.ui.chatting.c.b.d) aVar.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDm()) {
                        ox = bf.ox(str);
                        if (ox != -1) {
                            bm = str.substring(ox + 1).trim();
                            com.tencent.mm.pluginsdk.model.e.b(clVar, bm, 1);
                            clVar.cvA.fragment = aVar.yTx;
                            clVar.cvA.cvH = 43;
                            if (clVar.cvA.cvC != null) {
                                ab.e("MicroMsg.ChattingItemTextFrom", "alvinluo transform text fav failed");
                                break;
                            }
                            abl abl = clVar.cvA.cvC.wit;
                            if (abl != null) {
                                abl.alD(biVar.field_talker);
                                abl.alE(r.Yz());
                                com.tencent.mm.sdk.b.a.xxA.m(clVar);
                                break;
                            }
                        }
                    }
                    bm = str;
                    com.tencent.mm.pluginsdk.model.e.b(clVar, bm, 1);
                    clVar.cvA.fragment = aVar.yTx;
                    clVar.cvA.cvH = 43;
                    if (clVar.cvA.cvC != null) {
                    }
                    break;
            }
            com.tencent.mm.ui.base.h.bQ(aVar.yTx.getContext(), aVar.yTx.getContext().getString(R.string.oz));
            com.tencent.mm.plugin.secinforeport.a.a aVar2 = com.tencent.mm.plugin.secinforeport.a.a.qjm;
            com.tencent.mm.plugin.secinforeport.a.a.h(1, biVar.field_msgSvrId, bo.ana(str));
            AppMethodBeat.o(33301);
            return true;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33302);
            if (view instanceof MMTextView) {
                MMTextView mMTextView = (MMTextView) view;
                com.tencent.mm.ui.chatting.k.a.a.dHa();
                com.tencent.mm.ui.chatting.k.a.a.a(mMTextView.getText(), biVar);
            }
            AppMethodBeat.o(33302);
            return true;
        }

        public final boolean fi(View view) {
            AppMethodBeat.i(33303);
            Intent intent = new Intent(view.getContext(), TextPreviewUI.class);
            intent.addFlags(67108864);
            ay ayVar = (ay) view.getTag();
            if (ayVar != null) {
                CharSequence dPr = ((MMNeat7extView) view).dPr();
                intent.putExtra("Chat_Msg_Id", ayVar.cKd.field_msgId);
                intent.putExtra("key_chat_text", dPr);
                view.getContext().startActivity(intent);
                com.tencent.mm.ui.base.b.hL(view.getContext());
            }
            AppMethodBeat.o(33303);
            return true;
        }
    }
}
