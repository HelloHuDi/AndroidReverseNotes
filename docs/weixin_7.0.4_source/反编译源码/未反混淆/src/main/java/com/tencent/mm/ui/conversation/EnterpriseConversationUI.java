package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.c.a;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.z;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.i;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bbo;
import com.tencent.mm.protocal.protobuf.cfr;
import com.tencent.mm.protocal.protobuf.cfs;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI;
import com.tencent.mm.ui.g;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.v;
import java.util.LinkedList;

public class EnterpriseConversationUI extends BaseConversationUI {
    private View contentView;

    public static class EnterpriseConversationFmUI extends BaseConversationFmUI implements f, b {
        private j contextMenuHelper;
        private long edh = 0;
        private TextView emptyTipTv;
        long fRR = 0;
        private int fromScene;
        private String fuO;
        private boolean isDeleteCancel = false;
        private String jMa = "";
        private d jOb;
        private long jrh = 0;
        private p tipDialog;
        private LinearLayout yEi = null;
        private int yEl = 0;
        private a yEo = new a() {
            public final void a(a.a aVar) {
                AppMethodBeat.i(34428);
                if (!(aVar == null || bo.isNullOrNil(aVar.fuO) || !aVar.fuO.equals(EnterpriseConversationFmUI.this.fuO))) {
                    int e = EnterpriseConversationFmUI.this.yEl;
                    EnterpriseConversationFmUI.this.yEl = g.bK(EnterpriseConversationFmUI.this.getContext(), EnterpriseConversationFmUI.this.fuO);
                    if (EnterpriseConversationFmUI.this.yEl != e) {
                        EnterpriseConversationFmUI.q(EnterpriseConversationFmUI.this);
                    }
                }
                AppMethodBeat.o(34428);
            }
        };
        private ListView zqO;
        private String zqQ;
        private k zum;
        private View zun = null;
        private i zuo;
        private String zup = null;
        private ak zuq;
        private int zur = -2;
        private String zus = null;

        public EnterpriseConversationFmUI() {
            AppMethodBeat.i(34439);
            AppMethodBeat.o(34439);
        }

        static /* synthetic */ void q(EnterpriseConversationFmUI enterpriseConversationFmUI) {
            AppMethodBeat.i(34456);
            enterpriseConversationFmUI.dAK();
            AppMethodBeat.o(34456);
        }

        public void onActivityCreated(Bundle bundle) {
            AppMethodBeat.i(34440);
            super.onActivityCreated(bundle);
            this.fuO = thisActivity().getIntent().getStringExtra("enterprise_biz_name");
            this.zqQ = thisActivity().getIntent().getStringExtra("enterprise_biz_display_name");
            this.fromScene = thisActivity().getIntent().getIntExtra("enterprise_from_scene", 5);
            setMMTitle(this.zqQ);
            this.zqO = (ListView) findViewById(R.id.bi5);
            this.emptyTipTv = (TextView) findViewById(R.id.a74);
            this.emptyTipTv.setText(R.string.bdq);
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(34417);
                    EnterpriseConversationFmUI.this.finish();
                    AppMethodBeat.o(34417);
                    return true;
                }
            });
            setToTop(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(34429);
                    com.tencent.mm.platformtools.b.b.a(EnterpriseConversationFmUI.this.zqO);
                    AppMethodBeat.o(34429);
                }
            });
            if (com.tencent.mm.aj.f.qX(this.fuO) != null) {
                dAK();
                if (this.fuO != null) {
                    f anonymousClass12 = new f() {
                        public final void onSceneEnd(int i, int i2, String str, m mVar) {
                            AppMethodBeat.i(34430);
                            EnterpriseConversationFmUI.b(EnterpriseConversationFmUI.this);
                            AppMethodBeat.o(34430);
                        }
                    };
                    z.afa();
                    c.a(this.fuO, anonymousClass12);
                    ab.e("MicroMsg.EnterpriseConversationUI", "update father attr from svr bizName:%s", this.fuO);
                } else {
                    ab.e("MicroMsg.EnterpriseConversationUI", "bizName is null!!!");
                }
                addIconOptionMenu(1, (int) R.string.ewn, (int) R.raw.actionbar_icon_dark_search, (OnMenuItemClickListener) new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(34432);
                        Intent intent = new Intent();
                        intent.putExtra("enterprise_biz_name", EnterpriseConversationFmUI.this.fuO);
                        intent.addFlags(67108864);
                        com.tencent.mm.bp.d.b(EnterpriseConversationFmUI.this.getContext(), "brandservice", ".ui.EnterpriseBizSearchUI", intent);
                        AppMethodBeat.o(34432);
                        return true;
                    }
                });
                addIconOptionMenu(2, (int) R.string.cf, (int) R.raw.actionbar_icon_dark_add, (OnMenuItemClickListener) new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(34435);
                        if (EnterpriseConversationFmUI.this.zum != null) {
                            EnterpriseConversationFmUI.this.zum.dismiss();
                            EnterpriseConversationFmUI.this.zum = null;
                        }
                        EnterpriseConversationFmUI.this.zum = new k(EnterpriseConversationFmUI.this.getContext());
                        EnterpriseConversationFmUI.this.zum.rBl = new n.c() {
                            public final void a(l lVar) {
                                AppMethodBeat.i(34433);
                                if (EnterpriseConversationFmUI.this.yEl == 1) {
                                    lVar.ax(2, R.string.be8, R.raw.actionbar_goto_wework_icon);
                                    g.t(EnterpriseConversationFmUI.this.getContext(), EnterpriseConversationFmUI.this.fuO, 5);
                                }
                                lVar.ax(3, R.string.azw, R.raw.ofm_send_icon);
                                lVar.ax(4, R.string.bdp, R.raw.actionbar_goto_disabled_biz_icon);
                                lVar.ax(5, R.string.cg, R.raw.actionbar_setting_white_icon);
                                AppMethodBeat.o(34433);
                            }
                        };
                        EnterpriseConversationFmUI.this.zum.rBm = new d() {
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                AppMethodBeat.i(34434);
                                int i2 = 0;
                                Intent intent;
                                switch (menuItem.getItemId()) {
                                    case 2:
                                        g.u(EnterpriseConversationFmUI.this.getContext(), EnterpriseConversationFmUI.this.fuO, 5);
                                        break;
                                    case 3:
                                        intent = new Intent(EnterpriseConversationFmUI.this.thisActivity(), SelectConversationUI.class);
                                        intent.putExtra("Select_Talker_Name", EnterpriseConversationFmUI.this.fuO);
                                        intent.putExtra("Select_block_List", EnterpriseConversationFmUI.this.fuO);
                                        intent.putExtra("Select_Send_Card", true);
                                        intent.putExtra("Select_Conv_Type", 3);
                                        EnterpriseConversationFmUI.this.startActivityForResult(intent, 1);
                                        i2 = 3;
                                        break;
                                    case 4:
                                        i2 = 4;
                                        Intent intent2 = new Intent();
                                        intent2.putExtra("enterprise_biz_name", EnterpriseConversationFmUI.this.fuO);
                                        intent2.putExtra("enterprise_scene", 2);
                                        com.tencent.mm.bp.d.b(EnterpriseConversationFmUI.this.thisActivity(), "brandservice", ".ui.EnterpriseBizContactPlainListUI", intent2);
                                        break;
                                    case 5:
                                        intent = new Intent();
                                        intent.putExtra("Contact_User", EnterpriseConversationFmUI.this.fuO);
                                        com.tencent.mm.bp.d.b(EnterpriseConversationFmUI.this.thisActivity(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                                        i2 = 5;
                                        break;
                                }
                                g.ew(EnterpriseConversationFmUI.this.fuO, i2);
                                AppMethodBeat.o(34434);
                            }
                        };
                        EnterpriseConversationFmUI.this.zum.gP();
                        g.ew(EnterpriseConversationFmUI.this.fuO, 1);
                        AppMethodBeat.o(34435);
                        return false;
                    }
                });
                this.zuo = new i(thisActivity(), this.fuO, new com.tencent.mm.ui.p.a() {
                    public final void apt() {
                        AppMethodBeat.i(34436);
                        EnterpriseConversationFmUI.a(EnterpriseConversationFmUI.this, EnterpriseConversationFmUI.this.zuo.getCount());
                        AppMethodBeat.o(34436);
                    }
                });
                this.zuo.setGetViewPositionCallback(new MMSlideDelView.c() {
                    public final int cZ(View view) {
                        AppMethodBeat.i(34437);
                        int positionForView = EnterpriseConversationFmUI.this.zqO.getPositionForView(view);
                        AppMethodBeat.o(34437);
                        return positionForView;
                    }
                });
                this.zuo.setPerformItemClickListener(new MMSlideDelView.g() {
                    public final void q(View view, int i, int i2) {
                        AppMethodBeat.i(34438);
                        EnterpriseConversationFmUI.this.zqO.performItemClick(view, i, (long) i2);
                        AppMethodBeat.o(34438);
                    }
                });
                this.zuo.a(new MMSlideDelView.f() {
                    public final void bN(Object obj) {
                        AppMethodBeat.i(34418);
                        if (obj == null) {
                            ab.e("MicroMsg.EnterpriseConversationUI", "onItemDel object null");
                            AppMethodBeat.o(34418);
                            return;
                        }
                        EnterpriseConversationFmUI.a(EnterpriseConversationFmUI.this, obj.toString());
                        AppMethodBeat.o(34418);
                    }
                });
                this.zqO.setAdapter(this.zuo);
                this.zqO.setOnItemClickListener(new OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        String str = null;
                        AppMethodBeat.i(34419);
                        com.tencent.mm.storage.ak akVar = (com.tencent.mm.storage.ak) EnterpriseConversationFmUI.this.zuo.getItem(i);
                        if (akVar == null) {
                            ab.e("MicroMsg.EnterpriseConversationUI", "user should not be null. position:%d, size:%d", Integer.valueOf(i), Integer.valueOf(EnterpriseConversationFmUI.this.zuo.getCount()));
                            EnterpriseConversationFmUI.this.zuo.notifyDataSetChanged();
                            AppMethodBeat.o(34419);
                        } else if (com.tencent.mm.aj.f.kq(akVar.field_username)) {
                            Intent intent = new Intent(EnterpriseConversationFmUI.this.thisActivity(), BizChatConversationUI.class);
                            intent.putExtra("Contact_User", akVar.field_username);
                            intent.putExtra("biz_chat_from_scene", 7);
                            intent.addFlags(67108864);
                            EnterpriseConversationFmUI.this.startActivity(intent);
                            AppMethodBeat.o(34419);
                        } else if (com.tencent.mm.aj.f.rd(akVar.field_username)) {
                            com.tencent.mm.aj.d qX = com.tencent.mm.aj.f.qX(akVar.field_username);
                            if (qX != null) {
                                str = qX.adT();
                            }
                            if (str == null) {
                                str = "";
                            }
                            Intent intent2 = new Intent();
                            intent2.putExtra("rawUrl", str);
                            intent2.putExtra("useJs", true);
                            intent2.putExtra("srcUsername", akVar.field_username);
                            intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                            intent2.putExtra("geta8key_scene", 51);
                            intent2.addFlags(67108864);
                            com.tencent.mm.bp.d.b(EnterpriseConversationFmUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                            EnterpriseConversationFmUI.a(EnterpriseConversationFmUI.this, qX, 2, akVar.field_unReadCount);
                            AppMethodBeat.o(34419);
                        } else {
                            EnterpriseConversationFmUI.this.ui.startChatting(akVar.field_username, null, true);
                            EnterpriseConversationFmUI.a(EnterpriseConversationFmUI.this, com.tencent.mm.aj.f.qX(akVar.field_username), 1, akVar.field_unReadCount);
                            AppMethodBeat.o(34419);
                        }
                    }
                });
                this.contextMenuHelper = new j(thisActivity());
                this.jOb = new d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(34420);
                        switch (menuItem.getItemId()) {
                            case 1:
                                EnterpriseConversationFmUI.a(EnterpriseConversationFmUI.this, EnterpriseConversationFmUI.this.jMa);
                                AppMethodBeat.o(34420);
                                return;
                            case 2:
                                EnterpriseConversationFmUI.b(EnterpriseConversationFmUI.this, EnterpriseConversationFmUI.this.jMa);
                                AppMethodBeat.o(34420);
                                return;
                            case 3:
                                EnterpriseConversationFmUI.arW(EnterpriseConversationFmUI.this.jMa);
                                break;
                        }
                        AppMethodBeat.o(34420);
                    }
                };
                this.zqO.setOnItemLongClickListener(new OnItemLongClickListener() {
                    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                        AppMethodBeat.i(34421);
                        EnterpriseConversationFmUI.this.jMa = ((com.tencent.mm.storage.ak) EnterpriseConversationFmUI.this.zuo.getItem(i)).field_username;
                        EnterpriseConversationFmUI.this.contextMenuHelper.a(view, i, j, EnterpriseConversationFmUI.this, EnterpriseConversationFmUI.this.jOb);
                        AppMethodBeat.o(34421);
                        return true;
                    }
                });
            }
            this.edh = System.currentTimeMillis() / 1000;
            aw.ZK();
            com.tencent.mm.storage.ak aoZ = com.tencent.mm.model.c.XR().aoZ(this.fuO);
            if (aoZ != null) {
                String str;
                this.zur = aoZ.field_unReadCount;
                if (this.zur == 0 && aoZ.field_unReadMuteCount > 0) {
                    this.zur = -1;
                }
                this.jrh = aoZ.field_conversationTime / 1000;
                if (aoZ.field_isSend == 1) {
                    str = null;
                } else {
                    str = aoZ.field_digestUser;
                }
                this.zus = str;
            }
            z.afa().a(this.yEo, thisActivity().getMainLooper());
            aw.ZK();
            com.tencent.mm.model.c.XR().a(this);
            aw.ZK();
            com.tencent.mm.model.c.XM().a(this);
            if (this.zuo != null) {
                if (this.zuq == null) {
                    this.zuq = new ak() {
                        public final void handleMessage(Message message) {
                            AppMethodBeat.i(34427);
                            if (message != null && message.what == 1 && EnterpriseConversationFmUI.this.thisActivity() != null && !EnterpriseConversationFmUI.this.thisActivity().isFinishing()) {
                                int i;
                                int i2;
                                int count = EnterpriseConversationFmUI.this.zuo.getCount();
                                LinkedList linkedList = new LinkedList();
                                LinkedList linkedList2 = new LinkedList();
                                int i3 = 0;
                                int i4 = 0;
                                int i5 = 0;
                                int i6 = 0;
                                while (i6 < count) {
                                    com.tencent.mm.storage.ak akVar = (com.tencent.mm.storage.ak) EnterpriseConversationFmUI.this.zuo.getItem(i6);
                                    if (akVar != null) {
                                        String str = akVar.field_username;
                                        if (str != null) {
                                            if (t.mY(str) && com.tencent.mm.aj.f.re(str)) {
                                                ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(str);
                                                boolean aph = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XR().aph(str);
                                                Object obj = (aoO == null || (aoO.field_type & 2048) == 0) ? null : 1;
                                                if (obj != null && !aph) {
                                                    ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XR().apf(str);
                                                } else if (obj == null && aph) {
                                                    ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XR().apg(str);
                                                }
                                                if (com.tencent.mm.aj.f.rd(str)) {
                                                    linkedList2.add(str);
                                                }
                                                if (akVar.field_unReadCount > 0) {
                                                    if (t.nN(str)) {
                                                        i3++;
                                                        i = i5;
                                                        i2 = i4;
                                                    } else {
                                                        i2 = i4 + 1;
                                                        i = akVar.field_unReadCount + i5;
                                                    }
                                                    i6++;
                                                    i5 = i;
                                                    i4 = i2;
                                                }
                                            } else {
                                                ab.d("MicroMsg.EnterpriseConversationUI", "checkEnterpriseChildConv delete conv %s", str);
                                                linkedList.add(str);
                                                i = i5;
                                                i2 = i4;
                                                i6++;
                                                i5 = i;
                                                i4 = i2;
                                            }
                                        }
                                    }
                                    i = i5;
                                    i2 = i4;
                                    i6++;
                                    i5 = i;
                                    i4 = i2;
                                }
                                com.tencent.mm.aj.b qC = z.afa().qC(EnterpriseConversationFmUI.this.fuO);
                                int i7 = qC != null ? qC.field_qyUin : 0;
                                long j = qC != null ? qC.field_wwCorpId : 0;
                                long j2 = qC != null ? qC.field_wwUserVid : 0;
                                i6 = 0;
                                if (!bo.isNullOrNil(EnterpriseConversationFmUI.this.zus)) {
                                    i6 = z.afa().qE(EnterpriseConversationFmUI.this.zus);
                                }
                                h.pYm.e(12892, EnterpriseConversationFmUI.this.fuO, Integer.valueOf(EnterpriseConversationFmUI.this.fromScene), Integer.valueOf(count), "", Integer.valueOf(EnterpriseConversationFmUI.this.zur), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(EnterpriseConversationFmUI.this.jrh), Integer.valueOf(i6), Integer.valueOf(i7), Long.valueOf(j), Long.valueOf(j2));
                                ab.d("MicroMsg.EnterpriseConversationUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", EnterpriseConversationFmUI.this.fuO, Integer.valueOf(EnterpriseConversationFmUI.this.fromScene), Integer.valueOf(count), "", Integer.valueOf(EnterpriseConversationFmUI.this.zur), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(EnterpriseConversationFmUI.this.jrh), Integer.valueOf(i6), Integer.valueOf(i7), Long.valueOf(j), Long.valueOf(j2));
                                if (linkedList.size() > 0) {
                                    aw.ZK();
                                    com.tencent.mm.model.c.XR().aF(linkedList);
                                    EnterpriseConversationFmUI.this.zuo.KC();
                                }
                                if (z.afd().qB(EnterpriseConversationFmUI.this.fuO)) {
                                    z.afa();
                                    c.a(EnterpriseConversationFmUI.this.fuO, null);
                                }
                                z.afd().qB(EnterpriseConversationFmUI.p(EnterpriseConversationFmUI.this));
                                if (linkedList2.size() > 0) {
                                    i = 0;
                                    while (true) {
                                        i2 = i;
                                        if (i2 >= linkedList2.size()) {
                                            break;
                                        }
                                        z.afd().qB((String) linkedList2.get(i2));
                                        i = i2 + 1;
                                    }
                                }
                            }
                            AppMethodBeat.o(34427);
                        }
                    };
                } else {
                    this.zuq.removeMessages(1);
                }
                this.zuq.sendEmptyMessageDelayed(1, 500);
            }
            AppMethodBeat.o(34440);
        }

        public int getLayoutId() {
            return R.layout.vl;
        }

        public String getUserName() {
            return this.fuO;
        }

        public void onDestroy() {
            AppMethodBeat.i(34441);
            z.afa().a(this.yEo);
            if (aw.RK()) {
                aw.ZK();
                com.tencent.mm.model.c.XR().b(this);
                aw.ZK();
                com.tencent.mm.model.c.XM().b(this);
            }
            if (this.zuo != null) {
                i iVar = this.zuo;
                iVar.zrC.stopTimer();
                if (iVar.yDY != null) {
                    iVar.yDY.clear();
                    iVar.yDY = null;
                }
                iVar.bIf();
                iVar.dww();
                aw.ZK();
                com.tencent.mm.model.c.XR().b(iVar);
            }
            aw.Rg().b(1394, (f) this);
            if (this.edh > 0 && this.fRR > 0) {
                int i;
                int i2;
                long j = this.fRR - this.edh;
                com.tencent.mm.aj.b qC = z.afa().qC(this.fuO);
                if (qC != null) {
                    i = qC.field_qyUin;
                } else {
                    i = 0;
                }
                if (qC != null) {
                    i2 = qC.field_userUin;
                } else {
                    i2 = 0;
                }
                h.pYm.e(13465, "", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(j));
                ab.d("MicroMsg.EnterpriseConversationUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(j));
            }
            super.onDestroy();
            AppMethodBeat.o(34441);
        }

        public void onResume() {
            AppMethodBeat.i(34442);
            ab.v("MicroMsg.EnterpriseConversationUI", "on resume");
            if (this.zuo != null) {
                this.zuo.onResume();
            }
            super.onResume();
            if (!t.mY(this.fuO)) {
                finish();
            }
            AppMethodBeat.o(34442);
        }

        public void onPause() {
            AppMethodBeat.i(34443);
            ab.v("MicroMsg.EnterpriseConversationUI", "on pause");
            aw.ZK();
            com.tencent.mm.model.c.XR().apb(this.fuO);
            if (this.zuo != null) {
                this.zuo.onPause();
            }
            super.onPause();
            AppMethodBeat.o(34443);
        }

        public void onActivityResult(int i, int i2, Intent intent) {
            AppMethodBeat.i(34444);
            super.onActivityResult(i, i2, intent);
            switch (i) {
                case 1:
                    if (i2 != -1 || intent == null) {
                        AppMethodBeat.o(34444);
                        return;
                    }
                    String stringExtra = intent.getStringExtra("be_send_card_name");
                    String stringExtra2 = intent.getStringExtra("received_card_name");
                    boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                    String stringExtra3 = intent.getStringExtra("custom_send_text");
                    com.tencent.mm.plugin.messenger.a.g.bOk().q(stringExtra, stringExtra2, booleanExtra);
                    com.tencent.mm.plugin.messenger.a.g.bOk().eZ(stringExtra3, stringExtra2);
                    com.tencent.mm.ui.widget.snackbar.b.i(thisActivity(), getContext().getString(R.string.bvk));
                    AppMethodBeat.o(34444);
                    return;
                default:
                    AppMethodBeat.o(34444);
                    return;
            }
        }

        private void dAK() {
            AppMethodBeat.i(34445);
            this.yEl = g.bK(getContext(), this.fuO);
            if (this.yEl == 2 && this.yEi == null) {
                this.yEi = (LinearLayout) findViewById(R.id.bi7);
                LayoutParams layoutParams = this.yEi.getLayoutParams();
                layoutParams.height = com.tencent.mm.bz.a.al(getContext(), R.dimen.fh);
                this.yEi.setLayoutParams(layoutParams);
                this.zun = v.hu(getContext()).inflate(R.layout.vm, this.yEi, false);
                float dm = com.tencent.mm.bz.a.dm(getContext());
                ImageView imageView = (ImageView) this.zun.findViewById(R.id.rq);
                int i = imageView.getLayoutParams().height;
                imageView.getLayoutParams().height = (int) (((float) i) * dm);
                imageView.getLayoutParams().width = (int) (dm * ((float) i));
                imageView.requestLayout();
                TextView textView = (TextView) this.zun.findViewById(R.id.qm);
                com.tencent.mm.aj.b qC = z.afa().qC(this.fuO);
                z.afa();
                z.afa();
                String lb = c.lb(0);
                if (qC == null || qC.field_chatOpen || qC.field_use_preset_banner_tips || lb == null) {
                    textView.setText(R.string.be7);
                } else {
                    textView.setText(lb);
                }
                g.at(this.fuO, 1, 2);
                this.yEi.addView(this.zun);
                this.zun.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(34431);
                        g.u(EnterpriseConversationFmUI.this.getContext(), EnterpriseConversationFmUI.this.fuO, 3);
                        AppMethodBeat.o(34431);
                    }
                });
                g.t(getContext(), this.fuO, 3);
                g.bL(getContext(), this.fuO);
            }
            if (this.yEi != null) {
                if (this.yEl == 2) {
                    this.yEi.setVisibility(0);
                    dIM();
                    AppMethodBeat.o(34445);
                    return;
                }
                this.yEi.setVisibility(8);
            }
            AppMethodBeat.o(34445);
        }

        private void dIM() {
            AppMethodBeat.i(34446);
            com.tencent.mm.aj.b qC = z.afa().qC(this.fuO);
            int i = qC != null ? qC.field_qyUin : 0;
            int i2 = qC != null ? qC.field_userUin : 0;
            long j = qC != null ? qC.field_wwCorpId : 0;
            long j2 = qC != null ? qC.field_wwUserVid : 0;
            h.pYm.e(13656, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(j), Long.valueOf(j2));
            ab.d("MicroMsg.EnterpriseConversationUI", "expose wework btn on session list  report: %s,%s,%s,%s,%s,%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(j), Long.valueOf(j2));
            AppMethodBeat.o(34446);
        }

        public void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(34447);
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            if (i == 0 && i2 == 0) {
                if (mVar.getType() == 1394) {
                    cfr caz = ((com.tencent.mm.plugin.profile.b.d) mVar).caz();
                    cfs cay = ((com.tencent.mm.plugin.profile.b.d) mVar).cay();
                    if (cay == null || cay.vNh == null || cay.vNh.ret != 0) {
                        if (cay == null || cay.vNh == null) {
                            ab.w("MicroMsg.EnterpriseConversationUI", "chuangchen onSceneEnd type:%s, err:resp == null", Integer.valueOf(mVar.getType()));
                            AppMethodBeat.o(34447);
                            return;
                        }
                        ab.w("MicroMsg.EnterpriseConversationUI", "chuangchen onSceneEnd type:%s, err:code:%s", Integer.valueOf(mVar.getType()), Integer.valueOf(cay.vNh.ret));
                        AppMethodBeat.o(34447);
                        return;
                    } else if (caz.xeS) {
                        com.tencent.mm.aj.d qX = com.tencent.mm.aj.f.qX(caz.vNb);
                        qX.field_brandFlag |= 1;
                        bbo bbo = new bbo();
                        bbo.gvb = qX.field_brandFlag;
                        bbo.jBB = caz.vNb;
                        aw.ZK();
                        com.tencent.mm.model.c.XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(47, bbo));
                        z.aeR().c(qX, new String[0]);
                        aw.ZK();
                        com.tencent.mm.model.c.XR().aoX(qX.field_username);
                        aw.ZK();
                        if (com.tencent.mm.model.c.XR().apl(qX.field_enterpriseFather) <= 0) {
                            aw.ZK();
                            com.tencent.mm.model.c.XR().aoX(qX.field_enterpriseFather);
                            AppMethodBeat.o(34447);
                            return;
                        }
                        aw.ZK();
                        com.tencent.mm.model.c.XQ().aoj(qX.field_enterpriseFather);
                    } else {
                        AppMethodBeat.o(34447);
                        return;
                    }
                }
                AppMethodBeat.o(34447);
                return;
            }
            AppMethodBeat.o(34447);
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(34448);
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            aw.ZK();
            ad aoO = com.tencent.mm.model.c.XM().aoO(this.jMa);
            if (aoO == null) {
                ab.e("MicroMsg.EnterpriseConversationUI", "onCreateContextMenu, contact is null, talker = " + this.jMa);
                AppMethodBeat.o(34448);
                return;
            }
            CharSequence Oj = aoO.Oj();
            if (Oj.toLowerCase().endsWith("@chatroom") && bo.isNullOrNil(aoO.field_nickname)) {
                Oj = getString(R.string.ao1);
            }
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.e.j.b(thisActivity(), Oj));
            if (aoO.Oe()) {
                contextMenu.add(adapterContextMenuInfo.position, 3, 0, R.string.cvm);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 3, 0, R.string.be1);
            }
            contextMenu.add(adapterContextMenuInfo.position, 2, 1, R.string.bdu);
            contextMenu.add(adapterContextMenuInfo.position, 1, 2, R.string.cvq);
            AppMethodBeat.o(34448);
        }

        public final void a(int i, com.tencent.mm.sdk.e.n nVar, Object obj) {
        }

        static /* synthetic */ void b(EnterpriseConversationFmUI enterpriseConversationFmUI) {
            AppMethodBeat.i(34449);
            if (enterpriseConversationFmUI.zun != null) {
                com.tencent.mm.aj.b qC = z.afa().qC(enterpriseConversationFmUI.fuO);
                if (!(qC == null || qC.field_chatOpen || qC.field_use_preset_banner_tips)) {
                    TextView textView = (TextView) enterpriseConversationFmUI.zun.findViewById(R.id.qm);
                    z.afa();
                    z.afa();
                    String lb = c.lb(0);
                    if (!(textView == null || lb == null || textView.getText().equals(lb))) {
                        textView.setText(lb);
                    }
                }
            }
            AppMethodBeat.o(34449);
        }

        static /* synthetic */ void a(EnterpriseConversationFmUI enterpriseConversationFmUI, com.tencent.mm.aj.d dVar, int i, int i2) {
            AppMethodBeat.i(34452);
            com.tencent.mm.aj.b qC = z.afa().qC(enterpriseConversationFmUI.fuO);
            long j = qC != null ? qC.field_wwCorpId : 0;
            long j2 = qC != null ? qC.field_wwUserVid : 0;
            int i3 = i2 > 0 ? 1 : 2;
            long adU = dVar == null ? 0 : dVar.adU();
            h.pYm.e(14507, Long.valueOf(j), Long.valueOf(adU), Long.valueOf(j2), Integer.valueOf(1), Integer.valueOf(i3), Integer.valueOf(i));
            ab.d("MicroMsg.EnterpriseConversationUI", "enter biz enterprise sub barnd report: %s,%s,%s,%s,%s,%s", Long.valueOf(j), Long.valueOf(adU), Long.valueOf(j2), Integer.valueOf(1), Integer.valueOf(i3), Integer.valueOf(i));
            AppMethodBeat.o(34452);
        }

        static /* synthetic */ void arW(String str) {
            AppMethodBeat.i(34454);
            aw.ZK();
            if (com.tencent.mm.model.c.XM().aoO(str) == null) {
                ab.e("MicroMsg.EnterpriseConversationUI", "changed biz stick status failed, contact is null, talker = ".concat(String.valueOf(str)));
                AppMethodBeat.o(34454);
                return;
            }
            aw.ZK();
            if (com.tencent.mm.model.c.XR().aph(str)) {
                t.x(str, true);
                AppMethodBeat.o(34454);
                return;
            }
            i.mn(str);
            AppMethodBeat.o(34454);
        }

        static /* synthetic */ String p(EnterpriseConversationFmUI enterpriseConversationFmUI) {
            String qT;
            AppMethodBeat.i(34455);
            if (enterpriseConversationFmUI.zup == null) {
                z.aeR();
                qT = e.qT(enterpriseConversationFmUI.fuO);
                if (bo.isNullOrNil(qT)) {
                    qT = "";
                }
                enterpriseConversationFmUI.zup = qT;
            }
            if (bo.isNullOrNil(enterpriseConversationFmUI.zup)) {
                AppMethodBeat.o(34455);
                return null;
            }
            qT = enterpriseConversationFmUI.zup;
            AppMethodBeat.o(34455);
            return qT;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(34457);
        super.onCreate(bundle);
        this.contentView = v.hu(this).inflate(R.layout.hj, null);
        setContentView(this.contentView);
        this.conversationFm = new EnterpriseConversationFmUI();
        getSupportFragmentManager().beginTransaction().a((int) R.id.a9e, this.conversationFm).commit();
        com.tencent.mm.pluginsdk.f.a(this, this.contentView);
        AppMethodBeat.o(34457);
    }

    public void finish() {
        AppMethodBeat.i(34458);
        if (this.conversationFm != null && (this.conversationFm instanceof EnterpriseConversationFmUI)) {
            ((EnterpriseConversationFmUI) this.conversationFm).fRR = System.currentTimeMillis() / 1000;
        }
        super.finish();
        AppMethodBeat.o(34458);
    }
}
