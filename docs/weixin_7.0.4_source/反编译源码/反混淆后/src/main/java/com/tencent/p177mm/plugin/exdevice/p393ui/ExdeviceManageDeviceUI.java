package com.tencent.p177mm.plugin.exdevice.p393ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p230g.p231a.C26114dk;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.plugin.exdevice.model.C20540x;
import com.tencent.p177mm.plugin.exdevice.model.C45891ad;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.plugin.exdevice.p956h.C11648b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI */
public class ExdeviceManageDeviceUI extends MMActivity {
    private C38977a lBi;
    private ListView mListView;

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI$1 */
    class C117091 implements OnMenuItemClickListener {
        C117091() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(19982);
            ExdeviceManageDeviceUI.this.finish();
            AppMethodBeat.m2505o(19982);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI$a */
    static final class C38977a extends BaseAdapter implements C1202f {
        private C5279d jMV;
        private WeakReference<Context> jQk;
        boolean lBk;
        private OnClickListener lBl;
        private C46696j lBm;
        private volatile int lBn = -1;
        private List<C11648b> lyd;
        private C25814c lyr;
        private C44275p tipDialog = null;

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI$a$1 */
        class C117101 implements C5279d {
            C117101() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(19983);
                int itemId = menuItem.getItemId();
                C4990ab.m7411d("MicroMsg.ExdeviceManageDeviceUI", "onMenuItemSelected, itemId(%d), count(%d).", Integer.valueOf(itemId), Integer.valueOf(C38977a.this.getCount()));
                if (itemId < 0 || itemId >= r1) {
                    AppMethodBeat.m2505o(19983);
                    return;
                }
                C38977a.this.lBn = itemId;
                C38977a.m66209a(C38977a.this, (C11648b) C38977a.this.lyd.get(itemId));
                C38977a.this.notifyDataSetChanged();
                AppMethodBeat.m2505o(19983);
            }
        }

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI$a$2 */
        class C340562 implements OnClickListener {
            C340562() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(19984);
                if (C38977a.this.lBk) {
                    AppMethodBeat.m2505o(19984);
                    return;
                }
                Object tag = view.getTag();
                if (tag == null || !(tag instanceof Integer)) {
                    AppMethodBeat.m2505o(19984);
                    return;
                }
                int intValue = ((Integer) tag).intValue();
                if (intValue < 0 || intValue >= C38977a.this.getCount()) {
                    AppMethodBeat.m2505o(19984);
                    return;
                }
                C11648b uT = C38977a.this.mo61862uT(intValue);
                Context context = (Context) C38977a.this.jQk.get();
                if (context == null) {
                    C4990ab.m7412e("MicroMsg.ExdeviceManageDeviceUI", "Start activity failed, context is null.");
                    AppMethodBeat.m2505o(19984);
                    return;
                }
                C38977a.m66208a(context, uT);
                AppMethodBeat.m2505o(19984);
            }
        }

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI$a$3 */
        class C340573 implements OnCancelListener {
            C340573() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        }

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI$a$6 */
        class C340596 implements Runnable {
            C340596() {
            }

            public final void run() {
                AppMethodBeat.m2504i(19987);
                C38977a.this.lyd.remove(C38977a.this.lBn);
                C38977a.this.notifyDataSetChanged();
                C38977a.this.lBn = -1;
                AppMethodBeat.m2505o(19987);
            }
        }

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI$a$5 */
        class C389755 implements Runnable {
            C389755() {
            }

            public final void run() {
                AppMethodBeat.m2504i(19986);
                C38977a.this.notifyDataSetChanged();
                AppMethodBeat.m2505o(19986);
            }
        }

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI$a$a */
        static class C38976a {
            TextView gxi;
            ImageView iqT;
            View lBq;
            View lBr;

            private C38976a() {
            }

            /* synthetic */ C38976a(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(19994);
            C11648b uT = mo61862uT(i);
            AppMethodBeat.m2505o(19994);
            return uT;
        }

        public C38977a(Context context) {
            AppMethodBeat.m2504i(19988);
            this.jQk = new WeakReference(context);
            this.lyd = new LinkedList();
            this.lBm = new C46696j(context);
            C17927a c17927a = new C17927a();
            c17927a.ePT = C25738R.drawable.ads;
            this.lyr = c17927a.ahG();
            this.jMV = new C117101();
            this.lBl = new C340562();
            mo61857bw(C45891ad.boW().bpB());
            AppMethodBeat.m2505o(19988);
        }

        /* renamed from: bw */
        public final void mo61857bw(List<C11648b> list) {
            AppMethodBeat.m2504i(19989);
            this.lyd.clear();
            if (list == null || list.size() == 0) {
                AppMethodBeat.m2505o(19989);
                return;
            }
            this.lyd.addAll(list);
            AppMethodBeat.m2505o(19989);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(19990);
            int size = this.lyd.size();
            AppMethodBeat.m2505o(19990);
            return size;
        }

        /* renamed from: uT */
        public final C11648b mo61862uT(int i) {
            AppMethodBeat.m2504i(19991);
            C11648b c11648b = (C11648b) this.lyd.get(i);
            AppMethodBeat.m2505o(19991);
            return c11648b;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C38976a c38976a;
            CharSequence charSequence;
            AppMethodBeat.m2504i(19992);
            C11648b uT = mo61862uT(i);
            if (view == null) {
                c38976a = new C38976a();
                view = View.inflate(viewGroup.getContext(), 2130969425, null);
                c38976a.lBq = view.findViewById(2131821064);
                c38976a.gxi = (TextView) view.findViewById(2131823625);
                c38976a.lBr = view.findViewById(2131823666);
                c38976a.iqT = (ImageView) view.findViewById(2131823624);
                view.setTag(c38976a);
            } else {
                c38976a = (C38976a) view.getTag();
            }
            if (uT == null) {
                charSequence = "";
            } else {
                String str;
                if (!C5046bo.isNullOrNil(uT.dFl)) {
                    str = uT.dFl;
                } else if (!C5046bo.isNullOrNil(uT.dFm)) {
                    str = uT.dFm;
                } else if (uT.field_mac != 0) {
                    str = C42992b.m76358ie(uT.field_mac);
                } else if (C5046bo.isNullOrNil(uT.field_deviceID)) {
                    str = null;
                } else {
                    str = uT.field_deviceID;
                }
                charSequence = C5046bo.nullAsNil(str);
            }
            C4990ab.m7411d("MicroMsg.ExdeviceManageDeviceUI", "position(%s), name(%s), mac(%s).", Integer.valueOf(i), charSequence, Long.valueOf(uT.field_mac));
            c38976a.gxi.setText(charSequence);
            C32291o.ahp().mo43766a(uT.iconUrl, c38976a.iqT, this.lyr);
            c38976a.lBr.setTag(Integer.valueOf(i));
            if (this.lBk) {
                c38976a.lBr.setVisibility(0);
            } else {
                c38976a.lBr.setVisibility(8);
            }
            c38976a.lBq.setTag(Integer.valueOf(i));
            c38976a.lBq.setOnClickListener(this.lBl);
            AppMethodBeat.m2505o(19992);
            return view;
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(19993);
            if (c1207m == null) {
                C4990ab.m7412e("MicroMsg.ExdeviceManageDeviceUI", "scene is null.");
                AppMethodBeat.m2505o(19993);
                return;
            }
            if (c1207m instanceof C20540x) {
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.dismiss();
                }
                if (i == 0 && i2 == 0) {
                    if (this.lBn < 0 || this.lBn >= this.lyd.size()) {
                        AppMethodBeat.m2505o(19993);
                        return;
                    }
                    C5004al.m7441d(new C340596());
                }
            }
            AppMethodBeat.m2505o(19993);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130969426;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(19997);
        super.onCreate(bundle);
        setBackBtn(new C117091());
        setMMTitle((int) C25738R.string.bgq);
        C26114dk c26114dk = new C26114dk();
        c26114dk.cwH.cwI = true;
        C4879a.xxA.mo10055m(c26114dk);
        initView();
        C9638aw.m17182Rg().mo14539a(537, this.lBi);
        AppMethodBeat.m2505o(19997);
    }

    public final void initView() {
        AppMethodBeat.m2504i(19998);
        this.mListView = (ListView) findViewById(2131821698);
        this.lBi = new C38977a(this);
        View.inflate(this, 2130969414, null);
        this.mListView.setAdapter(this.lBi);
        AppMethodBeat.m2505o(19998);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(19999);
        this.lBi.mo61857bw(C45891ad.boW().bpB());
        this.lBi.notifyDataSetChanged();
        AppMethodBeat.m2505o(19999);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(C1625i.sHCENCODEVIDEOTIMEOUT);
        super.onDestroy();
        C9638aw.m17182Rg().mo14546b(537, this.lBi);
        AppMethodBeat.m2505o(C1625i.sHCENCODEVIDEOTIMEOUT);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(CdnLogic.kMediaTypeBackupFile);
        if (i == 4 && keyEvent.getRepeatCount() == 0 && this.lBi.lBk) {
            updateOptionMenuText(0, getString(C25738R.string.f9099pg));
            C38977a c38977a = this.lBi;
            if (c38977a.lBk) {
                c38977a.lBk = false;
                C5004al.m7441d(new C389755());
            }
            AppMethodBeat.m2505o(CdnLogic.kMediaTypeBackupFile);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(CdnLogic.kMediaTypeBackupFile);
        return onKeyDown;
    }
}
