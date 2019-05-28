package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.plugin.account.model.i;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.f.a.c;
import com.tencent.mm.ui.f.a.e;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.tools.o;
import java.util.ArrayList;

public class InviteFacebookFriendsUI extends MMActivity implements f {
    private ProgressDialog ehJ = null;
    a gBv;
    private ListView gtT;
    private View gtV;
    String gtX;
    private final int gyc = 5;

    public static class a extends p<g> {
        private int[] gty;
        String gtz;
        private boolean[] gxh;

        public static class a {
            ImageView eks;
            TextView gtG;
            TextView gxk;
            CheckBox gxl;
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            AppMethodBeat.i(124894);
            g gVar = (g) obj;
            if (gVar == null) {
                gVar = new g();
            }
            gVar.d(cursor);
            AppMethodBeat.o(124894);
            return gVar;
        }

        public a(Context context, com.tencent.mm.ui.p.a aVar) {
            super(context, new g());
            AppMethodBeat.i(124888);
            super.a(aVar);
            AppMethodBeat.o(124888);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(124889);
            g gVar = (g) getItem(i);
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(this.context, R.layout.xs, null);
                aVar2.eks = (ImageView) view.findViewById(R.id.bo3);
                aVar2.gtG = (TextView) view.findViewById(R.id.bo4);
                aVar2.gxk = (TextView) view.findViewById(R.id.bo9);
                aVar2.gxl = (CheckBox) view.findViewById(R.id.bo_);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.gtG.setText(j.b(this.context, gVar.apL(), aVar.gtG.getTextSize()));
            Bitmap pS = b.pS(gVar.dtU);
            if (pS == null) {
                aVar.eks.setImageDrawable(com.tencent.mm.bz.a.g(this.context, R.raw.default_avatar));
            } else {
                aVar.eks.setImageBitmap(pS);
            }
            aVar.gxl.setChecked(this.gxh[i]);
            if (com.tencent.mm.plugin.account.a.getInviteFriendOpenStg().wi(Long.toString(gVar.dtU))) {
                aVar.gxk.setVisibility(0);
            } else {
                aVar.gxk.setVisibility(8);
            }
            AppMethodBeat.o(124889);
            return view;
        }

        public final long[] aqS() {
            int i = 0;
            AppMethodBeat.i(124890);
            int i2 = 0;
            for (boolean z : this.gxh) {
                if (z) {
                    i2++;
                }
            }
            long[] jArr = new long[i2];
            int i3 = 0;
            while (true) {
                int i4 = i;
                if (i4 < getCount()) {
                    if (this.gxh[i4]) {
                        i = i3 + 1;
                        jArr[i3] = ((g) getItem(i4)).dtU;
                        i2 = i;
                    } else {
                        i2 = i3;
                    }
                    i = i4 + 1;
                    i3 = i2;
                } else {
                    AppMethodBeat.o(124890);
                    return jArr;
                }
            }
        }

        public final void na(int i) {
            AppMethodBeat.i(124891);
            if (i < 0 || i >= this.gxh.length) {
                AppMethodBeat.o(124891);
                return;
            }
            boolean[] zArr = this.gxh;
            zArr[i] = !zArr[i];
            super.notifyDataSetChanged();
            AppMethodBeat.o(124891);
        }

        public final void KC() {
            AppMethodBeat.i(124892);
            h facebookFrdStg = com.tencent.mm.plugin.account.a.getFacebookFrdStg();
            String str = this.gtz;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" where facebookfriend.status = 102 ");
            if (str != null && str.length() > 0) {
                stringBuilder.append(" and ( ");
                stringBuilder.append("facebookfriend.fbname like '%" + str + "%' or ");
                stringBuilder.append("facebookfriend.nickname like '%" + str + "%' or ");
                stringBuilder.append("facebookfriend.username like '%" + str + "%' ) ");
            }
            setCursor(facebookFrdStg.fni.a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + stringBuilder.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null, 0));
            this.gty = new int[getCount()];
            this.gxh = new boolean[getCount()];
            super.notifyDataSetChanged();
            AppMethodBeat.o(124892);
        }

        public final void KD() {
            AppMethodBeat.i(124893);
            KC();
            AppMethodBeat.o(124893);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(124895);
        super.onCreate(bundle);
        setMMTitle((int) R.string.bmh);
        com.tencent.mm.kernel.g.Rg().a(32, (f) this);
        initView();
        AppMethodBeat.o(124895);
    }

    public void onDestroy() {
        AppMethodBeat.i(124896);
        com.tencent.mm.kernel.g.Rg().b(32, (f) this);
        this.gBv.bIf();
        super.onDestroy();
        AppMethodBeat.o(124896);
    }

    public final void initView() {
        AppMethodBeat.i(124897);
        this.gtT = (ListView) findViewById(R.id.bsq);
        final TextView textView = (TextView) findViewById(R.id.a74);
        textView.setText(R.string.bma);
        o oVar = new o((byte) 0);
        oVar.zHa = new o.b() {
            public final boolean vN(String str) {
                return false;
            }

            public final void vO(String str) {
                AppMethodBeat.i(124871);
                InviteFacebookFriendsUI.this.gtX = bo.vA(str);
                InviteFacebookFriendsUI inviteFacebookFriendsUI = InviteFacebookFriendsUI.this;
                if (inviteFacebookFriendsUI.gBv != null) {
                    a aVar = inviteFacebookFriendsUI.gBv;
                    aVar.gtz = bo.vA(inviteFacebookFriendsUI.gtX.trim());
                    aVar.bIf();
                    aVar.KC();
                }
                AppMethodBeat.o(124871);
            }

            public final void apo() {
            }

            public final void app() {
            }

            public final void apq() {
            }

            public final void apr() {
            }
        };
        a(oVar);
        this.gBv = new a(this, new com.tencent.mm.ui.p.a() {
            public final void apt() {
                AppMethodBeat.i(124873);
                if (r.Za()) {
                    if (InviteFacebookFriendsUI.this.gBv.getCount() == 0) {
                        textView.setVisibility(0);
                        AppMethodBeat.o(124873);
                        return;
                    }
                    textView.setVisibility(8);
                }
                AppMethodBeat.o(124873);
            }
        });
        this.gtT.setAdapter(this.gBv);
        this.gtV = findViewById(R.id.bss);
        this.gtT.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(124874);
                if (InviteFacebookFriendsUI.this.gBv.aqS().length >= 50) {
                    com.tencent.mm.ui.base.h.g(InviteFacebookFriendsUI.this, R.string.bmg, R.string.tz);
                    AppMethodBeat.o(124874);
                    return;
                }
                InviteFacebookFriendsUI.this.gBv.na(i - InviteFacebookFriendsUI.this.gtT.getHeaderViewsCount());
                if (InviteFacebookFriendsUI.this.gBv.aqS().length > 0) {
                    InviteFacebookFriendsUI.this.showOptionMenu(true);
                    AppMethodBeat.o(124874);
                    return;
                }
                InviteFacebookFriendsUI.this.showOptionMenu(false);
                AppMethodBeat.o(124874);
            }
        });
        ab.d("MicroMsg.InviteFacebookFriendsUI", "isBindForFacebookApp:" + r.Za());
        if (r.Za()) {
            this.gtT.setVisibility(0);
            this.gtV.setVisibility(8);
            long c = bo.c((Long) com.tencent.mm.kernel.g.RP().Ry().get(65831, null));
            String nullAsNil = bo.nullAsNil((String) com.tencent.mm.kernel.g.RP().Ry().get(65830, null));
            if (bo.gb(c) > 86400000 && nullAsNil.length() > 0) {
                c cVar = new c(getString(R.string.g7d));
                cVar.arX(nullAsNil);
                new com.tencent.mm.plugin.account.model.h(cVar, new i() {
                    public final void p(Bundle bundle) {
                        AppMethodBeat.i(124875);
                        super.p(bundle);
                        AppMethodBeat.o(124875);
                    }

                    public final void onError(int i, String str) {
                        AppMethodBeat.i(124876);
                        super.onError(i, str);
                        if (i == 3) {
                            InviteFacebookFriendsUI.c(InviteFacebookFriendsUI.this);
                        }
                        AppMethodBeat.o(124876);
                    }
                }).apm();
            }
            final m abVar = new com.tencent.mm.plugin.account.friend.a.ab();
            abVar.aqg();
            final ap apVar = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(124877);
                    com.tencent.mm.kernel.g.RP().Ry().set(65829, Integer.valueOf(1));
                    com.tencent.mm.kernel.g.Rg().a(abVar, 0);
                    AppMethodBeat.o(124877);
                    return false;
                }
            }, false);
            if (bo.h((Integer) com.tencent.mm.kernel.g.RP().Ry().get(65829, null)) > 0) {
                com.tencent.mm.kernel.g.RP().Ry().set(65829, Integer.valueOf(1));
                com.tencent.mm.kernel.g.Rg().a(abVar, 0);
            } else {
                apVar.ae(5000, 5000);
            }
            Context context = this.mController.ylL;
            getString(R.string.tz);
            this.ehJ = com.tencent.mm.ui.base.h.b(context, getString(R.string.df7), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(124878);
                    apVar.stopTimer();
                    com.tencent.mm.kernel.g.Rg().c(abVar);
                    AppMethodBeat.o(124878);
                }
            });
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(124879);
                InviteFacebookFriendsUI.this.aqX();
                InviteFacebookFriendsUI.this.finish();
                AppMethodBeat.o(124879);
                return true;
            }
        });
        AnonymousClass9 anonymousClass9 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(124880);
                BackwardSupportUtil.c.a(InviteFacebookFriendsUI.this.gtT);
                AppMethodBeat.o(124880);
            }
        };
        addTextOptionMenu(0, getString(R.string.bme), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(124887);
                c cVar = new c(InviteFacebookFriendsUI.this.getString(R.string.g7d));
                Bundle bundle = new Bundle();
                bundle.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, InviteFacebookFriendsUI.this.getString(R.string.bmd));
                final long[] aqS = InviteFacebookFriendsUI.this.gBv.aqS();
                String l = Long.toString(aqS[0]);
                for (int i = 1; i < aqS.length; i++) {
                    l = (l + ",") + Long.toString(aqS[i]);
                }
                bundle.putString("to", l);
                cVar.a(InviteFacebookFriendsUI.this, "apprequests", bundle, new com.tencent.mm.ui.f.a.c.a() {
                    public final void a(e eVar) {
                        AppMethodBeat.i(124883);
                        ab.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
                        AppMethodBeat.o(124883);
                    }

                    public final void a(com.tencent.mm.ui.f.a.b bVar) {
                        AppMethodBeat.i(124884);
                        ab.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
                        AppMethodBeat.o(124884);
                    }

                    public final void p(Bundle bundle) {
                        AppMethodBeat.i(124885);
                        ab.i("MicroMsg.InviteFacebookFriendsUI", "fbinvite oncomplete");
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(new com.tencent.mm.az.h.a(33, Integer.toString(aqS.length)));
                        ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XL().c(new com.tencent.mm.az.h(arrayList));
                        for (long j : aqS) {
                            com.tencent.mm.plugin.account.friend.a.p pVar = new com.tencent.mm.plugin.account.friend.a.p();
                            pVar.username = Long.toString(j);
                            pVar.gvE = 5;
                            pVar.fvK = (int) bo.anT();
                            com.tencent.mm.plugin.account.a.getInviteFriendOpenStg().b(pVar);
                        }
                        com.tencent.mm.ui.base.h.a(InviteFacebookFriendsUI.this, (int) R.string.bmf, (int) R.string.tz, (int) R.string.up, (int) R.string.s2, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(124881);
                                InviteFacebookFriendsUI.this.gBv.KC();
                                AppMethodBeat.o(124881);
                            }
                        }, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(124882);
                                InviteFacebookFriendsUI.this.finish();
                                AppMethodBeat.o(124882);
                            }
                        });
                        AppMethodBeat.o(124885);
                    }

                    public final void onCancel() {
                        AppMethodBeat.i(124886);
                        ab.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite cancle");
                        AppMethodBeat.o(124886);
                    }
                });
                AppMethodBeat.o(124887);
                return true;
            }
        });
        showOptionMenu(false);
        AppMethodBeat.o(124897);
    }

    private void bj(String str, String str2) {
        AppMethodBeat.i(124898);
        com.tencent.mm.ui.base.h.a((Context) this, str2, str, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(124872);
                Intent intent = new Intent(InviteFacebookFriendsUI.this.mController.ylL, FacebookAuthUI.class);
                intent.putExtra("is_force_unbind", true);
                InviteFacebookFriendsUI.this.mController.ylL.startActivity(intent);
                InviteFacebookFriendsUI.this.finish();
                AppMethodBeat.o(124872);
            }
        }, null);
        AppMethodBeat.o(124898);
    }

    public final int getLayoutId() {
        return R.layout.ze;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(124899);
        ab.i("MicroMsg.InviteFacebookFriendsUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (mVar.getType() != 32) {
            AppMethodBeat.o(124899);
            return;
        }
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (i == 4 && i2 == -68) {
            if (bo.isNullOrNil(str)) {
                str = "error";
            }
            bj(getString(R.string.tz), str);
            AppMethodBeat.o(124899);
        } else if (i == 0 && i2 == 0) {
            this.gBv.a(null, null);
            AppMethodBeat.o(124899);
        } else {
            Toast.makeText(this, R.string.d08, 0).show();
            AppMethodBeat.o(124899);
        }
    }

    static /* synthetic */ void c(InviteFacebookFriendsUI inviteFacebookFriendsUI) {
        AppMethodBeat.i(124900);
        ab.e("MicroMsg.InviteFacebookFriendsUI", "dealWithRefreshTokenFail");
        inviteFacebookFriendsUI.bj(inviteFacebookFriendsUI.getString(R.string.tz), inviteFacebookFriendsUI.getString(R.string.bmb));
        AppMethodBeat.o(124900);
    }
}
