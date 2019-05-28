package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.a.b.a;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.aj.a.j;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.n;
import com.tencent.mm.aj.z;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.acr;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI;
import com.tencent.mm.ui.g;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.ui.v;
import java.util.LinkedList;

public class BizChatConversationUI extends BaseConversationUI {
    private View contentView;

    public static class BizChatConversationFmUI extends BaseConversationFmUI implements n, b {
        private TextView emptyTipTv;
        private String fvM;
        private boolean isCurrentActivity;
        private boolean isDeleteCancel = false;
        private ListView jJY;
        private d jKa;
        private k jLO;
        private int jLX = 0;
        private int jLY = 0;
        private long jMj;
        private String jMp;
        private p tipDialog;
        private LinearLayout yEi;
        private b yEj;
        private j yEk;
        private int yEl = 0;
        private a yEm = new a() {
            public final void a(a.b bVar) {
                AppMethodBeat.i(30068);
                if (!(bVar == null || bVar.fxr == null || !BizChatConversationFmUI.this.jMp.equals(bVar.fxr.field_brandUserName))) {
                    ab.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChatConv change");
                    BizChatConversationFmUI.this.yEj.mY(bVar.fxq);
                    if (BizChatConversationFmUI.this.isCurrentActivity) {
                        BizChatConversationFmUI.this.yEj.KC();
                    }
                }
                AppMethodBeat.o(30068);
            }
        };
        private com.tencent.mm.aj.a.d.a yEn = new com.tencent.mm.aj.a.d.a() {
            public final void a(com.tencent.mm.aj.a.d.a.b bVar) {
                AppMethodBeat.i(30070);
                if (!(bVar == null || bVar.fxB == null || !BizChatConversationFmUI.this.jMp.equals(bVar.fxB.field_brandUserName))) {
                    ab.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChat change");
                    BizChatConversationFmUI.this.yEj.mY(bVar.fxq);
                    if (BizChatConversationFmUI.this.isCurrentActivity) {
                        BizChatConversationFmUI.this.yEj.KC();
                    }
                }
                AppMethodBeat.o(30070);
            }
        };
        private c.a yEo = new c.a() {
            public final void a(c.a.a aVar) {
                AppMethodBeat.i(30071);
                String d = BizChatConversationFmUI.d(BizChatConversationFmUI.this);
                if (!(aVar == null || bo.isNullOrNil(aVar.fuO) || !aVar.fuO.equals(d))) {
                    int l = BizChatConversationFmUI.this.yEl;
                    BizChatConversationFmUI.this.yEl = g.bK(BizChatConversationFmUI.this.getContext(), d);
                    if (BizChatConversationFmUI.this.yEl != l) {
                        BizChatConversationFmUI.r(BizChatConversationFmUI.this);
                    }
                }
                AppMethodBeat.o(30071);
            }
        };

        public BizChatConversationFmUI() {
            AppMethodBeat.i(30079);
            AppMethodBeat.o(30079);
        }

        static /* synthetic */ String d(BizChatConversationFmUI bizChatConversationFmUI) {
            AppMethodBeat.i(30092);
            String dAM = bizChatConversationFmUI.dAM();
            AppMethodBeat.o(30092);
            return dAM;
        }

        static /* synthetic */ void r(BizChatConversationFmUI bizChatConversationFmUI) {
            AppMethodBeat.i(30097);
            bizChatConversationFmUI.dAK();
            AppMethodBeat.o(30097);
        }

        public void onActivityCreated(Bundle bundle) {
            AppMethodBeat.i(30080);
            super.onActivityCreated(bundle);
            this.jMp = thisActivity().getIntent().getStringExtra("Contact_User");
            ab.i("MicroMsg.BizChatConversationFmUI", "[registerListener]");
            z.aeU().a(this.yEm, thisActivity().getMainLooper());
            z.aeT().a(this.yEn, thisActivity().getMainLooper());
            z.afa().a(this.yEo, thisActivity().getMainLooper());
            aw.ZK();
            com.tencent.mm.model.c.XR().a(this);
            this.emptyTipTv = (TextView) findViewById(R.id.a74);
            this.emptyTipTv.setText(R.string.cvu);
            this.jJY = (ListView) findViewById(R.id.bi5);
            dAK();
            this.yEj = new b(thisActivity(), new com.tencent.mm.ui.p.a() {
                public final void apt() {
                    AppMethodBeat.i(30076);
                    BizChatConversationFmUI.this.setMMTitle(s.mJ(BizChatConversationFmUI.this.jMp));
                    if (BizChatConversationFmUI.this.yEj.getCount() <= 0) {
                        BizChatConversationFmUI.this.emptyTipTv.setVisibility(0);
                        BizChatConversationFmUI.this.jJY.setVisibility(8);
                        AppMethodBeat.o(30076);
                        return;
                    }
                    BizChatConversationFmUI.this.emptyTipTv.setVisibility(8);
                    if (BizChatConversationFmUI.this.jJY != null) {
                        BizChatConversationFmUI.this.jJY.setVisibility(0);
                    }
                    AppMethodBeat.o(30076);
                }
            }, this.jMp);
            this.yEj.setGetViewPositionCallback(new MMSlideDelView.c() {
                public final int cZ(View view) {
                    AppMethodBeat.i(30077);
                    int positionForView = BizChatConversationFmUI.this.jJY.getPositionForView(view);
                    AppMethodBeat.o(30077);
                    return positionForView;
                }
            });
            this.yEj.setPerformItemClickListener(new MMSlideDelView.g() {
                public final void q(View view, int i, int i2) {
                    AppMethodBeat.i(30078);
                    BizChatConversationFmUI.this.jJY.performItemClick(view, i, (long) i2);
                    AppMethodBeat.o(30078);
                }
            });
            this.yEj.a(new f() {
                public final void bN(Object obj) {
                    AppMethodBeat.i(30056);
                    if (obj == null) {
                        ab.e("MicroMsg.BizChatConversationFmUI", "onItemDel object null");
                        AppMethodBeat.o(30056);
                        return;
                    }
                    AppMethodBeat.o(30056);
                }
            });
            this.jJY.setAdapter(this.yEj);
            this.jKa = new d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.i(30072);
                    com.tencent.mm.aj.a.a fv;
                    switch (menuItem.getItemId()) {
                        case 0:
                            BizChatConversationFmUI.a(BizChatConversationFmUI.this, BizChatConversationFmUI.this.jMj);
                            AppMethodBeat.o(30072);
                            return;
                        case 1:
                            fv = z.aeU().fv(BizChatConversationFmUI.this.jMj);
                            fv.field_unReadCount = 1;
                            fv.field_atCount = 0;
                            z.aeU().b(fv);
                            com.tencent.mm.modelstat.b.fRa.Q(fv.field_brandUserName, true);
                            AppMethodBeat.o(30072);
                            return;
                        case 2:
                            z.aeU().fx(BizChatConversationFmUI.this.jMj);
                            com.tencent.mm.modelstat.b.fRa.Q(z.aeU().fv(BizChatConversationFmUI.this.jMj).field_brandUserName, false);
                            AppMethodBeat.o(30072);
                            return;
                        case 3:
                            fv = z.aeU().fv(BizChatConversationFmUI.this.jMj);
                            if (!z.aeU().fy(BizChatConversationFmUI.this.jMj)) {
                                z.aeU().fz(BizChatConversationFmUI.this.jMj);
                                com.tencent.mm.modelstat.b.fRa.c(true, fv.field_brandUserName, true);
                                break;
                            }
                            z.aeU().fA(BizChatConversationFmUI.this.jMj);
                            com.tencent.mm.modelstat.b.fRa.c(true, fv.field_brandUserName, false);
                            AppMethodBeat.o(30072);
                            return;
                    }
                    AppMethodBeat.o(30072);
                }
            };
            final com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(thisActivity());
            this.jJY.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(30073);
                    if (motionEvent.getAction() == 0) {
                        BizChatConversationFmUI.this.jLX = (int) motionEvent.getRawX();
                        BizChatConversationFmUI.this.jLY = (int) motionEvent.getRawY();
                    }
                    AppMethodBeat.o(30073);
                    return false;
                }
            });
            this.jJY.setOnItemLongClickListener(new OnItemLongClickListener() {
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(30074);
                    aVar.a(view, i, j, BizChatConversationFmUI.this, BizChatConversationFmUI.this.jKa, BizChatConversationFmUI.this.jLX, BizChatConversationFmUI.this.jLY);
                    AppMethodBeat.o(30074);
                    return true;
                }
            });
            this.jJY.setOnItemClickListener(new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(30075);
                    BizChatConversationFmUI.b(BizChatConversationFmUI.this, ((com.tencent.mm.aj.a.a) BizChatConversationFmUI.this.yEj.getItem(i)).field_bizChatId);
                    AppMethodBeat.o(30075);
                }
            });
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(30057);
                    BizChatConversationFmUI.this.finish();
                    AppMethodBeat.o(30057);
                    return true;
                }
            });
            addIconOptionMenu(1, (int) R.string.ewn, (int) R.raw.actionbar_icon_dark_search, (OnMenuItemClickListener) new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(30058);
                    ab.v("MicroMsg.BizChatConversationFmUI", "search btn was clicked.");
                    Intent intent = new Intent(BizChatConversationFmUI.this.getContext(), BizChatSearchUI.class);
                    intent.putExtra("enterprise_biz_name", BizChatConversationFmUI.this.jMp);
                    intent.putExtra("biz_chat_search_scene", 1);
                    intent.putExtra("biz_chat_search_text", "");
                    intent.addFlags(67108864);
                    BizChatConversationFmUI.this.startActivity(intent);
                    AppMethodBeat.o(30058);
                    return true;
                }
            });
            addIconOptionMenu(2, (int) R.string.cf, (int) R.raw.actionbar_icon_dark_add, (OnMenuItemClickListener) new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(30061);
                    if (BizChatConversationFmUI.this.jLO != null) {
                        BizChatConversationFmUI.this.jLO.dismiss();
                        BizChatConversationFmUI.this.jLO = null;
                    }
                    BizChatConversationFmUI.this.jLO = new k(BizChatConversationFmUI.this.getContext());
                    BizChatConversationFmUI.this.jLO.rBl = new com.tencent.mm.ui.base.n.c() {
                        public final void a(l lVar) {
                            AppMethodBeat.i(30059);
                            if (BizChatConversationFmUI.this.yEl == 1) {
                                lVar.ax(2, R.string.be8, R.raw.actionbar_goto_wework_icon);
                                g.t(BizChatConversationFmUI.this.getContext(), BizChatConversationFmUI.this.jMp, 6);
                            }
                            lVar.ax(1, R.string.a_n, R.raw.actionbar_create_biz_chat_icon);
                            lVar.a(4, BizChatConversationFmUI.this.getResources().getString(R.string.a_m), ah.f(BizChatConversationFmUI.this.getContext(), R.raw.actionbar_facefriend_icon, -1));
                            lVar.a(3, BizChatConversationFmUI.this.getResources().getString(R.string.cg), ah.f(BizChatConversationFmUI.this.getContext(), R.raw.actionbar_setting_white_icon, -1));
                            AppMethodBeat.o(30059);
                        }
                    };
                    BizChatConversationFmUI.this.jLO.rBm = new d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            AppMethodBeat.i(30060);
                            Intent intent;
                            switch (menuItem.getItemId()) {
                                case 1:
                                    BizChatConversationFmUI.m(BizChatConversationFmUI.this);
                                    AppMethodBeat.o(30060);
                                    return;
                                case 2:
                                    g.u(BizChatConversationFmUI.this.getContext(), BizChatConversationFmUI.this.jMp, 6);
                                    AppMethodBeat.o(30060);
                                    return;
                                case 3:
                                    if (bo.isNullOrNil(BizChatConversationFmUI.this.fvM)) {
                                        BizChatConversationFmUI.this.fvM = z.aeR().qP(BizChatConversationFmUI.this.jMp).adX();
                                    }
                                    if (!bo.isNullOrNil(BizChatConversationFmUI.this.fvM) && z.afd().qB(BizChatConversationFmUI.this.fvM)) {
                                        z.afa();
                                        c.a(BizChatConversationFmUI.this.fvM, null);
                                    }
                                    intent = new Intent();
                                    intent.putExtra("Contact_User", BizChatConversationFmUI.this.jMp);
                                    com.tencent.mm.bp.d.b(BizChatConversationFmUI.this.thisActivity(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                                    AppMethodBeat.o(30060);
                                    return;
                                case 4:
                                    if (bo.isNullOrNil(BizChatConversationFmUI.this.jMp)) {
                                        ab.e("MicroMsg.BizChatConversationFmUI", "brandUserName null");
                                        break;
                                    }
                                    intent = new Intent(BizChatConversationFmUI.this.getContext(), BizChatFavUI.class);
                                    intent.putExtra("Contact_User", BizChatConversationFmUI.this.jMp);
                                    intent.addFlags(67108864);
                                    BizChatConversationFmUI.this.startActivity(intent);
                                    AppMethodBeat.o(30060);
                                    return;
                            }
                            AppMethodBeat.o(30060);
                        }
                    };
                    BizChatConversationFmUI.this.jLO.gP();
                    AppMethodBeat.o(30061);
                    return false;
                }
            });
            dAL();
            aw.RS().m(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(30067);
                    ab.i("MicroMsg.BizChatConversationFmUI", "updateChatInfoFromSvr");
                    LinkedList linkedList = new LinkedList();
                    LinkedList linkedList2 = new LinkedList();
                    Cursor rn = z.aeU().rn(BizChatConversationFmUI.this.jMp);
                    if (rn.moveToFirst()) {
                        while (!rn.isAfterLast()) {
                            com.tencent.mm.aj.a.a aVar = new com.tencent.mm.aj.a.a();
                            aVar.d(rn);
                            rn.moveToNext();
                            com.tencent.mm.aj.a.c aK = z.aeT().aK(aVar.field_bizChatId);
                            if (aK.afh()) {
                                if (aK.isGroup()) {
                                    linkedList2.add(aK.field_bizChatServId);
                                } else {
                                    linkedList.add(aK.field_bizChatServId);
                                }
                            }
                        }
                    }
                    rn.close();
                    if (linkedList2.size() > 0) {
                        z.aeZ().a(linkedList2, BizChatConversationFmUI.this.jMp);
                    }
                    BizChatConversationFmUI.a(BizChatConversationFmUI.this, linkedList);
                    if (linkedList.size() > 0) {
                        z.aeZ().b(linkedList, BizChatConversationFmUI.this.jMp);
                    }
                    AppMethodBeat.o(30067);
                }
            }, 300);
            String dAM = dAM();
            if (dAM != null) {
                z.afa();
                c.a(dAM, null);
                ab.e("MicroMsg.BizChatConversationFmUI", "update father attr from svr mainBizName:%s", dAM);
            } else {
                ab.e("MicroMsg.BizChatConversationFmUI", "mainBizName is null!!!");
            }
            Looper.myQueue().addIdleHandler(new IdleHandler() {
                public final boolean queueIdle() {
                    AppMethodBeat.i(30055);
                    BizChatConversationFmUI.this.fvM = z.aeR().qP(BizChatConversationFmUI.this.jMp).adX();
                    int intExtra = BizChatConversationFmUI.this.thisActivity().getIntent().getIntExtra("biz_chat_from_scene", 7);
                    int i = -1;
                    if (BizChatConversationFmUI.this.yEj != null) {
                        i = BizChatConversationFmUI.this.yEj.getCount();
                    }
                    com.tencent.mm.aj.b qC = z.afa().qC(BizChatConversationFmUI.this.fvM);
                    int i2 = qC != null ? qC.field_qyUin : 0;
                    int i3 = qC != null ? qC.field_userUin : 0;
                    int qE = z.afa().qE(BizChatConversationFmUI.this.jMp);
                    long j = qC != null ? qC.field_wwCorpId : 0;
                    long j2 = qC != null ? qC.field_wwUserVid : 0;
                    h.pYm.e(12648, BizChatConversationFmUI.this.fvM, BizChatConversationFmUI.this.jMp, Integer.valueOf(intExtra), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(qE), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2));
                    ab.d("MicroMsg.BizChatConversationFmUI", "bizchat report belong:%s,brandUserName:%s,fromScene:%s,itemCount:%s,fatherUin:%d,childUin:%d,userUin:%d,wwCorpId:%l,wwUserVidL%l", BizChatConversationFmUI.this.fvM, BizChatConversationFmUI.this.jMp, Integer.valueOf(intExtra), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(qE), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2));
                    AppMethodBeat.o(30055);
                    return false;
                }
            });
            Intent intent = thisActivity().getIntent();
            if (w.a(intent, "biz_chat_need_to_jump_to_chatting_ui", false)) {
                long longExtra = intent.getLongExtra("biz_chat_chat_id", -1);
                if (longExtra != -1) {
                    mZ(longExtra);
                }
            }
            AppMethodBeat.o(30080);
        }

        public int getLayoutId() {
            return R.layout.vl;
        }

        public String getUserName() {
            AppMethodBeat.i(30081);
            String str;
            if (bo.isNullOrNil(this.fvM)) {
                str = this.jMp;
                AppMethodBeat.o(30081);
                return str;
            }
            str = this.fvM;
            AppMethodBeat.o(30081);
            return str;
        }

        public void onResume() {
            AppMethodBeat.i(30083);
            super.onResume();
            ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(this.jMp);
            if (aoO == null || !com.tencent.mm.n.a.jh(aoO.field_type)) {
                finish();
                AppMethodBeat.o(30083);
                return;
            }
            com.tencent.mm.aj.d qX = com.tencent.mm.aj.f.qX(this.jMp);
            if (qX == null || qX.field_enterpriseFather == null || !t.mY(qX.field_enterpriseFather)) {
                finish();
                AppMethodBeat.o(30083);
                return;
            }
            if (aoO.DX()) {
                setTitleMuteIconVisibility(0);
            } else {
                setTitleMuteIconVisibility(8);
            }
            this.isCurrentActivity = true;
            this.yEj.a(null, null);
            aw.getNotification().jO(this.jMp);
            AppMethodBeat.o(30083);
        }

        public void onPause() {
            AppMethodBeat.i(30084);
            ab.i("MicroMsg.BizChatConversationFmUI", "on pause");
            aw.ZK();
            com.tencent.mm.model.c.XR().apb(this.jMp);
            com.tencent.mm.aj.a.b aeU = z.aeU();
            String str = this.jMp;
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.BizConversationStorage", "brandUserName is null");
            } else {
                boolean hY = aeU.bSd.hY("BizChatConversation", "update BizChatConversation set newUnReadCount = 0 where newUnReadCount != 0 and brandUserName = '" + str + "'");
                ab.d("MicroMsg.BizConversationStorage", "resetNewUnreadCount :%s,sql:%s", Boolean.valueOf(hY), str);
            }
            if (this.yEj != null) {
                this.yEj.onPause();
            }
            this.isCurrentActivity = false;
            aw.getNotification().jO("");
            super.onPause();
            AppMethodBeat.o(30084);
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(30085);
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            com.tencent.mm.aj.a.a aVar = (com.tencent.mm.aj.a.a) this.yEj.getItem(adapterContextMenuInfo.position);
            this.jMj = aVar.field_bizChatId;
            if (aVar.field_unReadCount <= 0) {
                contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.string.cvl);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 2, 0, R.string.cvj);
            }
            z.aeU();
            if (com.tencent.mm.aj.a.b.c(aVar)) {
                contextMenu.add(adapterContextMenuInfo.position, 3, 1, R.string.cvm);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 3, 1, R.string.cvk);
            }
            contextMenu.add(adapterContextMenuInfo.position, 0, 2, R.string.cvq);
            AppMethodBeat.o(30085);
        }

        public void onActivityResult(int i, int i2, Intent intent) {
            AppMethodBeat.i(30086);
            super.onActivityResult(i, i2, intent);
            if (i2 != -1) {
                AppMethodBeat.o(30086);
                return;
            }
            switch (i) {
                case 1:
                    boolean z;
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra != null) {
                        ab.i("MicroMsg.BizChatConversationFmUI", "bundle != null");
                        String string = bundleExtra.getString("enterprise_members");
                        acr acr = new acr();
                        com.tencent.mm.aj.a.c cVar = new com.tencent.mm.aj.a.c();
                        cVar.field_addMemberUrl = this.yEk != null ? this.yEk.field_addMemberUrl : null;
                        cVar.field_brandUserName = this.jMp;
                        if (!e.a(cVar, string, null, acr)) {
                            z = false;
                        } else if (cVar.field_bizChatLocalId != -1) {
                            mZ(cVar.field_bizChatLocalId);
                            z = true;
                        } else {
                            z.aeZ();
                            final com.tencent.mm.aj.a.n a = com.tencent.mm.aj.a.h.a(this.jMp, acr, (n) this);
                            Context thisActivity = thisActivity();
                            getString(R.string.tz);
                            this.tipDialog = com.tencent.mm.ui.base.h.b(thisActivity, getString(R.string.un), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(30062);
                                    z.aeZ();
                                    com.tencent.mm.aj.a.h.f(a);
                                    AppMethodBeat.o(30062);
                                }
                            });
                            z = true;
                        }
                    } else {
                        z = false;
                    }
                    if (z) {
                        AppMethodBeat.o(30086);
                        return;
                    }
                    Toast.makeText(thisActivity(), getString(R.string.dru), 0).show();
                    AppMethodBeat.o(30086);
                    return;
                default:
                    AppMethodBeat.o(30086);
                    return;
            }
        }

        public final void a(int i, m mVar) {
            AppMethodBeat.i(30087);
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (mVar.getType() == 1355) {
                com.tencent.mm.aj.a.c rq = z.aeT().rq(((com.tencent.mm.aj.a.n) mVar).afm().wcb.wku.vMV);
                if (rq == null) {
                    Toast.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), getString(R.string.dru), 0).show();
                    AppMethodBeat.o(30087);
                    return;
                }
                mZ(rq.field_bizChatLocalId);
            }
            AppMethodBeat.o(30087);
        }

        private void dAK() {
            AppMethodBeat.i(30088);
            String dAM = dAM();
            this.yEl = g.bK(getContext(), dAM);
            if (this.yEl == 2 && this.yEi == null) {
                this.yEi = (LinearLayout) findViewById(R.id.bi7);
                LayoutParams layoutParams = this.yEi.getLayoutParams();
                layoutParams.height = com.tencent.mm.bz.a.al(getContext(), R.dimen.fh);
                this.yEi.setLayoutParams(layoutParams);
                View inflate = v.hu(getContext()).inflate(R.layout.vm, this.yEi, false);
                float dm = com.tencent.mm.bz.a.dm(getContext());
                ImageView imageView = (ImageView) inflate.findViewById(R.id.rq);
                int i = imageView.getLayoutParams().height;
                imageView.getLayoutParams().height = (int) (((float) i) * dm);
                imageView.getLayoutParams().width = (int) (dm * ((float) i));
                imageView.requestLayout();
                ((TextView) inflate.findViewById(R.id.qm)).setText(R.string.be3);
                this.yEi.addView(inflate);
                inflate.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(30069);
                        g.u(BizChatConversationFmUI.this.getContext(), BizChatConversationFmUI.d(BizChatConversationFmUI.this), 4);
                        AppMethodBeat.o(30069);
                    }
                });
                g.t(getContext(), this.jMp, 4);
                g.bL(getContext(), dAM);
            }
            if (this.yEi != null) {
                if (this.yEl == 2) {
                    this.yEi.setVisibility(0);
                    AppMethodBeat.o(30088);
                    return;
                }
                this.yEi.setVisibility(8);
            }
            AppMethodBeat.o(30088);
        }

        private void dAL() {
            boolean z = false;
            AppMethodBeat.i(30089);
            String cI = z.aeV().cI(this.jMp);
            this.yEk = z.aeV().cH(cI);
            String str = "MicroMsg.BizChatConversationFmUI";
            String str2 = "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s";
            Object[] objArr = new Object[3];
            objArr[0] = this.jMp;
            objArr[1] = cI;
            if (this.yEk == null) {
                z = true;
            }
            objArr[2] = Boolean.valueOf(z);
            ab.i(str, str2, objArr);
            if (bo.isNullOrNil(cI) || this.yEk == null || this.yEk.afh() || bo.isNullOrNil(this.yEk.field_addMemberUrl)) {
                z.aeZ();
                com.tencent.mm.aj.a.h.a(this.jMp, (n) this);
                Context thisActivity = thisActivity();
                getString(R.string.tz);
                this.tipDialog = com.tencent.mm.ui.base.h.b(thisActivity, getString(R.string.un), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(30066);
                        BizChatConversationFmUI.this.finish();
                        AppMethodBeat.o(30066);
                    }
                });
            }
            AppMethodBeat.o(30089);
        }

        private String dAM() {
            AppMethodBeat.i(30090);
            if (bo.isNullOrNil(this.fvM)) {
                this.fvM = z.aeR().qP(this.jMp).adX();
            }
            String str = this.fvM;
            AppMethodBeat.o(30090);
            return str;
        }

        private void mZ(long j) {
            AppMethodBeat.i(30091);
            Bundle bundle = new Bundle();
            bundle.putLong("key_biz_chat_id", j);
            bundle.putBoolean("finish_direct", false);
            bundle.putBoolean("key_need_send_video", false);
            bundle.putBoolean("key_is_biz_chat", true);
            this.ui.startChatting(this.jMp, bundle, true);
            AppMethodBeat.o(30091);
        }

        public final void a(int i, com.tencent.mm.sdk.e.n nVar, Object obj) {
        }

        public void onDestroy() {
            AppMethodBeat.i(30082);
            ab.i("MicroMsg.BizChatConversationFmUI", "[unRegitListener]");
            z.aeU().a(this.yEm);
            z.aeT().a(this.yEn);
            z.afa().a(this.yEo);
            if (aw.RK()) {
                aw.ZK();
                com.tencent.mm.model.c.XR().b(this);
            }
            this.yEj.bIf();
            b bVar = this.yEj;
            if (bVar.yDY != null) {
                bVar.yDY.clear();
                bVar.yDY = null;
            }
            super.onDestroy();
            AppMethodBeat.o(30082);
        }

        static /* synthetic */ void m(BizChatConversationFmUI bizChatConversationFmUI) {
            AppMethodBeat.i(30095);
            bizChatConversationFmUI.yEk = z.aeV().cH(z.aeV().cI(bizChatConversationFmUI.jMp));
            if (bizChatConversationFmUI.yEk == null || bo.isNullOrNil(bizChatConversationFmUI.yEk.field_addMemberUrl)) {
                Toast.makeText(bizChatConversationFmUI.thisActivity(), bizChatConversationFmUI.getString(R.string.a_o), 0).show();
                bizChatConversationFmUI.dAL();
                AppMethodBeat.o(30095);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", bizChatConversationFmUI.yEk.field_addMemberUrl);
            ab.i("MicroMsg.BizChatConversationFmUI", "KRawUrl :%s", bizChatConversationFmUI.yEk.field_addMemberUrl);
            intent.putExtra("useJs", true);
            intent.addFlags(67108864);
            com.tencent.mm.bp.d.b(bizChatConversationFmUI.getContext(), "webview", ".ui.tools.WebViewUI", intent, 1);
            AppMethodBeat.o(30095);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(30098);
        super.onCreate(bundle);
        this.contentView = v.hu(this).inflate(R.layout.hj, null);
        setContentView(this.contentView);
        this.conversationFm = new BizChatConversationFmUI();
        getSupportFragmentManager().beginTransaction().a((int) R.id.a9e, this.conversationFm).commit();
        com.tencent.mm.pluginsdk.f.a(this, this.contentView);
        AppMethodBeat.o(30098);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(30099);
        super.onConfigurationChanged(configuration);
        com.tencent.mm.pluginsdk.f.a(this, this.contentView);
        AppMethodBeat.o(30099);
    }
}
