package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.dk;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.j;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceManageDeviceUI extends MMActivity {
    private a lBi;
    private ListView mListView;

    static final class a extends BaseAdapter implements f {
        private d jMV;
        private WeakReference<Context> jQk;
        boolean lBk;
        private OnClickListener lBl;
        private j lBm;
        private volatile int lBn = -1;
        private List<b> lyd;
        private c lyr;
        private p tipDialog = null;

        static class a {
            TextView gxi;
            ImageView iqT;
            View lBq;
            View lBr;

            private a() {
            }

            /* synthetic */ a(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(19994);
            b uT = uT(i);
            AppMethodBeat.o(19994);
            return uT;
        }

        public a(Context context) {
            AppMethodBeat.i(19988);
            this.jQk = new WeakReference(context);
            this.lyd = new LinkedList();
            this.lBm = new j(context);
            com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
            aVar.ePT = R.drawable.ads;
            this.lyr = aVar.ahG();
            this.jMV = new d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.i(19983);
                    int itemId = menuItem.getItemId();
                    ab.d("MicroMsg.ExdeviceManageDeviceUI", "onMenuItemSelected, itemId(%d), count(%d).", Integer.valueOf(itemId), Integer.valueOf(a.this.getCount()));
                    if (itemId < 0 || itemId >= r1) {
                        AppMethodBeat.o(19983);
                        return;
                    }
                    a.this.lBn = itemId;
                    a.a(a.this, (b) a.this.lyd.get(itemId));
                    a.this.notifyDataSetChanged();
                    AppMethodBeat.o(19983);
                }
            };
            this.lBl = new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(19984);
                    if (a.this.lBk) {
                        AppMethodBeat.o(19984);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof Integer)) {
                        AppMethodBeat.o(19984);
                        return;
                    }
                    int intValue = ((Integer) tag).intValue();
                    if (intValue < 0 || intValue >= a.this.getCount()) {
                        AppMethodBeat.o(19984);
                        return;
                    }
                    b uT = a.this.uT(intValue);
                    Context context = (Context) a.this.jQk.get();
                    if (context == null) {
                        ab.e("MicroMsg.ExdeviceManageDeviceUI", "Start activity failed, context is null.");
                        AppMethodBeat.o(19984);
                        return;
                    }
                    a.a(context, uT);
                    AppMethodBeat.o(19984);
                }
            };
            bw(ad.boW().bpB());
            AppMethodBeat.o(19988);
        }

        public final void bw(List<b> list) {
            AppMethodBeat.i(19989);
            this.lyd.clear();
            if (list == null || list.size() == 0) {
                AppMethodBeat.o(19989);
                return;
            }
            this.lyd.addAll(list);
            AppMethodBeat.o(19989);
        }

        public final int getCount() {
            AppMethodBeat.i(19990);
            int size = this.lyd.size();
            AppMethodBeat.o(19990);
            return size;
        }

        public final b uT(int i) {
            AppMethodBeat.i(19991);
            b bVar = (b) this.lyd.get(i);
            AppMethodBeat.o(19991);
            return bVar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            CharSequence charSequence;
            AppMethodBeat.i(19992);
            b uT = uT(i);
            if (view == null) {
                aVar = new a();
                view = View.inflate(viewGroup.getContext(), R.layout.w7, null);
                aVar.lBq = view.findViewById(R.id.nc);
                aVar.gxi = (TextView) view.findViewById(R.id.bi_);
                aVar.lBr = view.findViewById(R.id.bjd);
                aVar.iqT = (ImageView) view.findViewById(R.id.bi9);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            if (uT == null) {
                charSequence = "";
            } else {
                String str;
                if (!bo.isNullOrNil(uT.dFl)) {
                    str = uT.dFl;
                } else if (!bo.isNullOrNil(uT.dFm)) {
                    str = uT.dFm;
                } else if (uT.field_mac != 0) {
                    str = com.tencent.mm.plugin.exdevice.j.b.ie(uT.field_mac);
                } else if (bo.isNullOrNil(uT.field_deviceID)) {
                    str = null;
                } else {
                    str = uT.field_deviceID;
                }
                charSequence = bo.nullAsNil(str);
            }
            ab.d("MicroMsg.ExdeviceManageDeviceUI", "position(%s), name(%s), mac(%s).", Integer.valueOf(i), charSequence, Long.valueOf(uT.field_mac));
            aVar.gxi.setText(charSequence);
            o.ahp().a(uT.iconUrl, aVar.iqT, this.lyr);
            aVar.lBr.setTag(Integer.valueOf(i));
            if (this.lBk) {
                aVar.lBr.setVisibility(0);
            } else {
                aVar.lBr.setVisibility(8);
            }
            aVar.lBq.setTag(Integer.valueOf(i));
            aVar.lBq.setOnClickListener(this.lBl);
            AppMethodBeat.o(19992);
            return view;
        }

        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(19993);
            if (mVar == null) {
                ab.e("MicroMsg.ExdeviceManageDeviceUI", "scene is null.");
                AppMethodBeat.o(19993);
                return;
            }
            if (mVar instanceof x) {
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.dismiss();
                }
                if (i == 0 && i2 == 0) {
                    if (this.lBn < 0 || this.lBn >= this.lyd.size()) {
                        AppMethodBeat.o(19993);
                        return;
                    }
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(19987);
                            a.this.lyd.remove(a.this.lBn);
                            a.this.notifyDataSetChanged();
                            a.this.lBn = -1;
                            AppMethodBeat.o(19987);
                        }
                    });
                }
            }
            AppMethodBeat.o(19993);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.w8;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(19997);
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(19982);
                ExdeviceManageDeviceUI.this.finish();
                AppMethodBeat.o(19982);
                return true;
            }
        });
        setMMTitle((int) R.string.bgq);
        dk dkVar = new dk();
        dkVar.cwH.cwI = true;
        com.tencent.mm.sdk.b.a.xxA.m(dkVar);
        initView();
        aw.Rg().a(537, this.lBi);
        AppMethodBeat.o(19997);
    }

    public final void initView() {
        AppMethodBeat.i(19998);
        this.mListView = (ListView) findViewById(R.id.a46);
        this.lBi = new a(this);
        View.inflate(this, R.layout.vw, null);
        this.mListView.setAdapter(this.lBi);
        AppMethodBeat.o(19998);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(19999);
        this.lBi.bw(ad.boW().bpB());
        this.lBi.notifyDataSetChanged();
        AppMethodBeat.o(19999);
    }

    public void onDestroy() {
        AppMethodBeat.i(i.sHCENCODEVIDEOTIMEOUT);
        super.onDestroy();
        aw.Rg().b(537, this.lBi);
        AppMethodBeat.o(i.sHCENCODEVIDEOTIMEOUT);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(CdnLogic.kMediaTypeBackupFile);
        if (i == 4 && keyEvent.getRepeatCount() == 0 && this.lBi.lBk) {
            updateOptionMenuText(0, getString(R.string.pg));
            a aVar = this.lBi;
            if (aVar.lBk) {
                aVar.lBk = false;
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(19986);
                        a.this.notifyDataSetChanged();
                        AppMethodBeat.o(19986);
                    }
                });
            }
            AppMethodBeat.o(CdnLogic.kMediaTypeBackupFile);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(CdnLogic.kMediaTypeBackupFile);
        return onKeyDown;
    }
}
