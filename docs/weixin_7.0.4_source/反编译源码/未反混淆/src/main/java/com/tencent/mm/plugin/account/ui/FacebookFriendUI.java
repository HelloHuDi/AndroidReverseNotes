package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.model.h;
import com.tencent.mm.plugin.account.model.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.f.a.c;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.tools.o.b;

@Deprecated
public class FacebookFriendUI extends MMActivity implements a, f {
    private ProgressDialog ehJ = null;
    d gBe;
    private ListView gtT;
    private View gtV;
    String gtX;
    private TextView gtY = null;
    private boolean gxV = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(124820);
        super.onCreate(bundle);
        setMMTitle((int) R.string.btc);
        g.Rg().a(32, (f) this);
        initView();
        AppMethodBeat.o(124820);
    }

    public void onResume() {
        AppMethodBeat.i(124821);
        super.onResume();
        o.acd().d(this);
        this.gBe.notifyDataSetChanged();
        AppMethodBeat.o(124821);
    }

    public void onPause() {
        AppMethodBeat.i(124822);
        super.onPause();
        o.acd().e(this);
        AppMethodBeat.o(124822);
    }

    public void onDestroy() {
        AppMethodBeat.i(124823);
        g.Rg().b(32, (f) this);
        this.gBe.bIf();
        super.onDestroy();
        AppMethodBeat.o(124823);
    }

    public final int getLayoutId() {
        return R.layout.ze;
    }

    public final void initView() {
        AppMethodBeat.i(124824);
        this.gtT = (ListView) findViewById(R.id.bsq);
        this.gtY = (TextView) findViewById(R.id.bsr);
        this.gtY.setText(R.string.bmc);
        final TextView textView = (TextView) findViewById(R.id.a74);
        textView.setText(R.string.bma);
        com.tencent.mm.ui.tools.o oVar = new com.tencent.mm.ui.tools.o((byte) 0);
        oVar.zHa = new b() {
            public final boolean vN(String str) {
                return false;
            }

            public final void vO(String str) {
                AppMethodBeat.i(124807);
                FacebookFriendUI.this.gtX = bo.vA(str);
                FacebookFriendUI facebookFriendUI = FacebookFriendUI.this;
                if (facebookFriendUI.gBe != null) {
                    facebookFriendUI.gBe.vM(facebookFriendUI.gtX);
                }
                AppMethodBeat.o(124807);
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
        this.gBe = new d(this, new p.a() {
            public final void apt() {
                AppMethodBeat.i(124811);
                if (r.Za() && FacebookFriendUI.this.gxV) {
                    if (FacebookFriendUI.this.gBe.getCount() == 0) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                }
                FacebookFriendUI.this.gxV = false;
                AppMethodBeat.o(124811);
            }
        });
        this.gBe.gBa = new d.a() {
            public final void mT(int i) {
                AppMethodBeat.i(124812);
                if (i > 0) {
                    FacebookFriendUI.this.gtY.setVisibility(8);
                    AppMethodBeat.o(124812);
                    return;
                }
                FacebookFriendUI.this.gtY.setVisibility(0);
                AppMethodBeat.o(124812);
            }
        };
        this.gtT.setAdapter(this.gBe);
        this.gtV = findViewById(R.id.bss);
        this.gtT.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(124813);
                com.tencent.mm.plugin.account.friend.a.g gVar = (com.tencent.mm.plugin.account.friend.a.g) FacebookFriendUI.this.gBe.getItem(i - FacebookFriendUI.this.gtT.getHeaderViewsCount());
                if (gVar.status == 100 || gVar.status == 101) {
                    Intent intent = new Intent();
                    intent.putExtra("Contact_User", gVar.getUsername());
                    intent.putExtra("Contact_Nick", gVar.apD());
                    intent.putExtra("Contact_KFacebookId", gVar.dtU);
                    intent.putExtra("Contact_KFacebookName", gVar.apL());
                    intent.putExtra("Contact_Scene", 31);
                    com.tencent.mm.plugin.account.a.a.gkE.c(intent, FacebookFriendUI.this);
                }
                if (gVar.status == 102) {
                    AppMethodBeat.o(124813);
                } else {
                    AppMethodBeat.o(124813);
                }
            }
        });
        ab.d("MicroMsg.FacebookFriendUI", "isBindForFacebookApp:" + r.Za());
        if (r.Za()) {
            this.gtT.setVisibility(0);
            this.gtV.setVisibility(8);
            long c = bo.c((Long) g.RP().Ry().get(65831, null));
            String nullAsNil = bo.nullAsNil((String) g.RP().Ry().get(65830, null));
            if (bo.gb(c) > 86400000 && nullAsNil.length() > 0) {
                c cVar = new c(getString(R.string.g7d));
                cVar.arX(nullAsNil);
                new h(cVar, new i() {
                    public final void p(Bundle bundle) {
                        AppMethodBeat.i(124814);
                        super.p(bundle);
                        AppMethodBeat.o(124814);
                    }

                    public final void onError(int i, String str) {
                        AppMethodBeat.i(124815);
                        super.onError(i, str);
                        if (i == 3) {
                            FacebookFriendUI.f(FacebookFriendUI.this);
                        }
                        AppMethodBeat.o(124815);
                    }
                }).apm();
            }
            final m abVar = new com.tencent.mm.plugin.account.friend.a.ab();
            abVar.aqg();
            final ap apVar = new ap(new ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(124816);
                    g.RP().Ry().set(65829, Integer.valueOf(1));
                    g.Rg().a(abVar, 0);
                    AppMethodBeat.o(124816);
                    return false;
                }
            }, false);
            if (bo.h((Integer) g.RP().Ry().get(65829, null)) > 0) {
                g.RP().Ry().set(65829, Integer.valueOf(1));
                g.Rg().a(abVar, 0);
            } else {
                apVar.ae(5000, 5000);
            }
            Context context = this.mController.ylL;
            getString(R.string.tz);
            this.ehJ = com.tencent.mm.ui.base.h.b(context, getString(R.string.df7), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(124817);
                    apVar.stopTimer();
                    g.Rg().c(abVar);
                    AppMethodBeat.o(124817);
                }
            });
            addTextOptionMenu(0, getString(R.string.btd), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(124818);
                    FacebookFriendUI.this.startActivity(new Intent(FacebookFriendUI.this, InviteFacebookFriendsUI.class));
                    AppMethodBeat.o(124818);
                    return true;
                }
            });
        } else {
            this.gtT.setVisibility(8);
            this.gtV.setVisibility(0);
            ((TextView) findViewById(R.id.bst)).setText(R.string.bsi);
            this.gtV.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(124819);
                    FacebookFriendUI.this.startActivity(new Intent(FacebookFriendUI.this, FacebookAuthUI.class));
                    AppMethodBeat.o(124819);
                }
            });
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(124808);
                FacebookFriendUI.this.aqX();
                FacebookFriendUI.this.finish();
                AppMethodBeat.o(124808);
                return true;
            }
        });
        AnonymousClass3 anonymousClass3 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(124809);
                BackwardSupportUtil.c.a(FacebookFriendUI.this.gtT);
                AppMethodBeat.o(124809);
            }
        };
        AppMethodBeat.o(124824);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(124825);
        ab.i("MicroMsg.FacebookFriendUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (mVar.getType() != 32) {
            AppMethodBeat.o(124825);
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
            AppMethodBeat.o(124825);
        } else if (i == 0 && i2 == 0) {
            this.gBe.a(null, null);
            AppMethodBeat.o(124825);
        } else {
            Toast.makeText(this, R.string.d08, 0).show();
            AppMethodBeat.o(124825);
        }
    }

    private void bj(String str, String str2) {
        AppMethodBeat.i(124826);
        com.tencent.mm.ui.base.h.a((Context) this, str2, str, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(124810);
                Intent intent = new Intent(FacebookFriendUI.this.mController.ylL, FacebookAuthUI.class);
                intent.putExtra("is_force_unbind", true);
                FacebookFriendUI.this.mController.ylL.startActivity(intent);
                FacebookFriendUI.this.finish();
                AppMethodBeat.o(124810);
            }
        }, null);
        AppMethodBeat.o(124826);
    }

    public final void qj(String str) {
        AppMethodBeat.i(124827);
        this.gBe.notifyDataSetChanged();
        AppMethodBeat.o(124827);
    }

    static /* synthetic */ void f(FacebookFriendUI facebookFriendUI) {
        AppMethodBeat.i(124828);
        ab.e("MicroMsg.FacebookFriendUI", "dealWithRefreshTokenFail");
        facebookFriendUI.bj(facebookFriendUI.getString(R.string.tz), facebookFriendUI.getString(R.string.bmb));
        AppMethodBeat.o(124828);
    }
}
