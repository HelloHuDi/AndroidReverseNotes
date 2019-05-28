package com.tencent.p177mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.p069v7.app.AppCompatActivity;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p230g.p232b.p233a.C26275be;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.appbrand.C42700v;
import com.tencent.p177mm.plugin.appbrand.config.WxaExposedParams.C19154a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p897a.C42462a;
import com.tencent.p177mm.plugin.appbrand.phonenumber.C45670j.C45669a;
import com.tencent.p177mm.plugin.appbrand.phonenumber.PhoneNumberAddUI.C42657a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p637c.C5681a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C8001y;
import p000a.p051k.C31820v;
import p1439b.p1440a.p1441a.p1442a.p1443a.p1444a.p1445a.p1446a.C31900a;

@C5271a(3)
@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\"H\u0014J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020$H\u0002J\u0012\u0010&\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020$H\u0014J\b\u0010*\u001a\u00020$H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManagerUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "addPhoneLineV", "Landroid/view/View;", "addPhoneTv", "Landroid/widget/TextView;", "appId", "", "authDesc", "exposeTv", "itemAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;", "listRv", "Landroid/support/v7/widget/RecyclerView;", "pagePath", "getPagePath", "()Ljava/lang/String;", "setPagePath", "(Ljava/lang/String;)V", "phoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "report", "Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;", "getReport", "()Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;", "setReport", "(Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;)V", "showDelete", "", "tipsTv", "getLayoutId", "", "initExpose", "", "initListView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "updateListView", "Companion", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberManagerUI */
public final class PhoneNumberManagerUI extends MMActivity {
    public static final C10691a iyG = new C10691a();
    private String appId = "";
    private String csu;
    C26275be ixV;
    private boolean ixx;
    private final ArrayList<PhoneItem> ixy = new ArrayList();
    private String iyA;
    private TextView iyB;
    private View iyC;
    private TextView iyD;
    private TextView iyE;
    private C19670h iyF;
    private RecyclerView iyp;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J&\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManagerUI$Companion;", "", "()V", "APPID", "", "AUTH_DESC", "MAX_COUNT", "", "PAGE_PATH", "SHOWDELETE", "TAG", "editPhoneNumber", "", "context", "Landroid/content/Context;", "appId", "managePhoneNumber", "pagePath", "authDesc", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberManagerUI$a */
    public static final class C10691a {
        private C10691a() {
        }

        public /* synthetic */ C10691a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberManagerUI$b */
    static final class C10692b implements OnClickListener {
        final /* synthetic */ PhoneNumberManagerUI iyH;

        C10692b(PhoneNumberManagerUI phoneNumberManagerUI) {
            this.iyH = phoneNumberManagerUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(134859);
            C26275be c26275be = this.iyH.ixV;
            if (c26275be != null) {
                C26275be c26275be2 = this.iyH.ixV;
                Long valueOf = c26275be2 != null ? Long.valueOf(c26275be2.mo43983GO()) : null;
                if (valueOf == null) {
                    C25052j.dWJ();
                }
                c26275be.mo44012de(valueOf.longValue() + 1);
            }
            C42657a c42657a = PhoneNumberAddUI.ixW;
            AppCompatActivity dxU = this.iyH.dxU();
            C25052j.m39375o(dxU, "context");
            C42657a.m75529X(dxU, this.iyH.appId);
            AppMethodBeat.m2505o(134859);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberManagerUI$c */
    static final class C10693c implements OnMenuItemClickListener {
        final /* synthetic */ PhoneNumberManagerUI iyH;

        C10693c(PhoneNumberManagerUI phoneNumberManagerUI) {
            this.iyH = phoneNumberManagerUI;
        }

        /* JADX WARNING: Removed duplicated region for block: B:6:0x0021  */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x002a  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00b1  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0099  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x009d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onMenuItemClick(MenuItem menuItem) {
            ArrayList arrayList;
            Integer valueOf;
            C45669a c45669a;
            AppMethodBeat.m2504i(134861);
            C19670h b = this.iyH.iyF;
            if (b != null) {
                arrayList = b.ixw;
                if (arrayList != null) {
                    valueOf = Integer.valueOf(arrayList.size());
                    if (valueOf == null) {
                        C25052j.dWJ();
                    }
                    if (valueOf.intValue() >= 0) {
                        b = this.iyH.iyF;
                        if (b != null) {
                            arrayList = b.ixw;
                        } else {
                            arrayList = null;
                        }
                        if (arrayList == null) {
                            C25052j.dWJ();
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            final PhoneItem phoneItem = (PhoneItem) it.next();
                            C26275be c26275be = this.iyH.ixV;
                            if (c26275be != null) {
                                Long valueOf2;
                                C26275be c26275be2 = this.iyH.ixV;
                                if (c26275be2 != null) {
                                    valueOf2 = Long.valueOf(c26275be2.mo43984GP());
                                } else {
                                    valueOf2 = null;
                                }
                                if (valueOf2 == null) {
                                    C25052j.dWJ();
                                }
                                c26275be.mo44013df(valueOf2.longValue() + 1);
                            }
                            new C10698f(this.iyH.appId, phoneItem.cFl, 1).acy().mo60492h(new C5681a<_Ret, _Var>(this) {
                                final /* synthetic */ C10693c iyI;

                                public final /* synthetic */ Object call(Object obj) {
                                    Long l = null;
                                    AppMethodBeat.m2504i(134860);
                                    C37441a c37441a = (C37441a) obj;
                                    C4990ab.m7417i("MicroMsg.PhoneNumberAddUI", "update %s errType = %d, errCode = %d, errMsg = %s", phoneItem.cFl, Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode), c37441a.aIm);
                                    C26275be c26275be;
                                    C26275be c26275be2;
                                    if (c37441a.errType == 0 && c37441a.errCode == 0) {
                                        c26275be = this.iyI.iyH.ixV;
                                        if (c26275be != null) {
                                            c26275be2 = this.iyI.iyH.ixV;
                                            if (c26275be2 != null) {
                                                l = Long.valueOf(c26275be2.mo43985GQ());
                                            }
                                            if (l == null) {
                                                C25052j.dWJ();
                                            }
                                            c26275be.mo44014dg(l.longValue() + 1);
                                        }
                                    } else {
                                        c26275be = this.iyI.iyH.ixV;
                                        if (c26275be != null) {
                                            c26275be2 = this.iyI.iyH.ixV;
                                            if (c26275be2 != null) {
                                                l = Long.valueOf(c26275be2.mo43986GR());
                                            }
                                            if (l == null) {
                                                C25052j.dWJ();
                                            }
                                            c26275be.mo44015dh(l.longValue() + 1);
                                        }
                                    }
                                    C37091y c37091y = C37091y.AUy;
                                    AppMethodBeat.m2505o(134860);
                                    return c37091y;
                                }
                            });
                        }
                    }
                    c45669a = C45670j.ixQ;
                    b = this.iyH.iyF;
                    if (b == null) {
                        arrayList = b.ixw;
                    } else {
                        arrayList = null;
                    }
                    if (arrayList == null) {
                        C25052j.dWJ();
                    }
                    c45669a.mo73463o(arrayList);
                    this.iyH.finish();
                    this.iyH.overridePendingTransition(C25738R.anim.f8293s, C25738R.anim.f8293s);
                    AppMethodBeat.m2505o(134861);
                    return true;
                }
            }
            valueOf = null;
            if (valueOf == null) {
            }
            if (valueOf.intValue() >= 0) {
            }
            c45669a = C45670j.ixQ;
            b = this.iyH.iyF;
            if (b == null) {
            }
            if (arrayList == null) {
            }
            c45669a.mo73463o(arrayList);
            this.iyH.finish();
            this.iyH.overridePendingTransition(C25738R.anim.f8293s, C25738R.anim.f8293s);
            AppMethodBeat.m2505o(134861);
            return true;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberManagerUI$f */
    static final class C10695f implements OnMenuItemClickListener {
        final /* synthetic */ PhoneNumberManagerUI iyH;

        C10695f(PhoneNumberManagerUI phoneNumberManagerUI) {
            this.iyH = phoneNumberManagerUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(134864);
            this.iyH.finish();
            AppMethodBeat.m2505o(134864);
            return true;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberManagerUI$d */
    static final class C10696d implements OnMenuItemClickListener {
        final /* synthetic */ PhoneNumberManagerUI iyH;

        C10696d(PhoneNumberManagerUI phoneNumberManagerUI) {
            this.iyH = phoneNumberManagerUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(134862);
            this.iyH.finish();
            this.iyH.overridePendingTransition(C25738R.anim.f8293s, C25738R.anim.f8293s);
            AppMethodBeat.m2505o(134862);
            return true;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberManagerUI$e */
    static final class C10697e implements OnMenuItemClickListener {
        final /* synthetic */ PhoneNumberManagerUI iyH;

        C10697e(PhoneNumberManagerUI phoneNumberManagerUI) {
            this.iyH = phoneNumberManagerUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(134863);
            C10691a c10691a = PhoneNumberManagerUI.iyG;
            AppCompatActivity dxU = this.iyH.dxU();
            C25052j.m39375o(dxU, "context");
            Context context = dxU;
            String a = this.iyH.appId;
            C25052j.m39376p(context, "context");
            C25052j.m39376p(a, "appId");
            Intent intent = new Intent(context, PhoneNumberManagerUI.class);
            intent.putExtra("APPID", a);
            intent.putExtra("SHOW_DELETE", true);
            context.startActivity(intent);
            AppMethodBeat.m2505o(134863);
            return true;
        }
    }

    static {
        AppMethodBeat.m2504i(134868);
        AppMethodBeat.m2505o(134868);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public PhoneNumberManagerUI() {
        AppMethodBeat.m2504i(134867);
        AppMethodBeat.m2505o(134867);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(134865);
        super.onCreate(bundle);
        mo17446xE(-1);
        getContentView().setBackgroundColor(dyd());
        String stringExtra = getIntent().getStringExtra("APPID");
        C25052j.m39375o(stringExtra, "intent.getStringExtra(APPID)");
        this.appId = stringExtra;
        this.iyA = getIntent().getStringExtra("AUTHDESC");
        this.csu = getIntent().getStringExtra("PAGEPATH");
        this.ixx = getIntent().getBooleanExtra("SHOW_DELETE", false);
        C4990ab.m7417i("MicroMsg.PhoneNumberManagerUI", "onCreate() appId:%s showDelete:%b", this.appId, Boolean.valueOf(this.ixx));
        this.ixV = C31900a.BTg.awB(this.appId);
        if (this.ixx) {
            overridePendingTransition(C25738R.anim.f8293s, C25738R.anim.f8293s);
        }
        this.iyp = (RecyclerView) findViewById(2131821272);
        RecyclerView recyclerView = this.iyp;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager());
        }
        AppCompatActivity dxU = dxU();
        C25052j.m39375o(dxU, "context");
        this.iyF = new C19670h(dxU, this.ixy);
        C19670h c19670h = this.iyF;
        if (c19670h != null) {
            c19670h.ixx = this.ixx;
        }
        recyclerView = this.iyp;
        if (recyclerView != null) {
            recyclerView.setAdapter(this.iyF);
        }
        String string = getString(C25738R.string.f9298vx);
        C8001y c8001y = C8001y.AVH;
        stringExtra = getString(C25738R.string.f9299vy);
        C25052j.m39375o(stringExtra, "getString(R.string.appbr…mber_expose_slogan_start)");
        String format = String.format(stringExtra, Arrays.copyOf(new Object[]{string}, 1));
        C25052j.m39375o(format, "java.lang.String.format(format, *args)");
        this.iyD = (TextView) findViewById(2131821276);
        C19154a c19154a = new C19154a();
        C19154a zC = c19154a.mo34388zC(this.appId);
        stringExtra = this.csu;
        if (stringExtra == null) {
            stringExtra = "";
        }
        zC.mo34392zG(stringExtra).mo34387nF(8);
        C42462a c42462a = new C42462a(C42700v.m75632b(c19154a.ayP()));
        SpannableString spannableString = new SpannableString(format);
        CharSequence charSequence = format;
        C25052j.m39375o(string, "expose_desc_end");
        spannableString.setSpan(c42462a, C31820v.m51518a(charSequence, string, 0, false, 6), C31820v.m51518a((CharSequence) format, string, 0, false, 6) + string.length(), 18);
        TextView textView = this.iyD;
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        TextView textView2 = this.iyD;
        if (textView2 != null) {
            textView2.setText(spannableString);
        }
        this.iyB = (TextView) findViewById(2131821273);
        textView2 = this.iyB;
        if (textView2 != null) {
            textView2.setOnClickListener(new C10692b(this));
        }
        this.iyC = findViewById(2131821274);
        this.iyE = (TextView) findViewById(2131821275);
        textView = this.iyE;
        if (textView != null) {
            textView.setVisibility(4);
            AppMethodBeat.m2505o(134865);
            return;
        }
        AppMethodBeat.m2505o(134865);
    }

    public final int getLayoutId() {
        return 2130968704;
    }

    public final void onResume() {
        TextView textView;
        AppMethodBeat.m2504i(134866);
        super.onResume();
        setMMTitle((int) C25738R.string.f9308w7);
        dyb();
        this.ixy.clear();
        this.ixy.addAll(C45670j.ixQ.aKN());
        C19670h c19670h = this.iyF;
        if (c19670h != null) {
            List list = this.ixy;
            C25052j.m39376p(list, "phoneItems");
            c19670h.ixy = (ArrayList) list;
            c19670h.notifyDataSetChanged();
        }
        View view;
        if (this.ixx || this.ixy.size() >= 3) {
            textView = this.iyB;
            if (textView != null) {
                textView.setVisibility(8);
            }
            view = this.iyC;
            if (view != null) {
                view.setVisibility(8);
            }
        } else {
            textView = this.iyB;
            if (textView != null) {
                textView.setVisibility(0);
            }
            view = this.iyC;
            if (view != null) {
                view.setVisibility(0);
            }
        }
        if (this.ixx) {
            textView = this.iyE;
            if (textView != null) {
                textView.setVisibility(8);
            }
        } else if (this.ixy.size() >= 3) {
            textView = this.iyE;
            if (textView != null) {
                textView.setVisibility(0);
            }
        } else {
            textView = this.iyE;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
        if (this.ixx) {
            mo17379a(0, getString(C25738R.string.f9300vz), (OnMenuItemClickListener) new C10693c(this), C5535b.BLACK);
            setBackBtn(new C10696d(this), C1318a.actionbar_icon_dark_close);
            AppMethodBeat.m2505o(134866);
            return;
        }
        mo17379a(0, getString(C25738R.string.f9307w6), (OnMenuItemClickListener) new C10697e(this), C5535b.BLACK);
        setBackBtn(new C10695f(this));
        AppMethodBeat.m2505o(134866);
    }
}
