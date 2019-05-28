package com.tencent.p177mm.p612ui.chatting.viewitems;

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
import com.tencent.neattextview.textview.layout.C5782a;
import com.tencent.neattextview.textview.view.NeatTextView.C5787b;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.app.plugin.C37469c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p201az.C32325e;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p210ca.C32432a;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C46636v;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.p612ui.chatting.C36121ak;
import com.tencent.p177mm.p612ui.chatting.C44318s.C23812e;
import com.tencent.p177mm.p612ui.chatting.C44318s.C5365n;
import com.tencent.p177mm.p612ui.chatting.TextPreviewUI;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C23733z;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44297ah;
import com.tencent.p177mm.p612ui.chatting.p620k.p621a.C5346a;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5382c;
import com.tencent.p177mm.p612ui.chatting.viewitems.ChattingItemTranslate.C5370a;
import com.tencent.p177mm.p612ui.chatting.viewitems.ChattingItemTranslate.C5371b;
import com.tencent.p177mm.p612ui.transmit.MsgRetransmitUI;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView.C5625a;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView.C5626b;
import com.tencent.p177mm.p612ui.widget.MMTextView;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.p612ui.widget.textview.C40917b;
import com.tencent.p177mm.p612ui.widget.textview.C46708a;
import com.tencent.p177mm.p612ui.widget.textview.C46708a.C16022e;
import com.tencent.p177mm.p612ui.widget.textview.C46708a.C40915a;
import com.tencent.p177mm.p612ui.widget.textview.C46708a.C5673f;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fts.p419a.C34204f;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d.C28108a;
import com.tencent.p177mm.plugin.fts.p424ui.C45976b.C28147b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.secinforeport.p1293a.C21734a;
import com.tencent.p177mm.pluginsdk.model.C40443e;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C23306f;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C23322n;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.protocal.protobuf.abl;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.HashMap;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.al */
public final class C30586al {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.al$d */
    static class C5373d implements C16022e {
        private C46708a yMs;

        C5373d(C46708a c46708a) {
            this.yMs = c46708a;
        }

        public final void dHp() {
            AppMethodBeat.m2504i(33319);
            C4990ab.m7410d("OnTouchOutside", "touchOutside");
            this.yMs.dLM();
            this.yMs.zWD = true;
            this.yMs.dLP();
            this.yMs.zWC = true;
            this.yMs.dLQ();
            C46708a c46708a = this.yMs;
            if (c46708a.zWn != null) {
                c46708a.zWn.dismiss();
            }
            AppMethodBeat.m2505o(33319);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.al$f */
    static final class C5374f extends C5379a {
        View gbS;
        C24088a yMt;
        C5673f zbi;
        ImageView zci;
        MMNeat7extView zgQ;
        ImageView zgR;
        TextView zgS;
        ViewStub zgT;
        ChattingItemTranslate zgU;
        C46708a zgV;
        C23306f zgW;
        C16022e zgX;

        C5374f() {
        }

        /* renamed from: z */
        public final C5379a mo11002z(View view, boolean z) {
            AppMethodBeat.m2504i(33321);
            super.mo11031eP(view);
            this.enf = (TextView) view.findViewById(2131820587);
            this.qkY = (TextView) view.findViewById(2131821102);
            this.zgQ = (MMNeat7extView) view.findViewById(2131821103);
            this.zgQ.setMaxWidth((int) (((float) C1338a.m2857am(this.zgQ.getContext(), C25738R.dimen.f10298x7)) / C32432a.dmK()));
            this.moo = (CheckBox) view.findViewById(2131820580);
            this.iVh = view.findViewById(2131820586);
            this.gbS = view.findViewById(2131820581);
            this.zgT = (ViewStub) view.findViewById(2131822510);
            if (z) {
                this.zgR = (ImageView) view.findViewById(2131822508);
                this.zgS = (TextView) view.findViewById(2131822509);
            } else {
                this.zci = (ImageView) view.findViewById(2131822661);
                this.zby = (ImageView) view.findViewById(2131822629);
                this.pyf = (ProgressBar) view.findViewById(2131822660);
            }
            this.zgW = new C23306f(this.zgQ, new C30132m(this.zgQ.getContext()));
            this.zgQ.setIsOpen(C5374f.dHq());
            this.zgQ.setTextCrashListener(new C30590c());
            AppMethodBeat.m2505o(33321);
            return this;
        }

        private static boolean dHq() {
            AppMethodBeat.m2504i(33322);
            try {
                C4990ab.m7417i("NeatTextView", "[isOpenNeatTextView] value:%s isNeatTextViewOpen:%s local:%s", C26373g.m41964Nu().getValue("CellTextViewEnable"), Integer.valueOf(C5046bo.getInt(C26373g.m41964Nu().getValue("CellTextViewEnable"), 1)), Boolean.valueOf(C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_CELLTEXTVIEW_CONFIG_BOOLEAN_SYNC, true)));
                if (1 == C5046bo.getInt(C26373g.m41964Nu().getValue("CellTextViewEnable"), 1) && r4) {
                    AppMethodBeat.m2505o(33322);
                    return true;
                }
                AppMethodBeat.m2505o(33322);
                return false;
            } catch (Exception e) {
                AppMethodBeat.m2505o(33322);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.al$e */
    static class C15732e extends C23812e {
        public C15732e(C46650a c46650a) {
            super(c46650a);
        }

        /* renamed from: a */
        public final void mo10992a(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33320);
            C40814ay c40814ay = (C40814ay) view.getTag();
            if (c7620bi.dtr()) {
                if (this.yJI != null) {
                    C7060h.pYm.mo8374X(10221, "1");
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    C25985d.m41467b(this.yJI.yTx.getContext(), "shake", ".ui.ShakeReportUI", intent);
                }
                AppMethodBeat.m2505o(33320);
                return;
            }
            if (c7620bi.isText() && (view instanceof MMTextView)) {
                MMTextView mMTextView = (MMTextView) view;
                C5346a.dHa();
                C5346a.m8097a(mMTextView.getText(), c40814ay.cKd);
            }
            AppMethodBeat.m2505o(33320);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.al$b */
    public static class C30587b extends C5378c implements C5365n, C5787b {
        private static final int zgH = 2131820672;
        private static final int zgI = 2131820585;
        private static final int zgJ = 2131820584;
        private C46650a yJI;
        private CharSequence yMu;
        private C15732e zgK;

        /* renamed from: com.tencent.mm.ui.chatting.viewitems.al$b$3 */
        class C157303 implements C46636v {
            C157303() {
            }

            /* renamed from: af */
            public final void mo27955af(CharSequence charSequence) {
                AppMethodBeat.m2504i(33306);
                C30587b.this.yMu = charSequence;
                AppMethodBeat.m2505o(33306);
            }
        }

        private C15732e dHo() {
            AppMethodBeat.m2504i(33309);
            if (this.zgK == null) {
                this.zgK = new C15732e(this.yJI);
            }
            C15732e c15732e = this.zgK;
            AppMethodBeat.m2505o(33309);
            return c15732e;
        }

        public final boolean dHk() {
            return true;
        }

        /* renamed from: aH */
        public boolean mo11016aH(int i, boolean z) {
            if (z && (i == 1 || i == 11 || i == 21 || i == 31 || i == 36 || i == 301989937)) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33310);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969084);
                view.setTag(new C5374f().mo11002z(view, false));
            }
            AppMethodBeat.m2505o(33310);
            return view;
        }

        /* renamed from: a */
        public void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            Object obj;
            C5371b bl;
            AppMethodBeat.m2504i(33311);
            this.yJI = c46650a;
            c5379a = (C5374f) c5379a;
            c5379a.zgQ.setTag(zgI, Long.valueOf(c7620bi.field_msgId));
            c5379a.zgQ.setTag(zgJ, Boolean.TRUE);
            c5379a.zgQ.setMaxLines(BaseClientBuilder.API_PRIORITY_OTHER);
            if (C5378c.dHm()) {
                if (c5379a.pyf != null) {
                    c5379a.pyf.setVisibility(8);
                }
                if (c7620bi.field_status == 1 || c7620bi.field_status == 5) {
                    if (c5379a.zci != null) {
                        c5379a.zci.setVisibility(8);
                    }
                    c5379a.zgQ.setBackgroundResource(C25738R.drawable.f6590j5);
                    c7620bi.xZd = true;
                } else {
                    c5379a.zgQ.setBackgroundResource(C25738R.drawable.f6589j4);
                    if (c5379a.zci != null) {
                        if (C5378c.m8136a((C15612h) c46650a.mo74857aF(C15612h.class), c7620bi.field_msgId)) {
                            if (c7620bi.xZd) {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
                                alphaAnimation.setDuration(300);
                                c5379a.zgQ.startAnimation(alphaAnimation);
                                c7620bi.xZd = false;
                            }
                            c5379a.zci.setVisibility(0);
                        } else {
                            c5379a.zci.setVisibility(8);
                        }
                    }
                }
            } else if (c5379a.pyf != null) {
                c5379a.pyf.setVisibility(c7620bi.field_status >= 2 ? 8 : 0);
            }
            String str2 = c7620bi.field_content;
            if (C5046bo.isNullOrNil(str2)) {
                C4990ab.m7413e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", Long.valueOf(c7620bi.field_msgId), Long.valueOf(c7620bi.field_msgSvrId));
            }
            if (c7620bi.dqJ == null || !c7620bi.dtV()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                CharSequence a = C44089j.m79283a(c5379a.zgQ.getContext(), str2, (int) c5379a.zgQ.getTextSize(), 1, null, m48747bK(c7620bi));
                C23733z c23733z = (C23733z) c46650a.mo74857aF(C23733z.class);
                if (c23733z.mo27776ng(c7620bi.field_msgId)) {
                    c5379a.zgQ.mo15920a(C34204f.m56086a(C39127d.m66572a(a, c23733z.dEM(), C28108a.Background, C28147b.mHt)).mDR, BufferType.SPANNABLE);
                } else {
                    c5379a.zgQ.mo15920a(a, BufferType.SPANNABLE);
                }
                for (C23322n type : (C23322n[]) a.getSpans(0, a.length(), C23322n.class)) {
                    if (type.getType() == 44) {
                        C7060h.pYm.mo8381e(12809, Integer.valueOf(6), "");
                        break;
                    }
                }
            } else {
                Object obj2;
                if (c7620bi.dqJ.contains("notify@all")) {
                    obj2 = "";
                } else {
                    String obj22 = c5379a.zgQ.getContext().getString(C25738R.string.dtl, new Object[]{"@"}) + IOUtils.LINE_SEPARATOR_UNIX;
                }
                c5379a.zgQ.mo15920a(C44089j.m79283a(c5379a.zgQ.getContext(), obj22 + str2, (int) c5379a.zgQ.getTextSize(), 1, Integer.valueOf(31), m48747bK(c7620bi)), BufferType.SPANNABLE);
            }
            C5370a c5370a = new C5370a(c7620bi, c46650a.dFx(), i);
            c5370a.zix = false;
            final Context context = c5379a.zgQ.getContext();
            c5379a.zgQ.setTag(zgH, Boolean.TRUE);
            if (c5379a.yMt == null) {
                c5379a.yMt = new C24088a(context, c5379a.zgQ);
                c5379a.yMt.zSa = true;
                c5379a.yMt.zRZ = new OnCreateContextMenuListener() {
                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.m2504i(33304);
                        contextMenu.clear();
                        contextMenu.add(0, 0, 0, context.getResources().getString(C25738R.string.f9082oy));
                        contextMenu.add(0, 1, 0, context.getResources().getString(C25738R.string.czl));
                        contextMenu.add(0, 2, 0, context.getResources().getString(C25738R.string.czk));
                        contextMenu.add(0, 3, 0, context.getResources().getString(C25738R.string.bnl));
                        AppMethodBeat.m2505o(33304);
                    }
                };
                c5379a.yMt.rBm = new C5279d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.m2504i(33305);
                        switch (menuItem.getItemId()) {
                            case 0:
                                ((ClipboardManager) C4996ah.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(C30587b.this.yMu, C30587b.this.yMu));
                                if (c5379a.zgV != null) {
                                    c5379a.zgV.dLM();
                                    c5379a.zgV.zWC = true;
                                    c5379a.zgV.zWD = true;
                                    c5379a.zgV.dLL();
                                }
                                Toast.makeText(context, C25738R.string.f9083oz, 0).show();
                                AppMethodBeat.m2505o(33305);
                                return;
                            case 1:
                                if (c5379a.zgV != null) {
                                    c5379a.zgV.zWC = true;
                                    c5379a.zgV.dLL();
                                    c5379a.zgV.mo75075hH(0, c5379a.zgQ.dPr().length());
                                    c5379a.zgV.dLO();
                                    c5379a.zgV.dLR();
                                    AppMethodBeat.m2505o(33305);
                                    return;
                                }
                                break;
                            case 2:
                                Intent intent = new Intent(context, MsgRetransmitUI.class);
                                intent.putExtra("Retr_Msg_content", C30587b.this.yMu);
                                intent.putExtra("Retr_Msg_Type", 4);
                                context.startActivity(intent);
                                AppMethodBeat.m2505o(33305);
                                return;
                            case 3:
                                C45316cl c45316cl = new C45316cl();
                                C40443e.m69375b(c45316cl, C30587b.this.yMu.toString(), 1);
                                c45316cl.cvA.fragment = C30587b.this.yJI.yTx;
                                c45316cl.cvA.cvH = 43;
                                if (c45316cl.cvA.cvC != null) {
                                    abl abl = c45316cl.cvA.cvC.wit;
                                    if (abl != null) {
                                        C40814ay c40814ay = (C40814ay) c5379a.zgQ.getTag();
                                        if (c40814ay != null) {
                                            abl.alD(C1853r.m3846Yz());
                                            abl.alE(c40814ay.cKd.field_talker);
                                            C4879a.xxA.mo10055m(c45316cl);
                                        }
                                    }
                                }
                                if (c5379a.zgV != null) {
                                    c5379a.zgV.dLM();
                                    c5379a.zgV.zWC = true;
                                    c5379a.zgV.zWD = true;
                                    c5379a.zgV.dLL();
                                    break;
                                }
                                break;
                        }
                        AppMethodBeat.m2505o(33305);
                    }
                };
            }
            if (c5379a.zgV == null) {
                C5382c c = mo11021c(c46650a);
                C40915a c40915a = new C40915a(c5379a.zgQ, c5379a.yMt, mo11006a(mo11021c(c46650a)), dHo(), c5379a.zgW);
                c40915a.zWt = C25738R.color.f12291z1;
                c40915a.zWN = 18;
                c40915a.zWu = C25738R.color.f11905l7;
                c5379a.zgV = c40915a.dLT();
                c5379a.zgX = new C5373d(c5379a.zgV);
                c5379a.zgV.zWl = new C157303();
                c5379a.zbi = new C5673f() {
                    public final void dismiss() {
                        AppMethodBeat.m2504i(33307);
                        c5379a.zgV.dLM();
                        c5379a.zgV.zWC = true;
                        c5379a.zgV.zWD = true;
                        c5379a.zgV.dLL();
                        AppMethodBeat.m2505o(33307);
                    }
                };
                c.zbi = c5379a.zbi;
            } else {
                c5379a.zgV.init();
            }
            c5379a.zgV.zWJ = c5379a.zgX;
            c5379a.zgQ.setTag(c5370a);
            c5379a.zgQ.setOnDoubleClickListener(this);
            c5379a.zgQ.setTextListener(new C5625a() {
                /* renamed from: ag */
                public final void mo11396ag(CharSequence charSequence) {
                    AppMethodBeat.m2504i(33308);
                    if (((Boolean) c5379a.zgQ.getTag(C30587b.zgJ)).booleanValue()) {
                        C5346a.dHa();
                        C5346a.dHb().mo10976a(charSequence, ((Long) c5379a.zgQ.getTag(C30587b.zgI)).longValue());
                    }
                    AppMethodBeat.m2505o(33308);
                }
            });
            C5371b c5371b = C5371b.NoTransform;
            if (C37469c.m63212Cj()) {
                if (c7620bi.dtF() && c7620bi.dtM()) {
                    str2 = c7620bi.field_transContent;
                } else {
                    str2 = null;
                }
                bl = ((C44297ah) c46650a.mo74857aF(C44297ah.class)).mo39566bl(c7620bi);
            } else {
                str2 = null;
                bl = c5371b;
            }
            if (!C5046bo.isNullOrNil(str2) || bl != C5371b.NoTransform) {
                String string;
                if (c5379a.zgU == null) {
                    c5379a.zgU = (ChattingItemTranslate) c5379a.zgT.inflate();
                    c5379a.zgU.init();
                }
                c5379a.zgU.mo10995a(C44089j.m79283a(c5379a.zgQ.getContext(), str2, (int) c5379a.zgQ.getTextSize(), 1, null, m48747bK(c7620bi)), bl);
                ChattingItemTranslate chattingItemTranslate = c5379a.zgU;
                if (C5046bo.isNullOrNil(c7620bi.field_transBrandWording)) {
                    string = c46650a.yTx.getMMResources().getString(C25738R.string.evt);
                } else {
                    string = c7620bi.field_transBrandWording;
                }
                chattingItemTranslate.setBrandWording(string);
                if (!C5046bo.isNullOrNil(str2)) {
                    C5370a c5370a2 = new C5370a(c7620bi, c46650a.dFx(), i);
                    c5370a2.klY = 2;
                    c5379a.zgU.setTag(c5370a2);
                    c5379a.zgU.setOnClickListener(dHo());
                    c5379a.zgU.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
                    c5379a.zgU.setOnDoubleClickListener(this);
                    c5379a.zgU.setOnLongClickListener(mo11021c(c46650a));
                    c5379a.zgU.setVisibility(0);
                }
            } else if (c5379a.zgU != null) {
                c5379a.zgU.setVisibility(8);
            }
            mo11007a(i, c5379a, c7620bi, c46650a.dFu(), c46650a.dFx(), c46650a, (C5365n) this);
            AppMethodBeat.m2505o(33311);
        }

        /* renamed from: aU */
        private void m48745aU(C7620bi c7620bi) {
            AppMethodBeat.m2504i(33312);
            if (!this.yJI.getTalkerUserName().equals("medianote")) {
                C9638aw.m17190ZK();
                C18628c.m29077XL().mo7920c(new C32325e(c7620bi.field_talker, c7620bi.field_msgSvrId));
            }
            C36121ak.m59479aU(c7620bi);
            this.yJI.mo74882qp(true);
            AppMethodBeat.m2505o(33312);
        }

        /* renamed from: bK */
        private String m48747bK(C7620bi c7620bi) {
            AppMethodBeat.m2504i(33313);
            if (c7620bi != null) {
                String nW = C37922v.m64078nW(c7620bi.field_msgSvrId);
                C32800b y = C37922v.m64076Zp().mo60676y(nW, true);
                y.mo53356j("prePublishId", "msg_" + c7620bi.field_msgSvrId);
                y.mo53356j("preUsername", mo11017b(this.yJI, c7620bi));
                y.mo53356j("preChatName", C5378c.m8139c(this.yJI, c7620bi));
                AppMethodBeat.m2505o(33313);
                return nW;
            }
            AppMethodBeat.m2505o(33313);
            return null;
        }

        /* JADX WARNING: Missing block: B:2:0x0011, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(33315);
     */
        /* JADX WARNING: Missing block: B:17:0x00b3, code skipped:
            r0 = (android.content.ClipboardManager) com.tencent.p177mm.sdk.platformtools.C4996ah.getContext().getSystemService("clipboard");
            r3 = r11.field_content;
            r4 = "MicroMsg.ChattingItemTextTo";
            r5 = new java.lang.StringBuilder("groupId = ").append(r9.getGroupId()).append(", content length: ");
     */
        /* JADX WARNING: Missing block: B:18:0x00dc, code skipped:
            if (r3 != null) goto L_0x0137;
     */
        /* JADX WARNING: Missing block: B:19:0x00de, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7410d(r4, r5.append(r1).toString());
            r1 = ((com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44297ah) r10.mo74857aF(com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44297ah.class)).mo39567bm(r11);
     */
        /* JADX WARNING: Missing block: B:21:?, code skipped:
            r0.setText(r1);
     */
        /* JADX WARNING: Missing block: B:24:0x0137, code skipped:
            r1 = r3.length();
     */
        /* JADX WARNING: Missing block: B:26:0x013d, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7412e("MicroMsg.ChattingItemTextTo", "clip.setText error ");
     */
        /* JADX WARNING: Missing block: B:34:?, code skipped:
            return false;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            String str;
            int i = 0;
            AppMethodBeat.m2504i(33315);
            switch (menuItem.getItemId()) {
                case 102:
                    break;
                case 103:
                    m48745aU(c7620bi);
                    break;
                case 108:
                    Intent intent = new Intent(c46650a.yTx.getContext(), MsgRetransmitUI.class);
                    String bm = ((C44297ah) c46650a.mo74857aF(C44297ah.class)).mo39567bm(c7620bi);
                    if (c7620bi.dtr()) {
                        intent.putExtra("Retr_Msg_content", bm);
                        intent.putExtra("Retr_Msg_Type", 6);
                    } else {
                        intent.putExtra("Retr_Msg_content", bm);
                        intent.putExtra("Retr_Msg_Type", 4);
                    }
                    c46650a.startActivity(intent);
                    break;
                case 124:
                    ((C44297ah) c46650a.mo74857aF(C44297ah.class)).mo39565b(menuItem, c7620bi);
                    break;
                case 141:
                    android.text.ClipboardManager clipboardManager = (android.text.ClipboardManager) C4996ah.getContext().getSystemService("clipboard");
                    str = c7620bi.field_transContent;
                    if (!C5046bo.isNullOrNil(str)) {
                        clipboardManager.setText(str);
                    }
                    C30379h.m48465bQ(c46650a.yTx.getContext(), c46650a.yTx.getContext().getString(C25738R.string.f9083oz));
                    AppMethodBeat.m2505o(33315);
                    return true;
                case ErrorCode.NEEDDOWNLOAD_3 /*142*/:
                    Intent intent2 = new Intent(c46650a.yTx.getContext(), MsgRetransmitUI.class);
                    str = c7620bi.field_transContent;
                    if (c7620bi.dtr()) {
                        intent2.putExtra("Retr_Msg_content", str);
                        intent2.putExtra("Retr_Msg_Type", 6);
                    } else {
                        intent2.putExtra("Retr_Msg_content", str);
                        intent2.putExtra("Retr_Msg_Type", 4);
                    }
                    c46650a.startActivity(intent2);
                    AppMethodBeat.m2505o(33315);
                    return true;
                case ErrorCode.NEEDDOWNLOAD_4 /*143*/:
                    C45316cl c45316cl = new C45316cl();
                    C40443e.m69375b(c45316cl, c7620bi.field_transContent, 1);
                    c45316cl.cvA.fragment = c46650a.yTx;
                    c45316cl.cvA.cvH = 43;
                    if (c45316cl.cvA.cvC == null) {
                        C4990ab.m7412e("MicroMsg.ChattingItemTextTo", "alvinluo transform text fav failed");
                        break;
                    }
                    abl abl = c45316cl.cvA.cvC.wit;
                    if (abl != null) {
                        abl.alD(c7620bi.field_talker);
                        abl.alE(C1853r.m3846Yz());
                        C4879a.xxA.mo10055m(c45316cl);
                        break;
                    }
                    break;
            }
            C30379h.m48465bQ(c46650a.yTx.getContext(), c46650a.yTx.getContext().getString(C25738R.string.f9083oz));
            C21734a c21734a = C21734a.qjm;
            C21734a.m33275h(1, c7620bi.field_msgSvrId, C5046bo.ana(str));
            AppMethodBeat.m2505o(33315);
            return true;
        }

        /* renamed from: a */
        public final void mo10991a(C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33316);
            c7620bi.dtJ();
            C9638aw.m17190ZK();
            C18628c.m29080XO().mo15284a(c7620bi.field_msgId, c7620bi);
            if (c7620bi.isText() && c7620bi.field_isSend == 1) {
                m48745aU(c7620bi);
            }
            AppMethodBeat.m2505o(33316);
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: fi */
        public final boolean mo11868fi(View view) {
            AppMethodBeat.m2504i(33317);
            CharSequence dPr = ((MMNeat7extView) view).dPr();
            Intent intent = new Intent(view.getContext(), TextPreviewUI.class);
            intent.addFlags(67108864);
            intent.putExtra("key_chat_text", dPr);
            if (view.getTag() instanceof C40814ay) {
                C40814ay c40814ay = (C40814ay) view.getTag();
                if (c40814ay != null) {
                    intent.putExtra("Chat_Msg_Id", c40814ay.cKd.field_msgId);
                }
            }
            view.getContext().startActivity(intent);
            C5274b.m8053hL(view.getContext());
            AppMethodBeat.m2505o(33317);
            return true;
        }

        /* renamed from: a */
        public boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            boolean z;
            AppMethodBeat.m2504i(33314);
            if (c7620bi.dqJ == null || !c7620bi.dqJ.contains("announcement@all")) {
                z = false;
            } else {
                z = true;
            }
            if (c7620bi.isText() || c7620bi.dtr()) {
                C5370a c5370a = (C5370a) view.getTag();
                int i = c5370a.position;
                if (c5370a.klY == 1) {
                    if (c7620bi.isText()) {
                        contextMenu.add(i, 102, 0, view.getContext().getString(C25738R.string.am4));
                    }
                    contextMenu.add(i, 108, 0, view.getContext().getString(C25738R.string.dr1));
                    if (c7620bi.field_status == 5) {
                        contextMenu.add(i, 103, 0, view.getContext().getString(C25738R.string.anv));
                    }
                    if (C25985d.afj("favorite")) {
                        contextMenu.add(i, 116, 0, view.getContext().getString(C25738R.string.dcq));
                    }
                    if (C46494g.m87731ad(this.yJI.yTx.getContext(), c7620bi.getType())) {
                        contextMenu.add(i, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 0, view.getContext().getString(C25738R.string.amc));
                    }
                    if (!z && !c7620bi.drC() && c7620bi.isText() && ((c7620bi.field_status == 2 || c7620bi.dJz == 1) && C5378c.m8135a(c7620bi, this.yJI) && C5378c.arB(c7620bi.field_talker) && !C7616ad.m13549mg(this.yJI.getTalkerUserName()))) {
                        contextMenu.add(i, 123, 0, view.getContext().getString(C25738R.string.ami));
                    }
                    if (C37469c.m63212Cj()) {
                        if (c7620bi.dtF() && c7620bi.dtM()) {
                            contextMenu.add(i, 124, 0, view.getContext().getString(C25738R.string.amn));
                        } else {
                            contextMenu.add(i, 124, 0, view.getContext().getString(C25738R.string.amp));
                        }
                    }
                    if (c7620bi.isText() && C17903f.aex()) {
                        this.yJI.dFy();
                    }
                    if (!this.yJI.dFy()) {
                        contextMenu.add(i, 100, 0, view.getContext().getString(C25738R.string.am7));
                    }
                } else if (c5370a.klY == 2) {
                    contextMenu.add(i, 141, 0, view.getContext().getString(C25738R.string.am4));
                    contextMenu.add(i, ErrorCode.NEEDDOWNLOAD_3, 0, view.getContext().getString(C25738R.string.dr1));
                    if (C25985d.afj("favorite")) {
                        contextMenu.add(i, ErrorCode.NEEDDOWNLOAD_4, 0, view.getContext().getString(C25738R.string.dcq));
                    }
                    if (C37469c.m63213Ck() && c7620bi.dtP()) {
                        contextMenu.add(i, 125, 0, view.getContext().getString(C25738R.string.amh));
                    }
                    AppMethodBeat.m2505o(33314);
                    return false;
                }
                AppMethodBeat.m2505o(33314);
                return true;
            }
            AppMethodBeat.m2505o(33314);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.al$c */
    static final class C30590c implements C5626b {
        private C30590c() {
        }

        /* synthetic */ C30590c(byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo11397a(Exception exception, String str, String str2) {
            AppMethodBeat.m2504i(33318);
            if (!C7243d.vxp) {
                HashMap hashMap = new HashMap(2);
                hashMap.put("Content", str);
                hashMap.put("Exception", exception.toString());
                hashMap.put("Stack", exception.getStackTrace());
                C7060h.pYm.mo8382g("NeatTextView", str2, hashMap);
            }
            AppMethodBeat.m2505o(33318);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.al$a */
    public static class C30591a extends C5378c implements C5787b {
        private static final int zgH = 2131820672;
        private static final int zgI = 2131820585;
        private static final int zgJ = 2131820584;
        private C46650a yJI;
        private CharSequence yMu;
        private C15732e zgK;

        /* renamed from: com.tencent.mm.ui.chatting.viewitems.al$a$4 */
        class C305954 implements C46636v {
            C305954() {
            }

            /* renamed from: af */
            public final void mo27955af(CharSequence charSequence) {
                AppMethodBeat.m2504i(33290);
                C30591a.this.yMu = charSequence;
                AppMethodBeat.m2505o(33290);
            }
        }

        private C15732e dHo() {
            AppMethodBeat.m2504i(33295);
            if (this.zgK == null) {
                this.zgK = new C15732e(this.yJI);
            }
            C15732e c15732e = this.zgK;
            AppMethodBeat.m2505o(33295);
            return c15732e;
        }

        public final boolean dHk() {
            return false;
        }

        /* renamed from: aH */
        public boolean mo11016aH(int i, boolean z) {
            if (z || (i != 1 && i != 11 && i != 21 && i != 31 && i != 36 && i != 301989937)) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        public View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33296);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969046);
                view.setTag(new C5374f().mo11002z(view, true));
            }
            AppMethodBeat.m2505o(33296);
            return view;
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: b */
        public final boolean mo11020b(C46650a c46650a) {
            AppMethodBeat.m2504i(33297);
            boolean dFx = c46650a.dFx();
            AppMethodBeat.m2505o(33297);
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
        /* renamed from: a */
        public void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            C5371b bl;
            String str2;
            String trim;
            String str3;
            Object obj;
            C5370a c5370a;
            final Context context;
            int t;
            ChattingItemTranslate chattingItemTranslate;
            AppMethodBeat.m2504i(33298);
            this.yJI = c46650a;
            final C5374f c5374f = (C5374f) c5379a;
            String str4 = c7620bi.field_content;
            String talkerUserName = c46650a.getTalkerUserName();
            c5374f.zgQ.setTag(zgI, Long.valueOf(c7620bi.field_msgId));
            c5374f.zgQ.setTag(zgJ, Boolean.TRUE);
            C5371b c5371b = C5371b.NoTransform;
            if (C37469c.m63212Cj()) {
                String str5;
                if (c7620bi.dtF() && c7620bi.dtM()) {
                    str5 = c7620bi.field_transContent;
                } else {
                    str5 = null;
                }
                bl = ((C44297ah) c46650a.mo74857aF(C44297ah.class)).mo39566bl(c7620bi);
                str2 = str5;
            } else {
                bl = c5371b;
                str2 = null;
            }
            if (c46650a.dFx() && !((C36135d) c46650a.mo74857aF(C36135d.class)).dDm()) {
                int ox = C1829bf.m3761ox(str4);
                if (ox != -1) {
                    trim = str4.substring(0, ox).trim();
                    if (trim == null || trim.length() <= 0) {
                        trim = talkerUserName;
                    }
                    CharSequence trim2 = str4.substring(ox + 1).trim();
                    if (C5046bo.isNullOrNil(str2)) {
                        str3 = str2;
                        talkerUserName = trim;
                    } else {
                        str3 = str2.substring(ox + 1).trim();
                        talkerUserName = trim;
                    }
                    mo11011a((C5379a) c5374f, c46650a, c7620bi, talkerUserName);
                    mo11012a((C5379a) c5374f, c46650a, talkerUserName, c7620bi);
                    if (c7620bi.dqJ == null && c7620bi.dtV()) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        trim2 = C44089j.m79283a(c5374f.zgQ.getContext(), trim2, (int) c5374f.zgQ.getTextSize(), 1, null, m48760bK(c7620bi));
                        C23733z c23733z = (C23733z) c46650a.mo74857aF(C23733z.class);
                        if (c23733z.mo27776ng(c7620bi.field_msgId)) {
                            c5374f.zgQ.mo15920a(C34204f.m56086a(C39127d.m66572a(trim2, c23733z.dEM(), C28108a.Background, C28147b.mHs)).mDR, BufferType.SPANNABLE);
                        } else {
                            c5374f.zgQ.mo15920a(trim2, BufferType.SPANNABLE);
                        }
                        for (C23322n type : (C23322n[]) trim2.getSpans(0, trim2.length(), C23322n.class)) {
                            if (type.getType() == 44) {
                                C7060h.pYm.mo8381e(12809, Integer.valueOf(7), "");
                                break;
                            }
                        }
                    } else if (obj != null) {
                        Object obj2;
                        if (c7620bi.dqJ.contains("notify@all")) {
                            obj2 = "";
                        } else {
                            str2 = c5374f.zgQ.getContext().getString(C25738R.string.dtl, new Object[]{"@"}) + IOUtils.LINE_SEPARATOR_UNIX;
                        }
                        c5374f.zgQ.mo15920a(C44089j.m79283a(c5374f.zgQ.getContext(), obj2 + trim2, (int) c5374f.zgQ.getTextSize(), 1, Integer.valueOf(31), m48760bK(c7620bi)), BufferType.SPANNABLE);
                    }
                    c5370a = new C5370a(c7620bi, c46650a.dFx(), i);
                    c5374f.zgS.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(33285);
                            Intent intent = new Intent(view.getContext(), TextPreviewUI.class);
                            intent.addFlags(67108864);
                            C40814ay c40814ay = (C40814ay) c5374f.zgQ.getTag();
                            if (c40814ay != null) {
                                CharSequence dPr = c5374f.zgQ.dPr();
                                intent.putExtra("Chat_Msg_Id", c40814ay.cKd.field_msgId);
                                intent.putExtra("key_chat_text", dPr);
                                view.getContext().startActivity(intent);
                                C5274b.m8053hL(view.getContext());
                            }
                            AppMethodBeat.m2505o(33285);
                        }
                    });
                    context = c5374f.zgQ.getContext();
                    c5374f.zgQ.setTag(zgH, Boolean.TRUE);
                    if (c5374f.yMt == null) {
                        c5374f.yMt = new C24088a(context, c5374f.zgQ);
                        c5374f.yMt.zSa = true;
                        c5374f.yMt.zRZ = new OnCreateContextMenuListener() {
                            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                                int t;
                                AppMethodBeat.m2504i(33286);
                                contextMenu.clear();
                                contextMenu.add(0, 0, 0, context.getResources().getString(C25738R.string.f9082oy));
                                CharSequence dPr = c5374f.zgQ.dPr();
                                C40814ay c40814ay = (C40814ay) c5374f.zgQ.getTag();
                                if (c40814ay != null) {
                                    t = C1831bh.m3776t(c40814ay.cKd);
                                } else {
                                    t = 0;
                                }
                                if (t <= 0 || t >= dPr.length()) {
                                    contextMenu.add(0, 1, 0, context.getResources().getString(C25738R.string.czl));
                                }
                                contextMenu.add(0, 2, 0, context.getResources().getString(C25738R.string.czk));
                                contextMenu.add(0, 3, 0, context.getResources().getString(C25738R.string.bnl));
                                AppMethodBeat.m2505o(33286);
                            }
                        };
                        c5374f.yMt.rBm = new C5279d() {

                            /* renamed from: com.tencent.mm.ui.chatting.viewitems.al$a$3$2 */
                            class C305932 implements DialogInterface.OnClickListener {
                                C305932() {
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(33288);
                                    Intent intent = new Intent(context, MsgRetransmitUI.class);
                                    intent.putExtra("Retr_Msg_content", C30591a.this.yMu);
                                    intent.putExtra("Retr_Msg_Type", 4);
                                    context.startActivity(intent);
                                    AppMethodBeat.m2505o(33288);
                                }
                            }

                            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                AppMethodBeat.m2504i(33289);
                                C40814ay c40814ay;
                                switch (menuItem.getItemId()) {
                                    case 0:
                                        ((ClipboardManager) C4996ah.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(C30591a.this.yMu, C30591a.this.yMu));
                                        if (c5374f.zgV != null) {
                                            c5374f.zgV.dLM();
                                            c5374f.zgV.zWC = true;
                                            c5374f.zgV.zWD = true;
                                            c5374f.zgV.dLL();
                                        }
                                        Toast.makeText(context, C25738R.string.f9083oz, 0).show();
                                        AppMethodBeat.m2505o(33289);
                                        return;
                                    case 1:
                                        if (c5374f.zgV != null) {
                                            c5374f.zgV.zWC = true;
                                            c5374f.zgV.dLL();
                                            c5374f.zgV.mo75075hH(0, c5374f.zgQ.dPr().length());
                                            c5374f.zgV.dLO();
                                            c5374f.zgV.dLR();
                                            AppMethodBeat.m2505o(33289);
                                            return;
                                        }
                                        break;
                                    case 2:
                                        c40814ay = (C40814ay) c5374f.zgQ.getTag();
                                        if (c40814ay != null) {
                                            final String s = C1831bh.m3775s(c40814ay.cKd);
                                            if (C5046bo.isNullOrNil(s)) {
                                                Intent intent = new Intent(context, MsgRetransmitUI.class);
                                                intent.putExtra("Retr_Msg_content", C30591a.this.yMu);
                                                intent.putExtra("Retr_Msg_Type", 4);
                                                context.startActivity(intent);
                                                AppMethodBeat.m2505o(33289);
                                                return;
                                            }
                                            C30379h.m48429a(context, (int) C25738R.string.g8v, (int) C25738R.string.g8w, (int) C25738R.string.f9255uf, (int) C25738R.string.g6g, true, new DialogInterface.OnClickListener() {
                                                public final void onClick(DialogInterface dialogInterface, int i) {
                                                    AppMethodBeat.m2504i(33287);
                                                    Intent intent = new Intent();
                                                    intent.putExtra("rawUrl", s);
                                                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                                                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                                                    C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent);
                                                    AppMethodBeat.m2505o(33287);
                                                }
                                            }, new C305932());
                                            AppMethodBeat.m2505o(33289);
                                            return;
                                        }
                                        break;
                                    case 3:
                                        C45316cl c45316cl = new C45316cl();
                                        C40443e.m69375b(c45316cl, C30591a.this.yMu.toString(), 1);
                                        c45316cl.cvA.fragment = C30591a.this.yJI.yTx;
                                        c45316cl.cvA.cvH = 43;
                                        if (c45316cl.cvA.cvC != null) {
                                            abl abl = c45316cl.cvA.cvC.wit;
                                            if (abl != null) {
                                                c40814ay = (C40814ay) c5374f.zgQ.getTag();
                                                if (c40814ay != null) {
                                                    abl.alD(c40814ay.cKd.field_talker);
                                                    abl.alE(C1853r.m3846Yz());
                                                    C4879a.xxA.mo10055m(c45316cl);
                                                }
                                            }
                                        }
                                        if (c5374f.zgV != null) {
                                            c5374f.zgV.dLM();
                                            c5374f.zgV.zWC = true;
                                            c5374f.zgV.zWD = true;
                                            c5374f.zgV.dLL();
                                            break;
                                        }
                                        break;
                                }
                                AppMethodBeat.m2505o(33289);
                            }
                        };
                    }
                    if (C1831bh.m3770o(c7620bi)) {
                        int i2;
                        t = C1831bh.m3776t(c7620bi);
                        if (t <= 0 || t >= C40917b.m70929fs(c5374f.zgQ).length()) {
                            i2 = 0;
                        } else {
                            i2 = t;
                        }
                        C5382c c = mo11021c(c46650a);
                        C5673f a = mo11006a(c);
                        if (c5374f.zgV != null) {
                            c5374f.zgV.destroy();
                        }
                        C40915a c40915a = new C40915a(c5374f.zgQ, c5374f.yMt, a, dHo(), c5374f.zgW);
                        c40915a.zWt = C25738R.color.f12291z1;
                        c40915a.zWN = 18;
                        c40915a.zWu = C25738R.color.f11905l7;
                        c5374f.zgV = c40915a.dLT();
                        c5374f.zgX = new C5373d(c5374f.zgV);
                        c5374f.zgV.zWl = new C305954();
                        c5374f.zbi = new C5673f() {
                            public final void dismiss() {
                                AppMethodBeat.m2504i(33291);
                                c5374f.zgV.dLM();
                                c5374f.zgV.zWC = true;
                                c5374f.zgV.zWD = true;
                                c5374f.zgV.dLL();
                                AppMethodBeat.m2505o(33291);
                            }
                        };
                        c.zbi = c5374f.zbi;
                        c5374f.zgV.zWy = i2;
                        c5374f.zgV.zWJ = c5374f.zgX;
                    } else {
                        c5374f.zgQ.setTag(zgH, Boolean.FALSE);
                        c5374f.zgQ.setOnTouchListener(c5374f.zgW);
                        c5374f.zgQ.setOnLongClickListener(mo11021c(c46650a));
                        c5374f.zgQ.setOnClickListener(dHo());
                    }
                    c5374f.zgQ.setOnDoubleClickListener(this);
                    c5374f.zgQ.setTag(c5370a);
                    c5374f.zgQ.setTag(zgI, Long.valueOf(c7620bi.field_msgId));
                    c5374f.zgQ.setTextListener(new C5625a() {
                        /* renamed from: ag */
                        public final void mo11396ag(CharSequence charSequence) {
                            AppMethodBeat.m2504i(33292);
                            if (((Boolean) c5374f.zgQ.getTag(C30591a.zgJ)).booleanValue()) {
                                C5346a.dHa();
                                C5346a.dHb().mo10976a(charSequence, ((Long) c5374f.zgQ.getTag(C30591a.zgI)).longValue());
                            }
                            AppMethodBeat.m2505o(33292);
                        }
                    });
                    c5374f.zgS.setVisibility(8);
                    c5374f.zgR.setVisibility(8);
                    c5374f.zgQ.setMaxLines(BaseClientBuilder.API_PRIORITY_OTHER);
                    t = C26373g.m41964Nu().getInt("InvalidateTextFoldLineNum", 5);
                    if (C1831bh.m3773q(c7620bi)) {
                        C5782a QV = c5374f.zgQ.mo15918QV(c5374f.zgQ.getContext().getResources().getDimensionPixelSize(C25738R.dimen.f10298x7));
                        if (QV != null && QV.dPe() > t) {
                            c5374f.zgQ.setMaxLines(t);
                            c5374f.zgS.setVisibility(0);
                            c5374f.zgR.setVisibility(0);
                        }
                    }
                    if (C5046bo.isNullOrNil(str3) || bl != C5371b.NoTransform) {
                        if (c5374f.zgU == null) {
                            c5374f.zgU = (ChattingItemTranslate) c5374f.zgT.inflate();
                            c5374f.zgU.init();
                        }
                        c5374f.zgU.mo10995a(C44089j.m79283a(c5374f.zgQ.getContext(), str3, (int) c5374f.zgQ.getTextSize(), 1, null, m48760bK(c7620bi)), bl);
                        chattingItemTranslate = c5374f.zgU;
                        if (C5046bo.isNullOrNil(c7620bi.field_transBrandWording)) {
                            trim = c7620bi.field_transBrandWording;
                        } else {
                            trim = c46650a.yTx.getMMResources().getString(C25738R.string.evt);
                        }
                        chattingItemTranslate.setBrandWording(trim);
                        if (!C5046bo.isNullOrNil(str3)) {
                            C5370a c5370a2 = new C5370a(c7620bi, c46650a.dFx(), i);
                            c5370a2.zix = false;
                            c5370a2.klY = 2;
                            c5374f.zgU.setTag(c5370a2);
                            c5374f.zgU.setOnClickListener(dHo());
                            c5374f.zgU.setOnDoubleClickListener(this);
                            c5374f.zgU.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
                            c5374f.zgU.setOnLongClickListener(mo11021c(c46650a));
                            c5374f.zgU.setVisibility(0);
                        }
                        AppMethodBeat.m2505o(33298);
                    }
                    if (c5374f.zgU != null) {
                        c5374f.zgU.setVisibility(8);
                    }
                    AppMethodBeat.m2505o(33298);
                    return;
                }
            }
            str3 = str2;
            Object trim22 = str4;
            mo11011a((C5379a) c5374f, c46650a, c7620bi, talkerUserName);
            mo11012a((C5379a) c5374f, c46650a, talkerUserName, c7620bi);
            if (c7620bi.dqJ == null) {
            }
            obj = null;
            if (obj != null) {
            }
            c5370a = new C5370a(c7620bi, c46650a.dFx(), i);
            c5374f.zgS.setOnClickListener(/* anonymous class already generated */);
            context = c5374f.zgQ.getContext();
            c5374f.zgQ.setTag(zgH, Boolean.TRUE);
            if (c5374f.yMt == null) {
            }
            if (C1831bh.m3770o(c7620bi)) {
            }
            c5374f.zgQ.setOnDoubleClickListener(this);
            c5374f.zgQ.setTag(c5370a);
            c5374f.zgQ.setTag(zgI, Long.valueOf(c7620bi.field_msgId));
            c5374f.zgQ.setTextListener(/* anonymous class already generated */);
            c5374f.zgS.setVisibility(8);
            c5374f.zgR.setVisibility(8);
            c5374f.zgQ.setMaxLines(BaseClientBuilder.API_PRIORITY_OTHER);
            t = C26373g.m41964Nu().getInt("InvalidateTextFoldLineNum", 5);
            if (C1831bh.m3773q(c7620bi)) {
            }
            if (C5046bo.isNullOrNil(str3)) {
            }
            if (c5374f.zgU == null) {
            }
            c5374f.zgU.mo10995a(C44089j.m79283a(c5374f.zgQ.getContext(), str3, (int) c5374f.zgQ.getTextSize(), 1, null, m48760bK(c7620bi)), bl);
            chattingItemTranslate = c5374f.zgU;
            if (C5046bo.isNullOrNil(c7620bi.field_transBrandWording)) {
            }
            chattingItemTranslate.setBrandWording(trim);
            if (C5046bo.isNullOrNil(str3)) {
            }
            AppMethodBeat.m2505o(33298);
        }

        /* renamed from: bK */
        private String m48760bK(C7620bi c7620bi) {
            AppMethodBeat.m2504i(33299);
            if (c7620bi != null) {
                String nW = C37922v.m64078nW(c7620bi.field_msgSvrId);
                C32800b y = C37922v.m64076Zp().mo60676y(nW, true);
                y.mo53356j("prePublishId", "msg_" + c7620bi.field_msgSvrId);
                y.mo53356j("preUsername", mo11017b(this.yJI, c7620bi));
                y.mo53356j("preChatName", C5378c.m8139c(this.yJI, c7620bi));
                AppMethodBeat.m2505o(33299);
                return nW;
            }
            AppMethodBeat.m2505o(33299);
            return null;
        }

        /* Access modifiers changed, original: protected */
        public boolean dHj() {
            return false;
        }

        /* renamed from: a */
        public boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33300);
            if (c7620bi.isText() || c7620bi.dtr()) {
                C5370a c5370a = (C5370a) view.getTag();
                int i = c5370a.position;
                if (c5370a.klY == 1) {
                    if (c7620bi.isText()) {
                        contextMenu.add(i, 102, 0, view.getContext().getString(C25738R.string.am4));
                    }
                    contextMenu.add(i, 108, 0, view.getContext().getString(C25738R.string.dr1));
                    if (C25985d.afj("favorite")) {
                        contextMenu.add(i, 116, 0, view.getContext().getString(C25738R.string.dcq));
                    }
                    if (C46494g.m87731ad(this.yJI.yTx.getContext(), c7620bi.getType())) {
                        contextMenu.add(i, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 0, view.getContext().getString(C25738R.string.amc));
                    }
                    if (c7620bi.isText() && C17903f.aex()) {
                        this.yJI.dFy();
                    }
                    if (!this.yJI.dFy()) {
                        contextMenu.add(i, 100, 0, view.getContext().getString(C25738R.string.am7));
                    }
                    if (C37469c.m63212Cj()) {
                        if (c7620bi.dtF() && c7620bi.dtM()) {
                            contextMenu.add(i, 124, 0, view.getContext().getString(C25738R.string.amn));
                        } else {
                            contextMenu.add(i, 124, 0, view.getContext().getString(C25738R.string.amp));
                        }
                    }
                    if (C1831bh.m3770o(c7620bi)) {
                        contextMenu.clear();
                        if (!this.yJI.dFy()) {
                            contextMenu.add(i, 100, 0, view.getContext().getString(C25738R.string.am7));
                        }
                    }
                } else if (c5370a.klY == 2) {
                    contextMenu.add(i, 141, 0, view.getContext().getString(C25738R.string.am4));
                    contextMenu.add(i, ErrorCode.NEEDDOWNLOAD_3, 0, view.getContext().getString(C25738R.string.dr1));
                    if (C25985d.afj("favorite")) {
                        contextMenu.add(i, ErrorCode.NEEDDOWNLOAD_4, 0, view.getContext().getString(C25738R.string.dcq));
                    }
                    if (C37469c.m63213Ck() && c7620bi.dtP()) {
                        contextMenu.add(i, 125, 0, view.getContext().getString(C25738R.string.amh));
                    }
                    AppMethodBeat.m2505o(33300);
                    return false;
                }
                AppMethodBeat.m2505o(33300);
                return true;
            }
            AppMethodBeat.m2505o(33300);
            return true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x00bb  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00a6  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x019a  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0108  */
        /* JADX WARNING: Missing block: B:2:0x0011, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(33301);
     */
        /* JADX WARNING: Missing block: B:38:0x0121, code skipped:
            r0 = (android.content.ClipboardManager) com.tencent.p177mm.sdk.platformtools.C4996ah.getContext().getSystemService("clipboard");
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
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7410d(r2, r3.append(r1).toString());
            r1 = ((com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44297ah) r12.mo74857aF(com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44297ah.class)).mo39567bm(r13);
     */
        /* JADX WARNING: Missing block: B:43:?, code skipped:
            r0.setText(r1);
     */
        /* JADX WARNING: Missing block: B:46:0x01a5, code skipped:
            r1 = r1.length();
     */
        /* JADX WARNING: Missing block: B:48:0x01ab, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7412e("MicroMsg.ChattingItemTextFrom", "clip.setText error ");
     */
        /* JADX WARNING: Missing block: B:60:?, code skipped:
            return false;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, final C46650a c46650a, final C7620bi c7620bi) {
            String str;
            AppMethodBeat.m2504i(33301);
            String bm;
            int ox;
            switch (menuItem.getItemId()) {
                case 102:
                    break;
                case 108:
                    final String s = C1831bh.m3775s(c7620bi);
                    if (!C5046bo.isNullOrNil(s)) {
                        C30379h.m48429a(c46650a.yTx.getContext(), (int) C25738R.string.g8v, (int) C25738R.string.g8w, (int) C25738R.string.f9255uf, (int) C25738R.string.g6g, true, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(33293);
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", s);
                                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                                C25985d.m41467b(c46650a.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                AppMethodBeat.m2505o(33293);
                            }
                        }, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(33294);
                                Intent intent = new Intent(c46650a.yTx.getContext(), MsgRetransmitUI.class);
                                String bm = ((C44297ah) c46650a.mo74857aF(C44297ah.class)).mo39567bm(c7620bi);
                                if (c7620bi.dtr()) {
                                    intent.putExtra("Retr_Msg_content", bm);
                                    intent.putExtra("Retr_Msg_Type", 6);
                                } else {
                                    intent.putExtra("Retr_Msg_content", bm);
                                    intent.putExtra("Retr_Msg_Type", 4);
                                }
                                c46650a.yTx.getContext().startActivity(intent);
                                AppMethodBeat.m2505o(33294);
                            }
                        });
                        break;
                    }
                    Intent intent = new Intent(c46650a.yTx.getContext(), MsgRetransmitUI.class);
                    bm = ((C44297ah) c46650a.mo74857aF(C44297ah.class)).mo39567bm(c7620bi);
                    if (c7620bi.dtr()) {
                        intent.putExtra("Retr_Msg_content", bm);
                        intent.putExtra("Retr_Msg_Type", 6);
                    } else {
                        intent.putExtra("Retr_Msg_content", bm);
                        intent.putExtra("Retr_Msg_Type", 4);
                    }
                    c46650a.startActivity(intent);
                    break;
                case 124:
                case 125:
                    ((C44297ah) c46650a.mo74857aF(C44297ah.class)).mo39565b(menuItem, c7620bi);
                    break;
                case 141:
                    str = c7620bi.field_transContent;
                    if (c46650a.dFx() && !((C36135d) c46650a.mo74857aF(C36135d.class)).dDm()) {
                        ox = C1829bf.m3761ox(str);
                        if (ox != -1) {
                            str = str.substring(ox + 1).trim();
                        }
                    }
                    android.text.ClipboardManager clipboardManager = (android.text.ClipboardManager) C4996ah.getContext().getSystemService("clipboard");
                    if (!C5046bo.isNullOrNil(str)) {
                        clipboardManager.setText(str);
                    }
                    C30379h.m48465bQ(c46650a.yTx.getContext(), c46650a.yTx.getContext().getString(C25738R.string.f9083oz));
                    AppMethodBeat.m2505o(33301);
                    return true;
                case ErrorCode.NEEDDOWNLOAD_3 /*142*/:
                    Intent intent2 = new Intent(c46650a.yTx.getContext(), MsgRetransmitUI.class);
                    str = c7620bi.field_transContent;
                    if (c46650a.dFx() && !((C36135d) c46650a.mo74857aF(C36135d.class)).dDm()) {
                        ox = C1829bf.m3761ox(str);
                        if (ox != -1) {
                            bm = str.substring(ox + 1).trim();
                            if (c7620bi.dtr()) {
                                intent2.putExtra("Retr_Msg_content", bm);
                                intent2.putExtra("Retr_Msg_Type", 4);
                            } else {
                                intent2.putExtra("Retr_Msg_content", bm);
                                intent2.putExtra("Retr_Msg_Type", 6);
                            }
                            c46650a.startActivity(intent2);
                            AppMethodBeat.m2505o(33301);
                            return true;
                        }
                    }
                    bm = str;
                    if (c7620bi.dtr()) {
                    }
                    c46650a.startActivity(intent2);
                    AppMethodBeat.m2505o(33301);
                    return true;
                case ErrorCode.NEEDDOWNLOAD_4 /*143*/:
                    C45316cl c45316cl = new C45316cl();
                    str = c7620bi.field_transContent;
                    if (c46650a.dFx() && !((C36135d) c46650a.mo74857aF(C36135d.class)).dDm()) {
                        ox = C1829bf.m3761ox(str);
                        if (ox != -1) {
                            bm = str.substring(ox + 1).trim();
                            C40443e.m69375b(c45316cl, bm, 1);
                            c45316cl.cvA.fragment = c46650a.yTx;
                            c45316cl.cvA.cvH = 43;
                            if (c45316cl.cvA.cvC != null) {
                                C4990ab.m7412e("MicroMsg.ChattingItemTextFrom", "alvinluo transform text fav failed");
                                break;
                            }
                            abl abl = c45316cl.cvA.cvC.wit;
                            if (abl != null) {
                                abl.alD(c7620bi.field_talker);
                                abl.alE(C1853r.m3846Yz());
                                C4879a.xxA.mo10055m(c45316cl);
                                break;
                            }
                        }
                    }
                    bm = str;
                    C40443e.m69375b(c45316cl, bm, 1);
                    c45316cl.cvA.fragment = c46650a.yTx;
                    c45316cl.cvA.cvH = 43;
                    if (c45316cl.cvA.cvC != null) {
                    }
                    break;
            }
            C30379h.m48465bQ(c46650a.yTx.getContext(), c46650a.yTx.getContext().getString(C25738R.string.f9083oz));
            C21734a c21734a = C21734a.qjm;
            C21734a.m33275h(1, c7620bi.field_msgSvrId, C5046bo.ana(str));
            AppMethodBeat.m2505o(33301);
            return true;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33302);
            if (view instanceof MMTextView) {
                MMTextView mMTextView = (MMTextView) view;
                C5346a.dHa();
                C5346a.m8097a(mMTextView.getText(), c7620bi);
            }
            AppMethodBeat.m2505o(33302);
            return true;
        }

        /* renamed from: fi */
        public final boolean mo11868fi(View view) {
            AppMethodBeat.m2504i(33303);
            Intent intent = new Intent(view.getContext(), TextPreviewUI.class);
            intent.addFlags(67108864);
            C40814ay c40814ay = (C40814ay) view.getTag();
            if (c40814ay != null) {
                CharSequence dPr = ((MMNeat7extView) view).dPr();
                intent.putExtra("Chat_Msg_Id", c40814ay.cKd.field_msgId);
                intent.putExtra("key_chat_text", dPr);
                view.getContext().startActivity(intent);
                C5274b.m8053hL(view.getContext());
            }
            AppMethodBeat.m2505o(33303);
            return true;
        }
    }
}
