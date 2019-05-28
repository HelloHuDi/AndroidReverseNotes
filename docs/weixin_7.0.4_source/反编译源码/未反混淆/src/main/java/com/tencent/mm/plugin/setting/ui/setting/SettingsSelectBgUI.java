package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.o;
import com.tencent.mm.ba.j;
import com.tencent.mm.ba.k;
import com.tencent.mm.ba.m;
import com.tencent.mm.ba.n;
import com.tencent.mm.ba.r;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.p;
import java.util.ArrayList;
import java.util.List;

public class SettingsSelectBgUI extends MMActivity implements f {
    private boolean qmZ;
    private a qoQ;
    private GridView qoR;
    private j qoS;
    private List<j> qoT = new ArrayList();
    private ap qoU = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(127470);
            if (SettingsSelectBgUI.this.findViewById(R.id.e_s).getWidth() <= 0) {
                AppMethodBeat.o(127470);
                return true;
            }
            SettingsSelectBgUI.a(SettingsSelectBgUI.this);
            AppMethodBeat.o(127470);
            return false;
        }
    }, true);
    private String username;

    class a extends p<m> {
        private Context context;
        private int itemWidth;

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            AppMethodBeat.i(127479);
            m mVar = (m) obj;
            if (mVar == null) {
                mVar = new m();
            }
            mVar.d(cursor);
            AppMethodBeat.o(127479);
            return mVar;
        }

        public a(Context context, int i) {
            super(context, new m());
            AppMethodBeat.i(127474);
            this.context = context;
            this.itemWidth = i;
            AppMethodBeat.o(127474);
        }

        public final int getCount() {
            AppMethodBeat.i(127475);
            int count = getCursor().getCount() + 2;
            AppMethodBeat.o(127475);
            return count;
        }

        public final void KD() {
            AppMethodBeat.i(127476);
            KC();
            AppMethodBeat.o(127476);
        }

        public final void KC() {
            AppMethodBeat.i(127477);
            setCursor(r.aix().ait());
            super.notifyDataSetChanged();
            AppMethodBeat.o(127477);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            AppMethodBeat.i(127478);
            if (view == null) {
                view = View.inflate(this.context, R.layout.as1, null);
                view.setLayoutParams(new LayoutParams(this.itemWidth, this.itemWidth));
                b bVar2 = new b();
                bVar2.qqB = (LinearLayout) view.findViewById(R.id.e_u);
                bVar2.qqC = (LinearLayout) view.findViewById(R.id.e_x);
                bVar2.qqD = (LinearLayout) view.findViewById(R.id.e_y);
                bVar2.qqE = (LinearLayout) view.findViewById(R.id.e_z);
                bVar2.qqF = (LinearLayout) view.findViewById(R.id.ea0);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            int a = bo.a((Integer) g.RP().Ry().get(12311, null), -2);
            com.tencent.mm.ba.a sU = r.aiy().sU(SettingsSelectBgUI.this.username);
            if (i == 0) {
                if (!(SettingsSelectBgUI.this.qmZ && a == -2) && (!(!SettingsSelectBgUI.this.qmZ && a == -2 && sU == null) && (sU == null || sU.fLV != -2))) {
                    bVar.WA("downloaded");
                } else {
                    bVar.WA("using");
                }
                ((ImageView) view.findViewById(R.id.e_t)).setImageBitmap(d.a(BitmapFactory.decodeResource(this.context.getResources(), R.drawable.ace), true, 10.0f));
                AppMethodBeat.o(127478);
            } else if (i == 1) {
                if (!(SettingsSelectBgUI.this.qmZ && a == 0) && (!(!SettingsSelectBgUI.this.qmZ && a == 0 && sU == null) && (sU == null || sU.fLV != 0))) {
                    bVar.WA("downloaded");
                } else {
                    bVar.WA("using");
                }
                ((ImageView) view.findViewById(R.id.e_t)).setImageBitmap(d.a(BitmapFactory.decodeResource(this.context.getResources(), R.drawable.acd), true, 10.0f));
                AppMethodBeat.o(127478);
            } else {
                Bitmap aml;
                m mVar = (m) getItem(i - 2);
                r.aix();
                if (g.RP().isSDCardAvailable()) {
                    aml = d.aml(n.aiu() + n.cw(mVar.id, mVar.cBc));
                } else {
                    aml = BitmapFactory.decodeResource(SettingsSelectBgUI.this.getResources(), R.drawable.aka);
                }
                if (aml == null) {
                    AppMethodBeat.o(127478);
                } else {
                    ((ImageView) view.findViewById(R.id.e_t)).setImageBitmap(d.a(aml, true, 10.0f));
                    switch (mVar.status) {
                        case 1:
                            if (!SettingsSelectBgUI.this.qmZ && sU != null && sU.fLV != mVar.id) {
                                bVar.WA("downloaded");
                                break;
                            }
                            bVar.WA("using");
                            break;
                            break;
                        case 2:
                            if (!SettingsSelectBgUI.this.qmZ && sU != null && sU.fLV == mVar.id) {
                                bVar.WA("using");
                                break;
                            }
                            bVar.WA("downloaded");
                            break;
                            break;
                        case 3:
                            bVar.WA("downloading");
                            break;
                        case 4:
                            bVar.WA("canceling");
                            break;
                        case 5:
                            bVar.WA("undownloaded");
                            break;
                    }
                    AppMethodBeat.o(127478);
                }
            }
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsSelectBgUI() {
        AppMethodBeat.i(127480);
        AppMethodBeat.o(127480);
    }

    public final int getLayoutId() {
        return R.layout.as0;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127481);
        super.onCreate(bundle);
        initView();
        g.Rg().a((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (f) this);
        g.Rg().a(160, (f) this);
        if (g.RP().isSDCardAvailable()) {
            g.Rg().a(new k(1), 0);
        }
        AppMethodBeat.o(127481);
    }

    public void onDestroy() {
        AppMethodBeat.i(127482);
        super.onDestroy();
        if (this.qoS != null) {
            g.Rg().c(this.qoS);
            r.aix().cz(this.qoS.fMn, 1);
        }
        List<j> list = this.qoT;
        for (j jVar : list) {
            r.aix().cz(jVar.fMn, 1);
        }
        list.clear();
        g.Rg().b((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (f) this);
        g.Rg().b(160, (f) this);
        this.qoQ.bIf();
        r.aix().d(this.qoQ);
        AppMethodBeat.o(127482);
    }

    public final void initView() {
        AppMethodBeat.i(127483);
        setMMTitle((int) R.string.e6b);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127471);
                SettingsSelectBgUI.this.finish();
                AppMethodBeat.o(127471);
                return true;
            }
        });
        this.qmZ = getIntent().getBooleanExtra("isApplyToAll", true);
        this.username = getIntent().getStringExtra("username");
        this.qoU.ae(20, 20);
        AppMethodBeat.o(127483);
    }

    public void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(127484);
        if ((mVar instanceof o) && ((o) mVar).acR() == 1) {
            int type = mVar.getType();
            if (type == JsApiGetBackgroundAudioState.CTRL_INDEX || type == 160) {
                if (type == 160) {
                    cZ(this.qoT);
                }
                if (i == 0 && i2 == 0) {
                    AppMethodBeat.o(127484);
                    return;
                } else {
                    AppMethodBeat.o(127484);
                    return;
                }
            }
            AppMethodBeat.o(127484);
            return;
        }
        ab.d("MicroMsg.SettingsSelectBgUI", "another scene");
        AppMethodBeat.o(127484);
    }

    private void cZ(List<j> list) {
        AppMethodBeat.i(127485);
        if (list.size() > 0) {
            this.qoS = (j) list.remove(0);
            g.Rg().a(this.qoS, 0);
            AppMethodBeat.o(127485);
            return;
        }
        this.qoS = null;
        AppMethodBeat.o(127485);
    }

    static /* synthetic */ void a(SettingsSelectBgUI settingsSelectBgUI) {
        AppMethodBeat.i(127486);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) settingsSelectBgUI.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        settingsSelectBgUI.qoQ = new a(settingsSelectBgUI, ((displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.widthPixels : displayMetrics.heightPixels) - 60) / 3);
        settingsSelectBgUI.qoR = (GridView) settingsSelectBgUI.findViewById(R.id.e_s);
        r.aix().c(settingsSelectBgUI.qoQ);
        settingsSelectBgUI.qoR.setAdapter(settingsSelectBgUI.qoQ);
        settingsSelectBgUI.qoR.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(127473);
                if (i == 0) {
                    SettingsSelectBgUI.a(SettingsSelectBgUI.this, -2);
                    SettingsSelectBgUI.this.qoQ.KC();
                    if (!SettingsSelectBgUI.this.qmZ) {
                        SettingsSelectBgUI.this.setResult(-1);
                        SettingsSelectBgUI.this.finish();
                    }
                    AppMethodBeat.o(127473);
                } else if (i == 1) {
                    SettingsSelectBgUI.a(SettingsSelectBgUI.this, 0);
                    SettingsSelectBgUI.this.qoQ.KC();
                    if (!SettingsSelectBgUI.this.qmZ) {
                        SettingsSelectBgUI.this.setResult(-1);
                        SettingsSelectBgUI.this.finish();
                    }
                    AppMethodBeat.o(127473);
                } else if (g.RP().isSDCardAvailable()) {
                    m mVar = (m) adapterView.getItemAtPosition(i - 2);
                    if (mVar == null) {
                        ab.e("MicroMsg.SettingsSelectBgUI", "onItemClick fail, info is null, position = ".concat(String.valueOf(i)));
                        AppMethodBeat.o(127473);
                        return;
                    }
                    n aix;
                    switch (mVar.status) {
                        case 1:
                        case 2:
                            SettingsSelectBgUI.a(SettingsSelectBgUI.this, mVar.id);
                            if (SettingsSelectBgUI.this.qmZ) {
                                mVar.status = 1;
                                aix = r.aix();
                                aix.lS(mVar.cBc);
                                mVar.status = 1;
                                aix.b(mVar);
                            } else {
                                SettingsSelectBgUI.this.qoQ.KC();
                            }
                            if (!SettingsSelectBgUI.this.qmZ) {
                                SettingsSelectBgUI.this.setResult(-1);
                                SettingsSelectBgUI.this.finish();
                                break;
                            }
                            break;
                        case 3:
                            if (SettingsSelectBgUI.this.qoS != null && SettingsSelectBgUI.this.qoS.fMn == mVar.id) {
                                g.Rg().c(SettingsSelectBgUI.this.qoS);
                                r.aix().cz(SettingsSelectBgUI.this.qoS.fMn, 1);
                                SettingsSelectBgUI.a(SettingsSelectBgUI.this, SettingsSelectBgUI.this.qoT);
                            }
                            SettingsSelectBgUI.h(mVar.id, SettingsSelectBgUI.this.qoT);
                            aix = r.aix();
                            mVar.status = 4;
                            aix.b(mVar);
                            final int i2 = mVar.id;
                            new ak() {
                                public final void handleMessage(Message message) {
                                    AppMethodBeat.i(127472);
                                    aix.cz(i2, 1);
                                    AppMethodBeat.o(127472);
                                }
                            }.sendEmptyMessageDelayed(0, 1000);
                            AppMethodBeat.o(127473);
                            return;
                        case 4:
                            r.aix().cz(mVar.id, 1);
                            AppMethodBeat.o(127473);
                            return;
                        case 5:
                            if (SettingsSelectBgUI.this.qoS == null) {
                                SettingsSelectBgUI.this.qoS = new j(mVar.id, 1);
                                g.Rg().a(SettingsSelectBgUI.this.qoS, 0);
                                AppMethodBeat.o(127473);
                                return;
                            }
                            SettingsSelectBgUI.this.qoT.add(new j(mVar.id, 1));
                            AppMethodBeat.o(127473);
                            return;
                    }
                    AppMethodBeat.o(127473);
                } else {
                    Toast.makeText(SettingsSelectBgUI.this, R.string.eab, 1).show();
                    AppMethodBeat.o(127473);
                }
            }
        });
        AppMethodBeat.o(127486);
    }

    static /* synthetic */ void h(int i, List list) {
        AppMethodBeat.i(127489);
        for (j jVar : list) {
            if (jVar.fMn == i) {
                r.aix().cz(jVar.fMn, 1);
                list.remove(jVar);
                AppMethodBeat.o(127489);
                return;
            }
        }
        AppMethodBeat.o(127489);
    }
}
