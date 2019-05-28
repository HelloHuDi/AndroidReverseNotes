package com.tencent.mm.plugin.nearby.ui;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;

public class NearbySayHiListUI extends MMActivity implements f {
    private int ehD = 0;
    private ListView gtT;
    private View gwR;
    private d jKa = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(55495);
            g.RN().QU();
            ((j) g.K(j.class)).bOo().QT(String.valueOf(NearbySayHiListUI.this.oQN));
            NearbySayHiListUI.this.oQJ.a(null, null);
            if (NearbySayHiListUI.this.oQK > 0) {
                NearbySayHiListUI.this.oQK = NearbySayHiListUI.this.oQK - 1;
            }
            NearbySayHiListUI.j(NearbySayHiListUI.this);
            AppMethodBeat.o(55495);
        }
    };
    private int limit = 0;
    private c oPQ;
    private bg oQI = null;
    private a oQJ;
    private int oQK = 0;
    private int oQL = 0;
    private boolean oQM;
    private long oQN;
    private p tipDialog = null;

    class a extends com.tencent.mm.ui.p<bf> {
        private MMActivity crP;
        protected MMSlideDelView.g jJO;
        protected MMSlideDelView.c jJP;
        protected MMSlideDelView.d jJR = MMSlideDelView.getItemStatusCallBack();
        int limit = -1;
        private bg oQI;
        protected MMSlideDelView.f oQS;

        class a {
            ImageView eks;
            TextView gtG;
            View jJW;
            TextView jJX;
            TextView ooM;

            a() {
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            AppMethodBeat.i(55512);
            bf bfVar = (bf) obj;
            if (bfVar == null) {
                bfVar = new bf();
            }
            bfVar.d(cursor);
            AppMethodBeat.o(55512);
            return bfVar;
        }

        public a(Context context, bg bgVar, int i) {
            super(context, new bf());
            AppMethodBeat.i(55508);
            this.crP = (MMActivity) context;
            this.limit = i;
            this.oQI = bgVar;
            AppMethodBeat.o(55508);
        }

        public final void setPerformItemClickListener(MMSlideDelView.g gVar) {
            this.jJO = gVar;
        }

        public final void a(MMSlideDelView.f fVar) {
            this.oQS = fVar;
        }

        public final void setGetViewPositionCallback(MMSlideDelView.c cVar) {
            this.jJP = cVar;
        }

        public final void KD() {
            AppMethodBeat.i(55509);
            KC();
            AppMethodBeat.o(55509);
        }

        public final void KC() {
            AppMethodBeat.i(55510);
            if (com.tencent.mm.bn.a.dgL()) {
                setCursor(this.oQI.Mq(this.limit));
            } else {
                setCursor(this.oQI.xm(this.limit));
            }
            super.notifyDataSetChanged();
            AppMethodBeat.o(55510);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            CharSequence charSequence;
            AppMethodBeat.i(55511);
            bf bfVar = (bf) getItem(i);
            if (view == null) {
                a aVar2 = new a();
                View view2 = (MMSlideDelView) View.inflate(this.crP, R.layout.g8, null);
                View inflate = View.inflate(this.crP, R.layout.ap4, null);
                aVar2.eks = (ImageView) inflate.findViewById(R.id.bo3);
                aVar2.gtG = (TextView) inflate.findViewById(R.id.e4_);
                aVar2.ooM = (TextView) inflate.findViewById(R.id.e4a);
                aVar2.jJW = view2.findViewById(R.id.a4b);
                aVar2.jJX = (TextView) view2.findViewById(R.id.nu);
                view2.setView(inflate);
                view2.setPerformItemClickListener(this.jJO);
                view2.setGetViewPositionCallback(this.jJP);
                view2.setItemStatusCallBack(this.jJR);
                view2.setEnable(false);
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            if (bfVar.field_flag != 0) {
                charSequence = bi.d.apF(bfVar.field_content).nickname;
            } else {
                charSequence = bfVar.field_talker;
            }
            aVar.gtG.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.crP, charSequence, aVar.gtG.getTextSize()));
            aVar.ooM.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.crP, bfVar.field_sayhicontent, aVar.ooM.getTextSize()));
            aVar.jJW.setTag(Long.valueOf(bfVar.field_svrid));
            aVar.jJW.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(55507);
                    ab.v("MicroMsg.SayHiAdapter", "on delView clicked");
                    a.this.jJR.bIq();
                    if (a.this.oQS != null) {
                        a.this.oQS.bN(view.getTag());
                    }
                    AppMethodBeat.o(55507);
                }
            });
            b.b(aVar.eks, bfVar.field_sayhiuser);
            AppMethodBeat.o(55511);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public NearbySayHiListUI() {
        AppMethodBeat.i(55513);
        AppMethodBeat.o(55513);
    }

    public void onCreate(Bundle bundle) {
        int i;
        NearbySayHiListUI nearbySayHiListUI;
        AppMethodBeat.i(55514);
        super.onCreate(bundle);
        this.ehD = bo.ank(com.tencent.mm.m.g.Nu().getValue("ThresholdToCleanLocation"));
        this.oQM = getIntent().getBooleanExtra("show_clear_header", false);
        g.RN().QU();
        this.oQI = (bg) ((j) g.K(j.class)).bOo();
        setMMTitle((int) R.string.dx5);
        this.oQL = this.oQI.baS();
        this.oQK = this.oQI.getCount();
        if (com.tencent.mm.bn.a.dgL()) {
            i = this.oQK;
            nearbySayHiListUI = this;
        } else if (this.oQL == 0) {
            i = 8;
            nearbySayHiListUI = this;
        } else {
            i = this.oQL;
            nearbySayHiListUI = this;
        }
        nearbySayHiListUI.limit = i;
        bg bgVar = this.oQI;
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(4));
        if (bgVar.bSd.update(bgVar.getTableName(), contentValues, "status!=? ", new String[]{"4"}) != 0) {
            bgVar.doNotify();
        }
        initView();
        AppMethodBeat.o(55514);
    }

    public void onResume() {
        AppMethodBeat.i(55515);
        super.onResume();
        if (this.oQK != this.oQI.getCount()) {
            this.oQK = this.oQI.getCount();
            if (this.oQK == 0) {
                TextView textView = (TextView) findViewById(R.id.a74);
                textView.setText(R.string.dx8);
                textView.setVisibility(0);
                enableOptionMenu(false);
            }
            this.oQJ.KC();
        }
        this.oQJ.notifyDataSetChanged();
        g.Rg().a(148, (f) this);
        AppMethodBeat.o(55515);
    }

    public void onDestroy() {
        AppMethodBeat.i(55516);
        this.oQJ.bIf();
        super.onDestroy();
        AppMethodBeat.o(55516);
    }

    public void onPause() {
        AppMethodBeat.i(55517);
        g.Rg().b(148, (f) this);
        super.onPause();
        AppMethodBeat.o(55517);
    }

    public final int getLayoutId() {
        return R.layout.a9t;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(55518);
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(55518);
        return onKeyDown;
    }

    public final void initView() {
        AppMethodBeat.i(55519);
        this.gtT = (ListView) findViewById(R.id.cp9);
        if (!com.tencent.mm.bn.a.dgL()) {
            final View inflate = getLayoutInflater().inflate(R.layout.ap5, null);
            inflate.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(55493);
                    NearbySayHiListUI.this.limit = NearbySayHiListUI.this.limit + 8;
                    ab.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + NearbySayHiListUI.this.limit);
                    a b = NearbySayHiListUI.this.oQJ;
                    int a = NearbySayHiListUI.this.limit;
                    b.bIf();
                    b.limit = a;
                    b.KC();
                    if (NearbySayHiListUI.this.oQK <= NearbySayHiListUI.this.limit) {
                        NearbySayHiListUI.this.gtT.removeFooterView(inflate);
                        ab.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + NearbySayHiListUI.this.limit);
                    }
                    AppMethodBeat.o(55493);
                }
            });
            if (this.oQK > 0 && this.limit < this.oQK) {
                this.gtT.addFooterView(inflate);
            }
        }
        addTextOptionMenu(0, getString(R.string.ou), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(55498);
                h.a(NearbySayHiListUI.this.mController.ylL, true, NearbySayHiListUI.this.getResources().getString(R.string.dx3), "", NearbySayHiListUI.this.getResources().getString(R.string.dx2), NearbySayHiListUI.this.getString(R.string.or), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(55497);
                        NearbySayHiListUI.this.oQI.axQ();
                        NearbySayHiListUI.this.oQJ.KC();
                        TextView textView = (TextView) NearbySayHiListUI.this.findViewById(R.id.a74);
                        textView.setText(R.string.dx8);
                        textView.setVisibility(0);
                        NearbySayHiListUI.this.enableOptionMenu(false);
                        AppMethodBeat.o(55497);
                    }
                }, null);
                AppMethodBeat.o(55498);
                return true;
            }
        });
        if (this.oQK == 0) {
            TextView textView = (TextView) findViewById(R.id.a74);
            textView.setText(R.string.dx8);
            textView.setVisibility(0);
            enableOptionMenu(false);
        }
        if (this.oQM && this.ehD != 0 && this.oQL >= this.ehD && bo.gT(this)) {
            this.gwR = new CleanLocationHeaderView(this);
            this.gwR.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(55500);
                    NearbySayHiListUI.this.oPQ = new c(2, 0.0f, 0.0f, 0, 0, "", "");
                    g.Rg().a(NearbySayHiListUI.this.oPQ, 0);
                    NearbySayHiListUI nearbySayHiListUI = NearbySayHiListUI.this;
                    Context context = NearbySayHiListUI.this.mController.ylL;
                    NearbySayHiListUI.this.getString(R.string.tz);
                    nearbySayHiListUI.tipDialog = h.b(context, NearbySayHiListUI.this.getString(R.string.d4m), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(55499);
                            g.Rg().c(NearbySayHiListUI.this.oPQ);
                            AppMethodBeat.o(55499);
                        }
                    });
                    com.tencent.mm.plugin.report.service.h.pYm.X(11429, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    AppMethodBeat.o(55500);
                }
            });
            this.gtT.addHeaderView(this.gwR);
        }
        this.oQJ = new a(this, this.oQI, this.limit);
        this.oQJ.setGetViewPositionCallback(new MMSlideDelView.c() {
            public final int cZ(View view) {
                AppMethodBeat.i(55501);
                int positionForView = NearbySayHiListUI.this.gtT.getPositionForView(view);
                AppMethodBeat.o(55501);
                return positionForView;
            }
        });
        this.oQJ.setPerformItemClickListener(new MMSlideDelView.g() {
            public final void q(View view, int i, int i2) {
                AppMethodBeat.i(55502);
                NearbySayHiListUI.this.gtT.performItemClick(view, i, (long) i2);
                AppMethodBeat.o(55502);
            }
        });
        this.oQJ.a(new MMSlideDelView.f() {
            public final void bN(Object obj) {
                AppMethodBeat.i(55503);
                if (obj == null) {
                    ab.e("MicroMsg.SayHiListUI", "onItemDel object null");
                    AppMethodBeat.o(55503);
                    return;
                }
                g.RN().QU();
                ((j) g.K(j.class)).bOo().QT(obj.toString());
                NearbySayHiListUI.this.oQJ.a(null, null);
                AppMethodBeat.o(55503);
            }
        });
        this.gtT.setAdapter(this.oQJ);
        final com.tencent.mm.ui.tools.j jVar = new com.tencent.mm.ui.tools.j(this);
        this.gtT.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(55504);
                if (i < NearbySayHiListUI.this.gtT.getHeaderViewsCount()) {
                    ab.w("MicroMsg.SayHiListUI", "on header view long click, ignore");
                    AppMethodBeat.o(55504);
                } else {
                    jVar.a(view, i, j, NearbySayHiListUI.this, NearbySayHiListUI.this.jKa);
                    AppMethodBeat.o(55504);
                }
                return true;
            }
        });
        this.gtT.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(55505);
                if (NearbySayHiListUI.this.gtT.getHeaderViewsCount() > 0) {
                    i -= NearbySayHiListUI.this.gtT.getHeaderViewsCount();
                }
                bf bfVar = (bf) NearbySayHiListUI.this.oQJ.getItem(i);
                if (bfVar == null || bfVar.field_content == null) {
                    AppMethodBeat.o(55505);
                    return;
                }
                bi.d apF = bi.d.apF(bfVar.field_content);
                Intent intent = new Intent();
                if (com.tencent.mm.bn.a.dgL()) {
                    intent.putExtra("Chat_User", bfVar.field_sayhiencryptuser);
                    intent.putExtra("lbs_mode", true);
                    intent.putExtra("add_scene", 18);
                    com.tencent.mm.plugin.nearby.a.gkE.d(intent, NearbySayHiListUI.this);
                } else {
                    String str;
                    Intent intent2 = new Intent();
                    String str2 = "Contact_User";
                    if (bo.isNullOrNil(apF.svN)) {
                        str = bfVar.field_sayhiuser;
                    } else {
                        str = apF.svN;
                    }
                    intent2.putExtra(str2, str);
                    intent2.putExtra("Contact_Alias", apF.dFl);
                    intent2.putExtra("Contact_Nick", apF.nickname);
                    intent2.putExtra("Contact_QuanPin", apF.gwG);
                    intent2.putExtra("Contact_PyInitial", apF.gwF);
                    intent2.putExtra("Contact_Sex", apF.dtS);
                    intent2.putExtra("Contact_Signature", apF.signature);
                    intent2.putExtra("Contact_Scene", apF.scene);
                    intent2.putExtra("Contact_FMessageCard", true);
                    intent2.putExtra("Contact_City", apF.getCity());
                    intent2.putExtra("Contact_Province", apF.getProvince());
                    intent2.putExtra("Contact_Content", bo.isNullOrNil(bfVar.field_sayhicontent) ? NearbySayHiListUI.this.getString(R.string.al3) : bfVar.field_sayhicontent);
                    intent2.putExtra("Contact_verify_Scene", apF.scene);
                    intent2.putExtra("Contact_Uin", apF.pnz);
                    intent2.putExtra("Contact_QQNick", apF.gwH);
                    intent2.putExtra("Contact_Mobile_MD5", apF.xZi);
                    intent2.putExtra("User_From_Fmessage", true);
                    intent2.putExtra("Contact_from_msgType", 37);
                    intent2.putExtra("Verify_ticket", apF.mGZ);
                    intent2.putExtra("Contact_Source_FMessage", apF.scene);
                    intent2.putExtra("Contact_ShowFMessageList", true);
                    ad aoO = ((j) g.K(j.class)).XM().aoO(apF.svN);
                    if (!(aoO == null || ((int) aoO.ewQ) < 0 || com.tencent.mm.n.a.jh(aoO.field_type))) {
                        int i2 = apF.cAd;
                        if (i2 == 0 || i2 == 2 || i2 == 5) {
                            intent2.putExtra("User_Verify", true);
                        }
                        intent2.putExtra("Contact_IsLBSFriend", true);
                        intent2.putExtra("Sns_from_Scene", 18);
                    }
                    com.tencent.mm.plugin.nearby.a.gkE.c(intent2, NearbySayHiListUI.this);
                }
                i iVar = new i();
                iVar.csa.scene = apF.scene;
                com.tencent.mm.sdk.b.a.xxA.m(iVar);
                AppMethodBeat.o(55505);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(55506);
                NearbySayHiListUI.this.aqX();
                NearbySayHiListUI.this.setResult(0);
                NearbySayHiListUI.this.finish();
                AppMethodBeat.o(55506);
                return true;
            }
        });
        AnonymousClass2 anonymousClass2 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(55494);
                BackwardSupportUtil.c.a(NearbySayHiListUI.this.gtT);
                AppMethodBeat.o(55494);
            }
        };
        AppMethodBeat.o(55519);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(55520);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        bf bfVar = (bf) this.oQJ.getItem(adapterContextMenuInfo.position);
        if (bfVar == null) {
            ab.e("MicroMsg.SayHiListUI", "onItemLongClick, item is null, pos = " + adapterContextMenuInfo.position);
            AppMethodBeat.o(55520);
            return;
        }
        contextMenu.add(0, 0, 0, R.string.p4);
        this.oQN = bfVar.field_svrid;
        AppMethodBeat.o(55520);
    }

    public void onBackPressed() {
        AppMethodBeat.i(55521);
        setResult(0);
        super.onBackPressed();
        AppMethodBeat.o(55521);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(55522);
        ab.i("MicroMsg.SayHiListUI", "onSceneEnd: errType=%d, errCode=%d, errMsg=%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (i != 0 || i2 != 0) {
            ab.w("MicroMsg.SayHiListUI", "[cpan] clear location failed.");
        } else if (((c) mVar).Ah() == 2) {
            h.a(this.mController.ylL, getString(R.string.d4l), "", new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(55496);
                    NearbySayHiListUI.this.setResult(-1);
                    NearbySayHiListUI.this.finish();
                    AppMethodBeat.o(55496);
                }
            });
            this.oPQ = null;
            AppMethodBeat.o(55522);
            return;
        }
        AppMethodBeat.o(55522);
    }

    static /* synthetic */ void j(NearbySayHiListUI nearbySayHiListUI) {
        AppMethodBeat.i(55523);
        if (nearbySayHiListUI.oQK == 0) {
            TextView textView = (TextView) nearbySayHiListUI.findViewById(R.id.a74);
            textView.setText(R.string.dx8);
            textView.setVisibility(0);
            nearbySayHiListUI.enableOptionMenu(false);
        }
        AppMethodBeat.o(55523);
    }
}
