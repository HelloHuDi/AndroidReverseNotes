package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p181af.C32221i;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C37810vb;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.p842bp.C25985d.C25987a;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.wallet.C30158b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.o */
public final class C40819o {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.o$b */
    public static class C7345b extends C5378c {
        private C46650a yJI;

        public final boolean dHk() {
            return false;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z || i != 419430449) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(32987);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969056);
                view.setTag(new C36227a().mo57098eZ(view));
            }
            AppMethodBeat.m2505o(32987);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            C8910b X;
            AppMethodBeat.m2504i(32988);
            this.yJI = c46650a;
            C36227a c36227a = (C36227a) c5379a;
            String str2 = c7620bi.field_content;
            if (str2 != null) {
                X = C8910b.m16058X(str2, c7620bi.field_reserved);
            } else {
                X = null;
            }
            if (X != null) {
                C5379a.m8170an(c36227a.jPL, c36227a.zcJ);
                c36227a.jPL.setBackgroundResource(C25738R.drawable.f6493fz);
                c36227a.jPL.setPadding(C1338a.fromDPToPix(C4996ah.getContext(), 13), 0, c46650a.yTx.getContext().getResources().getDimensionPixelOffset(C25738R.dimen.f10279wn), 0);
                c36227a.zec.setSingleLine(true);
                C37810vb c37810vb = new C37810vb();
                c37810vb.cRW.cEa = X.fhy;
                C4879a.xxA.mo10055m(c37810vb);
                boolean z = !c37810vb.cRX.cRY;
                if (c37810vb.cRX.status == -2) {
                    z = false;
                }
                int i2 = c37810vb.cRX.status;
                if (i2 <= 0) {
                    i2 = X.fhv;
                }
                CharSequence charSequence;
                switch (i2) {
                    case 1:
                    case 7:
                        C32221i c32221i = (C32221i) X.mo20333X(C32221i.class);
                        if (!C42252ah.isNullOrNil(X.fiF)) {
                            if (C5046bo.m7563gW(c32221i.fgg, 1)) {
                                if (X.fiF.length() > 5) {
                                    charSequence = X.fiF.substring(0, 5) + "..." + C4996ah.getContext().getString(C25738R.string.alm);
                                } else {
                                    charSequence = X.fiF + c46650a.yTx.getContext().getString(C25738R.string.alm);
                                }
                                charSequence = C44089j.m79292b(c46650a.yTx.getContext(), charSequence);
                            } else {
                                charSequence = C44089j.m79292b(c46650a.yTx.getContext(), X.fiF);
                            }
                            c36227a.zec.setText(charSequence);
                        } else if (C5046bo.m7563gW(c32221i.fgg, 1)) {
                            c36227a.zec.setText(C4996ah.getContext().getString(C25738R.string.all) + C4996ah.getContext().getString(C25738R.string.alm));
                        } else {
                            c36227a.zec.setText(C25738R.string.all);
                        }
                        c36227a.zed.setText(X.fhw);
                        c36227a.zeb.setImageResource(C1318a.c2c_remittance_icon);
                        break;
                    case 3:
                        if (z) {
                            if (C5046bo.m7563gW(((C32221i) X.mo20333X(C32221i.class)).fgg, 1)) {
                                if (C42252ah.isNullOrNil(X.fiF)) {
                                    charSequence = C4996ah.getContext().getString(C25738R.string.alb) + C4996ah.getContext().getString(C25738R.string.alm);
                                } else {
                                    charSequence = C4996ah.getContext().getString(C25738R.string.alb) + "-" + X.fiF;
                                    if (charSequence.length() > 5) {
                                        charSequence = charSequence.substring(0, 5) + "..." + C4996ah.getContext().getString(C25738R.string.alm);
                                    }
                                }
                            } else if (C42252ah.isNullOrNil(X.fiF)) {
                                charSequence = C4996ah.getContext().getString(C25738R.string.alb);
                            } else {
                                charSequence = C4996ah.getContext().getString(C25738R.string.alb) + "-" + X.fiF;
                            }
                            c36227a.zec.setText(C44089j.m79292b(c46650a.yTx.getContext(), charSequence));
                        } else {
                            c36227a.zec.setText(C25738R.string.alc);
                        }
                        c36227a.zed.setText(X.fhw);
                        c36227a.zeb.setImageResource(C1318a.c2c_remittance_received_icon);
                        C7345b.m12503a(c36227a);
                        break;
                    case 4:
                        c36227a.zed.setText(X.fhw);
                        c36227a.zeb.setImageResource(C1318a.c2c_remittance_rejected_icon);
                        if (z) {
                            if (C42252ah.isNullOrNil(X.fiF)) {
                                charSequence = C4996ah.getContext().getString(C25738R.string.alo);
                            } else {
                                charSequence = C4996ah.getContext().getString(C25738R.string.alo) + "-" + X.fiF;
                            }
                            c36227a.zec.setText(C44089j.m79292b(c46650a.yTx.getContext(), charSequence));
                        } else {
                            c36227a.zec.setText(C25738R.string.aln);
                        }
                        C7345b.m12503a(c36227a);
                        break;
                    case 5:
                        c36227a.zed.setText(X.fhw);
                        c36227a.zeb.setImageResource(C1318a.c2c_remittance_received_icon);
                        if (z) {
                            if (C42252ah.isNullOrNil(X.fiF)) {
                                charSequence = C4996ah.getContext().getString(C25738R.string.ali);
                            } else {
                                charSequence = C4996ah.getContext().getString(C25738R.string.ali) + "-" + X.fiF;
                            }
                            c36227a.zec.setText(C44089j.m79292b(c46650a.yTx.getContext(), charSequence));
                        } else {
                            c36227a.zec.setText(C25738R.string.alj);
                        }
                        C7345b.m12503a(c36227a);
                        break;
                    case 6:
                        c36227a.zec.setText(C25738R.string.ald);
                        c36227a.zed.setText(X.fhw);
                        c36227a.zeb.setImageResource(C1318a.c2c_remittance_cancle_icon);
                        C7345b.m12503a(c36227a);
                        break;
                    default:
                        c36227a.zeb.setImageResource(C1318a.c2c_remittance_icon);
                        c36227a.zec.setSingleLine(false);
                        c36227a.zec.setMaxLines(2);
                        c36227a.zed.setText(null);
                        c36227a.zec.setText(X.description);
                        break;
                }
                c36227a.jPL.setOnClickListener(mo11022d(c46650a));
                c36227a.jPL.setOnLongClickListener(mo11021c(c46650a));
                c36227a.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
                c36227a.jPL.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, null, 0));
            }
            AppMethodBeat.m2505o(32988);
        }

        /* renamed from: a */
        private static void m12503a(C36227a c36227a) {
            AppMethodBeat.m2504i(32989);
            int paddingLeft = c36227a.jPL.getPaddingLeft();
            int paddingTop = c36227a.jPL.getPaddingTop();
            int paddingRight = c36227a.jPL.getPaddingRight();
            int paddingBottom = c36227a.jPL.getPaddingBottom();
            c36227a.jPL.setBackgroundResource(C25738R.drawable.f6494g0);
            c36227a.jPL.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            AppMethodBeat.m2505o(32989);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32990);
            int i = ((C40814ay) view.getTag()).position;
            if (c7620bi != null) {
                contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
            }
            AppMethodBeat.m2505o(32990);
            return false;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32991);
            menuItem.getItemId();
            AppMethodBeat.m2505o(32991);
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32992);
            String str = c7620bi.field_content;
            C8910b c8910b = null;
            if (str != null) {
                c8910b = C8910b.m16058X(str, c7620bi.field_reserved);
            }
            if (c8910b != null) {
                Intent intent = new Intent();
                intent.putExtra("sender_name", c7620bi.field_talker);
                switch (c8910b.fhv) {
                    case 1:
                    case 7:
                        intent.putExtra("invalid_time", c8910b.fhz);
                        intent.putExtra("is_sender", false);
                        intent.putExtra("appmsg_type", c8910b.fhv);
                        intent.putExtra("transfer_id", c8910b.fhy);
                        intent.putExtra(C8741b.TRANSACTION_ID, c8910b.fhx);
                        intent.putExtra("effective_date", c8910b.fhA);
                        intent.putExtra("total_fee", c8910b.cKu);
                        intent.putExtra("fee_type", c8910b.cuZ);
                        if (!C1853r.m3831YM()) {
                            C25985d.m41458a(c46650a.yTx, "remittance", ".ui.RemittanceDetailUI", intent, 221);
                            break;
                        }
                        C25985d.m41458a(c46650a.yTx, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", intent, 221);
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        intent.putExtra("is_sender", true);
                        intent.putExtra("appmsg_type", c8910b.fhv);
                        intent.putExtra("transfer_id", c8910b.fhy);
                        intent.putExtra(C8741b.TRANSACTION_ID, c8910b.fhx);
                        intent.putExtra("effective_date", c8910b.fhA);
                        intent.putExtra("total_fee", c8910b.cKu);
                        intent.putExtra("fee_type", c8910b.cuZ);
                        if (!C1853r.m3831YM()) {
                            C25985d.m41467b(c46650a.yTx.getContext(), "remittance", ".ui.RemittanceDetailUI", intent);
                            break;
                        }
                        C25985d.m41467b(c46650a.yTx.getContext(), "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", intent);
                        break;
                    default:
                        C4990ab.m7421w("MicroMsg.ChattingItemAppMsgRemittanceFrom", "Unrecognized type %d, probably version to low & check update!", Integer.valueOf(c8910b.fhv));
                        C42252ah.m74616cw(c46650a.yTx.getContext());
                        break;
                }
                AppMethodBeat.m2505o(32992);
                return true;
            }
            AppMethodBeat.m2505o(32992);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.o$c */
    public static class C7346c extends C5378c {
        private C46650a yJI;

        public final boolean dHk() {
            return true;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z && i == 419430449) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(32994);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969093);
                view.setTag(new C36227a().mo57098eZ(view));
            }
            AppMethodBeat.m2505o(32994);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            C8910b X;
            AppMethodBeat.m2504i(32995);
            this.yJI = c46650a;
            C36227a c36227a = (C36227a) c5379a;
            String str2 = c7620bi.field_content;
            if (str2 != null) {
                X = C8910b.m16058X(str2, c7620bi.field_reserved);
            } else {
                X = null;
            }
            if (X != null) {
                C5379a.m8170an(c36227a.jPL, c36227a.zcJ);
                c36227a.jPL.setBackgroundResource(C25738R.drawable.f6495g1);
                c36227a.jPL.setPadding(c46650a.yTx.getContext().getResources().getDimensionPixelSize(C25738R.dimen.f9966lo), 0, C1338a.fromDPToPix(c46650a.yTx.getContext(), 13), 0);
                c36227a.zec.setSingleLine(true);
                C37810vb c37810vb = new C37810vb();
                c37810vb.cRW.cEa = X.fhy;
                C4879a.xxA.mo10055m(c37810vb);
                boolean z = c37810vb.cRX.cRY;
                if (c37810vb.cRX.status == -2) {
                    z = false;
                }
                int i2 = c37810vb.cRX.status;
                if (i2 <= 0) {
                    i2 = X.fhv;
                }
                CharSequence charSequence;
                switch (i2) {
                    case 1:
                    case 7:
                        C9638aw.m17190ZK();
                        C7616ad aoN = C18628c.m29078XM().aoN(c7620bi.field_talker);
                        if (aoN != null) {
                            str2 = aoN.mo16707Oj();
                        } else {
                            str2 = c7620bi.field_talker;
                        }
                        if (C42252ah.isNullOrNil(X.fiF)) {
                            c36227a.zec.setText(C44089j.m79293b(c46650a.yTx.getContext(), c46650a.yTx.getMMResources().getString(C25738R.string.alk, new Object[]{C42252ah.nullAsNil(str2)}), c36227a.zec.getTextSize()));
                        } else {
                            c36227a.zec.setText(C44089j.m79292b(c46650a.yTx.getContext(), X.fiF));
                        }
                        C32221i c32221i = (C32221i) X.mo20333X(C32221i.class);
                        if (C42252ah.isNullOrNil(X.fiF)) {
                            str2 = c46650a.yTx.getMMResources().getString(C25738R.string.alk, new Object[]{C42252ah.nullAsNil(str2)});
                            if (!C5046bo.m7563gW(c32221i.fgg, 1)) {
                                Object charSequence2 = str2;
                            } else if (str2.length() > 5) {
                                charSequence2 = str2.substring(0, 5) + "..." + C4996ah.getContext().getString(C25738R.string.alm);
                            } else {
                                charSequence2 = str2 + C4996ah.getContext().getString(C25738R.string.alm);
                            }
                            c36227a.zec.setText(C44089j.m79293b(c46650a.yTx.getContext(), charSequence2, c36227a.zec.getTextSize()));
                        } else {
                            if (C5046bo.m7563gW(c32221i.fgg, 1)) {
                                if (X.fiF.length() > 5) {
                                    charSequence2 = X.fiF.substring(0, 5) + "..." + C4996ah.getContext().getString(C25738R.string.alm);
                                } else {
                                    charSequence2 = X.fiF + c46650a.yTx.getContext().getString(C25738R.string.alm);
                                }
                                charSequence2 = C44089j.m79292b(c46650a.yTx.getContext(), charSequence2);
                            } else {
                                charSequence2 = C44089j.m79292b(c46650a.yTx.getContext(), X.fiF);
                            }
                            c36227a.zec.setText(charSequence2);
                        }
                        c36227a.zed.setText(X.fhw);
                        c36227a.zeb.setImageResource(C1318a.c2c_remittance_icon);
                        break;
                    case 3:
                        if (z) {
                            if (C5046bo.m7563gW(((C32221i) X.mo20333X(C32221i.class)).fgg, 1)) {
                                if (C42252ah.isNullOrNil(X.fiF)) {
                                    charSequence2 = C4996ah.getContext().getString(C25738R.string.alb) + C4996ah.getContext().getString(C25738R.string.alm);
                                } else {
                                    charSequence2 = C4996ah.getContext().getString(C25738R.string.alb) + "-" + X.fiF;
                                    if (charSequence2.length() > 5) {
                                        charSequence2 = charSequence2.substring(0, 5) + "..." + C4996ah.getContext().getString(C25738R.string.alm);
                                    }
                                }
                            } else if (C42252ah.isNullOrNil(X.fiF)) {
                                charSequence2 = C4996ah.getContext().getString(C25738R.string.alb);
                            } else {
                                charSequence2 = C4996ah.getContext().getString(C25738R.string.alb) + "-" + X.fiF;
                            }
                            c36227a.zec.setText(C44089j.m79292b(c46650a.yTx.getContext(), charSequence2));
                        } else {
                            c36227a.zec.setText(C25738R.string.alc);
                        }
                        c36227a.zed.setText(X.fhw);
                        c36227a.zeb.setImageResource(C1318a.c2c_remittance_received_icon);
                        C7346c.m12510a(c36227a);
                        break;
                    case 4:
                        c36227a.zed.setText(X.fhw);
                        c36227a.zeb.setImageResource(C1318a.c2c_remittance_rejected_icon);
                        if (z) {
                            if (C42252ah.isNullOrNil(X.fiF)) {
                                charSequence2 = C4996ah.getContext().getString(C25738R.string.alo);
                            } else {
                                charSequence2 = C4996ah.getContext().getString(C25738R.string.alo) + "-" + X.fiF;
                            }
                            c36227a.zec.setText(C44089j.m79292b(c46650a.yTx.getContext(), charSequence2));
                        } else {
                            c36227a.zec.setText(C25738R.string.aln);
                        }
                        C7346c.m12510a(c36227a);
                        break;
                    case 5:
                        if (z) {
                            if (C42252ah.isNullOrNil(X.fiF)) {
                                charSequence2 = C4996ah.getContext().getString(C25738R.string.ali);
                            } else {
                                charSequence2 = C4996ah.getContext().getString(C25738R.string.ali) + "-" + X.fiF;
                            }
                            c36227a.zec.setText(C44089j.m79292b(c46650a.yTx.getContext(), charSequence2));
                        } else {
                            c36227a.zec.setText(C25738R.string.alj);
                        }
                        c36227a.zed.setText(X.fhw);
                        c36227a.zeb.setImageResource(C1318a.c2c_remittance_received_icon);
                        C7346c.m12510a(c36227a);
                        break;
                    case 6:
                        c36227a.zec.setText(C25738R.string.ald);
                        c36227a.zed.setText(X.fhw);
                        c36227a.zeb.setImageResource(C1318a.c2c_remittance_cancle_icon);
                        C7346c.m12510a(c36227a);
                        break;
                    default:
                        c36227a.zeb.setImageResource(C1318a.c2c_remittance_icon);
                        c36227a.zec.setSingleLine(false);
                        c36227a.zec.setMaxLines(2);
                        c36227a.zed.setText(null);
                        c36227a.zec.setText(X.description);
                        break;
                }
                c36227a.jPL.setOnClickListener(mo11022d(c46650a));
                c36227a.jPL.setOnLongClickListener(mo11021c(c46650a));
                c36227a.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
                c36227a.jPL.setTag(new C40814ay(c7620bi, this.yJI.dFx(), i, null, 0));
            }
            AppMethodBeat.m2505o(32995);
        }

        /* renamed from: a */
        private static void m12510a(C36227a c36227a) {
            AppMethodBeat.m2504i(32996);
            int paddingLeft = c36227a.jPL.getPaddingLeft();
            int paddingTop = c36227a.jPL.getPaddingTop();
            int paddingRight = c36227a.jPL.getPaddingRight();
            int paddingBottom = c36227a.jPL.getPaddingBottom();
            c36227a.jPL.setBackgroundResource(C25738R.drawable.f6496g2);
            c36227a.jPL.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            AppMethodBeat.m2505o(32996);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32997);
            int i = ((C40814ay) view.getTag()).position;
            String str = c7620bi.field_content;
            C8910b c8910b = null;
            if (str != null) {
                c8910b = C8910b.m16058X(str, c7620bi.field_reserved);
            }
            if (c8910b != null) {
                contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
            }
            AppMethodBeat.m2505o(32997);
            return false;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, final C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32998);
            String str = c7620bi.field_content;
            C8910b c8910b = null;
            if (str != null) {
                c8910b = C8910b.m16058X(str, c7620bi.field_reserved);
            }
            if (c8910b != null) {
                Intent intent = new Intent();
                intent.putExtra("sender_name", c7620bi.field_talker);
                switch (c8910b.fhv) {
                    case 1:
                    case 7:
                        intent.putExtra("invalid_time", c8910b.fhz);
                        intent.putExtra("is_sender", true);
                        intent.putExtra("appmsg_type", c8910b.fhv);
                        intent.putExtra("transfer_id", c8910b.fhy);
                        intent.putExtra(C8741b.TRANSACTION_ID, c8910b.fhx);
                        intent.putExtra("effective_date", c8910b.fhA);
                        intent.putExtra("total_fee", c8910b.cKu);
                        intent.putExtra("fee_type", c8910b.cuZ);
                        C25987a c73471 = new C25987a() {
                            public final void onActivityResult(int i, int i2, Intent intent) {
                                AppMethodBeat.m2504i(32993);
                                if (i != 221) {
                                    AppMethodBeat.m2505o(32993);
                                } else if (intent == null) {
                                    AppMethodBeat.m2505o(32993);
                                } else {
                                    String stringExtra = intent.getStringExtra("result_msg");
                                    if (!C5046bo.isNullOrNil(stringExtra)) {
                                        C30379h.m48461b(c46650a.yTx.getContext(), stringExtra, "", false);
                                    }
                                    AppMethodBeat.m2505o(32993);
                                }
                            }
                        };
                        if (!C1853r.m3831YM()) {
                            C25985d.m41459a(c46650a.yTv, "remittance", ".ui.RemittanceDetailUI", intent, 221, c73471);
                            break;
                        }
                        C25985d.m41459a(c46650a.yTv, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", intent, 221, c73471);
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        intent.putExtra("appmsg_type", c8910b.fhv);
                        intent.putExtra("transfer_id", c8910b.fhy);
                        intent.putExtra(C8741b.TRANSACTION_ID, c8910b.fhx);
                        intent.putExtra("effective_date", c8910b.fhA);
                        intent.putExtra("total_fee", c8910b.cKu);
                        intent.putExtra("fee_type", c8910b.cuZ);
                        if (!C1853r.m3831YM()) {
                            C25985d.m41467b(c46650a.yTx.getContext(), "remittance", ".ui.RemittanceDetailUI", intent);
                            break;
                        }
                        C25985d.m41467b(c46650a.yTx.getContext(), "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", intent);
                        break;
                    default:
                        C4990ab.m7421w("MicroMsg.ChattingItemAppMsgRemittanceTo", "Unrecognized type %d, probably version to low & check update!", Integer.valueOf(c8910b.fhv));
                        C42252ah.m74616cw(c46650a.yTx.getContext());
                        break;
                }
                AppMethodBeat.m2505o(32998);
                return true;
            }
            AppMethodBeat.m2505o(32998);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.o$a */
    static class C36227a extends C5379a {
        public int zcJ = 0;
        public ImageView zeb;
        public TextView zec;
        public TextView zed;

        C36227a() {
        }

        /* renamed from: eZ */
        public final C36227a mo57098eZ(View view) {
            AppMethodBeat.m2504i(32986);
            super.mo11031eP(view);
            this.enf = (TextView) this.mRR.findViewById(2131820587);
            this.moo = (CheckBox) this.mRR.findViewById(2131820580);
            this.iVh = this.mRR.findViewById(2131820586);
            this.qkY = (TextView) this.mRR.findViewById(2131821102);
            this.zeb = (ImageView) this.mRR.findViewById(2131822585);
            this.zec = (TextView) this.mRR.findViewById(2131822587);
            this.zed = (TextView) this.mRR.findViewById(2131822586);
            this.zcJ = C5378c.m8145hV(C4996ah.getContext());
            this.zed.setTypeface(((C30158b) C1720g.m3528K(C30158b.class)).mo48438ex(this.mRR.getContext()));
            AppMethodBeat.m2505o(32986);
            return this;
        }
    }
}
