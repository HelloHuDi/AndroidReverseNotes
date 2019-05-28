package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.i;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.vb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.h;

public final class o {

    public static class b extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;

        public final boolean dHk() {
            return false;
        }

        public final boolean aH(int i, boolean z) {
            if (z || i != 419430449) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(32987);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.m_);
                view.setTag(new a().eZ(view));
            }
            AppMethodBeat.o(32987);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            com.tencent.mm.af.j.b X;
            AppMethodBeat.i(32988);
            this.yJI = aVar2;
            a aVar3 = (a) aVar;
            String str2 = biVar.field_content;
            if (str2 != null) {
                X = com.tencent.mm.af.j.b.X(str2, biVar.field_reserved);
            } else {
                X = null;
            }
            if (X != null) {
                com.tencent.mm.ui.chatting.viewitems.c.a.an(aVar3.jPL, aVar3.zcJ);
                aVar3.jPL.setBackgroundResource(R.drawable.fz);
                aVar3.jPL.setPadding(com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 13), 0, aVar2.yTx.getContext().getResources().getDimensionPixelOffset(R.dimen.wn), 0);
                aVar3.zec.setSingleLine(true);
                vb vbVar = new vb();
                vbVar.cRW.cEa = X.fhy;
                com.tencent.mm.sdk.b.a.xxA.m(vbVar);
                boolean z = !vbVar.cRX.cRY;
                if (vbVar.cRX.status == -2) {
                    z = false;
                }
                int i2 = vbVar.cRX.status;
                if (i2 <= 0) {
                    i2 = X.fhv;
                }
                CharSequence charSequence;
                switch (i2) {
                    case 1:
                    case 7:
                        i iVar = (i) X.X(i.class);
                        if (!com.tencent.mm.platformtools.ah.isNullOrNil(X.fiF)) {
                            if (bo.gW(iVar.fgg, 1)) {
                                if (X.fiF.length() > 5) {
                                    charSequence = X.fiF.substring(0, 5) + "..." + ah.getContext().getString(R.string.alm);
                                } else {
                                    charSequence = X.fiF + aVar2.yTx.getContext().getString(R.string.alm);
                                }
                                charSequence = j.b(aVar2.yTx.getContext(), charSequence);
                            } else {
                                charSequence = j.b(aVar2.yTx.getContext(), X.fiF);
                            }
                            aVar3.zec.setText(charSequence);
                        } else if (bo.gW(iVar.fgg, 1)) {
                            aVar3.zec.setText(ah.getContext().getString(R.string.all) + ah.getContext().getString(R.string.alm));
                        } else {
                            aVar3.zec.setText(R.string.all);
                        }
                        aVar3.zed.setText(X.fhw);
                        aVar3.zeb.setImageResource(R.raw.c2c_remittance_icon);
                        break;
                    case 3:
                        if (z) {
                            if (bo.gW(((i) X.X(i.class)).fgg, 1)) {
                                if (com.tencent.mm.platformtools.ah.isNullOrNil(X.fiF)) {
                                    charSequence = ah.getContext().getString(R.string.alb) + ah.getContext().getString(R.string.alm);
                                } else {
                                    charSequence = ah.getContext().getString(R.string.alb) + "-" + X.fiF;
                                    if (charSequence.length() > 5) {
                                        charSequence = charSequence.substring(0, 5) + "..." + ah.getContext().getString(R.string.alm);
                                    }
                                }
                            } else if (com.tencent.mm.platformtools.ah.isNullOrNil(X.fiF)) {
                                charSequence = ah.getContext().getString(R.string.alb);
                            } else {
                                charSequence = ah.getContext().getString(R.string.alb) + "-" + X.fiF;
                            }
                            aVar3.zec.setText(j.b(aVar2.yTx.getContext(), charSequence));
                        } else {
                            aVar3.zec.setText(R.string.alc);
                        }
                        aVar3.zed.setText(X.fhw);
                        aVar3.zeb.setImageResource(R.raw.c2c_remittance_received_icon);
                        a(aVar3);
                        break;
                    case 4:
                        aVar3.zed.setText(X.fhw);
                        aVar3.zeb.setImageResource(R.raw.c2c_remittance_rejected_icon);
                        if (z) {
                            if (com.tencent.mm.platformtools.ah.isNullOrNil(X.fiF)) {
                                charSequence = ah.getContext().getString(R.string.alo);
                            } else {
                                charSequence = ah.getContext().getString(R.string.alo) + "-" + X.fiF;
                            }
                            aVar3.zec.setText(j.b(aVar2.yTx.getContext(), charSequence));
                        } else {
                            aVar3.zec.setText(R.string.aln);
                        }
                        a(aVar3);
                        break;
                    case 5:
                        aVar3.zed.setText(X.fhw);
                        aVar3.zeb.setImageResource(R.raw.c2c_remittance_received_icon);
                        if (z) {
                            if (com.tencent.mm.platformtools.ah.isNullOrNil(X.fiF)) {
                                charSequence = ah.getContext().getString(R.string.ali);
                            } else {
                                charSequence = ah.getContext().getString(R.string.ali) + "-" + X.fiF;
                            }
                            aVar3.zec.setText(j.b(aVar2.yTx.getContext(), charSequence));
                        } else {
                            aVar3.zec.setText(R.string.alj);
                        }
                        a(aVar3);
                        break;
                    case 6:
                        aVar3.zec.setText(R.string.ald);
                        aVar3.zed.setText(X.fhw);
                        aVar3.zeb.setImageResource(R.raw.c2c_remittance_cancle_icon);
                        a(aVar3);
                        break;
                    default:
                        aVar3.zeb.setImageResource(R.raw.c2c_remittance_icon);
                        aVar3.zec.setSingleLine(false);
                        aVar3.zec.setMaxLines(2);
                        aVar3.zed.setText(null);
                        aVar3.zec.setText(X.description);
                        break;
                }
                aVar3.jPL.setOnClickListener(d(aVar2));
                aVar3.jPL.setOnLongClickListener(c(aVar2));
                aVar3.jPL.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
                aVar3.jPL.setTag(new ay(biVar, aVar2.dFx(), i, null, 0));
            }
            AppMethodBeat.o(32988);
        }

        private static void a(a aVar) {
            AppMethodBeat.i(32989);
            int paddingLeft = aVar.jPL.getPaddingLeft();
            int paddingTop = aVar.jPL.getPaddingTop();
            int paddingRight = aVar.jPL.getPaddingRight();
            int paddingBottom = aVar.jPL.getPaddingBottom();
            aVar.jPL.setBackgroundResource(R.drawable.g0);
            aVar.jPL.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            AppMethodBeat.o(32989);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(32990);
            int i = ((ay) view.getTag()).position;
            if (biVar != null) {
                contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
            }
            AppMethodBeat.o(32990);
            return false;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32991);
            menuItem.getItemId();
            AppMethodBeat.o(32991);
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32992);
            String str = biVar.field_content;
            com.tencent.mm.af.j.b bVar = null;
            if (str != null) {
                bVar = com.tencent.mm.af.j.b.X(str, biVar.field_reserved);
            }
            if (bVar != null) {
                Intent intent = new Intent();
                intent.putExtra("sender_name", biVar.field_talker);
                switch (bVar.fhv) {
                    case 1:
                    case 7:
                        intent.putExtra("invalid_time", bVar.fhz);
                        intent.putExtra("is_sender", false);
                        intent.putExtra("appmsg_type", bVar.fhv);
                        intent.putExtra("transfer_id", bVar.fhy);
                        intent.putExtra(com.google.firebase.analytics.FirebaseAnalytics.b.TRANSACTION_ID, bVar.fhx);
                        intent.putExtra("effective_date", bVar.fhA);
                        intent.putExtra("total_fee", bVar.cKu);
                        intent.putExtra("fee_type", bVar.cuZ);
                        if (!r.YM()) {
                            d.a(aVar.yTx, "remittance", ".ui.RemittanceDetailUI", intent, 221);
                            break;
                        }
                        d.a(aVar.yTx, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", intent, 221);
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        intent.putExtra("is_sender", true);
                        intent.putExtra("appmsg_type", bVar.fhv);
                        intent.putExtra("transfer_id", bVar.fhy);
                        intent.putExtra(com.google.firebase.analytics.FirebaseAnalytics.b.TRANSACTION_ID, bVar.fhx);
                        intent.putExtra("effective_date", bVar.fhA);
                        intent.putExtra("total_fee", bVar.cKu);
                        intent.putExtra("fee_type", bVar.cuZ);
                        if (!r.YM()) {
                            d.b(aVar.yTx.getContext(), "remittance", ".ui.RemittanceDetailUI", intent);
                            break;
                        }
                        d.b(aVar.yTx.getContext(), "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", intent);
                        break;
                    default:
                        ab.w("MicroMsg.ChattingItemAppMsgRemittanceFrom", "Unrecognized type %d, probably version to low & check update!", Integer.valueOf(bVar.fhv));
                        com.tencent.mm.platformtools.ah.cw(aVar.yTx.getContext());
                        break;
                }
                AppMethodBeat.o(32992);
                return true;
            }
            AppMethodBeat.o(32992);
            return false;
        }
    }

    public static class c extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;

        public final boolean dHk() {
            return true;
        }

        public final boolean aH(int i, boolean z) {
            if (z && i == 419430449) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(32994);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.n9);
                view.setTag(new a().eZ(view));
            }
            AppMethodBeat.o(32994);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            com.tencent.mm.af.j.b X;
            AppMethodBeat.i(32995);
            this.yJI = aVar2;
            a aVar3 = (a) aVar;
            String str2 = biVar.field_content;
            if (str2 != null) {
                X = com.tencent.mm.af.j.b.X(str2, biVar.field_reserved);
            } else {
                X = null;
            }
            if (X != null) {
                com.tencent.mm.ui.chatting.viewitems.c.a.an(aVar3.jPL, aVar3.zcJ);
                aVar3.jPL.setBackgroundResource(R.drawable.g1);
                aVar3.jPL.setPadding(aVar2.yTx.getContext().getResources().getDimensionPixelSize(R.dimen.lo), 0, com.tencent.mm.bz.a.fromDPToPix(aVar2.yTx.getContext(), 13), 0);
                aVar3.zec.setSingleLine(true);
                vb vbVar = new vb();
                vbVar.cRW.cEa = X.fhy;
                com.tencent.mm.sdk.b.a.xxA.m(vbVar);
                boolean z = vbVar.cRX.cRY;
                if (vbVar.cRX.status == -2) {
                    z = false;
                }
                int i2 = vbVar.cRX.status;
                if (i2 <= 0) {
                    i2 = X.fhv;
                }
                CharSequence charSequence;
                switch (i2) {
                    case 1:
                    case 7:
                        aw.ZK();
                        ad aoN = com.tencent.mm.model.c.XM().aoN(biVar.field_talker);
                        if (aoN != null) {
                            str2 = aoN.Oj();
                        } else {
                            str2 = biVar.field_talker;
                        }
                        if (com.tencent.mm.platformtools.ah.isNullOrNil(X.fiF)) {
                            aVar3.zec.setText(j.b(aVar2.yTx.getContext(), aVar2.yTx.getMMResources().getString(R.string.alk, new Object[]{com.tencent.mm.platformtools.ah.nullAsNil(str2)}), aVar3.zec.getTextSize()));
                        } else {
                            aVar3.zec.setText(j.b(aVar2.yTx.getContext(), X.fiF));
                        }
                        i iVar = (i) X.X(i.class);
                        if (com.tencent.mm.platformtools.ah.isNullOrNil(X.fiF)) {
                            str2 = aVar2.yTx.getMMResources().getString(R.string.alk, new Object[]{com.tencent.mm.platformtools.ah.nullAsNil(str2)});
                            if (!bo.gW(iVar.fgg, 1)) {
                                Object charSequence2 = str2;
                            } else if (str2.length() > 5) {
                                charSequence2 = str2.substring(0, 5) + "..." + ah.getContext().getString(R.string.alm);
                            } else {
                                charSequence2 = str2 + ah.getContext().getString(R.string.alm);
                            }
                            aVar3.zec.setText(j.b(aVar2.yTx.getContext(), charSequence2, aVar3.zec.getTextSize()));
                        } else {
                            if (bo.gW(iVar.fgg, 1)) {
                                if (X.fiF.length() > 5) {
                                    charSequence2 = X.fiF.substring(0, 5) + "..." + ah.getContext().getString(R.string.alm);
                                } else {
                                    charSequence2 = X.fiF + aVar2.yTx.getContext().getString(R.string.alm);
                                }
                                charSequence2 = j.b(aVar2.yTx.getContext(), charSequence2);
                            } else {
                                charSequence2 = j.b(aVar2.yTx.getContext(), X.fiF);
                            }
                            aVar3.zec.setText(charSequence2);
                        }
                        aVar3.zed.setText(X.fhw);
                        aVar3.zeb.setImageResource(R.raw.c2c_remittance_icon);
                        break;
                    case 3:
                        if (z) {
                            if (bo.gW(((i) X.X(i.class)).fgg, 1)) {
                                if (com.tencent.mm.platformtools.ah.isNullOrNil(X.fiF)) {
                                    charSequence2 = ah.getContext().getString(R.string.alb) + ah.getContext().getString(R.string.alm);
                                } else {
                                    charSequence2 = ah.getContext().getString(R.string.alb) + "-" + X.fiF;
                                    if (charSequence2.length() > 5) {
                                        charSequence2 = charSequence2.substring(0, 5) + "..." + ah.getContext().getString(R.string.alm);
                                    }
                                }
                            } else if (com.tencent.mm.platformtools.ah.isNullOrNil(X.fiF)) {
                                charSequence2 = ah.getContext().getString(R.string.alb);
                            } else {
                                charSequence2 = ah.getContext().getString(R.string.alb) + "-" + X.fiF;
                            }
                            aVar3.zec.setText(j.b(aVar2.yTx.getContext(), charSequence2));
                        } else {
                            aVar3.zec.setText(R.string.alc);
                        }
                        aVar3.zed.setText(X.fhw);
                        aVar3.zeb.setImageResource(R.raw.c2c_remittance_received_icon);
                        a(aVar3);
                        break;
                    case 4:
                        aVar3.zed.setText(X.fhw);
                        aVar3.zeb.setImageResource(R.raw.c2c_remittance_rejected_icon);
                        if (z) {
                            if (com.tencent.mm.platformtools.ah.isNullOrNil(X.fiF)) {
                                charSequence2 = ah.getContext().getString(R.string.alo);
                            } else {
                                charSequence2 = ah.getContext().getString(R.string.alo) + "-" + X.fiF;
                            }
                            aVar3.zec.setText(j.b(aVar2.yTx.getContext(), charSequence2));
                        } else {
                            aVar3.zec.setText(R.string.aln);
                        }
                        a(aVar3);
                        break;
                    case 5:
                        if (z) {
                            if (com.tencent.mm.platformtools.ah.isNullOrNil(X.fiF)) {
                                charSequence2 = ah.getContext().getString(R.string.ali);
                            } else {
                                charSequence2 = ah.getContext().getString(R.string.ali) + "-" + X.fiF;
                            }
                            aVar3.zec.setText(j.b(aVar2.yTx.getContext(), charSequence2));
                        } else {
                            aVar3.zec.setText(R.string.alj);
                        }
                        aVar3.zed.setText(X.fhw);
                        aVar3.zeb.setImageResource(R.raw.c2c_remittance_received_icon);
                        a(aVar3);
                        break;
                    case 6:
                        aVar3.zec.setText(R.string.ald);
                        aVar3.zed.setText(X.fhw);
                        aVar3.zeb.setImageResource(R.raw.c2c_remittance_cancle_icon);
                        a(aVar3);
                        break;
                    default:
                        aVar3.zeb.setImageResource(R.raw.c2c_remittance_icon);
                        aVar3.zec.setSingleLine(false);
                        aVar3.zec.setMaxLines(2);
                        aVar3.zed.setText(null);
                        aVar3.zec.setText(X.description);
                        break;
                }
                aVar3.jPL.setOnClickListener(d(aVar2));
                aVar3.jPL.setOnLongClickListener(c(aVar2));
                aVar3.jPL.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
                aVar3.jPL.setTag(new ay(biVar, this.yJI.dFx(), i, null, 0));
            }
            AppMethodBeat.o(32995);
        }

        private static void a(a aVar) {
            AppMethodBeat.i(32996);
            int paddingLeft = aVar.jPL.getPaddingLeft();
            int paddingTop = aVar.jPL.getPaddingTop();
            int paddingRight = aVar.jPL.getPaddingRight();
            int paddingBottom = aVar.jPL.getPaddingBottom();
            aVar.jPL.setBackgroundResource(R.drawable.g2);
            aVar.jPL.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            AppMethodBeat.o(32996);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(32997);
            int i = ((ay) view.getTag()).position;
            String str = biVar.field_content;
            com.tencent.mm.af.j.b bVar = null;
            if (str != null) {
                bVar = com.tencent.mm.af.j.b.X(str, biVar.field_reserved);
            }
            if (bVar != null) {
                contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
            }
            AppMethodBeat.o(32997);
            return false;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }

        public final boolean b(View view, final com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32998);
            String str = biVar.field_content;
            com.tencent.mm.af.j.b bVar = null;
            if (str != null) {
                bVar = com.tencent.mm.af.j.b.X(str, biVar.field_reserved);
            }
            if (bVar != null) {
                Intent intent = new Intent();
                intent.putExtra("sender_name", biVar.field_talker);
                switch (bVar.fhv) {
                    case 1:
                    case 7:
                        intent.putExtra("invalid_time", bVar.fhz);
                        intent.putExtra("is_sender", true);
                        intent.putExtra("appmsg_type", bVar.fhv);
                        intent.putExtra("transfer_id", bVar.fhy);
                        intent.putExtra(com.google.firebase.analytics.FirebaseAnalytics.b.TRANSACTION_ID, bVar.fhx);
                        intent.putExtra("effective_date", bVar.fhA);
                        intent.putExtra("total_fee", bVar.cKu);
                        intent.putExtra("fee_type", bVar.cuZ);
                        com.tencent.mm.bp.d.a anonymousClass1 = new com.tencent.mm.bp.d.a() {
                            public final void onActivityResult(int i, int i2, Intent intent) {
                                AppMethodBeat.i(32993);
                                if (i != 221) {
                                    AppMethodBeat.o(32993);
                                } else if (intent == null) {
                                    AppMethodBeat.o(32993);
                                } else {
                                    String stringExtra = intent.getStringExtra("result_msg");
                                    if (!bo.isNullOrNil(stringExtra)) {
                                        com.tencent.mm.ui.base.h.b(aVar.yTx.getContext(), stringExtra, "", false);
                                    }
                                    AppMethodBeat.o(32993);
                                }
                            }
                        };
                        if (!r.YM()) {
                            d.a(aVar.yTv, "remittance", ".ui.RemittanceDetailUI", intent, 221, anonymousClass1);
                            break;
                        }
                        d.a(aVar.yTv, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", intent, 221, anonymousClass1);
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        intent.putExtra("appmsg_type", bVar.fhv);
                        intent.putExtra("transfer_id", bVar.fhy);
                        intent.putExtra(com.google.firebase.analytics.FirebaseAnalytics.b.TRANSACTION_ID, bVar.fhx);
                        intent.putExtra("effective_date", bVar.fhA);
                        intent.putExtra("total_fee", bVar.cKu);
                        intent.putExtra("fee_type", bVar.cuZ);
                        if (!r.YM()) {
                            d.b(aVar.yTx.getContext(), "remittance", ".ui.RemittanceDetailUI", intent);
                            break;
                        }
                        d.b(aVar.yTx.getContext(), "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", intent);
                        break;
                    default:
                        ab.w("MicroMsg.ChattingItemAppMsgRemittanceTo", "Unrecognized type %d, probably version to low & check update!", Integer.valueOf(bVar.fhv));
                        com.tencent.mm.platformtools.ah.cw(aVar.yTx.getContext());
                        break;
                }
                AppMethodBeat.o(32998);
                return true;
            }
            AppMethodBeat.o(32998);
            return false;
        }
    }

    static class a extends com.tencent.mm.ui.chatting.viewitems.c.a {
        public int zcJ = 0;
        public ImageView zeb;
        public TextView zec;
        public TextView zed;

        a() {
        }

        public final a eZ(View view) {
            AppMethodBeat.i(32986);
            super.eP(view);
            this.enf = (TextView) this.mRR.findViewById(R.id.ag);
            this.moo = (CheckBox) this.mRR.findViewById(R.id.a_);
            this.iVh = this.mRR.findViewById(R.id.af);
            this.qkY = (TextView) this.mRR.findViewById(R.id.od);
            this.zeb = (ImageView) this.mRR.findViewById(R.id.ar5);
            this.zec = (TextView) this.mRR.findViewById(R.id.ar7);
            this.zed = (TextView) this.mRR.findViewById(R.id.ar6);
            this.zcJ = c.hV(ah.getContext());
            this.zed.setTypeface(((com.tencent.mm.pluginsdk.wallet.b) g.K(com.tencent.mm.pluginsdk.wallet.b.class)).ex(this.mRR.getContext()));
            AppMethodBeat.o(32986);
            return this;
        }
    }
}
