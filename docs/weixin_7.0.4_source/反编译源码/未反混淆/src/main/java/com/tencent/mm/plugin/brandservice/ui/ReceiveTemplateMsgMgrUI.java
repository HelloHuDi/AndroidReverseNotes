package com.tencent.mm.plugin.brandservice.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.k;
import com.tencent.mm.protocal.protobuf.azo;
import com.tencent.mm.protocal.protobuf.azq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.Iterator;
import java.util.LinkedList;

public class ReceiveTemplateMsgMgrUI extends MMPreference implements f {
    private static LinkedList<azo> jMt;
    private ProgressDialog ehJ;
    protected com.tencent.mm.ui.base.preference.f iFE;
    private String jMs;
    private boolean jMu = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.an_;
    }

    public final int JC() {
        return R.xml.bc;
    }

    public final int aWi() {
        return R.layout.an9;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(14024);
        super.onCreate(bundle);
        g.Rg().a(1031, (f) this);
        g.Rg().a(1030, (f) this);
        initView();
        AppMethodBeat.o(14024);
    }

    public void onPause() {
        AppMethodBeat.i(14025);
        if (this.jMu) {
            ab.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onPause option change");
            this.jMu = false;
            g.Rg().a(new k(this.jMs, jMt), 0);
        }
        super.onPause();
        AppMethodBeat.o(14025);
    }

    public void onDestroy() {
        AppMethodBeat.i(14026);
        g.Rg().b(1031, (f) this);
        g.Rg().b(1030, (f) this);
        super.onDestroy();
        AppMethodBeat.o(14026);
    }

    public final void initView() {
        AppMethodBeat.i(14027);
        setMMTitle((int) R.string.az_);
        this.iFE = this.yCw;
        this.jMs = getIntent().getStringExtra("enterprise_biz_name");
        if (bo.isNullOrNil(this.jMs)) {
            ab.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "bizName is null");
            finish();
            AppMethodBeat.o(14027);
            return;
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(14021);
                ReceiveTemplateMsgMgrUI.this.finish();
                AppMethodBeat.o(14021);
                return true;
            }
        });
        final m dVar = new d(this.jMs);
        g.Rg().a(dVar, 0);
        getString(R.string.tz);
        this.ehJ = h.b((Context) this, getString(R.string.diu), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(14022);
                g.Rg().c(dVar);
                AppMethodBeat.o(14022);
            }
        });
        AppMethodBeat.o(14027);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(14028);
        if (jMt == null) {
            ab.w("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "mRecvOptions == null");
            AppMethodBeat.o(14028);
        } else {
            String str = preference.mKey;
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "key is null");
                AppMethodBeat.o(14028);
            } else {
                Iterator it = jMt.iterator();
                while (it.hasNext()) {
                    azo azo = (azo) it.next();
                    if (str.equals(bo.nullAsNil(azo.wDw))) {
                        this.jMu = true;
                        if (((CheckBoxPreference) preference).isChecked()) {
                            azo.vEq = 0;
                        } else {
                            azo.vEq = 1;
                        }
                        if (this.jMu) {
                            ab.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "option change, do scene");
                            al.n(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(14023);
                                    if (ReceiveTemplateMsgMgrUI.this.jMu) {
                                        ReceiveTemplateMsgMgrUI.this.jMu = false;
                                        g.Rg().a(new k(ReceiveTemplateMsgMgrUI.this.jMs, ReceiveTemplateMsgMgrUI.jMt), 0);
                                    }
                                    AppMethodBeat.o(14023);
                                }
                            }, 4000);
                        }
                        AppMethodBeat.o(14028);
                    }
                }
                if (this.jMu) {
                }
                AppMethodBeat.o(14028);
            }
        }
        return false;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(14029);
        if (mVar == null) {
            ab.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onSceneEnd: [%d], [%d], [%s], scene is null", Integer.valueOf(i), Integer.valueOf(i2), str);
            AppMethodBeat.o(14029);
            return;
        }
        ab.i("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(mVar.getType()));
        if (mVar.getType() == 1031) {
            if (this.ehJ != null && this.ehJ.isShowing()) {
                this.ehJ.dismiss();
                this.ehJ = null;
            }
            if (i == 0 && i2 == 0) {
                azq azq;
                d dVar = (d) mVar;
                if (dVar.ehh == null || dVar.ehh.fsH.fsP == null) {
                    azq = null;
                } else {
                    azq = (azq) dVar.ehh.fsH.fsP;
                }
                jMt = azq.wDx;
                LinkedList linkedList = jMt;
                this.iFE.removeAll();
                if (linkedList == null || linkedList.size() <= 0) {
                    ab.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "recvOption is empty");
                    eD(true);
                    AppMethodBeat.o(14029);
                    return;
                }
                eD(false);
                ab.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBody options.size = %d", Integer.valueOf(linkedList.size()));
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    boolean z;
                    azo azo = (azo) it.next();
                    CheckBoxPreference checkBoxPreference = new CheckBoxPreference(this);
                    checkBoxPreference.yDf = false;
                    checkBoxPreference.setKey(azo.wDw);
                    checkBoxPreference.setTitle((CharSequence) azo.Title);
                    if (azo.vEq == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    checkBoxPreference.uOT = z;
                    this.iFE.b(checkBoxPreference);
                }
                this.iFE.notifyDataSetChanged();
                ab.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBodyView finish");
                AppMethodBeat.o(14029);
                return;
            }
            Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.dir), 1).show();
            eD(true);
            AppMethodBeat.o(14029);
        } else if (mVar.getType() != 1030 || (i == 0 && i2 == 0)) {
            AppMethodBeat.o(14029);
        } else {
            Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.dis), 0).show();
            AppMethodBeat.o(14029);
        }
    }

    private void eD(boolean z) {
        AppMethodBeat.i(14030);
        View findViewById = findViewById(R.id.dw5);
        View findViewById2 = findViewById(R.id.dw4);
        if (findViewById != null) {
            if (z) {
                ((TextView) findViewById).setVisibility(0);
                if (findViewById2 != null) {
                    findViewById2.setVisibility(8);
                    AppMethodBeat.o(14030);
                    return;
                }
            }
            ((TextView) findViewById).setVisibility(8);
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
        }
        AppMethodBeat.o(14030);
    }
}
