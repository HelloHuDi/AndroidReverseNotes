package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.h.a;
import com.tencent.mm.ai.h.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.tools.j;
import junit.framework.Assert;

public class MassSendHistoryUI extends MMActivity implements a, b, SensorController.a {
    private static SensorController mfW;
    private com.tencent.mm.audio.a.a chb;
    private d jOb = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(22797);
            if (menuItem.getItemId() == 1) {
                com.tencent.mm.plugin.masssend.a.a aVar = (com.tencent.mm.plugin.masssend.a.a) MassSendHistoryUI.this.ooT.getItem(menuItem.getGroupId());
                if (aVar == null) {
                    AppMethodBeat.o(22797);
                    return;
                }
                if (aVar.bNv().equals(MassSendHistoryUI.this.ooT.ooH)) {
                    MassSendHistoryUI.h(MassSendHistoryUI.this);
                }
                com.tencent.mm.plugin.masssend.a.b bNE = h.bNE();
                String bNv = aVar.bNv();
                Cursor a = bNE.fni.a("select * from massendinfo ORDER BY createtime DESC  limit 2", null, 0);
                if (a != null) {
                    com.tencent.mm.plugin.masssend.a.a aVar2;
                    ak akVar;
                    if (a.getCount() == 0) {
                        a.close();
                    } else if (a.getCount() == 1) {
                        a.moveToFirst();
                        aVar2 = new com.tencent.mm.plugin.masssend.a.a();
                        aVar2.d(a);
                        a.close();
                        akVar = new ak();
                        akVar.setUsername("masssendapp");
                        akVar.setContent(ah.getContext().getResources().getString(R.string.axn));
                        akVar.eD(aVar2.createTime);
                        akVar.hO(0);
                        akVar.hM(0);
                        aw.ZK();
                        c.XR().a(akVar, "masssendapp");
                    } else {
                        a.moveToPosition(1);
                        aVar2 = new com.tencent.mm.plugin.masssend.a.a();
                        aVar2.d(a);
                        a.close();
                        akVar = new ak();
                        akVar.setUsername("masssendapp");
                        akVar.setContent(com.tencent.mm.plugin.masssend.a.b.a(aVar2));
                        akVar.eD(aVar2.createTime);
                        akVar.hO(0);
                        akVar.hM(0);
                        aw.ZK();
                        c.XR().a(akVar, "masssendapp");
                    }
                }
                if (bNE.fni.delete("massendinfo", "clientid= ?", new String[]{String.valueOf(bNv)}) > 0) {
                    bNE.doNotify();
                }
            }
            AppMethodBeat.o(22797);
        }
    };
    private boolean mfP = true;
    private View nDr;
    private ListView ooS;
    private c ooT;
    private Button ooU;
    private Button ooV;
    private MMPullDownView ooW;
    private boolean ooX = false;
    private LinearLayout ooY;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MassSendHistoryUI() {
        AppMethodBeat.i(22806);
        AppMethodBeat.o(22806);
    }

    static /* synthetic */ boolean a(MassSendHistoryUI massSendHistoryUI, String str) {
        AppMethodBeat.i(22821);
        boolean Qx = massSendHistoryUI.Qx(str);
        AppMethodBeat.o(22821);
        return Qx;
    }

    static /* synthetic */ void h(MassSendHistoryUI massSendHistoryUI) {
        AppMethodBeat.i(22822);
        massSendHistoryUI.stopPlay();
        AppMethodBeat.o(22822);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22807);
        super.onCreate(bundle);
        setMMTitle((int) R.string.cyx);
        if (mfW == null) {
            mfW = new SensorController(getApplicationContext());
        }
        initView();
        this.chb = new com.tencent.mm.audio.a.a(this);
        this.chb.coD = this;
        this.chb.coC = this;
        this.ooT.ooI = new e() {
            public final String Qw(String str) {
                AppMethodBeat.i(22794);
                aw.ZK();
                String nullAsNil;
                if (c.isSDCardAvailable()) {
                    nullAsNil = bo.nullAsNil(str);
                    if (MassSendHistoryUI.this.chb.isPlaying() && nullAsNil.equals(MassSendHistoryUI.this.ooT.ooH)) {
                        MassSendHistoryUI.bNN();
                        MassSendHistoryUI.this.releaseWakeLock();
                        MassSendHistoryUI.this.chb.stop(false);
                        nullAsNil = "";
                        AppMethodBeat.o(22794);
                        return nullAsNil;
                    } else if (MassSendHistoryUI.a(MassSendHistoryUI.this, nullAsNil)) {
                        AppMethodBeat.o(22794);
                        return nullAsNil;
                    } else {
                        nullAsNil = "";
                        AppMethodBeat.o(22794);
                        return nullAsNil;
                    }
                }
                t.hO(MassSendHistoryUI.this);
                nullAsNil = "";
                AppMethodBeat.o(22794);
                return nullAsNil;
            }
        };
        if (this.mController != null) {
            this.mController.aC(3, false);
        }
        AppMethodBeat.o(22807);
    }

    public void onResume() {
        AppMethodBeat.i(22808);
        super.onResume();
        h.bNE().c(this.ooT);
        this.ooT.a(null, null);
        this.ooS.setSelection(this.ooT.getCount() - 1);
        AppMethodBeat.o(22808);
    }

    public void onPause() {
        AppMethodBeat.i(22809);
        super.onPause();
        aw.ZL().La();
        h.bNE().d(this.ooT);
        mfW.dps();
        AppMethodBeat.o(22809);
    }

    public void onDestroy() {
        AppMethodBeat.i(22810);
        this.ooT.bIf();
        super.onDestroy();
        AppMethodBeat.o(22810);
    }

    public final int getLayoutId() {
        return R.layout.acl;
    }

    public final void initView() {
        AppMethodBeat.i(22811);
        this.ooX = getIntent().getBooleanExtra("finish_direct", false);
        ab.d("MicroMsg.MassSendHistoryUI", "isFromSearch  " + this.ooX);
        this.ooY = (LinearLayout) findViewById(R.id.d7c);
        this.ooS = (ListView) findViewById(R.id.d7_);
        this.ooS.setTranscriptMode(0);
        this.ooW = (MMPullDownView) findViewById(R.id.d79);
        this.ooW.setOnTopLoadDataListener(new g() {
            public final boolean bhn() {
                int i = 0;
                AppMethodBeat.i(22798);
                if (MassSendHistoryUI.this.ooT.bdn()) {
                    MassSendHistoryUI.this.ooS.setSelectionFromTop(0, MassSendHistoryUI.this.ooW.getTopHeight());
                    AppMethodBeat.o(22798);
                } else {
                    c b = MassSendHistoryUI.this.ooT;
                    if (!b.bdn()) {
                        b.kmW += 10;
                        if (b.kmW <= b.enb) {
                            i = 10;
                        } else {
                            b.kmW = b.enb;
                            i = b.enb % 10;
                        }
                    }
                    ab.v("MicroMsg.MassSendHistoryUI", "onLoadData add count:".concat(String.valueOf(i)));
                    MassSendHistoryUI.this.ooT.a(null, null);
                    MassSendHistoryUI.this.ooS.setSelectionFromTop(i, MassSendHistoryUI.this.ooW.getTopHeight());
                    AppMethodBeat.o(22798);
                }
                return true;
            }
        });
        this.ooW.setTopViewVisible(true);
        this.ooW.setAtBottomCallBack(new MMPullDownView.c() {
            public final boolean bhm() {
                AppMethodBeat.i(22799);
                if (MassSendHistoryUI.this.ooS.getChildAt(MassSendHistoryUI.this.ooS.getChildCount() - 1).getBottom() > MassSendHistoryUI.this.ooS.getHeight() || MassSendHistoryUI.this.ooS.getLastVisiblePosition() != MassSendHistoryUI.this.ooS.getAdapter().getCount() - 1) {
                    AppMethodBeat.o(22799);
                    return false;
                }
                AppMethodBeat.o(22799);
                return true;
            }
        });
        this.ooW.setAtTopCallBack(new MMPullDownView.d() {
            public final boolean bhl() {
                AppMethodBeat.i(22800);
                View childAt = MassSendHistoryUI.this.ooS.getChildAt(MassSendHistoryUI.this.ooS.getFirstVisiblePosition());
                if (childAt == null || childAt.getTop() != 0) {
                    AppMethodBeat.o(22800);
                    return false;
                }
                AppMethodBeat.o(22800);
                return true;
            }
        });
        this.ooW.setIsBottomShowAll(true);
        this.ooT = new c(this);
        this.ooT.a((p.a) new p.a() {
            public final void apt() {
                AppMethodBeat.i(22801);
                MassSendHistoryUI.this.ooW.setIsTopShowAll(MassSendHistoryUI.this.ooT.bdn());
                if (MassSendHistoryUI.this.ooT.getCount() == 0) {
                    MassSendHistoryUI.this.ooW.setVisibility(8);
                    MassSendHistoryUI.this.nDr.setVisibility(0);
                    MassSendHistoryUI.this.ooY.setVisibility(8);
                    AppMethodBeat.o(22801);
                    return;
                }
                MassSendHistoryUI.this.ooW.setVisibility(0);
                MassSendHistoryUI.this.nDr.setVisibility(8);
                MassSendHistoryUI.this.ooY.setVisibility(0);
                AppMethodBeat.o(22801);
            }
        });
        this.nDr = findViewById(R.id.d7a);
        this.ooS.setAdapter(this.ooT);
        this.ooS.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(22802);
                ab.v("MicroMsg.MassSendHistoryUI", "onItemClick");
                AppMethodBeat.o(22802);
            }
        });
        this.ooS.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(22803);
                ab.v("MicroMsg.MassSendHistoryUI", "onTouch");
                AppMethodBeat.o(22803);
                return false;
            }
        });
        this.ooU = (Button) findViewById(R.id.d7d);
        this.ooU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(22804);
                MassSendHistoryUI.this.startActivity(new Intent(MassSendHistoryUI.this, MassSendSelectContactUI.class));
                AppMethodBeat.o(22804);
            }
        });
        this.ooV = (Button) findViewById(R.id.d7b);
        this.ooV.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(22805);
                MassSendHistoryUI.this.startActivity(new Intent(MassSendHistoryUI.this, MassSendSelectContactUI.class));
                AppMethodBeat.o(22805);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22795);
                if (MassSendHistoryUI.this.ooX) {
                    MassSendHistoryUI.this.finish();
                } else {
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    com.tencent.mm.plugin.masssend.a.gkE.p(intent, MassSendHistoryUI.this);
                    MassSendHistoryUI.this.finish();
                }
                AppMethodBeat.o(22795);
                return true;
            }
        });
        addIconOptionMenu(0, R.string.tk, R.raw.actionbar_setting_icon, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22796);
                Intent intent = new Intent();
                intent.putExtra("Contact_User", "masssendapp");
                com.tencent.mm.plugin.masssend.a.gkE.c(intent, MassSendHistoryUI.this);
                AppMethodBeat.o(22796);
                return true;
            }
        });
        new j(this).a(this.ooS, this, this.jOb);
        AppMethodBeat.o(22811);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(22812);
        if (i == 4) {
            if (this.ooX) {
                finish();
            } else {
                Intent intent = new Intent();
                intent.addFlags(67108864);
                com.tencent.mm.plugin.masssend.a.gkE.p(intent, this);
                finish();
            }
            AppMethodBeat.o(22812);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(22812);
        return onKeyDown;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(22813);
        ab.v("MicroMsg.MassSendHistoryUI", "onCreateContextMenu");
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        String[] split = ((com.tencent.mm.plugin.masssend.a.a) this.ooT.getItem(adapterContextMenuInfo.position)).bNy().split(";");
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : split) {
            aw.ZK();
            ad aoO = c.XM().aoO(str);
            if (aoO != null) {
                stringBuilder.append(aoO.Oj() + ";");
            }
        }
        contextMenu.setHeaderTitle(stringBuilder.toString());
        contextMenu.add(adapterContextMenuInfo.position, 1, 0, getString(R.string.am7));
        AppMethodBeat.o(22813);
    }

    /* Access modifiers changed, original: protected|final */
    public final void releaseWakeLock() {
        AppMethodBeat.i(22814);
        this.ooS.setKeepScreenOn(false);
        AppMethodBeat.o(22814);
    }

    public final void he(boolean z) {
        AppMethodBeat.i(22815);
        if (this.chb == null) {
            AppMethodBeat.o(22815);
        } else if (this.chb.isPlaying()) {
            this.chb.bo(z);
            aw.ZL().f(z, false, false);
            this.mfP = z;
            if (!z) {
                if (Qx(this.ooT.ooH)) {
                    this.ooT.Qv(this.ooT.ooH);
                    AppMethodBeat.o(22815);
                    return;
                }
                this.ooT.Qv("");
            }
            AppMethodBeat.o(22815);
        } else {
            this.chb.bo(true);
            aw.ZL().f(true, false, false);
            this.mfP = true;
            AppMethodBeat.o(22815);
        }
    }

    private boolean Qx(String str) {
        AppMethodBeat.i(22816);
        Assert.assertTrue(str != null);
        mfW.a(this);
        com.tencent.mm.plugin.masssend.a.a Qs = h.bNE().Qs(str);
        aw.ZK();
        if (c.isSDCardAvailable() || bo.isNullOrNil(Qs.bNw())) {
            if (this.chb == null) {
                this.chb = new com.tencent.mm.audio.a.a(this);
            }
            this.chb.stop(false);
            if (this.chb.m(Qs.bNw(), this.mfP)) {
                aw.ZL().f(this.mfP, false, false);
                this.chb.coD = this;
                this.chb.coC = this;
                AppMethodBeat.o(22816);
                return true;
            }
            Toast.makeText(this, getString(R.string.ank), 0).show();
            AppMethodBeat.o(22816);
            return false;
        }
        t.hO(this);
        AppMethodBeat.o(22816);
        return false;
    }

    public final void EA() {
        AppMethodBeat.i(22818);
        stopPlay();
        AppMethodBeat.o(22818);
    }

    public final void onError() {
        AppMethodBeat.i(22819);
        stopPlay();
        AppMethodBeat.o(22819);
    }

    private void stopPlay() {
        AppMethodBeat.i(22817);
        mfW.dps();
        this.chb.stop(false);
        this.ooT.Qv("");
        releaseWakeLock();
        AppMethodBeat.o(22817);
    }

    static /* synthetic */ void bNN() {
        AppMethodBeat.i(22820);
        mfW.dps();
        AppMethodBeat.o(22820);
    }
}
