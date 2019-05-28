package com.tencent.p177mm.plugin.exdevice.p393ui;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.p177mm.plugin.exdevice.model.C20495e;
import com.tencent.p177mm.plugin.exdevice.model.C20495e.C20494b;
import com.tencent.p177mm.plugin.exdevice.model.C20536p;
import com.tencent.p177mm.plugin.exdevice.model.C20538v;
import com.tencent.p177mm.plugin.exdevice.model.C27852f;
import com.tencent.p177mm.plugin.exdevice.model.C38956j;
import com.tencent.p177mm.plugin.exdevice.model.C38956j.C34038a;
import com.tencent.p177mm.plugin.exdevice.model.C42998t;
import com.tencent.p177mm.plugin.exdevice.model.C45891ad;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.plugin.p369d.p370a.p1606e.C42904a;
import com.tencent.p177mm.protocal.protobuf.ajl;
import com.tencent.p177mm.protocal.protobuf.asq;
import com.tencent.p177mm.protocal.protobuf.asr;
import com.tencent.p177mm.protocal.protobuf.bbv;
import com.tencent.p177mm.protocal.protobuf.buq;
import com.tencent.p177mm.protocal.protobuf.bvu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.RegionCodeDecoder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.json.JSONObject;

@SuppressLint({"Assert"})
/* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI */
public class ExdeviceBindDeviceUI extends MMActivity implements C1202f, C20494b {
    static final /* synthetic */ boolean $assertionsDisabled = (!ExdeviceBindDeviceUI.class.desiredAssertionStatus());
    private ProgressDialog ehJ;
    private ScrollView hJh;
    private TextView klD;
    private String lst;
    private C34038a ltg;
    private String lxI;
    private C11671a lyS;
    private View lyT;
    private TextView lyU;
    private ImageView lyV;
    private View lyW;
    private C11682e lyX;
    private String lyY;
    private String lyZ;
    private TextView lyf;
    private TextView lyg;
    private boolean lza = false;
    private C34038a lzb;
    private boolean lzc = false;
    private boolean lzd = false;
    private ListView mListView;

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI$10 */
    class C299310 extends ClickableSpan {
        C299310() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(19835);
            ExdeviceBindDeviceUI.this.finish();
            AppMethodBeat.m2505o(19835);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.m2504i(19836);
            textPaint.setColor(textPaint.linkColor);
            textPaint.setUnderlineText(false);
            AppMethodBeat.m2505o(19836);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI$1 */
    class C116681 implements OnMenuItemClickListener {
        C116681() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(19824);
            ExdeviceBindDeviceUI.this.finish();
            AppMethodBeat.m2505o(19824);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI$9 */
    class C116709 extends ClickableSpan {
        C116709() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(19833);
            C27852f.m44278ao(ExdeviceBindDeviceUI.this.mController.ylL, "http://o2o.gtimg.com/mydevice/page/deviceHelp.html");
            AppMethodBeat.m2505o(19833);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.m2504i(19834);
            textPaint.setColor(textPaint.linkColor);
            textPaint.setUnderlineText(false);
            AppMethodBeat.m2505o(19834);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI$a */
    static final class C11671a extends BaseAdapter {
        private C25814c lyr;
        List<C11683f> lzl = new ArrayList();
        private String lzm;
        private C11682e lzn;
        private String lzo;

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI$a$a */
        static class C11672a {
            TextView gxi;
            ImageView iqT;

            private C11672a() {
            }

            /* synthetic */ C11672a(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(19849);
            C11683f uO = mo23437uO(i);
            AppMethodBeat.m2505o(19849);
            return uO;
        }

        public C11671a(String str, C11682e c11682e, String str2) {
            AppMethodBeat.m2504i(19837);
            this.lzm = str;
            this.lzn = c11682e;
            this.lzo = str2;
            C17927a c17927a = new C17927a();
            c17927a.ePV = C25738R.color.f12305zf;
            this.lyr = c17927a.ahG();
            AppMethodBeat.m2505o(19837);
        }

        /* Access modifiers changed, original: final */
        public final void bpE() {
            AppMethodBeat.m2504i(19838);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.lzl.size()) {
                    C11683f c11683f = (C11683f) this.lzl.get(i2);
                    c11683f.lzx = mo23431c(c11683f);
                    i = i2 + 1;
                } else {
                    AppMethodBeat.m2505o(19838);
                    return;
                }
            }
        }

        /* renamed from: b */
        public final boolean mo23429b(C11683f c11683f) {
            AppMethodBeat.m2504i(19839);
            if (m19484KD(c11683f.getKey()) < 0) {
                AppMethodBeat.m2505o(19839);
                return false;
            }
            c11683f.lzx = mo23431c(c11683f);
            AppMethodBeat.m2505o(19839);
            return true;
        }

        /* renamed from: KB */
        public final boolean mo23427KB(String str) {
            AppMethodBeat.m2504i(19840);
            if (m19484KD(str) >= 0) {
                AppMethodBeat.m2505o(19840);
                return true;
            }
            AppMethodBeat.m2505o(19840);
            return false;
        }

        /* renamed from: KC */
        public final C11683f mo23428KC(String str) {
            AppMethodBeat.m2504i(19841);
            if (str == null || str.length() == 0) {
                AppMethodBeat.m2505o(19841);
                return null;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.lzl.size()) {
                    C11683f c11683f = (C11683f) this.lzl.get(i2);
                    if (C11671a.m19485KE(c11683f.bpF()) || !str.equalsIgnoreCase(c11683f.bpF())) {
                        i = i2 + 1;
                    } else {
                        AppMethodBeat.m2505o(19841);
                        return c11683f;
                    }
                }
                AppMethodBeat.m2505o(19841);
                return null;
            }
        }

        public final int getCount() {
            AppMethodBeat.m2504i(19842);
            int i = 0;
            for (int i2 = 0; i2 < this.lzl.size(); i2++) {
                if (((C11683f) this.lzl.get(i2)).lzx) {
                    i++;
                }
            }
            AppMethodBeat.m2505o(19842);
            return i;
        }

        /* renamed from: uO */
        public final C11683f mo23437uO(int i) {
            AppMethodBeat.m2504i(19843);
            int i2 = -1;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.lzl.size()) {
                    if (((C11683f) this.lzl.get(i4)).lzx) {
                        i2++;
                    }
                    if (i2 == i) {
                        C11683f c11683f = (C11683f) this.lzl.get(i4);
                        AppMethodBeat.m2505o(19843);
                        return c11683f;
                    }
                    i3 = i4 + 1;
                } else {
                    AppMethodBeat.m2505o(19843);
                    return null;
                }
            }
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C11672a c11672a;
            View inflate;
            AppMethodBeat.m2504i(19844);
            C11683f uO = mo23437uO(i);
            if (view == null) {
                c11672a = new C11672a();
                inflate = View.inflate(viewGroup.getContext(), 2130969412, null);
                c11672a.gxi = (TextView) inflate.findViewById(2131823625);
                c11672a.iqT = (ImageView) inflate.findViewById(2131823624);
                inflate.setTag(c11672a);
            } else {
                c11672a = (C11672a) view.getTag();
                inflate = view;
            }
            if (uO == null || uO.lzC == null) {
                Assert.assertTrue(false);
                AppMethodBeat.m2505o(19844);
                return inflate;
            }
            String str;
            String str2;
            SpannableString spannableString;
            if (uO.lzy == C11676b.CONNECT_PROTO_TYPE_BLUE) {
                C4990ab.m7411d("MicroMsg.ExdeviceBindDeviceUI", "position(%s), broadcastname(%s), mac(%s), deviceTitle(%s).", Integer.valueOf(i), uO.lzz.lzs, uO.lzz.cbq, uO.lzC.wwt);
                str = "";
                str2 = uO.lzC.dFt;
                if (str2 != null && str2.length() >= 4) {
                    str = str2.substring(str2.length() - 4, str2.length());
                } else if (uO.lzz.cbq != null && uO.lzz.cbq.length() >= 4) {
                    str = uO.lzz.cbq;
                    str = str.substring(str.length() - 4, str.length());
                }
                str = uO.lzC.wwt + " " + str;
                spannableString = new SpannableString(str);
                spannableString.setSpan(new ForegroundColorSpan(viewGroup.getContext().getResources().getColor(C25738R.color.f12092s0)), uO.lzC.wwt.length() + 1, str.length(), 17);
                c11672a.gxi.setText(spannableString);
            } else if (uO.lzy == C11676b.CONNECT_PROTO_TYPE_WIFI) {
                str = "";
                str2 = uO.lzC.dFt;
                if (str2 != null && str2.length() >= 4) {
                    str = str2.substring(str2.length() - 4, str2.length());
                } else if (uO.lzC.vKF != null && uO.lzC.vKF.length() >= 4) {
                    str = uO.lzC.vKF;
                    str = str.substring(str.length() - 4, str.length());
                }
                str = uO.lzC.wwt + " " + str;
                spannableString = new SpannableString(str);
                spannableString.setSpan(new ForegroundColorSpan(viewGroup.getContext().getResources().getColor(C25738R.color.f12092s0)), uO.lzC.wwt.length() + 1, str.length(), 17);
                c11672a.gxi.setText(spannableString);
            } else {
                Assert.assertTrue(false);
            }
            str = uO.lzC.IconUrl;
            if (!C11671a.m19485KE(str)) {
                C32291o.ahp().mo43766a(str, c11672a.iqT, this.lyr);
            }
            AppMethodBeat.m2505o(19844);
            return inflate;
        }

        /* renamed from: KD */
        private int m19484KD(String str) {
            AppMethodBeat.m2504i(19845);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.lzl.size()) {
                    AppMethodBeat.m2505o(19845);
                    return -1;
                } else if (((C11683f) this.lzl.get(i2)).getKey().compareTo(str) == 0) {
                    AppMethodBeat.m2505o(19845);
                    return i2;
                } else {
                    i = i2 + 1;
                }
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dV */
        public final int mo23432dV(String str, String str2) {
            AppMethodBeat.m2504i(19846);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.lzl.size()) {
                    C11683f c11683f = (C11683f) this.lzl.get(i2);
                    String str3 = c11683f.lzB != null ? c11683f.lzB.vIk : c11683f.lzy == C11676b.CONNECT_PROTO_TYPE_WIFI ? c11683f.lzA.lxI : null;
                    String str4 = c11683f.lzB != null ? c11683f.lzB.jBE : c11683f.lzy == C11676b.CONNECT_PROTO_TYPE_WIFI ? c11683f.lzA.lsu : null;
                    if (C11671a.m19485KE(str3) || C11671a.m19485KE(str4) || str.compareTo(str3) != 0 || str2.compareTo(str4) != 0) {
                        i = i2 + 1;
                    } else {
                        AppMethodBeat.m2505o(19846);
                        return i2;
                    }
                }
                AppMethodBeat.m2505o(19846);
                return -1;
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: c */
        public final boolean mo23431c(C11683f c11683f) {
            AppMethodBeat.m2504i(19847);
            if (c11683f.lzC == null) {
                AppMethodBeat.m2505o(19847);
                return false;
            }
            if (this.lzn == C11682e.SCAN_CATALOG) {
                if (c11683f.lzC.wwm == null || c11683f.lzC.wwm.compareTo(this.lzm) != 0) {
                    AppMethodBeat.m2505o(19847);
                    return false;
                } else if (c11683f.lzC.wwv == null || c11683f.lzC.wwv.compareTo(this.lzo) != 0) {
                    AppMethodBeat.m2505o(19847);
                    return false;
                }
            } else if (this.lzn != C11682e.SCAN_MY_DEVICE) {
                Assert.assertTrue(false);
                AppMethodBeat.m2505o(19847);
                return false;
            } else if (c11683f.lzC.dFp == 0) {
                AppMethodBeat.m2505o(19847);
                return false;
            }
            AppMethodBeat.m2505o(19847);
            return true;
        }

        /* renamed from: KE */
        private static boolean m19485KE(String str) {
            AppMethodBeat.m2504i(19848);
            if (str == null || str.length() == 0) {
                AppMethodBeat.m2505o(19848);
                return true;
            }
            AppMethodBeat.m2505o(19848);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI$c */
    class C11673c {
        public String cbq;
        public String lzs;

        private C11673c() {
        }

        /* synthetic */ C11673c(ExdeviceBindDeviceUI exdeviceBindDeviceUI, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI$d */
    class C11674d {
        public String lsu;
        public String lxI;

        private C11674d() {
        }

        /* synthetic */ C11674d(ExdeviceBindDeviceUI exdeviceBindDeviceUI, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI$b */
    enum C11676b {
        CONNECT_PROTO_TYPE_WIFI,
        CONNECT_PROTO_TYPE_BLUE;

        static {
            AppMethodBeat.m2505o(19852);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI$6 */
    class C116776 implements Runnable {
        C116776() {
        }

        public final void run() {
            AppMethodBeat.m2504i(19830);
            Java2CExDevice.stopScanWCLanDevice();
            Java2CExDevice.releaseWCLanDeviceLib();
            AppMethodBeat.m2505o(19830);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI$2 */
    class C116782 extends ClickableSpan {
        C116782() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(19825);
            ExdeviceBindDeviceUI.this.finish();
            AppMethodBeat.m2505o(19825);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.m2504i(19826);
            textPaint.setColor(textPaint.linkColor);
            textPaint.setUnderlineText(false);
            AppMethodBeat.m2505o(19826);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI$3 */
    class C116793 implements C34038a {
        C116793() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0048 A:{SKIP} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: g */
        public final void mo7189g(int i, Object... objArr) {
            Throwable e;
            AppMethodBeat.m2504i(19828);
            if (i != 10 || objArr == null) {
                AppMethodBeat.m2505o(19828);
                return;
            }
            String string;
            String string2;
            String string3;
            try {
                JSONObject jSONObject = new JSONObject(new String((byte[]) objArr[0]));
                JSONObject jSONObject2 = jSONObject.getJSONObject("deviceInfo");
                string = jSONObject2.getString("deviceType");
                try {
                    string3 = jSONObject2.getString("deviceId");
                } catch (Exception e2) {
                    e = e2;
                    string3 = null;
                }
                try {
                    if (!jSONObject.isNull("manufacturerData")) {
                        string2 = jSONObject.getString("manufacturerData");
                        if (string != null || string3 == null) {
                            AppMethodBeat.m2505o(19828);
                        }
                        final C11683f c11683f = new C11683f(ExdeviceBindDeviceUI.this, (byte) 0);
                        c11683f.lzy = C11676b.CONNECT_PROTO_TYPE_WIFI;
                        c11683f.lzA = new C11674d(ExdeviceBindDeviceUI.this, (byte) 0);
                        c11683f.lzA.lxI = string;
                        c11683f.lzA.lsu = string3;
                        if (C5046bo.isNullOrNil(string2)) {
                            c11683f.lzF = null;
                        } else {
                            c11683f.lzF = Base64.encodeToString(string2.getBytes(), 2);
                            C4990ab.m7417i("MicroMsg.ExdeviceBindDeviceUI", "device.mManufacturerData: %s", c11683f.lzF);
                        }
                        C5004al.m7441d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(19827);
                                ExdeviceBindDeviceUI.this.mo23420a(c11683f);
                                AppMethodBeat.m2505o(19827);
                            }
                        });
                        AppMethodBeat.m2505o(19828);
                        return;
                    }
                } catch (Exception e3) {
                    e = e3;
                    C4990ab.printErrStackTrace("MicroMsg.ExdeviceBindDeviceUI", e, "", new Object[0]);
                    C4990ab.m7412e("MicroMsg.ExdeviceBindDeviceUI", "json decode failed: deviceInfo decode");
                    string2 = null;
                    if (string != null) {
                    }
                    AppMethodBeat.m2505o(19828);
                }
            } catch (Exception e4) {
                e = e4;
                string3 = null;
                string = null;
            }
            string2 = null;
            if (string != null) {
            }
            AppMethodBeat.m2505o(19828);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI$5 */
    class C116805 implements OnItemClickListener {
        C116805() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(19829);
            C11683f uO = ExdeviceBindDeviceUI.this.lyS.mo23437uO(i - ((ListView) adapterView).getHeaderViewsCount());
            if (uO.lzC.dFp != 0) {
                ExdeviceBindDeviceUI.m19477a(ExdeviceBindDeviceUI.this, uO);
                AppMethodBeat.m2505o(19829);
                return;
            }
            ExdeviceBindDeviceUI.m19478b(ExdeviceBindDeviceUI.this, uO);
            AppMethodBeat.m2505o(19829);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI$4 */
    class C116814 implements C34038a {
        C116814() {
        }

        /* renamed from: g */
        public final void mo7189g(int i, Object... objArr) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI$e */
    enum C11682e {
        SCAN_ALL,
        SCAN_MY_DEVICE,
        SCAN_CATALOG;

        static {
            AppMethodBeat.m2505o(19855);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI$f */
    class C11683f {
        public String lyG;
        public C11674d lzA;
        public asq lzB;
        public asr lzC;
        public int lzD;
        public bbv lzE;
        public String lzF;
        public boolean lzx;
        public C11676b lzy;
        public C11673c lzz;

        private C11683f() {
            this.lzx = false;
            this.lzy = C11676b.CONNECT_PROTO_TYPE_WIFI;
        }

        /* synthetic */ C11683f(ExdeviceBindDeviceUI exdeviceBindDeviceUI, byte b) {
            this();
        }

        public final String getKey() {
            AppMethodBeat.m2504i(19856);
            String str;
            if (this.lzy == C11676b.CONNECT_PROTO_TYPE_WIFI) {
                str = this.lzA.lxI + this.lzA.lsu;
                AppMethodBeat.m2505o(19856);
                return str;
            }
            str = this.lzz.cbq;
            AppMethodBeat.m2505o(19856);
            return str;
        }

        public final String bpF() {
            if (this.lzy != C11676b.CONNECT_PROTO_TYPE_WIFI) {
                return this.lzz.cbq;
            }
            if (this.lzC == null) {
                return null;
            }
            return this.lzC.vKF;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    static {
        AppMethodBeat.m2504i(19870);
        AppMethodBeat.m2505o(19870);
    }

    public final int getLayoutId() {
        return 2130969413;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(19857);
        super.onCreate(bundle);
        setBackBtn(new C116681());
        Intent intent = getIntent();
        this.lyY = intent.getStringExtra("device_category_id");
        this.lst = intent.getStringExtra("device_brand_name");
        this.lxI = intent.getStringExtra("device_type");
        if (this.lxI == null || this.lxI.length() == 0) {
            this.lxI = this.lst;
        }
        String stringExtra = intent.getStringExtra("device_scan_conn_proto");
        String stringExtra2 = intent.getStringExtra("device_scan_mode");
        String str = "";
        String stringExtra3 = intent.getStringExtra("device_title");
        if (C5046bo.isNullOrNil(stringExtra3)) {
            stringExtra3 = this.mController.ylL.getString(C25738R.string.bg6);
        }
        if (stringExtra2.contains("SCAN_MY_DEVICE")) {
            this.lyX = C11682e.SCAN_MY_DEVICE;
            str = this.mController.ylL.getString(C25738R.string.beh);
        } else if (stringExtra2.compareTo("SCAN_CATALOG") == 0) {
            this.lyX = C11682e.SCAN_CATALOG;
            str = this.mController.ylL.getString(C25738R.string.bef);
        } else {
            Assert.assertTrue(false);
        }
        setMMTitle(str);
        if (this.lyX == C11682e.SCAN_CATALOG) {
            this.lzc = stringExtra.contains("wifi");
            this.lzd = stringExtra.contains("blue");
            C4990ab.m7417i("MicroMsg.ExdeviceBindDeviceUI", "mIsScanWifi(%b), mIsScanBlue(%b)", Boolean.valueOf(this.lzc), Boolean.valueOf(this.lzd));
        } else if (this.lyX == C11682e.SCAN_MY_DEVICE) {
            this.lzd = true;
            this.lzc = true;
        }
        this.ltg = new C116793();
        this.lzb = new C116814();
        initView();
        this.klD.setText(this.mController.ylL.getString(C25738R.string.bhx, new Object[]{stringExtra3}));
        C9638aw.m17182Rg().mo14539a(1264, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(1706, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(1270, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(1719, (C1202f) this);
        if (this.lzd) {
            C45891ad.bph().mo35801a((C20494b) this);
        }
        if (this.lzc) {
            C38956j.boN().mo61836a(10, this.ltg);
            C38956j.boN().mo61836a(11, this.lzb);
            Java2CExDevice.initWCLanDeviceLib();
        }
        AppMethodBeat.m2505o(19857);
    }

    public void onResume() {
        AppMethodBeat.m2504i(19858);
        super.onResume();
        C4990ab.m7416i("MicroMsg.ExdeviceBindDeviceUI", "onResume start scan.");
        if (this.lzd) {
            C45891ad.bph();
            C20495e.boJ();
        }
        if (this.lzc) {
            Java2CExDevice.startScanWCLanDevice(new byte[0], 1000);
        }
        this.lyS.bpE();
        this.lyS.notifyDataSetChanged();
        AppMethodBeat.m2505o(19858);
    }

    public final void initView() {
        AppMethodBeat.m2504i(19859);
        this.mListView = (ListView) findViewById(2131821698);
        View inflate = View.inflate(this, 2130969415, null);
        this.lyW = View.inflate(this, 2130969448, null);
        this.lyT = this.lyW.findViewById(2131823631);
        this.klD = (TextView) this.lyW.findViewById(2131823632);
        this.lyU = (TextView) findViewById(2131823630);
        this.lyV = (ImageView) findViewById(2131823626);
        this.lyf = (TextView) findViewById(2131823627);
        this.lyg = (TextView) findViewById(2131823628);
        this.hJh = (ScrollView) findViewById(2131823642);
        this.mListView.addHeaderView(inflate, null, false);
        this.mListView.addFooterView(this.lyW, null, false);
        this.lyS = new C11671a(this.lst, this.lyX, this.lyY);
        this.mListView.setAdapter(this.lyS);
        this.mListView.setOnItemClickListener(new C116805());
        if (this.lzd && !this.lzc) {
            if (!C42904a.m76178dv(this.mController.ylL)) {
                C4990ab.m7417i("MicroMsg.ExdeviceBindDeviceUI", "now sdk version not support ble device : %d", Integer.valueOf(VERSION.SDK_INT));
                m19479uM(4);
                AppMethodBeat.m2505o(19859);
                return;
            } else if (!C42904a.aVH()) {
                C4990ab.m7416i("MicroMsg.ExdeviceBindDeviceUI", "Bluetooth is not open, Just leave");
                m19479uM(3);
                AppMethodBeat.m2505o(19859);
                return;
            }
        }
        if (!this.lzd && this.lzc && !C5023at.isWifi(this.mController.ylL)) {
            C4990ab.m7416i("MicroMsg.ExdeviceBindDeviceUI", "wifi is not open, Just leave");
            m19479uM(5);
            AppMethodBeat.m2505o(19859);
        } else if (this.lyX == C11682e.SCAN_MY_DEVICE) {
            m19479uM(0);
            AppMethodBeat.m2505o(19859);
        } else {
            if (this.lyX != C11682e.SCAN_CATALOG) {
                C11682e c11682e = C11682e.SCAN_ALL;
                Assert.assertTrue(false);
            } else if (this.lzd && this.lzc) {
                Assert.assertTrue(false);
                m19479uM(1);
                AppMethodBeat.m2505o(19859);
                return;
            } else if (this.lzd) {
                m19479uM(2);
                AppMethodBeat.m2505o(19859);
                return;
            } else if (this.lzc) {
                m19479uM(1);
                AppMethodBeat.m2505o(19859);
                return;
            }
            AppMethodBeat.m2505o(19859);
        }
    }

    public void onPause() {
        AppMethodBeat.m2504i(19860);
        super.onPause();
        C4990ab.m7416i("MicroMsg.ExdeviceBindDeviceUI", "onPause stop scan.");
        if (this.lzc) {
            Java2CExDevice.stopScanWCLanDevice();
        }
        if (this.lzd) {
            C45891ad.bpi().stopScan();
        }
        AppMethodBeat.m2505o(19860);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(19861);
        super.onDestroy();
        if (this.lzc) {
            C9638aw.m17180RS().mo10302aa(new C116776());
            C38956j.boN().mo61837b(10, this.ltg);
            C38956j.boN().mo61837b(11, this.lzb);
        }
        if (this.lzd) {
            C45891ad.bph().mo35803b(this);
            C45891ad.bpi().stopScan();
        }
        C9638aw.m17182Rg().mo14546b(1264, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(1706, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(1270, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(1719, (C1202f) this);
        AppMethodBeat.m2505o(19861);
    }

    /* renamed from: p */
    public final void mo23423p(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(19862);
        C4990ab.m7411d("MicroMsg.ExdeviceBindDeviceUI", "onScanResult, broadcastName(%s), mac(%s), isCompleted(%b).", str, str2, Boolean.valueOf(z));
        if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7413e("MicroMsg.ExdeviceBindDeviceUI", "onScanResult failed, broadcastName(%s), mac(%s), isCompleted(%b).", str, str2, Boolean.valueOf(z));
            AppMethodBeat.m2505o(19862);
            return;
        }
        final C11683f c11683f = new C11683f(this, (byte) 0);
        c11683f.lzy = C11676b.CONNECT_PROTO_TYPE_BLUE;
        c11683f.lzz = new C11673c(this, (byte) 0);
        c11683f.lzz.lzs = str;
        c11683f.lzz.cbq = C42992b.m76359if(C42992b.m76346KK(str2));
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(19831);
                ExdeviceBindDeviceUI.this.mo23420a(c11683f);
                AppMethodBeat.m2505o(19831);
            }
        });
        AppMethodBeat.m2505o(19862);
    }

    /* renamed from: c */
    public final void mo23422c(String str, int i, long j) {
    }

    /* renamed from: b */
    public final void mo23421b(String str, byte[] bArr, boolean z) {
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(19863);
        C4990ab.m7417i("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (c1207m == null) {
            C4990ab.m7412e("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, scene is null.");
            AppMethodBeat.m2505o(19863);
            return;
        }
        final int i3 = i;
        final int i4 = i2;
        final String str2 = str;
        final C1207m c1207m2 = c1207m;
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(19832);
                ExdeviceBindDeviceUI.m19476a(ExdeviceBindDeviceUI.this, i3, i4, str2, c1207m2);
                AppMethodBeat.m2505o(19832);
            }
        });
        AppMethodBeat.m2505o(19863);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo23420a(C11683f c11683f) {
        AppMethodBeat.m2504i(19864);
        if (this.lyS.mo23427KB(c11683f.getKey())) {
            AppMethodBeat.m2505o(19864);
            return;
        }
        C4990ab.m7410d("MicroMsg.ExdeviceBindDeviceUI", "Add device: " + c11683f.bpF());
        C11671a c11671a = this.lyS;
        if (!(c11683f == null || c11671a.mo23427KB(c11683f.getKey()))) {
            c11683f.lzx = c11671a.mo23431c(c11683f);
            c11671a.lzl.add(c11683f);
        }
        this.lyS.notifyDataSetChanged();
        if (c11683f.lzy == C11676b.CONNECT_PROTO_TYPE_BLUE) {
            C4990ab.m7417i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice doScene, mac(%s), brandName(%s),categoryId(%s)", c11683f.lzz.cbq, this.lst, this.lyY);
            C9638aw.m17182Rg().mo14541a(new C42998t(c11683f.lzz.cbq, this.lst, this.lyY), 0);
            AppMethodBeat.m2505o(19864);
        } else if (c11683f.lzy == C11676b.CONNECT_PROTO_TYPE_WIFI) {
            C4990ab.m7417i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice doScene, deviceType(%s), deviceId(%s)", c11683f.lzA.lxI, c11683f.lzA.lsu);
            C9638aw.m17182Rg().mo14541a(new C20538v(c11683f.lzA.lxI, c11683f.lzA.lsu, c11683f.lzF), 0);
            AppMethodBeat.m2505o(19864);
        } else {
            Assert.assertTrue(false);
            AppMethodBeat.m2505o(19864);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(19865);
        this.lyS.bpE();
        this.lyS.notifyDataSetChanged();
        AppMethodBeat.m2505o(19865);
    }

    /* renamed from: uM */
    private void m19479uM(int i) {
        AppMethodBeat.m2504i(19866);
        String string;
        String string2;
        SpannableString spannableString;
        switch (i) {
            case 0:
                string = getString(C25738R.string.beu);
                SpannableString spannableString2 = new SpannableString(string);
                spannableString2.setSpan(new ForegroundColorSpan(C25738R.color.f12123t7), 0, string.length(), 33);
                spannableString2.setSpan(new C116709(), 0, string.length(), 33);
                this.lyU.setMovementMethod(LinkMovementMethod.getInstance());
                this.lyU.setText(spannableString2);
                break;
            case 1:
                string = getString(C25738R.string.bez);
                string2 = getString(C25738R.string.bfr);
                spannableString = new SpannableString(string + string2);
                spannableString.setSpan(new ForegroundColorSpan(C25738R.color.f12123t7), string.length(), string.length() + string2.length(), 33);
                spannableString.setSpan(new C116782(), string.length(), string.length() + string2.length(), 33);
                this.lyU.setMovementMethod(LinkMovementMethod.getInstance());
                this.lyU.setText(spannableString);
                break;
            case 2:
                string = getString(C25738R.string.bey);
                string2 = getString(C25738R.string.bev);
                spannableString = new SpannableString(string + string2);
                spannableString.setSpan(new ForegroundColorSpan(C25738R.color.f12123t7), string.length(), string.length() + string2.length(), 33);
                spannableString.setSpan(new C299310(), string.length(), string.length() + string2.length(), 33);
                this.lyU.setMovementMethod(LinkMovementMethod.getInstance());
                this.lyU.setText(spannableString);
                break;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                this.lyV.setImageResource(C1318a.bluetooth_logo);
                this.lyf.setText(C25738R.string.bf7);
                this.lyg.setText(C25738R.string.ber);
                break;
            case 4:
                this.lyV.setImageResource(C1318a.bluetooth_logo);
                this.lyf.setText(C25738R.string.bf5);
                this.lyg.setText("");
                break;
            case 5:
                this.lyV.setImageResource(C1318a.wifi_logo);
                this.lyf.setText(C25738R.string.bf7);
                this.lyg.setText(C25738R.string.bf2);
                break;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
                this.lyT.setVisibility(0);
                this.mListView.setVisibility(0);
                this.lyU.setVisibility(0);
                this.lyV.setVisibility(8);
                this.lyf.setVisibility(8);
                this.lyg.setVisibility(8);
                AppMethodBeat.m2505o(19866);
                return;
            case 3:
            case 4:
            case 5:
                this.hJh.setVisibility(8);
                this.lyT.setVisibility(8);
                this.mListView.setVisibility(8);
                this.lyU.setVisibility(8);
                this.lyV.setVisibility(0);
                this.lyf.setVisibility(0);
                if (i != 4) {
                    this.lyg.setVisibility(0);
                    break;
                }
                this.lyg.setVisibility(8);
                AppMethodBeat.m2505o(19866);
                return;
        }
        AppMethodBeat.m2505o(19866);
    }

    /* renamed from: a */
    static /* synthetic */ void m19477a(ExdeviceBindDeviceUI exdeviceBindDeviceUI, C11683f c11683f) {
        AppMethodBeat.m2504i(19867);
        Intent intent = new Intent(exdeviceBindDeviceUI, ExdeviceDeviceProfileUI.class);
        asr asr = c11683f.lzC;
        intent.putExtra("device_mac", asr.vKF);
        intent.putExtra("device_brand_name", asr.wwm);
        intent.putExtra("device_desc", asr.wwu);
        intent.putExtra("device_title", asr.wwt);
        intent.putExtra("device_icon_url", asr.IconUrl);
        intent.putExtra("device_alias", asr.guS);
        intent.putExtra("device_jump_url", asr.mZj);
        intent.putExtra("bind_ticket", c11683f.lyG);
        intent.putExtra("device_type", c11683f.lzB.vIk);
        intent.putExtra("device_id", c11683f.lzB.jBE);
        intent.putExtra("hide_device_panel", true);
        intent.putExtra("subscribe_flag", c11683f.lzD);
        if (c11683f.lzy == C11676b.CONNECT_PROTO_TYPE_BLUE) {
            intent.putExtra("device_ble_simple_proto", asr.dFq);
        } else if (c11683f.lzy != C11676b.CONNECT_PROTO_TYPE_WIFI) {
            Assert.assertTrue(false);
            AppMethodBeat.m2505o(19867);
            return;
        }
        exdeviceBindDeviceUI.startActivityForResult(intent, 0);
        AppMethodBeat.m2505o(19867);
    }

    /* renamed from: b */
    static /* synthetic */ void m19478b(ExdeviceBindDeviceUI exdeviceBindDeviceUI, C11683f c11683f) {
        AppMethodBeat.m2504i(19868);
        if (c11683f == null) {
            C4990ab.m7412e("MicroMsg.ExdeviceBindDeviceUI", "Device == null");
            AppMethodBeat.m2505o(19868);
        } else if (c11683f.lzE == null) {
            C4990ab.m7412e("MicroMsg.ExdeviceBindDeviceUI", "Device.contact == null");
            AppMethodBeat.m2505o(19868);
        } else {
            bbv bbv = c11683f.lzE;
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(C1946aa.m4148a(bbv.wcB));
            Intent intent = new Intent();
            intent.putExtra("device_id", c11683f.lzB.jBE);
            intent.putExtra("device_type", c11683f.lzB.vIk);
            intent.putExtra("Contact_User", C1946aa.m4148a(bbv.wcB));
            intent.putExtra("Contact_Scene", bbv.wbF);
            intent.putExtra("KIsHardDevice", true);
            intent.putExtra("KHardDeviceBindTicket", c11683f.lyG);
            if (aoO != null) {
                if (!C7486a.m12942jh(aoO.field_type)) {
                    intent.putExtra("Contact_Alias", bbv.guS);
                    intent.putExtra("Contact_Nick", bbv.wyX.toString());
                    intent.putExtra("Contact_Signature", bbv.guQ);
                    intent.putExtra("Contact_RegionCode", RegionCodeDecoder.m7796aC(bbv.guW, bbv.guO, bbv.guP));
                    intent.putExtra("Contact_Sex", bbv.guN);
                    intent.putExtra("Contact_VUser_Info", bbv.wBU);
                    intent.putExtra("Contact_VUser_Info_Flag", bbv.wBT);
                    intent.putExtra("Contact_KWeibo_flag", bbv.wBX);
                    intent.putExtra("Contact_KWeibo", bbv.wBV);
                    intent.putExtra("Contact_KWeiboNick", bbv.wBW);
                    if (bbv.wCa != null) {
                        try {
                            intent.putExtra("Contact_customInfo", bbv.wCa.toByteArray());
                        } catch (IOException e) {
                            C4990ab.printErrStackTrace("MicroMsg.ExdeviceBindDeviceUI", e, "", new Object[0]);
                        }
                    }
                }
                C25985d.m41467b(exdeviceBindDeviceUI.mController.ylL, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            }
            AppMethodBeat.m2505o(19868);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m19476a(ExdeviceBindDeviceUI exdeviceBindDeviceUI, int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(19869);
        C11683f KC;
        if (c1207m instanceof C20536p) {
            if (exdeviceBindDeviceUI.ehJ != null && exdeviceBindDeviceUI.ehJ.isShowing()) {
                exdeviceBindDeviceUI.ehJ.dismiss();
            }
            exdeviceBindDeviceUI.lza = false;
            C20536p c20536p = (C20536p) c1207m;
            if (!(i == 0 && i2 == 0)) {
                C4990ab.m7413e("MicroMsg.ExdeviceBindDeviceUI", "NetSceneGetHardDeviceHelpUrl onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", Integer.valueOf(i), Integer.valueOf(i2), str);
            }
            exdeviceBindDeviceUI.lyZ = ((ajl) c20536p.ehh.fsH.fsP).wpj;
            String str2 = exdeviceBindDeviceUI.lyZ;
            if (C5046bo.isNullOrNil(str2)) {
                C4990ab.m7416i("MicroMsg.ExdeviceBindDeviceUI", "Jump to webview failed, url is null or nil.");
                AppMethodBeat.m2505o(19869);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            C25985d.m41467b((Context) exdeviceBindDeviceUI, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(19869);
        } else if (c1207m instanceof C42998t) {
            buq boS = ((C42998t) c1207m).boS();
            if (i != 0 || i2 != 0) {
                C4990ab.m7413e("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", Integer.valueOf(i), Integer.valueOf(i2), str);
                AppMethodBeat.m2505o(19869);
            } else if (boS.vLj == null) {
                C4990ab.m7412e("MicroMsg.ExdeviceBindDeviceUI", "HardDeviceAttr is null");
                AppMethodBeat.m2505o(19869);
            } else {
                KC = exdeviceBindDeviceUI.lyS.mo23428KC(boS.vLj.vKF);
                if (KC == null) {
                    C4990ab.m7412e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice is null");
                    AppMethodBeat.m2505o(19869);
                } else if (KC.lzB != null) {
                    C4990ab.m7412e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice.mHardDevice is not null");
                    AppMethodBeat.m2505o(19869);
                } else {
                    KC.lzC = boS.vLj;
                    KC.lzB = boS.vLi;
                    KC.lyG = boS.vKK;
                    KC.lzE = boS.vKL;
                    exdeviceBindDeviceUI.lyS.mo23429b(KC);
                    exdeviceBindDeviceUI.lyS.notifyDataSetChanged();
                    C4990ab.m7417i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice onSceneEnd, deviceType(%s) deviceId(%s), title(%s), mac(%s), isEnterMainDevice(%d).", boS.vLi.vIk, boS.vLi.jBE, boS.vLj.wwt, boS.vLj.vKF, Integer.valueOf(boS.vLj.dFp));
                    AppMethodBeat.m2505o(19869);
                }
            }
        } else {
            if (c1207m instanceof C20538v) {
                if (i == 0 && i2 == 0) {
                    bvu bvu = (bvu) ((C20538v) c1207m).ehh.fsH.fsP;
                    if (bvu.vLi == null) {
                        C4990ab.m7412e("MicroMsg.ExdeviceBindDeviceUI", "HardDevice info is null");
                        AppMethodBeat.m2505o(19869);
                        return;
                    }
                    C11671a c11671a = exdeviceBindDeviceUI.lyS;
                    String str3 = bvu.vLi.vIk;
                    String str4 = bvu.vLi.jBE;
                    if (str3 == null || str3.length() == 0 || str4 == null || str4.length() == 0) {
                        KC = null;
                    } else {
                        int dV = c11671a.mo23432dV(str3, str4);
                        if (dV < 0) {
                            KC = null;
                        } else {
                            KC = (C11683f) c11671a.lzl.get(dV);
                        }
                    }
                    if (KC == null) {
                        C4990ab.m7412e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice is null");
                        AppMethodBeat.m2505o(19869);
                        return;
                    } else if (KC.lzB != null) {
                        C4990ab.m7412e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice.mHardDevice is not null");
                        AppMethodBeat.m2505o(19869);
                        return;
                    } else {
                        KC.lzC = bvu.vLj;
                        KC.lzB = bvu.vLi;
                        KC.lyG = bvu.vKK;
                        KC.lzE = bvu.vKL;
                        exdeviceBindDeviceUI.lyS.mo23429b(KC);
                        exdeviceBindDeviceUI.lyS.notifyDataSetChanged();
                        C4990ab.m7417i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice onSceneEnd, deviceType(%s) deviceId(%s), title(%s), isEnterMainDevice(%d).", bvu.vLi.vIk, bvu.vLi.jBE, bvu.vLj.wwt, Integer.valueOf(bvu.vLj.dFp));
                    }
                } else {
                    C4990ab.m7413e("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", Integer.valueOf(i), Integer.valueOf(i2), str);
                    AppMethodBeat.m2505o(19869);
                    return;
                }
            }
            AppMethodBeat.m2505o(19869);
        }
    }
}
