package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f.b.j;
import a.l;
import a.y;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.be;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@l(dWo = {1, 1, 13}, dWp = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\"H\u0014J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020$H\u0002J\u0012\u0010&\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020$H\u0014J\b\u0010*\u001a\u00020$H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManagerUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "addPhoneLineV", "Landroid/view/View;", "addPhoneTv", "Landroid/widget/TextView;", "appId", "", "authDesc", "exposeTv", "itemAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;", "listRv", "Landroid/support/v7/widget/RecyclerView;", "pagePath", "getPagePath", "()Ljava/lang/String;", "setPagePath", "(Ljava/lang/String;)V", "phoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "report", "Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;", "getReport", "()Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;", "setReport", "(Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;)V", "showDelete", "", "tipsTv", "getLayoutId", "", "initExpose", "", "initListView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "updateListView", "Companion", "plugin-appbrand-integration_release"})
public final class PhoneNumberManagerUI extends MMActivity {
    public static final a iyG = new a();
    private String appId = "";
    private String csu;
    be ixV;
    private boolean ixx;
    private final ArrayList<PhoneItem> ixy = new ArrayList();
    private String iyA;
    private TextView iyB;
    private View iyC;
    private TextView iyD;
    private TextView iyE;
    private h iyF;
    private RecyclerView iyp;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J&\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManagerUI$Companion;", "", "()V", "APPID", "", "AUTH_DESC", "MAX_COUNT", "", "PAGE_PATH", "SHOWDELETE", "TAG", "editPhoneNumber", "", "context", "Landroid/content/Context;", "appId", "managePhoneNumber", "pagePath", "authDesc", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements OnClickListener {
        final /* synthetic */ PhoneNumberManagerUI iyH;

        b(PhoneNumberManagerUI phoneNumberManagerUI) {
            this.iyH = phoneNumberManagerUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(134859);
            be beVar = this.iyH.ixV;
            if (beVar != null) {
                be beVar2 = this.iyH.ixV;
                Long valueOf = beVar2 != null ? Long.valueOf(beVar2.GO()) : null;
                if (valueOf == null) {
                    j.dWJ();
                }
                beVar.de(valueOf.longValue() + 1);
            }
            com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI.a aVar = PhoneNumberAddUI.ixW;
            AppCompatActivity dxU = this.iyH.dxU();
            j.o(dxU, "context");
            com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI.a.X(dxU, this.iyH.appId);
            AppMethodBeat.o(134859);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class c implements OnMenuItemClickListener {
        final /* synthetic */ PhoneNumberManagerUI iyH;

        c(PhoneNumberManagerUI phoneNumberManagerUI) {
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
            com.tencent.mm.plugin.appbrand.phonenumber.j.a aVar;
            AppMethodBeat.i(134861);
            h b = this.iyH.iyF;
            if (b != null) {
                arrayList = b.ixw;
                if (arrayList != null) {
                    valueOf = Integer.valueOf(arrayList.size());
                    if (valueOf == null) {
                        j.dWJ();
                    }
                    if (valueOf.intValue() >= 0) {
                        b = this.iyH.iyF;
                        if (b != null) {
                            arrayList = b.ixw;
                        } else {
                            arrayList = null;
                        }
                        if (arrayList == null) {
                            j.dWJ();
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            final PhoneItem phoneItem = (PhoneItem) it.next();
                            be beVar = this.iyH.ixV;
                            if (beVar != null) {
                                Long valueOf2;
                                be beVar2 = this.iyH.ixV;
                                if (beVar2 != null) {
                                    valueOf2 = Long.valueOf(beVar2.GP());
                                } else {
                                    valueOf2 = null;
                                }
                                if (valueOf2 == null) {
                                    j.dWJ();
                                }
                                beVar.df(valueOf2.longValue() + 1);
                            }
                            new f(this.iyH.appId, phoneItem.cFl, 1).acy().h(new com.tencent.mm.vending.c.a<_Ret, _Var>(this) {
                                final /* synthetic */ c iyI;

                                public final /* synthetic */ Object call(Object obj) {
                                    Long l = null;
                                    AppMethodBeat.i(134860);
                                    com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                                    ab.i("MicroMsg.PhoneNumberAddUI", "update %s errType = %d, errCode = %d, errMsg = %s", phoneItem.cFl, Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.aIm);
                                    be beVar;
                                    be beVar2;
                                    if (aVar.errType == 0 && aVar.errCode == 0) {
                                        beVar = this.iyI.iyH.ixV;
                                        if (beVar != null) {
                                            beVar2 = this.iyI.iyH.ixV;
                                            if (beVar2 != null) {
                                                l = Long.valueOf(beVar2.GQ());
                                            }
                                            if (l == null) {
                                                j.dWJ();
                                            }
                                            beVar.dg(l.longValue() + 1);
                                        }
                                    } else {
                                        beVar = this.iyI.iyH.ixV;
                                        if (beVar != null) {
                                            beVar2 = this.iyI.iyH.ixV;
                                            if (beVar2 != null) {
                                                l = Long.valueOf(beVar2.GR());
                                            }
                                            if (l == null) {
                                                j.dWJ();
                                            }
                                            beVar.dh(l.longValue() + 1);
                                        }
                                    }
                                    y yVar = y.AUy;
                                    AppMethodBeat.o(134860);
                                    return yVar;
                                }
                            });
                        }
                    }
                    aVar = j.ixQ;
                    b = this.iyH.iyF;
                    if (b == null) {
                        arrayList = b.ixw;
                    } else {
                        arrayList = null;
                    }
                    if (arrayList == null) {
                        j.dWJ();
                    }
                    aVar.o(arrayList);
                    this.iyH.finish();
                    this.iyH.overridePendingTransition(R.anim.s, R.anim.s);
                    AppMethodBeat.o(134861);
                    return true;
                }
            }
            valueOf = null;
            if (valueOf == null) {
            }
            if (valueOf.intValue() >= 0) {
            }
            aVar = j.ixQ;
            b = this.iyH.iyF;
            if (b == null) {
            }
            if (arrayList == null) {
            }
            aVar.o(arrayList);
            this.iyH.finish();
            this.iyH.overridePendingTransition(R.anim.s, R.anim.s);
            AppMethodBeat.o(134861);
            return true;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class f implements OnMenuItemClickListener {
        final /* synthetic */ PhoneNumberManagerUI iyH;

        f(PhoneNumberManagerUI phoneNumberManagerUI) {
            this.iyH = phoneNumberManagerUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(134864);
            this.iyH.finish();
            AppMethodBeat.o(134864);
            return true;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class d implements OnMenuItemClickListener {
        final /* synthetic */ PhoneNumberManagerUI iyH;

        d(PhoneNumberManagerUI phoneNumberManagerUI) {
            this.iyH = phoneNumberManagerUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(134862);
            this.iyH.finish();
            this.iyH.overridePendingTransition(R.anim.s, R.anim.s);
            AppMethodBeat.o(134862);
            return true;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class e implements OnMenuItemClickListener {
        final /* synthetic */ PhoneNumberManagerUI iyH;

        e(PhoneNumberManagerUI phoneNumberManagerUI) {
            this.iyH = phoneNumberManagerUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(134863);
            a aVar = PhoneNumberManagerUI.iyG;
            AppCompatActivity dxU = this.iyH.dxU();
            j.o(dxU, "context");
            Context context = dxU;
            String a = this.iyH.appId;
            j.p(context, "context");
            j.p(a, "appId");
            Intent intent = new Intent(context, PhoneNumberManagerUI.class);
            intent.putExtra("APPID", a);
            intent.putExtra("SHOW_DELETE", true);
            context.startActivity(intent);
            AppMethodBeat.o(134863);
            return true;
        }
    }

    static {
        AppMethodBeat.i(134868);
        AppMethodBeat.o(134868);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public PhoneNumberManagerUI() {
        AppMethodBeat.i(134867);
        AppMethodBeat.o(134867);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(134865);
        super.onCreate(bundle);
        xE(-1);
        getContentView().setBackgroundColor(dyd());
        String stringExtra = getIntent().getStringExtra("APPID");
        j.o(stringExtra, "intent.getStringExtra(APPID)");
        this.appId = stringExtra;
        this.iyA = getIntent().getStringExtra("AUTHDESC");
        this.csu = getIntent().getStringExtra("PAGEPATH");
        this.ixx = getIntent().getBooleanExtra("SHOW_DELETE", false);
        ab.i("MicroMsg.PhoneNumberManagerUI", "onCreate() appId:%s showDelete:%b", this.appId, Boolean.valueOf(this.ixx));
        this.ixV = b.a.a.a.a.a.a.a.a.BTg.awB(this.appId);
        if (this.ixx) {
            overridePendingTransition(R.anim.s, R.anim.s);
        }
        this.iyp = (RecyclerView) findViewById(R.id.sz);
        RecyclerView recyclerView = this.iyp;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager());
        }
        AppCompatActivity dxU = dxU();
        j.o(dxU, "context");
        this.iyF = new h(dxU, this.ixy);
        h hVar = this.iyF;
        if (hVar != null) {
            hVar.ixx = this.ixx;
        }
        recyclerView = this.iyp;
        if (recyclerView != null) {
            recyclerView.setAdapter(this.iyF);
        }
        String string = getString(R.string.vx);
        a.f.b.y yVar = a.f.b.y.AVH;
        stringExtra = getString(R.string.vy);
        j.o(stringExtra, "getString(R.string.appbr…mber_expose_slogan_start)");
        String format = String.format(stringExtra, Arrays.copyOf(new Object[]{string}, 1));
        j.o(format, "java.lang.String.format(format, *args)");
        this.iyD = (TextView) findViewById(R.id.t3);
        com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a aVar = new com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a();
        com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a zC = aVar.zC(this.appId);
        stringExtra = this.csu;
        if (stringExtra == null) {
            stringExtra = "";
        }
        zC.zG(stringExtra).nF(8);
        com.tencent.mm.plugin.appbrand.jsapi.a.a aVar2 = new com.tencent.mm.plugin.appbrand.jsapi.a.a(v.b(aVar.ayP()));
        SpannableString spannableString = new SpannableString(format);
        CharSequence charSequence = format;
        j.o(string, "expose_desc_end");
        spannableString.setSpan(aVar2, a.k.v.a(charSequence, string, 0, false, 6), a.k.v.a((CharSequence) format, string, 0, false, 6) + string.length(), 18);
        TextView textView = this.iyD;
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        TextView textView2 = this.iyD;
        if (textView2 != null) {
            textView2.setText(spannableString);
        }
        this.iyB = (TextView) findViewById(R.id.t0);
        textView2 = this.iyB;
        if (textView2 != null) {
            textView2.setOnClickListener(new b(this));
        }
        this.iyC = findViewById(R.id.t1);
        this.iyE = (TextView) findViewById(R.id.t2);
        textView = this.iyE;
        if (textView != null) {
            textView.setVisibility(4);
            AppMethodBeat.o(134865);
            return;
        }
        AppMethodBeat.o(134865);
    }

    public final int getLayoutId() {
        return R.layout.cr;
    }

    public final void onResume() {
        TextView textView;
        AppMethodBeat.i(134866);
        super.onResume();
        setMMTitle((int) R.string.w7);
        dyb();
        this.ixy.clear();
        this.ixy.addAll(j.ixQ.aKN());
        h hVar = this.iyF;
        if (hVar != null) {
            List list = this.ixy;
            j.p(list, "phoneItems");
            hVar.ixy = (ArrayList) list;
            hVar.notifyDataSetChanged();
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
            a(0, getString(R.string.vz), (OnMenuItemClickListener) new c(this), com.tencent.mm.ui.q.b.BLACK);
            setBackBtn(new d(this), R.raw.actionbar_icon_dark_close);
            AppMethodBeat.o(134866);
            return;
        }
        a(0, getString(R.string.w6), (OnMenuItemClickListener) new e(this), com.tencent.mm.ui.q.b.BLACK);
        setBackBtn(new f(this));
        AppMethodBeat.o(134866);
    }
}
