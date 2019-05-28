package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.aa;
import com.tencent.mm.plugin.account.friend.a.p;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.plugin.appbrand.jsapi.g.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.auv;
import com.tencent.mm.protocal.protobuf.bea;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import junit.framework.Assert;

public class RecommendFriendUI extends MMActivity implements f {
    private ProgressDialog ehJ = null;
    private b gxY;
    private ListView gxZ;
    private LinkedList<aco> gxf = new LinkedList();
    private boolean gxg;
    private TextView gya;
    private LinkedList<bed> gyb = new LinkedList();
    private int gyc = -1;
    private boolean gyd = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RecommendFriendUI() {
        AppMethodBeat.i(108634);
        AppMethodBeat.o(108634);
    }

    static /* synthetic */ void a(RecommendFriendUI recommendFriendUI, int i) {
        AppMethodBeat.i(108645);
        recommendFriendUI.nb(i);
        AppMethodBeat.o(108645);
    }

    static /* synthetic */ void d(RecommendFriendUI recommendFriendUI) {
        AppMethodBeat.i(108647);
        recommendFriendUI.goBack();
        AppMethodBeat.o(108647);
    }

    public final int getLayoutId() {
        return R.layout.a88;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(108635);
        super.onCreate(bundle);
        this.gyc = bo.getInt(getIntent().getStringExtra("recommend_type"), 0);
        this.gxg = false;
        g.Rg().a((int) b.CTRL_INDEX, (f) this);
        initView();
        AppMethodBeat.o(108635);
    }

    public final void initView() {
        AppMethodBeat.i(108636);
        this.gya = (TextView) findViewById(R.id.cj4);
        if (this.gyc == 1) {
            setMMTitle((int) R.string.e_q);
            this.gya.setText(R.string.e_u);
        } else if (this.gyc == 2) {
            setMMTitle((int) R.string.e_p);
            this.gya.setText(R.string.e_t);
        } else {
            setMMTitle((int) R.string.e7m);
            this.gya.setText(R.string.e_v);
        }
        this.gxY = new b(getLayoutInflater());
        this.gxZ = (ListView) findViewById(R.id.cj3);
        this.gxZ.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 0;
                AppMethodBeat.i(108627);
                if (RecommendFriendUI.this.gxg) {
                    RecommendFriendUI recommendFriendUI = RecommendFriendUI.this;
                    b b = RecommendFriendUI.this.gxY;
                    if (b.gxg) {
                        i2 = ((aco) b.gxf.get(i)).weB;
                    }
                    RecommendFriendUI.a(recommendFriendUI, i2);
                    AppMethodBeat.o(108627);
                    return;
                }
                RecommendFriendUI.this.gxY.na(i);
                if (RecommendFriendUI.this.gxY.aqw().length > 0) {
                    RecommendFriendUI.this.showOptionMenu(true);
                    AppMethodBeat.o(108627);
                    return;
                }
                RecommendFriendUI.this.showOptionMenu(false);
                AppMethodBeat.o(108627);
            }
        });
        this.gxZ.setAdapter(this.gxY);
        addTextOptionMenu(0, getString(R.string.cer), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(108629);
                int length = RecommendFriendUI.this.gxY.aqw().length;
                h.a(RecommendFriendUI.this.mController.ylL, RecommendFriendUI.this.mController.ylL.getResources().getQuantityString(R.plurals.q, length, new Object[]{Integer.valueOf(length)}), RecommendFriendUI.this.getString(R.string.tz), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(108628);
                        RecommendFriendUI.c(RecommendFriendUI.this);
                        AppMethodBeat.o(108628);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(108629);
                return true;
            }
        });
        showOptionMenu(false);
        aqx();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(108630);
                RecommendFriendUI.d(RecommendFriendUI.this);
                AppMethodBeat.o(108630);
                return true;
            }
        });
        AnonymousClass4 anonymousClass4 = new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(108631);
                c.a(RecommendFriendUI.this.gxZ);
                AppMethodBeat.o(108631);
            }
        };
        AppMethodBeat.o(108636);
    }

    private void goBack() {
        AppMethodBeat.i(108637);
        if (this.gyc != 0) {
            finish();
            AppMethodBeat.o(108637);
        } else if (this.gxg || this.gyd) {
            finish();
            AppMethodBeat.o(108637);
        } else {
            aqz();
            AppMethodBeat.o(108637);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(108638);
        if (i == 4) {
            goBack();
            AppMethodBeat.o(108638);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(108638);
        return onKeyDown;
    }

    public void onDestroy() {
        AppMethodBeat.i(108639);
        g.Rg().b((int) b.CTRL_INDEX, (f) this);
        super.onDestroy();
        AppMethodBeat.o(108639);
    }

    private void aqx() {
        AppMethodBeat.i(108640);
        this.gyd = true;
        final m aaVar = new aa(this.gyc);
        g.Rg().a(aaVar, 0);
        Context context = this.mController.ylL;
        getString(R.string.tz);
        this.ehJ = h.b(context, getString(R.string.ceu), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(108632);
                g.Rg().c(aaVar);
                RecommendFriendUI.this.finish();
                AppMethodBeat.o(108632);
            }
        });
        AppMethodBeat.o(108640);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(108641);
        ab.i("MicroMsg.RecommendFriendUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (i == 0 && i2 == 0 && mVar.getType() == b.CTRL_INDEX) {
            this.gyb = ((bea) ((aa) mVar).ehh.fsH.fsP).ndm;
            this.gxf = ((bea) ((aa) mVar).ehh.fsH.fsP).vFk;
            this.gyd = false;
            if (this.gyb.size() <= 0) {
                aqy();
                AppMethodBeat.o(108641);
                return;
            } else if (this.gyc == 0 && this.gxf.size() <= 0) {
                aqy();
                AppMethodBeat.o(108641);
                return;
            } else if (this.gyc != 0) {
                nb(-1);
                AppMethodBeat.o(108641);
                return;
            } else {
                aqz();
                AppMethodBeat.o(108641);
                return;
            }
        }
        aqy();
        AppMethodBeat.o(108641);
    }

    private void aqy() {
        AppMethodBeat.i(108642);
        this.gya.setVisibility(0);
        this.gxZ.setVisibility(8);
        AppMethodBeat.o(108642);
    }

    private void nb(int i) {
        AppMethodBeat.i(108643);
        ab.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendSuccess  respList.size:" + this.gyb.size());
        this.gxY.a(this.gyb, i);
        this.gxZ.setAdapter(this.gxY);
        this.gxg = false;
        if (this.gyc == 0) {
            String str = "";
            int i2 = 0;
            while (i2 < this.gxf.size()) {
                String str2;
                if (i == ((aco) this.gxf.get(i2)).weB) {
                    str2 = ((aco) this.gxf.get(i2)).wkk;
                } else {
                    str2 = str;
                }
                i2++;
                str = str2;
            }
            setMMTitle(str);
        }
        this.gxY.gxg = this.gxg;
        this.gxY.notifyDataSetChanged();
        AppMethodBeat.o(108643);
    }

    private void aqz() {
        AppMethodBeat.i(108644);
        Assert.assertTrue("dealGetInviteFriendGroupSuccess just only qq", this.gyc == 0);
        ab.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendGroupSuccess  respList.size:" + this.gxf.size());
        this.gxY.gxf = this.gxf;
        this.gxZ.setAdapter(this.gxY);
        showOptionMenu(false);
        this.gxg = true;
        setMMTitle((int) R.string.e7m);
        this.gxY.gxg = this.gxg;
        this.gxY.notifyDataSetChanged();
        AppMethodBeat.o(108644);
    }

    static /* synthetic */ void c(RecommendFriendUI recommendFriendUI) {
        AppMethodBeat.i(108646);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < recommendFriendUI.gxY.aqw().length) {
                auv auv = new auv();
                auv.jBB = bo.nullAsNil(recommendFriendUI.gxY.aqw()[i2]);
                auv.wyY = recommendFriendUI.gyc;
                ((j) g.K(j.class)).XL().c(new a(22, auv));
                p pVar = new p();
                pVar.username = recommendFriendUI.gxY.aqw()[i2];
                pVar.gvE = recommendFriendUI.gyc;
                pVar.fvK = (int) bo.anT();
                ((q) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getInviteFriendOpenStg()).b(pVar);
                i = i2 + 1;
            } else {
                h.a(recommendFriendUI.mController.ylL, (int) R.string.ces, (int) R.string.tz, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(108633);
                        RecommendFriendUI.this.finish();
                        AppMethodBeat.o(108633);
                    }
                });
                AppMethodBeat.o(108646);
                return;
            }
        }
    }
}
